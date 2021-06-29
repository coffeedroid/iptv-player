package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.adcolony.sdk.C0797u;

/* renamed from: com.adcolony.sdk.b0 */
class C0562b0 {
    C0562b0() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo10500a() {
        return mo10502c() ? "wifi" : mo10501b() ? "cell" : "none";
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    /* renamed from: b */
    public boolean mo10501b() {
        Context b = C0557a.m86b();
        if (b == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) b.getApplicationContext().getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            int type = activeNetworkInfo.getType();
            return type == 0 || type >= 2;
        } catch (SecurityException e) {
            new C0797u.C0798a().mo10920a("SecurityException - please ensure you added the ").mo10920a("ACCESS_NETWORK_STATE permission: ").mo10920a(e.toString()).mo10922a(C0797u.f1094i);
            return false;
        } catch (Exception e2) {
            new C0797u.C0798a().mo10920a("Exception occurred when retrieving activeNetworkInfo in ").mo10920a("ADCNetwork.using_mobile(): ").mo10920a(e2.toString()).mo10922a(C0797u.f1095j);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    /* renamed from: c */
    public boolean mo10502c() {
        Context b = C0557a.m86b();
        if (b == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) b.getApplicationContext().getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
        } catch (SecurityException e) {
            new C0797u.C0798a().mo10920a("SecurityException - please ensure you added the ").mo10920a("ACCESS_NETWORK_STATE permission: ").mo10920a(e.toString()).mo10922a(C0797u.f1094i);
            return false;
        } catch (Exception e2) {
            new C0797u.C0798a().mo10920a("Exception occurred when retrieving activeNetworkInfo in ").mo10920a("ADCNetwork.using_wifi(): ").mo10920a(e2.toString()).mo10922a(C0797u.f1095j);
            return false;
        }
    }
}
