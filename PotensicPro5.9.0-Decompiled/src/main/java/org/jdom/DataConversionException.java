package org.jdom;

/* loaded from: classes5.dex */
public class DataConversionException extends JDOMException {
    private static final String CVS_ID = "@(#) $RCSfile: DataConversionException.java,v $ $Revision: 1.13 $ $Date: 2004/02/06 09:28:30 $ $Name: jdom_1_0 $";

    public DataConversionException(String str, String str2) {
        super(new StringBuffer().append("The XML construct ").append(str).append(" could not be converted to a ").append(str2).toString());
    }
}
