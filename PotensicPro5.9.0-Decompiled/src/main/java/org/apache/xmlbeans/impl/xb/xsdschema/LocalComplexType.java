package org.apache.xmlbeans.impl.xb.xsdschema;

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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface LocalComplexType extends ComplexType {
    public static final SchemaType type;

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.LocalComplexType$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$LocalComplexType;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$LocalComplexType == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.LocalComplexType");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$LocalComplexType = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$LocalComplexType;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("localcomplextype6494type");
    }

    public static final class Factory {
        public static LocalComplexType newInstance() {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().newInstance(LocalComplexType.type, null);
        }

        public static LocalComplexType newInstance(XmlOptions xmlOptions) {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().newInstance(LocalComplexType.type, xmlOptions);
        }

        public static LocalComplexType parse(String str) throws XmlException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(str, LocalComplexType.type, (XmlOptions) null);
        }

        public static LocalComplexType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(str, LocalComplexType.type, xmlOptions);
        }

        public static LocalComplexType parse(File file) throws XmlException, IOException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(file, LocalComplexType.type, (XmlOptions) null);
        }

        public static LocalComplexType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(file, LocalComplexType.type, xmlOptions);
        }

        public static LocalComplexType parse(URL url) throws XmlException, IOException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(url, LocalComplexType.type, (XmlOptions) null);
        }

        public static LocalComplexType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(url, LocalComplexType.type, xmlOptions);
        }

        public static LocalComplexType parse(InputStream inputStream) throws XmlException, IOException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(inputStream, LocalComplexType.type, (XmlOptions) null);
        }

        public static LocalComplexType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(inputStream, LocalComplexType.type, xmlOptions);
        }

        public static LocalComplexType parse(Reader reader) throws XmlException, IOException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(reader, LocalComplexType.type, (XmlOptions) null);
        }

        public static LocalComplexType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(reader, LocalComplexType.type, xmlOptions);
        }

        public static LocalComplexType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, LocalComplexType.type, (XmlOptions) null);
        }

        public static LocalComplexType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, LocalComplexType.type, xmlOptions);
        }

        public static LocalComplexType parse(Node node) throws XmlException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(node, LocalComplexType.type, (XmlOptions) null);
        }

        public static LocalComplexType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(node, LocalComplexType.type, xmlOptions);
        }

        public static LocalComplexType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, LocalComplexType.type, (XmlOptions) null);
        }

        public static LocalComplexType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, LocalComplexType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, LocalComplexType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, LocalComplexType.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
