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
public interface MaxExclusiveDocument extends XmlObject {
    public static final SchemaType type;

    Facet addNewMaxExclusive();

    Facet getMaxExclusive();

    void setMaxExclusive(Facet facet);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.MaxExclusiveDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$MaxExclusiveDocument;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$MaxExclusiveDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.MaxExclusiveDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$MaxExclusiveDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$MaxExclusiveDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("maxexclusive6d69doctype");
    }

    public static final class Factory {
        public static MaxExclusiveDocument newInstance() {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().newInstance(MaxExclusiveDocument.type, null);
        }

        public static MaxExclusiveDocument newInstance(XmlOptions xmlOptions) {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().newInstance(MaxExclusiveDocument.type, xmlOptions);
        }

        public static MaxExclusiveDocument parse(String str) throws XmlException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(str, MaxExclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxExclusiveDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(str, MaxExclusiveDocument.type, xmlOptions);
        }

        public static MaxExclusiveDocument parse(File file) throws XmlException, IOException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(file, MaxExclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxExclusiveDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(file, MaxExclusiveDocument.type, xmlOptions);
        }

        public static MaxExclusiveDocument parse(URL url) throws XmlException, IOException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(url, MaxExclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxExclusiveDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(url, MaxExclusiveDocument.type, xmlOptions);
        }

        public static MaxExclusiveDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MaxExclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxExclusiveDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MaxExclusiveDocument.type, xmlOptions);
        }

        public static MaxExclusiveDocument parse(Reader reader) throws XmlException, IOException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(reader, MaxExclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxExclusiveDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(reader, MaxExclusiveDocument.type, xmlOptions);
        }

        public static MaxExclusiveDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MaxExclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxExclusiveDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MaxExclusiveDocument.type, xmlOptions);
        }

        public static MaxExclusiveDocument parse(Node node) throws XmlException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(node, MaxExclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxExclusiveDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(node, MaxExclusiveDocument.type, xmlOptions);
        }

        public static MaxExclusiveDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MaxExclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxExclusiveDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MaxExclusiveDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MaxExclusiveDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MaxExclusiveDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
