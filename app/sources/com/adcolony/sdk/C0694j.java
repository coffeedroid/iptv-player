package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings;
import android.security.NetworkSecurityPolicy;
import android.support.p000v4.p002os.EnvironmentCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebView;
import com.adcolony.sdk.C0797u;
import com.google.android.gms.common.internal.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.j */
class C0694j {

    /* renamed from: i */
    private static int f766i = 2;

    /* renamed from: j */
    static final String f767j = "Production";

    /* renamed from: a */
    private String f768a = "";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f769b;

    /* renamed from: c */
    private boolean f770c;

    /* renamed from: d */
    private boolean f771d;

    /* renamed from: e */
    private JSONObject f772e = C0795s.m798b();

    /* renamed from: f */
    private String f773f = "android";

    /* renamed from: g */
    private String f774g = "android_native";

    /* renamed from: h */
    private String f775h = "";

    /* renamed from: com.adcolony.sdk.j$a */
    class C0695a implements C0816z {

        /* renamed from: com.adcolony.sdk.j$a$a */
        class C0696a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0812x f777a;

            C0696a(C0812x xVar) {
                this.f777a = xVar;
            }

            public void run() {
                try {
                    if (C0694j.this.mo10729f() < 14) {
                        new C0699d(this.f777a, false).execute(new Void[0]);
                    } else {
                        new C0699d(this.f777a, false).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    }
                } catch (RuntimeException unused) {
                    new C0797u.C0798a().mo10920a("Error retrieving device info, disabling AdColony.").mo10922a(C0797u.f1095j);
                    AdColony.disable();
                }
            }
        }

