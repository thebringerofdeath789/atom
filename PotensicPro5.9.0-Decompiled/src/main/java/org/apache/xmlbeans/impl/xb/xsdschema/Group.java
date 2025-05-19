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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface Group extends Annotated {
    public static final SchemaType type;

    All addNewAll();

    AnyDocument.Any addNewAny();

    ExplicitGroup addNewChoice();

    LocalElement addNewElement();

    GroupRef addNewGroup();

    ExplicitGroup addNewSequence();

    All getAllArray(int i);

    All[] getAllArray();

    AnyDocument.Any getAnyArray(int i);

    AnyDocument.Any[] getAnyArray();

    ExplicitGroup getChoiceArray(int i);

    ExplicitGroup[] getChoiceArray();

    LocalElement getElementArray(int i);

    LocalElement[] getElementArray();

    GroupRef getGroupArray(int i);

    GroupRef[] getGroupArray();

    Object getMaxOccurs();

    BigInteger getMinOccurs();

    String getName();

    QName getRef();

    ExplicitGroup getSequenceArray(int i);

    ExplicitGroup[] getSequenceArray();

    All insertNewAll(int i);

    AnyDocument.Any insertNewAny(int i);

    ExplicitGroup insertNewChoice(int i);

    LocalElement insertNewElement(int i);

    GroupRef insertNewGroup(int i);

    ExplicitGroup insertNewSequence(int i);

    boolean isSetMaxOccurs();

    boolean isSetMinOccurs();

    boolean isSetName();

    boolean isSetRef();

    void removeAll(int i);

    void removeAny(int i);

    void removeChoice(int i);

    void removeElement(int i);

    void removeGroup(int i);

    void removeSequence(int i);

    void setAllArray(int i, All all);

    void setAllArray(All[] allArr);

    void setAnyArray(int i, AnyDocument.Any any);

    void setAnyArray(AnyDocument.Any[] anyArr);

    void setChoiceArray(int i, ExplicitGroup explicitGroup);

    void setChoiceArray(ExplicitGroup[] explicitGroupArr);

    void setElementArray(int i, LocalElement localElement);

    void setElementArray(LocalElement[] localElementArr);

    void setGroupArray(int i, GroupRef groupRef);

    void setGroupArray(GroupRef[] groupRefArr);

    void setMaxOccurs(Object obj);

    void setMinOccurs(BigInteger bigInteger);

    void setName(String str);

    void setRef(QName qName);

    void setSequenceArray(int i, ExplicitGroup explicitGroup);

    void setSequenceArray(ExplicitGroup[] explicitGroupArr);

    int sizeOfAllArray();

    int sizeOfAnyArray();

    int sizeOfChoiceArray();

    int sizeOfElementArray();

    int sizeOfGroupArray();

    int sizeOfSequenceArray();

    void unsetMaxOccurs();

    void unsetMinOccurs();

    void unsetName();

    void unsetRef();

    AllNNI xgetMaxOccurs();

    XmlNonNegativeInteger xgetMinOccurs();

    XmlNCName xgetName();

    XmlQName xgetRef();

    void xsetMaxOccurs(AllNNI allNNI);

    void xsetMinOccurs(XmlNonNegativeInteger xmlNonNegativeInteger);

    void xsetName(XmlNCName xmlNCName);

    void xsetRef(XmlQName xmlQName);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.Group$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$Group;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$Group == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.Group");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$Group = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$Group;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("group7ca6type");
    }

    public static final class Factory {
        public static Group newInstance() {
            return (Group) XmlBeans.getContextTypeLoader().newInstance(Group.type, null);
        }

        public static Group newInstance(XmlOptions xmlOptions) {
            return (Group) XmlBeans.getContextTypeLoader().newInstance(Group.type, xmlOptions);
        }

        public static Group parse(String str) throws XmlException {
            return (Group) XmlBeans.getContextTypeLoader().parse(str, Group.type, (XmlOptions) null);
        }

        public static Group parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (Group) XmlBeans.getContextTypeLoader().parse(str, Group.type, xmlOptions);
        }

        public static Group parse(File file) throws XmlException, IOException {
            return (Group) XmlBeans.getContextTypeLoader().parse(file, Group.type, (XmlOptions) null);
        }

        public static Group parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Group) XmlBeans.getContextTypeLoader().parse(file, Group.type, xmlOptions);
        }

        public static Group parse(URL url) throws XmlException, IOException {
            return (Group) XmlBeans.getContextTypeLoader().parse(url, Group.type, (XmlOptions) null);
        }

        public static Group parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Group) XmlBeans.getContextTypeLoader().parse(url, Group.type, xmlOptions);
        }

        public static Group parse(InputStream inputStream) throws XmlException, IOException {
            return (Group) XmlBeans.getContextTypeLoader().parse(inputStream, Group.type, (XmlOptions) null);
        }

        public static Group parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Group) XmlBeans.getContextTypeLoader().parse(inputStream, Group.type, xmlOptions);
        }

        public static Group parse(Reader reader) throws XmlException, IOException {
            return (Group) XmlBeans.getContextTypeLoader().parse(reader, Group.type, (XmlOptions) null);
        }

        public static Group parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Group) XmlBeans.getContextTypeLoader().parse(reader, Group.type, xmlOptions);
        }

        public static Group parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (Group) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Group.type, (XmlOptions) null);
        }

        public static Group parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (Group) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Group.type, xmlOptions);
        }

        public static Group parse(Node node) throws XmlException {
            return (Group) XmlBeans.getContextTypeLoader().parse(node, Group.type, (XmlOptions) null);
        }

        public static Group parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (Group) XmlBeans.getContextTypeLoader().parse(node, Group.type, xmlOptions);
        }

        public static Group parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (Group) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Group.type, (XmlOptions) null);
        }

        public static Group parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (Group) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Group.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Group.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Group.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
