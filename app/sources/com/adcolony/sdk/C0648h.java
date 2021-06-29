package com.adcolony.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.adcolony.sdk.C0720l;
import com.adcolony.sdk.C0797u;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.iab.omid.library.adcolony.Omid;
import com.iab.omid.library.adcolony.adsession.Partner;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.settings.SettingsJsonConstants;

/* renamed from: com.adcolony.sdk.h */
class C0648h implements C0720l.C0721a {

    /* renamed from: U */
    static final String f660U = "026ae9c9824b3e483fa6c71fa88f57ae27816141";

    /* renamed from: V */
    static final String f661V = "7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5";

    /* renamed from: W */
    static String f662W = "http://=";

    /* renamed from: X */
    private static volatile String f663X = "";

    /* renamed from: A */
    private String f664A;

    /* renamed from: B */
    private String f665B;

    /* renamed from: C */
    private String f666C = "";

    /* renamed from: D */
    private boolean f667D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public boolean f668E;

    /* renamed from: F */
    private boolean f669F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f670G;

    /* renamed from: H */
    boolean f671H;

    /* renamed from: I */
    private boolean f672I;

    /* renamed from: J */
    private boolean f673J;

    /* renamed from: K */
    private boolean f674K;

    /* renamed from: L */
    private boolean f675L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public boolean f676M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public boolean f677N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public boolean f678O;

    /* renamed from: P */
    private int f679P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public int f680Q = 1;

    /* renamed from: R */
    private final int f681R = 120;

    /* renamed from: S */
    private Application.ActivityLifecycleCallbacks f682S;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public Partner f683T = null;

    /* renamed from: a */
    private C0672i f684a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C0813y f685b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C0733m f686c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C0644f0 f687d;

    /* renamed from: e */
    private C0580d f688e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C0711k f689f;

    /* renamed from: g */
    private C0771p f690g;

    /* renamed from: h */
    private C0674i0 f691h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C0647g0 f692i;

    /* renamed from: j */
    private C0801w f693j;

    /* renamed from: k */
    C0694j f694k;

    /* renamed from: l */
    C0562b0 f695l;

    /* renamed from: m */
    private C0563c f696m;

    /* renamed from: n */
    private AdColonyAdView f697n;

    /* renamed from: o */
    private AdColonyInterstitial f698o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public AdColonyRewardListener f699p;

    /* renamed from: q */
    private HashMap<String, AdColonyCustomMessageListener> f700q = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: r */
    public AdColonyAppOptions f701r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public C0812x f702s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f703t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public C0812x f704u;

    /* renamed from: v */
    private JSONObject f705v;

    /* renamed from: w */
    private HashMap<String, AdColonyZone> f706w = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: x */
    public HashMap<Integer, C0737m0> f707x = new HashMap<>();

    /* renamed from: y */
    private String f708y;

    /* renamed from: z */
    private String f709z;

