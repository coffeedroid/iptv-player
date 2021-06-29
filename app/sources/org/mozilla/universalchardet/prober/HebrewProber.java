package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;

public class HebrewProber extends CharsetProber {
    public static final int FINAL_KAF = 234;
    public static final int FINAL_MEM = 237;
    public static final int FINAL_NUN = 239;
    public static final int FINAL_PE = 243;
    public static final int FINAL_TSADI = 245;
    public static final int MIN_FINAL_CHAR_DISTANCE = 5;
    public static final float MIN_MODEL_DISTANCE = 0.01f;
    public static final int NORMAL_KAF = 235;
    public static final int NORMAL_MEM = 238;
    public static final int NORMAL_NUN = 240;
    public static final int NORMAL_PE = 244;
    public static final int NORMAL_TSADI = 246;
    public static final byte SPACE = 32;
    private byte beforePrev;
    private int finalCharLogicalScore;
    private int finalCharVisualScore;
    private CharsetProber logicalProber = null;
    private byte prev;
    private CharsetProber visualProber = null;

    public HebrewProber() {
        reset();
    }

    protected static boolean isFinal(byte b) {
        byte b2 = b & 255;
        return b2 == 234 || b2 == 237 || b2 == 239 || b2 == 243 || b2 == 245;
    }

    protected static boolean isNonFinal(byte b) {
        byte b2 = b & 255;
        return b2 == 235 || b2 == 238 || b2 == 240 || b2 == 244;
    }

    public String getCharSetName() {
        int i = this.finalCharLogicalScore - this.finalCharVisualScore;
        if (i >= 5) {
            return Constants.CHARSET_WINDOWS_1255;
        }
        if (i <= -5) {
            return Constants.CHARSET_ISO_8859_8;
        }
        float confidence = this.logicalProber.getConfidence() - this.visualProber.getConfidence();
        return confidence > 0.01f ? Constants.CHARSET_WINDOWS_1255 : confidence < -0.01f ? Constants.CHARSET_ISO_8859_8 : i < 0 ? Constants.CHARSET_ISO_8859_8 : Constants.CHARSET_WINDOWS_1255;
    }

    public float getConfidence() {
        return 0.0f;
    }

    public CharsetProber.ProbingState getState() {
        return (this.logicalProber.getState() == CharsetProber.ProbingState.NOT_ME && this.visualProber.getState() == CharsetProber.ProbingState.NOT_ME) ? CharsetProber.ProbingState.NOT_ME : CharsetProber.ProbingState.DETECTING;
    }

    public CharsetProber.ProbingState handleData(byte[] bArr, int i, int i2) {
        if (getState() == CharsetProber.ProbingState.NOT_ME) {
            return CharsetProber.ProbingState.NOT_ME;
        }
        int i3 = i2 + i;
        while (i < i3) {
            byte b = bArr[i];
            if (b == 32) {
                if (this.beforePrev != 32) {
                    if (isFinal(this.prev)) {
                        this.finalCharLogicalScore++;
                    } else if (!isNonFinal(this.prev)) {
                    }
                }
                this.beforePrev = this.prev;
                this.prev = b;
                i++;
            } else {
                if (this.beforePrev == 32) {
                    if (isFinal(this.prev)) {
                        if (b == 32) {
                        }
                    }
                }
                this.beforePrev = this.prev;
                this.prev = b;
                i++;
            }
            this.finalCharVisualScore++;
            this.beforePrev = this.prev;
            this.prev = b;
            i++;
        }
        return CharsetProber.ProbingState.DETECTING;
    }

    public void reset() {
        this.finalCharLogicalScore = 0;
        this.finalCharVisualScore = 0;
        this.prev = SPACE;
        this.beforePrev = SPACE;
    }

    public void setModalProbers(CharsetProber charsetProber, CharsetProber charsetProber2) {
        this.logicalProber = charsetProber;
        this.visualProber = charsetProber2;
    }

    public void setOption() {
    }
}
