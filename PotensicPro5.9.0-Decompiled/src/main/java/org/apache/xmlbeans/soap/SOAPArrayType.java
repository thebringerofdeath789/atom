package org.apache.xmlbeans.soap;

import aavax.xml.namespace.QName;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.XmlWhitespace;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;

/* loaded from: classes5.dex */
public final class SOAPArrayType {
    private static int[] EMPTY_INT_ARRAY = new int[0];
    private int[] _dimensions;
    private int[] _ranks;
    private QName _type;

    public boolean isSameRankAs(SOAPArrayType sOAPArrayType) {
        if (this._ranks.length != sOAPArrayType._ranks.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int[] iArr = this._ranks;
            if (i >= iArr.length) {
                return this._dimensions.length == sOAPArrayType._dimensions.length;
            }
            if (iArr[i] != sOAPArrayType._ranks[i]) {
                return false;
            }
            i++;
        }
    }

    public static int[] parseSoap11Index(String str) {
        String collapse = XmlWhitespace.collapse(str, 3);
        if (!collapse.startsWith("[") || !collapse.endsWith("]")) {
            throw new IllegalArgumentException("Misformed SOAP 1.1 index: must be contained in braces []");
        }
        return internalParseCommaIntString(collapse.substring(1, collapse.length() - 1));
    }

