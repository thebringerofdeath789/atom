package org.apache.xmlbeans.impl.piccolo.xml;

import java.io.IOException;
import java.io.Reader;

/* loaded from: classes5.dex */
public abstract class XMLInputReader extends Reader {
    private String xmlVersion = null;
    private boolean xmlStandaloneDeclared = false;
    private boolean xmlStandalone = false;
    private String xmlDeclaredEncoding = null;
    private XMLDeclParser parser = new XMLDeclParser();

    protected void resetInput() {
        this.xmlDeclaredEncoding = null;
        this.xmlVersion = null;
        this.xmlStandalone = false;
        this.xmlStandaloneDeclared = false;
    }

    protected int parseXMLDeclaration(char[] cArr, int i, int i2) throws IOException {
        this.parser.reset(cArr, i, i2);
        int parse = this.parser.parse();
        XMLDeclParser xMLDeclParser = this.parser;
        if (parse != 1) {
            return 0;
        }
        this.xmlVersion = xMLDeclParser.getXMLVersion();
        this.xmlStandalone = this.parser.isXMLStandalone();
        this.xmlStandaloneDeclared = this.parser.isXMLStandaloneDeclared();
        this.xmlDeclaredEncoding = this.parser.getXMLEncoding();
        return this.parser.getCharsRead();
    }

    public String getXMLVersion() {
        return this.xmlVersion;
    }

    public boolean isXMLStandalone() {
        return this.xmlStandalone;
    }

    public boolean isXMLStandaloneDeclared() {
        return this.xmlStandaloneDeclared;
    }

    public String getXMLDeclaredEncoding() {
        return this.xmlDeclaredEncoding;
    }
}
