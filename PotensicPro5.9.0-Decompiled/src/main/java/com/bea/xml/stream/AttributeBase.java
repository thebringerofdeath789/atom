package com.bea.xml.stream;

import aavax.xml.namespace.QName;
import aavax.xml.stream.Location;
import aavax.xml.stream.events.Attribute;
import aavax.xml.stream.events.Characters;
import aavax.xml.stream.events.EndElement;
import aavax.xml.stream.events.StartElement;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes.dex */
public class AttributeBase implements Attribute, Location {
    private QName attributeType;
    private String locationURI;
    private QName name;
    private String value;
    private int eventType = -1;
    private int line = -1;
    private int column = -1;
    private int characterOffset = 0;

    @Override // aavax.xml.stream.events.Attribute
    public String getDTDType() {
        return "CDATA";
    }

    @Override // aavax.xml.stream.events.XMLEvent
    public int getEventType() {
        return 10;
    }

    @Override // aavax.xml.stream.events.XMLEvent
    public Location getLocation() {
        return this;
    }

    @Override // aavax.xml.stream.Location
    public String getPublicId() {
        return null;
    }

    @Override // aavax.xml.stream.events.XMLEvent
    public QName getSchemaType() {
        return null;
    }

    public String getSourceName() {
        return null;
    }

    @Override // aavax.xml.stream.Location
    public String getSystemId() {
        return null;
    }

    @Override // aavax.xml.stream.events.XMLEvent
    public boolean isAttribute() {
        return true;
    }

    @Override // aavax.xml.stream.events.XMLEvent
    public boolean isCharacters() {
        return false;
    }

    public boolean isDefault() {
        return true;
    }

    @Override // aavax.xml.stream.events.XMLEvent
    public boolean isEndDocument() {
        return false;
    }

    @Override // aavax.xml.stream.events.XMLEvent
    public boolean isEndElement() {
        return false;
    }

    public boolean isEndEntity() {
        return false;
    }

    @Override // aavax.xml.stream.events.XMLEvent
    public boolean isEntityReference() {
        return false;
    }

    @Override // aavax.xml.stream.events.XMLEvent
    public boolean isNamespace() {
        return false;
    }

    public boolean isNamespaceDeclaration() {
        return false;
    }

    @Override // aavax.xml.stream.events.XMLEvent
    public boolean isProcessingInstruction() {
        return false;
    }

    @Override // aavax.xml.stream.events.Attribute
    public boolean isSpecified() {
        return true;
    }

    @Override // aavax.xml.stream.events.XMLEvent
    public boolean isStartDocument() {
        return false;
    }

    @Override // aavax.xml.stream.events.XMLEvent
    public boolean isStartElement() {
        return false;
    }

    public boolean isStartEntity() {
        return false;
    }

    public void recycle() {
    }

    public AttributeBase(String str, String str2, String str3, String str4, String str5) {
        this.name = new QName(str2, str3, str == null ? "" : str);
        this.value = str4;
        this.attributeType = new QName(str5);
    }

    public AttributeBase(String str, String str2, String str3) {
        this.name = new QName("", str2, str == null ? "" : str);
        this.value = str3;
    }

    public AttributeBase(QName qName, String str) {
        this.name = qName;
        this.value = str;
    }

    public String toString() {
        if (this.name.getPrefix() != null && !this.name.getPrefix().equals("")) {
            return new StringBuffer().append("['").append(this.name.getNamespaceURI()).append("']:").append(this.name.getPrefix()).append(":").append(this.name.getLocalPart()).append("='").append(this.value).append("'").toString();
        }
        return new StringBuffer().append(this.name.getLocalPart()).append("='").append(this.value).append("'").toString();
    }

    @Override // aavax.xml.stream.Location
    public int getLineNumber() {
        return this.line;
    }

    public void setLineNumber(int i) {
        this.line = i;
    }

    @Override // aavax.xml.stream.Location
    public int getColumnNumber() {
        return this.column;
    }

    public void setColumnNumber(int i) {
        this.column = i;
    }

    @Override // aavax.xml.stream.Location
    public int getCharacterOffset() {
        return this.characterOffset;
    }

    public void setCharacterOffset(int i) {
        this.characterOffset = i;
    }

    public String getLocationURI() {
        return this.locationURI;
    }

    public void setLocationURI(String str) {
        this.locationURI = str;
    }

    public boolean hasName() {
        return this.name != null;
    }

    @Override // aavax.xml.stream.events.Attribute
    public QName getName() {
        return this.name;
    }

