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
public interface AllDocument extends XmlObject {
    public static final SchemaType type;

    All addNewAll();

    All getAll();

    void setAll(All all);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.AllDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$AllDocument;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AllDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.AllDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AllDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AllDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("all7214doctype");
    }

    public static final class Factory {
        public static AllDocument newInstance() {
            return (AllDocument) XmlBeans.getContextTypeLoader().newInstance(AllDocument.type, null);
        }

        public static AllDocument newInstance(XmlOptions xmlOptions) {
            return (AllDocument) XmlBeans.getContextTypeLoader().newInstance(AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(String str) throws XmlException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(str, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(str, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(File file) throws XmlException, IOException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(file, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(file, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(URL url) throws XmlException, IOException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(url, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(url, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(Reader reader) throws XmlException, IOException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(reader, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(reader, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(Node node) throws XmlException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(node, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(node, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AllDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AllDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AllDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
