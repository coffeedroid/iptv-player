package com.adcolony.sdk;

import p017io.fabric.sdk.android.services.settings.SettingsJsonConstants;

public class AdColonyAdSize {
    public static final AdColonyAdSize BANNER = new AdColonyAdSize(320, 50);
    public static final AdColonyAdSize LEADERBOARD = new AdColonyAdSize(728, 90);
    public static final AdColonyAdSize MEDIUM_RECTANGLE = new AdColonyAdSize(300, 250);
    public static final AdColonyAdSize SKYSCRAPER = new AdColonyAdSize(160, SettingsJsonConstants.ANALYTICS_FLUSH_INTERVAL_SECS_DEFAULT);

    /* renamed from: a */
    int f127a;

    /* renamed from: b */
    int f128b;

    public AdColonyAdSize(int i, int i2) {
        this.f127a = i;
        this.f128b = i2;
    }

    public int getHeight() {
        return this.f128b;
    }

    public int getWidth() {
        return this.f127a;
    }
}
