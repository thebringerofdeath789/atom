package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.util.CellUtil;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCnf;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase;

/* loaded from: classes6.dex */
public class CTTrPrBaseImpl extends XmlComplexContentImpl implements CTTrPrBase {
    private static final QName CNFSTYLE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cnfStyle");
    private static final QName DIVID$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "divId");
    private static final QName GRIDBEFORE$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "gridBefore");
    private static final QName GRIDAFTER$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "gridAfter");
    private static final QName WBEFORE$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "wBefore");
    private static final QName WAFTER$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "wAfter");
    private static final QName CANTSPLIT$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cantSplit");
    private static final QName TRHEIGHT$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "trHeight");
    private static final QName TBLHEADER$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblHeader");
    private static final QName TBLCELLSPACING$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblCellSpacing");
    private static final QName JC$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "jc");
    private static final QName HIDDEN$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", CellUtil.HIDDEN);

    public CTTrPrBaseImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff addNewCantSplit() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(CANTSPLIT$12);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTCnf addNewCnfStyle() {
        CTCnf add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CNFSTYLE$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber addNewDivId() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(DIVID$2);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber addNewGridAfter() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(GRIDAFTER$6);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber addNewGridBefore() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(GRIDBEFORE$4);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff addNewHidden() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(HIDDEN$22);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTJc addNewJc() {
        CTJc cTJc;
        synchronized (monitor()) {
            check_orphaned();
            cTJc = (CTJc) get_store().add_element_user(JC$20);
        }
        return cTJc;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth addNewTblCellSpacing() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(TBLCELLSPACING$18);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff addNewTblHeader() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(TBLHEADER$16);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTHeight addNewTrHeight() {
        CTHeight cTHeight;
        synchronized (monitor()) {
            check_orphaned();
            cTHeight = (CTHeight) get_store().add_element_user(TRHEIGHT$14);
        }
        return cTHeight;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth addNewWAfter() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(WAFTER$10);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth addNewWBefore() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(WBEFORE$8);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff getCantSplitArray(int i) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(CANTSPLIT$12, i);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff[] getCantSplitArray() {
        CTOnOff[] cTOnOffArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CANTSPLIT$12, arrayList);
            cTOnOffArr = new CTOnOff[arrayList.size()];
            arrayList.toArray(cTOnOffArr);
        }
        return cTOnOffArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTOnOff> getCantSplitList() {
        1CantSplitList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CantSplitList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTCnf getCnfStyleArray(int i) {
        CTCnf find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(CNFSTYLE$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTCnf[] getCnfStyleArray() {
        CTCnf[] cTCnfArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CNFSTYLE$0, arrayList);
            cTCnfArr = new CTCnf[arrayList.size()];
            arrayList.toArray(cTCnfArr);
        }
        return cTCnfArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTCnf> getCnfStyleList() {
        1CnfStyleList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CnfStyleList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber getDivIdArray(int i) {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(DIVID$2, i);
            if (cTDecimalNumber == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber[] getDivIdArray() {
        CTDecimalNumber[] cTDecimalNumberArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DIVID$2, arrayList);
            cTDecimalNumberArr = new CTDecimalNumber[arrayList.size()];
            arrayList.toArray(cTDecimalNumberArr);
        }
        return cTDecimalNumberArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTDecimalNumber> getDivIdList() {
        1DivIdList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DivIdList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber getGridAfterArray(int i) {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(GRIDAFTER$6, i);
            if (cTDecimalNumber == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber[] getGridAfterArray() {
        CTDecimalNumber[] cTDecimalNumberArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GRIDAFTER$6, arrayList);
            cTDecimalNumberArr = new CTDecimalNumber[arrayList.size()];
            arrayList.toArray(cTDecimalNumberArr);
        }
        return cTDecimalNumberArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTDecimalNumber> getGridAfterList() {
        1GridAfterList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1GridAfterList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber getGridBeforeArray(int i) {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(GRIDBEFORE$4, i);
            if (cTDecimalNumber == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber[] getGridBeforeArray() {
        CTDecimalNumber[] cTDecimalNumberArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GRIDBEFORE$4, arrayList);
            cTDecimalNumberArr = new CTDecimalNumber[arrayList.size()];
            arrayList.toArray(cTDecimalNumberArr);
        }
        return cTDecimalNumberArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTDecimalNumber> getGridBeforeList() {
        1GridBeforeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1GridBeforeList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff getHiddenArray(int i) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(HIDDEN$22, i);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff[] getHiddenArray() {
        CTOnOff[] cTOnOffArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(HIDDEN$22, arrayList);
            cTOnOffArr = new CTOnOff[arrayList.size()];
            arrayList.toArray(cTOnOffArr);
        }
        return cTOnOffArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTOnOff> getHiddenList() {
        1HiddenList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1HiddenList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTJc getJcArray(int i) {
        CTJc cTJc;
        synchronized (monitor()) {
            check_orphaned();
            cTJc = (CTJc) get_store().find_element_user(JC$20, i);
            if (cTJc == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTJc;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTJc[] getJcArray() {
        CTJc[] cTJcArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(JC$20, arrayList);
            cTJcArr = new CTJc[arrayList.size()];
            arrayList.toArray(cTJcArr);
        }
        return cTJcArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTJc> getJcList() {
        1JcList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1JcList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth getTblCellSpacingArray(int i) {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().find_element_user(TBLCELLSPACING$18, i);
            if (cTTblWidth == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth[] getTblCellSpacingArray() {
        CTTblWidth[] cTTblWidthArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TBLCELLSPACING$18, arrayList);
            cTTblWidthArr = new CTTblWidth[arrayList.size()];
            arrayList.toArray(cTTblWidthArr);
        }
        return cTTblWidthArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTTblWidth> getTblCellSpacingList() {
        1TblCellSpacingList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TblCellSpacingList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff getTblHeaderArray(int i) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(TBLHEADER$16, i);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff[] getTblHeaderArray() {
        CTOnOff[] cTOnOffArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TBLHEADER$16, arrayList);
            cTOnOffArr = new CTOnOff[arrayList.size()];
            arrayList.toArray(cTOnOffArr);
        }
        return cTOnOffArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTOnOff> getTblHeaderList() {
        1TblHeaderList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TblHeaderList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTHeight getTrHeightArray(int i) {
        CTHeight cTHeight;
        synchronized (monitor()) {
            check_orphaned();
            cTHeight = (CTHeight) get_store().find_element_user(TRHEIGHT$14, i);
            if (cTHeight == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTHeight;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTHeight[] getTrHeightArray() {
        CTHeight[] cTHeightArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TRHEIGHT$14, arrayList);
            cTHeightArr = new CTHeight[arrayList.size()];
            arrayList.toArray(cTHeightArr);
        }
        return cTHeightArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTHeight> getTrHeightList() {
        1TrHeightList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TrHeightList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth getWAfterArray(int i) {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().find_element_user(WAFTER$10, i);
            if (cTTblWidth == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth[] getWAfterArray() {
        CTTblWidth[] cTTblWidthArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(WAFTER$10, arrayList);
            cTTblWidthArr = new CTTblWidth[arrayList.size()];
            arrayList.toArray(cTTblWidthArr);
        }
        return cTTblWidthArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTTblWidth> getWAfterList() {
        1WAfterList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1WAfterList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth getWBeforeArray(int i) {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().find_element_user(WBEFORE$8, i);
            if (cTTblWidth == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth[] getWBeforeArray() {
        CTTblWidth[] cTTblWidthArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(WBEFORE$8, arrayList);
            cTTblWidthArr = new CTTblWidth[arrayList.size()];
            arrayList.toArray(cTTblWidthArr);
        }
        return cTTblWidthArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTTblWidth> getWBeforeList() {
        1WBeforeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1WBeforeList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff insertNewCantSplit(int i) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(CANTSPLIT$12, i);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTCnf insertNewCnfStyle(int i) {
        CTCnf insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(CNFSTYLE$0, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber insertNewDivId(int i) {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().insert_element_user(DIVID$2, i);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber insertNewGridAfter(int i) {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().insert_element_user(GRIDAFTER$6, i);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber insertNewGridBefore(int i) {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().insert_element_user(GRIDBEFORE$4, i);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff insertNewHidden(int i) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(HIDDEN$22, i);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTJc insertNewJc(int i) {
        CTJc cTJc;
        synchronized (monitor()) {
            check_orphaned();
            cTJc = (CTJc) get_store().insert_element_user(JC$20, i);
        }
        return cTJc;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth insertNewTblCellSpacing(int i) {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().insert_element_user(TBLCELLSPACING$18, i);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff insertNewTblHeader(int i) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(TBLHEADER$16, i);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTHeight insertNewTrHeight(int i) {
        CTHeight cTHeight;
        synchronized (monitor()) {
            check_orphaned();
            cTHeight = (CTHeight) get_store().insert_element_user(TRHEIGHT$14, i);
        }
        return cTHeight;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth insertNewWAfter(int i) {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().insert_element_user(WAFTER$10, i);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth insertNewWBefore(int i) {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().insert_element_user(WBEFORE$8, i);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeCantSplit(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CANTSPLIT$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeCnfStyle(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CNFSTYLE$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeDivId(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DIVID$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeGridAfter(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRIDAFTER$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeGridBefore(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRIDBEFORE$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeHidden(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HIDDEN$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeJc(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(JC$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeTblCellSpacing(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLCELLSPACING$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeTblHeader(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLHEADER$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeTrHeight(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TRHEIGHT$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeWAfter(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WAFTER$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeWBefore(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WBEFORE$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setCantSplitArray(int i, CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff2 = (CTOnOff) get_store().find_element_user(CANTSPLIT$12, i);
            if (cTOnOff2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setCantSplitArray(CTOnOff[] cTOnOffArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOnOffArr, CANTSPLIT$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setCnfStyleArray(int i, CTCnf cTCnf) {
        synchronized (monitor()) {
            check_orphaned();
            CTCnf find_element_user = get_store().find_element_user(CNFSTYLE$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTCnf);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setCnfStyleArray(CTCnf[] cTCnfArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTCnfArr, CNFSTYLE$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setDivIdArray(int i, CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumber2 = (CTDecimalNumber) get_store().find_element_user(DIVID$2, i);
            if (cTDecimalNumber2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTDecimalNumber2.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setDivIdArray(CTDecimalNumber[] cTDecimalNumberArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTDecimalNumberArr, DIVID$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setGridAfterArray(int i, CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumber2 = (CTDecimalNumber) get_store().find_element_user(GRIDAFTER$6, i);
            if (cTDecimalNumber2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTDecimalNumber2.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setGridAfterArray(CTDecimalNumber[] cTDecimalNumberArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTDecimalNumberArr, GRIDAFTER$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setGridBeforeArray(int i, CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumber2 = (CTDecimalNumber) get_store().find_element_user(GRIDBEFORE$4, i);
            if (cTDecimalNumber2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTDecimalNumber2.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setGridBeforeArray(CTDecimalNumber[] cTDecimalNumberArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTDecimalNumberArr, GRIDBEFORE$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setHiddenArray(int i, CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff2 = (CTOnOff) get_store().find_element_user(HIDDEN$22, i);
            if (cTOnOff2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setHiddenArray(CTOnOff[] cTOnOffArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOnOffArr, HIDDEN$22);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setJcArray(int i, CTJc cTJc) {
        synchronized (monitor()) {
            check_orphaned();
            CTJc cTJc2 = (CTJc) get_store().find_element_user(JC$20, i);
            if (cTJc2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTJc2.set(cTJc);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setJcArray(CTJc[] cTJcArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTJcArr, JC$20);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setTblCellSpacingArray(int i, CTTblWidth cTTblWidth) {
        synchronized (monitor()) {
            check_orphaned();
            CTTblWidth cTTblWidth2 = (CTTblWidth) get_store().find_element_user(TBLCELLSPACING$18, i);
            if (cTTblWidth2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTblWidth2.set(cTTblWidth);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setTblCellSpacingArray(CTTblWidth[] cTTblWidthArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTblWidthArr, TBLCELLSPACING$18);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setTblHeaderArray(int i, CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff2 = (CTOnOff) get_store().find_element_user(TBLHEADER$16, i);
            if (cTOnOff2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setTblHeaderArray(CTOnOff[] cTOnOffArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOnOffArr, TBLHEADER$16);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setTrHeightArray(int i, CTHeight cTHeight) {
        synchronized (monitor()) {
            check_orphaned();
            CTHeight cTHeight2 = (CTHeight) get_store().find_element_user(TRHEIGHT$14, i);
            if (cTHeight2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTHeight2.set(cTHeight);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setTrHeightArray(CTHeight[] cTHeightArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTHeightArr, TRHEIGHT$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setWAfterArray(int i, CTTblWidth cTTblWidth) {
        synchronized (monitor()) {
            check_orphaned();
            CTTblWidth cTTblWidth2 = (CTTblWidth) get_store().find_element_user(WAFTER$10, i);
            if (cTTblWidth2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTblWidth2.set(cTTblWidth);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setWAfterArray(CTTblWidth[] cTTblWidthArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTblWidthArr, WAFTER$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setWBeforeArray(int i, CTTblWidth cTTblWidth) {
        synchronized (monitor()) {
            check_orphaned();
            CTTblWidth cTTblWidth2 = (CTTblWidth) get_store().find_element_user(WBEFORE$8, i);
            if (cTTblWidth2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTblWidth2.set(cTTblWidth);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setWBeforeArray(CTTblWidth[] cTTblWidthArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTblWidthArr, WBEFORE$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfCantSplitArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CANTSPLIT$12);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfCnfStyleArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CNFSTYLE$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfDivIdArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DIVID$2);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfGridAfterArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(GRIDAFTER$6);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfGridBeforeArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(GRIDBEFORE$4);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfHiddenArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(HIDDEN$22);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfJcArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(JC$20);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfTblCellSpacingArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TBLCELLSPACING$18);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfTblHeaderArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TBLHEADER$16);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfTrHeightArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TRHEIGHT$14);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfWAfterArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(WAFTER$10);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfWBeforeArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(WBEFORE$8);
        }
        return count_elements;
    }
}
