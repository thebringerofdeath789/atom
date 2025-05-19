package org.apache.xmlbeans.impl.xb.xmlschema.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xmlschema.BaseAttribute;

/* loaded from: classes5.dex */
public class BaseAttributeImpl extends XmlComplexContentImpl implements BaseAttribute {
    private static final QName BASE$0 = new QName("http://www.w3.org/XML/1998/namespace", TtmlNode.RUBY_BASE);

    public BaseAttributeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.BaseAttribute
    public String getBase() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BASE$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.BaseAttribute
    public XmlAnyURI xgetBase() {
        XmlAnyURI xmlAnyURI;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(BASE$0);
        }
        return xmlAnyURI;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.BaseAttribute
    public boolean isSetBase() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BASE$0) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.BaseAttribute
    public void setBase(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BASE$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.BaseAttribute
    public void xsetBase(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BASE$0;
            XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_attribute_user(qName);
            if (xmlAnyURI2 == null) {
                xmlAnyURI2 = (XmlAnyURI) get_store().add_attribute_user(qName);
            }
            xmlAnyURI2.set(xmlAnyURI);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.BaseAttribute
    public void unsetBase() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BASE$0);
        }
    }
}
