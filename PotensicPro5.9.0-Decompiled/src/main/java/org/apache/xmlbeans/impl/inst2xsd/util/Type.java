package org.apache.xmlbeans.impl.inst2xsd.util;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.text.StringSubstitutor;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.values.XmlQNameImpl;

/* loaded from: classes5.dex */
public class Type {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final int COMPLEX_TYPE_COMPLEX_CONTENT = 3;
    public static final int COMPLEX_TYPE_EMPTY_CONTENT = 5;
    public static final int COMPLEX_TYPE_MIXED_CONTENT = 4;
    public static final int COMPLEX_TYPE_SIMPLE_CONTENT = 2;
    public static final int PARTICLE_CHOICE_UNBOUNDED = 2;
    public static final int PARTICLE_SEQUENCE = 1;
    public static final int SIMPLE_TYPE_SIMPLE_CONTENT = 1;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$inst2xsd$util$Type;
    private List _attributes;
    private List _elements;
    private List _enumerationQNames;
    private List _enumerationValues;
    private Type _extensionType;
    private QName _name;
    private int _kind = 1;
    private int _topParticleForComplexOrMixedContent = 1;
    private boolean _isGlobal = false;
    private boolean _acceptsEnumerationValue = true;

    static {
        if (class$org$apache$xmlbeans$impl$inst2xsd$util$Type == null) {
            class$org$apache$xmlbeans$impl$inst2xsd$util$Type = class$("org.apache.xmlbeans.impl.inst2xsd.util.Type");
        }
        $assertionsDisabled = true;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    protected Type() {
    }

    public static Type createNamedType(QName qName, int i) {
        if (!$assertionsDisabled && qName == null) {
            throw new AssertionError();
        }
        Type type = new Type();
        type.setName(qName);
        type.setContentType(i);
        return type;
    }

    public static Type createUnnamedType(int i) {
        if (!$assertionsDisabled && i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
            throw new AssertionError(new StringBuffer().append("Unknown contentType: ").append(i).toString());
        }
        Type type = new Type();
        type.setContentType(i);
        return type;
    }

    public QName getName() {
        return this._name;
    }

    public void setName(QName qName) {
        this._name = qName;
    }

    public int getContentType() {
        return this._kind;
    }

    public void setContentType(int i) {
        this._kind = i;
    }

    public List getElements() {
        ensureElements();
        return this._elements;
    }

    public void addElement(Element element) {
        ensureElements();
        this._elements.add(element);
    }

    public void setElements(List list) {
        ensureElements();
        this._elements.clear();
        this._elements.addAll(list);
    }

    private void ensureElements() {
        if (this._elements == null) {
            this._elements = new ArrayList();
        }
    }

    public List getAttributes() {
        ensureAttributes();
        return this._attributes;
    }

    public void addAttribute(Attribute attribute) {
        ensureAttributes();
        this._attributes.add(attribute);
    }

    public Attribute getAttribute(QName qName) {
        for (int i = 0; i < this._attributes.size(); i++) {
            Attribute attribute = (Attribute) this._attributes.get(i);
            if (attribute.getName().equals(qName)) {
                return attribute;
            }
        }
        return null;
    }

    private void ensureAttributes() {
        if (this._attributes == null) {
            this._attributes = new ArrayList();
        }
    }

    public boolean isComplexType() {
        int i = this._kind;
        return i == 3 || i == 4 || i == 2;
    }

    public boolean hasSimpleContent() {
        int i = this._kind;
        return i == 1 || i == 2;
    }

    public int getTopParticleForComplexOrMixedContent() {
        return this._topParticleForComplexOrMixedContent;
    }

    public void setTopParticleForComplexOrMixedContent(int i) {
        this._topParticleForComplexOrMixedContent = i;
    }

    public boolean isGlobal() {
        return this._isGlobal;
    }

    public void setGlobal(boolean z) {
        if (!$assertionsDisabled && (!z || getName() == null)) {
            throw new AssertionError();
        }
        this._isGlobal = z;
    }

    public Type getExtensionType() {
        return this._extensionType;
    }

    public void setExtensionType(Type type) {
        boolean z = $assertionsDisabled;
        if (!z && this._kind != 2) {
            throw new AssertionError("Extension used only for type which are COMPLEX_TYPE_SIMPLE_CONTENT");
        }
        if (!z && (type == null || type.getName() == null)) {
            throw new AssertionError("Extended type must be a named type.");
        }
        this._extensionType = type;
    }

    public List getEnumerationValues() {
        ensureEnumerationValues();
        return this._enumerationValues;
    }

    public List getEnumerationQNames() {
        ensureEnumerationValues();
        return this._enumerationQNames;
    }

    public void addEnumerationValue(String str, final XmlCursor xmlCursor) {
        int i;
        boolean z = $assertionsDisabled;
        if (!z && (i = this._kind) != 1 && i != 2) {
            throw new AssertionError("Enumerations possible only on simple content");
        }
        ensureEnumerationValues();
        if (!this._acceptsEnumerationValue || this._enumerationValues.contains(str)) {
            return;
        }
        this._enumerationValues.add(str);
        if (this._name.equals(XmlQName.type.getName())) {
            QName validateLexical = XmlQNameImpl.validateLexical(str, null, new PrefixResolver() { // from class: org.apache.xmlbeans.impl.inst2xsd.util.Type.1
                @Override // org.apache.xmlbeans.impl.common.PrefixResolver
                public String getNamespaceForPrefix(String str2) {
                    return xmlCursor.namespaceForPrefix(str2);
                }
            });
            if (!z && validateLexical == null) {
                throw new AssertionError("The check for QName should allready have happened.");
            }
            this._enumerationQNames.add(validateLexical);
        }
    }

    private void ensureEnumerationValues() {
        if (this._enumerationValues == null) {
            this._enumerationValues = new ArrayList();
            this._enumerationQNames = new ArrayList();
        }
    }

    public boolean isEnumeration() {
        List list;
        return this._acceptsEnumerationValue && (list = this._enumerationValues) != null && list.size() > 1;
    }

    public boolean isQNameEnumeration() {
        List list;
        return isEnumeration() && this._name.equals(XmlQName.type.getName()) && (list = this._enumerationQNames) != null && list.size() > 1;
    }

    public void closeEnumeration() {
        this._acceptsEnumerationValue = false;
    }

    public String toString() {
        return new StringBuffer().append("Type{_name = ").append(this._name).append(", _extensionType = ").append(this._extensionType).append(", _kind = ").append(this._kind).append(", _elements = ").append(this._elements).append(", _attributes = ").append(this._attributes).append(StringSubstitutor.DEFAULT_VAR_END).toString();
    }

    public void addAllEnumerationsFrom(Type type) {
        int i;
        if (!$assertionsDisabled && (i = this._kind) != 1 && i != 2) {
            throw new AssertionError("Enumerations possible only on simple content");
        }
        ensureEnumerationValues();
        int i2 = 0;
        if (this._name.equals(XmlQName.type.getName()) && type._name.equals(XmlQName.type.getName())) {
            while (i2 < type.getEnumerationValues().size()) {
                String str = (String) type.getEnumerationValues().get(i2);
                QName qName = (QName) type.getEnumerationQNames().get(i2);
                if (this._acceptsEnumerationValue && !this._enumerationQNames.contains(qName)) {
                    this._enumerationValues.add(str);
                    this._enumerationQNames.add(qName);
                }
                i2++;
            }
            return;
        }
        while (i2 < type.getEnumerationValues().size()) {
            String str2 = (String) type.getEnumerationValues().get(i2);
            if (this._acceptsEnumerationValue && !this._enumerationValues.contains(str2)) {
                this._enumerationValues.add(str2);
            }
            i2++;
        }
    }
}
