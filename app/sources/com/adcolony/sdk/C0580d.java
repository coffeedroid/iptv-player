package com.adcolony.sdk;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import com.adcolony.sdk.C0797u;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.settings.SettingsJsonConstants;

/* renamed from: com.adcolony.sdk.d */
class C0580d {

    /* renamed from: a */
    private HashMap<String, C0563c> f296a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ConcurrentHashMap<String, AdColonyInterstitial> f297b;

    /* renamed from: c */
    private HashMap<String, AdColonyAdViewListener> f298c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public HashMap<String, AdColonyAdView> f299d;

    /* renamed from: com.adcolony.sdk.d$a */
    class C0581a implements C0816z {
        C0581a() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            boolean unused = C0580d.this.m189c(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.d$b */
    class C0582b implements C0816z {
        C0582b() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0580d.this.mo10561a(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.d$c */
    class C0583c implements C0816z {

        /* renamed from: com.adcolony.sdk.d$c$a */
        class C0584a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0812x f303a;

            C0584a(C0812x xVar) {
                this.f303a = xVar;
            }

            public void run() {
                AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) C0580d.this.f297b.get(C0795s.m812h(this.f303a.mo10941b(), "id"));
                if (adColonyInterstitial != null && adColonyInterstitial.getListener() != null) {
                    adColonyInterstitial.getListener().onAudioStopped(adColonyInterstitial);
                }
            }
        }

        C0583c() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0717k0.m515a((Runnable) new C0584a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.d$d */
    class C0585d implements C0816z {

        /* renamed from: com.adcolony.sdk.d$d$a */
        class C0586a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0812x f306a;

            C0586a(C0812x xVar) {
                this.f306a = xVar;
            }

            public void run() {
                AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) C0580d.this.f297b.get(C0795s.m812h(this.f306a.mo10941b(), "id"));
                if (adColonyInterstitial != null && adColonyInterstitial.getListener() != null) {
                    adColonyInterstitial.getListener().onAudioStarted(adColonyInterstitial);
                }
            }
        }

        C0585d() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0717k0.m515a((Runnable) new C0586a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.d$e */
    class C0587e implements C0816z {
        C0587e() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            boolean unused = C0580d.this.m201i(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.d$f */
    class C0588f implements C0816z {
        C0588f() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0580d.this.mo10563b(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.d$g */
    class C0589g implements C0816z {
        C0589g() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            boolean unused = C0580d.this.m199h(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.d$h */
    class C0590h implements C0816z {
        C0590h() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            JSONObject b = C0795s.m798b();
            C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, true);
            xVar.mo10940a(b).mo10945d();
        }
    }

    /* renamed from: com.adcolony.sdk.d$i */
    class C0591i implements C0816z {

        /* renamed from: com.adcolony.sdk.d$i$a */
        class C0592a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0812x f313a;

            C0592a(C0812x xVar) {
                this.f313a = xVar;
            }

            public void run() {
                C0812x xVar = this.f313a;
                xVar.mo10940a(xVar.mo10941b()).mo10945d();
            }
        }

        C0591i() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0717k0.m515a((Runnable) new C0592a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.d$j */
    class C0593j implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdColonyInterstitial f315a;

        /* renamed from: b */
        final /* synthetic */ AdColonyInterstitialListener f316b;

        C0593j(AdColonyInterstitial adColonyInterstitial, AdColonyInterstitialListener adColonyInterstitialListener) {
            this.f315a = adColonyInterstitial;
            this.f316b = adColonyInterstitialListener;
        }

        public void run() {
            this.f315a.mo10417a(true);
            this.f316b.onExpiring(this.f315a);
            C0711k i = C0557a.m88c().mo10648i();
            if (i.mo10770a() != null) {
                i.mo10770a().dismiss();
                i.mo10771a((AlertDialog) null);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.d$k */
    class C0594k implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f318a;

        /* renamed from: b */
        final /* synthetic */ C0812x f319b;

        /* renamed from: c */
        final /* synthetic */ AdColonyAdViewListener f320c;

        /* renamed from: d */
        final /* synthetic */ String f321d;

        C0594k(Context context, C0812x xVar, AdColonyAdViewListener adColonyAdViewListener, String str) {
            this.f318a = context;
            this.f319b = xVar;
            this.f320c = adColonyAdViewListener;
            this.f321d = str;
        }

        public void run() {
            AdColonyAdView adColonyAdView = new AdColonyAdView(this.f318a, this.f319b, this.f320c);
            C0580d.this.f299d.put(this.f321d, adColonyAdView);
            adColonyAdView.setOmidManager(this.f320c.mo10359b());
            adColonyAdView.mo10324d();
            this.f320c.mo10357a((C0576c0) null);
            this.f320c.onRequestFilled(adColonyAdView);
        }
    }

    /* renamed from: com.adcolony.sdk.d$l */
    class C0595l implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdColonyInterstitial f323a;

        /* renamed from: b */
        final /* synthetic */ C0812x f324b;

        /* renamed from: c */
        final /* synthetic */ AdColonyInterstitialListener f325c;

        C0595l(AdColonyInterstitial adColonyInterstitial, C0812x xVar, AdColonyInterstitialListener adColonyInterstitialListener) {
            this.f323a = adColonyInterstitial;
            this.f324b = xVar;
            this.f325c = adColonyInterstitialListener;
        }

        public void run() {
            if (this.f323a.mo10427e() == null) {
                this.f323a.mo10416a(C0795s.m811g(this.f324b.mo10941b(), "iab"));
            }
            this.f323a.mo10415a(C0795s.m812h(this.f324b.mo10941b(), "ad_id"));
            this.f323a.mo10421b(C0795s.m812h(this.f324b.mo10941b(), "creative_id"));
            C0576c0 e = this.f323a.mo10427e();
            if (!(e == null || e.mo10552d() == 2)) {
                try {
                    e.mo10545a();
                } catch (IllegalArgumentException unused) {
                    new C0797u.C0798a().mo10920a("IllegalArgumentException when creating omid session").mo10922a(C0797u.f1095j);
                }
            }
            this.f325c.onRequestFilled(this.f323a);
        }
    }

    /* renamed from: com.adcolony.sdk.d$m */
    class C0596m implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdColonyInterstitial f327a;

        /* renamed from: b */
        final /* synthetic */ AdColonyInterstitialListener f328b;

        C0596m(AdColonyInterstitial adColonyInterstitial, AdColonyInterstitialListener adColonyInterstitialListener) {
            this.f327a = adColonyInterstitial;
            this.f328b = adColonyInterstitialListener;
        }

        public void run() {
            AdColonyZone adColonyZone = C0557a.m88c().mo10662w().get(this.f327a.getZoneID());
            if (adColonyZone == null) {
                adColonyZone = new AdColonyZone(this.f327a.getZoneID());
                adColonyZone.mo10478b(6);
            }
            this.f328b.onRequestNotFilled(adColonyZone);
        }
    }

    /* renamed from: com.adcolony.sdk.d$n */
    class C0597n implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdColonyInterstitialListener f330a;

        /* renamed from: b */
        final /* synthetic */ AdColonyInterstitial f331b;

        C0597n(AdColonyInterstitialListener adColonyInterstitialListener, AdColonyInterstitial adColonyInterstitial) {
            this.f330a = adColonyInterstitialListener;
            this.f331b = adColonyInterstitial;
        }

        public void run() {
            C0557a.m88c().mo10641d(false);
            this.f330a.onClosed(this.f331b);
        }
    }

    /* renamed from: com.adcolony.sdk.d$o */
    class C0598o implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0563c f333a;

        C0598o(C0563c cVar) {
            this.f333a = cVar;
        }

        public void run() {
            for (int i = 0; i < this.f333a.mo10527i().size(); i++) {
                C0557a.m87b(this.f333a.mo10529j().get(i), this.f333a.mo10527i().get(i));
            }
            this.f333a.mo10529j().clear();
            this.f333a.mo10527i().clear();
            this.f333a.removeAllViews();
            C0563c cVar = this.f333a;
            cVar.f227A = null;
            cVar.f253z = null;
            new C0797u.C0798a().mo10920a("Destroying container tied to ad_session_id = ").mo10920a(this.f333a.mo10504a()).mo10922a(C0797u.f1091f);
            for (C0737m0 next : this.f333a.mo10534n().values()) {
                if (!next.mo10839s()) {
                    int c = next.mo10493c();
                    if (c <= 0) {
                        c = next.mo10494d();
                    }
                    C0557a.m88c().mo10630a(c);
                    next.loadUrl("about:blank");
                    next.clearCache(true);
                    next.removeAllViews();
                    next.mo10820a(true);
                }
            }
            new C0797u.C0798a().mo10920a("Stopping and releasing all media players associated with ").mo10920a("VideoViews tied to ad_session_id = ").mo10920a(this.f333a.mo10504a()).mo10922a(C0797u.f1091f);
            for (C0722l0 next2 : this.f333a.mo10533m().values()) {
                next2.mo10795i();
                next2.mo10796j();
            }
            this.f333a.mo10533m().clear();
            this.f333a.mo10532l().clear();
            this.f333a.mo10534n().clear();
            this.f333a.mo10525h().clear();
            this.f333a.mo10519e().clear();
            this.f333a.mo10521f().clear();
            this.f333a.mo10523g().clear();
            this.f333a.f240m = true;
        }
    }

    /* renamed from: com.adcolony.sdk.d$p */
    class C0599p implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdColonyAdViewListener f335a;

        C0599p(AdColonyAdViewListener adColonyAdViewListener) {
            this.f335a = adColonyAdViewListener;
        }

        public void run() {
            String c = this.f335a.mo10360c();
            AdColonyZone adColonyZone = C0557a.m88c().mo10662w().get(c);
            if (adColonyZone == null) {
                adColonyZone = new AdColonyZone(c);
                adColonyZone.mo10478b(6);
            }
            this.f335a.onRequestNotFilled(adColonyZone);
        }
    }

    /* renamed from: com.adcolony.sdk.d$q */
    class C0600q implements C0816z {

        /* renamed from: com.adcolony.sdk.d$q$a */
        class C0601a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0812x f338a;

            C0601a(C0812x xVar) {
                this.f338a = xVar;
            }

            public void run() {
                boolean unused = C0580d.this.m193e(this.f338a);
            }
        }

        C0600q() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0717k0.m515a((Runnable) new C0601a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.d$r */
    class C0602r implements C0816z {

        /* renamed from: com.adcolony.sdk.d$r$a */
        class C0603a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0812x f341a;

            C0603a(C0812x xVar) {
                this.f341a = xVar;
            }

            public void run() {
                boolean unused = C0580d.this.m195f(this.f341a);
            }
        }

        C0602r() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0717k0.m515a((Runnable) new C0603a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.d$s */
    class C0604s implements C0816z {
        C0604s() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            boolean unused = C0580d.this.m204k(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.d$t */
    class C0605t implements C0816z {
        C0605t() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            boolean unused = C0580d.this.m203j(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.d$u */
    class C0606u implements C0816z {
        C0606u() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            boolean unused = C0580d.this.m197g(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.d$v */
    class C0607v implements C0816z {
        C0607v() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            boolean unused = C0580d.this.m205l(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.d$w */
    class C0608w implements C0816z {
        C0608w() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            boolean unused = C0580d.this.m191d(xVar);
        }
    }

    C0580d() {
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m189c(C0812x xVar) {
        String h = C0795s.m812h(xVar.mo10941b(), "id");
        AdColonyAdViewListener remove = this.f298c.remove(h);
        if (remove == null) {
            mo10560a(xVar.mo10944c(), h);
            return false;
        }
        C0717k0.m515a((Runnable) new C0599p(remove));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m191d(C0812x xVar) {
        String h = C0795s.m812h(xVar.mo10941b(), "id");
        AdColonyAdViewListener remove = this.f298c.remove(h);
        if (remove == null) {
            mo10560a(xVar.mo10944c(), h);
            return false;
        }
        Context b = C0557a.m86b();
        if (b == null) {
            return false;
        }
        C0717k0.m515a((Runnable) new C0594k(b, xVar, remove, h));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m193e(C0812x xVar) {
        Context b = C0557a.m86b();
        if (b == null) {
            return false;
        }
        JSONObject b2 = xVar.mo10941b();
        String h = C0795s.m812h(b2, "ad_session_id");
        C0563c cVar = new C0563c(b.getApplicationContext(), h);
        cVar.mo10530j(xVar);
        this.f296a.put(h, cVar);
        if (C0795s.m810f(b2, SettingsJsonConstants.ICON_WIDTH_KEY) == 0) {
            AdColonyInterstitial adColonyInterstitial = this.f297b.get(h);
            if (adColonyInterstitial == null) {
                mo10560a(xVar.mo10944c(), h);
                return false;
            }
            adColonyInterstitial.mo10414a(cVar);
        } else {
            cVar.mo10509a(false);
        }
        JSONObject b3 = C0795s.m798b();
        C0795s.m802b(b3, FirebaseAnalytics.Param.SUCCESS, true);
        xVar.mo10940a(b3).mo10945d();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean m195f(C0812x xVar) {
        String h = C0795s.m812h(xVar.mo10941b(), "ad_session_id");
        C0563c cVar = this.f296a.get(h);
        if (cVar == null) {
            mo10560a(xVar.mo10944c(), h);
            return false;
        }
        mo10557a(cVar);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean m197g(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        int f = C0795s.m810f(b, "status");
        if (f == 5 || f == 1 || f == 0 || f == 6) {
            return false;
        }
        String h = C0795s.m812h(b, "id");
        AdColonyInterstitial remove = this.f297b.remove(h);
        AdColonyInterstitialListener listener = remove == null ? null : remove.getListener();
        if (listener == null) {
            mo10560a(xVar.mo10944c(), h);
            return false;
        }
        C0717k0.m515a((Runnable) new C0597n(listener, remove));
        remove.mo10414a((C0563c) null);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public boolean m199h(C0812x xVar) {
        String h = C0795s.m812h(xVar.mo10941b(), "id");
        JSONObject b = C0795s.m798b();
        C0795s.m791a(b, "id", h);
        Context b2 = C0557a.m86b();
        if (b2 == null) {
            C0795s.m802b(b, "has_audio", false);
            xVar.mo10940a(b).mo10945d();
            return false;
        }
        boolean b3 = C0717k0.m524b(C0717k0.m506a(b2));
        double a = C0717k0.m502a(C0717k0.m506a(b2));
        C0795s.m802b(b, "has_audio", b3);
        C0795s.m789a(b, MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, a);
        xVar.mo10940a(b).mo10945d();
        return b3;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public boolean m201i(C0812x xVar) {
        String h = C0795s.m812h(xVar.mo10941b(), "id");
        AdColonyInterstitial adColonyInterstitial = this.f297b.get(h);
        AdColonyInterstitialListener listener = adColonyInterstitial == null ? null : adColonyInterstitial.getListener();
        if (listener == null) {
            mo10560a(xVar.mo10944c(), h);
            return false;
        } else if (!C0557a.m89d()) {
            return false;
        } else {
            C0717k0.m515a((Runnable) new C0595l(adColonyInterstitial, xVar, listener));
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public boolean m203j(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        String c = xVar.mo10944c();
        String h = C0795s.m812h(b, "ad_session_id");
        int f = C0795s.m810f(b, "view_id");
        C0563c cVar = this.f296a.get(h);
        if (cVar == null) {
            mo10560a(c, h);
            return false;
        }
        View view = cVar.mo10519e().get(Integer.valueOf(f));
        if (view == null) {
            mo10560a(c, "" + f);
            return false;
        }
        cVar.removeView(view);
        cVar.addView(view, view.getLayoutParams());
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public boolean m204k(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        String c = xVar.mo10944c();
        String h = C0795s.m812h(b, "ad_session_id");
        int f = C0795s.m810f(b, "view_id");
        C0563c cVar = this.f296a.get(h);
        View view = cVar.mo10519e().get(Integer.valueOf(f));
        if (cVar == null) {
            mo10560a(c, h);
            return false;
        } else if (view == null) {
            mo10560a(c, "" + f);
            return false;
        } else {
            view.bringToFront();
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public boolean m205l(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        String h = C0795s.m812h(b, "id");
        AdColonyInterstitial adColonyInterstitial = this.f297b.get(h);
        AdColonyAdView adColonyAdView = this.f299d.get(h);
        int a = C0795s.m777a(b, AdUnitActivity.EXTRA_ORIENTATION, -1);
        boolean z = adColonyAdView != null;
        if (adColonyInterstitial != null || z) {
            JSONObject b2 = C0795s.m798b();
            C0795s.m791a(b2, "id", h);
            if (adColonyInterstitial != null) {
                adColonyInterstitial.mo10412a(C0795s.m810f(b2, "module_id"));
                adColonyInterstitial.mo10420b(a);
                adColonyInterstitial.mo10433i();
            }
            return true;
        }
        mo10560a(xVar.mo10944c(), h);
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ConcurrentHashMap<String, AdColonyInterstitial> mo10556a() {
        return this.f297b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10557a(C0563c cVar) {
        C0717k0.m515a((Runnable) new C0598o(cVar));
        AdColonyAdView adColonyAdView = this.f299d.get(cVar.mo10504a());
        if (adColonyAdView == null || adColonyAdView.mo10323c()) {
            new C0797u.C0798a().mo10920a("Removing ad 4").mo10922a(C0797u.f1089d);
            this.f296a.remove(cVar.mo10504a());
            cVar.f253z = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10558a(String str, AdColonyAdViewListener adColonyAdViewListener, AdColonyAdSize adColonyAdSize, AdColonyAdOptions adColonyAdOptions) {
        JSONObject jSONObject;
        String a = C0717k0.m507a();
        JSONObject b = C0795s.m798b();
        float n = C0557a.m88c().mo10647h().mo10737n();
        C0795s.m791a(b, "zone_id", str);
        C0795s.m801b(b, AppMeasurement.Param.TYPE, 1);
        C0795s.m801b(b, "width_pixels", (int) (((float) adColonyAdSize.getWidth()) * n));
        C0795s.m801b(b, "height_pixels", (int) (((float) adColonyAdSize.getHeight()) * n));
        C0795s.m801b(b, SettingsJsonConstants.ICON_WIDTH_KEY, adColonyAdSize.getWidth());
        C0795s.m801b(b, SettingsJsonConstants.ICON_HEIGHT_KEY, adColonyAdSize.getHeight());
        C0795s.m791a(b, "id", a);
        adColonyAdViewListener.mo10358a(str);
        adColonyAdViewListener.mo10356a(adColonyAdSize);
        if (!(adColonyAdOptions == null || (jSONObject = adColonyAdOptions.f126d) == null)) {
            C0795s.m793a(b, "options", jSONObject);
        }
        this.f298c.put(a, adColonyAdViewListener);
        new C0812x("AdSession.on_request", 1, b).mo10945d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10559a(String str, AdColonyInterstitialListener adColonyInterstitialListener, AdColonyAdOptions adColonyAdOptions) {
        String a = C0717k0.m507a();
        C0648h c = C0557a.m88c();
        JSONObject b = C0795s.m798b();
        C0795s.m791a(b, "zone_id", str);
        C0795s.m802b(b, "fullscreen", true);
        C0795s.m801b(b, SettingsJsonConstants.ICON_WIDTH_KEY, c.mo10647h().mo10742s());
        C0795s.m801b(b, SettingsJsonConstants.ICON_HEIGHT_KEY, c.mo10647h().mo10741r());
        C0795s.m801b(b, AppMeasurement.Param.TYPE, 0);
        C0795s.m791a(b, "id", a);
        new C0797u.C0798a().mo10920a("AdSession request with id = ").mo10920a(a).mo10922a(C0797u.f1089d);
        AdColonyInterstitial adColonyInterstitial = new AdColonyInterstitial(a, adColonyInterstitialListener, str);
        this.f297b.put(a, adColonyInterstitial);
        if (!(adColonyAdOptions == null || adColonyAdOptions.f126d == null)) {
            adColonyInterstitial.mo10413a(adColonyAdOptions);
            C0795s.m793a(b, "options", adColonyAdOptions.f126d);
        }
        new C0797u.C0798a().mo10920a("Requesting AdColony interstitial advertisement.").mo10922a(C0797u.f1088c);
        new C0812x("AdSession.on_request", 1, b).mo10945d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10560a(String str, String str2) {
        new C0797u.C0798a().mo10920a("Message '").mo10920a(str).mo10920a("' sent with invalid id: ").mo10920a(str2).mo10922a(C0797u.f1094i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo10561a(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        String h = C0795s.m812h(b, "id");
        if (C0795s.m810f(b, AppMeasurement.Param.TYPE) != 0) {
            return true;
        }
        AdColonyInterstitial remove = this.f297b.remove(h);
        AdColonyInterstitialListener listener = remove == null ? null : remove.getListener();
        if (listener == null) {
            mo10560a(xVar.mo10944c(), h);
            return false;
        } else if (!C0557a.m89d()) {
            return false;
        } else {
            C0717k0.m515a((Runnable) new C0593j(remove, listener));
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public HashMap<String, AdColonyAdView> mo10562b() {
        return this.f299d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo10563b(C0812x xVar) {
        String h = C0795s.m812h(xVar.mo10941b(), "id");
        AdColonyInterstitial remove = this.f297b.remove(h);
        AdColonyInterstitialListener listener = remove == null ? null : remove.getListener();
        if (listener == null) {
            mo10560a(xVar.mo10944c(), h);
            return false;
        } else if (!C0557a.m89d()) {
            return false;
        } else {
            C0717k0.m515a((Runnable) new C0596m(remove, listener));
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public HashMap<String, AdColonyAdViewListener> mo10564c() {
        return this.f298c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public HashMap<String, C0563c> mo10565d() {
        return this.f296a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo10566e() {
        this.f296a = new HashMap<>();
        this.f297b = new ConcurrentHashMap<>();
        this.f298c = new HashMap<>();
        this.f299d = new HashMap<>();
        C0557a.m84a("AdContainer.create", (C0816z) new C0600q());
        C0557a.m84a("AdContainer.destroy", (C0816z) new C0602r());
        C0557a.m84a("AdContainer.move_view_to_index", (C0816z) new C0604s());
        C0557a.m84a("AdContainer.move_view_to_front", (C0816z) new C0605t());
        C0557a.m84a("AdSession.finish_fullscreen_ad", (C0816z) new C0606u());
        C0557a.m84a("AdSession.start_fullscreen_ad", (C0816z) new C0607v());
        C0557a.m84a("AdSession.ad_view_available", (C0816z) new C0608w());
        C0557a.m84a("AdSession.ad_view_unavailable", (C0816z) new C0581a());
        C0557a.m84a("AdSession.expiring", (C0816z) new C0582b());
        C0557a.m84a("AdSession.audio_stopped", (C0816z) new C0583c());
        C0557a.m84a("AdSession.audio_started", (C0816z) new C0585d());
        C0557a.m84a("AdSession.interstitial_available", (C0816z) new C0587e());
        C0557a.m84a("AdSession.interstitial_unavailable", (C0816z) new C0588f());
        C0557a.m84a("AdSession.has_audio", (C0816z) new C0589g());
        C0557a.m84a("WebView.prepare", (C0816z) new C0590h());
        C0557a.m84a("AdSession.expanded", (C0816z) new C0591i());
    }
}
