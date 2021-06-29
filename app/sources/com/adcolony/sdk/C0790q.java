package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.support.p000v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.io.File;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.settings.SettingsJsonConstants;

@SuppressLint({"AppCompatCustomView"})
/* renamed from: com.adcolony.sdk.q */
class C0790q extends ImageView {

    /* renamed from: a */
    private int f1068a;

    /* renamed from: b */
    private int f1069b;

    /* renamed from: c */
    private int f1070c;

    /* renamed from: d */
    private int f1071d;

    /* renamed from: e */
    private int f1072e;

    /* renamed from: f */
    private boolean f1073f;

    /* renamed from: g */
    private boolean f1074g;

    /* renamed from: h */
    private boolean f1075h;

    /* renamed from: i */
    private String f1076i;

    /* renamed from: j */
    private String f1077j;

    /* renamed from: k */
    private C0812x f1078k;

    /* renamed from: l */
    private C0563c f1079l;

    /* renamed from: com.adcolony.sdk.q$a */
    class C0791a implements C0816z {
        C0791a() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0790q.this.m761a(xVar)) {
                C0790q.this.m767d(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.q$b */
    class C0792b implements C0816z {
        C0792b() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0790q.this.m761a(xVar)) {
                C0790q.this.m763b(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.q$c */
    class C0793c implements C0816z {
        C0793c() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0790q.this.m761a(xVar)) {
                C0790q.this.m765c(xVar);
            }
        }
    }

    private C0790q(Context context) {
        super(context);
    }

    C0790q(Context context, C0812x xVar, int i, C0563c cVar) {
        super(context);
        this.f1068a = i;
        this.f1078k = xVar;
        this.f1079l = cVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m761a(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        return C0795s.m810f(b, "id") == this.f1068a && C0795s.m810f(b, "container_id") == this.f1079l.mo10514c() && C0795s.m812h(b, "ad_session_id").equals(this.f1079l.mo10504a());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m763b(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        this.f1069b = C0795s.m810f(b, "x");
        this.f1070c = C0795s.m810f(b, "y");
        this.f1071d = C0795s.m810f(b, SettingsJsonConstants.ICON_WIDTH_KEY);
        this.f1072e = C0795s.m810f(b, SettingsJsonConstants.ICON_HEIGHT_KEY);
        if (this.f1073f) {
            float n = (((float) this.f1072e) * C0557a.m88c().mo10647h().mo10737n()) / ((float) getDrawable().getIntrinsicHeight());
            this.f1072e = (int) (((float) getDrawable().getIntrinsicHeight()) * n);
            int intrinsicWidth = (int) (((float) getDrawable().getIntrinsicWidth()) * n);
            this.f1071d = intrinsicWidth;
            this.f1069b -= intrinsicWidth;
            this.f1070c -= this.f1072e;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.f1069b, this.f1070c, 0, 0);
        layoutParams.width = this.f1071d;
        layoutParams.height = this.f1072e;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m765c(C0812x xVar) {
        this.f1076i = C0795s.m812h(xVar.mo10941b(), "filepath");
        setImageURI(Uri.fromFile(new File(this.f1076i)));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m767d(C0812x xVar) {
        if (C0795s.m807d(xVar.mo10941b(), "visible")) {
            setVisibility(0);
        } else {
            setVisibility(4);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int[] mo10908a() {
        return new int[]{this.f1069b, this.f1070c, this.f1071d, this.f1072e};
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10909b() {
        JSONObject b = this.f1078k.mo10941b();
        this.f1077j = C0795s.m812h(b, "ad_session_id");
        this.f1069b = C0795s.m810f(b, "x");
        this.f1070c = C0795s.m810f(b, "y");
        this.f1071d = C0795s.m810f(b, SettingsJsonConstants.ICON_WIDTH_KEY);
        this.f1072e = C0795s.m810f(b, SettingsJsonConstants.ICON_HEIGHT_KEY);
        this.f1076i = C0795s.m812h(b, "filepath");
        this.f1073f = C0795s.m807d(b, "dpi");
        this.f1074g = C0795s.m807d(b, "invert_y");
        this.f1075h = C0795s.m807d(b, "wrap_content");
        setImageURI(Uri.fromFile(new File(this.f1076i)));
        if (this.f1073f) {
            float n = (((float) this.f1072e) * C0557a.m88c().mo10647h().mo10737n()) / ((float) getDrawable().getIntrinsicHeight());
            this.f1072e = (int) (((float) getDrawable().getIntrinsicHeight()) * n);
            int intrinsicWidth = (int) (((float) getDrawable().getIntrinsicWidth()) * n);
            this.f1071d = intrinsicWidth;
            this.f1069b -= intrinsicWidth;
            this.f1070c = this.f1074g ? this.f1070c + this.f1072e : this.f1070c - this.f1072e;
        }
        setVisibility(4);
        FrameLayout.LayoutParams layoutParams = this.f1075h ? new FrameLayout.LayoutParams(-2, -2) : new FrameLayout.LayoutParams(this.f1071d, this.f1072e);
        layoutParams.setMargins(this.f1069b, this.f1070c, 0, 0);
        layoutParams.gravity = 0;
        this.f1079l.addView(this, layoutParams);
        this.f1079l.mo10527i().add(C0557a.m80a("ImageView.set_visible", (C0816z) new C0791a(), true));
        this.f1079l.mo10527i().add(C0557a.m80a("ImageView.set_bounds", (C0816z) new C0792b(), true));
        this.f1079l.mo10527i().add(C0557a.m80a("ImageView.set_image", (C0816z) new C0793c(), true));
        this.f1079l.mo10529j().add("ImageView.set_visible");
        this.f1079l.mo10529j().add("ImageView.set_bounds");
        this.f1079l.mo10529j().add("ImageView.set_image");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        C0648h c = C0557a.m88c();
        C0580d b = c.mo10633b();
        int action = motionEvent.getAction() & 255;
        if (action != 0 && action != 1 && action != 3 && action != 2 && action != 5 && action != 6) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        JSONObject b2 = C0795s.m798b();
        C0795s.m801b(b2, "view_id", this.f1068a);
        C0795s.m791a(b2, "ad_session_id", this.f1077j);
        C0795s.m801b(b2, "container_x", this.f1069b + x);
        C0795s.m801b(b2, "container_y", this.f1070c + y);
        C0795s.m801b(b2, "view_x", x);
        C0795s.m801b(b2, "view_y", y);
        C0795s.m801b(b2, "id", this.f1079l.getId());
        switch (action) {
            case 0:
                new C0812x("AdContainer.on_touch_began", this.f1079l.mo10531k(), b2).mo10945d();
                break;
            case 1:
                if (!this.f1079l.mo10538p()) {
                    c.mo10621a(b.mo10562b().get(this.f1077j));
                }
                if (x > 0 && x < this.f1071d && y > 0 && y < this.f1072e) {
                    new C0812x("AdContainer.on_touch_ended", this.f1079l.mo10531k(), b2).mo10945d();
                    break;
                } else {
                    new C0812x("AdContainer.on_touch_cancelled", this.f1079l.mo10531k(), b2).mo10945d();
                    break;
                }
                break;
            case 2:
                new C0812x("AdContainer.on_touch_moved", this.f1079l.mo10531k(), b2).mo10945d();
                break;
            case 3:
                new C0812x("AdContainer.on_touch_cancelled", this.f1079l.mo10531k(), b2).mo10945d();
                break;
            case 5:
                int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                C0795s.m801b(b2, "container_x", ((int) motionEvent.getX(action2)) + this.f1069b);
                C0795s.m801b(b2, "container_y", ((int) motionEvent.getY(action2)) + this.f1070c);
                C0795s.m801b(b2, "view_x", (int) motionEvent.getX(action2));
                C0795s.m801b(b2, "view_y", (int) motionEvent.getY(action2));
                new C0812x("AdContainer.on_touch_began", this.f1079l.mo10531k(), b2).mo10945d();
                break;
            case 6:
                int action3 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                int x2 = (int) motionEvent.getX(action3);
                int y2 = (int) motionEvent.getY(action3);
                C0795s.m801b(b2, "container_x", ((int) motionEvent.getX(action3)) + this.f1069b);
                C0795s.m801b(b2, "container_y", ((int) motionEvent.getY(action3)) + this.f1070c);
                C0795s.m801b(b2, "view_x", (int) motionEvent.getX(action3));
                C0795s.m801b(b2, "view_y", (int) motionEvent.getY(action3));
                if (!this.f1079l.mo10538p()) {
                    c.mo10621a(b.mo10562b().get(this.f1077j));
                }
                if (x2 > 0 && x2 < this.f1071d && y2 > 0 && y2 < this.f1072e) {
                    new C0812x("AdContainer.on_touch_ended", this.f1079l.mo10531k(), b2).mo10945d();
                    break;
                } else {
                    new C0812x("AdContainer.on_touch_cancelled", this.f1079l.mo10531k(), b2).mo10945d();
                    break;
                }
                break;
        }
        return true;
    }
}
