package org.apache.xmlbeans.impl.xb.ltgfmt.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;

/* loaded from: classes5.dex */
public class TestCaseImpl extends XmlComplexContentImpl implements TestCase {
    private static final QName DESCRIPTION$0 = new QName("http://www.bea.com/2003/05/xmlbean/ltgfmt", "description");
    private static final QName FILES$2 = new QName("http://www.bea.com/2003/05/xmlbean/ltgfmt", "files");
    private static final QName ID$4 = new QName("", TtmlNode.ATTR_ID);
    private static final QName ORIGIN$6 = new QName("", "origin");
    private static final QName MODIFIED$8 = new QName("", "modified");

    public TestCaseImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public String getDescription() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DESCRIPTION$0, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public XmlString xgetDescription() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(DESCRIPTION$0, 0);
        }
        return xmlString;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public boolean isSetDescription() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DESCRIPTION$0) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void setDescription(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DESCRIPTION$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void xsetDescription(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DESCRIPTION$0;
            XmlString xmlString2 = (XmlString) typeStore.find_element_user(qName, 0);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_element_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void unsetDescription() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DESCRIPTION$0, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public TestCase.Files getFiles() {
        synchronized (monitor()) {
            check_orphaned();
            TestCase.Files files = (TestCase.Files) get_store().find_element_user(FILES$2, 0);
            if (files == null) {
                return null;
            }
            return files;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void setFiles(TestCase.Files files) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILES$2;
            TestCase.Files files2 = (TestCase.Files) typeStore.find_element_user(qName, 0);
            if (files2 == null) {
                files2 = (TestCase.Files) get_store().add_element_user(qName);
            }
            files2.set(files);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public TestCase.Files addNewFiles() {
        TestCase.Files files;
        synchronized (monitor()) {
            check_orphaned();
            files = (TestCase.Files) get_store().add_element_user(FILES$2);
        }
        return files;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$4);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public XmlID xgetId() {
        XmlID xmlID;
        synchronized (monitor()) {
            check_orphaned();
            xmlID = (XmlID) get_store().find_attribute_user(ID$4);
        }
        return xmlID;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$4) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void xsetId(XmlID xmlID) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$4;
            XmlID xmlID2 = (XmlID) typeStore.find_attribute_user(qName);
            if (xmlID2 == null) {
                xmlID2 = (XmlID) get_store().add_attribute_user(qName);
            }
            xmlID2.set(xmlID);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public String getOrigin() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ORIGIN$6);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public XmlToken xgetOrigin() {
        XmlToken xmlToken;
        synchronized (monitor()) {
            check_orphaned();
            xmlToken = (XmlToken) get_store().find_attribute_user(ORIGIN$6);
        }
        return xmlToken;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public boolean isSetOrigin() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ORIGIN$6) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void setOrigin(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORIGIN$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void xsetOrigin(XmlToken xmlToken) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORIGIN$6;
            XmlToken xmlToken2 = (XmlToken) typeStore.find_attribute_user(qName);
            if (xmlToken2 == null) {
                xmlToken2 = (XmlToken) get_store().add_attribute_user(qName);
            }
            xmlToken2.set(xmlToken);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void unsetOrigin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ORIGIN$6);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public boolean getModified() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(MODIFIED$8);
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public XmlBoolean xgetModified() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(MODIFIED$8);
        }
        return xmlBoolean;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public boolean isSetModified() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MODIFIED$8) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void setModified(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MODIFIED$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void xsetModified(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MODIFIED$8;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void unsetModified() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MODIFIED$8);
        }
    }

    public static class FilesImpl extends XmlComplexContentImpl implements TestCase.Files {
        private static final QName FILE$0 = new QName("http://www.bea.com/2003/05/xmlbean/ltgfmt", StringLookupFactory.KEY_FILE);

        public FilesImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public FileDesc[] getFileArray() {
            FileDesc[] fileDescArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(FILE$0, arrayList);
                fileDescArr = new FileDesc[arrayList.size()];
                arrayList.toArray(fileDescArr);
            }
            return fileDescArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public FileDesc getFileArray(int i) {
            FileDesc fileDesc;
            synchronized (monitor()) {
                check_orphaned();
                fileDesc = (FileDesc) get_store().find_element_user(FILE$0, i);
                if (fileDesc == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return fileDesc;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public int sizeOfFileArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(FILE$0);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public void setFileArray(FileDesc[] fileDescArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(fileDescArr, FILE$0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public void setFileArray(int i, FileDesc fileDesc) {
            synchronized (monitor()) {
                check_orphaned();
                FileDesc fileDesc2 = (FileDesc) get_store().find_element_user(FILE$0, i);
                if (fileDesc2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                fileDesc2.set(fileDesc);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public FileDesc insertNewFile(int i) {
            FileDesc fileDesc;
            synchronized (monitor()) {
                check_orphaned();
                fileDesc = (FileDesc) get_store().insert_element_user(FILE$0, i);
            }
            return fileDesc;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public FileDesc addNewFile() {
            FileDesc fileDesc;
            synchronized (monitor()) {
                check_orphaned();
                fileDesc = (FileDesc) get_store().add_element_user(FILE$0);
            }
            return fileDesc;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public void removeFile(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(FILE$0, i);
            }
        }
    }
}
