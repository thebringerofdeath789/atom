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
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface TopLevelElement extends Element {
    public static final SchemaType type;

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    String getName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    boolean isSetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    void setName(String str);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    void unsetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    XmlNCName xgetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    void xsetName(XmlNCName xmlNCName);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelElement;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelElement == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelElement = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelElement;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("toplevelelement98d8type");
    }

    public static final class Factory {
        public static TopLevelElement newInstance() {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().newInstance(TopLevelElement.type, null);
        }

        public static TopLevelElement newInstance(XmlOptions xmlOptions) {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().newInstance(TopLevelElement.type, xmlOptions);
        }

        public static TopLevelElement parse(String str) throws XmlException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(str, TopLevelElement.type, (XmlOptions) null);
        }

        public static TopLevelElement parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(str, TopLevelElement.type, xmlOptions);
        }

        public static TopLevelElement parse(File file) throws XmlException, IOException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(file, TopLevelElement.type, (XmlOptions) null);
        }

        public static TopLevelElement parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(file, TopLevelElement.type, xmlOptions);
        }

        public static TopLevelElement parse(URL url) throws XmlException, IOException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(url, TopLevelElement.type, (XmlOptions) null);
        }

        public static TopLevelElement parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(url, TopLevelElement.type, xmlOptions);
        }

        public static TopLevelElement parse(InputStream inputStream) throws XmlException, IOException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(inputStream, TopLevelElement.type, (XmlOptions) null);
        }

        public static TopLevelElement parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(inputStream, TopLevelElement.type, xmlOptions);
        }

        public static TopLevelElement parse(Reader reader) throws XmlException, IOException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(reader, TopLevelElement.type, (XmlOptions) null);
        }

        public static TopLevelElement parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(reader, TopLevelElement.type, xmlOptions);
        }

        public static TopLevelElement parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TopLevelElement.type, (XmlOptions) null);
        }

        public static TopLevelElement parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TopLevelElement.type, xmlOptions);
        }

        public static TopLevelElement parse(Node node) throws XmlException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(node, TopLevelElement.type, (XmlOptions) null);
        }

        public static TopLevelElement parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(node, TopLevelElement.type, xmlOptions);
        }

        public static TopLevelElement parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TopLevelElement.type, (XmlOptions) null);
        }

        public static TopLevelElement parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TopLevelElement.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TopLevelElement.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TopLevelElement.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
