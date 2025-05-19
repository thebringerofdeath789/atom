package org.apache.xmlbeans;

import aavax.xml.namespace.QName;
import java.math.BigInteger;

/* loaded from: classes5.dex */
public interface SchemaField {
    String getDefaultText();

    XmlAnySimpleType getDefaultValue();

    BigInteger getMaxOccurs();

    BigInteger getMinOccurs();

    QName getName();

    SchemaType getType();

    Object getUserData();

    boolean isAttribute();

    boolean isDefault();

    boolean isFixed();

    boolean isNillable();
}
