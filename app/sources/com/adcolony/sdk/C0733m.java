package com.adcolony.sdk;

import com.adcolony.sdk.C0720l;
import com.adcolony.sdk.C0797u;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.m */
class C0733m implements C0720l.C0721a {

    /* renamed from: a */
    private BlockingQueue<Runnable> f916a = new LinkedBlockingQueue();

    /* renamed from: b */
    private ThreadPoolExecutor f917b = new ThreadPoolExecutor(4, 16, 60, TimeUnit.SECONDS, this.f916a);

    /* renamed from: c */
    private LinkedList<C0720l> f918c = new LinkedList<>();

    /* renamed from: d */
    private String f919d = C0557a.m88c().mo10647h().mo10715I();

    /* renamed from: com.adcolony.sdk.m$a */
    class C0734a implements C0816z {
        C0734a() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0733m mVar = C0733m.this;
            mVar.mo10813a(new C0720l(xVar, mVar));
        }
    }

    /* renamed from: com.adcolony.sdk.m$b */
    class C0735b implements C0816z {
        C0735b() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0733m mVar = C0733m.this;
            mVar.mo10813a(new C0720l(xVar, mVar));
        }
    }

    /* renamed from: com.adcolony.sdk.m$c */
    class C0736c implements C0816z {
        C0736c() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0733m mVar = C0733m.this;
            mVar.mo10813a(new C0720l(xVar, mVar));
        }
    }

    C0733m() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo10811a() {
        return this.f917b.getCorePoolSize();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10812a(int i) {
        this.f917b.setCorePoolSize(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10813a(C0720l lVar) {
        String str = this.f919d;
        if (str == null || str.equals("")) {
            this.f918c.push(lVar);
            return;
        }
        try {
            this.f917b.execute(lVar);
        } catch (RejectedExecutionException unused) {
            C0797u.C0798a a = new C0797u.C0798a().mo10920a("RejectedExecutionException: ThreadPoolExecutor unable to ");
            a.mo10920a("execute download for url " + lVar.f855m).mo10922a(C0797u.f1095j);
            mo10627a(lVar, lVar.mo10785a(), (Map<String, List<String>>) null);
        }
    }

    /* renamed from: a */
    public void mo10627a(C0720l lVar, C0812x xVar, Map<String, List<String>> map) {
        JSONObject b = C0795s.m798b();
        C0795s.m791a(b, "url", lVar.f855m);
        C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, lVar.f857o);
        C0795s.m801b(b, "status", lVar.f859q);
        C0795s.m791a(b, "body", lVar.f856n);
        C0795s.m801b(b, "size", lVar.f858p);
        if (map != null) {
            JSONObject b2 = C0795s.m798b();
            for (Map.Entry next : map.entrySet()) {
                String obj = ((List) next.getValue()).toString();
                String substring = obj.substring(1, obj.length() - 1);
                if (next.getKey() != null) {
                    C0795s.m791a(b2, (String) next.getKey(), substring);
                }
            }
            C0795s.m793a(b, "headers", b2);
        }
        xVar.mo10940a(b).mo10945d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10814a(String str) {
        this.f919d = str;
        while (!this.f918c.isEmpty()) {
            mo10813a(this.f918c.removeLast());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10815b() {
        C0557a.m84a("WebServices.download", (C0816z) new C0734a());
        C0557a.m84a("WebServices.get", (C0816z) new C0735b());
        C0557a.m84a("WebServices.post", (C0816z) new C0736c());
    }
}
