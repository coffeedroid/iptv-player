package mdc.licensekeyupgrade;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.p000v4.view.InputDeviceCompat;
import android.util.AttributeSet;
import android.view.View;

public class PointOverlayView extends View {
    private Paint paint;
    PointF[] points;

    public PointOverlayView(Context context) {
        super(context);
        init();
    }

    public PointOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PointOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.paint = new Paint();
        this.paint.setColor(InputDeviceCompat.SOURCE_ANY);
        this.paint.setStyle(Paint.Style.FILL);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.points != null) {
            for (PointF pointF : this.points) {
                canvas.drawCircle(pointF.x, pointF.y, 10.0f, this.paint);
            }
        }
    }

    public void setPoints(PointF[] pointFArr) {
        this.points = pointFArr;
        invalidate();
    }
}
