package com.adcolony.sdk;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.adcolony.sdk.C0797u;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.measurement.AppMeasurement;
import org.json.JSONObject;

public class AdColonyInterstitial {
    public static final int ADCOLONY_IAP_ENGAGEMENT_END_CARD = 0;
    public static final int ADCOLONY_IAP_ENGAGEMENT_OVERLAY = 1;

    /* renamed from: a */
    private AdColonyInterstitialListener f166a;

    /* renamed from: b */
    private C0563c f167b;

    /* renamed from: c */
    private AdColonyAdOptions f168c;

    /* renamed from: d */
    private C0576c0 f169d;

    /* renamed from: e */
    private int f170e;

    /* renamed from: f */
    private String f171f;

    /* renamed from: g */
    private String f172g;

    /* renamed from: h */
    private String f173h;

    /* renamed from: i */
    private int f174i;

    /* renamed from: j */
    private String f175j;

    /* renamed from: k */
    private boolean f176k;

    /* renamed from: l */
    private boolean f177l;

    /* renamed from: m */
    private boolean f178m;

    AdColonyInterstitial(String str, AdColonyInterstitialListener adColonyInterstitialListener, String str2) {
        this.f166a = adColonyInterstitialListener;
        this.f175j = str2;
        this.f171f = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo10411a() {
        String str = this.f172g;
        return str == null ? "" : str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10412a(int i) {
        this.f174i = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10413a(AdColonyAdOptions adColonyAdOptions) {
        this.f168c = adColonyAdOptions;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10414a(C0563c cVar) {
        this.f167b = cVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10415a(String str) {
        this.f172g = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10416a(JSONObject jSONObject) {
        if (jSONObject.length() > 0) {
            this.f169d = new C0576c0(jSONObject, this.f171f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10417a(boolean z) {
        this.f176k = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo10418a(AdColonyZone adColonyZone) {
        if (adColonyZone != null) {
            if (adColonyZone.getPlayFrequency() <= 1) {
                return false;
            }
            if (adColonyZone.mo10475a() == 0) {
                adColonyZone.mo10476a(adColonyZone.getPlayFrequency() - 1);
                return false;
            }
            adColonyZone.mo10476a(adColonyZone.mo10475a() - 1);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo10419b() {
        return this.f171f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10420b(int i) {
        this.f170e = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10421b(String str) {
        this.f173h = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10422b(boolean z) {
        this.f178m = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C0563c mo10423c() {
        return this.f167b;
    }

    public boolean cancel() {
        if (this.f167b == null) {
            return false;
        }
        Context b = C0557a.m86b();
        if (b != null && !(b instanceof AdColonyInterstitialActivity)) {
            return false;
        }
        JSONObject b2 = C0795s.m798b();
        C0795s.m791a(b2, "id", this.f167b.mo10504a());
        new C0812x("AdSession.on_request_close", this.f167b.mo10531k(), b2).mo10945d();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo10425d() {
        String str = this.f173h;
        return str == null ? "" : str;
    }

    public boolean destroy() {
        C0557a.m88c().mo10633b().mo10556a().remove(this.f171f);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public C0576c0 mo10427e() {
        return this.f169d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo10428f() {
        return this.f170e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo10429g() {
        return this.f169d != null;
    }

    public AdColonyInterstitialListener getListener() {
        return this.f166a;
    }

    public String getZoneID() {
        return this.f175j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo10432h() {
        return this.f178m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo10433i() {
        Context b = C0557a.m86b();
        if (b == null || !C0557a.m90e()) {
            return false;
        }
        C0557a.m88c().mo10641d(true);
        C0557a.m88c().mo10626a(this.f167b);
        C0557a.m88c().mo10624a(this);
        new C0797u.C0798a().mo10920a("Launching fullscreen Activity via AdColonyInterstitial's launch ").mo10920a("method.").mo10922a(C0797u.f1089d);
        Intent intent = new Intent(b, AdColonyInterstitialActivity.class);
        if (b instanceof Application) {
            intent.addFlags(CrashUtils.ErrorDialogData.BINDER_CRASH);
        }
        b.startActivity(intent);
        this.f177l = true;
        return true;
    }

    public boolean isExpired() {
        return this.f176k || this.f177l;
    }

    public void setListener(@NonNull AdColonyInterstitialListener adColonyInterstitialListener) {
        this.f166a = adColonyInterstitialListener;
    }

    public boolean show() {
        if (!C0557a.m90e()) {
            return false;
        }
        C0648h c = C0557a.m88c();
        if (this.f177l) {
            new C0797u.C0798a().mo10920a("This ad object has already been shown. Please request a new ad ").mo10920a("via AdColony.requestInterstitial.").mo10922a(C0797u.f1092g);
            return false;
        } else if (this.f176k) {
            new C0797u.C0798a().mo10920a("This ad object has expired. Please request a new ad via AdColony").mo10920a(".requestInterstitial.").mo10922a(C0797u.f1092g);
            return false;
        } else if (c.mo10618B()) {
            new C0797u.C0798a().mo10920a("Can not show ad while an interstitial is already active.").mo10922a(C0797u.f1092g);
            return false;
        } else if (mo10418a(c.mo10662w().get(this.f175j))) {
            new C0797u.C0798a().mo10920a("Skipping show()").mo10922a(C0797u.f1091f);
            return false;
        } else {
            JSONObject b = C0795s.m798b();
            C0795s.m791a(b, "zone_id", this.f175j);
            C0795s.m801b(b, AppMeasurement.Param.TYPE, 0);
            C0795s.m791a(b, "id", this.f171f);
            AdColonyAdOptions adColonyAdOptions = this.f168c;
            if (adColonyAdOptions != null) {
                C0795s.m802b(b, "pre_popup", adColonyAdOptions.f123a);
                C0795s.m802b(b, "post_popup", this.f168c.f124b);
            }
            AdColonyZone adColonyZone = c.mo10662w().get(this.f175j);
            if (adColonyZone != null && adColonyZone.isRewarded() && c.mo10657r() == null) {
                new C0797u.C0798a().mo10920a("Rewarded ad: show() called with no reward listener set.").mo10922a(C0797u.f1092g);
            }
            new C0812x("AdSession.launch_ad_unit", 1, b).mo10945d();
            return true;
        }
    }
}
