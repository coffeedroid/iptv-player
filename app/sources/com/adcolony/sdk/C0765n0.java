package com.adcolony.sdk;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import p017io.fabric.sdk.android.services.common.CommonUtils;

/* renamed from: com.adcolony.sdk.n0 */
class C0765n0 {
    C0765n0() {
    }

    /* renamed from: a */
    public static String m712a(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest instance = MessageDigest.getInstance(CommonUtils.SHA1_INSTANCE);
        instance.update(str.getBytes("iso-8859-1"), 0, str.length());
        return m713a(instance.digest());
    }

    /* renamed from: a */
    private static String m713a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            byte b2 = (b >>> 4) & 15;
            int i = 0;
            while (true) {
                sb.append((char) ((b2 < 0 || b2 > 9) ? (b2 - 10) + 97 : b2 + 48));
                b2 = b & 15;
                int i2 = i + 1;
                if (i >= 1) {
                    break;
                }
                i = i2;
            }
        }
        return sb.toString();
    }
}
