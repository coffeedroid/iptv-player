package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.p000v4.p002os.EnvironmentCompat;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.adcolony.sdk.C0797u;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.iab.omid.library.adcolony.ScriptInjector;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import org.json.JSONArray;
import org.json.JSONObject;
import p016fi.iki.elonen.NanoHTTPD;
import p017io.fabric.sdk.android.services.network.HttpRequest;
import p017io.fabric.sdk.android.services.settings.SettingsJsonConstants;

@SuppressLint({"SetJavaScriptEnabled"})
/* renamed from: com.adcolony.sdk.m0 */
class C0737m0 extends WebView implements C0559a0 {

    /* renamed from: N */
    static boolean f923N;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f924A;

    /* renamed from: B */
    private boolean f925B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f926C;

    /* renamed from: D */
    private boolean f927D;

    /* renamed from: E */
    private boolean f928E;

    /* renamed from: F */
    private boolean f929F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public JSONArray f930G = C0795s.m778a();
    /* access modifiers changed from: private */

    /* renamed from: H */
    public JSONObject f931H = C0795s.m798b();

    /* renamed from: I */
    private JSONObject f932I = C0795s.m798b();
    /* access modifiers changed from: private */

    /* renamed from: J */
    public C0563c f933J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public C0812x f934K;

    /* renamed from: L */
    private ImageView f935L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public final Object f936M = new Object();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f937a;

    /* renamed from: b */
    private String f938b;

    /* renamed from: c */
    private String f939c = "";

    /* renamed from: d */
    private String f940d = "";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f941e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f942f = "";

    /* renamed from: g */
    private String f943g = "";

    /* renamed from: h */
    private String f944h = "";
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f945i = "";

    /* renamed from: j */
    private String f946j = "";
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f947k;

    /* renamed from: l */
    private int f948l;

    /* renamed from: m */
    private int f949m;

    /* renamed from: n */
    private int f950n;

    /* renamed from: o */
    private int f951o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f952p;

    /* renamed from: q */
    private int f953q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f954r;

    /* renamed from: s */
    private int f955s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f956t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f957u;

    /* renamed from: v */
    private int f958v;

    /* renamed from: w */
    private int f959w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f960x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f961y;

    /* renamed from: z */
    private boolean f962z;

    /* renamed from: com.adcolony.sdk.m0$a */
    class C0738a implements Runnable {
        C0738a() {
        }

        public void run() {
            String str = "";
            synchronized (C0737m0.this.f936M) {
                if (C0737m0.this.f930G.length() > 0) {
                    if (C0737m0.this.f960x) {
                        str = C0737m0.this.f930G.toString();
                    }
                    JSONArray unused = C0737m0.this.f930G = C0795s.m778a();
                }
            }
            if (C0737m0.this.f960x) {
                C0737m0 m0Var = C0737m0.this;
                m0Var.mo10819a("NativeLayer.dispatch_messages(ADC3_update(" + str + "));");
            }
        }
    }

    /* renamed from: com.adcolony.sdk.m0$b */
    class C0739b implements Runnable {
        C0739b() {
        }

