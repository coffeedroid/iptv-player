package com.adcolony.sdk;

import android.support.annotation.NonNull;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.settings.SettingsJsonConstants;

public class AdColonyCustomMessage {

    /* renamed from: a */
    String f161a;

    /* renamed from: b */
    String f162b;

    /* renamed from: com.adcolony.sdk.AdColonyCustomMessage$a */
    class C0556a implements Runnable {
        C0556a() {
        }

        public void run() {
            AdColony.m14a();
            JSONObject b = C0795s.m798b();
            C0795s.m791a(b, AppMeasurement.Param.TYPE, AdColonyCustomMessage.this.f161a);
            C0795s.m791a(b, SettingsJsonConstants.PROMPT_MESSAGE_KEY, AdColonyCustomMessage.this.f162b);
            new C0812x("CustomMessage.native_send", 1, b).mo10945d();
        }
    }

    public AdColonyCustomMessage(@NonNull String str, @NonNull String str2) {
        if (C0717k0.m538h(str) || C0717k0.m538h(str2)) {
            this.f161a = str;
            this.f162b = str2;
        }
    }

    public String getMessage() {
        return this.f162b;
    }

    public String getType() {
        return this.f161a;
    }

    public void send() {
        try {
            AdColony.f100a.execute(new C0556a());
        } catch (RejectedExecutionException unused) {
        }
    }

    public AdColonyCustomMessage set(String str, String str2) {
        this.f161a = str;
        this.f162b = str2;
        return this;
    }
}
