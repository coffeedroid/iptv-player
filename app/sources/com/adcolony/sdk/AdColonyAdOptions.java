package com.adcolony.sdk;

import android.support.annotation.NonNull;
import org.json.JSONObject;

public class AdColonyAdOptions {

    /* renamed from: a */
    boolean f123a;

    /* renamed from: b */
    boolean f124b;

    /* renamed from: c */
    AdColonyUserMetadata f125c;

    /* renamed from: d */
    JSONObject f126d = C0795s.m798b();

    public AdColonyAdOptions enableConfirmationDialog(boolean z) {
        this.f123a = z;
        C0795s.m802b(this.f126d, "confirmation_enabled", true);
        return this;
    }

    public AdColonyAdOptions enableResultsDialog(boolean z) {
        this.f124b = z;
        C0795s.m802b(this.f126d, "results_enabled", true);
        return this;
    }

    public Object getOption(@NonNull String str) {
        return C0795s.m797b(this.f126d, str);
    }

    public AdColonyUserMetadata getUserMetadata() {
        return this.f125c;
    }

    public AdColonyAdOptions setOption(@NonNull String str, double d) {
        if (C0717k0.m538h(str)) {
            C0795s.m789a(this.f126d, str, d);
        }
        return this;
    }

    public AdColonyAdOptions setOption(@NonNull String str, @NonNull String str2) {
        if (str != null && C0717k0.m538h(str) && C0717k0.m538h(str2)) {
            C0795s.m791a(this.f126d, str, str2);
        }
        return this;
    }

    public AdColonyAdOptions setOption(@NonNull String str, boolean z) {
        if (C0717k0.m538h(str)) {
            C0795s.m802b(this.f126d, str, z);
        }
        return this;
    }

    public AdColonyAdOptions setUserMetadata(@NonNull AdColonyUserMetadata adColonyUserMetadata) {
        this.f125c = adColonyUserMetadata;
        C0795s.m793a(this.f126d, "user_metadata", adColonyUserMetadata.f187b);
        return this;
    }
}
