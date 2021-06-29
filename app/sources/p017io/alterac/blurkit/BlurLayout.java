package p017io.alterac.blurkit;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* renamed from: io.alterac.blurkit.BlurLayout */
public class BlurLayout extends FrameLayout {
    public static final int DEFAULT_BLUR_RADIUS = 12;
    public static final float DEFAULT_CORNER_RADIUS = 0.0f;
    public static final float DEFAULT_DOWNSCALE_FACTOR = 0.12f;
    public static final int DEFAULT_FPS = 60;
    private Choreographer.FrameCallback invalidationLoop = new Choreographer.FrameCallback() {
        public void doFrame(long j) {
            BlurLayout.this.invalidate();
            Choreographer.getInstance().postFrameCallbackDelayed(this, (long) (1000 / BlurLayout.this.mFPS));
        }
    };
    private WeakReference<View> mActivityView;
    private boolean mAttachedToWindow;
    private int mBlurRadius;
    private float mCornerRadius;
    private float mDownscaleFactor;
    /* access modifiers changed from: private */
    public int mFPS;
    private RoundedImageView mImageView;
    private Bitmap mLockedBitmap;
    private Point mLockedPoint;
    private boolean mPositionLocked;
    private boolean mRunning;
    private boolean mViewLocked;

    public BlurLayout(Context context) {
        super(context, (AttributeSet) null);
    }

