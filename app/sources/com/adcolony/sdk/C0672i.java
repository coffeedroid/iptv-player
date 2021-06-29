package com.adcolony.sdk;

import com.adcolony.sdk.C0797u;
import com.google.android.gms.measurement.AppMeasurement;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.settings.SettingsJsonConstants;

/* renamed from: com.adcolony.sdk.i */
class C0672i implements C0816z {

    /* renamed from: com.adcolony.sdk.i$a */
    class C0673a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f741a;

        /* renamed from: b */
        final /* synthetic */ String f742b;

        C0673a(String str, String str2) {
            this.f741a = str;
            this.f742b = str2;
        }

        public void run() {
            new C0797u.C0798a().mo10920a("Received custom message ").mo10920a(this.f741a).mo10920a(" of type ").mo10920a(this.f742b).mo10922a(C0797u.f1091f);
            try {
                AdColonyCustomMessageListener adColonyCustomMessageListener = C0557a.m88c().mo10646g().get(this.f742b);
                if (adColonyCustomMessageListener != null) {
                    adColonyCustomMessageListener.onAdColonyCustomMessage(new AdColonyCustomMessage(this.f742b, this.f741a));
                }
            } catch (RuntimeException unused) {
            }
        }
    }

    C0672i() {
        C0557a.m84a("CustomMessage.controller_send", (C0816z) this);
    }

    /* renamed from: a */
    public void mo10499a(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        C0717k0.m515a((Runnable) new C0673a(C0795s.m812h(b, SettingsJsonConstants.PROMPT_MESSAGE_KEY), C0795s.m812h(b, AppMeasurement.Param.TYPE)));
    }
}
