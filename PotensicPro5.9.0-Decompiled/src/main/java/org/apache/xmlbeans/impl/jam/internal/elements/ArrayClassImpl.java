package org.apache.xmlbeans.impl.jam.internal.elements;

import java.io.StringWriter;
import okhttp3.HttpUrl;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JamClassLoader;

/* loaded from: classes5.dex */
public final class ArrayClassImpl extends BuiltinClassImpl {
    private JClass mComponentType;
    private int mDimensions;

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JClass
    public boolean isArrayType() {
        return true;
    }

    public static JClass createClassForFD(String str, JamClassLoader jamClassLoader) {
        if (!str.startsWith("[")) {
            throw new IllegalArgumentException(new StringBuffer().append("must be an array type fd: ").append(str).toString());
        }
        if (str.endsWith(";")) {
            int indexOf = str.indexOf("L");
            if (indexOf != -1 && indexOf < str.length() - 2) {
                return new ArrayClassImpl(jamClassLoader.loadClass(str.substring(indexOf + 1, str.length() - 1)), indexOf);
            }
            throw new IllegalArgumentException(new StringBuffer().append("array type field descriptor '").append(str).append("' is malformed").toString());
        }
        int lastIndexOf = str.lastIndexOf("[") + 1;
        JClass loadClass = jamClassLoader.loadClass(str.substring(lastIndexOf, lastIndexOf + 1));
        if (loadClass == null) {
            throw new IllegalArgumentException(new StringBuffer().append("array type field descriptor '").append(str).append("' is malformed").toString());
        }
        return new ArrayClassImpl(loadClass, lastIndexOf);
    }

    public static String normalizeArrayName(String str) {
        int indexOf;
        if (str.startsWith("[")) {
            return str;
        }
        if (str.endsWith("]") && (indexOf = str.indexOf(91)) != -1) {
            String substring = str.substring(0, indexOf);
            String primitiveClassForName = PrimitiveClassImpl.getPrimitiveClassForName(substring);
            if (primitiveClassForName == null) {
                primitiveClassForName = new StringBuffer().append('L').append(substring).append(';').toString();
            }
            StringWriter stringWriter = new StringWriter();
            do {
                stringWriter.write(91);
                indexOf = str.indexOf(91, indexOf + 1);
            } while (indexOf != -1);
            stringWriter.write(primitiveClassForName);
            return stringWriter.toString();
        }
        throw new IllegalArgumentException(new StringBuffer().append("'").append(str).append("' does not name an array").toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ArrayClassImpl(JClass jClass, int i) {
        super(((ElementImpl) jClass).getContext());
        if (i < 1) {
            throw new IllegalArgumentException(new StringBuffer().append("dimensions=").append(i).toString());
        }
        if (jClass == 0) {
            throw new IllegalArgumentException("null componentType");
        }
        this.mComponentType = jClass;
        this.mDimensions = i;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.ElementImpl, org.apache.xmlbeans.impl.jam.JElement
    public String getSimpleName() {
        String qualifiedName = getQualifiedName();
        int lastIndexOf = qualifiedName.lastIndexOf(46);
        return lastIndexOf == -1 ? qualifiedName : qualifiedName.substring(lastIndexOf + 1);
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JElement
    public String getQualifiedName() {
        StringWriter stringWriter = new StringWriter();
        stringWriter.write(this.mComponentType.getQualifiedName());
        for (int i = 0; i < this.mDimensions; i++) {
            stringWriter.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        return stringWriter.toString();
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JClass
    public JClass getArrayComponentType() {
        return this.mComponentType;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JClass
    public int getArrayDimensions() {
        return this.mDimensions;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JClass
    public JClass getSuperclass() {
        return getClassLoader().loadClass("java.lang.Object");
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isAssignableFrom(JClass jClass) {
        return jClass.isArrayType() && jClass.getArrayDimensions() == this.mDimensions && this.mComponentType.isAssignableFrom(jClass.getArrayComponentType());
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JClass
    public String getFieldDescriptor() {
        StringWriter stringWriter = new StringWriter();
        for (int i = 0; i < this.mDimensions; i++) {
            stringWriter.write("[");
        }
        if (this.mComponentType.isPrimitiveType()) {
            stringWriter.write(this.mComponentType.getFieldDescriptor());
        } else {
            stringWriter.write("L");
            stringWriter.write(this.mComponentType.getQualifiedName());
            stringWriter.write(";");
        }
        return stringWriter.toString();
    }
}
