package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMap;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSchema;

/* loaded from: classes6.dex */
public class CTMapInfoImpl extends XmlComplexContentImpl implements CTMapInfo {
    private static final QName SCHEMA$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "Schema");
    private static final QName MAP$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "Map");
    private static final QName SELECTIONNAMESPACES$4 = new QName("", "SelectionNamespaces");

    public CTMapInfoImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public CTMap addNewMap() {
        CTMap cTMap;
        synchronized (monitor()) {
            check_orphaned();
            cTMap = (CTMap) get_store().add_element_user(MAP$2);
        }
        return cTMap;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public CTSchema addNewSchema() {
        CTSchema cTSchema;
        synchronized (monitor()) {
            check_orphaned();
            cTSchema = (CTSchema) get_store().add_element_user(SCHEMA$0);
        }
        return cTSchema;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public CTMap getMapArray(int i) {
        CTMap cTMap;
        synchronized (monitor()) {
            check_orphaned();
            cTMap = (CTMap) get_store().find_element_user(MAP$2, i);
            if (cTMap == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMap;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public CTMap[] getMapArray() {
        CTMap[] cTMapArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MAP$2, arrayList);
            cTMapArr = new CTMap[arrayList.size()];
            arrayList.toArray(cTMapArr);
        }
        return cTMapArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public List<CTMap> getMapList() {
        1MapList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MapList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public CTSchema getSchemaArray(int i) {
        CTSchema cTSchema;
        synchronized (monitor()) {
            check_orphaned();
            cTSchema = (CTSchema) get_store().find_element_user(SCHEMA$0, i);
            if (cTSchema == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSchema;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public CTSchema[] getSchemaArray() {
        CTSchema[] cTSchemaArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SCHEMA$0, arrayList);
            cTSchemaArr = new CTSchema[arrayList.size()];
            arrayList.toArray(cTSchemaArr);
        }
        return cTSchemaArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public List<CTSchema> getSchemaList() {
        1SchemaList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SchemaList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public String getSelectionNamespaces() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SELECTIONNAMESPACES$4);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public CTMap insertNewMap(int i) {
        CTMap cTMap;
        synchronized (monitor()) {
            check_orphaned();
            cTMap = (CTMap) get_store().insert_element_user(MAP$2, i);
        }
        return cTMap;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public CTSchema insertNewSchema(int i) {
        CTSchema cTSchema;
        synchronized (monitor()) {
            check_orphaned();
            cTSchema = (CTSchema) get_store().insert_element_user(SCHEMA$0, i);
        }
        return cTSchema;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public void removeMap(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MAP$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public void removeSchema(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SCHEMA$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public void setMapArray(int i, CTMap cTMap) {
        synchronized (monitor()) {
            check_orphaned();
            CTMap cTMap2 = (CTMap) get_store().find_element_user(MAP$2, i);
            if (cTMap2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMap2.set(cTMap);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public void setMapArray(CTMap[] cTMapArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMapArr, MAP$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public void setSchemaArray(int i, CTSchema cTSchema) {
        synchronized (monitor()) {
            check_orphaned();
            CTSchema cTSchema2 = (CTSchema) get_store().find_element_user(SCHEMA$0, i);
            if (cTSchema2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSchema2.set(cTSchema);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public void setSchemaArray(CTSchema[] cTSchemaArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSchemaArr, SCHEMA$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public void setSelectionNamespaces(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SELECTIONNAMESPACES$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public int sizeOfMapArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MAP$2);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public int sizeOfSchemaArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SCHEMA$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public XmlString xgetSelectionNamespaces() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(SELECTIONNAMESPACES$4);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo
    public void xsetSelectionNamespaces(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SELECTIONNAMESPACES$4;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }
}
