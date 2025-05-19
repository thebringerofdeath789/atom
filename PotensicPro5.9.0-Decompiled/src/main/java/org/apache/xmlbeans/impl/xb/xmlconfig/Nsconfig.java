package org.apache.xmlbeans.impl.xb.xmlconfig;

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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface Nsconfig extends XmlObject {
    public static final SchemaType type;

    String getPackage();

    String getPrefix();

    String getSuffix();

    Object getUri();

    List getUriprefix();

    boolean isSetPackage();

    boolean isSetPrefix();

    boolean isSetSuffix();

    boolean isSetUri();

    boolean isSetUriprefix();

    void setPackage(String str);

    void setPrefix(String str);

    void setSuffix(String str);

    void setUri(Object obj);

    void setUriprefix(List list);

    void unsetPackage();

    void unsetPrefix();

    void unsetSuffix();

    void unsetUri();

    void unsetUriprefix();

    XmlString xgetPackage();

    XmlString xgetPrefix();

    XmlString xgetSuffix();

    NamespaceList xgetUri();

    NamespacePrefixList xgetUriprefix();

    void xsetPackage(XmlString xmlString);

    void xsetPrefix(XmlString xmlString);

    void xsetSuffix(XmlString xmlString);

    void xsetUri(NamespaceList namespaceList);

    void xsetUriprefix(NamespacePrefixList namespacePrefixList);

    /* renamed from: org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xmlconfig$Nsconfig;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$Nsconfig == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$Nsconfig = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$Nsconfig;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("nsconfigaebatype");
    }

    public static final class Factory {
        public static Nsconfig newInstance() {
            return (Nsconfig) XmlBeans.getContextTypeLoader().newInstance(Nsconfig.type, null);
        }

        public static Nsconfig newInstance(XmlOptions xmlOptions) {
            return (Nsconfig) XmlBeans.getContextTypeLoader().newInstance(Nsconfig.type, xmlOptions);
        }

        public static Nsconfig parse(String str) throws XmlException {
            return (Nsconfig) XmlBeans.getContextTypeLoader().parse(str, Nsconfig.type, (XmlOptions) null);
        }

        public static Nsconfig parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (Nsconfig) XmlBeans.getContextTypeLoader().parse(str, Nsconfig.type, xmlOptions);
        }

        public static Nsconfig parse(File file) throws XmlException, IOException {
            return (Nsconfig) XmlBeans.getContextTypeLoader().parse(file, Nsconfig.type, (XmlOptions) null);
        }

        public static Nsconfig parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Nsconfig) XmlBeans.getContextTypeLoader().parse(file, Nsconfig.type, xmlOptions);
        }

        public static Nsconfig parse(URL url) throws XmlException, IOException {
            return (Nsconfig) XmlBeans.getContextTypeLoader().parse(url, Nsconfig.type, (XmlOptions) null);
        }

        public static Nsconfig parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Nsconfig) XmlBeans.getContextTypeLoader().parse(url, Nsconfig.type, xmlOptions);
        }

        public static Nsconfig parse(InputStream inputStream) throws XmlException, IOException {
            return (Nsconfig) XmlBeans.getContextTypeLoader().parse(inputStream, Nsconfig.type, (XmlOptions) null);
        }

        public static Nsconfig parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Nsconfig) XmlBeans.getContextTypeLoader().parse(inputStream, Nsconfig.type, xmlOptions);
        }

        public static Nsconfig parse(Reader reader) throws XmlException, IOException {
            return (Nsconfig) XmlBeans.getContextTypeLoader().parse(reader, Nsconfig.type, (XmlOptions) null);
        }

        public static Nsconfig parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Nsconfig) XmlBeans.getContextTypeLoader().parse(reader, Nsconfig.type, xmlOptions);
        }

        public static Nsconfig parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (Nsconfig) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Nsconfig.type, (XmlOptions) null);
        }

        public static Nsconfig parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (Nsconfig) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Nsconfig.type, xmlOptions);
        }

        public static Nsconfig parse(Node node) throws XmlException {
            return (Nsconfig) XmlBeans.getContextTypeLoader().parse(node, Nsconfig.type, (XmlOptions) null);
        }

        public static Nsconfig parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (Nsconfig) XmlBeans.getContextTypeLoader().parse(node, Nsconfig.type, xmlOptions);
        }

        public static Nsconfig parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (Nsconfig) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Nsconfig.type, (XmlOptions) null);
        }

        public static Nsconfig parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (Nsconfig) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Nsconfig.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Nsconfig.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Nsconfig.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
