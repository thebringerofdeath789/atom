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
public interface NamedAttributeGroup extends AttributeGroup {
    public static final SchemaType type;

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    String getName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    boolean isSetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    void setName(String str);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    void unsetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    XmlNCName xgetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    void xsetName(XmlNCName xmlNCName);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$NamedAttributeGroup;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamedAttributeGroup == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamedAttributeGroup = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamedAttributeGroup;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("namedattributegroup2e29type");
    }

    public static final class Factory {
        public static NamedAttributeGroup newInstance() {
            return (NamedAttributeGroup) XmlBeans.getContextTypeLoader().newInstance(NamedAttributeGroup.type, null);
        }

        public static NamedAttributeGroup newInstance(XmlOptions xmlOptions) {
            return (NamedAttributeGroup) XmlBeans.getContextTypeLoader().newInstance(NamedAttributeGroup.type, xmlOptions);
        }

        public static NamedAttributeGroup parse(String str) throws XmlException {
            return (NamedAttributeGroup) XmlBeans.getContextTypeLoader().parse(str, NamedAttributeGroup.type, (XmlOptions) null);
        }

        public static NamedAttributeGroup parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (NamedAttributeGroup) XmlBeans.getContextTypeLoader().parse(str, NamedAttributeGroup.type, xmlOptions);
        }

        public static NamedAttributeGroup parse(File file) throws XmlException, IOException {
            return (NamedAttributeGroup) XmlBeans.getContextTypeLoader().parse(file, NamedAttributeGroup.type, (XmlOptions) null);
        }

        public static NamedAttributeGroup parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NamedAttributeGroup) XmlBeans.getContextTypeLoader().parse(file, NamedAttributeGroup.type, xmlOptions);
        }

        public static NamedAttributeGroup parse(URL url) throws XmlException, IOException {
            return (NamedAttributeGroup) XmlBeans.getContextTypeLoader().parse(url, NamedAttributeGroup.type, (XmlOptions) null);
        }

        public static NamedAttributeGroup parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NamedAttributeGroup) XmlBeans.getContextTypeLoader().parse(url, NamedAttributeGroup.type, xmlOptions);
        }

        public static NamedAttributeGroup parse(InputStream inputStream) throws XmlException, IOException {
            return (NamedAttributeGroup) XmlBeans.getContextTypeLoader().parse(inputStream, NamedAttributeGroup.type, (XmlOptions) null);
        }

        public static NamedAttributeGroup parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NamedAttributeGroup) XmlBeans.getContextTypeLoader().parse(inputStream, NamedAttributeGroup.type, xmlOptions);
        }

        public static NamedAttributeGroup parse(Reader reader) throws XmlException, IOException {
            return (NamedAttributeGroup) XmlBeans.getContextTypeLoader().parse(reader, NamedAttributeGroup.type, (XmlOptions) null);
        }

        public static NamedAttributeGroup parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NamedAttributeGroup) XmlBeans.getContextTypeLoader().parse(reader, NamedAttributeGroup.type, xmlOptions);
        }

        public static NamedAttributeGroup parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (NamedAttributeGroup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NamedAttributeGroup.type, (XmlOptions) null);
        }

        public static NamedAttributeGroup parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (NamedAttributeGroup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NamedAttributeGroup.type, xmlOptions);
        }

        public static NamedAttributeGroup parse(Node node) throws XmlException {
            return (NamedAttributeGroup) XmlBeans.getContextTypeLoader().parse(node, NamedAttributeGroup.type, (XmlOptions) null);
        }

        public static NamedAttributeGroup parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (NamedAttributeGroup) XmlBeans.getContextTypeLoader().parse(node, NamedAttributeGroup.type, xmlOptions);
        }

        public static NamedAttributeGroup parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (NamedAttributeGroup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NamedAttributeGroup.type, (XmlOptions) null);
        }

        public static NamedAttributeGroup parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (NamedAttributeGroup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NamedAttributeGroup.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NamedAttributeGroup.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NamedAttributeGroup.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
