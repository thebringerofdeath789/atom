package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTCacheField extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTCacheField.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcachefieldae21type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCacheField newInstance() {
            return (CTCacheField) XmlBeans.getContextTypeLoader().newInstance(CTCacheField.type, null);
        }

        public static CTCacheField newInstance(XmlOptions xmlOptions) {
            return (CTCacheField) XmlBeans.getContextTypeLoader().newInstance(CTCacheField.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCacheField.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCacheField.type, xmlOptions);
        }

        public static CTCacheField parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCacheField) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCacheField.type, (XmlOptions) null);
        }

        public static CTCacheField parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCacheField) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCacheField.type, xmlOptions);
        }

        public static CTCacheField parse(File file) throws XmlException, IOException {
            return (CTCacheField) XmlBeans.getContextTypeLoader().parse(file, CTCacheField.type, (XmlOptions) null);
        }

        public static CTCacheField parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCacheField) XmlBeans.getContextTypeLoader().parse(file, CTCacheField.type, xmlOptions);
        }

        public static CTCacheField parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCacheField) XmlBeans.getContextTypeLoader().parse(inputStream, CTCacheField.type, (XmlOptions) null);
        }

        public static CTCacheField parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCacheField) XmlBeans.getContextTypeLoader().parse(inputStream, CTCacheField.type, xmlOptions);
        }

        public static CTCacheField parse(Reader reader) throws XmlException, IOException {
            return (CTCacheField) XmlBeans.getContextTypeLoader().parse(reader, CTCacheField.type, (XmlOptions) null);
        }

        public static CTCacheField parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCacheField) XmlBeans.getContextTypeLoader().parse(reader, CTCacheField.type, xmlOptions);
        }

        public static CTCacheField parse(String str) throws XmlException {
            return (CTCacheField) XmlBeans.getContextTypeLoader().parse(str, CTCacheField.type, (XmlOptions) null);
        }

        public static CTCacheField parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCacheField) XmlBeans.getContextTypeLoader().parse(str, CTCacheField.type, xmlOptions);
        }

        public static CTCacheField parse(URL url) throws XmlException, IOException {
            return (CTCacheField) XmlBeans.getContextTypeLoader().parse(url, CTCacheField.type, (XmlOptions) null);
        }

        public static CTCacheField parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCacheField) XmlBeans.getContextTypeLoader().parse(url, CTCacheField.type, xmlOptions);
        }

        public static CTCacheField parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTCacheField) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCacheField.type, (XmlOptions) null);
        }

        public static CTCacheField parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTCacheField) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCacheField.type, xmlOptions);
        }

        public static CTCacheField parse(Node node) throws XmlException {
            return (CTCacheField) XmlBeans.getContextTypeLoader().parse(node, CTCacheField.type, (XmlOptions) null);
        }

        public static CTCacheField parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCacheField) XmlBeans.getContextTypeLoader().parse(node, CTCacheField.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTFieldGroup addNewFieldGroup();

    CTX addNewMpMap();

    CTSharedItems addNewSharedItems();

    String getCaption();

    boolean getDatabaseField();

    CTExtensionList getExtLst();

    CTFieldGroup getFieldGroup();

    String getFormula();

    int getHierarchy();

    long getLevel();

    long getMappingCount();

    boolean getMemberPropertyField();

    CTX getMpMapArray(int i);

    CTX[] getMpMapArray();

    List<CTX> getMpMapList();

    String getName();

    long getNumFmtId();

    String getPropertyName();

    boolean getServerField();

    CTSharedItems getSharedItems();

    int getSqlType();

    boolean getUniqueList();

    CTX insertNewMpMap(int i);

    boolean isSetCaption();

    boolean isSetDatabaseField();

    boolean isSetExtLst();

    boolean isSetFieldGroup();

    boolean isSetFormula();

    boolean isSetHierarchy();

    boolean isSetLevel();

    boolean isSetMappingCount();

    boolean isSetMemberPropertyField();

    boolean isSetNumFmtId();

    boolean isSetPropertyName();

    boolean isSetServerField();

    boolean isSetSharedItems();

    boolean isSetSqlType();

    boolean isSetUniqueList();

    void removeMpMap(int i);

    void setCaption(String str);

    void setDatabaseField(boolean z);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFieldGroup(CTFieldGroup cTFieldGroup);

    void setFormula(String str);

    void setHierarchy(int i);

    void setLevel(long j);

    void setMappingCount(long j);

    void setMemberPropertyField(boolean z);

    void setMpMapArray(int i, CTX ctx);

    void setMpMapArray(CTX[] ctxArr);

    void setName(String str);

    void setNumFmtId(long j);

    void setPropertyName(String str);

    void setServerField(boolean z);

    void setSharedItems(CTSharedItems cTSharedItems);

    void setSqlType(int i);

    void setUniqueList(boolean z);

    int sizeOfMpMapArray();

    void unsetCaption();

    void unsetDatabaseField();

    void unsetExtLst();

    void unsetFieldGroup();

    void unsetFormula();

    void unsetHierarchy();

    void unsetLevel();

    void unsetMappingCount();

    void unsetMemberPropertyField();

    void unsetNumFmtId();

    void unsetPropertyName();

    void unsetServerField();

    void unsetSharedItems();

    void unsetSqlType();

    void unsetUniqueList();

    STXstring xgetCaption();

    XmlBoolean xgetDatabaseField();

    STXstring xgetFormula();

    XmlInt xgetHierarchy();

    XmlUnsignedInt xgetLevel();

    XmlUnsignedInt xgetMappingCount();

    XmlBoolean xgetMemberPropertyField();

    STXstring xgetName();

    STNumFmtId xgetNumFmtId();

    STXstring xgetPropertyName();

    XmlBoolean xgetServerField();

    XmlInt xgetSqlType();

    XmlBoolean xgetUniqueList();

    void xsetCaption(STXstring sTXstring);

    void xsetDatabaseField(XmlBoolean xmlBoolean);

    void xsetFormula(STXstring sTXstring);

    void xsetHierarchy(XmlInt xmlInt);

    void xsetLevel(XmlUnsignedInt xmlUnsignedInt);

    void xsetMappingCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetMemberPropertyField(XmlBoolean xmlBoolean);

    void xsetName(STXstring sTXstring);

    void xsetNumFmtId(STNumFmtId sTNumFmtId);

    void xsetPropertyName(STXstring sTXstring);

    void xsetServerField(XmlBoolean xmlBoolean);

    void xsetSqlType(XmlInt xmlInt);

    void xsetUniqueList(XmlBoolean xmlBoolean);
}
