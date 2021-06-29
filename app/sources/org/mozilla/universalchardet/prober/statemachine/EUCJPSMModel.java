package org.mozilla.universalchardet.prober.statemachine;

import org.mozilla.universalchardet.Constants;

public class EUCJPSMModel extends SMModel {
    public static final int EUCJP_CLASS_FACTOR = 6;
    private static int[] eucjpCharLenTable = {2, 2, 2, 3, 1, 0};
    private static int[] eucjpClassTable = {PkgInt.pack4bits(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.pack4bits(4, 4, 4, 4, 4, 4, 5, 5), PkgInt.pack4bits(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.pack4bits(4, 4, 4, 5, 4, 4, 4, 4), PkgInt.pack4bits(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.pack4bits(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.pack4bits(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.pack4bits(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.pack4bits(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.pack4bits(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.pack4bits(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.pack4bits(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.pack4bits(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.pack4bits(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.pack4bits(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.pack4bits(4, 4, 4, 4, 4, 4, 4, 4), PkgInt.pack4bits(5, 5, 5, 5, 5, 5, 5, 5), PkgInt.pack4bits(5, 5, 5, 5, 5, 5, 1, 3), PkgInt.pack4bits(5, 5, 5, 5, 5, 5, 5, 5), PkgInt.pack4bits(5, 5, 5, 5, 5, 5, 5, 5), PkgInt.pack4bits(5, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 5)};
    private static int[] eucjpStateTable = {PkgInt.pack4bits(3, 4, 3, 5, 0, 1, 1, 1), PkgInt.pack4bits(1, 1, 1, 1, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 0, 1, 0, 1, 1, 1), PkgInt.pack4bits(1, 1, 0, 1, 1, 1, 3, 1), PkgInt.pack4bits(3, 1, 1, 1, 0, 0, 0, 0)};

    public EUCJPSMModel() {
        super(new PkgInt(3, 7, 2, 15, eucjpClassTable), 6, new PkgInt(3, 7, 2, 15, eucjpStateTable), eucjpCharLenTable, Constants.CHARSET_EUC_JP);
    }
}
