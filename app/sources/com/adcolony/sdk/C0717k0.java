package com.adcolony.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.p000v4.p002os.EnvironmentCompat;
import android.view.View;
import android.widget.Toast;
import com.adcolony.sdk.C0797u;
import com.google.android.gms.common.util.AndroidUtilsLight;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.CRC32;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.k0 */
class C0717k0 {

    /* renamed from: a */
    static final int f835a = 128;

    /* renamed from: b */
    static ExecutorService f836b = Executors.newSingleThreadExecutor();

    /* renamed from: c */
    static Handler f837c;

    /* renamed from: com.adcolony.sdk.k0$a */
    static class C0718a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f838a;

        /* renamed from: b */
        final /* synthetic */ String f839b;

        /* renamed from: c */
        final /* synthetic */ int f840c;

        C0718a(Context context, String str, int i) {
            this.f838a = context;
            this.f839b = str;
            this.f840c = i;
        }

        public void run() {
            Toast makeText = Toast.makeText(this.f838a, this.f839b, this.f840c);
        }
    }

    /* renamed from: com.adcolony.sdk.k0$b */
    static class C0719b {

        /* renamed from: a */
        double f841a;

        /* renamed from: b */
        double f842b = ((double) System.currentTimeMillis());

        C0719b(double d) {
            mo10780a(d);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo10780a(double d) {
            this.f841a = d;
            double currentTimeMillis = (double) System.currentTimeMillis();
            Double.isNaN(currentTimeMillis);
            this.f842b = (currentTimeMillis / 1000.0d) + this.f841a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo10781a() {
            return mo10782b() == 0.0d;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public double mo10782b() {
            double currentTimeMillis = (double) System.currentTimeMillis();
            Double.isNaN(currentTimeMillis);
            double d = this.f842b - (currentTimeMillis / 1000.0d);
            if (d <= 0.0d) {
                return 0.0d;
            }
            return d;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo10783c() {
            mo10780a(this.f841a);
        }

        public String toString() {
            return C0717k0.m508a(mo10782b(), 2);
        }
    }

    C0717k0() {
    }

    /* renamed from: a */
    static double m502a(AudioManager audioManager) {
        if (audioManager == null) {
            new C0797u.C0798a().mo10920a("getAudioVolume() called with a null AudioManager").mo10922a(C0797u.f1095j);
            return 0.0d;
        }
        try {
            double streamVolume = (double) audioManager.getStreamVolume(3);
            double streamMaxVolume = (double) audioManager.getStreamMaxVolume(3);
            if (streamMaxVolume == 0.0d) {
                return 0.0d;
            }
            Double.isNaN(streamVolume);
            Double.isNaN(streamMaxVolume);
            return streamVolume / streamMaxVolume;
        } catch (Exception e) {
            new C0797u.C0798a().mo10920a("Exception occurred when accessing AudioManager: ").mo10920a(e.toString()).mo10922a(C0797u.f1095j);
            return 0.0d;
        }
    }

    /* renamed from: a */
    static int m503a(View view) {
        if (view == null) {
            return 0;
        }
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        return (int) (((float) iArr[0]) / C0557a.m88c().mo10647h().mo10737n());
    }

    /* renamed from: a */
    static int m504a(C0647g0 g0Var) {
        int i = 0;
        try {
            Context b = C0557a.m86b();
            if (b != null) {
                int i2 = (int) (b.getPackageManager().getPackageInfo(b.getPackageName(), 0).lastUpdateTime / 1000);
                boolean exists = new File(g0Var.mo10610a() + "AppVersion").exists();
                boolean z = true;
                if (exists) {
                    if (C0795s.m810f(C0795s.m804c(g0Var.mo10610a() + "AppVersion"), "last_update") != i2) {
                        i = 1;
                    } else {
                        z = false;
                    }
                } else {
                    i = 2;
                }
                if (z) {
                    JSONObject b2 = C0795s.m798b();
                    C0795s.m801b(b2, "last_update", i2);
                    C0795s.m813i(b2, g0Var.mo10610a() + "AppVersion");
                }
            }
        } catch (Exception unused) {
        }
        return i;
    }

    /* renamed from: a */
    static int m505a(String str) {
        CRC32 crc32 = new CRC32();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            crc32.update(str.charAt(i));
        }
        return (int) crc32.getValue();
    }

    /* renamed from: a */
    static AudioManager m506a(Context context) {
        if (context != null) {
            return (AudioManager) context.getSystemService("audio");
        }
        new C0797u.C0798a().mo10920a("getAudioManager called with a null Context").mo10922a(C0797u.f1095j);
        return null;
    }

    /* renamed from: a */
    static String m507a() {
        return UUID.randomUUID().toString();
    }

    /* renamed from: a */
    static String m508a(double d, int i) {
        StringBuilder sb = new StringBuilder();
        m512a(d, i, sb);
        return sb.toString();
    }

    /* renamed from: a */
    static String m509a(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* renamed from: a */
    static String m510a(JSONArray jSONArray) throws JSONException {
        String str = "";
        for (int i = 0; i < jSONArray.length(); i++) {
            if (i > 0) {
                str = str + ",";
            }
            switch (jSONArray.getInt(i)) {
                case 1:
                    str = str + "MO";
                    break;
                case 2:
                    str = str + "TU";
                    break;
                case 3:
                    str = str + "WE";
                    break;
                case 4:
                    str = str + "TH";
                    break;
                case 5:
                    str = str + "FR";
                    break;
                case 6:
                    str = str + "SA";
                    break;
                case 7:
                    str = str + "SU";
                    break;
            }
        }
        return str;
    }

    /* renamed from: a */
    static JSONArray m511a(int i) {
        JSONArray a = C0795s.m778a();
        for (int i2 = 0; i2 < i; i2++) {
            C0795s.m800b(a, m507a());
        }
        return a;
    }

    /* renamed from: a */
    static void m512a(double d, int i, StringBuilder sb) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            sb.append(d);
            return;
        }
        if (d < 0.0d) {
            d = -d;
            sb.append('-');
        }
        if (i == 0) {
            sb.append(Math.round(d));
            return;
        }
        long pow = (long) Math.pow(10.0d, (double) i);
        double d2 = (double) pow;
        Double.isNaN(d2);
        long round = Math.round(d * d2);
        sb.append(round / pow);
        sb.append('.');
        long j = round % pow;
        if (j == 0) {
            for (int i2 = 0; i2 < i; i2++) {
                sb.append('0');
            }
            return;
        }
        for (long j2 = j * 10; j2 < pow; j2 *= 10) {
            sb.append('0');
        }
        sb.append(j);
    }

    /* renamed from: a */
    static boolean m513a(Intent intent) {
        return m514a(intent, false);
    }

    /* renamed from: a */
    static boolean m514a(Intent intent, boolean z) {
        try {
            Context b = C0557a.m86b();
            if (b == null) {
                return false;
            }
            AdColonyInterstitial d = C0557a.m88c().mo10640d();
            if (d != null && d.mo10429g()) {
                d.mo10427e().mo10553e();
            }
            if (z) {
                b.startActivity(Intent.createChooser(intent, "Handle this via..."));
                return true;
            }
            b.startActivity(intent);
            return true;
        } catch (Exception e) {
            new C0797u.C0798a().mo10920a(e.toString()).mo10922a(C0797u.f1093h);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m515a(Runnable runnable) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            return false;
        }
        if (f837c == null) {
            f837c = new Handler(mainLooper);
        }
        if (mainLooper == Looper.myLooper()) {
            runnable.run();
            return true;
        }
        f837c.post(runnable);
        return true;
    }

    /* renamed from: a */
    static boolean m516a(String str, int i) {
        Context b = C0557a.m86b();
        if (b == null) {
            return false;
        }
        m515a((Runnable) new C0718a(b, str, i));
        return true;
    }

    /* renamed from: a */
    static boolean m517a(String str, File file) {
        try {
            MessageDigest instance = MessageDigest.getInstance(AndroidUtilsLight.DIGEST_ALGORITHM_SHA1);
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    } catch (IOException e) {
                        throw new RuntimeException("Unable to process file for MD5", e);
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                            new C0797u.C0798a().mo10920a("Exception on closing MD5 input stream").mo10922a(C0797u.f1095j);
                        }
                        throw th;
                    }
                }
                boolean equals = str.equals(String.format("%40s", new Object[]{new BigInteger(1, instance.digest()).toString(16)}).replace(' ', '0'));
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                    new C0797u.C0798a().mo10920a("Exception on closing MD5 input stream").mo10922a(C0797u.f1095j);
                }
                return equals;
            } catch (FileNotFoundException unused3) {
                new C0797u.C0798a().mo10920a("Exception while getting FileInputStream").mo10922a(C0797u.f1095j);
                return false;
            }
        } catch (NoSuchAlgorithmException unused4) {
            new C0797u.C0798a().mo10920a("Exception while getting Digest").mo10922a(C0797u.f1095j);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m518a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        Arrays.sort(strArr);
        Arrays.sort(strArr2);
        return Arrays.equals(strArr, strArr2);
    }

    /* renamed from: b */
    static double m519b() {
        double currentTimeMillis = (double) System.currentTimeMillis();
        Double.isNaN(currentTimeMillis);
        return currentTimeMillis / 1000.0d;
    }

    /* renamed from: b */
    static int m520b(View view) {
        if (view == null) {
            return 0;
        }
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        return (int) (((float) iArr[1]) / C0557a.m88c().mo10647h().mo10737n());
    }

    /* renamed from: b */
    static String m521b(@NonNull Context context) {
        try {
            return context.getPackageName();
        } catch (Exception unused) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    /* renamed from: b */
    static String m522b(String str) {
        try {
            return C0765n0.m712a(str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    static String m523b(JSONArray jSONArray) throws JSONException {
        String str = "";
        for (int i = 0; i < jSONArray.length(); i++) {
            if (i > 0) {
                str = str + ",";
            }
            str = str + jSONArray.getInt(i);
        }
        return str;
    }

    /* renamed from: b */
    static boolean m524b(AudioManager audioManager) {
        if (audioManager == null) {
            new C0797u.C0798a().mo10920a("isAudioEnabled() called with a null AudioManager").mo10922a(C0797u.f1095j);
            return false;
        }
        try {
            return audioManager.getStreamVolume(3) > 0;
        } catch (Exception e) {
            new C0797u.C0798a().mo10920a("Exception occurred when accessing AudioManager.getStreamVolume: ").mo10920a(e.toString()).mo10922a(C0797u.f1095j);
            return false;
        }
    }

    /* renamed from: c */
    static JSONArray m525c(Context context) {
        JSONArray a = C0795s.m778a();
        if (context == null) {
            return a;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            if (packageInfo.requestedPermissions == null) {
                return a;
            }
            JSONArray a2 = C0795s.m778a();
            int i = 0;
            while (i < packageInfo.requestedPermissions.length) {
                try {
                    a2.put(packageInfo.requestedPermissions[i]);
                    i++;
                } catch (Exception unused) {
                }
            }
            return a2;
        } catch (Exception unused2) {
            return a;
        }
    }

    /* renamed from: c */
    private static void m526c(String str) {
        Context b = C0557a.m86b();
        if (b != null) {
            try {
                InputStream open = b.getAssets().open(str);
                FileOutputStream fileOutputStream = new FileOutputStream(C0557a.m88c().mo10659t().mo10612c() + str);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        open.close();
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return;
                    }
                }
            } catch (Exception e) {
                new C0797u.C0798a().mo10920a("Failed copy hardcoded ad unit file named: ").mo10920a(str).mo10920a(" with error: ").mo10920a(e.getMessage()).mo10922a(C0797u.f1095j);
            }
        }
    }

    /* renamed from: c */
    static boolean m527c() {
        try {
            C0648h c = C0557a.m88c();
            File file = new File(c.mo10659t().mo10610a() + "026ae9c9824b3e483fa6c71fa88f57ae27816141");
            StringBuilder sb = new StringBuilder();
            sb.append(c.mo10659t().mo10610a());
            sb.append("7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5");
            return c.mo10650k().mo10891a(file) && c.mo10650k().mo10891a(new File(sb.toString()));
        } catch (Exception unused) {
            new C0797u.C0798a().mo10920a("Unable to delete controller or launch response.").mo10922a(C0797u.f1095j);
            return false;
        }
    }

    /* renamed from: d */
    static int m528d(Context context) {
        int identifier;
        if (context != null && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: d */
    static String m529d() {
        Context b = C0557a.m86b();
        if (b == null) {
            return "";
        }
        PackageManager packageManager = (b instanceof Application ? (Application) b : ((Activity) b).getApplication()).getPackageManager();
        try {
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(b.getPackageName(), 0));
            return applicationLabel == null ? "" : applicationLabel.toString();
        } catch (Exception unused) {
            new C0797u.C0798a().mo10920a("Failed to retrieve application label.").mo10922a(C0797u.f1095j);
            return "";
        }
    }

    /* renamed from: d */
    public static void m530d(String str) {
        Context b = C0557a.m86b();
        if (b != null) {
            try {
                String[] list = b.getAssets().list(str);
                if (list.length == 0) {
                    m526c(str);
                    return;
                }
                File file = new File(C0557a.m88c().mo10659t().mo10612c() + str);
                if (!file.exists()) {
                    file.mkdir();
                }
                for (int i = 0; i < list.length; i++) {
                    m530d(str + "/" + list[i]);
                }
            } catch (IOException e) {
                new C0797u.C0798a().mo10920a("Failed copy hardcoded ad unit with error: ").mo10920a(e.getMessage()).mo10922a(C0797u.f1095j);
            }
        }
    }

    /* renamed from: e */
    static String m531e() {
        Context b = C0557a.m86b();
        if (b == null) {
            return "1.0";
        }
        try {
            return b.getPackageManager().getPackageInfo(b.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            new C0797u.C0798a().mo10920a("Failed to retrieve package info.").mo10922a(C0797u.f1095j);
            return "1.0";
        }
    }

    /* renamed from: e */
    static String m532e(String str) {
        return str == null ? "" : URLDecoder.decode(str);
    }

    /* renamed from: f */
    static int m533f() {
        Context b = C0557a.m86b();
        if (b == null) {
            return 0;
        }
        try {
            return b.getPackageManager().getPackageInfo(b.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            new C0797u.C0798a().mo10920a("Failed to retrieve package info.").mo10922a(C0797u.f1095j);
            return 0;
        }
    }

    /* renamed from: f */
    static boolean m534f(String str) {
        Context b = C0557a.m86b();
        if (b == null) {
            return false;
        }
        try {
            (b instanceof Application ? (Application) b : ((Activity) b).getApplication()).getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int m535g(java.lang.String r5) {
        /*
            int r0 = r5.hashCode()
            r1 = 0
            r2 = -1
            r3 = 1
            r4 = 729267099(0x2b77bb9b, float:8.8012383E-13)
            if (r0 == r4) goto L_0x001c
            r4 = 1430647483(0x5545f2bb, float:1.36028944E13)
            if (r0 == r4) goto L_0x0012
            goto L_0x0026
        L_0x0012:
            java.lang.String r0 = "landscape"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0026
            r5 = 1
            goto L_0x0027
        L_0x001c:
            java.lang.String r0 = "portrait"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0026
            r5 = 0
            goto L_0x0027
        L_0x0026:
            r5 = -1
        L_0x0027:
            if (r5 == 0) goto L_0x002e
            if (r5 == r3) goto L_0x002d
            r1 = -1
            goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0717k0.m535g(java.lang.String):int");
    }

    /* renamed from: g */
    static String m536g() {
        Context b = C0557a.m86b();
        return (!(b instanceof Activity) || b.getResources().getConfiguration().orientation != 1) ? "landscape" : "portrait";
    }

    /* renamed from: h */
    static boolean m537h() {
        Context b = C0557a.m86b();
        return b != null && Build.VERSION.SDK_INT >= 24 && (b instanceof Activity) && ((Activity) b).isInMultiWindowMode();
    }

    /* renamed from: h */
    static boolean m538h(String str) {
        if (str != null && str.length() <= 128) {
            return true;
        }
        new C0797u.C0798a().mo10920a("String must be non-null and the max length is 128 characters.").mo10922a(C0797u.f1092g);
        return false;
    }

    /* renamed from: i */
    static void m539i(String str) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    new C0797u.C0798a().mo10920a(">").mo10920a(file.getAbsolutePath()).mo10922a(C0797u.f1089d);
                    m539i(file.getAbsolutePath());
                } else {
                    new C0797u.C0798a().mo10920a(file.getAbsolutePath()).mo10922a(C0797u.f1089d);
                }
            }
        }
    }

    /* renamed from: j */
    static int m540j(String str) {
        try {
            return (int) Long.parseLong(str, 16);
        } catch (NumberFormatException unused) {
            new C0797u.C0798a().mo10920a("Unable to parse '").mo10920a(str).mo10920a("' as a color.").mo10922a(C0797u.f1093h);
            return -16777216;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        return new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", java.util.Locale.US).parse(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        return new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.US).parse(r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0020 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0025 */
    /* renamed from: k */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.Date m541k(java.lang.String r5) {
        /*
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r2 = "yyyy-MM-dd'T'HH:mmZ"
            r0.<init>(r2, r1)
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.util.Locale r2 = java.util.Locale.US
            java.lang.String r3 = "yyyy-MM-dd'T'HH:mm:ssZ"
            r1.<init>(r3, r2)
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.util.Locale r3 = java.util.Locale.US
            java.lang.String r4 = "yyyy-MM-dd"
            r2.<init>(r4, r3)
            java.util.Date r0 = r0.parse(r5)     // Catch:{ Exception -> 0x0020 }
            return r0
        L_0x0020:
            java.util.Date r0 = r1.parse(r5)     // Catch:{ Exception -> 0x0025 }
            return r0
        L_0x0025:
            java.util.Date r5 = r2.parse(r5)     // Catch:{ Exception -> 0x002a }
            return r5
        L_0x002a:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0717k0.m541k(java.lang.String):java.util.Date");
    }
}
