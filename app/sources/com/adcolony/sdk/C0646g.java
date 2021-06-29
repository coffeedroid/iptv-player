package com.adcolony.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.adcolony.sdk.C0797u;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.g */
class C0646g extends ContentObserver {

    /* renamed from: a */
    private AudioManager f651a;

    /* renamed from: b */
    private AdColonyInterstitial f652b;

    public C0646g(Handler handler, AdColonyInterstitial adColonyInterstitial) {
        super(handler);
        Context b = C0557a.m86b();
        if (b != null) {
            this.f651a = (AudioManager) b.getSystemService("audio");
            this.f652b = adColonyInterstitial;
            b.getApplicationContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10606a() {
        Context b = C0557a.m86b();
        if (b != null) {
            b.getApplicationContext().getContentResolver().unregisterContentObserver(this);
        }
        this.f652b = null;
        this.f651a = null;
    }

    public boolean deliverSelfNotifications() {
        return false;
    }

    public void onChange(boolean z) {
        AdColonyInterstitial adColonyInterstitial;
        if (this.f651a != null && (adColonyInterstitial = this.f652b) != null && adColonyInterstitial.mo10423c() != null) {
            double streamVolume = (double) ((((float) this.f651a.getStreamVolume(3)) / 15.0f) * 100.0f);
            JSONObject b = C0795s.m798b();
            C0795s.m789a(b, "audio_percentage", streamVolume);
            C0795s.m791a(b, "ad_session_id", this.f652b.mo10423c().mo10504a());
            C0795s.m801b(b, "id", this.f652b.mo10423c().mo10514c());
            new C0812x("AdContainer.on_audio_change", this.f652b.mo10423c().mo10531k(), b).mo10945d();
            new C0797u.C0798a().mo10920a("Volume changed to ").mo10917a(streamVolume).mo10922a(C0797u.f1091f);
        }
    }
}
