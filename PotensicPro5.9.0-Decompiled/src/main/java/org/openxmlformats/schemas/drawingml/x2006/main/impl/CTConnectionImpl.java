package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnection;
import org.openxmlformats.schemas.drawingml.x2006.main.STDrawingElementId;

/* loaded from: classes5.dex */
public class CTConnectionImpl extends XmlComplexContentImpl implements CTConnection {
    private static final QName ID$0 = new QName("", TtmlNode.ATTR_ID);
    private static final QName IDX$2 = new QName("", "idx");

    public CTConnectionImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnection
    public long getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$0);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnection
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnection
    public void setId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnection
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnection
    public STDrawingElementId xgetId() {
        STDrawingElementId sTDrawingElementId;
        synchronized (monitor()) {
            check_orphaned();
            sTDrawingElementId = (STDrawingElementId) get_store().find_attribute_user(ID$0);
        }
        return sTDrawingElementId;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnection
    public XmlUnsignedInt xgetIdx() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(IDX$2);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnection
    public void xsetId(STDrawingElementId sTDrawingElementId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$0;
            STDrawingElementId sTDrawingElementId2 = (STDrawingElementId) typeStore.find_attribute_user(qName);
            if (sTDrawingElementId2 == null) {
                sTDrawingElementId2 = (STDrawingElementId) get_store().add_attribute_user(qName);
            }
            sTDrawingElementId2.set(sTDrawingElementId);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnection
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
}
