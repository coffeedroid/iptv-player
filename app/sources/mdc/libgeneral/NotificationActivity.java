package mdc.libgeneral;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mdc.mdcdialog.MDCDialog;
import java.util.List;
import mdc.libgeneral.core.Notification;
import org.json.JSONException;
import org.json.JSONObject;
import p016fi.iki.elonen.NanoHTTPD;
import p017io.fabric.sdk.android.services.network.HttpRequest;

public class NotificationActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {
    AdapterNotification adapterNotification;

    public static class AdapterNotification extends ArrayAdapter<Notification> {
        Activity activity;
        List<Notification> listNotifications;

        public AdapterNotification(@NonNull Activity activity2, @NonNull List<Notification> list) {
            super(activity2, 0, list);
            this.activity = activity2;
            this.listNotifications = list;
        }

        public synchronized int getCount() {
            if (this.listNotifications == null) {
                return 0;
            }
            return this.listNotifications.size();
        }

        @NonNull
        public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
            final Notification notification = this.listNotifications.get(i);
            if (notification.getFormat().equals("text")) {
                if (!(view instanceof LinearLayout)) {
                    view = View.inflate(getContext(), C1726R.layout.row_notification_1, (ViewGroup) null);
                }
                View findViewById = view.findViewById(C1726R.C1728id.v_spot);
                if (NotificationManager.sharedInstant().isWatched(notification.getIdNotification())) {
                    findViewById.setVisibility(8);
                } else {
                    findViewById.setVisibility(0);
                }
                ((TextView) view.findViewById(C1726R.C1728id.tv_title)).setText(notification.getTitle());
                ((TextView) view.findViewById(C1726R.C1728id.tv_des)).setText(notification.getDes());
                ((ImageView) view.findViewById(C1726R.C1728id.iv_thumb)).setImageResource(notification.getResIdOfThumb());
                ((TextView) view.findViewById(C1726R.C1728id.tv_time)).setText(Utils.parseTime(notification.getStartDate()));
            } else {
                if (!(view instanceof RelativeLayout)) {
                    view = View.inflate(getContext(), C1726R.layout.row_webview, (ViewGroup) null);
                }
                WebView webView = (WebView) view.findViewById(C1726R.C1728id.webview);
                webView.getSettings().setDefaultTextEncodingName(HttpRequest.CHARSET_UTF8);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() != 1) {
                            return false;
                        }
                        NotificationManager.sharedInstant().readNotification((double) notification.getIdNotification());
                        try {
                            JSONObject jSONObject = new JSONObject(notification.getContent());
                            if (jSONObject.has("button")) {
                                JSONObject jSONObject2 = jSONObject.getJSONObject("button");
                                if (jSONObject2.has("link")) {
                                    try {
                                        AdapterNotification.this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(jSONObject2.getString("link"))));
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                });
                if (notification.getFormat().equals("html")) {
                    webView.loadData(notification.getHtml(), NanoHTTPD.MIME_HTML, HttpRequest.CHARSET_UTF8);
                } else if (notification.getFormat().equals("link")) {
                    webView.loadUrl(notification.getLink());
                }
            }
            view.setTag(notification);
            return view;
        }
    }

    /* access modifiers changed from: private */
    public static void openWeb(Activity activity, String str) {
        if (str != null) {
            try {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception unused) {
            }
        }
    }

    public static void showNotification(final Activity activity, String str) {
        String str2;
        final String str3;
        try {
            JSONObject jSONObject = new JSONObject(str.replaceAll("\r", ""));
            String string = jSONObject.has("title") ? jSONObject.getString("title") : null;
            String string2 = jSONObject.has("text") ? jSONObject.getString("text") : null;
            if (jSONObject.has("TitleImageUrl")) {
                jSONObject.getString("TitleImageUrl");
            }
            if (jSONObject.has("button")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("button");
                str2 = jSONObject2.has("title") ? jSONObject2.getString("title") : null;
                str3 = jSONObject2.has("link") ? jSONObject2.getString("link") : null;
            } else {
                str3 = null;
                str2 = null;
            }
            if (string2 != null) {
                WebView webView = new WebView(activity);
                webView.setBackgroundColor(0);
                webView.getSettings().setDefaultTextEncodingName("utf-8");
                webView.loadData(string2, NanoHTTPD.MIME_HTML, HttpRequest.CHARSET_UTF8);
                MDCDialog mDCDialog = new MDCDialog(activity, 4);
                mDCDialog.setTitle(string);
                mDCDialog.setView(webView);
                if (str2 == null) {
                    mDCDialog.setPositiveButton("Close", (MDCDialog.OnMDCDialogClickListener) null);
                } else {
                    mDCDialog.setPositiveButton(str2, new MDCDialog.OnMDCDialogClickListener() {
                        public void onClick(MDCDialog mDCDialog, TextView textView) {
                            NotificationActivity.openWeb(activity, str3);
                        }
                    });
                }
                mDCDialog.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onClick(View view) {
        if (view.getId() == C1726R.C1728id.login_btn_back) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1726R.layout.activity_notification);
        int intExtra = getIntent().getIntExtra("Type", 0);
        ListView listView = (ListView) findViewById(C1726R.C1728id.lv_notification);
        this.adapterNotification = new AdapterNotification(this, NotificationManager.sharedInstant().getNotificationsByType(intExtra));
        listView.setAdapter(this.adapterNotification);
        listView.setOnItemClickListener(this);
        listView.setEmptyView(findViewById(C1726R.C1728id.empty));
        ((TextView) findViewById(C1726R.C1728id.tv_title)).setText(getIntent().getStringExtra("Title"));
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Notification notification = (Notification) view.getTag();
        NotificationManager.sharedInstant().readNotification((double) notification.getIdNotification());
        this.adapterNotification.notifyDataSetChanged();
        showNotification(this, notification.getContent());
    }
}