    /* renamed from: com.adcolony.sdk.h$a */
    class C0649a implements C0816z {
        C0649a() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            int f = C0795s.m810f(xVar.mo10941b(), "number");
            JSONObject b = C0795s.m798b();
            C0795s.m792a(b, "uuids", C0717k0.m511a(f));
            xVar.mo10940a(b).mo10945d();
        }
    }

    /* renamed from: com.adcolony.sdk.h$b */
    class C0650b implements C0816z {

        /* renamed from: com.adcolony.sdk.h$b$a */
        class C0651a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Context f712a;

            /* renamed from: b */
            final /* synthetic */ C0812x f713b;

            C0651a(Context context, C0812x xVar) {
                this.f712a = context;
                this.f713b = xVar;
            }

            public void run() {
                C0648h.this.mo10631a(this.f712a, this.f713b);
            }
        }

        C0650b() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            Context b = C0557a.m86b();
            if (b != null) {
                C0717k0.f836b.execute(new C0651a(b, xVar));
            }
        }
    }

    /* renamed from: com.adcolony.sdk.h$c */
    class C0652c implements C0816z {
        C0652c() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0648h.this.mo10647h().mo10724b(C0795s.m812h(xVar.mo10941b(), "version"));
            C0640e0 e0Var = C0801w.f1120n;
            if (e0Var != null) {
                e0Var.mo10590e(C0648h.this.mo10647h().mo10733j());
            }
            new C0797u.C0798a().mo10920a("Controller version: ").mo10920a(C0648h.this.mo10647h().mo10733j()).mo10922a(C0797u.f1091f);
        }
    }

    /* renamed from: com.adcolony.sdk.h$d */
    class C0653d implements Runnable {
        C0653d() {
        }

        public void run() {
            Context b = C0557a.m86b();
            if (!C0648h.this.f678O && b != null) {
                try {
                    boolean unused = C0648h.this.f678O = Omid.activateWithOmidApiVersion(Omid.getVersion(), b.getApplicationContext());
                } catch (IllegalArgumentException unused2) {
                    new C0797u.C0798a().mo10920a("IllegalArgumentException when activating Omid").mo10922a(C0797u.f1095j);
                    boolean unused3 = C0648h.this.f678O = false;
                }
            }
            if (C0648h.this.f678O && C0648h.this.f683T == null) {
                try {
                    Partner unused4 = C0648h.this.f683T = Partner.createPartner("AdColony", "4.1.4");
                } catch (IllegalArgumentException unused5) {
                    new C0797u.C0798a().mo10920a("IllegalArgumentException when creating Omid Partner").mo10922a(C0797u.f1095j);
                    boolean unused6 = C0648h.this.f678O = false;
                }
            }
        }
    }

    /* renamed from: com.adcolony.sdk.h$e */
    class C0654e implements Runnable {
        C0654e() {
        }

        public void run() {
            JSONObject b = C0795s.m798b();
            C0795s.m791a(b, "url", C0648h.f662W);
            C0795s.m791a(b, FirebaseAnalytics.Param.CONTENT_TYPE, "application/json");
            C0795s.m791a(b, FirebaseAnalytics.Param.CONTENT, C0648h.this.mo10647h().mo10738o().toString());
            new C0797u.C0798a().mo10920a("Launch: ").mo10920a(C0648h.this.mo10647h().mo10738o().toString()).mo10922a(C0797u.f1089d);
            new C0797u.C0798a().mo10920a("Saving Launch to ").mo10920a(C0648h.this.f692i.mo10610a()).mo10920a(C0648h.f660U).mo10922a(C0797u.f1091f);
            C0648h.this.f686c.mo10813a(new C0720l(new C0812x("WebServices.post", 0, b), C0648h.this));
        }
    }

    /* renamed from: com.adcolony.sdk.h$f */
    class C0655f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f718a;

        /* renamed from: b */
        final /* synthetic */ boolean f719b;

        /* renamed from: c */
        final /* synthetic */ C0812x f720c;

        C0655f(Context context, boolean z, C0812x xVar) {
            this.f718a = context;
            this.f719b = z;
            this.f720c = xVar;
        }

        public void run() {
            C0737m0 m0Var = new C0737m0(this.f718a.getApplicationContext(), C0648h.this.f685b.mo10955d(), this.f719b);
            m0Var.mo10821a(true, this.f720c);
            C0648h.this.f707x.put(Integer.valueOf(m0Var.mo10494d()), m0Var);
        }
    }

    /* renamed from: com.adcolony.sdk.h$g */
    class C0656g implements Runnable {

        /* renamed from: com.adcolony.sdk.h$g$a */
        class C0657a implements Runnable {
            C0657a() {
            }

            public void run() {
                if (C0557a.m88c().mo10658s().mo10601d()) {
                    C0648h.this.m274E();
                }
            }
        }

        C0656g() {
        }

        public void run() {
            new Handler().postDelayed(new C0657a(), (long) (C0648h.this.f680Q * 1000));
        }
    }

    /* renamed from: com.adcolony.sdk.h$h */
    class C0658h implements Runnable {
        C0658h() {
        }

        public void run() {
            boolean f = C0648h.this.m275F();
            C0797u.C0798a aVar = new C0797u.C0798a();
            aVar.mo10920a("Loaded library. Success=" + f).mo10922a(C0797u.f1089d);
        }
    }

    /* renamed from: com.adcolony.sdk.h$i */
    class C0659i implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0737m0 f725a;

        C0659i(C0737m0 m0Var) {
            this.f725a = m0Var;
        }

        public void run() {
            C0737m0 m0Var = this.f725a;
            if (m0Var != null && m0Var.mo10839s()) {
                this.f725a.loadUrl("about:blank");
                this.f725a.clearCache(true);
                this.f725a.removeAllViews();
                this.f725a.mo10820a(true);
                this.f725a.destroy();
            }
            if (C0648h.this.f704u != null) {
                C0648h.this.f704u.mo10945d();
                C0812x unused = C0648h.this.f704u = null;
                boolean unused2 = C0648h.this.f703t = false;
            }
        }
    }

    /* renamed from: com.adcolony.sdk.h$j */
    class C0660j implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0812x f727a;

        C0660j(C0812x xVar) {
            this.f727a = xVar;
        }

        public void run() {
            C0648h.this.f699p.onReward(new AdColonyReward(this.f727a));
        }
    }

    /* renamed from: com.adcolony.sdk.h$k */
    class C0661k implements C0816z {
        C0661k() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0648h.this.mo10632a(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.h$l */
    class C0662l implements Application.ActivityLifecycleCallbacks {
        C0662l() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (!C0648h.this.f687d.mo10601d()) {
                C0648h.this.f687d.mo10598c(true);
            }
            C0557a.m81a((Context) activity);
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            C0557a.f212d = false;
            C0648h.this.f687d.mo10600d(false);
            C0648h.this.f687d.mo10603e(true);
            C0557a.m88c().mo10647h().mo10716J();
        }

        public void onActivityResumed(Activity activity) {
            ScheduledExecutorService scheduledExecutorService;
            C0557a.f212d = true;
            C0557a.m81a((Context) activity);
            Context b = C0557a.m86b();
            if (b == null || !C0648h.this.f687d.mo10597b() || !(b instanceof C0560b) || ((C0560b) b).f220e) {
                new C0797u.C0798a().mo10920a("onActivityResumed() Activity Lifecycle Callback").mo10922a(C0797u.f1091f);
                C0557a.m81a((Context) activity);
                if (C0648h.this.f702s != null) {
                    C0648h.this.f702s.mo10940a(C0648h.this.f702s.mo10941b()).mo10945d();
                    C0812x unused = C0648h.this.f702s = null;
                }
                boolean unused2 = C0648h.this.f668E = false;
                C0648h.this.f687d.mo10600d(true);
                C0648h.this.f687d.mo10603e(true);
                C0648h.this.f687d.mo10604f(false);
                C0648h hVar = C0648h.this;
                if (hVar.f671H && !hVar.f687d.mo10601d()) {
                    C0648h.this.f687d.mo10598c(true);
                }
                C0648h.this.f689f.mo10774c();
                C0640e0 e0Var = C0801w.f1120n;
                if (e0Var == null || (scheduledExecutorService = e0Var.f620b) == null || scheduledExecutorService.isShutdown() || C0801w.f1120n.f620b.isTerminated()) {
                    AdColony.m13a((Context) activity, C0557a.m88c().f701r);
                    return;
                }
                return;
            }
            new C0797u.C0798a().mo10920a("Ignoring onActivityResumed").mo10922a(C0797u.f1091f);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    /* renamed from: com.adcolony.sdk.h$m */
    class C0663m implements C0816z {
        C0663m() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0648h.this.m301f(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.h$n */
    class C0664n implements C0816z {
        C0664n() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            boolean unused = C0648h.this.f670G = true;
            if (C0648h.this.f676M) {
                JSONObject b = C0795s.m798b();
                JSONObject b2 = C0795s.m798b();
                C0795s.m791a(b2, "app_version", C0717k0.m531e());
                C0795s.m793a(b, "app_bundle_info", b2);
                new C0812x("AdColony.on_update", 1, b).mo10945d();
                boolean unused2 = C0648h.this.f676M = false;
            }
            if (C0648h.this.f677N) {
                new C0812x("AdColony.on_install", 1).mo10945d();
            }
            if (C0801w.f1120n != null) {
                C0801w.f1120n.mo10591f(C0795s.m812h(xVar.mo10941b(), "app_session_id"));
            }
            if (AdColonyEventTracker.m42a()) {
                AdColonyEventTracker.m44b();
            }
            int a = C0795s.m777a(xVar.mo10941b(), "concurrent_requests", 4);
            if (a != C0648h.this.f686c.mo10811a()) {
                C0648h.this.f686c.mo10812a(a);
            }
            C0648h.this.m276G();
        }
    }

    /* renamed from: com.adcolony.sdk.h$o */
    class C0665o implements C0816z {
        C0665o() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0648h.this.m304g(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.h$p */
    class C0666p implements C0816z {
        C0666p() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0648h.this.mo10642d(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.h$q */
    class C0667q implements C0816z {
        C0667q() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0648h.this.mo10644e(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.h$r */
    class C0668r implements C0816z {
        C0668r() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            boolean unused = C0648h.this.m285a(true, true);
        }
    }

    /* renamed from: com.adcolony.sdk.h$s */
    class C0669s implements C0816z {
        C0669s() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            JSONObject b = C0795s.m798b();
            C0795s.m791a(b, "sha1", C0717k0.m522b(C0795s.m812h(xVar.mo10941b(), DataBufferSafeParcelable.DATA_FIELD)));
            xVar.mo10940a(b).mo10945d();
        }
    }

    /* renamed from: com.adcolony.sdk.h$t */
    class C0670t implements C0816z {
        C0670t() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            JSONObject b = C0795s.m798b();
            C0795s.m801b(b, "crc32", C0717k0.m505a(C0795s.m812h(xVar.mo10941b(), DataBufferSafeParcelable.DATA_FIELD)));
            xVar.mo10940a(b).mo10945d();
        }
    }

    C0648h() {
    }

    /* renamed from: D */
    static String m273D() {
        return f663X;
    }

    /* access modifiers changed from: private */
    /* renamed from: E */
    public void m274E() {
        new Thread(new C0654e()).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: F */
    public boolean m275F() {
        this.f685b.mo10948a();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: G */
    public void m276G() {
        JSONObject b = C0795s.m798b();
        C0795s.m791a(b, AppMeasurement.Param.TYPE, "AdColony.on_configuration_completed");
        JSONArray jSONArray = new JSONArray();
        for (String put : mo10662w().keySet()) {
            jSONArray.put(put);
        }
        JSONObject b2 = C0795s.m798b();
        C0795s.m792a(b2, "zone_ids", jSONArray);
        C0795s.m793a(b, SettingsJsonConstants.PROMPT_MESSAGE_KEY, b2);
        new C0812x("CustomMessage.controller_send", 0, b).mo10945d();
    }

    /* renamed from: H */
    private void m277H() {
        Context b = C0557a.m86b();
        if (b != null && this.f682S == null && Build.VERSION.SDK_INT > 14) {
            this.f682S = new C0662l();
            (b instanceof Application ? (Application) b : ((Activity) b).getApplication()).registerActivityLifecycleCallbacks(this.f682S);
        }
    }

    /* renamed from: I */
    private void m278I() {
        if (C0557a.m88c().mo10658s().mo10601d()) {
            int i = this.f679P + 1;
            this.f679P = i;
            int i2 = this.f680Q * i;
            int i3 = 120;
            if (i2 <= 120) {
                i3 = i2;
            }
            this.f680Q = i3;
            C0717k0.m515a((Runnable) new C0656g());
            return;
        }
        new C0797u.C0798a().mo10920a("Max launch server download attempts hit, or AdColony is no longer").mo10920a(" active.").mo10922a(C0797u.f1093h);
    }

    /* renamed from: a */
    private boolean m284a(JSONObject jSONObject) {
        if (!this.f672I) {
            new C0797u.C0798a().mo10920a("Non-standard launch. Downloading new controller.").mo10922a(C0797u.f1093h);
            return true;
        }
        JSONObject jSONObject2 = this.f705v;
        if (jSONObject2 != null && C0795s.m812h(C0795s.m811g(jSONObject2, "controller"), "sha1").equals(C0795s.m812h(C0795s.m811g(jSONObject, "controller"), "sha1"))) {
            return false;
        }
        new C0797u.C0798a().mo10920a("Controller sha1 does not match, downloading new controller.").mo10922a(C0797u.f1093h);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m285a(boolean z, boolean z2) {
        if (!C0557a.m89d()) {
            return false;
        }
        this.f675L = z2;
        this.f672I = z;
        if (z && !z2 && !m275F()) {
            return false;
        }
        m274E();
        return true;
    }

    /* renamed from: b */
    private void m288b(JSONObject jSONObject) {
        if (!C0737m0.f923N) {
            JSONObject g = C0795s.m811g(jSONObject, "logging");
            C0801w.f1117k = C0795s.m777a(g, "send_level", 1);
            C0801w.f1107a = C0795s.m807d(g, "log_private");
            C0801w.f1115i = C0795s.m777a(g, "print_level", 3);
            this.f693j.mo10936b(C0795s.m803c(g, "modules"));
        }
        mo10647h().mo10721a(C0795s.m811g(jSONObject, "metadata"));
        this.f666C = C0795s.m812h(C0795s.m811g(jSONObject, "controller"), "version");
    }

    /* renamed from: b */
    private boolean m290b(String str) {
        Context b = C0557a.m86b();
        if (b == null) {
            return false;
        }
        File file = new File(b.getFilesDir().getAbsolutePath() + "/adc3/" + f661V);
        if (file.exists()) {
            return C0717k0.m517a(str, file);
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        new java.io.File(r3.f692i.mo10610a() + f660U).delete();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0047 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m294c(org.json.JSONObject r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0014
            com.adcolony.sdk.u$a r4 = new com.adcolony.sdk.u$a
            r4.<init>()
            java.lang.String r1 = "Launch response verification failed - response is null or unknown"
            com.adcolony.sdk.u$a r4 = r4.mo10920a((java.lang.String) r1)
            com.adcolony.sdk.u r1 = com.adcolony.sdk.C0797u.f1091f
            r4.mo10922a((com.adcolony.sdk.C0797u) r1)
            return r0
        L_0x0014:
            java.lang.String r1 = "controller"
            org.json.JSONObject r1 = com.adcolony.sdk.C0795s.m811g(r4, r1)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r2 = "url"
            java.lang.String r2 = com.adcolony.sdk.C0795s.m812h(r1, r2)     // Catch:{ Exception -> 0x0047 }
            r3.f709z = r2     // Catch:{ Exception -> 0x0047 }
            java.lang.String r2 = "sha1"
            java.lang.String r1 = com.adcolony.sdk.C0795s.m812h(r1, r2)     // Catch:{ Exception -> 0x0047 }
            r3.f664A = r1     // Catch:{ Exception -> 0x0047 }
            java.lang.String r1 = "status"
            java.lang.String r1 = com.adcolony.sdk.C0795s.m812h(r4, r1)     // Catch:{ Exception -> 0x0047 }
            r3.f665B = r1     // Catch:{ Exception -> 0x0047 }
            java.lang.String r1 = "pie"
            java.lang.String r1 = com.adcolony.sdk.C0795s.m812h(r4, r1)     // Catch:{ Exception -> 0x0047 }
            f663X = r1     // Catch:{ Exception -> 0x0047 }
            boolean r1 = com.adcolony.sdk.AdColonyEventTracker.m42a()     // Catch:{ Exception -> 0x0047 }
            if (r1 == 0) goto L_0x0043
            com.adcolony.sdk.AdColonyEventTracker.m44b()     // Catch:{ Exception -> 0x0047 }
        L_0x0043:
            r3.m288b((org.json.JSONObject) r4)     // Catch:{ Exception -> 0x0047 }
            goto L_0x0068
        L_0x0047:
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0067 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0067 }
            r1.<init>()     // Catch:{ Exception -> 0x0067 }
            com.adcolony.sdk.g0 r2 = r3.f692i     // Catch:{ Exception -> 0x0067 }
            java.lang.String r2 = r2.mo10610a()     // Catch:{ Exception -> 0x0067 }
            r1.append(r2)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r2 = "026ae9c9824b3e483fa6c71fa88f57ae27816141"
            r1.append(r2)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0067 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0067 }
            r4.delete()     // Catch:{ Exception -> 0x0067 }
            goto L_0x0068
        L_0x0067:
        L_0x0068:
            java.lang.String r4 = r3.f665B
            java.lang.String r1 = "disable"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x00af
            boolean r4 = com.adcolony.sdk.C0737m0.f923N
            if (r4 != 0) goto L_0x00af
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0095 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0095 }
            r1.<init>()     // Catch:{ Exception -> 0x0095 }
            com.adcolony.sdk.g0 r2 = r3.f692i     // Catch:{ Exception -> 0x0095 }
            java.lang.String r2 = r2.mo10610a()     // Catch:{ Exception -> 0x0095 }
            r1.append(r2)     // Catch:{ Exception -> 0x0095 }
            java.lang.String r2 = "7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5"
            r1.append(r2)     // Catch:{ Exception -> 0x0095 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0095 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0095 }
            r4.delete()     // Catch:{ Exception -> 0x0095 }
        L_0x0095:
            com.adcolony.sdk.u$a r4 = new com.adcolony.sdk.u$a
            r4.<init>()
            java.lang.String r1 = "Launch server response with disabled status. Disabling AdColony "
            com.adcolony.sdk.u$a r4 = r4.mo10920a((java.lang.String) r1)
            java.lang.String r1 = "until next launch."
            com.adcolony.sdk.u$a r4 = r4.mo10920a((java.lang.String) r1)
            com.adcolony.sdk.u r1 = com.adcolony.sdk.C0797u.f1093h
            r4.mo10922a((com.adcolony.sdk.C0797u) r1)
            com.adcolony.sdk.AdColony.disable()
            return r0
        L_0x00af:
            java.lang.String r4 = r3.f709z
            java.lang.String r1 = ""
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x00c3
            java.lang.String r4 = r3.f665B
            java.lang.String r1 = ""
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x00de
        L_0x00c3:
            boolean r4 = com.adcolony.sdk.C0737m0.f923N
            if (r4 != 0) goto L_0x00de
            com.adcolony.sdk.u$a r4 = new com.adcolony.sdk.u$a
            r4.<init>()
            java.lang.String r1 = "Missing controller status or URL. Disabling AdColony until next "
            com.adcolony.sdk.u$a r4 = r4.mo10920a((java.lang.String) r1)
            java.lang.String r1 = "launch."
            com.adcolony.sdk.u$a r4 = r4.mo10920a((java.lang.String) r1)
            com.adcolony.sdk.u r1 = com.adcolony.sdk.C0797u.f1094i
            r4.mo10922a((com.adcolony.sdk.C0797u) r1)
            return r0
        L_0x00de:
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0648h.m294c(org.json.JSONObject):boolean");
    }

    /* renamed from: e */
    private boolean m300e(boolean z) {
        return m285a(z, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m301f(C0812x xVar) {
        mo10630a(C0795s.m810f(xVar.mo10941b(), "id"));
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m304g(C0812x xVar) {
        AdColonyAppOptions adColonyAppOptions = this.f701r;
        JSONObject jSONObject = adColonyAppOptions.f159d;
        C0795s.m791a(jSONObject, "app_id", adColonyAppOptions.f156a);
        C0795s.m792a(jSONObject, "zone_ids", this.f701r.f158c);
        JSONObject b = C0795s.m798b();
        C0795s.m793a(b, "options", jSONObject);
        xVar.mo10940a(b).mo10945d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public boolean mo10617A() {
        return this.f670G;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public boolean mo10618B() {
        return this.f667D;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C */
    public boolean mo10619C() {
        return this.f703t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Context mo10620a() {
        return C0557a.m86b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10621a(AdColonyAdView adColonyAdView) {
        this.f697n = adColonyAdView;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10622a(AdColonyAppOptions adColonyAppOptions) {
        synchronized (this.f688e.mo10556a()) {
            for (Map.Entry<String, AdColonyInterstitial> value : this.f688e.mo10556a().entrySet()) {
                AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) value.getValue();
                AdColonyInterstitialListener listener = adColonyInterstitial.getListener();
                adColonyInterstitial.mo10417a(true);
                if (listener != null) {
                    listener.onExpiring(adColonyInterstitial);
                }
            }
            this.f688e.mo10556a().clear();
        }
        this.f670G = false;
        mo10630a(1);
        this.f706w.clear();
        this.f701r = adColonyAppOptions;
        this.f685b.mo10948a();
        m285a(true, true);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0101  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo10623a(com.adcolony.sdk.AdColonyAppOptions r4, boolean r5) {
        /*
            r3 = this;
            r3.f669F = r5
            r3.f701r = r4
            com.adcolony.sdk.y r0 = new com.adcolony.sdk.y
            r0.<init>()
            r3.f685b = r0
            com.adcolony.sdk.i r0 = new com.adcolony.sdk.i
            r0.<init>()
            r3.f684a = r0
            com.adcolony.sdk.m r0 = new com.adcolony.sdk.m
            r0.<init>()
            r3.f686c = r0
            r0.mo10815b()
            com.adcolony.sdk.f0 r0 = new com.adcolony.sdk.f0
            r0.<init>()
            r3.f687d = r0
            r0.mo10594a()
            com.adcolony.sdk.d r0 = new com.adcolony.sdk.d
            r0.<init>()
            r3.f688e = r0
            r0.mo10566e()
            com.adcolony.sdk.k r0 = new com.adcolony.sdk.k
            r0.<init>()
            r3.f689f = r0
            com.adcolony.sdk.p r0 = new com.adcolony.sdk.p
            r0.<init>()
            r3.f690g = r0
            r0.mo10894b()
            com.adcolony.sdk.w r0 = new com.adcolony.sdk.w
            r0.<init>()
            r3.f693j = r0
            com.adcolony.sdk.C0801w.m841a()
            com.adcolony.sdk.g0 r0 = new com.adcolony.sdk.g0
            r0.<init>()
            r3.f692i = r0
            r0.mo10614e()
            com.adcolony.sdk.i0 r0 = new com.adcolony.sdk.i0
            r0.<init>()
            r3.f691h = r0
            r0.mo10689a()
            com.adcolony.sdk.j r0 = new com.adcolony.sdk.j
            r0.<init>()
            r3.f694k = r0
            r0.mo10717K()
            com.adcolony.sdk.b0 r0 = new com.adcolony.sdk.b0
            r0.<init>()
            r3.f695l = r0
            java.lang.String r0 = r0.mo10500a()
            r3.f708y = r0
            android.content.Context r0 = com.adcolony.sdk.C0557a.m86b()
            com.adcolony.sdk.AdColony.m13a((android.content.Context) r0, (com.adcolony.sdk.AdColonyAppOptions) r4)
            r4 = 0
            r0 = 1
            if (r5 != 0) goto L_0x0129
            java.io.File r5 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.adcolony.sdk.g0 r2 = r3.f692i
            java.lang.String r2 = r2.mo10610a()
            r1.append(r2)
            java.lang.String r2 = "026ae9c9824b3e483fa6c71fa88f57ae27816141"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r5.<init>(r1)
            boolean r5 = r5.exists()
            r3.f673J = r5
            java.io.File r5 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.adcolony.sdk.g0 r2 = r3.f692i
            java.lang.String r2 = r2.mo10610a()
            r1.append(r2)
            java.lang.String r2 = "7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r5.<init>(r1)
            boolean r5 = r5.exists()
            r3.f674K = r5
            boolean r1 = r3.f673J
            if (r1 == 0) goto L_0x00fa
            if (r5 == 0) goto L_0x00fa
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            com.adcolony.sdk.g0 r1 = r3.f692i
            java.lang.String r1 = r1.mo10610a()
            r5.append(r1)
            java.lang.String r1 = "026ae9c9824b3e483fa6c71fa88f57ae27816141"
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            org.json.JSONObject r5 = com.adcolony.sdk.C0795s.m804c(r5)
            java.lang.String r1 = "sdkVersion"
            java.lang.String r5 = com.adcolony.sdk.C0795s.m812h(r5, r1)
            com.adcolony.sdk.j r1 = r3.f694k
            java.lang.String r1 = r1.mo10711E()
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x00fa
            r5 = 1
            goto L_0x00fb
        L_0x00fa:
            r5 = 0
        L_0x00fb:
            r3.f672I = r5
            boolean r5 = r3.f673J
            if (r5 == 0) goto L_0x0121
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            com.adcolony.sdk.g0 r1 = r3.f692i
            java.lang.String r1 = r1.mo10610a()
            r5.append(r1)
            java.lang.String r1 = "026ae9c9824b3e483fa6c71fa88f57ae27816141"
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            org.json.JSONObject r5 = com.adcolony.sdk.C0795s.m804c(r5)
            r3.f705v = r5
            r3.m288b((org.json.JSONObject) r5)
        L_0x0121:
            boolean r5 = r3.f672I
            r3.m300e((boolean) r5)
            r3.m277H()
        L_0x0129:
            com.adcolony.sdk.h$k r5 = new com.adcolony.sdk.h$k
            r5.<init>()
            java.lang.String r1 = "Module.load"
            com.adcolony.sdk.C0557a.m84a((java.lang.String) r1, (com.adcolony.sdk.C0816z) r5)
            com.adcolony.sdk.h$m r5 = new com.adcolony.sdk.h$m
            r5.<init>()
            java.lang.String r1 = "Module.unload"
            com.adcolony.sdk.C0557a.m84a((java.lang.String) r1, (com.adcolony.sdk.C0816z) r5)
            com.adcolony.sdk.h$n r5 = new com.adcolony.sdk.h$n
            r5.<init>()
            java.lang.String r1 = "AdColony.on_configured"
            com.adcolony.sdk.C0557a.m84a((java.lang.String) r1, (com.adcolony.sdk.C0816z) r5)
            com.adcolony.sdk.h$o r5 = new com.adcolony.sdk.h$o
            r5.<init>()
            java.lang.String r1 = "AdColony.get_app_info"
            com.adcolony.sdk.C0557a.m84a((java.lang.String) r1, (com.adcolony.sdk.C0816z) r5)
            com.adcolony.sdk.h$p r5 = new com.adcolony.sdk.h$p
            r5.<init>()
            java.lang.String r1 = "AdColony.v4vc_reward"
            com.adcolony.sdk.C0557a.m84a((java.lang.String) r1, (com.adcolony.sdk.C0816z) r5)
            com.adcolony.sdk.h$q r5 = new com.adcolony.sdk.h$q
            r5.<init>()
            java.lang.String r1 = "AdColony.zone_info"
            com.adcolony.sdk.C0557a.m84a((java.lang.String) r1, (com.adcolony.sdk.C0816z) r5)
            com.adcolony.sdk.h$r r5 = new com.adcolony.sdk.h$r
            r5.<init>()
            java.lang.String r1 = "AdColony.probe_launch_server"
            com.adcolony.sdk.C0557a.m84a((java.lang.String) r1, (com.adcolony.sdk.C0816z) r5)
            com.adcolony.sdk.h$s r5 = new com.adcolony.sdk.h$s
            r5.<init>()
            java.lang.String r1 = "Crypto.sha1"
            com.adcolony.sdk.C0557a.m84a((java.lang.String) r1, (com.adcolony.sdk.C0816z) r5)
            com.adcolony.sdk.h$t r5 = new com.adcolony.sdk.h$t
            r5.<init>()
            java.lang.String r1 = "Crypto.crc32"
            com.adcolony.sdk.C0557a.m84a((java.lang.String) r1, (com.adcolony.sdk.C0816z) r5)
            com.adcolony.sdk.h$a r5 = new com.adcolony.sdk.h$a
            r5.<init>()
            java.lang.String r1 = "Crypto.uuid"
            com.adcolony.sdk.C0557a.m84a((java.lang.String) r1, (com.adcolony.sdk.C0816z) r5)
            com.adcolony.sdk.h$b r5 = new com.adcolony.sdk.h$b
            r5.<init>()
            java.lang.String r1 = "Device.query_advertiser_info"
            com.adcolony.sdk.C0557a.m84a((java.lang.String) r1, (com.adcolony.sdk.C0816z) r5)
            com.adcolony.sdk.h$c r5 = new com.adcolony.sdk.h$c
            r5.<init>()
            java.lang.String r1 = "AdColony.controller_version"
            com.adcolony.sdk.C0557a.m84a((java.lang.String) r1, (com.adcolony.sdk.C0816z) r5)
            com.adcolony.sdk.g0 r5 = r3.f692i
            int r5 = com.adcolony.sdk.C0717k0.m504a((com.adcolony.sdk.C0647g0) r5)
            if (r5 != r0) goto L_0x01ab
            r1 = 1
            goto L_0x01ac
        L_0x01ab:
            r1 = 0
        L_0x01ac:
            r3.f676M = r1
            r1 = 2
            if (r5 != r1) goto L_0x01b2
            r4 = 1
        L_0x01b2:
            r3.f677N = r4
            com.adcolony.sdk.h$d r4 = new com.adcolony.sdk.h$d
            r4.<init>()
            com.adcolony.sdk.C0717k0.m515a((java.lang.Runnable) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0648h.mo10623a(com.adcolony.sdk.AdColonyAppOptions, boolean):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10624a(AdColonyInterstitial adColonyInterstitial) {
        this.f698o = adColonyInterstitial;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10625a(AdColonyRewardListener adColonyRewardListener) {
        this.f699p = adColonyRewardListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10626a(C0563c cVar) {
        this.f696m = cVar;
    }

    /* renamed from: a */
    public void mo10627a(C0720l lVar, C0812x xVar, Map<String, List<String>> map) {
        if (lVar.f855m.equals(f662W)) {
            if (lVar.f857o) {
                new C0797u.C0798a().mo10920a("Launch: ").mo10920a(lVar.f856n).mo10922a(C0797u.f1089d);
                JSONObject a = C0795s.m782a(lVar.f856n, "Parsing launch response");
                C0795s.m791a(a, "sdkVersion", mo10647h().mo10711E());
                C0795s.m813i(a, this.f692i.mo10610a() + f660U);
                if (m294c(a)) {
                    if (m284a(a)) {
                        new C0797u.C0798a().mo10920a("Controller missing or out of date. Downloading controller").mo10922a(C0797u.f1091f);
                        JSONObject b = C0795s.m798b();
                        C0795s.m791a(b, "url", this.f709z);
                        C0795s.m791a(b, "filepath", this.f692i.mo10610a() + f661V);
                        this.f686c.mo10813a(new C0720l(new C0812x("WebServices.download", 0, b), this));
                    }
                    this.f705v = a;
                } else if (!this.f672I) {
                    new C0797u.C0798a().mo10920a("Incomplete or disabled launch server response. ").mo10920a("Disabling AdColony until next launch.").mo10922a(C0797u.f1094i);
                    mo10629a(true);
                }
            } else {
                m278I();
            }
        } else if (!lVar.f855m.equals(this.f709z)) {
        } else {
            if (!m290b(this.f664A) && !C0737m0.f923N) {
                new C0797u.C0798a().mo10920a("Downloaded controller sha1 does not match, retrying.").mo10922a(C0797u.f1092g);
                m278I();
            } else if (!this.f672I && !this.f675L) {
                C0717k0.m515a((Runnable) new C0658h());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10628a(String str) {
        this.f708y = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10629a(boolean z) {
        this.f669F = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo10630a(int i) {
        C0559a0 a = this.f685b.mo10946a(i);
        C0737m0 remove = this.f707x.remove(Integer.valueOf(i));
        boolean z = false;
        if (a == null) {
            return false;
        }
        if (remove != null && remove.mo10840t()) {
            z = true;
        }
        C0659i iVar = new C0659i(remove);
        if (z) {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            new Handler().postDelayed(iVar, 1000);
        } else {
            iVar.run();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo10631a(Context context, C0812x xVar) {
        boolean z;
        if (context == null) {
            return false;
        }
        String str = "";
        AdvertisingIdClient.Info info = null;
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(context);
        } catch (NoClassDefFoundError unused) {
            new C0797u.C0798a().mo10920a("Google Play Services ads dependencies are missing. Collecting ").mo10920a("Android ID instead of Advertising ID.").mo10922a(C0797u.f1092g);
            return false;
        } catch (NoSuchMethodError unused2) {
            new C0797u.C0798a().mo10920a("Google Play Services is out of date, please update to GPS 4.0+. ").mo10920a("Collecting Android ID instead of Advertising ID.").mo10922a(C0797u.f1092g);
        } catch (Exception e) {
            e.printStackTrace();
            if (!Build.MANUFACTURER.equals("Amazon")) {
                new C0797u.C0798a().mo10920a("Advertising ID is not available. Collecting Android ID instead of").mo10920a(" Advertising ID.").mo10922a(C0797u.f1092g);
                return false;
            }
            str = mo10647h().mo10726c();
            z = mo10647h().mo10727d();
        }
        z = false;
        if (!Build.MANUFACTURER.equals("Amazon") && info == null) {
            return false;
        }
        if (!Build.MANUFACTURER.equals("Amazon")) {
            str = info.getId();
            z = info.isLimitAdTrackingEnabled();
        }
        mo10647h().mo10720a(str);
        C0801w.f1120n.f623e.put("advertisingId", mo10647h().mo10723b());
        mo10647h().mo10725b(z);
        mo10647h().mo10722a(true);
        if (xVar != null) {
            JSONObject b = C0795s.m798b();
            C0795s.m791a(b, "advertiser_id", mo10647h().mo10723b());
            C0795s.m802b(b, "limit_ad_tracking", mo10647h().mo10745v());
            xVar.mo10940a(b).mo10945d();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo10632a(C0812x xVar) {
        Context b = C0557a.m86b();
        if (b == null) {
            return false;
        }
        try {
            int f = xVar.mo10941b().has("id") ? C0795s.m810f(xVar.mo10941b(), "id") : 0;
            if (f <= 0) {
                f = this.f685b.mo10955d();
            }
            mo10630a(f);
            C0717k0.m515a((Runnable) new C0655f(b, C0795s.m807d(xVar.mo10941b(), "is_display_module"), xVar));
            return true;
        } catch (RuntimeException e) {
            C0797u.C0798a aVar = new C0797u.C0798a();
            aVar.mo10920a(e.toString() + ": during WebView initialization.").mo10920a(" Disabling AdColony.").mo10922a(C0797u.f1094i);
            AdColony.disable();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0580d mo10633b() {
        if (this.f688e == null) {
            C0580d dVar = new C0580d();
            this.f688e = dVar;
            dVar.mo10566e();
        }
        return this.f688e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10634b(@NonNull AdColonyAppOptions adColonyAppOptions) {
        this.f701r = adColonyAppOptions;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10635b(C0812x xVar) {
        this.f704u = xVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10636b(boolean z) {
        this.f668E = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo10637c() {
        return this.f666C;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo10638c(C0812x xVar) {
        this.f702s = xVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo10639c(boolean z) {
        this.f703t = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public AdColonyInterstitial mo10640d() {
        return this.f698o;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo10641d(boolean z) {
        this.f667D = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo10642d(C0812x xVar) {
        if (this.f699p == null) {
            return false;
        }
        C0717k0.m515a((Runnable) new C0660j(xVar));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public AdColonyAdView mo10643e() {
        return this.f697n;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo10644e(C0812x xVar) {
        AdColonyZone adColonyZone;
        if (this.f669F) {
            new C0797u.C0798a().mo10920a("AdColony is disabled. Ignoring zone_info message.").mo10922a(C0797u.f1093h);
            return;
        }
        String h = C0795s.m812h(xVar.mo10941b(), "zone_id");
        if (this.f706w.containsKey(h)) {
            adColonyZone = this.f706w.get(h);
        } else {
            AdColonyZone adColonyZone2 = new AdColonyZone(h);
            this.f706w.put(h, adColonyZone2);
            adColonyZone = adColonyZone2;
        }
        adColonyZone.mo10477a(xVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public C0563c mo10645f() {
        return this.f696m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public HashMap<String, AdColonyCustomMessageListener> mo10646g() {
        return this.f700q;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public C0694j mo10647h() {
        if (this.f694k == null) {
            C0694j jVar = new C0694j();
            this.f694k = jVar;
            jVar.mo10717K();
        }
        return this.f694k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public C0711k mo10648i() {
        if (this.f689f == null) {
            this.f689f = new C0711k();
        }
        return this.f689f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public C0733m mo10649j() {
        if (this.f686c == null) {
            this.f686c = new C0733m();
        }
        return this.f686c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public C0771p mo10650k() {
        if (this.f690g == null) {
            C0771p pVar = new C0771p();
            this.f690g = pVar;
            pVar.mo10894b();
        }
        return this.f690g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public JSONObject mo10651l() {
        return this.f705v;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public C0813y mo10652m() {
        if (this.f685b == null) {
            C0813y yVar = new C0813y();
            this.f685b = yVar;
            yVar.mo10948a();
        }
        return this.f685b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public C0562b0 mo10653n() {
        if (this.f695l == null) {
            this.f695l = new C0562b0();
        }
        return this.f695l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public String mo10654o() {
        return this.f708y;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public Partner mo10655p() {
        return this.f683T;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public AdColonyAppOptions mo10656q() {
        if (this.f701r == null) {
            this.f701r = new AdColonyAppOptions();
        }
        return this.f701r;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public AdColonyRewardListener mo10657r() {
        return this.f699p;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public C0644f0 mo10658s() {
        if (this.f687d == null) {
            C0644f0 f0Var = new C0644f0();
            this.f687d = f0Var;
            f0Var.mo10594a();
        }
        return this.f687d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public C0647g0 mo10659t() {
        if (this.f692i == null) {
            C0647g0 g0Var = new C0647g0();
            this.f692i = g0Var;
            g0Var.mo10614e();
        }
        return this.f692i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public C0674i0 mo10660u() {
        if (this.f691h == null) {
            C0674i0 i0Var = new C0674i0();
            this.f691h = i0Var;
            i0Var.mo10689a();
        }
        return this.f691h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public HashMap<Integer, C0737m0> mo10661v() {
        return this.f707x;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public HashMap<String, AdColonyZone> mo10662w() {
        return this.f706w;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public boolean mo10663x() {
        return this.f701r != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public boolean mo10664y() {
        return this.f668E;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public boolean mo10665z() {
        return this.f669F;
    }
}
