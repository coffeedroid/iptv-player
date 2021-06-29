package com.adcolony.sdk;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.adcolony.sdk.C0797u;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.settings.SettingsJsonConstants;

public class AdColonyAdView extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C0563c f129a = C0557a.m88c().mo10633b().mo10565d().get(this.f132d);

    /* renamed from: b */
    private AdColonyAdViewListener f130b;

    /* renamed from: c */
    private AdColonyAdSize f131c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f132d;

    /* renamed from: e */
    private String f133e;

    /* renamed from: f */
    private String f134f;

    /* renamed from: g */
    private ImageView f135g;

    /* renamed from: h */
    private C0576c0 f136h;

    /* renamed from: i */
    private C0812x f137i;

    /* renamed from: j */
    private boolean f138j;

    /* renamed from: k */
    private boolean f139k;

    /* renamed from: l */
    private boolean f140l;

    /* renamed from: m */
    private boolean f141m;

    /* renamed from: n */
    private boolean f142n;

    /* renamed from: o */
    private int f143o;

    /* renamed from: p */
    private int f144p;

    /* renamed from: q */
    private int f145q;

    /* renamed from: r */
    private int f146r;

    /* renamed from: s */
    private int f147s;

    /* renamed from: t */
    private JSONObject f148t;

    /* renamed from: com.adcolony.sdk.AdColonyAdView$a */
    class C0554a implements Runnable {
        C0554a() {
        }

        public void run() {
            Context b = C0557a.m86b();
            if (b instanceof AdColonyAdViewActivity) {
                ((AdColonyAdViewActivity) b).mo10346b();
            }
            C0580d b2 = C0557a.m88c().mo10633b();
            b2.mo10562b().remove(AdColonyAdView.this.f132d);
            b2.mo10557a(AdColonyAdView.this.f129a);
            JSONObject b3 = C0795s.m798b();
            C0795s.m791a(b3, "id", AdColonyAdView.this.f132d);
            new C0812x("AdSession.on_ad_view_destroyed", 1, b3).mo10945d();
        }
    }

    /* renamed from: com.adcolony.sdk.AdColonyAdView$b */
    class C0555b implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Context f150a;

        C0555b(Context context) {
            this.f150a = context;
        }

        public void onClick(View view) {
            Context context = this.f150a;
            if (context instanceof AdColonyAdViewActivity) {
                ((AdColonyAdViewActivity) context).mo10346b();
            }
        }
    }

    AdColonyAdView(Context context, C0812x xVar, AdColonyAdViewListener adColonyAdViewListener) {
        super(context);
        this.f130b = adColonyAdViewListener;
        this.f133e = adColonyAdViewListener.mo10360c();
        JSONObject b = xVar.mo10941b();
        this.f148t = b;
        this.f132d = C0795s.m812h(b, "id");
        this.f134f = C0795s.m812h(b, "close_button_filepath");
        this.f138j = C0795s.m807d(b, "trusted_demand_source");
        this.f142n = C0795s.m807d(b, "close_button_snap_to_webview");
        this.f146r = C0795s.m810f(b, "close_button_width");
        this.f147s = C0795s.m810f(b, "close_button_height");
        this.f131c = adColonyAdViewListener.mo10355a();
        setLayoutParams(new FrameLayout.LayoutParams(this.f129a.mo10517d(), this.f129a.mo10510b()));
        setBackgroundColor(0);
        addView(this.f129a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10321a() {
        if (this.f138j || this.f141m) {
            float n = C0557a.m88c().mo10647h().mo10737n();
            this.f129a.setLayoutParams(new FrameLayout.LayoutParams((int) (((float) this.f131c.getWidth()) * n), (int) (((float) this.f131c.getHeight()) * n)));
            C0737m0 webView = getWebView();
            if (webView != null) {
                C0812x xVar = new C0812x("WebView.set_bounds", 0);
                JSONObject b = C0795s.m798b();
                C0795s.m801b(b, "x", webView.mo10833n());
                C0795s.m801b(b, "y", webView.mo10834o());
                C0795s.m801b(b, SettingsJsonConstants.ICON_WIDTH_KEY, webView.mo10832m());
                C0795s.m801b(b, SettingsJsonConstants.ICON_HEIGHT_KEY, webView.mo10831l());
                xVar.mo10943b(b);
                webView.mo10816a(xVar);
                JSONObject b2 = C0795s.m798b();
                C0795s.m791a(b2, "ad_session_id", this.f132d);
                new C0812x("MRAID.on_close", this.f129a.mo10531k(), b2).mo10945d();
            }
            ImageView imageView = this.f135g;
            if (imageView != null) {
                this.f129a.removeView(imageView);
            }
            addView(this.f129a);
            AdColonyAdViewListener adColonyAdViewListener = this.f130b;
            if (adColonyAdViewListener != null) {
                adColonyAdViewListener.onClosed(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo10322b() {
        if (this.f138j || this.f141m) {
            C0694j h = C0557a.m88c().mo10647h();
            int s = h.mo10742s();
            int r = h.mo10741r();
            int i = this.f144p;
            if (i <= 0) {
                i = s;
            }
            int i2 = this.f145q;
            if (i2 <= 0) {
                i2 = r;
            }
            int i3 = (s - i) / 2;
            int i4 = (r - i2) / 2;
            this.f129a.setLayoutParams(new FrameLayout.LayoutParams(s, r));
            C0737m0 webView = getWebView();
            if (webView != null) {
                C0812x xVar = new C0812x("WebView.set_bounds", 0);
                JSONObject b = C0795s.m798b();
                C0795s.m801b(b, "x", i3);
                C0795s.m801b(b, "y", i4);
                C0795s.m801b(b, SettingsJsonConstants.ICON_WIDTH_KEY, i);
                C0795s.m801b(b, SettingsJsonConstants.ICON_HEIGHT_KEY, i2);
                xVar.mo10943b(b);
                webView.mo10816a(xVar);
                float n = h.mo10737n();
                JSONObject b2 = C0795s.m798b();
                C0795s.m801b(b2, "app_orientation", C0717k0.m535g(C0717k0.m536g()));
                C0795s.m801b(b2, SettingsJsonConstants.ICON_WIDTH_KEY, (int) (((float) i) / n));
                C0795s.m801b(b2, SettingsJsonConstants.ICON_HEIGHT_KEY, (int) (((float) i2) / n));
                C0795s.m801b(b2, "x", C0717k0.m503a((View) webView));
                C0795s.m801b(b2, "y", C0717k0.m520b((View) webView));
                C0795s.m791a(b2, "ad_session_id", this.f132d);
                new C0812x("MRAID.on_size_change", this.f129a.mo10531k(), b2).mo10945d();
            }
            ImageView imageView = this.f135g;
            if (imageView != null) {
                this.f129a.removeView(imageView);
            }
            Context b3 = C0557a.m86b();
            if (!(b3 == null || this.f140l || webView == null)) {
                float n2 = C0557a.m88c().mo10647h().mo10737n();
                int i5 = (int) (((float) this.f146r) * n2);
                int i6 = (int) (((float) this.f147s) * n2);
                if (this.f142n) {
                    s = webView.mo10829j() + webView.mo10828i();
                }
                int k = this.f142n ? webView.mo10830k() : 0;
                ImageView imageView2 = new ImageView(b3.getApplicationContext());
                this.f135g = imageView2;
                imageView2.setImageURI(Uri.fromFile(new File(this.f134f)));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i5, i6);
                layoutParams.setMargins(s - i5, k, 0, 0);
                this.f135g.setOnClickListener(new C0555b(b3));
                this.f129a.addView(this.f135g, layoutParams);
            }
            if (this.f137i != null) {
                JSONObject b4 = C0795s.m798b();
                C0795s.m802b(b4, FirebaseAnalytics.Param.SUCCESS, true);
                this.f137i.mo10940a(b4).mo10945d();
                this.f137i = null;
            }
            return true;
        }
        if (this.f137i != null) {
            JSONObject b5 = C0795s.m798b();
            C0795s.m802b(b5, FirebaseAnalytics.Param.SUCCESS, false);
            this.f137i.mo10940a(b5).mo10945d();
            this.f137i = null;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo10323c() {
        return this.f139k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo10324d() {
        if (this.f136h != null) {
            getWebView().mo10826g();
        }
    }

    public boolean destroy() {
        if (this.f139k) {
            new C0797u.C0798a().mo10920a("Ignoring duplicate call to destroy().").mo10922a(C0797u.f1092g);
            return false;
        }
        this.f139k = true;
        C0576c0 c0Var = this.f136h;
        if (!(c0Var == null || c0Var.mo10551c() == null)) {
            this.f136h.mo10550b();
        }
        C0717k0.m515a((Runnable) new C0554a());
        return true;
    }

    /* access modifiers changed from: package-private */
    public String getAdSessionId() {
        return this.f132d;
    }

    public AdColonyAdSize getAdSize() {
        return this.f131c;
    }

    /* access modifiers changed from: package-private */
    public C0563c getContainer() {
        return this.f129a;
    }

    public AdColonyAdViewListener getListener() {
        return this.f130b;
    }

    /* access modifiers changed from: package-private */
    public C0576c0 getOmidManager() {
        return this.f136h;
    }

    /* access modifiers changed from: package-private */
    public int getOrientation() {
        return this.f143o;
    }

    /* access modifiers changed from: package-private */
    public boolean getTrustedDemandSource() {
        return this.f138j;
    }

    /* access modifiers changed from: package-private */
    public boolean getUserInteraction() {
        return this.f141m;
    }

    /* access modifiers changed from: package-private */
    public C0737m0 getWebView() {
        C0563c cVar = this.f129a;
        if (cVar == null) {
            return null;
        }
        return cVar.mo10534n().get(2);
    }

    public String getZoneId() {
        return this.f133e;
    }

    /* access modifiers changed from: package-private */
    public void setExpandMessage(C0812x xVar) {
        this.f137i = xVar;
    }

    /* access modifiers changed from: package-private */
    public void setExpandedHeight(int i) {
        this.f145q = (int) (((float) i) * C0557a.m88c().mo10647h().mo10737n());
    }

    /* access modifiers changed from: package-private */
    public void setExpandedWidth(int i) {
        this.f144p = (int) (((float) i) * C0557a.m88c().mo10647h().mo10737n());
    }

    public void setListener(AdColonyAdViewListener adColonyAdViewListener) {
        this.f130b = adColonyAdViewListener;
    }

    /* access modifiers changed from: package-private */
    public void setNoCloseButton(boolean z) {
        this.f140l = this.f138j && z;
    }

    /* access modifiers changed from: package-private */
    public void setOmidManager(C0576c0 c0Var) {
        this.f136h = c0Var;
    }

    /* access modifiers changed from: package-private */
    public void setOrientation(int i) {
        this.f143o = i;
    }

    /* access modifiers changed from: package-private */
    public void setUserInteraction(boolean z) {
        this.f141m = z;
    }
}
