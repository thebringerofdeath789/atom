package org.dom4j.bean;

import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.dom4j.Attribute;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.QName;
import org.dom4j.tree.DefaultAttribute;
import org.xml.sax.Attributes;

/* loaded from: classes5.dex */
public class BeanDocumentFactory extends DocumentFactory {
    static /* synthetic */ Class class$org$dom4j$bean$BeanDocumentFactory;
    private static BeanDocumentFactory singleton = new BeanDocumentFactory();

    protected Object createBean(QName qName) {
        return null;
    }

    public static DocumentFactory getInstance() {
        return singleton;
    }

    @Override // org.dom4j.DocumentFactory
    public Element createElement(QName qName) {
        Object createBean = createBean(qName);
        if (createBean == null) {
            return new BeanElement(qName);
        }
        return new BeanElement(qName, createBean);
    }

    public Element createElement(QName qName, Attributes attributes) {
        Object createBean = createBean(qName, attributes);
        if (createBean == null) {
            return new BeanElement(qName);
        }
        return new BeanElement(qName, createBean);
    }

    @Override // org.dom4j.DocumentFactory
    public Attribute createAttribute(Element element, QName qName, String str) {
        return new DefaultAttribute(qName, str);
    }

    protected Object createBean(QName qName, Attributes attributes) {
        String value = attributes.getValue(JamXmlElements.CLASS);
        if (value == null) {
            return null;
        }
        try {
            Class cls = class$org$dom4j$bean$BeanDocumentFactory;
            if (cls == null) {
                cls = class$("org.dom4j.bean.BeanDocumentFactory");
                class$org$dom4j$bean$BeanDocumentFactory = cls;
            }
            return Class.forName(value, true, cls.getClassLoader()).newInstance();
        } catch (Exception e) {
            handleException(e);
            return null;
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    protected void handleException(Exception exc) {
        System.out.println(new StringBuffer().append("#### Warning: couldn't create bean: ").append(exc).toString());
    }
}
