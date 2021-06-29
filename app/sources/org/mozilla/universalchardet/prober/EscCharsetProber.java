package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.statemachine.CodingStateMachine;
import org.mozilla.universalchardet.prober.statemachine.HZSMModel;
import org.mozilla.universalchardet.prober.statemachine.ISO2022CNSMModel;
import org.mozilla.universalchardet.prober.statemachine.ISO2022JPSMModel;
import org.mozilla.universalchardet.prober.statemachine.ISO2022KRSMModel;

public class EscCharsetProber extends CharsetProber {
    private static final HZSMModel hzsModel = new HZSMModel();
    private static final ISO2022CNSMModel iso2022cnModel = new ISO2022CNSMModel();
    private static final ISO2022JPSMModel iso2022jpModel = new ISO2022JPSMModel();
    private static final ISO2022KRSMModel iso2022krModel = new ISO2022KRSMModel();
    private int activeSM;
    private CodingStateMachine[] codingSM = new CodingStateMachine[4];
    private String detectedCharset;
    private CharsetProber.ProbingState state;

    public EscCharsetProber() {
        this.codingSM[0] = new CodingStateMachine(hzsModel);
        this.codingSM[1] = new CodingStateMachine(iso2022cnModel);
        this.codingSM[2] = new CodingStateMachine(iso2022jpModel);
        this.codingSM[3] = new CodingStateMachine(iso2022krModel);
        reset();
    }

    public String getCharSetName() {
        return this.detectedCharset;
    }

    public float getConfidence() {
        return 0.99f;
    }

    public CharsetProber.ProbingState getState() {
        return this.state;
    }

    public CharsetProber.ProbingState handleData(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        while (i < i3 && this.state == CharsetProber.ProbingState.DETECTING) {
            int i4 = this.activeSM - 1;
            while (i4 >= 0) {
                int nextState = this.codingSM[i4].nextState(bArr[i]);
                if (nextState == 1) {
                    this.activeSM--;
                    if (this.activeSM <= 0) {
                        this.state = CharsetProber.ProbingState.NOT_ME;
                    } else {
                        if (i4 != this.activeSM) {
                            CodingStateMachine codingStateMachine = this.codingSM[this.activeSM];
                            this.codingSM[this.activeSM] = this.codingSM[i4];
                            this.codingSM[i4] = codingStateMachine;
                        }
                        i4--;
                    }
                } else if (nextState == 2) {
                    this.state = CharsetProber.ProbingState.FOUND_IT;
                    this.detectedCharset = this.codingSM[i4].getCodingStateMachine();
                } else {
                    i4--;
                }
                return this.state;
            }
            i++;
        }
        return this.state;
    }

    public void reset() {
        this.state = CharsetProber.ProbingState.DETECTING;
        for (CodingStateMachine reset : this.codingSM) {
            reset.reset();
        }
        this.activeSM = this.codingSM.length;
        this.detectedCharset = null;
    }

    public void setOption() {
    }
}
