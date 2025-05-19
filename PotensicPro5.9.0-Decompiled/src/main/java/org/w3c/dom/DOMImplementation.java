package org.w3c.dom;

/* loaded from: classes6.dex */
public interface DOMImplementation {
    Document createDocument(String str, String str2, DocumentType documentType) throws DOMException;

    DocumentType createDocumentType(String str, String str2, String str3) throws DOMException;

    boolean hasFeature(String str, String str2);
}
