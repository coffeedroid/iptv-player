package com.adcolony.sdk;

import android.support.p000v4.p002os.EnvironmentCompat;
import android.util.Log;
import com.adcolony.sdk.C0799v;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.unity3d.ads.metadata.MediationMetaData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.settings.SettingsJsonConstants;

/* renamed from: com.adcolony.sdk.e0 */
class C0640e0 {

    /* renamed from: h */
    static final String f617h = "adcolony_android";

    /* renamed from: i */
    static final String f618i = "adcolony_fatal_reports";

    /* renamed from: a */
    C0796t f619a;

    /* renamed from: b */
    ScheduledExecutorService f620b;

    /* renamed from: c */
    List<C0799v> f621c = new ArrayList();

    /* renamed from: d */
    List<C0799v> f622d = new ArrayList();

    /* renamed from: e */
    HashMap<String, Object> f623e;

    /* renamed from: f */
    private C0794r f624f = new C0794r(f617h, "4.1.4", "Production");

    /* renamed from: g */
    private C0794r f625g = new C0794r(f618i, "4.1.4", "Production");

    /* renamed from: com.adcolony.sdk.e0$a */
    class C0641a implements Runnable {
        C0641a() {
        }

        public void run() {
            C0640e0.this.mo10580a();
        }
    }

    /* renamed from: com.adcolony.sdk.e0$b */
    class C0642b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0799v f627a;

        C0642b(C0799v vVar) {
            this.f627a = vVar;
        }

