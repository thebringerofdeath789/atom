package org.dom4j.dtd;

import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class AttributeDecl {
    private String attributeName;
    private String elementName;
    private String type;
    private String value;
    private String valueDefault;

    public AttributeDecl() {
    }

    public AttributeDecl(String str, String str2, String str3, String str4, String str5) {
        this.elementName = str;
        this.attributeName = str2;
        this.type = str3;
        this.value = str5;
        this.valueDefault = str4;
    }

    public String getElementName() {
        return this.elementName;
    }

    public void setElementName(String str) {
        this.elementName = str;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public void setAttributeName(String str) {
        this.attributeName = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getValueDefault() {
        return this.valueDefault;
    }

    public void setValueDefault(String str) {
        this.valueDefault = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("<!ATTLIST ");
        stringBuffer.append(this.elementName);
        stringBuffer.append(StringUtils.SPACE);
        stringBuffer.append(this.attributeName);
        stringBuffer.append(StringUtils.SPACE);
        stringBuffer.append(this.type);
        stringBuffer.append(StringUtils.SPACE);
        String str = this.valueDefault;
        if (str != null) {
            stringBuffer.append(str);
            if (this.valueDefault.equals("#FIXED")) {
                stringBuffer.append(" \"");
                stringBuffer.append(this.value);
                stringBuffer.append("\"");
            }
        } else {
            stringBuffer.append("\"");
            stringBuffer.append(this.value);
            stringBuffer.append("\"");
        }
        stringBuffer.append(">");
        return stringBuffer.toString();
    }
}
