package org.jdom;

/* loaded from: classes5.dex */
public class IllegalDataException extends IllegalArgumentException {
    private static final String CVS_ID = "@(#) $RCSfile: IllegalDataException.java,v $ $Revision: 1.13 $ $Date: 2004/02/06 09:28:30 $ $Name: jdom_1_0 $";

    IllegalDataException(String str, String str2, String str3) {
        super(new StringBuffer().append("The data \"").append(str).append("\" is not legal for a JDOM ").append(str2).append(": ").append(str3).append(".").toString());
    }

    IllegalDataException(String str, String str2) {
        super(new StringBuffer().append("The data \"").append(str).append("\" is not legal for a JDOM ").append(str2).append(".").toString());
    }

    public IllegalDataException(String str) {
        super(str);
    }
}
