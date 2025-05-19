package org.jdom;

/* loaded from: classes5.dex */
public class Text extends Content {
    private static final String CVS_ID = "@(#) $RCSfile: Text.java,v $ $Revision: 1.24 $ $Date: 2004/02/27 11:32:57 $ $Name: jdom_1_0 $";
    static final String EMPTY_STRING = "";
    protected String value;

    protected Text() {
    }

    public Text(String str) {
        setText(str);
    }

    public String getText() {
        return this.value;
    }

    public String getTextTrim() {
        return getText().trim();
    }

    public String getTextNormalize() {
        return normalizeString(getText());
    }

    public static String normalizeString(String str) {
        if (str == null) {
            return "";
        }
        char[] charArray = str.toCharArray();
        char[] cArr = new char[charArray.length];
        int i = 0;
        boolean z = true;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (" \t\n\r".indexOf(charArray[i2]) == -1) {
                cArr[i] = charArray[i2];
                i++;
                z = false;
            } else if (!z) {
                cArr[i] = ' ';
                i++;
                z = true;
            }
        }
        if (z && i > 0) {
            i--;
        }
        return new String(cArr, 0, i);
    }

    public Text setText(String str) {
        if (str == null) {
            this.value = "";
            return this;
        }
        String checkCharacterData = Verifier.checkCharacterData(str);
        if (checkCharacterData != null) {
            throw new IllegalDataException(str, "character content", checkCharacterData);
        }
        this.value = str;
        return this;
    }

    public void append(String str) {
        if (str == null) {
            return;
        }
        String checkCharacterData = Verifier.checkCharacterData(str);
        if (checkCharacterData != null) {
            throw new IllegalDataException(str, "character content", checkCharacterData);
        }
        if (str == "") {
            this.value = str;
        } else {
            this.value = new StringBuffer(String.valueOf(this.value)).append(str).toString();
        }
    }

    public void append(Text text) {
        if (text == null) {
            return;
        }
        this.value = new StringBuffer(String.valueOf(this.value)).append(text.getText()).toString();
    }

    @Override // org.jdom.Content
    public String getValue() {
        return this.value;
    }

    public String toString() {
        return new StringBuffer(64).append("[Text: ").append(getText()).append("]").toString();
    }

    @Override // org.jdom.Content, org.jdom.Parent
    public Object clone() {
        Text text = (Text) super.clone();
        text.value = this.value;
        return text;
    }
}
