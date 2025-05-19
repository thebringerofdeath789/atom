package schemasMicrosoftComOfficeOffice.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import schemasMicrosoftComOfficeOffice.CTIdMap;
import schemasMicrosoftComVml.STExt;

/* loaded from: classes6.dex */
public class CTIdMapImpl extends XmlComplexContentImpl implements CTIdMap {
    private static final QName EXT$0 = new QName("urn:schemas-microsoft-com:vml", "ext");
    private static final QName DATA$2 = new QName("", "data");

    public CTIdMapImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // schemasMicrosoftComOfficeOffice.CTIdMap
    public String getData() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DATA$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTIdMap
    public STExt.Enum getExt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(EXT$0);
            if (simpleValue == null) {
                return null;
            }
            return (STExt.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTIdMap
    public boolean isSetData() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DATA$2) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTIdMap
    public boolean isSetExt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EXT$0) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTIdMap
    public void setData(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DATA$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTIdMap
    public void setExt(STExt.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXT$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTIdMap
    public void unsetData() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DATA$2);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTIdMap
    public void unsetExt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EXT$0);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTIdMap
    public XmlString xgetData() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(DATA$2);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTIdMap
    public STExt xgetExt() {
        STExt sTExt;
        synchronized (monitor()) {
            check_orphaned();
            sTExt = (STExt) get_store().find_attribute_user(EXT$0);
        }
        return sTExt;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTIdMap
    public void xsetData(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DATA$2;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTIdMap
    public void xsetExt(STExt sTExt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXT$0;
            STExt sTExt2 = (STExt) typeStore.find_attribute_user(qName);
            if (sTExt2 == null) {
                sTExt2 = (STExt) get_store().add_attribute_user(qName);
            }
            sTExt2.set(sTExt);
        }
    }
}
