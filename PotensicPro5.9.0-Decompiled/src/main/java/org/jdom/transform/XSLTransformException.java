package org.jdom.transform;

import org.jdom.JDOMException;

/* loaded from: classes5.dex */
public class XSLTransformException extends JDOMException {
    private static final String CVS_ID = "@(#) $RCSfile: XSLTransformException.java,v $ $Revision: 1.3 $ $Date: 2004/02/06 09:28:32 $ $Name: jdom_1_0 $";

    public XSLTransformException() {
    }

    public XSLTransformException(String str) {
        super(str);
    }

    public XSLTransformException(String str, Exception exc) {
        super(str, exc);
    }
}
