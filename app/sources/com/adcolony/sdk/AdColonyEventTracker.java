package com.adcolony.sdk;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.app.NotificationCompat;
import com.adcolony.sdk.C0797u;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.purchasing.core.TransactionDetailsUtilities;
import com.unity3d.services.purchasing.core.TransactionErrorDetailsUtilities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.settings.AppSettingsData;

public class AdColonyEventTracker {
    public static final String CUSTOM_EVENT_1 = "ADCT_CUSTOM_EVENT_1";
    public static final String CUSTOM_EVENT_2 = "ADCT_CUSTOM_EVENT_2";
    public static final String CUSTOM_EVENT_3 = "ADCT_CUSTOM_EVENT_3";
    public static final String CUSTOM_EVENT_4 = "ADCT_CUSTOM_EVENT_4";
    public static final String CUSTOM_EVENT_5 = "ADCT_CUSTOM_EVENT_5";
    public static final String LOGIN_DEFAULT = "ADCT_DEFAULT_LOGIN";
    public static final String LOGIN_FACEBOOK = "ADCT_FACEBOOK_LOGIN";
    public static final String LOGIN_GOOGLE = "ADCT_GOOGLE_LOGIN";
    public static final String LOGIN_LINKEDIN = "ADCT_LINKEDIN_LOGIN";
    public static final String LOGIN_OPENID = "ADCT_OPENID_LOGIN";
    public static final String LOGIN_TWITTER = "ADCT_TWITTER_LOGIN";
    public static final String REGISTRATION_CUSTOM = "ADCT_CUSTOM_REGISTRATION";
    public static final String REGISTRATION_DEFAULT = "ADCT_DEFAULT_REGISTRATION";
    public static final String REGISTRATION_FACEBOOK = "ADCT_FACEBOOK_REGISTRATION";
    public static final String REGISTRATION_GOOGLE = "ADCT_GOOGLE_REGISTRATION";
    public static final String REGISTRATION_LINKEDIN = "ADCT_LINKEDIN_REGISTRATION";
    public static final String REGISTRATION_OPENID = "ADCT_OPENID_REGISTRATION";
    public static final String REGISTRATION_TWITTER = "ADCT_TWITTER_REGISTRATION";
    public static final String SOCIAL_SHARING_CUSTOM = "ADCT_CUSTOM_SHARING";
    public static final String SOCIAL_SHARING_FACEBOOK = "ADCT_FACEBOOK_SHARING";
    public static final String SOCIAL_SHARING_FLICKR = "ADCT_FLICKR_SHARING";
    public static final String SOCIAL_SHARING_FOURSQUARE = "ADCT_FOURSQUARE_SHARING";
    public static final String SOCIAL_SHARING_GOOGLE = "ADCT_GOOGLE_SHARING";
    public static final String SOCIAL_SHARING_INSTAGRAM = "ADCT_INSTAGRAM_SHARING";
    public static final String SOCIAL_SHARING_LINKEDIN = "ADCT_LINKEDIN_SHARING";
    public static final String SOCIAL_SHARING_PINTEREST = "ADCT_PINTEREST_SHARING";
    public static final String SOCIAL_SHARING_SNAPCHAT = "ADCT_SNAPCHAT_SHARING";
    public static final String SOCIAL_SHARING_TUMBLR = "ADCT_TUMBLR_SHARING";
    public static final String SOCIAL_SHARING_TWITTER = "ADCT_TWITTER_SHARING";
    public static final String SOCIAL_SHARING_VIMEO = "ADCT_VIMEO_SHARING";
    public static final String SOCIAL_SHARING_VINE = "ADCT_VINE_SHARING";
    public static final String SOCIAL_SHARING_YOUTUBE = "ADCT_YOUTUBE_SHARING";

    /* renamed from: a */
    private static final List<JSONObject> f164a = Collections.synchronizedList(new ArrayList());

    /* renamed from: b */
    private static final int f165b = 200;

