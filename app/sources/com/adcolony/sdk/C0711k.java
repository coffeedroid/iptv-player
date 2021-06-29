package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.adcolony.sdk.C0797u;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.settings.SettingsJsonConstants;

/* renamed from: com.adcolony.sdk.k */
class C0711k {

    /* renamed from: d */
    static AlertDialog f822d;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C0812x f823a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AlertDialog f824b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f825c;

    /* renamed from: com.adcolony.sdk.k$a */
    class C0712a implements C0816z {
        C0712a() {
        }

        /* renamed from: a */
        public void mo10499a(C0812x xVar) {
            if (!C0557a.m89d() || !(C0557a.m86b() instanceof Activity)) {
                new C0797u.C0798a().mo10920a("Missing Activity reference, can't build AlertDialog.").mo10922a(C0797u.f1094i);
            } else if (C0795s.m807d(xVar.mo10941b(), "on_resume")) {
                C0812x unused = C0711k.this.f823a = xVar;
            } else {
                C0711k.this.mo10772a(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.k$b */
    class C0713b implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ C0812x f827a;

        C0713b(C0812x xVar) {
            this.f827a = xVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            AlertDialog unused = C0711k.this.f824b = null;
            dialogInterface.dismiss();
            JSONObject b = C0795s.m798b();
            C0795s.m802b(b, "positive", true);
            boolean unused2 = C0711k.this.f825c = false;
            this.f827a.mo10940a(b).mo10945d();
        }
    }

    /* renamed from: com.adcolony.sdk.k$c */
    class C0714c implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ C0812x f829a;

        C0714c(C0812x xVar) {
            this.f829a = xVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            AlertDialog unused = C0711k.this.f824b = null;
            dialogInterface.dismiss();
            JSONObject b = C0795s.m798b();
            C0795s.m802b(b, "positive", false);
            boolean unused2 = C0711k.this.f825c = false;
            this.f829a.mo10940a(b).mo10945d();
        }
    }

    /* renamed from: com.adcolony.sdk.k$d */
    class C0715d implements DialogInterface.OnCancelListener {

        /* renamed from: a */
        final /* synthetic */ C0812x f831a;

        C0715d(C0812x xVar) {
            this.f831a = xVar;
        }

        public void onCancel(DialogInterface dialogInterface) {
            AlertDialog unused = C0711k.this.f824b = null;
            boolean unused2 = C0711k.this.f825c = false;
            JSONObject b = C0795s.m798b();
            C0795s.m802b(b, "positive", false);
            this.f831a.mo10940a(b).mo10945d();
        }
    }

    /* renamed from: com.adcolony.sdk.k$e */
    class C0716e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AlertDialog.Builder f833a;

        C0716e(AlertDialog.Builder builder) {
            this.f833a = builder;
        }

        public void run() {
            boolean unused = C0711k.this.f825c = true;
            AlertDialog unused2 = C0711k.this.f824b = this.f833a.show();
        }
    }

    C0711k() {
        C0557a.m84a("Alert.show", (C0816z) new C0712a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AlertDialog mo10770a() {
        return this.f824b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10771a(AlertDialog alertDialog) {
        this.f824b = alertDialog;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public void mo10772a(C0812x xVar) {
        Context b = C0557a.m86b();
        if (b != null) {
            AlertDialog.Builder builder = Build.VERSION.SDK_INT >= 21 ? new AlertDialog.Builder(b, 16974374) : new AlertDialog.Builder(b, 16974126);
            JSONObject b2 = xVar.mo10941b();
            String h = C0795s.m812h(b2, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
            String h2 = C0795s.m812h(b2, "title");
            String h3 = C0795s.m812h(b2, "positive");
            String h4 = C0795s.m812h(b2, "negative");
            builder.setMessage(h);
            builder.setTitle(h2);
            builder.setPositiveButton(h3, new C0713b(xVar));
            if (!h4.equals("")) {
                builder.setNegativeButton(h4, new C0714c(xVar));
            }
            builder.setOnCancelListener(new C0715d(xVar));
            C0717k0.m515a((Runnable) new C0716e(builder));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo10773b() {
        return this.f825c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo10774c() {
        C0812x xVar = this.f823a;
        if (xVar != null) {
            mo10772a(xVar);
            this.f823a = null;
        }
    }
}
