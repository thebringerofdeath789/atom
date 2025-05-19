package org.dom4j.bean;

import java.util.List;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.dom4j.Attribute;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.tree.DefaultElement;
import org.dom4j.tree.NamespaceStack;
import org.xml.sax.Attributes;

/* loaded from: classes5.dex */
public class BeanElement extends DefaultElement {
    private static final DocumentFactory DOCUMENT_FACTORY = BeanDocumentFactory.getInstance();
    static /* synthetic */ Class class$org$dom4j$bean$BeanElement;
    private Object bean;

    public BeanElement(String str, Object obj) {
        this(DOCUMENT_FACTORY.createQName(str), obj);
    }

    public BeanElement(String str, Namespace namespace, Object obj) {
        this(DOCUMENT_FACTORY.createQName(str, namespace), obj);
    }

    public BeanElement(QName qName, Object obj) {
        super(qName);
        this.bean = obj;
    }

    public BeanElement(QName qName) {
        super(qName);
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.Element
    public Object getData() {
        return this.bean;
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.Element
    public void setData(Object obj) {
        this.bean = obj;
        setAttributeList(null);
    }

    @Override // org.dom4j.tree.DefaultElement, org.dom4j.tree.AbstractElement, org.dom4j.Element
    public Attribute attribute(String str) {
        return getBeanAttributeList().attribute(str);
    }

    @Override // org.dom4j.tree.DefaultElement, org.dom4j.tree.AbstractElement, org.dom4j.Element
    public Attribute attribute(QName qName) {
        return getBeanAttributeList().attribute(qName);
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.Element
    public Element addAttribute(String str, String str2) {
        Attribute attribute = attribute(str);
        if (attribute != null) {
            attribute.setValue(str2);
        }
        return this;
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.Element
    public Element addAttribute(QName qName, String str) {
        Attribute attribute = attribute(qName);
        if (attribute != null) {
            attribute.setValue(str);
        }
        return this;
    }

    @Override // org.dom4j.tree.DefaultElement, org.dom4j.Element
    public void setAttributes(List list) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override // org.dom4j.tree.AbstractElement
    public void setAttributes(Attributes attributes, NamespaceStack namespaceStack, boolean z) {
        String value = attributes.getValue(JamXmlElements.CLASS);
        if (value != null) {
            try {
                Class cls = class$org$dom4j$bean$BeanElement;
                if (cls == null) {
                    cls = class$("org.dom4j.bean.BeanElement");
                    class$org$dom4j$bean$BeanElement = cls;
                }
                setData(Class.forName(value, true, cls.getClassLoader()).newInstance());
                for (int i = 0; i < attributes.getLength(); i++) {
                    String localName = attributes.getLocalName(i);
                    if (!JamXmlElements.CLASS.equalsIgnoreCase(localName)) {
                        addAttribute(localName, attributes.getValue(i));
                    }
                }
                return;
            } catch (Exception e) {
                ((BeanDocumentFactory) getDocumentFactory()).handleException(e);
                return;
            }
        }
        super.setAttributes(attributes, namespaceStack, z);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    @Override // org.dom4j.tree.DefaultElement, org.dom4j.tree.AbstractElement, org.dom4j.tree.AbstractNode
    protected DocumentFactory getDocumentFactory() {
        return DOCUMENT_FACTORY;
    }

    protected BeanAttributeList getBeanAttributeList() {
        return (BeanAttributeList) attributeList();
    }

    @Override // org.dom4j.tree.AbstractElement
    protected List createAttributeList() {
        return new BeanAttributeList(this);
    }

    @Override // org.dom4j.tree.AbstractElement
    protected List createAttributeList(int i) {
        return new BeanAttributeList(this);
    }
}
