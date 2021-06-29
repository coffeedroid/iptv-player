package com.adcolony.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.p000v4.p002os.EnvironmentCompat;
import com.PinkiePie;
import com.adcolony.sdk.C0717k0;
import com.adcolony.sdk.C0797u;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONObject;

public class AdColony {

    /* renamed from: a */
    static ExecutorService f100a = Executors.newSingleThreadExecutor();

    /* renamed from: com.adcolony.sdk.AdColony$a */
    static class C0542a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f101a;

        /* renamed from: b */
        final /* synthetic */ AdColonyInterstitialListener f102b;

        C0542a(String str, AdColonyInterstitialListener adColonyInterstitialListener) {
            this.f101a = str;
            this.f102b = adColonyInterstitialListener;
        }

        public void run() {
            AdColonyZone adColonyZone = C0557a.m88c().mo10662w().get(this.f101a);
            if (adColonyZone == null) {
                adColonyZone = new AdColonyZone(this.f101a);
            }
            this.f102b.onRequestNotFilled(adColonyZone);
        }
    }

    /* renamed from: com.adcolony.sdk.AdColony$b */
    static class C0543b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f103a;

        /* renamed from: b */
        final /* synthetic */ AdColonyAdViewListener f104b;

        C0543b(String str, AdColonyAdViewListener adColonyAdViewListener) {
            this.f103a = str;
            this.f104b = adColonyAdViewListener;
        }

        public void run() {
            AdColonyZone adColonyZone = !C0557a.m90e() ? null : C0557a.m88c().mo10662w().get(this.f103a);
            if (adColonyZone == null) {
                adColonyZone = new AdColonyZone(this.f103a);
            }
            this.f104b.onRequestNotFilled(adColonyZone);
        }
    }

    /* renamed from: com.adcolony.sdk.AdColony$c */
    static class C0544c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdColonyInterstitial f105a;

        C0544c(AdColonyInterstitial adColonyInterstitial) {
            this.f105a = adColonyInterstitial;
        }

        public void run() {
            AdColonyInterstitialListener listener = this.f105a.getListener();
            this.f105a.mo10417a(true);
            if (listener != null) {
                listener.onExpiring(this.f105a);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.AdColony$d */
    static class C0545d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0648h f106a;

        C0545d(C0648h hVar) {
            this.f106a = hVar;
        }

        public void run() {
            ArrayList arrayList = new ArrayList();
            Iterator<C0559a0> it = this.f106a.mo10652m().mo10952b().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C0559a0 a0Var = (C0559a0) it2.next();
                this.f106a.mo10630a(a0Var.mo10494d());
                if (a0Var instanceof C0737m0) {
                    C0737m0 m0Var = (C0737m0) a0Var;
                    if (!m0Var.mo10839s()) {
                        m0Var.loadUrl("about:blank");
                        m0Var.clearCache(true);
                        m0Var.removeAllViews();
                        m0Var.mo10820a(true);
                    }
                }
            }
        }
    }

    /* renamed from: com.adcolony.sdk.AdColony$e */
    static class C0546e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ double f107a;

        /* renamed from: b */
        final /* synthetic */ String f108b;

        /* renamed from: c */
        final /* synthetic */ String f109c;

        /* renamed from: d */
        final /* synthetic */ String f110d;

        C0546e(double d, String str, String str2, String str3) {
            this.f107a = d;
            this.f108b = str;
            this.f109c = str2;
            this.f110d = str3;
        }

        public void run() {
            AdColony.m14a();
            JSONObject b = C0795s.m798b();
            double d = this.f107a;
            if (d >= 0.0d) {
                C0795s.m789a(b, "price", d);
            }
            String str = this.f108b;
            if (str != null && str.length() <= 3) {
                C0795s.m791a(b, "currency_code", this.f108b);
            }
            C0795s.m791a(b, "product_id", this.f109c);
            C0795s.m791a(b, FirebaseAnalytics.Param.TRANSACTION_ID, this.f110d);
            new C0812x("AdColony.on_iap_report", 1, b).mo10945d();
        }
    }

    /* renamed from: com.adcolony.sdk.AdColony$f */
    static class C0547f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdColonyAdViewListener f111a;

        /* renamed from: b */
        final /* synthetic */ String f112b;

        /* renamed from: c */
        final /* synthetic */ AdColonyAdSize f113c;

        /* renamed from: d */
        final /* synthetic */ AdColonyAdOptions f114d;

        C0547f(AdColonyAdViewListener adColonyAdViewListener, String str, AdColonyAdSize adColonyAdSize, AdColonyAdOptions adColonyAdOptions) {
            this.f111a = adColonyAdViewListener;
            this.f112b = str;
            this.f113c = adColonyAdSize;
            this.f114d = adColonyAdOptions;
        }

        public void run() {
            C0648h c = C0557a.m88c();
            if (c.mo10664y() || c.mo10665z()) {
                AdColony.m18b();
                AdColony.m16a(this.f111a, this.f112b);
            }
            if (!AdColony.m14a() && C0557a.m89d()) {
                AdColony.m16a(this.f111a, this.f112b);
            }
            if (c.mo10662w().get(this.f112b) == null) {
                new AdColonyZone(this.f112b);
                new C0797u.C0798a().mo10920a("Zone info for ").mo10920a(this.f112b).mo10920a(" doesn't exist in hashmap").mo10922a(C0797u.f1089d);
            }
            c.mo10633b().mo10558a(this.f112b, this.f111a, this.f113c, this.f114d);
        }
    }

    /* renamed from: com.adcolony.sdk.AdColony$g */
    static class C0548g implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdColonyAppOptions f115a;

        C0548g(AdColonyAppOptions adColonyAppOptions) {
            this.f115a = adColonyAppOptions;
        }

        public void run() {
            AdColony.m14a();
            JSONObject b = C0795s.m798b();
            C0795s.m793a(b, "options", this.f115a.mo10370b());
            new C0812x("Options.set_options", 1, b).mo10945d();
        }
    }

    /* renamed from: com.adcolony.sdk.AdColony$h */
    static class C0549h implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f116a;

        C0549h(String str) {
            this.f116a = str;
        }

        public void run() {
            AdColony.m14a();
            JSONObject b = C0795s.m798b();
            C0795s.m791a(b, AppMeasurement.Param.TYPE, this.f116a);
            new C0812x("CustomMessage.register", 1, b).mo10945d();
        }
    }

    /* renamed from: com.adcolony.sdk.AdColony$i */
    static class C0550i implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f117a;

        C0550i(String str) {
            this.f117a = str;
        }

        public void run() {
            AdColony.m14a();
            JSONObject b = C0795s.m798b();
            C0795s.m791a(b, AppMeasurement.Param.TYPE, this.f117a);
            new C0812x("CustomMessage.unregister", 1, b).mo10945d();
        }
    }

    /* renamed from: com.adcolony.sdk.AdColony$j */
    static class C0551j implements Runnable {
        C0551j() {
        }

        public void run() {
            AdColony.m14a();
            for (String a : C0557a.m88c().mo10646g().keySet()) {
                JSONObject b = C0795s.m798b();
                C0795s.m791a(b, AppMeasurement.Param.TYPE, a);
                new C0812x("CustomMessage.unregister", 1, b).mo10945d();
            }
        }
    }

    /* renamed from: com.adcolony.sdk.AdColony$k */
    static class C0552k implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdColonyInterstitialListener f118a;

        /* renamed from: b */
        final /* synthetic */ String f119b;

        /* renamed from: c */
        final /* synthetic */ AdColonyAdOptions f120c;

        /* renamed from: com.adcolony.sdk.AdColony$k$a */
        class C0553a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ AdColonyZone f121a;

            C0553a(AdColonyZone adColonyZone) {
                this.f121a = adColonyZone;
            }

            public void run() {
                C0552k.this.f118a.onRequestNotFilled(this.f121a);
            }
        }

        C0552k(AdColonyInterstitialListener adColonyInterstitialListener, String str, AdColonyAdOptions adColonyAdOptions) {
            this.f118a = adColonyInterstitialListener;
            this.f119b = str;
            this.f120c = adColonyAdOptions;
        }

        public void run() {
            C0648h c = C0557a.m88c();
            if (c.mo10664y() || c.mo10665z()) {
                AdColony.m18b();
                AdColony.m17a(this.f118a, this.f119b);
            } else if (AdColony.m14a() || !C0557a.m89d()) {
                AdColonyZone adColonyZone = c.mo10662w().get(this.f119b);
                if (adColonyZone == null) {
                    adColonyZone = new AdColonyZone(this.f119b);
                    C0797u.C0798a a = new C0797u.C0798a().mo10920a("Zone info for ");
                    a.mo10920a(this.f119b + " doesn't exist in hashmap").mo10922a(C0797u.f1089d);
                }
                if (adColonyZone.getZoneType() == 2 || adColonyZone.getZoneType() == 1) {
                    C0717k0.m515a((Runnable) new C0553a(adColonyZone));
                } else {
                    c.mo10633b().mo10559a(this.f119b, this.f118a, this.f120c);
                }
            } else {
                AdColony.m17a(this.f118a, this.f119b);
            }
        }
    }

    /* renamed from: a */
    static void m13a(Context context, AdColonyAppOptions adColonyAppOptions) {
        if (adColonyAppOptions != null && context != null) {
            String b = C0717k0.m521b(context);
            String e = C0717k0.m531e();
            int f = C0717k0.m533f();
            String h = C0557a.m88c().mo10647h().mo10731h();
            String str = "none";
            if (C0557a.m88c().mo10653n().mo10502c()) {
                str = "wifi";
            } else if (C0557a.m88c().mo10653n().mo10501b()) {
                str = "mobile";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("sessionId", EnvironmentCompat.MEDIA_UNKNOWN);
            hashMap.put("advertiserId", EnvironmentCompat.MEDIA_UNKNOWN);
            hashMap.put("countryLocale", Locale.getDefault().getDisplayLanguage() + " (" + Locale.getDefault().getDisplayCountry() + ")");
            hashMap.put("countryLocalShort", C0557a.m88c().mo10647h().mo10734k());
            hashMap.put("manufacturer", C0557a.m88c().mo10647h().mo10747x());
            hashMap.put("model", C0557a.m88c().mo10647h().mo10707A());
            hashMap.put("osVersion", C0557a.m88c().mo10647h().mo10709C());
            hashMap.put("carrierName", h);
            hashMap.put("networkType", str);
            hashMap.put("platform", "android");
            hashMap.put("appName", b);
            hashMap.put("appVersion", e);
            hashMap.put("appBuildNumber", Integer.valueOf(f));
            hashMap.put("appId", "" + adColonyAppOptions.mo10369a());
            hashMap.put("apiLevel", Integer.valueOf(Build.VERSION.SDK_INT));
            hashMap.put("sdkVersion", C0557a.m88c().mo10647h().mo10711E());
            hashMap.put("controllerVersion", EnvironmentCompat.MEDIA_UNKNOWN);
            hashMap.put("zoneIds", adColonyAppOptions.mo10372d());
            JSONObject mediationInfo = adColonyAppOptions.getMediationInfo();
            JSONObject pluginInfo = adColonyAppOptions.getPluginInfo();
            if (!C0795s.m812h(mediationInfo, "mediation_network").equals("")) {
                hashMap.put("mediationNetwork", C0795s.m812h(mediationInfo, "mediation_network"));
                hashMap.put("mediationNetworkVersion", C0795s.m812h(mediationInfo, "mediation_network_version"));
            }
            if (!C0795s.m812h(pluginInfo, "plugin").equals("")) {
                hashMap.put("plugin", C0795s.m812h(pluginInfo, "plugin"));
                hashMap.put("pluginVersion", C0795s.m812h(pluginInfo, "plugin_version"));
            }
            C0801w.m845a((HashMap<String, Object>) hashMap);
        }
    }

    /* renamed from: a */
    static boolean m14a() {
        C0717k0.C0719b bVar = new C0717k0.C0719b(15.0d);
        C0648h c = C0557a.m88c();
        while (!c.mo10617A() && !bVar.mo10781a()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException unused) {
            }
        }
        return c.mo10617A();
    }

    /* renamed from: a */
    private static boolean m15a(Context context, AdColonyAppOptions adColonyAppOptions, @NonNull String str, @NonNull String... strArr) {
        if (C0609d0.m233a(0, (Bundle) null)) {
            new C0797u.C0798a().mo10920a("Cannot configure AdColony; configuration mechanism requires 5 ").mo10920a("seconds between attempts.").mo10922a(C0797u.f1092g);
            return false;
        }
        if (context == null) {
            context = C0557a.m86b();
        }
        if (context == null) {
            new C0797u.C0798a().mo10920a("Ignoring call to AdColony.configure() as the provided Activity or ").mo10920a("Application context is null and we do not currently hold a ").mo10920a("reference to either for our use.").mo10922a(C0797u.f1092g);
            return false;
        }
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (adColonyAppOptions == null) {
            adColonyAppOptions = new AdColonyAppOptions();
        }
        if (C0557a.m90e() && !C0795s.m807d(C0557a.m88c().mo10656q().mo10370b(), "reconfigurable")) {
            C0648h c = C0557a.m88c();
            if (!c.mo10656q().mo10369a().equals(str)) {
                new C0797u.C0798a().mo10920a("Ignoring call to AdColony.configure() as the app id does not ").mo10920a("match what was used during the initial configuration.").mo10922a(C0797u.f1092g);
                return false;
            } else if (C0717k0.m518a(strArr, c.mo10656q().mo10371c())) {
                new C0797u.C0798a().mo10920a("Ignoring call to AdColony.configure() as the same zone ids ").mo10920a("were used during the previous configuration.").mo10922a(C0797u.f1092g);
                return true;
            }
        }
        adColonyAppOptions.mo10367a(str);
        adColonyAppOptions.mo10368a(strArr);
        adColonyAppOptions.mo10374f();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss:SSS", Locale.US);
        long currentTimeMillis = System.currentTimeMillis();
        String format = simpleDateFormat.format(new Date(currentTimeMillis));
        boolean z = true;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] != null && !strArr[i].equals("")) {
                z = false;
            }
        }
        if (str.equals("") || z) {
            new C0797u.C0798a().mo10920a("AdColony.configure() called with an empty app or zone id String.").mo10922a(C0797u.f1094i);
            return false;
        }
        C0557a.f211c = true;
        if (Build.VERSION.SDK_INT < 14) {
            new C0797u.C0798a().mo10920a("The minimum API level for the AdColony SDK is 14.").mo10922a(C0797u.f1092g);
            C0557a.m82a(context, adColonyAppOptions, true);
        } else {
            C0557a.m82a(context, adColonyAppOptions, false);
        }
        String str2 = C0557a.m88c().mo10659t().mo10615f() + "/adc3/AppInfo";
        JSONObject b = C0795s.m798b();
        if (new File(str2).exists()) {
            b = C0795s.m804c(str2);
        }
        JSONObject b2 = C0795s.m798b();
        if (C0795s.m812h(b, "appId").equals(str)) {
            C0795s.m792a(b2, "zoneIds", C0795s.m780a(C0795s.m803c(b, "zoneIds"), strArr, true));
            C0795s.m791a(b2, "appId", str);
        } else {
            C0795s.m792a(b2, "zoneIds", C0795s.m781a(strArr));
            C0795s.m791a(b2, "appId", str);
        }
        C0795s.m813i(b2, str2);
        new C0797u.C0798a().mo10920a("Configure: Total Time (ms): ").mo10920a("" + (System.currentTimeMillis() - currentTimeMillis)).mo10920a(" and started at " + format).mo10922a(C0797u.f1093h);
        return true;
    }

    /* renamed from: a */
    static boolean m16a(AdColonyAdViewListener adColonyAdViewListener, String str) {
        if (adColonyAdViewListener == null || !C0557a.m89d()) {
            return false;
        }
        C0717k0.m515a((Runnable) new C0543b(str, adColonyAdViewListener));
        return false;
    }

    /* renamed from: a */
    static boolean m17a(AdColonyInterstitialListener adColonyInterstitialListener, String str) {
        if (adColonyInterstitialListener == null || !C0557a.m89d()) {
            return false;
        }
        C0717k0.m515a((Runnable) new C0542a(str, adColonyInterstitialListener));
        return false;
    }

    public static boolean addCustomMessageListener(@NonNull AdColonyCustomMessageListener adColonyCustomMessageListener, String str) {
        if (!C0557a.m91f()) {
            new C0797u.C0798a().mo10920a("Ignoring call to AdColony.addCustomMessageListener as AdColony ").mo10920a("has not yet been configured.").mo10922a(C0797u.f1092g);
            return false;
        } else if (!C0717k0.m538h(str)) {
            new C0797u.C0798a().mo10920a("Ignoring call to AdColony.addCustomMessageListener.").mo10922a(C0797u.f1092g);
            return false;
        } else {
            try {
                C0557a.m88c().mo10646g().put(str, adColonyCustomMessageListener);
                f100a.execute(new C0549h(str));
                return true;
            } catch (RejectedExecutionException unused) {
                return false;
            }
        }
    }

    /* renamed from: b */
    static void m18b() {
        new C0797u.C0798a().mo10920a("The AdColony API is not available while AdColony is disabled.").mo10922a(C0797u.f1094i);
    }

    public static boolean clearCustomMessageListeners() {
        if (!C0557a.m91f()) {
            new C0797u.C0798a().mo10920a("Ignoring call to AdColony.clearCustomMessageListeners as AdColony").mo10920a(" has not yet been configured.").mo10922a(C0797u.f1092g);
            return false;
        }
        C0557a.m88c().mo10646g().clear();
        f100a.execute(new C0551j());
        return true;
    }

    public static boolean configure(Activity activity, AdColonyAppOptions adColonyAppOptions, @NonNull String str, @NonNull String... strArr) {
        return m15a(activity, adColonyAppOptions, str, strArr);
    }

    public static boolean configure(Activity activity, @NonNull String str, @NonNull String... strArr) {
        return m15a(activity, (AdColonyAppOptions) null, str, strArr);
    }

    public static boolean configure(Application application, AdColonyAppOptions adColonyAppOptions, @NonNull String str, @NonNull String... strArr) {
        return m15a(application, adColonyAppOptions, str, strArr);
    }

    public static boolean configure(Application application, @NonNull String str, @NonNull String... strArr) {
        return configure(application, (AdColonyAppOptions) null, str, strArr);
    }

    public static boolean disable() {
        if (!C0557a.m91f()) {
            return false;
        }
        Context b = C0557a.m86b();
        if (b != null && (b instanceof C0560b)) {
            ((Activity) b).finish();
        }
        C0648h c = C0557a.m88c();
        for (AdColonyInterstitial cVar : c.mo10633b().mo10556a().values()) {
            C0717k0.m515a((Runnable) new C0544c(cVar));
        }
        C0717k0.m515a((Runnable) new C0545d(c));
        C0557a.m88c().mo10629a(true);
        return true;
    }

    public static AdColonyAppOptions getAppOptions() {
        if (!C0557a.m91f()) {
            return null;
        }
        return C0557a.m88c().mo10656q();
    }

    public static AdColonyCustomMessageListener getCustomMessageListener(@NonNull String str) {
        if (!C0557a.m91f()) {
            return null;
        }
        return C0557a.m88c().mo10646g().get(str);
    }

    public static AdColonyRewardListener getRewardListener() {
        if (!C0557a.m91f()) {
            return null;
        }
        return C0557a.m88c().mo10657r();
    }

    public static String getSDKVersion() {
        return !C0557a.m91f() ? "" : C0557a.m88c().mo10647h().mo10711E();
    }

    public static AdColonyZone getZone(@NonNull String str) {
        if (!C0557a.m91f()) {
            new C0797u.C0798a().mo10920a("Ignoring call to AdColony.getZone() as AdColony has not yet been ").mo10920a("configured.").mo10922a(C0797u.f1092g);
            return null;
        }
        HashMap<String, AdColonyZone> w = C0557a.m88c().mo10662w();
        if (w.containsKey(str)) {
            return w.get(str);
        }
        AdColonyZone adColonyZone = new AdColonyZone(str);
        C0557a.m88c().mo10662w().put(str, adColonyZone);
        return adColonyZone;
    }

    public static boolean notifyIAPComplete(@NonNull String str, @NonNull String str2) {
        return notifyIAPComplete(str, str2, (String) null, 0.0d);
    }

    public static boolean notifyIAPComplete(@NonNull String str, @NonNull String str2, String str3, @FloatRange(from = 0.0d) double d) {
        if (!C0557a.m91f()) {
            new C0797u.C0798a().mo10920a("Ignoring call to notifyIAPComplete as AdColony has not yet been ").mo10920a("configured.").mo10922a(C0797u.f1092g);
            return false;
        } else if (!C0717k0.m538h(str) || !C0717k0.m538h(str2)) {
            new C0797u.C0798a().mo10920a("Ignoring call to notifyIAPComplete as one of the passed Strings ").mo10920a("is greater than ").mo10918a(128).mo10920a(" characters.").mo10922a(C0797u.f1092g);
            return false;
        } else {
            if (str3 != null && str3.length() > 3) {
                new C0797u.C0798a().mo10920a("You are trying to report an IAP event with a currency String ").mo10920a("containing more than 3 characters.").mo10922a(C0797u.f1092g);
            }
            f100a.execute(new C0546e(d, str3, str, str2));
            return true;
        }
    }

    public static boolean removeCustomMessageListener(@NonNull String str) {
        if (!C0557a.m91f()) {
            new C0797u.C0798a().mo10920a("Ignoring call to AdColony.removeCustomMessageListener as AdColony").mo10920a(" has not yet been configured.").mo10922a(C0797u.f1092g);
            return false;
        }
        C0557a.m88c().mo10646g().remove(str);
        f100a.execute(new C0550i(str));
        return true;
    }

    public static boolean removeRewardListener() {
        if (!C0557a.m91f()) {
            new C0797u.C0798a().mo10920a("Ignoring call to AdColony.removeRewardListener() as AdColony has ").mo10920a("not yet been configured.").mo10922a(C0797u.f1092g);
            return false;
        }
        C0557a.m88c().mo10625a((AdColonyRewardListener) null);
        return true;
    }

    public static boolean requestAdView(@NonNull String str, @NonNull AdColonyAdViewListener adColonyAdViewListener, @NonNull AdColonyAdSize adColonyAdSize) {
        return requestAdView(str, adColonyAdViewListener, adColonyAdSize, (AdColonyAdOptions) null);
    }

    public static boolean requestAdView(@NonNull String str, @NonNull AdColonyAdViewListener adColonyAdViewListener, @NonNull AdColonyAdSize adColonyAdSize, AdColonyAdOptions adColonyAdOptions) {
        if (!C0557a.m91f()) {
            new C0797u.C0798a().mo10920a("Ignoring call to requestAdView as AdColony has not yet been").mo10920a(" configured.").mo10922a(C0797u.f1092g);
            m16a(adColonyAdViewListener, str);
            return false;
        } else if (adColonyAdSize.getHeight() <= 0 || adColonyAdSize.getWidth() <= 0) {
            new C0797u.C0798a().mo10920a("Ignoring call to requestAdView as you've provided an AdColonyAdSize").mo10920a(" object with an invalid width or height.").mo10922a(C0797u.f1092g);
            return false;
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("zone_id", str);
            if (C0609d0.m233a(1, bundle)) {
                m16a(adColonyAdViewListener, str);
                return false;
            }
            try {
                f100a.execute(new C0547f(adColonyAdViewListener, str, adColonyAdSize, adColonyAdOptions));
                return true;
            } catch (RejectedExecutionException unused) {
                m16a(adColonyAdViewListener, str);
                return false;
            }
        }
    }

    public static boolean requestInterstitial(@NonNull String str, @NonNull AdColonyInterstitialListener adColonyInterstitialListener) {
        return PinkiePie.DianePieNull();
    }

    public static boolean requestInterstitial(@NonNull String str, @NonNull AdColonyInterstitialListener adColonyInterstitialListener, AdColonyAdOptions adColonyAdOptions) {
        if (!C0557a.m91f()) {
            new C0797u.C0798a().mo10920a("Ignoring call to AdColony.requestInterstitial as AdColony has not").mo10920a(" yet been configured.").mo10922a(C0797u.f1092g);
            adColonyInterstitialListener.onRequestNotFilled(new AdColonyZone(str));
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("zone_id", str);
        if (C0609d0.m233a(1, bundle)) {
            AdColonyZone adColonyZone = C0557a.m88c().mo10662w().get(str);
            if (adColonyZone == null) {
                adColonyZone = new AdColonyZone(str);
                C0797u.C0798a a = new C0797u.C0798a().mo10920a("Zone info for ");
                a.mo10920a(str + " doesn't exist in hashmap").mo10922a(C0797u.f1089d);
            }
            adColonyInterstitialListener.onRequestNotFilled(adColonyZone);
            return false;
        }
        try {
            f100a.execute(new C0552k(adColonyInterstitialListener, str, adColonyAdOptions));
            return true;
        } catch (RejectedExecutionException unused) {
            m17a(adColonyInterstitialListener, str);
            return false;
        }
    }

    public static boolean setAppOptions(@NonNull AdColonyAppOptions adColonyAppOptions) {
        if (!C0557a.m91f()) {
            new C0797u.C0798a().mo10920a("Ignoring call to AdColony.setAppOptions() as AdColony has not yet").mo10920a(" been configured.").mo10922a(C0797u.f1092g);
            return false;
        }
        C0557a.m88c().mo10634b(adColonyAppOptions);
        adColonyAppOptions.mo10374f();
        try {
            f100a.execute(new C0548g(adColonyAppOptions));
            return true;
        } catch (RejectedExecutionException unused) {
            return false;
        }
    }

    public static boolean setRewardListener(@NonNull AdColonyRewardListener adColonyRewardListener) {
        if (!C0557a.m91f()) {
            new C0797u.C0798a().mo10920a("Ignoring call to AdColony.setRewardListener() as AdColony has not").mo10920a(" yet been configured.").mo10922a(C0797u.f1092g);
            return false;
        }
        C0557a.m88c().mo10625a(adColonyRewardListener);
        return true;
    }
}
