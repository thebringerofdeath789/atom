package org.jdom.adapters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.jdom.DocType;
import org.jdom.JDOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;

/* loaded from: classes5.dex */
public abstract class AbstractDOMAdapter implements DOMAdapter {
    private static final String CVS_ID = "@(#) $RCSfile: AbstractDOMAdapter.java,v $ $Revision: 1.20 $ $Date: 2004/02/06 09:28:31 $ $Name: jdom_1_0 $";
    static /* synthetic */ Class class$java$lang$String;

    @Override // org.jdom.adapters.DOMAdapter
    public abstract Document createDocument() throws JDOMException;

    @Override // org.jdom.adapters.DOMAdapter
    public abstract Document getDocument(InputStream inputStream, boolean z) throws IOException, JDOMException;

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    @Override // org.jdom.adapters.DOMAdapter
    public Document getDocument(File file, boolean z) throws IOException, JDOMException {
        return getDocument(new FileInputStream(file), z);
    }

    @Override // org.jdom.adapters.DOMAdapter
    public Document createDocument(DocType docType) throws JDOMException {
        if (docType == null) {
            return createDocument();
        }
        DOMImplementation implementation = createDocument().getImplementation();
        DocumentType createDocumentType = implementation.createDocumentType(docType.getElementName(), docType.getPublicID(), docType.getSystemID());
        setInternalSubset(createDocumentType, docType.getInternalSubset());
        return implementation.createDocument("http://temporary", docType.getElementName(), createDocumentType);
    }

    protected void setInternalSubset(DocumentType documentType, String str) {
        if (documentType == null || str == null) {
            return;
        }
        try {
            Class<?> cls = documentType.getClass();
            Class<?>[] clsArr = new Class[1];
            Class<?> cls2 = class$java$lang$String;
            if (cls2 == null) {
                cls2 = class$("java.lang.String");
                class$java$lang$String = cls2;
            }
            clsArr[0] = cls2;
            cls.getMethod("setInternalSubset", clsArr).invoke(documentType, str);
        } catch (Exception unused) {
        }
    }
}
