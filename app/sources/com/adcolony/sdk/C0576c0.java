package com.adcolony.sdk;

import android.support.p000v4.app.NotificationCompat;
import android.webkit.WebView;
import com.adcolony.sdk.C0797u;
import com.google.android.gms.measurement.AppMeasurement;
import com.iab.omid.library.adcolony.adsession.AdEvents;
import com.iab.omid.library.adcolony.adsession.AdSession;
import com.iab.omid.library.adcolony.adsession.AdSessionConfiguration;
import com.iab.omid.library.adcolony.adsession.AdSessionContext;
import com.iab.omid.library.adcolony.adsession.Owner;
import com.iab.omid.library.adcolony.adsession.VerificationScriptResource;
import com.iab.omid.library.adcolony.adsession.video.InteractionType;
import com.iab.omid.library.adcolony.adsession.video.Position;
import com.iab.omid.library.adcolony.adsession.video.VastProperties;
import com.iab.omid.library.adcolony.adsession.video.VideoEvents;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.settings.SettingsJsonConstants;

/* renamed from: com.adcolony.sdk.c0 */
class C0576c0 {

    /* renamed from: a */
    private AdSessionContext f270a;

    /* renamed from: b */
    private AdSessionConfiguration f271b;

    /* renamed from: c */
    private AdSession f272c;

    /* renamed from: d */
    private AdEvents f273d;

    /* renamed from: e */
    private VideoEvents f274e;

    /* renamed from: f */
    private AdColonyCustomMessageListener f275f;

    /* renamed from: g */
    private List<VerificationScriptResource> f276g = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f277h = -1;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f278i = "";

    /* renamed from: j */
    private int f279j;

    /* renamed from: k */
    private boolean f280k;

    /* renamed from: l */
    private boolean f281l;

    /* renamed from: m */
    private boolean f282m;

    /* renamed from: n */
    private boolean f283n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f284o;

    /* renamed from: p */
    private int f285p;

    /* renamed from: q */
    private int f286q;

    /* renamed from: r */
    private String f287r = "";
    /* access modifiers changed from: private */

    /* renamed from: s */
    public String f288s = "";

    /* renamed from: com.adcolony.sdk.c0$a */
    class C0577a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f289a;

        C0577a(String str) {
            this.f289a = str;
        }

