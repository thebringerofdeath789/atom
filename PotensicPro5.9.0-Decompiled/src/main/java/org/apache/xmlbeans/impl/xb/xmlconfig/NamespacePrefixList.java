package org.apache.xmlbeans.impl.xb.xmlconfig;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface NamespacePrefixList extends XmlAnySimpleType {
    public static final SchemaType type;

    List getListValue();

    List listValue();

    void set(List list);

    void setListValue(List list);

    List xgetListValue();

    List xlistValue();

    /* renamed from: org.apache.xmlbeans.impl.xb.xmlconfig.NamespacePrefixList$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespacePrefixList;

        static /* synthetic */ Class class$(String str) {
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException e) {
                throw new NoClassDefFoundError().initCause(e);
            }
        }
    }

    static {
        Class cls;
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespacePrefixList == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xmlconfig.NamespacePrefixList");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespacePrefixList = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$NamespacePrefixList;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("namespaceprefixlistec0ctype");
    }

    public static final class Factory {
        public static NamespacePrefixList newValue(Object obj) {
            return (NamespacePrefixList) NamespacePrefixList.type.newValue(obj);
        }

        public static NamespacePrefixList newInstance() {
            return (NamespacePrefixList) XmlBeans.getContextTypeLoader().newInstance(NamespacePrefixList.type, null);
        }

        public static NamespacePrefixList newInstance(XmlOptions xmlOptions) {
            return (NamespacePrefixList) XmlBeans.getContextTypeLoader().newInstance(NamespacePrefixList.type, xmlOptions);
        }

        public static NamespacePrefixList parse(String str) throws XmlException {
            return (NamespacePrefixList) XmlBeans.getContextTypeLoader().parse(str, NamespacePrefixList.type, (XmlOptions) null);
        }

        public static NamespacePrefixList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (NamespacePrefixList) XmlBeans.getContextTypeLoader().parse(str, NamespacePrefixList.type, xmlOptions);
        }

        public static NamespacePrefixList parse(File file) throws XmlException, IOException {
            return (NamespacePrefixList) XmlBeans.getContextTypeLoader().parse(file, NamespacePrefixList.type, (XmlOptions) null);
        }

        public static NamespacePrefixList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NamespacePrefixList) XmlBeans.getContextTypeLoader().parse(file, NamespacePrefixList.type, xmlOptions);
        }

        public static NamespacePrefixList parse(URL url) throws XmlException, IOException {
            return (NamespacePrefixList) XmlBeans.getContextTypeLoader().parse(url, NamespacePrefixList.type, (XmlOptions) null);
        }

        public static NamespacePrefixList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NamespacePrefixList) XmlBeans.getContextTypeLoader().parse(url, NamespacePrefixList.type, xmlOptions);
        }

        public static NamespacePrefixList parse(InputStream inputStream) throws XmlException, IOException {
            return (NamespacePrefixList) XmlBeans.getContextTypeLoader().parse(inputStream, NamespacePrefixList.type, (XmlOptions) null);
        }

        public static NamespacePrefixList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NamespacePrefixList) XmlBeans.getContextTypeLoader().parse(inputStream, NamespacePrefixList.type, xmlOptions);
        }

        public static NamespacePrefixList parse(Reader reader) throws XmlException, IOException {
            return (NamespacePrefixList) XmlBeans.getContextTypeLoader().parse(reader, NamespacePrefixList.type, (XmlOptions) null);
        }

        public static NamespacePrefixList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NamespacePrefixList) XmlBeans.getContextTypeLoader().parse(reader, NamespacePrefixList.type, xmlOptions);
        }

        public static NamespacePrefixList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (NamespacePrefixList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NamespacePrefixList.type, (XmlOptions) null);
        }

        public static NamespacePrefixList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (NamespacePrefixList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NamespacePrefixList.type, xmlOptions);
        }

        public static NamespacePrefixList parse(Node node) throws XmlException {
            return (NamespacePrefixList) XmlBeans.getContextTypeLoader().parse(node, NamespacePrefixList.type, (XmlOptions) null);
        }

        public static NamespacePrefixList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (NamespacePrefixList) XmlBeans.getContextTypeLoader().parse(node, NamespacePrefixList.type, xmlOptions);
        }

        public static NamespacePrefixList parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (NamespacePrefixList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NamespacePrefixList.type, (XmlOptions) null);
        }

        public static NamespacePrefixList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (NamespacePrefixList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NamespacePrefixList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NamespacePrefixList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NamespacePrefixList.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
