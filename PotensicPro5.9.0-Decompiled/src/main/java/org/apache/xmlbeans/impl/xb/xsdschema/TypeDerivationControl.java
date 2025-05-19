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
import org.apache.xmlbeans.impl.xb.xsdschema.DerivationControl;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface TypeDerivationControl extends DerivationControl {
    public static final DerivationControl.Enum EXTENSION;
    public static final int INT_EXTENSION = 2;
    public static final int INT_LIST = 4;
    public static final int INT_RESTRICTION = 3;
    public static final int INT_UNION = 5;
    public static final DerivationControl.Enum LIST;
    public static final DerivationControl.Enum RESTRICTION;
    public static final DerivationControl.Enum UNION;
    public static final SchemaType type;

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.TypeDerivationControl$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$TypeDerivationControl;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$TypeDerivationControl == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.TypeDerivationControl");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$TypeDerivationControl = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$TypeDerivationControl;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("typederivationcontrol3239type");
        EXTENSION = DerivationControl.EXTENSION;
        RESTRICTION = DerivationControl.RESTRICTION;
        LIST = DerivationControl.LIST;
        UNION = DerivationControl.UNION;
    }

    public static final class Factory {
        public static TypeDerivationControl newValue(Object obj) {
            return (TypeDerivationControl) TypeDerivationControl.type.newValue(obj);
        }

        public static TypeDerivationControl newInstance() {
            return (TypeDerivationControl) XmlBeans.getContextTypeLoader().newInstance(TypeDerivationControl.type, null);
        }

        public static TypeDerivationControl newInstance(XmlOptions xmlOptions) {
            return (TypeDerivationControl) XmlBeans.getContextTypeLoader().newInstance(TypeDerivationControl.type, xmlOptions);
        }

        public static TypeDerivationControl parse(String str) throws XmlException {
            return (TypeDerivationControl) XmlBeans.getContextTypeLoader().parse(str, TypeDerivationControl.type, (XmlOptions) null);
        }

        public static TypeDerivationControl parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TypeDerivationControl) XmlBeans.getContextTypeLoader().parse(str, TypeDerivationControl.type, xmlOptions);
        }

        public static TypeDerivationControl parse(File file) throws XmlException, IOException {
            return (TypeDerivationControl) XmlBeans.getContextTypeLoader().parse(file, TypeDerivationControl.type, (XmlOptions) null);
        }

        public static TypeDerivationControl parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TypeDerivationControl) XmlBeans.getContextTypeLoader().parse(file, TypeDerivationControl.type, xmlOptions);
        }

        public static TypeDerivationControl parse(URL url) throws XmlException, IOException {
            return (TypeDerivationControl) XmlBeans.getContextTypeLoader().parse(url, TypeDerivationControl.type, (XmlOptions) null);
        }

        public static TypeDerivationControl parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TypeDerivationControl) XmlBeans.getContextTypeLoader().parse(url, TypeDerivationControl.type, xmlOptions);
        }

        public static TypeDerivationControl parse(InputStream inputStream) throws XmlException, IOException {
            return (TypeDerivationControl) XmlBeans.getContextTypeLoader().parse(inputStream, TypeDerivationControl.type, (XmlOptions) null);
        }

        public static TypeDerivationControl parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TypeDerivationControl) XmlBeans.getContextTypeLoader().parse(inputStream, TypeDerivationControl.type, xmlOptions);
        }

        public static TypeDerivationControl parse(Reader reader) throws XmlException, IOException {
            return (TypeDerivationControl) XmlBeans.getContextTypeLoader().parse(reader, TypeDerivationControl.type, (XmlOptions) null);
        }

        public static TypeDerivationControl parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TypeDerivationControl) XmlBeans.getContextTypeLoader().parse(reader, TypeDerivationControl.type, xmlOptions);
        }

        public static TypeDerivationControl parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TypeDerivationControl) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TypeDerivationControl.type, (XmlOptions) null);
        }

        public static TypeDerivationControl parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TypeDerivationControl) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TypeDerivationControl.type, xmlOptions);
        }

        public static TypeDerivationControl parse(Node node) throws XmlException {
            return (TypeDerivationControl) XmlBeans.getContextTypeLoader().parse(node, TypeDerivationControl.type, (XmlOptions) null);
        }

        public static TypeDerivationControl parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TypeDerivationControl) XmlBeans.getContextTypeLoader().parse(node, TypeDerivationControl.type, xmlOptions);
        }

        public static TypeDerivationControl parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (TypeDerivationControl) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TypeDerivationControl.type, (XmlOptions) null);
        }

        public static TypeDerivationControl parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (TypeDerivationControl) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TypeDerivationControl.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TypeDerivationControl.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TypeDerivationControl.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
