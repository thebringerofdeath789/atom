package org.apache.xmlbeans.impl.values;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;

/* loaded from: classes5.dex */
public class JavaQNameHolder extends XmlObjectBase {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final NamespaceManager PRETTY_PREFIXER;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$values$JavaQNameHolder;
    private QName _value;

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int get_wscanon_rule() {
        return 1;
    }

    static {
        if (class$org$apache$xmlbeans$impl$values$JavaQNameHolder == null) {
            class$org$apache$xmlbeans$impl$values$JavaQNameHolder = class$("org.apache.xmlbeans.impl.values.JavaQNameHolder");
        }
        $assertionsDisabled = true;
        PRETTY_PREFIXER = new PrettyNamespaceManager();
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_QNAME;
    }

    private static class PrettyNamespaceManager implements NamespaceManager {
        private PrettyNamespaceManager() {
        }

        @Override // org.apache.xmlbeans.impl.values.NamespaceManager
        public String find_prefix_for_nsuri(String str, String str2) {
            return QNameHelper.suggestPrefix(str);
        }

        @Override // org.apache.xmlbeans.impl.common.PrefixResolver
        public String getNamespaceForPrefix(String str) {
            throw new RuntimeException("Should not be called");
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager namespaceManager) {
        if (namespaceManager == null) {
            namespaceManager = PRETTY_PREFIXER;
        }
        String namespaceURI = this._value.getNamespaceURI();
        String localPart = this._value.getLocalPart();
        if (namespaceURI == null || namespaceURI.length() == 0) {
            return localPart;
        }
        String find_prefix_for_nsuri = namespaceManager.find_prefix_for_nsuri(namespaceURI, null);
        if ($assertionsDisabled || find_prefix_for_nsuri != null) {
            return "".equals(find_prefix_for_nsuri) ? localPart : new StringBuffer().append(find_prefix_for_nsuri).append(":").append(localPart).toString();
        }
        throw new AssertionError();
    }

    public static QName validateLexical(String str, ValidationContext validationContext, PrefixResolver prefixResolver) {
        try {
            return parse(str, prefixResolver);
        } catch (XmlValueOutOfRangeException e) {
            validationContext.invalid(e.getMessage());
            return null;
        }
    }

    private static QName parse(String str, PrefixResolver prefixResolver) {
        String substring;
        String str2;
        int length = str.length();
        while (length > 0 && XMLChar.isSpace(str.charAt(length - 1))) {
            length--;
        }
        int i = 0;
        while (i < length && XMLChar.isSpace(str.charAt(i))) {
            i++;
        }
        int indexOf = str.indexOf(58, i);
        String str3 = "";
        if (indexOf >= 0) {
            str2 = str.substring(i, indexOf);
            substring = str.substring(indexOf + 1, length);
        } else {
            substring = str.substring(i, length);
            str2 = "";
        }
        if (str2.length() > 0 && !XMLChar.isValidNCName(str2)) {
            throw new XmlValueOutOfRangeException(XmlErrorCodes.QNAME, new Object[]{new StringBuffer().append("Prefix not a valid NCName in '").append(str).append("'").toString()});
        }
        if (!XMLChar.isValidNCName(substring)) {
            throw new XmlValueOutOfRangeException(XmlErrorCodes.QNAME, new Object[]{new StringBuffer().append("Localname not a valid NCName in '").append(str).append("'").toString()});
        }
        String namespaceForPrefix = prefixResolver == null ? null : prefixResolver.getNamespaceForPrefix(str2);
        if (namespaceForPrefix != null) {
            str3 = namespaceForPrefix;
        } else if (str2.length() > 0) {
            throw new XmlValueOutOfRangeException(XmlErrorCodes.QNAME, new Object[]{new StringBuffer().append("Can't resolve prefix '").append(str2).append("'").toString()});
        }
        if (str2 != null && str2.length() > 0) {
            return new QName(str3, substring, str2);
        }
        return new QName(str3, substring);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        PrefixResolver current = NamespaceContext.getCurrent();
        if (current == null && has_store()) {
            current = get_store();
        }
        this._value = parse(str, current);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_QName(QName qName) {
        if (!$assertionsDisabled && qName == null) {
            throw new AssertionError();
        }
        if (has_store()) {
            get_store().find_prefix_for_nsuri(qName.getNamespaceURI(), null);
        }
        this._value = qName;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_xmlanysimple(XmlAnySimpleType xmlAnySimpleType) {
        this._value = parse(xmlAnySimpleType.getStringValue(), NamespaceContext.getCurrent());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public QName getQNameValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean equal_to(XmlObject xmlObject) {
        return this._value.equals(((XmlObjectBase) xmlObject).qNameValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        return this._value.hashCode();
    }
}
