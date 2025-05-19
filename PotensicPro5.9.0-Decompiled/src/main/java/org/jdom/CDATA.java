package org.jdom;

/* loaded from: classes5.dex */
public class CDATA extends Text {
    private static final String CVS_ID = "@(#) $RCSfile: CDATA.java,v $ $Revision: 1.30 $ $Date: 2004/02/27 11:32:57 $ $Name: jdom_1_0 $";

    protected CDATA() {
    }

    public CDATA(String str) {
        setText(str);
    }

    @Override // org.jdom.Text
    public Text setText(String str) {
        if (str == null) {
            this.value = "";
            return this;
        }
        String checkCDATASection = Verifier.checkCDATASection(str);
        if (checkCDATASection != null) {
            throw new IllegalDataException(str, "CDATA section", checkCDATASection);
        }
        this.value = str;
        return this;
    }

    @Override // org.jdom.Text
    public void append(String str) {
        if (str == null) {
            return;
        }
        String checkCDATASection = Verifier.checkCDATASection(str);
        if (checkCDATASection != null) {
            throw new IllegalDataException(str, "CDATA section", checkCDATASection);
        }
        if (this.value == "") {
            this.value = str;
        } else {
            this.value = new StringBuffer(String.valueOf(this.value)).append(str).toString();
        }
    }

    @Override // org.jdom.Text
    public String toString() {
        return new StringBuffer(64).append("[CDATA: ").append(getText()).append("]").toString();
    }
}
