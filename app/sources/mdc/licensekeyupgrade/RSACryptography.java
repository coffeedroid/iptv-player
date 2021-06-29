package mdc.licensekeyupgrade;

import android.content.Context;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import p017io.fabric.sdk.android.services.network.HttpRequest;

class RSACryptography {
    private static String SHARE_FILE = "mdc.licensekeyupgrade.RSACryptography";
    private static String SHARE_PUBLIC_KEY = "k_public_key";

    RSACryptography() {
    }

    public static String decryptWithPublicKey(Context context, String str, PublicKey publicKey) {
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(2, publicKey);
            return new String(instance.doFinal(Base64Coder.decode(str)), HttpRequest.CHARSET_UTF8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encryptWithPrivateKey(Context context, String str) {
        try {
            PrivateKey readPrivateKeyFromFile = readPrivateKeyFromFile(context, "/mnt/sdcard/data/private_key.der");
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, readPrivateKeyFromFile);
            return new String(Base64Coder.encode(instance.doFinal(str.getBytes())));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getPlainText() {
        return null;
    }

    public static PublicKey getPublicKey(Context context) throws Exception {
        InputStream open = context.getAssets().open("publickey/publickey.txt");
        byte[] bArr = new byte[512];
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = open.read(bArr, 0, 512);
            if (read == -1) {
                break;
            }
            sb.append(new String(bArr, 0, read));
        }
        open.close();
        String sb2 = sb.toString();
        if (sb2 == null) {
            return null;
        }
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64Coder.decode(sb2)));
    }

    public static PrivateKey readPrivateKeyFromFile(Context context, String str) throws Exception {
        File file = new File(str);
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        byte[] bArr = new byte[((int) file.length())];
        dataInputStream.readFully(bArr);
        dataInputStream.close();
        return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bArr));
    }

    public static PublicKey readPublicKeyFromAssetFile(Context context, String str) throws Exception {
        InputStream open = context.getAssets().open(str);
        DataInputStream dataInputStream = new DataInputStream(open);
        byte[] bArr = new byte[open.available()];
        dataInputStream.readFully(bArr);
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
    }

    public static PublicKey readPublicKeyFromBase64Str(Context context) throws Exception {
        String string = context.getSharedPreferences(SHARE_FILE, 0).getString(SHARE_PUBLIC_KEY, (String) null);
        if (string == null) {
            return null;
        }
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64Coder.decode(string)));
    }
}
