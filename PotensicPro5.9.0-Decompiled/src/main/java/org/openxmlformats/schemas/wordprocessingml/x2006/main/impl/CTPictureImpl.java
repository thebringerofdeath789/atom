package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTControl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRel;

/* loaded from: classes6.dex */
public class CTPictureImpl extends CTPictureBaseImpl implements CTPicture {
    private static final QName MOVIE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "movie");
    private static final QName CONTROL$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", SessionDescription.ATTR_CONTROL);

    public CTPictureImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture
    public CTControl addNewControl() {
        CTControl add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CONTROL$2);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture
    public CTRel addNewMovie() {
        CTRel cTRel;
        synchronized (monitor()) {
            check_orphaned();
            cTRel = (CTRel) get_store().add_element_user(MOVIE$0);
        }
        return cTRel;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture
    public CTControl getControl() {
        synchronized (monitor()) {
            check_orphaned();
            CTControl find_element_user = get_store().find_element_user(CONTROL$2, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture
    public CTRel getMovie() {
        synchronized (monitor()) {
            check_orphaned();
            CTRel cTRel = (CTRel) get_store().find_element_user(MOVIE$0, 0);
            if (cTRel == null) {
                return null;
            }
            return cTRel;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture
    public boolean isSetControl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CONTROL$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture
    public boolean isSetMovie() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MOVIE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture
    public void setControl(CTControl cTControl) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTROL$2;
            CTControl find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTControl) get_store().add_element_user(qName);
            }
            find_element_user.set(cTControl);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture
    public void setMovie(CTRel cTRel) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MOVIE$0;
            CTRel cTRel2 = (CTRel) typeStore.find_element_user(qName, 0);
            if (cTRel2 == null) {
                cTRel2 = (CTRel) get_store().add_element_user(qName);
            }
            cTRel2.set(cTRel);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture
    public void unsetControl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CONTROL$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture
    public void unsetMovie() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVIE$0, 0);
        }
    }
}
