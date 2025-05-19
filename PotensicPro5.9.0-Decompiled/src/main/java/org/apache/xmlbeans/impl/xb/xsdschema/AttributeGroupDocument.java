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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface AttributeGroupDocument extends XmlObject {
    public static final SchemaType type;

    NamedAttributeGroup addNewAttributeGroup();

    NamedAttributeGroup getAttributeGroup();

    void setAttributeGroup(NamedAttributeGroup namedAttributeGroup);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeGroupDocument;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeGroupDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeGroupDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeGroupDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("attributegroup4520doctype");
    }

    public static final class Factory {
        public static AttributeGroupDocument newInstance() {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().newInstance(AttributeGroupDocument.type, null);
        }

        public static AttributeGroupDocument newInstance(XmlOptions xmlOptions) {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().newInstance(AttributeGroupDocument.type, xmlOptions);
        }

        public static AttributeGroupDocument parse(String str) throws XmlException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(str, AttributeGroupDocument.type, (XmlOptions) null);
        }

        public static AttributeGroupDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(str, AttributeGroupDocument.type, xmlOptions);
        }

        public static AttributeGroupDocument parse(File file) throws XmlException, IOException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(file, AttributeGroupDocument.type, (XmlOptions) null);
        }

        public static AttributeGroupDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(file, AttributeGroupDocument.type, xmlOptions);
        }

        public static AttributeGroupDocument parse(URL url) throws XmlException, IOException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(url, AttributeGroupDocument.type, (XmlOptions) null);
        }

        public static AttributeGroupDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(url, AttributeGroupDocument.type, xmlOptions);
        }

        public static AttributeGroupDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AttributeGroupDocument.type, (XmlOptions) null);
        }

        public static AttributeGroupDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AttributeGroupDocument.type, xmlOptions);
        }

        public static AttributeGroupDocument parse(Reader reader) throws XmlException, IOException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(reader, AttributeGroupDocument.type, (XmlOptions) null);
        }

        public static AttributeGroupDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(reader, AttributeGroupDocument.type, xmlOptions);
        }

        public static AttributeGroupDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AttributeGroupDocument.type, (XmlOptions) null);
        }

        public static AttributeGroupDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AttributeGroupDocument.type, xmlOptions);
        }

        public static AttributeGroupDocument parse(Node node) throws XmlException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(node, AttributeGroupDocument.type, (XmlOptions) null);
        }

        public static AttributeGroupDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(node, AttributeGroupDocument.type, xmlOptions);
        }

        public static AttributeGroupDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AttributeGroupDocument.type, (XmlOptions) null);
        }

        public static AttributeGroupDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AttributeGroupDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AttributeGroupDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AttributeGroupDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
