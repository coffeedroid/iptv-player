package mdc.libgeneral;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mdc.libgeneral.core.Notification;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.network.HttpRequest;

public class NotificationManager {
    public static final String SHARE_ALL_NOTIFYCATION = "all_notification";
    public static final String SHARE_FILE = "mdc.libgeneral.NotificationManager";
    public static final String SHARE_READ_NOTIFICATION = "read_notification";
    private static NotificationManager instant;
    private Context context;
    /* access modifiers changed from: private */
    public NotificationDelegate delegate;
    private List<Notification> listAllNofications = new ArrayList();
    private List<Double> listReadNotifications = new ArrayList();
    String tag = NotificationManager.class.getName();

    public interface NotificationDelegate {
        void loadNotificationDone();
    }

    private NotificationManager() {
    }

    /* access modifiers changed from: private */
    public Object connectToServer(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str.replaceAll(" ", "%20")).openConnection();
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("content-type", "text/plain; charset=utf-8");
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i * 1000);
            }
            if (i2 > 0) {
                httpURLConnection.setReadTimeout(i2 * 1000);
            }
            httpURLConnection.setRequestMethod(HttpRequest.METHOD_GET);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                return Integer.valueOf(responseCode);
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            StringBuilder sb = new StringBuilder();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    sb.append(new String(bArr, 0, read));
                } else {
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return sb.toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void loadNotification(String str) throws JSONException {
        if (str != null) {
            this.context.getSharedPreferences(SHARE_FILE, 0).edit().putString(SHARE_ALL_NOTIFYCATION, str).apply();
            parseNotifications(new JSONArray(str));
        }
    }

    private void parseNotifications(JSONArray jSONArray) throws JSONException {
        this.listAllNofications.clear();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            this.listAllNofications.add(Notification.fromJson(jSONArray.getJSONObject(i)));
        }
    }

    public static NotificationManager sharedInstant() {
        if (instant == null) {
            instant = new NotificationManager();
        }
        return instant;
    }

    public List<Notification> getAllNotifications() {
        return this.listAllNofications;
    }

    public NotificationDelegate getDelegate() {
        return this.delegate;
    }

    public List<Notification> getNotificationsByType(int i) {
        ArrayList arrayList = new ArrayList();
        for (Notification next : this.listAllNofications) {
            if (next.getType() == i) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public int getNumberOfUnreadNotification() {
        return this.listAllNofications.size() - this.listReadNotifications.size();
    }

    public List<Notification> getRecentNotifications() {
        return this.listAllNofications.size() > 3 ? this.listAllNofications.subList(0, 3) : this.listAllNofications;
    }

    public void init(Context context2) {
        this.context = context2;
        String string = context2.getSharedPreferences(SHARE_FILE, 0).getString(SHARE_ALL_NOTIFYCATION, (String) null);
        if (string != null) {
            try {
                parseNotifications(new JSONArray(string));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        String string2 = context2.getSharedPreferences(SHARE_FILE, 0).getString(SHARE_READ_NOTIFICATION, (String) null);
        if (string2 != null) {
            this.listReadNotifications = (List) new Gson().fromJson(string2, ArrayList.class);
        }
    }

    public boolean isWatched(int i) {
        return this.listReadNotifications.contains(Double.valueOf((double) i));
    }

    public void loadNotificationFromServer(final String str, final String str2, final String str3) {
        new Thread(new Runnable() {
            public void run() {
                NotificationManager notificationManager = NotificationManager.this;
                Object access$000 = notificationManager.connectToServer("http://visearch.net/configs/get_notifications.php?AppId=" + str + "&AppVersion=" + str2 + "&Platform=" + str3, 10, 10);
                if (access$000 instanceof String) {
                    try {
                        NotificationManager.this.loadNotification(new JSONObject((String) access$000).getString("Notifications"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (NotificationManager.this.delegate != null) {
                        NotificationManager.this.delegate.loadNotificationDone();
                        return;
                    }
                    return;
                }
                String str = NotificationManager.this.tag;
                Log.i(str, "load notification failed:" + access$000);
            }
        }).start();
    }

    public void readNotification(double d) {
        if (!this.listReadNotifications.contains(Double.valueOf(d))) {
            this.listReadNotifications.add(Double.valueOf(d));
            this.context.getSharedPreferences(SHARE_FILE, 0).edit().putString(SHARE_READ_NOTIFICATION, new Gson().toJson((Object) this.listReadNotifications, (Type) ArrayList.class)).apply();
        }
    }

    public void setDelegate(NotificationDelegate notificationDelegate) {
        this.delegate = notificationDelegate;
    }
}
