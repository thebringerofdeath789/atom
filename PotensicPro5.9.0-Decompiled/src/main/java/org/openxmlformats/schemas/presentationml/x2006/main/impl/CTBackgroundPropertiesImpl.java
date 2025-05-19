package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList;

/* loaded from: classes6.dex */
public class CTBackgroundPropertiesImpl extends XmlComplexContentImpl implements CTBackgroundProperties {
    private static final QName NOFILL$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "noFill");
    private static final QName SOLIDFILL$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "solidFill");
    private static final QName GRADFILL$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gradFill");
    private static final QName BLIPFILL$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blipFill");
    private static final QName PATTFILL$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "pattFill");
    private static final QName GRPFILL$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "grpFill");
    private static final QName EFFECTLST$12 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "effectLst");
    private static final QName EFFECTDAG$14 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "effectDag");
    private static final QName EXTLST$16 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
    private static final QName SHADETOTITLE$18 = new QName("", "shadeToTitle");

    public CTBackgroundPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public CTBlipFillProperties addNewBlipFill() {
        CTBlipFillProperties cTBlipFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTBlipFillProperties = (CTBlipFillProperties) get_store().add_element_user(BLIPFILL$6);
        }
        return cTBlipFillProperties;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public CTEffectContainer addNewEffectDag() {
        CTEffectContainer add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EFFECTDAG$14);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public CTEffectList addNewEffectLst() {
        CTEffectList cTEffectList;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectList = (CTEffectList) get_store().add_element_user(EFFECTLST$12);
        }
        return cTEffectList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public CTExtensionList addNewExtLst() {
        CTExtensionList add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EXTLST$16);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public CTGradientFillProperties addNewGradFill() {
        CTGradientFillProperties cTGradientFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientFillProperties = (CTGradientFillProperties) get_store().add_element_user(GRADFILL$4);
        }
        return cTGradientFillProperties;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public CTGroupFillProperties addNewGrpFill() {
        CTGroupFillProperties add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(GRPFILL$10);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public CTNoFillProperties addNewNoFill() {
        CTNoFillProperties cTNoFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTNoFillProperties = (CTNoFillProperties) get_store().add_element_user(NOFILL$0);
        }
        return cTNoFillProperties;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public CTPatternFillProperties addNewPattFill() {
        CTPatternFillProperties add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(PATTFILL$8);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public CTSolidColorFillProperties addNewSolidFill() {
        CTSolidColorFillProperties cTSolidColorFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTSolidColorFillProperties = (CTSolidColorFillProperties) get_store().add_element_user(SOLIDFILL$2);
        }
        return cTSolidColorFillProperties;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public CTBlipFillProperties getBlipFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTBlipFillProperties cTBlipFillProperties = (CTBlipFillProperties) get_store().find_element_user(BLIPFILL$6, 0);
            if (cTBlipFillProperties == null) {
                return null;
            }
            return cTBlipFillProperties;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public CTEffectContainer getEffectDag() {
        synchronized (monitor()) {
            check_orphaned();
            CTEffectContainer find_element_user = get_store().find_element_user(EFFECTDAG$14, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public CTEffectList getEffectLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTEffectList cTEffectList = (CTEffectList) get_store().find_element_user(EFFECTLST$12, 0);
            if (cTEffectList == null) {
                return null;
            }
            return cTEffectList;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList find_element_user = get_store().find_element_user(EXTLST$16, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public CTGradientFillProperties getGradFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTGradientFillProperties cTGradientFillProperties = (CTGradientFillProperties) get_store().find_element_user(GRADFILL$4, 0);
            if (cTGradientFillProperties == null) {
                return null;
            }
            return cTGradientFillProperties;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public CTGroupFillProperties getGrpFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTGroupFillProperties find_element_user = get_store().find_element_user(GRPFILL$10, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public CTNoFillProperties getNoFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTNoFillProperties cTNoFillProperties = (CTNoFillProperties) get_store().find_element_user(NOFILL$0, 0);
            if (cTNoFillProperties == null) {
                return null;
            }
            return cTNoFillProperties;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public CTPatternFillProperties getPattFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTPatternFillProperties find_element_user = get_store().find_element_user(PATTFILL$8, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public boolean getShadeToTitle() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHADETOTITLE$18;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public CTSolidColorFillProperties getSolidFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTSolidColorFillProperties cTSolidColorFillProperties = (CTSolidColorFillProperties) get_store().find_element_user(SOLIDFILL$2, 0);
            if (cTSolidColorFillProperties == null) {
                return null;
            }
            return cTSolidColorFillProperties;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public boolean isSetBlipFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BLIPFILL$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public boolean isSetEffectDag() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EFFECTDAG$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public boolean isSetEffectLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EFFECTLST$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public boolean isSetGradFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GRADFILL$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public boolean isSetGrpFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GRPFILL$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public boolean isSetNoFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOFILL$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public boolean isSetPattFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PATTFILL$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public boolean isSetShadeToTitle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHADETOTITLE$18) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public boolean isSetSolidFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SOLIDFILL$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLIPFILL$6;
            CTBlipFillProperties cTBlipFillProperties2 = (CTBlipFillProperties) typeStore.find_element_user(qName, 0);
            if (cTBlipFillProperties2 == null) {
                cTBlipFillProperties2 = (CTBlipFillProperties) get_store().add_element_user(qName);
            }
            cTBlipFillProperties2.set(cTBlipFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public void setEffectDag(CTEffectContainer cTEffectContainer) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EFFECTDAG$14;
            CTEffectContainer find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTEffectContainer) get_store().add_element_user(qName);
            }
            find_element_user.set(cTEffectContainer);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public void setEffectLst(CTEffectList cTEffectList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EFFECTLST$12;
            CTEffectList cTEffectList2 = (CTEffectList) typeStore.find_element_user(qName, 0);
            if (cTEffectList2 == null) {
                cTEffectList2 = (CTEffectList) get_store().add_element_user(qName);
            }
            cTEffectList2.set(cTEffectList);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$16;
            CTExtensionList find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            find_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GRADFILL$4;
            CTGradientFillProperties cTGradientFillProperties2 = (CTGradientFillProperties) typeStore.find_element_user(qName, 0);
            if (cTGradientFillProperties2 == null) {
                cTGradientFillProperties2 = (CTGradientFillProperties) get_store().add_element_user(qName);
            }
            cTGradientFillProperties2.set(cTGradientFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public void setGrpFill(CTGroupFillProperties cTGroupFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GRPFILL$10;
            CTGroupFillProperties find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTGroupFillProperties) get_store().add_element_user(qName);
            }
            find_element_user.set(cTGroupFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public void setNoFill(CTNoFillProperties cTNoFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOFILL$0;
            CTNoFillProperties cTNoFillProperties2 = (CTNoFillProperties) typeStore.find_element_user(qName, 0);
            if (cTNoFillProperties2 == null) {
                cTNoFillProperties2 = (CTNoFillProperties) get_store().add_element_user(qName);
            }
            cTNoFillProperties2.set(cTNoFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATTFILL$8;
            CTPatternFillProperties find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTPatternFillProperties) get_store().add_element_user(qName);
            }
            find_element_user.set(cTPatternFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public void setShadeToTitle(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHADETOTITLE$18;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SOLIDFILL$2;
            CTSolidColorFillProperties cTSolidColorFillProperties2 = (CTSolidColorFillProperties) typeStore.find_element_user(qName, 0);
            if (cTSolidColorFillProperties2 == null) {
                cTSolidColorFillProperties2 = (CTSolidColorFillProperties) get_store().add_element_user(qName);
            }
            cTSolidColorFillProperties2.set(cTSolidColorFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public void unsetBlipFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BLIPFILL$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public void unsetEffectDag() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EFFECTDAG$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public void unsetEffectLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EFFECTLST$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public void unsetGradFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRADFILL$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public void unsetGrpFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRPFILL$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public void unsetNoFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOFILL$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public void unsetPattFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PATTFILL$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public void unsetShadeToTitle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHADETOTITLE$18);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public void unsetSolidFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SOLIDFILL$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public XmlBoolean xgetShadeToTitle() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHADETOTITLE$18;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties
    public void xsetShadeToTitle(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHADETOTITLE$18;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }
}
