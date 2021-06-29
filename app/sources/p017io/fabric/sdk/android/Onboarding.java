package p017io.fabric.sdk.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.ustv.player.manager.SharePreManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import p017io.fabric.sdk.android.services.common.ApiKey;
import p017io.fabric.sdk.android.services.common.CommonUtils;
import p017io.fabric.sdk.android.services.common.DeliveryMechanism;
import p017io.fabric.sdk.android.services.common.IdManager;
import p017io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import p017io.fabric.sdk.android.services.network.HttpRequestFactory;
import p017io.fabric.sdk.android.services.settings.AppRequestData;
import p017io.fabric.sdk.android.services.settings.AppSettingsData;
import p017io.fabric.sdk.android.services.settings.CreateAppSpiCall;
import p017io.fabric.sdk.android.services.settings.IconRequest;
import p017io.fabric.sdk.android.services.settings.Settings;
import p017io.fabric.sdk.android.services.settings.SettingsData;
import p017io.fabric.sdk.android.services.settings.UpdateAppSpiCall;

/* renamed from: io.fabric.sdk.android.Onboarding */
class Onboarding extends Kit<Boolean> {
    private static final String BINARY_BUILD_TYPE = "binary";
    static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    private String applicationLabel;
    private String installerPackageName;
    private final Future<Map<String, KitInfo>> kitsFinder;
    private PackageInfo packageInfo;
    private PackageManager packageManager;
    private String packageName;
    private final Collection<Kit> providedKits;
    private final HttpRequestFactory requestFactory = new DefaultHttpRequestFactory();
    private String targetAndroidSdkVersion;
    private String versionCode;
    private String versionName;

    public Onboarding(Future<Map<String, KitInfo>> future, Collection<Kit> collection) {
        this.kitsFinder = future;
        this.providedKits = collection;
    }

    private AppRequestData buildAppRequest(IconRequest iconRequest, Collection<KitInfo> collection) {
        Context context = getContext();
        return new AppRequestData(new ApiKey().getValue(context), getIdManager().getAppIdentifier(), this.versionName, this.versionCode, CommonUtils.createInstanceIdFrom(CommonUtils.resolveBuildId(context)), this.applicationLabel, DeliveryMechanism.determineFrom(this.installerPackageName).getId(), this.targetAndroidSdkVersion, SharePreManager.DEF_THEME, iconRequest, collection);
    }

    private boolean performAutoConfigure(String str, AppSettingsData appSettingsData, Collection<KitInfo> collection) {
        if (AppSettingsData.STATUS_NEW.equals(appSettingsData.status)) {
            if (performCreateApp(str, appSettingsData, collection)) {
                return Settings.getInstance().loadSettingsSkippingCache();
            }
            Fabric.getLogger().mo20914e(Fabric.TAG, "Failed to create app with Crashlytics service.", (Throwable) null);
            return false;
        } else if (AppSettingsData.STATUS_CONFIGURED.equals(appSettingsData.status)) {
            return Settings.getInstance().loadSettingsSkippingCache();
        } else {
            if (appSettingsData.updateRequired) {
                Fabric.getLogger().mo20911d(Fabric.TAG, "Server says an update is required - forcing a full App update.");
                performUpdateApp(str, appSettingsData, collection);
            }
            return true;
        }
    }

    private boolean performCreateApp(String str, AppSettingsData appSettingsData, Collection<KitInfo> collection) {
        return new CreateAppSpiCall(this, getOverridenSpiEndpoint(), appSettingsData.url, this.requestFactory).invoke(buildAppRequest(IconRequest.build(getContext(), str), collection));
    }

    private boolean performUpdateApp(AppSettingsData appSettingsData, IconRequest iconRequest, Collection<KitInfo> collection) {
        return new UpdateAppSpiCall(this, getOverridenSpiEndpoint(), appSettingsData.url, this.requestFactory).invoke(buildAppRequest(iconRequest, collection));
    }

    private boolean performUpdateApp(String str, AppSettingsData appSettingsData, Collection<KitInfo> collection) {
        return performUpdateApp(appSettingsData, IconRequest.build(getContext(), str), collection);
    }

    private SettingsData retrieveSettingsData() {
        try {
            Settings.getInstance().initialize(this, this.idManager, this.requestFactory, this.versionCode, this.versionName, getOverridenSpiEndpoint()).loadSettingsData();
            return Settings.getInstance().awaitSettingsData();
        } catch (Exception e) {
            Fabric.getLogger().mo20914e(Fabric.TAG, "Error dealing with settings", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Boolean doInBackground() {
        boolean z;
        String appIconHashOrNull = CommonUtils.getAppIconHashOrNull(getContext());
        SettingsData retrieveSettingsData = retrieveSettingsData();
        if (retrieveSettingsData != null) {
            try {
                z = performAutoConfigure(appIconHashOrNull, retrieveSettingsData.appData, mergeKits(this.kitsFinder != null ? this.kitsFinder.get() : new HashMap(), this.providedKits).values());
            } catch (Exception e) {
                Fabric.getLogger().mo20914e(Fabric.TAG, "Error performing auto configuration.", e);
            }
            return Boolean.valueOf(z);
        }
        z = false;
        return Boolean.valueOf(z);
    }

    public String getIdentifier() {
        return "io.fabric.sdk.android:fabric";
    }

    /* access modifiers changed from: package-private */
    public String getOverridenSpiEndpoint() {
        return CommonUtils.getStringsFileValue(getContext(), CRASHLYTICS_API_ENDPOINT);
    }

    public String getVersion() {
        return "1.4.5.28";
    }

    /* access modifiers changed from: package-private */
    public Map<String, KitInfo> mergeKits(Map<String, KitInfo> map, Collection<Kit> collection) {
        for (Kit next : collection) {
            if (!map.containsKey(next.getIdentifier())) {
                map.put(next.getIdentifier(), new KitInfo(next.getIdentifier(), next.getVersion(), BINARY_BUILD_TYPE));
            }
        }
        return map;
    }

    /* access modifiers changed from: protected */
    public boolean onPreExecute() {
        try {
            this.installerPackageName = getIdManager().getInstallerPackageName();
            this.packageManager = getContext().getPackageManager();
            this.packageName = getContext().getPackageName();
            this.packageInfo = this.packageManager.getPackageInfo(this.packageName, 0);
            this.versionCode = Integer.toString(this.packageInfo.versionCode);
            this.versionName = this.packageInfo.versionName == null ? IdManager.DEFAULT_VERSION_NAME : this.packageInfo.versionName;
            this.applicationLabel = this.packageManager.getApplicationLabel(getContext().getApplicationInfo()).toString();
            this.targetAndroidSdkVersion = Integer.toString(getContext().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            Fabric.getLogger().mo20914e(Fabric.TAG, "Failed init", e);
            return false;
        }
    }
}
