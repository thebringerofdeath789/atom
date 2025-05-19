package org.jdom.input;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.xml.sax.SAXParseException;

/* loaded from: classes5.dex */
public class JDOMParseException extends JDOMException {
    private static final String CVS_ID = "@(#) $RCSfile: JDOMParseException.java,v $ $Revision: 1.7 $ $Date: 2004/02/17 02:29:24 $ $Name: jdom_1_0 $";
    private final Document partialDocument;

    public JDOMParseException(String str, Throwable th) {
        this(str, th, null);
    }

    public JDOMParseException(String str, Throwable th, Document document) {
        super(str, th);
        this.partialDocument = document;
    }

    public Document getPartialDocument() {
        return this.partialDocument;
    }

    public String getPublicId() {
        if (getCause() instanceof SAXParseException) {
            return ((SAXParseException) getCause()).getPublicId();
        }
        return null;
    }

    public String getSystemId() {
        if (getCause() instanceof SAXParseException) {
            return ((SAXParseException) getCause()).getSystemId();
        }
        return null;
    }

    public int getLineNumber() {
        if (getCause() instanceof SAXParseException) {
            return ((SAXParseException) getCause()).getLineNumber();
        }
        return -1;
    }

    public int getColumnNumber() {
        if (getCause() instanceof SAXParseException) {
            return ((SAXParseException) getCause()).getColumnNumber();
        }
        return -1;
    }
}
