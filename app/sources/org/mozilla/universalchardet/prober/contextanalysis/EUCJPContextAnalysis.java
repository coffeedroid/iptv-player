package org.mozilla.universalchardet.prober.contextanalysis;

public class EUCJPContextAnalysis extends JapaneseContextAnalysis {
    public static final int FIRSTPLANE_HIGHBYTE_BEGIN = 161;
    public static final int FIRSTPLANE_HIGHBYTE_END = 254;
    public static final int HIRAGANA_HIGHBYTE = 164;
    public static final int HIRAGANA_LOWBYTE_BEGIN = 161;
    public static final int HIRAGANA_LOWBYTE_END = 243;
    public static final int SINGLE_SHIFT_2 = 142;
    public static final int SINGLE_SHIFT_3 = 143;

    /* access modifiers changed from: protected */
    public int getOrder(byte[] bArr, int i) {
        byte b;
        if ((bArr[i] & 255) != 164 || (b = bArr[i + 1] & 255) < 161 || b > 243) {
            return -1;
        }
        return b - 161;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getOrder(org.mozilla.universalchardet.prober.contextanalysis.JapaneseContextAnalysis.Order r5, byte[] r6, int r7) {
        /*
            r4 = this;
            r0 = -1
            r5.order = r0
            r0 = 1
            r5.charLength = r0
            byte r1 = r6[r7]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 161(0xa1, float:2.26E-43)
            r3 = 142(0x8e, float:1.99E-43)
            if (r1 == r3) goto L_0x001d
            if (r1 < r2) goto L_0x0017
            r3 = 254(0xfe, float:3.56E-43)
            if (r1 > r3) goto L_0x0017
            goto L_0x001d
        L_0x0017:
            r3 = 143(0x8f, float:2.0E-43)
            if (r1 != r3) goto L_0x0020
            r3 = 3
            goto L_0x001e
        L_0x001d:
            r3 = 2
        L_0x001e:
            r5.charLength = r3
        L_0x0020:
            r3 = 164(0xa4, float:2.3E-43)
            if (r1 != r3) goto L_0x0032
            int r7 = r7 + r0
            byte r6 = r6[r7]
            r6 = r6 & 255(0xff, float:3.57E-43)
            if (r6 < r2) goto L_0x0032
            r7 = 243(0xf3, float:3.4E-43)
            if (r6 > r7) goto L_0x0032
            int r6 = r6 - r2
            r5.order = r6
        L_0x0032:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.universalchardet.prober.contextanalysis.EUCJPContextAnalysis.getOrder(org.mozilla.universalchardet.prober.contextanalysis.JapaneseContextAnalysis$Order, byte[], int):void");
    }
}