    /* JADX INFO: finally extract failed */
    public BlurLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            BlurKit.init(context);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1634R.styleable.BlurLayout, 0, 0);
        try {
            this.mDownscaleFactor = obtainStyledAttributes.getFloat(C1634R.styleable.BlurLayout_blk_downscaleFactor, 0.12f);
            this.mBlurRadius = obtainStyledAttributes.getInteger(C1634R.styleable.BlurLayout_blk_blurRadius, 12);
            this.mFPS = obtainStyledAttributes.getInteger(C1634R.styleable.BlurLayout_blk_fps, 60);
            this.mCornerRadius = obtainStyledAttributes.getDimension(C1634R.styleable.BlurLayout_blk_cornerRadius, 0.0f);
            obtainStyledAttributes.recycle();
            this.mImageView = new RoundedImageView(getContext());
            this.mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            addView(this.mImageView);
            setCornerRadius(this.mCornerRadius);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private Bitmap blur() {
        Point point;
        Bitmap bitmap;
        if (getContext() == null || isInEditMode()) {
            return null;
        }
        if (this.mActivityView == null || this.mActivityView.get() == null) {
            this.mActivityView = new WeakReference<>(getActivityView());
            if (this.mActivityView.get() == null) {
                return null;
            }
        }
        if (this.mPositionLocked) {
            if (this.mLockedPoint == null) {
                this.mLockedPoint = getPositionInScreen();
            }
            point = this.mLockedPoint;
        } else {
            point = getPositionInScreen();
        }
        setAlpha(0.0f);
        int width = ((View) this.mActivityView.get()).getWidth();
        int height = ((View) this.mActivityView.get()).getHeight();
        int width2 = (int) (((float) getWidth()) * this.mDownscaleFactor);
        int height2 = (int) (((float) getHeight()) * this.mDownscaleFactor);
        int i = (int) (((float) point.x) * this.mDownscaleFactor);
        int i2 = (int) (((float) point.y) * this.mDownscaleFactor);
        int width3 = getWidth() / 8;
        int height3 = getHeight() / 8;
        int i3 = -width3;
        if (i + i3 < 0) {
            i3 = 0;
        }
        if (getWidth() + i + width3 > width) {
            width3 = (width - getWidth()) - i;
        }
        int i4 = -height3;
        if (i2 + i4 < 0) {
            i4 = 0;
        }
        if (i2 + height2 + height3 > height) {
            height3 = 0;
        }
        if (this.mViewLocked) {
            if (this.mLockedBitmap == null) {
                lockView();
            }
            if (width2 == 0 || height2 == 0) {
                return null;
            }
            bitmap = Bitmap.createBitmap(this.mLockedBitmap, i, i2, width2, height2);
        } else {
            try {
                bitmap = getDownscaledBitmapForView((View) this.mActivityView.get(), new Rect(point.x + i3, point.y + i4, point.x + getWidth() + Math.abs(i3) + width3, point.y + getHeight() + Math.abs(i4) + height3), this.mDownscaleFactor);
            } catch (BlurKitException unused) {
                return null;
            } catch (NullPointerException unused2) {
                return null;
            }
        }
        if (!this.mViewLocked) {
            bitmap = Bitmap.createBitmap(BlurKit.getInstance().blur(bitmap, this.mBlurRadius), (int) (((float) Math.abs(i3)) * this.mDownscaleFactor), (int) (((float) Math.abs(i4)) * this.mDownscaleFactor), width2, height2);
        }
        setAlpha(1.0f);
        return bitmap;
    }

    private View getActivityView() {
        try {
            return ((Activity) getContext()).getWindow().getDecorView().findViewById(16908290);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    private Bitmap getDownscaledBitmapForView(View view, Rect rect, float f) throws BlurKitException, NullPointerException {
        View rootView = view.getRootView();
        int width = (int) (((float) rect.width()) * f);
        int height = (int) (((float) rect.height()) * f);
        if (rootView.getWidth() <= 0 || rootView.getHeight() <= 0 || width <= 0 || height <= 0) {
            throw new BlurKitException("No screen available (width or height = 0)");
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.preScale(f, f);
        matrix.postTranslate(((float) (-rect.left)) * f, ((float) (-rect.top)) * f);
        canvas.setMatrix(matrix);
        rootView.draw(canvas);
        return createBitmap;
    }

    private Point getPositionInScreen() {
        PointF positionInScreen = getPositionInScreen(this);
        return new Point((int) positionInScreen.x, (int) positionInScreen.y);
    }

    private PointF getPositionInScreen(View view) {
        if (getParent() == null) {
            return new PointF();
        }
        try {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup == null) {
                return new PointF();
            }
            PointF positionInScreen = getPositionInScreen(viewGroup);
            positionInScreen.offset(view.getX(), view.getY());
            return positionInScreen;
        } catch (Exception unused) {
            return new PointF();
        }
    }

    public int getBlurRadius() {
        return this.mBlurRadius;
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public float getDownscaleFactor() {
        return this.mDownscaleFactor;
    }

    public int getFPS() {
        return this.mFPS;
    }

    public boolean getPositionLocked() {
        return this.mPositionLocked;
    }

    public boolean getViewLocked() {
        return this.mViewLocked;
    }

    public void invalidate() {
        super.invalidate();
        Bitmap blur = blur();
        if (blur != null) {
            this.mImageView.setImageBitmap(blur);
        }
    }

    public void lockPosition() {
        this.mPositionLocked = true;
        this.mLockedPoint = getPositionInScreen();
    }

    public void lockView() {
        this.mViewLocked = true;
        if (this.mActivityView != null && this.mActivityView.get() != null) {
            View rootView = ((View) this.mActivityView.get()).getRootView();
            try {
                setAlpha(0.0f);
                this.mLockedBitmap = getDownscaledBitmapForView(rootView, new Rect(0, 0, rootView.getWidth(), rootView.getHeight()), this.mDownscaleFactor);
                setAlpha(1.0f);
                this.mLockedBitmap = BlurKit.getInstance().blur(this.mLockedBitmap, this.mBlurRadius);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttachedToWindow = true;
        startBlur();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttachedToWindow = false;
        pauseBlur();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        invalidate();
    }

    public void pauseBlur() {
        if (this.mRunning) {
            this.mRunning = false;
            Choreographer.getInstance().removeFrameCallback(this.invalidationLoop);
        }
    }

    public void setBlurRadius(int i) {
        this.mBlurRadius = i;
        this.mLockedBitmap = null;
        invalidate();
    }

    public void setCornerRadius(float f) {
        this.mCornerRadius = f;
        if (this.mImageView != null) {
            this.mImageView.setCornerRadius(f);
        }
        invalidate();
    }

    public void setDownscaleFactor(float f) {
        this.mDownscaleFactor = f;
        this.mLockedBitmap = null;
        invalidate();
    }

    public void setFPS(int i) {
        if (this.mRunning) {
            pauseBlur();
        }
        this.mFPS = i;
        if (this.mAttachedToWindow) {
            startBlur();
        }
    }

    public void startBlur() {
        if (!this.mRunning && this.mFPS > 0) {
            this.mRunning = true;
            Choreographer.getInstance().postFrameCallback(this.invalidationLoop);
        }
    }

    public void unlockPosition() {
        this.mPositionLocked = false;
        this.mLockedPoint = null;
    }

    public void unlockView() {
        this.mViewLocked = false;
        this.mLockedBitmap = null;
    }
}
