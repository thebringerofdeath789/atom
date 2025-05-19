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
public interface GroupRef extends RealGroup {
    public static final SchemaType type;

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    QName getRef();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    boolean isSetRef();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void setRef(QName qName);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void unsetRef();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    XmlQName xgetRef();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void xsetRef(XmlQName xmlQName);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.GroupRef$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$GroupRef;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$GroupRef == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.GroupRef");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$GroupRef = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$GroupRef;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("groupref303ftype");
    }

    public static final class Factory {
        public static GroupRef newInstance() {
            return (GroupRef) XmlBeans.getContextTypeLoader().newInstance(GroupRef.type, null);
        }

        public static GroupRef newInstance(XmlOptions xmlOptions) {
            return (GroupRef) XmlBeans.getContextTypeLoader().newInstance(GroupRef.type, xmlOptions);
        }

        public static GroupRef parse(String str) throws XmlException {
            return (GroupRef) XmlBeans.getContextTypeLoader().parse(str, GroupRef.type, (XmlOptions) null);
        }

        public static GroupRef parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (GroupRef) XmlBeans.getContextTypeLoader().parse(str, GroupRef.type, xmlOptions);
        }

        public static GroupRef parse(File file) throws XmlException, IOException {
            return (GroupRef) XmlBeans.getContextTypeLoader().parse(file, GroupRef.type, (XmlOptions) null);
        }

        public static GroupRef parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (GroupRef) XmlBeans.getContextTypeLoader().parse(file, GroupRef.type, xmlOptions);
        }

        public static GroupRef parse(URL url) throws XmlException, IOException {
            return (GroupRef) XmlBeans.getContextTypeLoader().parse(url, GroupRef.type, (XmlOptions) null);
        }

        public static GroupRef parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (GroupRef) XmlBeans.getContextTypeLoader().parse(url, GroupRef.type, xmlOptions);
        }

        public static GroupRef parse(InputStream inputStream) throws XmlException, IOException {
            return (GroupRef) XmlBeans.getContextTypeLoader().parse(inputStream, GroupRef.type, (XmlOptions) null);
        }

        public static GroupRef parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (GroupRef) XmlBeans.getContextTypeLoader().parse(inputStream, GroupRef.type, xmlOptions);
        }

        public static GroupRef parse(Reader reader) throws XmlException, IOException {
            return (GroupRef) XmlBeans.getContextTypeLoader().parse(reader, GroupRef.type, (XmlOptions) null);
        }

        public static GroupRef parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (GroupRef) XmlBeans.getContextTypeLoader().parse(reader, GroupRef.type, xmlOptions);
        }

        public static GroupRef parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (GroupRef) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, GroupRef.type, (XmlOptions) null);
        }

        public static GroupRef parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (GroupRef) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, GroupRef.type, xmlOptions);
        }

        public static GroupRef parse(Node node) throws XmlException {
            return (GroupRef) XmlBeans.getContextTypeLoader().parse(node, GroupRef.type, (XmlOptions) null);
        }

        public static GroupRef parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (GroupRef) XmlBeans.getContextTypeLoader().parse(node, GroupRef.type, xmlOptions);
        }

        public static GroupRef parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (GroupRef) XmlBeans.getContextTypeLoader().parse(xMLInputStream, GroupRef.type, (XmlOptions) null);
        }

        public static GroupRef parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (GroupRef) XmlBeans.getContextTypeLoader().parse(xMLInputStream, GroupRef.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, GroupRef.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, GroupRef.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
