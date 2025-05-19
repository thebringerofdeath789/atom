package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextField;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STGuid;

/* loaded from: classes5.dex */
public class CTTextFieldImpl extends XmlComplexContentImpl implements CTTextField {
    private static final QName RPR$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "rPr");
    private static final QName PPR$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "pPr");
    private static final QName T$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "t");
    private static final QName ID$6 = new QName("", TtmlNode.ATTR_ID);
    private static final QName TYPE$8 = new QName("", "type");

    public CTTextFieldImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public CTTextParagraphProperties addNewPPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(PPR$2);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public CTTextCharacterProperties addNewRPr() {
        CTTextCharacterProperties cTTextCharacterProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextCharacterProperties = (CTTextCharacterProperties) get_store().add_element_user(RPR$0);
        }
        return cTTextCharacterProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$6);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public CTTextParagraphProperties getPPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextParagraphProperties cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(PPR$2, 0);
            if (cTTextParagraphProperties == null) {
                return null;
            }
            return cTTextParagraphProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public String getT() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(T$4, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public String getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TYPE$8);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public boolean isSetPPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PPR$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public boolean isSetRPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RPR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public boolean isSetT() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(T$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public void setPPr(CTTextParagraphProperties cTTextParagraphProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PPR$2;
            CTTextParagraphProperties cTTextParagraphProperties2 = (CTTextParagraphProperties) typeStore.find_element_user(qName, 0);
            if (cTTextParagraphProperties2 == null) {
                cTTextParagraphProperties2 = (CTTextParagraphProperties) get_store().add_element_user(qName);
            }
            cTTextParagraphProperties2.set(cTTextParagraphProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public void setT(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = T$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public void setType(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public void unsetPPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PPR$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public void unsetRPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RPR$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public void unsetT() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(T$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$8);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public STGuid xgetId() {
        STGuid find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(ID$6);
        }
        return find_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public XmlString xgetT() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(T$4, 0);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public XmlString xgetType() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(TYPE$8);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public void xsetId(STGuid sTGuid) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$6;
            STGuid find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STGuid) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTGuid);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public void xsetT(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = T$4;
            XmlString xmlString2 = (XmlString) typeStore.find_element_user(qName, 0);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_element_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextField
    public void xsetType(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$8;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }
}
