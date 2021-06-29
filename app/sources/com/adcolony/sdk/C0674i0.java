package com.adcolony.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.p000v4.app.NotificationCompat;
import com.adcolony.sdk.C0797u;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p016fi.iki.elonen.NanoHTTPD;
import p017io.fabric.sdk.android.services.settings.SettingsJsonConstants;

/* renamed from: com.adcolony.sdk.i0 */
class C0674i0 {

    /* renamed from: com.adcolony.sdk.i0$a */
    class C0675a implements C0816z {
        C0675a() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0674i0.this.mo10691a(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$b */
    class C0676b implements C0816z {
        C0676b() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0674i0.this.mo10693b(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$c */
    class C0677c implements C0816z {
        C0677c() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0674i0.this.mo10702k(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$d */
    class C0678d implements C0816z {
        C0678d() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            boolean unused = C0674i0.this.m385o(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$e */
    class C0679e implements C0816z {
        C0679e() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            boolean unused = C0674i0.this.m384n(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$f */
    class C0680f implements C0816z {
        C0680f() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0674i0.this.mo10695d(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$g */
    class C0681g implements C0816z {
        C0681g() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            boolean unused = C0674i0.this.m387q(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$h */
    class C0682h implements C0816z {
        C0682h() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            boolean unused = C0674i0.this.m386p(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$i */
    class C0683i implements MediaScannerConnection.OnScanCompletedListener {

        /* renamed from: a */
        final /* synthetic */ JSONObject f752a;

        /* renamed from: b */
        final /* synthetic */ C0812x f753b;

        C0683i(JSONObject jSONObject, C0812x xVar) {
            this.f752a = jSONObject;
            this.f753b = xVar;
        }

        public void onScanCompleted(String str, Uri uri) {
            C0717k0.m516a("Screenshot saved to Gallery!", 0);
            C0795s.m802b(this.f752a, FirebaseAnalytics.Param.SUCCESS, true);
            this.f753b.mo10940a(this.f752a).mo10945d();
        }
    }

    /* renamed from: com.adcolony.sdk.i0$j */
    class C0684j implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f755a;

        C0684j(String str) {
            this.f755a = str;
        }

        public void run() {
            JSONObject b = C0795s.m798b();
            C0795s.m791a(b, AppMeasurement.Param.TYPE, "open_hook");
            C0795s.m791a(b, SettingsJsonConstants.PROMPT_MESSAGE_KEY, this.f755a);
            new C0812x("CustomMessage.controller_send", 0, b).mo10945d();
        }
    }

    /* renamed from: com.adcolony.sdk.i0$k */
    class C0685k implements C0816z {
        C0685k() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0674i0.this.mo10699h(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$l */
    class C0686l implements C0816z {
        C0686l() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0674i0.this.mo10700i(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$m */
    class C0687m implements C0816z {
        C0687m() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0674i0.this.mo10703l(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$n */
    class C0688n implements C0816z {
        C0688n() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0674i0.this.mo10701j(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$o */
    class C0689o implements C0816z {
        C0689o() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0674i0.this.mo10704m(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$p */
    class C0690p implements C0816z {
        C0690p() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0674i0.this.mo10698g(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$q */
    class C0691q implements C0816z {
        C0691q() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0674i0.this.mo10697f(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$r */
    class C0692r implements C0816z {
        C0692r() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0674i0.this.mo10696e(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$s */
    class C0693s implements C0816z {
        C0693s() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0674i0.this.mo10694c(xVar);
        }
    }

    C0674i0() {
    }

    /* renamed from: c */
    private boolean m381c(@NonNull String str) {
        if (C0557a.m88c().mo10633b().mo10562b().get(str) == null) {
            return false;
        }
        JSONObject b = C0795s.m798b();
        C0795s.m791a(b, "ad_session_id", str);
        new C0812x("MRAID.on_event", 1, b).mo10945d();
        return true;
    }

    /* renamed from: d */
    private void m382d(String str) {
        C0717k0.f836b.execute(new C0684j(str));
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public boolean m384n(C0812x xVar) {
        String h = C0795s.m812h(xVar.mo10941b(), "ad_session_id");
        Activity activity = C0557a.m86b() instanceof Activity ? (Activity) C0557a.m86b() : null;
        boolean z = activity instanceof AdColonyAdViewActivity;
        if (!(activity instanceof C0560b)) {
            return false;
        }
        if (z) {
            ((AdColonyAdViewActivity) activity).mo10346b();
            return true;
        }
        JSONObject b = C0795s.m798b();
        C0795s.m791a(b, "id", h);
        new C0812x("AdSession.on_request_close", ((C0560b) activity).f219d, b).mo10945d();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public boolean m385o(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        C0580d b2 = C0557a.m88c().mo10633b();
        String h = C0795s.m812h(b, "ad_session_id");
        AdColonyInterstitial adColonyInterstitial = b2.mo10556a().get(h);
        AdColonyAdView adColonyAdView = b2.mo10562b().get(h);
        if ((adColonyInterstitial == null || adColonyInterstitial.getListener() == null || adColonyInterstitial.mo10423c() == null) && (adColonyAdView == null || adColonyAdView.getListener() == null)) {
            return false;
        }
        if (adColonyAdView == null) {
            new C0812x("AdUnit.make_in_app_purchase", adColonyInterstitial.mo10423c().mo10531k()).mo10945d();
        }
        mo10690a(h);
        m381c(h);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public boolean m386p(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        String h = C0795s.m812h(b, "ad_session_id");
        int f = C0795s.m810f(b, AdUnitActivity.EXTRA_ORIENTATION);
        C0580d b2 = C0557a.m88c().mo10633b();
        AdColonyAdView adColonyAdView = b2.mo10562b().get(h);
        AdColonyInterstitial adColonyInterstitial = b2.mo10556a().get(h);
        Context b3 = C0557a.m86b();
        if (adColonyAdView != null) {
            adColonyAdView.setOrientation(f);
        } else if (adColonyInterstitial != null) {
            adColonyInterstitial.mo10420b(f);
        }
        if (adColonyInterstitial == null && adColonyAdView == null) {
            new C0797u.C0798a().mo10920a("Invalid ad session id sent with set orientation properties message: ").mo10920a(h).mo10922a(C0797u.f1095j);
            return false;
        } else if (!(b3 instanceof C0560b)) {
            return true;
        } else {
            ((C0560b) b3).mo10496a(adColonyAdView == null ? adColonyInterstitial.mo10428f() : adColonyAdView.getOrientation());
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public boolean m387q(C0812x xVar) {
        AdColonyAdView adColonyAdView = C0557a.m88c().mo10633b().mo10562b().get(C0795s.m812h(xVar.mo10941b(), "ad_session_id"));
        if (adColonyAdView == null) {
            return false;
        }
        adColonyAdView.setNoCloseButton(C0795s.m807d(xVar.mo10941b(), "use_custom_close"));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10689a() {
        C0557a.m84a("System.open_store", (C0816z) new C0685k());
        C0557a.m84a("System.save_screenshot", (C0816z) new C0686l());
        C0557a.m84a("System.telephone", (C0816z) new C0687m());
        C0557a.m84a("System.sms", (C0816z) new C0688n());
        C0557a.m84a("System.vibrate", (C0816z) new C0689o());
        C0557a.m84a("System.open_browser", (C0816z) new C0690p());
        C0557a.m84a("System.mail", (C0816z) new C0691q());
        C0557a.m84a("System.launch_app", (C0816z) new C0692r());
        C0557a.m84a("System.create_calendar_event", (C0816z) new C0693s());
        C0557a.m84a("System.check_app_presence", (C0816z) new C0675a());
        C0557a.m84a("System.check_social_presence", (C0816z) new C0676b());
        C0557a.m84a("System.social_post", (C0816z) new C0677c());
        C0557a.m84a("System.make_in_app_purchase", (C0816z) new C0678d());
        C0557a.m84a("System.close", (C0816z) new C0679e());
        C0557a.m84a("System.expand", (C0816z) new C0680f());
        C0557a.m84a("System.use_custom_close", (C0816z) new C0681g());
        C0557a.m84a("System.set_orientation_properties", (C0816z) new C0682h());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10690a(String str) {
        C0580d b = C0557a.m88c().mo10633b();
        AdColonyInterstitial adColonyInterstitial = b.mo10556a().get(str);
        if (adColonyInterstitial == null || adColonyInterstitial.getListener() == null) {
            AdColonyAdView adColonyAdView = b.mo10562b().get(str);
            AdColonyAdViewListener listener = adColonyAdView != null ? adColonyAdView.getListener() : null;
            if (adColonyAdView != null && listener != null) {
                listener.onClicked(adColonyAdView);
                return;
            }
            return;
        }
        adColonyInterstitial.getListener().onClicked(adColonyInterstitial);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo10691a(C0812x xVar) {
        JSONObject b = C0795s.m798b();
        String h = C0795s.m812h(xVar.mo10941b(), MediationMetaData.KEY_NAME);
        boolean f = C0717k0.m534f(h);
        C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, true);
        C0795s.m802b(b, "result", f);
        C0795s.m791a(b, MediationMetaData.KEY_NAME, h);
        C0795s.m791a(b, NotificationCompat.CATEGORY_SERVICE, h);
        xVar.mo10940a(b).mo10945d();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10692b(String str) {
        C0580d b = C0557a.m88c().mo10633b();
        AdColonyInterstitial adColonyInterstitial = b.mo10556a().get(str);
        if (adColonyInterstitial == null || adColonyInterstitial.getListener() == null) {
            AdColonyAdView adColonyAdView = b.mo10562b().get(str);
            AdColonyAdViewListener listener = adColonyAdView != null ? adColonyAdView.getListener() : null;
            if (adColonyAdView != null && listener != null) {
                listener.onLeftApplication(adColonyAdView);
                return;
            }
            return;
        }
        adColonyInterstitial.getListener().onLeftApplication(adColonyInterstitial);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo10693b(C0812x xVar) {
        return mo10691a(xVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo10694c(C0812x xVar) {
        Intent intent;
        C0812x xVar2 = xVar;
        JSONObject b = C0795s.m798b();
        JSONObject b2 = xVar.mo10941b();
        String str = "";
        String str2 = "";
        String h = C0795s.m812h(b2, "ad_session_id");
        JSONObject g = C0795s.m811g(b2, "params");
        JSONObject g2 = C0795s.m811g(g, "recurrence");
        JSONArray a = C0795s.m778a();
        JSONArray a2 = C0795s.m778a();
        JSONArray a3 = C0795s.m778a();
        String h2 = C0795s.m812h(g, "description");
        C0795s.m812h(g, "location");
        String h3 = C0795s.m812h(g, "start");
        String h4 = C0795s.m812h(g, "end");
        String h5 = C0795s.m812h(g, "summary");
        if (g2 != null && g2.length() > 0) {
            str2 = C0795s.m812h(g2, "expires");
            str = C0795s.m812h(g2, "frequency").toUpperCase(Locale.getDefault());
            a = C0795s.m803c(g2, "daysInWeek");
            a2 = C0795s.m803c(g2, "daysInMonth");
            a3 = C0795s.m803c(g2, "daysInYear");
        }
        if (h5.equals("")) {
            h5 = h2;
        }
        Date k = C0717k0.m541k(h3);
        Date k2 = C0717k0.m541k(h4);
        Date k3 = C0717k0.m541k(str2);
        if (k == null || k2 == null) {
            C0717k0.m516a("Unable to create Calendar Event", 0);
            C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, false);
            xVar2.mo10940a(b).mo10945d();
            return false;
        }
        long time = k.getTime();
        long time2 = k2.getTime();
        long j = 0;
        long time3 = k3 != null ? (k3.getTime() - k.getTime()) / 1000 : 0;
        if (str.equals("DAILY")) {
            j = (time3 / 86400) + 1;
        } else if (str.equals("WEEKLY")) {
            j = (time3 / 604800) + 1;
        } else if (str.equals("MONTHLY")) {
            j = (time3 / 2629800) + 1;
        } else if (str.equals("YEARLY")) {
            j = (time3 / 31557600) + 1;
        }
        long j2 = j;
        if (g2 == null || g2.length() <= 0) {
            intent = new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event").putExtra("title", h5).putExtra("description", h2).putExtra("beginTime", time).putExtra("endTime", time2);
        } else {
            String str3 = "FREQ=" + str + ";COUNT=" + j2;
            try {
                if (a.length() != 0) {
                    str3 = str3 + ";BYDAY=" + C0717k0.m510a(a);
                }
                if (a2.length() != 0) {
                    str3 = str3 + ";BYMONTHDAY=" + C0717k0.m523b(a2);
                }
                if (a3.length() != 0) {
                    str3 = str3 + ";BYYEARDAY=" + C0717k0.m523b(a3);
                }
            } catch (JSONException unused) {
            }
            intent = new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event").putExtra("title", h5).putExtra("description", h2).putExtra("beginTime", time).putExtra("endTime", time2).putExtra("rrule", str3);
        }
        if (C0717k0.m513a(intent)) {
            C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, true);
            xVar.mo10940a(b).mo10945d();
            mo10692b(h);
            mo10690a(h);
            m381c(h);
            return true;
        }
        C0717k0.m516a("Unable to create Calendar Event.", 0);
        C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, false);
        xVar.mo10940a(b).mo10945d();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo10695d(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        Context b2 = C0557a.m86b();
        if (b2 != null && C0557a.m90e()) {
            String h = C0795s.m812h(b, "ad_session_id");
            C0648h c = C0557a.m88c();
            AdColonyAdView adColonyAdView = c.mo10633b().mo10562b().get(h);
            if (adColonyAdView != null && ((adColonyAdView.getTrustedDemandSource() || adColonyAdView.getUserInteraction()) && c.mo10643e() != adColonyAdView)) {
                adColonyAdView.setExpandMessage(xVar);
                adColonyAdView.setExpandedWidth(C0795s.m810f(b, SettingsJsonConstants.ICON_WIDTH_KEY));
                adColonyAdView.setExpandedHeight(C0795s.m810f(b, SettingsJsonConstants.ICON_HEIGHT_KEY));
                adColonyAdView.setOrientation(C0795s.m777a(b, AdUnitActivity.EXTRA_ORIENTATION, -1));
                adColonyAdView.setNoCloseButton(C0795s.m807d(b, "use_custom_close"));
                c.mo10621a(adColonyAdView);
                c.mo10626a(adColonyAdView.getContainer());
                Intent intent = new Intent(b2, AdColonyAdViewActivity.class);
                if (b2 instanceof Application) {
                    intent.addFlags(CrashUtils.ErrorDialogData.BINDER_CRASH);
                }
                m381c(h);
                mo10690a(h);
                b2.startActivity(intent);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo10696e(C0812x xVar) {
        JSONObject b = C0795s.m798b();
        JSONObject b2 = xVar.mo10941b();
        String h = C0795s.m812h(b2, "ad_session_id");
        if (C0795s.m807d(b2, "deep_link")) {
            return mo10699h(xVar);
        }
        Context b3 = C0557a.m86b();
        if (b3 == null) {
            return false;
        }
        if (C0717k0.m513a(b3.getPackageManager().getLaunchIntentForPackage(C0795s.m812h(b2, "handle")))) {
            C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, true);
            xVar.mo10940a(b).mo10945d();
            mo10692b(h);
            mo10690a(h);
            m381c(h);
            return true;
        }
        C0717k0.m516a("Failed to launch external application.", 0);
        C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, false);
        xVar.mo10940a(b).mo10945d();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo10697f(C0812x xVar) {
        JSONObject b = C0795s.m798b();
        JSONObject b2 = xVar.mo10941b();
        JSONArray c = C0795s.m803c(b2, "recipients");
        boolean d = C0795s.m807d(b2, "html");
        String h = C0795s.m812h(b2, "subject");
        String h2 = C0795s.m812h(b2, "body");
        String h3 = C0795s.m812h(b2, "ad_session_id");
        String[] strArr = new String[c.length()];
        for (int i = 0; i < c.length(); i++) {
            strArr[i] = C0795s.m806d(c, i);
        }
        Intent intent = new Intent("android.intent.action.SEND");
        if (!d) {
            intent.setType("plain/text");
        }
        intent.putExtra("android.intent.extra.SUBJECT", h).putExtra("android.intent.extra.TEXT", h2).putExtra("android.intent.extra.EMAIL", strArr);
        if (C0717k0.m513a(intent)) {
            C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, true);
            xVar.mo10940a(b).mo10945d();
            mo10692b(h3);
            mo10690a(h3);
            m381c(h3);
            return true;
        }
        C0717k0.m516a("Failed to send email.", 0);
        C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, false);
        xVar.mo10940a(b).mo10945d();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo10698g(C0812x xVar) {
        JSONObject b = C0795s.m798b();
        JSONObject b2 = xVar.mo10941b();
        String h = C0795s.m812h(b2, "url");
        String h2 = C0795s.m812h(b2, "ad_session_id");
        AdColonyAdView adColonyAdView = C0557a.m88c().mo10633b().mo10562b().get(h2);
        if (adColonyAdView != null && !adColonyAdView.getTrustedDemandSource() && !adColonyAdView.getUserInteraction()) {
            return false;
        }
        if (h.startsWith("browser")) {
            h = h.replaceFirst("browser", "http");
        }
        if (h.startsWith("safari")) {
            h = h.replaceFirst("safari", "http");
        }
        m382d(h);
        if (C0717k0.m513a(new Intent("android.intent.action.VIEW", Uri.parse(h)))) {
            C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, true);
            xVar.mo10940a(b).mo10945d();
            mo10692b(h2);
            mo10690a(h2);
            m381c(h2);
            return true;
        }
        C0717k0.m516a("Failed to launch browser.", 0);
        C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, false);
        xVar.mo10940a(b).mo10945d();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo10699h(C0812x xVar) {
        JSONObject b = C0795s.m798b();
        JSONObject b2 = xVar.mo10941b();
        String h = C0795s.m812h(b2, "product_id");
        String h2 = C0795s.m812h(b2, "ad_session_id");
        if (h.equals("")) {
            h = C0795s.m812h(b2, "handle");
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(h));
        m382d(h);
        if (C0717k0.m513a(intent)) {
            C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, true);
            xVar.mo10940a(b).mo10945d();
            mo10692b(h2);
            mo10690a(h2);
            m381c(h2);
            return true;
        }
        C0717k0.m516a("Unable to open.", 0);
        C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, false);
        xVar.mo10940a(b).mo10945d();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|9|10|11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        com.adcolony.sdk.C0717k0.m516a("Error saving screenshot.", 0);
        com.adcolony.sdk.C0795s.m802b(r2, com.google.firebase.analytics.FirebaseAnalytics.Param.SUCCESS, false);
        r11.mo10940a(r2).mo10945d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00e1, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00e2, code lost:
        com.adcolony.sdk.C0717k0.m516a("Error saving screenshot.", 0);
        com.adcolony.sdk.C0795s.m802b(r2, com.google.firebase.analytics.FirebaseAnalytics.Param.SUCCESS, false);
        r11.mo10940a(r2).mo10945d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00f3, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x00ab */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo10700i(com.adcolony.sdk.C0812x r11) {
        /*
            r10 = this;
            android.content.Context r0 = com.adcolony.sdk.C0557a.m86b()
            r1 = 0
            if (r0 == 0) goto L_0x011f
            boolean r2 = r0 instanceof android.app.Activity
            if (r2 != 0) goto L_0x000d
            goto L_0x011f
        L_0x000d:
            java.lang.String r2 = "android.permission.WRITE_EXTERNAL_STORAGE"
            int r2 = android.support.p000v4.app.ActivityCompat.checkSelfPermission(r0, r2)     // Catch:{ NoClassDefFoundError -> 0x010a }
            if (r2 != 0) goto L_0x00f4
            org.json.JSONObject r2 = r11.mo10941b()     // Catch:{ NoClassDefFoundError -> 0x010a }
            java.lang.String r3 = "ad_session_id"
            java.lang.String r2 = com.adcolony.sdk.C0795s.m812h(r2, r3)     // Catch:{ NoClassDefFoundError -> 0x010a }
            r10.mo10690a((java.lang.String) r2)     // Catch:{ NoClassDefFoundError -> 0x010a }
            org.json.JSONObject r2 = com.adcolony.sdk.C0795s.m798b()     // Catch:{ NoClassDefFoundError -> 0x010a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NoClassDefFoundError -> 0x010a }
            r3.<init>()     // Catch:{ NoClassDefFoundError -> 0x010a }
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ NoClassDefFoundError -> 0x010a }
            java.lang.String r4 = r4.toString()     // Catch:{ NoClassDefFoundError -> 0x010a }
            r3.append(r4)     // Catch:{ NoClassDefFoundError -> 0x010a }
            java.lang.String r4 = "/Pictures/AdColony_Screenshots/AdColony_Screenshot_"
            r3.append(r4)     // Catch:{ NoClassDefFoundError -> 0x010a }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ NoClassDefFoundError -> 0x010a }
            r3.append(r4)     // Catch:{ NoClassDefFoundError -> 0x010a }
            java.lang.String r4 = ".jpg"
            r3.append(r4)     // Catch:{ NoClassDefFoundError -> 0x010a }
            java.lang.String r3 = r3.toString()     // Catch:{ NoClassDefFoundError -> 0x010a }
            r4 = r0
            android.app.Activity r4 = (android.app.Activity) r4     // Catch:{ NoClassDefFoundError -> 0x010a }
            android.view.Window r4 = r4.getWindow()     // Catch:{ NoClassDefFoundError -> 0x010a }
            android.view.View r4 = r4.getDecorView()     // Catch:{ NoClassDefFoundError -> 0x010a }
            android.view.View r4 = r4.getRootView()     // Catch:{ NoClassDefFoundError -> 0x010a }
            r5 = 1
            r4.setDrawingCacheEnabled(r5)     // Catch:{ NoClassDefFoundError -> 0x010a }
            android.graphics.Bitmap r6 = r4.getDrawingCache()     // Catch:{ NoClassDefFoundError -> 0x010a }
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createBitmap(r6)     // Catch:{ NoClassDefFoundError -> 0x010a }
            r4.setDrawingCacheEnabled(r1)     // Catch:{ NoClassDefFoundError -> 0x010a }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x00ab }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ab }
            r7.<init>()     // Catch:{ Exception -> 0x00ab }
            java.io.File r8 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x00ab }
            java.lang.String r8 = r8.getPath()     // Catch:{ Exception -> 0x00ab }
            r7.append(r8)     // Catch:{ Exception -> 0x00ab }
            java.lang.String r8 = "/Pictures"
            r7.append(r8)     // Catch:{ Exception -> 0x00ab }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00ab }
            r4.<init>(r7)     // Catch:{ Exception -> 0x00ab }
            java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x00ab }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ab }
            r8.<init>()     // Catch:{ Exception -> 0x00ab }
            java.io.File r9 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x00ab }
            java.lang.String r9 = r9.getPath()     // Catch:{ Exception -> 0x00ab }
            r8.append(r9)     // Catch:{ Exception -> 0x00ab }
            java.lang.String r9 = "/Pictures/AdColony_Screenshots"
            r8.append(r9)     // Catch:{ Exception -> 0x00ab }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00ab }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00ab }
            r4.mkdirs()     // Catch:{ Exception -> 0x00ab }
            r7.mkdirs()     // Catch:{ Exception -> 0x00ab }
        L_0x00ab:
            java.io.File r4 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d0 }
            r4.<init>(r3)     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d0 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d0 }
            r7.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d0 }
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d0 }
            r8 = 90
            r6.compress(r4, r8, r7)     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d0 }
            r7.flush()     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d0 }
            r7.close()     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d0 }
            java.lang.String[] r4 = new java.lang.String[r5]     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d0 }
            r4[r1] = r3     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d0 }
            r3 = 0
            com.adcolony.sdk.i0$i r6 = new com.adcolony.sdk.i0$i     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d0 }
            r6.<init>(r2, r11)     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d0 }
            android.media.MediaScannerConnection.scanFile(r0, r4, r3, r6)     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d0 }
            return r5
        L_0x00d0:
            java.lang.String r0 = "Error saving screenshot."
            com.adcolony.sdk.C0717k0.m516a((java.lang.String) r0, (int) r1)     // Catch:{ NoClassDefFoundError -> 0x010a }
            java.lang.String r0 = "success"
            com.adcolony.sdk.C0795s.m802b((org.json.JSONObject) r2, (java.lang.String) r0, (boolean) r1)     // Catch:{ NoClassDefFoundError -> 0x010a }
            com.adcolony.sdk.x r0 = r11.mo10940a((org.json.JSONObject) r2)     // Catch:{ NoClassDefFoundError -> 0x010a }
            r0.mo10945d()     // Catch:{ NoClassDefFoundError -> 0x010a }
            return r1
        L_0x00e2:
            java.lang.String r0 = "Error saving screenshot."
            com.adcolony.sdk.C0717k0.m516a((java.lang.String) r0, (int) r1)     // Catch:{ NoClassDefFoundError -> 0x010a }
            java.lang.String r0 = "success"
            com.adcolony.sdk.C0795s.m802b((org.json.JSONObject) r2, (java.lang.String) r0, (boolean) r1)     // Catch:{ NoClassDefFoundError -> 0x010a }
            com.adcolony.sdk.x r0 = r11.mo10940a((org.json.JSONObject) r2)     // Catch:{ NoClassDefFoundError -> 0x010a }
            r0.mo10945d()     // Catch:{ NoClassDefFoundError -> 0x010a }
            return r1
        L_0x00f4:
            java.lang.String r0 = "Error saving screenshot."
            com.adcolony.sdk.C0717k0.m516a((java.lang.String) r0, (int) r1)     // Catch:{ NoClassDefFoundError -> 0x010a }
            org.json.JSONObject r0 = r11.mo10941b()     // Catch:{ NoClassDefFoundError -> 0x010a }
            java.lang.String r2 = "success"
            com.adcolony.sdk.C0795s.m802b((org.json.JSONObject) r0, (java.lang.String) r2, (boolean) r1)     // Catch:{ NoClassDefFoundError -> 0x010a }
            com.adcolony.sdk.x r0 = r11.mo10940a((org.json.JSONObject) r0)     // Catch:{ NoClassDefFoundError -> 0x010a }
            r0.mo10945d()     // Catch:{ NoClassDefFoundError -> 0x010a }
            return r1
        L_0x010a:
            java.lang.String r0 = "Error saving screenshot."
            com.adcolony.sdk.C0717k0.m516a((java.lang.String) r0, (int) r1)
            org.json.JSONObject r0 = r11.mo10941b()
            java.lang.String r2 = "success"
            com.adcolony.sdk.C0795s.m802b((org.json.JSONObject) r0, (java.lang.String) r2, (boolean) r1)
            com.adcolony.sdk.x r11 = r11.mo10940a((org.json.JSONObject) r0)
            r11.mo10945d()
        L_0x011f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0674i0.mo10700i(com.adcolony.sdk.x):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public boolean mo10701j(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        JSONObject b2 = C0795s.m798b();
        String h = C0795s.m812h(b, "ad_session_id");
        JSONArray c = C0795s.m803c(b, "recipients");
        String str = "";
        for (int i = 0; i < c.length(); i++) {
            if (i != 0) {
                str = str + ";";
            }
            str = str + C0795s.m806d(c, i);
        }
        if (C0717k0.m513a(new Intent("android.intent.action.VIEW", Uri.parse("smsto:" + str)).putExtra("sms_body", C0795s.m812h(b, "body")))) {
            C0795s.m802b(b2, FirebaseAnalytics.Param.SUCCESS, true);
            xVar.mo10940a(b2).mo10945d();
            mo10692b(h);
            mo10690a(h);
            m381c(h);
            return true;
        }
        C0717k0.m516a("Failed to create sms.", 0);
        C0795s.m802b(b2, FirebaseAnalytics.Param.SUCCESS, false);
        xVar.mo10940a(b2).mo10945d();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public boolean mo10702k(C0812x xVar) {
        JSONObject b = C0795s.m798b();
        JSONObject b2 = xVar.mo10941b();
        Intent type = new Intent("android.intent.action.SEND").setType(NanoHTTPD.MIME_PLAINTEXT);
        Intent putExtra = type.putExtra("android.intent.extra.TEXT", C0795s.m812h(b2, "text") + " " + C0795s.m812h(b2, "url"));
        String h = C0795s.m812h(b2, "ad_session_id");
        if (C0717k0.m514a(putExtra, true)) {
            C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, true);
            xVar.mo10940a(b).mo10945d();
            mo10692b(h);
            mo10690a(h);
            m381c(h);
            return true;
        }
        C0717k0.m516a("Unable to create social post.", 0);
        C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, false);
        xVar.mo10940a(b).mo10945d();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public boolean mo10703l(C0812x xVar) {
        JSONObject b = C0795s.m798b();
        JSONObject b2 = xVar.mo10941b();
        Intent intent = new Intent("android.intent.action.DIAL");
        Intent data = intent.setData(Uri.parse("tel:" + C0795s.m812h(b2, "phone_number")));
        String h = C0795s.m812h(b2, "ad_session_id");
        if (C0717k0.m513a(data)) {
            C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, true);
            xVar.mo10940a(b).mo10945d();
            mo10692b(h);
            mo10690a(h);
            m381c(h);
            return true;
        }
        C0717k0.m516a("Failed to dial number.", 0);
        C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, false);
        xVar.mo10940a(b).mo10945d();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public boolean mo10704m(C0812x xVar) {
        Context b = C0557a.m86b();
        if (b == null) {
            return false;
        }
        int a = C0795s.m777a(xVar.mo10941b(), "length_ms", 500);
        JSONObject b2 = C0795s.m798b();
        JSONArray c = C0717k0.m525c(b);
        boolean z = false;
        for (int i = 0; i < c.length(); i++) {
            if (C0795s.m806d(c, i).equals("android.permission.VIBRATE")) {
                z = true;
            }
        }
        if (!z) {
            new C0797u.C0798a().mo10920a("No vibrate permission detected.").mo10922a(C0797u.f1092g);
            C0795s.m802b(b2, FirebaseAnalytics.Param.SUCCESS, false);
            xVar.mo10940a(b2).mo10945d();
            return false;
        }
        try {
            ((Vibrator) b.getSystemService("vibrator")).vibrate((long) a);
            C0795s.m802b(b2, FirebaseAnalytics.Param.SUCCESS, false);
            xVar.mo10940a(b2).mo10945d();
            return true;
        } catch (Exception unused) {
            new C0797u.C0798a().mo10920a("Vibrate command failed.").mo10922a(C0797u.f1092g);
            C0795s.m802b(b2, FirebaseAnalytics.Param.SUCCESS, false);
            xVar.mo10940a(b2).mo10945d();
            return false;
        }
    }
}
