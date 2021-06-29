package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.FloatRange;
import android.support.p000v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.adcolony.sdk.C0797u;
import com.iab.omid.library.adcolony.adsession.AdSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.settings.SettingsJsonConstants;

/* renamed from: com.adcolony.sdk.c */
class C0563c extends FrameLayout {

    /* renamed from: A */
    VideoView f227A;

    /* renamed from: a */
    private HashMap<Integer, C0722l0> f228a;

    /* renamed from: b */
    private HashMap<Integer, C0700j0> f229b;

    /* renamed from: c */
    private HashMap<Integer, C0737m0> f230c;

    /* renamed from: d */
    private HashMap<Integer, C0754n> f231d;

    /* renamed from: e */
    private HashMap<Integer, C0790q> f232e;

    /* renamed from: f */
    private HashMap<Integer, Boolean> f233f;

    /* renamed from: g */
    private HashMap<Integer, View> f234g;

    /* renamed from: h */
    private int f235h;

    /* renamed from: i */
    private int f236i;

    /* renamed from: j */
    private int f237j;

    /* renamed from: k */
    private int f238k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public String f239l;

    /* renamed from: m */
    boolean f240m;

    /* renamed from: n */
    boolean f241n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public float f242o = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public double f243p = 0.0d;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public long f244q = 0;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f245r = 0;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f246s = 0;

    /* renamed from: t */
    private ArrayList<C0816z> f247t;

    /* renamed from: u */
    private ArrayList<String> f248u;

    /* renamed from: v */
    private boolean f249v;

    /* renamed from: w */
    private boolean f250w;

    /* renamed from: x */
    private boolean f251x;

    /* renamed from: y */
    private AdSession f252y;

    /* renamed from: z */
    Context f253z;

    /* renamed from: com.adcolony.sdk.c$a */
    class C0564a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Runnable f254a;

        C0564a(Runnable runnable) {
            this.f254a = runnable;
        }

        public void run() {
            while (!C0563c.this.f240m) {
                C0717k0.m515a(this.f254a);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* renamed from: com.adcolony.sdk.c$b */
    class C0565b implements C0816z {
        C0565b() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0563c.this.mo10528i(xVar)) {
                C0563c cVar = C0563c.this;
                cVar.mo10506a((View) cVar.mo10515c(xVar));
            }
        }
    }

