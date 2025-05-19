package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;

/* loaded from: classes5.dex */
public class CTGraphicalObjectDataImpl extends XmlComplexContentImpl implements CTGraphicalObjectData {
    private static final QName URI$0 = new QName("", "uri");

    public CTGraphicalObjectDataImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData
    public String getUri() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(URI$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData
    public boolean isSetUri() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(URI$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData
    public void setUri(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData
    public void unsetUri() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(URI$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData
    public XmlToken xgetUri() {
        XmlToken xmlToken;
        synchronized (monitor()) {
            check_orphaned();
            xmlToken = (XmlToken) get_store().find_attribute_user(URI$0);
        }
        return xmlToken;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData
    public void xsetUri(XmlToken xmlToken) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$0;
            XmlToken xmlToken2 = (XmlToken) typeStore.find_attribute_user(qName);
            if (xmlToken2 == null) {
                xmlToken2 = (XmlToken) get_store().add_attribute_user(qName);
            }
            xmlToken2.set(xmlToken);
        }
    }
}
