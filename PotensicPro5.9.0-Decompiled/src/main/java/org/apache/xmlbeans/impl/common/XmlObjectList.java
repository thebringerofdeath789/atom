package org.apache.xmlbeans.impl.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;

/* loaded from: classes5.dex */
public class XmlObjectList {
    private final XmlObject[] _objects;

    public XmlObjectList(int i) {
        this._objects = new XmlObject[i];
    }

    public boolean set(XmlObject xmlObject, int i) {
        XmlObject[] xmlObjectArr = this._objects;
        if (xmlObjectArr[i] != null) {
            return false;
        }
        xmlObjectArr[i] = xmlObject;
        return true;
    }

    public boolean filled() {
        int i = 0;
        while (true) {
            XmlObject[] xmlObjectArr = this._objects;
            if (i >= xmlObjectArr.length) {
                return true;
            }
            if (xmlObjectArr[i] == null) {
                return false;
            }
            i++;
        }
    }

    public int unfilled() {
        int i = 0;
        while (true) {
            XmlObject[] xmlObjectArr = this._objects;
            if (i >= xmlObjectArr.length) {
                return -1;
            }
            if (xmlObjectArr[i] == null) {
                return i;
            }
            i++;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof XmlObjectList)) {
            return false;
        }
        XmlObjectList xmlObjectList = (XmlObjectList) obj;
        if (xmlObjectList._objects.length != this._objects.length) {
            return false;
        }
        int i = 0;
        while (true) {
            XmlObject[] xmlObjectArr = this._objects;
            if (i >= xmlObjectArr.length) {
                return true;
            }
            if (xmlObjectArr[i] == null) {
                break;
            }
            XmlObject[] xmlObjectArr2 = xmlObjectList._objects;
            if (xmlObjectArr2[i] == null || !xmlObjectArr[i].valueEquals(xmlObjectArr2[i])) {
                return false;
            }
            i++;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            XmlObject[] xmlObjectArr = this._objects;
            if (i >= xmlObjectArr.length) {
                return i2;
            }
            if (xmlObjectArr[i] != null) {
                i2 = (i2 * 31) + xmlObjectArr[i].valueHashCode();
            }
            i++;
        }
    }

    private static String prettytrim(String str) {
        int length = str.length();
        while (length > 0 && XMLChar.isSpace(str.charAt(length - 1))) {
            length--;
        }
        int i = 0;
        while (i < length && XMLChar.isSpace(str.charAt(i))) {
            i++;
        }
        return str.substring(i, length);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this._objects.length; i++) {
            if (i != 0) {
                stringBuffer.append(StringUtils.SPACE);
            }
            stringBuffer.append(prettytrim(((SimpleValue) this._objects[i]).getStringValue()));
        }
        return stringBuffer.toString();
    }
}
