package com.adcolony.sdk;

import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.settings.SettingsJsonConstants;

/* renamed from: com.adcolony.sdk.w */
class C0801w {

    /* renamed from: a */
    static boolean f1107a = false;

    /* renamed from: b */
    static final int f1108b = 4000;

    /* renamed from: c */
    static final int f1109c = 4;

    /* renamed from: d */
    static final int f1110d = 3;

    /* renamed from: e */
    static final int f1111e = 2;

    /* renamed from: f */
    static final int f1112f = 1;

    /* renamed from: g */
    static final int f1113g = 0;

    /* renamed from: h */
    static final int f1114h = -1;

    /* renamed from: i */
    static int f1115i = 3;

    /* renamed from: j */
    static JSONObject f1116j = C0795s.m798b();

    /* renamed from: k */
    static int f1117k = 1;

    /* renamed from: l */
    private static ExecutorService f1118l = null;

    /* renamed from: m */
    private static final Queue<Runnable> f1119m = new ConcurrentLinkedQueue();

    /* renamed from: n */
    static C0640e0 f1120n;

    /* renamed from: com.adcolony.sdk.w$a */
    static class C0802a implements C0816z {
        C0802a() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0801w.m850b(C0795s.m810f(xVar.mo10941b(), "module"), 0, C0795s.m812h(xVar.mo10941b(), SettingsJsonConstants.PROMPT_MESSAGE_KEY), true);
        }
    }

    /* renamed from: com.adcolony.sdk.w$b */
    static class C0803b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f1121a;

        /* renamed from: b */
        final /* synthetic */ String f1122b;

        /* renamed from: c */
        final /* synthetic */ int f1123c;

        /* renamed from: d */
        final /* synthetic */ boolean f1124d;

        C0803b(int i, String str, int i2, boolean z) {
            this.f1121a = i;
            this.f1122b = str;
            this.f1123c = i2;
            this.f1124d = z;
        }

        public void run() {
            C0801w.m842a(this.f1121a, this.f1122b, this.f1123c);
            int i = 0;
            while (i <= this.f1122b.length() / C0801w.f1108b) {
                int i2 = i * C0801w.f1108b;
                i++;
                int i3 = i * C0801w.f1108b;
                if (i3 > this.f1122b.length()) {
                    i3 = this.f1122b.length();
                }
                if (this.f1123c == 3 && C0801w.m848a(C0795s.m811g(C0801w.f1116j, Integer.toString(this.f1121a)), 3, this.f1124d)) {
                    Log.d("AdColony [TRACE]", this.f1122b.substring(i2, i3));
                } else if (this.f1123c == 2 && C0801w.m848a(C0795s.m811g(C0801w.f1116j, Integer.toString(this.f1121a)), 2, this.f1124d)) {
                    Log.i("AdColony [INFO]", this.f1122b.substring(i2, i3));
                } else if (this.f1123c == 1 && C0801w.m848a(C0795s.m811g(C0801w.f1116j, Integer.toString(this.f1121a)), 1, this.f1124d)) {
                    Log.w("AdColony [WARNING]", this.f1122b.substring(i2, i3));
                } else if (this.f1123c == 0 && C0801w.m848a(C0795s.m811g(C0801w.f1116j, Integer.toString(this.f1121a)), 0, this.f1124d)) {
                    Log.e("AdColony [ERROR]", this.f1122b.substring(i2, i3));
                } else if (this.f1123c == -1 && C0801w.f1115i >= -1) {
                    Log.e("AdColony [FATAL]", this.f1122b.substring(i2, i3));
                }
            }
        }
    }

    /* renamed from: com.adcolony.sdk.w$c */
    static class C0804c implements C0816z {
        C0804c() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0801w.f1115i = C0795s.m810f(xVar.mo10941b(), FirebaseAnalytics.Param.LEVEL);
        }
    }

    /* renamed from: com.adcolony.sdk.w$d */
    static class C0805d implements C0816z {
        C0805d() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0801w.m850b(C0795s.m810f(xVar.mo10941b(), "module"), 3, C0795s.m812h(xVar.mo10941b(), SettingsJsonConstants.PROMPT_MESSAGE_KEY), false);
        }
    }

    /* renamed from: com.adcolony.sdk.w$e */
    static class C0806e implements C0816z {
        C0806e() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0801w.m850b(C0795s.m810f(xVar.mo10941b(), "module"), 3, C0795s.m812h(xVar.mo10941b(), SettingsJsonConstants.PROMPT_MESSAGE_KEY), true);
        }
    }

    /* renamed from: com.adcolony.sdk.w$f */
    static class C0807f implements C0816z {
        C0807f() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0801w.m850b(C0795s.m810f(xVar.mo10941b(), "module"), 2, C0795s.m812h(xVar.mo10941b(), SettingsJsonConstants.PROMPT_MESSAGE_KEY), false);
        }
    }

    /* renamed from: com.adcolony.sdk.w$g */
    static class C0808g implements C0816z {
        C0808g() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0801w.m850b(C0795s.m810f(xVar.mo10941b(), "module"), 2, C0795s.m812h(xVar.mo10941b(), SettingsJsonConstants.PROMPT_MESSAGE_KEY), true);
        }
    }

    /* renamed from: com.adcolony.sdk.w$h */
    static class C0809h implements C0816z {
        C0809h() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0801w.m850b(C0795s.m810f(xVar.mo10941b(), "module"), 1, C0795s.m812h(xVar.mo10941b(), SettingsJsonConstants.PROMPT_MESSAGE_KEY), false);
        }
    }

    /* renamed from: com.adcolony.sdk.w$i */
    static class C0810i implements C0816z {
        C0810i() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0801w.m850b(C0795s.m810f(xVar.mo10941b(), "module"), 1, C0795s.m812h(xVar.mo10941b(), SettingsJsonConstants.PROMPT_MESSAGE_KEY), true);
        }
    }

    /* renamed from: com.adcolony.sdk.w$j */
    static class C0811j implements C0816z {
        C0811j() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0801w.m850b(C0795s.m810f(xVar.mo10941b(), "module"), 0, C0795s.m812h(xVar.mo10941b(), SettingsJsonConstants.PROMPT_MESSAGE_KEY), false);
        }
    }

    C0801w() {
    }

    /* renamed from: a */
    private static Runnable m840a(int i, int i2, String str, boolean z) {
        return new C0803b(i, str, i2, z);
    }

    /* renamed from: a */
    static void m841a() {
        C0557a.m84a("Log.set_log_level", (C0816z) new C0804c());
        C0557a.m84a("Log.public.trace", (C0816z) new C0805d());
        C0557a.m84a("Log.private.trace", (C0816z) new C0806e());
        C0557a.m84a("Log.public.info", (C0816z) new C0807f());
        C0557a.m84a("Log.private.info", (C0816z) new C0808g());
        C0557a.m84a("Log.public.warning", (C0816z) new C0809h());
        C0557a.m84a("Log.private.warning", (C0816z) new C0810i());
        C0557a.m84a("Log.public.error", (C0816z) new C0811j());
        C0557a.m84a("Log.private.error", (C0816z) new C0802a());
    }

    /* renamed from: a */
    static void m842a(int i, String str, int i2) {
        if (f1120n != null) {
            if (i2 == 3 && m847a(C0795s.m811g(f1116j, Integer.toString(i)), 3)) {
                f1120n.mo10584a(str);
            } else if (i2 == 2 && m847a(C0795s.m811g(f1116j, Integer.toString(i)), 2)) {
                f1120n.mo10588c(str);
            } else if (i2 == 1 && m847a(C0795s.m811g(f1116j, Integer.toString(i)), 1)) {
                f1120n.mo10589d(str);
            } else if (i2 == 0 && m847a(C0795s.m811g(f1116j, Integer.toString(i)), 0)) {
                f1120n.mo10587b(str);
            }
        }
    }

    /* renamed from: a */
    static void m843a(int i, String str, boolean z) {
        m850b(0, i, str, z);
    }

    /* renamed from: a */
    static void m844a(C0766o oVar) {
        C0640e0 e0Var = f1120n;
        if (e0Var != null && f1117k != 4) {
            e0Var.mo10582a(oVar);
        }
    }

    /* renamed from: a */
    static void m845a(HashMap<String, Object> hashMap) {
        try {
            C0640e0 e0Var = new C0640e0(new C0796t(new URL("http://=")), Executors.newSingleThreadScheduledExecutor(), hashMap);
            f1120n = e0Var;
            e0Var.mo10581a(5, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static boolean m846a(Runnable runnable) {
        try {
            if (f1118l == null || f1118l.isShutdown() || f1118l.isTerminated()) {
                return false;
            }
            f1118l.submit(runnable);
            return true;
        } catch (RejectedExecutionException unused) {
            Log.e("ADCLogError", "Internal error when submitting log to executor service.");
            return false;
        }
    }

    /* renamed from: a */
    static boolean m847a(JSONObject jSONObject, int i) {
        int f = C0795s.m810f(jSONObject, "send_level");
        if (jSONObject.length() == 0) {
            f = f1117k;
        }
        return f >= i && f != 4;
    }

    /* renamed from: a */
    static boolean m848a(JSONObject jSONObject, int i, boolean z) {
        int f = C0795s.m810f(jSONObject, "print_level");
        boolean d = C0795s.m807d(jSONObject, "log_private");
        if (jSONObject.length() == 0) {
            f = f1115i;
            d = f1107a;
        }
        return (!z || d) && f != 4 && f >= i;
    }

    /* renamed from: b */
    static void m849b() {
        ExecutorService executorService = f1118l;
        if (executorService == null || executorService.isShutdown() || f1118l.isTerminated()) {
            f1118l = Executors.newSingleThreadExecutor();
        }
        synchronized (f1119m) {
            while (!f1119m.isEmpty()) {
                m846a(f1119m.poll());
            }
        }
    }

    /* renamed from: b */
    static void m850b(int i, int i2, String str, boolean z) {
        if (!m846a(m840a(i, i2, str, z))) {
            synchronized (f1119m) {
                f1119m.add(m840a(i, i2, str, z));
            }
        }
    }

    /* renamed from: c */
    static void m851c() {
        ExecutorService executorService = f1118l;
        if (executorService != null) {
            executorService.shutdown();
            try {
                if (!f1118l.awaitTermination(1, TimeUnit.SECONDS)) {
                    f1118l.shutdownNow();
                    if (!f1118l.awaitTermination(1, TimeUnit.SECONDS)) {
                        System.err.println("ADCLogManager: ScheduledExecutorService did not terminate");
                    }
                }
            } catch (InterruptedException unused) {
                f1118l.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo10935a(JSONArray jSONArray) {
        JSONObject b = C0795s.m798b();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject c = C0795s.m805c(jSONArray, i);
            C0795s.m793a(b, Integer.toString(C0795s.m810f(c, "id")), c);
        }
        return b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10936b(JSONArray jSONArray) {
        f1116j = mo10935a(jSONArray);
    }
}
