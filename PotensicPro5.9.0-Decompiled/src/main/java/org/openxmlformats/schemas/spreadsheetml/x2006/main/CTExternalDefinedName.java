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
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTExternalDefinedName extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTExternalDefinedName.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctexternaldefinedname9408type");

    public static final class Factory {
        private Factory() {
        }

        public static CTExternalDefinedName newInstance() {
            return (CTExternalDefinedName) XmlBeans.getContextTypeLoader().newInstance(CTExternalDefinedName.type, null);
        }

        public static CTExternalDefinedName newInstance(XmlOptions xmlOptions) {
            return (CTExternalDefinedName) XmlBeans.getContextTypeLoader().newInstance(CTExternalDefinedName.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTExternalDefinedName.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTExternalDefinedName.type, xmlOptions);
        }

        public static CTExternalDefinedName parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTExternalDefinedName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTExternalDefinedName.type, (XmlOptions) null);
        }

        public static CTExternalDefinedName parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalDefinedName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTExternalDefinedName.type, xmlOptions);
        }

        public static CTExternalDefinedName parse(File file) throws XmlException, IOException {
            return (CTExternalDefinedName) XmlBeans.getContextTypeLoader().parse(file, CTExternalDefinedName.type, (XmlOptions) null);
        }

        public static CTExternalDefinedName parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalDefinedName) XmlBeans.getContextTypeLoader().parse(file, CTExternalDefinedName.type, xmlOptions);
        }

        public static CTExternalDefinedName parse(InputStream inputStream) throws XmlException, IOException {
            return (CTExternalDefinedName) XmlBeans.getContextTypeLoader().parse(inputStream, CTExternalDefinedName.type, (XmlOptions) null);
        }

        public static CTExternalDefinedName parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalDefinedName) XmlBeans.getContextTypeLoader().parse(inputStream, CTExternalDefinedName.type, xmlOptions);
        }

        public static CTExternalDefinedName parse(Reader reader) throws XmlException, IOException {
            return (CTExternalDefinedName) XmlBeans.getContextTypeLoader().parse(reader, CTExternalDefinedName.type, (XmlOptions) null);
        }

        public static CTExternalDefinedName parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalDefinedName) XmlBeans.getContextTypeLoader().parse(reader, CTExternalDefinedName.type, xmlOptions);
        }

        public static CTExternalDefinedName parse(String str) throws XmlException {
            return (CTExternalDefinedName) XmlBeans.getContextTypeLoader().parse(str, CTExternalDefinedName.type, (XmlOptions) null);
        }

        public static CTExternalDefinedName parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalDefinedName) XmlBeans.getContextTypeLoader().parse(str, CTExternalDefinedName.type, xmlOptions);
        }

        public static CTExternalDefinedName parse(URL url) throws XmlException, IOException {
            return (CTExternalDefinedName) XmlBeans.getContextTypeLoader().parse(url, CTExternalDefinedName.type, (XmlOptions) null);
        }

        public static CTExternalDefinedName parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalDefinedName) XmlBeans.getContextTypeLoader().parse(url, CTExternalDefinedName.type, xmlOptions);
        }

        public static CTExternalDefinedName parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTExternalDefinedName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTExternalDefinedName.type, (XmlOptions) null);
        }

        public static CTExternalDefinedName parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTExternalDefinedName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTExternalDefinedName.type, xmlOptions);
        }

        public static CTExternalDefinedName parse(Node node) throws XmlException {
            return (CTExternalDefinedName) XmlBeans.getContextTypeLoader().parse(node, CTExternalDefinedName.type, (XmlOptions) null);
        }

        public static CTExternalDefinedName parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalDefinedName) XmlBeans.getContextTypeLoader().parse(node, CTExternalDefinedName.type, xmlOptions);
        }
    }

    String getName();

    String getRefersTo();

    long getSheetId();

    boolean isSetRefersTo();

    boolean isSetSheetId();

    void setName(String str);

    void setRefersTo(String str);

    void setSheetId(long j);

    void unsetRefersTo();

    void unsetSheetId();

    STXstring xgetName();

    STXstring xgetRefersTo();

    XmlUnsignedInt xgetSheetId();

    void xsetName(STXstring sTXstring);

    void xsetRefersTo(STXstring sTXstring);

    void xsetSheetId(XmlUnsignedInt xmlUnsignedInt);
}
