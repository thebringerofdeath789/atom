package org.jdom;

import org.jdom.output.XMLOutputter;

/* loaded from: classes5.dex */
public class DocType extends Content {
    private static final String CVS_ID = "@(#) $RCSfile: DocType.java,v $ $Revision: 1.31 $ $Date: 2004/02/27 11:32:57 $ $Name: jdom_1_0 $";
    protected String elementName;
    protected String internalSubset;
    protected String publicID;
    protected String systemID;

    @Override // org.jdom.Content
    public String getValue() {
        return "";
    }

    protected DocType() {
    }

    public DocType(String str, String str2, String str3) {
        setElementName(str);
        setPublicID(str2);
        setSystemID(str3);
    }

    public DocType(String str, String str2) {
        this(str, null, str2);
    }

    public DocType(String str) {
        this(str, null, null);
    }

    public String getElementName() {
        return this.elementName;
    }

    public DocType setElementName(String str) {
        String checkXMLName = Verifier.checkXMLName(str);
        if (checkXMLName != null) {
            throw new IllegalNameException(str, "DocType", checkXMLName);
        }
        this.elementName = str;
        return this;
    }

    public String getPublicID() {
        return this.publicID;
    }

    public DocType setPublicID(String str) {
        String checkPublicID = Verifier.checkPublicID(str);
        if (checkPublicID != null) {
            throw new IllegalDataException(str, "DocType", checkPublicID);
        }
        this.publicID = str;
        return this;
    }

    public String getSystemID() {
        return this.systemID;
    }

    public DocType setSystemID(String str) {
        String checkSystemLiteral = Verifier.checkSystemLiteral(str);
        if (checkSystemLiteral != null) {
            throw new IllegalDataException(str, "DocType", checkSystemLiteral);
        }
        this.systemID = str;
        return this;
    }

    public void setInternalSubset(String str) {
        this.internalSubset = str;
    }

    public String getInternalSubset() {
        return this.internalSubset;
    }

    public String toString() {
        return new StringBuffer().append("[DocType: ").append(new XMLOutputter().outputString(this)).append("]").toString();
    }
}
