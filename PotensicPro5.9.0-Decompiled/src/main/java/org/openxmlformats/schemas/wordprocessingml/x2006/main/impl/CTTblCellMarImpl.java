package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;

/* loaded from: classes6.dex */
public class CTTblCellMarImpl extends XmlComplexContentImpl implements CTTblCellMar {
    private static final QName TOP$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "top");
    private static final QName LEFT$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "left");
    private static final QName BOTTOM$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bottom");
    private static final QName RIGHT$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "right");

    public CTTblCellMarImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public CTTblWidth addNewBottom() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(BOTTOM$4);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public CTTblWidth addNewLeft() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(LEFT$2);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public CTTblWidth addNewRight() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(RIGHT$6);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public CTTblWidth addNewTop() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(TOP$0);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public CTTblWidth getBottom() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblWidth cTTblWidth = (CTTblWidth) get_store().find_element_user(BOTTOM$4, 0);
            if (cTTblWidth == null) {
                return null;
            }
            return cTTblWidth;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public CTTblWidth getLeft() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblWidth cTTblWidth = (CTTblWidth) get_store().find_element_user(LEFT$2, 0);
            if (cTTblWidth == null) {
                return null;
            }
            return cTTblWidth;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public CTTblWidth getRight() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblWidth cTTblWidth = (CTTblWidth) get_store().find_element_user(RIGHT$6, 0);
            if (cTTblWidth == null) {
                return null;
            }
            return cTTblWidth;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public CTTblWidth getTop() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblWidth cTTblWidth = (CTTblWidth) get_store().find_element_user(TOP$0, 0);
            if (cTTblWidth == null) {
                return null;
            }
            return cTTblWidth;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public boolean isSetBottom() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BOTTOM$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public boolean isSetLeft() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LEFT$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public boolean isSetRight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RIGHT$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public boolean isSetTop() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TOP$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public void setBottom(CTTblWidth cTTblWidth) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOTTOM$4;
            CTTblWidth cTTblWidth2 = (CTTblWidth) typeStore.find_element_user(qName, 0);
            if (cTTblWidth2 == null) {
                cTTblWidth2 = (CTTblWidth) get_store().add_element_user(qName);
            }
            cTTblWidth2.set(cTTblWidth);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public void setLeft(CTTblWidth cTTblWidth) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEFT$2;
            CTTblWidth cTTblWidth2 = (CTTblWidth) typeStore.find_element_user(qName, 0);
            if (cTTblWidth2 == null) {
                cTTblWidth2 = (CTTblWidth) get_store().add_element_user(qName);
            }
            cTTblWidth2.set(cTTblWidth);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public void setRight(CTTblWidth cTTblWidth) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RIGHT$6;
            CTTblWidth cTTblWidth2 = (CTTblWidth) typeStore.find_element_user(qName, 0);
            if (cTTblWidth2 == null) {
                cTTblWidth2 = (CTTblWidth) get_store().add_element_user(qName);
            }
            cTTblWidth2.set(cTTblWidth);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public void setTop(CTTblWidth cTTblWidth) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOP$0;
            CTTblWidth cTTblWidth2 = (CTTblWidth) typeStore.find_element_user(qName, 0);
            if (cTTblWidth2 == null) {
                cTTblWidth2 = (CTTblWidth) get_store().add_element_user(qName);
            }
            cTTblWidth2.set(cTTblWidth);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public void unsetBottom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOTTOM$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public void unsetLeft() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LEFT$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public void unsetRight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RIGHT$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public void unsetTop() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TOP$0, 0);
        }
    }
}
