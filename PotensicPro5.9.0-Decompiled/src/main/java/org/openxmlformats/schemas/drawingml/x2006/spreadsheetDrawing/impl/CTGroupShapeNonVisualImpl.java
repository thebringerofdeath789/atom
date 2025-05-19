package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShapeNonVisual;

/* loaded from: classes5.dex */
public class CTGroupShapeNonVisualImpl extends XmlComplexContentImpl implements CTGroupShapeNonVisual {
    private static final QName CNVPR$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "cNvPr");
    private static final QName CNVGRPSPPR$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "cNvGrpSpPr");

    public CTGroupShapeNonVisualImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShapeNonVisual
    public CTNonVisualGroupDrawingShapeProps addNewCNvGrpSpPr() {
        CTNonVisualGroupDrawingShapeProps cTNonVisualGroupDrawingShapeProps;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualGroupDrawingShapeProps = (CTNonVisualGroupDrawingShapeProps) get_store().add_element_user(CNVGRPSPPR$2);
        }
        return cTNonVisualGroupDrawingShapeProps;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShapeNonVisual
    public CTNonVisualDrawingProps addNewCNvPr() {
        CTNonVisualDrawingProps cTNonVisualDrawingProps;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualDrawingProps = (CTNonVisualDrawingProps) get_store().add_element_user(CNVPR$0);
        }
        return cTNonVisualDrawingProps;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShapeNonVisual
    public CTNonVisualGroupDrawingShapeProps getCNvGrpSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTNonVisualGroupDrawingShapeProps cTNonVisualGroupDrawingShapeProps = (CTNonVisualGroupDrawingShapeProps) get_store().find_element_user(CNVGRPSPPR$2, 0);
            if (cTNonVisualGroupDrawingShapeProps == null) {
                return null;
            }
            return cTNonVisualGroupDrawingShapeProps;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShapeNonVisual
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShapeNonVisual
    public void setCNvGrpSpPr(CTNonVisualGroupDrawingShapeProps cTNonVisualGroupDrawingShapeProps) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CNVGRPSPPR$2;
            CTNonVisualGroupDrawingShapeProps cTNonVisualGroupDrawingShapeProps2 = (CTNonVisualGroupDrawingShapeProps) typeStore.find_element_user(qName, 0);
            if (cTNonVisualGroupDrawingShapeProps2 == null) {
                cTNonVisualGroupDrawingShapeProps2 = (CTNonVisualGroupDrawingShapeProps) get_store().add_element_user(qName);
            }
            cTNonVisualGroupDrawingShapeProps2.set(cTNonVisualGroupDrawingShapeProps);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShapeNonVisual
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
}
