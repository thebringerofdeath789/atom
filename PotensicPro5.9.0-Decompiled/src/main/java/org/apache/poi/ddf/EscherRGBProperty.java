package org.apache.poi.ddf;

import org.apache.poi.util.HexDump;

/* loaded from: classes4.dex */
public class EscherRGBProperty extends EscherSimpleProperty {
    public EscherRGBProperty(short s, int i) {
        super(s, i);
    }

    public int getRgbColor() {
        return this.propertyValue;
    }

    public byte getRed() {
        return (byte) (this.propertyValue & 255);
    }

    public byte getGreen() {
        return (byte) ((this.propertyValue >> 8) & 255);
    }

    public byte getBlue() {
        return (byte) ((this.propertyValue >> 16) & 255);
    }

    @Override // org.apache.poi.ddf.EscherSimpleProperty, org.apache.poi.ddf.EscherProperty
    public String toXml(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("<").append(getClass().getSimpleName()).append(" id=\"0x").append(HexDump.toHex(getId())).append("\" name=\"").append(getName()).append("\" blipId=\"").append(isBlipId()).append("\" value=\"0x").append(HexDump.toHex(this.propertyValue)).append("\"/>\n");
        return sb.toString();
    }
}
