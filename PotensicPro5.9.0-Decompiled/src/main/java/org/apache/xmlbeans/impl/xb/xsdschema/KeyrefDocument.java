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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface KeyrefDocument extends XmlObject {
    public static final SchemaType type;

    Keyref addNewKeyref();

    Keyref getKeyref();

    void setKeyref(Keyref keyref);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$KeyrefDocument;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$KeyrefDocument$Keyref;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$KeyrefDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$KeyrefDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$KeyrefDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("keyref45afdoctype");
    }

    public interface Keyref extends Keybase {
        public static final SchemaType type;

        QName getRefer();

        void setRefer(QName qName);

        XmlQName xgetRefer();

        void xsetRefer(XmlQName xmlQName);

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$KeyrefDocument$Keyref == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument$Keyref");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$KeyrefDocument$Keyref = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$KeyrefDocument$Keyref;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("keyref7a1felemtype");
        }

        public static final class Factory {
            public static Keyref newInstance() {
                return (Keyref) XmlBeans.getContextTypeLoader().newInstance(Keyref.type, null);
            }

            public static Keyref newInstance(XmlOptions xmlOptions) {
                return (Keyref) XmlBeans.getContextTypeLoader().newInstance(Keyref.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static KeyrefDocument newInstance() {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().newInstance(KeyrefDocument.type, null);
        }

        public static KeyrefDocument newInstance(XmlOptions xmlOptions) {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().newInstance(KeyrefDocument.type, xmlOptions);
        }

        public static KeyrefDocument parse(String str) throws XmlException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(str, KeyrefDocument.type, (XmlOptions) null);
        }

        public static KeyrefDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(str, KeyrefDocument.type, xmlOptions);
        }

        public static KeyrefDocument parse(File file) throws XmlException, IOException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(file, KeyrefDocument.type, (XmlOptions) null);
        }

        public static KeyrefDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(file, KeyrefDocument.type, xmlOptions);
        }

        public static KeyrefDocument parse(URL url) throws XmlException, IOException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(url, KeyrefDocument.type, (XmlOptions) null);
        }

        public static KeyrefDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(url, KeyrefDocument.type, xmlOptions);
        }

        public static KeyrefDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(inputStream, KeyrefDocument.type, (XmlOptions) null);
        }

        public static KeyrefDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(inputStream, KeyrefDocument.type, xmlOptions);
        }

        public static KeyrefDocument parse(Reader reader) throws XmlException, IOException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(reader, KeyrefDocument.type, (XmlOptions) null);
        }

        public static KeyrefDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(reader, KeyrefDocument.type, xmlOptions);
        }

        public static KeyrefDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, KeyrefDocument.type, (XmlOptions) null);
        }

        public static KeyrefDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, KeyrefDocument.type, xmlOptions);
        }

        public static KeyrefDocument parse(Node node) throws XmlException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(node, KeyrefDocument.type, (XmlOptions) null);
        }

        public static KeyrefDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(node, KeyrefDocument.type, xmlOptions);
        }

        public static KeyrefDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, KeyrefDocument.type, (XmlOptions) null);
        }

        public static KeyrefDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, KeyrefDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, KeyrefDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, KeyrefDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
