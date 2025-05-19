package org.apache.xmlbeans.impl.xb.xsdownload.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry;

/* loaded from: classes5.dex */
public class DownloadedSchemaEntryImpl extends XmlComplexContentImpl implements DownloadedSchemaEntry {
    private static final QName FILENAME$0 = new QName("http://www.bea.com/2003/01/xmlbean/xsdownload", "filename");
    private static final QName SHA1$2 = new QName("http://www.bea.com/2003/01/xmlbean/xsdownload", "sha1");
    private static final QName SCHEMALOCATION$4 = new QName("http://www.bea.com/2003/01/xmlbean/xsdownload", "schemaLocation");
    private static final QName NAMESPACE$6 = new QName("http://www.bea.com/2003/01/xmlbean/xsdownload", "namespace");

    public DownloadedSchemaEntryImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public String getFilename() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(FILENAME$0, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public XmlToken xgetFilename() {
        XmlToken xmlToken;
        synchronized (monitor()) {
            check_orphaned();
            xmlToken = (XmlToken) get_store().find_element_user(FILENAME$0, 0);
        }
        return xmlToken;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void setFilename(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILENAME$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void xsetFilename(XmlToken xmlToken) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILENAME$0;
            XmlToken xmlToken2 = (XmlToken) typeStore.find_element_user(qName, 0);
            if (xmlToken2 == null) {
                xmlToken2 = (XmlToken) get_store().add_element_user(qName);
            }
            xmlToken2.set(xmlToken);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public String getSha1() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(SHA1$2, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public XmlToken xgetSha1() {
        XmlToken xmlToken;
        synchronized (monitor()) {
            check_orphaned();
            xmlToken = (XmlToken) get_store().find_element_user(SHA1$2, 0);
        }
        return xmlToken;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void setSha1(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHA1$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void xsetSha1(XmlToken xmlToken) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHA1$2;
            XmlToken xmlToken2 = (XmlToken) typeStore.find_element_user(qName, 0);
            if (xmlToken2 == null) {
                xmlToken2 = (XmlToken) get_store().add_element_user(qName);
            }
            xmlToken2.set(xmlToken);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public String[] getSchemaLocationArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SCHEMALOCATION$4, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public String getSchemaLocationArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(SCHEMALOCATION$4, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public XmlAnyURI[] xgetSchemaLocationArray() {
        XmlAnyURI[] xmlAnyURIArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SCHEMALOCATION$4, arrayList);
            xmlAnyURIArr = new XmlAnyURI[arrayList.size()];
            arrayList.toArray(xmlAnyURIArr);
        }
        return xmlAnyURIArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public XmlAnyURI xgetSchemaLocationArray(int i) {
        XmlAnyURI xmlAnyURI;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURI = (XmlAnyURI) get_store().find_element_user(SCHEMALOCATION$4, i);
            if (xmlAnyURI == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlAnyURI;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public int sizeOfSchemaLocationArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SCHEMALOCATION$4);
        }
        return count_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void setSchemaLocationArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, SCHEMALOCATION$4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void setSchemaLocationArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(SCHEMALOCATION$4, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void xsetSchemaLocationArray(XmlAnyURI[] xmlAnyURIArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlAnyURIArr, SCHEMALOCATION$4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void xsetSchemaLocationArray(int i, XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            XmlAnyURI xmlAnyURI2 = (XmlAnyURI) get_store().find_element_user(SCHEMALOCATION$4, i);
            if (xmlAnyURI2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlAnyURI2.set(xmlAnyURI);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void insertSchemaLocation(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(SCHEMALOCATION$4, i)).setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void addSchemaLocation(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(SCHEMALOCATION$4)).setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public XmlAnyURI insertNewSchemaLocation(int i) {
        XmlAnyURI xmlAnyURI;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURI = (XmlAnyURI) get_store().insert_element_user(SCHEMALOCATION$4, i);
        }
        return xmlAnyURI;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public XmlAnyURI addNewSchemaLocation() {
        XmlAnyURI xmlAnyURI;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURI = (XmlAnyURI) get_store().add_element_user(SCHEMALOCATION$4);
        }
        return xmlAnyURI;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void removeSchemaLocation(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SCHEMALOCATION$4, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public String getNamespace() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(NAMESPACE$6, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public XmlAnyURI xgetNamespace() {
        XmlAnyURI xmlAnyURI;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURI = (XmlAnyURI) get_store().find_element_user(NAMESPACE$6, 0);
        }
        return xmlAnyURI;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public boolean isSetNamespace() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NAMESPACE$6) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void setNamespace(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAMESPACE$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void xsetNamespace(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAMESPACE$6;
            XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_element_user(qName, 0);
            if (xmlAnyURI2 == null) {
                xmlAnyURI2 = (XmlAnyURI) get_store().add_element_user(qName);
            }
            xmlAnyURI2.set(xmlAnyURI);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void unsetNamespace() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NAMESPACE$6, 0);
        }
    }
}