        public void run() {
            try {
                C0580d b = C0557a.m88c().mo10633b();
                AdColonyInterstitial adColonyInterstitial = b.mo10556a().get(C0737m0.this.f941e);
                AdColonyAdView adColonyAdView = b.mo10562b().get(C0737m0.this.f941e);
                C0576c0 e = adColonyInterstitial == null ? null : adColonyInterstitial.mo10427e();
                if (e == null && adColonyAdView != null) {
                    e = adColonyAdView.getOmidManager();
                }
                int d = e == null ? -1 : e.mo10552d();
                if (e != null && d == 2) {
                    e.mo10546a((WebView) C0737m0.this);
                    e.mo10547a(C0737m0.this.f933J);
                }
            } catch (IllegalArgumentException unused) {
                new C0797u.C0798a().mo10920a("IllegalArgumentException when creating omid session").mo10922a(C0797u.f1095j);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.m0$c */
    class C0740c extends WebChromeClient {

        /* renamed from: a */
        final /* synthetic */ JSONObject f965a;

        C0740c(JSONObject jSONObject) {
            this.f965a = jSONObject;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            ConsoleMessage.MessageLevel messageLevel = consoleMessage.messageLevel();
            String message = consoleMessage.message();
            boolean z = false;
            boolean z2 = messageLevel == ConsoleMessage.MessageLevel.ERROR;
            if (consoleMessage.message().contains("Viewport argument key \"shrink-to-fit\" not recognized and ignored") || consoleMessage.message().contains("Viewport target-densitydpi is not supported.")) {
                z = true;
            }
            if (message.contains("ADC3_update is not defined") || message.contains("NativeLayer.dispatch_messages is not a function")) {
                C0737m0.this.m629a(this.f965a, "Unable to communicate with AdColony. Please ensure that you have added an exception for our Javascript interface in your ProGuard configuration and that you do not have a faulty proxy enabled on your device.");
            }
            if (!z && (messageLevel == ConsoleMessage.MessageLevel.WARNING || z2)) {
                AdColonyInterstitial adColonyInterstitial = null;
                if (C0737m0.this.f941e != null) {
                    adColonyInterstitial = C0557a.m88c().mo10633b().mo10556a().get(C0737m0.this.f941e);
                }
                new C0797u.C0798a().mo10920a("onConsoleMessage: ").mo10920a(consoleMessage.message()).mo10920a(" with ad id: ").mo10920a(adColonyInterstitial == null ? EnvironmentCompat.MEDIA_UNKNOWN : adColonyInterstitial.mo10411a()).mo10922a(z2 ? C0797u.f1095j : C0797u.f1093h);
            }
            return true;
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            new C0797u.C0798a().mo10920a("JS Alert: ").mo10920a(str2).mo10922a(C0797u.f1091f);
            jsResult.confirm();
            return true;
        }
    }

    /* renamed from: com.adcolony.sdk.m0$d */
    class C0741d extends C0753l {
        C0741d() {
            super(C0737m0.this, (C0740c) null);
        }

        @RequiresApi(api = 23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            C0737m0.this.m625a(webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
        }

        @RequiresApi(api = 23)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest.getUrl().toString().endsWith("mraid.js")) {
                try {
                    return new WebResourceResponse("text/javascript", HttpRequest.CHARSET_UTF8, new ByteArrayInputStream(C0737m0.this.f942f.getBytes(HttpRequest.CHARSET_UTF8)));
                } catch (UnsupportedEncodingException unused) {
                    new C0797u.C0798a().mo10920a("UTF-8 not supported.").mo10922a(C0797u.f1095j);
                }
            }
            return null;
        }

        @RequiresApi(api = 24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (!C0737m0.this.f924A || !webResourceRequest.isForMainFrame()) {
                return false;
            }
            Uri url = webResourceRequest.getUrl();
            C0717k0.m513a(new Intent("android.intent.action.VIEW", url));
            JSONObject b = C0795s.m798b();
            C0795s.m791a(b, "url", url.toString());
            C0795s.m791a(b, "ad_session_id", C0737m0.this.f941e);
            new C0812x("WebView.redirect_detected", C0737m0.this.f933J.mo10531k(), b).mo10945d();
            C0674i0 u = C0557a.m88c().mo10660u();
            u.mo10690a(C0737m0.this.f941e);
            u.mo10692b(C0737m0.this.f941e);
            return true;
        }
    }

    /* renamed from: com.adcolony.sdk.m0$e */
    class C0742e extends C0753l {
        C0742e() {
            super(C0737m0.this, (C0740c) null);
        }

        @RequiresApi(api = 21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest.getUrl().toString().endsWith("mraid.js")) {
                try {
                    return new WebResourceResponse("text/javascript", HttpRequest.CHARSET_UTF8, new ByteArrayInputStream(C0737m0.this.f942f.getBytes(HttpRequest.CHARSET_UTF8)));
                } catch (UnsupportedEncodingException unused) {
                    new C0797u.C0798a().mo10920a("UTF-8 not supported.").mo10922a(C0797u.f1095j);
                }
            }
            return null;
        }
    }

    /* renamed from: com.adcolony.sdk.m0$f */
    class C0743f {
        C0743f() {
        }

        @JavascriptInterface
        public void dispatch_messages(String str) {
            C0737m0.this.m634b(str);
        }

        @JavascriptInterface
        public void enable_reverse_messaging() {
            boolean unused = C0737m0.this.f926C = true;
        }

        @JavascriptInterface
        public String pull_messages() {
            String str = "[]";
            synchronized (C0737m0.this.f936M) {
                if (C0737m0.this.f930G.length() > 0) {
                    if (C0737m0.this.f960x) {
                        str = C0737m0.this.f930G.toString();
                    }
                    JSONArray unused = C0737m0.this.f930G = C0795s.m778a();
                }
            }
            return str;
        }

