package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.LogFactory;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCfType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STConditionalFormattingOperator;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDxfId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STTimePeriod;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STTimePeriod$Enum;

/* loaded from: classes6.dex */
public class CTCfRuleImpl extends XmlComplexContentImpl implements CTCfRule {
    private static final QName FORMULA$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "formula");
    private static final QName COLORSCALE$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "colorScale");
    private static final QName DATABAR$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dataBar");
    private static final QName ICONSET$6 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "iconSet");
    private static final QName EXTLST$8 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
    private static final QName TYPE$10 = new QName("", "type");
    private static final QName DXFID$12 = new QName("", "dxfId");
    private static final QName PRIORITY$14 = new QName("", LogFactory.PRIORITY_KEY);
    private static final QName STOPIFTRUE$16 = new QName("", "stopIfTrue");
    private static final QName ABOVEAVERAGE$18 = new QName("", "aboveAverage");
    private static final QName PERCENT$20 = new QName("", "percent");
    private static final QName BOTTOM$22 = new QName("", "bottom");
    private static final QName OPERATOR$24 = new QName("", "operator");
    private static final QName TEXT$26 = new QName("", "text");
    private static final QName TIMEPERIOD$28 = new QName("", "timePeriod");
    private static final QName RANK$30 = new QName("", "rank");
    private static final QName STDDEV$32 = new QName("", "stdDev");
    private static final QName EQUALAVERAGE$34 = new QName("", "equalAverage");

    public CTCfRuleImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void addFormula(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(FORMULA$0)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public CTColorScale addNewColorScale() {
        CTColorScale add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(COLORSCALE$2);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public CTDataBar addNewDataBar() {
        CTDataBar add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(DATABAR$4);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public CTExtensionList addNewExtLst() {
        CTExtensionList add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EXTLST$8);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STFormula addNewFormula() {
        STFormula sTFormula;
        synchronized (monitor()) {
            check_orphaned();
            sTFormula = (STFormula) get_store().add_element_user(FORMULA$0);
        }
        return sTFormula;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public CTIconSet addNewIconSet() {
        CTIconSet add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(ICONSET$6);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean getAboveAverage() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABOVEAVERAGE$18;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean getBottom() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOTTOM$22;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public CTColorScale getColorScale() {
        synchronized (monitor()) {
            check_orphaned();
            CTColorScale find_element_user = get_store().find_element_user(COLORSCALE$2, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public CTDataBar getDataBar() {
        synchronized (monitor()) {
            check_orphaned();
            CTDataBar find_element_user = get_store().find_element_user(DATABAR$4, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public long getDxfId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DXFID$12);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean getEqualAverage() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EQUALAVERAGE$34;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList find_element_user = get_store().find_element_user(EXTLST$8, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public String getFormulaArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(FORMULA$0, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public String[] getFormulaArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FORMULA$0, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public List<String> getFormulaList() {
        1FormulaList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FormulaList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public CTIconSet getIconSet() {
        synchronized (monitor()) {
            check_orphaned();
            CTIconSet find_element_user = get_store().find_element_user(ICONSET$6, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STConditionalFormattingOperator.Enum getOperator() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(OPERATOR$24);
            if (simpleValue == null) {
                return null;
            }
            return (STConditionalFormattingOperator.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean getPercent() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PERCENT$20;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public int getPriority() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PRIORITY$14);
            if (simpleValue == null) {
                return 0;
            }
            return simpleValue.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public long getRank() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(RANK$30);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public int getStdDev() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STDDEV$32);
            if (simpleValue == null) {
                return 0;
            }
            return simpleValue.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean getStopIfTrue() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STOPIFTRUE$16;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public String getText() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TEXT$26);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STTimePeriod$Enum getTimePeriod() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TIMEPERIOD$28);
            if (simpleValue == null) {
                return null;
            }
            return (STTimePeriod$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STCfType.Enum getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TYPE$10);
            if (simpleValue == null) {
                return null;
            }
            return (STCfType.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void insertFormula(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(FORMULA$0, i)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STFormula insertNewFormula(int i) {
        STFormula sTFormula;
        synchronized (monitor()) {
            check_orphaned();
            sTFormula = (STFormula) get_store().insert_element_user(FORMULA$0, i);
        }
        return sTFormula;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetAboveAverage() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ABOVEAVERAGE$18) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetBottom() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BOTTOM$22) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetColorScale() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(COLORSCALE$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetDataBar() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DATABAR$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetDxfId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DXFID$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetEqualAverage() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EQUALAVERAGE$34) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetIconSet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ICONSET$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetOperator() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OPERATOR$24) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetPercent() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PERCENT$20) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetRank() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RANK$30) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetStdDev() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STDDEV$32) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetStopIfTrue() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STOPIFTRUE$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetText() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TEXT$26) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetTimePeriod() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TIMEPERIOD$28) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void removeFormula(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FORMULA$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setAboveAverage(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABOVEAVERAGE$18;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setBottom(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOTTOM$22;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setColorScale(CTColorScale cTColorScale) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLORSCALE$2;
            CTColorScale find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTColorScale) get_store().add_element_user(qName);
            }
            find_element_user.set(cTColorScale);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setDataBar(CTDataBar cTDataBar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DATABAR$4;
            CTDataBar find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTDataBar) get_store().add_element_user(qName);
            }
            find_element_user.set(cTDataBar);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setDxfId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DXFID$12;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setEqualAverage(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EQUALAVERAGE$34;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$8;
            CTExtensionList find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            find_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setFormulaArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(FORMULA$0, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setFormulaArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, FORMULA$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setIconSet(CTIconSet cTIconSet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ICONSET$6;
            CTIconSet find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTIconSet) get_store().add_element_user(qName);
            }
            find_element_user.set(cTIconSet);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setOperator(STConditionalFormattingOperator.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPERATOR$24;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setPercent(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PERCENT$20;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setPriority(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRIORITY$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setRank(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RANK$30;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setStdDev(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STDDEV$32;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setStopIfTrue(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STOPIFTRUE$16;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setText(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXT$26;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setTimePeriod(STTimePeriod$Enum sTTimePeriod$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TIMEPERIOD$28;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTimePeriod$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setType(STCfType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public int sizeOfFormulaArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FORMULA$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetAboveAverage() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ABOVEAVERAGE$18);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetBottom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BOTTOM$22);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetColorScale() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COLORSCALE$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetDataBar() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DATABAR$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetDxfId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DXFID$12);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetEqualAverage() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EQUALAVERAGE$34);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetIconSet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ICONSET$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetOperator() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OPERATOR$24);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetPercent() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PERCENT$20);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetRank() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RANK$30);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetStdDev() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STDDEV$32);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetStopIfTrue() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STOPIFTRUE$16);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TEXT$26);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetTimePeriod() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TIMEPERIOD$28);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$10);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public XmlBoolean xgetAboveAverage() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABOVEAVERAGE$18;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public XmlBoolean xgetBottom() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOTTOM$22;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STDxfId xgetDxfId() {
        STDxfId sTDxfId;
        synchronized (monitor()) {
            check_orphaned();
            sTDxfId = (STDxfId) get_store().find_attribute_user(DXFID$12);
        }
        return sTDxfId;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public XmlBoolean xgetEqualAverage() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EQUALAVERAGE$34;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STFormula xgetFormulaArray(int i) {
        STFormula sTFormula;
        synchronized (monitor()) {
            check_orphaned();
            sTFormula = (STFormula) get_store().find_element_user(FORMULA$0, i);
            if (sTFormula == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTFormula;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STFormula[] xgetFormulaArray() {
        STFormula[] sTFormulaArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FORMULA$0, arrayList);
            sTFormulaArr = new STFormula[arrayList.size()];
            arrayList.toArray(sTFormulaArr);
        }
        return sTFormulaArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public List<STFormula> xgetFormulaList() {
        2FormulaList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2FormulaList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STConditionalFormattingOperator xgetOperator() {
        STConditionalFormattingOperator sTConditionalFormattingOperator;
        synchronized (monitor()) {
            check_orphaned();
            sTConditionalFormattingOperator = (STConditionalFormattingOperator) get_store().find_attribute_user(OPERATOR$24);
        }
        return sTConditionalFormattingOperator;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public XmlBoolean xgetPercent() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PERCENT$20;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public XmlInt xgetPriority() {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().find_attribute_user(PRIORITY$14);
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public XmlUnsignedInt xgetRank() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(RANK$30);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public XmlInt xgetStdDev() {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().find_attribute_user(STDDEV$32);
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public XmlBoolean xgetStopIfTrue() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STOPIFTRUE$16;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public XmlString xgetText() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(TEXT$26);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STTimePeriod xgetTimePeriod() {
        STTimePeriod find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(TIMEPERIOD$28);
        }
        return find_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STCfType xgetType() {
        STCfType sTCfType;
        synchronized (monitor()) {
            check_orphaned();
            sTCfType = (STCfType) get_store().find_attribute_user(TYPE$10);
        }
        return sTCfType;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetAboveAverage(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABOVEAVERAGE$18;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetBottom(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOTTOM$22;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetDxfId(STDxfId sTDxfId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DXFID$12;
            STDxfId sTDxfId2 = (STDxfId) typeStore.find_attribute_user(qName);
            if (sTDxfId2 == null) {
                sTDxfId2 = (STDxfId) get_store().add_attribute_user(qName);
            }
            sTDxfId2.set(sTDxfId);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetEqualAverage(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EQUALAVERAGE$34;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetFormulaArray(int i, STFormula sTFormula) {
        synchronized (monitor()) {
            check_orphaned();
            STFormula sTFormula2 = (STFormula) get_store().find_element_user(FORMULA$0, i);
            if (sTFormula2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTFormula2.set(sTFormula);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetFormulaArray(STFormula[] sTFormulaArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTFormulaArr, FORMULA$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetOperator(STConditionalFormattingOperator sTConditionalFormattingOperator) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPERATOR$24;
            STConditionalFormattingOperator sTConditionalFormattingOperator2 = (STConditionalFormattingOperator) typeStore.find_attribute_user(qName);
            if (sTConditionalFormattingOperator2 == null) {
                sTConditionalFormattingOperator2 = (STConditionalFormattingOperator) get_store().add_attribute_user(qName);
            }
            sTConditionalFormattingOperator2.set(sTConditionalFormattingOperator);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetPercent(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PERCENT$20;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetPriority(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRIORITY$14;
            XmlInt xmlInt2 = (XmlInt) typeStore.find_attribute_user(qName);
            if (xmlInt2 == null) {
                xmlInt2 = (XmlInt) get_store().add_attribute_user(qName);
            }
            xmlInt2.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetRank(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RANK$30;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetStdDev(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STDDEV$32;
            XmlInt xmlInt2 = (XmlInt) typeStore.find_attribute_user(qName);
            if (xmlInt2 == null) {
                xmlInt2 = (XmlInt) get_store().add_attribute_user(qName);
            }
            xmlInt2.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetStopIfTrue(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STOPIFTRUE$16;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetText(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXT$26;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetTimePeriod(STTimePeriod sTTimePeriod) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TIMEPERIOD$28;
            STTimePeriod find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STTimePeriod) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTimePeriod);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetType(STCfType sTCfType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$10;
            STCfType sTCfType2 = (STCfType) typeStore.find_attribute_user(qName);
            if (sTCfType2 == null) {
                sTCfType2 = (STCfType) get_store().add_attribute_user(qName);
            }
            sTCfType2.set(sTCfType);
        }
    }
}
