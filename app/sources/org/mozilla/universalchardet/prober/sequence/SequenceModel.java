package org.mozilla.universalchardet.prober.sequence;

public abstract class SequenceModel {
    protected short[] charToOrderMap;
    protected String charsetName;
    protected boolean keepEnglishLetter;
    protected byte[] precedenceMatrix;
    protected float typicalPositiveRatio;

    public SequenceModel(short[] sArr, byte[] bArr, float f, boolean z, String str) {
        this.charToOrderMap = sArr;
        this.precedenceMatrix = bArr;
        this.typicalPositiveRatio = f;
        this.keepEnglishLetter = z;
        this.charsetName = str;
    }

    public String getCharsetName() {
        return this.charsetName;
    }

    public boolean getKeepEnglishLetter() {
        return this.keepEnglishLetter;
    }

    public short getOrder(byte b) {
        return this.charToOrderMap[b & 255];
    }

    public byte getPrecedence(int i) {
        return this.precedenceMatrix[i];
    }

    public float getTypicalPositiveRatio() {
        return this.typicalPositiveRatio;
    }
}
