package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTPivotCacheDefinition extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPivotCacheDefinition.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpivotcachedefinition575ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPivotCacheDefinition newInstance() {
            return (CTPivotCacheDefinition) XmlBeans.getContextTypeLoader().newInstance(CTPivotCacheDefinition.type, null);
        }

        public static CTPivotCacheDefinition newInstance(XmlOptions xmlOptions) {
            return (CTPivotCacheDefinition) XmlBeans.getContextTypeLoader().newInstance(CTPivotCacheDefinition.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPivotCacheDefinition.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPivotCacheDefinition.type, xmlOptions);
        }

        public static CTPivotCacheDefinition parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPivotCacheDefinition) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPivotCacheDefinition.type, (XmlOptions) null);
        }

        public static CTPivotCacheDefinition parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotCacheDefinition) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPivotCacheDefinition.type, xmlOptions);
        }

        public static CTPivotCacheDefinition parse(File file) throws XmlException, IOException {
            return (CTPivotCacheDefinition) XmlBeans.getContextTypeLoader().parse(file, CTPivotCacheDefinition.type, (XmlOptions) null);
        }

        public static CTPivotCacheDefinition parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCacheDefinition) XmlBeans.getContextTypeLoader().parse(file, CTPivotCacheDefinition.type, xmlOptions);
        }

        public static CTPivotCacheDefinition parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPivotCacheDefinition) XmlBeans.getContextTypeLoader().parse(inputStream, CTPivotCacheDefinition.type, (XmlOptions) null);
        }

        public static CTPivotCacheDefinition parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCacheDefinition) XmlBeans.getContextTypeLoader().parse(inputStream, CTPivotCacheDefinition.type, xmlOptions);
        }

        public static CTPivotCacheDefinition parse(Reader reader) throws XmlException, IOException {
            return (CTPivotCacheDefinition) XmlBeans.getContextTypeLoader().parse(reader, CTPivotCacheDefinition.type, (XmlOptions) null);
        }

        public static CTPivotCacheDefinition parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCacheDefinition) XmlBeans.getContextTypeLoader().parse(reader, CTPivotCacheDefinition.type, xmlOptions);
        }

        public static CTPivotCacheDefinition parse(String str) throws XmlException {
            return (CTPivotCacheDefinition) XmlBeans.getContextTypeLoader().parse(str, CTPivotCacheDefinition.type, (XmlOptions) null);
        }

        public static CTPivotCacheDefinition parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotCacheDefinition) XmlBeans.getContextTypeLoader().parse(str, CTPivotCacheDefinition.type, xmlOptions);
        }

        public static CTPivotCacheDefinition parse(URL url) throws XmlException, IOException {
            return (CTPivotCacheDefinition) XmlBeans.getContextTypeLoader().parse(url, CTPivotCacheDefinition.type, (XmlOptions) null);
        }

        public static CTPivotCacheDefinition parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCacheDefinition) XmlBeans.getContextTypeLoader().parse(url, CTPivotCacheDefinition.type, xmlOptions);
        }

        public static CTPivotCacheDefinition parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPivotCacheDefinition) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPivotCacheDefinition.type, (XmlOptions) null);
        }

        public static CTPivotCacheDefinition parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPivotCacheDefinition) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPivotCacheDefinition.type, xmlOptions);
        }

        public static CTPivotCacheDefinition parse(Node node) throws XmlException {
            return (CTPivotCacheDefinition) XmlBeans.getContextTypeLoader().parse(node, CTPivotCacheDefinition.type, (XmlOptions) null);
        }

        public static CTPivotCacheDefinition parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotCacheDefinition) XmlBeans.getContextTypeLoader().parse(node, CTPivotCacheDefinition.type, xmlOptions);
        }
    }

    CTCacheFields addNewCacheFields();

    CTCacheHierarchies addNewCacheHierarchies();

    CTCacheSource addNewCacheSource();

    CTCalculatedItems addNewCalculatedItems();

    CTCalculatedMembers addNewCalculatedMembers();

    CTDimensions addNewDimensions();

    CTExtensionList addNewExtLst();

    CTPCDKPIs addNewKpis();

    CTMeasureDimensionMaps addNewMaps();

    CTMeasureGroups addNewMeasureGroups();

    CTTupleCache addNewTupleCache();

    boolean getBackgroundQuery();

    CTCacheFields getCacheFields();

    CTCacheHierarchies getCacheHierarchies();

    CTCacheSource getCacheSource();

    CTCalculatedItems getCalculatedItems();

    CTCalculatedMembers getCalculatedMembers();

    short getCreatedVersion();

    CTDimensions getDimensions();

    boolean getEnableRefresh();

    CTExtensionList getExtLst();

    String getId();

    boolean getInvalid();

    CTPCDKPIs getKpis();

    CTMeasureDimensionMaps getMaps();

    CTMeasureGroups getMeasureGroups();

    short getMinRefreshableVersion();

    long getMissingItemsLimit();

    boolean getOptimizeMemory();

    long getRecordCount();

    boolean getRefreshOnLoad();

    String getRefreshedBy();

    double getRefreshedDate();

    short getRefreshedVersion();

    boolean getSaveData();

    boolean getSupportAdvancedDrill();

    boolean getSupportSubquery();

    CTTupleCache getTupleCache();

    boolean getTupleCache2();

    boolean getUpgradeOnRefresh();

    boolean isSetBackgroundQuery();

    boolean isSetCacheHierarchies();

    boolean isSetCalculatedItems();

    boolean isSetCalculatedMembers();

    boolean isSetCreatedVersion();

    boolean isSetDimensions();

    boolean isSetEnableRefresh();

    boolean isSetExtLst();

    boolean isSetId();

    boolean isSetInvalid();

    boolean isSetKpis();

    boolean isSetMaps();

    boolean isSetMeasureGroups();

    boolean isSetMinRefreshableVersion();

    boolean isSetMissingItemsLimit();

    boolean isSetOptimizeMemory();

    boolean isSetRecordCount();

    boolean isSetRefreshOnLoad();

    boolean isSetRefreshedBy();

    boolean isSetRefreshedDate();

    boolean isSetRefreshedVersion();

    boolean isSetSaveData();

    boolean isSetSupportAdvancedDrill();

    boolean isSetSupportSubquery();

    boolean isSetTupleCache();

    boolean isSetTupleCache2();

    boolean isSetUpgradeOnRefresh();

    void setBackgroundQuery(boolean z);

    void setCacheFields(CTCacheFields cTCacheFields);

    void setCacheHierarchies(CTCacheHierarchies cTCacheHierarchies);

    void setCacheSource(CTCacheSource cTCacheSource);

    void setCalculatedItems(CTCalculatedItems cTCalculatedItems);

    void setCalculatedMembers(CTCalculatedMembers cTCalculatedMembers);

    void setCreatedVersion(short s);

    void setDimensions(CTDimensions cTDimensions);

    void setEnableRefresh(boolean z);

    void setExtLst(CTExtensionList cTExtensionList);

    void setId(String str);

    void setInvalid(boolean z);

    void setKpis(CTPCDKPIs cTPCDKPIs);

    void setMaps(CTMeasureDimensionMaps cTMeasureDimensionMaps);

    void setMeasureGroups(CTMeasureGroups cTMeasureGroups);

    void setMinRefreshableVersion(short s);

    void setMissingItemsLimit(long j);

    void setOptimizeMemory(boolean z);

    void setRecordCount(long j);

    void setRefreshOnLoad(boolean z);

    void setRefreshedBy(String str);

    void setRefreshedDate(double d);

    void setRefreshedVersion(short s);

    void setSaveData(boolean z);

    void setSupportAdvancedDrill(boolean z);

    void setSupportSubquery(boolean z);

    void setTupleCache(CTTupleCache cTTupleCache);

    void setTupleCache2(boolean z);

    void setUpgradeOnRefresh(boolean z);

    void unsetBackgroundQuery();

    void unsetCacheHierarchies();

    void unsetCalculatedItems();

    void unsetCalculatedMembers();

    void unsetCreatedVersion();

    void unsetDimensions();

    void unsetEnableRefresh();

    void unsetExtLst();

    void unsetId();

    void unsetInvalid();

    void unsetKpis();

    void unsetMaps();

    void unsetMeasureGroups();

    void unsetMinRefreshableVersion();

    void unsetMissingItemsLimit();

    void unsetOptimizeMemory();

    void unsetRecordCount();

    void unsetRefreshOnLoad();

    void unsetRefreshedBy();

    void unsetRefreshedDate();

    void unsetRefreshedVersion();

    void unsetSaveData();

    void unsetSupportAdvancedDrill();

    void unsetSupportSubquery();

    void unsetTupleCache();

    void unsetTupleCache2();

    void unsetUpgradeOnRefresh();

    XmlBoolean xgetBackgroundQuery();

    XmlUnsignedByte xgetCreatedVersion();

    XmlBoolean xgetEnableRefresh();

    STRelationshipId xgetId();

    XmlBoolean xgetInvalid();

    XmlUnsignedByte xgetMinRefreshableVersion();

    XmlUnsignedInt xgetMissingItemsLimit();

    XmlBoolean xgetOptimizeMemory();

    XmlUnsignedInt xgetRecordCount();

    XmlBoolean xgetRefreshOnLoad();

    STXstring xgetRefreshedBy();

    XmlDouble xgetRefreshedDate();

    XmlUnsignedByte xgetRefreshedVersion();

    XmlBoolean xgetSaveData();

    XmlBoolean xgetSupportAdvancedDrill();

    XmlBoolean xgetSupportSubquery();

    XmlBoolean xgetTupleCache2();

    XmlBoolean xgetUpgradeOnRefresh();

    void xsetBackgroundQuery(XmlBoolean xmlBoolean);

    void xsetCreatedVersion(XmlUnsignedByte xmlUnsignedByte);

    void xsetEnableRefresh(XmlBoolean xmlBoolean);

    void xsetId(STRelationshipId sTRelationshipId);

    void xsetInvalid(XmlBoolean xmlBoolean);

    void xsetMinRefreshableVersion(XmlUnsignedByte xmlUnsignedByte);

    void xsetMissingItemsLimit(XmlUnsignedInt xmlUnsignedInt);

    void xsetOptimizeMemory(XmlBoolean xmlBoolean);

    void xsetRecordCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetRefreshOnLoad(XmlBoolean xmlBoolean);

    void xsetRefreshedBy(STXstring sTXstring);

    void xsetRefreshedDate(XmlDouble xmlDouble);

    void xsetRefreshedVersion(XmlUnsignedByte xmlUnsignedByte);

    void xsetSaveData(XmlBoolean xmlBoolean);

    void xsetSupportAdvancedDrill(XmlBoolean xmlBoolean);

    void xsetSupportSubquery(XmlBoolean xmlBoolean);

    void xsetTupleCache2(XmlBoolean xmlBoolean);

    void xsetUpgradeOnRefresh(XmlBoolean xmlBoolean);
}
