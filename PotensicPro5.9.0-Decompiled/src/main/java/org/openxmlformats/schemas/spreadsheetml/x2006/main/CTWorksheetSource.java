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
public interface CTWorksheetSource extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTWorksheetSource.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctworksheetsourced4c8type");

    public static final class Factory {
        private Factory() {
        }

        public static CTWorksheetSource newInstance() {
            return (CTWorksheetSource) XmlBeans.getContextTypeLoader().newInstance(CTWorksheetSource.type, null);
        }

        public static CTWorksheetSource newInstance(XmlOptions xmlOptions) {
            return (CTWorksheetSource) XmlBeans.getContextTypeLoader().newInstance(CTWorksheetSource.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTWorksheetSource.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTWorksheetSource.type, xmlOptions);
        }

        public static CTWorksheetSource parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTWorksheetSource) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTWorksheetSource.type, (XmlOptions) null);
        }

        public static CTWorksheetSource parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTWorksheetSource) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTWorksheetSource.type, xmlOptions);
        }

        public static CTWorksheetSource parse(File file) throws XmlException, IOException {
            return (CTWorksheetSource) XmlBeans.getContextTypeLoader().parse(file, CTWorksheetSource.type, (XmlOptions) null);
        }

        public static CTWorksheetSource parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorksheetSource) XmlBeans.getContextTypeLoader().parse(file, CTWorksheetSource.type, xmlOptions);
        }

        public static CTWorksheetSource parse(InputStream inputStream) throws XmlException, IOException {
            return (CTWorksheetSource) XmlBeans.getContextTypeLoader().parse(inputStream, CTWorksheetSource.type, (XmlOptions) null);
        }

        public static CTWorksheetSource parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorksheetSource) XmlBeans.getContextTypeLoader().parse(inputStream, CTWorksheetSource.type, xmlOptions);
        }

        public static CTWorksheetSource parse(Reader reader) throws XmlException, IOException {
            return (CTWorksheetSource) XmlBeans.getContextTypeLoader().parse(reader, CTWorksheetSource.type, (XmlOptions) null);
        }

        public static CTWorksheetSource parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorksheetSource) XmlBeans.getContextTypeLoader().parse(reader, CTWorksheetSource.type, xmlOptions);
        }

        public static CTWorksheetSource parse(String str) throws XmlException {
            return (CTWorksheetSource) XmlBeans.getContextTypeLoader().parse(str, CTWorksheetSource.type, (XmlOptions) null);
        }

        public static CTWorksheetSource parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTWorksheetSource) XmlBeans.getContextTypeLoader().parse(str, CTWorksheetSource.type, xmlOptions);
        }

        public static CTWorksheetSource parse(URL url) throws XmlException, IOException {
            return (CTWorksheetSource) XmlBeans.getContextTypeLoader().parse(url, CTWorksheetSource.type, (XmlOptions) null);
        }

        public static CTWorksheetSource parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorksheetSource) XmlBeans.getContextTypeLoader().parse(url, CTWorksheetSource.type, xmlOptions);
        }

        public static CTWorksheetSource parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTWorksheetSource) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTWorksheetSource.type, (XmlOptions) null);
        }

        public static CTWorksheetSource parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTWorksheetSource) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTWorksheetSource.type, xmlOptions);
        }

        public static CTWorksheetSource parse(Node node) throws XmlException {
            return (CTWorksheetSource) XmlBeans.getContextTypeLoader().parse(node, CTWorksheetSource.type, (XmlOptions) null);
        }

        public static CTWorksheetSource parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTWorksheetSource) XmlBeans.getContextTypeLoader().parse(node, CTWorksheetSource.type, xmlOptions);
        }
    }

    String getId();

    String getName();

    String getRef();

    String getSheet();

    boolean isSetId();

    boolean isSetName();

    boolean isSetRef();

    boolean isSetSheet();

    void setId(String str);

    void setName(String str);

    void setRef(String str);

    void setSheet(String str);

    void unsetId();

    void unsetName();

    void unsetRef();

    void unsetSheet();

    STRelationshipId xgetId();

    STXstring xgetName();

    STRef xgetRef();

    STXstring xgetSheet();

    void xsetId(STRelationshipId sTRelationshipId);

    void xsetName(STXstring sTXstring);

    void xsetRef(STRef sTRef);

    void xsetSheet(STXstring sTXstring);
}
