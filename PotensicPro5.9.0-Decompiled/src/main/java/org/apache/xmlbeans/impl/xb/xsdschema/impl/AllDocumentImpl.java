package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.apache.xmlbeans.impl.xb.xsdschema.AllDocument;

/* loaded from: classes5.dex */
public class AllDocumentImpl extends XmlComplexContentImpl implements AllDocument {
    private static final QName ALL$0 = new QName("http://www.w3.org/2001/XMLSchema", TtmlNode.COMBINE_ALL);

    public AllDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AllDocument
    public All getAll() {
        synchronized (monitor()) {
            check_orphaned();
            All all = (All) get_store().find_element_user(ALL$0, 0);
            if (all == null) {
                return null;
            }
            return all;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AllDocument
    public void setAll(All all) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALL$0;
            All all2 = (All) typeStore.find_element_user(qName, 0);
            if (all2 == null) {
                all2 = (All) get_store().add_element_user(qName);
            }
            all2.set(all);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AllDocument
    public All addNewAll() {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().add_element_user(ALL$0);
        }
        return all;
    }
}