    public String getLocalName() {
        return this.name.getLocalPart();
    }

    @Override // aavax.xml.stream.events.Attribute
    public String getValue() {
        return this.value;
    }

    public String getNamespaceURI() {
        return this.name.getNamespaceURI();
    }

    public void setNamespaceURI(String str) {
        this.name = new QName(str, this.name.getLocalPart());
    }

    @Override // aavax.xml.stream.events.XMLEvent
    public StartElement asStartElement() {
        throw new ClassCastException("cannnot cast AttributeBase to StartElement");
    }

    @Override // aavax.xml.stream.events.XMLEvent
    public EndElement asEndElement() {
        throw new ClassCastException("cannnot cast AttributeBase to EndElement");
    }

    @Override // aavax.xml.stream.events.XMLEvent
    public Characters asCharacters() {
        throw new ClassCastException("cannnot cast AttributeBase to Characters");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
    
        r10.write(r0);
     */
    @Override // aavax.xml.stream.events.XMLEvent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeAsEncodedUnicode(java.io.Writer r10) throws aavax.xml.stream.XMLStreamException {
        /*
            r9 = this;
            aavax.xml.namespace.QName r0 = r9.name     // Catch: java.io.IOException -> L81
            java.lang.String r0 = r0.getPrefix()     // Catch: java.io.IOException -> L81
            if (r0 == 0) goto L16
            int r1 = r0.length()     // Catch: java.io.IOException -> L81
            if (r1 <= 0) goto L16
            r10.write(r0)     // Catch: java.io.IOException -> L81
            r0 = 58
            r10.write(r0)     // Catch: java.io.IOException -> L81
        L16:
            aavax.xml.namespace.QName r0 = r9.name     // Catch: java.io.IOException -> L81
            java.lang.String r0 = r0.getLocalPart()     // Catch: java.io.IOException -> L81
            r10.write(r0)     // Catch: java.io.IOException -> L81
            java.lang.String r0 = "=\""
            r10.write(r0)     // Catch: java.io.IOException -> L81
            java.lang.String r0 = r9.value     // Catch: java.io.IOException -> L81
            int r1 = r0.length()     // Catch: java.io.IOException -> L81
            r2 = 34
            if (r1 <= 0) goto L7d
            r3 = 0
            r4 = r3
        L30:
            r5 = 32
            r6 = 60
            r7 = 38
            if (r4 >= r1) goto L48
            char r8 = r0.charAt(r4)     // Catch: java.io.IOException -> L81
            if (r8 == r2) goto L48
            if (r8 == r7) goto L48
            if (r8 == r6) goto L48
            if (r8 >= r5) goto L45
            goto L48
        L45:
            int r4 = r4 + 1
            goto L30
        L48:
            if (r4 != r1) goto L4e
            r10.write(r0)     // Catch: java.io.IOException -> L81
            goto L7d
        L4e:
            if (r4 <= 0) goto L53
            r10.write(r0, r3, r4)     // Catch: java.io.IOException -> L81
        L53:
            if (r4 >= r1) goto L7d
            char r3 = r0.charAt(r4)     // Catch: java.io.IOException -> L81
            if (r3 == r2) goto L75
            if (r3 == r7) goto L6f
            if (r3 == r6) goto L69
            if (r3 >= r5) goto L65
            writeEncodedChar(r10, r3)     // Catch: java.io.IOException -> L81
            goto L7a
        L65:
            r10.write(r3)     // Catch: java.io.IOException -> L81
            goto L7a
        L69:
            java.lang.String r3 = "&lt;"
            r10.write(r3)     // Catch: java.io.IOException -> L81
            goto L7a
        L6f:
            java.lang.String r3 = "&amp;"
            r10.write(r3)     // Catch: java.io.IOException -> L81
            goto L7a
        L75:
            java.lang.String r3 = "&quot;"
            r10.write(r3)     // Catch: java.io.IOException -> L81
        L7a:
            int r4 = r4 + 1
            goto L53
        L7d:
            r10.write(r2)     // Catch: java.io.IOException -> L81
            return
        L81:
            r10 = move-exception
            aavax.xml.stream.XMLStreamException r0 = new aavax.xml.stream.XMLStreamException
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bea.xml.stream.AttributeBase.writeAsEncodedUnicode(java.io.Writer):void");
    }

    public static void writeEncodedChar(Writer writer, char c) throws IOException {
        writer.write("&#");
        writer.write(Integer.toString(c));
        writer.write(59);
    }
}
