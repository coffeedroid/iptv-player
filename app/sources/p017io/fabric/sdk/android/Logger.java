package p017io.fabric.sdk.android;

/* renamed from: io.fabric.sdk.android.Logger */
public interface Logger {
    /* renamed from: d */
    void mo20911d(String str, String str2);

    /* renamed from: d */
    void mo20912d(String str, String str2, Throwable th);

    /* renamed from: e */
    void mo20913e(String str, String str2);

    /* renamed from: e */
    void mo20914e(String str, String str2, Throwable th);

    int getLogLevel();

    /* renamed from: i */
    void mo20916i(String str, String str2);

    /* renamed from: i */
    void mo20917i(String str, String str2, Throwable th);

    boolean isLoggable(String str, int i);

    void log(int i, String str, String str2);

    void log(int i, String str, String str2, boolean z);

    void setLogLevel(int i);

    /* renamed from: v */
    void mo20922v(String str, String str2);

    /* renamed from: v */
    void mo20923v(String str, String str2, Throwable th);

    /* renamed from: w */
    void mo20924w(String str, String str2);

    /* renamed from: w */
    void mo20925w(String str, String str2, Throwable th);
}
