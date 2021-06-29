package com.adcolony.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.adcolony.sdk.C0797u;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.settings.SettingsJsonConstants;

/* renamed from: com.adcolony.sdk.b */
class C0560b extends Activity {

    /* renamed from: k */
    static final int f214k = 0;

    /* renamed from: l */
    static final int f215l = 1;

    /* renamed from: a */
    C0563c f216a;

    /* renamed from: b */
    int f217b = -1;

    /* renamed from: c */
    String f218c;

    /* renamed from: d */
    int f219d;

    /* renamed from: e */
    boolean f220e;

    /* renamed from: f */
    boolean f221f;

    /* renamed from: g */
    boolean f222g;

    /* renamed from: h */
    boolean f223h;

    /* renamed from: i */
    boolean f224i;

    /* renamed from: j */
    boolean f225j;

    /* renamed from: com.adcolony.sdk.b$a */
    class C0561a implements C0816z {
        C0561a() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0560b.this.mo10438a(xVar);
        }
    }

    C0560b() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10495a() {
        C0648h c = C0557a.m88c();
        if (this.f216a == null) {
            this.f216a = c.mo10645f();
        }
        C0563c cVar = this.f216a;
        if (cVar != null) {
            cVar.mo10513b(false);
            if (C0717k0.m537h()) {
                this.f216a.mo10513b(true);
            }
            int s = c.mo10647h().mo10742s();
            int r = this.f223h ? c.mo10647h().mo10741r() - C0717k0.m528d(C0557a.m86b()) : c.mo10647h().mo10741r();
            if (s > 0 && r > 0) {
                JSONObject b = C0795s.m798b();
                JSONObject b2 = C0795s.m798b();
                float n = c.mo10647h().mo10737n();
                C0795s.m801b(b2, SettingsJsonConstants.ICON_WIDTH_KEY, (int) (((float) s) / n));
                C0795s.m801b(b2, SettingsJsonConstants.ICON_HEIGHT_KEY, (int) (((float) r) / n));
                C0795s.m801b(b2, "app_orientation", C0717k0.m535g(C0717k0.m536g()));
                C0795s.m801b(b2, "x", 0);
                C0795s.m801b(b2, "y", 0);
                C0795s.m791a(b2, "ad_session_id", this.f216a.mo10504a());
                C0795s.m801b(b, "screen_width", s);
                C0795s.m801b(b, "screen_height", r);
                C0795s.m791a(b, "ad_session_id", this.f216a.mo10504a());
                C0795s.m801b(b, "id", this.f216a.mo10514c());
                this.f216a.setLayoutParams(new FrameLayout.LayoutParams(s, r));
                this.f216a.mo10512b(s);
                this.f216a.mo10505a(r);
                new C0812x("MRAID.on_size_change", this.f216a.mo10531k(), b2).mo10945d();
                new C0812x("AdContainer.on_orientation_change", this.f216a.mo10531k(), b).mo10945d();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10496a(int i) {
        if (i == 0) {
            setRequestedOrientation(7);
        } else if (i != 1) {
            setRequestedOrientation(4);
        } else {
            setRequestedOrientation(6);
        }
        this.f217b = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10438a(C0812x xVar) {
        int f = C0795s.m810f(xVar.mo10941b(), "status");
        if ((f == 5 || f == 0 || f == 6 || f == 1) && !this.f220e) {
            C0648h c = C0557a.m88c();
            C0711k i = c.mo10648i();
            c.mo10638c(xVar);
            if (i.mo10770a() != null) {
                i.mo10770a().dismiss();
                i.mo10771a((AlertDialog) null);
            }
            if (!this.f222g) {
                finish();
            }
            this.f220e = true;
            ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            c.mo10641d(false);
            JSONObject b = C0795s.m798b();
            C0795s.m791a(b, "id", this.f216a.mo10504a());
            new C0812x("AdSession.on_close", this.f216a.mo10531k(), b).mo10945d();
            c.mo10626a((C0563c) null);
            c.mo10624a((AdColonyInterstitial) null);
            c.mo10621a((AdColonyAdView) null);
            C0557a.m88c().mo10633b().mo10556a().remove(this.f216a.mo10504a());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10497a(boolean z) {
        Iterator<Map.Entry<Integer, C0722l0>> it = this.f216a.mo10533m().entrySet().iterator();
        while (it.hasNext() && !isFinishing()) {
            C0722l0 l0Var = (C0722l0) it.next().getValue();
            if (!l0Var.mo10792f() && l0Var.mo10788b().isPlaying()) {
                l0Var.mo10793g();
            }
        }
        AdColonyInterstitial d = C0557a.m88c().mo10640d();
        if (d != null && d.mo10429g() && d.mo10427e().mo10551c() != null && z && this.f224i) {
            d.mo10427e().mo10548a("pause");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10498b(boolean z) {
        for (Map.Entry<Integer, C0722l0> value : this.f216a.mo10533m().entrySet()) {
            C0722l0 l0Var = (C0722l0) value.getValue();
            if (!l0Var.mo10792f() && !l0Var.mo10788b().isPlaying() && !C0557a.m88c().mo10648i().mo10773b()) {
                l0Var.mo10794h();
            }
        }
        AdColonyInterstitial d = C0557a.m88c().mo10640d();
        if (d != null && d.mo10429g() && d.mo10427e().mo10551c() != null) {
            if ((!z || (z && !this.f224i)) && this.f225j) {
                d.mo10427e().mo10548a("resume");
            }
        }
    }

    public void onBackPressed() {
        JSONObject b = C0795s.m798b();
        C0795s.m791a(b, "id", this.f216a.mo10504a());
        new C0812x("AdSession.on_back_button", this.f216a.mo10531k(), b).mo10945d();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this instanceof AdColonyInterstitialActivity) {
            mo10495a();
        } else {
            ((AdColonyAdViewActivity) this).mo10347c();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C0557a.m90e() || C0557a.m88c().mo10645f() == null) {
            finish();
            return;
        }
        C0648h c = C0557a.m88c();
        this.f222g = false;
        C0563c f = c.mo10645f();
        this.f216a = f;
        f.mo10513b(false);
        if (C0717k0.m537h()) {
            this.f216a.mo10513b(true);
        }
        this.f218c = this.f216a.mo10504a();
        this.f219d = this.f216a.mo10531k();
        boolean multiWindowEnabled = c.mo10656q().getMultiWindowEnabled();
        this.f223h = multiWindowEnabled;
        if (multiWindowEnabled) {
            getWindow().addFlags(2048);
            getWindow().clearFlags(1024);
        } else {
            getWindow().addFlags(1024);
            getWindow().clearFlags(2048);
        }
        requestWindowFeature(1);
        getWindow().getDecorView().setBackgroundColor(-16777216);
        if (c.mo10656q().getKeepScreenOn()) {
            getWindow().addFlags(128);
        }
        ViewParent parent = this.f216a.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.f216a);
        }
        setContentView(this.f216a);
        this.f216a.mo10527i().add(C0557a.m80a("AdSession.finish_fullscreen_ad", (C0816z) new C0561a(), true));
        this.f216a.mo10529j().add("AdSession.finish_fullscreen_ad");
        mo10496a(this.f217b);
        if (!this.f216a.mo10535o()) {
            JSONObject b = C0795s.m798b();
            C0795s.m791a(b, "id", this.f216a.mo10504a());
            C0795s.m801b(b, "screen_width", this.f216a.mo10517d());
            C0795s.m801b(b, "screen_height", this.f216a.mo10510b());
            new C0797u.C0798a().mo10920a("AdSession.on_fullscreen_ad_started").mo10922a(C0797u.f1089d);
            new C0812x("AdSession.on_fullscreen_ad_started", this.f216a.mo10531k(), b).mo10945d();
            this.f216a.mo10516c(true);
            return;
        }
        mo10495a();
    }

    public void onDestroy() {
        super.onDestroy();
        if (C0557a.m90e() && this.f216a != null && !this.f220e) {
            if ((Build.VERSION.SDK_INT < 24 || !C0717k0.m537h()) && !this.f216a.mo10539q()) {
                JSONObject b = C0795s.m798b();
                C0795s.m791a(b, "id", this.f216a.mo10504a());
                new C0812x("AdSession.on_error", this.f216a.mo10531k(), b).mo10945d();
                this.f222g = true;
            }
        }
    }

    public void onPause() {
        super.onPause();
        mo10497a(this.f221f);
        this.f221f = false;
    }

    public void onResume() {
        super.onResume();
        mo10495a();
        mo10498b(this.f221f);
        this.f221f = true;
        this.f225j = true;
    }

    public void onWindowFocusChanged(boolean z) {
        if (z && this.f221f) {
            C0557a.m88c().mo10658s().mo10596b(true);
            mo10498b(this.f221f);
            this.f224i = true;
        } else if (!z && this.f221f) {
            new C0797u.C0798a().mo10920a("Activity is active but window does not have focus, pausing.").mo10922a(C0797u.f1091f);
            C0557a.m88c().mo10658s().mo10595a(true);
            mo10497a(this.f221f);
            this.f224i = false;
        }
    }
}
