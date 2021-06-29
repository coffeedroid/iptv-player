package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.support.p000v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.adcolony.sdk.C0797u;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.settings.SettingsJsonConstants;

@TargetApi(14)
/* renamed from: com.adcolony.sdk.l0 */
class C0722l0 extends TextureView implements MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnSeekCompleteListener, TextureView.SurfaceTextureListener {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f860A;

    /* renamed from: B */
    private boolean f861B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f862C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public boolean f863D;

    /* renamed from: E */
    private boolean f864E;

    /* renamed from: F */
    private String f865F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public String f866G;

    /* renamed from: H */
    private FileInputStream f867H;

    /* renamed from: I */
    private C0812x f868I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public C0563c f869J;

    /* renamed from: K */
    private Surface f870K;

    /* renamed from: L */
    private SurfaceTexture f871L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public RectF f872M = new RectF();
    /* access modifiers changed from: private */

    /* renamed from: N */
    public C0732j f873N;

    /* renamed from: O */
    private ProgressBar f874O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public MediaPlayer f875P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public JSONObject f876Q = C0795s.m798b();

    /* renamed from: R */
    private ExecutorService f877R = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */

    /* renamed from: S */
    public C0812x f878S;

    /* renamed from: a */
    private float f879a;

    /* renamed from: b */
    private float f880b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public float f881c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public float f882d;

    /* renamed from: e */
    private float f883e;

    /* renamed from: f */
    private float f884f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f885g;

    /* renamed from: h */
    private boolean f886h = true;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Paint f887i = new Paint();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Paint f888j = new Paint(1);

    /* renamed from: k */
    private int f889k;

    /* renamed from: l */
    private int f890l;

    /* renamed from: m */
    private int f891m;

    /* renamed from: n */
    private int f892n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f893o;

    /* renamed from: p */
    private int f894p;

    /* renamed from: q */
    private int f895q;

    /* renamed from: r */
    private int f896r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public double f897s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public double f898t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public long f899u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f900v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f901w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f902x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f903y;

    /* renamed from: z */
    private boolean f904z;

