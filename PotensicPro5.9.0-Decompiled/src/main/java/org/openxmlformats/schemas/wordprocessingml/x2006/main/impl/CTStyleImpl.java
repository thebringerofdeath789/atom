package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.util.CellUtil;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLongHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblStylePr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STStyleType;

/* loaded from: classes6.dex */
public class CTStyleImpl extends XmlComplexContentImpl implements CTStyle {
    private static final QName NAME$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "name");
    private static final QName ALIASES$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "aliases");
    private static final QName BASEDON$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "basedOn");
    private static final QName NEXT$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "next");
    private static final QName LINK$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "link");
    private static final QName AUTOREDEFINE$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "autoRedefine");
    private static final QName HIDDEN$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", CellUtil.HIDDEN);
    private static final QName UIPRIORITY$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "uiPriority");
    private static final QName SEMIHIDDEN$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "semiHidden");
    private static final QName UNHIDEWHENUSED$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "unhideWhenUsed");
    private static final QName QFORMAT$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "qFormat");
    private static final QName LOCKED$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", CellUtil.LOCKED);
    private static final QName PERSONAL$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "personal");
    private static final QName PERSONALCOMPOSE$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "personalCompose");
    private static final QName PERSONALREPLY$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "personalReply");
    private static final QName RSID$30 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rsid");
    private static final QName PPR$32 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pPr");
    private static final QName RPR$34 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPr");
    private static final QName TBLPR$36 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblPr");
    private static final QName TRPR$38 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "trPr");
    private static final QName TCPR$40 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcPr");
    private static final QName TBLSTYLEPR$42 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblStylePr");
    private static final QName TYPE$44 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "type");
    private static final QName STYLEID$46 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "styleId");
    private static final QName DEFAULT$48 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "default");
    private static final QName CUSTOMSTYLE$50 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customStyle");

    public CTStyleImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTString addNewAliases() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(ALIASES$2);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff addNewAutoRedefine() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(AUTOREDEFINE$10);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTString addNewBasedOn() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(BASEDON$4);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff addNewHidden() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(HIDDEN$12);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTString addNewLink() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(LINK$8);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff addNewLocked() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(LOCKED$22);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTString addNewName() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(NAME$0);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTString addNewNext() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(NEXT$6);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTPPr addNewPPr() {
        CTPPr cTPPr;
        synchronized (monitor()) {
            check_orphaned();
            cTPPr = (CTPPr) get_store().add_element_user(PPR$32);
        }
        return cTPPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff addNewPersonal() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PERSONAL$24);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff addNewPersonalCompose() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PERSONALCOMPOSE$26);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff addNewPersonalReply() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PERSONALREPLY$28);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff addNewQFormat() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(QFORMAT$20);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTRPr addNewRPr() {
        CTRPr cTRPr;
        synchronized (monitor()) {
            check_orphaned();
            cTRPr = (CTRPr) get_store().add_element_user(RPR$34);
        }
        return cTRPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTLongHexNumber addNewRsid() {
        CTLongHexNumber add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(RSID$30);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff addNewSemiHidden() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(SEMIHIDDEN$16);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTTblPrBase addNewTblPr() {
        CTTblPrBase cTTblPrBase;
        synchronized (monitor()) {
            check_orphaned();
            cTTblPrBase = (CTTblPrBase) get_store().add_element_user(TBLPR$36);
        }
        return cTTblPrBase;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTTblStylePr addNewTblStylePr() {
        CTTblStylePr add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TBLSTYLEPR$42);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTTcPr addNewTcPr() {
        CTTcPr cTTcPr;
        synchronized (monitor()) {
            check_orphaned();
            cTTcPr = (CTTcPr) get_store().add_element_user(TCPR$40);
        }
        return cTTcPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTTrPr addNewTrPr() {
        CTTrPr cTTrPr;
        synchronized (monitor()) {
            check_orphaned();
            cTTrPr = (CTTrPr) get_store().add_element_user(TRPR$38);
        }
        return cTTrPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTDecimalNumber addNewUiPriority() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(UIPRIORITY$14);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff addNewUnhideWhenUsed() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(UNHIDEWHENUSED$18);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTString getAliases() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTString = (CTString) get_store().find_element_user(ALIASES$2, 0);
            if (cTString == null) {
                return null;
            }
            return cTString;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff getAutoRedefine() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(AUTOREDEFINE$10, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTString getBasedOn() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTString = (CTString) get_store().find_element_user(BASEDON$4, 0);
            if (cTString == null) {
                return null;
            }
            return cTString;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public STOnOff.Enum getCustomStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CUSTOMSTYLE$50);
            if (simpleValue == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public STOnOff.Enum getDefault() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DEFAULT$48);
            if (simpleValue == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff getHidden() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(HIDDEN$12, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTString getLink() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTString = (CTString) get_store().find_element_user(LINK$8, 0);
            if (cTString == null) {
                return null;
            }
            return cTString;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff getLocked() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(LOCKED$22, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTString getName() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTString = (CTString) get_store().find_element_user(NAME$0, 0);
            if (cTString == null) {
                return null;
            }
            return cTString;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTString getNext() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTString = (CTString) get_store().find_element_user(NEXT$6, 0);
            if (cTString == null) {
                return null;
            }
            return cTString;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTPPr getPPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTPPr cTPPr = (CTPPr) get_store().find_element_user(PPR$32, 0);
            if (cTPPr == null) {
                return null;
            }
            return cTPPr;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff getPersonal() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(PERSONAL$24, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff getPersonalCompose() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(PERSONALCOMPOSE$26, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff getPersonalReply() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(PERSONALREPLY$28, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff getQFormat() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(QFORMAT$20, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTRPr getRPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTRPr cTRPr = (CTRPr) get_store().find_element_user(RPR$34, 0);
            if (cTRPr == null) {
                return null;
            }
            return cTRPr;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTLongHexNumber getRsid() {
        synchronized (monitor()) {
            check_orphaned();
            CTLongHexNumber find_element_user = get_store().find_element_user(RSID$30, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff getSemiHidden() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(SEMIHIDDEN$16, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public String getStyleId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STYLEID$46);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTTblPrBase getTblPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblPrBase cTTblPrBase = (CTTblPrBase) get_store().find_element_user(TBLPR$36, 0);
            if (cTTblPrBase == null) {
                return null;
            }
            return cTTblPrBase;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTTblStylePr getTblStylePrArray(int i) {
        CTTblStylePr find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(TBLSTYLEPR$42, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTTblStylePr[] getTblStylePrArray() {
        CTTblStylePr[] cTTblStylePrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TBLSTYLEPR$42, arrayList);
            cTTblStylePrArr = new CTTblStylePr[arrayList.size()];
            arrayList.toArray(cTTblStylePrArr);
        }
        return cTTblStylePrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public List<CTTblStylePr> getTblStylePrList() {
        1TblStylePrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TblStylePrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTTcPr getTcPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTcPr cTTcPr = (CTTcPr) get_store().find_element_user(TCPR$40, 0);
            if (cTTcPr == null) {
                return null;
            }
            return cTTcPr;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTTrPr getTrPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTrPr cTTrPr = (CTTrPr) get_store().find_element_user(TRPR$38, 0);
            if (cTTrPr == null) {
                return null;
            }
            return cTTrPr;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public STStyleType.Enum getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TYPE$44);
            if (simpleValue == null) {
                return null;
            }
            return (STStyleType.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTDecimalNumber getUiPriority() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(UIPRIORITY$14, 0);
            if (cTDecimalNumber == null) {
                return null;
            }
            return cTDecimalNumber;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff getUnhideWhenUsed() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(UNHIDEWHENUSED$18, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTTblStylePr insertNewTblStylePr(int i) {
        CTTblStylePr insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(TBLSTYLEPR$42, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetAliases() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ALIASES$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetAutoRedefine() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(AUTOREDEFINE$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetBasedOn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BASEDON$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetCustomStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CUSTOMSTYLE$50) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetDefault() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFAULT$48) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetHidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HIDDEN$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetLink() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LINK$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetLocked() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LOCKED$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NAME$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetNext() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NEXT$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetPPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PPR$32) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetPersonal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PERSONAL$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetPersonalCompose() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PERSONALCOMPOSE$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetPersonalReply() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PERSONALREPLY$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetQFormat() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(QFORMAT$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetRPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RPR$34) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetRsid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RSID$30) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetSemiHidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SEMIHIDDEN$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetStyleId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STYLEID$46) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetTblPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLPR$36) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetTcPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TCPR$40) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetTrPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TRPR$38) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$44) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetUiPriority() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UIPRIORITY$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetUnhideWhenUsed() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UNHIDEWHENUSED$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void removeTblStylePr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLSTYLEPR$42, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setAliases(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALIASES$2;
            CTString cTString2 = (CTString) typeStore.find_element_user(qName, 0);
            if (cTString2 == null) {
                cTString2 = (CTString) get_store().add_element_user(qName);
            }
            cTString2.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setAutoRedefine(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTOREDEFINE$10;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setBasedOn(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BASEDON$4;
            CTString cTString2 = (CTString) typeStore.find_element_user(qName, 0);
            if (cTString2 == null) {
                cTString2 = (CTString) get_store().add_element_user(qName);
            }
            cTString2.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setCustomStyle(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CUSTOMSTYLE$50;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setDefault(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULT$48;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setHidden(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIDDEN$12;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setLink(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINK$8;
            CTString cTString2 = (CTString) typeStore.find_element_user(qName, 0);
            if (cTString2 == null) {
                cTString2 = (CTString) get_store().add_element_user(qName);
            }
            cTString2.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setLocked(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LOCKED$22;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setName(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$0;
            CTString cTString2 = (CTString) typeStore.find_element_user(qName, 0);
            if (cTString2 == null) {
                cTString2 = (CTString) get_store().add_element_user(qName);
            }
            cTString2.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setNext(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NEXT$6;
            CTString cTString2 = (CTString) typeStore.find_element_user(qName, 0);
            if (cTString2 == null) {
                cTString2 = (CTString) get_store().add_element_user(qName);
            }
            cTString2.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setPPr(CTPPr cTPPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PPR$32;
            CTPPr cTPPr2 = (CTPPr) typeStore.find_element_user(qName, 0);
            if (cTPPr2 == null) {
                cTPPr2 = (CTPPr) get_store().add_element_user(qName);
            }
            cTPPr2.set(cTPPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setPersonal(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PERSONAL$24;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setPersonalCompose(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PERSONALCOMPOSE$26;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setPersonalReply(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PERSONALREPLY$28;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setQFormat(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = QFORMAT$20;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setRPr(CTRPr cTRPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RPR$34;
            CTRPr cTRPr2 = (CTRPr) typeStore.find_element_user(qName, 0);
            if (cTRPr2 == null) {
                cTRPr2 = (CTRPr) get_store().add_element_user(qName);
            }
            cTRPr2.set(cTRPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setRsid(CTLongHexNumber cTLongHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RSID$30;
            CTLongHexNumber find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTLongHexNumber) get_store().add_element_user(qName);
            }
            find_element_user.set(cTLongHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setSemiHidden(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SEMIHIDDEN$16;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setStyleId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLEID$46;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setTblPr(CTTblPrBase cTTblPrBase) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLPR$36;
            CTTblPrBase cTTblPrBase2 = (CTTblPrBase) typeStore.find_element_user(qName, 0);
            if (cTTblPrBase2 == null) {
                cTTblPrBase2 = (CTTblPrBase) get_store().add_element_user(qName);
            }
            cTTblPrBase2.set(cTTblPrBase);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setTblStylePrArray(int i, CTTblStylePr cTTblStylePr) {
        synchronized (monitor()) {
            check_orphaned();
            CTTblStylePr find_element_user = get_store().find_element_user(TBLSTYLEPR$42, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTTblStylePr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setTblStylePrArray(CTTblStylePr[] cTTblStylePrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTTblStylePrArr, TBLSTYLEPR$42);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setTcPr(CTTcPr cTTcPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TCPR$40;
            CTTcPr cTTcPr2 = (CTTcPr) typeStore.find_element_user(qName, 0);
            if (cTTcPr2 == null) {
                cTTcPr2 = (CTTcPr) get_store().add_element_user(qName);
            }
            cTTcPr2.set(cTTcPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setTrPr(CTTrPr cTTrPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRPR$38;
            CTTrPr cTTrPr2 = (CTTrPr) typeStore.find_element_user(qName, 0);
            if (cTTrPr2 == null) {
                cTTrPr2 = (CTTrPr) get_store().add_element_user(qName);
            }
            cTTrPr2.set(cTTrPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setType(STStyleType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$44;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setUiPriority(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UIPRIORITY$14;
            CTDecimalNumber cTDecimalNumber2 = (CTDecimalNumber) typeStore.find_element_user(qName, 0);
            if (cTDecimalNumber2 == null) {
                cTDecimalNumber2 = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumber2.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setUnhideWhenUsed(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UNHIDEWHENUSED$18;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public int sizeOfTblStylePrArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TBLSTYLEPR$42);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetAliases() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALIASES$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetAutoRedefine() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AUTOREDEFINE$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetBasedOn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BASEDON$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetCustomStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CUSTOMSTYLE$50);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetDefault() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFAULT$48);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetHidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HIDDEN$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetLink() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LINK$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetLocked() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LOCKED$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NAME$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetNext() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NEXT$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetPPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PPR$32, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetPersonal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERSONAL$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetPersonalCompose() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERSONALCOMPOSE$26, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetPersonalReply() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERSONALREPLY$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetQFormat() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(QFORMAT$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetRPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RPR$34, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetRsid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RSID$30, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetSemiHidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SEMIHIDDEN$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetStyleId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STYLEID$46);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetTblPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLPR$36, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetTcPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TCPR$40, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetTrPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TRPR$38, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$44);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetUiPriority() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UIPRIORITY$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetUnhideWhenUsed() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UNHIDEWHENUSED$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public STOnOff xgetCustomStyle() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(CUSTOMSTYLE$50);
        }
        return sTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public STOnOff xgetDefault() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(DEFAULT$48);
        }
        return sTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public STString xgetStyleId() {
        STString sTString;
        synchronized (monitor()) {
            check_orphaned();
            sTString = (STString) get_store().find_attribute_user(STYLEID$46);
        }
        return sTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public STStyleType xgetType() {
        STStyleType sTStyleType;
        synchronized (monitor()) {
            check_orphaned();
            sTStyleType = (STStyleType) get_store().find_attribute_user(TYPE$44);
        }
        return sTStyleType;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void xsetCustomStyle(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CUSTOMSTYLE$50;
            STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qName);
            if (sTOnOff2 == null) {
                sTOnOff2 = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOff2.set(sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void xsetDefault(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULT$48;
            STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qName);
            if (sTOnOff2 == null) {
                sTOnOff2 = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOff2.set(sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void xsetStyleId(STString sTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLEID$46;
            STString sTString2 = (STString) typeStore.find_attribute_user(qName);
            if (sTString2 == null) {
                sTString2 = (STString) get_store().add_attribute_user(qName);
            }
            sTString2.set(sTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void xsetType(STStyleType sTStyleType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$44;
            STStyleType sTStyleType2 = (STStyleType) typeStore.find_attribute_user(qName);
            if (sTStyleType2 == null) {
                sTStyleType2 = (STStyleType) get_store().add_attribute_user(qName);
            }
            sTStyleType2.set(sTStyleType);
        }
    }
}
