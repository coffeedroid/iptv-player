package com.adcolony.sdk;

import android.content.Context;
import com.adcolony.sdk.C0797u;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.settings.SettingsJsonConstants;

/* renamed from: com.adcolony.sdk.a */
class C0557a {

    /* renamed from: a */
    private static WeakReference<Context> f209a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static C0648h f210b;

    /* renamed from: c */
    static boolean f211c;

    /* renamed from: d */
    static boolean f212d;

    /* renamed from: com.adcolony.sdk.a$a */
    static class C0558a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f213a;

        C0558a(Context context) {
            this.f213a = context;
        }

        public void run() {
            C0557a.f210b.mo10631a(this.f213a, (C0812x) null);
        }
    }

    C0557a() {
    }

    /* renamed from: a */
    static C0816z m80a(String str, C0816z zVar, boolean z) {
        m88c().mo10652m().mo10949a(str, zVar);
        return zVar;
    }

    /* renamed from: a */
    static void m81a(Context context) {
        if (context == null) {
            f209a.clear();
        } else {
            f209a = new WeakReference<>(context);
        }
    }

    /* renamed from: a */
    static void m82a(Context context, AdColonyAppOptions adColonyAppOptions, boolean z) {
        m81a(context);
        f212d = true;
        C0648h hVar = f210b;
        if (hVar == null) {
            C0648h hVar2 = new C0648h();
            f210b = hVar2;
            hVar2.mo10623a(adColonyAppOptions, z);
        } else {
            hVar.mo10622a(adColonyAppOptions);
        }
        C0717k0.f836b.execute(new C0558a(context));
        new C0797u.C0798a().mo10920a("Configuring AdColony").mo10922a(C0797u.f1090e);
        f210b.mo10636b(false);
        f210b.mo10658s().mo10600d(true);
        f210b.mo10658s().mo10603e(true);
        f210b.mo10658s().mo10604f(false);
        C0648h hVar3 = f210b;
        hVar3.f671H = true;
        hVar3.mo10658s().mo10598c(false);
    }

    /* renamed from: a */
    static void m83a(String str) {
        try {
            C0812x xVar = new C0812x("CustomMessage.send", 0);
            xVar.mo10941b().put(SettingsJsonConstants.PROMPT_MESSAGE_KEY, str);
            xVar.mo10945d();
        } catch (JSONException e) {
            new C0797u.C0798a().mo10920a("JSON error from ADC.java's send_custom_message(): ").mo10920a(e.toString()).mo10922a(C0797u.f1095j);
        }
    }

    /* renamed from: a */
    static void m84a(String str, C0816z zVar) {
        m88c().mo10652m().mo10949a(str, zVar);
    }

    /* renamed from: a */
    static void m85a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = C0795s.m798b();
        }
        C0795s.m791a(jSONObject, "m_type", str);
        m88c().mo10652m().mo10951a(jSONObject);
    }

    /* renamed from: b */
    static Context m86b() {
        WeakReference<Context> weakReference = f209a;
        if (weakReference == null) {
            return null;
        }
        return (Context) weakReference.get();
    }

    /* renamed from: b */
    static void m87b(String str, C0816z zVar) {
        m88c().mo10652m().mo10953b(str, zVar);
    }

    /* renamed from: c */
    static C0648h m88c() {
        if (!m90e()) {
            Context b = m86b();
            if (b == null) {
                return new C0648h();
            }
            f210b = new C0648h();
            JSONObject c = C0795s.m804c(b.getFilesDir().getAbsolutePath() + "/adc3/AppInfo");
            JSONArray c2 = C0795s.m803c(c, "zoneIds");
            f210b.mo10623a(new AdColonyAppOptions().mo10367a(C0795s.m812h(c, "appId")).mo10368a(C0795s.m795a(c2)), false);
        }
        return f210b;
    }

    /* renamed from: d */
    static boolean m89d() {
        WeakReference<Context> weakReference = f209a;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* renamed from: e */
    static boolean m90e() {
        return f210b != null;
    }

    /* renamed from: f */
    static boolean m91f() {
        return f211c;
    }

    /* renamed from: g */
    static void m92g() {
        m88c().mo10652m().mo10956e();
    }
}
