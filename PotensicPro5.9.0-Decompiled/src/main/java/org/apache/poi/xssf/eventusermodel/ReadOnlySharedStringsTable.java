package org.apache.poi.xssf.eventusermodel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.util.SAXHelper;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes5.dex */
public class ReadOnlySharedStringsTable extends DefaultHandler {
    private StringBuffer characters;
    private int count;
    private List<String> strings;
    private boolean tIsOpen;
    private int uniqueCount;

    public ReadOnlySharedStringsTable(OPCPackage oPCPackage) throws IOException, SAXException {
        ArrayList<PackagePart> partsByContentType = oPCPackage.getPartsByContentType(XSSFRelation.SHARED_STRINGS.getContentType());
        if (partsByContentType.size() > 0) {
            readFrom(partsByContentType.get(0).getInputStream());
        }
    }

    public ReadOnlySharedStringsTable(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException, SAXException {
        readFrom(packagePart.getInputStream());
    }

    public void readFrom(InputStream inputStream) throws IOException, SAXException {
        InputSource inputSource = new InputSource(inputStream);
        try {
            XMLReader newXMLReader = SAXHelper.newXMLReader();
            newXMLReader.setContentHandler(this);
            newXMLReader.parse(inputSource);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("SAX parser appears to be broken - " + e.getMessage());
        }
    }

    public int getCount() {
        return this.count;
    }

    public int getUniqueCount() {
        return this.uniqueCount;
    }

    public String getEntryAt(int i) {
        return this.strings.get(i);
    }

    public List<String> getItems() {
        return this.strings;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        if ("sst".equals(str3)) {
            String value = attributes.getValue("count");
            if (value != null) {
                this.count = Integer.parseInt(value);
            }
            String value2 = attributes.getValue("uniqueCount");
            if (value2 != null) {
                this.uniqueCount = Integer.parseInt(value2);
            }
            this.strings = new ArrayList(this.uniqueCount);
            this.characters = new StringBuffer();
            return;
        }
        if ("si".equals(str3)) {
            this.characters.setLength(0);
        } else if ("t".equals(str3)) {
            this.tIsOpen = true;
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        if ("si".equals(str3)) {
            this.strings.add(this.characters.toString());
        } else if ("t".equals(str3)) {
            this.tIsOpen = false;
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        if (this.tIsOpen) {
            this.characters.append(cArr, i, i2);
        }
    }
}
