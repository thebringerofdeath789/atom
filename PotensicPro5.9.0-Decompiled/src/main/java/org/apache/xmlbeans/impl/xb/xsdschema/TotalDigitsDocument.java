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
public interface TotalDigitsDocument extends XmlObject {
    public static final SchemaType type;

    TotalDigits addNewTotalDigits();

    TotalDigits getTotalDigits();

    void setTotalDigits(TotalDigits totalDigits);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$TotalDigitsDocument;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$TotalDigitsDocument$TotalDigits;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$TotalDigitsDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$TotalDigitsDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$TotalDigitsDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("totaldigits4a8bdoctype");
    }

    public interface TotalDigits extends NumFacet {
        public static final SchemaType type;

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$TotalDigitsDocument$TotalDigits == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument$TotalDigits");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$TotalDigitsDocument$TotalDigits = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$TotalDigitsDocument$TotalDigits;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("totaldigits2615elemtype");
        }

        public static final class Factory {
            public static TotalDigits newInstance() {
                return (TotalDigits) XmlBeans.getContextTypeLoader().newInstance(TotalDigits.type, null);
            }

            public static TotalDigits newInstance(XmlOptions xmlOptions) {
                return (TotalDigits) XmlBeans.getContextTypeLoader().newInstance(TotalDigits.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static TotalDigitsDocument newInstance() {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().newInstance(TotalDigitsDocument.type, null);
        }

        public static TotalDigitsDocument newInstance(XmlOptions xmlOptions) {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().newInstance(TotalDigitsDocument.type, xmlOptions);
        }

        public static TotalDigitsDocument parse(String str) throws XmlException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(str, TotalDigitsDocument.type, (XmlOptions) null);
        }

        public static TotalDigitsDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(str, TotalDigitsDocument.type, xmlOptions);
        }

        public static TotalDigitsDocument parse(File file) throws XmlException, IOException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(file, TotalDigitsDocument.type, (XmlOptions) null);
        }

        public static TotalDigitsDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(file, TotalDigitsDocument.type, xmlOptions);
        }

        public static TotalDigitsDocument parse(URL url) throws XmlException, IOException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(url, TotalDigitsDocument.type, (XmlOptions) null);
        }

        public static TotalDigitsDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(url, TotalDigitsDocument.type, xmlOptions);
        }

        public static TotalDigitsDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(inputStream, TotalDigitsDocument.type, (XmlOptions) null);
        }

        public static TotalDigitsDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(inputStream, TotalDigitsDocument.type, xmlOptions);
        }

        public static TotalDigitsDocument parse(Reader reader) throws XmlException, IOException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(reader, TotalDigitsDocument.type, (XmlOptions) null);
        }

        public static TotalDigitsDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(reader, TotalDigitsDocument.type, xmlOptions);
        }

        public static TotalDigitsDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TotalDigitsDocument.type, (XmlOptions) null);
        }

        public static TotalDigitsDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TotalDigitsDocument.type, xmlOptions);
        }

        public static TotalDigitsDocument parse(Node node) throws XmlException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(node, TotalDigitsDocument.type, (XmlOptions) null);
        }

        public static TotalDigitsDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(node, TotalDigitsDocument.type, xmlOptions);
        }

        public static TotalDigitsDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TotalDigitsDocument.type, (XmlOptions) null);
        }

        public static TotalDigitsDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TotalDigitsDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TotalDigitsDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TotalDigitsDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
