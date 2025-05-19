package org.dom4j.io;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import org.dom4j.Document;
import org.xml.sax.InputSource;

/* loaded from: classes5.dex */
class DocumentInputSource extends InputSource {
    private Document document;

    public DocumentInputSource() {
    }

    public DocumentInputSource(Document document) {
        this.document = document;
        setSystemId(document.getName());
    }

    public Document getDocument() {
        return this.document;
    }

    public void setDocument(Document document) {
        this.document = document;
        setSystemId(document.getName());
    }

    @Override // org.xml.sax.InputSource
    public void setCharacterStream(Reader reader) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xml.sax.InputSource
    public Reader getCharacterStream() {
        try {
            StringWriter stringWriter = new StringWriter();
            XMLWriter xMLWriter = new XMLWriter(stringWriter);
            xMLWriter.write(this.document);
            xMLWriter.flush();
            return new StringReader(stringWriter.toString());
        } catch (IOException e) {
            return new Reader() { // from class: org.dom4j.io.DocumentInputSource.1
                @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                }

                @Override // java.io.Reader
                public int read(char[] cArr, int i, int i2) throws IOException {
                    throw e;
                }
            };
        }
    }
}
