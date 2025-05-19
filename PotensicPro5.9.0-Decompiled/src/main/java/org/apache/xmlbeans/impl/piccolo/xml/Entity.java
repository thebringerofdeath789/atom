package org.apache.xmlbeans.impl.piccolo.xml;

import java.io.IOException;
import java.io.Reader;
import org.apache.xmlbeans.impl.piccolo.util.RecursionException;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public interface Entity {
    char[] charArrayValue();

    void close() throws IOException;

    String getDeclaredEncoding();

    String getPublicID();

    Reader getReader();

    String getSystemID();

    String getXMLVersion();

    boolean isInternal();

    boolean isOpen();

    boolean isParsed();

    boolean isStandalone();

    boolean isStandaloneDeclared();

    void open() throws IOException, SAXException, RecursionException;

    void setStandalone(boolean z);

    String stringValue();
}
