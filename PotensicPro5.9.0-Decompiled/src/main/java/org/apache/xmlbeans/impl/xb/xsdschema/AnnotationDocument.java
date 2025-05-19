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
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface AnnotationDocument extends XmlObject {
    public static final SchemaType type;

    Annotation addNewAnnotation();

    Annotation getAnnotation();

    void setAnnotation(Annotation annotation);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$AnnotationDocument;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$AnnotationDocument$Annotation;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AnnotationDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AnnotationDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AnnotationDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("annotationb034doctype");
    }

    public interface Annotation extends OpenAttrs {
        public static final SchemaType type;

        AppinfoDocument.Appinfo addNewAppinfo();

        DocumentationDocument.Documentation addNewDocumentation();

        AppinfoDocument.Appinfo getAppinfoArray(int i);

        AppinfoDocument.Appinfo[] getAppinfoArray();

        DocumentationDocument.Documentation getDocumentationArray(int i);

        DocumentationDocument.Documentation[] getDocumentationArray();

        String getId();

        AppinfoDocument.Appinfo insertNewAppinfo(int i);

        DocumentationDocument.Documentation insertNewDocumentation(int i);

        boolean isSetId();

        void removeAppinfo(int i);

        void removeDocumentation(int i);

        void setAppinfoArray(int i, AppinfoDocument.Appinfo appinfo);

        void setAppinfoArray(AppinfoDocument.Appinfo[] appinfoArr);

        void setDocumentationArray(int i, DocumentationDocument.Documentation documentation);

        void setDocumentationArray(DocumentationDocument.Documentation[] documentationArr);

        void setId(String str);

        int sizeOfAppinfoArray();

        int sizeOfDocumentationArray();

        void unsetId();

        XmlID xgetId();

        void xsetId(XmlID xmlID);

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AnnotationDocument$Annotation == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument$Annotation");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AnnotationDocument$Annotation = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AnnotationDocument$Annotation;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("annotation5abfelemtype");
        }

        public static final class Factory {
            public static Annotation newInstance() {
                return (Annotation) XmlBeans.getContextTypeLoader().newInstance(Annotation.type, null);
            }

            public static Annotation newInstance(XmlOptions xmlOptions) {
                return (Annotation) XmlBeans.getContextTypeLoader().newInstance(Annotation.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static AnnotationDocument newInstance() {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().newInstance(AnnotationDocument.type, null);
        }

        public static AnnotationDocument newInstance(XmlOptions xmlOptions) {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().newInstance(AnnotationDocument.type, xmlOptions);
        }

        public static AnnotationDocument parse(String str) throws XmlException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(str, AnnotationDocument.type, (XmlOptions) null);
        }

        public static AnnotationDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(str, AnnotationDocument.type, xmlOptions);
        }

        public static AnnotationDocument parse(File file) throws XmlException, IOException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(file, AnnotationDocument.type, (XmlOptions) null);
        }

        public static AnnotationDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(file, AnnotationDocument.type, xmlOptions);
        }

        public static AnnotationDocument parse(URL url) throws XmlException, IOException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(url, AnnotationDocument.type, (XmlOptions) null);
        }

        public static AnnotationDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(url, AnnotationDocument.type, xmlOptions);
        }

        public static AnnotationDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AnnotationDocument.type, (XmlOptions) null);
        }

        public static AnnotationDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AnnotationDocument.type, xmlOptions);
        }

        public static AnnotationDocument parse(Reader reader) throws XmlException, IOException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(reader, AnnotationDocument.type, (XmlOptions) null);
        }

        public static AnnotationDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(reader, AnnotationDocument.type, xmlOptions);
        }

        public static AnnotationDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AnnotationDocument.type, (XmlOptions) null);
        }

        public static AnnotationDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AnnotationDocument.type, xmlOptions);
        }

        public static AnnotationDocument parse(Node node) throws XmlException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(node, AnnotationDocument.type, (XmlOptions) null);
        }

        public static AnnotationDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(node, AnnotationDocument.type, xmlOptions);
        }

        public static AnnotationDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AnnotationDocument.type, (XmlOptions) null);
        }

        public static AnnotationDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AnnotationDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AnnotationDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AnnotationDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
