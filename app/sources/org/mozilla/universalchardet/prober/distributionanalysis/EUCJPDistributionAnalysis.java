package org.mozilla.universalchardet.prober.distributionanalysis;

public class EUCJPDistributionAnalysis extends JISDistributionAnalysis {
    public static final int HIGHBYTE_BEGIN = 161;
    public static final int HIGHBYTE_END = 254;
    public static final int LOWBYTE_BEGIN = 161;
    public static final int LOWBYTE_END = 254;

    /* access modifiers changed from: protected */
    public int getOrder(byte[] bArr, int i) {
        byte b = bArr[i] & 255;
        if (b < 161) {
            return -1;
        }
        return (((b - 161) * 94) + (bArr[i + 1] & 255)) - 161;
    }
}
