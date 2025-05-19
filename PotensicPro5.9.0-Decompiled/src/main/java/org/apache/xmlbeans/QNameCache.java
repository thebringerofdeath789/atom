package org.apache.xmlbeans;

import aavax.xml.namespace.QName;

/* loaded from: classes5.dex */
public final class QNameCache {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final float DEFAULT_LOAD = 0.7f;
    static /* synthetic */ Class class$org$apache$xmlbeans$QNameCache;
    private int hashmask;
    private final float loadFactor;
    private int numEntries;
    private QName[] table;
    private int threshold;

    static {
        if (class$org$apache$xmlbeans$QNameCache == null) {
            class$org$apache$xmlbeans$QNameCache = class$("org.apache.xmlbeans.QNameCache");
        }
        $assertionsDisabled = true;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public QNameCache(int i, float f) {
        this.numEntries = 0;
        boolean z = $assertionsDisabled;
        if (!z && i <= 0) {
            throw new AssertionError();
        }
        if (!z && (f <= 0.0f || f >= 1.0f)) {
            throw new AssertionError();
        }
        int i2 = 16;
        while (i2 < i) {
            i2 <<= 1;
        }
        this.loadFactor = f;
        this.hashmask = i2 - 1;
        this.threshold = (int) (i2 * f);
        this.table = new QName[i2];
    }

    public QNameCache(int i) {
        this(i, 0.7f);
    }

    public QName getName(String str, String str2) {
        return getName(str, str2, "");
    }

    public QName getName(String str, String str2, String str3) {
        if (!$assertionsDisabled && str2 == null) {
            throw new AssertionError();
        }
        if (str == null) {
            str = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        int hash = hash(str, str2, str3);
        int i = this.hashmask;
        while (true) {
            int i2 = hash & i;
            QName qName = this.table[i2];
            if (qName == null) {
                int i3 = this.numEntries + 1;
                this.numEntries = i3;
                if (i3 >= this.threshold) {
                    rehash();
                }
                QName[] qNameArr = this.table;
                QName qName2 = new QName(str, str2, str3);
                qNameArr[i2] = qName2;
                return qName2;
            }
            if (equals(qName, str, str2, str3)) {
                return qName;
            }
            hash = i2 - 1;
            i = this.hashmask;
        }
    }

    private void rehash() {
        int i;
        int length = this.table.length * 2;
        QName[] qNameArr = new QName[length];
        int i2 = length - 1;
        int i3 = 0;
        while (true) {
            QName[] qNameArr2 = this.table;
            if (i3 < qNameArr2.length) {
                QName qName = qNameArr2[i3];
                if (qName != null) {
                    int hash = hash(qName.getNamespaceURI(), qName.getLocalPart(), qName.getPrefix());
                    while (true) {
                        i = hash & i2;
                        if (qNameArr[i] == null) {
                            break;
                        } else {
                            hash = i - 1;
                        }
                    }
                    qNameArr[i] = qName;
                }
                i3++;
            } else {
                this.table = qNameArr;
                this.hashmask = i2;
                this.threshold = (int) (length * this.loadFactor);
                return;
            }
        }
    }

    private static int hash(String str, String str2, String str3) {
        return (str3.hashCode() << 10) + 0 + (str.hashCode() << 5) + str2.hashCode();
    }

    private static boolean equals(QName qName, String str, String str2, String str3) {
        return qName.getLocalPart().equals(str2) && qName.getNamespaceURI().equals(str) && qName.getPrefix().equals(str3);
    }
}
