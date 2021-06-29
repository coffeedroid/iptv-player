package com.adcolony.sdk;

import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONObject;

public class AdColonyReward {

    /* renamed from: a */
    private int f181a;

    /* renamed from: b */
    private String f182b;

    /* renamed from: c */
    private String f183c;

    /* renamed from: d */
    private boolean f184d;

    AdColonyReward(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        this.f181a = C0795s.m810f(b, "reward_amount");
        this.f182b = C0795s.m812h(b, "reward_name");
        this.f184d = C0795s.m807d(b, FirebaseAnalytics.Param.SUCCESS);
        this.f183c = C0795s.m812h(b, "zone_id");
    }

    public int getRewardAmount() {
        return this.f181a;
    }

    public String getRewardName() {
        return this.f182b;
    }

    public String getZoneID() {
        return this.f183c;
    }

    public boolean success() {
        return this.f184d;
    }
}