        public void run() {
            C0640e0.this.f621c.add(this.f627a);
        }
    }

    C0640e0(C0796t tVar, ScheduledExecutorService scheduledExecutorService, HashMap<String, Object> hashMap) {
        this.f619a = tVar;
        this.f620b = scheduledExecutorService;
        this.f623e = hashMap;
    }

    /* renamed from: c */
    private synchronized JSONObject m234c(C0799v vVar) throws JSONException {
        JSONObject jSONObject;
        jSONObject = new JSONObject(this.f623e);
        jSONObject.put("environment", vVar.mo10923a().mo10911a());
        jSONObject.put(FirebaseAnalytics.Param.LEVEL, vVar.mo10927c());
        jSONObject.put(SettingsJsonConstants.PROMPT_MESSAGE_KEY, vVar.mo10928d());
        jSONObject.put("clientTimestamp", vVar.mo10929e());
        JSONObject mediationInfo = C0557a.m88c().mo10656q().getMediationInfo();
        JSONObject pluginInfo = C0557a.m88c().mo10656q().getPluginInfo();
        double g = C0557a.m88c().mo10647h().mo10730g();
        jSONObject.put("mediation_network", C0795s.m812h(mediationInfo, MediationMetaData.KEY_NAME));
        jSONObject.put("mediation_network_version", C0795s.m812h(mediationInfo, "version"));
        jSONObject.put("plugin", C0795s.m812h(pluginInfo, MediationMetaData.KEY_NAME));
        jSONObject.put("plugin_version", C0795s.m812h(pluginInfo, "version"));
        jSONObject.put("batteryInfo", g);
        if (vVar instanceof C0766o) {
            jSONObject = C0795s.m784a(jSONObject, ((C0766o) vVar).mo10882f());
            jSONObject.put("platform", "android");
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo10579a(C0794r rVar, List<C0799v> list) throws IOException, JSONException {
        String b = C0557a.m88c().mo10647h().mo10723b();
        String str = this.f623e.get("advertiserId") != null ? (String) this.f623e.get("advertiserId") : EnvironmentCompat.MEDIA_UNKNOWN;
        if (b != null && b.length() > 0 && !b.equals(str)) {
            this.f623e.put("advertiserId", b);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(FirebaseAnalytics.Param.INDEX, rVar.mo10913c());
        jSONObject.put("environment", rVar.mo10911a());
        jSONObject.put("version", rVar.mo10914d());
        JSONArray jSONArray = new JSONArray();
        for (C0799v c : list) {
            jSONArray.put(m234c(c));
        }
        jSONObject.put("logs", jSONArray);
        return jSONObject.toString();
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* renamed from: a */
    synchronized void mo10580a() {
        /*
            r2 = this;
            monitor-enter(r2)
            monitor-enter(r2)     // Catch:{ all -> 0x0049 }
            java.util.List<com.adcolony.sdk.v> r0 = r2.f621c     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            int r0 = r0.size()     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            if (r0 <= 0) goto L_0x001c
            com.adcolony.sdk.r r0 = r2.f624f     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            java.util.List<com.adcolony.sdk.v> r1 = r2.f621c     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            java.lang.String r0 = r2.mo10579a((com.adcolony.sdk.C0794r) r0, (java.util.List<com.adcolony.sdk.C0799v>) r1)     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            com.adcolony.sdk.t r1 = r2.f619a     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            r1.mo10915a(r0)     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            java.util.List<com.adcolony.sdk.v> r0 = r2.f621c     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            r0.clear()     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
        L_0x001c:
            java.util.List<com.adcolony.sdk.v> r0 = r2.f622d     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            int r0 = r0.size()     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            if (r0 <= 0) goto L_0x0044
            com.adcolony.sdk.r r0 = r2.f625g     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            java.util.List<com.adcolony.sdk.v> r1 = r2.f622d     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            java.lang.String r0 = r2.mo10579a((com.adcolony.sdk.C0794r) r0, (java.util.List<com.adcolony.sdk.C0799v>) r1)     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            com.adcolony.sdk.t r1 = r2.f619a     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            r1.mo10915a(r0)     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            java.util.List<com.adcolony.sdk.v> r0 = r2.f622d     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            r0.clear()     // Catch:{ IOException -> 0x003f, JSONException -> 0x0039 }
            goto L_0x0044
        L_0x0037:
            r0 = move-exception
            goto L_0x0047
        L_0x0039:
            java.util.List<com.adcolony.sdk.v> r0 = r2.f621c     // Catch:{ all -> 0x0037 }
            r0.clear()     // Catch:{ all -> 0x0037 }
            goto L_0x0044
        L_0x003f:
            java.util.List<com.adcolony.sdk.v> r0 = r2.f621c     // Catch:{ all -> 0x0037 }
            r0.clear()     // Catch:{ all -> 0x0037 }
        L_0x0044:
            monitor-exit(r2)     // Catch:{ all -> 0x0037 }
            monitor-exit(r2)
            return
        L_0x0047:
            monitor-exit(r2)     // Catch:{ all -> 0x0037 }
            throw r0     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0640e0.mo10580a():void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo10581a(long j, TimeUnit timeUnit) {
        try {
            if (!this.f620b.isShutdown() && !this.f620b.isTerminated()) {
                this.f620b.scheduleAtFixedRate(new C0641a(), j, j, timeUnit);
            }
        } catch (RuntimeException unused) {
            Log.e("ADCLogError", "Internal error when submitting remote log to executor service");
        }
        return;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10582a(C0766o oVar) {
        oVar.mo10925a(this.f625g);
        oVar.mo10924a(-1);
        mo10583a((C0799v) oVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo10583a(C0799v vVar) {
        this.f622d.add(vVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo10584a(String str) {
        mo10586b(new C0799v.C0800a().mo10931a(3).mo10932a(this.f624f).mo10933a(str).mo10934a());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r4.f620b.shutdownNow();
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0045 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo10585b() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.concurrent.ScheduledExecutorService r0 = r4.f620b     // Catch:{ all -> 0x0053 }
            r0.shutdown()     // Catch:{ all -> 0x0053 }
            java.util.concurrent.ScheduledExecutorService r0 = r4.f620b     // Catch:{ InterruptedException -> 0x0045 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x0045 }
            r2 = 1
            boolean r0 = r0.awaitTermination(r2, r1)     // Catch:{ InterruptedException -> 0x0045 }
            if (r0 != 0) goto L_0x0051
            java.util.concurrent.ScheduledExecutorService r0 = r4.f620b     // Catch:{ InterruptedException -> 0x0045 }
            r0.shutdownNow()     // Catch:{ InterruptedException -> 0x0045 }
            java.util.concurrent.ScheduledExecutorService r0 = r4.f620b     // Catch:{ InterruptedException -> 0x0045 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x0045 }
            boolean r0 = r0.awaitTermination(r2, r1)     // Catch:{ InterruptedException -> 0x0045 }
            if (r0 != 0) goto L_0x0051
            java.io.PrintStream r0 = java.lang.System.err     // Catch:{ InterruptedException -> 0x0045 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0045 }
            r1.<init>()     // Catch:{ InterruptedException -> 0x0045 }
            java.lang.Class r2 = r4.getClass()     // Catch:{ InterruptedException -> 0x0045 }
            java.lang.String r2 = r2.getSimpleName()     // Catch:{ InterruptedException -> 0x0045 }
            r1.append(r2)     // Catch:{ InterruptedException -> 0x0045 }
            java.lang.String r2 = ": ScheduledExecutorService "
            r1.append(r2)     // Catch:{ InterruptedException -> 0x0045 }
            java.lang.String r2 = "did not terminate"
            r1.append(r2)     // Catch:{ InterruptedException -> 0x0045 }
            java.lang.String r1 = r1.toString()     // Catch:{ InterruptedException -> 0x0045 }
            r0.println(r1)     // Catch:{ InterruptedException -> 0x0045 }
            goto L_0x0051
        L_0x0045:
            java.util.concurrent.ScheduledExecutorService r0 = r4.f620b     // Catch:{ all -> 0x0053 }
            r0.shutdownNow()     // Catch:{ all -> 0x0053 }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0053 }
            r0.interrupt()     // Catch:{ all -> 0x0053 }
        L_0x0051:
            monitor-exit(r4)
            return
        L_0x0053:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0640e0.mo10585b():void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo10586b(C0799v vVar) {
        try {
            if (!this.f620b.isShutdown() && !this.f620b.isTerminated()) {
                this.f620b.submit(new C0642b(vVar));
            }
        } catch (RejectedExecutionException unused) {
            Log.e("ADCLogError", "Internal error when submitting remote log to executor service");
        }
        return;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo10587b(String str) {
        mo10586b(new C0799v.C0800a().mo10931a(0).mo10932a(this.f624f).mo10933a(str).mo10934a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized void mo10588c(String str) {
        mo10586b(new C0799v.C0800a().mo10931a(2).mo10932a(this.f624f).mo10933a(str).mo10934a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized void mo10589d(String str) {
        mo10586b(new C0799v.C0800a().mo10931a(1).mo10932a(this.f624f).mo10933a(str).mo10934a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public synchronized void mo10590e(String str) {
        this.f623e.put("controllerVersion", str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public synchronized void mo10591f(String str) {
        this.f623e.put("sessionId", str);
    }
}
