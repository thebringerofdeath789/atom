package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFDDList;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFHelpText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFName;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFStatusText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFTextInput;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMacroName;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;

/* loaded from: classes6.dex */
public class CTFFDataImpl extends XmlComplexContentImpl implements CTFFData {
    private static final QName NAME$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "name");
    private static final QName ENABLED$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "enabled");
    private static final QName CALCONEXIT$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "calcOnExit");
    private static final QName ENTRYMACRO$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "entryMacro");
    private static final QName EXITMACRO$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "exitMacro");
    private static final QName HELPTEXT$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "helpText");
    private static final QName STATUSTEXT$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "statusText");
    private static final QName CHECKBOX$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "checkBox");
    private static final QName DDLIST$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ddList");
    private static final QName TEXTINPUT$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "textInput");

    public CTFFDataImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff addNewCalcOnExit() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(CALCONEXIT$4);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFCheckBox addNewCheckBox() {
        CTFFCheckBox cTFFCheckBox;
        synchronized (monitor()) {
            check_orphaned();
            cTFFCheckBox = (CTFFCheckBox) get_store().add_element_user(CHECKBOX$14);
        }
        return cTFFCheckBox;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFDDList addNewDdList() {
        CTFFDDList add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(DDLIST$16);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff addNewEnabled() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(ENABLED$2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName addNewEntryMacro() {
        CTMacroName add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(ENTRYMACRO$6);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName addNewExitMacro() {
        CTMacroName add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EXITMACRO$8);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFHelpText addNewHelpText() {
        CTFFHelpText add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(HELPTEXT$10);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFName addNewName() {
        CTFFName add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(NAME$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFStatusText addNewStatusText() {
        CTFFStatusText add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(STATUSTEXT$12);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFTextInput addNewTextInput() {
        CTFFTextInput add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TEXTINPUT$18);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff getCalcOnExitArray(int i) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(CALCONEXIT$4, i);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff[] getCalcOnExitArray() {
        CTOnOff[] cTOnOffArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CALCONEXIT$4, arrayList);
            cTOnOffArr = new CTOnOff[arrayList.size()];
            arrayList.toArray(cTOnOffArr);
        }
        return cTOnOffArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTOnOff> getCalcOnExitList() {
        1CalcOnExitList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CalcOnExitList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFCheckBox getCheckBoxArray(int i) {
        CTFFCheckBox cTFFCheckBox;
        synchronized (monitor()) {
            check_orphaned();
            cTFFCheckBox = (CTFFCheckBox) get_store().find_element_user(CHECKBOX$14, i);
            if (cTFFCheckBox == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFFCheckBox;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFCheckBox[] getCheckBoxArray() {
        CTFFCheckBox[] cTFFCheckBoxArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CHECKBOX$14, arrayList);
            cTFFCheckBoxArr = new CTFFCheckBox[arrayList.size()];
            arrayList.toArray(cTFFCheckBoxArr);
        }
        return cTFFCheckBoxArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFCheckBox> getCheckBoxList() {
        AbstractList<CTFFCheckBox> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTFFCheckBox>() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTFFDataImpl.1CheckBoxList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTFFCheckBox cTFFCheckBox) {
                    CTFFDataImpl.this.insertNewCheckBox(i).set(cTFFCheckBox);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFFCheckBox get(int i) {
                    return CTFFDataImpl.this.getCheckBoxArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFFCheckBox remove(int i) {
                    CTFFCheckBox checkBoxArray = CTFFDataImpl.this.getCheckBoxArray(i);
                    CTFFDataImpl.this.removeCheckBox(i);
                    return checkBoxArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFFCheckBox set(int i, CTFFCheckBox cTFFCheckBox) {
                    CTFFCheckBox checkBoxArray = CTFFDataImpl.this.getCheckBoxArray(i);
                    CTFFDataImpl.this.setCheckBoxArray(i, cTFFCheckBox);
                    return checkBoxArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTFFDataImpl.this.sizeOfCheckBoxArray();
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFDDList getDdListArray(int i) {
        CTFFDDList find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(DDLIST$16, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFDDList[] getDdListArray() {
        CTFFDDList[] cTFFDDListArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DDLIST$16, arrayList);
            cTFFDDListArr = new CTFFDDList[arrayList.size()];
            arrayList.toArray(cTFFDDListArr);
        }
        return cTFFDDListArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFDDList> getDdListList() {
        1DdListList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DdListList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff getEnabledArray(int i) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(ENABLED$2, i);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff[] getEnabledArray() {
        CTOnOff[] cTOnOffArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ENABLED$2, arrayList);
            cTOnOffArr = new CTOnOff[arrayList.size()];
            arrayList.toArray(cTOnOffArr);
        }
        return cTOnOffArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTOnOff> getEnabledList() {
        1EnabledList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1EnabledList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName getEntryMacroArray(int i) {
        CTMacroName find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(ENTRYMACRO$6, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName[] getEntryMacroArray() {
        CTMacroName[] cTMacroNameArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ENTRYMACRO$6, arrayList);
            cTMacroNameArr = new CTMacroName[arrayList.size()];
            arrayList.toArray(cTMacroNameArr);
        }
        return cTMacroNameArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTMacroName> getEntryMacroList() {
        1EntryMacroList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1EntryMacroList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName getExitMacroArray(int i) {
        CTMacroName find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(EXITMACRO$8, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName[] getExitMacroArray() {
        CTMacroName[] cTMacroNameArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(EXITMACRO$8, arrayList);
            cTMacroNameArr = new CTMacroName[arrayList.size()];
            arrayList.toArray(cTMacroNameArr);
        }
        return cTMacroNameArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTMacroName> getExitMacroList() {
        1ExitMacroList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ExitMacroList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFHelpText getHelpTextArray(int i) {
        CTFFHelpText find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(HELPTEXT$10, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFHelpText[] getHelpTextArray() {
        CTFFHelpText[] cTFFHelpTextArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(HELPTEXT$10, arrayList);
            cTFFHelpTextArr = new CTFFHelpText[arrayList.size()];
            arrayList.toArray(cTFFHelpTextArr);
        }
        return cTFFHelpTextArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFHelpText> getHelpTextList() {
        1HelpTextList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1HelpTextList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFName getNameArray(int i) {
        CTFFName find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(NAME$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFName[] getNameArray() {
        CTFFName[] cTFFNameArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(NAME$0, arrayList);
            cTFFNameArr = new CTFFName[arrayList.size()];
            arrayList.toArray(cTFFNameArr);
        }
        return cTFFNameArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFName> getNameList() {
        1NameList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1NameList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFStatusText getStatusTextArray(int i) {
        CTFFStatusText find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(STATUSTEXT$12, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFStatusText[] getStatusTextArray() {
        CTFFStatusText[] cTFFStatusTextArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(STATUSTEXT$12, arrayList);
            cTFFStatusTextArr = new CTFFStatusText[arrayList.size()];
            arrayList.toArray(cTFFStatusTextArr);
        }
        return cTFFStatusTextArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFStatusText> getStatusTextList() {
        1StatusTextList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1StatusTextList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFTextInput getTextInputArray(int i) {
        CTFFTextInput find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(TEXTINPUT$18, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFTextInput[] getTextInputArray() {
        CTFFTextInput[] cTFFTextInputArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TEXTINPUT$18, arrayList);
            cTFFTextInputArr = new CTFFTextInput[arrayList.size()];
            arrayList.toArray(cTFFTextInputArr);
        }
        return cTFFTextInputArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFTextInput> getTextInputList() {
        1TextInputList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TextInputList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff insertNewCalcOnExit(int i) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(CALCONEXIT$4, i);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFCheckBox insertNewCheckBox(int i) {
        CTFFCheckBox cTFFCheckBox;
        synchronized (monitor()) {
            check_orphaned();
            cTFFCheckBox = (CTFFCheckBox) get_store().insert_element_user(CHECKBOX$14, i);
        }
        return cTFFCheckBox;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFDDList insertNewDdList(int i) {
        CTFFDDList insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(DDLIST$16, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff insertNewEnabled(int i) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(ENABLED$2, i);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName insertNewEntryMacro(int i) {
        CTMacroName insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(ENTRYMACRO$6, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName insertNewExitMacro(int i) {
        CTMacroName insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(EXITMACRO$8, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFHelpText insertNewHelpText(int i) {
        CTFFHelpText insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(HELPTEXT$10, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFName insertNewName(int i) {
        CTFFName insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(NAME$0, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFStatusText insertNewStatusText(int i) {
        CTFFStatusText insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(STATUSTEXT$12, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFTextInput insertNewTextInput(int i) {
        CTFFTextInput insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(TEXTINPUT$18, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeCalcOnExit(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CALCONEXIT$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeCheckBox(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CHECKBOX$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeDdList(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DDLIST$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeEnabled(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ENABLED$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeEntryMacro(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ENTRYMACRO$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeExitMacro(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXITMACRO$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeHelpText(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HELPTEXT$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeName(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NAME$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeStatusText(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STATUSTEXT$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeTextInput(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTINPUT$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setCalcOnExitArray(int i, CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff2 = (CTOnOff) get_store().find_element_user(CALCONEXIT$4, i);
            if (cTOnOff2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setCalcOnExitArray(CTOnOff[] cTOnOffArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOnOffArr, CALCONEXIT$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setCheckBoxArray(int i, CTFFCheckBox cTFFCheckBox) {
        synchronized (monitor()) {
            check_orphaned();
            CTFFCheckBox cTFFCheckBox2 = (CTFFCheckBox) get_store().find_element_user(CHECKBOX$14, i);
            if (cTFFCheckBox2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFFCheckBox2.set(cTFFCheckBox);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setCheckBoxArray(CTFFCheckBox[] cTFFCheckBoxArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFFCheckBoxArr, CHECKBOX$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setDdListArray(int i, CTFFDDList cTFFDDList) {
        synchronized (monitor()) {
            check_orphaned();
            CTFFDDList find_element_user = get_store().find_element_user(DDLIST$16, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTFFDDList);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setDdListArray(CTFFDDList[] cTFFDDListArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTFFDDListArr, DDLIST$16);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setEnabledArray(int i, CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff2 = (CTOnOff) get_store().find_element_user(ENABLED$2, i);
            if (cTOnOff2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setEnabledArray(CTOnOff[] cTOnOffArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOnOffArr, ENABLED$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setEntryMacroArray(int i, CTMacroName cTMacroName) {
        synchronized (monitor()) {
            check_orphaned();
            CTMacroName find_element_user = get_store().find_element_user(ENTRYMACRO$6, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTMacroName);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setEntryMacroArray(CTMacroName[] cTMacroNameArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTMacroNameArr, ENTRYMACRO$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setExitMacroArray(int i, CTMacroName cTMacroName) {
        synchronized (monitor()) {
            check_orphaned();
            CTMacroName find_element_user = get_store().find_element_user(EXITMACRO$8, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTMacroName);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setExitMacroArray(CTMacroName[] cTMacroNameArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTMacroNameArr, EXITMACRO$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setHelpTextArray(int i, CTFFHelpText cTFFHelpText) {
        synchronized (monitor()) {
            check_orphaned();
            CTFFHelpText find_element_user = get_store().find_element_user(HELPTEXT$10, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTFFHelpText);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setHelpTextArray(CTFFHelpText[] cTFFHelpTextArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTFFHelpTextArr, HELPTEXT$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setNameArray(int i, CTFFName cTFFName) {
        synchronized (monitor()) {
            check_orphaned();
            CTFFName find_element_user = get_store().find_element_user(NAME$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTFFName);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setNameArray(CTFFName[] cTFFNameArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTFFNameArr, NAME$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setStatusTextArray(int i, CTFFStatusText cTFFStatusText) {
        synchronized (monitor()) {
            check_orphaned();
            CTFFStatusText find_element_user = get_store().find_element_user(STATUSTEXT$12, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTFFStatusText);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setStatusTextArray(CTFFStatusText[] cTFFStatusTextArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTFFStatusTextArr, STATUSTEXT$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setTextInputArray(int i, CTFFTextInput cTFFTextInput) {
        synchronized (monitor()) {
            check_orphaned();
            CTFFTextInput find_element_user = get_store().find_element_user(TEXTINPUT$18, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTFFTextInput);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setTextInputArray(CTFFTextInput[] cTFFTextInputArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTFFTextInputArr, TEXTINPUT$18);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfCalcOnExitArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CALCONEXIT$4);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfCheckBoxArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CHECKBOX$14);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfDdListArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DDLIST$16);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfEnabledArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ENABLED$2);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfEntryMacroArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ENTRYMACRO$6);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfExitMacroArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(EXITMACRO$8);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfHelpTextArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(HELPTEXT$10);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfNameArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(NAME$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfStatusTextArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(STATUSTEXT$12);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfTextInputArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TEXTINPUT$18);
        }
        return count_elements;
    }
}
