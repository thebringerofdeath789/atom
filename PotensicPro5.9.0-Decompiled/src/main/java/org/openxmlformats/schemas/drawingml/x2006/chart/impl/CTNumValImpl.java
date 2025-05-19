package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal;
import org.openxmlformats.schemas.drawingml.x2006.chart.STXstring;

/* loaded from: classes5.dex */
public class CTNumValImpl extends XmlComplexContentImpl implements CTNumVal {
    private static final QName V$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "v");
    private static final QName IDX$2 = new QName("", "idx");
    private static final QName FORMATCODE$4 = new QName("", "formatCode");

    public CTNumValImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal
    public String getFormatCode() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FORMATCODE$4);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal
    public long getIdx() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(IDX$2);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal
    public String getV() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(V$0, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal
    public boolean isSetFormatCode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FORMATCODE$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal
    public void setFormatCode(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORMATCODE$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal
    public void setIdx(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IDX$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal
    public void setV(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = V$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal
    public void unsetFormatCode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FORMATCODE$4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal
    public STXstring xgetFormatCode() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_attribute_user(FORMATCODE$4);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal
    public XmlUnsignedInt xgetIdx() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(IDX$2);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal
    public STXstring xgetV() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_element_user(V$0, 0);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal
    public void xsetFormatCode(STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORMATCODE$4;
            STXstring sTXstring2 = (STXstring) typeStore.find_attribute_user(qName);
            if (sTXstring2 == null) {
                sTXstring2 = (STXstring) get_store().add_attribute_user(qName);
            }
            sTXstring2.set(sTXstring);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal
    public void xsetIdx(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IDX$2;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal
    public void xsetV(STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = V$0;
            STXstring sTXstring2 = (STXstring) typeStore.find_element_user(qName, 0);
            if (sTXstring2 == null) {
                sTXstring2 = (STXstring) get_store().add_element_user(qName);
            }
            sTXstring2.set(sTXstring);
        }
    }
}
