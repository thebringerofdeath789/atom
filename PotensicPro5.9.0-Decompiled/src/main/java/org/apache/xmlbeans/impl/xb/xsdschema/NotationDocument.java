package org.apache.xmlbeans.impl.xb.xsdschema;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface NotationDocument extends XmlObject {
    public static final SchemaType type;

    Notation addNewNotation();

    Notation getNotation();

    void setNotation(Notation notation);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$NotationDocument;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$NotationDocument$Notation;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NotationDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NotationDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NotationDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("notation3381doctype");
    }

    public interface Notation extends Annotated {
        public static final SchemaType type;

        String getName();

        String getPublic();

        String getSystem();

        boolean isSetPublic();

        boolean isSetSystem();

        void setName(String str);

        void setPublic(String str);

        void setSystem(String str);

        void unsetPublic();

        void unsetSystem();

        XmlNCName xgetName();

        Public xgetPublic();

        XmlAnyURI xgetSystem();

        void xsetName(XmlNCName xmlNCName);

        void xsetPublic(Public r1);

        void xsetSystem(XmlAnyURI xmlAnyURI);

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NotationDocument$Notation == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument$Notation");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NotationDocument$Notation = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NotationDocument$Notation;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("notation8b1felemtype");
        }

        public static final class Factory {
            public static Notation newInstance() {
                return (Notation) XmlBeans.getContextTypeLoader().newInstance(Notation.type, null);
            }

            public static Notation newInstance(XmlOptions xmlOptions) {
                return (Notation) XmlBeans.getContextTypeLoader().newInstance(Notation.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static NotationDocument newInstance() {
            return (NotationDocument) XmlBeans.getContextTypeLoader().newInstance(NotationDocument.type, null);
        }

        public static NotationDocument newInstance(XmlOptions xmlOptions) {
            return (NotationDocument) XmlBeans.getContextTypeLoader().newInstance(NotationDocument.type, xmlOptions);
        }

        public static NotationDocument parse(String str) throws XmlException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(str, NotationDocument.type, (XmlOptions) null);
        }

        public static NotationDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(str, NotationDocument.type, xmlOptions);
        }

        public static NotationDocument parse(File file) throws XmlException, IOException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(file, NotationDocument.type, (XmlOptions) null);
        }

        public static NotationDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(file, NotationDocument.type, xmlOptions);
        }

        public static NotationDocument parse(URL url) throws XmlException, IOException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(url, NotationDocument.type, (XmlOptions) null);
        }

        public static NotationDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(url, NotationDocument.type, xmlOptions);
        }

        public static NotationDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(inputStream, NotationDocument.type, (XmlOptions) null);
        }

        public static NotationDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(inputStream, NotationDocument.type, xmlOptions);
        }

        public static NotationDocument parse(Reader reader) throws XmlException, IOException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(reader, NotationDocument.type, (XmlOptions) null);
        }

        public static NotationDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(reader, NotationDocument.type, xmlOptions);
        }

        public static NotationDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NotationDocument.type, (XmlOptions) null);
        }

        public static NotationDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NotationDocument.type, xmlOptions);
        }

        public static NotationDocument parse(Node node) throws XmlException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(node, NotationDocument.type, (XmlOptions) null);
        }

        public static NotationDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(node, NotationDocument.type, xmlOptions);
        }

        public static NotationDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NotationDocument.type, (XmlOptions) null);
        }

        public static NotationDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NotationDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NotationDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NotationDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
