package com.adcolony.sdk;

public abstract class AdColonyAdViewListener {

    /* renamed from: a */
    String f153a = "";

    /* renamed from: b */
    AdColonyAdSize f154b;

    /* renamed from: c */
    C0576c0 f155c;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AdColonyAdSize mo10355a() {
        return this.f154b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10356a(AdColonyAdSize adColonyAdSize) {
        this.f154b = adColonyAdSize;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10357a(C0576c0 c0Var) {
        this.f155c = c0Var;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10358a(String str) {
        this.f153a = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0576c0 mo10359b() {
        return this.f155c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo10360c() {
        return this.f153a;
    }

    public void onClicked(AdColonyAdView adColonyAdView) {
    }

    public void onClosed(AdColonyAdView adColonyAdView) {
    }

    public void onLeftApplication(AdColonyAdView adColonyAdView) {
    }

    public void onOpened(AdColonyAdView adColonyAdView) {
    }

    public abstract void onRequestFilled(AdColonyAdView adColonyAdView);

    public void onRequestNotFilled(AdColonyZone adColonyZone) {
    }
}
