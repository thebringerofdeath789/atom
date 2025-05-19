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
public interface MinInclusiveDocument extends XmlObject {
    public static final SchemaType type;

    Facet addNewMinInclusive();

    Facet getMinInclusive();

    void setMinInclusive(Facet facet);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.MinInclusiveDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$MinInclusiveDocument;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$MinInclusiveDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.MinInclusiveDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$MinInclusiveDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$MinInclusiveDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("mininclusive8b49doctype");
    }

    public static final class Factory {
        public static MinInclusiveDocument newInstance() {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().newInstance(MinInclusiveDocument.type, null);
        }

        public static MinInclusiveDocument newInstance(XmlOptions xmlOptions) {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().newInstance(MinInclusiveDocument.type, xmlOptions);
        }

        public static MinInclusiveDocument parse(String str) throws XmlException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(str, MinInclusiveDocument.type, (XmlOptions) null);
        }

        public static MinInclusiveDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(str, MinInclusiveDocument.type, xmlOptions);
        }

        public static MinInclusiveDocument parse(File file) throws XmlException, IOException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(file, MinInclusiveDocument.type, (XmlOptions) null);
        }

        public static MinInclusiveDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(file, MinInclusiveDocument.type, xmlOptions);
        }

        public static MinInclusiveDocument parse(URL url) throws XmlException, IOException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(url, MinInclusiveDocument.type, (XmlOptions) null);
        }

        public static MinInclusiveDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(url, MinInclusiveDocument.type, xmlOptions);
        }

        public static MinInclusiveDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MinInclusiveDocument.type, (XmlOptions) null);
        }

        public static MinInclusiveDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MinInclusiveDocument.type, xmlOptions);
        }

        public static MinInclusiveDocument parse(Reader reader) throws XmlException, IOException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(reader, MinInclusiveDocument.type, (XmlOptions) null);
        }

        public static MinInclusiveDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(reader, MinInclusiveDocument.type, xmlOptions);
        }

        public static MinInclusiveDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MinInclusiveDocument.type, (XmlOptions) null);
        }

        public static MinInclusiveDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MinInclusiveDocument.type, xmlOptions);
        }

        public static MinInclusiveDocument parse(Node node) throws XmlException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(node, MinInclusiveDocument.type, (XmlOptions) null);
        }

        public static MinInclusiveDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(node, MinInclusiveDocument.type, xmlOptions);
        }

        public static MinInclusiveDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MinInclusiveDocument.type, (XmlOptions) null);
        }

        public static MinInclusiveDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MinInclusiveDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MinInclusiveDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MinInclusiveDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