        public void run() {
            JSONObject b = C0795s.m798b();
            JSONObject b2 = C0795s.m798b();
            C0795s.m801b(b2, "session_type", C0576c0.this.f277h);
            C0795s.m791a(b2, "session_id", C0576c0.this.f278i);
            C0795s.m791a(b2, NotificationCompat.CATEGORY_EVENT, this.f289a);
            C0795s.m791a(b, AppMeasurement.Param.TYPE, "iab_hook");
            C0795s.m791a(b, SettingsJsonConstants.PROMPT_MESSAGE_KEY, b2.toString());
            new C0812x("CustomMessage.controller_send", 0, b).mo10945d();
        }
    }

    /* renamed from: com.adcolony.sdk.c0$b */
    class C0578b implements AdColonyCustomMessageListener {

        /* renamed from: com.adcolony.sdk.c0$b$a */
        class C0579a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f292a;

            /* renamed from: b */
            final /* synthetic */ String f293b;

            /* renamed from: c */
            final /* synthetic */ float f294c;

            C0579a(String str, String str2, float f) {
                this.f292a = str;
                this.f293b = str2;
                this.f294c = f;
            }

            public void run() {
                if (this.f292a.equals(C0576c0.this.f288s)) {
                    C0576c0.this.mo10549a(this.f293b, this.f294c);
                    return;
                }
                AdColonyAdView adColonyAdView = C0557a.m88c().mo10633b().mo10562b().get(this.f292a);
                C0576c0 omidManager = adColonyAdView != null ? adColonyAdView.getOmidManager() : null;
                if (omidManager != null) {
                    omidManager.mo10549a(this.f293b, this.f294c);
                }
            }
        }

        C0578b() {
        }

        public void onAdColonyCustomMessage(AdColonyCustomMessage adColonyCustomMessage) {
            JSONObject b = C0795s.m799b(adColonyCustomMessage.getMessage());
            String h = C0795s.m812h(b, "event_type");
            float floatValue = BigDecimal.valueOf(C0795s.m808e(b, FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION)).floatValue();
            boolean d = C0795s.m807d(b, "replay");
            boolean equals = C0795s.m812h(b, "skip_type").equals("dec");
            String h2 = C0795s.m812h(b, "asi");
            if (h.equals("skip") && equals) {
                boolean unused = C0576c0.this.f284o = true;
            } else if (!d || (!h.equals("start") && !h.equals("first_quartile") && !h.equals("midpoint") && !h.equals("third_quartile") && !h.equals("complete"))) {
                C0717k0.m515a((Runnable) new C0579a(h2, h, floatValue));
            }
        }
    }

    C0576c0(JSONObject jSONObject, String str) {
        this.f277h = m168a(jSONObject);
        this.f283n = C0795s.m807d(jSONObject, "skippable");
        this.f285p = C0795s.m810f(jSONObject, "skip_offset");
        this.f286q = C0795s.m810f(jSONObject, "video_duration");
        JSONArray c = C0795s.m803c(jSONObject, "js_resources");
        JSONArray c2 = C0795s.m803c(jSONObject, "verification_params");
        JSONArray c3 = C0795s.m803c(jSONObject, "vendor_keys");
        this.f288s = str;
        for (int i = 0; i < c.length(); i++) {
            try {
                String d = C0795s.m806d(c2, i);
                String d2 = C0795s.m806d(c3, i);
                URL url = new URL(C0795s.m806d(c, i));
                this.f276g.add((d.equals("") || d2.equals("")) ? !d2.equals("") ? VerificationScriptResource.createVerificationScriptResourceWithoutParameters(d2, url) : VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url) : VerificationScriptResource.createVerificationScriptResourceWithParameters(d2, url, d));
            } catch (MalformedURLException unused) {
                new C0797u.C0798a().mo10920a("Invalid js resource url passed to Omid").mo10922a(C0797u.f1095j);
            }
        }
        try {
            this.f287r = C0557a.m88c().mo10650k().mo10885a(C0795s.m812h(jSONObject, "filepath"), true).toString();
        } catch (IOException unused2) {
            new C0797u.C0798a().mo10920a("Error loading IAB JS Client").mo10922a(C0797u.f1095j);
        }
    }

    /* renamed from: a */
    private int m168a(JSONObject jSONObject) {
        if (this.f277h == -1) {
            this.f279j = C0795s.m810f(jSONObject, "ad_unit_type");
            String h = C0795s.m812h(jSONObject, "ad_type");
            int i = this.f279j;
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                if (h.equals("video")) {
                    return 0;
                }
                if (h.equals("display")) {
                    return 1;
                }
                if (h.equals("banner_display") || h.equals("interstitial_display")) {
                    return 2;
                }
            }
        }
        return this.f277h;
    }

    /* renamed from: b */
    private void m171b(C0563c cVar) {
        m172b("register_ad_view");
        C0737m0 m0Var = C0557a.m88c().mo10661v().get(Integer.valueOf(cVar.mo10531k()));
        if (m0Var == null && !cVar.mo10534n().isEmpty()) {
            m0Var = (C0737m0) cVar.mo10534n().entrySet().iterator().next().getValue();
        }
        AdSession adSession = this.f272c;
        if (adSession == null || m0Var == null) {
            AdSession adSession2 = this.f272c;
            if (adSession2 != null) {
                adSession2.registerAdView(cVar);
                cVar.mo10507a(this.f272c);
                m172b("register_obstructions");
                return;
            }
            return;
        }
        adSession.registerAdView(m0Var);
        m0Var.mo10824e();
    }

    /* renamed from: b */
    private void m172b(String str) {
        C0717k0.f836b.execute(new C0577a(str));
    }

    /* renamed from: f */
    private void m174f() {
        C0578b bVar = new C0578b();
        this.f275f = bVar;
        AdColony.addCustomMessageListener(bVar, "viewability_ad_event");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10545a() throws IllegalArgumentException {
        mo10546a((WebView) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10546a(WebView webView) throws IllegalArgumentException {
        String str;
        List<VerificationScriptResource> list;
        if (this.f277h >= 0 && (str = this.f287r) != null && !str.equals("") && (list = this.f276g) != null) {
            if (!list.isEmpty() || mo10552d() == 2) {
                C0648h c = C0557a.m88c();
                Owner owner = Owner.NATIVE;
                int d = mo10552d();
                if (d == 0) {
                    this.f270a = AdSessionContext.createNativeAdSessionContext(c.mo10655p(), this.f287r, this.f276g, (String) null);
                    AdSessionConfiguration createAdSessionConfiguration = AdSessionConfiguration.createAdSessionConfiguration(owner, owner, false);
                    this.f271b = createAdSessionConfiguration;
                    AdSession createAdSession = AdSession.createAdSession(createAdSessionConfiguration, this.f270a);
                    this.f272c = createAdSession;
                    this.f278i = createAdSession.getAdSessionId();
                    m172b("inject_javascript");
                } else if (d == 1) {
                    this.f270a = AdSessionContext.createNativeAdSessionContext(c.mo10655p(), this.f287r, this.f276g, (String) null);
                    AdSessionConfiguration createAdSessionConfiguration2 = AdSessionConfiguration.createAdSessionConfiguration(owner, (Owner) null, false);
                    this.f271b = createAdSessionConfiguration2;
                    AdSession createAdSession2 = AdSession.createAdSession(createAdSessionConfiguration2, this.f270a);
                    this.f272c = createAdSession2;
                    this.f278i = createAdSession2.getAdSessionId();
                    m172b("inject_javascript");
                } else if (d == 2) {
                    this.f270a = AdSessionContext.createHtmlAdSessionContext(c.mo10655p(), webView, "");
                    AdSessionConfiguration createAdSessionConfiguration3 = AdSessionConfiguration.createAdSessionConfiguration(owner, (Owner) null, false);
                    this.f271b = createAdSessionConfiguration3;
                    AdSession createAdSession3 = AdSession.createAdSession(createAdSessionConfiguration3, this.f270a);
                    this.f272c = createAdSession3;
                    this.f278i = createAdSession3.getAdSessionId();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10547a(C0563c cVar) {
        if (!this.f282m && this.f277h >= 0 && this.f272c != null) {
            m171b(cVar);
            m174f();
            this.f274e = this.f277h != 0 ? null : VideoEvents.createVideoEvents(this.f272c);
            this.f272c.start();
            this.f273d = AdEvents.createAdEvents(this.f272c);
            m172b("start_session");
            if (this.f274e != null) {
                Position position = Position.PREROLL;
                this.f274e.loaded(this.f283n ? VastProperties.createVastPropertiesForSkippableVideo((float) this.f285p, true, position) : VastProperties.createVastPropertiesForNonSkippableVideo(true, position));
            }
            this.f282m = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10548a(String str) {
        mo10549a(str, 0.0f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10549a(String str, float f) {
        if (C0557a.m89d() && this.f272c != null) {
            if (this.f274e != null || str.equals("start") || str.equals("skip") || str.equals("continue") || str.equals("cancel")) {
                char c = 65535;
                try {
                    switch (str.hashCode()) {
                        case -1941887438:
                            if (str.equals("first_quartile")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1710060637:
                            if (str.equals("buffer_start")) {
                                c = 12;
                                break;
                            }
                            break;
                        case -1638835128:
                            if (str.equals("midpoint")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1367724422:
                            if (str.equals("cancel")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -934426579:
                            if (str.equals("resume")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -651914917:
                            if (str.equals("third_quartile")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -599445191:
                            if (str.equals("complete")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -567202649:
                            if (str.equals("continue")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -342650039:
                            if (str.equals("sound_mute")) {
                                c = 8;
                                break;
                            }
                            break;
                        case 3532159:
                            if (str.equals("skip")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 106440182:
                            if (str.equals("pause")) {
                                c = 10;
                                break;
                            }
                            break;
                        case 109757538:
                            if (str.equals("start")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 583742045:
                            if (str.equals("in_video_engagement")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 823102269:
                            if (str.equals("html5_interaction")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 1648173410:
                            if (str.equals("sound_unmute")) {
                                c = 9;
                                break;
                            }
                            break;
                        case 1906584668:
                            if (str.equals("buffer_end")) {
                                c = 13;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            this.f273d.impressionOccurred();
                            if (this.f274e != null) {
                                VideoEvents videoEvents = this.f274e;
                                if (f <= 0.0f) {
                                    f = (float) this.f286q;
                                }
                                videoEvents.start(f, 1.0f);
                            }
                            m172b(str);
                            return;
                        case 1:
                            this.f274e.firstQuartile();
                            m172b(str);
                            return;
                        case 2:
                            this.f274e.midpoint();
                            m172b(str);
                            return;
                        case 3:
                            this.f274e.thirdQuartile();
                            m172b(str);
                            return;
                        case 4:
                            this.f284o = true;
                            this.f274e.complete();
                            m172b(str);
                            return;
                        case 5:
                            m172b(str);
                            mo10550b();
                            return;
                        case 6:
                        case 7:
                            if (this.f274e != null) {
                                this.f274e.skipped();
                            }
                            m172b(str);
                            mo10550b();
                            return;
                        case 8:
                            this.f274e.volumeChange(0.0f);
                            m172b(str);
                            return;
                        case 9:
                            this.f274e.volumeChange(1.0f);
                            m172b(str);
                            return;
                        case 10:
                            if (!this.f280k && !this.f281l && !this.f284o) {
                                this.f274e.pause();
                                m172b(str);
                                this.f280k = true;
                                this.f281l = false;
                                return;
                            }
                            return;
                        case 11:
                            if (this.f280k && !this.f284o) {
                                this.f274e.resume();
                                m172b(str);
                                this.f280k = false;
                                return;
                            }
                            return;
                        case 12:
                            this.f274e.bufferStart();
                            m172b(str);
                            return;
                        case 13:
                            this.f274e.bufferFinish();
                            m172b(str);
                            return;
                        case 14:
                        case 15:
                            this.f274e.adUserInteraction(InteractionType.CLICK);
                            m172b(str);
                            if (this.f281l && !this.f280k && !this.f284o) {
                                this.f274e.pause();
                                m172b("pause");
                                this.f280k = true;
                                this.f281l = false;
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } catch (IllegalArgumentException | IllegalStateException e) {
                    C0797u.C0798a a = new C0797u.C0798a().mo10920a("Recording IAB event for ").mo10920a(str);
                    a.mo10920a(" caused " + e.getClass()).mo10922a(C0797u.f1093h);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10550b() {
        AdColony.removeCustomMessageListener("viewability_ad_event");
        this.f272c.finish();
        m172b("end_session");
        this.f272c = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public AdSession mo10551c() {
        return this.f272c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo10552d() {
        return this.f277h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo10553e() {
        this.f281l = true;
    }
}
