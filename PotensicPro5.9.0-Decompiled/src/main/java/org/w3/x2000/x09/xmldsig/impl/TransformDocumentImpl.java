package org.w3.x2000.x09.xmldsig.impl;

import aavax.xml.namespace.QName;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.w3.x2000.x09.xmldsig.TransformDocument;
import org.w3.x2000.x09.xmldsig.TransformType;

/* loaded from: classes6.dex */
public class TransformDocumentImpl extends XmlComplexContentImpl implements TransformDocument {
    private static final QName TRANSFORM$0 = new QName(SignatureFacet.XML_DIGSIG_NS, "Transform");

    public TransformDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformDocument
    public TransformType addNewTransform() {
        TransformType transformType;
        synchronized (monitor()) {
            check_orphaned();
            transformType = (TransformType) get_store().add_element_user(TRANSFORM$0);
        }
        return transformType;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformDocument
    public TransformType getTransform() {
        synchronized (monitor()) {
            check_orphaned();
            TransformType transformType = (TransformType) get_store().find_element_user(TRANSFORM$0, 0);
            if (transformType == null) {
                return null;
            }
            return transformType;
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformDocument
    public void setTransform(TransformType transformType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRANSFORM$0;
            TransformType transformType2 = (TransformType) typeStore.find_element_user(qName, 0);
            if (transformType2 == null) {
                transformType2 = (TransformType) get_store().add_element_user(qName);
            }
            transformType2.set(transformType);
        }
    }
}