    /* renamed from: a */
    static void m41a(JSONObject jSONObject) {
        synchronized (f164a) {
            if (200 > f164a.size()) {
                f164a.add(jSONObject);
            }
        }
    }

    /* renamed from: a */
    static boolean m42a() {
        boolean z;
        synchronized (f164a) {
            z = f164a.size() != 0;
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m43a(String str, String str2) {
        if (str == null || str.length() <= 512) {
            return false;
        }
        new C0797u.C0798a().mo10920a("Description of event ").mo10920a(str2).mo10920a(" must be less").mo10920a(" than 512 characters").mo10922a(C0797u.f1094i);
        return true;
    }

    /* renamed from: b */
    static void m44b() {
        if (!C0648h.m273D().equals("")) {
            synchronized (f164a) {
                for (JSONObject b : f164a) {
                    m45b(b);
                }
                f164a.clear();
            }
        }
    }

    /* renamed from: b */
    private static void m45b(JSONObject jSONObject) {
        C0557a.m88c();
        if (C0648h.m273D().equals("")) {
            m41a(jSONObject);
            return;
        }
        m46c(jSONObject);
        new C0812x("AdColony.log_event", 1, jSONObject).mo10945d();
    }

    /* renamed from: c */
    private static void m46c(JSONObject jSONObject) {
        JSONObject g = C0795s.m811g(jSONObject, "payload");
        if (C0737m0.f923N) {
            C0795s.m791a(g, "api_key", "bb2cf0647ba654d7228dd3f9405bbc6a");
        } else {
            C0795s.m791a(g, "api_key", C0648h.m273D());
        }
        try {
            jSONObject.remove("payload");
            jSONObject.put("payload", g);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private static void m47d(JSONObject jSONObject) {
        C0795s.m791a(jSONObject, "timezone", TimeZone.getDefault().getID());
        C0795s.m791a(jSONObject, "action_time", String.valueOf(Math.round((float) (System.currentTimeMillis() / 1000))));
    }

    public static void logAchievementUnlocked(@Nullable String str) {
        if (!m43a(str, "logAchievementUnlocked")) {
            HashMap hashMap = new HashMap();
            hashMap.put("description", str);
            logEvent("achievement_unlocked", hashMap);
        }
    }

    public static void logActivated() {
        logEvent(AppSettingsData.STATUS_ACTIVATED);
    }

    public static void logAddToCart(@Nullable String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(FirebaseAnalytics.Param.ITEM_ID, str);
        logEvent(FirebaseAnalytics.Event.ADD_TO_CART, hashMap);
    }

    public static void logAddToWishlist(@Nullable String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(FirebaseAnalytics.Param.ITEM_ID, str);
        logEvent(FirebaseAnalytics.Event.ADD_TO_WISHLIST, hashMap);
    }

    public static void logAppRated() {
        logEvent("app_rated");
    }

    public static void logCheckoutInitiated() {
        logEvent("checkout_initiated");
    }

    public static void logContentView(@Nullable String str, @Nullable String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("content_id", str);
        hashMap.put(FirebaseAnalytics.Param.CONTENT_TYPE, str2);
        logEvent("content_view", hashMap);
    }

    public static void logCreditsSpent(@Nullable String str, @Nullable Integer num, @Nullable Double d, @Nullable String str2) {
        if (str2 == null || str2.length() == 3) {
            HashMap hashMap = new HashMap();
            hashMap.put(MediationMetaData.KEY_NAME, str);
            hashMap.put(FirebaseAnalytics.Param.QUANTITY, String.valueOf(num));
            hashMap.put(FirebaseAnalytics.Param.VALUE, String.valueOf(d));
            hashMap.put("currency_code", str2);
            logEvent("credits_spent", hashMap);
            return;
        }
        new C0797u.C0798a().mo10920a("Event logCreditsSpentWithName currency code is specified, but a three-letter ISO 4217 code, (e.g.: 'USD'). Event will not be sent.").mo10922a(C0797u.f1094i);
    }

    public static void logCustomEvent(@Nullable String str, @Nullable String str2) {
        if (!m43a(str2, "logCustomEvent")) {
            HashMap hashMap = new HashMap();
            hashMap.put(NotificationCompat.CATEGORY_EVENT, str);
            hashMap.put("description", str2);
            logEvent("custom_event", hashMap);
        }
    }

    public static void logEvent(@Nullable String str) {
        logEvent(str, (HashMap<String, String>) null);
    }

    public static void logEvent(@NonNull String str, @Nullable HashMap<String, String> hashMap) {
        JSONObject b = C0795s.m798b();
        C0795s.m791a(b, "event_name", str);
        JSONObject b2 = C0795s.m798b();
        if (hashMap != null) {
            for (Map.Entry next : hashMap.entrySet()) {
                if (next.getValue() != null && !((String) next.getValue()).equals("null")) {
                    C0795s.m791a(b2, (String) next.getKey(), (String) next.getValue());
                }
            }
        }
        m47d(b2);
        C0795s.m793a(b, "payload", b2);
        m45b(b);
    }

    public static void logInvite() {
        logEvent("invite");
    }

    public static void logLevelAchieved(@Nullable Integer num) {
        HashMap hashMap = new HashMap();
        hashMap.put("level_achieved", String.valueOf(num));
        logEvent("level_achieved", hashMap);
    }

    public static void logLogin(@Nullable String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(FirebaseAnalytics.Param.METHOD, str);
        logEvent(FirebaseAnalytics.Event.LOGIN, hashMap);
    }

    public static void logPaymentInfoAdded() {
        logEvent("payment_info_added");
    }

    public static void logRegistrationCompleted(@Nullable String str, @Nullable String str2) {
        if (!m43a(str2, "logRegistrationCompleted")) {
            HashMap hashMap = new HashMap();
            hashMap.put(FirebaseAnalytics.Param.METHOD, str);
            hashMap.put("description", str2);
            logEvent("registration_completed", hashMap);
        }
    }

    public static void logReservation() {
        logEvent("reservation");
    }

    public static void logSearch(@Nullable String str) {
        if (str == null || str.length() <= 512) {
            HashMap hashMap = new HashMap();
            hashMap.put("search_string", str);
            logEvent(FirebaseAnalytics.Event.SEARCH, hashMap);
            return;
        }
        new C0797u.C0798a().mo10920a("logSearch searchString cannot exceed 512 characters. Event will ").mo10920a("not be sent.").mo10922a(C0797u.f1094i);
    }

    public static void logSocialSharingEvent(@Nullable String str, @Nullable String str2) {
        if (!m43a(str2, "logSocialSharingEvent")) {
            HashMap hashMap = new HashMap();
            hashMap.put("network", str);
            hashMap.put("description", str2);
            logEvent("social_sharing_event", hashMap);
        }
    }

    public static void logTransaction(@Nullable String str, @Nullable Integer num, @Nullable Double d, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        if (!m43a(str5, "logTransaction")) {
            if (str2 == null || str2.length() == 3) {
                HashMap hashMap = new HashMap();
                hashMap.put(FirebaseAnalytics.Param.ITEM_ID, str);
                hashMap.put(FirebaseAnalytics.Param.QUANTITY, String.valueOf(num));
                hashMap.put("price", String.valueOf(d));
                hashMap.put("currency_code", str2);
                hashMap.put(TransactionDetailsUtilities.RECEIPT, str3);
                hashMap.put(TransactionErrorDetailsUtilities.STORE, str4);
                hashMap.put("description", str5);
                logEvent("transaction", hashMap);
                return;
            }
            new C0797u.C0798a().mo10920a("Event logCreditsSpentWithName currency code is specified, but a three-letter ISO 4217 code, (e.g.: 'USD'). Event will not be sent.").mo10922a(C0797u.f1094i);
        }
    }

    public static void logTutorialCompleted() {
        logEvent("tutorial_completed");
    }
}
