package org.apache.xmlbeans.impl.xb.xmlschema;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlLanguage;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface LangAttribute extends XmlObject {
    public static final SchemaType type;

    String getLang();

    boolean isSetLang();

    void setLang(String str);

    void unsetLang();

    XmlLanguage xgetLang();

    void xsetLang(XmlLanguage xmlLanguage);

    /* renamed from: org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xmlschema$LangAttribute;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlschema$LangAttribute == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlschema$LangAttribute = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xmlschema$LangAttribute;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLLANG").resolveHandle("lange126attrtypetype");
    }

    public static final class Factory {
        public static LangAttribute newInstance() {
            return (LangAttribute) XmlBeans.getContextTypeLoader().newInstance(LangAttribute.type, null);
        }

        public static LangAttribute newInstance(XmlOptions xmlOptions) {
            return (LangAttribute) XmlBeans.getContextTypeLoader().newInstance(LangAttribute.type, xmlOptions);
        }

        public static LangAttribute parse(String str) throws XmlException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(str, LangAttribute.type, (XmlOptions) null);
        }

        public static LangAttribute parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(str, LangAttribute.type, xmlOptions);
        }

        public static LangAttribute parse(File file) throws XmlException, IOException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(file, LangAttribute.type, (XmlOptions) null);
        }

        public static LangAttribute parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(file, LangAttribute.type, xmlOptions);
        }

        public static LangAttribute parse(URL url) throws XmlException, IOException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(url, LangAttribute.type, (XmlOptions) null);
        }

        public static LangAttribute parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(url, LangAttribute.type, xmlOptions);
        }

        public static LangAttribute parse(InputStream inputStream) throws XmlException, IOException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(inputStream, LangAttribute.type, (XmlOptions) null);
        }

        public static LangAttribute parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(inputStream, LangAttribute.type, xmlOptions);
        }

        public static LangAttribute parse(Reader reader) throws XmlException, IOException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(reader, LangAttribute.type, (XmlOptions) null);
        }

        public static LangAttribute parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(reader, LangAttribute.type, xmlOptions);
        }

        public static LangAttribute parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, LangAttribute.type, (XmlOptions) null);
        }

        public static LangAttribute parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, LangAttribute.type, xmlOptions);
        }

        public static LangAttribute parse(Node node) throws XmlException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(node, LangAttribute.type, (XmlOptions) null);
        }

        public static LangAttribute parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(node, LangAttribute.type, xmlOptions);
        }

        public static LangAttribute parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(xMLInputStream, LangAttribute.type, (XmlOptions) null);
        }

        public static LangAttribute parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(xMLInputStream, LangAttribute.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, LangAttribute.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, LangAttribute.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
