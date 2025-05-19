package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins;

/* loaded from: classes6.dex */
public class CTPageMarginsImpl extends XmlComplexContentImpl implements CTPageMargins {
    private static final QName LEFT$0 = new QName("", "left");
    private static final QName RIGHT$2 = new QName("", "right");
    private static final QName TOP$4 = new QName("", "top");
    private static final QName BOTTOM$6 = new QName("", "bottom");
    private static final QName HEADER$8 = new QName("", "header");
    private static final QName FOOTER$10 = new QName("", "footer");

    public CTPageMarginsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public double getBottom() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BOTTOM$6);
            if (simpleValue == null) {
                return 0.0d;
            }
            return simpleValue.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public double getFooter() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FOOTER$10);
            if (simpleValue == null) {
                return 0.0d;
            }
            return simpleValue.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public double getHeader() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HEADER$8);
            if (simpleValue == null) {
                return 0.0d;
            }
            return simpleValue.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public double getLeft() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(LEFT$0);
            if (simpleValue == null) {
                return 0.0d;
            }
            return simpleValue.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public double getRight() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(RIGHT$2);
            if (simpleValue == null) {
                return 0.0d;
            }
            return simpleValue.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public double getTop() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TOP$4);
            if (simpleValue == null) {
                return 0.0d;
            }
            return simpleValue.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public void setBottom(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOTTOM$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public void setFooter(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOOTER$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public void setHeader(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HEADER$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public void setLeft(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEFT$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public void setRight(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RIGHT$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public void setTop(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOP$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public XmlDouble xgetBottom() {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().find_attribute_user(BOTTOM$6);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public XmlDouble xgetFooter() {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().find_attribute_user(FOOTER$10);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public XmlDouble xgetHeader() {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().find_attribute_user(HEADER$8);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public XmlDouble xgetLeft() {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().find_attribute_user(LEFT$0);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public XmlDouble xgetRight() {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().find_attribute_user(RIGHT$2);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public XmlDouble xgetTop() {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().find_attribute_user(TOP$4);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public void xsetBottom(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOTTOM$6;
            XmlDouble xmlDouble2 = (XmlDouble) typeStore.find_attribute_user(qName);
            if (xmlDouble2 == null) {
                xmlDouble2 = (XmlDouble) get_store().add_attribute_user(qName);
            }
            xmlDouble2.set(xmlDouble);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public void xsetFooter(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOOTER$10;
            XmlDouble xmlDouble2 = (XmlDouble) typeStore.find_attribute_user(qName);
            if (xmlDouble2 == null) {
                xmlDouble2 = (XmlDouble) get_store().add_attribute_user(qName);
            }
            xmlDouble2.set(xmlDouble);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public void xsetHeader(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HEADER$8;
            XmlDouble xmlDouble2 = (XmlDouble) typeStore.find_attribute_user(qName);
            if (xmlDouble2 == null) {
                xmlDouble2 = (XmlDouble) get_store().add_attribute_user(qName);
            }
            xmlDouble2.set(xmlDouble);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public void xsetLeft(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEFT$0;
            XmlDouble xmlDouble2 = (XmlDouble) typeStore.find_attribute_user(qName);
            if (xmlDouble2 == null) {
                xmlDouble2 = (XmlDouble) get_store().add_attribute_user(qName);
            }
            xmlDouble2.set(xmlDouble);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public void xsetRight(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RIGHT$2;
            XmlDouble xmlDouble2 = (XmlDouble) typeStore.find_attribute_user(qName);
            if (xmlDouble2 == null) {
                xmlDouble2 = (XmlDouble) get_store().add_attribute_user(qName);
            }
            xmlDouble2.set(xmlDouble);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins
    public void xsetTop(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOP$4;
            XmlDouble xmlDouble2 = (XmlDouble) typeStore.find_attribute_user(qName);
            if (xmlDouble2 == null) {
                xmlDouble2 = (XmlDouble) get_store().add_attribute_user(qName);
            }
            xmlDouble2.set(xmlDouble);
        }
    }
}
