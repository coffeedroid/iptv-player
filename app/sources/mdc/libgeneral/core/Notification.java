package mdc.libgeneral.core;

import android.text.Html;
import mdc.libgeneral.C1726R;
import org.json.JSONException;
import org.json.JSONObject;

public class Notification {
    public static final int TYPE_MORE_APP = 3;
    public static final int TYPE_NOTIFICATION = 0;
    public static final int TYPE_PROMOTION = 2;
    public static final int TYPE_UPDATE = 1;
    private String content;
    private String format = "text";
    private int idNotification;
    private String startDate;
    private int type;

    public static Notification fromJson(JSONObject jSONObject) throws JSONException {
        Notification notification = new Notification();
        if (jSONObject.has("Id")) {
            notification.setIdNotification(jSONObject.getInt("Id"));
        }
        if (jSONObject.has("Type")) {
            notification.setType(jSONObject.getInt("Type"));
        }
        if (jSONObject.has("Notification")) {
            notification.setContent(jSONObject.getString("Notification"));
        }
        if (jSONObject.has("StartDate")) {
            notification.setStartDate(jSONObject.getString("StartDate"));
        }
        return notification;
    }

    public String getContent() {
        return this.content;
    }

    public String getDes() {
        try {
            JSONObject jSONObject = new JSONObject(this.content);
            return jSONObject.has("text") ? jSONObject.getString("text") : "";
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getFormat() {
        try {
            JSONObject jSONObject = new JSONObject(this.content);
            if (jSONObject.has("format")) {
                this.format = jSONObject.getString("format");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.format;
    }

    public String getHtml() {
        try {
            JSONObject jSONObject = new JSONObject(this.content);
            return jSONObject.has("text") ? Html.fromHtml(jSONObject.getString("html")).toString() : "";
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public int getIdNotification() {
        return this.idNotification;
    }

    public String getLink() {
        try {
            JSONObject jSONObject = new JSONObject(this.content);
            return jSONObject.has("link") ? jSONObject.getString("link") : "";
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public int getResIdOfThumb() {
        return this.type == 1 ? C1726R.C1727drawable.icon_update : this.type == 2 ? C1726R.C1727drawable.icon_gift : this.type == 3 ? C1726R.C1727drawable.icon_more_apps : C1726R.C1727drawable.icon_news;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getTitle() {
        try {
            JSONObject jSONObject = new JSONObject(this.content);
            return jSONObject.has("title") ? jSONObject.getString("title") : "";
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public int getType() {
        return this.type;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public void setIdNotification(int i) {
        this.idNotification = i;
    }

    public void setStartDate(String str) {
        this.startDate = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
