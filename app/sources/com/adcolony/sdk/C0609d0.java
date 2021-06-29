package com.adcolony.sdk;

import android.os.Bundle;
import java.util.HashMap;

/* renamed from: com.adcolony.sdk.d0 */
class C0609d0 {

    /* renamed from: a */
    private static int f348a = 0;

    /* renamed from: b */
    private static HashMap<String, Integer> f349b = new HashMap<>();

    /* renamed from: c */
    private static HashMap<String, Integer> f350c = new HashMap<>();

    /* renamed from: d */
    static final int f351d = 5;

    /* renamed from: e */
    static final int f352e = 1;

    /* renamed from: f */
    static final int f353f = 3;

    /* renamed from: g */
    static final int f354g = 0;

    /* renamed from: h */
    static final int f355h = 1;

    C0609d0() {
    }

    /* renamed from: a */
    static boolean m233a(int i, Bundle bundle) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (i != 0) {
            if (i != 1 || bundle == null) {
                return false;
            }
            String string = bundle.getString("zone_id");
            if (f349b.get(string) == null) {
                f349b.put(string, Integer.valueOf(currentTimeMillis));
            }
            if (f350c.get(string) == null) {
                f350c.put(string, 0);
            }
            if (currentTimeMillis - f349b.get(string).intValue() > 1) {
                f350c.put(string, 1);
                f349b.put(string, Integer.valueOf(currentTimeMillis));
                return false;
            }
            int intValue = f350c.get(string).intValue() + 1;
            f350c.put(string, Integer.valueOf(intValue));
            return intValue > 3;
        } else if (currentTimeMillis - f348a < 5) {
            return true;
        } else {
            f348a = currentTimeMillis;
            return false;
        }
    }
}
