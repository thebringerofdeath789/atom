package org.apache.xmlbeans.impl.xb.xsdownload.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry;
import org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument;

/* loaded from: classes5.dex */
public class DownloadedSchemasDocumentImpl extends XmlComplexContentImpl implements DownloadedSchemasDocument {
    private static final QName DOWNLOADEDSCHEMAS$0 = new QName("http://www.bea.com/2003/01/xmlbean/xsdownload", "downloaded-schemas");

    public DownloadedSchemasDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument
    public DownloadedSchemasDocument.DownloadedSchemas getDownloadedSchemas() {
        synchronized (monitor()) {
            check_orphaned();
            DownloadedSchemasDocument.DownloadedSchemas downloadedSchemas = (DownloadedSchemasDocument.DownloadedSchemas) get_store().find_element_user(DOWNLOADEDSCHEMAS$0, 0);
            if (downloadedSchemas == null) {
                return null;
            }
            return downloadedSchemas;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument
    public void setDownloadedSchemas(DownloadedSchemasDocument.DownloadedSchemas downloadedSchemas) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOWNLOADEDSCHEMAS$0;
            DownloadedSchemasDocument.DownloadedSchemas downloadedSchemas2 = (DownloadedSchemasDocument.DownloadedSchemas) typeStore.find_element_user(qName, 0);
            if (downloadedSchemas2 == null) {
                downloadedSchemas2 = (DownloadedSchemasDocument.DownloadedSchemas) get_store().add_element_user(qName);
            }
            downloadedSchemas2.set(downloadedSchemas);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument
    public DownloadedSchemasDocument.DownloadedSchemas addNewDownloadedSchemas() {
        DownloadedSchemasDocument.DownloadedSchemas downloadedSchemas;
        synchronized (monitor()) {
            check_orphaned();
            downloadedSchemas = (DownloadedSchemasDocument.DownloadedSchemas) get_store().add_element_user(DOWNLOADEDSCHEMAS$0);
        }
        return downloadedSchemas;
    }

    public static class DownloadedSchemasImpl extends XmlComplexContentImpl implements DownloadedSchemasDocument.DownloadedSchemas {
        private static final QName ENTRY$0 = new QName("http://www.bea.com/2003/01/xmlbean/xsdownload", "entry");
        private static final QName DEFAULTDIRECTORY$2 = new QName("", "defaultDirectory");

        public DownloadedSchemasImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument.DownloadedSchemas
        public DownloadedSchemaEntry[] getEntryArray() {
            DownloadedSchemaEntry[] downloadedSchemaEntryArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(ENTRY$0, arrayList);
                downloadedSchemaEntryArr = new DownloadedSchemaEntry[arrayList.size()];
                arrayList.toArray(downloadedSchemaEntryArr);
            }
            return downloadedSchemaEntryArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument.DownloadedSchemas
        public DownloadedSchemaEntry getEntryArray(int i) {
            DownloadedSchemaEntry downloadedSchemaEntry;
            synchronized (monitor()) {
                check_orphaned();
                downloadedSchemaEntry = (DownloadedSchemaEntry) get_store().find_element_user(ENTRY$0, i);
                if (downloadedSchemaEntry == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return downloadedSchemaEntry;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument.DownloadedSchemas
        public int sizeOfEntryArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(ENTRY$0);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument.DownloadedSchemas
        public void setEntryArray(DownloadedSchemaEntry[] downloadedSchemaEntryArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(downloadedSchemaEntryArr, ENTRY$0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument.DownloadedSchemas
        public void setEntryArray(int i, DownloadedSchemaEntry downloadedSchemaEntry) {
            synchronized (monitor()) {
                check_orphaned();
                DownloadedSchemaEntry downloadedSchemaEntry2 = (DownloadedSchemaEntry) get_store().find_element_user(ENTRY$0, i);
                if (downloadedSchemaEntry2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                downloadedSchemaEntry2.set(downloadedSchemaEntry);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument.DownloadedSchemas
        public DownloadedSchemaEntry insertNewEntry(int i) {
            DownloadedSchemaEntry downloadedSchemaEntry;
            synchronized (monitor()) {
                check_orphaned();
                downloadedSchemaEntry = (DownloadedSchemaEntry) get_store().insert_element_user(ENTRY$0, i);
            }
            return downloadedSchemaEntry;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument.DownloadedSchemas
        public DownloadedSchemaEntry addNewEntry() {
            DownloadedSchemaEntry downloadedSchemaEntry;
            synchronized (monitor()) {
                check_orphaned();
                downloadedSchemaEntry = (DownloadedSchemaEntry) get_store().add_element_user(ENTRY$0);
            }
            return downloadedSchemaEntry;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument.DownloadedSchemas
        public void removeEntry(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(ENTRY$0, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument.DownloadedSchemas
        public String getDefaultDirectory() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DEFAULTDIRECTORY$2);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument.DownloadedSchemas
        public XmlToken xgetDefaultDirectory() {
            XmlToken xmlToken;
            synchronized (monitor()) {
                check_orphaned();
                xmlToken = (XmlToken) get_store().find_attribute_user(DEFAULTDIRECTORY$2);
            }
            return xmlToken;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument.DownloadedSchemas
        public boolean isSetDefaultDirectory() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(DEFAULTDIRECTORY$2) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument.DownloadedSchemas
        public void setDefaultDirectory(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = DEFAULTDIRECTORY$2;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument.DownloadedSchemas
        public void xsetDefaultDirectory(XmlToken xmlToken) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = DEFAULTDIRECTORY$2;
                XmlToken xmlToken2 = (XmlToken) typeStore.find_attribute_user(qName);
                if (xmlToken2 == null) {
                    xmlToken2 = (XmlToken) get_store().add_attribute_user(qName);
                }
                xmlToken2.set(xmlToken);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument.DownloadedSchemas
        public void unsetDefaultDirectory() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(DEFAULTDIRECTORY$2);
            }
        }
    }
}
