package org.apache.xmlbeans.impl.piccolo.xml;

import org.apache.xmlbeans.impl.piccolo.util.IntStack;
import org.apache.xmlbeans.impl.piccolo.util.StringStack;

/* loaded from: classes5.dex */
public class FastNamespaceSupport {
    public static final String XMLNS = "http://www.w3.org/XML/1998/namespace";
    private String defaultURI;
    private int defaultURIContexts;
    private int prefixCount;
    private int prefixPos;
    private String[] prefixes = new String[20];
    private String[] uris = new String[20];
    private StringStack defaultURIs = new StringStack(20);
    private IntStack contextPrefixCounts = new IntStack(20);
    private IntStack defaultURIContextCounts = new IntStack(20);

    public FastNamespaceSupport() {
        reset();
    }

    public void reset() {
        this.defaultURIs.clear();
        this.contextPrefixCounts.clear();
        this.defaultURIContextCounts.clear();
        this.prefixPos = -1;
        this.defaultURI = "";
        this.prefixCount = 0;
        this.defaultURIContexts = 0;
    }

    public void pushContext() {
        this.defaultURIContexts++;
        this.contextPrefixCounts.push(this.prefixCount);
        this.prefixCount = 0;
    }

    public void popContext() {
        int i = this.defaultURIContexts;
        if (i <= 0) {
            this.defaultURIContexts = this.defaultURIContextCounts.pop();
            this.defaultURI = this.defaultURIs.pop();
        } else {
            this.defaultURIContexts = i - 1;
        }
        this.prefixPos -= this.prefixCount;
        this.prefixCount = this.contextPrefixCounts.pop();
    }

    public void declarePrefix(String str, String str2) {
        if (str.length() == 0) {
            int i = this.defaultURIContexts - 1;
            this.defaultURIContexts = i;
            this.defaultURIContextCounts.push(i);
            this.defaultURIs.push(this.defaultURI);
            this.defaultURIContexts = 0;
            this.defaultURI = str2;
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = this.prefixCount;
            if (i2 < i3) {
                String[] strArr = this.prefixes;
                int i4 = this.prefixPos;
                if (str == strArr[i4 - i2]) {
                    this.uris[i4 - i2] = str2;
                    return;
                }
                i2++;
            } else {
                int i5 = this.prefixPos + 1;
                this.prefixPos = i5;
                this.prefixCount = i3 + 1;
                String[] strArr2 = this.prefixes;
                if (i5 >= strArr2.length) {
                    int length = strArr2.length;
                    int i6 = length * 2;
                    String[] strArr3 = new String[i6];
                    String[] strArr4 = new String[i6];
                    System.arraycopy(strArr2, 0, strArr3, 0, length);
                    System.arraycopy(this.uris, 0, strArr4, 0, length);
                    this.prefixes = strArr3;
                    this.uris = strArr4;
                }
                String[] strArr5 = this.prefixes;
                int i7 = this.prefixPos;
                strArr5[i7] = str;
                this.uris[i7] = str2;
                return;
            }
        }
    }

    public String[] processName(String str, String[] strArr, boolean z) {
        int indexOf = str.indexOf(58);
        strArr[2] = str;
        if (indexOf < 0) {
            strArr[1] = str;
            if (z) {
                strArr[0] = "";
            } else {
                strArr[0] = this.defaultURI;
            }
            return strArr;
        }
        String substring = str.substring(0, indexOf);
        strArr[1] = str.substring(indexOf + 1);
        String uri = getURI(substring);
        strArr[0] = uri;
        if (uri == "") {
            return null;
        }
        return strArr;
    }

    public String getDefaultURI() {
        return this.defaultURI;
    }

    public String getURI(String str) {
        if (str == null || str.length() == 0) {
            return this.defaultURI;
        }
        if (str == "xml") {
            return "http://www.w3.org/XML/1998/namespace";
        }
        for (int i = this.prefixPos; i >= 0; i--) {
            if (str == this.prefixes[i]) {
                return this.uris[i];
            }
        }
        return "";
    }

    public int getContextSize() {
        return this.prefixCount + ((this.defaultURIContexts != 0 || this.defaultURI == "") ? 0 : 1);
    }

    public String getContextPrefix(int i) {
        return (i == this.prefixCount && this.defaultURIContexts == 0 && this.defaultURI != "") ? "" : this.prefixes[this.prefixPos - i];
    }

    public String getContextURI(int i) {
        String str;
        return (i == this.prefixCount && this.defaultURIContexts == 0 && (str = this.defaultURI) != "") ? str : this.uris[this.prefixPos - i];
    }
}
