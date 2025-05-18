package aavax.xml.stream.util;

import aavax.xml.namespace.NamespaceContext;
import aavax.xml.namespace.QName;
import aavax.xml.stream.Location;
import aavax.xml.stream.XMLStreamException;
import aavax.xml.stream.XMLStreamReader;

/* loaded from: classes.dex */
public class StreamReaderDelegate implements XMLStreamReader {
    private XMLStreamReader reader;

    public StreamReaderDelegate() {
    }

    public StreamReaderDelegate(XMLStreamReader xMLStreamReader) {
        this.reader = xMLStreamReader;
    }

    public void setParent(XMLStreamReader xMLStreamReader) {
        this.reader = xMLStreamReader;
    }

    public XMLStreamReader getParent() {
        return this.reader;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public int next() throws XMLStreamException {
        return this.reader.next();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public int nextTag() throws XMLStreamException {
        return this.reader.nextTag();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getElementText() throws XMLStreamException {
        return this.reader.getElementText();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public void require(int i, String str, String str2) throws XMLStreamException {
        this.reader.require(i, str, str2);
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public boolean hasNext() throws XMLStreamException {
        return this.reader.hasNext();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public void close() throws XMLStreamException {
        this.reader.close();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getNamespaceURI(String str) {
        return this.reader.getNamespaceURI(str);
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public NamespaceContext getNamespaceContext() {
        return this.reader.getNamespaceContext();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public boolean isStartElement() {
        return this.reader.isStartElement();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public boolean isEndElement() {
        return this.reader.isEndElement();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public boolean isCharacters() {
        return this.reader.isCharacters();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public boolean isWhiteSpace() {
        return this.reader.isWhiteSpace();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getAttributeValue(String str, String str2) {
        return this.reader.getAttributeValue(str, str2);
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public int getAttributeCount() {
        return this.reader.getAttributeCount();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public QName getAttributeName(int i) {
        return this.reader.getAttributeName(i);
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getAttributePrefix(int i) {
        return this.reader.getAttributePrefix(i);
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getAttributeNamespace(int i) {
        return this.reader.getAttributeNamespace(i);
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getAttributeLocalName(int i) {
        return this.reader.getAttributeLocalName(i);
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getAttributeType(int i) {
        return this.reader.getAttributeType(i);
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getAttributeValue(int i) {
        return this.reader.getAttributeValue(i);
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public boolean isAttributeSpecified(int i) {
        return this.reader.isAttributeSpecified(i);
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public int getNamespaceCount() {
        return this.reader.getNamespaceCount();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getNamespacePrefix(int i) {
        return this.reader.getNamespacePrefix(i);
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getNamespaceURI(int i) {
        return this.reader.getNamespaceURI(i);
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public int getEventType() {
        return this.reader.getEventType();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getText() {
        return this.reader.getText();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public int getTextCharacters(int i, char[] cArr, int i2, int i3) throws XMLStreamException {
        return this.reader.getTextCharacters(i, cArr, i2, i3);
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public char[] getTextCharacters() {
        return this.reader.getTextCharacters();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public int getTextStart() {
        return this.reader.getTextStart();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public int getTextLength() {
        return this.reader.getTextLength();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getEncoding() {
        return this.reader.getEncoding();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public boolean hasText() {
        return this.reader.hasText();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public Location getLocation() {
        return this.reader.getLocation();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public QName getName() {
        return this.reader.getName();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getLocalName() {
        return this.reader.getLocalName();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public boolean hasName() {
        return this.reader.hasName();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getNamespaceURI() {
        return this.reader.getNamespaceURI();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getPrefix() {
        return this.reader.getPrefix();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getVersion() {
        return this.reader.getVersion();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public boolean isStandalone() {
        return this.reader.isStandalone();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public boolean standaloneSet() {
        return this.reader.standaloneSet();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getCharacterEncodingScheme() {
        return this.reader.getCharacterEncodingScheme();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getPITarget() {
        return this.reader.getPITarget();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getPIData() {
        return this.reader.getPIData();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public Object getProperty(String str) {
        return this.reader.getProperty(str);
    }
}