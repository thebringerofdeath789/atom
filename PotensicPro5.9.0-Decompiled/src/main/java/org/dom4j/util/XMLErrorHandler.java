package org.dom4j.util;

import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes5.dex */
public class XMLErrorHandler implements ErrorHandler {
    protected static final QName ERROR_QNAME = QName.get(IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR);
    protected static final QName FATALERROR_QNAME = QName.get("fatalError");
    protected static final QName WARNING_QNAME = QName.get("warning");
    private QName errorQName;
    private Element errors;
    private QName fatalErrorQName;
    private QName warningQName;

    public XMLErrorHandler() {
        this.errorQName = ERROR_QNAME;
        this.fatalErrorQName = FATALERROR_QNAME;
        this.warningQName = WARNING_QNAME;
        this.errors = DocumentHelper.createElement("errors");
    }

    public XMLErrorHandler(Element element) {
        this.errorQName = ERROR_QNAME;
        this.fatalErrorQName = FATALERROR_QNAME;
        this.warningQName = WARNING_QNAME;
        this.errors = element;
    }

    @Override // org.xml.sax.ErrorHandler
    public void error(SAXParseException sAXParseException) {
        addException(this.errors.addElement(this.errorQName), sAXParseException);
    }

    @Override // org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException sAXParseException) {
        addException(this.errors.addElement(this.fatalErrorQName), sAXParseException);
    }

    @Override // org.xml.sax.ErrorHandler
    public void warning(SAXParseException sAXParseException) {
        addException(this.errors.addElement(this.warningQName), sAXParseException);
    }

    public Element getErrors() {
        return this.errors;
    }

    public void setErrors(Element element) {
        this.errors = element;
    }

    public QName getErrorQName() {
        return this.errorQName;
    }

    public void setErrorQName(QName qName) {
        this.errorQName = qName;
    }

    public QName getFatalErrorQName() {
        return this.fatalErrorQName;
    }

    public void setFatalErrorQName(QName qName) {
        this.fatalErrorQName = qName;
    }

    public QName getWarningQName() {
        return this.warningQName;
    }

    public void setWarningQName(QName qName) {
        this.warningQName = qName;
    }

    protected void addException(Element element, SAXParseException sAXParseException) {
        element.addAttribute(JamXmlElements.COLUMN, Integer.toString(sAXParseException.getColumnNumber()));
        element.addAttribute("line", Integer.toString(sAXParseException.getLineNumber()));
        String publicId = sAXParseException.getPublicId();
        if (publicId != null && publicId.length() > 0) {
            element.addAttribute("publicID", publicId);
        }
        String systemId = sAXParseException.getSystemId();
        if (systemId != null && systemId.length() > 0) {
            element.addAttribute("systemID", systemId);
        }
        element.addText(sAXParseException.getMessage());
    }
}
