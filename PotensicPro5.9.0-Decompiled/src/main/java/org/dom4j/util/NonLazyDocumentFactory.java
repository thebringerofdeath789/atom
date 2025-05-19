package org.dom4j.util;

import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.QName;

/* loaded from: classes5.dex */
public class NonLazyDocumentFactory extends DocumentFactory {
    protected static transient NonLazyDocumentFactory singleton = new NonLazyDocumentFactory();

    public static DocumentFactory getInstance() {
        return singleton;
    }

    @Override // org.dom4j.DocumentFactory
    public Element createElement(QName qName) {
        return new NonLazyElement(qName);
    }
}
