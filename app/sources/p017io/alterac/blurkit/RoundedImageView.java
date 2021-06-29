package p017io.alterac.blurkit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo21415bv = {1, 0, 2}, mo21416d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\tJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\tR\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo21417d2 = {"Lio/alterac/blurkit/RoundedImageView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributes", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mCornerRadius", "", "porterDuffXfermode", "Landroid/graphics/PorterDuffXfermode;", "rectF", "Landroid/graphics/RectF;", "getCornerRadius", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setCornerRadius", "cornerRadius", "Companion", "blurkit_release"}, mo21418k = 1, mo21419mv = {1, 1, 10})
/* renamed from: io.alterac.blurkit.RoundedImageView */
public final class RoundedImageView extends ImageView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEFAULT_COLOR = -16777216;
    private float mCornerRadius;
    private PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    private RectF rectF = new RectF();

    @Metadata(mo21415bv = {1, 0, 2}, mo21416d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo21417d2 = {"Lio/alterac/blurkit/RoundedImageView$Companion;", "", "()V", "DEFAULT_COLOR", "", "blurkit_release"}, mo21418k = 1, mo21419mv = {1, 1, 10})
    /* renamed from: io.alterac.blurkit.RoundedImageView$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoundedImageView(@NotNull Context context) {
        super(context, (AttributeSet) null);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoundedImageView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attributes");
    }

    public final float getCornerRadius() {
        return this.mCornerRadius;
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable) || this.mCornerRadius <= ((float) 0)) {
            super.onDraw(canvas);
            return;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Paint paint = bitmapDrawable.getPaint();
        RectF rectF2 = this.rectF;
        if (rectF2 == null) {
            Intrinsics.throwNpe();
        }
        rectF2.set(bitmapDrawable.getBounds());
        int saveLayer = canvas.saveLayer(this.rectF, (Paint) null);
        Intrinsics.checkExpressionValueIsNotNull(paint, "paint");
        paint.setAntiAlias(true);
        paint.setColor(-16777216);
        canvas.drawARGB(0, 0, 0, 0);
        RectF rectF3 = this.rectF;
        if (rectF3 == null) {
            Intrinsics.throwNpe();
        }
        canvas.drawRoundRect(rectF3, this.mCornerRadius, this.mCornerRadius, paint);
        Xfermode xfermode = paint.getXfermode();
        paint.setXfermode(this.porterDuffXfermode);
        super.onDraw(canvas);
        paint.setXfermode(xfermode);
        canvas.restoreToCount(saveLayer);
    }

    public final void setCornerRadius(float f) {
        this.mCornerRadius = f;
    }
}