        C0695a() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0717k0.m515a((Runnable) new C0696a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.j$b */
    class C0697b implements C0816z {
        C0697b() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            JSONObject b = C0795s.m798b();
            C0795s.m802b(b, "result", C0717k0.m534f(C0795s.m812h(xVar.mo10941b(), MediationMetaData.KEY_NAME)));
            C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, true);
            xVar.mo10940a(b).mo10945d();
        }
    }

    /* renamed from: com.adcolony.sdk.j$c */
    class C0698c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f780a;

        C0698c(Context context) {
            this.f780a = context;
        }

        public void run() {
            try {
                String unused = C0694j.this.f769b = new WebView(this.f780a).getSettings().getUserAgentString();
            } catch (RuntimeException e) {
                C0797u.C0798a aVar = new C0797u.C0798a();
                aVar.mo10920a(e.toString() + ": during WebView initialization.").mo10920a(" Disabling AdColony.").mo10922a(C0797u.f1094i);
                String unused2 = C0694j.this.f769b = "";
                AdColony.disable();
            }
            C0557a.m88c().mo10649j().mo10814a(C0694j.this.f769b);
        }
    }

    /* renamed from: com.adcolony.sdk.j$d */
    private static class C0699d extends AsyncTask<Void, Void, JSONObject> {

        /* renamed from: a */
        private C0812x f782a;

        /* renamed from: b */
        private boolean f783b;

        C0699d(C0812x xVar, boolean z) {
            this.f782a = xVar;
            this.f783b = z;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public JSONObject doInBackground(Void... voidArr) {
            if (Build.VERSION.SDK_INT < 14) {
                return null;
            }
            return C0557a.m88c().mo10647h().mo10738o();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(JSONObject jSONObject) {
            if (this.f783b) {
                new C0812x("Device.update_info", 1, jSONObject).mo10945d();
            } else {
                this.f782a.mo10940a(jSONObject).mo10945d();
            }
        }
    }

    C0694j() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public String mo10707A() {
        return Build.MODEL;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public int mo10708B() {
        Context b = C0557a.m86b();
        if (b == null) {
            return 2;
        }
        int i = b.getResources().getConfiguration().orientation;
        if (i != 1) {
            return i != 2 ? 2 : 1;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C */
    public String mo10709C() {
        return Build.VERSION.RELEASE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D */
    public String mo10710D() {
        Context b = C0557a.m86b();
        return b == null ? EnvironmentCompat.MEDIA_UNKNOWN : b.getPackageName();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public String mo10711E() {
        return "4.1.4";
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r0 = (android.telephony.TelephonyManager) r0.getSystemService("phone");
     */
    /* renamed from: F */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo10712F() {
        /*
            r2 = this;
            android.content.Context r0 = com.adcolony.sdk.C0557a.m86b()
            if (r0 != 0) goto L_0x0009
            java.lang.String r0 = ""
            return r0
        L_0x0009:
            java.lang.String r1 = "phone"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            if (r0 != 0) goto L_0x0016
            java.lang.String r0 = ""
            goto L_0x001a
        L_0x0016:
            java.lang.String r0 = r0.getSimCountryIso()
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0694j.mo10712F():java.lang.String");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: G */
    public int mo10713G() {
        return TimeZone.getDefault().getOffset(15) / 60000;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: H */
    public String mo10714H() {
        return TimeZone.getDefault().getID();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: I */
    public String mo10715I() {
        Context b;
        if (this.f769b == null && (b = C0557a.m86b()) != null) {
            C0717k0.m515a((Runnable) new C0698c(b));
        }
        return this.f769b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: J */
    public boolean mo10716J() {
        if (!C0557a.m89d()) {
            return false;
        }
        int B = mo10708B();
        if (B != 0) {
            if (B == 1 && f766i == 0) {
                new C0797u.C0798a().mo10920a("Sending device info update").mo10922a(C0797u.f1091f);
                f766i = B;
                if (mo10729f() < 14) {
                    new C0699d((C0812x) null, true).execute(new Void[0]);
                } else {
                    new C0699d((C0812x) null, true).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                }
                return true;
            }
        } else if (f766i == 1) {
            new C0797u.C0798a().mo10920a("Sending device info update").mo10922a(C0797u.f1091f);
            f766i = B;
            if (mo10729f() < 14) {
                new C0699d((C0812x) null, true).execute(new Void[0]);
            } else {
                new C0699d((C0812x) null, true).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: K */
    public void mo10717K() {
        this.f770c = false;
        C0557a.m84a("Device.get_info", (C0816z) new C0695a());
        C0557a.m84a("Device.application_exists", (C0816z) new C0697b());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: L */
    public boolean mo10718L() {
        Context b = C0557a.m86b();
        if (b == null) {
            return false;
        }
        DisplayMetrics displayMetrics = b.getResources().getDisplayMetrics();
        float f = ((float) displayMetrics.widthPixels) / displayMetrics.xdpi;
        float f2 = ((float) displayMetrics.heightPixels) / displayMetrics.ydpi;
        return Math.sqrt((double) ((f * f) + (f2 * f2))) >= 6.0d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo10719a() {
        return System.getProperty("os.arch").toLowerCase(Locale.ENGLISH);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10720a(String str) {
        this.f768a = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10721a(JSONObject jSONObject) {
        this.f772e = jSONObject;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10722a(boolean z) {
        this.f770c = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo10723b() {
        return this.f768a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10724b(String str) {
        this.f775h = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10725b(boolean z) {
        this.f771d = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo10726c() {
        Context b = C0557a.m86b();
        return b == null ? "" : Settings.Secure.getString(b.getContentResolver(), "advertising_id");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo10727d() {
        Context b = C0557a.m86b();
        if (b == null) {
            return false;
        }
        try {
            return Settings.Secure.getInt(b.getContentResolver(), "limit_ad_tracking") != 0;
        } catch (Settings.SettingNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"HardwareIds"})
    /* renamed from: e */
    public String mo10728e() {
        Context b = C0557a.m86b();
        return b == null ? "" : Settings.Secure.getString(b.getContentResolver(), "android_id");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo10729f() {
        return Build.VERSION.SDK_INT;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public double mo10730g() {
        Context b = C0557a.m86b();
        if (b == null) {
            return 0.0d;
        }
        try {
            Intent registerReceiver = b.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null) {
                return 0.0d;
            }
            int intExtra = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            if (intExtra < 0 || intExtra2 < 0) {
                return 0.0d;
            }
            double d = (double) intExtra;
            double d2 = (double) intExtra2;
            Double.isNaN(d);
            Double.isNaN(d2);
            return d / d2;
        } catch (IllegalArgumentException unused) {
            return 0.0d;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public String mo10731h() {
        Context b = C0557a.m86b();
        if (b == null) {
            return "";
        }
        TelephonyManager telephonyManager = (TelephonyManager) b.getSystemService("phone");
        String networkOperatorName = telephonyManager == null ? "" : telephonyManager.getNetworkOperatorName();
        return networkOperatorName.length() == 0 ? EnvironmentCompat.MEDIA_UNKNOWN : networkOperatorName;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo10732i() {
        return Build.VERSION.SDK_INT < 23 || NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public String mo10733j() {
        return this.f775h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public String mo10734k() {
        return Locale.getDefault().getCountry();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public int mo10735l() {
        TimeZone timeZone = TimeZone.getDefault();
        if (!timeZone.inDaylightTime(new Date())) {
            return 0;
        }
        return timeZone.getDSTSavings() / 60000;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r0 = r0.getResources().getConfiguration().uiMode & 48;
     */
    /* renamed from: m */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo10736m() {
        /*
            r4 = this;
            android.content.Context r0 = com.adcolony.sdk.C0557a.m86b()
            r1 = 0
            if (r0 == 0) goto L_0x0024
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 29
            if (r2 >= r3) goto L_0x000e
            goto L_0x0024
        L_0x000e:
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.uiMode
            r0 = r0 & 48
            r2 = 16
            if (r0 == r2) goto L_0x0024
            r2 = 32
            if (r0 == r2) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r1 = 1
        L_0x0024:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0694j.mo10736m():boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public float mo10737n() {
        Context b = C0557a.m86b();
        if (b == null) {
            return 0.0f;
        }
        return b.getResources().getDisplayMetrics().density;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public JSONObject mo10738o() {
        JSONObject b = C0795s.m798b();
        C0648h c = C0557a.m88c();
        C0795s.m791a(b, "carrier_name", mo10731h());
        C0795s.m791a(b, "data_path", C0557a.m88c().mo10659t().mo10611b());
        C0795s.m801b(b, "device_api", mo10729f());
        C0795s.m801b(b, "display_width", mo10742s());
        C0795s.m801b(b, "display_height", mo10741r());
        C0795s.m801b(b, "screen_width", mo10742s());
        C0795s.m801b(b, "screen_height", mo10741r());
        C0795s.m801b(b, "display_dpi", mo10740q());
        C0795s.m791a(b, "device_type", mo10739p());
        C0795s.m791a(b, "locale_language_code", mo10743t());
        C0795s.m791a(b, "ln", mo10743t());
        C0795s.m791a(b, "locale_country_code", mo10734k());
        C0795s.m791a(b, "locale", mo10734k());
        C0795s.m791a(b, "mac_address", mo10746w());
        C0795s.m791a(b, "manufacturer", mo10747x());
        C0795s.m791a(b, "device_brand", mo10747x());
        C0795s.m791a(b, "media_path", C0557a.m88c().mo10659t().mo10612c());
        C0795s.m791a(b, "temp_storage_path", C0557a.m88c().mo10659t().mo10613d());
        C0795s.m801b(b, "memory_class", mo10748y());
        C0795s.m801b(b, "network_speed", 20);
        C0795s.m790a(b, "memory_used_mb", mo10749z());
        C0795s.m791a(b, "model", mo10707A());
        C0795s.m791a(b, "device_model", mo10707A());
        C0795s.m791a(b, "sdk_type", this.f774g);
        C0795s.m791a(b, "sdk_version", mo10711E());
        C0795s.m791a(b, "network_type", c.mo10653n().mo10500a());
        C0795s.m791a(b, "os_version", mo10709C());
        C0795s.m791a(b, "os_name", this.f773f);
        C0795s.m791a(b, "platform", this.f773f);
        C0795s.m791a(b, "arch", mo10719a());
        C0795s.m791a(b, "user_id", C0795s.m812h(c.mo10656q().f159d, "user_id"));
        C0795s.m791a(b, "app_id", c.mo10656q().f156a);
        C0795s.m791a(b, "app_bundle_name", C0717k0.m529d());
        C0795s.m791a(b, "app_bundle_version", C0717k0.m531e());
        C0795s.m789a(b, "battery_level", mo10730g());
        C0795s.m791a(b, "cell_service_country_code", mo10712F());
        C0795s.m791a(b, "timezone_ietf", mo10714H());
        C0795s.m801b(b, "timezone_gmt_m", mo10713G());
        C0795s.m801b(b, "timezone_dst_m", mo10735l());
        C0795s.m793a(b, "launch_metadata", mo10744u());
        C0795s.m791a(b, "controller_version", c.mo10637c());
        int B = mo10708B();
        f766i = B;
        C0795s.m801b(b, "current_orientation", B);
        C0795s.m802b(b, "cleartext_permitted", mo10732i());
        C0795s.m789a(b, Constants.PARAM_DENSITY, (double) mo10737n());
        C0795s.m802b(b, "dark_mode", mo10736m());
        JSONArray a = C0795s.m778a();
        if (C0717k0.m534f("com.android.vending")) {
            a.put("google");
        }
        if (C0717k0.m534f("com.amazon.venezia")) {
            a.put("amazon");
        }
        C0795s.m792a(b, "available_stores", a);
        C0795s.m792a(b, "permissions", C0717k0.m525c(C0557a.m86b()));
        int i = 40;
        while (!this.f770c && i > 0) {
            try {
                Thread.sleep(50);
                i--;
            } catch (Exception unused) {
            }
        }
        C0795s.m791a(b, "advertiser_id", mo10723b());
        C0795s.m802b(b, "limit_tracking", mo10745v());
        if (mo10723b() == null || mo10723b().equals("")) {
            C0795s.m791a(b, "android_id_sha1", C0717k0.m522b(mo10728e()));
        }
        return b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public String mo10739p() {
        return mo10718L() ? "tablet" : "phone";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public int mo10740q() {
        Context b = C0557a.m86b();
        if (b == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) b.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.densityDpi;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public int mo10741r() {
        Context b = C0557a.m86b();
        if (b == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) b.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public int mo10742s() {
        Context b = C0557a.m86b();
        if (b == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) b.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public String mo10743t() {
        return Locale.getDefault().getLanguage();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public JSONObject mo10744u() {
        return this.f772e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public boolean mo10745v() {
        return this.f771d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public String mo10746w() {
        return "";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public String mo10747x() {
        return Build.MANUFACTURER;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public int mo10748y() {
        ActivityManager activityManager;
        Context b = C0557a.m86b();
        if (b == null || (activityManager = (ActivityManager) b.getSystemService("activity")) == null) {
            return 0;
        }
        return activityManager.getMemoryClass();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public long mo10749z() {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / ((long) 1048576);
    }
}
