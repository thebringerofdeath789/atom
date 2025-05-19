package org.apache.xmlbeans.impl.xb.xsdschema;

import aavax.xml.namespace.QName;
import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
import org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface Element extends Annotated {
    public static final SchemaType type;

    LocalComplexType addNewComplexType();

    Keybase addNewKey();

    KeyrefDocument.Keyref addNewKeyref();

    LocalSimpleType addNewSimpleType();

    Keybase addNewUnique();

    boolean getAbstract();

    Object getBlock();

    LocalComplexType getComplexType();

    String getDefault();

    Object getFinal();

    String getFixed();

    FormChoice.Enum getForm();

    Keybase getKeyArray(int i);

    Keybase[] getKeyArray();

    KeyrefDocument.Keyref getKeyrefArray(int i);

    KeyrefDocument.Keyref[] getKeyrefArray();

    Object getMaxOccurs();

    BigInteger getMinOccurs();

    String getName();

    boolean getNillable();

    QName getRef();

    LocalSimpleType getSimpleType();

    QName getSubstitutionGroup();

    QName getType();

    Keybase getUniqueArray(int i);

    Keybase[] getUniqueArray();

    Keybase insertNewKey(int i);

    KeyrefDocument.Keyref insertNewKeyref(int i);

    Keybase insertNewUnique(int i);

    boolean isSetAbstract();

    boolean isSetBlock();

    boolean isSetComplexType();

    boolean isSetDefault();

    boolean isSetFinal();

    boolean isSetFixed();

    boolean isSetForm();

    boolean isSetMaxOccurs();

    boolean isSetMinOccurs();

    boolean isSetName();

    boolean isSetNillable();

    boolean isSetRef();

    boolean isSetSimpleType();

    boolean isSetSubstitutionGroup();

    boolean isSetType();

    void removeKey(int i);

    void removeKeyref(int i);

    void removeUnique(int i);

    void setAbstract(boolean z);

    void setBlock(Object obj);

    void setComplexType(LocalComplexType localComplexType);

    void setDefault(String str);

    void setFinal(Object obj);

    void setFixed(String str);

    void setForm(FormChoice.Enum r1);

    void setKeyArray(int i, Keybase keybase);

    void setKeyArray(Keybase[] keybaseArr);

    void setKeyrefArray(int i, KeyrefDocument.Keyref keyref);

    void setKeyrefArray(KeyrefDocument.Keyref[] keyrefArr);

    void setMaxOccurs(Object obj);

    void setMinOccurs(BigInteger bigInteger);

    void setName(String str);

    void setNillable(boolean z);

    void setRef(QName qName);

    void setSimpleType(LocalSimpleType localSimpleType);

    void setSubstitutionGroup(QName qName);

    void setType(QName qName);

    void setUniqueArray(int i, Keybase keybase);

    void setUniqueArray(Keybase[] keybaseArr);

    int sizeOfKeyArray();

    int sizeOfKeyrefArray();

    int sizeOfUniqueArray();

    void unsetAbstract();

    void unsetBlock();

    void unsetComplexType();

    void unsetDefault();

    void unsetFinal();

    void unsetFixed();

    void unsetForm();

    void unsetMaxOccurs();

    void unsetMinOccurs();

    void unsetName();

    void unsetNillable();

    void unsetRef();

    void unsetSimpleType();

    void unsetSubstitutionGroup();

    void unsetType();

    XmlBoolean xgetAbstract();

    BlockSet xgetBlock();

    XmlString xgetDefault();

    DerivationSet xgetFinal();

    XmlString xgetFixed();

    FormChoice xgetForm();

    AllNNI xgetMaxOccurs();

    XmlNonNegativeInteger xgetMinOccurs();

    XmlNCName xgetName();

    XmlBoolean xgetNillable();

    XmlQName xgetRef();

    XmlQName xgetSubstitutionGroup();

    XmlQName xgetType();

    void xsetAbstract(XmlBoolean xmlBoolean);

    void xsetBlock(BlockSet blockSet);

    void xsetDefault(XmlString xmlString);

    void xsetFinal(DerivationSet derivationSet);

    void xsetFixed(XmlString xmlString);

    void xsetForm(FormChoice formChoice);

    void xsetMaxOccurs(AllNNI allNNI);

    void xsetMinOccurs(XmlNonNegativeInteger xmlNonNegativeInteger);

    void xsetName(XmlNCName xmlNCName);

    void xsetNillable(XmlBoolean xmlBoolean);

    void xsetRef(XmlQName xmlQName);

    void xsetSubstitutionGroup(XmlQName xmlQName);

    void xsetType(XmlQName xmlQName);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.Element$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$Element;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$Element == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.Element");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$Element = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$Element;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("elementd189type");
    }

    public static final class Factory {
        public static Element newInstance() {
            return (Element) XmlBeans.getContextTypeLoader().newInstance(Element.type, null);
        }

        public static Element newInstance(XmlOptions xmlOptions) {
            return (Element) XmlBeans.getContextTypeLoader().newInstance(Element.type, xmlOptions);
        }

        public static Element parse(String str) throws XmlException {
            return (Element) XmlBeans.getContextTypeLoader().parse(str, Element.type, (XmlOptions) null);
        }

        public static Element parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (Element) XmlBeans.getContextTypeLoader().parse(str, Element.type, xmlOptions);
        }

        public static Element parse(File file) throws XmlException, IOException {
            return (Element) XmlBeans.getContextTypeLoader().parse(file, Element.type, (XmlOptions) null);
        }

        public static Element parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Element) XmlBeans.getContextTypeLoader().parse(file, Element.type, xmlOptions);
        }

        public static Element parse(URL url) throws XmlException, IOException {
            return (Element) XmlBeans.getContextTypeLoader().parse(url, Element.type, (XmlOptions) null);
        }

        public static Element parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Element) XmlBeans.getContextTypeLoader().parse(url, Element.type, xmlOptions);
        }

        public static Element parse(InputStream inputStream) throws XmlException, IOException {
            return (Element) XmlBeans.getContextTypeLoader().parse(inputStream, Element.type, (XmlOptions) null);
        }

        public static Element parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Element) XmlBeans.getContextTypeLoader().parse(inputStream, Element.type, xmlOptions);
        }

        public static Element parse(Reader reader) throws XmlException, IOException {
            return (Element) XmlBeans.getContextTypeLoader().parse(reader, Element.type, (XmlOptions) null);
        }

        public static Element parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Element) XmlBeans.getContextTypeLoader().parse(reader, Element.type, xmlOptions);
        }

        public static Element parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (Element) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Element.type, (XmlOptions) null);
        }

        public static Element parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (Element) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Element.type, xmlOptions);
        }

        public static Element parse(Node node) throws XmlException {
            return (Element) XmlBeans.getContextTypeLoader().parse(node, Element.type, (XmlOptions) null);
        }

        public static Element parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (Element) XmlBeans.getContextTypeLoader().parse(node, Element.type, xmlOptions);
        }

        public static Element parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (Element) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Element.type, (XmlOptions) null);
        }

        public static Element parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (Element) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Element.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Element.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Element.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
