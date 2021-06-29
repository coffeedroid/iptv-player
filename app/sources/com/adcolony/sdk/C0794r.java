package com.adcolony.sdk;

/* renamed from: com.adcolony.sdk.r */
class C0794r {

    /* renamed from: a */
    private String f1083a;

    /* renamed from: b */
    private String f1084b;

    /* renamed from: c */
    private String f1085c;

    /* renamed from: d */
    private String f1086d = "%s_%s_%s";

    public C0794r(String str, String str2, String str3) {
        this.f1083a = str;
        this.f1084b = str2;
        this.f1085c = str3;
    }

    /* renamed from: a */
    public String mo10911a() {
        return this.f1085c;
    }

    /* renamed from: b */
    public String mo10912b() {
        return String.format(this.f1086d, new Object[]{mo10913c(), mo10914d(), mo10911a()});
    }

    /* renamed from: c */
    public String mo10913c() {
        return this.f1083a;
    }

    /* renamed from: d */
    public String mo10914d() {
        return this.f1084b;
    }
}
