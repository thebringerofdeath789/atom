package org.apache.xmlbeans.impl.jam.internal.classrefs;

import java.io.StringWriter;
import org.apache.xmlbeans.impl.jam.JClass;

/* loaded from: classes5.dex */
public class UnqualifiedJClassRef implements JClassRef {
    private static final String PREFIX = "[UnqualifiedJClassRef]";
    private static final boolean VERBOSE = false;
    private JClassRefContext mContext;
    private String mQualifiedClassname = null;
    private String mUnqualifiedClassname;

    public static JClassRef create(String str, JClassRefContext jClassRefContext) {
        throw new IllegalStateException("Unqualified names currently disabled.");
    }

    private UnqualifiedJClassRef(String str, JClassRefContext jClassRefContext) {
        if (jClassRefContext == null) {
            throw new IllegalArgumentException("null ctx");
        }
        if (str == null) {
            throw new IllegalArgumentException("null ucname");
        }
        this.mContext = jClassRefContext;
        this.mUnqualifiedClassname = str;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef
    public JClass getRefClass() {
        return this.mContext.getClassLoader().loadClass(getQualifiedName());
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef
    public String getQualifiedName() {
        String str;
        int i;
        String str2 = this.mQualifiedClassname;
        if (str2 != null) {
            return str2;
        }
        int indexOf = this.mUnqualifiedClassname.indexOf(91);
        if (indexOf != -1) {
            str = this.mUnqualifiedClassname.substring(0, indexOf);
            i = 0;
            do {
                i++;
                indexOf = this.mUnqualifiedClassname.indexOf(91, indexOf + 1);
            } while (indexOf != -1);
        } else {
            str = this.mUnqualifiedClassname;
            i = 0;
        }
        String qualifyName = qualifyName(str);
        if (qualifyName == null) {
            throw new IllegalStateException(new StringBuffer().append("unable to handle unqualified java type reference '").append(str).append(" [").append(this.mUnqualifiedClassname).append("]'. ").append("This is still partially NYI.").toString());
        }
        if (i > 0) {
            StringWriter stringWriter = new StringWriter();
            for (int i2 = 0; i2 < i; i2++) {
                stringWriter.write(91);
            }
            stringWriter.write(76);
            stringWriter.write(qualifyName);
            stringWriter.write(59);
            this.mQualifiedClassname = stringWriter.toString();
        } else {
            this.mQualifiedClassname = qualifyName;
        }
        return this.mQualifiedClassname;
    }

    private String qualifyName(String str) {
        String checkExplicitImport = checkExplicitImport(str);
        if (checkExplicitImport != null) {
            return checkExplicitImport;
        }
        String checkJavaLang = checkJavaLang(str);
        if (checkJavaLang != null) {
            return checkJavaLang;
        }
        String checkSamePackage = checkSamePackage(str);
        if (checkSamePackage != null) {
            return checkSamePackage;
        }
        String checkAlreadyQualified = checkAlreadyQualified(str);
        if (checkAlreadyQualified != null) {
            return checkAlreadyQualified;
        }
        return null;
    }

    private String checkSamePackage(String str) {
        JClass loadClass = this.mContext.getClassLoader().loadClass(new StringBuffer().append(this.mContext.getPackageName()).append(".").append(str).toString());
        if (loadClass.isUnresolvedType()) {
            return null;
        }
        return loadClass.getQualifiedName();
    }

    private String checkJavaLang(String str) {
        JClass loadClass = this.mContext.getClassLoader().loadClass(new StringBuffer().append("java.lang.").append(str).toString());
        if (loadClass.isUnresolvedType()) {
            return null;
        }
        return loadClass.getQualifiedName();
    }

    private String checkAlreadyQualified(String str) {
        JClass loadClass = this.mContext.getClassLoader().loadClass(str);
        if (loadClass.isUnresolvedType()) {
            return null;
        }
        return loadClass.getQualifiedName();
    }

    private String checkExplicitImport(String str) {
        String[] importSpecs = this.mContext.getImportSpecs();
        for (int i = 0; i < importSpecs.length; i++) {
            if (lastSegment(importSpecs[i]).equals(str)) {
                return importSpecs[i];
            }
        }
        return null;
    }

    private static String lastSegment(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    private static String firstSegment(String str) {
        int indexOf = str.indexOf(".");
        return indexOf == -1 ? str : str.substring(0, indexOf);
    }
}
