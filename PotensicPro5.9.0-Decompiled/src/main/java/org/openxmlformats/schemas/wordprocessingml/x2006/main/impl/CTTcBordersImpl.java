package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders;

/* loaded from: classes6.dex */
public class CTTcBordersImpl extends XmlComplexContentImpl implements CTTcBorders {
    private static final QName TOP$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "top");
    private static final QName LEFT$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "left");
    private static final QName BOTTOM$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bottom");
    private static final QName RIGHT$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "right");
    private static final QName INSIDEH$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "insideH");
    private static final QName INSIDEV$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "insideV");
    private static final QName TL2BR$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tl2br");
    private static final QName TR2BL$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tr2bl");

    public CTTcBordersImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public CTBorder addNewBottom() {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().add_element_user(BOTTOM$4);
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public CTBorder addNewInsideH() {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().add_element_user(INSIDEH$8);
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public CTBorder addNewInsideV() {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().add_element_user(INSIDEV$10);
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public CTBorder addNewLeft() {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().add_element_user(LEFT$2);
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public CTBorder addNewRight() {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().add_element_user(RIGHT$6);
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public CTBorder addNewTl2Br() {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().add_element_user(TL2BR$12);
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public CTBorder addNewTop() {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().add_element_user(TOP$0);
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public CTBorder addNewTr2Bl() {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().add_element_user(TR2BL$14);
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public CTBorder getInsideH() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorder = (CTBorder) get_store().find_element_user(INSIDEH$8, 0);
            if (cTBorder == null) {
                return null;
            }
            return cTBorder;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public CTBorder getInsideV() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorder = (CTBorder) get_store().find_element_user(INSIDEV$10, 0);
            if (cTBorder == null) {
                return null;
            }
            return cTBorder;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public CTBorder getTl2Br() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorder = (CTBorder) get_store().find_element_user(TL2BR$12, 0);
            if (cTBorder == null) {
                return null;
            }
            return cTBorder;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public CTBorder getTr2Bl() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorder = (CTBorder) get_store().find_element_user(TR2BL$14, 0);
            if (cTBorder == null) {
                return null;
            }
            return cTBorder;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public boolean isSetBottom() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BOTTOM$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public boolean isSetInsideH() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(INSIDEH$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public boolean isSetInsideV() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(INSIDEV$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public boolean isSetLeft() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LEFT$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public boolean isSetRight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RIGHT$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public boolean isSetTl2Br() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TL2BR$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public boolean isSetTop() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TOP$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public boolean isSetTr2Bl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TR2BL$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public void setInsideH(CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSIDEH$8;
            CTBorder cTBorder2 = (CTBorder) typeStore.find_element_user(qName, 0);
            if (cTBorder2 == null) {
                cTBorder2 = (CTBorder) get_store().add_element_user(qName);
            }
            cTBorder2.set(cTBorder);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public void setInsideV(CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSIDEV$10;
            CTBorder cTBorder2 = (CTBorder) typeStore.find_element_user(qName, 0);
            if (cTBorder2 == null) {
                cTBorder2 = (CTBorder) get_store().add_element_user(qName);
            }
            cTBorder2.set(cTBorder);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public void setTl2Br(CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TL2BR$12;
            CTBorder cTBorder2 = (CTBorder) typeStore.find_element_user(qName, 0);
            if (cTBorder2 == null) {
                cTBorder2 = (CTBorder) get_store().add_element_user(qName);
            }
            cTBorder2.set(cTBorder);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public void setTr2Bl(CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TR2BL$14;
            CTBorder cTBorder2 = (CTBorder) typeStore.find_element_user(qName, 0);
            if (cTBorder2 == null) {
                cTBorder2 = (CTBorder) get_store().add_element_user(qName);
            }
            cTBorder2.set(cTBorder);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public void unsetBottom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOTTOM$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public void unsetInsideH() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INSIDEH$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public void unsetInsideV() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INSIDEV$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public void unsetLeft() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LEFT$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public void unsetRight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RIGHT$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public void unsetTl2Br() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TL2BR$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public void unsetTop() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TOP$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders
    public void unsetTr2Bl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TR2BL$14, 0);
        }
    }
}
