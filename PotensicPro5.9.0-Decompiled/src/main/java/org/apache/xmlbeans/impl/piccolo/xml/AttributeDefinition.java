package org.apache.xmlbeans.impl.piccolo.xml;

import org.apache.xmlbeans.XmlErrorCodes;

/* loaded from: classes5.dex */
public final class AttributeDefinition {
    public static final int CDATA = 3;
    public static final int ENTITIES = 8;
    public static final int ENTITY = 7;
    public static final int ENUMERATION = 1;
    public static final int FIXED = 3;
    public static final int ID = 4;
    public static final int IDREF = 5;
    public static final int IDREFS = 6;
    public static final int IMPLIED = 1;
    public static final int NMTOKEN = 9;
    public static final int NMTOKENS = 10;
    public static final int NOTATION = 2;
    public static final int REQUIRED = 2;
    int defaultType;
    String defaultValue;
    String localName;
    String[] possibleValues;
    String prefix;
    String qName;
    int valueType;
    private static final String[] valueTypeStrings = {null, XmlErrorCodes.NMTOKEN, "NOTATION", "CDATA", "ID", "IDREF", "IDREFS", "ENTITY", "ENTITIES", XmlErrorCodes.NMTOKEN, "NMTOKENS"};
    private static final String[] defaultTypeStrings = {null, "#IMPLIED", "#REQUIRED", "#FIXED"};

    public AttributeDefinition(String str, String str2, String str3, int i, String[] strArr, int i2, String str4) {
        this.prefix = str;
        this.localName = str2;
        this.qName = str3;
        this.valueType = i;
        this.possibleValues = strArr;
        this.defaultType = i2;
        this.defaultValue = str4;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getLocalName() {
        return this.localName;
    }

    public String getQName() {
        return this.qName;
    }

    public int getValueType() {
        return this.valueType;
    }

    public String getValueTypeString() {
        return getValueTypeString(this.valueType);
    }

    public static String getValueTypeString(int i) {
        return valueTypeStrings[i];
    }

    public int getDefaultType() {
        return this.defaultType;
    }

    public String getDefaultTypeString() {
        return getDefaultTypeString(this.defaultType);
    }

    public static String getDefaultTypeString(int i) {
        return defaultTypeStrings[i];
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public String[] getPossibleValues() {
        return this.possibleValues;
    }
}
