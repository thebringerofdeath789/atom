package org.apache.xmlbeans.impl.xb.xmlconfig;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface JavaName extends XmlToken {
    public static final SchemaType type;

    /* renamed from: org.apache.xmlbeans.impl.xb.xmlconfig.JavaName$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xmlconfig$JavaName;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$JavaName == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xmlconfig.JavaName");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$JavaName = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlconfig$JavaName;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("javanamee640type");
    }

    public static final class Factory {
        public static JavaName newValue(Object obj) {
            return (JavaName) JavaName.type.newValue(obj);
        }

        public static JavaName newInstance() {
            return (JavaName) XmlBeans.getContextTypeLoader().newInstance(JavaName.type, null);
        }

        public static JavaName newInstance(XmlOptions xmlOptions) {
            return (JavaName) XmlBeans.getContextTypeLoader().newInstance(JavaName.type, xmlOptions);
        }

        public static JavaName parse(String str) throws XmlException {
            return (JavaName) XmlBeans.getContextTypeLoader().parse(str, JavaName.type, (XmlOptions) null);
        }

        public static JavaName parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (JavaName) XmlBeans.getContextTypeLoader().parse(str, JavaName.type, xmlOptions);
        }

        public static JavaName parse(File file) throws XmlException, IOException {
            return (JavaName) XmlBeans.getContextTypeLoader().parse(file, JavaName.type, (XmlOptions) null);
        }

        public static JavaName parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (JavaName) XmlBeans.getContextTypeLoader().parse(file, JavaName.type, xmlOptions);
        }

        public static JavaName parse(URL url) throws XmlException, IOException {
            return (JavaName) XmlBeans.getContextTypeLoader().parse(url, JavaName.type, (XmlOptions) null);
        }

        public static JavaName parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (JavaName) XmlBeans.getContextTypeLoader().parse(url, JavaName.type, xmlOptions);
        }

        public static JavaName parse(InputStream inputStream) throws XmlException, IOException {
            return (JavaName) XmlBeans.getContextTypeLoader().parse(inputStream, JavaName.type, (XmlOptions) null);
        }

        public static JavaName parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (JavaName) XmlBeans.getContextTypeLoader().parse(inputStream, JavaName.type, xmlOptions);
        }

        public static JavaName parse(Reader reader) throws XmlException, IOException {
            return (JavaName) XmlBeans.getContextTypeLoader().parse(reader, JavaName.type, (XmlOptions) null);
        }

        public static JavaName parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (JavaName) XmlBeans.getContextTypeLoader().parse(reader, JavaName.type, xmlOptions);
        }

        public static JavaName parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (JavaName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, JavaName.type, (XmlOptions) null);
        }

        public static JavaName parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (JavaName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, JavaName.type, xmlOptions);
        }

        public static JavaName parse(Node node) throws XmlException {
            return (JavaName) XmlBeans.getContextTypeLoader().parse(node, JavaName.type, (XmlOptions) null);
        }

        public static JavaName parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (JavaName) XmlBeans.getContextTypeLoader().parse(node, JavaName.type, xmlOptions);
        }

        public static JavaName parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (JavaName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, JavaName.type, (XmlOptions) null);
        }

        public static JavaName parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (JavaName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, JavaName.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, JavaName.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, JavaName.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
