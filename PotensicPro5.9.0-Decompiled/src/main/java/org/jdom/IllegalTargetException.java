package org.jdom;

/* loaded from: classes5.dex */
public class IllegalTargetException extends IllegalArgumentException {
    private static final String CVS_ID = "@(#) $RCSfile: IllegalTargetException.java,v $ $Revision: 1.14 $ $Date: 2004/02/06 09:28:30 $ $Name: jdom_1_0 $";

    IllegalTargetException(String str, String str2) {
        super(new StringBuffer().append("The target \"").append(str).append("\" is not legal for JDOM/XML Processing Instructions: ").append(str2).append(".").toString());
    }

    public IllegalTargetException(String str) {
        super(str);
    }
}
