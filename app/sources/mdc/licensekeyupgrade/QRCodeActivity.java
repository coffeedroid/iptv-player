package mdc.licensekeyupgrade;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.p000v4.app.ActivityCompat;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.Toast;
import com.dlazaro66.qrcodereaderview.C0906QRCodeReaderView;

public class QRCodeActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback, C0906QRCodeReaderView.OnQRCodeReadListener {
    private static final int MY_PERMISSION_REQUEST_CAMERA = 0;
    private static float density = -1.0f;
    private static int height = -1;
    static String tag = "QRCodeActivity";
    private static int width = -1;
    private PointOverlayView pointsOverlayView;
    private C0906QRCodeReaderView qrCodeReaderView;

    public static float densityScreen(Activity activity) {
        if (density == -1.0f) {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
            } else {
                defaultDisplay.getMetrics(displayMetrics);
            }
            density = displayMetrics.density;
        }
        return density;
    }

    public static int heightScreen(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        height = displayMetrics.heightPixels;
        return height;
    }

    private void initQRCodeReaderView() {
        this.qrCodeReaderView = (C0906QRCodeReaderView) findViewById(C1731R.C1733id.qrdecoderview);
        this.pointsOverlayView = (PointOverlayView) findViewById(C1731R.C1733id.points_overlay_view);
        this.qrCodeReaderView.setAutofocusInterval(2000);
        this.qrCodeReaderView.setOnQRCodeReadListener(this);
        this.qrCodeReaderView.setBackCamera();
        this.qrCodeReaderView.startCamera();
    }

    private void requestCameraPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.CAMERA")) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 0);
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 0);
    }

    public static int widthScreen(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        width = displayMetrics.widthPixels;
        return width;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1731R.layout.activity_qrcode);
        findViewById(C1731R.C1733id.qrdecoderview).getLayoutParams().height = widthScreen(this);
        if (ActivityCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
            initQRCodeReaderView();
        } else {
            requestCameraPermission();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.qrCodeReaderView != null) {
            this.qrCodeReaderView.stopCamera();
        }
    }

    public void onQRCodeRead(String str, PointF[] pointFArr) {
        this.pointsOverlayView.setPoints(pointFArr);
        Intent intent = new Intent();
        intent.putExtra("LicenseKey", str);
        setResult(-1, intent);
        finish();
    }

    @TargetApi(23)
    @RequiresApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            if (iArr.length == 1 && iArr[0] == 0) {
                Toast.makeText(this, "Camera permission was granted.", 0).show();
                initQRCodeReaderView();
                return;
            }
            Toast.makeText(this, "Camera permission request was denied.", 0).show();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.qrCodeReaderView != null) {
            this.qrCodeReaderView.startCamera();
        }
    }
}
