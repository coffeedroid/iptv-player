package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.sequence.HebrewModel;
import org.mozilla.universalchardet.prober.sequence.Ibm855Model;
import org.mozilla.universalchardet.prober.sequence.Ibm866Model;
import org.mozilla.universalchardet.prober.sequence.Koi8rModel;
import org.mozilla.universalchardet.prober.sequence.Latin5BulgarianModel;
import org.mozilla.universalchardet.prober.sequence.Latin5Model;
import org.mozilla.universalchardet.prober.sequence.Latin7Model;
import org.mozilla.universalchardet.prober.sequence.MacCyrillicModel;
import org.mozilla.universalchardet.prober.sequence.SequenceModel;
import org.mozilla.universalchardet.prober.sequence.Win1251BulgarianModel;
import org.mozilla.universalchardet.prober.sequence.Win1251Model;
import org.mozilla.universalchardet.prober.sequence.Win1253Model;

public class SBCSGroupProber extends CharsetProber {
    private static final SequenceModel hebrewModel = new HebrewModel();
    private static final SequenceModel ibm855Model = new Ibm855Model();
    private static final SequenceModel ibm866Model = new Ibm866Model();
    private static final SequenceModel koi8rModel = new Koi8rModel();
    private static final SequenceModel latin5BulgarianModel = new Latin5BulgarianModel();
    private static final SequenceModel latin5Model = new Latin5Model();
    private static final SequenceModel latin7Model = new Latin7Model();
    private static final SequenceModel macCyrillicModel = new MacCyrillicModel();
    private static final SequenceModel win1251BulgarianModel = new Win1251BulgarianModel();
    private static final SequenceModel win1251Model = new Win1251Model();
    private static final SequenceModel win1253Model = new Win1253Model();
    private int activeNum;
    private int bestGuess;
    private boolean[] isActive = new boolean[13];
    private CharsetProber[] probers = new CharsetProber[13];
    private CharsetProber.ProbingState state;

    public SBCSGroupProber() {
        this.probers[0] = new SingleByteCharsetProber(win1251Model);
        this.probers[1] = new SingleByteCharsetProber(koi8rModel);
        this.probers[2] = new SingleByteCharsetProber(latin5Model);
        this.probers[3] = new SingleByteCharsetProber(macCyrillicModel);
        this.probers[4] = new SingleByteCharsetProber(ibm866Model);
        this.probers[5] = new SingleByteCharsetProber(ibm855Model);
        this.probers[6] = new SingleByteCharsetProber(latin7Model);
        this.probers[7] = new SingleByteCharsetProber(win1253Model);
        this.probers[8] = new SingleByteCharsetProber(latin5BulgarianModel);
        this.probers[9] = new SingleByteCharsetProber(win1251BulgarianModel);
        HebrewProber hebrewProber = new HebrewProber();
        this.probers[10] = hebrewProber;
        this.probers[11] = new SingleByteCharsetProber(hebrewModel, false, hebrewProber);
        this.probers[12] = new SingleByteCharsetProber(hebrewModel, true, hebrewProber);
        hebrewProber.setModalProbers(this.probers[11], this.probers[12]);
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

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        r3.state = r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.mozilla.universalchardet.prober.CharsetProber.ProbingState handleData(byte[] r4, int r5, int r6) {
        /*
            r3 = this;
            java.nio.ByteBuffer r4 = r3.filterWithoutEnglishLetters(r4, r5, r6)
            int r5 = r4.position()
            if (r5 != 0) goto L_0x000b
            goto L_0x004c
        L_0x000b:
            r5 = 0
            r6 = 0
        L_0x000d:
            org.mozilla.universalchardet.prober.CharsetProber[] r0 = r3.probers
            int r0 = r0.length
            if (r6 >= r0) goto L_0x004c
            boolean[] r0 = r3.isActive
            boolean r0 = r0[r6]
            if (r0 != 0) goto L_0x0019
            goto L_0x0049
        L_0x0019:
            org.mozilla.universalchardet.prober.CharsetProber[] r0 = r3.probers
            r0 = r0[r6]
            byte[] r1 = r4.array()
            int r2 = r4.position()
            org.mozilla.universalchardet.prober.CharsetProber$ProbingState r0 = r0.handleData(r1, r5, r2)
            org.mozilla.universalchardet.prober.CharsetProber$ProbingState r1 = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.FOUND_IT
            if (r0 != r1) goto L_0x0034
            r3.bestGuess = r6
            org.mozilla.universalchardet.prober.CharsetProber$ProbingState r4 = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.FOUND_IT
        L_0x0031:
            r3.state = r4
            goto L_0x004c
        L_0x0034:
            org.mozilla.universalchardet.prober.CharsetProber$ProbingState r1 = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.NOT_ME
            if (r0 != r1) goto L_0x0049
            boolean[] r0 = r3.isActive
            r0[r6] = r5
            int r0 = r3.activeNum
            int r0 = r0 + -1
            r3.activeNum = r0
            int r0 = r3.activeNum
            if (r0 > 0) goto L_0x0049
            org.mozilla.universalchardet.prober.CharsetProber$ProbingState r4 = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.NOT_ME
            goto L_0x0031
        L_0x0049:
            int r6 = r6 + 1
            goto L_0x000d
        L_0x004c:
            org.mozilla.universalchardet.prober.CharsetProber$ProbingState r4 = r3.state
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.universalchardet.prober.SBCSGroupProber.handleData(byte[], int, int):org.mozilla.universalchardet.prober.CharsetProber$ProbingState");
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
