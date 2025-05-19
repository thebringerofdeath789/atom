package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DLineTo;

/* loaded from: classes5.dex */
public class CTPath2DLineToImpl extends XmlComplexContentImpl implements CTPath2DLineTo {
    private static final QName PT$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "pt");

    public CTPath2DLineToImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DLineTo
    public CTAdjPoint2D addNewPt() {
        CTAdjPoint2D cTAdjPoint2D;
        synchronized (monitor()) {
            check_orphaned();
            cTAdjPoint2D = (CTAdjPoint2D) get_store().add_element_user(PT$0);
        }
        return cTAdjPoint2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DLineTo
    public CTAdjPoint2D getPt() {
        synchronized (monitor()) {
            check_orphaned();
            CTAdjPoint2D cTAdjPoint2D = (CTAdjPoint2D) get_store().find_element_user(PT$0, 0);
            if (cTAdjPoint2D == null) {
                return null;
            }
            return cTAdjPoint2D;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DLineTo
    public void setPt(CTAdjPoint2D cTAdjPoint2D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PT$0;
            CTAdjPoint2D cTAdjPoint2D2 = (CTAdjPoint2D) typeStore.find_element_user(qName, 0);
            if (cTAdjPoint2D2 == null) {
                cTAdjPoint2D2 = (CTAdjPoint2D) get_store().add_element_user(qName);
            }
            cTAdjPoint2D2.set(cTAdjPoint2D);
        }
    }
}
