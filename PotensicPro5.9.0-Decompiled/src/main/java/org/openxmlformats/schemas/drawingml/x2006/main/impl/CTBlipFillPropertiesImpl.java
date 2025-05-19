package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStretchInfoProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTileInfoProperties;

/* loaded from: classes5.dex */
public class CTBlipFillPropertiesImpl extends XmlComplexContentImpl implements CTBlipFillProperties {
    private static final QName BLIP$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blip");
    private static final QName SRCRECT$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "srcRect");
    private static final QName TILE$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tile");
    private static final QName STRETCH$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "stretch");
    private static final QName DPI$8 = new QName("", "dpi");
    private static final QName ROTWITHSHAPE$10 = new QName("", "rotWithShape");

    public CTBlipFillPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public CTBlip addNewBlip() {
        CTBlip cTBlip;
        synchronized (monitor()) {
            check_orphaned();
            cTBlip = (CTBlip) get_store().add_element_user(BLIP$0);
        }
        return cTBlip;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public CTRelativeRect addNewSrcRect() {
        CTRelativeRect cTRelativeRect;
        synchronized (monitor()) {
            check_orphaned();
            cTRelativeRect = (CTRelativeRect) get_store().add_element_user(SRCRECT$2);
        }
        return cTRelativeRect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public CTStretchInfoProperties addNewStretch() {
        CTStretchInfoProperties cTStretchInfoProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTStretchInfoProperties = (CTStretchInfoProperties) get_store().add_element_user(STRETCH$6);
        }
        return cTStretchInfoProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public CTTileInfoProperties addNewTile() {
        CTTileInfoProperties add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TILE$4);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public CTBlip getBlip() {
        synchronized (monitor()) {
            check_orphaned();
            CTBlip cTBlip = (CTBlip) get_store().find_element_user(BLIP$0, 0);
            if (cTBlip == null) {
                return null;
            }
            return cTBlip;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public long getDpi() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DPI$8);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public boolean getRotWithShape() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ROTWITHSHAPE$10);
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public CTRelativeRect getSrcRect() {
        synchronized (monitor()) {
            check_orphaned();
            CTRelativeRect cTRelativeRect = (CTRelativeRect) get_store().find_element_user(SRCRECT$2, 0);
            if (cTRelativeRect == null) {
                return null;
            }
            return cTRelativeRect;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public CTStretchInfoProperties getStretch() {
        synchronized (monitor()) {
            check_orphaned();
            CTStretchInfoProperties cTStretchInfoProperties = (CTStretchInfoProperties) get_store().find_element_user(STRETCH$6, 0);
            if (cTStretchInfoProperties == null) {
                return null;
            }
            return cTStretchInfoProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public CTTileInfoProperties getTile() {
        synchronized (monitor()) {
            check_orphaned();
            CTTileInfoProperties find_element_user = get_store().find_element_user(TILE$4, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public boolean isSetBlip() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BLIP$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public boolean isSetDpi() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DPI$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public boolean isSetRotWithShape() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ROTWITHSHAPE$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public boolean isSetSrcRect() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SRCRECT$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public boolean isSetStretch() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STRETCH$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public boolean isSetTile() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TILE$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void setBlip(CTBlip cTBlip) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLIP$0;
            CTBlip cTBlip2 = (CTBlip) typeStore.find_element_user(qName, 0);
            if (cTBlip2 == null) {
                cTBlip2 = (CTBlip) get_store().add_element_user(qName);
            }
            cTBlip2.set(cTBlip);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void setDpi(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DPI$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void setRotWithShape(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROTWITHSHAPE$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void setSrcRect(CTRelativeRect cTRelativeRect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SRCRECT$2;
            CTRelativeRect cTRelativeRect2 = (CTRelativeRect) typeStore.find_element_user(qName, 0);
            if (cTRelativeRect2 == null) {
                cTRelativeRect2 = (CTRelativeRect) get_store().add_element_user(qName);
            }
            cTRelativeRect2.set(cTRelativeRect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void setStretch(CTStretchInfoProperties cTStretchInfoProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STRETCH$6;
            CTStretchInfoProperties cTStretchInfoProperties2 = (CTStretchInfoProperties) typeStore.find_element_user(qName, 0);
            if (cTStretchInfoProperties2 == null) {
                cTStretchInfoProperties2 = (CTStretchInfoProperties) get_store().add_element_user(qName);
            }
            cTStretchInfoProperties2.set(cTStretchInfoProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void setTile(CTTileInfoProperties cTTileInfoProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TILE$4;
            CTTileInfoProperties find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTileInfoProperties) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTileInfoProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void unsetBlip() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BLIP$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void unsetDpi() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DPI$8);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void unsetRotWithShape() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ROTWITHSHAPE$10);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void unsetSrcRect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SRCRECT$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void unsetStretch() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STRETCH$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void unsetTile() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TILE$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public XmlUnsignedInt xgetDpi() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(DPI$8);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public XmlBoolean xgetRotWithShape() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(ROTWITHSHAPE$10);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void xsetDpi(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DPI$8;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void xsetRotWithShape(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROTWITHSHAPE$10;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }
}
