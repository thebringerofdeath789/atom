package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthor;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList;

/* loaded from: classes6.dex */
public class CTCommentAuthorListImpl extends XmlComplexContentImpl implements CTCommentAuthorList {
    private static final QName CMAUTHOR$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cmAuthor");

    public CTCommentAuthorListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList
    public CTCommentAuthor addNewCmAuthor() {
        CTCommentAuthor cTCommentAuthor;
        synchronized (monitor()) {
            check_orphaned();
            cTCommentAuthor = (CTCommentAuthor) get_store().add_element_user(CMAUTHOR$0);
        }
        return cTCommentAuthor;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList
    public CTCommentAuthor getCmAuthorArray(int i) {
        CTCommentAuthor cTCommentAuthor;
        synchronized (monitor()) {
            check_orphaned();
            cTCommentAuthor = (CTCommentAuthor) get_store().find_element_user(CMAUTHOR$0, i);
            if (cTCommentAuthor == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCommentAuthor;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList
    public CTCommentAuthor[] getCmAuthorArray() {
        CTCommentAuthor[] cTCommentAuthorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CMAUTHOR$0, arrayList);
            cTCommentAuthorArr = new CTCommentAuthor[arrayList.size()];
            arrayList.toArray(cTCommentAuthorArr);
        }
        return cTCommentAuthorArr;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList
    public List<CTCommentAuthor> getCmAuthorList() {
        1CmAuthorList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CmAuthorList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList
    public CTCommentAuthor insertNewCmAuthor(int i) {
        CTCommentAuthor cTCommentAuthor;
        synchronized (monitor()) {
            check_orphaned();
            cTCommentAuthor = (CTCommentAuthor) get_store().insert_element_user(CMAUTHOR$0, i);
        }
        return cTCommentAuthor;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList
    public void removeCmAuthor(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CMAUTHOR$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList
    public void setCmAuthorArray(int i, CTCommentAuthor cTCommentAuthor) {
        synchronized (monitor()) {
            check_orphaned();
            CTCommentAuthor cTCommentAuthor2 = (CTCommentAuthor) get_store().find_element_user(CMAUTHOR$0, i);
            if (cTCommentAuthor2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTCommentAuthor2.set(cTCommentAuthor);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList
    public void setCmAuthorArray(CTCommentAuthor[] cTCommentAuthorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTCommentAuthorArr, CMAUTHOR$0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList
    public int sizeOfCmAuthorArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CMAUTHOR$0);
        }
        return count_elements;
    }
}
