package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;

/* loaded from: classes5.dex */
public class CTRegularTextRunImpl extends XmlComplexContentImpl implements CTRegularTextRun {
    private static final QName RPR$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "rPr");
    private static final QName T$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "t");

    public CTRegularTextRunImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun
    public CTTextCharacterProperties addNewRPr() {
        CTTextCharacterProperties cTTextCharacterProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextCharacterProperties = (CTTextCharacterProperties) get_store().add_element_user(RPR$0);
        }
        return cTTextCharacterProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun
    public CTTextCharacterProperties getRPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextCharacterProperties cTTextCharacterProperties = (CTTextCharacterProperties) get_store().find_element_user(RPR$0, 0);
            if (cTTextCharacterProperties == null) {
                return null;
            }
            return cTTextCharacterProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun
    public String getT() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(T$2, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun
    public boolean isSetRPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RPR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun
    public void setRPr(CTTextCharacterProperties cTTextCharacterProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RPR$0;
            CTTextCharacterProperties cTTextCharacterProperties2 = (CTTextCharacterProperties) typeStore.find_element_user(qName, 0);
            if (cTTextCharacterProperties2 == null) {
                cTTextCharacterProperties2 = (CTTextCharacterProperties) get_store().add_element_user(qName);
            }
            cTTextCharacterProperties2.set(cTTextCharacterProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun
    public void setT(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = T$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun
    public void unsetRPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RPR$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun
    public XmlString xgetT() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(T$2, 0);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun
    public void xsetT(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = T$2;
            XmlString xmlString2 = (XmlString) typeStore.find_element_user(qName, 0);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_element_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }
}
