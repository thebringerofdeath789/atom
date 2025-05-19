package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDataBinding;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPlaceholder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDocPart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDropDownList;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;

/* loaded from: classes6.dex */
public class CTSdtPrImpl extends XmlComplexContentImpl implements CTSdtPr {
    private static final QName RPR$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPr");
    private static final QName ALIAS$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "alias");
    private static final QName LOCK$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lock");
    private static final QName PLACEHOLDER$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "placeholder");
    private static final QName SHOWINGPLCHDR$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "showingPlcHdr");
    private static final QName DATABINDING$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dataBinding");
    private static final QName TEMPORARY$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "temporary");
    private static final QName ID$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", TtmlNode.ATTR_ID);
    private static final QName TAG$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tag");
    private static final QName EQUATION$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "equation");
    private static final QName COMBOBOX$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "comboBox");
    private static final QName DATE$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "date");
    private static final QName DOCPARTOBJ$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "docPartObj");
    private static final QName DOCPARTLIST$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "docPartList");
    private static final QName DROPDOWNLIST$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dropDownList");
    private static final QName PICTURE$30 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "picture");
    private static final QName RICHTEXT$32 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "richText");
    private static final QName TEXT$34 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "text");
    private static final QName CITATION$36 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "citation");
    private static final QName GROUP$38 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "group");
    private static final QName BIBLIOGRAPHY$40 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bibliography");

    public CTSdtPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTString addNewAlias() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(ALIAS$2);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty addNewBibliography() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(BIBLIOGRAPHY$40);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty addNewCitation() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(CITATION$36);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtComboBox addNewComboBox() {
        CTSdtComboBox add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(COMBOBOX$20);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDataBinding addNewDataBinding() {
        CTDataBinding add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(DATABINDING$10);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDate addNewDate() {
        CTSdtDate add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(DATE$22);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDocPart addNewDocPartList() {
        CTSdtDocPart cTSdtDocPart;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDocPart = (CTSdtDocPart) get_store().add_element_user(DOCPARTLIST$26);
        }
        return cTSdtDocPart;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDocPart addNewDocPartObj() {
        CTSdtDocPart cTSdtDocPart;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDocPart = (CTSdtDocPart) get_store().add_element_user(DOCPARTOBJ$24);
        }
        return cTSdtDocPart;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDropDownList addNewDropDownList() {
        CTSdtDropDownList add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(DROPDOWNLIST$28);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty addNewEquation() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(EQUATION$18);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty addNewGroup() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(GROUP$38);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDecimalNumber addNewId() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(ID$14);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTLock addNewLock() {
        CTLock add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(LOCK$4);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty addNewPicture() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PICTURE$30);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTPlaceholder addNewPlaceholder() {
        CTPlaceholder add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(PLACEHOLDER$6);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTRPr addNewRPr() {
        CTRPr cTRPr;
        synchronized (monitor()) {
            check_orphaned();
            cTRPr = (CTRPr) get_store().add_element_user(RPR$0);
        }
        return cTRPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty addNewRichText() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(RICHTEXT$32);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTOnOff addNewShowingPlcHdr() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(SHOWINGPLCHDR$8);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTString addNewTag() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(TAG$16);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTOnOff addNewTemporary() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(TEMPORARY$12);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtText addNewText() {
        CTSdtText add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TEXT$34);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTString getAliasArray(int i) {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().find_element_user(ALIAS$2, i);
            if (cTString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTString[] getAliasArray() {
        CTString[] cTStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ALIAS$2, arrayList);
            cTStringArr = new CTString[arrayList.size()];
            arrayList.toArray(cTStringArr);
        }
        return cTStringArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTString> getAliasList() {
        1AliasList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AliasList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty getBibliographyArray(int i) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(BIBLIOGRAPHY$40, i);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty[] getBibliographyArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BIBLIOGRAPHY$40, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTEmpty> getBibliographyList() {
        1BibliographyList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BibliographyList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty getCitationArray(int i) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(CITATION$36, i);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty[] getCitationArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CITATION$36, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTEmpty> getCitationList() {
        1CitationList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CitationList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtComboBox getComboBoxArray(int i) {
        CTSdtComboBox find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(COMBOBOX$20, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtComboBox[] getComboBoxArray() {
        CTSdtComboBox[] cTSdtComboBoxArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMBOBOX$20, arrayList);
            cTSdtComboBoxArr = new CTSdtComboBox[arrayList.size()];
            arrayList.toArray(cTSdtComboBoxArr);
        }
        return cTSdtComboBoxArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTSdtComboBox> getComboBoxList() {
        1ComboBoxList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ComboBoxList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDataBinding getDataBindingArray(int i) {
        CTDataBinding find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(DATABINDING$10, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDataBinding[] getDataBindingArray() {
        CTDataBinding[] cTDataBindingArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DATABINDING$10, arrayList);
            cTDataBindingArr = new CTDataBinding[arrayList.size()];
            arrayList.toArray(cTDataBindingArr);
        }
        return cTDataBindingArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTDataBinding> getDataBindingList() {
        1DataBindingList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DataBindingList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDate getDateArray(int i) {
        CTSdtDate find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(DATE$22, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDate[] getDateArray() {
        CTSdtDate[] cTSdtDateArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DATE$22, arrayList);
            cTSdtDateArr = new CTSdtDate[arrayList.size()];
            arrayList.toArray(cTSdtDateArr);
        }
        return cTSdtDateArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTSdtDate> getDateList() {
        1DateList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DateList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDocPart getDocPartListArray(int i) {
        CTSdtDocPart cTSdtDocPart;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDocPart = (CTSdtDocPart) get_store().find_element_user(DOCPARTLIST$26, i);
            if (cTSdtDocPart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSdtDocPart;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDocPart[] getDocPartListArray() {
        CTSdtDocPart[] cTSdtDocPartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DOCPARTLIST$26, arrayList);
            cTSdtDocPartArr = new CTSdtDocPart[arrayList.size()];
            arrayList.toArray(cTSdtDocPartArr);
        }
        return cTSdtDocPartArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTSdtDocPart> getDocPartListList() {
        1DocPartListList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DocPartListList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDocPart getDocPartObjArray(int i) {
        CTSdtDocPart cTSdtDocPart;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDocPart = (CTSdtDocPart) get_store().find_element_user(DOCPARTOBJ$24, i);
            if (cTSdtDocPart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSdtDocPart;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDocPart[] getDocPartObjArray() {
        CTSdtDocPart[] cTSdtDocPartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DOCPARTOBJ$24, arrayList);
            cTSdtDocPartArr = new CTSdtDocPart[arrayList.size()];
            arrayList.toArray(cTSdtDocPartArr);
        }
        return cTSdtDocPartArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTSdtDocPart> getDocPartObjList() {
        1DocPartObjList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DocPartObjList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDropDownList getDropDownListArray(int i) {
        CTSdtDropDownList find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(DROPDOWNLIST$28, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDropDownList[] getDropDownListArray() {
        CTSdtDropDownList[] cTSdtDropDownListArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DROPDOWNLIST$28, arrayList);
            cTSdtDropDownListArr = new CTSdtDropDownList[arrayList.size()];
            arrayList.toArray(cTSdtDropDownListArr);
        }
        return cTSdtDropDownListArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTSdtDropDownList> getDropDownListList() {
        1DropDownListList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DropDownListList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty getEquationArray(int i) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(EQUATION$18, i);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty[] getEquationArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(EQUATION$18, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTEmpty> getEquationList() {
        1EquationList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1EquationList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty getGroupArray(int i) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(GROUP$38, i);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty[] getGroupArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GROUP$38, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTEmpty> getGroupList() {
        1GroupList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1GroupList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDecimalNumber getIdArray(int i) {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(ID$14, i);
            if (cTDecimalNumber == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDecimalNumber[] getIdArray() {
        CTDecimalNumber[] cTDecimalNumberArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ID$14, arrayList);
            cTDecimalNumberArr = new CTDecimalNumber[arrayList.size()];
            arrayList.toArray(cTDecimalNumberArr);
        }
        return cTDecimalNumberArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTDecimalNumber> getIdList() {
        1IdList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1IdList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTLock getLockArray(int i) {
        CTLock find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(LOCK$4, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTLock[] getLockArray() {
        CTLock[] cTLockArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LOCK$4, arrayList);
            cTLockArr = new CTLock[arrayList.size()];
            arrayList.toArray(cTLockArr);
        }
        return cTLockArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTLock> getLockList() {
        1LockList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LockList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty getPictureArray(int i) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PICTURE$30, i);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty[] getPictureArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PICTURE$30, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTEmpty> getPictureList() {
        1PictureList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PictureList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTPlaceholder getPlaceholderArray(int i) {
        CTPlaceholder find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(PLACEHOLDER$6, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTPlaceholder[] getPlaceholderArray() {
        CTPlaceholder[] cTPlaceholderArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PLACEHOLDER$6, arrayList);
            cTPlaceholderArr = new CTPlaceholder[arrayList.size()];
            arrayList.toArray(cTPlaceholderArr);
        }
        return cTPlaceholderArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTPlaceholder> getPlaceholderList() {
        1PlaceholderList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PlaceholderList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTRPr getRPrArray(int i) {
        CTRPr cTRPr;
        synchronized (monitor()) {
            check_orphaned();
            cTRPr = (CTRPr) get_store().find_element_user(RPR$0, i);
            if (cTRPr == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTRPr[] getRPrArray() {
        CTRPr[] cTRPrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(RPR$0, arrayList);
            cTRPrArr = new CTRPr[arrayList.size()];
            arrayList.toArray(cTRPrArr);
        }
        return cTRPrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTRPr> getRPrList() {
        1RPrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RPrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty getRichTextArray(int i) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(RICHTEXT$32, i);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty[] getRichTextArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(RICHTEXT$32, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTEmpty> getRichTextList() {
        1RichTextList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RichTextList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTOnOff getShowingPlcHdrArray(int i) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(SHOWINGPLCHDR$8, i);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTOnOff[] getShowingPlcHdrArray() {
        CTOnOff[] cTOnOffArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SHOWINGPLCHDR$8, arrayList);
            cTOnOffArr = new CTOnOff[arrayList.size()];
            arrayList.toArray(cTOnOffArr);
        }
        return cTOnOffArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTOnOff> getShowingPlcHdrList() {
        1ShowingPlcHdrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ShowingPlcHdrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTString getTagArray(int i) {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().find_element_user(TAG$16, i);
            if (cTString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTString[] getTagArray() {
        CTString[] cTStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TAG$16, arrayList);
            cTStringArr = new CTString[arrayList.size()];
            arrayList.toArray(cTStringArr);
        }
        return cTStringArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTString> getTagList() {
        1TagList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TagList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTOnOff getTemporaryArray(int i) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(TEMPORARY$12, i);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTOnOff[] getTemporaryArray() {
        CTOnOff[] cTOnOffArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TEMPORARY$12, arrayList);
            cTOnOffArr = new CTOnOff[arrayList.size()];
            arrayList.toArray(cTOnOffArr);
        }
        return cTOnOffArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTOnOff> getTemporaryList() {
        1TemporaryList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TemporaryList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtText getTextArray(int i) {
        CTSdtText find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(TEXT$34, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtText[] getTextArray() {
        CTSdtText[] cTSdtTextArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TEXT$34, arrayList);
            cTSdtTextArr = new CTSdtText[arrayList.size()];
            arrayList.toArray(cTSdtTextArr);
        }
        return cTSdtTextArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public List<CTSdtText> getTextList() {
        1TextList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TextList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTString insertNewAlias(int i) {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().insert_element_user(ALIAS$2, i);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty insertNewBibliography(int i) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(BIBLIOGRAPHY$40, i);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty insertNewCitation(int i) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(CITATION$36, i);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtComboBox insertNewComboBox(int i) {
        CTSdtComboBox insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(COMBOBOX$20, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDataBinding insertNewDataBinding(int i) {
        CTDataBinding insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(DATABINDING$10, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDate insertNewDate(int i) {
        CTSdtDate insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(DATE$22, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDocPart insertNewDocPartList(int i) {
        CTSdtDocPart cTSdtDocPart;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDocPart = (CTSdtDocPart) get_store().insert_element_user(DOCPARTLIST$26, i);
        }
        return cTSdtDocPart;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDocPart insertNewDocPartObj(int i) {
        CTSdtDocPart cTSdtDocPart;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDocPart = (CTSdtDocPart) get_store().insert_element_user(DOCPARTOBJ$24, i);
        }
        return cTSdtDocPart;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtDropDownList insertNewDropDownList(int i) {
        CTSdtDropDownList insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(DROPDOWNLIST$28, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty insertNewEquation(int i) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(EQUATION$18, i);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty insertNewGroup(int i) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(GROUP$38, i);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTDecimalNumber insertNewId(int i) {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().insert_element_user(ID$14, i);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTLock insertNewLock(int i) {
        CTLock insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(LOCK$4, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty insertNewPicture(int i) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PICTURE$30, i);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTPlaceholder insertNewPlaceholder(int i) {
        CTPlaceholder insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(PLACEHOLDER$6, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTRPr insertNewRPr(int i) {
        CTRPr cTRPr;
        synchronized (monitor()) {
            check_orphaned();
            cTRPr = (CTRPr) get_store().insert_element_user(RPR$0, i);
        }
        return cTRPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTEmpty insertNewRichText(int i) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(RICHTEXT$32, i);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTOnOff insertNewShowingPlcHdr(int i) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(SHOWINGPLCHDR$8, i);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTString insertNewTag(int i) {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().insert_element_user(TAG$16, i);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTOnOff insertNewTemporary(int i) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(TEMPORARY$12, i);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public CTSdtText insertNewText(int i) {
        CTSdtText insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(TEXT$34, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeAlias(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALIAS$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeBibliography(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BIBLIOGRAPHY$40, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeCitation(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CITATION$36, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeComboBox(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMBOBOX$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeDataBinding(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DATABINDING$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeDate(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DATE$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeDocPartList(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DOCPARTLIST$26, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeDocPartObj(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DOCPARTOBJ$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeDropDownList(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DROPDOWNLIST$28, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeEquation(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EQUATION$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeGroup(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GROUP$38, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeId(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ID$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeLock(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LOCK$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removePicture(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PICTURE$30, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removePlaceholder(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PLACEHOLDER$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeRPr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RPR$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeRichText(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RICHTEXT$32, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeShowingPlcHdr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHOWINGPLCHDR$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeTag(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TAG$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeTemporary(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEMPORARY$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void removeText(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXT$34, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setAliasArray(int i, CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTString2 = (CTString) get_store().find_element_user(ALIAS$2, i);
            if (cTString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTString2.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setAliasArray(CTString[] cTStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTStringArr, ALIAS$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setBibliographyArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmpty2 = (CTEmpty) get_store().find_element_user(BIBLIOGRAPHY$40, i);
            if (cTEmpty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmpty2.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setBibliographyArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, BIBLIOGRAPHY$40);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setCitationArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmpty2 = (CTEmpty) get_store().find_element_user(CITATION$36, i);
            if (cTEmpty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmpty2.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setCitationArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, CITATION$36);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setComboBoxArray(int i, CTSdtComboBox cTSdtComboBox) {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtComboBox find_element_user = get_store().find_element_user(COMBOBOX$20, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTSdtComboBox);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setComboBoxArray(CTSdtComboBox[] cTSdtComboBoxArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSdtComboBoxArr, COMBOBOX$20);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDataBindingArray(int i, CTDataBinding cTDataBinding) {
        synchronized (monitor()) {
            check_orphaned();
            CTDataBinding find_element_user = get_store().find_element_user(DATABINDING$10, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTDataBinding);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDataBindingArray(CTDataBinding[] cTDataBindingArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTDataBindingArr, DATABINDING$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDateArray(int i, CTSdtDate cTSdtDate) {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtDate find_element_user = get_store().find_element_user(DATE$22, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTSdtDate);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDateArray(CTSdtDate[] cTSdtDateArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSdtDateArr, DATE$22);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDocPartListArray(int i, CTSdtDocPart cTSdtDocPart) {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtDocPart cTSdtDocPart2 = (CTSdtDocPart) get_store().find_element_user(DOCPARTLIST$26, i);
            if (cTSdtDocPart2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSdtDocPart2.set(cTSdtDocPart);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDocPartListArray(CTSdtDocPart[] cTSdtDocPartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSdtDocPartArr, DOCPARTLIST$26);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDocPartObjArray(int i, CTSdtDocPart cTSdtDocPart) {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtDocPart cTSdtDocPart2 = (CTSdtDocPart) get_store().find_element_user(DOCPARTOBJ$24, i);
            if (cTSdtDocPart2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSdtDocPart2.set(cTSdtDocPart);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDocPartObjArray(CTSdtDocPart[] cTSdtDocPartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSdtDocPartArr, DOCPARTOBJ$24);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDropDownListArray(int i, CTSdtDropDownList cTSdtDropDownList) {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtDropDownList find_element_user = get_store().find_element_user(DROPDOWNLIST$28, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTSdtDropDownList);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setDropDownListArray(CTSdtDropDownList[] cTSdtDropDownListArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSdtDropDownListArr, DROPDOWNLIST$28);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setEquationArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmpty2 = (CTEmpty) get_store().find_element_user(EQUATION$18, i);
            if (cTEmpty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmpty2.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setEquationArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, EQUATION$18);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setGroupArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmpty2 = (CTEmpty) get_store().find_element_user(GROUP$38, i);
            if (cTEmpty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmpty2.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setGroupArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, GROUP$38);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setIdArray(int i, CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumber2 = (CTDecimalNumber) get_store().find_element_user(ID$14, i);
            if (cTDecimalNumber2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTDecimalNumber2.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setIdArray(CTDecimalNumber[] cTDecimalNumberArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTDecimalNumberArr, ID$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setLockArray(int i, CTLock cTLock) {
        synchronized (monitor()) {
            check_orphaned();
            CTLock find_element_user = get_store().find_element_user(LOCK$4, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTLock);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setLockArray(CTLock[] cTLockArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTLockArr, LOCK$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setPictureArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmpty2 = (CTEmpty) get_store().find_element_user(PICTURE$30, i);
            if (cTEmpty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmpty2.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setPictureArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, PICTURE$30);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setPlaceholderArray(int i, CTPlaceholder cTPlaceholder) {
        synchronized (monitor()) {
            check_orphaned();
            CTPlaceholder find_element_user = get_store().find_element_user(PLACEHOLDER$6, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTPlaceholder);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setPlaceholderArray(CTPlaceholder[] cTPlaceholderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPlaceholderArr, PLACEHOLDER$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setRPrArray(int i, CTRPr cTRPr) {
        synchronized (monitor()) {
            check_orphaned();
            CTRPr cTRPr2 = (CTRPr) get_store().find_element_user(RPR$0, i);
            if (cTRPr2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRPr2.set(cTRPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setRPrArray(CTRPr[] cTRPrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRPrArr, RPR$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setRichTextArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmpty2 = (CTEmpty) get_store().find_element_user(RICHTEXT$32, i);
            if (cTEmpty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEmpty2.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setRichTextArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEmptyArr, RICHTEXT$32);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setShowingPlcHdrArray(int i, CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff2 = (CTOnOff) get_store().find_element_user(SHOWINGPLCHDR$8, i);
            if (cTOnOff2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setShowingPlcHdrArray(CTOnOff[] cTOnOffArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOnOffArr, SHOWINGPLCHDR$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setTagArray(int i, CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTString2 = (CTString) get_store().find_element_user(TAG$16, i);
            if (cTString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTString2.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setTagArray(CTString[] cTStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTStringArr, TAG$16);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setTemporaryArray(int i, CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff2 = (CTOnOff) get_store().find_element_user(TEMPORARY$12, i);
            if (cTOnOff2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setTemporaryArray(CTOnOff[] cTOnOffArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOnOffArr, TEMPORARY$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setTextArray(int i, CTSdtText cTSdtText) {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtText find_element_user = get_store().find_element_user(TEXT$34, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTSdtText);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public void setTextArray(CTSdtText[] cTSdtTextArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSdtTextArr, TEXT$34);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfAliasArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ALIAS$2);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfBibliographyArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BIBLIOGRAPHY$40);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfCitationArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CITATION$36);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfComboBoxArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(COMBOBOX$20);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfDataBindingArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DATABINDING$10);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfDateArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DATE$22);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfDocPartListArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DOCPARTLIST$26);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfDocPartObjArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DOCPARTOBJ$24);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfDropDownListArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DROPDOWNLIST$28);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfEquationArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(EQUATION$18);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfGroupArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(GROUP$38);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfIdArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ID$14);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfLockArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(LOCK$4);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfPictureArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PICTURE$30);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfPlaceholderArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PLACEHOLDER$6);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfRPrArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(RPR$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfRichTextArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(RICHTEXT$32);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfShowingPlcHdrArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SHOWINGPLCHDR$8);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfTagArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TAG$16);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfTemporaryArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TEMPORARY$12);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr
    public int sizeOfTextArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TEXT$34);
        }
        return count_elements;
    }
}
