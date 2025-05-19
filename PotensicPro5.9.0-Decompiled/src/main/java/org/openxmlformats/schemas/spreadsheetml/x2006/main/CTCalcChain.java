package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTCalcChain extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTCalcChain.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcalcchain5a0btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTCalcChain newInstance() {
            return (CTCalcChain) XmlBeans.getContextTypeLoader().newInstance(CTCalcChain.type, null);
        }

        public static CTCalcChain newInstance(XmlOptions xmlOptions) {
            return (CTCalcChain) XmlBeans.getContextTypeLoader().newInstance(CTCalcChain.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCalcChain.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCalcChain.type, xmlOptions);
        }

        public static CTCalcChain parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCalcChain) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCalcChain.type, (XmlOptions) null);
        }

        public static CTCalcChain parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCalcChain) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCalcChain.type, xmlOptions);
        }

        public static CTCalcChain parse(File file) throws XmlException, IOException {
            return (CTCalcChain) XmlBeans.getContextTypeLoader().parse(file, CTCalcChain.type, (XmlOptions) null);
        }

        public static CTCalcChain parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCalcChain) XmlBeans.getContextTypeLoader().parse(file, CTCalcChain.type, xmlOptions);
        }

        public static CTCalcChain parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCalcChain) XmlBeans.getContextTypeLoader().parse(inputStream, CTCalcChain.type, (XmlOptions) null);
        }

        public static CTCalcChain parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCalcChain) XmlBeans.getContextTypeLoader().parse(inputStream, CTCalcChain.type, xmlOptions);
        }

        public static CTCalcChain parse(Reader reader) throws XmlException, IOException {
            return (CTCalcChain) XmlBeans.getContextTypeLoader().parse(reader, CTCalcChain.type, (XmlOptions) null);
        }

        public static CTCalcChain parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCalcChain) XmlBeans.getContextTypeLoader().parse(reader, CTCalcChain.type, xmlOptions);
        }

        public static CTCalcChain parse(String str) throws XmlException {
            return (CTCalcChain) XmlBeans.getContextTypeLoader().parse(str, CTCalcChain.type, (XmlOptions) null);
        }

        public static CTCalcChain parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCalcChain) XmlBeans.getContextTypeLoader().parse(str, CTCalcChain.type, xmlOptions);
        }

        public static CTCalcChain parse(URL url) throws XmlException, IOException {
            return (CTCalcChain) XmlBeans.getContextTypeLoader().parse(url, CTCalcChain.type, (XmlOptions) null);
        }

        public static CTCalcChain parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCalcChain) XmlBeans.getContextTypeLoader().parse(url, CTCalcChain.type, xmlOptions);
        }

        public static CTCalcChain parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTCalcChain) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCalcChain.type, (XmlOptions) null);
        }

        public static CTCalcChain parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTCalcChain) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCalcChain.type, xmlOptions);
        }

        public static CTCalcChain parse(Node node) throws XmlException {
            return (CTCalcChain) XmlBeans.getContextTypeLoader().parse(node, CTCalcChain.type, (XmlOptions) null);
        }

        public static CTCalcChain parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCalcChain) XmlBeans.getContextTypeLoader().parse(node, CTCalcChain.type, xmlOptions);
        }
    }

    CTCalcCell addNewC();

    CTExtensionList addNewExtLst();

    CTCalcCell getCArray(int i);

    CTCalcCell[] getCArray();

    List<CTCalcCell> getCList();

    CTExtensionList getExtLst();

    CTCalcCell insertNewC(int i);

    boolean isSetExtLst();

    void removeC(int i);

    void setCArray(int i, CTCalcCell cTCalcCell);

    void setCArray(CTCalcCell[] cTCalcCellArr);

    void setExtLst(CTExtensionList cTExtensionList);

    int sizeOfCArray();

    void unsetExtLst();
}
