package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;

/* loaded from: classes6.dex */
public class CTPBdrImpl extends XmlComplexContentImpl implements CTPBdr {
    private static final QName TOP$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "top");
    private static final QName LEFT$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "left");
    private static final QName BOTTOM$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bottom");
    private static final QName RIGHT$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "right");
    private static final QName BETWEEN$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "between");
    private static final QName BAR$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bar");

    public CTPBdrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public CTBorder addNewBar() {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().add_element_user(BAR$10);
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public CTBorder addNewBetween() {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().add_element_user(BETWEEN$8);
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public CTBorder addNewBottom() {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().add_element_user(BOTTOM$4);
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public CTBorder addNewLeft() {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().add_element_user(LEFT$2);
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public CTBorder addNewRight() {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().add_element_user(RIGHT$6);
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public CTBorder addNewTop() {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().add_element_user(TOP$0);
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public CTBorder getBar() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorder = (CTBorder) get_store().find_element_user(BAR$10, 0);
            if (cTBorder == null) {
                return null;
            }
            return cTBorder;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public CTBorder getBetween() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorder = (CTBorder) get_store().find_element_user(BETWEEN$8, 0);
            if (cTBorder == null) {
                return null;
            }
            return cTBorder;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public CTBorder getBottom() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorder = (CTBorder) get_store().find_element_user(BOTTOM$4, 0);
            if (cTBorder == null) {
                return null;
            }
            return cTBorder;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public CTBorder getLeft() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorder = (CTBorder) get_store().find_element_user(LEFT$2, 0);
            if (cTBorder == null) {
                return null;
            }
            return cTBorder;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public CTBorder getRight() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorder = (CTBorder) get_store().find_element_user(RIGHT$6, 0);
            if (cTBorder == null) {
                return null;
            }
            return cTBorder;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public CTBorder getTop() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorder = (CTBorder) get_store().find_element_user(TOP$0, 0);
            if (cTBorder == null) {
                return null;
            }
            return cTBorder;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public boolean isSetBar() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BAR$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public boolean isSetBetween() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BETWEEN$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public boolean isSetBottom() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BOTTOM$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public boolean isSetLeft() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LEFT$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public boolean isSetRight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RIGHT$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public boolean isSetTop() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TOP$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public void setBar(CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BAR$10;
            CTBorder cTBorder2 = (CTBorder) typeStore.find_element_user(qName, 0);
            if (cTBorder2 == null) {
                cTBorder2 = (CTBorder) get_store().add_element_user(qName);
            }
            cTBorder2.set(cTBorder);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public void setBetween(CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BETWEEN$8;
            CTBorder cTBorder2 = (CTBorder) typeStore.find_element_user(qName, 0);
            if (cTBorder2 == null) {
                cTBorder2 = (CTBorder) get_store().add_element_user(qName);
            }
            cTBorder2.set(cTBorder);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public void setBottom(CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOTTOM$4;
            CTBorder cTBorder2 = (CTBorder) typeStore.find_element_user(qName, 0);
            if (cTBorder2 == null) {
                cTBorder2 = (CTBorder) get_store().add_element_user(qName);
            }
            cTBorder2.set(cTBorder);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public void setLeft(CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEFT$2;
            CTBorder cTBorder2 = (CTBorder) typeStore.find_element_user(qName, 0);
            if (cTBorder2 == null) {
                cTBorder2 = (CTBorder) get_store().add_element_user(qName);
            }
            cTBorder2.set(cTBorder);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public void setRight(CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RIGHT$6;
            CTBorder cTBorder2 = (CTBorder) typeStore.find_element_user(qName, 0);
            if (cTBorder2 == null) {
                cTBorder2 = (CTBorder) get_store().add_element_user(qName);
            }
            cTBorder2.set(cTBorder);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public void setTop(CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOP$0;
            CTBorder cTBorder2 = (CTBorder) typeStore.find_element_user(qName, 0);
            if (cTBorder2 == null) {
                cTBorder2 = (CTBorder) get_store().add_element_user(qName);
            }
            cTBorder2.set(cTBorder);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public void unsetBar() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BAR$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public void unsetBetween() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BETWEEN$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public void unsetBottom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOTTOM$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public void unsetLeft() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LEFT$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public void unsetRight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RIGHT$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr
    public void unsetTop() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TOP$0, 0);
        }
    }
}
