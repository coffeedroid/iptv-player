package org.mozilla.universalchardet;

import java.io.FileInputStream;
import java.io.PrintStream;
import org.mozilla.universalchardet.prober.CharsetProber;

public class UniversalDetector {
    public static final float MINIMUM_THRESHOLD = 0.2f;
    public static final float SHORTCUT_THRESHOLD = 0.95f;
    private String detectedCharset;
    private boolean done;
    private CharsetProber escCharsetProber = null;
    private boolean gotData;
    private InputState inputState;
    private byte lastChar;
    private CharsetListener listener;
    private CharsetProber[] probers = new CharsetProber[3];
    private boolean start;

    public enum InputState {
        PURE_ASCII,
        ESC_ASCII,
        HIGHBYTE
    }

    public UniversalDetector(CharsetListener charsetListener) {
        this.listener = charsetListener;
        for (int i = 0; i < this.probers.length; i++) {
            this.probers[i] = null;
        }
        reset();
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length != 1) {
            System.out.println("USAGE: java UniversalDetector filename");
            return;
        }
        UniversalDetector universalDetector = new UniversalDetector(new CharsetListener() {
            public void report(String str) {
                PrintStream printStream = System.out;
                printStream.println("charset = " + str);
            }
        });
        byte[] bArr = new byte[4096];
        FileInputStream fileInputStream = new FileInputStream(strArr[0]);
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read <= 0 || universalDetector.isDone()) {
                universalDetector.dataEnd();
            } else {
                universalDetector.handleData(bArr, 0, read);
            }
        }
        universalDetector.dataEnd();
    }

    public void dataEnd() {
        if (this.gotData) {
            if (this.detectedCharset != null) {
                this.done = true;
                if (this.listener != null) {
                    this.listener.report(this.detectedCharset);
                }
            } else if (this.inputState == InputState.HIGHBYTE) {
                float f = 0.0f;
                int i = 0;
                for (int i2 = 0; i2 < this.probers.length; i2++) {
                    float confidence = this.probers[i2].getConfidence();
                    if (confidence > f) {
                        i = i2;
                        f = confidence;
                    }
                }
                if (f > 0.2f) {
                    this.detectedCharset = this.probers[i].getCharSetName();
                    if (this.listener != null) {
                        this.listener.report(this.detectedCharset);
                    }
                }
            } else {
                InputState inputState2 = this.inputState;
                InputState inputState3 = InputState.ESC_ASCII;
            }
        }
    }

    public String getDetectedCharset() {
        return this.detectedCharset;
    }

    public CharsetListener getListener() {
        return this.listener;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleData(byte[] r10, int r11, int r12) {
        /*
            r9 = this;
            boolean r0 = r9.done
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 1
            if (r12 <= 0) goto L_0x000a
            r9.gotData = r0
        L_0x000a:
            boolean r1 = r9.start
            r2 = 0
            r3 = 255(0xff, float:3.57E-43)
            if (r1 == 0) goto L_0x0076
            r9.start = r2
            r1 = 3
            if (r12 <= r1) goto L_0x0076
            byte r1 = r10[r11]
            r1 = r1 & r3
            int r4 = r11 + 1
            byte r4 = r10[r4]
            r4 = r4 & r3
            int r5 = r11 + 2
            byte r5 = r10[r5]
            r5 = r5 & r3
            int r6 = r11 + 3
            byte r6 = r10[r6]
            r6 = r6 & r3
            r7 = 254(0xfe, float:3.56E-43)
            if (r1 == 0) goto L_0x005d
            r8 = 239(0xef, float:3.35E-43)
            if (r1 == r8) goto L_0x0050
            switch(r1) {
                case 254: goto L_0x0042;
                case 255: goto L_0x0034;
                default: goto L_0x0033;
            }
        L_0x0033:
            goto L_0x006f
        L_0x0034:
            if (r4 != r7) goto L_0x003d
            if (r5 != 0) goto L_0x003d
            if (r6 != 0) goto L_0x003d
            java.lang.String r1 = org.mozilla.universalchardet.Constants.CHARSET_UTF_32LE
            goto L_0x005a
        L_0x003d:
            if (r4 != r7) goto L_0x006f
            java.lang.String r1 = org.mozilla.universalchardet.Constants.CHARSET_UTF_16LE
            goto L_0x005a
        L_0x0042:
            if (r4 != r3) goto L_0x004b
            if (r5 != 0) goto L_0x004b
            if (r6 != 0) goto L_0x004b
            java.lang.String r1 = org.mozilla.universalchardet.Constants.CHARSET_X_ISO_10646_UCS_4_3412
            goto L_0x005a
        L_0x004b:
            if (r4 != r3) goto L_0x006f
            java.lang.String r1 = org.mozilla.universalchardet.Constants.CHARSET_UTF_16BE
            goto L_0x005a
        L_0x0050:
            r1 = 187(0xbb, float:2.62E-43)
            if (r4 != r1) goto L_0x006f
            r1 = 191(0xbf, float:2.68E-43)
            if (r5 != r1) goto L_0x006f
            java.lang.String r1 = org.mozilla.universalchardet.Constants.CHARSET_UTF_8
        L_0x005a:
            r9.detectedCharset = r1
            goto L_0x006f
        L_0x005d:
            if (r4 != 0) goto L_0x0066
            if (r5 != r7) goto L_0x0066
            if (r6 != r3) goto L_0x0066
            java.lang.String r1 = org.mozilla.universalchardet.Constants.CHARSET_UTF_32BE
            goto L_0x005a
        L_0x0066:
            if (r4 != 0) goto L_0x006f
            if (r5 != r3) goto L_0x006f
            if (r6 != r7) goto L_0x006f
            java.lang.String r1 = org.mozilla.universalchardet.Constants.CHARSET_X_ISO_10646_UCS_4_2143
            goto L_0x005a
        L_0x006f:
            java.lang.String r1 = r9.detectedCharset
            if (r1 == 0) goto L_0x0076
            r9.done = r0
            return
        L_0x0076:
            int r1 = r11 + r12
            r4 = r11
        L_0x0079:
            if (r4 >= r1) goto L_0x00e5
            byte r5 = r10[r4]
            r5 = r5 & r3
            r6 = r5 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x00c6
            r6 = 160(0xa0, float:2.24E-43)
            if (r5 == r6) goto L_0x00c6
            org.mozilla.universalchardet.UniversalDetector$InputState r5 = r9.inputState
            org.mozilla.universalchardet.UniversalDetector$InputState r6 = org.mozilla.universalchardet.UniversalDetector.InputState.HIGHBYTE
            if (r5 == r6) goto L_0x00e2
            org.mozilla.universalchardet.UniversalDetector$InputState r5 = org.mozilla.universalchardet.UniversalDetector.InputState.HIGHBYTE
            r9.inputState = r5
            org.mozilla.universalchardet.prober.CharsetProber r5 = r9.escCharsetProber
            if (r5 == 0) goto L_0x0097
            r5 = 0
            r9.escCharsetProber = r5
        L_0x0097:
            org.mozilla.universalchardet.prober.CharsetProber[] r5 = r9.probers
            r5 = r5[r2]
            if (r5 != 0) goto L_0x00a6
            org.mozilla.universalchardet.prober.CharsetProber[] r5 = r9.probers
            org.mozilla.universalchardet.prober.MBCSGroupProber r6 = new org.mozilla.universalchardet.prober.MBCSGroupProber
            r6.<init>()
            r5[r2] = r6
        L_0x00a6:
            org.mozilla.universalchardet.prober.CharsetProber[] r5 = r9.probers
            r5 = r5[r0]
            if (r5 != 0) goto L_0x00b5
            org.mozilla.universalchardet.prober.CharsetProber[] r5 = r9.probers
            org.mozilla.universalchardet.prober.SBCSGroupProber r6 = new org.mozilla.universalchardet.prober.SBCSGroupProber
            r6.<init>()
            r5[r0] = r6
        L_0x00b5:
            org.mozilla.universalchardet.prober.CharsetProber[] r5 = r9.probers
            r6 = 2
            r5 = r5[r6]
            if (r5 != 0) goto L_0x00e2
            org.mozilla.universalchardet.prober.CharsetProber[] r5 = r9.probers
            org.mozilla.universalchardet.prober.Latin1Prober r7 = new org.mozilla.universalchardet.prober.Latin1Prober
            r7.<init>()
            r5[r6] = r7
            goto L_0x00e2
        L_0x00c6:
            org.mozilla.universalchardet.UniversalDetector$InputState r6 = r9.inputState
            org.mozilla.universalchardet.UniversalDetector$InputState r7 = org.mozilla.universalchardet.UniversalDetector.InputState.PURE_ASCII
            if (r6 != r7) goto L_0x00de
            r6 = 27
            if (r5 == r6) goto L_0x00da
            r6 = 123(0x7b, float:1.72E-43)
            if (r5 != r6) goto L_0x00de
            byte r5 = r9.lastChar
            r6 = 126(0x7e, float:1.77E-43)
            if (r5 != r6) goto L_0x00de
        L_0x00da:
            org.mozilla.universalchardet.UniversalDetector$InputState r5 = org.mozilla.universalchardet.UniversalDetector.InputState.ESC_ASCII
            r9.inputState = r5
        L_0x00de:
            byte r5 = r10[r4]
            r9.lastChar = r5
        L_0x00e2:
            int r4 = r4 + 1
            goto L_0x0079
        L_0x00e5:
            org.mozilla.universalchardet.UniversalDetector$InputState r1 = r9.inputState
            org.mozilla.universalchardet.UniversalDetector$InputState r3 = org.mozilla.universalchardet.UniversalDetector.InputState.ESC_ASCII
            if (r1 != r3) goto L_0x010b
            org.mozilla.universalchardet.prober.CharsetProber r1 = r9.escCharsetProber
            if (r1 != 0) goto L_0x00f6
            org.mozilla.universalchardet.prober.EscCharsetProber r1 = new org.mozilla.universalchardet.prober.EscCharsetProber
            r1.<init>()
            r9.escCharsetProber = r1
        L_0x00f6:
            org.mozilla.universalchardet.prober.CharsetProber r1 = r9.escCharsetProber
            org.mozilla.universalchardet.prober.CharsetProber$ProbingState r10 = r1.handleData(r10, r11, r12)
            org.mozilla.universalchardet.prober.CharsetProber$ProbingState r11 = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.FOUND_IT
            if (r10 != r11) goto L_0x0132
            r9.done = r0
            org.mozilla.universalchardet.prober.CharsetProber r10 = r9.escCharsetProber
            java.lang.String r10 = r10.getCharSetName()
            r9.detectedCharset = r10
            goto L_0x0132
        L_0x010b:
            org.mozilla.universalchardet.UniversalDetector$InputState r1 = r9.inputState
            org.mozilla.universalchardet.UniversalDetector$InputState r3 = org.mozilla.universalchardet.UniversalDetector.InputState.HIGHBYTE
            if (r1 != r3) goto L_0x0132
        L_0x0111:
            org.mozilla.universalchardet.prober.CharsetProber[] r1 = r9.probers
            int r1 = r1.length
            if (r2 >= r1) goto L_0x0132
            org.mozilla.universalchardet.prober.CharsetProber[] r1 = r9.probers
            r1 = r1[r2]
            org.mozilla.universalchardet.prober.CharsetProber$ProbingState r1 = r1.handleData(r10, r11, r12)
            org.mozilla.universalchardet.prober.CharsetProber$ProbingState r3 = org.mozilla.universalchardet.prober.CharsetProber.ProbingState.FOUND_IT
            if (r1 != r3) goto L_0x012f
            r9.done = r0
            org.mozilla.universalchardet.prober.CharsetProber[] r10 = r9.probers
            r10 = r10[r2]
            java.lang.String r10 = r10.getCharSetName()
            r9.detectedCharset = r10
            return
        L_0x012f:
            int r2 = r2 + 1
            goto L_0x0111
        L_0x0132:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.universalchardet.UniversalDetector.handleData(byte[], int, int):void");
    }

    public boolean isDone() {
        return this.done;
    }

    public void reset() {
        this.done = false;
        this.start = true;
        this.detectedCharset = null;
        this.gotData = false;
        this.inputState = InputState.PURE_ASCII;
        this.lastChar = 0;
        if (this.escCharsetProber != null) {
            this.escCharsetProber.reset();
        }
        for (int i = 0; i < this.probers.length; i++) {
            if (this.probers[i] != null) {
                this.probers[i].reset();
            }
        }
    }

    public void setListener(CharsetListener charsetListener) {
        this.listener = charsetListener;
    }
}
