package org.mozilla.universalchardet.prober.statemachine;

import org.mozilla.universalchardet.Constants;

public class ISO2022JPSMModel extends SMModel {
    public static final int ISO2022JP_CLASS_FACTOR = 10;
    private static int[] iso2022jpCharLenTable = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static int[] iso2022jpClassTable = {PkgInt.pack4bits(2, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 2, 2), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 1, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 7, 0, 0, 0), PkgInt.pack4bits(3, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(6, 0, 4, 0, 8, 0, 0, 0), PkgInt.pack4bits(0, 9, 5, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2)};
    private static int[] iso2022jpStateTable = {PkgInt.pack4bits(0, 3, 1, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 1, 1, 1, 1, 1, 1), PkgInt.pack4bits(1, 1, 1, 1, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 1, 1), PkgInt.pack4bits(1, 5, 1, 1, 1, 4, 1, 1), PkgInt.pack4bits(1, 1, 1, 6, 2, 1, 2, 1), PkgInt.pack4bits(1, 1, 1, 1, 1, 1, 2, 2), PkgInt.pack4bits(1, 1, 1, 2, 1, 1, 1, 1), PkgInt.pack4bits(1, 1, 1, 1, 2, 1, 0, 0)};

    public ISO2022JPSMModel() {
        super(new PkgInt(3, 7, 2, 15, iso2022jpClassTable), 10, new PkgInt(3, 7, 2, 15, iso2022jpStateTable), iso2022jpCharLenTable, Constants.CHARSET_ISO_2022_JP);
    }
}
