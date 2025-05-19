package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontSize;

/* loaded from: classes6.dex */
public class CTFontSizeImpl extends XmlComplexContentImpl implements CTFontSize {
    private static final QName VAL$0 = new QName("", "val");

    public CTFontSizeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontSize
    public double getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VAL$0);
            if (simpleValue == null) {
                return 0.0d;
            }
            return simpleValue.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontSize
    public void setVal(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontSize
    public XmlDouble xgetVal() {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().find_attribute_user(VAL$0);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontSize
    public void xsetVal(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            XmlDouble xmlDouble2 = (XmlDouble) typeStore.find_attribute_user(qName);
            if (xmlDouble2 == null) {
                xmlDouble2 = (XmlDouble) get_store().add_attribute_user(qName);
            }
            xmlDouble2.set(xmlDouble);
        }
    }
}
