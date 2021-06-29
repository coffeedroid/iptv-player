package p017io.fabric.sdk.android;

/* renamed from: io.fabric.sdk.android.KitInfo */
public class KitInfo {
    private final String buildType;
    private final String identifier;
    private final String version;

    public KitInfo(String str, String str2, String str3) {
        this.identifier = str;
        this.version = str2;
        this.buildType = str3;
    }

    public String getBuildType() {
        return this.buildType;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getVersion() {
        return this.version;
    }
}
