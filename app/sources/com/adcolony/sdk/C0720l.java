package com.adcolony.sdk;

import android.content.Context;
import com.adcolony.sdk.C0797u;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.network.HttpRequest;

/* renamed from: com.adcolony.sdk.l */
class C0720l implements Runnable {

    /* renamed from: a */
    private HttpURLConnection f843a;

    /* renamed from: b */
    private InputStream f844b;

    /* renamed from: c */
    private C0812x f845c;

    /* renamed from: d */
    private C0721a f846d;

    /* renamed from: e */
    private final int f847e = 4096;

    /* renamed from: f */
    private final int f848f = 299;

    /* renamed from: g */
    private String f849g;

    /* renamed from: h */
    private int f850h = 0;

    /* renamed from: i */
    private boolean f851i = false;

    /* renamed from: j */
    private Map<String, List<String>> f852j;

    /* renamed from: k */
    private String f853k = "";

    /* renamed from: l */
    private String f854l = "";

    /* renamed from: m */
    String f855m = "";

    /* renamed from: n */
    String f856n = "";

    /* renamed from: o */
    boolean f857o;

    /* renamed from: p */
    int f858p;

    /* renamed from: q */
    int f859q;

    /* renamed from: com.adcolony.sdk.l$a */
    interface C0721a {
        /* renamed from: a */
        void mo10627a(C0720l lVar, C0812x xVar, Map<String, List<String>> map);
    }

    C0720l(C0812x xVar, C0721a aVar) {
        this.f845c = xVar;
        this.f846d = aVar;
    }

