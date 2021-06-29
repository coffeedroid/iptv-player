package com.adcolony.sdk;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.util.Log;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import com.unity3d.services.purchasing.core.TransactionErrorDetailsUtilities;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdColonyAppOptions {
    public static final String ADMARVEL = "AdMarvel";
    public static final String ADMOB = "AdMob";
    public static final String ADOBEAIR = "Adobe AIR";
    public static final String AERSERVE = "AerServe";
    public static final int ALL = 2;
    public static final String APPODEAL = "Appodeal";
    public static final String COCOS2DX = "Cocos2d-x";
    public static final String CORONA = "Corona";
    public static final String FUSEPOWERED = "Fuse Powered";
    public static final String FYBER = "Fyber";
    public static final String IRONSOURCE = "ironSource";
    public static final int LANDSCAPE = 1;
    public static final String MOPUB = "MoPub";
    public static final int PORTRAIT = 0;
    @Deprecated
    public static final int SENSOR = 2;
    public static final String UNITY = "Unity";

    /* renamed from: a */
    String f156a = "";

    /* renamed from: b */
    String[] f157b;

    /* renamed from: c */
    JSONArray f158c = C0795s.m778a();

    /* renamed from: d */
    JSONObject f159d = C0795s.m798b();

    /* renamed from: e */
    AdColonyUserMetadata f160e;

    public AdColonyAppOptions() {
        setOriginStore("google");
        if (C0557a.m90e()) {
            C0648h c = C0557a.m88c();
            if (c.mo10663x()) {
                mo10367a(c.mo10656q().f156a);
                mo10368a(c.mo10656q().f157b);
            }
        }
    }

    public static AdColonyAppOptions getMoPubAppOptions(@NonNull String str) {
        AdColonyAppOptions mediationNetwork = new AdColonyAppOptions().setMediationNetwork(MOPUB, "1.0");
        if (str != null && !str.isEmpty()) {
            String[] split = str.split(",");
            int length = split.length;
            int i = 0;
            while (i < length) {
                String[] split2 = split[i].split(":");
                if (split2.length == 2) {
                    String str2 = split2[0];
                    char c = 65535;
                    int hashCode = str2.hashCode();
                    if (hashCode != 109770977) {
                        if (hashCode == 351608024 && str2.equals("version")) {
                            c = 1;
                        }
                    } else if (str2.equals(TransactionErrorDetailsUtilities.STORE)) {
                        c = 0;
                    }
                    if (c == 0) {
                        mediationNetwork.setOriginStore(split2[1]);
                    } else if (c != 1) {
                        Log.e("AdColonyMoPub", "AdColony client options in wrong format - please check your MoPub dashboard");
                        return mediationNetwork;
                    } else {
                        mediationNetwork.setAppVersion(split2[1]);
                    }
                    i++;
                } else {
                    Log.e("AdColonyMoPub", "AdColony client options not recognized - please check your MoPub dashboard");
                    return null;
                }
            }
        }
        return mediationNetwork;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AdColonyAppOptions mo10367a(String str) {
        if (str == null) {
            return this;
        }
        this.f156a = str;
        C0795s.m791a(this.f159d, "app_id", str);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AdColonyAppOptions mo10368a(String... strArr) {
        if (strArr == null) {
            return this;
        }
        this.f157b = strArr;
        this.f158c = C0795s.m778a();
        for (String b : strArr) {
            C0795s.m800b(this.f158c, b);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo10369a() {
        return this.f156a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public JSONObject mo10370b() {
        return this.f159d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String[] mo10371c() {
        return this.f157b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public JSONArray mo10372d() {
        return this.f158c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo10373e() {
        setOption("bundle_id", C0557a.m88c().mo10647h().mo10710D());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo10374f() {
        if (C0795s.m788a(this.f159d, "use_forced_controller")) {
            C0737m0.f923N = C0795s.m807d(this.f159d, "use_forced_controller");
        }
        if (C0795s.m788a(this.f159d, "use_staging_launch_server") && C0795s.m807d(this.f159d, "use_staging_launch_server")) {
            C0648h.f662W = "http://=";
        }
    }

    public int getAppOrientation() {
        return C0795s.m777a(this.f159d, "app_orientation", -1);
    }

    public String getAppVersion() {
        return C0795s.m812h(this.f159d, "app_version");
    }

    public String getGDPRConsentString() {
        return C0795s.m812h(this.f159d, "consent_string");
    }

    public boolean getGDPRRequired() {
        return C0795s.m807d(this.f159d, "gdpr_required");
    }

    public boolean getKeepScreenOn() {
        return C0795s.m807d(this.f159d, "keep_screen_on");
    }

    public JSONObject getMediationInfo() {
        JSONObject b = C0795s.m798b();
        C0795s.m791a(b, MediationMetaData.KEY_NAME, C0795s.m812h(this.f159d, "mediation_network"));
        C0795s.m791a(b, "version", C0795s.m812h(this.f159d, "mediation_network_version"));
        return b;
    }

    public boolean getMultiWindowEnabled() {
        return C0795s.m807d(this.f159d, "multi_window_enabled");
    }

    public Object getOption(@NonNull String str) {
        return C0795s.m797b(this.f159d, str);
    }

    public String getOriginStore() {
        return C0795s.m812h(this.f159d, "origin_store");
    }

    public JSONObject getPluginInfo() {
        JSONObject b = C0795s.m798b();
        C0795s.m791a(b, MediationMetaData.KEY_NAME, C0795s.m812h(this.f159d, "plugin"));
        C0795s.m791a(b, "version", C0795s.m812h(this.f159d, "plugin_version"));
        return b;
    }

    public int getRequestedAdOrientation() {
        return C0795s.m777a(this.f159d, AdUnitActivity.EXTRA_ORIENTATION, -1);
    }

    public boolean getTestModeEnabled() {
        return C0795s.m807d(this.f159d, "test_mode");
    }

    public String getUserID() {
        return C0795s.m812h(this.f159d, "user_id");
    }

    public AdColonyUserMetadata getUserMetadata() {
        return this.f160e;
    }

    public AdColonyAppOptions setAppOrientation(@IntRange(from = 0, mo116to = 2) int i) {
        setOption("app_orientation", (double) i);
        return this;
    }

    public AdColonyAppOptions setAppVersion(@NonNull String str) {
        if (C0717k0.m538h(str)) {
            setOption("app_version", str);
        }
        return this;
    }

    public AdColonyAppOptions setGDPRConsentString(@NonNull String str) {
        C0795s.m791a(this.f159d, "consent_string", str);
        return this;
    }

    public AdColonyAppOptions setGDPRRequired(boolean z) {
        setOption("gdpr_required", z);
        return this;
    }

    public AdColonyAppOptions setKeepScreenOn(boolean z) {
        C0795s.m802b(this.f159d, "keep_screen_on", z);
        return this;
    }

    public AdColonyAppOptions setMediationNetwork(@NonNull String str, @NonNull String str2) {
        if (C0717k0.m538h(str) && C0717k0.m538h(str2)) {
            C0795s.m791a(this.f159d, "mediation_network", str);
            C0795s.m791a(this.f159d, "mediation_network_version", str2);
        }
        return this;
    }

    public AdColonyAppOptions setMultiWindowEnabled(boolean z) {
        C0795s.m802b(this.f159d, "multi_window_enabled", z);
        return this;
    }

    public AdColonyAppOptions setOption(@NonNull String str, double d) {
        if (C0717k0.m538h(str)) {
            C0795s.m789a(this.f159d, str, d);
        }
        return this;
    }

    public AdColonyAppOptions setOption(@NonNull String str, @NonNull String str2) {
        if (str != null && C0717k0.m538h(str) && C0717k0.m538h(str2)) {
            C0795s.m791a(this.f159d, str, str2);
        }
        return this;
    }

    public AdColonyAppOptions setOption(@NonNull String str, boolean z) {
        if (C0717k0.m538h(str)) {
            C0795s.m802b(this.f159d, str, z);
        }
        return this;
    }

    public AdColonyAppOptions setOriginStore(@NonNull String str) {
        if (C0717k0.m538h(str)) {
            setOption("origin_store", str);
        }
        return this;
    }

    public AdColonyAppOptions setPlugin(@NonNull String str, @NonNull String str2) {
        if (C0717k0.m538h(str) && C0717k0.m538h(str2)) {
            C0795s.m791a(this.f159d, "plugin", str);
            C0795s.m791a(this.f159d, "plugin_version", str2);
        }
        return this;
    }

    public AdColonyAppOptions setRequestedAdOrientation(@IntRange(from = 0, mo116to = 2) int i) {
        setOption(AdUnitActivity.EXTRA_ORIENTATION, (double) i);
        return this;
    }

    public AdColonyAppOptions setTestModeEnabled(boolean z) {
        C0795s.m802b(this.f159d, "test_mode", z);
        return this;
    }

    public AdColonyAppOptions setUserID(@NonNull String str) {
        if (C0717k0.m538h(str)) {
            setOption("user_id", str);
        }
        return this;
    }

    public AdColonyAppOptions setUserMetadata(@NonNull AdColonyUserMetadata adColonyUserMetadata) {
        this.f160e = adColonyUserMetadata;
        C0795s.m793a(this.f159d, "user_metadata", adColonyUserMetadata.f187b);
        return this;
    }
}
