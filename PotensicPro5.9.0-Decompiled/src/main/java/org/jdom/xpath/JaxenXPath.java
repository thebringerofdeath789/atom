package org.jdom.xpath;

import java.util.List;
import org.jaxen.JaxenException;
import org.jaxen.SimpleNamespaceContext;
import org.jaxen.SimpleVariableContext;
import org.jaxen.jdom.JDOMXPath;
import org.jdom.Attribute;
import org.jdom.Content;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;

/* loaded from: classes5.dex */
class JaxenXPath extends XPath {
    private static final String CVS_ID = "@(#) $RCSfile: JaxenXPath.java,v $ $Revision: 1.19 $ $Date: 2004/09/03 07:27:39 $ $Name: jdom_1_0 $";
    private Object currentContext;
    private transient JDOMXPath xPath;

    public JaxenXPath(String str) throws JDOMException {
        setXPath(str);
    }

    @Override // org.jdom.xpath.XPath
    public List selectNodes(Object obj) throws JDOMException {
        try {
            try {
                this.currentContext = obj;
                return this.xPath.selectNodes(obj);
            } catch (JaxenException e) {
                throw new JDOMException(new StringBuffer("XPath error while evaluating \"").append(this.xPath.toString()).append("\": ").append(e.getMessage()).toString(), e);
            }
        } finally {
            this.currentContext = null;
        }
    }

    @Override // org.jdom.xpath.XPath
    public Object selectSingleNode(Object obj) throws JDOMException {
        try {
            try {
                this.currentContext = obj;
                return this.xPath.selectSingleNode(obj);
            } catch (JaxenException e) {
                throw new JDOMException(new StringBuffer("XPath error while evaluating \"").append(this.xPath.toString()).append("\": ").append(e.getMessage()).toString(), e);
            }
        } finally {
            this.currentContext = null;
        }
    }

    @Override // org.jdom.xpath.XPath
    public String valueOf(Object obj) throws JDOMException {
        try {
            try {
                this.currentContext = obj;
                return this.xPath.stringValueOf(obj);
            } catch (JaxenException e) {
                throw new JDOMException(new StringBuffer("XPath error while evaluating \"").append(this.xPath.toString()).append("\": ").append(e.getMessage()).toString(), e);
            }
        } finally {
            this.currentContext = null;
        }
    }

    @Override // org.jdom.xpath.XPath
    public Number numberValueOf(Object obj) throws JDOMException {
        try {
            try {
                this.currentContext = obj;
                return this.xPath.numberValueOf(obj);
            } catch (JaxenException e) {
                throw new JDOMException(new StringBuffer("XPath error while evaluating \"").append(this.xPath.toString()).append("\": ").append(e.getMessage()).toString(), e);
            }
        } finally {
            this.currentContext = null;
        }
    }

    @Override // org.jdom.xpath.XPath
    public void setVariable(String str, Object obj) throws IllegalArgumentException {
        SimpleVariableContext variableContext = this.xPath.getVariableContext();
        if (variableContext instanceof SimpleVariableContext) {
            variableContext.setVariableValue((String) null, str, obj);
        }
    }

    @Override // org.jdom.xpath.XPath
    public void addNamespace(Namespace namespace) {
        try {
            this.xPath.addNamespace(namespace.getPrefix(), namespace.getURI());
        } catch (JaxenException unused) {
        }
    }

    @Override // org.jdom.xpath.XPath
    public String getXPath() {
        return this.xPath.toString();
    }

    private void setXPath(String str) throws JDOMException {
        try {
            JDOMXPath jDOMXPath = new JDOMXPath(str);
            this.xPath = jDOMXPath;
            jDOMXPath.setNamespaceContext(new NSContext());
        } catch (Exception e) {
            throw new JDOMException(new StringBuffer("Invalid XPath expression: \"").append(str).append("\"").toString(), e);
        }
    }

    public String toString() {
        return this.xPath.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof JaxenXPath) {
            return super.equals(obj) && this.xPath.toString().equals(((JaxenXPath) obj).xPath.toString());
        }
        return false;
    }

    public int hashCode() {
        return this.xPath.hashCode();
    }

    private class NSContext extends SimpleNamespaceContext {
        public NSContext() {
        }

        public String translateNamespacePrefixToUri(String str) {
            Object obj;
            Namespace namespace;
            Element element = null;
            if (str == null || str.length() == 0) {
                return null;
            }
            String translateNamespacePrefixToUri = super.translateNamespacePrefixToUri(str);
            if (translateNamespacePrefixToUri != null || (obj = JaxenXPath.this.currentContext) == null) {
                return translateNamespacePrefixToUri;
            }
            if (obj instanceof Element) {
                element = (Element) obj;
            } else if (obj instanceof Attribute) {
                element = ((Attribute) obj).getParent();
            } else if (obj instanceof Content) {
                element = ((Content) obj).getParentElement();
            } else if (obj instanceof Document) {
                element = ((Document) obj).getRootElement();
            }
            return (element == null || (namespace = element.getNamespace(str)) == null) ? translateNamespacePrefixToUri : namespace.getURI();
        }
    }
}
