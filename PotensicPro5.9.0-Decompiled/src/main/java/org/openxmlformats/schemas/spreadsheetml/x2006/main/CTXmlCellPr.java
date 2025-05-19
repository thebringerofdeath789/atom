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
public interface CTXmlCellPr extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTXmlCellPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctxmlcellprf1datype");

    public static final class Factory {
        private Factory() {
        }

        public static CTXmlCellPr newInstance() {
            return (CTXmlCellPr) XmlBeans.getContextTypeLoader().newInstance(CTXmlCellPr.type, null);
        }

        public static CTXmlCellPr newInstance(XmlOptions xmlOptions) {
            return (CTXmlCellPr) XmlBeans.getContextTypeLoader().newInstance(CTXmlCellPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTXmlCellPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTXmlCellPr.type, xmlOptions);
        }

        public static CTXmlCellPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTXmlCellPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTXmlCellPr.type, (XmlOptions) null);
        }

        public static CTXmlCellPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTXmlCellPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTXmlCellPr.type, xmlOptions);
        }

        public static CTXmlCellPr parse(File file) throws XmlException, IOException {
            return (CTXmlCellPr) XmlBeans.getContextTypeLoader().parse(file, CTXmlCellPr.type, (XmlOptions) null);
        }

        public static CTXmlCellPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXmlCellPr) XmlBeans.getContextTypeLoader().parse(file, CTXmlCellPr.type, xmlOptions);
        }

        public static CTXmlCellPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTXmlCellPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTXmlCellPr.type, (XmlOptions) null);
        }

        public static CTXmlCellPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXmlCellPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTXmlCellPr.type, xmlOptions);
        }

        public static CTXmlCellPr parse(Reader reader) throws XmlException, IOException {
            return (CTXmlCellPr) XmlBeans.getContextTypeLoader().parse(reader, CTXmlCellPr.type, (XmlOptions) null);
        }

        public static CTXmlCellPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXmlCellPr) XmlBeans.getContextTypeLoader().parse(reader, CTXmlCellPr.type, xmlOptions);
        }

        public static CTXmlCellPr parse(String str) throws XmlException {
            return (CTXmlCellPr) XmlBeans.getContextTypeLoader().parse(str, CTXmlCellPr.type, (XmlOptions) null);
        }

        public static CTXmlCellPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTXmlCellPr) XmlBeans.getContextTypeLoader().parse(str, CTXmlCellPr.type, xmlOptions);
        }

        public static CTXmlCellPr parse(URL url) throws XmlException, IOException {
            return (CTXmlCellPr) XmlBeans.getContextTypeLoader().parse(url, CTXmlCellPr.type, (XmlOptions) null);
        }

        public static CTXmlCellPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXmlCellPr) XmlBeans.getContextTypeLoader().parse(url, CTXmlCellPr.type, xmlOptions);
        }

        public static CTXmlCellPr parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTXmlCellPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTXmlCellPr.type, (XmlOptions) null);
        }

        public static CTXmlCellPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTXmlCellPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTXmlCellPr.type, xmlOptions);
        }

        public static CTXmlCellPr parse(Node node) throws XmlException {
            return (CTXmlCellPr) XmlBeans.getContextTypeLoader().parse(node, CTXmlCellPr.type, (XmlOptions) null);
        }

        public static CTXmlCellPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTXmlCellPr) XmlBeans.getContextTypeLoader().parse(node, CTXmlCellPr.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTXmlPr addNewXmlPr();

    CTExtensionList getExtLst();

    long getId();

    String getUniqueName();

    CTXmlPr getXmlPr();

    boolean isSetExtLst();

    boolean isSetUniqueName();

    void setExtLst(CTExtensionList cTExtensionList);

    void setId(long j);

    void setUniqueName(String str);

    void setXmlPr(CTXmlPr cTXmlPr);

    void unsetExtLst();

    void unsetUniqueName();

    XmlUnsignedInt xgetId();

    STXstring xgetUniqueName();

    void xsetId(XmlUnsignedInt xmlUnsignedInt);

    void xsetUniqueName(STXstring sTXstring);
}
