package com.adcolony.sdk;

import com.adcolony.sdk.C0799v;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.Date;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.settings.SettingsJsonConstants;

/* renamed from: com.adcolony.sdk.o */
class C0766o extends C0799v {

    /* renamed from: i */
    static final C0794r f1022i = new C0794r("adcolony_fatal_reports", "4.1.4", "Production");

    /* renamed from: j */
    static final String f1023j = "sourceFile";

    /* renamed from: k */
    static final String f1024k = "lineNumber";

    /* renamed from: l */
    static final String f1025l = "methodName";

    /* renamed from: m */
    static final String f1026m = "stackTrace";

    /* renamed from: n */
    static final String f1027n = "isAdActive";

    /* renamed from: o */
    static final String f1028o = "activeAdId";

    /* renamed from: p */
    static final String f1029p = "active_creative_ad_id";

    /* renamed from: q */
    static final String f1030q = "listOfCachedAds";

    /* renamed from: r */
    static final String f1031r = "listOfCreativeAdIds";

    /* renamed from: s */
    static final String f1032s = "adCacheSize";
    /* access modifiers changed from: private */

    /* renamed from: h */
    public JSONObject f1033h;

    /* renamed from: com.adcolony.sdk.o$a */
    private class C0767a extends C0799v.C0800a {
        C0767a() {
            this.f1106a = new C0766o();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0767a mo10883a(JSONObject jSONObject) {
            JSONObject unused = ((C0766o) this.f1106a).f1033h = jSONObject;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0799v.C0800a mo10884a(Date date) {
            C0795s.m791a(((C0766o) this.f1106a).f1033h, AppMeasurement.Param.TIMESTAMP, C0799v.f1099e.format(date));
            return super.mo10884a(date);
        }
    }

    C0766o() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0766o mo10881a(JSONObject jSONObject) {
        C0767a aVar = new C0767a();
        aVar.mo10883a(jSONObject);
        aVar.mo10933a(C0795s.m812h(jSONObject, SettingsJsonConstants.PROMPT_MESSAGE_KEY));
        try {
            aVar.mo10884a(new Date(Long.parseLong(C0795s.m812h(jSONObject, AppMeasurement.Param.TIMESTAMP))));
        } catch (NumberFormatException unused) {
        }
        aVar.mo10932a(f1022i);
        aVar.mo10931a(-1);
        return (C0766o) aVar.mo10934a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public JSONObject mo10882f() {
        return this.f1033h;
    }
}
