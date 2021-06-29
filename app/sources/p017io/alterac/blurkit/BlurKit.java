package p017io.alterac.blurkit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;

/* renamed from: io.alterac.blurkit.BlurKit */
public class BlurKit {
    private static final float FULL_SCALE = 0.6f;
    private static BlurKit instance;

    /* renamed from: rs */
    private static RenderScript f1405rs;

    private Bitmap getBitmapForView(View view, float f) {
        Bitmap createBitmap = Bitmap.createBitmap((int) (((float) view.getWidth()) * f), (int) (((float) view.getHeight()) * f), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.preScale(f, f);
        canvas.setMatrix(matrix);
        view.draw(canvas);
        return createBitmap;
    }

    public static BlurKit getInstance() {
        if (instance != null) {
            return instance;
        }
        throw new RuntimeException("BlurKit not initialized!");
    }

    public static void init(Context context) {
        if (instance == null) {
            instance = new BlurKit();
            f1405rs = RenderScript.create(context);
        }
    }

    public Bitmap blur(Bitmap bitmap, int i) {
        Allocation createFromBitmap = Allocation.createFromBitmap(f1405rs, bitmap);
        Allocation createTyped = Allocation.createTyped(f1405rs, createFromBitmap.getType());
        ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(f1405rs, Element.U8_4(f1405rs));
        create.setRadius((float) i);
        create.setInput(createFromBitmap);
        create.forEach(createTyped);
        createTyped.copyTo(bitmap);
        return bitmap;
    }

    public Bitmap blur(View view, int i) {
        return blur(getBitmapForView(view, FULL_SCALE), i);
    }

    public Bitmap fastBlur(View view, int i, float f) {
        return blur(getBitmapForView(view, f), i);
    }
}
