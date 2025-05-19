package org.apache.xmlbeans.impl.xb.xsdschema;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface Facet extends Annotated {
    public static final SchemaType type;

    XmlAnySimpleType addNewValue();

    boolean getFixed();

    XmlAnySimpleType getValue();

    boolean isSetFixed();

    void setFixed(boolean z);

    void setValue(XmlAnySimpleType xmlAnySimpleType);

    void unsetFixed();

    XmlBoolean xgetFixed();

    void xsetFixed(XmlBoolean xmlBoolean);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.Facet$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$Facet;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$Facet == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.Facet");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$Facet = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$Facet;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("facet446etype");
    }

    public static final class Factory {
        public static Facet newInstance() {
            return (Facet) XmlBeans.getContextTypeLoader().newInstance(Facet.type, null);
        }

        public static Facet newInstance(XmlOptions xmlOptions) {
            return (Facet) XmlBeans.getContextTypeLoader().newInstance(Facet.type, xmlOptions);
        }

        public static Facet parse(String str) throws XmlException {
            return (Facet) XmlBeans.getContextTypeLoader().parse(str, Facet.type, (XmlOptions) null);
        }

        public static Facet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (Facet) XmlBeans.getContextTypeLoader().parse(str, Facet.type, xmlOptions);
        }

        public static Facet parse(File file) throws XmlException, IOException {
            return (Facet) XmlBeans.getContextTypeLoader().parse(file, Facet.type, (XmlOptions) null);
        }

        public static Facet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Facet) XmlBeans.getContextTypeLoader().parse(file, Facet.type, xmlOptions);
        }

        public static Facet parse(URL url) throws XmlException, IOException {
            return (Facet) XmlBeans.getContextTypeLoader().parse(url, Facet.type, (XmlOptions) null);
        }

        public static Facet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Facet) XmlBeans.getContextTypeLoader().parse(url, Facet.type, xmlOptions);
        }

        public static Facet parse(InputStream inputStream) throws XmlException, IOException {
            return (Facet) XmlBeans.getContextTypeLoader().parse(inputStream, Facet.type, (XmlOptions) null);
        }

        public static Facet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Facet) XmlBeans.getContextTypeLoader().parse(inputStream, Facet.type, xmlOptions);
        }

        public static Facet parse(Reader reader) throws XmlException, IOException {
            return (Facet) XmlBeans.getContextTypeLoader().parse(reader, Facet.type, (XmlOptions) null);
        }

        public static Facet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Facet) XmlBeans.getContextTypeLoader().parse(reader, Facet.type, xmlOptions);
        }

        public static Facet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (Facet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Facet.type, (XmlOptions) null);
        }

        public static Facet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (Facet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Facet.type, xmlOptions);
        }

        public static Facet parse(Node node) throws XmlException {
            return (Facet) XmlBeans.getContextTypeLoader().parse(node, Facet.type, (XmlOptions) null);
        }

        public static Facet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (Facet) XmlBeans.getContextTypeLoader().parse(node, Facet.type, xmlOptions);
        }

        public static Facet parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (Facet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Facet.type, (XmlOptions) null);
        }

        public static Facet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (Facet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Facet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Facet.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Facet.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
