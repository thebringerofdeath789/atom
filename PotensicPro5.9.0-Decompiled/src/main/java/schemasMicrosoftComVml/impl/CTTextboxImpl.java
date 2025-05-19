package schemasMicrosoftComVml.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent;
import schemasMicrosoftComOfficeOffice.STInsetMode;
import schemasMicrosoftComOfficeOffice.STTrueFalse;
import schemasMicrosoftComOfficeOffice.STTrueFalse$Enum;
import schemasMicrosoftComVml.CTTextbox;

/* loaded from: classes6.dex */
public class CTTextboxImpl extends XmlComplexContentImpl implements CTTextbox {
    private static final QName TXBXCONTENT$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "txbxContent");
    private static final QName ID$2 = new QName("", TtmlNode.ATTR_ID);
    private static final QName STYLE$4 = new QName("", TtmlNode.TAG_STYLE);
    private static final QName INSET$6 = new QName("", "inset");
    private static final QName SINGLECLICK$8 = new QName("urn:schemas-microsoft-com:office:office", "singleclick");
    private static final QName INSETMODE$10 = new QName("urn:schemas-microsoft-com:office:office", "insetmode");

    public CTTextboxImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public CTTxbxContent addNewTxbxContent() {
        CTTxbxContent cTTxbxContent;
        synchronized (monitor()) {
            check_orphaned();
            cTTxbxContent = (CTTxbxContent) get_store().add_element_user(TXBXCONTENT$0);
        }
        return cTTxbxContent;
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public String getInset() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(INSET$6);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public STInsetMode.Enum getInsetmode() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return (STInsetMode.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public STTrueFalse$Enum getSingleclick() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SINGLECLICK$8);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public String getStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STYLE$4);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public CTTxbxContent getTxbxContent() {
        synchronized (monitor()) {
            check_orphaned();
            CTTxbxContent cTTxbxContent = (CTTxbxContent) get_store().find_element_user(TXBXCONTENT$0, 0);
            if (cTTxbxContent == null) {
                return null;
            }
            return cTTxbxContent;
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$2) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public boolean isSetInset() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INSET$6) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public boolean isSetInsetmode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INSETMODE$10) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public boolean isSetSingleclick() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SINGLECLICK$8) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public boolean isSetStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STYLE$4) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public boolean isSetTxbxContent() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TXBXCONTENT$0) != 0;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public void setInset(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSET$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public void setInsetmode(STInsetMode.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public void setSingleclick(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SINGLECLICK$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public void setStyle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public void setTxbxContent(CTTxbxContent cTTxbxContent) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TXBXCONTENT$0;
            CTTxbxContent cTTxbxContent2 = (CTTxbxContent) typeStore.find_element_user(qName, 0);
            if (cTTxbxContent2 == null) {
                cTTxbxContent2 = (CTTxbxContent) get_store().add_element_user(qName);
            }
            cTTxbxContent2.set(cTTxbxContent);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$2);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public void unsetInset() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INSET$6);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public void unsetInsetmode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INSETMODE$10);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public void unsetSingleclick() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SINGLECLICK$8);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public void unsetStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STYLE$4);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public void unsetTxbxContent() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TXBXCONTENT$0, 0);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public XmlString xgetId() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(ID$2);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public XmlString xgetInset() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(INSET$6);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public STInsetMode xgetInsetmode() {
        STInsetMode sTInsetMode;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$10;
            sTInsetMode = (STInsetMode) typeStore.find_attribute_user(qName);
            if (sTInsetMode == null) {
                sTInsetMode = (STInsetMode) get_default_attribute_value(qName);
            }
        }
        return sTInsetMode;
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public STTrueFalse xgetSingleclick() {
        STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(SINGLECLICK$8);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public XmlString xgetStyle() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(STYLE$4);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public void xsetId(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$2;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public void xsetInset(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSET$6;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public void xsetInsetmode(STInsetMode sTInsetMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$10;
            STInsetMode sTInsetMode2 = (STInsetMode) typeStore.find_attribute_user(qName);
            if (sTInsetMode2 == null) {
                sTInsetMode2 = (STInsetMode) get_store().add_attribute_user(qName);
            }
            sTInsetMode2.set(sTInsetMode);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public void xsetSingleclick(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SINGLECLICK$8;
            STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTTextbox
    public void xsetStyle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$4;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }
}