    /* renamed from: a */
    private void m546a(String str, String str2) {
        try {
            String substring = str2.substring(0, str2.lastIndexOf("/") + 1);
            if (str2 != null && !"".equals(str2) && !substring.equals(C0557a.m88c().mo10659t().mo10613d()) && !new File(str).renameTo(new File(str2))) {
                C0797u.C0798a a = new C0797u.C0798a().mo10920a("Moving of ");
                if (str == null) {
                    str = "temp folder's asset file";
                }
                a.mo10920a(str).mo10920a(" failed.").mo10922a(C0797u.f1093h);
            }
        } catch (Exception e) {
            new C0797u.C0798a().mo10920a("Exception: ").mo10920a(e.toString()).mo10922a(C0797u.f1094i);
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        r0 = p017io.fabric.sdk.android.services.network.HttpRequest.CHARSET_UTF8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
        if (r8.f849g == null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0065, code lost:
        if (r8.f849g.isEmpty() != false) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0067, code lost:
        r0 = r8.f849g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006b, code lost:
        if ((r10 instanceof java.io.ByteArrayOutputStream) == false) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006d, code lost:
        r8.f856n = ((java.io.ByteArrayOutputStream) r10).toString(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0077, code lost:
        if (r10 == null) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0079, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007c, code lost:
        if (r9 == null) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007e, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0081, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0084, code lost:
        return true;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m547a(java.io.InputStream r9, java.io.OutputStream r10) throws java.lang.Exception {
        /*
            r8 = this;
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r1.<init>(r9)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r0]     // Catch:{ Exception -> 0x0085 }
        L_0x000a:
            r3 = 0
            int r4 = r1.read(r2, r3, r0)     // Catch:{ Exception -> 0x0085 }
            r5 = -1
            if (r4 == r5) goto L_0x0059
            int r5 = r8.f858p     // Catch:{ Exception -> 0x0085 }
            int r5 = r5 + r4
            r8.f858p = r5     // Catch:{ Exception -> 0x0085 }
            boolean r6 = r8.f851i     // Catch:{ Exception -> 0x0085 }
            if (r6 == 0) goto L_0x0055
            int r6 = r8.f850h     // Catch:{ Exception -> 0x0085 }
            if (r5 > r6) goto L_0x0020
            goto L_0x0055
        L_0x0020:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x0085 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0085 }
            r2.<init>()     // Catch:{ Exception -> 0x0085 }
            java.lang.String r3 = "Data exceeds expected maximum ("
            r2.append(r3)     // Catch:{ Exception -> 0x0085 }
            int r3 = r8.f858p     // Catch:{ Exception -> 0x0085 }
            r2.append(r3)     // Catch:{ Exception -> 0x0085 }
            java.lang.String r3 = "/"
            r2.append(r3)     // Catch:{ Exception -> 0x0085 }
            int r3 = r8.f850h     // Catch:{ Exception -> 0x0085 }
            r2.append(r3)     // Catch:{ Exception -> 0x0085 }
            java.lang.String r3 = "): "
            r2.append(r3)     // Catch:{ Exception -> 0x0085 }
            java.net.HttpURLConnection r3 = r8.f843a     // Catch:{ Exception -> 0x0085 }
            java.net.URL r3 = r3.getURL()     // Catch:{ Exception -> 0x0085 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0085 }
            r2.append(r3)     // Catch:{ Exception -> 0x0085 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0085 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0085 }
            throw r0     // Catch:{ Exception -> 0x0085 }
        L_0x0055:
            r10.write(r2, r3, r4)     // Catch:{ Exception -> 0x0085 }
            goto L_0x000a
        L_0x0059:
            java.lang.String r0 = "UTF-8"
            java.lang.String r2 = r8.f849g     // Catch:{ Exception -> 0x0085 }
            if (r2 == 0) goto L_0x0069
            java.lang.String r2 = r8.f849g     // Catch:{ Exception -> 0x0085 }
            boolean r2 = r2.isEmpty()     // Catch:{ Exception -> 0x0085 }
            if (r2 != 0) goto L_0x0069
            java.lang.String r0 = r8.f849g     // Catch:{ Exception -> 0x0085 }
        L_0x0069:
            boolean r2 = r10 instanceof java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0085 }
            if (r2 == 0) goto L_0x0076
            r2 = r10
            java.io.ByteArrayOutputStream r2 = (java.io.ByteArrayOutputStream) r2     // Catch:{ Exception -> 0x0085 }
            java.lang.String r0 = r2.toString(r0)     // Catch:{ Exception -> 0x0085 }
            r8.f856n = r0     // Catch:{ Exception -> 0x0085 }
        L_0x0076:
            r0 = 1
            if (r10 == 0) goto L_0x007c
            r10.close()
        L_0x007c:
            if (r9 == 0) goto L_0x0081
            r9.close()
        L_0x0081:
            r1.close()
            return r0
        L_0x0085:
            r0 = move-exception
            goto L_0x008d
        L_0x0087:
            r1 = move-exception
            goto L_0x0092
        L_0x0089:
            r1 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
        L_0x008d:
            throw r0     // Catch:{ all -> 0x008e }
        L_0x008e:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
        L_0x0092:
            if (r10 == 0) goto L_0x0097
            r10.close()
        L_0x0097:
            if (r9 == 0) goto L_0x009c
            r9.close()
        L_0x009c:
            if (r0 == 0) goto L_0x00a1
            r0.close()
        L_0x00a1:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0720l.m547a(java.io.InputStream, java.io.OutputStream):boolean");
    }

    /* renamed from: b */
    private boolean m548b() throws IOException {
        JSONObject b = this.f845c.mo10941b();
        String h = C0795s.m812h(b, FirebaseAnalytics.Param.CONTENT_TYPE);
        String h2 = C0795s.m812h(b, FirebaseAnalytics.Param.CONTENT);
        boolean d = C0795s.m807d(b, "no_redirect");
        this.f855m = C0795s.m812h(b, "url");
        this.f853k = C0795s.m812h(b, "filepath");
        StringBuilder sb = new StringBuilder();
        sb.append(C0557a.m88c().mo10659t().mo10613d());
        String str = this.f853k;
        sb.append(str.substring(str.lastIndexOf("/") + 1));
        this.f854l = sb.toString();
        this.f849g = C0795s.m812h(b, "encoding");
        int a = C0795s.m777a(b, "max_size", 0);
        this.f850h = a;
        this.f851i = a != 0;
        this.f858p = 0;
        this.f844b = null;
        this.f843a = null;
        this.f852j = null;
        if (!this.f855m.startsWith("file://")) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f855m).openConnection();
            this.f843a = httpURLConnection;
            httpURLConnection.setInstanceFollowRedirects(!d);
            this.f843a.setRequestProperty(HttpRequest.HEADER_ACCEPT_CHARSET, HttpRequest.CHARSET_UTF8);
            String I = C0557a.m88c().mo10647h().mo10715I();
            if (I != null && !I.equals("")) {
                this.f843a.setRequestProperty("User-Agent", I);
            }
            if (!h.equals("")) {
                this.f843a.setRequestProperty(HttpRequest.HEADER_CONTENT_TYPE, h);
            }
            if (this.f845c.mo10944c().equals("WebServices.post")) {
                this.f843a.setDoOutput(true);
                this.f843a.setFixedLengthStreamingMode(h2.getBytes(HttpRequest.CHARSET_UTF8).length);
                new PrintStream(this.f843a.getOutputStream()).print(h2);
            }
        } else if (this.f855m.startsWith("file:///android_asset/")) {
            Context b2 = C0557a.m86b();
            if (b2 != null) {
                this.f844b = b2.getAssets().open(this.f855m.substring(22));
            }
        } else {
            this.f844b = new FileInputStream(this.f855m.substring(7));
        }
        return (this.f843a == null && this.f844b == null) ? false : true;
    }

    /* renamed from: c */
    private boolean m549c() throws Exception {
        OutputStream outputStream;
        String c = this.f845c.mo10944c();
        if (this.f844b != null) {
            outputStream = this.f853k.length() == 0 ? new ByteArrayOutputStream(4096) : new FileOutputStream(new File(this.f853k).getAbsolutePath());
        } else if (c.equals("WebServices.download")) {
            this.f844b = this.f843a.getInputStream();
            outputStream = new FileOutputStream(this.f854l);
        } else if (c.equals("WebServices.get")) {
            this.f844b = this.f843a.getInputStream();
            outputStream = new ByteArrayOutputStream(4096);
        } else if (c.equals("WebServices.post")) {
            this.f843a.connect();
            this.f844b = (this.f843a.getResponseCode() < 200 || this.f843a.getResponseCode() > 299) ? this.f843a.getErrorStream() : this.f843a.getInputStream();
            outputStream = new ByteArrayOutputStream(4096);
        } else {
            outputStream = null;
        }
        HttpURLConnection httpURLConnection = this.f843a;
        if (httpURLConnection != null) {
            this.f859q = httpURLConnection.getResponseCode();
            this.f852j = this.f843a.getHeaderFields();
        }
        return m547a(this.f844b, outputStream);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0812x mo10785a() {
        return this.f845c;
    }

    public void run() {
        boolean z = false;
        this.f857o = false;
        try {
            if (m548b()) {
                this.f857o = m549c();
                if (this.f845c.mo10944c().equals("WebServices.post") && this.f859q != 200) {
                    this.f857o = false;
                }
            }
        } catch (MalformedURLException e) {
            new C0797u.C0798a().mo10920a("MalformedURLException: ").mo10920a(e.toString()).mo10922a(C0797u.f1095j);
            this.f857o = true;
        } catch (OutOfMemoryError unused) {
            C0797u.C0798a a = new C0797u.C0798a().mo10920a("Out of memory error - disabling AdColony. (").mo10918a(this.f858p).mo10920a("/").mo10918a(this.f850h);
            a.mo10920a("): " + this.f855m).mo10922a(C0797u.f1094i);
            C0557a.m88c().mo10629a(true);
        } catch (IOException e2) {
            new C0797u.C0798a().mo10920a("Download of ").mo10920a(this.f855m).mo10920a(" failed: ").mo10920a(e2.toString()).mo10922a(C0797u.f1093h);
            int i = this.f859q;
            if (i == 0) {
                i = 504;
            }
            this.f859q = i;
        } catch (IllegalStateException e3) {
            new C0797u.C0798a().mo10920a("okhttp error: ").mo10920a(e3.toString()).mo10922a(C0797u.f1094i);
            e3.printStackTrace();
        } catch (Exception e4) {
            new C0797u.C0798a().mo10920a("Exception: ").mo10920a(e4.toString()).mo10922a(C0797u.f1094i);
            e4.printStackTrace();
        }
        z = true;
        if (this.f857o) {
            new C0797u.C0798a().mo10920a("Downloaded ").mo10920a(this.f855m).mo10922a(C0797u.f1091f);
        }
        if (z) {
            if (this.f845c.mo10944c().equals("WebServices.download")) {
                m546a(this.f854l, this.f853k);
            }
            this.f846d.mo10627a(this, this.f845c, this.f852j);
        }
    }
}
