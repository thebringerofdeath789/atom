package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTPTab extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPTab.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctptaba283type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPTab newInstance() {
            return (CTPTab) XmlBeans.getContextTypeLoader().newInstance(CTPTab.type, null);
        }

        public static CTPTab newInstance(XmlOptions xmlOptions) {
            return (CTPTab) XmlBeans.getContextTypeLoader().newInstance(CTPTab.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPTab.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPTab) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPTab) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(File file) throws XmlException, IOException {
            return (CTPTab) XmlBeans.getContextTypeLoader().parse(file, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPTab) XmlBeans.getContextTypeLoader().parse(file, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPTab) XmlBeans.getContextTypeLoader().parse(inputStream, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPTab) XmlBeans.getContextTypeLoader().parse(inputStream, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(Reader reader) throws XmlException, IOException {
            return (CTPTab) XmlBeans.getContextTypeLoader().parse(reader, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPTab) XmlBeans.getContextTypeLoader().parse(reader, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(String str) throws XmlException {
            return (CTPTab) XmlBeans.getContextTypeLoader().parse(str, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPTab) XmlBeans.getContextTypeLoader().parse(str, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(URL url) throws XmlException, IOException {
            return (CTPTab) XmlBeans.getContextTypeLoader().parse(url, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPTab) XmlBeans.getContextTypeLoader().parse(url, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPTab) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPTab) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(Node node) throws XmlException {
            return (CTPTab) XmlBeans.getContextTypeLoader().parse(node, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPTab) XmlBeans.getContextTypeLoader().parse(node, CTPTab.type, xmlOptions);
        }
    }

    STPTabAlignment$Enum getAlignment();

    STPTabLeader$Enum getLeader();

    STPTabRelativeTo$Enum getRelativeTo();

    void setAlignment(STPTabAlignment$Enum sTPTabAlignment$Enum);

    void setLeader(STPTabLeader$Enum sTPTabLeader$Enum);

    void setRelativeTo(STPTabRelativeTo$Enum sTPTabRelativeTo$Enum);

    STPTabAlignment xgetAlignment();

    STPTabLeader xgetLeader();

    STPTabRelativeTo xgetRelativeTo();

    void xsetAlignment(STPTabAlignment sTPTabAlignment);

    void xsetLeader(STPTabLeader sTPTabLeader);

    void xsetRelativeTo(STPTabRelativeTo sTPTabRelativeTo);
}
