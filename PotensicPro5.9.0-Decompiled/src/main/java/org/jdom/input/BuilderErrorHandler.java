package org.jdom.input;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/* loaded from: classes5.dex */
public class BuilderErrorHandler implements ErrorHandler {
    private static final String CVS_ID = "@(#) $RCSfile: BuilderErrorHandler.java,v $ $Revision: 1.12 $ $Date: 2004/02/06 09:28:31 $ $Name: jdom_1_0 $";

    @Override // org.xml.sax.ErrorHandler
    public void warning(SAXParseException sAXParseException) throws SAXException {
    }

    @Override // org.xml.sax.ErrorHandler
    public void error(SAXParseException sAXParseException) throws SAXException {
        throw sAXParseException;
    }

    @Override // org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException sAXParseException) throws SAXException {
        throw sAXParseException;
    }
}
