package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXmlColumnPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDxfId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STTotalsRowFunction;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STTotalsRowFunction$Enum;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

/* loaded from: classes6.dex */
public class CTTableColumnImpl extends XmlComplexContentImpl implements CTTableColumn {
    private static final QName CALCULATEDCOLUMNFORMULA$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "calculatedColumnFormula");
    private static final QName TOTALSROWFORMULA$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "totalsRowFormula");
    private static final QName XMLCOLUMNPR$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "xmlColumnPr");
    private static final QName EXTLST$6 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
    private static final QName ID$8 = new QName("", TtmlNode.ATTR_ID);
    private static final QName UNIQUENAME$10 = new QName("", "uniqueName");
    private static final QName NAME$12 = new QName("", "name");
    private static final QName TOTALSROWFUNCTION$14 = new QName("", "totalsRowFunction");
    private static final QName TOTALSROWLABEL$16 = new QName("", "totalsRowLabel");
    private static final QName QUERYTABLEFIELDID$18 = new QName("", "queryTableFieldId");
    private static final QName HEADERROWDXFID$20 = new QName("", "headerRowDxfId");
    private static final QName DATADXFID$22 = new QName("", "dataDxfId");
    private static final QName TOTALSROWDXFID$24 = new QName("", "totalsRowDxfId");
    private static final QName HEADERROWCELLSTYLE$26 = new QName("", "headerRowCellStyle");
    private static final QName DATACELLSTYLE$28 = new QName("", "dataCellStyle");
    private static final QName TOTALSROWCELLSTYLE$30 = new QName("", "totalsRowCellStyle");

    public CTTableColumnImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public CTTableFormula addNewCalculatedColumnFormula() {
        CTTableFormula add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CALCULATEDCOLUMNFORMULA$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public CTExtensionList addNewExtLst() {
        CTExtensionList add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EXTLST$6);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public CTTableFormula addNewTotalsRowFormula() {
        CTTableFormula add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TOTALSROWFORMULA$2);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public CTXmlColumnPr addNewXmlColumnPr() {
        CTXmlColumnPr cTXmlColumnPr;
        synchronized (monitor()) {
            check_orphaned();
            cTXmlColumnPr = (CTXmlColumnPr) get_store().add_element_user(XMLCOLUMNPR$4);
        }
        return cTXmlColumnPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public CTTableFormula getCalculatedColumnFormula() {
        synchronized (monitor()) {
            check_orphaned();
            CTTableFormula find_element_user = get_store().find_element_user(CALCULATEDCOLUMNFORMULA$0, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public String getDataCellStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DATACELLSTYLE$28);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public long getDataDxfId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DATADXFID$22);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList find_element_user = get_store().find_element_user(EXTLST$6, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public String getHeaderRowCellStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HEADERROWCELLSTYLE$26);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public long getHeaderRowDxfId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HEADERROWDXFID$20);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public long getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$8);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(NAME$12);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public long getQueryTableFieldId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(QUERYTABLEFIELDID$18);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public String getTotalsRowCellStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TOTALSROWCELLSTYLE$30);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public long getTotalsRowDxfId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TOTALSROWDXFID$24);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public CTTableFormula getTotalsRowFormula() {
        synchronized (monitor()) {
            check_orphaned();
            CTTableFormula find_element_user = get_store().find_element_user(TOTALSROWFORMULA$2, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public STTotalsRowFunction$Enum getTotalsRowFunction() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOTALSROWFUNCTION$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return (STTotalsRowFunction$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public String getTotalsRowLabel() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TOTALSROWLABEL$16);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public String getUniqueName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(UNIQUENAME$10);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public CTXmlColumnPr getXmlColumnPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTXmlColumnPr cTXmlColumnPr = (CTXmlColumnPr) get_store().find_element_user(XMLCOLUMNPR$4, 0);
            if (cTXmlColumnPr == null) {
                return null;
            }
            return cTXmlColumnPr;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public boolean isSetCalculatedColumnFormula() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CALCULATEDCOLUMNFORMULA$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public boolean isSetDataCellStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DATACELLSTYLE$28) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public boolean isSetDataDxfId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DATADXFID$22) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public boolean isSetHeaderRowCellStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HEADERROWCELLSTYLE$26) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public boolean isSetHeaderRowDxfId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HEADERROWDXFID$20) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public boolean isSetQueryTableFieldId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(QUERYTABLEFIELDID$18) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public boolean isSetTotalsRowCellStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TOTALSROWCELLSTYLE$30) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public boolean isSetTotalsRowDxfId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TOTALSROWDXFID$24) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public boolean isSetTotalsRowFormula() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TOTALSROWFORMULA$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public boolean isSetTotalsRowFunction() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TOTALSROWFUNCTION$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public boolean isSetTotalsRowLabel() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TOTALSROWLABEL$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public boolean isSetUniqueName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(UNIQUENAME$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public boolean isSetXmlColumnPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(XMLCOLUMNPR$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void setCalculatedColumnFormula(CTTableFormula cTTableFormula) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CALCULATEDCOLUMNFORMULA$0;
            CTTableFormula find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTableFormula) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTableFormula);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void setDataCellStyle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DATACELLSTYLE$28;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void setDataDxfId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DATADXFID$22;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$6;
            CTExtensionList find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            find_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void setHeaderRowCellStyle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HEADERROWCELLSTYLE$26;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void setHeaderRowDxfId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HEADERROWDXFID$20;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void setId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$12;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void setQueryTableFieldId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = QUERYTABLEFIELDID$18;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void setTotalsRowCellStyle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOTALSROWCELLSTYLE$30;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void setTotalsRowDxfId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOTALSROWDXFID$24;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void setTotalsRowFormula(CTTableFormula cTTableFormula) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOTALSROWFORMULA$2;
            CTTableFormula find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTableFormula) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTableFormula);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void setTotalsRowFunction(STTotalsRowFunction$Enum sTTotalsRowFunction$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOTALSROWFUNCTION$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTotalsRowFunction$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void setTotalsRowLabel(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOTALSROWLABEL$16;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void setUniqueName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UNIQUENAME$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void setXmlColumnPr(CTXmlColumnPr cTXmlColumnPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = XMLCOLUMNPR$4;
            CTXmlColumnPr cTXmlColumnPr2 = (CTXmlColumnPr) typeStore.find_element_user(qName, 0);
            if (cTXmlColumnPr2 == null) {
                cTXmlColumnPr2 = (CTXmlColumnPr) get_store().add_element_user(qName);
            }
            cTXmlColumnPr2.set(cTXmlColumnPr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void unsetCalculatedColumnFormula() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CALCULATEDCOLUMNFORMULA$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void unsetDataCellStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DATACELLSTYLE$28);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void unsetDataDxfId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DATADXFID$22);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void unsetHeaderRowCellStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HEADERROWCELLSTYLE$26);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void unsetHeaderRowDxfId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HEADERROWDXFID$20);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void unsetQueryTableFieldId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(QUERYTABLEFIELDID$18);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void unsetTotalsRowCellStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TOTALSROWCELLSTYLE$30);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void unsetTotalsRowDxfId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TOTALSROWDXFID$24);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void unsetTotalsRowFormula() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TOTALSROWFORMULA$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void unsetTotalsRowFunction() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TOTALSROWFUNCTION$14);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void unsetTotalsRowLabel() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TOTALSROWLABEL$16);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void unsetUniqueName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(UNIQUENAME$10);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void unsetXmlColumnPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(XMLCOLUMNPR$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public STXstring xgetDataCellStyle() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_attribute_user(DATACELLSTYLE$28);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public STDxfId xgetDataDxfId() {
        STDxfId sTDxfId;
        synchronized (monitor()) {
            check_orphaned();
            sTDxfId = (STDxfId) get_store().find_attribute_user(DATADXFID$22);
        }
        return sTDxfId;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public STXstring xgetHeaderRowCellStyle() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_attribute_user(HEADERROWCELLSTYLE$26);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public STDxfId xgetHeaderRowDxfId() {
        STDxfId sTDxfId;
        synchronized (monitor()) {
            check_orphaned();
            sTDxfId = (STDxfId) get_store().find_attribute_user(HEADERROWDXFID$20);
        }
        return sTDxfId;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public XmlUnsignedInt xgetId() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(ID$8);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public STXstring xgetName() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_attribute_user(NAME$12);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public XmlUnsignedInt xgetQueryTableFieldId() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(QUERYTABLEFIELDID$18);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public STXstring xgetTotalsRowCellStyle() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_attribute_user(TOTALSROWCELLSTYLE$30);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public STDxfId xgetTotalsRowDxfId() {
        STDxfId sTDxfId;
        synchronized (monitor()) {
            check_orphaned();
            sTDxfId = (STDxfId) get_store().find_attribute_user(TOTALSROWDXFID$24);
        }
        return sTDxfId;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public STTotalsRowFunction xgetTotalsRowFunction() {
        STTotalsRowFunction find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOTALSROWFUNCTION$14;
            find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STTotalsRowFunction) get_default_attribute_value(qName);
            }
        }
        return find_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public STXstring xgetTotalsRowLabel() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_attribute_user(TOTALSROWLABEL$16);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public STXstring xgetUniqueName() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_attribute_user(UNIQUENAME$10);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void xsetDataCellStyle(STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DATACELLSTYLE$28;
            STXstring sTXstring2 = (STXstring) typeStore.find_attribute_user(qName);
            if (sTXstring2 == null) {
                sTXstring2 = (STXstring) get_store().add_attribute_user(qName);
            }
            sTXstring2.set(sTXstring);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void xsetDataDxfId(STDxfId sTDxfId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DATADXFID$22;
            STDxfId sTDxfId2 = (STDxfId) typeStore.find_attribute_user(qName);
            if (sTDxfId2 == null) {
                sTDxfId2 = (STDxfId) get_store().add_attribute_user(qName);
            }
            sTDxfId2.set(sTDxfId);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void xsetHeaderRowCellStyle(STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HEADERROWCELLSTYLE$26;
            STXstring sTXstring2 = (STXstring) typeStore.find_attribute_user(qName);
            if (sTXstring2 == null) {
                sTXstring2 = (STXstring) get_store().add_attribute_user(qName);
            }
            sTXstring2.set(sTXstring);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void xsetHeaderRowDxfId(STDxfId sTDxfId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HEADERROWDXFID$20;
            STDxfId sTDxfId2 = (STDxfId) typeStore.find_attribute_user(qName);
            if (sTDxfId2 == null) {
                sTDxfId2 = (STDxfId) get_store().add_attribute_user(qName);
            }
            sTDxfId2.set(sTDxfId);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void xsetId(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$8;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void xsetName(STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$12;
            STXstring sTXstring2 = (STXstring) typeStore.find_attribute_user(qName);
            if (sTXstring2 == null) {
                sTXstring2 = (STXstring) get_store().add_attribute_user(qName);
            }
            sTXstring2.set(sTXstring);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void xsetQueryTableFieldId(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = QUERYTABLEFIELDID$18;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void xsetTotalsRowCellStyle(STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOTALSROWCELLSTYLE$30;
            STXstring sTXstring2 = (STXstring) typeStore.find_attribute_user(qName);
            if (sTXstring2 == null) {
                sTXstring2 = (STXstring) get_store().add_attribute_user(qName);
            }
            sTXstring2.set(sTXstring);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void xsetTotalsRowDxfId(STDxfId sTDxfId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOTALSROWDXFID$24;
            STDxfId sTDxfId2 = (STDxfId) typeStore.find_attribute_user(qName);
            if (sTDxfId2 == null) {
                sTDxfId2 = (STDxfId) get_store().add_attribute_user(qName);
            }
            sTDxfId2.set(sTDxfId);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void xsetTotalsRowFunction(STTotalsRowFunction sTTotalsRowFunction) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOTALSROWFUNCTION$14;
            STTotalsRowFunction find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STTotalsRowFunction) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTotalsRowFunction);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void xsetTotalsRowLabel(STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOTALSROWLABEL$16;
            STXstring sTXstring2 = (STXstring) typeStore.find_attribute_user(qName);
            if (sTXstring2 == null) {
                sTXstring2 = (STXstring) get_store().add_attribute_user(qName);
            }
            sTXstring2.set(sTXstring);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn
    public void xsetUniqueName(STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UNIQUENAME$10;
            STXstring sTXstring2 = (STXstring) typeStore.find_attribute_user(qName);
            if (sTXstring2 == null) {
                sTXstring2 = (STXstring) get_store().add_attribute_user(qName);
            }
            sTXstring2.set(sTXstring);
        }
    }
}
