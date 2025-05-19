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
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface AttributeGroup extends Annotated {
    public static final SchemaType type;

    Wildcard addNewAnyAttribute();

    Attribute addNewAttribute();

    AttributeGroupRef addNewAttributeGroup();

    Wildcard getAnyAttribute();

    Attribute getAttributeArray(int i);

    Attribute[] getAttributeArray();

    AttributeGroupRef getAttributeGroupArray(int i);

    AttributeGroupRef[] getAttributeGroupArray();

    String getName();

    QName getRef();

    Attribute insertNewAttribute(int i);

    AttributeGroupRef insertNewAttributeGroup(int i);

    boolean isSetAnyAttribute();

    boolean isSetName();

    boolean isSetRef();

    void removeAttribute(int i);

    void removeAttributeGroup(int i);

    void setAnyAttribute(Wildcard wildcard);

    void setAttributeArray(int i, Attribute attribute);

    void setAttributeArray(Attribute[] attributeArr);

    void setAttributeGroupArray(int i, AttributeGroupRef attributeGroupRef);

    void setAttributeGroupArray(AttributeGroupRef[] attributeGroupRefArr);

    void setName(String str);

    void setRef(QName qName);

    int sizeOfAttributeArray();

    int sizeOfAttributeGroupArray();

    void unsetAnyAttribute();

    void unsetName();

    void unsetRef();

    XmlNCName xgetName();

    XmlQName xgetRef();

    void xsetName(XmlNCName xmlNCName);

    void xsetRef(XmlQName xmlQName);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeGroup;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeGroup == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeGroup = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$AttributeGroup;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("attributegroupe530type");
    }

    public static final class Factory {
        public static AttributeGroup newInstance() {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().newInstance(AttributeGroup.type, null);
        }

        public static AttributeGroup newInstance(XmlOptions xmlOptions) {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().newInstance(AttributeGroup.type, xmlOptions);
        }

        public static AttributeGroup parse(String str) throws XmlException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(str, AttributeGroup.type, (XmlOptions) null);
        }

        public static AttributeGroup parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(str, AttributeGroup.type, xmlOptions);
        }

        public static AttributeGroup parse(File file) throws XmlException, IOException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(file, AttributeGroup.type, (XmlOptions) null);
        }

        public static AttributeGroup parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(file, AttributeGroup.type, xmlOptions);
        }

        public static AttributeGroup parse(URL url) throws XmlException, IOException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(url, AttributeGroup.type, (XmlOptions) null);
        }

        public static AttributeGroup parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(url, AttributeGroup.type, xmlOptions);
        }

        public static AttributeGroup parse(InputStream inputStream) throws XmlException, IOException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(inputStream, AttributeGroup.type, (XmlOptions) null);
        }

        public static AttributeGroup parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(inputStream, AttributeGroup.type, xmlOptions);
        }

        public static AttributeGroup parse(Reader reader) throws XmlException, IOException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(reader, AttributeGroup.type, (XmlOptions) null);
        }

        public static AttributeGroup parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(reader, AttributeGroup.type, xmlOptions);
        }

        public static AttributeGroup parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AttributeGroup.type, (XmlOptions) null);
        }

        public static AttributeGroup parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AttributeGroup.type, xmlOptions);
        }

        public static AttributeGroup parse(Node node) throws XmlException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(node, AttributeGroup.type, (XmlOptions) null);
        }

        public static AttributeGroup parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(node, AttributeGroup.type, xmlOptions);
        }

        public static AttributeGroup parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AttributeGroup.type, (XmlOptions) null);
        }

        public static AttributeGroup parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AttributeGroup.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AttributeGroup.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AttributeGroup.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
