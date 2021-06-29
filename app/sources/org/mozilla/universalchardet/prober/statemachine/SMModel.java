package org.mozilla.universalchardet.prober.statemachine;

public abstract class SMModel {
    public static final int ERROR = 1;
    public static final int ITSME = 2;
    public static final int START = 0;
    protected int[] charLenTable;
    protected int classFactor;
    protected PkgInt classTable;
    protected String name;
    protected PkgInt stateTable;

    public SMModel(PkgInt pkgInt, int i, PkgInt pkgInt2, int[] iArr, String str) {
        this.classTable = pkgInt;
        this.classFactor = i;
        this.stateTable = pkgInt2;
        this.charLenTable = iArr;
        this.name = str;
    }

    public int getCharLen(int i) {
        return this.charLenTable[i];
    }

    public int getClass(byte b) {
        return this.classTable.unpack(b & 255);
    }

    public String getName() {
        return this.name;
    }

    public int getNextState(int i, int i2) {
        return this.stateTable.unpack((i2 * this.classFactor) + i);
    }
}
