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
public interface LengthDocument extends XmlObject {
    public static final SchemaType type;

    NumFacet addNewLength();

    NumFacet getLength();

    void setLength(NumFacet numFacet);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.LengthDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$LengthDocument;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$LengthDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.LengthDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$LengthDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$LengthDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("length7edddoctype");
    }

    public static final class Factory {
        public static LengthDocument newInstance() {
            return (LengthDocument) XmlBeans.getContextTypeLoader().newInstance(LengthDocument.type, null);
        }

        public static LengthDocument newInstance(XmlOptions xmlOptions) {
            return (LengthDocument) XmlBeans.getContextTypeLoader().newInstance(LengthDocument.type, xmlOptions);
        }

        public static LengthDocument parse(String str) throws XmlException {
            return (LengthDocument) XmlBeans.getContextTypeLoader().parse(str, LengthDocument.type, (XmlOptions) null);
        }

        public static LengthDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (LengthDocument) XmlBeans.getContextTypeLoader().parse(str, LengthDocument.type, xmlOptions);
        }

        public static LengthDocument parse(File file) throws XmlException, IOException {
            return (LengthDocument) XmlBeans.getContextTypeLoader().parse(file, LengthDocument.type, (XmlOptions) null);
        }

        public static LengthDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LengthDocument) XmlBeans.getContextTypeLoader().parse(file, LengthDocument.type, xmlOptions);
        }

        public static LengthDocument parse(URL url) throws XmlException, IOException {
            return (LengthDocument) XmlBeans.getContextTypeLoader().parse(url, LengthDocument.type, (XmlOptions) null);
        }

        public static LengthDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LengthDocument) XmlBeans.getContextTypeLoader().parse(url, LengthDocument.type, xmlOptions);
        }

        public static LengthDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (LengthDocument) XmlBeans.getContextTypeLoader().parse(inputStream, LengthDocument.type, (XmlOptions) null);
        }

        public static LengthDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LengthDocument) XmlBeans.getContextTypeLoader().parse(inputStream, LengthDocument.type, xmlOptions);
        }

        public static LengthDocument parse(Reader reader) throws XmlException, IOException {
            return (LengthDocument) XmlBeans.getContextTypeLoader().parse(reader, LengthDocument.type, (XmlOptions) null);
        }

        public static LengthDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LengthDocument) XmlBeans.getContextTypeLoader().parse(reader, LengthDocument.type, xmlOptions);
        }

        public static LengthDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (LengthDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, LengthDocument.type, (XmlOptions) null);
        }

        public static LengthDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (LengthDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, LengthDocument.type, xmlOptions);
        }

        public static LengthDocument parse(Node node) throws XmlException {
            return (LengthDocument) XmlBeans.getContextTypeLoader().parse(node, LengthDocument.type, (XmlOptions) null);
        }

        public static LengthDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (LengthDocument) XmlBeans.getContextTypeLoader().parse(node, LengthDocument.type, xmlOptions);
        }

        public static LengthDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (LengthDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, LengthDocument.type, (XmlOptions) null);
        }

        public static LengthDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (LengthDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, LengthDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, LengthDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, LengthDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
