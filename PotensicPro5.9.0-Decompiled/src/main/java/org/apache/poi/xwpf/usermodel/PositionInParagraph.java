package org.apache.poi.xwpf.usermodel;

/* loaded from: classes5.dex */
public class PositionInParagraph {
    private int posChar;
    private int posRun;
    private int posText;

    public PositionInParagraph() {
        this.posRun = 0;
        this.posText = 0;
        this.posChar = 0;
    }

    public PositionInParagraph(int i, int i2, int i3) {
        this.posRun = 0;
        this.posText = 0;
        this.posChar = 0;
        this.posRun = i;
        this.posChar = i3;
        this.posText = i2;
    }

    public int getRun() {
        return this.posRun;
    }

    public void setRun(int i) {
        this.posRun = i;
    }

    public int getText() {
        return this.posText;
    }

    public void setText(int i) {
        this.posText = i;
    }

    public int getChar() {
        return this.posChar;
    }

    public void setChar(int i) {
        this.posChar = i;
    }
}
