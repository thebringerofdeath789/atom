package org.xml.sax.helpers;

import java.util.EmptyStackException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* loaded from: classes6.dex */
public class NamespaceSupport {
    private static final Enumeration EMPTY_ENUMERATION = new Vector().elements();
    public static final String XMLNS = "http://www.w3.org/XML/1998/namespace";
    private int contextPos;
    private Context[] contexts;
    private Context currentContext;

    final class Context {
        Hashtable attributeNameTable;
        Hashtable elementNameTable;
        Hashtable prefixTable;
        Hashtable uriTable;
        String defaultNS = null;
        boolean declsOK = true;
        private Vector declarations = null;
        private boolean declSeen = false;
        private Context parent = null;

        Context() {
            copyTables();
        }

        private void copyTables() {
            Hashtable hashtable = this.prefixTable;
            this.prefixTable = hashtable != null ? (Hashtable) hashtable.clone() : new Hashtable();
            Hashtable hashtable2 = this.uriTable;
            this.uriTable = hashtable2 != null ? (Hashtable) hashtable2.clone() : new Hashtable();
            this.elementNameTable = new Hashtable();
            this.attributeNameTable = new Hashtable();
            this.declSeen = true;
        }

        void clear() {
            this.parent = null;
            this.prefixTable = null;
            this.uriTable = null;
            this.elementNameTable = null;
            this.attributeNameTable = null;
            this.defaultNS = null;
        }

        void declarePrefix(String str, String str2) {
            if (!this.declsOK) {
                throw new IllegalStateException("can't declare any more prefixes in this context");
            }
            if (!this.declSeen) {
                copyTables();
            }
            if (this.declarations == null) {
                this.declarations = new Vector();
            }
            String intern = str.intern();
            String intern2 = str2.intern();
            if ("".equals(intern)) {
                if ("".equals(intern2)) {
                    intern2 = null;
                }
                this.defaultNS = intern2;
            } else {
                this.prefixTable.put(intern, intern2);
                this.uriTable.put(intern2, intern);
            }
            this.declarations.addElement(intern);
        }

        Enumeration getDeclaredPrefixes() {
            Vector vector = this.declarations;
            return vector == null ? NamespaceSupport.EMPTY_ENUMERATION : vector.elements();
        }

        String getPrefix(String str) {
            Hashtable hashtable = this.uriTable;
            if (hashtable == null) {
                return null;
            }
            return (String) hashtable.get(str);
        }

        Enumeration getPrefixes() {
            Hashtable hashtable = this.prefixTable;
            return hashtable == null ? NamespaceSupport.EMPTY_ENUMERATION : hashtable.keys();
        }

        String getURI(String str) {
            if ("".equals(str)) {
                return this.defaultNS;
            }
            Hashtable hashtable = this.prefixTable;
            if (hashtable == null) {
                return null;
            }
            return (String) hashtable.get(str);
        }

        String[] processName(String str, boolean z) {
            String str2;
            this.declsOK = false;
            Hashtable hashtable = z ? this.attributeNameTable : this.elementNameTable;
            String[] strArr = (String[]) hashtable.get(str);
            if (strArr != null) {
                return strArr;
            }
            String[] strArr2 = new String[3];
            strArr2[2] = str.intern();
            int indexOf = str.indexOf(58);
            if (indexOf == -1) {
                if (z || (str2 = this.defaultNS) == null) {
                    strArr2[0] = "";
                } else {
                    strArr2[0] = str2;
                }
                strArr2[1] = strArr2[2];
            } else {
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf + 1);
                String str3 = "".equals(substring) ? this.defaultNS : (String) this.prefixTable.get(substring);
                if (str3 == null) {
                    return null;
                }
                strArr2[0] = str3;
                strArr2[1] = substring2.intern();
            }
            hashtable.put(strArr2[2], strArr2);
            return strArr2;
        }

        void setParent(Context context) {
            this.parent = context;
            this.declarations = null;
            this.prefixTable = context.prefixTable;
            this.uriTable = context.uriTable;
            this.elementNameTable = context.elementNameTable;
            this.attributeNameTable = context.attributeNameTable;
            this.defaultNS = context.defaultNS;
            this.declSeen = false;
            this.declsOK = true;
        }
    }

    public NamespaceSupport() {
        reset();
    }

    public boolean declarePrefix(String str, String str2) {
        if (str.equals("xml") || str.equals("xmlns")) {
            return false;
        }
        this.currentContext.declarePrefix(str, str2);
        return true;
    }

    public Enumeration getDeclaredPrefixes() {
        return this.currentContext.getDeclaredPrefixes();
    }

    public String getPrefix(String str) {
        return this.currentContext.getPrefix(str);
    }

    public Enumeration getPrefixes() {
        return this.currentContext.getPrefixes();
    }

    public Enumeration getPrefixes(String str) {
        Vector vector = new Vector();
        Enumeration prefixes = getPrefixes();
        while (prefixes.hasMoreElements()) {
            String str2 = (String) prefixes.nextElement();
            if (str.equals(getURI(str2))) {
                vector.addElement(str2);
            }
        }
        return vector.elements();
    }

    public String getURI(String str) {
        return this.currentContext.getURI(str);
    }

    public void popContext() {
        this.contexts[this.contextPos].clear();
        int i = this.contextPos - 1;
        this.contextPos = i;
        if (i < 0) {
            throw new EmptyStackException();
        }
        this.currentContext = this.contexts[i];
    }

    public String[] processName(String str, String[] strArr, boolean z) {
        String[] processName = this.currentContext.processName(str, z);
        if (processName == null) {
            return null;
        }
        strArr[0] = processName[0];
        strArr[1] = processName[1];
        strArr[2] = processName[2];
        return strArr;
    }

    public void pushContext() {
        Context[] contextArr = this.contexts;
        int length = contextArr.length;
        contextArr[this.contextPos].declsOK = false;
        int i = this.contextPos + 1;
        this.contextPos = i;
        if (i >= length) {
            Context[] contextArr2 = new Context[length * 2];
            System.arraycopy(this.contexts, 0, contextArr2, 0, length);
            this.contexts = contextArr2;
        }
        Context[] contextArr3 = this.contexts;
        int i2 = this.contextPos;
        Context context = contextArr3[i2];
        this.currentContext = context;
        if (context == null) {
            Context context2 = new Context();
            this.currentContext = context2;
            contextArr3[i2] = context2;
        }
        int i3 = this.contextPos;
        if (i3 > 0) {
            this.currentContext.setParent(this.contexts[i3 - 1]);
        }
    }

    public void reset() {
        Context[] contextArr = new Context[32];
        this.contexts = contextArr;
        this.contextPos = 0;
        Context context = new Context();
        this.currentContext = context;
        contextArr[0] = context;
        context.declarePrefix("xml", "http://www.w3.org/XML/1998/namespace");
    }
}
