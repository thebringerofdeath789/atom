package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAbsoluteAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTOneCellAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor;

/* loaded from: classes5.dex */
public class CTDrawingImpl extends XmlComplexContentImpl implements CTDrawing {
    private static final QName TWOCELLANCHOR$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "twoCellAnchor");
    private static final QName ONECELLANCHOR$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "oneCellAnchor");
    private static final QName ABSOLUTEANCHOR$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "absoluteAnchor");

    public CTDrawingImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTAbsoluteAnchor addNewAbsoluteAnchor() {
        CTAbsoluteAnchor add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(ABSOLUTEANCHOR$4);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTOneCellAnchor addNewOneCellAnchor() {
        CTOneCellAnchor cTOneCellAnchor;
        synchronized (monitor()) {
            check_orphaned();
            cTOneCellAnchor = (CTOneCellAnchor) get_store().add_element_user(ONECELLANCHOR$2);
        }
        return cTOneCellAnchor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTTwoCellAnchor addNewTwoCellAnchor() {
        CTTwoCellAnchor cTTwoCellAnchor;
        synchronized (monitor()) {
            check_orphaned();
            cTTwoCellAnchor = (CTTwoCellAnchor) get_store().add_element_user(TWOCELLANCHOR$0);
        }
        return cTTwoCellAnchor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTAbsoluteAnchor getAbsoluteAnchorArray(int i) {
        CTAbsoluteAnchor find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(ABSOLUTEANCHOR$4, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTAbsoluteAnchor[] getAbsoluteAnchorArray() {
        CTAbsoluteAnchor[] cTAbsoluteAnchorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ABSOLUTEANCHOR$4, arrayList);
            cTAbsoluteAnchorArr = new CTAbsoluteAnchor[arrayList.size()];
            arrayList.toArray(cTAbsoluteAnchorArr);
        }
        return cTAbsoluteAnchorArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public List<CTAbsoluteAnchor> getAbsoluteAnchorList() {
        1AbsoluteAnchorList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AbsoluteAnchorList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTOneCellAnchor getOneCellAnchorArray(int i) {
        CTOneCellAnchor cTOneCellAnchor;
        synchronized (monitor()) {
            check_orphaned();
            cTOneCellAnchor = (CTOneCellAnchor) get_store().find_element_user(ONECELLANCHOR$2, i);
            if (cTOneCellAnchor == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOneCellAnchor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTOneCellAnchor[] getOneCellAnchorArray() {
        CTOneCellAnchor[] cTOneCellAnchorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ONECELLANCHOR$2, arrayList);
            cTOneCellAnchorArr = new CTOneCellAnchor[arrayList.size()];
            arrayList.toArray(cTOneCellAnchorArr);
        }
        return cTOneCellAnchorArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public List<CTOneCellAnchor> getOneCellAnchorList() {
        1OneCellAnchorList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OneCellAnchorList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTTwoCellAnchor getTwoCellAnchorArray(int i) {
        CTTwoCellAnchor cTTwoCellAnchor;
        synchronized (monitor()) {
            check_orphaned();
            cTTwoCellAnchor = (CTTwoCellAnchor) get_store().find_element_user(TWOCELLANCHOR$0, i);
            if (cTTwoCellAnchor == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTwoCellAnchor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTTwoCellAnchor[] getTwoCellAnchorArray() {
        CTTwoCellAnchor[] cTTwoCellAnchorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TWOCELLANCHOR$0, arrayList);
            cTTwoCellAnchorArr = new CTTwoCellAnchor[arrayList.size()];
            arrayList.toArray(cTTwoCellAnchorArr);
        }
        return cTTwoCellAnchorArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public List<CTTwoCellAnchor> getTwoCellAnchorList() {
        1TwoCellAnchorList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TwoCellAnchorList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTAbsoluteAnchor insertNewAbsoluteAnchor(int i) {
        CTAbsoluteAnchor insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(ABSOLUTEANCHOR$4, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTOneCellAnchor insertNewOneCellAnchor(int i) {
        CTOneCellAnchor cTOneCellAnchor;
        synchronized (monitor()) {
            check_orphaned();
            cTOneCellAnchor = (CTOneCellAnchor) get_store().insert_element_user(ONECELLANCHOR$2, i);
        }
        return cTOneCellAnchor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTTwoCellAnchor insertNewTwoCellAnchor(int i) {
        CTTwoCellAnchor cTTwoCellAnchor;
        synchronized (monitor()) {
            check_orphaned();
            cTTwoCellAnchor = (CTTwoCellAnchor) get_store().insert_element_user(TWOCELLANCHOR$0, i);
        }
        return cTTwoCellAnchor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public void removeAbsoluteAnchor(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ABSOLUTEANCHOR$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public void removeOneCellAnchor(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ONECELLANCHOR$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public void removeTwoCellAnchor(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TWOCELLANCHOR$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public void setAbsoluteAnchorArray(int i, CTAbsoluteAnchor cTAbsoluteAnchor) {
        synchronized (monitor()) {
            check_orphaned();
            CTAbsoluteAnchor find_element_user = get_store().find_element_user(ABSOLUTEANCHOR$4, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTAbsoluteAnchor);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public void setAbsoluteAnchorArray(CTAbsoluteAnchor[] cTAbsoluteAnchorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTAbsoluteAnchorArr, ABSOLUTEANCHOR$4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public void setOneCellAnchorArray(int i, CTOneCellAnchor cTOneCellAnchor) {
        synchronized (monitor()) {
            check_orphaned();
            CTOneCellAnchor cTOneCellAnchor2 = (CTOneCellAnchor) get_store().find_element_user(ONECELLANCHOR$2, i);
            if (cTOneCellAnchor2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOneCellAnchor2.set(cTOneCellAnchor);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public void setOneCellAnchorArray(CTOneCellAnchor[] cTOneCellAnchorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOneCellAnchorArr, ONECELLANCHOR$2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public void setTwoCellAnchorArray(int i, CTTwoCellAnchor cTTwoCellAnchor) {
        synchronized (monitor()) {
            check_orphaned();
            CTTwoCellAnchor cTTwoCellAnchor2 = (CTTwoCellAnchor) get_store().find_element_user(TWOCELLANCHOR$0, i);
            if (cTTwoCellAnchor2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTwoCellAnchor2.set(cTTwoCellAnchor);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public void setTwoCellAnchorArray(CTTwoCellAnchor[] cTTwoCellAnchorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTwoCellAnchorArr, TWOCELLANCHOR$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public int sizeOfAbsoluteAnchorArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ABSOLUTEANCHOR$4);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public int sizeOfOneCellAnchorArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ONECELLANCHOR$2);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public int sizeOfTwoCellAnchorArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TWOCELLANCHOR$0);
        }
        return count_elements;
    }
}
