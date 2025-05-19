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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface NumFacet extends Facet {
    public static final SchemaType type;

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.NumFacet$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$NumFacet;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NumFacet == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.NumFacet");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NumFacet = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NumFacet;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("numfacet93a2type");
    }

    public static final class Factory {
        public static NumFacet newInstance() {
            return (NumFacet) XmlBeans.getContextTypeLoader().newInstance(NumFacet.type, null);
        }

        public static NumFacet newInstance(XmlOptions xmlOptions) {
            return (NumFacet) XmlBeans.getContextTypeLoader().newInstance(NumFacet.type, xmlOptions);
        }

        public static NumFacet parse(String str) throws XmlException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(str, NumFacet.type, (XmlOptions) null);
        }

        public static NumFacet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(str, NumFacet.type, xmlOptions);
        }

        public static NumFacet parse(File file) throws XmlException, IOException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(file, NumFacet.type, (XmlOptions) null);
        }

        public static NumFacet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(file, NumFacet.type, xmlOptions);
        }

        public static NumFacet parse(URL url) throws XmlException, IOException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(url, NumFacet.type, (XmlOptions) null);
        }

        public static NumFacet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(url, NumFacet.type, xmlOptions);
        }

        public static NumFacet parse(InputStream inputStream) throws XmlException, IOException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(inputStream, NumFacet.type, (XmlOptions) null);
        }

        public static NumFacet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(inputStream, NumFacet.type, xmlOptions);
        }

        public static NumFacet parse(Reader reader) throws XmlException, IOException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(reader, NumFacet.type, (XmlOptions) null);
        }

        public static NumFacet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(reader, NumFacet.type, xmlOptions);
        }

        public static NumFacet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NumFacet.type, (XmlOptions) null);
        }

        public static NumFacet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NumFacet.type, xmlOptions);
        }

        public static NumFacet parse(Node node) throws XmlException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(node, NumFacet.type, (XmlOptions) null);
        }

        public static NumFacet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(node, NumFacet.type, xmlOptions);
        }

        public static NumFacet parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NumFacet.type, (XmlOptions) null);
        }

        public static NumFacet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NumFacet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NumFacet.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NumFacet.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
