package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.support.p000v4.view.GravityCompat;
import android.support.p000v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.FrameLayout;
import com.adcolony.sdk.C0797u;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.settings.SettingsJsonConstants;

@SuppressLint({"AppCompatCustomView"})
/* renamed from: com.adcolony.sdk.j0 */
class C0700j0 extends Button {

    /* renamed from: A */
    private C0563c f784A;

    /* renamed from: B */
    private C0812x f785B;

    /* renamed from: a */
    private final int f786a = 0;

    /* renamed from: b */
    private final int f787b = 1;

    /* renamed from: c */
    private final int f788c = 2;

    /* renamed from: d */
    private final int f789d = 3;

    /* renamed from: e */
    private final int f790e = 1;

    /* renamed from: f */
    private final int f791f = 2;

    /* renamed from: g */
    private final int f792g = 3;

    /* renamed from: h */
    private final int f793h = 0;

    /* renamed from: i */
    private final int f794i = 1;

    /* renamed from: j */
    private final int f795j = 2;

    /* renamed from: k */
    private final int f796k = 1;

    /* renamed from: l */
    private final int f797l = 2;

    /* renamed from: m */
    private int f798m;

    /* renamed from: n */
    private int f799n;

    /* renamed from: o */
    private int f800o;

    /* renamed from: p */
    private int f801p;

    /* renamed from: q */
    private int f802q;

    /* renamed from: r */
    private int f803r;

    /* renamed from: s */
    private int f804s;

    /* renamed from: t */
    private int f805t;

    /* renamed from: u */
    private int f806u;

    /* renamed from: v */
    private int f807v;

    /* renamed from: w */
    private String f808w;

    /* renamed from: x */
    private String f809x;

    /* renamed from: y */
    private String f810y;

    /* renamed from: z */
    private String f811z;

