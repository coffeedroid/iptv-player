package org.mozilla.universalchardet.prober;

import kotlin.jvm.internal.ByteCompanionObject;
import org.mozilla.universalchardet.prober.CharsetProber;

public class MBCSGroupProber extends CharsetProber {
    private int activeNum;
    private int bestGuess;
    private boolean[] isActive = new boolean[7];
    private CharsetProber[] probers = new CharsetProber[7];
    private CharsetProber.ProbingState state;

    public MBCSGroupProber() {
        this.probers[0] = new UTF8Prober();
        this.probers[1] = new SJISProber();
        this.probers[2] = new EUCJPProber();
        this.probers[3] = new GB18030Prober();
        this.probers[4] = new EUCKRProber();
        this.probers[5] = new Big5Prober();
        this.probers[6] = new EUCTWProber();
        reset();
    }

    public String getCharSetName() {
        if (this.bestGuess == -1) {
            getConfidence();
            if (this.bestGuess == -1) {
                this.bestGuess = 0;
            }
        }
        return this.probers[this.bestGuess].getCharSetName();
    }

    public float getConfidence() {
        if (this.state == CharsetProber.ProbingState.FOUND_IT) {
            return 0.99f;
        }
        if (this.state == CharsetProber.ProbingState.NOT_ME) {
            return 0.01f;
        }
        float f = 0.0f;
        for (int i = 0; i < this.probers.length; i++) {
            if (this.isActive[i]) {
                float confidence = this.probers[i].getConfidence();
                if (f < confidence) {
                    this.bestGuess = i;
                    f = confidence;
                }
            }
        }
        return f;
    }

    public CharsetProber.ProbingState getState() {
        return this.state;
    }

    public CharsetProber.ProbingState handleData(byte[] bArr, int i, int i2) {
        CharsetProber.ProbingState probingState;
        byte[] bArr2 = new byte[i2];
        int i3 = i2 + i;
        int i4 = 0;
        boolean z = true;
        while (i < i3) {
            if ((bArr[i] & ByteCompanionObject.MIN_VALUE) != 0) {
                bArr2[i4] = bArr[i];
                i4++;
                z = true;
            } else if (z) {
                bArr2[i4] = bArr[i];
                i4++;
                z = false;
            }
            i++;
        }
        int i5 = 0;
        while (true) {
            if (i5 >= this.probers.length) {
                break;
            }
            if (this.isActive[i5]) {
                CharsetProber.ProbingState handleData = this.probers[i5].handleData(bArr2, 0, i4);
                if (handleData == CharsetProber.ProbingState.FOUND_IT) {
                    this.bestGuess = i5;
                    probingState = CharsetProber.ProbingState.FOUND_IT;
                    break;
                } else if (handleData == CharsetProber.ProbingState.NOT_ME) {
                    this.isActive[i5] = false;
                    this.activeNum--;
                    if (this.activeNum <= 0) {
                        probingState = CharsetProber.ProbingState.NOT_ME;
                        break;
                    }
                } else {
                    continue;
                }
            }
            i5++;
        }
        this.state = probingState;
        return this.state;
    }

    public void reset() {
        this.activeNum = 0;
        for (int i = 0; i < this.probers.length; i++) {
            this.probers[i].reset();
            this.isActive[i] = true;
            this.activeNum++;
        }
        this.bestGuess = -1;
        this.state = CharsetProber.ProbingState.DETECTING;
    }

    public void setOption() {
    }
}
