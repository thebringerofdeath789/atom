package org.jdom;

/* loaded from: classes5.dex */
public class EntityRef extends Content {
    private static final String CVS_ID = "@(#) $RCSfile: EntityRef.java,v $ $Revision: 1.21 $ $Date: 2004/02/27 11:32:57 $ $Name: jdom_1_0 $";
    protected String name;
    protected String publicID;
    protected String systemID;

    @Override // org.jdom.Content
    public String getValue() {
        return "";
    }

    protected EntityRef() {
    }

    public EntityRef(String str) {
        this(str, null, null);
    }

    public EntityRef(String str, String str2) {
        this(str, null, str2);
    }

    public EntityRef(String str, String str2, String str3) {
        setName(str);
        setPublicID(str2);
        setSystemID(str3);
    }

    public String getName() {
        return this.name;
    }

    public String getPublicID() {
        return this.publicID;
    }

    public String getSystemID() {
        return this.systemID;
    }

    public EntityRef setName(String str) {
        String checkXMLName = Verifier.checkXMLName(str);
        if (checkXMLName != null) {
            throw new IllegalNameException(str, "EntityRef", checkXMLName);
        }
        this.name = str;
        return this;
    }

    public EntityRef setPublicID(String str) {
        String checkPublicID = Verifier.checkPublicID(str);
        if (checkPublicID != null) {
            throw new IllegalDataException(str, "EntityRef", checkPublicID);
        }
        this.publicID = str;
        return this;
    }

    public EntityRef setSystemID(String str) {
        String checkSystemLiteral = Verifier.checkSystemLiteral(str);
        if (checkSystemLiteral != null) {
            throw new IllegalDataException(str, "EntityRef", checkSystemLiteral);
        }
        this.systemID = str;
        return this;
    }

    public String toString() {
        return new StringBuffer().append("[EntityRef: ").append("&").append(this.name).append(";").append("]").toString();
    }
}
