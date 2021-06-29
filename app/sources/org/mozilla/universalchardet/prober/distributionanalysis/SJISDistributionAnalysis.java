package org.mozilla.universalchardet.prober.distributionanalysis;

public class SJISDistributionAnalysis extends JISDistributionAnalysis {
    public static final int HIGHBYTE_BEGIN_1 = 129;
    public static final int HIGHBYTE_BEGIN_2 = 224;
    public static final int HIGHBYTE_END_1 = 159;
    public static final int HIGHBYTE_END_2 = 239;
    public static final int LOWBYTE_BEGIN_1 = 64;
    public static final int LOWBYTE_BEGIN_2 = 128;

    /* access modifiers changed from: protected */
    public int getOrder(byte[] bArr, int i) {
        int i2;
        byte b = bArr[i] & 255;
        if (b >= 129 && b <= 159) {
            i2 = b - 129;
        } else if (b < 224 || b > 239) {
            return -1;
        } else {
            i2 = (b - 224) + 31;
        }
        int i3 = i2 * 188;
        byte b2 = bArr[i + 1] & 255;
        int i4 = i3 + (b2 - 64);
        return b2 >= 128 ? i4 - 1 : i4;
    }
}
