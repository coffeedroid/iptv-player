package com.adcolony.sdk;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.adcolony.sdk.C0797u;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdColonyInterstitialActivity extends C0560b {

    /* renamed from: m */
    AdColonyInterstitial f179m;

    /* renamed from: n */
    private C0646g f180n;

    public AdColonyInterstitialActivity() {
        this.f179m = !C0557a.m90e() ? null : C0557a.m88c().mo10640d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10437a(AdColonyInterstitial adColonyInterstitial) {
        this.f179m = adColonyInterstitial;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10438a(C0812x xVar) {
        AdColonyInterstitial adColonyInterstitial;
        super.mo10438a(xVar);
        C0580d b = C0557a.m88c().mo10633b();
        JSONObject g = C0795s.m811g(xVar.mo10941b(), "v4iap");
        JSONArray c = C0795s.m803c(g, "product_ids");
        if (!(g == null || (adColonyInterstitial = this.f179m) == null || adColonyInterstitial.getListener() == null || c.length() <= 0)) {
            this.f179m.getListener().onIAPEvent(this.f179m, C0795s.m806d(c, 0), C0795s.m810f(g, "engagement_type"));
        }
        b.mo10557a(this.f216a);
        if (this.f179m != null) {
            b.mo10556a().remove(this.f179m.mo10419b());
        }
        AdColonyInterstitial adColonyInterstitial2 = this.f179m;
        if (!(adColonyInterstitial2 == null || adColonyInterstitial2.getListener() == null)) {
            this.f179m.getListener().onClosed(this.f179m);
            this.f179m.mo10414a((C0563c) null);
            this.f179m.setListener((AdColonyInterstitialListener) null);
            this.f179m = null;
        }
        C0646g gVar = this.f180n;
        if (gVar != null) {
            gVar.mo10606a();
            this.f180n = null;
        }
        new C0797u.C0798a().mo10920a("finish_ad call finished").mo10922a(C0797u.f1091f);
    }

    public /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }

    public /* bridge */ /* synthetic */ void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        AdColonyInterstitial adColonyInterstitial;
        AdColonyInterstitial adColonyInterstitial2 = this.f179m;
        this.f217b = adColonyInterstitial2 == null ? -1 : adColonyInterstitial2.mo10428f();
        super.onCreate(bundle);
        if (C0557a.m90e() && (adColonyInterstitial = this.f179m) != null) {
            C0576c0 e = adColonyInterstitial.mo10427e();
            if (e != null) {
                e.mo10547a(this.f216a);
            }
            this.f180n = new C0646g(new Handler(Looper.getMainLooper()), this.f179m);
            if (this.f179m.getListener() != null) {
                this.f179m.getListener().onOpened(this.f179m);
            }
        }
    }

    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    public /* bridge */ /* synthetic */ void onPause() {
        super.onPause();
    }

    public /* bridge */ /* synthetic */ void onResume() {
        super.onResume();
    }

    public /* bridge */ /* synthetic */ void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
