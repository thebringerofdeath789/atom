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
public interface UniqueDocument extends XmlObject {
    public static final SchemaType type;

    Keybase addNewUnique();

    Keybase getUnique();

    void setUnique(Keybase keybase);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.UniqueDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$UniqueDocument;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$UniqueDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.UniqueDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$UniqueDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$UniqueDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("unique3752doctype");
    }

    public static final class Factory {
        public static UniqueDocument newInstance() {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().newInstance(UniqueDocument.type, null);
        }

        public static UniqueDocument newInstance(XmlOptions xmlOptions) {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().newInstance(UniqueDocument.type, xmlOptions);
        }

        public static UniqueDocument parse(String str) throws XmlException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(str, UniqueDocument.type, (XmlOptions) null);
        }

        public static UniqueDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(str, UniqueDocument.type, xmlOptions);
        }

        public static UniqueDocument parse(File file) throws XmlException, IOException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(file, UniqueDocument.type, (XmlOptions) null);
        }

        public static UniqueDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(file, UniqueDocument.type, xmlOptions);
        }

        public static UniqueDocument parse(URL url) throws XmlException, IOException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(url, UniqueDocument.type, (XmlOptions) null);
        }

        public static UniqueDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(url, UniqueDocument.type, xmlOptions);
        }

        public static UniqueDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(inputStream, UniqueDocument.type, (XmlOptions) null);
        }

        public static UniqueDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(inputStream, UniqueDocument.type, xmlOptions);
        }

        public static UniqueDocument parse(Reader reader) throws XmlException, IOException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(reader, UniqueDocument.type, (XmlOptions) null);
        }

        public static UniqueDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(reader, UniqueDocument.type, xmlOptions);
        }

        public static UniqueDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, UniqueDocument.type, (XmlOptions) null);
        }

        public static UniqueDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, UniqueDocument.type, xmlOptions);
        }

        public static UniqueDocument parse(Node node) throws XmlException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(node, UniqueDocument.type, (XmlOptions) null);
        }

        public static UniqueDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(node, UniqueDocument.type, xmlOptions);
        }

        public static UniqueDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, UniqueDocument.type, (XmlOptions) null);
        }

        public static UniqueDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, UniqueDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, UniqueDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, UniqueDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
