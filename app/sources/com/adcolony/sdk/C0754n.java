package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.support.p000v4.view.GravityCompat;
import android.support.p000v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.settings.SettingsJsonConstants;

@SuppressLint({"AppCompatCustomView"})
/* renamed from: com.adcolony.sdk.n */
class C0754n extends EditText {

    /* renamed from: A */
    private C0563c f984A;

    /* renamed from: B */
    private C0812x f985B;

    /* renamed from: a */
    private final int f986a = 0;

    /* renamed from: b */
    private final int f987b = 1;

    /* renamed from: c */
    private final int f988c = 2;

    /* renamed from: d */
    private final int f989d = 3;

    /* renamed from: e */
    private final int f990e = 1;

    /* renamed from: f */
    private final int f991f = 2;

    /* renamed from: g */
    private final int f992g = 3;

    /* renamed from: h */
    private final int f993h = 0;

    /* renamed from: i */
    private final int f994i = 1;

    /* renamed from: j */
    private final int f995j = 2;

    /* renamed from: k */
    private final int f996k = 1;

    /* renamed from: l */
    private final int f997l = 2;

    /* renamed from: m */
    private int f998m;

    /* renamed from: n */
    private int f999n;

    /* renamed from: o */
    private int f1000o;

    /* renamed from: p */
    private int f1001p;

    /* renamed from: q */
    private int f1002q;

    /* renamed from: r */
    private int f1003r;

    /* renamed from: s */
    private int f1004s;

    /* renamed from: t */
    private int f1005t;

    /* renamed from: u */
    private int f1006u;

    /* renamed from: v */
    private int f1007v;

    /* renamed from: w */
    private String f1008w;

    /* renamed from: x */
    private String f1009x;

    /* renamed from: y */
    private String f1010y;

    /* renamed from: z */
    private String f1011z;

