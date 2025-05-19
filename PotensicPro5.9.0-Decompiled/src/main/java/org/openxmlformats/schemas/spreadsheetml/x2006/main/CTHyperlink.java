package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTHyperlink extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTHyperlink.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cthyperlink0c85type");

    public static final class Factory {
        private Factory() {
        }

        public static CTHyperlink newInstance() {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().newInstance(CTHyperlink.type, null);
        }

        public static CTHyperlink newInstance(XmlOptions xmlOptions) {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().newInstance(CTHyperlink.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTHyperlink.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(File file) throws XmlException, IOException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(file, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(file, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(InputStream inputStream) throws XmlException, IOException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(inputStream, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(inputStream, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(Reader reader) throws XmlException, IOException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(reader, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(reader, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(String str) throws XmlException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(str, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(str, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(URL url) throws XmlException, IOException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(url, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(url, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(Node node) throws XmlException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(node, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTHyperlink) XmlBeans.getContextTypeLoader().parse(node, CTHyperlink.type, xmlOptions);
        }
    }

    String getDisplay();

    String getId();

    String getLocation();

    String getRef();

    String getTooltip();

    boolean isSetDisplay();

    boolean isSetId();

    boolean isSetLocation();

    boolean isSetTooltip();

    void setDisplay(String str);

    void setId(String str);

    void setLocation(String str);

    void setRef(String str);

    void setTooltip(String str);

    void unsetDisplay();

    void unsetId();

    void unsetLocation();

    void unsetTooltip();

    STXstring xgetDisplay();

    STRelationshipId xgetId();

    STXstring xgetLocation();

    STRef xgetRef();

    STXstring xgetTooltip();

    void xsetDisplay(STXstring sTXstring);

    void xsetId(STRelationshipId sTRelationshipId);

    void xsetLocation(STXstring sTXstring);

    void xsetRef(STRef sTRef);

    void xsetTooltip(STXstring sTXstring);
}
