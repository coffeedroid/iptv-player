package com.adcolony.sdk;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.adcolony.sdk.v */
class C0799v {

    /* renamed from: e */
    static final SimpleDateFormat f1099e = new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ", Locale.US);

    /* renamed from: f */
    static final String f1100f = "message";

    /* renamed from: g */
    static final String f1101g = "timestamp";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Date f1102a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f1103b;

    /* renamed from: c */
    protected String f1104c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C0794r f1105d;

    /* renamed from: com.adcolony.sdk.v$a */
    static class C0800a {

        /* renamed from: a */
        protected C0799v f1106a = new C0799v();

        C0800a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0800a mo10931a(int i) {
            int unused = this.f1106a.f1103b = i;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0800a mo10932a(C0794r rVar) {
            C0794r unused = this.f1106a.f1105d = rVar;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0800a mo10933a(String str) {
            this.f1106a.f1104c = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0800a mo10884a(Date date) {
            Date unused = this.f1106a.f1102a = date;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0799v mo10934a() {
            if (this.f1106a.f1102a == null) {
                Date unused = this.f1106a.f1102a = new Date(System.currentTimeMillis());
            }
            return this.f1106a;
        }
    }

    C0799v() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0794r mo10923a() {
        return this.f1105d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10924a(int i) {
        this.f1103b = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10925a(C0794r rVar) {
        this.f1105d = rVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo10926b() {
        return this.f1103b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo10927c() {
        switch (this.f1103b) {
            case -1:
                return "Fatal";
            case 0:
                return "Error";
            case 1:
                return "Warn";
            case 2:
                return "Info";
            case 3:
                return "Debug";
            default:
                return "UNKNOWN LOG LEVEL";
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo10928d() {
        return this.f1104c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo10929e() {
        return f1099e.format(this.f1102a);
    }

    public String toString() {
        return mo10929e() + " " + mo10927c() + "/" + mo10923a().mo10911a() + ": " + mo10928d();
    }
}
