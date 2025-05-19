package org.xml.sax.helpers;

import org.xml.sax.Attributes;

/* loaded from: classes6.dex */
public class AttributesImpl implements Attributes {
    String[] data;
    int length;

    public AttributesImpl() {
        this.length = 0;
        this.data = null;
    }

    public AttributesImpl(Attributes attributes) {
        setAttributes(attributes);
    }

    private void badIndex(int i) throws ArrayIndexOutOfBoundsException {
        throw new ArrayIndexOutOfBoundsException(new StringBuffer().append("Attempt to modify attribute at illegal index: ").append(i).toString());
    }

    private void ensureCapacity(int i) {
        int i2;
        if (i <= 0) {
            return;
        }
        String[] strArr = this.data;
        if (strArr == null || strArr.length == 0) {
            i2 = 25;
        } else if (strArr.length >= i * 5) {
            return;
        } else {
            i2 = strArr.length;
        }
        while (i2 < i * 5) {
            i2 *= 2;
        }
        String[] strArr2 = new String[i2];
        int i3 = this.length;
        if (i3 > 0) {
            System.arraycopy(this.data, 0, strArr2, 0, i3 * 5);
        }
        this.data = strArr2;
    }

    public void addAttribute(String str, String str2, String str3, String str4, String str5) {
        ensureCapacity(this.length + 1);
        String[] strArr = this.data;
        int i = this.length;
        strArr[i * 5] = str;
        strArr[(i * 5) + 1] = str2;
        strArr[(i * 5) + 2] = str3;
        strArr[(i * 5) + 3] = str4;
        strArr[(i * 5) + 4] = str5;
        this.length = i + 1;
    }

    public void clear() {
        if (this.data != null) {
            for (int i = 0; i < this.length * 5; i++) {
                this.data[i] = null;
            }
        }
        this.length = 0;
    }

    @Override // org.xml.sax.Attributes
    public int getIndex(String str) {
        int i = this.length * 5;
        for (int i2 = 0; i2 < i; i2 += 5) {
            if (this.data[i2 + 2].equals(str)) {
                return i2 / 5;
            }
        }
        return -1;
    }

    @Override // org.xml.sax.Attributes
    public int getIndex(String str, String str2) {
        int i = this.length * 5;
        for (int i2 = 0; i2 < i; i2 += 5) {
            if (this.data[i2].equals(str) && this.data[i2 + 1].equals(str2)) {
                return i2 / 5;
            }
        }
        return -1;
    }

    @Override // org.xml.sax.Attributes, org.xml.sax.AttributeList
    public int getLength() {
        return this.length;
    }

    @Override // org.xml.sax.Attributes
    public String getLocalName(int i) {
        if (i < 0 || i >= this.length) {
            return null;
        }
        return this.data[(i * 5) + 1];
    }

    @Override // org.xml.sax.Attributes
    public String getQName(int i) {
        if (i < 0 || i >= this.length) {
            return null;
        }
        return this.data[(i * 5) + 2];
    }

    @Override // org.xml.sax.Attributes, org.xml.sax.AttributeList
    public String getType(int i) {
        if (i < 0 || i >= this.length) {
            return null;
        }
        return this.data[(i * 5) + 3];
    }

    @Override // org.xml.sax.Attributes, org.xml.sax.AttributeList
    public String getType(String str) {
        int i = this.length * 5;
        for (int i2 = 0; i2 < i; i2 += 5) {
            if (this.data[i2 + 2].equals(str)) {
                return this.data[i2 + 3];
            }
        }
        return null;
    }

    @Override // org.xml.sax.Attributes
    public String getType(String str, String str2) {
        int i = this.length * 5;
        for (int i2 = 0; i2 < i; i2 += 5) {
            if (this.data[i2].equals(str) && this.data[i2 + 1].equals(str2)) {
                return this.data[i2 + 3];
            }
        }
        return null;
    }

    @Override // org.xml.sax.Attributes
    public String getURI(int i) {
        if (i < 0 || i >= this.length) {
            return null;
        }
        return this.data[i * 5];
    }

    @Override // org.xml.sax.Attributes, org.xml.sax.AttributeList
    public String getValue(int i) {
        if (i < 0 || i >= this.length) {
            return null;
        }
        return this.data[(i * 5) + 4];
    }

    @Override // org.xml.sax.Attributes, org.xml.sax.AttributeList
    public String getValue(String str) {
        int i = this.length * 5;
        for (int i2 = 0; i2 < i; i2 += 5) {
            if (this.data[i2 + 2].equals(str)) {
                return this.data[i2 + 4];
            }
        }
        return null;
    }

    @Override // org.xml.sax.Attributes
    public String getValue(String str, String str2) {
        int i = this.length * 5;
        for (int i2 = 0; i2 < i; i2 += 5) {
            if (this.data[i2].equals(str) && this.data[i2 + 1].equals(str2)) {
                return this.data[i2 + 4];
            }
        }
        return null;
    }

    public void removeAttribute(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.length)) {
            badIndex(i);
            return;
        }
        if (i < i2 - 1) {
            String[] strArr = this.data;
            System.arraycopy(strArr, (i + 1) * 5, strArr, i * 5, ((i2 - i) - 1) * 5);
        }
        int i3 = this.length;
        int i4 = (i3 - 1) * 5;
        String[] strArr2 = this.data;
        int i5 = i4 + 1;
        strArr2[i4] = null;
        int i6 = i5 + 1;
        strArr2[i5] = null;
        int i7 = i6 + 1;
        strArr2[i6] = null;
        strArr2[i7] = null;
        strArr2[i7 + 1] = null;
        this.length = i3 - 1;
    }

    public void setAttribute(int i, String str, String str2, String str3, String str4, String str5) {
        if (i < 0 || i >= this.length) {
            badIndex(i);
            return;
        }
        String[] strArr = this.data;
        int i2 = i * 5;
        strArr[i2] = str;
        strArr[i2 + 1] = str2;
        strArr[i2 + 2] = str3;
        strArr[i2 + 3] = str4;
        strArr[i2 + 4] = str5;
    }

    public void setAttributes(Attributes attributes) {
        clear();
        int length = attributes.getLength();
        this.length = length;
        if (length > 0) {
            this.data = new String[length * 5];
            for (int i = 0; i < this.length; i++) {
                int i2 = i * 5;
                this.data[i2] = attributes.getURI(i);
                this.data[i2 + 1] = attributes.getLocalName(i);
                this.data[i2 + 2] = attributes.getQName(i);
                this.data[i2 + 3] = attributes.getType(i);
                this.data[i2 + 4] = attributes.getValue(i);
            }
        }
    }

    public void setLocalName(int i, String str) {
        if (i < 0 || i >= this.length) {
            badIndex(i);
        } else {
            this.data[(i * 5) + 1] = str;
        }
    }

    public void setQName(int i, String str) {
        if (i < 0 || i >= this.length) {
            badIndex(i);
        } else {
            this.data[(i * 5) + 2] = str;
        }
    }

    public void setType(int i, String str) {
        if (i < 0 || i >= this.length) {
            badIndex(i);
        } else {
            this.data[(i * 5) + 3] = str;
        }
    }

    public void setURI(int i, String str) {
        if (i < 0 || i >= this.length) {
            badIndex(i);
        } else {
            this.data[i * 5] = str;
        }
    }

    public void setValue(int i, String str) {
        if (i < 0 || i >= this.length) {
            badIndex(i);
        } else {
            this.data[(i * 5) + 4] = str;
        }
    }
}
