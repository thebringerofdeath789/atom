package org.apache.xmlbeans.impl.xb.xmlconfig;

import aavax.xml.namespace.QName;
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
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface Usertypeconfig extends XmlObject {
    public static final SchemaType type;

    String getJavaname();

    QName getName();

    String getStaticHandler();

    boolean isSetJavaname();

    boolean isSetName();

    void setJavaname(String str);

    void setName(QName qName);

    void setStaticHandler(String str);

    void unsetJavaname();

    void unsetName();

    XmlString xgetJavaname();

    XmlQName xgetName();

    XmlString xgetStaticHandler();

    void xsetJavaname(XmlString xmlString);

    void xsetName(XmlQName xmlQName);

    void xsetStaticHandler(XmlString xmlString);

    /* renamed from: org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xmlconfig$Usertypeconfig;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$Usertypeconfig == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$Usertypeconfig = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$Usertypeconfig;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("usertypeconfig7bbatype");
    }

    public static final class Factory {
        public static Usertypeconfig newInstance() {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().newInstance(Usertypeconfig.type, null);
        }

        public static Usertypeconfig newInstance(XmlOptions xmlOptions) {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().newInstance(Usertypeconfig.type, xmlOptions);
        }

        public static Usertypeconfig parse(String str) throws XmlException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(str, Usertypeconfig.type, (XmlOptions) null);
        }

        public static Usertypeconfig parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(str, Usertypeconfig.type, xmlOptions);
        }

        public static Usertypeconfig parse(File file) throws XmlException, IOException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(file, Usertypeconfig.type, (XmlOptions) null);
        }

        public static Usertypeconfig parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(file, Usertypeconfig.type, xmlOptions);
        }

        public static Usertypeconfig parse(URL url) throws XmlException, IOException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(url, Usertypeconfig.type, (XmlOptions) null);
        }

        public static Usertypeconfig parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(url, Usertypeconfig.type, xmlOptions);
        }

        public static Usertypeconfig parse(InputStream inputStream) throws XmlException, IOException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(inputStream, Usertypeconfig.type, (XmlOptions) null);
        }

        public static Usertypeconfig parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(inputStream, Usertypeconfig.type, xmlOptions);
        }

        public static Usertypeconfig parse(Reader reader) throws XmlException, IOException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(reader, Usertypeconfig.type, (XmlOptions) null);
        }

        public static Usertypeconfig parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(reader, Usertypeconfig.type, xmlOptions);
        }

        public static Usertypeconfig parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Usertypeconfig.type, (XmlOptions) null);
        }

        public static Usertypeconfig parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Usertypeconfig.type, xmlOptions);
        }

        public static Usertypeconfig parse(Node node) throws XmlException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(node, Usertypeconfig.type, (XmlOptions) null);
        }

        public static Usertypeconfig parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(node, Usertypeconfig.type, xmlOptions);
        }

        public static Usertypeconfig parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Usertypeconfig.type, (XmlOptions) null);
        }

        public static Usertypeconfig parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Usertypeconfig.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Usertypeconfig.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Usertypeconfig.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
