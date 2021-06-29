package org.mozilla.universalchardet.prober.statemachine;

public class CodingStateMachine {
    protected int currentBytePos;
    protected int currentCharLen;
    protected int currentState = 0;
    protected SMModel model;

    public CodingStateMachine(SMModel sMModel) {
        this.model = sMModel;
    }

    public String getCodingStateMachine() {
        return this.model.getName();
    }

    public int getCurrentCharLen() {
        return this.currentCharLen;
    }

    public int nextState(byte b) {
        int i = this.model.getClass(b);
        if (this.currentState == 0) {
            this.currentBytePos = 0;
            this.currentCharLen = this.model.getCharLen(i);
        }
        this.currentState = this.model.getNextState(i, this.currentState);
        this.currentBytePos++;
        return this.currentState;
    }

    public void reset() {
        this.currentState = 0;
    }
}
