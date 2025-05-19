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
public interface NamedGroup extends RealGroup {
    public static final SchemaType type;

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    String getName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    boolean isSetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void setName(String str);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void unsetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    XmlNCName xgetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void xsetName(XmlNCName xmlNCName);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$NamedGroup;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$NamedGroup$All;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamedGroup == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamedGroup = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamedGroup;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("namedgroup878dtype");
    }

    public interface All extends org.apache.xmlbeans.impl.xb.xsdschema.All {
        public static final SchemaType type;

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamedGroup$All == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup$All");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamedGroup$All = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$NamedGroup$All;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("all82daelemtype");
        }

        public static final class Factory {
            public static All newInstance() {
                return (All) XmlBeans.getContextTypeLoader().newInstance(All.type, null);
            }

            public static All newInstance(XmlOptions xmlOptions) {
                return (All) XmlBeans.getContextTypeLoader().newInstance(All.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static NamedGroup newInstance() {
            return (NamedGroup) XmlBeans.getContextTypeLoader().newInstance(NamedGroup.type, null);
        }

        public static NamedGroup newInstance(XmlOptions xmlOptions) {
            return (NamedGroup) XmlBeans.getContextTypeLoader().newInstance(NamedGroup.type, xmlOptions);
        }

        public static NamedGroup parse(String str) throws XmlException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(str, NamedGroup.type, (XmlOptions) null);
        }

        public static NamedGroup parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(str, NamedGroup.type, xmlOptions);
        }

        public static NamedGroup parse(File file) throws XmlException, IOException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(file, NamedGroup.type, (XmlOptions) null);
        }

        public static NamedGroup parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(file, NamedGroup.type, xmlOptions);
        }

        public static NamedGroup parse(URL url) throws XmlException, IOException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(url, NamedGroup.type, (XmlOptions) null);
        }

        public static NamedGroup parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(url, NamedGroup.type, xmlOptions);
        }

        public static NamedGroup parse(InputStream inputStream) throws XmlException, IOException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(inputStream, NamedGroup.type, (XmlOptions) null);
        }

        public static NamedGroup parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(inputStream, NamedGroup.type, xmlOptions);
        }

        public static NamedGroup parse(Reader reader) throws XmlException, IOException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(reader, NamedGroup.type, (XmlOptions) null);
        }

        public static NamedGroup parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(reader, NamedGroup.type, xmlOptions);
        }

        public static NamedGroup parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NamedGroup.type, (XmlOptions) null);
        }

        public static NamedGroup parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NamedGroup.type, xmlOptions);
        }

        public static NamedGroup parse(Node node) throws XmlException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(node, NamedGroup.type, (XmlOptions) null);
        }

        public static NamedGroup parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(node, NamedGroup.type, xmlOptions);
        }

        public static NamedGroup parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NamedGroup.type, (XmlOptions) null);
        }

        public static NamedGroup parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NamedGroup.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NamedGroup.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NamedGroup.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
