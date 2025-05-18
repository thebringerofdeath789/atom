package com.bea.xml.stream;

import aavax.xml.namespace.NamespaceContext;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ReadOnlyNamespaceContextBase implements NamespaceContext {
    private String[] prefixes;
    private String[] uris;

    private String checkNull(String str) {
        return str == null ? "" : str;
    }

    public ReadOnlyNamespaceContextBase(String[] strArr, String[] strArr2, int i) {
        String[] strArr3 = new String[i];
        this.prefixes = strArr3;
        this.uris = new String[i];
        System.arraycopy(strArr, 0, strArr3, 0, strArr3.length);
        String[] strArr4 = this.uris;
        System.arraycopy(strArr2, 0, strArr4, 0, strArr4.length);
    }

    @Override // aavax.xml.namespace.NamespaceContext
    public String getNamespaceURI(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Prefix may not be null.");
        }
        if (str.length() > 0) {
            for (int length = this.uris.length - 1; length >= 0; length--) {
                if (str.equals(this.prefixes[length])) {
                    return this.uris[length];
                }
            }
            if ("xml".equals(str)) {
                return "http://www.w3.org/XML/1998/namespace";
            }
            if ("xmlns".equals(str)) {
                return "http://www.w3.org/2000/xmlns/";
            }
            return null;
        }
        for (int length2 = this.uris.length - 1; length2 >= 0; length2--) {
            if (this.prefixes[length2] == null) {
                return this.uris[length2];
            }
        }
        return null;
    }

    @Override // aavax.xml.namespace.NamespaceContext
    public String getPrefix(String str) {
        if (str == null) {
            throw new IllegalArgumentException("uri may not be null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("uri may not be empty string");
        }
        for (int length = this.uris.length - 1; length >= 0; length--) {
            if (str.equals(this.uris[length])) {
                String str2 = this.prefixes[length];
                if (str2 == null) {
                    for (int length2 = this.uris.length - 1; length2 > length; length2--) {
                        if (this.prefixes[length2] == null) {
                            break;
                        }
                    }
                    return "";
                }
                for (int length3 = this.uris.length - 1; length3 > length; length3--) {
                    if (str2.equals(this.prefixes[length3])) {
                        break;
                    }
                }
                return str2;
            }
        }
        if ("http://www.w3.org/XML/1998/namespace".equals(str)) {
            return "xml";
        }
        if ("http://www.w3.org/2000/xmlns/".equals(str)) {
            return "xmlns";
        }
        return null;
    }

    public String getDefaultNameSpace() {
        for (int length = this.uris.length - 1; length >= 0; length--) {
            if (this.prefixes[length] == null) {
                return this.uris[length];
            }
        }
        return null;
    }

    @Override // aavax.xml.namespace.NamespaceContext
    public Iterator getPrefixes(String str) {
        if (str == null) {
            throw new IllegalArgumentException("uri may not be null");
        }
        if ("".equals(str)) {
            throw new IllegalArgumentException("uri may not be empty string");
        }
        HashSet hashSet = new HashSet();
        for (int length = this.uris.length - 1; length >= 0; length--) {
            String checkNull = checkNull(this.prefixes[length]);
            if (str.equals(this.uris[length]) && !hashSet.contains(checkNull)) {
                if (checkNull.length() == 0) {
                    for (int length2 = this.uris.length - 1; length2 > length; length2--) {
                        if (this.prefixes[length2] == null) {
                            break;
                        }
                    }
                    hashSet.add(checkNull);
                } else {
                    for (int length3 = this.uris.length - 1; length3 > length; length3--) {
                        if (checkNull.equals(this.prefixes[length3])) {
                            break;
                        }
                    }
                    hashSet.add(checkNull);
                }
            }
        }
        return hashSet.iterator();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.uris.length; i++) {
            stringBuffer.append(new StringBuffer().append("[").append(checkNull(this.prefixes[i])).append("<->").append(this.uris[i]).append("]").toString());
        }
        return stringBuffer.toString();
    }

    public static void main(String[] strArr) throws Exception {
        MXParser mXParser = new MXParser();
        mXParser.setInput(new FileReader(strArr[0]));
        while (mXParser.hasNext()) {
            if (mXParser.isStartElement()) {
                System.out.println(new StringBuffer().append("context[").append(mXParser.getNamespaceContext()).append("]").toString());
                Iterator prefixes = mXParser.getNamespaceContext().getPrefixes("a");
                while (prefixes.hasNext()) {
                    System.out.println(new StringBuffer().append("Found prefix:").append(prefixes.next()).toString());
                }
            }
            mXParser.next();
        }
    }
}