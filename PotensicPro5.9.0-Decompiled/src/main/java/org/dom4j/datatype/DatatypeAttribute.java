package org.dom4j.datatype;

import com.sun.msv.datatype.DatabindableDatatype;
import com.sun.msv.datatype.SerializationContext;
import com.sun.msv.datatype.xsd.XSDatatype;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.tree.AbstractAttribute;
import org.relaxng.datatype.DatatypeException;
import org.relaxng.datatype.ValidationContext;

/* loaded from: classes5.dex */
public class DatatypeAttribute extends AbstractAttribute implements SerializationContext, ValidationContext {
    private Object data;
    private XSDatatype datatype;
    private Element parent;
    private QName qname;
    private String text;

    public String getBaseUri() {
        return null;
    }

    public boolean isNotation(String str) {
        return false;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public boolean isReadOnly() {
        return false;
    }

    public boolean isUnparsedEntity(String str) {
        return true;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public boolean supportsParent() {
        return true;
    }

    public DatatypeAttribute(QName qName, XSDatatype xSDatatype) {
        this.qname = qName;
        this.datatype = xSDatatype;
    }

    public DatatypeAttribute(QName qName, XSDatatype xSDatatype, String str) {
        this.qname = qName;
        this.datatype = xSDatatype;
        this.text = str;
        this.data = convertToValue(str);
    }

    @Override // org.dom4j.tree.AbstractAttribute
    public String toString() {
        return new StringBuffer().append(getClass().getName()).append(hashCode()).append(" [Attribute: name ").append(getQualifiedName()).append(" value \"").append(getValue()).append("\" data: ").append(getData()).append("]").toString();
    }

    public XSDatatype getXSDatatype() {
        return this.datatype;
    }

    public String getNamespacePrefix(String str) {
        Namespace namespaceForURI;
        Element parent = getParent();
        if (parent == null || (namespaceForURI = parent.getNamespaceForURI(str)) == null) {
            return null;
        }
        return namespaceForURI.getPrefix();
    }

    public String resolveNamespacePrefix(String str) {
        Namespace namespaceForPrefix;
        if (str.equals(getNamespacePrefix())) {
            return getNamespaceURI();
        }
        Element parent = getParent();
        if (parent == null || (namespaceForPrefix = parent.getNamespaceForPrefix(str)) == null) {
            return null;
        }
        return namespaceForPrefix.getURI();
    }

    @Override // org.dom4j.Attribute
    public QName getQName() {
        return this.qname;
    }

    @Override // org.dom4j.Attribute
    public String getValue() {
        return this.text;
    }

    @Override // org.dom4j.tree.AbstractAttribute, org.dom4j.Attribute
    public void setValue(String str) {
        validate(str);
        this.text = str;
        this.data = convertToValue(str);
    }

    @Override // org.dom4j.tree.AbstractAttribute, org.dom4j.Attribute
    public Object getData() {
        return this.data;
    }

    @Override // org.dom4j.tree.AbstractAttribute, org.dom4j.Attribute
    public void setData(Object obj) {
        String convertToLexicalValue = this.datatype.convertToLexicalValue(obj, this);
        validate(convertToLexicalValue);
        this.text = convertToLexicalValue;
        this.data = obj;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public Element getParent() {
        return this.parent;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void setParent(Element element) {
        this.parent = element;
    }

    protected void validate(String str) throws IllegalArgumentException {
        try {
            this.datatype.checkValid(str, this);
        } catch (DatatypeException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    protected Object convertToValue(String str) {
        XSDatatype xSDatatype = this.datatype;
        if (xSDatatype instanceof DatabindableDatatype) {
            return xSDatatype.createJavaObject(str, this);
        }
        return xSDatatype.createValue(str, this);
    }
}
