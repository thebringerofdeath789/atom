package org.apache.xmlbeans.impl.xb.xsdschema;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface ComplexContentDocument extends XmlObject {
    public static final SchemaType type;

    ComplexContent addNewComplexContent();

    ComplexContent getComplexContent();

    void setComplexContent(ComplexContent complexContent);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexContentDocument;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexContentDocument$ComplexContent;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexContentDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexContentDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexContentDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("complexcontentc57adoctype");
    }

    public interface ComplexContent extends Annotated {
        public static final SchemaType type;

        ExtensionType addNewExtension();

        ComplexRestrictionType addNewRestriction();

        ExtensionType getExtension();

        boolean getMixed();

        ComplexRestrictionType getRestriction();

        boolean isSetExtension();

        boolean isSetMixed();

        boolean isSetRestriction();

        void setExtension(ExtensionType extensionType);

        void setMixed(boolean z);

        void setRestriction(ComplexRestrictionType complexRestrictionType);

        void unsetExtension();

        void unsetMixed();

        void unsetRestriction();

        XmlBoolean xgetMixed();

        void xsetMixed(XmlBoolean xmlBoolean);

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexContentDocument$ComplexContent == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument$ComplexContent");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexContentDocument$ComplexContent = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexContentDocument$ComplexContent;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("complexcontentaa7felemtype");
        }

        public static final class Factory {
            public static ComplexContent newInstance() {
                return (ComplexContent) XmlBeans.getContextTypeLoader().newInstance(ComplexContent.type, null);
            }

            public static ComplexContent newInstance(XmlOptions xmlOptions) {
                return (ComplexContent) XmlBeans.getContextTypeLoader().newInstance(ComplexContent.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static ComplexContentDocument newInstance() {
            return (ComplexContentDocument) XmlBeans.getContextTypeLoader().newInstance(ComplexContentDocument.type, null);
        }

        public static ComplexContentDocument newInstance(XmlOptions xmlOptions) {
            return (ComplexContentDocument) XmlBeans.getContextTypeLoader().newInstance(ComplexContentDocument.type, xmlOptions);
        }

        public static ComplexContentDocument parse(String str) throws XmlException {
            return (ComplexContentDocument) XmlBeans.getContextTypeLoader().parse(str, ComplexContentDocument.type, (XmlOptions) null);
        }

        public static ComplexContentDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ComplexContentDocument) XmlBeans.getContextTypeLoader().parse(str, ComplexContentDocument.type, xmlOptions);
        }

        public static ComplexContentDocument parse(File file) throws XmlException, IOException {
            return (ComplexContentDocument) XmlBeans.getContextTypeLoader().parse(file, ComplexContentDocument.type, (XmlOptions) null);
        }

        public static ComplexContentDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexContentDocument) XmlBeans.getContextTypeLoader().parse(file, ComplexContentDocument.type, xmlOptions);
        }

        public static ComplexContentDocument parse(URL url) throws XmlException, IOException {
            return (ComplexContentDocument) XmlBeans.getContextTypeLoader().parse(url, ComplexContentDocument.type, (XmlOptions) null);
        }

        public static ComplexContentDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexContentDocument) XmlBeans.getContextTypeLoader().parse(url, ComplexContentDocument.type, xmlOptions);
        }

        public static ComplexContentDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (ComplexContentDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ComplexContentDocument.type, (XmlOptions) null);
        }

        public static ComplexContentDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexContentDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ComplexContentDocument.type, xmlOptions);
        }

        public static ComplexContentDocument parse(Reader reader) throws XmlException, IOException {
            return (ComplexContentDocument) XmlBeans.getContextTypeLoader().parse(reader, ComplexContentDocument.type, (XmlOptions) null);
        }

        public static ComplexContentDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexContentDocument) XmlBeans.getContextTypeLoader().parse(reader, ComplexContentDocument.type, xmlOptions);
        }

        public static ComplexContentDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ComplexContentDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ComplexContentDocument.type, (XmlOptions) null);
        }

        public static ComplexContentDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ComplexContentDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ComplexContentDocument.type, xmlOptions);
        }

        public static ComplexContentDocument parse(Node node) throws XmlException {
            return (ComplexContentDocument) XmlBeans.getContextTypeLoader().parse(node, ComplexContentDocument.type, (XmlOptions) null);
        }

        public static ComplexContentDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ComplexContentDocument) XmlBeans.getContextTypeLoader().parse(node, ComplexContentDocument.type, xmlOptions);
        }

        public static ComplexContentDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (ComplexContentDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ComplexContentDocument.type, (XmlOptions) null);
        }

        public static ComplexContentDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (ComplexContentDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ComplexContentDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ComplexContentDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ComplexContentDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
