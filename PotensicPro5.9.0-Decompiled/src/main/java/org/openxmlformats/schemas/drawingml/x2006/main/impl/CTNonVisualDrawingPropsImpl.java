package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.apache.poi.ss.util.CellUtil;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.STDrawingElementId;

/* loaded from: classes5.dex */
public class CTNonVisualDrawingPropsImpl extends XmlComplexContentImpl implements CTNonVisualDrawingProps {
    private static final QName HLINKCLICK$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hlinkClick");
    private static final QName HLINKHOVER$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hlinkHover");
    private static final QName EXTLST$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
    private static final QName ID$6 = new QName("", TtmlNode.ATTR_ID);
    private static final QName NAME$8 = new QName("", "name");
    private static final QName DESCR$10 = new QName("", "descr");
    private static final QName HIDDEN$12 = new QName("", CellUtil.HIDDEN);

    public CTNonVisualDrawingPropsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$4);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public CTHyperlink addNewHlinkClick() {
        CTHyperlink cTHyperlink;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlink = (CTHyperlink) get_store().add_element_user(HLINKCLICK$0);
        }
        return cTHyperlink;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public CTHyperlink addNewHlinkHover() {
        CTHyperlink cTHyperlink;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlink = (CTHyperlink) get_store().add_element_user(HLINKHOVER$2);
        }
        return cTHyperlink;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public String getDescr() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DESCR$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public CTOfficeArtExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTOfficeArtExtensionList cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(EXTLST$4, 0);
            if (cTOfficeArtExtensionList == null) {
                return null;
            }
            return cTOfficeArtExtensionList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public boolean getHidden() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIDDEN$12;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public CTHyperlink getHlinkClick() {
        synchronized (monitor()) {
            check_orphaned();
            CTHyperlink cTHyperlink = (CTHyperlink) get_store().find_element_user(HLINKCLICK$0, 0);
            if (cTHyperlink == null) {
                return null;
            }
            return cTHyperlink;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public CTHyperlink getHlinkHover() {
        synchronized (monitor()) {
            check_orphaned();
            CTHyperlink cTHyperlink = (CTHyperlink) get_store().find_element_user(HLINKHOVER$2, 0);
            if (cTHyperlink == null) {
                return null;
            }
            return cTHyperlink;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public long getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$6);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(NAME$8);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public boolean isSetDescr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DESCR$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public boolean isSetHidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HIDDEN$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public boolean isSetHlinkClick() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HLINKCLICK$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public boolean isSetHlinkHover() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HLINKHOVER$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void setDescr(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DESCR$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$4;
            CTOfficeArtExtensionList cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) typeStore.find_element_user(qName, 0);
            if (cTOfficeArtExtensionList2 == null) {
                cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) get_store().add_element_user(qName);
            }
            cTOfficeArtExtensionList2.set(cTOfficeArtExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void setHidden(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIDDEN$12;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void setHlinkClick(CTHyperlink cTHyperlink) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HLINKCLICK$0;
            CTHyperlink cTHyperlink2 = (CTHyperlink) typeStore.find_element_user(qName, 0);
            if (cTHyperlink2 == null) {
                cTHyperlink2 = (CTHyperlink) get_store().add_element_user(qName);
            }
            cTHyperlink2.set(cTHyperlink);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void setHlinkHover(CTHyperlink cTHyperlink) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HLINKHOVER$2;
            CTHyperlink cTHyperlink2 = (CTHyperlink) typeStore.find_element_user(qName, 0);
            if (cTHyperlink2 == null) {
                cTHyperlink2 = (CTHyperlink) get_store().add_element_user(qName);
            }
            cTHyperlink2.set(cTHyperlink);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void setId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void unsetDescr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DESCR$10);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void unsetHidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HIDDEN$12);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void unsetHlinkClick() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HLINKCLICK$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void unsetHlinkHover() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HLINKHOVER$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public XmlString xgetDescr() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DESCR$10;
            xmlString = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString == null) {
                xmlString = (XmlString) get_default_attribute_value(qName);
            }
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public XmlBoolean xgetHidden() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIDDEN$12;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public STDrawingElementId xgetId() {
        STDrawingElementId sTDrawingElementId;
        synchronized (monitor()) {
            check_orphaned();
            sTDrawingElementId = (STDrawingElementId) get_store().find_attribute_user(ID$6);
        }
        return sTDrawingElementId;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public XmlString xgetName() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(NAME$8);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void xsetDescr(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DESCR$10;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void xsetHidden(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIDDEN$12;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void xsetId(STDrawingElementId sTDrawingElementId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$6;
            STDrawingElementId sTDrawingElementId2 = (STDrawingElementId) typeStore.find_attribute_user(qName);
            if (sTDrawingElementId2 == null) {
                sTDrawingElementId2 = (STDrawingElementId) get_store().add_attribute_user(qName);
            }
            sTDrawingElementId2.set(sTDrawingElementId);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void xsetName(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$8;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }
}
