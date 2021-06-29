package com.adcolony.sdk;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;

public class AdColonyAdViewActivity extends C0560b {

    /* renamed from: m */
    AdColonyAdView f152m;

    public AdColonyAdViewActivity() {
        this.f152m = !C0557a.m90e() ? null : C0557a.m88c().mo10643e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10346b() {
        ViewParent parent = this.f216a.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.f216a);
        }
        this.f152m.mo10321a();
        C0557a.m88c().mo10621a((AdColonyAdView) null);
        finish();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo10347c() {
        this.f152m.mo10322b();
    }

    public void onBackPressed() {
        mo10346b();
    }

    public /* bridge */ /* synthetic */ void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        AdColonyAdView adColonyAdView;
        if (!C0557a.m90e() || (adColonyAdView = this.f152m) == null) {
            C0557a.m88c().mo10621a((AdColonyAdView) null);
            finish();
            return;
        }
        this.f217b = adColonyAdView.getOrientation();
        super.onCreate(bundle);
        this.f152m.mo10322b();
        AdColonyAdViewListener listener = this.f152m.getListener();
        if (listener != null) {
            listener.onOpened(this.f152m);
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