        @JavascriptInterface
        public void push_messages(String str) {
            C0737m0.this.m634b(str);
        }
    }

    /* renamed from: com.adcolony.sdk.m0$g */
    class C0744g implements C0816z {

        /* renamed from: com.adcolony.sdk.m0$g$a */
        class C0745a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0812x f971a;

            C0745a(C0812x xVar) {
                this.f971a = xVar;
            }

            public void run() {
                C0737m0.this.mo10822b(this.f971a);
            }
        }

        C0744g() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0737m0.this.mo10823c(xVar)) {
                C0717k0.m515a((Runnable) new C0745a(xVar));
            }
        }
    }

    /* renamed from: com.adcolony.sdk.m0$h */
    class C0746h implements C0816z {

        /* renamed from: com.adcolony.sdk.m0$h$a */
        class C0747a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0812x f974a;

            C0747a(C0812x xVar) {
                this.f974a = xVar;
            }

            public void run() {
                C0737m0.this.mo10816a(this.f974a);
            }
        }

        C0746h() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0737m0.this.mo10823c(xVar)) {
                C0717k0.m515a((Runnable) new C0747a(xVar));
            }
        }
    }

    /* renamed from: com.adcolony.sdk.m0$i */
    class C0748i implements C0816z {

        /* renamed from: com.adcolony.sdk.m0$i$a */
        class C0749a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0812x f977a;

            C0749a(C0812x xVar) {
                this.f977a = xVar;
            }

            public void run() {
                C0737m0.this.mo10819a(C0795s.m812h(this.f977a.mo10941b(), "custom_js"));
            }
        }

        C0748i() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0737m0.this.mo10823c(xVar)) {
                C0717k0.m515a((Runnable) new C0749a(xVar));
            }
        }
    }

    /* renamed from: com.adcolony.sdk.m0$j */
    class C0750j implements C0816z {

        /* renamed from: com.adcolony.sdk.m0$j$a */
        class C0751a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0812x f980a;

            C0751a(C0812x xVar) {
                this.f980a = xVar;
            }

            public void run() {
                C0737m0.this.m635b(C0795s.m807d(this.f980a.mo10941b(), "transparent"));
            }
        }

        C0750j() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0737m0.this.mo10823c(xVar)) {
                C0717k0.m515a((Runnable) new C0751a(xVar));
            }
        }
    }

    /* renamed from: com.adcolony.sdk.m0$k */
    class C0752k implements View.OnClickListener {
        C0752k() {
        }

        public void onClick(View view) {
            C0717k0.m513a(new Intent("android.intent.action.VIEW", Uri.parse(C0737m0.this.f945i)));
            C0557a.m88c().mo10660u().mo10692b(C0737m0.this.f941e);
        }
    }

    /* renamed from: com.adcolony.sdk.m0$l */
    private class C0753l extends WebViewClient {
        private C0753l() {
        }

        /* synthetic */ C0753l(C0737m0 m0Var, C0740c cVar) {
            this();
        }

        public void onLoadResource(WebView webView, String str) {
            if (str.equals(C0737m0.this.f937a)) {
                C0737m0.this.mo10819a("if (typeof(CN) != 'undefined' && CN.div) {\n  if (typeof(cn_dispatch_on_touch_begin) != 'undefined') CN.div.removeEventListener('mousedown',  cn_dispatch_on_touch_begin, true);\n  if (typeof(cn_dispatch_on_touch_end) != 'undefined')   CN.div.removeEventListener('mouseup',  cn_dispatch_on_touch_end, true);\n  if (typeof(cn_dispatch_on_touch_move) != 'undefined')  CN.div.removeEventListener('mousemove',  cn_dispatch_on_touch_move, true);\n}\n");
            }
        }

        public void onPageFinished(WebView webView, String str) {
            JSONObject b = C0795s.m798b();
            C0795s.m801b(b, "id", C0737m0.this.f947k);
            C0795s.m791a(b, "url", str);
            new C0797u.C0798a().mo10920a("onPageFinished called with URL = ").mo10920a(str).mo10922a(C0797u.f1089d);
            if (C0737m0.this.f933J == null) {
                new C0812x("WebView.on_load", C0737m0.this.f956t, b).mo10945d();
            } else {
                C0795s.m791a(b, "ad_session_id", C0737m0.this.f941e);
                C0795s.m801b(b, "container_id", C0737m0.this.f933J.mo10514c());
                new C0812x("WebView.on_load", C0737m0.this.f933J.mo10531k(), b).mo10945d();
            }
            if ((C0737m0.this.f960x || C0737m0.this.f961y) && !C0737m0.this.f924A) {
                int h = C0737m0.this.f957u > 0 ? C0737m0.this.f957u : C0737m0.this.f956t;
                if (C0737m0.this.f957u > 0) {
                    float n = C0557a.m88c().mo10647h().mo10737n();
                    C0795s.m801b(C0737m0.this.f931H, "app_orientation", C0717k0.m535g(C0717k0.m536g()));
                    C0795s.m801b(C0737m0.this.f931H, "x", C0717k0.m503a((View) C0737m0.this));
                    C0795s.m801b(C0737m0.this.f931H, "y", C0717k0.m520b((View) C0737m0.this));
                    C0795s.m801b(C0737m0.this.f931H, SettingsJsonConstants.ICON_WIDTH_KEY, (int) (((float) C0737m0.this.f952p) / n));
                    C0795s.m801b(C0737m0.this.f931H, SettingsJsonConstants.ICON_HEIGHT_KEY, (int) (((float) C0737m0.this.f954r) / n));
                    C0795s.m791a(C0737m0.this.f931H, "ad_session_id", C0737m0.this.f941e);
                }
                C0737m0 m0Var = C0737m0.this;
                m0Var.mo10819a("ADC3_init(" + h + "," + C0737m0.this.f931H.toString() + ");");
                boolean unused = C0737m0.this.f924A = true;
            }
            if (!C0737m0.this.f961y) {
                return;
            }
            if (C0737m0.this.f956t != 1 || C0737m0.this.f957u > 0) {
                JSONObject b2 = C0795s.m798b();
                C0795s.m802b(b2, FirebaseAnalytics.Param.SUCCESS, true);
                C0795s.m801b(b2, "id", C0737m0.this.f956t);
                C0737m0.this.f934K.mo10940a(b2).mo10945d();
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            boolean unused = C0737m0.this.f924A = false;
            new C0797u.C0798a().mo10920a("onPageStarted with URL = ").mo10920a(str).mo10922a(C0797u.f1091f);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (Build.VERSION.SDK_INT < 23) {
                C0737m0.this.m625a(i, str, str2);
            }
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            if (!renderProcessGoneDetail.didCrash()) {
                return true;
            }
            C0737m0.this.m629a(C0795s.m798b(), "An error occurred while rendering the ad. Ad closing.");
            return true;
        }

        @TargetApi(11)
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (Build.VERSION.SDK_INT < 21 && str.endsWith("mraid.js")) {
                try {
                    return new WebResourceResponse("text/javascript", HttpRequest.CHARSET_UTF8, new ByteArrayInputStream(C0737m0.this.f942f.getBytes(HttpRequest.CHARSET_UTF8)));
                } catch (UnsupportedEncodingException unused) {
                    new C0797u.C0798a().mo10920a("UTF-8 not supported.").mo10922a(C0797u.f1095j);
                }
            }
            return null;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!C0737m0.this.f924A) {
                return false;
            }
            C0717k0.m513a(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            C0674i0 u = C0557a.m88c().mo10660u();
            u.mo10690a(C0737m0.this.f941e);
            u.mo10692b(C0737m0.this.f941e);
            JSONObject b = C0795s.m798b();
            C0795s.m791a(b, "url", str);
            C0795s.m791a(b, "ad_session_id", C0737m0.this.f941e);
            new C0812x("WebView.redirect_detected", C0737m0.this.f933J.mo10531k(), b).mo10945d();
            return true;
        }
    }

    private C0737m0(Context context) {
        super(context);
    }

    C0737m0(Context context, int i, boolean z) {
        super(context);
        this.f956t = i;
        this.f962z = z;
    }

    C0737m0(Context context, C0812x xVar, int i, int i2, C0563c cVar) {
        super(context);
        this.f934K = xVar;
        mo10817a(xVar, i, i2, cVar);
        mo10836p();
    }

    /* renamed from: a */
    private String m623a(String str, String str2) {
        C0580d b = C0557a.m88c().mo10633b();
        AdColonyInterstitial adColonyInterstitial = b.mo10556a().get(this.f941e);
        AdColonyAdViewListener adColonyAdViewListener = b.mo10564c().get(this.f941e);
        if (adColonyInterstitial != null && this.f932I.length() > 0 && !C0795s.m812h(this.f932I, "ad_type").equals("video")) {
            adColonyInterstitial.mo10416a(this.f932I);
        } else if (adColonyAdViewListener != null && this.f932I.length() > 0) {
            adColonyAdViewListener.mo10357a(new C0576c0(this.f932I, this.f941e));
        }
        C0576c0 e = adColonyInterstitial == null ? null : adColonyInterstitial.mo10427e();
        if (e == null && adColonyAdViewListener != null) {
            e = adColonyAdViewListener.mo10359b();
        }
        if (e != null && e.mo10552d() == 2) {
            this.f927D = true;
            if (!str2.equals("")) {
                try {
                    return ScriptInjector.injectScriptContentIntoHtml(C0557a.m88c().mo10650k().mo10885a(str2, false).toString(), str);
                } catch (IOException e2) {
                    m631a((Exception) e2);
                }
            }
        }
        return str;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m625a(int i, String str, String str2) {
        if (this.f933J != null) {
            JSONObject b = C0795s.m798b();
            C0795s.m801b(b, "id", this.f947k);
            C0795s.m791a(b, "ad_session_id", this.f941e);
            C0795s.m801b(b, "container_id", this.f933J.mo10514c());
            C0795s.m801b(b, "code", i);
            C0795s.m791a(b, MediaRouteProviderProtocol.SERVICE_DATA_ERROR, str);
            C0795s.m791a(b, "url", str2);
            new C0812x("WebView.on_error", this.f933J.mo10531k(), b).mo10945d();
        }
        new C0797u.C0798a().mo10920a("onReceivedError: ").mo10920a(str).mo10922a(C0797u.f1095j);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m629a(JSONObject jSONObject, String str) {
        Context b = C0557a.m86b();
        if (b != null && (b instanceof C0560b)) {
            C0812x xVar = new C0812x("AdSession.finish_fullscreen_ad", 0);
            C0795s.m801b(jSONObject, "status", 1);
            new C0797u.C0798a().mo10920a(str).mo10922a(C0797u.f1094i);
            ((C0560b) b).mo10438a(xVar);
        } else if (this.f956t == 1) {
            new C0797u.C0798a().mo10920a("Unable to communicate with controller, disabling AdColony.").mo10922a(C0797u.f1094i);
            AdColony.disable();
        } else if (this.f957u > 0) {
            this.f960x = false;
        }
    }

    /* renamed from: a */
    private boolean m631a(Exception exc) {
        AdColonyInterstitialListener listener;
        new C0797u.C0798a().mo10920a(exc.getClass().toString()).mo10920a(" during metadata injection w/ metadata = ").mo10920a(C0795s.m812h(this.f931H, "metadata")).mo10922a(C0797u.f1095j);
        AdColonyInterstitial remove = C0557a.m88c().mo10633b().mo10556a().remove(C0795s.m812h(this.f931H, "ad_session_id"));
        if (remove == null || (listener = remove.getListener()) == null) {
            return false;
        }
        listener.onExpiring(remove);
        remove.mo10417a(true);
        return true;
    }

    /* renamed from: b */
    private void m633b(Exception exc) {
        new C0797u.C0798a().mo10920a(exc.getClass().toString()).mo10920a(" during metadata injection w/ metadata = ").mo10920a(C0795s.m812h(this.f931H, "metadata")).mo10922a(C0797u.f1095j);
        JSONObject b = C0795s.m798b();
        C0795s.m791a(b, "id", this.f941e);
        new C0812x("AdSession.on_error", this.f933J.mo10531k(), b).mo10945d();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m634b(String str) {
        JSONArray a = C0795s.m779a(str);
        for (int i = 0; i < a.length(); i++) {
            C0557a.m88c().mo10652m().mo10951a(C0795s.m805c(a, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m635b(boolean z) {
        setBackgroundColor(z ? 0 : -1);
    }

    /* renamed from: w */
    private void m653w() {
        Context b = C0557a.m86b();
        if (b != null && this.f933J != null && !this.f928E) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            gradientDrawable.setShape(1);
            ImageView imageView = new ImageView(b);
            this.f935L = imageView;
            imageView.setImageURI(Uri.fromFile(new File(this.f944h)));
            this.f935L.setBackground(gradientDrawable);
            this.f935L.setOnClickListener(new C0752k());
            mo10841u();
            addView(this.f935L);
        }
    }

    /* renamed from: a */
    public void mo10490a() {
        if (C0557a.m89d() && this.f924A && !this.f926C) {
            mo10842v();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10816a(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        this.f948l = C0795s.m810f(b, "x");
        this.f950n = C0795s.m810f(b, "y");
        this.f952p = C0795s.m810f(b, SettingsJsonConstants.ICON_WIDTH_KEY);
        this.f954r = C0795s.m810f(b, SettingsJsonConstants.ICON_HEIGHT_KEY);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.f948l, this.f950n, 0, 0);
        layoutParams.width = this.f952p;
        layoutParams.height = this.f954r;
        setLayoutParams(layoutParams);
        if (this.f961y) {
            JSONObject b2 = C0795s.m798b();
            C0795s.m802b(b2, FirebaseAnalytics.Param.SUCCESS, true);
            C0795s.m801b(b2, "id", this.f956t);
            xVar.mo10940a(b2).mo10945d();
        }
        mo10841u();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10817a(C0812x xVar, int i, int i2, C0563c cVar) {
        JSONObject b = xVar.mo10941b();
        String h = C0795s.m812h(b, "url");
        this.f937a = h;
        if (h.equals("")) {
            this.f937a = C0795s.m812h(b, DataBufferSafeParcelable.DATA_FIELD);
        }
        this.f940d = C0795s.m812h(b, "base_url");
        this.f939c = C0795s.m812h(b, "custom_js");
        this.f941e = C0795s.m812h(b, "ad_session_id");
        this.f931H = C0795s.m811g(b, "info");
        this.f943g = C0795s.m812h(b, "mraid_filepath");
        this.f957u = C0795s.m807d(b, "use_mraid_module") ? C0557a.m88c().mo10652m().mo10955d() : this.f957u;
        this.f944h = C0795s.m812h(b, "ad_choices_filepath");
        this.f945i = C0795s.m812h(b, "ad_choices_url");
        this.f928E = C0795s.m807d(b, "disable_ad_choices");
        this.f929F = C0795s.m807d(b, "ad_choices_snap_to_webview");
        this.f958v = C0795s.m810f(b, "ad_choices_width");
        this.f959w = C0795s.m810f(b, "ad_choices_height");
        if (this.f932I.length() == 0) {
            this.f932I = C0795s.m811g(b, "iab");
        }
        boolean z = false;
        if (!this.f962z && !this.f943g.equals("")) {
            if (this.f957u > 0) {
                this.f937a = m623a(this.f937a.replaceFirst("script\\s*src\\s*=\\s*\"mraid.js\"", "script src=\"file://" + this.f943g + "\""), C0795s.m812h(C0795s.m811g(this.f931H, "device_info"), "iab_filepath"));
            } else {
                try {
                    this.f942f = C0557a.m88c().mo10650k().mo10885a(this.f943g, false).toString();
                    this.f942f = this.f942f.replaceFirst("bridge.os_name\\s*=\\s*\"\"\\s*;", "bridge.os_name = \"\";\nvar ADC_DEVICE_INFO = " + this.f931H.toString() + ";\n");
                } catch (IOException e) {
                    m633b((Exception) e);
                } catch (IllegalArgumentException e2) {
                    m633b((Exception) e2);
                } catch (IndexOutOfBoundsException e3) {
                    m633b((Exception) e3);
                }
            }
        }
        this.f947k = i;
        this.f933J = cVar;
        if (i2 >= 0) {
            this.f956t = i2;
        } else {
            mo10825f();
        }
        this.f952p = C0795s.m810f(b, SettingsJsonConstants.ICON_WIDTH_KEY);
        this.f954r = C0795s.m810f(b, SettingsJsonConstants.ICON_HEIGHT_KEY);
        this.f948l = C0795s.m810f(b, "x");
        int f = C0795s.m810f(b, "y");
        this.f950n = f;
        this.f953q = this.f952p;
        this.f955s = this.f954r;
        this.f951o = f;
        this.f949m = this.f948l;
        if (C0795s.m807d(b, "enable_messages") || this.f961y) {
            z = true;
        }
        this.f960x = z;
        mo10826g();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10818a(C0812x xVar, int i, C0563c cVar) {
        mo10817a(xVar, i, -1, cVar);
        mo10837q();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10819a(String str) {
        if (this.f925B) {
            new C0797u.C0798a().mo10920a("Ignoring call to execute_js as WebView has been destroyed.").mo10922a(C0797u.f1089d);
        } else if (Build.VERSION.SDK_INT >= 19) {
            evaluateJavascript(str, (ValueCallback) null);
        } else {
            loadUrl("javascript:" + str);
        }
    }

    /* renamed from: a */
    public void mo10491a(JSONObject jSONObject) {
        synchronized (this.f936M) {
            this.f930G.put(jSONObject);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10820a(boolean z) {
        this.f925B = z;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"AddJavascriptInterface"})
    /* renamed from: a */
    public void mo10821a(boolean z, C0812x xVar) {
        String str;
        String str2;
        if (this.f934K == null) {
            this.f934K = xVar;
        }
        JSONObject b = this.f934K.mo10941b();
        this.f961y = z;
        this.f962z = C0795s.m807d(b, "is_display_module");
        if (z) {
            String h = C0795s.m812h(b, "filepath");
            this.f946j = C0795s.m812h(b, "interstitial_html");
            this.f943g = C0795s.m812h(b, "mraid_filepath");
            this.f940d = C0795s.m812h(b, "base_url");
            this.f938b = h;
            this.f932I = C0795s.m811g(b, "iab");
            if (f923N && this.f956t == 1) {
                this.f938b = "android_asset/ADCController.js";
            }
            if (this.f946j.equals("")) {
                str2 = "file:///" + this.f938b;
            } else {
                str2 = "";
            }
            this.f937a = str2;
            this.f931H = C0795s.m811g(b, "info");
            this.f941e = C0795s.m812h(b, "ad_session_id");
            this.f960x = true;
        }
        setFocusable(true);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        setWebChromeClient(new C0740c(b));
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setGeolocationEnabled(true);
        settings.setUseWideViewPort(true);
        if (Build.VERSION.SDK_INT >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(true);
            settings.setAllowUniversalAccessFromFileURLs(true);
            settings.setAllowFileAccess(true);
        }
        int i = Build.VERSION.SDK_INT;
        WebViewClient dVar = i >= 23 ? new C0741d() : i >= 21 ? new C0742e() : new C0753l(this, (C0740c) null);
        addJavascriptInterface(new C0743f(), "NativeLayer");
        setWebViewClient(dVar);
        if (this.f962z) {
            try {
                if (this.f946j.equals("")) {
                    FileInputStream fileInputStream = new FileInputStream(this.f938b);
                    StringBuilder sb = new StringBuilder(fileInputStream.available());
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read < 0) {
                            break;
                        }
                        sb.append(new String(bArr, 0, read));
                    }
                    if (this.f938b.contains(".html")) {
                        str = sb.toString();
                    } else {
                        str = "<html><script>" + sb.toString() + "</script></html>";
                    }
                } else {
                    str = this.f946j.replaceFirst("script\\s*src\\s*=\\s*\"mraid.js\"", "script src=\"file://" + this.f943g + "\"");
                }
                String h2 = C0795s.m812h(C0795s.m811g(b, "info"), "metadata");
                loadDataWithBaseURL(this.f937a.equals("") ? this.f940d : this.f937a, m623a(str, C0795s.m812h(C0795s.m799b(h2), "iab_filepath")).replaceFirst("var\\s*ADC_DEVICE_INFO\\s*=\\s*null\\s*;", Matcher.quoteReplacement("var ADC_DEVICE_INFO = " + h2 + ";")), NanoHTTPD.MIME_HTML, (String) null, (String) null);
            } catch (IOException e) {
                m631a((Exception) e);
                return;
            } catch (IllegalArgumentException e2) {
                m631a((Exception) e2);
                return;
            } catch (IndexOutOfBoundsException e3) {
                m631a((Exception) e3);
                return;
            }
        } else if (!this.f937a.startsWith("http") && !this.f937a.startsWith("file")) {
            loadDataWithBaseURL(this.f940d, this.f937a, NanoHTTPD.MIME_HTML, (String) null, (String) null);
        } else if (this.f937a.contains(".html") || !this.f937a.startsWith("file")) {
            loadUrl(this.f937a);
        } else {
            loadDataWithBaseURL(this.f937a, "<html><script src=\"" + this.f937a + "\"></script></html>", NanoHTTPD.MIME_HTML, (String) null, (String) null);
        }
        if (!z) {
            mo10825f();
            mo10837q();
        }
        if (z || this.f960x) {
            C0557a.m88c().mo10652m().mo10947a((C0559a0) this);
        }
        if (!this.f939c.equals("")) {
            mo10819a(this.f939c);
        }
    }

    /* renamed from: b */
    public void mo10492b() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10822b(C0812x xVar) {
        if (C0795s.m807d(xVar.mo10941b(), "visible")) {
            setVisibility(0);
        } else {
            setVisibility(4);
        }
        if (this.f961y) {
            JSONObject b = C0795s.m798b();
            C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, true);
            C0795s.m801b(b, "id", this.f956t);
            xVar.mo10940a(b).mo10945d();
        }
    }

    /* renamed from: c */
    public int mo10493c() {
        return this.f957u;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo10823c(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        return C0795s.m810f(b, "id") == this.f947k && C0795s.m810f(b, "container_id") == this.f933J.mo10514c() && C0795s.m812h(b, "ad_session_id").equals(this.f933J.mo10504a());
    }

    /* renamed from: d */
    public int mo10494d() {
        return this.f956t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo10824e() {
        ImageView imageView = this.f935L;
        if (imageView != null) {
            this.f933J.mo10506a((View) imageView);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo10825f() {
        this.f933J.mo10527i().add(C0557a.m80a("WebView.set_visible", (C0816z) new C0744g(), true));
        this.f933J.mo10527i().add(C0557a.m80a("WebView.set_bounds", (C0816z) new C0746h(), true));
        this.f933J.mo10527i().add(C0557a.m80a("WebView.execute_js", (C0816z) new C0748i(), true));
        this.f933J.mo10527i().add(C0557a.m80a("WebView.set_transparent", (C0816z) new C0750j(), true));
        this.f933J.mo10529j().add("WebView.set_visible");
        this.f933J.mo10529j().add("WebView.set_bounds");
        this.f933J.mo10529j().add("WebView.execute_js");
        this.f933J.mo10529j().add("WebView.set_transparent");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo10826g() {
        C0717k0.m515a((Runnable) new C0739b());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public int mo10827h() {
        return this.f954r;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo10828i() {
        return this.f952p;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public int mo10829j() {
        return this.f948l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public int mo10830k() {
        return this.f950n;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public int mo10831l() {
        return this.f955s;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public int mo10832m() {
        return this.f953q;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public int mo10833n() {
        return this.f949m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public int mo10834o() {
        return this.f951o;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            AdColonyAdView adColonyAdView = this.f941e == null ? null : C0557a.m88c().mo10633b().mo10562b().get(this.f941e);
            if (adColonyAdView != null && !adColonyAdView.getUserInteraction()) {
                JSONObject b = C0795s.m798b();
                C0795s.m791a(b, "ad_session_id", this.f941e);
                new C0812x("WebView.on_first_click", 1, b).mo10945d();
                adColonyAdView.setUserInteraction(true);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo10836p() {
        mo10821a(false, (C0812x) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public void mo10837q() {
        setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f952p, this.f954r);
        layoutParams.setMargins(this.f948l, this.f950n, 0, 0);
        layoutParams.gravity = 0;
        this.f933J.addView(this, layoutParams);
        if (!this.f944h.equals("") && !this.f945i.equals("")) {
            m653w();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public boolean mo10838r() {
        return this.f925B;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public boolean mo10839s() {
        return this.f962z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public boolean mo10840t() {
        return this.f927D;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public void mo10841u() {
        if (this.f935L != null) {
            int s = C0557a.m88c().mo10647h().mo10742s();
            int r = C0557a.m88c().mo10647h().mo10741r();
            if (this.f929F) {
                s = this.f948l + this.f952p;
            }
            if (this.f929F) {
                r = this.f950n + this.f954r;
            }
            float n = C0557a.m88c().mo10647h().mo10737n();
            int i = (int) (((float) this.f958v) * n);
            int i2 = (int) (((float) this.f959w) * n);
            this.f935L.setLayoutParams(new AbsoluteLayout.LayoutParams(i, i2, s - i, r - i2));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public void mo10842v() {
        C0717k0.m515a((Runnable) new C0738a());
    }
}
