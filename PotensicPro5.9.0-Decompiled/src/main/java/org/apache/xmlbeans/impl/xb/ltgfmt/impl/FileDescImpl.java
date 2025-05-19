package org.apache.xmlbeans.impl.xb.ltgfmt.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.ltgfmt.Code;
import org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc;

/* loaded from: classes5.dex */
public class FileDescImpl extends XmlComplexContentImpl implements FileDesc {
    private static final QName CODE$0 = new QName("http://www.bea.com/2003/05/xmlbean/ltgfmt", "code");
    private static final QName TSDIR$2 = new QName("", "tsDir");
    private static final QName FOLDER$4 = new QName("", "folder");
    private static final QName FILENAME$6 = new QName("", "fileName");
    private static final QName ROLE$8 = new QName("", "role");
    private static final QName VALIDITY$10 = new QName("", "validity");

    public FileDescImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public Code getCode() {
        synchronized (monitor()) {
            check_orphaned();
            Code code = (Code) get_store().find_element_user(CODE$0, 0);
            if (code == null) {
                return null;
            }
            return code;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public boolean isSetCode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CODE$0) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void setCode(Code code) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CODE$0;
            Code code2 = (Code) typeStore.find_element_user(qName, 0);
            if (code2 == null) {
                code2 = (Code) get_store().add_element_user(qName);
            }
            code2.set(code);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public Code addNewCode() {
        Code code;
        synchronized (monitor()) {
            check_orphaned();
            code = (Code) get_store().add_element_user(CODE$0);
        }
        return code;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void unsetCode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CODE$0, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public String getTsDir() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TSDIR$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public XmlToken xgetTsDir() {
        XmlToken xmlToken;
        synchronized (monitor()) {
            check_orphaned();
            xmlToken = (XmlToken) get_store().find_attribute_user(TSDIR$2);
        }
        return xmlToken;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public boolean isSetTsDir() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TSDIR$2) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void setTsDir(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TSDIR$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void xsetTsDir(XmlToken xmlToken) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TSDIR$2;
            XmlToken xmlToken2 = (XmlToken) typeStore.find_attribute_user(qName);
            if (xmlToken2 == null) {
                xmlToken2 = (XmlToken) get_store().add_attribute_user(qName);
            }
            xmlToken2.set(xmlToken);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void unsetTsDir() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TSDIR$2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public String getFolder() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FOLDER$4);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public XmlToken xgetFolder() {
        XmlToken xmlToken;
        synchronized (monitor()) {
            check_orphaned();
            xmlToken = (XmlToken) get_store().find_attribute_user(FOLDER$4);
        }
        return xmlToken;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public boolean isSetFolder() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FOLDER$4) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void setFolder(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOLDER$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void xsetFolder(XmlToken xmlToken) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOLDER$4;
            XmlToken xmlToken2 = (XmlToken) typeStore.find_attribute_user(qName);
            if (xmlToken2 == null) {
                xmlToken2 = (XmlToken) get_store().add_attribute_user(qName);
            }
            xmlToken2.set(xmlToken);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void unsetFolder() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FOLDER$4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public String getFileName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FILENAME$6);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public XmlToken xgetFileName() {
        XmlToken xmlToken;
        synchronized (monitor()) {
            check_orphaned();
            xmlToken = (XmlToken) get_store().find_attribute_user(FILENAME$6);
        }
        return xmlToken;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public boolean isSetFileName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILENAME$6) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void setFileName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILENAME$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void xsetFileName(XmlToken xmlToken) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILENAME$6;
            XmlToken xmlToken2 = (XmlToken) typeStore.find_attribute_user(qName);
            if (xmlToken2 == null) {
                xmlToken2 = (XmlToken) get_store().add_attribute_user(qName);
            }
            xmlToken2.set(xmlToken);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void unsetFileName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILENAME$6);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public FileDesc.Role.Enum getRole() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ROLE$8);
            if (simpleValue == null) {
                return null;
            }
            return (FileDesc.Role.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public FileDesc.Role xgetRole() {
        FileDesc.Role role;
        synchronized (monitor()) {
            check_orphaned();
            role = (FileDesc.Role) get_store().find_attribute_user(ROLE$8);
        }
        return role;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public boolean isSetRole() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ROLE$8) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void setRole(FileDesc.Role.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROLE$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void xsetRole(FileDesc.Role role) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROLE$8;
            FileDesc.Role role2 = (FileDesc.Role) typeStore.find_attribute_user(qName);
            if (role2 == null) {
                role2 = (FileDesc.Role) get_store().add_attribute_user(qName);
            }
            role2.set(role);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void unsetRole() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ROLE$8);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public boolean getValidity() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VALIDITY$10);
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public XmlBoolean xgetValidity() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(VALIDITY$10);
        }
        return xmlBoolean;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public boolean isSetValidity() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VALIDITY$10) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void setValidity(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VALIDITY$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void xsetValidity(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VALIDITY$10;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void unsetValidity() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VALIDITY$10);
        }
    }

    public static class RoleImpl extends JavaStringEnumerationHolderEx implements FileDesc.Role {
        public RoleImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected RoleImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }
}
