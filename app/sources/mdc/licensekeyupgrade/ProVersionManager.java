package mdc.licensekeyupgrade;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.livestream.util.Decrypter;
import com.mdc.mdcdialog.MDCDialog;
import com.ustv.player.manager.SharePreManager;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mdc.licensekeyupgrade.AsyncTask;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p017io.fabric.sdk.android.services.network.HttpRequest;

public class ProVersionManager {
    public static final List<String> allFeaturePro = Arrays.asList(new String[]{SharePreManager.SHARE_PIP, "CHROMECAST", "RECORD", "PREMIUM"});
    private static ProVersionManager instant;
    private String HOST_SALES = "https://edge.mdcgate.com/sales/";
    private String SHARE_CUSTOM_FEATURE = "custom_feature";
    /* access modifiers changed from: private */
    public String SHARE_FILE = ProVersionManager.class.getName();
    /* access modifiers changed from: private */
    public String SHARE_ORDER_ID = "order_id";
    /* access modifiers changed from: private */
    public String SHARE_PRO_KEY = "key";
    private boolean bPro = false;
    private List<String> featurePremiumList;
    IOldDeviceDelegate oldDeviceDelegate;
    public String sError = null;
    String tag = ProVersionManager.class.getSimpleName();

    public interface IProVersionDelegate {
        void onCheckKeyComplete(ProVersionManager proVersionManager, String str);
    }

    public interface IOldDeviceDelegate {
        void onOldDevices(JSONArray jSONArray);
    }

    public static class ProKey {
        public String feature;
        private String key;
        private int orderId;

        public ProKey(String str, int i) {
            this.key = str;
            setOrderId(i);
        }

        public ProKey(String str, int i, String str2) {
            this.key = str;
            this.feature = str2;
            setOrderId(i);
        }

        public String getKey() {
            return this.key;
        }

        public int getOrderId() {
            return this.orderId;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setOrderId(int i) {
            this.orderId = i;
        }
    }

