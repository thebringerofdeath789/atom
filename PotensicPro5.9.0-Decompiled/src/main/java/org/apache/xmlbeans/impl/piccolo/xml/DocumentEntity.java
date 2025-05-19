package org.apache.xmlbeans.impl.piccolo.xml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.apache.xmlbeans.impl.piccolo.util.RecursionException;
import org.xml.sax.InputSource;

/* loaded from: classes5.dex */
public class DocumentEntity implements Entity {
    private static URL defaultContext;
    private boolean isOpen = false;
    private URL url = null;
    private String sysID = null;
    private InputSource source = null;
    private boolean isStandalone = false;
    private XMLStreamReader streamReader = null;
    private XMLReaderReader readerReader = null;
    private XMLInputReader activeReader = null;

    @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
    public String getPublicID() {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
    public boolean isInternal() {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
    public boolean isParsed() {
        return true;
    }

    static {
        try {
            defaultContext = new URL(StringLookupFactory.KEY_FILE, (String) null, ".");
        } catch (IOException unused) {
            defaultContext = null;
        }
    }

    public DocumentEntity() {
    }

    public DocumentEntity(String str) throws IOException {
        reset(str);
    }

    public DocumentEntity(InputSource inputSource) throws IOException {
        reset(inputSource);
    }

    @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
    public boolean isOpen() {
        return this.isOpen;
    }

    @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
    public void open() throws IOException, RecursionException {
        String str;
        InputSource inputSource = this.source;
        if (inputSource != null) {
            Reader characterStream = inputSource.getCharacterStream();
            if (characterStream != null) {
                if (this.readerReader == null) {
                    this.readerReader = new XMLReaderReader();
                }
                this.readerReader.reset(characterStream, true);
                this.isStandalone = this.readerReader.isXMLStandalone();
                this.activeReader = this.readerReader;
                this.isOpen = true;
                return;
            }
            InputStream byteStream = this.source.getByteStream();
            if (byteStream != null) {
                if (this.streamReader == null) {
                    this.streamReader = new XMLStreamReader();
                }
                this.streamReader.reset(byteStream, this.source.getEncoding(), true);
                this.isOpen = true;
                this.isStandalone = this.streamReader.isXMLStandalone();
                this.activeReader = this.streamReader;
                return;
            }
            URL url = new URL(defaultContext, this.source.getSystemId());
            this.url = url;
            this.sysID = url.toString();
            str = this.source.getEncoding();
        } else {
            str = null;
        }
        if (this.streamReader == null) {
            this.streamReader = new XMLStreamReader();
        }
        this.streamReader.reset(this.url.openStream(), str, true);
        this.isStandalone = this.streamReader.isXMLStandalone();
        this.activeReader = this.streamReader;
        this.isOpen = true;
    }

    @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
    public String getDeclaredEncoding() {
        return this.activeReader.getXMLDeclaredEncoding();
    }

    @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
    public boolean isStandaloneDeclared() {
        return this.activeReader.isXMLStandaloneDeclared();
    }

    @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
    public String getXMLVersion() {
        return this.activeReader.getXMLVersion();
    }

    public void reset(String str) throws IOException {
        close();
        this.isStandalone = false;
        this.source = null;
        try {
            this.url = new URL(defaultContext, str);
        } catch (MalformedURLException unused) {
            this.url = new File(str).toURL();
        }
        this.sysID = this.url.toString();
    }

    public void reset(InputSource inputSource) throws IOException {
        close();
        this.isStandalone = false;
        this.source = inputSource;
        String systemId = inputSource.getSystemId();
        this.sysID = systemId;
        if (systemId != null) {
            try {
                this.url = new URL(defaultContext, this.sysID);
            } catch (MalformedURLException unused) {
                this.url = new File(this.sysID).toURL();
            }
            this.sysID = this.url.toString();
        }
    }

    @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
    public void close() throws IOException {
        if (this.isOpen) {
            this.source = null;
            this.activeReader.close();
            this.activeReader = null;
            this.isOpen = false;
        }
    }

    @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
    public String getSystemID() {
        return this.sysID;
    }

    @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
    public boolean isStandalone() {
        return this.isStandalone;
    }

    @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
    public void setStandalone(boolean z) {
        this.isStandalone = z;
    }

    @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
    public Reader getReader() {
        return this.activeReader;
    }

    @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
    public String stringValue() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
    public char[] charArrayValue() {
        throw new UnsupportedOperationException();
    }
}
