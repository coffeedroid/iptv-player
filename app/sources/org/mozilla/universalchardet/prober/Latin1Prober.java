package org.mozilla.universalchardet.prober;

import java.nio.ByteBuffer;
import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;

public class Latin1Prober extends CharsetProber {
    public static final byte ACO = 5;
    public static final byte ACV = 4;
    public static final byte ASC = 2;
    public static final byte ASO = 7;
    public static final byte ASS = 3;
    public static final byte ASV = 6;
    public static final int CLASS_NUM = 8;
    public static final int FREQ_CAT_NUM = 4;
    public static final byte OTH = 1;
    public static final byte UDF = 0;
    private static final byte[] latin1CharToClass = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 0, 1, 7, 1, 1, 1, 1, 1, 1, 5, 1, 5, 0, 5, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 7, 0, 7, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 4, 4, 4, 4, 4, 1, 4, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 6, 1, 6, 6, 6, 6, 6, 7, 7, 7};
    private static final byte[] latin1ClassModel = {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 1, 1, 3, 3, 0, 3, 3, 3, 1, 2, 1, 2, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 1, 3, 1, 1, 1, 3, 0, 3, 1, 3, 1, 1, 3, 3};
    private int[] freqCounter = new int[4];
    private byte lastCharClass;
    private CharsetProber.ProbingState state;

    public Latin1Prober() {
        reset();
    }

    public String getCharSetName() {
        return Constants.CHARSET_WINDOWS_1252;
    }

    public float getConfidence() {
        float f;
        if (this.state == CharsetProber.ProbingState.NOT_ME) {
            return 0.01f;
        }
        int i = 0;
        for (int i2 : this.freqCounter) {
            i += i2;
        }
        float f2 = 0.0f;
        if (i <= 0) {
            f = 0.0f;
        } else {
            float f3 = (float) i;
            f = ((((float) this.freqCounter[3]) * 1.0f) / f3) - ((((float) this.freqCounter[1]) * 20.0f) / f3);
        }
        if (f >= 0.0f) {
            f2 = f;
        }
        return f2 * 0.5f;
    }

    public CharsetProber.ProbingState getState() {
        return this.state;
    }

    public CharsetProber.ProbingState handleData(byte[] bArr, int i, int i2) {
        ByteBuffer filterWithEnglishLetters = filterWithEnglishLetters(bArr, i, i2);
        byte[] array = filterWithEnglishLetters.array();
        int position = filterWithEnglishLetters.position();
        int i3 = 0;
        while (true) {
            if (i3 >= position) {
                break;
            }
            byte b = latin1CharToClass[array[i3] & 255];
            byte b2 = latin1ClassModel[(this.lastCharClass * 8) + b];
            if (b2 == 0) {
                this.state = CharsetProber.ProbingState.NOT_ME;
                break;
            }
            int[] iArr = this.freqCounter;
            iArr[b2] = iArr[b2] + 1;
            this.lastCharClass = b;
            i3++;
        }
        return this.state;
    }

    public void reset() {
        this.state = CharsetProber.ProbingState.DETECTING;
        this.lastCharClass = 1;
        for (int i = 0; i < this.freqCounter.length; i++) {
            this.freqCounter[i] = 0;
        }
    }

    public void setOption() {
    }
}
