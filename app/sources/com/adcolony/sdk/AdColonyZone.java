package com.adcolony.sdk;

import android.support.annotation.NonNull;
import com.adcolony.sdk.C0797u;
import com.google.android.gms.measurement.AppMeasurement;
import org.json.JSONObject;

public class AdColonyZone {
    public static final int BANNER = 1;
    public static final int INTERSTITIAL = 0;
    @Deprecated
    public static final int NATIVE = 2;

    /* renamed from: n */
    static final int f189n = 0;

    /* renamed from: o */
    static final int f190o = 1;

    /* renamed from: p */
    static final int f191p = 2;

    /* renamed from: q */
    static final int f192q = 3;

    /* renamed from: r */
    static final int f193r = 4;

    /* renamed from: s */
    static final int f194s = 5;

    /* renamed from: t */
    static final int f195t = 6;

    /* renamed from: a */
    private String f196a;

    /* renamed from: b */
    private String f197b;

    /* renamed from: c */
    private String f198c;

    /* renamed from: d */
    private String f199d;

    /* renamed from: e */
    private int f200e = 5;

    /* renamed from: f */
    private int f201f;

    /* renamed from: g */
    private int f202g;

    /* renamed from: h */
    private int f203h;

    /* renamed from: i */
    private int f204i;

    /* renamed from: j */
    private int f205j;

    /* renamed from: k */
    private int f206k;

    /* renamed from: l */
    private boolean f207l;

    /* renamed from: m */
    private boolean f208m;

    AdColonyZone(@NonNull String str) {
        this.f196a = str;
    }

    /* renamed from: a */
    private String m69a(String str) {
        return m70a(str, "");
    }

    /* renamed from: a */
    private String m70a(String str, String str2) {
        if (C0557a.m90e() && !C0557a.m88c().mo10664y() && !C0557a.m88c().mo10665z()) {
            return str;
        }
        m73c();
        return str2;
    }

    /* renamed from: a */
    private boolean m71a(boolean z) {
        if (C0557a.m90e() && !C0557a.m88c().mo10664y() && !C0557a.m88c().mo10665z()) {
            return z;
        }
        m73c();
        return false;
    }

    /* renamed from: c */
    private int m72c(int i) {
        if (C0557a.m90e() && !C0557a.m88c().mo10664y() && !C0557a.m88c().mo10665z()) {
            return i;
        }
        m73c();
        return 0;
    }

    /* renamed from: c */
    private void m73c() {
        new C0797u.C0798a().mo10920a("The AdColonyZone API is not available while AdColony is disabled.").mo10922a(C0797u.f1094i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo10475a() {
        return this.f206k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10476a(int i) {
        this.f206k = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10477a(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        JSONObject g = C0795s.m811g(b, "reward");
        this.f197b = C0795s.m812h(g, "reward_name");
        this.f205j = C0795s.m810f(g, "reward_amount");
        this.f203h = C0795s.m810f(g, "views_per_reward");
        this.f202g = C0795s.m810f(g, "views_until_reward");
        this.f198c = C0795s.m812h(g, "reward_name_plural");
        this.f199d = C0795s.m812h(g, "reward_prompt");
        this.f208m = C0795s.m807d(b, "rewarded");
        this.f200e = C0795s.m810f(b, "status");
        this.f201f = C0795s.m810f(b, AppMeasurement.Param.TYPE);
        this.f204i = C0795s.m810f(b, "play_interval");
        this.f196a = C0795s.m812h(b, "zone_id");
        boolean z = true;
        if (this.f200e == 1) {
            z = false;
        }
        this.f207l = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10478b(int i) {
        this.f200e = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo10479b() {
        return this.f200e == 0;
    }

    public int getPlayFrequency() {
        return m72c(this.f204i);
    }

    public int getRemainingViewsUntilReward() {
        return m72c(this.f202g);
    }

    public int getRewardAmount() {
        return m72c(this.f205j);
    }

    public String getRewardName() {
        return m69a(this.f197b);
    }

    public int getViewsPerReward() {
        return m72c(this.f203h);
    }

    public String getZoneID() {
        return m69a(this.f196a);
    }

    public int getZoneType() {
        return this.f201f;
    }

    public boolean isRewarded() {
        return this.f208m;
    }

    public boolean isValid() {
        return m71a(this.f207l);
    }
}
