package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;
import org.openxmlformats.schemas.drawingml.x2006.main.STGeomGuideFormula;
import org.openxmlformats.schemas.drawingml.x2006.main.STGeomGuideName;

/* loaded from: classes5.dex */
public class CTGeomGuideImpl extends XmlComplexContentImpl implements CTGeomGuide {
    private static final QName NAME$0 = new QName("", "name");
    private static final QName FMLA$2 = new QName("", "fmla");

    public CTGeomGuideImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide
    public String getFmla() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FMLA$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(NAME$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide
    public void setFmla(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FMLA$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide
    public STGeomGuideFormula xgetFmla() {
        STGeomGuideFormula sTGeomGuideFormula;
        synchronized (monitor()) {
            check_orphaned();
            sTGeomGuideFormula = (STGeomGuideFormula) get_store().find_attribute_user(FMLA$2);
        }
        return sTGeomGuideFormula;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide
    public STGeomGuideName xgetName() {
        STGeomGuideName sTGeomGuideName;
        synchronized (monitor()) {
            check_orphaned();
            sTGeomGuideName = (STGeomGuideName) get_store().find_attribute_user(NAME$0);
        }
        return sTGeomGuideName;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide
    public void xsetFmla(STGeomGuideFormula sTGeomGuideFormula) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FMLA$2;
            STGeomGuideFormula sTGeomGuideFormula2 = (STGeomGuideFormula) typeStore.find_attribute_user(qName);
            if (sTGeomGuideFormula2 == null) {
                sTGeomGuideFormula2 = (STGeomGuideFormula) get_store().add_attribute_user(qName);
            }
            sTGeomGuideFormula2.set(sTGeomGuideFormula);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide
    public void xsetName(STGeomGuideName sTGeomGuideName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$0;
            STGeomGuideName sTGeomGuideName2 = (STGeomGuideName) typeStore.find_attribute_user(qName);
            if (sTGeomGuideName2 == null) {
                sTGeomGuideName2 = (STGeomGuideName) get_store().add_attribute_user(qName);
            }
            sTGeomGuideName2.set(sTGeomGuideName);
        }
    }
}
