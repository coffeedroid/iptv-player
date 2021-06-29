package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import com.adcolony.sdk.C0797u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"UseSparseArrays"})
/* renamed from: com.adcolony.sdk.y */
class C0813y {

    /* renamed from: a */
    private ArrayList<C0559a0> f1127a = new ArrayList<>();

    /* renamed from: b */
    private HashMap<Integer, C0559a0> f1128b = new HashMap<>();

    /* renamed from: c */
    private int f1129c = 2;

    /* renamed from: d */
    private HashMap<String, ArrayList<C0816z>> f1130d = new HashMap<>();

    /* renamed from: e */
    private JSONArray f1131e = C0795s.m778a();

    /* renamed from: f */
    private int f1132f = 1;

    /* renamed from: com.adcolony.sdk.y$a */
    class C0814a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f1133a;

        C0814a(Context context) {
            this.f1133a = context;
        }

        public void run() {
            AdColonyAppOptions q = C0557a.m88c().mo10656q();
            q.mo10373e();
            JSONObject b = q.mo10370b();
            JSONObject b2 = C0795s.m798b();
            C0795s.m791a(b, "os_name", "android");
            C0795s.m791a(b2, "filepath", C0557a.m88c().mo10659t().mo10610a() + "7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5");
            C0795s.m793a(b2, "info", b);
            C0795s.m801b(b2, "m_origin", 0);
            C0795s.m801b(b2, "m_id", C0813y.m871a(C0813y.this));
            C0795s.m791a(b2, "m_type", "Controller.create");
            try {
                new C0737m0(this.f1133a, 1, false).mo10821a(true, new C0812x(b2));
            } catch (RuntimeException e) {
                C0797u.C0798a aVar = new C0797u.C0798a();
                aVar.mo10920a(e.toString() + ": during WebView initialization.").mo10920a(" Disabling AdColony.").mo10922a(C0797u.f1094i);
                AdColony.disable();
            }
        }
    }

    /* renamed from: com.adcolony.sdk.y$b */
    class C0815b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f1135a;

        /* renamed from: b */
        final /* synthetic */ JSONObject f1136b;

        C0815b(String str, JSONObject jSONObject) {
            this.f1135a = str;
            this.f1136b = jSONObject;
        }

        public void run() {
            C0813y.this.mo10950a(this.f1135a, this.f1136b);
        }
    }

    C0813y() {
    }

    /* renamed from: a */
    static /* synthetic */ int m871a(C0813y yVar) {
        int i = yVar.f1132f;
        yVar.f1132f = i + 1;
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0559a0 mo10946a(int i) {
        synchronized (this.f1127a) {
            C0559a0 a0Var = this.f1128b.get(Integer.valueOf(i));
            if (a0Var == null) {
                return null;
            }
            this.f1127a.remove(a0Var);
            this.f1128b.remove(Integer.valueOf(i));
            a0Var.mo10492b();
            return a0Var;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0559a0 mo10947a(C0559a0 a0Var) {
        synchronized (this.f1127a) {
            int c = a0Var.mo10493c();
            if (c <= 0) {
                c = a0Var.mo10494d();
            }
            this.f1127a.add(a0Var);
            this.f1128b.put(Integer.valueOf(c), a0Var);
        }
        return a0Var;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10948a() {
        Context b;
        C0648h c = C0557a.m88c();
        if (!c.mo10664y() && !c.mo10665z() && (b = C0557a.m86b()) != null) {
            C0717k0.m515a((Runnable) new C0814a(b));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10949a(String str, C0816z zVar) {
        ArrayList arrayList = this.f1130d.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f1130d.put(str, arrayList);
        }
        arrayList.add(zVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10950a(String str, JSONObject jSONObject) {
        synchronized (this.f1130d) {
            ArrayList arrayList = this.f1130d.get(str);
            if (arrayList != null) {
                C0812x xVar = new C0812x(jSONObject);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        ((C0816z) it.next()).mo10499a(xVar);
                    } catch (RuntimeException e) {
                        new C0797u.C0798a().mo10919a((Object) e).mo10922a(C0797u.f1095j);
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10951a(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("m_id")) {
                int i = this.f1132f;
                this.f1132f = i + 1;
                jSONObject.put("m_id", i);
            }
            if (!jSONObject.has("m_origin")) {
                jSONObject.put("m_origin", 0);
            }
            int i2 = jSONObject.getInt("m_target");
            if (i2 == 0) {
                synchronized (this) {
                    this.f1131e.put(jSONObject);
                }
                return;
            }
            C0559a0 a0Var = this.f1128b.get(Integer.valueOf(i2));
            if (a0Var != null) {
                a0Var.mo10491a(jSONObject);
            }
        } catch (JSONException e) {
            new C0797u.C0798a().mo10920a("JSON error in ADCMessageDispatcher's sendMessage(): ").mo10920a(e.toString()).mo10922a(C0797u.f1095j);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ArrayList<C0559a0> mo10952b() {
        return this.f1127a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10953b(String str, C0816z zVar) {
        synchronized (this.f1130d) {
            ArrayList arrayList = this.f1130d.get(str);
            if (arrayList != null) {
                arrayList.remove(zVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public HashMap<Integer, C0559a0> mo10954c() {
        return this.f1128b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo10955d() {
        int i = this.f1129c;
        this.f1129c = i + 1;
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public synchronized void mo10956e() {
        synchronized (this.f1127a) {
            for (int size = this.f1127a.size() - 1; size >= 0; size--) {
                this.f1127a.get(size).mo10490a();
            }
        }
        JSONArray jSONArray = null;
        if (this.f1131e.length() > 0) {
            jSONArray = this.f1131e;
            this.f1131e = C0795s.m778a();
        }
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("m_type");
                    if (jSONObject.getInt("m_origin") >= 2) {
                        C0717k0.m515a((Runnable) new C0815b(string, jSONObject));
                    } else {
                        mo10950a(string, jSONObject);
                    }
                } catch (JSONException e) {
                    new C0797u.C0798a().mo10920a("JSON error from message dispatcher's updateModules(): ").mo10920a(e.toString()).mo10922a(C0797u.f1095j);
                }
            }
        }
    }
}