    /* renamed from: com.adcolony.sdk.l0$a */
    class C0723a implements C0816z {
        C0723a() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0722l0.this.m558a(xVar)) {
                C0722l0.this.mo10794h();
            }
        }
    }

    /* renamed from: com.adcolony.sdk.l0$b */
    class C0724b implements C0816z {
        C0724b() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0722l0.this.m558a(xVar)) {
                C0722l0.this.m566c(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.l0$c */
    class C0725c implements C0816z {
        C0725c() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0722l0.this.m558a(xVar)) {
                C0722l0.this.m568d(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.l0$d */
    class C0726d implements C0816z {
        C0726d() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0722l0.this.m558a(xVar)) {
                C0722l0.this.mo10793g();
            }
        }
    }

    /* renamed from: com.adcolony.sdk.l0$e */
    class C0727e implements C0816z {
        C0727e() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0722l0.this.m558a(xVar)) {
                boolean unused = C0722l0.this.m563b(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.l0$f */
    class C0728f implements C0816z {
        C0728f() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (C0722l0.this.m558a(xVar)) {
                boolean unused = C0722l0.this.m573e(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.l0$g */
    class C0729g implements Runnable {
        C0729g() {
        }

        public void run() {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (C0722l0.this.f878S != null) {
                JSONObject b = C0795s.m798b();
                C0795s.m801b(b, "id", C0722l0.this.f893o);
                C0795s.m791a(b, "ad_session_id", C0722l0.this.f866G);
                C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, true);
                C0722l0.this.f878S.mo10940a(b).mo10945d();
                C0812x unused = C0722l0.this.f878S = null;
            }
        }
    }

    /* renamed from: com.adcolony.sdk.l0$h */
    class C0730h implements Runnable {
        C0730h() {
        }

        public void run() {
            long unused = C0722l0.this.f899u = 0;
            while (!C0722l0.this.f900v && !C0722l0.this.f903y && C0557a.m89d()) {
                Context b = C0557a.m86b();
                if (!C0722l0.this.f900v && !C0722l0.this.f860A && b != null && (b instanceof Activity)) {
                    if (C0722l0.this.f875P.isPlaying()) {
                        if (C0722l0.this.f899u == 0 && C0557a.f212d) {
                            long unused2 = C0722l0.this.f899u = System.currentTimeMillis();
                        }
                        boolean unused3 = C0722l0.this.f902x = true;
                        C0722l0 l0Var = C0722l0.this;
                        double currentPosition = (double) l0Var.f875P.getCurrentPosition();
                        Double.isNaN(currentPosition);
                        double unused4 = l0Var.f897s = currentPosition / 1000.0d;
                        C0722l0 l0Var2 = C0722l0.this;
                        double duration = (double) l0Var2.f875P.getDuration();
                        Double.isNaN(duration);
                        double unused5 = l0Var2.f898t = duration / 1000.0d;
                        if (System.currentTimeMillis() - C0722l0.this.f899u > 1000 && !C0722l0.this.f863D && C0557a.f212d) {
                            if (C0722l0.this.f897s == 0.0d) {
                                new C0797u.C0798a().mo10920a("getCurrentPosition() not working, firing ").mo10920a("AdSession.on_error").mo10922a(C0797u.f1095j);
                                C0722l0.this.m581k();
                            } else {
                                boolean unused6 = C0722l0.this.f863D = true;
                            }
                        }
                        if (C0722l0.this.f862C) {
                            C0722l0.this.mo10791e();
                        }
                    }
                    if (C0722l0.this.f902x && !C0722l0.this.f900v && !C0722l0.this.f903y) {
                        C0795s.m801b(C0722l0.this.f876Q, "id", C0722l0.this.f893o);
                        C0795s.m801b(C0722l0.this.f876Q, "container_id", C0722l0.this.f869J.mo10514c());
                        C0795s.m791a(C0722l0.this.f876Q, "ad_session_id", C0722l0.this.f866G);
                        C0795s.m789a(C0722l0.this.f876Q, "elapsed", C0722l0.this.f897s);
                        C0795s.m789a(C0722l0.this.f876Q, FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, C0722l0.this.f898t);
                        new C0812x("VideoView.on_progress", C0722l0.this.f869J.mo10531k(), C0722l0.this.f876Q).mo10945d();
                    }
                    if (C0722l0.this.f901w || ((Activity) b).isFinishing()) {
                        boolean unused7 = C0722l0.this.f901w = false;
                        C0722l0.this.mo10795i();
                        return;
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException unused8) {
                        C0722l0.this.m581k();
                        new C0797u.C0798a().mo10920a("InterruptedException in ADCVideoView's update thread.").mo10922a(C0797u.f1094i);
                    }
                } else {
                    return;
                }
            }
            if (C0722l0.this.f901w) {
                C0722l0.this.mo10795i();
            }
        }
    }

    /* renamed from: com.adcolony.sdk.l0$i */
    class C0731i implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f913a;

        C0731i(Context context) {
            this.f913a = context;
        }

        public void run() {
            C0732j unused = C0722l0.this.f873N = new C0732j(this.f913a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (C0722l0.this.f881c * 4.0f), (int) (C0722l0.this.f881c * 4.0f));
            layoutParams.setMargins(0, C0722l0.this.f869J.mo10510b() - ((int) (C0722l0.this.f881c * 4.0f)), 0, 0);
            layoutParams.gravity = 0;
            C0722l0.this.f869J.addView(C0722l0.this.f873N, layoutParams);
        }
    }

    /* renamed from: com.adcolony.sdk.l0$j */
    private class C0732j extends View {
        C0732j(Context context) {
            super(context);
            setWillNotDraw(false);
            try {
                Class<?> cls = getClass();
                cls.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this, new Object[]{1, null});
            } catch (Exception unused) {
            }
        }

        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawArc(C0722l0.this.f872M, 270.0f, C0722l0.this.f882d, false, C0722l0.this.f887i);
            float centerX = C0722l0.this.f872M.centerX();
            double centerY = (double) C0722l0.this.f872M.centerY();
            double d = (double) C0722l0.this.f888j.getFontMetrics().bottom;
            Double.isNaN(d);
            Double.isNaN(centerY);
            canvas.drawText("" + C0722l0.this.f885g, centerX, (float) (centerY + (d * 1.35d)), C0722l0.this.f888j);
            invalidate();
        }
    }

    private C0722l0(Context context) {
        super(context);
    }

    C0722l0(Context context, C0812x xVar, int i, C0563c cVar) {
        super(context);
        this.f869J = cVar;
        this.f868I = xVar;
        this.f893o = i;
        setSurfaceTextureListener(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m558a(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        return C0795s.m810f(b, "id") == this.f893o && C0795s.m810f(b, "container_id") == this.f869J.mo10514c() && C0795s.m812h(b, "ad_session_id").equals(this.f869J.mo10504a());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m563b(C0812x xVar) {
        if (!this.f904z) {
            return false;
        }
        if (this.f900v) {
            this.f900v = false;
        }
        this.f878S = xVar;
        int f = C0795s.m810f(xVar.mo10941b(), "time");
        int duration = this.f875P.getDuration() / 1000;
        this.f875P.setOnSeekCompleteListener(this);
        this.f875P.seekTo(f * 1000);
        if (duration == f) {
            this.f900v = true;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m566c(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        this.f889k = C0795s.m810f(b, "x");
        this.f890l = C0795s.m810f(b, "y");
        this.f891m = C0795s.m810f(b, SettingsJsonConstants.ICON_WIDTH_KEY);
        this.f892n = C0795s.m810f(b, SettingsJsonConstants.ICON_HEIGHT_KEY);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.f889k, this.f890l, 0, 0);
        layoutParams.width = this.f891m;
        layoutParams.height = this.f892n;
        setLayoutParams(layoutParams);
        if (this.f862C && this.f873N != null) {
            int i = (int) (this.f881c * 4.0f);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
            layoutParams2.setMargins(0, this.f869J.mo10510b() - ((int) (this.f881c * 4.0f)), 0, 0);
            layoutParams2.gravity = 0;
            this.f873N.setLayoutParams(layoutParams2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m568d(C0812x xVar) {
        C0732j jVar;
        C0732j jVar2;
        if (C0795s.m807d(xVar.mo10941b(), "visible")) {
            setVisibility(0);
            if (this.f862C && (jVar2 = this.f873N) != null) {
                jVar2.setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(4);
        if (this.f862C && (jVar = this.f873N) != null) {
            jVar.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m573e(C0812x xVar) {
        boolean z = false;
        if (!this.f904z) {
            return false;
        }
        float e = (float) C0795s.m808e(xVar.mo10941b(), MediaRouteProviderProtocol.CLIENT_DATA_VOLUME);
        AdColonyInterstitial d = C0557a.m88c().mo10640d();
        if (d != null) {
            if (((double) e) <= 0.0d) {
                z = true;
            }
            d.mo10422b(z);
        }
        this.f875P.setVolume(e, e);
        JSONObject b = C0795s.m798b();
        C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, true);
        xVar.mo10940a(b).mo10945d();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m581k() {
        JSONObject b = C0795s.m798b();
        C0795s.m791a(b, "id", this.f866G);
        new C0812x("AdSession.on_error", this.f869J.mo10531k(), b).mo10945d();
        this.f900v = true;
    }

    /* renamed from: l */
    private void m582l() {
        double d = (double) this.f891m;
        double d2 = (double) this.f894p;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = d / d2;
        double d4 = (double) this.f892n;
        double d5 = (double) this.f895q;
        Double.isNaN(d4);
        Double.isNaN(d5);
        double d6 = d4 / d5;
        if (d3 > d6) {
            d3 = d6;
        }
        double d7 = (double) this.f894p;
        Double.isNaN(d7);
        int i = (int) (d7 * d3);
        double d8 = (double) this.f895q;
        Double.isNaN(d8);
        int i2 = (int) (d8 * d3);
        new C0797u.C0798a().mo10920a("setMeasuredDimension to ").mo10918a(i).mo10920a(" by ").mo10918a(i2).mo10922a(C0797u.f1091f);
        setMeasuredDimension(i, i2);
        if (this.f861B) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            layoutParams.gravity = 17;
            layoutParams.setMargins(0, 0, 0, 0);
            setLayoutParams(layoutParams);
        }
    }

    /* renamed from: m */
    private void m585m() {
        try {
            this.f877R.submit(new C0730h());
        } catch (RejectedExecutionException unused) {
            m581k();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10787a() {
        if (this.f871L != null) {
            this.f860A = true;
        }
        this.f877R.shutdown();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public MediaPlayer mo10788b() {
        return this.f875P;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo10789c() {
        return this.f875P != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo10790d() {
        Context b;
        JSONObject b2 = this.f868I.mo10941b();
        this.f866G = C0795s.m812h(b2, "ad_session_id");
        this.f889k = C0795s.m810f(b2, "x");
        this.f890l = C0795s.m810f(b2, "y");
        this.f891m = C0795s.m810f(b2, SettingsJsonConstants.ICON_WIDTH_KEY);
        this.f892n = C0795s.m810f(b2, SettingsJsonConstants.ICON_HEIGHT_KEY);
        this.f862C = C0795s.m807d(b2, "enable_timer");
        this.f864E = C0795s.m807d(b2, "enable_progress");
        this.f865F = C0795s.m812h(b2, "filepath");
        this.f894p = C0795s.m810f(b2, "video_width");
        this.f895q = C0795s.m810f(b2, "video_height");
        this.f884f = C0557a.m88c().mo10647h().mo10737n();
        new C0797u.C0798a().mo10920a("Original video dimensions = ").mo10918a(this.f894p).mo10920a("x").mo10918a(this.f895q).mo10922a(C0797u.f1089d);
        setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f891m, this.f892n);
        layoutParams.setMargins(this.f889k, this.f890l, 0, 0);
        layoutParams.gravity = 0;
        this.f869J.addView(this, layoutParams);
        if (this.f864E && (b = C0557a.m86b()) != null) {
            ProgressBar progressBar = new ProgressBar(b);
            this.f874O = progressBar;
            C0563c cVar = this.f869J;
            int i = (int) (this.f884f * 100.0f);
            cVar.addView(progressBar, new FrameLayout.LayoutParams(i, i, 17));
        }
        this.f875P = new MediaPlayer();
        this.f904z = false;
        try {
            if (!this.f865F.startsWith("http")) {
                FileInputStream fileInputStream = new FileInputStream(this.f865F);
                this.f867H = fileInputStream;
                this.f875P.setDataSource(fileInputStream.getFD());
            } else {
                this.f861B = true;
                this.f875P.setDataSource(this.f865F);
            }
            this.f875P.setOnErrorListener(this);
            this.f875P.setOnPreparedListener(this);
            this.f875P.setOnCompletionListener(this);
            this.f875P.prepareAsync();
        } catch (IOException e) {
            new C0797u.C0798a().mo10920a("Failed to create/prepare MediaPlayer: ").mo10920a(e.toString()).mo10922a(C0797u.f1094i);
            m581k();
        }
        this.f869J.mo10527i().add(C0557a.m80a("VideoView.play", (C0816z) new C0723a(), true));
        this.f869J.mo10527i().add(C0557a.m80a("VideoView.set_bounds", (C0816z) new C0724b(), true));
        this.f869J.mo10527i().add(C0557a.m80a("VideoView.set_visible", (C0816z) new C0725c(), true));
        this.f869J.mo10527i().add(C0557a.m80a("VideoView.pause", (C0816z) new C0726d(), true));
        this.f869J.mo10527i().add(C0557a.m80a("VideoView.seek_to_time", (C0816z) new C0727e(), true));
        this.f869J.mo10527i().add(C0557a.m80a("VideoView.set_volume", (C0816z) new C0728f(), true));
        this.f869J.mo10529j().add("VideoView.play");
        this.f869J.mo10529j().add("VideoView.set_bounds");
        this.f869J.mo10529j().add("VideoView.set_visible");
        this.f869J.mo10529j().add("VideoView.pause");
        this.f869J.mo10529j().add("VideoView.seek_to_time");
        this.f869J.mo10529j().add("VideoView.set_volume");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo10791e() {
        if (this.f886h) {
            this.f883e = (float) (360.0d / this.f898t);
            this.f888j.setColor(-3355444);
            this.f888j.setShadowLayer((float) ((int) (this.f884f * 2.0f)), 0.0f, 0.0f, -16777216);
            this.f888j.setTextAlign(Paint.Align.CENTER);
            this.f888j.setLinearText(true);
            this.f888j.setTextSize(this.f884f * 12.0f);
            this.f887i.setStyle(Paint.Style.STROKE);
            float f = this.f884f * 2.0f;
            if (f > 6.0f) {
                f = 6.0f;
            }
            if (f < 4.0f) {
                f = 4.0f;
            }
            this.f887i.setStrokeWidth(f);
            this.f887i.setShadowLayer((float) ((int) (this.f884f * 3.0f)), 0.0f, 0.0f, -16777216);
            this.f887i.setColor(-3355444);
            Rect rect = new Rect();
            this.f888j.getTextBounds("0123456789", 0, 9, rect);
            this.f881c = (float) rect.height();
            Context b = C0557a.m86b();
            if (b != null) {
                C0717k0.m515a((Runnable) new C0731i(b));
            }
            this.f886h = false;
        }
        this.f885g = (int) (this.f898t - this.f897s);
        float f2 = this.f881c;
        float f3 = (float) ((int) f2);
        this.f879a = f3;
        float f4 = (float) ((int) (3.0f * f2));
        this.f880b = f4;
        float f5 = f2 / 2.0f;
        float f6 = f2 * 2.0f;
        this.f872M.set(f3 - f5, f4 - f6, f3 + f6, f4 + f5);
        double d = (double) this.f883e;
        Double.isNaN(d);
        this.f882d = (float) (d * (this.f898t - this.f897s));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo10792f() {
        return this.f900v;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo10793g() {
        if (!this.f904z) {
            new C0797u.C0798a().mo10920a("ADCVideoView pause() called while MediaPlayer is not prepared.").mo10922a(C0797u.f1093h);
            return false;
        } else if (!this.f902x) {
            new C0797u.C0798a().mo10920a("Ignoring ADCVideoView pause due to invalid MediaPlayer state.").mo10922a(C0797u.f1091f);
            return false;
        } else {
            this.f896r = this.f875P.getCurrentPosition();
            this.f898t = (double) this.f875P.getDuration();
            this.f875P.pause();
            this.f903y = true;
            new C0797u.C0798a().mo10920a("Video view paused").mo10922a(C0797u.f1089d);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo10794h() {
        if (!this.f904z) {
            return false;
        }
        if (!this.f903y && C0557a.f212d) {
            this.f875P.start();
            m585m();
            new C0797u.C0798a().mo10920a("MediaPlayer is prepared - ADCVideoView play() called.").mo10922a(C0797u.f1089d);
        } else if (!this.f900v && C0557a.f212d) {
            this.f875P.start();
            this.f903y = false;
            if (!this.f877R.isShutdown()) {
                m585m();
            }
            C0732j jVar = this.f873N;
            if (jVar != null) {
                jVar.invalidate();
            }
        }
        setWillNotDraw(false);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo10795i() {
        new C0797u.C0798a().mo10920a("MediaPlayer stopped and released.").mo10922a(C0797u.f1091f);
        try {
            if (!this.f900v && this.f904z && this.f875P.isPlaying()) {
                this.f875P.stop();
            }
        } catch (IllegalStateException unused) {
            new C0797u.C0798a().mo10920a("Caught IllegalStateException when calling stop on MediaPlayer").mo10922a(C0797u.f1093h);
        }
        ProgressBar progressBar = this.f874O;
        if (progressBar != null) {
            this.f869J.removeView(progressBar);
        }
        this.f900v = true;
        this.f904z = false;
        this.f875P.release();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo10796j() {
        this.f901w = true;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f900v = true;
        this.f897s = this.f898t;
        C0795s.m801b(this.f876Q, "id", this.f893o);
        C0795s.m801b(this.f876Q, "container_id", this.f869J.mo10514c());
        C0795s.m791a(this.f876Q, "ad_session_id", this.f866G);
        C0795s.m789a(this.f876Q, "elapsed", this.f897s);
        C0795s.m789a(this.f876Q, FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, this.f898t);
        new C0812x("VideoView.on_progress", this.f869J.mo10531k(), this.f876Q).mo10945d();
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        m581k();
        C0797u.C0798a aVar = new C0797u.C0798a();
        aVar.mo10920a("MediaPlayer error: " + i + "," + i2).mo10922a(C0797u.f1094i);
        return true;
    }

    public void onMeasure(int i, int i2) {
        m582l();
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f904z = true;
        if (this.f864E) {
            this.f869J.removeView(this.f874O);
        }
        if (this.f861B) {
            this.f894p = mediaPlayer.getVideoWidth();
            this.f895q = mediaPlayer.getVideoHeight();
            m582l();
            new C0797u.C0798a().mo10920a("MediaPlayer getVideoWidth = ").mo10918a(mediaPlayer.getVideoWidth()).mo10922a(C0797u.f1091f);
            new C0797u.C0798a().mo10920a("MediaPlayer getVideoHeight = ").mo10918a(mediaPlayer.getVideoHeight()).mo10922a(C0797u.f1091f);
        }
        JSONObject b = C0795s.m798b();
        C0795s.m801b(b, "id", this.f893o);
        C0795s.m801b(b, "container_id", this.f869J.mo10514c());
        C0795s.m791a(b, "ad_session_id", this.f866G);
        new C0797u.C0798a().mo10920a("ADCVideoView is prepared").mo10922a(C0797u.f1089d);
        new C0812x("VideoView.on_ready", this.f869J.mo10531k(), b).mo10945d();
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
        ExecutorService executorService = this.f877R;
        if (executorService != null && !executorService.isShutdown()) {
            try {
                this.f877R.submit(new C0729g());
            } catch (RejectedExecutionException unused) {
                m581k();
            }
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (surfaceTexture == null || this.f860A) {
            new C0797u.C0798a().mo10920a("Null texture provided by system's onSurfaceTextureAvailable or ").mo10920a("MediaPlayer has been destroyed.").mo10922a(C0797u.f1095j);
            return;
        }
        Surface surface = new Surface(surfaceTexture);
        this.f870K = surface;
        try {
            this.f875P.setSurface(surface);
        } catch (IllegalStateException unused) {
            new C0797u.C0798a().mo10920a("IllegalStateException thrown when calling MediaPlayer.setSurface()").mo10922a(C0797u.f1094i);
            m581k();
        }
        this.f871L = surfaceTexture;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f871L = surfaceTexture;
        if (!this.f860A) {
            return false;
        }
        surfaceTexture.release();
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f871L = surfaceTexture;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f871L = surfaceTexture;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        C0648h c = C0557a.m88c();
        C0580d b = c.mo10633b();
        int action = motionEvent.getAction() & 255;
        if (action != 0 && action != 1 && action != 3 && action != 2 && action != 5 && action != 6) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        JSONObject b2 = C0795s.m798b();
        C0795s.m801b(b2, "view_id", this.f893o);
        C0795s.m791a(b2, "ad_session_id", this.f866G);
        C0795s.m801b(b2, "container_x", this.f889k + x);
        C0795s.m801b(b2, "container_y", this.f890l + y);
        C0795s.m801b(b2, "view_x", x);
        C0795s.m801b(b2, "view_y", y);
        C0795s.m801b(b2, "id", this.f869J.mo10514c());
        switch (action) {
            case 0:
                new C0812x("AdContainer.on_touch_began", this.f869J.mo10531k(), b2).mo10945d();
                break;
            case 1:
                if (!this.f869J.mo10538p()) {
                    c.mo10621a(b.mo10562b().get(this.f866G));
                }
                new C0812x("AdContainer.on_touch_ended", this.f869J.mo10531k(), b2).mo10945d();
                break;
            case 2:
                new C0812x("AdContainer.on_touch_moved", this.f869J.mo10531k(), b2).mo10945d();
                break;
            case 3:
                new C0812x("AdContainer.on_touch_cancelled", this.f869J.mo10531k(), b2).mo10945d();
                break;
            case 5:
                int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                C0795s.m801b(b2, "container_x", ((int) motionEvent.getX(action2)) + this.f889k);
                C0795s.m801b(b2, "container_y", ((int) motionEvent.getY(action2)) + this.f890l);
                C0795s.m801b(b2, "view_x", (int) motionEvent.getX(action2));
                C0795s.m801b(b2, "view_y", (int) motionEvent.getY(action2));
                new C0812x("AdContainer.on_touch_began", this.f869J.mo10531k(), b2).mo10945d();
                break;
            case 6:
                int action3 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                C0795s.m801b(b2, "container_x", ((int) motionEvent.getX(action3)) + this.f889k);
                C0795s.m801b(b2, "container_y", ((int) motionEvent.getY(action3)) + this.f890l);
                C0795s.m801b(b2, "view_x", (int) motionEvent.getX(action3));
                C0795s.m801b(b2, "view_y", (int) motionEvent.getY(action3));
                if (!this.f869J.mo10538p()) {
                    c.mo10621a(b.mo10562b().get(this.f866G));
                }
                new C0812x("AdContainer.on_touch_ended", this.f869J.mo10531k(), b2).mo10945d();
                break;
        }
        return true;
    }
}