    /* renamed from: com.adcolony.sdk.c$c */
    class C0566c implements C0816z {
        C0566c() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0563c.this.mo10528i(xVar)) {
                C0563c.this.mo10524g(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.c$d */
    class C0567d implements C0816z {

        /* renamed from: com.adcolony.sdk.c$d$a */
        class C0568a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0812x f259a;

            C0568a(C0812x xVar) {
                this.f259a = xVar;
            }

            public void run() {
                C0563c cVar = C0563c.this;
                cVar.mo10506a((View) cVar.mo10518d(this.f259a));
            }
        }

        C0567d() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0563c.this.mo10528i(xVar)) {
                C0717k0.m515a((Runnable) new C0568a(xVar));
            }
        }
    }

    /* renamed from: com.adcolony.sdk.c$e */
    class C0569e implements C0816z {

        /* renamed from: com.adcolony.sdk.c$e$a */
        class C0570a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0812x f262a;

            C0570a(C0812x xVar) {
                this.f262a = xVar;
            }

            public void run() {
                C0563c.this.mo10526h(this.f262a);
            }
        }

        C0569e() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0563c.this.mo10528i(xVar)) {
                C0717k0.m515a((Runnable) new C0570a(xVar));
            }
        }
    }

    /* renamed from: com.adcolony.sdk.c$f */
    class C0571f implements C0816z {
        C0571f() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0563c.this.mo10528i(xVar)) {
                C0563c cVar = C0563c.this;
                cVar.mo10506a(cVar.mo10511b(xVar));
            }
        }
    }

    /* renamed from: com.adcolony.sdk.c$g */
    class C0572g implements C0816z {
        C0572g() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0563c.this.mo10528i(xVar)) {
                C0563c.this.mo10522f(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.c$h */
    class C0573h implements C0816z {
        C0573h() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0563c.this.mo10528i(xVar)) {
                C0563c cVar = C0563c.this;
                cVar.mo10506a((View) cVar.mo10503a(xVar));
            }
        }
    }

    /* renamed from: com.adcolony.sdk.c$i */
    class C0574i implements C0816z {
        C0574i() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0563c.this.mo10528i(xVar)) {
                C0563c.this.mo10520e(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.c$j */
    class C0575j implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f268a;

        C0575j(boolean z) {
            this.f268a = z;
        }

        public void run() {
            if (C0563c.this.f244q == 0) {
                long unused = C0563c.this.f244q = System.currentTimeMillis();
            }
            View view = (View) C0563c.this.getParent();
            AdColonyAdView adColonyAdView = C0557a.m88c().mo10633b().mo10562b().get(C0563c.this.f239l);
            C0737m0 webView = adColonyAdView == null ? null : adColonyAdView.getWebView();
            Context b = C0557a.m86b();
            boolean z = false;
            float a = C0768o0.m720a(view, b, true, this.f268a, true, adColonyAdView != null);
            double a2 = b == null ? 0.0d : C0717k0.m502a(C0717k0.m506a(b));
            int a3 = C0717k0.m503a((View) webView);
            int b2 = C0717k0.m520b((View) webView);
            if (!(a3 == C0563c.this.f245r && b2 == C0563c.this.f246s)) {
                z = true;
            }
            if (z) {
                int unused2 = C0563c.this.f245r = a3;
                int unused3 = C0563c.this.f246s = b2;
                C0563c.this.m113a(a3, b2, webView);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (C0563c.this.f244q + 200 < currentTimeMillis) {
                long unused4 = C0563c.this.f244q = currentTimeMillis;
                if (!(C0563c.this.f242o == a && C0563c.this.f243p == a2 && !z)) {
                    C0563c.this.m112a(a, a2);
                }
                float unused5 = C0563c.this.f242o = a;
                double unused6 = C0563c.this.f243p = a2;
            }
        }
    }

    private C0563c(Context context) {
        super(context);
    }

    C0563c(Context context, String str) {
        super(context);
        this.f253z = context;
        this.f239l = str;
        setBackgroundColor(-16777216);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m112a(@FloatRange(from = 0.0d, mo110to = 100.0d) float f, @FloatRange(from = 0.0d, mo110to = 1.0d) double d) {
        JSONObject b = C0795s.m798b();
        C0795s.m801b(b, "id", this.f237j);
        C0795s.m791a(b, "ad_session_id", this.f239l);
        C0795s.m789a(b, "exposure", (double) f);
        C0795s.m789a(b, MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, d);
        new C0812x("AdContainer.on_exposure_change", this.f238k, b).mo10945d();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m113a(int i, int i2, C0737m0 m0Var) {
        float n = C0557a.m88c().mo10647h().mo10737n();
        if (m0Var != null) {
            JSONObject b = C0795s.m798b();
            C0795s.m801b(b, "app_orientation", C0717k0.m535g(C0717k0.m536g()));
            C0795s.m801b(b, SettingsJsonConstants.ICON_WIDTH_KEY, (int) (((float) m0Var.mo10828i()) / n));
            C0795s.m801b(b, SettingsJsonConstants.ICON_HEIGHT_KEY, (int) (((float) m0Var.mo10827h()) / n));
            C0795s.m801b(b, "x", i);
            C0795s.m801b(b, "y", i2);
            C0795s.m791a(b, "ad_session_id", this.f239l);
            new C0812x("MRAID.on_size_change", this.f238k, b).mo10945d();
        }
    }

    /* renamed from: d */
    private void m120d(boolean z) {
        new Thread(new C0564a(new C0575j(z))).start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0790q mo10503a(C0812x xVar) {
        int f = C0795s.m810f(xVar.mo10941b(), "id");
        C0790q qVar = new C0790q(this.f253z, xVar, f, this);
        qVar.mo10909b();
        this.f232e.put(Integer.valueOf(f), qVar);
        this.f234g.put(Integer.valueOf(f), qVar);
        return qVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo10504a() {
        return this.f239l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10505a(int i) {
        this.f236i = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10506a(View view) {
        AdSession adSession = this.f252y;
        if (adSession != null && view != null) {
            adSession.addFriendlyObstruction(view);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10507a(AdSession adSession) {
        this.f252y = adSession;
        mo10508a((Map) this.f234g);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10508a(Map map) {
        if (this.f252y != null && map != null) {
            for (Map.Entry value : map.entrySet()) {
                this.f252y.addFriendlyObstruction((View) value.getValue());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10509a(boolean z) {
        this.f249v = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo10510b() {
        return this.f236i;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"InlinedApi"})
    /* renamed from: b */
    public View mo10511b(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        int f = C0795s.m810f(b, "id");
        if (C0795s.m807d(b, "editable")) {
            C0754n nVar = new C0754n(this.f253z, xVar, f, this);
            nVar.mo10868a();
            this.f231d.put(Integer.valueOf(f), nVar);
            this.f234g.put(Integer.valueOf(f), nVar);
            this.f233f.put(Integer.valueOf(f), true);
            return nVar;
        } else if (!C0795s.m807d(b, "button")) {
            C0700j0 j0Var = new C0700j0(this.f253z, xVar, f, this);
            j0Var.mo10757a();
            this.f229b.put(Integer.valueOf(f), j0Var);
            this.f234g.put(Integer.valueOf(f), j0Var);
            this.f233f.put(Integer.valueOf(f), false);
            return j0Var;
        } else {
            C0700j0 j0Var2 = new C0700j0(this.f253z, 16974145, xVar, f, this);
            j0Var2.mo10757a();
            this.f229b.put(Integer.valueOf(f), j0Var2);
            this.f234g.put(Integer.valueOf(f), j0Var2);
            this.f233f.put(Integer.valueOf(f), false);
            return j0Var2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10512b(int i) {
        this.f235h = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10513b(boolean z) {
        this.f251x = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo10514c() {
        return this.f237j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C0722l0 mo10515c(C0812x xVar) {
        int f = C0795s.m810f(xVar.mo10941b(), "id");
        C0722l0 l0Var = new C0722l0(this.f253z, xVar, f, this);
        l0Var.mo10790d();
        this.f228a.put(Integer.valueOf(f), l0Var);
        this.f234g.put(Integer.valueOf(f), l0Var);
        return l0Var;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo10516c(boolean z) {
        this.f250w = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo10517d() {
        return this.f235h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C0737m0 mo10518d(C0812x xVar) {
        C0737m0 m0Var;
        JSONObject b = xVar.mo10941b();
        int f = C0795s.m810f(b, "id");
        boolean d = C0795s.m807d(b, "is_module");
        C0648h c = C0557a.m88c();
        if (d) {
            m0Var = c.mo10661v().get(Integer.valueOf(C0795s.m810f(b, "module_id")));
            if (m0Var == null) {
                new C0797u.C0798a().mo10920a("Module WebView created with invalid id").mo10922a(C0797u.f1094i);
                return null;
            }
            m0Var.mo10818a(xVar, f, this);
        } else {
            try {
                m0Var = new C0737m0(this.f253z, xVar, f, c.mo10652m().mo10955d(), this);
            } catch (RuntimeException e) {
                C0797u.C0798a aVar = new C0797u.C0798a();
                aVar.mo10920a(e.toString() + ": during WebView initialization.").mo10920a(" Disabling AdColony.").mo10922a(C0797u.f1094i);
                AdColony.disable();
                return null;
            }
        }
        this.f230c.put(Integer.valueOf(f), m0Var);
        this.f234g.put(Integer.valueOf(f), m0Var);
        JSONObject b2 = C0795s.m798b();
        C0795s.m801b(b2, "module_id", m0Var.mo10494d());
        C0795s.m801b(b2, "mraid_module_id", m0Var.mo10493c());
        xVar.mo10940a(b2).mo10945d();
        return m0Var;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public HashMap<Integer, View> mo10519e() {
        return this.f234g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo10520e(C0812x xVar) {
        int f = C0795s.m810f(xVar.mo10941b(), "id");
        View remove = this.f234g.remove(Integer.valueOf(f));
        C0790q remove2 = this.f232e.remove(Integer.valueOf(f));
        if (remove == null || remove2 == null) {
            C0580d b = C0557a.m88c().mo10633b();
            String c = xVar.mo10944c();
            b.mo10560a(c, "" + f);
            return false;
        }
        removeView(remove2);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public HashMap<Integer, C0754n> mo10521f() {
        return this.f231d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo10522f(C0812x xVar) {
        int f = C0795s.m810f(xVar.mo10941b(), "id");
        View remove = this.f234g.remove(Integer.valueOf(f));
        TextView remove2 = this.f233f.remove(Integer.valueOf(this.f237j)).booleanValue() ? this.f231d.remove(Integer.valueOf(f)) : this.f229b.remove(Integer.valueOf(f));
        if (remove == null || remove2 == null) {
            C0580d b = C0557a.m88c().mo10633b();
            String c = xVar.mo10944c();
            b.mo10560a(c, "" + f);
            return false;
        }
        removeView(remove2);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public HashMap<Integer, Boolean> mo10523g() {
        return this.f233f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo10524g(C0812x xVar) {
        int f = C0795s.m810f(xVar.mo10941b(), "id");
        View remove = this.f234g.remove(Integer.valueOf(f));
        C0722l0 remove2 = this.f228a.remove(Integer.valueOf(f));
        if (remove == null || remove2 == null) {
            C0580d b = C0557a.m88c().mo10633b();
            String c = xVar.mo10944c();
            b.mo10560a(c, "" + f);
            return false;
        }
        if (remove2.mo10789c()) {
            remove2.mo10795i();
        }
        remove2.mo10787a();
        removeView(remove2);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public HashMap<Integer, C0790q> mo10525h() {
        return this.f232e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo10526h(C0812x xVar) {
        int f = C0795s.m810f(xVar.mo10941b(), "id");
        C0648h c = C0557a.m88c();
        View remove = this.f234g.remove(Integer.valueOf(f));
        C0737m0 remove2 = this.f230c.remove(Integer.valueOf(f));
        if (remove2 == null || remove == null) {
            C0580d b = c.mo10633b();
            String c2 = xVar.mo10944c();
            b.mo10560a(c2, "" + f);
            return false;
        }
        c.mo10652m().mo10946a(remove2.mo10494d());
        removeView(remove2);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public ArrayList<C0816z> mo10527i() {
        return this.f247t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo10528i(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        return C0795s.m810f(b, "container_id") == this.f237j && C0795s.m812h(b, "ad_session_id").equals(this.f239l);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public ArrayList<String> mo10529j() {
        return this.f248u;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo10530j(C0812x xVar) {
        this.f228a = new HashMap<>();
        this.f229b = new HashMap<>();
        this.f230c = new HashMap<>();
        this.f231d = new HashMap<>();
        this.f232e = new HashMap<>();
        this.f233f = new HashMap<>();
        this.f234g = new HashMap<>();
        this.f247t = new ArrayList<>();
        this.f248u = new ArrayList<>();
        JSONObject b = xVar.mo10941b();
        if (C0795s.m807d(b, "transparent")) {
            setBackgroundColor(0);
        }
        this.f237j = C0795s.m810f(b, "id");
        this.f235h = C0795s.m810f(b, SettingsJsonConstants.ICON_WIDTH_KEY);
        this.f236i = C0795s.m810f(b, SettingsJsonConstants.ICON_HEIGHT_KEY);
        this.f238k = C0795s.m810f(b, "module_id");
        this.f241n = C0795s.m807d(b, "viewability_enabled");
        this.f249v = this.f237j == 1;
        C0648h c = C0557a.m88c();
        if (this.f235h == 0 && this.f236i == 0) {
            this.f235h = c.mo10647h().mo10742s();
            this.f236i = c.mo10656q().getMultiWindowEnabled() ? c.mo10647h().mo10741r() - C0717k0.m528d(C0557a.m86b()) : c.mo10647h().mo10741r();
        } else {
            setLayoutParams(new FrameLayout.LayoutParams(this.f235h, this.f236i));
        }
        this.f247t.add(C0557a.m80a("VideoView.create", (C0816z) new C0565b(), true));
        this.f247t.add(C0557a.m80a("VideoView.destroy", (C0816z) new C0566c(), true));
        this.f247t.add(C0557a.m80a("WebView.create", (C0816z) new C0567d(), true));
        this.f247t.add(C0557a.m80a("WebView.destroy", (C0816z) new C0569e(), true));
        this.f247t.add(C0557a.m80a("TextView.create", (C0816z) new C0571f(), true));
        this.f247t.add(C0557a.m80a("TextView.destroy", (C0816z) new C0572g(), true));
        this.f247t.add(C0557a.m80a("ImageView.create", (C0816z) new C0573h(), true));
        this.f247t.add(C0557a.m80a("ImageView.destroy", (C0816z) new C0574i(), true));
        this.f248u.add("VideoView.create");
        this.f248u.add("VideoView.destroy");
        this.f248u.add("WebView.create");
        this.f248u.add("WebView.destroy");
        this.f248u.add("TextView.create");
        this.f248u.add("TextView.destroy");
        this.f248u.add("ImageView.create");
        this.f248u.add("ImageView.destroy");
        VideoView videoView = new VideoView(this.f253z);
        this.f227A = videoView;
        videoView.setVisibility(8);
        addView(this.f227A);
        setClipToPadding(false);
        if (this.f241n) {
            m120d(C0795s.m807d(xVar.mo10941b(), "advanced_viewability"));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public int mo10531k() {
        return this.f238k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public HashMap<Integer, C0700j0> mo10532l() {
        return this.f229b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public HashMap<Integer, C0722l0> mo10533m() {
        return this.f228a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public HashMap<Integer, C0737m0> mo10534n() {
        return this.f230c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public boolean mo10535o() {
        return this.f250w;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0 && action != 1 && action != 3 && action != 2 && action != 5 && action != 6) {
            return false;
        }
        C0648h c = C0557a.m88c();
        C0580d b = c.mo10633b();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        JSONObject b2 = C0795s.m798b();
        C0795s.m801b(b2, "view_id", -1);
        C0795s.m791a(b2, "ad_session_id", this.f239l);
        C0795s.m801b(b2, "container_x", x);
        C0795s.m801b(b2, "container_y", y);
        C0795s.m801b(b2, "view_x", x);
        C0795s.m801b(b2, "view_y", y);
        C0795s.m801b(b2, "id", this.f237j);
        switch (action) {
            case 0:
                new C0812x("AdContainer.on_touch_began", this.f238k, b2).mo10945d();
                break;
            case 1:
                if (!this.f249v) {
                    c.mo10621a(b.mo10562b().get(this.f239l));
                }
                new C0812x("AdContainer.on_touch_ended", this.f238k, b2).mo10945d();
                break;
            case 2:
                new C0812x("AdContainer.on_touch_moved", this.f238k, b2).mo10945d();
                break;
            case 3:
                new C0812x("AdContainer.on_touch_cancelled", this.f238k, b2).mo10945d();
                break;
            case 5:
                int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                C0795s.m801b(b2, "container_x", (int) motionEvent.getX(action2));
                C0795s.m801b(b2, "container_y", (int) motionEvent.getY(action2));
                C0795s.m801b(b2, "view_x", (int) motionEvent.getX(action2));
                C0795s.m801b(b2, "view_y", (int) motionEvent.getY(action2));
                new C0812x("AdContainer.on_touch_began", this.f238k, b2).mo10945d();
                break;
            case 6:
                int action3 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                C0795s.m801b(b2, "container_x", (int) motionEvent.getX(action3));
                C0795s.m801b(b2, "container_y", (int) motionEvent.getY(action3));
                C0795s.m801b(b2, "view_x", (int) motionEvent.getX(action3));
                C0795s.m801b(b2, "view_y", (int) motionEvent.getY(action3));
                C0795s.m801b(b2, "x", (int) motionEvent.getX(action3));
                C0795s.m801b(b2, "y", (int) motionEvent.getY(action3));
                if (!this.f249v) {
                    c.mo10621a(b.mo10562b().get(this.f239l));
                }
                new C0812x("AdContainer.on_touch_ended", this.f238k, b2).mo10945d();
                break;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public boolean mo10538p() {
        return this.f249v;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public boolean mo10539q() {
        return this.f251x;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo10540r() {
        JSONObject b = C0795s.m798b();
        C0795s.m791a(b, "id", this.f239l);
        new C0812x("AdSession.on_error", this.f238k, b).mo10945d();
    }
}
