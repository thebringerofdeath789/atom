package org.jdom.adapters;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.jdom.DocType;
import org.jdom.JDOMException;
import org.w3c.dom.Document;

/* loaded from: classes5.dex */
public interface DOMAdapter {
    Document createDocument() throws JDOMException;

    Document createDocument(DocType docType) throws JDOMException;

    Document getDocument(File file, boolean z) throws IOException, JDOMException;

    Document getDocument(InputStream inputStream, boolean z) throws IOException, JDOMException;
}
