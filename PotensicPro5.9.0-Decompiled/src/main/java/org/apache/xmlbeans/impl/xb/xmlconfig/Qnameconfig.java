package org.apache.xmlbeans.impl.xb.xmlconfig;

import aavax.xml.namespace.QName;
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
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface Qnameconfig extends XmlObject {
    public static final SchemaType type;

    String getJavaname();

    QName getName();

    List getTarget();

    boolean isSetJavaname();

    boolean isSetName();

    boolean isSetTarget();

    void setJavaname(String str);

    void setName(QName qName);

    void setTarget(List list);

    void unsetJavaname();

    void unsetName();

    void unsetTarget();

    XmlString xgetJavaname();

    XmlQName xgetName();

    Qnametargetlist xgetTarget();

    void xsetJavaname(XmlString xmlString);

    void xsetName(XmlQName xmlQName);

    void xsetTarget(Qnametargetlist qnametargetlist);

    /* renamed from: org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xmlconfig$Qnameconfig;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$Qnameconfig == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$Qnameconfig = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$Qnameconfig;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("qnameconfig463ftype");
    }

    public static final class Factory {
        public static Qnameconfig newInstance() {
            return (Qnameconfig) XmlBeans.getContextTypeLoader().newInstance(Qnameconfig.type, null);
        }

        public static Qnameconfig newInstance(XmlOptions xmlOptions) {
            return (Qnameconfig) XmlBeans.getContextTypeLoader().newInstance(Qnameconfig.type, xmlOptions);
        }

        public static Qnameconfig parse(String str) throws XmlException {
            return (Qnameconfig) XmlBeans.getContextTypeLoader().parse(str, Qnameconfig.type, (XmlOptions) null);
        }

        public static Qnameconfig parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (Qnameconfig) XmlBeans.getContextTypeLoader().parse(str, Qnameconfig.type, xmlOptions);
        }

        public static Qnameconfig parse(File file) throws XmlException, IOException {
            return (Qnameconfig) XmlBeans.getContextTypeLoader().parse(file, Qnameconfig.type, (XmlOptions) null);
        }

        public static Qnameconfig parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Qnameconfig) XmlBeans.getContextTypeLoader().parse(file, Qnameconfig.type, xmlOptions);
        }

        public static Qnameconfig parse(URL url) throws XmlException, IOException {
            return (Qnameconfig) XmlBeans.getContextTypeLoader().parse(url, Qnameconfig.type, (XmlOptions) null);
        }

        public static Qnameconfig parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Qnameconfig) XmlBeans.getContextTypeLoader().parse(url, Qnameconfig.type, xmlOptions);
        }

        public static Qnameconfig parse(InputStream inputStream) throws XmlException, IOException {
            return (Qnameconfig) XmlBeans.getContextTypeLoader().parse(inputStream, Qnameconfig.type, (XmlOptions) null);
        }

        public static Qnameconfig parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Qnameconfig) XmlBeans.getContextTypeLoader().parse(inputStream, Qnameconfig.type, xmlOptions);
        }

        public static Qnameconfig parse(Reader reader) throws XmlException, IOException {
            return (Qnameconfig) XmlBeans.getContextTypeLoader().parse(reader, Qnameconfig.type, (XmlOptions) null);
        }

        public static Qnameconfig parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Qnameconfig) XmlBeans.getContextTypeLoader().parse(reader, Qnameconfig.type, xmlOptions);
        }

        public static Qnameconfig parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (Qnameconfig) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Qnameconfig.type, (XmlOptions) null);
        }

        public static Qnameconfig parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (Qnameconfig) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Qnameconfig.type, xmlOptions);
        }

        public static Qnameconfig parse(Node node) throws XmlException {
            return (Qnameconfig) XmlBeans.getContextTypeLoader().parse(node, Qnameconfig.type, (XmlOptions) null);
        }

        public static Qnameconfig parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (Qnameconfig) XmlBeans.getContextTypeLoader().parse(node, Qnameconfig.type, xmlOptions);
        }

        public static Qnameconfig parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (Qnameconfig) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Qnameconfig.type, (XmlOptions) null);
        }

        public static Qnameconfig parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (Qnameconfig) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Qnameconfig.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Qnameconfig.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Qnameconfig.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
