package org.mozilla.universalchardet.prober.statemachine;

import org.mozilla.universalchardet.Constants;

public class GB18030SMModel extends SMModel {
    public static final int GB18030_CLASS_FACTOR = 7;
    private static int[] gb18030CharLenTable = {0, 1, 1, 1, 1, 1, 2};
    private static int[] gb18030ClassTable = {PkgInt.pack4bits(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.pack4bits(1, 1, 1, 1, 1, 1, 0, 0), PkgInt.pack4bits(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.pack4bits(1, 1, 1, 0, 1, 1, 1, 1), PkgInt.pack4bits(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.pack4bits(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.pack4bits(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.pack4bits(3, 3, 1, 1, 1, 1, 1, 1), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 4), PkgInt.pack4bits(5, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 0)};
    private static int[] gb18030StateTable = {PkgInt.pack4bits(1, 0, 0, 0, 0, 0, 3, 1), PkgInt.pack4bits(1, 1, 1, 1, 1, 1, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 1, 1, 0), PkgInt.pack4bits(4, 1, 0, 0, 1, 1, 1, 1), PkgInt.pack4bits(1, 1, 5, 1, 1, 1, 2, 1), PkgInt.pack4bits(1, 1, 0, 0, 0, 0, 0, 0)};

    public GB18030SMModel() {
        super(new PkgInt(3, 7, 2, 15, gb18030ClassTable), 7, new PkgInt(3, 7, 2, 15, gb18030StateTable), gb18030CharLenTable, Constants.CHARSET_GB18030);
    }
}