    /* renamed from: com.adcolony.sdk.j0$a */
    class C0701a implements C0816z {
        C0701a() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0700j0.this.mo10760c(xVar)) {
                C0700j0.this.mo10758a(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.j0$b */
    class C0702b implements C0816z {
        C0702b() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0700j0.this.mo10760c(xVar)) {
                C0700j0.this.mo10768k(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.j0$c */
    class C0703c implements C0816z {
        C0703c() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0700j0.this.mo10760c(xVar)) {
                C0700j0.this.mo10762e(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.j0$d */
    class C0704d implements C0816z {
        C0704d() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0700j0.this.mo10760c(xVar)) {
                C0700j0.this.mo10763f(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.j0$e */
    class C0705e implements C0816z {
        C0705e() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0700j0.this.mo10760c(xVar)) {
                C0700j0.this.mo10761d(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.j0$f */
    class C0706f implements C0816z {
        C0706f() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0700j0.this.mo10760c(xVar)) {
                C0700j0.this.mo10767j(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.j0$g */
    class C0707g implements C0816z {
        C0707g() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0700j0.this.mo10760c(xVar)) {
                C0700j0.this.mo10764g(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.j0$h */
    class C0708h implements C0816z {
        C0708h() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0700j0.this.mo10760c(xVar)) {
                C0700j0.this.mo10765h(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.j0$i */
    class C0709i implements C0816z {
        C0709i() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0700j0.this.mo10760c(xVar)) {
                C0700j0.this.mo10759b(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.j0$j */
    class C0710j implements C0816z {
        C0710j() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0700j0.this.mo10760c(xVar)) {
                C0700j0.this.mo10766i(xVar);
            }
        }
    }

    private C0700j0(Context context) {
        super(context);
    }

    C0700j0(Context context, int i, C0812x xVar, int i2, C0563c cVar) {
        super(context, (AttributeSet) null, i);
        this.f798m = i2;
        this.f785B = xVar;
        this.f784A = cVar;
    }

    C0700j0(Context context, C0812x xVar, int i, C0563c cVar) {
        super(context);
        this.f798m = i;
        this.f785B = xVar;
        this.f784A = cVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo10756a(boolean z, int i) {
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
    public void mo10757a() {
        int i;
        int i2;
        JSONObject b = this.f785B.mo10941b();
        this.f811z = C0795s.m812h(b, "ad_session_id");
        this.f799n = C0795s.m810f(b, "x");
        this.f800o = C0795s.m810f(b, "y");
        this.f801p = C0795s.m810f(b, SettingsJsonConstants.ICON_WIDTH_KEY);
        this.f802q = C0795s.m810f(b, SettingsJsonConstants.ICON_HEIGHT_KEY);
        this.f804s = C0795s.m810f(b, "font_family");
        this.f803r = C0795s.m810f(b, "font_style");
        this.f805t = C0795s.m810f(b, "font_size");
        this.f808w = C0795s.m812h(b, "background_color");
        this.f809x = C0795s.m812h(b, "font_color");
        this.f810y = C0795s.m812h(b, "text");
        this.f806u = C0795s.m810f(b, "align_x");
        this.f807v = C0795s.m810f(b, "align_y");
        C0648h c = C0557a.m88c();
        if (this.f810y.equals("")) {
            this.f810y = "Learn More";
        }
        setVisibility(4);
        FrameLayout.LayoutParams layoutParams = C0795s.m807d(b, "wrap_content") ? new FrameLayout.LayoutParams(-2, -2) : new FrameLayout.LayoutParams(this.f801p, this.f802q);
        layoutParams.gravity = 0;
        setText(this.f810y);
        setTextSize((float) this.f805t);
        if (C0795s.m807d(b, "overlay")) {
            this.f799n = 0;
            this.f800o = 0;
            i2 = (int) (c.mo10647h().mo10737n() * 6.0f);
            i = (int) (c.mo10647h().mo10737n() * 6.0f);
            int n = (int) (c.mo10647h().mo10737n() * 4.0f);
            setPadding(n, n, n, n);
            layoutParams.gravity = 8388693;
        } else {
            i2 = 0;
            i = 0;
        }
        layoutParams.setMargins(this.f799n, this.f800o, i2, i);
        this.f784A.addView(this, layoutParams);
        switch (this.f804s) {
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
        switch (this.f803r) {
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
        setGravity(mo10756a(true, this.f806u) | mo10756a(false, this.f807v));
        if (!this.f808w.equals("")) {
            setBackgroundColor(C0717k0.m540j(this.f808w));
        }
        if (!this.f809x.equals("")) {
            setTextColor(C0717k0.m540j(this.f809x));
        }
        this.f784A.mo10527i().add(C0557a.m80a("TextView.set_visible", (C0816z) new C0702b(), true));
        this.f784A.mo10527i().add(C0557a.m80a("TextView.set_bounds", (C0816z) new C0703c(), true));
        this.f784A.mo10527i().add(C0557a.m80a("TextView.set_font_color", (C0816z) new C0704d(), true));
        this.f784A.mo10527i().add(C0557a.m80a("TextView.set_background_color", (C0816z) new C0705e(), true));
        this.f784A.mo10527i().add(C0557a.m80a("TextView.set_typeface", (C0816z) new C0706f(), true));
        this.f784A.mo10527i().add(C0557a.m80a("TextView.set_font_size", (C0816z) new C0707g(), true));
        this.f784A.mo10527i().add(C0557a.m80a("TextView.set_font_style", (C0816z) new C0708h(), true));
        this.f784A.mo10527i().add(C0557a.m80a("TextView.get_text", (C0816z) new C0709i(), true));
        this.f784A.mo10527i().add(C0557a.m80a("TextView.set_text", (C0816z) new C0710j(), true));
        this.f784A.mo10527i().add(C0557a.m80a("TextView.align", (C0816z) new C0701a(), true));
        this.f784A.mo10529j().add("TextView.set_visible");
        this.f784A.mo10529j().add("TextView.set_bounds");
        this.f784A.mo10529j().add("TextView.set_font_color");
        this.f784A.mo10529j().add("TextView.set_background_color");
        this.f784A.mo10529j().add("TextView.set_typeface");
        this.f784A.mo10529j().add("TextView.set_font_size");
        this.f784A.mo10529j().add("TextView.set_font_style");
        this.f784A.mo10529j().add("TextView.get_text");
        this.f784A.mo10529j().add("TextView.set_text");
        this.f784A.mo10529j().add("TextView.align");
        new C0797u.C0798a().mo10920a("TextView added to layout").mo10922a(C0797u.f1091f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10758a(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        this.f806u = C0795s.m810f(b, "x");
        this.f807v = C0795s.m810f(b, "y");
        setGravity(mo10756a(true, this.f806u) | mo10756a(false, this.f807v));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10759b(C0812x xVar) {
        JSONObject b = C0795s.m798b();
        C0795s.m791a(b, "text", getText().toString());
        xVar.mo10940a(b).mo10945d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo10760c(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        return C0795s.m810f(b, "id") == this.f798m && C0795s.m810f(b, "container_id") == this.f784A.mo10514c() && C0795s.m812h(b, "ad_session_id").equals(this.f784A.mo10504a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo10761d(C0812x xVar) {
        String h = C0795s.m812h(xVar.mo10941b(), "background_color");
        this.f808w = h;
        setBackgroundColor(C0717k0.m540j(h));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo10762e(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        this.f799n = C0795s.m810f(b, "x");
        this.f800o = C0795s.m810f(b, "y");
        this.f801p = C0795s.m810f(b, SettingsJsonConstants.ICON_WIDTH_KEY);
        this.f802q = C0795s.m810f(b, SettingsJsonConstants.ICON_HEIGHT_KEY);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.f799n, this.f800o, 0, 0);
        layoutParams.width = this.f801p;
        layoutParams.height = this.f802q;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo10763f(C0812x xVar) {
        String h = C0795s.m812h(xVar.mo10941b(), "font_color");
        this.f809x = h;
        setTextColor(C0717k0.m540j(h));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo10764g(C0812x xVar) {
        int f = C0795s.m810f(xVar.mo10941b(), "font_size");
        this.f805t = f;
        setTextSize((float) f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo10765h(C0812x xVar) {
        int f = C0795s.m810f(xVar.mo10941b(), "font_style");
        this.f803r = f;
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
    public void mo10766i(C0812x xVar) {
        String h = C0795s.m812h(xVar.mo10941b(), "text");
        this.f810y = h;
        setText(h);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo10767j(C0812x xVar) {
        int f = C0795s.m810f(xVar.mo10941b(), "font_family");
        this.f804s = f;
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
    public void mo10768k(C0812x xVar) {
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
        C0795s.m801b(b2, "view_id", this.f798m);
        C0795s.m791a(b2, "ad_session_id", this.f811z);
        C0795s.m801b(b2, "container_x", this.f799n + x);
        C0795s.m801b(b2, "container_y", this.f800o + y);
        C0795s.m801b(b2, "view_x", x);
        C0795s.m801b(b2, "view_y", y);
        C0795s.m801b(b2, "id", this.f784A.getId());
        switch (action) {
            case 0:
                new C0812x("AdContainer.on_touch_began", this.f784A.mo10531k(), b2).mo10945d();
                break;
            case 1:
                if (!this.f784A.mo10538p()) {
                    c.mo10621a(b.mo10562b().get(this.f811z));
                }
                if (x > 0 && x < getWidth() && y > 0 && y < getHeight()) {
                    new C0812x("AdContainer.on_touch_ended", this.f784A.mo10531k(), b2).mo10945d();
                    break;
                } else {
                    new C0812x("AdContainer.on_touch_cancelled", this.f784A.mo10531k(), b2).mo10945d();
                    break;
                }
                break;
            case 2:
                new C0812x("AdContainer.on_touch_moved", this.f784A.mo10531k(), b2).mo10945d();
                break;
            case 3:
                new C0812x("AdContainer.on_touch_cancelled", this.f784A.mo10531k(), b2).mo10945d();
                break;
            case 5:
                int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                C0795s.m801b(b2, "container_x", ((int) motionEvent.getX(action2)) + this.f799n);
                C0795s.m801b(b2, "container_y", ((int) motionEvent.getY(action2)) + this.f800o);
                C0795s.m801b(b2, "view_x", (int) motionEvent.getX(action2));
                C0795s.m801b(b2, "view_y", (int) motionEvent.getY(action2));
                new C0812x("AdContainer.on_touch_began", this.f784A.mo10531k(), b2).mo10945d();
                break;
            case 6:
                int action3 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                int x2 = (int) motionEvent.getX(action3);
                int y2 = (int) motionEvent.getY(action3);
                C0795s.m801b(b2, "container_x", ((int) motionEvent.getX(action3)) + this.f799n);
                C0795s.m801b(b2, "container_y", ((int) motionEvent.getY(action3)) + this.f800o);
                C0795s.m801b(b2, "view_x", (int) motionEvent.getX(action3));
                C0795s.m801b(b2, "view_y", (int) motionEvent.getY(action3));
                if (!this.f784A.mo10538p()) {
                    c.mo10621a(b.mo10562b().get(this.f811z));
                }
                if (x2 > 0 && x2 < getWidth() && y2 > 0 && y2 < getHeight()) {
                    new C0812x("AdContainer.on_touch_ended", this.f784A.mo10531k(), b2).mo10945d();
                    break;
                } else {
                    new C0812x("AdContainer.on_touch_cancelled", this.f784A.mo10531k(), b2).mo10945d();
                    break;
                }
                break;
        }
        return true;
    }
}
