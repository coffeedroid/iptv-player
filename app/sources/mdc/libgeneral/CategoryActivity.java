package mdc.libgeneral;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import mdc.libgeneral.NotificationActivity;
import mdc.libgeneral.core.Notification;

public class CategoryActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {
    NotificationActivity.AdapterNotification adapterNotification;

    public void onClick(View view) {
        if (view.getId() == C1726R.C1728id.btn_back) {
            finish();
            return;
        }
        int parseInt = Integer.parseInt((String) view.getTag());
        String charSequence = ((TextView) view).getText().toString();
        Intent intent = new Intent(this, NotificationActivity.class);
        intent.putExtra("Type", parseInt);
        intent.putExtra("Title", charSequence);
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1726R.layout.activity_category);
        ListView listView = (ListView) findViewById(C1726R.C1728id.lv_notification);
        this.adapterNotification = new NotificationActivity.AdapterNotification(this, NotificationManager.sharedInstant().getRecentNotifications());
        listView.setOnItemClickListener(this);
        findViewById(C1726R.C1728id.tv_news).setOnClickListener(this);
        findViewById(C1726R.C1728id.tv_promotion).setOnClickListener(this);
        findViewById(C1726R.C1728id.tv_update).setOnClickListener(this);
        findViewById(C1726R.C1728id.tv_more_app).setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) findViewById(C1726R.C1728id.ll_header);
        ((LinearLayout) findViewById(C1726R.C1728id.ll_container)).removeView(linearLayout);
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        listView.addHeaderView(linearLayout);
        listView.setAdapter(this.adapterNotification);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Notification notification = (Notification) view.getTag();
        if (notification != null) {
            NotificationManager.sharedInstant().readNotification((double) notification.getIdNotification());
            this.adapterNotification.notifyDataSetChanged();
            NotificationActivity.showNotification(this, notification.getContent());
        }
    }
}
