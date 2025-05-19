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
public interface MinExclusiveDocument extends XmlObject {
    public static final SchemaType type;

    Facet addNewMinExclusive();

    Facet getMinExclusive();

    void setMinExclusive(Facet facet);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.MinExclusiveDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$MinExclusiveDocument;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$MinExclusiveDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.MinExclusiveDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$MinExclusiveDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$MinExclusiveDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("minexclusive64d7doctype");
    }

    public static final class Factory {
        public static MinExclusiveDocument newInstance() {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().newInstance(MinExclusiveDocument.type, null);
        }

        public static MinExclusiveDocument newInstance(XmlOptions xmlOptions) {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().newInstance(MinExclusiveDocument.type, xmlOptions);
        }

        public static MinExclusiveDocument parse(String str) throws XmlException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(str, MinExclusiveDocument.type, (XmlOptions) null);
        }

        public static MinExclusiveDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(str, MinExclusiveDocument.type, xmlOptions);
        }

        public static MinExclusiveDocument parse(File file) throws XmlException, IOException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(file, MinExclusiveDocument.type, (XmlOptions) null);
        }

        public static MinExclusiveDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(file, MinExclusiveDocument.type, xmlOptions);
        }

        public static MinExclusiveDocument parse(URL url) throws XmlException, IOException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(url, MinExclusiveDocument.type, (XmlOptions) null);
        }

        public static MinExclusiveDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(url, MinExclusiveDocument.type, xmlOptions);
        }

        public static MinExclusiveDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MinExclusiveDocument.type, (XmlOptions) null);
        }

        public static MinExclusiveDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MinExclusiveDocument.type, xmlOptions);
        }

        public static MinExclusiveDocument parse(Reader reader) throws XmlException, IOException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(reader, MinExclusiveDocument.type, (XmlOptions) null);
        }

        public static MinExclusiveDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(reader, MinExclusiveDocument.type, xmlOptions);
        }

        public static MinExclusiveDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MinExclusiveDocument.type, (XmlOptions) null);
        }

        public static MinExclusiveDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MinExclusiveDocument.type, xmlOptions);
        }

        public static MinExclusiveDocument parse(Node node) throws XmlException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(node, MinExclusiveDocument.type, (XmlOptions) null);
        }

        public static MinExclusiveDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(node, MinExclusiveDocument.type, xmlOptions);
        }

        public static MinExclusiveDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MinExclusiveDocument.type, (XmlOptions) null);
        }

        public static MinExclusiveDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MinExclusiveDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MinExclusiveDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MinExclusiveDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
