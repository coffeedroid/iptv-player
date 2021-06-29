package com.adcolony.sdk;

import com.adcolony.sdk.C0797u;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.x */
class C0812x {

    /* renamed from: a */
    private String f1125a;

    /* renamed from: b */
    private JSONObject f1126b;

    C0812x(String str, int i) {
        try {
            this.f1125a = str;
            JSONObject jSONObject = new JSONObject();
            this.f1126b = jSONObject;
            jSONObject.put("m_target", i);
        } catch (JSONException e) {
            new C0797u.C0798a().mo10920a("JSON Error in ADCMessage constructor: ").mo10920a(e.toString()).mo10922a(C0797u.f1095j);
        }
    }

    C0812x(String str, int i, String str2) {
        try {
            this.f1125a = str;
            JSONObject b = C0795s.m799b(str2);
            this.f1126b = b;
            b.put("m_target", i);
        } catch (JSONException e) {
            new C0797u.C0798a().mo10920a("JSON Error in ADCMessage constructor: ").mo10920a(e.toString()).mo10922a(C0797u.f1095j);
        }
    }

    C0812x(String str, int i, JSONObject jSONObject) {
        try {
            this.f1125a = str;
            jSONObject = jSONObject == null ? new JSONObject() : jSONObject;
            this.f1126b = jSONObject;
            jSONObject.put("m_target", i);
        } catch (JSONException e) {
            new C0797u.C0798a().mo10920a("JSON Error in ADCMessage constructor: ").mo10920a(e.toString()).mo10922a(C0797u.f1095j);
        }
    }

    C0812x(JSONObject jSONObject) {
        try {
            this.f1126b = jSONObject;
            this.f1125a = jSONObject.getString("m_type");
        } catch (JSONException e) {
            new C0797u.C0798a().mo10920a("JSON Error in ADCMessage constructor: ").mo10920a(e.toString()).mo10922a(C0797u.f1095j);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0812x mo10938a() {
        return mo10940a((JSONObject) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0812x mo10939a(String str) {
        return mo10940a(C0795s.m799b(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0812x mo10940a(JSONObject jSONObject) {
        try {
            C0812x xVar = new C0812x("reply", this.f1126b.getInt("m_origin"), jSONObject);
            xVar.f1126b.put("m_id", this.f1126b.getInt("m_id"));
            return xVar;
        } catch (JSONException e) {
            new C0797u.C0798a().mo10920a("JSON error in ADCMessage's createReply(): ").mo10920a(e.toString()).mo10922a(C0797u.f1095j);
            return new C0812x("JSONException", 0);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public JSONObject mo10941b() {
        return this.f1126b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10942b(String str) {
        this.f1125a = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10943b(JSONObject jSONObject) {
        this.f1126b = jSONObject;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo10944c() {
        return this.f1125a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo10945d() {
        C0557a.m85a(this.f1125a, this.f1126b);
    }
}
