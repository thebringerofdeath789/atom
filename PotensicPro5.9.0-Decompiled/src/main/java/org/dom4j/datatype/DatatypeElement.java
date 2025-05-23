package org.dom4j.datatype;

import com.sun.msv.datatype.DatabindableDatatype;
import com.sun.msv.datatype.SerializationContext;
import com.sun.msv.datatype.xsd.XSDatatype;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.Node;
import org.dom4j.QName;
import org.dom4j.tree.DefaultElement;
import org.relaxng.datatype.DatatypeException;
import org.relaxng.datatype.ValidationContext;

/* loaded from: classes5.dex */
public class DatatypeElement extends DefaultElement implements SerializationContext, ValidationContext {
    private Object data;
    private XSDatatype datatype;

    public String getBaseUri() {
        return null;
    }

    public boolean isNotation(String str) {
        return false;
    }

    public boolean isUnparsedEntity(String str) {
        return true;
    }

    public DatatypeElement(QName qName, XSDatatype xSDatatype) {
        super(qName);
        this.datatype = xSDatatype;
    }

    public DatatypeElement(QName qName, int i, XSDatatype xSDatatype) {
        super(qName, i);
        this.datatype = xSDatatype;
    }

    @Override // org.dom4j.tree.AbstractElement
    public String toString() {
        return new StringBuffer().append(getClass().getName()).append(hashCode()).append(" [Element: <").append(getQualifiedName()).append(" attributes: ").append(attributeList()).append(" data: ").append(getData()).append(" />]").toString();
    }

    public XSDatatype getXSDatatype() {
        return this.datatype;
    }

    public String getNamespacePrefix(String str) {
        Namespace namespaceForURI = getNamespaceForURI(str);
        if (namespaceForURI != null) {
            return namespaceForURI.getPrefix();
        }
        return null;
    }

    public String resolveNamespacePrefix(String str) {
        Namespace namespaceForPrefix = getNamespaceForPrefix(str);
        if (namespaceForPrefix != null) {
            return namespaceForPrefix.getURI();
        }
        return null;
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.Element
    public Object getData() {
        String textTrim;
        if (this.data == null && (textTrim = getTextTrim()) != null && textTrim.length() > 0) {
            XSDatatype xSDatatype = this.datatype;
            if (xSDatatype instanceof DatabindableDatatype) {
                this.data = xSDatatype.createJavaObject(textTrim, this);
            } else {
                this.data = xSDatatype.createValue(textTrim, this);
            }
        }
        return this.data;
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.Element
    public void setData(Object obj) {
        String convertToLexicalValue = this.datatype.convertToLexicalValue(obj, this);
        validate(convertToLexicalValue);
        this.data = obj;
        setText(convertToLexicalValue);
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.Element
    public Element addText(String str) {
        validate(str);
        return super.addText(str);
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void setText(String str) {
        validate(str);
        super.setText(str);
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.tree.AbstractBranch
    protected void childAdded(Node node) {
        this.data = null;
        super.childAdded(node);
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.tree.AbstractBranch
    protected void childRemoved(Node node) {
        this.data = null;
        super.childRemoved(node);
    }

    protected void validate(String str) throws IllegalArgumentException {
        try {
            this.datatype.checkValid(str, this);
        } catch (DatatypeException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
