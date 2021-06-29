package p018jp.wasabeef.blurry.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: jp.wasabeef.blurry.internal.BlurTask */
public class BlurTask {
    private static ExecutorService THREAD_POOL = Executors.newCachedThreadPool();
    /* access modifiers changed from: private */
    public Bitmap bitmap;
    /* access modifiers changed from: private */
    public Callback callback;
    /* access modifiers changed from: private */
    public WeakReference<Context> contextWeakRef;
    /* access modifiers changed from: private */
    public BlurFactor factor;
    /* access modifiers changed from: private */
    public Resources res;

    /* renamed from: jp.wasabeef.blurry.internal.BlurTask$Callback */
    public interface Callback {
        void done(BitmapDrawable bitmapDrawable);
    }

    public BlurTask(Context context, Bitmap bitmap2, BlurFactor blurFactor, Callback callback2) {
        this.res = context.getResources();
        this.factor = blurFactor;
        this.callback = callback2;
        this.contextWeakRef = new WeakReference<>(context);
        this.bitmap = bitmap2;
    }

    public BlurTask(View view, BlurFactor blurFactor, Callback callback2) {
        this.res = view.getResources();
        this.factor = blurFactor;
        this.callback = callback2;
        this.contextWeakRef = new WeakReference<>(view.getContext());
        view.setDrawingCacheEnabled(true);
        view.destroyDrawingCache();
        view.setDrawingCacheQuality(524288);
        this.bitmap = view.getDrawingCache();
    }

    public void execute() {
        THREAD_POOL.execute(new Runnable() {
            public void run() {
                final BitmapDrawable bitmapDrawable = new BitmapDrawable(BlurTask.this.res, Blur.m1203of((Context) BlurTask.this.contextWeakRef.get(), BlurTask.this.bitmap, BlurTask.this.factor));
                if (BlurTask.this.callback != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            BlurTask.this.callback.done(bitmapDrawable);
                        }
                    });
                }
            }
        });
    }
}
