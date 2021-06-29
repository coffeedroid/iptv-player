package org.mozilla.universalchardet.prober.statemachine;

import org.mozilla.universalchardet.Constants;

public class ISO2022CNSMModel extends SMModel {
    public static final int ISO2022CN_CLASS_FACTOR = 9;
    private static int[] iso2022cnCharLenTable = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static int[] iso2022cnClassTable = {PkgInt.pack4bits(2, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 1, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 3, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 4, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2)};
    private static int[] iso2022cnStateTable = {PkgInt.pack4bits(0, 3, 1, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 1, 1, 1, 1, 1, 1, 1), PkgInt.pack4bits(1, 1, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 1, 1, 1, 4, 1), PkgInt.pack4bits(1, 1, 1, 2, 1, 1, 1, 1), PkgInt.pack4bits(5, 6, 1, 1, 1, 1, 1, 1), PkgInt.pack4bits(1, 1, 1, 2, 1, 1, 1, 1), PkgInt.pack4bits(1, 1, 1, 1, 1, 2, 1, 0)};

    public ISO2022CNSMModel() {
        super(new PkgInt(3, 7, 2, 15, iso2022cnClassTable), 9, new PkgInt(3, 7, 2, 15, iso2022cnStateTable), iso2022cnCharLenTable, Constants.CHARSET_ISO_2022_CN);
    }
}
