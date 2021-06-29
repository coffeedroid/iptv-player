package com.adcolony.sdk;

/* renamed from: com.adcolony.sdk.u */
class C0797u {

    /* renamed from: c */
    static C0797u f1088c = new C0797u(3, false);

    /* renamed from: d */
    static C0797u f1089d = new C0797u(3, true);

    /* renamed from: e */
    static C0797u f1090e = new C0797u(2, false);

    /* renamed from: f */
    static C0797u f1091f = new C0797u(2, true);

    /* renamed from: g */
    static C0797u f1092g = new C0797u(1, false);

    /* renamed from: h */
    static C0797u f1093h = new C0797u(1, true);

    /* renamed from: i */
    static C0797u f1094i = new C0797u(0, false);

    /* renamed from: j */
    static C0797u f1095j = new C0797u(0, true);

    /* renamed from: a */
    private int f1096a;

    /* renamed from: b */
    private boolean f1097b;

    /* renamed from: com.adcolony.sdk.u$a */
    static class C0798a {

        /* renamed from: a */
        StringBuilder f1098a = new StringBuilder();

        C0798a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0798a mo10916a(char c) {
            if (c != 10) {
                this.f1098a.append(c);
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0798a mo10917a(double d) {
            C0717k0.m512a(d, 2, this.f1098a);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0798a mo10918a(int i) {
            this.f1098a.append(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0798a mo10919a(Object obj) {
            if (obj != null) {
                this.f1098a.append(obj.toString());
            } else {
                this.f1098a.append("null");
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0798a mo10920a(String str) {
            this.f1098a.append(str);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0798a mo10921a(boolean z) {
            this.f1098a.append(z);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo10922a(C0797u uVar) {
            uVar.m816a(this.f1098a.toString());
        }
    }

    C0797u(int i, boolean z) {
        this.f1096a = i;
        this.f1097b = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m816a(String str) {
        C0801w.m843a(this.f1096a, str, this.f1097b);
    }
}
