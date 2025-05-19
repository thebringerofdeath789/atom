package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import aavax.xml.namespace.QName;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins;

/* loaded from: classes5.dex */
public class CTPageMarginsImpl extends XmlComplexContentImpl implements CTPageMargins {
    private static final QName L$0 = new QName("", "l");
    private static final QName R$2 = new QName("", InternalZipConstants.READ_MODE);
    private static final QName T$4 = new QName("", "t");
    private static final QName B$6 = new QName("", "b");
    private static final QName HEADER$8 = new QName("", "header");
    private static final QName FOOTER$10 = new QName("", "footer");

    public CTPageMarginsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
    public double getB() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(B$6);
            if (simpleValue == null) {
                return 0.0d;
            }
            return simpleValue.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
    public double getL() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(L$0);
            if (simpleValue == null) {
                return 0.0d;
            }
            return simpleValue.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
    public double getR() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(R$2);
            if (simpleValue == null) {
                return 0.0d;
            }
            return simpleValue.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
    public double getT() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(T$4);
            if (simpleValue == null) {
                return 0.0d;
            }
            return simpleValue.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
    public void setB(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = B$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
    public void setL(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = L$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
    public void setR(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = R$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
    public void setT(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = T$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
    public XmlDouble xgetB() {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().find_attribute_user(B$6);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
    public XmlDouble xgetFooter() {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().find_attribute_user(FOOTER$10);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
    public XmlDouble xgetHeader() {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().find_attribute_user(HEADER$8);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
    public XmlDouble xgetL() {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().find_attribute_user(L$0);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
    public XmlDouble xgetR() {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().find_attribute_user(R$2);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
    public XmlDouble xgetT() {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().find_attribute_user(T$4);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
    public void xsetB(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = B$6;
            XmlDouble xmlDouble2 = (XmlDouble) typeStore.find_attribute_user(qName);
            if (xmlDouble2 == null) {
                xmlDouble2 = (XmlDouble) get_store().add_attribute_user(qName);
            }
            xmlDouble2.set(xmlDouble);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
    public void xsetL(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = L$0;
            XmlDouble xmlDouble2 = (XmlDouble) typeStore.find_attribute_user(qName);
            if (xmlDouble2 == null) {
                xmlDouble2 = (XmlDouble) get_store().add_attribute_user(qName);
            }
            xmlDouble2.set(xmlDouble);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
    public void xsetR(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = R$2;
            XmlDouble xmlDouble2 = (XmlDouble) typeStore.find_attribute_user(qName);
            if (xmlDouble2 == null) {
                xmlDouble2 = (XmlDouble) get_store().add_attribute_user(qName);
            }
            xmlDouble2.set(xmlDouble);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins
    public void xsetT(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = T$4;
            XmlDouble xmlDouble2 = (XmlDouble) typeStore.find_attribute_user(qName);
            if (xmlDouble2 == null) {
                xmlDouble2 = (XmlDouble) get_store().add_attribute_user(qName);
            }
            xmlDouble2.set(xmlDouble);
        }
    }
}
