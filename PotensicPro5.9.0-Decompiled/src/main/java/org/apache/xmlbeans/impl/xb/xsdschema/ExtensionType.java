package org.apache.xmlbeans.impl.xb.xsdschema;

import aavax.xml.namespace.QName;
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
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface ExtensionType extends Annotated {
    public static final SchemaType type;

    All addNewAll();

    Wildcard addNewAnyAttribute();

    Attribute addNewAttribute();

    AttributeGroupRef addNewAttributeGroup();

    ExplicitGroup addNewChoice();

    GroupRef addNewGroup();

    ExplicitGroup addNewSequence();

    All getAll();

    Wildcard getAnyAttribute();

    Attribute getAttributeArray(int i);

    Attribute[] getAttributeArray();

    AttributeGroupRef getAttributeGroupArray(int i);

    AttributeGroupRef[] getAttributeGroupArray();

    QName getBase();

    ExplicitGroup getChoice();

    GroupRef getGroup();

    ExplicitGroup getSequence();

    Attribute insertNewAttribute(int i);

    AttributeGroupRef insertNewAttributeGroup(int i);

    boolean isSetAll();

    boolean isSetAnyAttribute();

    boolean isSetChoice();

    boolean isSetGroup();

    boolean isSetSequence();

    void removeAttribute(int i);

    void removeAttributeGroup(int i);

    void setAll(All all);

    void setAnyAttribute(Wildcard wildcard);

    void setAttributeArray(int i, Attribute attribute);

    void setAttributeArray(Attribute[] attributeArr);

    void setAttributeGroupArray(int i, AttributeGroupRef attributeGroupRef);

    void setAttributeGroupArray(AttributeGroupRef[] attributeGroupRefArr);

    void setBase(QName qName);

    void setChoice(ExplicitGroup explicitGroup);

    void setGroup(GroupRef groupRef);

    void setSequence(ExplicitGroup explicitGroup);

    int sizeOfAttributeArray();

    int sizeOfAttributeGroupArray();

    void unsetAll();

    void unsetAnyAttribute();

    void unsetChoice();

    void unsetGroup();

    void unsetSequence();

    XmlQName xgetBase();

    void xsetBase(XmlQName xmlQName);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$ExtensionType;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ExtensionType == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ExtensionType = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ExtensionType;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("extensiontypeed4ctype");
    }

    public static final class Factory {
        public static ExtensionType newInstance() {
            return (ExtensionType) XmlBeans.getContextTypeLoader().newInstance(ExtensionType.type, null);
        }

        public static ExtensionType newInstance(XmlOptions xmlOptions) {
            return (ExtensionType) XmlBeans.getContextTypeLoader().newInstance(ExtensionType.type, xmlOptions);
        }

        public static ExtensionType parse(String str) throws XmlException {
            return (ExtensionType) XmlBeans.getContextTypeLoader().parse(str, ExtensionType.type, (XmlOptions) null);
        }

        public static ExtensionType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ExtensionType) XmlBeans.getContextTypeLoader().parse(str, ExtensionType.type, xmlOptions);
        }

        public static ExtensionType parse(File file) throws XmlException, IOException {
            return (ExtensionType) XmlBeans.getContextTypeLoader().parse(file, ExtensionType.type, (XmlOptions) null);
        }

        public static ExtensionType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ExtensionType) XmlBeans.getContextTypeLoader().parse(file, ExtensionType.type, xmlOptions);
        }

        public static ExtensionType parse(URL url) throws XmlException, IOException {
            return (ExtensionType) XmlBeans.getContextTypeLoader().parse(url, ExtensionType.type, (XmlOptions) null);
        }

        public static ExtensionType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ExtensionType) XmlBeans.getContextTypeLoader().parse(url, ExtensionType.type, xmlOptions);
        }

        public static ExtensionType parse(InputStream inputStream) throws XmlException, IOException {
            return (ExtensionType) XmlBeans.getContextTypeLoader().parse(inputStream, ExtensionType.type, (XmlOptions) null);
        }

        public static ExtensionType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ExtensionType) XmlBeans.getContextTypeLoader().parse(inputStream, ExtensionType.type, xmlOptions);
        }

        public static ExtensionType parse(Reader reader) throws XmlException, IOException {
            return (ExtensionType) XmlBeans.getContextTypeLoader().parse(reader, ExtensionType.type, (XmlOptions) null);
        }

        public static ExtensionType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ExtensionType) XmlBeans.getContextTypeLoader().parse(reader, ExtensionType.type, xmlOptions);
        }

        public static ExtensionType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ExtensionType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ExtensionType.type, (XmlOptions) null);
        }

        public static ExtensionType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ExtensionType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ExtensionType.type, xmlOptions);
        }

        public static ExtensionType parse(Node node) throws XmlException {
            return (ExtensionType) XmlBeans.getContextTypeLoader().parse(node, ExtensionType.type, (XmlOptions) null);
        }

        public static ExtensionType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ExtensionType) XmlBeans.getContextTypeLoader().parse(node, ExtensionType.type, xmlOptions);
        }

        public static ExtensionType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (ExtensionType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ExtensionType.type, (XmlOptions) null);
        }

        public static ExtensionType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (ExtensionType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ExtensionType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ExtensionType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ExtensionType.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
