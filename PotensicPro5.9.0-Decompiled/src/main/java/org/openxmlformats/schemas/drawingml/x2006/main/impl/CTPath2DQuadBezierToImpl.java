package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DQuadBezierTo;

/* loaded from: classes5.dex */
public class CTPath2DQuadBezierToImpl extends XmlComplexContentImpl implements CTPath2DQuadBezierTo {
    private static final QName PT$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "pt");

    public CTPath2DQuadBezierToImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DQuadBezierTo
    public CTAdjPoint2D addNewPt() {
        CTAdjPoint2D cTAdjPoint2D;
        synchronized (monitor()) {
            check_orphaned();
            cTAdjPoint2D = (CTAdjPoint2D) get_store().add_element_user(PT$0);
        }
        return cTAdjPoint2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DQuadBezierTo
    public CTAdjPoint2D getPtArray(int i) {
        CTAdjPoint2D cTAdjPoint2D;
        synchronized (monitor()) {
            check_orphaned();
            cTAdjPoint2D = (CTAdjPoint2D) get_store().find_element_user(PT$0, i);
            if (cTAdjPoint2D == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAdjPoint2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DQuadBezierTo
    public CTAdjPoint2D[] getPtArray() {
        CTAdjPoint2D[] cTAdjPoint2DArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PT$0, arrayList);
            cTAdjPoint2DArr = new CTAdjPoint2D[arrayList.size()];
            arrayList.toArray(cTAdjPoint2DArr);
        }
        return cTAdjPoint2DArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DQuadBezierTo
    public List<CTAdjPoint2D> getPtList() {
        1PtList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PtList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DQuadBezierTo
    public CTAdjPoint2D insertNewPt(int i) {
        CTAdjPoint2D cTAdjPoint2D;
        synchronized (monitor()) {
            check_orphaned();
            cTAdjPoint2D = (CTAdjPoint2D) get_store().insert_element_user(PT$0, i);
        }
        return cTAdjPoint2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DQuadBezierTo
    public void removePt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PT$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DQuadBezierTo
    public void setPtArray(int i, CTAdjPoint2D cTAdjPoint2D) {
        synchronized (monitor()) {
            check_orphaned();
            CTAdjPoint2D cTAdjPoint2D2 = (CTAdjPoint2D) get_store().find_element_user(PT$0, i);
            if (cTAdjPoint2D2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTAdjPoint2D2.set(cTAdjPoint2D);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DQuadBezierTo
    public void setPtArray(CTAdjPoint2D[] cTAdjPoint2DArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTAdjPoint2DArr, PT$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DQuadBezierTo
    public int sizeOfPtArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PT$0);
        }
        return count_elements;
    }
}
