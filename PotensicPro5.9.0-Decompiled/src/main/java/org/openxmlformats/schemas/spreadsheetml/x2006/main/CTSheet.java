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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSheetState;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTSheet extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSheet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctsheet4dbetype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSheet newInstance() {
            return (CTSheet) XmlBeans.getContextTypeLoader().newInstance(CTSheet.type, null);
        }

        public static CTSheet newInstance(XmlOptions xmlOptions) {
            return (CTSheet) XmlBeans.getContextTypeLoader().newInstance(CTSheet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSheet.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSheet.type, xmlOptions);
        }

        public static CTSheet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSheet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSheet.type, (XmlOptions) null);
        }

        public static CTSheet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSheet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSheet.type, xmlOptions);
        }

        public static CTSheet parse(File file) throws XmlException, IOException {
            return (CTSheet) XmlBeans.getContextTypeLoader().parse(file, CTSheet.type, (XmlOptions) null);
        }

        public static CTSheet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheet) XmlBeans.getContextTypeLoader().parse(file, CTSheet.type, xmlOptions);
        }

        public static CTSheet parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSheet) XmlBeans.getContextTypeLoader().parse(inputStream, CTSheet.type, (XmlOptions) null);
        }

        public static CTSheet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheet) XmlBeans.getContextTypeLoader().parse(inputStream, CTSheet.type, xmlOptions);
        }

        public static CTSheet parse(Reader reader) throws XmlException, IOException {
            return (CTSheet) XmlBeans.getContextTypeLoader().parse(reader, CTSheet.type, (XmlOptions) null);
        }

        public static CTSheet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheet) XmlBeans.getContextTypeLoader().parse(reader, CTSheet.type, xmlOptions);
        }

        public static CTSheet parse(String str) throws XmlException {
            return (CTSheet) XmlBeans.getContextTypeLoader().parse(str, CTSheet.type, (XmlOptions) null);
        }

        public static CTSheet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSheet) XmlBeans.getContextTypeLoader().parse(str, CTSheet.type, xmlOptions);
        }

        public static CTSheet parse(URL url) throws XmlException, IOException {
            return (CTSheet) XmlBeans.getContextTypeLoader().parse(url, CTSheet.type, (XmlOptions) null);
        }

        public static CTSheet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheet) XmlBeans.getContextTypeLoader().parse(url, CTSheet.type, xmlOptions);
        }

        public static CTSheet parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSheet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSheet.type, (XmlOptions) null);
        }

        public static CTSheet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSheet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSheet.type, xmlOptions);
        }

        public static CTSheet parse(Node node) throws XmlException {
            return (CTSheet) XmlBeans.getContextTypeLoader().parse(node, CTSheet.type, (XmlOptions) null);
        }

        public static CTSheet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSheet) XmlBeans.getContextTypeLoader().parse(node, CTSheet.type, xmlOptions);
        }
    }

    String getId();

    String getName();

    long getSheetId();

    STSheetState.Enum getState();

    boolean isSetState();

    void setId(String str);

    void setName(String str);

    void setSheetId(long j);

    void setState(STSheetState.Enum r1);

    void unsetState();

    STRelationshipId xgetId();

    STXstring xgetName();

    XmlUnsignedInt xgetSheetId();

    STSheetState xgetState();

    void xsetId(STRelationshipId sTRelationshipId);

    void xsetName(STXstring sTXstring);

    void xsetSheetId(XmlUnsignedInt xmlUnsignedInt);

    void xsetState(STSheetState sTSheetState);
}
