package org.jdom;

/* loaded from: classes5.dex */
public class IllegalNameException extends IllegalArgumentException {
    private static final String CVS_ID = "@(#) $RCSfile: IllegalNameException.java,v $ $Revision: 1.13 $ $Date: 2004/02/06 09:28:30 $ $Name: jdom_1_0 $";

    IllegalNameException(String str, String str2, String str3) {
        super(new StringBuffer().append("The name \"").append(str).append("\" is not legal for JDOM/XML ").append(str2).append("s: ").append(str3).append(".").toString());
    }

    IllegalNameException(String str, String str2) {
        super(new StringBuffer().append("The name \"").append(str).append("\" is not legal for JDOM/XML ").append(str2).append("s.").toString());
    }

    public IllegalNameException(String str) {
        super(str);
    }
}
