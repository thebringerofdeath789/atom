package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingShapeProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual;

/* loaded from: classes6.dex */
public class CTShapeNonVisualImpl extends XmlComplexContentImpl implements CTShapeNonVisual {
    private static final QName CNVPR$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cNvPr");
    private static final QName CNVSPPR$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cNvSpPr");
    private static final QName NVPR$4 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvPr");

    public CTShapeNonVisualImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual
    public CTNonVisualDrawingProps addNewCNvPr() {
        CTNonVisualDrawingProps cTNonVisualDrawingProps;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualDrawingProps = (CTNonVisualDrawingProps) get_store().add_element_user(CNVPR$0);
        }
        return cTNonVisualDrawingProps;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual
    public CTNonVisualDrawingShapeProps addNewCNvSpPr() {
        CTNonVisualDrawingShapeProps cTNonVisualDrawingShapeProps;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualDrawingShapeProps = (CTNonVisualDrawingShapeProps) get_store().add_element_user(CNVSPPR$2);
        }
        return cTNonVisualDrawingShapeProps;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual
    public CTApplicationNonVisualDrawingProps addNewNvPr() {
        CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps;
        synchronized (monitor()) {
            check_orphaned();
            cTApplicationNonVisualDrawingProps = (CTApplicationNonVisualDrawingProps) get_store().add_element_user(NVPR$4);
        }
        return cTApplicationNonVisualDrawingProps;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual
    public CTNonVisualDrawingProps getCNvPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTNonVisualDrawingProps cTNonVisualDrawingProps = (CTNonVisualDrawingProps) get_store().find_element_user(CNVPR$0, 0);
            if (cTNonVisualDrawingProps == null) {
                return null;
            }
            return cTNonVisualDrawingProps;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual
    public CTNonVisualDrawingShapeProps getCNvSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTNonVisualDrawingShapeProps cTNonVisualDrawingShapeProps = (CTNonVisualDrawingShapeProps) get_store().find_element_user(CNVSPPR$2, 0);
            if (cTNonVisualDrawingShapeProps == null) {
                return null;
            }
            return cTNonVisualDrawingShapeProps;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual
    public CTApplicationNonVisualDrawingProps getNvPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps = (CTApplicationNonVisualDrawingProps) get_store().find_element_user(NVPR$4, 0);
            if (cTApplicationNonVisualDrawingProps == null) {
                return null;
            }
            return cTApplicationNonVisualDrawingProps;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual
    public void setCNvPr(CTNonVisualDrawingProps cTNonVisualDrawingProps) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CNVPR$0;
            CTNonVisualDrawingProps cTNonVisualDrawingProps2 = (CTNonVisualDrawingProps) typeStore.find_element_user(qName, 0);
            if (cTNonVisualDrawingProps2 == null) {
                cTNonVisualDrawingProps2 = (CTNonVisualDrawingProps) get_store().add_element_user(qName);
            }
            cTNonVisualDrawingProps2.set(cTNonVisualDrawingProps);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual
    public void setCNvSpPr(CTNonVisualDrawingShapeProps cTNonVisualDrawingShapeProps) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CNVSPPR$2;
            CTNonVisualDrawingShapeProps cTNonVisualDrawingShapeProps2 = (CTNonVisualDrawingShapeProps) typeStore.find_element_user(qName, 0);
            if (cTNonVisualDrawingShapeProps2 == null) {
                cTNonVisualDrawingShapeProps2 = (CTNonVisualDrawingShapeProps) get_store().add_element_user(qName);
            }
            cTNonVisualDrawingShapeProps2.set(cTNonVisualDrawingShapeProps);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual
    public void setNvPr(CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NVPR$4;
            CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps2 = (CTApplicationNonVisualDrawingProps) typeStore.find_element_user(qName, 0);
            if (cTApplicationNonVisualDrawingProps2 == null) {
                cTApplicationNonVisualDrawingProps2 = (CTApplicationNonVisualDrawingProps) get_store().add_element_user(qName);
            }
            cTApplicationNonVisualDrawingProps2.set(cTApplicationNonVisualDrawingProps);
        }
    }
}
