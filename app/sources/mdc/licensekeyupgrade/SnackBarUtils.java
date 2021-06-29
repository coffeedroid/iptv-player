package mdc.licensekeyupgrade;

import android.app.Activity;
import android.widget.Toast;

class SnackBarUtils {
    SnackBarUtils() {
    }

    public static void show(Activity activity, String str) {
        Toast.makeText(activity, str, 1).show();
    }
}
