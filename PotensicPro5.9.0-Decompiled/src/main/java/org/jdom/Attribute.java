package org.jdom;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes5.dex */
public class Attribute implements Serializable, Cloneable {
    public static final int CDATA_TYPE = 1;
    private static final String CVS_ID = "@(#) $RCSfile: Attribute.java,v $ $Revision: 1.52 $ $Date: 2004/03/01 23:58:28 $ $Name: jdom_1_0 $";
    public static final int ENTITIES_TYPE = 6;
    public static final int ENTITY_TYPE = 5;
    public static final int ENUMERATED_TYPE = 10;
    public static final int IDREFS_TYPE = 4;
    public static final int IDREF_TYPE = 3;
    public static final int ID_TYPE = 2;
    public static final int NMTOKENS_TYPE = 8;
    public static final int NMTOKEN_TYPE = 7;
    public static final int NOTATION_TYPE = 9;
    public static final int UNDECLARED_TYPE = 0;
    protected String name;
    protected transient Namespace namespace;
    protected Object parent;
    protected int type;
    protected String value;

    public final boolean equals(Object obj) {
        return obj == this;
    }

    protected Attribute() {
        this.type = 0;
    }

    public Attribute(String str, String str2, Namespace namespace) {
        this.type = 0;
        setName(str);
        setValue(str2);
        setNamespace(namespace);
    }

    public Attribute(String str, String str2, int i, Namespace namespace) {
        this.type = 0;
        setName(str);
        setValue(str2);
        setAttributeType(i);
        setNamespace(namespace);
    }

    public Attribute(String str, String str2) {
        this(str, str2, 0, Namespace.NO_NAMESPACE);
    }

    public Attribute(String str, String str2, int i) {
        this(str, str2, i, Namespace.NO_NAMESPACE);
    }

    public Element getParent() {
        return (Element) this.parent;
    }

    public Document getDocument() {
        Object obj = this.parent;
        if (obj != null) {
            return ((Element) obj).getDocument();
        }
        return null;
    }

    protected Attribute setParent(Element element) {
        this.parent = element;
        return this;
    }

    public Attribute detach() {
        Element parent = getParent();
        if (parent != null) {
            parent.removeAttribute(getName(), getNamespace());
        }
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Attribute setName(String str) {
        String checkAttributeName = Verifier.checkAttributeName(str);
        if (checkAttributeName != null) {
            throw new IllegalNameException(str, "attribute", checkAttributeName);
        }
        this.name = str;
        return this;
    }

    public String getQualifiedName() {
        String prefix = this.namespace.getPrefix();
        if (prefix != null && !prefix.equals("")) {
            return new StringBuffer(prefix).append(NameUtil.COLON).append(getName()).toString();
        }
        return getName();
    }

    public String getNamespacePrefix() {
        return this.namespace.getPrefix();
    }

    public String getNamespaceURI() {
        return this.namespace.getURI();
    }

    public Namespace getNamespace() {
        return this.namespace;
    }

    public Attribute setNamespace(Namespace namespace) {
        if (namespace == null) {
            namespace = Namespace.NO_NAMESPACE;
        }
        if (namespace != Namespace.NO_NAMESPACE && namespace.getPrefix().equals("")) {
            throw new IllegalNameException("", "attribute namespace", "An attribute namespace without a prefix can only be the NO_NAMESPACE namespace");
        }
        this.namespace = namespace;
        return this;
    }

    public String getValue() {
        return this.value;
    }

    public Attribute setValue(String str) {
        String checkCharacterData = Verifier.checkCharacterData(str);
        if (checkCharacterData != null) {
            throw new IllegalDataException(str, "attribute", checkCharacterData);
        }
        this.value = str;
        return this;
    }

    public int getAttributeType() {
        return this.type;
    }

    public Attribute setAttributeType(int i) {
        if (i < 0 || i > 10) {
            throw new IllegalDataException(String.valueOf(i), "attribute", "Illegal attribute type");
        }
        this.type = i;
        return this;
    }

    public String toString() {
        return new StringBuffer().append("[Attribute: ").append(getQualifiedName()).append("=\"").append(this.value).append("\"").append("]").toString();
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public Object clone() {
        Attribute attribute;
        try {
            attribute = (Attribute) super.clone();
        } catch (CloneNotSupportedException unused) {
            attribute = null;
        }
        attribute.parent = null;
        return attribute;
    }

    public int getIntValue() throws DataConversionException {
        try {
            return Integer.parseInt(this.value.trim());
        } catch (NumberFormatException unused) {
            throw new DataConversionException(this.name, XmlErrorCodes.INT);
        }
    }

    public long getLongValue() throws DataConversionException {
        try {
            return Long.parseLong(this.value.trim());
        } catch (NumberFormatException unused) {
            throw new DataConversionException(this.name, XmlErrorCodes.LONG);
        }
    }

    public float getFloatValue() throws DataConversionException {
        try {
            return Float.valueOf(this.value.trim()).floatValue();
        } catch (NumberFormatException unused) {
            throw new DataConversionException(this.name, XmlErrorCodes.FLOAT);
        }
    }

    public double getDoubleValue() throws DataConversionException {
        try {
            return Double.valueOf(this.value.trim()).doubleValue();
        } catch (NumberFormatException unused) {
            throw new DataConversionException(this.name, XmlErrorCodes.DOUBLE);
        }
    }

    public boolean getBooleanValue() throws DataConversionException {
        String trim = this.value.trim();
        if (trim.equalsIgnoreCase(BooleanUtils.TRUE) || trim.equalsIgnoreCase("on") || trim.equalsIgnoreCase("1") || trim.equalsIgnoreCase(BooleanUtils.YES)) {
            return true;
        }
        if (trim.equalsIgnoreCase("false") || trim.equalsIgnoreCase("off") || trim.equalsIgnoreCase(SessionDescription.SUPPORTED_SDP_VERSION) || trim.equalsIgnoreCase(BooleanUtils.NO)) {
            return false;
        }
        throw new DataConversionException(this.name, XmlErrorCodes.BOOLEAN);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.namespace.getPrefix());
        objectOutputStream.writeObject(this.namespace.getURI());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.namespace = Namespace.getNamespace((String) objectInputStream.readObject(), (String) objectInputStream.readObject());
    }
}
