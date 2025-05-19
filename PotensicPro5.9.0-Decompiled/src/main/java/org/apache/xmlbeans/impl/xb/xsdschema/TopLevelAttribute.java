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
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface TopLevelAttribute extends Attribute {
    public static final SchemaType type;

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    String getName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    boolean isSetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    void setName(String str);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    void unsetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    XmlNCName xgetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    void xsetName(XmlNCName xmlNCName);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelAttribute;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelAttribute == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelAttribute = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelAttribute;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("toplevelattributeb338type");
    }

    public static final class Factory {
        public static TopLevelAttribute newInstance() {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().newInstance(TopLevelAttribute.type, null);
        }

        public static TopLevelAttribute newInstance(XmlOptions xmlOptions) {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().newInstance(TopLevelAttribute.type, xmlOptions);
        }

        public static TopLevelAttribute parse(String str) throws XmlException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(str, TopLevelAttribute.type, (XmlOptions) null);
        }

        public static TopLevelAttribute parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(str, TopLevelAttribute.type, xmlOptions);
        }

        public static TopLevelAttribute parse(File file) throws XmlException, IOException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(file, TopLevelAttribute.type, (XmlOptions) null);
        }

        public static TopLevelAttribute parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(file, TopLevelAttribute.type, xmlOptions);
        }

        public static TopLevelAttribute parse(URL url) throws XmlException, IOException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(url, TopLevelAttribute.type, (XmlOptions) null);
        }

        public static TopLevelAttribute parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(url, TopLevelAttribute.type, xmlOptions);
        }

        public static TopLevelAttribute parse(InputStream inputStream) throws XmlException, IOException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(inputStream, TopLevelAttribute.type, (XmlOptions) null);
        }

        public static TopLevelAttribute parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(inputStream, TopLevelAttribute.type, xmlOptions);
        }

        public static TopLevelAttribute parse(Reader reader) throws XmlException, IOException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(reader, TopLevelAttribute.type, (XmlOptions) null);
        }

        public static TopLevelAttribute parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(reader, TopLevelAttribute.type, xmlOptions);
        }

        public static TopLevelAttribute parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TopLevelAttribute.type, (XmlOptions) null);
        }

        public static TopLevelAttribute parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TopLevelAttribute.type, xmlOptions);
        }

        public static TopLevelAttribute parse(Node node) throws XmlException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(node, TopLevelAttribute.type, (XmlOptions) null);
        }

        public static TopLevelAttribute parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(node, TopLevelAttribute.type, xmlOptions);
        }

        public static TopLevelAttribute parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TopLevelAttribute.type, (XmlOptions) null);
        }

        public static TopLevelAttribute parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TopLevelAttribute.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TopLevelAttribute.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TopLevelAttribute.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
