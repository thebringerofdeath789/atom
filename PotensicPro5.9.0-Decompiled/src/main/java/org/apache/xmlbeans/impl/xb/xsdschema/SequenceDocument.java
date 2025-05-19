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
public interface SequenceDocument extends XmlObject {
    public static final SchemaType type;

    ExplicitGroup addNewSequence();

    ExplicitGroup getSequence();

    void setSequence(ExplicitGroup explicitGroup);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.SequenceDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$SequenceDocument;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SequenceDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.SequenceDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SequenceDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SequenceDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("sequencecba2doctype");
    }

    public static final class Factory {
        public static SequenceDocument newInstance() {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().newInstance(SequenceDocument.type, null);
        }

        public static SequenceDocument newInstance(XmlOptions xmlOptions) {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().newInstance(SequenceDocument.type, xmlOptions);
        }

        public static SequenceDocument parse(String str) throws XmlException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(str, SequenceDocument.type, (XmlOptions) null);
        }

        public static SequenceDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(str, SequenceDocument.type, xmlOptions);
        }

        public static SequenceDocument parse(File file) throws XmlException, IOException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(file, SequenceDocument.type, (XmlOptions) null);
        }

        public static SequenceDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(file, SequenceDocument.type, xmlOptions);
        }

        public static SequenceDocument parse(URL url) throws XmlException, IOException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(url, SequenceDocument.type, (XmlOptions) null);
        }

        public static SequenceDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(url, SequenceDocument.type, xmlOptions);
        }

        public static SequenceDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SequenceDocument.type, (XmlOptions) null);
        }

        public static SequenceDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SequenceDocument.type, xmlOptions);
        }

        public static SequenceDocument parse(Reader reader) throws XmlException, IOException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(reader, SequenceDocument.type, (XmlOptions) null);
        }

        public static SequenceDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(reader, SequenceDocument.type, xmlOptions);
        }

        public static SequenceDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SequenceDocument.type, (XmlOptions) null);
        }

        public static SequenceDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SequenceDocument.type, xmlOptions);
        }

        public static SequenceDocument parse(Node node) throws XmlException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(node, SequenceDocument.type, (XmlOptions) null);
        }

        public static SequenceDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(node, SequenceDocument.type, xmlOptions);
        }

        public static SequenceDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SequenceDocument.type, (XmlOptions) null);
        }

        public static SequenceDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SequenceDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SequenceDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SequenceDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