    private boolean checkInternetConnection(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isAvailable() && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    private void checkKey(Context context, String str, String str2) {
        Log.i(this.tag, "prokey: check local pro version key start");
        if (context.getSharedPreferences(this.SHARE_FILE, 0).getString(this.SHARE_PRO_KEY, (String) null) == null) {
            Log.i(this.tag, "prokey: not found local key");
            this.bPro = false;
            return;
        }
        String string = context.getSharedPreferences(this.SHARE_FILE, 0).getString(this.SHARE_CUSTOM_FEATURE, (String) null);
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                String str3 = this.tag;
                Log.i(str3, "Feature Premium đã lưu: " + jSONArray);
                this.featurePremiumList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    String parseFeaturePremiumKey = parseFeaturePremiumKey(context, jSONArray.getString(i), str, str2);
                    String str4 = this.tag;
                    Log.i(str4, "tìm thấy feature " + parseFeaturePremiumKey);
                    if (parseFeaturePremiumKey != null && !this.featurePremiumList.contains(parseFeaturePremiumKey)) {
                        this.featurePremiumList.add(parseFeaturePremiumKey);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private Object connectToServer(String str, int i, int i2) {
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
                    String str2 = this.tag;
                    Log.i(str2, "Server Response:" + sb.toString());
                    return sb.toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Object connectToServer(String str, ArrayList<NameValuePair> arrayList, int i, int i2) {
        if (str == null) {
            return null;
        }
        String replaceAll = str.replaceAll(" ", "%20");
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        if (i != -1) {
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, i * 1000);
        }
        if (i2 != -1) {
            HttpConnectionParams.setSoTimeout(basicHttpParams, i2 * 1000);
        }
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
        HttpPost httpPost = new HttpPost(replaceAll);
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList, HttpRequest.CHARSET_UTF8));
            HttpResponse execute = defaultHttpClient.execute(httpPost);
            int statusCode = execute.getStatusLine().getStatusCode();
            return statusCode == 200 ? EntityUtils.toString(execute.getEntity(), HttpRequest.CHARSET_UTF8) : Integer.valueOf(statusCode);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Object getCurrentDate() {
        return connectToServer(this.HOST_SALES + "utils/get_current_date.php", 30, 30);
    }

    public static ProVersionManager getInstant() {
        if (instant == null) {
            instant = new ProVersionManager();
        }
        return instant;
    }

    private Object getProVersionKey(Context context, String str, String str2, String str3, String str4, String str5) {
        if (!checkInternetConnection(context)) {
            return "getProVersionKey: Network Error";
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("CustomerName", str));
        arrayList.add(new BasicNameValuePair("CustomerType", str2));
        arrayList.add(new BasicNameValuePair("ApplicationId", str3));
        arrayList.add(new BasicNameValuePair("IMEI", str4));
        arrayList.add(new BasicNameValuePair("ApplicationVersion", str5));
        arrayList.add(new BasicNameValuePair("Model", Build.MODEL));
        Object connectToServer = connectToServer(this.HOST_SALES + "get_proversion_key_custom_feature.php", arrayList, 300, 300);
        if (connectToServer instanceof Integer) {
            return "Http Error Code : " + connectToServer;
        }
        String str6 = (String) connectToServer;
        if (str6 == null) {
            return "Connection failed";
        }
        Log.i(this.tag, "getProVersionKey: Server Response : " + str6);
        try {
            JSONObject jSONObject = new JSONObject(str6);
            if (!jSONObject.getString(Decrypter.RESULT).equals(Decrypter.RESULT_SUCCESS)) {
                return jSONObject.getString(Decrypter.REASON);
            }
            String str7 = null;
            int i = -1;
            if (jSONObject.has("Key")) {
                str7 = jSONObject.getString("Key");
            }
            if (jSONObject.has("OrderId")) {
                i = jSONObject.getInt("OrderId");
            }
            if (jSONObject.has("Info")) {
                Log.i(this.tag, "Info Purchase = " + jSONObject.getString("Info"));
            }
            if (jSONObject.has("KeyCustomFeature")) {
                String string = jSONObject.getString("KeyCustomFeature");
                Log.i(this.tag, "Custom Feature = " + string);
                context.getSharedPreferences(this.SHARE_FILE, 0).edit().putString(this.SHARE_CUSTOM_FEATURE, string).commit();
            }
            return new ProKey(str7, i);
        } catch (JSONException e) {
            e.printStackTrace();
            return "getProVersionKey: Json Exception";
        }
    }

    private String md5(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void openWebisteWithUrl(Activity activity, String str) {
        if (str != null) {
            try {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00fa A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String parseFeaturePremiumKey(android.content.Context r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            r9 = this;
            r0 = 0
            if (r11 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "publickey/publicKey.der"
            java.security.PublicKey r1 = mdc.licensekeyupgrade.RSACryptography.readPublicKeyFromAssetFile(r10, r1)     // Catch:{ Exception -> 0x000b }
            goto L_0x0010
        L_0x000b:
            r1 = move-exception
            r1.printStackTrace()
            r1 = r0
        L_0x0010:
            r2 = 0
            if (r1 != 0) goto L_0x001d
            java.lang.String r10 = r9.tag
            java.lang.String r11 = "prokey: public key error"
            android.util.Log.i(r10, r11)
            r9.bPro = r2
            return r0
        L_0x001d:
            java.lang.String r10 = mdc.licensekeyupgrade.RSACryptography.decryptWithPublicKey(r10, r11, r1)
            java.lang.String r11 = r9.tag
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "prokey: plaint text = "
            r1.append(r3)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            android.util.Log.i(r11, r1)
            if (r10 != 0) goto L_0x0043
            java.lang.String r10 = r9.tag
            java.lang.String r11 = "prokey: parse key error"
            android.util.Log.i(r10, r11)
            r9.bPro = r2
            return r0
        L_0x0043:
            java.util.StringTokenizer r11 = new java.util.StringTokenizer
            java.lang.String r1 = "\n"
            r11.<init>(r10, r1)
            int r10 = r11.countTokens()
        L_0x004e:
            boolean r1 = r11.hasMoreTokens()
            if (r1 == 0) goto L_0x0109
            java.lang.String r1 = r11.nextToken()
            if (r2 != 0) goto L_0x0070
            java.lang.String r1 = r1.toLowerCase()
            java.lang.String r3 = r12.toLowerCase()
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0105
            java.lang.String r10 = r9.tag
            java.lang.String r11 = "prokey: email not match"
            android.util.Log.i(r10, r11)
            return r0
        L_0x0070:
            r3 = 1
            if (r2 != r3) goto L_0x0081
            boolean r1 = r1.equals(r13)
            if (r1 != 0) goto L_0x0105
            java.lang.String r10 = r9.tag
            java.lang.String r11 = "prokey: Application id not match"
            android.util.Log.i(r10, r11)
            return r0
        L_0x0081:
            r3 = 2
            r4 = 3
            if (r2 != r3) goto L_0x0102
            java.lang.String r3 = "0000-00-00"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0099
            java.lang.String r1 = r9.tag
            java.lang.String r3 = "prokey: key vaild"
            android.util.Log.i(r1, r3)
            if (r10 != r4) goto L_0x0105
            java.lang.String r10 = "PREMIUM"
            return r10
        L_0x0099:
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat
            java.lang.String r5 = "yyyy-MM-dd"
            r3.<init>(r5)
            java.util.Date r1 = r3.parse(r1)     // Catch:{ ParseException -> 0x00a5 }
            goto L_0x00aa
        L_0x00a5:
            r1 = move-exception
            r1.printStackTrace()
            r1 = r0
        L_0x00aa:
            if (r1 != 0) goto L_0x00b4
            java.lang.String r10 = r9.tag
            java.lang.String r11 = "prokey: parse expired date error"
            android.util.Log.i(r10, r11)
            return r0
        L_0x00b4:
            java.lang.Object r5 = r9.getCurrentDate()
            boolean r6 = r5 instanceof java.lang.String
            if (r6 == 0) goto L_0x00dd
            java.lang.String r6 = r9.tag
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "prokey: current date from server:"
            r7.append(r8)
            r7.append(r5)
            java.lang.String r7 = r7.toString()
            android.util.Log.i(r6, r7)
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ ParseException -> 0x00d9 }
            java.util.Date r3 = r3.parse(r5)     // Catch:{ ParseException -> 0x00d9 }
            goto L_0x00de
        L_0x00d9:
            r3 = move-exception
            r3.printStackTrace()
        L_0x00dd:
            r3 = r0
        L_0x00de:
            if (r3 != 0) goto L_0x00e8
            java.util.Calendar r3 = java.util.Calendar.getInstance()
            java.util.Date r3 = r3.getTime()
        L_0x00e8:
            boolean r1 = r3.before(r1)
            if (r1 == 0) goto L_0x00fa
            java.lang.String r1 = r9.tag
            java.lang.String r3 = "prokey: key vaild"
            android.util.Log.i(r1, r3)
            if (r10 != r4) goto L_0x0105
            java.lang.String r10 = "PREMIUM"
            return r10
        L_0x00fa:
            java.lang.String r10 = r9.tag
            java.lang.String r11 = "prokey: key invaild"
            android.util.Log.i(r10, r11)
            return r0
        L_0x0102:
            if (r2 != r4) goto L_0x0105
            return r1
        L_0x0105:
            int r2 = r2 + 1
            goto L_0x004e
        L_0x0109:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: mdc.licensekeyupgrade.ProVersionManager.parseFeaturePremiumKey(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parseKey(android.content.Context r7, java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
            r6 = this;
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            java.lang.String r1 = "publickey/publicKey.der"
            java.security.PublicKey r1 = mdc.licensekeyupgrade.RSACryptography.readPublicKeyFromAssetFile(r7, r1)     // Catch:{ Exception -> 0x000b }
            goto L_0x0010
        L_0x000b:
            r1 = move-exception
            r1.printStackTrace()
            r1 = r0
        L_0x0010:
            r2 = 0
            if (r1 != 0) goto L_0x001d
            java.lang.String r7 = r6.tag
            java.lang.String r8 = "prokey: public key error"
            android.util.Log.i(r7, r8)
            r6.bPro = r2
            return
        L_0x001d:
            java.lang.String r7 = mdc.licensekeyupgrade.RSACryptography.decryptWithPublicKey(r7, r8, r1)
            java.lang.String r8 = r6.tag
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "prokey: plaint text = "
            r1.append(r3)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            android.util.Log.i(r8, r1)
            if (r7 != 0) goto L_0x0043
            java.lang.String r7 = r6.tag
            java.lang.String r8 = "prokey: parse key error"
            android.util.Log.i(r7, r8)
            r6.bPro = r2
            return
        L_0x0043:
            java.util.StringTokenizer r8 = new java.util.StringTokenizer
            java.lang.String r1 = "\n"
            r8.<init>(r7, r1)
            r1 = r0
            r7 = 0
        L_0x004c:
            boolean r3 = r8.hasMoreTokens()
            r4 = 1
            if (r3 == 0) goto L_0x009c
            java.lang.String r3 = r8.nextToken()
            if (r7 != 0) goto L_0x0071
            java.lang.String r3 = r3.toLowerCase()
            java.lang.String r4 = r9.toLowerCase()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0099
            java.lang.String r7 = r6.tag
            java.lang.String r8 = "prokey: email not match"
            android.util.Log.i(r7, r8)
            r6.bPro = r2
            return
        L_0x0071:
            if (r7 != r4) goto L_0x0083
            boolean r3 = r3.equals(r10)
            if (r3 != 0) goto L_0x0099
            java.lang.String r7 = r6.tag
            java.lang.String r8 = "prokey: Application id not match"
            android.util.Log.i(r7, r8)
            r6.bPro = r2
            return
        L_0x0083:
            r5 = 2
            if (r7 != r5) goto L_0x0099
            java.lang.String r1 = "0000-00-00"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0098
            java.lang.String r7 = r6.tag
            java.lang.String r8 = "prokey: key vaild"
            android.util.Log.i(r7, r8)
            r6.bPro = r4
            return
        L_0x0098:
            r1 = r3
        L_0x0099:
            int r7 = r7 + 1
            goto L_0x004c
        L_0x009c:
            java.text.SimpleDateFormat r7 = new java.text.SimpleDateFormat
            java.lang.String r8 = "yyyy-MM-dd"
            r7.<init>(r8)
            java.util.Date r8 = r7.parse(r1)     // Catch:{ ParseException -> 0x00a8 }
            goto L_0x00ad
        L_0x00a8:
            r8 = move-exception
            r8.printStackTrace()
            r8 = r0
        L_0x00ad:
            if (r8 != 0) goto L_0x00b9
            java.lang.String r7 = r6.tag
            java.lang.String r8 = "prokey: parse expired date error"
            android.util.Log.i(r7, r8)
            r6.bPro = r2
            return
        L_0x00b9:
            java.lang.Object r9 = r6.getCurrentDate()
            boolean r10 = r9 instanceof java.lang.String
            if (r10 == 0) goto L_0x00e2
            java.lang.String r10 = r6.tag
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "prokey: current date from server:"
            r1.append(r3)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            android.util.Log.i(r10, r1)
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ ParseException -> 0x00de }
            java.util.Date r7 = r7.parse(r9)     // Catch:{ ParseException -> 0x00de }
            goto L_0x00e3
        L_0x00de:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00e2:
            r7 = r0
        L_0x00e3:
            if (r7 != 0) goto L_0x00ed
            java.util.Calendar r7 = java.util.Calendar.getInstance()
            java.util.Date r7 = r7.getTime()
        L_0x00ed:
            boolean r7 = r7.before(r8)
            if (r7 == 0) goto L_0x00fd
            java.lang.String r7 = r6.tag
            java.lang.String r8 = "prokey: key vaild"
            android.util.Log.i(r7, r8)
            r6.bPro = r4
            goto L_0x0106
        L_0x00fd:
            java.lang.String r7 = r6.tag
            java.lang.String r8 = "prokey: key invaild"
            android.util.Log.i(r7, r8)
            r6.bPro = r2
        L_0x0106:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: mdc.licensekeyupgrade.ProVersionManager.parseKey(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public Object upgradeProVersionByLicenseKey(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        String str7;
        if (!checkInternetConnection(context)) {
            return "Network Error";
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("CustomerName", str));
        arrayList.add(new BasicNameValuePair("CustomerType", str2));
        arrayList.add(new BasicNameValuePair("ApplicationId", str3));
        arrayList.add(new BasicNameValuePair("HashKey", md5(str4)));
        arrayList.add(new BasicNameValuePair("Md5Imei", md5(str5)));
        arrayList.add(new BasicNameValuePair("ApplicationVersion", str6));
        Object connectToServer = connectToServer(this.HOST_SALES + "licensekey/upgrade_app.php", arrayList, 300, 300);
        if (connectToServer instanceof Integer) {
            return "Http Error Code : " + connectToServer;
        }
        String str8 = (String) connectToServer;
        if (str8 == null) {
            return "Server Internal Error";
        }
        Log.i(this.tag, "Server Response = " + str8);
        try {
            JSONObject jSONObject = new JSONObject(str8);
            if (jSONObject.getInt(Decrypter.RESULT) == 0) {
                if (jSONObject.has("Ex-Order") && this.oldDeviceDelegate != null) {
                    this.oldDeviceDelegate.onOldDevices(jSONObject.getJSONArray("Ex-Order"));
                }
                return jSONObject.getString(Decrypter.REASON);
            }
            int i = -1;
            String str9 = null;
            if (jSONObject.has("Key")) {
                str9 = jSONObject.getString("Key");
                str7 = parseFeaturePremiumKey(context, str9, str, str3);
                Log.i(this.tag, "Thêm 1 tính năng pro:" + str7);
                if (this.featurePremiumList == null) {
                    this.featurePremiumList = new ArrayList();
                }
                if (!this.featurePremiumList.contains(str7)) {
                    this.featurePremiumList.add(str7);
                }
            } else {
                str7 = null;
            }
            if (jSONObject.has("OrderId")) {
                i = jSONObject.getInt("OrderId");
            }
            return new ProKey(str9, i, str7);
        } catch (JSONException e) {
            e.printStackTrace();
            return "JsonException";
        }
    }

    public void activeLicenseKey(final Activity activity, String str, String str2, String str3, String str4, IProVersionDelegate iProVersionDelegate, String str5) {
        Activity activity2 = activity;
        String str6 = str5;
        if (str6 != null) {
            final String upperCase = str6.replaceAll("-", "").toUpperCase();
            if (upperCase.length() < 25) {
                SnackBarUtils.show(activity, "Key is Invalid");
                return;
            }
            AsyncTask asyncTask = new AsyncTask(activity);
            asyncTask.configProcessDialog(0, false, false, false, activity.getResources().getString(C1731R.string.proccessing));
            asyncTask.setRunImmediately(true);
            final IProVersionDelegate iProVersionDelegate2 = iProVersionDelegate;
            asyncTask.setOnCompleteTaskListener(new AsyncTask.setOnCompeteTask() {
                public void onComplete(int i, Activity activity, Object obj) {
                    if (obj instanceof String) {
                        SnackBarUtils.show(activity, (String) obj);
                    }
                    if (iProVersionDelegate2 != null) {
                        String str = null;
                        if (obj instanceof ProKey) {
                            str = ((ProKey) obj).feature;
                        }
                        iProVersionDelegate2.onCheckKeyComplete(ProVersionManager.this, str);
                    }
                }
            });
            final Activity activity3 = activity;
            final String str7 = str;
            final String str8 = str2;
            final String str9 = str4;
            final String str10 = str3;
            asyncTask.start((Object) null, (AsyncTask.ITask) new AsyncTask.ITask() {
                public Object executeTask(Object obj) {
                    Object access$000 = ProVersionManager.this.upgradeProVersionByLicenseKey(activity3, str7, str8, str9, upperCase, ProVersionManager.this.getUUID(activity3), str10);
                    if (access$000 instanceof ProKey) {
                        ProKey proKey = (ProKey) access$000;
                        String key = proKey.getKey();
                        int orderId = proKey.getOrderId();
                        activity3.getSharedPreferences(ProVersionManager.this.SHARE_FILE, 0).edit().putString(ProVersionManager.this.SHARE_PRO_KEY, key).commit();
                        activity3.getSharedPreferences(ProVersionManager.this.SHARE_FILE, 0).edit().putInt(ProVersionManager.this.SHARE_ORDER_ID, orderId).commit();
                    }
                    return access$000;
                }
            });
        }
    }

    public void addFeature(String str) {
        if (this.featurePremiumList == null) {
            this.featurePremiumList = new ArrayList();
        }
        if (!this.featurePremiumList.contains(str)) {
            String str2 = this.tag;
            Log.i(str2, "add feature:" + str);
            this.featurePremiumList.add(str);
        }
    }

    public void buyLicenseKey(Activity activity, String str, String str2) {
        openWebisteWithUrl(activity, (this.HOST_SALES + "licensekey/buy_licensekey.php?") + "&ApplicationVersion=" + str2 + "&ApplicationId=" + str);
    }

    public boolean checkFeature(String str) {
        if (isPro()) {
            return true;
        }
        return this.featurePremiumList != null && this.featurePremiumList.contains(str);
    }

    public void checkProVersion(Context context, String str, String str2, String str3, String str4, String str5, IProVersionDelegate iProVersionDelegate) {
        this.sError = null;
        checkKey(context, str, str3);
        Object proVersionKey = getProVersionKey(context, str, str2, str3, str5, str4);
        if (proVersionKey instanceof ProKey) {
            ProKey proKey = (ProKey) proVersionKey;
            String key = proKey.getKey();
            int orderId = proKey.getOrderId();
            context.getSharedPreferences(this.SHARE_FILE, 0).edit().putString(this.SHARE_PRO_KEY, key).commit();
            context.getSharedPreferences(this.SHARE_FILE, 0).edit().putInt(this.SHARE_ORDER_ID, orderId).commit();
            checkKey(context, str, str3);
        } else if (proVersionKey instanceof String) {
            String str6 = this.tag;
            Log.i(str6, "prokey : get pro version key on server return :" + proVersionKey);
            this.sError = (String) proVersionKey;
            this.bPro = false;
        }
        if (iProVersionDelegate != null) {
            iProVersionDelegate.onCheckKeyComplete(this, (String) null);
        }
    }

    public void checkProVersionInAsyncTask(Context context, boolean z, String str, String str2, String str3, String str4, String str5, IProVersionDelegate iProVersionDelegate) {
        AsyncTask asyncTask = new AsyncTask(context);
        if (z) {
            asyncTask.configProcessDialog(0, false, false, false, "Checking...");
        }
        final Context context2 = context;
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str3;
        final String str9 = str4;
        final String str10 = str5;
        final IProVersionDelegate iProVersionDelegate2 = iProVersionDelegate;
        asyncTask.start((Object) null, (AsyncTask.ITask) new AsyncTask.ITask() {
            public Object executeTask(Object obj) {
                ProVersionManager.getInstant().checkProVersion(context2, str6, str7, str8, str9, str10, iProVersionDelegate2);
                return null;
            }
        });
    }

    public String getAllFeatures() {
        String str = "";
        if (this.featurePremiumList != null) {
            for (String str2 : this.featurePremiumList) {
                str = str + str2 + "\n";
            }
        }
        return str.trim();
    }

    public String getKey(Context context) {
        return context.getSharedPreferences(this.SHARE_FILE, 0).getString(this.SHARE_PRO_KEY, (String) null);
    }

    public int getOrderId(Context context) {
        return context.getSharedPreferences(this.SHARE_FILE, 0).getInt(this.SHARE_ORDER_ID, -1);
    }

    public String getUUID(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public boolean hasFeature(String str) {
        return (str == null || this.featurePremiumList == null || !this.featurePremiumList.contains(str)) ? false : true;
    }

    public boolean hasOnePremium() {
        if (isPro()) {
            return true;
        }
        return this.featurePremiumList != null && this.featurePremiumList.size() > 1;
    }

    public boolean isPro() {
        return (this.featurePremiumList == null || this.featurePremiumList.contains("PREMIUM")) ? true : true;
    }

    public boolean isProVersionExpired(Context context) {
        return false;
    }

    public ProVersionManager setOldDeviceDelegate(IOldDeviceDelegate iOldDeviceDelegate) {
        this.oldDeviceDelegate = iOldDeviceDelegate;
        return this;
    }

    public void showUpgradeKeyDialog(Activity activity, String str, String str2, String str3, String str4, IProVersionDelegate iProVersionDelegate) {
        showUpgradeKeyDialog(activity, str, str2, str3, str4, iProVersionDelegate, (String) null);
    }

    public void showUpgradeKeyDialog(Activity activity, String str, String str2, String str3, String str4, IProVersionDelegate iProVersionDelegate, String str5) {
        Activity activity2 = activity;
        String str6 = str5;
        View inflate = View.inflate(activity, C1731R.layout.dialog_upgrade_by_key, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(C1731R.C1733id.et_key);
        if (str6 != null) {
            editText.setText(str6);
            editText.setSelection(str5.length() - 1);
        } else {
            editText.setSelection(0);
        }
        editText.setGravity(17);
        editText.setInputType(524288);
        editText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        editText.setImeOptions(6);
        editText.setSingleLine(true);
        editText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (i2 <= i3) {
                    String charSequence2 = charSequence.toString();
                    int length = charSequence2.length();
                    if (length == 5 || length == 11 || length == 17 || length == 23) {
                        String str = charSequence2 + "-";
                        editText.setText(str);
                        editText.setSelection(str.length());
                    } else if (length >= 30) {
                        String substring = charSequence2.substring(0, 29);
                        editText.setText(substring);
                        editText.setSelection(substring.length());
                    }
                }
            }
        });
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return true;
            }
        });
        MDCDialog mDCDialog = new MDCDialog(activity, 1);
        mDCDialog.setTitle(activity.getResources().getString(C1731R.string.upgrade_pro));
        mDCDialog.setView(inflate);
        final Activity activity3 = activity;
        final String str7 = str;
        final String str8 = str2;
        final String str9 = str3;
        final String str10 = str4;
        final IProVersionDelegate iProVersionDelegate2 = iProVersionDelegate;
        mDCDialog.setPositiveButton(activity.getResources().getString(C1731R.string.upgrade), new MDCDialog.OnMDCDialogClickListener() {
            public void onClick(MDCDialog mDCDialog, TextView textView) {
                String obj = editText.getText().toString();
                if (obj.equals("")) {
                    SnackBarUtils.show(activity3, "Key Empty");
                } else {
                    ProVersionManager.this.activeLicenseKey(activity3, str7, str8, str9, str10, iProVersionDelegate2, obj);
                }
            }
        });
        mDCDialog.show();
    }
}
