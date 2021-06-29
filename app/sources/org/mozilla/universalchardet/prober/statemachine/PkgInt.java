package org.mozilla.universalchardet.prober.statemachine;

public class PkgInt {
    public static final int BIT_SHIFT_16BITS = 4;
    public static final int BIT_SHIFT_4BITS = 2;
    public static final int BIT_SHIFT_8BITS = 3;
    public static final int INDEX_SHIFT_16BITS = 1;
    public static final int INDEX_SHIFT_4BITS = 3;
    public static final int INDEX_SHIFT_8BITS = 2;
    public static final int SHIFT_MASK_16BITS = 1;
    public static final int SHIFT_MASK_4BITS = 7;
    public static final int SHIFT_MASK_8BITS = 3;
    public static final int UNIT_MASK_16BITS = 65535;
    public static final int UNIT_MASK_4BITS = 15;
    public static final int UNIT_MASK_8BITS = 255;
    private int bitShift;
    private int[] data;
    private int indexShift;
    private int shiftMask;
    private int unitMask;

    public PkgInt(int i, int i2, int i3, int i4, int[] iArr) {
        this.indexShift = i;
        this.shiftMask = i2;
        this.bitShift = i3;
        this.unitMask = i4;
        this.data = iArr;
    }

    public static int pack16bits(int i, int i2) {
        return i | (i2 << 16);
    }

    public static int pack4bits(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return pack8bits(i | (i2 << 4), (i4 << 4) | i3, (i6 << 4) | i5, (i8 << 4) | i7);
    }

    public static int pack8bits(int i, int i2, int i3, int i4) {
        return pack16bits(i | (i2 << 8), (i4 << 8) | i3);
    }

    public int unpack(int i) {
        return (this.data[i >> this.indexShift] >> ((i & this.shiftMask) << this.bitShift)) & this.unitMask;
    }
}
