package org.apache.xmlbeans;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.XmlCursor;
import org.xml.sax.ContentHandler;
import org.xml.sax.ext.LexicalHandler;

/* loaded from: classes5.dex */
public interface XmlSaxHandler {
    void bookmarkLastAttr(QName qName, XmlCursor.XmlBookmark xmlBookmark);

    void bookmarkLastEvent(XmlCursor.XmlBookmark xmlBookmark);

    ContentHandler getContentHandler();

    LexicalHandler getLexicalHandler();

    XmlObject getObject() throws XmlException;
}
