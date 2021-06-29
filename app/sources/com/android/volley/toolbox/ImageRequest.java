package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.GuardedBy;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.widget.ImageView;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;

public class ImageRequest extends Request<Bitmap> {
    public static final float DEFAULT_IMAGE_BACKOFF_MULT = 2.0f;
    public static final int DEFAULT_IMAGE_MAX_RETRIES = 2;
    public static final int DEFAULT_IMAGE_TIMEOUT_MS = 1000;
    private static final Object sDecodeLock = new Object();
    private final Bitmap.Config mDecodeConfig;
    @Nullable
    @GuardedBy("mLock")
    private Response.Listener<Bitmap> mListener;
    private final Object mLock;
    private final int mMaxHeight;
    private final int mMaxWidth;
    private final ImageView.ScaleType mScaleType;

    @Deprecated
    public ImageRequest(String str, Response.Listener<Bitmap> listener, int i, int i2, Bitmap.Config config, Response.ErrorListener errorListener) {
        this(str, listener, i, i2, ImageView.ScaleType.CENTER_INSIDE, config, errorListener);
    }

    public ImageRequest(String str, Response.Listener<Bitmap> listener, int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, @Nullable Response.ErrorListener errorListener) {
        super(0, str, errorListener);
        this.mLock = new Object();
        setRetryPolicy(new DefaultRetryPolicy(1000, 2, 2.0f));
        this.mListener = listener;
        this.mDecodeConfig = config;
        this.mMaxWidth = i;
        this.mMaxHeight = i2;
        this.mScaleType = scaleType;
    }

    private Response<Bitmap> doParse(NetworkResponse networkResponse) {
        Bitmap bitmap;
        byte[] bArr = networkResponse.data;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.mMaxWidth == 0 && this.mMaxHeight == 0) {
            options.inPreferredConfig = this.mDecodeConfig;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int resizedDimension = getResizedDimension(this.mMaxWidth, this.mMaxHeight, i, i2, this.mScaleType);
            int resizedDimension2 = getResizedDimension(this.mMaxHeight, this.mMaxWidth, i2, i, this.mScaleType);
            options.inJustDecodeBounds = false;
            options.inSampleSize = findBestSampleSize(i, i2, resizedDimension, resizedDimension2);
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmap != null && (bitmap.getWidth() > resizedDimension || bitmap.getHeight() > resizedDimension2)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, resizedDimension, resizedDimension2, true);
                bitmap.recycle();
                bitmap = createScaledBitmap;
            }
        }
        return bitmap == null ? Response.error(new ParseError(networkResponse)) : Response.success(bitmap, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    @VisibleForTesting
    static int findBestSampleSize(int i, int i2, int i3, int i4) {
        double d = (double) i;
        double d2 = (double) i3;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = (double) i2;
        double d4 = (double) i4;
        Double.isNaN(d3);
        Double.isNaN(d4);
        double min = Math.min(d / d2, d3 / d4);
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (((double) f2) > min) {
                return (int) f;
            }
            f = f2;
        }
    }

    private static int getResizedDimension(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            double d = (double) i2;
            double d2 = (double) i4;
            Double.isNaN(d);
            Double.isNaN(d2);
            double d3 = (double) i3;
            Double.isNaN(d3);
            return (int) (d3 * (d / d2));
        } else if (i2 == 0) {
            return i;
        } else {
            double d4 = (double) i4;
            double d5 = (double) i3;
            Double.isNaN(d4);
            Double.isNaN(d5);
            double d6 = d4 / d5;
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                double d7 = (double) i;
                Double.isNaN(d7);
                double d8 = (double) i2;
                if (d7 * d6 >= d8) {
                    return i;
                }
                Double.isNaN(d8);
                return (int) (d8 / d6);
            }
            double d9 = (double) i;
            Double.isNaN(d9);
            double d10 = (double) i2;
            if (d9 * d6 <= d10) {
                return i;
            }
            Double.isNaN(d10);
            return (int) (d10 / d6);
        }
    }

    public void cancel() {
        super.cancel();
        synchronized (this.mLock) {
            this.mListener = null;
        }
    }

    /* access modifiers changed from: protected */
    public void deliverResponse(Bitmap bitmap) {
        Response.Listener<Bitmap> listener;
        synchronized (this.mLock) {
            listener = this.mListener;
        }
        if (listener != null) {
            listener.onResponse(bitmap);
        }
    }

    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    /* access modifiers changed from: protected */
    public Response<Bitmap> parseNetworkResponse(NetworkResponse networkResponse) {
        Response<Bitmap> doParse;
        synchronized (sDecodeLock) {
            try {
                doParse = doParse(networkResponse);
            } catch (OutOfMemoryError e) {
                VolleyLog.m885e("Caught OOM for %d byte image, url=%s", Integer.valueOf(networkResponse.data.length), getUrl());
                return Response.error(new ParseError((Throwable) e));
            } catch (Throwable th) {
                throw th;
            }
        }
        return doParse;
    }
}
