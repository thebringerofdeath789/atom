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
public interface ReducedDerivationControl extends DerivationControl {
    public static final DerivationControl.Enum EXTENSION;
    public static final int INT_EXTENSION = 2;
    public static final int INT_RESTRICTION = 3;
    public static final DerivationControl.Enum RESTRICTION;
    public static final SchemaType type;

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.ReducedDerivationControl$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$ReducedDerivationControl;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ReducedDerivationControl == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.ReducedDerivationControl");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ReducedDerivationControl = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ReducedDerivationControl;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("reducedderivationcontrole1cbtype");
        EXTENSION = DerivationControl.EXTENSION;
        RESTRICTION = DerivationControl.RESTRICTION;
    }

    public static final class Factory {
        public static ReducedDerivationControl newValue(Object obj) {
            return (ReducedDerivationControl) ReducedDerivationControl.type.newValue(obj);
        }

        public static ReducedDerivationControl newInstance() {
            return (ReducedDerivationControl) XmlBeans.getContextTypeLoader().newInstance(ReducedDerivationControl.type, null);
        }

        public static ReducedDerivationControl newInstance(XmlOptions xmlOptions) {
            return (ReducedDerivationControl) XmlBeans.getContextTypeLoader().newInstance(ReducedDerivationControl.type, xmlOptions);
        }

        public static ReducedDerivationControl parse(String str) throws XmlException {
            return (ReducedDerivationControl) XmlBeans.getContextTypeLoader().parse(str, ReducedDerivationControl.type, (XmlOptions) null);
        }

        public static ReducedDerivationControl parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ReducedDerivationControl) XmlBeans.getContextTypeLoader().parse(str, ReducedDerivationControl.type, xmlOptions);
        }

        public static ReducedDerivationControl parse(File file) throws XmlException, IOException {
            return (ReducedDerivationControl) XmlBeans.getContextTypeLoader().parse(file, ReducedDerivationControl.type, (XmlOptions) null);
        }

        public static ReducedDerivationControl parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ReducedDerivationControl) XmlBeans.getContextTypeLoader().parse(file, ReducedDerivationControl.type, xmlOptions);
        }

        public static ReducedDerivationControl parse(URL url) throws XmlException, IOException {
            return (ReducedDerivationControl) XmlBeans.getContextTypeLoader().parse(url, ReducedDerivationControl.type, (XmlOptions) null);
        }

        public static ReducedDerivationControl parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ReducedDerivationControl) XmlBeans.getContextTypeLoader().parse(url, ReducedDerivationControl.type, xmlOptions);
        }

        public static ReducedDerivationControl parse(InputStream inputStream) throws XmlException, IOException {
            return (ReducedDerivationControl) XmlBeans.getContextTypeLoader().parse(inputStream, ReducedDerivationControl.type, (XmlOptions) null);
        }

        public static ReducedDerivationControl parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ReducedDerivationControl) XmlBeans.getContextTypeLoader().parse(inputStream, ReducedDerivationControl.type, xmlOptions);
        }

        public static ReducedDerivationControl parse(Reader reader) throws XmlException, IOException {
            return (ReducedDerivationControl) XmlBeans.getContextTypeLoader().parse(reader, ReducedDerivationControl.type, (XmlOptions) null);
        }

        public static ReducedDerivationControl parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ReducedDerivationControl) XmlBeans.getContextTypeLoader().parse(reader, ReducedDerivationControl.type, xmlOptions);
        }

        public static ReducedDerivationControl parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ReducedDerivationControl) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ReducedDerivationControl.type, (XmlOptions) null);
        }

        public static ReducedDerivationControl parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ReducedDerivationControl) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ReducedDerivationControl.type, xmlOptions);
        }

        public static ReducedDerivationControl parse(Node node) throws XmlException {
            return (ReducedDerivationControl) XmlBeans.getContextTypeLoader().parse(node, ReducedDerivationControl.type, (XmlOptions) null);
        }

        public static ReducedDerivationControl parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ReducedDerivationControl) XmlBeans.getContextTypeLoader().parse(node, ReducedDerivationControl.type, xmlOptions);
        }

        public static ReducedDerivationControl parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (ReducedDerivationControl) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ReducedDerivationControl.type, (XmlOptions) null);
        }

        public static ReducedDerivationControl parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (ReducedDerivationControl) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ReducedDerivationControl.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ReducedDerivationControl.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ReducedDerivationControl.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
