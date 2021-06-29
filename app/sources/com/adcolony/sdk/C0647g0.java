package com.adcolony.sdk;

import android.content.Context;
import android.os.StatFs;
import com.adcolony.sdk.C0797u;
import java.io.File;

/* renamed from: com.adcolony.sdk.g0 */
class C0647g0 {

    /* renamed from: a */
    private String f653a;

    /* renamed from: b */
    private String f654b;

    /* renamed from: c */
    private String f655c;

    /* renamed from: d */
    private String f656d;

    /* renamed from: e */
    private File f657e;

    /* renamed from: f */
    private File f658f;

    /* renamed from: g */
    private File f659g;

    C0647g0() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public double mo10609a(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return (double) (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()));
        } catch (RuntimeException unused) {
            return 0.0d;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo10610a() {
        return this.f653a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo10611b() {
        return this.f655c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo10612c() {
        return this.f654b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo10613d() {
        return this.f656d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo10614e() {
        new C0797u.C0798a().mo10920a("Configuring storage").mo10922a(C0797u.f1091f);
        C0648h c = C0557a.m88c();
        this.f653a = mo10615f() + "/adc3/";
        this.f654b = this.f653a + "media/";
        File file = new File(this.f654b);
        this.f657e = file;
        if (!file.isDirectory()) {
            this.f657e.delete();
            this.f657e.mkdirs();
        }
        if (!this.f657e.isDirectory()) {
            c.mo10629a(true);
            return false;
        } else if (mo10609a(this.f654b) < 2.097152E7d) {
            new C0797u.C0798a().mo10920a("Not enough memory available at media path, disabling AdColony.").mo10922a(C0797u.f1092g);
            c.mo10629a(true);
            return false;
        } else {
            this.f655c = mo10615f() + "/adc3/data/";
            File file2 = new File(this.f655c);
            this.f658f = file2;
            if (!file2.isDirectory()) {
                this.f658f.delete();
            }
            this.f658f.mkdirs();
            this.f656d = this.f653a + "tmp/";
            File file3 = new File(this.f656d);
            this.f659g = file3;
            if (!file3.isDirectory()) {
                this.f659g.delete();
                this.f659g.mkdirs();
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo10615f() {
        Context b = C0557a.m86b();
        return b == null ? "" : b.getFilesDir().getAbsolutePath();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo10616g() {
        File file = this.f657e;
        if (file == null || this.f658f == null || this.f659g == null) {
            return false;
        }
        if (!file.isDirectory()) {
            this.f657e.delete();
        }
        if (!this.f658f.isDirectory()) {
            this.f658f.delete();
        }
        if (!this.f659g.isDirectory()) {
            this.f659g.delete();
        }
        this.f657e.mkdirs();
        this.f658f.mkdirs();
        this.f659g.mkdirs();
        return true;
    }
}
