package org.apache.poi.ddf;

import org.apache.poi.util.HexDump;

/* loaded from: classes4.dex */
public class EscherBoolProperty extends EscherSimpleProperty {
    public EscherBoolProperty(short s, int i) {
        super(s, i);
    }

    public boolean isTrue() {
        return this.propertyValue != 0;
    }

    public boolean isFalse() {
        return this.propertyValue == 0;
    }

    @Override // org.apache.poi.ddf.EscherSimpleProperty, org.apache.poi.ddf.EscherProperty
    public String toXml(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("<").append(getClass().getSimpleName()).append(" id=\"0x").append(HexDump.toHex(getId())).append("\" name=\"").append(getName()).append("\" simpleValue=\"").append(getPropertyValue()).append("\" blipId=\"").append(isBlipId()).append("\" value=\"").append(isTrue()).append("\"").append("/>\n");
        return sb.toString();
    }
}
