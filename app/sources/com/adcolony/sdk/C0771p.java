package com.adcolony.sdk;

import com.adcolony.sdk.C0797u;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.network.HttpRequest;

/* renamed from: com.adcolony.sdk.p */
class C0771p {

    /* renamed from: a */
    private LinkedList<Runnable> f1039a = new LinkedList<>();

    /* renamed from: b */
    private boolean f1040b;

    /* renamed from: com.adcolony.sdk.p$a */
    class C0772a implements C0816z {

        /* renamed from: com.adcolony.sdk.p$a$a */
        class C0773a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0812x f1042a;

            C0773a(C0812x xVar) {
                this.f1042a = xVar;
            }

            public void run() {
                C0771p.this.mo10898e(this.f1042a);
                C0771p.this.mo10886a();
            }
        }

        C0772a() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0771p.this.mo10887a((Runnable) new C0773a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.p$b */
    class C0774b implements C0816z {

        /* renamed from: com.adcolony.sdk.p$b$a */
        class C0775a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0812x f1045a;

            C0775a(C0812x xVar) {
                this.f1045a = xVar;
            }

            public void run() {
                C0771p.this.mo10890a(this.f1045a, new File(C0795s.m812h(this.f1045a.mo10941b(), "filepath")));
                C0771p.this.mo10886a();
            }
        }

        C0774b() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0771p.this.mo10887a((Runnable) new C0775a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.p$c */
    class C0776c implements C0816z {

        /* renamed from: com.adcolony.sdk.p$c$a */
        class C0777a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0812x f1048a;

            C0777a(C0812x xVar) {
                this.f1048a = xVar;
            }

            public void run() {
                C0771p.this.mo10895b(this.f1048a);
                C0771p.this.mo10886a();
            }
        }

        C0776c() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0771p.this.mo10887a((Runnable) new C0777a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.p$d */
    class C0778d implements C0816z {

        /* renamed from: com.adcolony.sdk.p$d$a */
        class C0779a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0812x f1051a;

            C0779a(C0812x xVar) {
                this.f1051a = xVar;
            }

            public void run() {
                C0771p.this.mo10896c(this.f1051a);
                C0771p.this.mo10886a();
            }
        }

        C0778d() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0771p.this.mo10887a((Runnable) new C0779a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.p$e */
    class C0780e implements C0816z {

        /* renamed from: com.adcolony.sdk.p$e$a */
        class C0781a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0812x f1054a;

            C0781a(C0812x xVar) {
                this.f1054a = xVar;
            }

            public void run() {
                C0771p.this.mo10897d(this.f1054a);
                C0771p.this.mo10886a();
            }
        }

        C0780e() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0771p.this.mo10887a((Runnable) new C0781a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.p$f */
    class C0782f implements C0816z {

        /* renamed from: com.adcolony.sdk.p$f$a */
        class C0783a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0812x f1057a;

            C0783a(C0812x xVar) {
                this.f1057a = xVar;
            }

            public void run() {
                C0771p.this.mo10889a(this.f1057a);
                C0771p.this.mo10886a();
            }
        }

        C0782f() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0771p.this.mo10887a((Runnable) new C0783a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.p$g */
    class C0784g implements C0816z {

        /* renamed from: com.adcolony.sdk.p$g$a */
        class C0785a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0812x f1060a;

            C0785a(C0812x xVar) {
                this.f1060a = xVar;
            }

            public void run() {
                boolean unused = C0771p.this.m735g(this.f1060a);
                C0771p.this.mo10886a();
            }
        }

        C0784g() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0771p.this.mo10887a((Runnable) new C0785a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.p$h */
    class C0786h implements C0816z {

        /* renamed from: com.adcolony.sdk.p$h$a */
        class C0787a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0812x f1063a;

            C0787a(C0812x xVar) {
                this.f1063a = xVar;
            }

            public void run() {
                boolean unused = C0771p.this.m736h(this.f1063a);
                C0771p.this.mo10886a();
            }
        }

        C0786h() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0771p.this.mo10887a((Runnable) new C0787a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.p$i */
    class C0788i implements C0816z {

        /* renamed from: com.adcolony.sdk.p$i$a */
        class C0789a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0812x f1066a;

            C0789a(C0812x xVar) {
                this.f1066a = xVar;
            }

            public void run() {
                boolean unused = C0771p.this.m734f(this.f1066a);
                C0771p.this.mo10886a();
            }
        }

        C0788i() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            C0771p.this.mo10887a((Runnable) new C0789a(xVar));
        }
    }

    C0771p() {
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean m734f(C0812x xVar) {
        String h = C0795s.m812h(xVar.mo10941b(), "filepath");
        C0557a.m88c().mo10659t().mo10616g();
        JSONObject b = C0795s.m798b();
        try {
            if (new File(h).mkdir()) {
                C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, true);
                xVar.mo10940a(b).mo10945d();
                return true;
            }
            C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, false);
            return false;
        } catch (Exception unused) {
            C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, false);
            xVar.mo10940a(b).mo10945d();
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean m735g(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        String h = C0795s.m812h(b, "filepath");
        C0557a.m88c().mo10659t().mo10616g();
        JSONObject b2 = C0795s.m798b();
        try {
            int f = C0795s.m810f(b, "offset");
            int f2 = C0795s.m810f(b, "size");
            boolean d = C0795s.m807d(b, "gunzip");
            String h2 = C0795s.m812h(b, "output_filepath");
            C0671h0 h0Var = new C0671h0(new FileInputStream(h), f, f2);
            InputStream gZIPInputStream = d ? new GZIPInputStream(h0Var, 1024) : h0Var;
            if (h2.equals("")) {
                StringBuilder sb = new StringBuilder(gZIPInputStream.available());
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = gZIPInputStream.read(bArr, 0, 1024);
                    if (read < 0) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read, "ISO-8859-1"));
                }
                C0795s.m801b(b2, "size", sb.length());
                C0795s.m791a(b2, DataBufferSafeParcelable.DATA_FIELD, sb.toString());
            } else {
                FileOutputStream fileOutputStream = new FileOutputStream(h2);
                byte[] bArr2 = new byte[1024];
                int i = 0;
                while (true) {
                    int read2 = gZIPInputStream.read(bArr2, 0, 1024);
                    if (read2 < 0) {
                        break;
                    }
                    fileOutputStream.write(bArr2, 0, read2);
                    i += read2;
                }
                fileOutputStream.close();
                C0795s.m801b(b2, "size", i);
            }
            gZIPInputStream.close();
            C0795s.m802b(b2, FirebaseAnalytics.Param.SUCCESS, true);
            xVar.mo10940a(b2).mo10945d();
            return true;
        } catch (IOException unused) {
            C0795s.m802b(b2, FirebaseAnalytics.Param.SUCCESS, false);
            xVar.mo10940a(b2).mo10945d();
            return false;
        } catch (OutOfMemoryError unused2) {
            new C0797u.C0798a().mo10920a("Out of memory error - disabling AdColony.").mo10922a(C0797u.f1094i);
            C0557a.m88c().mo10629a(true);
            C0795s.m802b(b2, FirebaseAnalytics.Param.SUCCESS, false);
            xVar.mo10940a(b2).mo10945d();
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00f4, code lost:
        new com.adcolony.sdk.C0797u.C0798a().mo10920a("Out of memory error - disabling AdColony.").mo10922a(com.adcolony.sdk.C0797u.f1094i);
        com.adcolony.sdk.C0557a.m88c().mo10629a(true);
        com.adcolony.sdk.C0795s.m802b(r4, com.google.firebase.analytics.FirebaseAnalytics.Param.SUCCESS, false);
        r0.mo10940a(r4).mo10945d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0119, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[ExcHandler: OutOfMemoryError (unused java.lang.OutOfMemoryError), SYNTHETIC, Splitter:B:1:0x0027] */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m736h(com.adcolony.sdk.C0812x r19) {
        /*
            r18 = this;
            r0 = r19
            org.json.JSONObject r1 = r19.mo10941b()
            java.lang.String r2 = "filepath"
            java.lang.String r2 = com.adcolony.sdk.C0795s.m812h(r1, r2)
            java.lang.String r3 = "bundle_path"
            java.lang.String r3 = com.adcolony.sdk.C0795s.m812h(r1, r3)
            java.lang.String r4 = "bundle_filenames"
            org.json.JSONArray r1 = com.adcolony.sdk.C0795s.m803c((org.json.JSONObject) r1, (java.lang.String) r4)
            com.adcolony.sdk.h r4 = com.adcolony.sdk.C0557a.m88c()
            com.adcolony.sdk.g0 r4 = r4.mo10659t()
            r4.mo10616g()
            org.json.JSONObject r4 = com.adcolony.sdk.C0795s.m798b()
            java.io.File r7 = new java.io.File     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            r7.<init>(r3)     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            java.io.RandomAccessFile r8 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            java.lang.String r9 = "r"
            r8.<init>(r7, r9)     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            r9 = 32
            byte[] r9 = new byte[r9]     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            r8.readInt()     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            int r10 = r8.readInt()     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            org.json.JSONArray r11 = new org.json.JSONArray     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            r11.<init>()     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            r12 = 1024(0x400, float:1.435E-42)
            byte[] r13 = new byte[r12]     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            r14 = 0
        L_0x0048:
            if (r14 >= r10) goto L_0x00da
            int r15 = r14 * 44
            int r15 = r15 + 8
            long r5 = (long) r15     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            r8.seek(r5)     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            r8.read(r9)     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            java.lang.String r5 = new java.lang.String     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            r5.<init>(r9)     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            r8.readInt()     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            int r5 = r8.readInt()     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            int r6 = r8.readInt()     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            r11.put(r6)     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00ae }
            r15.<init>()     // Catch:{ JSONException -> 0x00ae }
            r15.append(r2)     // Catch:{ JSONException -> 0x00ae }
            java.lang.Object r12 = r1.get(r14)     // Catch:{ JSONException -> 0x00ae }
            r15.append(r12)     // Catch:{ JSONException -> 0x00ae }
            java.lang.String r12 = r15.toString()     // Catch:{ JSONException -> 0x00ae }
            r17 = r1
            r16 = r2
            long r1 = (long) r5
            r8.seek(r1)     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            r1.<init>(r12)     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            int r2 = r6 / 1024
            int r6 = r6 % 1024
            r5 = 0
        L_0x008d:
            if (r5 >= r2) goto L_0x009b
            r12 = 1024(0x400, float:1.435E-42)
            r15 = 0
            r8.read(r13, r15, r12)     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            r1.write(r13, r15, r12)     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            int r5 = r5 + 1
            goto L_0x008d
        L_0x009b:
            r12 = 1024(0x400, float:1.435E-42)
            r15 = 0
            r8.read(r13, r15, r6)     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            r1.write(r13, r15, r6)     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            r1.close()     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            int r14 = r14 + 1
            r2 = r16
            r1 = r17
            goto L_0x0048
        L_0x00ae:
            com.adcolony.sdk.u$a r1 = new com.adcolony.sdk.u$a     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            r1.<init>()     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            java.lang.String r2 = "Could extract file name at index "
            com.adcolony.sdk.u$a r1 = r1.mo10920a((java.lang.String) r2)     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            com.adcolony.sdk.u$a r1 = r1.mo10918a((int) r14)     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            java.lang.String r2 = " unpacking ad unit bundle at "
            com.adcolony.sdk.u$a r1 = r1.mo10920a((java.lang.String) r2)     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            com.adcolony.sdk.u$a r1 = r1.mo10920a((java.lang.String) r3)     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            com.adcolony.sdk.u r2 = com.adcolony.sdk.C0797u.f1094i     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            r1.mo10922a((com.adcolony.sdk.C0797u) r2)     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            java.lang.String r1 = "success"
            r2 = 0
            com.adcolony.sdk.C0795s.m802b((org.json.JSONObject) r4, (java.lang.String) r1, (boolean) r2)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f4 }
            com.adcolony.sdk.x r1 = r0.mo10940a((org.json.JSONObject) r4)     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f4 }
            r1.mo10945d()     // Catch:{ IOException -> 0x011b, OutOfMemoryError -> 0x00f4 }
            return r2
        L_0x00da:
            r8.close()     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            r7.delete()     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            java.lang.String r1 = "success"
            r2 = 1
            com.adcolony.sdk.C0795s.m802b((org.json.JSONObject) r4, (java.lang.String) r1, (boolean) r2)     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            java.lang.String r1 = "file_sizes"
            com.adcolony.sdk.C0795s.m792a((org.json.JSONObject) r4, (java.lang.String) r1, (org.json.JSONArray) r11)     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            com.adcolony.sdk.x r1 = r0.mo10940a((org.json.JSONObject) r4)     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            r1.mo10945d()     // Catch:{ IOException -> 0x011a, OutOfMemoryError -> 0x00f4 }
            r1 = 1
            return r1
        L_0x00f4:
            com.adcolony.sdk.u$a r1 = new com.adcolony.sdk.u$a
            r1.<init>()
            java.lang.String r2 = "Out of memory error - disabling AdColony."
            com.adcolony.sdk.u$a r1 = r1.mo10920a((java.lang.String) r2)
            com.adcolony.sdk.u r2 = com.adcolony.sdk.C0797u.f1094i
            r1.mo10922a((com.adcolony.sdk.C0797u) r2)
            com.adcolony.sdk.h r1 = com.adcolony.sdk.C0557a.m88c()
            r2 = 1
            r1.mo10629a((boolean) r2)
            java.lang.String r1 = "success"
            r2 = 0
            com.adcolony.sdk.C0795s.m802b((org.json.JSONObject) r4, (java.lang.String) r1, (boolean) r2)
            com.adcolony.sdk.x r0 = r0.mo10940a((org.json.JSONObject) r4)
            r0.mo10945d()
            return r2
        L_0x011a:
            r2 = 0
        L_0x011b:
            com.adcolony.sdk.u$a r1 = new com.adcolony.sdk.u$a
            r1.<init>()
            java.lang.String r5 = "Failed to find or open ad unit bundle at path: "
            com.adcolony.sdk.u$a r1 = r1.mo10920a((java.lang.String) r5)
            com.adcolony.sdk.u$a r1 = r1.mo10920a((java.lang.String) r3)
            com.adcolony.sdk.u r3 = com.adcolony.sdk.C0797u.f1095j
            r1.mo10922a((com.adcolony.sdk.C0797u) r3)
            java.lang.String r1 = "success"
            com.adcolony.sdk.C0795s.m802b((org.json.JSONObject) r4, (java.lang.String) r1, (boolean) r2)
            com.adcolony.sdk.x r0 = r0.mo10940a((org.json.JSONObject) r4)
            r0.mo10945d()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0771p.m736h(com.adcolony.sdk.x):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public StringBuilder mo10885a(String str, boolean z) throws IOException {
        File file = new File(str);
        StringBuilder sb = new StringBuilder((int) file.length());
        BufferedReader bufferedReader = z ? new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()), HttpRequest.CHARSET_UTF8)) : new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath())));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
                sb.append("\n");
            } else {
                bufferedReader.close();
                return sb;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10886a() {
        this.f1040b = false;
        if (!this.f1039a.isEmpty()) {
            this.f1040b = true;
            this.f1039a.removeLast().run();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10887a(Runnable runnable) {
        if (!this.f1039a.isEmpty() || this.f1040b) {
            this.f1039a.push(runnable);
            return;
        }
        this.f1040b = true;
        runnable.run();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10888a(String str, String str2, boolean z) throws IOException {
        BufferedWriter bufferedWriter = z ? new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str), HttpRequest.CHARSET_UTF8)) : new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str)));
        bufferedWriter.write(str2);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo10889a(C0812x xVar) {
        String h = C0795s.m812h(xVar.mo10941b(), "filepath");
        C0557a.m88c().mo10659t().mo10616g();
        JSONObject b = C0795s.m798b();
        try {
            boolean a = mo10892a(h);
            C0795s.m802b(b, "result", a);
            C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, true);
            xVar.mo10940a(b).mo10945d();
            return a;
        } catch (Exception e) {
            C0795s.m802b(b, "result", false);
            C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, false);
            xVar.mo10940a(b).mo10945d();
            e.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo10890a(C0812x xVar, File file) {
        C0557a.m88c().mo10659t().mo10616g();
        JSONObject b = C0795s.m798b();
        if (mo10891a(file)) {
            C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, true);
            xVar.mo10940a(b).mo10945d();
            return true;
        }
        C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, false);
        xVar.mo10940a(b).mo10945d();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo10891a(File file) {
        try {
            if (!file.isDirectory()) {
                return file.delete();
            }
            if (file.list().length == 0) {
                return file.delete();
            }
            String[] list = file.list();
            if (list.length > 0) {
                return mo10891a(new File(file, list[0]));
            }
            if (file.list().length == 0) {
                return file.delete();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo10892a(String str) throws Exception {
        return new File(str).exists();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public List<String> mo10893b(String str, boolean z) throws IOException {
        File file = new File(str);
        file.length();
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = z ? new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()), HttpRequest.CHARSET_UTF8)) : new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath())));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                arrayList.add(readLine);
            } else {
                bufferedReader.close();
                return arrayList;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10894b() {
        C0557a.m84a("FileSystem.save", (C0816z) new C0772a());
        C0557a.m84a("FileSystem.delete", (C0816z) new C0774b());
        C0557a.m84a("FileSystem.listing", (C0816z) new C0776c());
        C0557a.m84a("FileSystem.load", (C0816z) new C0778d());
        C0557a.m84a("FileSystem.rename", (C0816z) new C0780e());
        C0557a.m84a("FileSystem.exists", (C0816z) new C0782f());
        C0557a.m84a("FileSystem.extract", (C0816z) new C0784g());
        C0557a.m84a("FileSystem.unpack_bundle", (C0816z) new C0786h());
        C0557a.m84a("FileSystem.create_directory", (C0816z) new C0788i());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo10895b(C0812x xVar) {
        String h = C0795s.m812h(xVar.mo10941b(), "filepath");
        C0557a.m88c().mo10659t().mo10616g();
        JSONObject b = C0795s.m798b();
        String[] list = new File(h).list();
        if (list != null) {
            JSONArray a = C0795s.m778a();
            for (String str : list) {
                JSONObject b2 = C0795s.m798b();
                C0795s.m791a(b2, FFmpegMediaMetadataRetriever.METADATA_KEY_FILENAME, str);
                if (new File(h + str).isDirectory()) {
                    C0795s.m802b(b2, "is_folder", true);
                } else {
                    C0795s.m802b(b2, "is_folder", false);
                }
                C0795s.m785a(a, (Object) b2);
            }
            C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, true);
            C0795s.m792a(b, "entries", a);
            xVar.mo10940a(b).mo10945d();
            return true;
        }
        C0795s.m802b(b, FirebaseAnalytics.Param.SUCCESS, false);
        xVar.mo10940a(b).mo10945d();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo10896c(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        String h = C0795s.m812h(b, "filepath");
        String h2 = C0795s.m812h(b, "encoding");
        boolean z = h2 != null && h2.equals("utf8");
        C0557a.m88c().mo10659t().mo10616g();
        JSONObject b2 = C0795s.m798b();
        try {
            StringBuilder a = mo10885a(h, z);
            C0795s.m802b(b2, FirebaseAnalytics.Param.SUCCESS, true);
            C0795s.m791a(b2, DataBufferSafeParcelable.DATA_FIELD, a.toString());
            xVar.mo10940a(b2).mo10945d();
            return a.toString();
        } catch (IOException unused) {
            C0795s.m802b(b2, FirebaseAnalytics.Param.SUCCESS, false);
            xVar.mo10940a(b2).mo10945d();
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo10897d(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        String h = C0795s.m812h(b, "filepath");
        String h2 = C0795s.m812h(b, "new_filepath");
        C0557a.m88c().mo10659t().mo10616g();
        JSONObject b2 = C0795s.m798b();
        try {
            if (new File(h).renameTo(new File(h2))) {
                C0795s.m802b(b2, FirebaseAnalytics.Param.SUCCESS, true);
                xVar.mo10940a(b2).mo10945d();
                return true;
            }
            C0795s.m802b(b2, FirebaseAnalytics.Param.SUCCESS, false);
            xVar.mo10940a(b2).mo10945d();
            return false;
        } catch (Exception unused) {
            C0795s.m802b(b2, FirebaseAnalytics.Param.SUCCESS, false);
            xVar.mo10940a(b2).mo10945d();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo10898e(C0812x xVar) {
        JSONObject b = xVar.mo10941b();
        String h = C0795s.m812h(b, "filepath");
        String h2 = C0795s.m812h(b, DataBufferSafeParcelable.DATA_FIELD);
        String h3 = C0795s.m812h(b, "encoding");
        boolean z = h3 != null && h3.equals("utf8");
        C0557a.m88c().mo10659t().mo10616g();
        JSONObject b2 = C0795s.m798b();
        try {
            mo10888a(h, h2, z);
            C0795s.m802b(b2, FirebaseAnalytics.Param.SUCCESS, true);
            xVar.mo10940a(b2).mo10945d();
            return true;
        } catch (IOException unused) {
            C0795s.m802b(b2, FirebaseAnalytics.Param.SUCCESS, false);
            xVar.mo10940a(b2).mo10945d();
            return false;
        }
    }
}
