package org.apache.xmlbeans.impl.xb.xsdschema;

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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface AttributeGroupRef extends AttributeGroup {
    public static final SchemaType type;

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    QName getRef();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    boolean isSetRef();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    void setRef(QName qName);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    void unsetRef();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    XmlQName xgetRef();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    void xsetRef(XmlQName xmlQName);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeGroupRef;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeGroupRef == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeGroupRef = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeGroupRef;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("attributegroupref8375type");
    }

    public static final class Factory {
        public static AttributeGroupRef newInstance() {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().newInstance(AttributeGroupRef.type, null);
        }

        public static AttributeGroupRef newInstance(XmlOptions xmlOptions) {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().newInstance(AttributeGroupRef.type, xmlOptions);
        }

        public static AttributeGroupRef parse(String str) throws XmlException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(str, AttributeGroupRef.type, (XmlOptions) null);
        }

        public static AttributeGroupRef parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(str, AttributeGroupRef.type, xmlOptions);
        }

        public static AttributeGroupRef parse(File file) throws XmlException, IOException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(file, AttributeGroupRef.type, (XmlOptions) null);
        }

        public static AttributeGroupRef parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(file, AttributeGroupRef.type, xmlOptions);
        }

        public static AttributeGroupRef parse(URL url) throws XmlException, IOException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(url, AttributeGroupRef.type, (XmlOptions) null);
        }

        public static AttributeGroupRef parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(url, AttributeGroupRef.type, xmlOptions);
        }

        public static AttributeGroupRef parse(InputStream inputStream) throws XmlException, IOException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(inputStream, AttributeGroupRef.type, (XmlOptions) null);
        }

        public static AttributeGroupRef parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(inputStream, AttributeGroupRef.type, xmlOptions);
        }

        public static AttributeGroupRef parse(Reader reader) throws XmlException, IOException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(reader, AttributeGroupRef.type, (XmlOptions) null);
        }

        public static AttributeGroupRef parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(reader, AttributeGroupRef.type, xmlOptions);
        }

        public static AttributeGroupRef parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AttributeGroupRef.type, (XmlOptions) null);
        }

        public static AttributeGroupRef parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AttributeGroupRef.type, xmlOptions);
        }

        public static AttributeGroupRef parse(Node node) throws XmlException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(node, AttributeGroupRef.type, (XmlOptions) null);
        }

        public static AttributeGroupRef parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(node, AttributeGroupRef.type, xmlOptions);
        }

        public static AttributeGroupRef parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AttributeGroupRef.type, (XmlOptions) null);
        }

        public static AttributeGroupRef parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AttributeGroupRef.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AttributeGroupRef.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AttributeGroupRef.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