    /* renamed from: com.adcolony.sdk.n$a */
    class C0755a implements C0816z {
        C0755a() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0754n.this.mo10871c(xVar)) {
                C0754n.this.mo10869a(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.n$b */
    class C0756b implements C0816z {
        C0756b() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0754n.this.mo10871c(xVar)) {
                C0754n.this.mo10879k(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.n$c */
    class C0757c implements C0816z {
        C0757c() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0754n.this.mo10871c(xVar)) {
                C0754n.this.mo10873e(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.n$d */
    class C0758d implements C0816z {
        C0758d() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0754n.this.mo10871c(xVar)) {
                C0754n.this.mo10874f(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.n$e */
    class C0759e implements C0816z {
        C0759e() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0754n.this.mo10871c(xVar)) {
                C0754n.this.mo10872d(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.n$f */
    class C0760f implements C0816z {
        C0760f() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0754n.this.mo10871c(xVar)) {
                C0754n.this.mo10878j(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.n$g */
    class C0761g implements C0816z {
        C0761g() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0754n.this.mo10871c(xVar)) {
                C0754n.this.mo10875g(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.n$h */
    class C0762h implements C0816z {
        C0762h() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0754n.this.mo10871c(xVar)) {
                C0754n.this.mo10876h(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.n$i */
    class C0763i implements C0816z {
        C0763i() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0754n.this.mo10871c(xVar)) {
                C0754n.this.mo10870b(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.n$j */
    class C0764j implements C0816z {
        C0764j() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0754n.this.mo10871c(xVar)) {
                C0754n.this.mo10877i(xVar);
            }
        }
    }

    private C0754n(Context context) {
        super(context);
    }

    C0754n(Context context, C0812x xVar, int i, C0563c cVar) {
        super(context);
        this.f998m = i;
        this.f985B = xVar;
        this.f984A = cVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo10867a(boolean z, int i) {
        if (i == 0) {
            return z ? 1 : 16;
        }
        if (i == 1) {
            return z ? 8388611 : 48;
        }
        if (i != 2) {
            return 17;
        }
        if (z) {
            return GravityCompat.END;
        }
        return 80;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10868a() {
        JSONObject b = this.f985B.mo10941b();
        this.f1008w = C0795s.m812h(b, "ad_session_id");
        this.f999n = C0795s.m810f(b, "x");
        this.f1000o = C0795s.m810f(b, "y");
        this.f1001p = C0795s.m810f(b, SettingsJsonConstants.ICON_WIDTH_KEY);
        this.f1002q = C0795s.m810f(b, SettingsJsonConstants.ICON_HEIGHT_KEY);
        this.f1004s = C0795s.m810f(b, "font_family");
        this.f1003r = C0795s.m810f(b, "font_style");
        this.f1005t = C0795s.m810f(b, "font_size");
        this.f1009x = C0795s.m812h(b, "background_color");
        this.f1010y = C0795s.m812h(b, "font_color");
        this.f1011z = C0795s.m812h(b, "text");
        this.f1006u = C0795s.m810f(b, "align_x");
        this.f1007v = C0795s.m810f(b, "align_y");
        setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f1001p, this.f1002q);
        layoutParams.setMargins(this.f999n, this.f1000o, 0, 0);
        layoutParams.gravity = 0;
        this.f984A.addView(this, layoutParams);
        switch (this.f1004s) {
            case 0:
                setTypeface(Typeface.DEFAULT);
                break;
            case 1:
                setTypeface(Typeface.SERIF);
                break;
            case 2:
                setTypeface(Typeface.SANS_SERIF);
                break;
            case 3:
                setTypeface(Typeface.MONOSPACE);
                break;
        }
        switch (this.f1003r) {
            case 0:
                setTypeface(getTypeface(), 0);
                break;
            case 1:
                setTypeface(getTypeface(), 1);
                break;
            case 2:
                setTypeface(getTypeface(), 2);
                break;
            case 3:
                setTypeface(getTypeface(), 3);
                break;
        }
        setText(this.f1011z);
        setTextSize((float) this.f1005t);
        setGravity(mo10867a(true, this.f1006u) | mo10867a(false, this.f1007v));
        if (!this.f1009x.equals("")) {
            setBackgroundColor(C0717k0.m540j(this.f1009x));
        }
        if (!this.f1010y.equals("")) {
            setTextColor(C0717k0.m540j(this.f1010y));
        }
        this.f984A.mo10527i().add(C0557a.m80a("TextView.set_visible", (C0816z) new C0756b(), true));
        this.f984A.mo10527i().add(C0557a.m80a("TextView.set_bounds", (C0816z) new C0757c(), true));
        this.f984A.mo10527i().add(C0557a.m80a("TextView.set_font_color", (C0816z) new C0758d(), true));
        this.f984A.mo10527i().add(C0557a.m80a("TextView.set_background_color", (C0816z) new C0759e(), true));
        this.f984A.mo10527i().add(C0557a.m80a("TextView.set_typeface", (C0816z) new C0760f(), true));
        this.f984A.mo10527i().add(C0557a.m80a("TextView.set_font_size", (C0816z) new C0761g(), true));
        this.f984A.mo10527i().add(C0557a.m80a("TextView.set_font_style", (C0816z) new C0762h(), true));
        this.f984A.mo10527i().add(C0557a.m80a("TextView.get_text", (C0816z) new C0763i(), true));
        this.f984A.mo10527i().add(C0557a.m80a("TextView.set_text", (C0816z) new C0764j(), true));
        this.f984A.mo10527i().add(C0557a.m80a("TextView.align", (C0816z) new C0755a(), true));
        this.f984A.mo10529j().add("TextView.set_visible");
        this.f984A.mo10529j().add("TextView.set_bounds");
        this.f984A.mo10529j().add("TextView.set_font_color");
        this.f984A.mo10529j().add("TextView.set_background_color");
        this.f984A.mo10529j().add("TextView.set_typeface");
        this.f984A.mo10529j().add("TextView.set_font_size");
        this.f984A.mo10529j().add("TextView.set_font_style");
        this.f984A.mo10529j().add("TextView.get_text");
        this.f984A.mo10529j().add("TextView.set_text");
        this.f984A.mo10529j().add("TextView.align");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10869a(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        this.f1006u = C0795s.m810f(b, "x");
        this.f1007v = C0795s.m810f(b, "y");
        setGravity(mo10867a(true, this.f1006u) | mo10867a(false, this.f1007v));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10870b(C0812x xVar) {
        JSONObject b = C0795s.m798b();
        C0795s.m791a(b, "text", getText().toString());
        xVar.mo10940a(b).mo10945d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo10871c(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        return C0795s.m810f(b, "id") == this.f998m && C0795s.m810f(b, "container_id") == this.f984A.mo10514c() && C0795s.m812h(b, "ad_session_id").equals(this.f984A.mo10504a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo10872d(C0812x xVar) {
        String h = C0795s.m812h(xVar.mo10941b(), "background_color");
        this.f1009x = h;
        setBackgroundColor(C0717k0.m540j(h));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo10873e(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        this.f999n = C0795s.m810f(b, "x");
        this.f1000o = C0795s.m810f(b, "y");
        this.f1001p = C0795s.m810f(b, SettingsJsonConstants.ICON_WIDTH_KEY);
        this.f1002q = C0795s.m810f(b, SettingsJsonConstants.ICON_HEIGHT_KEY);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.f999n, this.f1000o, 0, 0);
        layoutParams.width = this.f1001p;
        layoutParams.height = this.f1002q;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo10874f(C0812x xVar) {
        String h = C0795s.m812h(xVar.mo10941b(), "font_color");
        this.f1010y = h;
        setTextColor(C0717k0.m540j(h));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo10875g(C0812x xVar) {
        int f = C0795s.m810f(xVar.mo10941b(), "font_size");
        this.f1005t = f;
        setTextSize((float) f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo10876h(C0812x xVar) {
        int f = C0795s.m810f(xVar.mo10941b(), "font_style");
        this.f1003r = f;
        switch (f) {
            case 0:
                setTypeface(getTypeface(), 0);
                return;
            case 1:
                setTypeface(getTypeface(), 1);
                return;
            case 2:
                setTypeface(getTypeface(), 2);
                return;
            case 3:
                setTypeface(getTypeface(), 3);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo10877i(C0812x xVar) {
        String h = C0795s.m812h(xVar.mo10941b(), "text");
        this.f1011z = h;
        setText(h);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo10878j(C0812x xVar) {
        int f = C0795s.m810f(xVar.mo10941b(), "font_family");
        this.f1004s = f;
        switch (f) {
            case 0:
                setTypeface(Typeface.DEFAULT);
                return;
            case 1:
                setTypeface(Typeface.SERIF);
                return;
            case 2:
                setTypeface(Typeface.SANS_SERIF);
                return;
            case 3:
                setTypeface(Typeface.MONOSPACE);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo10879k(C0812x xVar) {
        if (C0795s.m807d(xVar.mo10941b(), "visible")) {
            setVisibility(0);
        } else {
            setVisibility(4);
        }
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
        C0795s.m801b(b2, "view_id", this.f998m);
        C0795s.m791a(b2, "ad_session_id", this.f1008w);
        C0795s.m801b(b2, "container_x", this.f999n + x);
        C0795s.m801b(b2, "container_y", this.f1000o + y);
        C0795s.m801b(b2, "view_x", x);
        C0795s.m801b(b2, "view_y", y);
        C0795s.m801b(b2, "id", this.f984A.mo10514c());
        switch (action) {
            case 0:
                new C0812x("AdContainer.on_touch_began", this.f984A.mo10531k(), b2).mo10945d();
                break;
            case 1:
                if (!this.f984A.mo10538p()) {
                    c.mo10621a(b.mo10562b().get(this.f1008w));
                }
                new C0812x("AdContainer.on_touch_ended", this.f984A.mo10531k(), b2).mo10945d();
                break;
            case 2:
                new C0812x("AdContainer.on_touch_moved", this.f984A.mo10531k(), b2).mo10945d();
                break;
            case 3:
                new C0812x("AdContainer.on_touch_cancelled", this.f984A.mo10531k(), b2).mo10945d();
                break;
            case 5:
                int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                C0795s.m801b(b2, "container_x", ((int) motionEvent.getX(action2)) + this.f999n);
                C0795s.m801b(b2, "container_y", ((int) motionEvent.getY(action2)) + this.f1000o);
                C0795s.m801b(b2, "view_x", (int) motionEvent.getX(action2));
                C0795s.m801b(b2, "view_y", (int) motionEvent.getY(action2));
                new C0812x("AdContainer.on_touch_began", this.f984A.mo10531k(), b2).mo10945d();
                break;
            case 6:
                int action3 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                C0795s.m801b(b2, "container_x", ((int) motionEvent.getX(action3)) + this.f999n);
                C0795s.m801b(b2, "container_y", ((int) motionEvent.getY(action3)) + this.f1000o);
                C0795s.m801b(b2, "view_x", (int) motionEvent.getX(action3));
                C0795s.m801b(b2, "view_y", (int) motionEvent.getY(action3));
                if (!this.f984A.mo10538p()) {
                    c.mo10621a(b.mo10562b().get(this.f1008w));
                }
                new C0812x("AdContainer.on_touch_ended", this.f984A.mo10531k(), b2).mo10945d();
                break;
        }
        return true;
    }
}
