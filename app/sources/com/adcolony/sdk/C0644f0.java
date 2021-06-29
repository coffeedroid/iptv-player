package com.adcolony.sdk;

import android.content.Context;
import com.adcolony.sdk.C0717k0;
import com.adcolony.sdk.C0797u;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.f0 */
class C0644f0 implements Runnable {

    /* renamed from: a */
    private final long f630a = NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS;

    /* renamed from: b */
    private final int f631b = 17;

    /* renamed from: c */
    private final int f632c = 15000;

    /* renamed from: d */
    private final int f633d = 1000;

    /* renamed from: e */
    private long f634e;

    /* renamed from: f */
    private long f635f;

    /* renamed from: g */
    private long f636g;

    /* renamed from: h */
    private long f637h;

    /* renamed from: i */
    private long f638i;

    /* renamed from: j */
    private long f639j;

    /* renamed from: k */
    private long f640k;

    /* renamed from: l */
    private long f641l;

    /* renamed from: m */
    private boolean f642m = true;

    /* renamed from: n */
    private boolean f643n = true;

    /* renamed from: o */
    private boolean f644o;

    /* renamed from: p */
    private boolean f645p;

    /* renamed from: q */
    private boolean f646q;

    /* renamed from: r */
    private boolean f647r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f648s;

    /* renamed from: t */
    private boolean f649t;

    /* renamed from: com.adcolony.sdk.f0$a */
    class C0645a implements C0816z {
        C0645a() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            boolean unused = C0644f0.this.f648s = true;
        }
    }

    C0644f0() {
    }

    /* renamed from: a */
    private void m248a(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
    }

    /* renamed from: f */
    private void m250f() {
        mo10595a(false);
    }

    /* renamed from: g */
    private void m251g() {
        mo10596b(false);
    }

    /* renamed from: a */
    public void mo10594a() {
        C0557a.m84a("SessionInfo.stopped", (C0816z) new C0645a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10595a(boolean z) {
        ArrayList<C0559a0> b = C0557a.m88c().mo10652m().mo10952b();
        synchronized (b) {
            Iterator<C0559a0> it = b.iterator();
            while (it.hasNext()) {
                C0559a0 next = it.next();
                JSONObject b2 = C0795s.m798b();
                C0795s.m802b(b2, "from_window_focus", z);
                new C0812x("SessionInfo.on_pause", next.mo10494d(), b2).mo10945d();
            }
        }
        this.f643n = true;
        C0557a.m92g();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10596b(boolean z) {
        ArrayList<C0559a0> b = C0557a.m88c().mo10652m().mo10952b();
        synchronized (b) {
            Iterator<C0559a0> it = b.iterator();
            while (it.hasNext()) {
                C0559a0 next = it.next();
                JSONObject b2 = C0795s.m798b();
                C0795s.m802b(b2, "from_window_focus", z);
                new C0812x("SessionInfo.on_resume", next.mo10494d(), b2).mo10945d();
            }
        }
        C0801w.m849b();
        this.f643n = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo10597b() {
        return this.f642m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo10598c(boolean z) {
        if (!this.f645p) {
            if (this.f646q) {
                C0557a.m88c().mo10636b(false);
                this.f646q = false;
            }
            this.f634e = 0;
            this.f635f = 0;
            this.f645p = true;
            this.f642m = true;
            this.f648s = false;
            new Thread(this).start();
            if (z) {
                JSONObject b = C0795s.m798b();
                C0795s.m791a(b, "id", C0717k0.m507a());
                new C0812x("SessionInfo.on_start", 1, b).mo10945d();
                C0737m0 m0Var = (C0737m0) C0557a.m88c().mo10652m().mo10954c().get(1);
                if (m0Var != null) {
                    m0Var.mo10842v();
                }
            }
            if (AdColony.f100a.isShutdown()) {
                AdColony.f100a = Executors.newSingleThreadExecutor();
            }
            C0801w.m849b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo10599c() {
        return this.f644o;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo10600d(boolean z) {
        this.f642m = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo10601d() {
        return this.f645p;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo10602e() {
        this.f645p = false;
        this.f642m = false;
        C0640e0 e0Var = C0801w.f1120n;
        if (e0Var != null) {
            e0Var.mo10585b();
        }
        JSONObject b = C0795s.m798b();
        double d = (double) this.f634e;
        Double.isNaN(d);
        C0795s.m789a(b, "session_length", d / 1000.0d);
        new C0812x("SessionInfo.on_stop", 1, b).mo10945d();
        C0557a.m92g();
        AdColony.f100a.shutdown();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo10603e(boolean z) {
        this.f644o = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo10604f(boolean z) {
        this.f649t = z;
    }

    public void run() {
        while (!this.f647r) {
            this.f637h = System.currentTimeMillis();
            C0557a.m92g();
            if (this.f635f >= NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
                break;
            }
            if (!this.f642m) {
                if (this.f644o && !this.f643n) {
                    this.f644o = false;
                    m250f();
                }
                this.f635f += this.f641l == 0 ? 0 : System.currentTimeMillis() - this.f641l;
                this.f641l = System.currentTimeMillis();
            } else {
                if (this.f644o && this.f643n) {
                    this.f644o = false;
                    m251g();
                }
                this.f635f = 0;
                this.f641l = 0;
            }
            this.f636g = 17;
            m248a(17);
            long currentTimeMillis = System.currentTimeMillis() - this.f637h;
            this.f638i = currentTimeMillis;
            if (currentTimeMillis > 0 && currentTimeMillis < 6000) {
                this.f634e += currentTimeMillis;
            }
            C0648h c = C0557a.m88c();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (currentTimeMillis2 - this.f640k > 15000) {
                this.f640k = currentTimeMillis2;
            }
            if (C0557a.m89d() && currentTimeMillis2 - this.f639j > 1000) {
                this.f639j = currentTimeMillis2;
                String a = c.mo10653n().mo10500a();
                if (!a.equals(c.mo10654o())) {
                    c.mo10628a(a);
                    JSONObject b = C0795s.m798b();
                    C0795s.m791a(b, "network_type", c.mo10654o());
                    new C0812x("Network.on_status_change", 1, b).mo10945d();
                }
            }
        }
        new C0797u.C0798a().mo10920a("AdColony session ending, releasing Context.").mo10922a(C0797u.f1090e);
        C0557a.m88c().mo10636b(true);
        C0557a.m81a((Context) null);
        this.f646q = true;
        this.f649t = true;
        mo10602e();
        C0717k0.C0719b bVar = new C0717k0.C0719b(10.0d);
        while (!this.f648s && !bVar.mo10781a() && this.f649t) {
            C0557a.m92g();
            m248a(100);
        }
    }
}
