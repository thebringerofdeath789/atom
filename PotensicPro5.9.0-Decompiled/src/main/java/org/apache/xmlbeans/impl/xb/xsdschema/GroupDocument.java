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
public interface GroupDocument extends XmlObject {
    public static final SchemaType type;

    NamedGroup addNewGroup();

    NamedGroup getGroup();

    void setGroup(NamedGroup namedGroup);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$GroupDocument;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$GroupDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$GroupDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$GroupDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("group6eb6doctype");
    }

    public static final class Factory {
        public static GroupDocument newInstance() {
            return (GroupDocument) XmlBeans.getContextTypeLoader().newInstance(GroupDocument.type, null);
        }

        public static GroupDocument newInstance(XmlOptions xmlOptions) {
            return (GroupDocument) XmlBeans.getContextTypeLoader().newInstance(GroupDocument.type, xmlOptions);
        }

        public static GroupDocument parse(String str) throws XmlException {
            return (GroupDocument) XmlBeans.getContextTypeLoader().parse(str, GroupDocument.type, (XmlOptions) null);
        }

        public static GroupDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (GroupDocument) XmlBeans.getContextTypeLoader().parse(str, GroupDocument.type, xmlOptions);
        }

        public static GroupDocument parse(File file) throws XmlException, IOException {
            return (GroupDocument) XmlBeans.getContextTypeLoader().parse(file, GroupDocument.type, (XmlOptions) null);
        }

        public static GroupDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (GroupDocument) XmlBeans.getContextTypeLoader().parse(file, GroupDocument.type, xmlOptions);
        }

        public static GroupDocument parse(URL url) throws XmlException, IOException {
            return (GroupDocument) XmlBeans.getContextTypeLoader().parse(url, GroupDocument.type, (XmlOptions) null);
        }

        public static GroupDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (GroupDocument) XmlBeans.getContextTypeLoader().parse(url, GroupDocument.type, xmlOptions);
        }

        public static GroupDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (GroupDocument) XmlBeans.getContextTypeLoader().parse(inputStream, GroupDocument.type, (XmlOptions) null);
        }

        public static GroupDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (GroupDocument) XmlBeans.getContextTypeLoader().parse(inputStream, GroupDocument.type, xmlOptions);
        }

        public static GroupDocument parse(Reader reader) throws XmlException, IOException {
            return (GroupDocument) XmlBeans.getContextTypeLoader().parse(reader, GroupDocument.type, (XmlOptions) null);
        }

        public static GroupDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (GroupDocument) XmlBeans.getContextTypeLoader().parse(reader, GroupDocument.type, xmlOptions);
        }

        public static GroupDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (GroupDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, GroupDocument.type, (XmlOptions) null);
        }

        public static GroupDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (GroupDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, GroupDocument.type, xmlOptions);
        }

        public static GroupDocument parse(Node node) throws XmlException {
            return (GroupDocument) XmlBeans.getContextTypeLoader().parse(node, GroupDocument.type, (XmlOptions) null);
        }

        public static GroupDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (GroupDocument) XmlBeans.getContextTypeLoader().parse(node, GroupDocument.type, xmlOptions);
        }

        public static GroupDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (GroupDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, GroupDocument.type, (XmlOptions) null);
        }

        public static GroupDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (GroupDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, GroupDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, GroupDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, GroupDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
