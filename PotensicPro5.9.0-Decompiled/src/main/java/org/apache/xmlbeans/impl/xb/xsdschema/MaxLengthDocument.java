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
public interface MaxLengthDocument extends XmlObject {
    public static final SchemaType type;

    NumFacet addNewMaxLength();

    NumFacet getMaxLength();

    void setMaxLength(NumFacet numFacet);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.MaxLengthDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$MaxLengthDocument;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$MaxLengthDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.MaxLengthDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$MaxLengthDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$MaxLengthDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("maxlengthf8abdoctype");
    }

    public static final class Factory {
        public static MaxLengthDocument newInstance() {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().newInstance(MaxLengthDocument.type, null);
        }

        public static MaxLengthDocument newInstance(XmlOptions xmlOptions) {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().newInstance(MaxLengthDocument.type, xmlOptions);
        }

        public static MaxLengthDocument parse(String str) throws XmlException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(str, MaxLengthDocument.type, (XmlOptions) null);
        }

        public static MaxLengthDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(str, MaxLengthDocument.type, xmlOptions);
        }

        public static MaxLengthDocument parse(File file) throws XmlException, IOException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(file, MaxLengthDocument.type, (XmlOptions) null);
        }

        public static MaxLengthDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(file, MaxLengthDocument.type, xmlOptions);
        }

        public static MaxLengthDocument parse(URL url) throws XmlException, IOException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(url, MaxLengthDocument.type, (XmlOptions) null);
        }

        public static MaxLengthDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(url, MaxLengthDocument.type, xmlOptions);
        }

        public static MaxLengthDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MaxLengthDocument.type, (XmlOptions) null);
        }

        public static MaxLengthDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MaxLengthDocument.type, xmlOptions);
        }

        public static MaxLengthDocument parse(Reader reader) throws XmlException, IOException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(reader, MaxLengthDocument.type, (XmlOptions) null);
        }

        public static MaxLengthDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(reader, MaxLengthDocument.type, xmlOptions);
        }

        public static MaxLengthDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MaxLengthDocument.type, (XmlOptions) null);
        }

        public static MaxLengthDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MaxLengthDocument.type, xmlOptions);
        }

        public static MaxLengthDocument parse(Node node) throws XmlException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(node, MaxLengthDocument.type, (XmlOptions) null);
        }

        public static MaxLengthDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(node, MaxLengthDocument.type, xmlOptions);
        }

        public static MaxLengthDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MaxLengthDocument.type, (XmlOptions) null);
        }

        public static MaxLengthDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MaxLengthDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MaxLengthDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MaxLengthDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
