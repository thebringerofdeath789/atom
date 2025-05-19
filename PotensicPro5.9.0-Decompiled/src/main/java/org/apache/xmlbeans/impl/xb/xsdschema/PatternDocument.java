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
public interface PatternDocument extends XmlObject {
    public static final SchemaType type;

    Pattern addNewPattern();

    Pattern getPattern();

    void setPattern(Pattern pattern);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$PatternDocument;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$PatternDocument$Pattern;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$PatternDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$PatternDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$PatternDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("pattern9585doctype");
    }

    public interface Pattern extends NoFixedFacet {
        public static final SchemaType type;

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$PatternDocument$Pattern == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument$Pattern");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$PatternDocument$Pattern = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$PatternDocument$Pattern;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("pattern6809elemtype");
        }

        public static final class Factory {
            public static Pattern newInstance() {
                return (Pattern) XmlBeans.getContextTypeLoader().newInstance(Pattern.type, null);
            }

            public static Pattern newInstance(XmlOptions xmlOptions) {
                return (Pattern) XmlBeans.getContextTypeLoader().newInstance(Pattern.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static PatternDocument newInstance() {
            return (PatternDocument) XmlBeans.getContextTypeLoader().newInstance(PatternDocument.type, null);
        }

        public static PatternDocument newInstance(XmlOptions xmlOptions) {
            return (PatternDocument) XmlBeans.getContextTypeLoader().newInstance(PatternDocument.type, xmlOptions);
        }

        public static PatternDocument parse(String str) throws XmlException {
            return (PatternDocument) XmlBeans.getContextTypeLoader().parse(str, PatternDocument.type, (XmlOptions) null);
        }

        public static PatternDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (PatternDocument) XmlBeans.getContextTypeLoader().parse(str, PatternDocument.type, xmlOptions);
        }

        public static PatternDocument parse(File file) throws XmlException, IOException {
            return (PatternDocument) XmlBeans.getContextTypeLoader().parse(file, PatternDocument.type, (XmlOptions) null);
        }

        public static PatternDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PatternDocument) XmlBeans.getContextTypeLoader().parse(file, PatternDocument.type, xmlOptions);
        }

        public static PatternDocument parse(URL url) throws XmlException, IOException {
            return (PatternDocument) XmlBeans.getContextTypeLoader().parse(url, PatternDocument.type, (XmlOptions) null);
        }

        public static PatternDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PatternDocument) XmlBeans.getContextTypeLoader().parse(url, PatternDocument.type, xmlOptions);
        }

        public static PatternDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (PatternDocument) XmlBeans.getContextTypeLoader().parse(inputStream, PatternDocument.type, (XmlOptions) null);
        }

        public static PatternDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PatternDocument) XmlBeans.getContextTypeLoader().parse(inputStream, PatternDocument.type, xmlOptions);
        }

        public static PatternDocument parse(Reader reader) throws XmlException, IOException {
            return (PatternDocument) XmlBeans.getContextTypeLoader().parse(reader, PatternDocument.type, (XmlOptions) null);
        }

        public static PatternDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PatternDocument) XmlBeans.getContextTypeLoader().parse(reader, PatternDocument.type, xmlOptions);
        }

        public static PatternDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (PatternDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, PatternDocument.type, (XmlOptions) null);
        }

        public static PatternDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (PatternDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, PatternDocument.type, xmlOptions);
        }

        public static PatternDocument parse(Node node) throws XmlException {
            return (PatternDocument) XmlBeans.getContextTypeLoader().parse(node, PatternDocument.type, (XmlOptions) null);
        }

        public static PatternDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (PatternDocument) XmlBeans.getContextTypeLoader().parse(node, PatternDocument.type, xmlOptions);
        }

        public static PatternDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (PatternDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, PatternDocument.type, (XmlOptions) null);
        }

        public static PatternDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (PatternDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, PatternDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, PatternDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, PatternDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