    private static int[] internalParseCommaIntString(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf(44, i2);
            if (indexOf < 0) {
                break;
            }
            arrayList.add(str.substring(i2, indexOf));
            i2 = indexOf + 1;
        }
        arrayList.add(str.substring(i2));
        int[] iArr = new int[arrayList.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String collapse = XmlWhitespace.collapse((String) it.next(), 3);
            if (collapse.equals(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD) || collapse.equals("")) {
                iArr[i] = -1;
            } else {
                try {
                    iArr[i] = Integer.parseInt(collapse);
                } catch (Exception unused) {
                    throw new XmlValueOutOfRangeException("Malformed integer in SOAP array index");
                }
            }
            i++;
        }
        return iArr;
    }

    public SOAPArrayType(String str, PrefixResolver prefixResolver) {
        int indexOf = str.indexOf(91);
        if (indexOf < 0) {
            throw new XmlValueOutOfRangeException();
        }
        String collapse = XmlWhitespace.collapse(str.substring(0, indexOf), 3);
        int indexOf2 = collapse.indexOf(58);
        String namespaceForPrefix = prefixResolver.getNamespaceForPrefix(indexOf2 >= 0 ? collapse.substring(0, indexOf2) : "");
        if (namespaceForPrefix == null) {
            throw new XmlValueOutOfRangeException();
        }
        this._type = QNameHelper.forLNS(collapse.substring(indexOf2 + 1), namespaceForPrefix);
        initDimensions(str, indexOf);
    }

    public SOAPArrayType(QName qName, String str) {
        int indexOf = str.indexOf(91);
        if (indexOf < 0) {
            this._type = qName;
            this._ranks = EMPTY_INT_ARRAY;
            String[] split = XmlWhitespace.collapse(str, 3).split(StringUtils.SPACE);
            for (int i = 0; i < split.length; i++) {
                if (split[i].equals(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
                    this._dimensions[i] = -1;
                } else {
                    try {
                        this._dimensions[i] = Integer.parseInt(split[i]);
                    } catch (Exception unused) {
                        throw new XmlValueOutOfRangeException();
                    }
                }
            }
            return;
        }
        this._type = qName;
        initDimensions(str, indexOf);
    }

    public SOAPArrayType(SOAPArrayType sOAPArrayType, int[] iArr) {
        this._type = sOAPArrayType._type;
        int[] iArr2 = new int[sOAPArrayType._ranks.length + 1];
        this._ranks = iArr2;
        int[] iArr3 = sOAPArrayType._ranks;
        System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
        this._ranks[r0.length - 1] = sOAPArrayType._dimensions.length;
        int[] iArr4 = new int[iArr.length];
        this._dimensions = iArr4;
        System.arraycopy(iArr, 0, iArr4, 0, iArr.length);
    }

    private void initDimensions(String str, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        while (i >= 0) {
            i2 = str.indexOf(93, i);
            if (i2 < 0) {
                throw new XmlValueOutOfRangeException();
            }
            arrayList.add(str.substring(i + 1, i2));
            i = str.indexOf(91, i2);
        }
        if (!XmlWhitespace.isAllSpace(str.substring(i2 + 1))) {
            throw new XmlValueOutOfRangeException();
        }
        this._ranks = new int[arrayList.size() - 1];
        for (int i3 = 0; i3 < this._ranks.length; i3++) {
            String str2 = (String) arrayList.get(i3);
            int i4 = 0;
            for (int i5 = 0; i5 < str2.length(); i5++) {
                char charAt = str2.charAt(i5);
                if (charAt == ',') {
                    i4++;
                } else if (!XmlWhitespace.isSpace(charAt)) {
                    throw new XmlValueOutOfRangeException();
                }
            }
            this._ranks[i3] = i4 + 1;
        }
        this._dimensions = internalParseCommaIntString((String) arrayList.get(arrayList.size() - 1));
    }

    public QName getQName() {
        return this._type;
    }

    public int[] getRanks() {
        int[] iArr = this._ranks;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    public int[] getDimensions() {
        int[] iArr = this._dimensions;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    public boolean containsNestedArrays() {
        return this._ranks.length > 0;
    }

    public String soap11DimensionString() {
        return soap11DimensionString(this._dimensions);
    }

    public String soap11DimensionString(int[] iArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this._ranks.length; i++) {
            stringBuffer.append(PropertyUtils.INDEXED_DELIM);
            for (int i2 = 1; i2 < this._ranks[i]; i2++) {
                stringBuffer.append(',');
            }
            stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
        }
        stringBuffer.append(PropertyUtils.INDEXED_DELIM);
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (i3 > 0) {
                stringBuffer.append(',');
            }
            if (iArr[i3] >= 0) {
                stringBuffer.append(iArr[i3]);
            }
        }
        stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
        return stringBuffer.toString();
    }

    private SOAPArrayType() {
    }

    public static SOAPArrayType newSoap12Array(QName qName, String str) {
        int[] iArr = EMPTY_INT_ARRAY;
        String[] split = XmlWhitespace.collapse(str, 3).split(StringUtils.SPACE);
        int[] iArr2 = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            String str2 = split[i];
            if (i == 0 && str2.equals(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
                iArr2[i] = -1;
            } else {
                try {
                    iArr2[i] = Integer.parseInt(split[i]);
                } catch (Exception unused) {
                    throw new XmlValueOutOfRangeException();
                }
            }
        }
        SOAPArrayType sOAPArrayType = new SOAPArrayType();
        sOAPArrayType._ranks = iArr;
        sOAPArrayType._type = qName;
        sOAPArrayType._dimensions = iArr2;
        return sOAPArrayType;
    }

    public String soap12DimensionString(int[] iArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(' ');
            }
            if (iArr[i] >= 0) {
                stringBuffer.append(iArr[i]);
            }
        }
        return stringBuffer.toString();
    }

    public SOAPArrayType nestedArrayType() {
        if (!containsNestedArrays()) {
            throw new IllegalStateException();
        }
        SOAPArrayType sOAPArrayType = new SOAPArrayType();
        sOAPArrayType._type = this._type;
        int[] iArr = new int[this._ranks.length - 1];
        sOAPArrayType._ranks = iArr;
        int i = 0;
        System.arraycopy(this._ranks, 0, iArr, 0, iArr.length);
        sOAPArrayType._dimensions = new int[this._ranks[r1.length - 1]];
        while (true) {
            int[] iArr2 = sOAPArrayType._dimensions;
            if (i >= iArr2.length) {
                return sOAPArrayType;
            }
            iArr2[i] = -1;
            i++;
        }
    }

    public int hashCode() {
        int hashCode = this._type.hashCode();
        int[] iArr = this._dimensions;
        return hashCode + iArr.length + this._ranks.length + (iArr.length != 0 ? iArr[0] : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        SOAPArrayType sOAPArrayType = (SOAPArrayType) obj;
        if (!this._type.equals(sOAPArrayType._type) || this._ranks.length != sOAPArrayType._ranks.length || this._dimensions.length != sOAPArrayType._dimensions.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int[] iArr = this._ranks;
            if (i >= iArr.length) {
                int i2 = 0;
                while (true) {
                    int[] iArr2 = this._dimensions;
                    if (i2 >= iArr2.length) {
                        return true;
                    }
                    if (iArr2[i2] != sOAPArrayType._dimensions[i2]) {
                        return false;
                    }
                    i2++;
                }
            } else {
                if (iArr[i] != sOAPArrayType._ranks[i]) {
                    return false;
                }
                i++;
            }
        }
    }
}
