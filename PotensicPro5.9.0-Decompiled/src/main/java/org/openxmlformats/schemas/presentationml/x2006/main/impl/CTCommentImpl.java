package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.Calendar;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTComment;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.STIndex;

/* loaded from: classes6.dex */
public class CTCommentImpl extends XmlComplexContentImpl implements CTComment {
    private static final QName POS$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "pos");
    private static final QName TEXT$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "text");
    private static final QName EXTLST$4 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
    private static final QName AUTHORID$6 = new QName("", "authorId");
    private static final QName DT$8 = new QName("", "dt");
    private static final QName IDX$10 = new QName("", "idx");

    public CTCommentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public CTExtensionListModify addNewExtLst() {
        CTExtensionListModify add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EXTLST$4);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public CTPoint2D addNewPos() {
        CTPoint2D cTPoint2D;
        synchronized (monitor()) {
            check_orphaned();
            cTPoint2D = (CTPoint2D) get_store().add_element_user(POS$0);
        }
        return cTPoint2D;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public long getAuthorId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(AUTHORID$6);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public Calendar getDt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DT$8);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getCalendarValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public CTExtensionListModify getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionListModify find_element_user = get_store().find_element_user(EXTLST$4, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public long getIdx() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(IDX$10);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public CTPoint2D getPos() {
        synchronized (monitor()) {
            check_orphaned();
            CTPoint2D cTPoint2D = (CTPoint2D) get_store().find_element_user(POS$0, 0);
            if (cTPoint2D == null) {
                return null;
            }
            return cTPoint2D;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public String getText() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(TEXT$2, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public boolean isSetDt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DT$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public void setAuthorId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTHORID$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public void setDt(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DT$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public void setExtLst(CTExtensionListModify cTExtensionListModify) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$4;
            CTExtensionListModify find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTExtensionListModify) get_store().add_element_user(qName);
            }
            find_element_user.set(cTExtensionListModify);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public void setIdx(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IDX$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public void setPos(CTPoint2D cTPoint2D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POS$0;
            CTPoint2D cTPoint2D2 = (CTPoint2D) typeStore.find_element_user(qName, 0);
            if (cTPoint2D2 == null) {
                cTPoint2D2 = (CTPoint2D) get_store().add_element_user(qName);
            }
            cTPoint2D2.set(cTPoint2D);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public void setText(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXT$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public void unsetDt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DT$8);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public XmlUnsignedInt xgetAuthorId() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(AUTHORID$6);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public XmlDateTime xgetDt() {
        XmlDateTime xmlDateTime;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTime = (XmlDateTime) get_store().find_attribute_user(DT$8);
        }
        return xmlDateTime;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public STIndex xgetIdx() {
        STIndex find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(IDX$10);
        }
        return find_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public XmlString xgetText() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(TEXT$2, 0);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public void xsetAuthorId(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTHORID$6;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public void xsetDt(XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DT$8;
            XmlDateTime xmlDateTime2 = (XmlDateTime) typeStore.find_attribute_user(qName);
            if (xmlDateTime2 == null) {
                xmlDateTime2 = (XmlDateTime) get_store().add_attribute_user(qName);
            }
            xmlDateTime2.set(xmlDateTime);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public void xsetIdx(STIndex sTIndex) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IDX$10;
            STIndex find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STIndex) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTIndex);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTComment
    public void xsetText(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXT$2;
            XmlString xmlString2 = (XmlString) typeStore.find_element_user(qName, 0);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_element_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }
}
