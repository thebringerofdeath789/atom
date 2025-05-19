package org.apache.xmlbeans.impl.jam.internal.elements;

import java.util.HashMap;
import java.util.Map;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.jam.JClass;

/* loaded from: classes5.dex */
public final class PrimitiveClassImpl extends BuiltinClassImpl {
    private static final Object[][] PRIMITIVES = {new Object[]{XmlErrorCodes.INT, "I", Integer.TYPE}, new Object[]{XmlErrorCodes.LONG, "J", Long.TYPE}, new Object[]{XmlErrorCodes.BOOLEAN, "Z", Boolean.TYPE}, new Object[]{"short", "S", Short.TYPE}, new Object[]{"byte", "B", Byte.TYPE}, new Object[]{"char", "C", Character.TYPE}, new Object[]{XmlErrorCodes.FLOAT, "F", Float.TYPE}, new Object[]{XmlErrorCodes.DOUBLE, "D", Double.TYPE}};
    private static final Map NAME_TO_FD = new HashMap();
    private static final Map NAME_TO_CLASS = new HashMap();

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JClass
    public boolean isPrimitiveType() {
        return true;
    }

    static {
        int i = 0;
        while (true) {
            Object[][] objArr = PRIMITIVES;
            if (i >= objArr.length) {
                return;
            }
            NAME_TO_FD.put(objArr[i][0], objArr[i][1]);
            NAME_TO_CLASS.put(objArr[i][0], objArr[i][2]);
            i++;
        }
    }

    public static void mapNameToPrimitive(ElementContext elementContext, Map map) {
        int i = 0;
        while (true) {
            Object[][] objArr = PRIMITIVES;
            if (i >= objArr.length) {
                return;
            }
            PrimitiveClassImpl primitiveClassImpl = new PrimitiveClassImpl(elementContext, (String) objArr[i][0]);
            map.put(objArr[i][0], primitiveClassImpl);
            map.put(objArr[i][1], primitiveClassImpl);
            i++;
        }
    }

    public static String getPrimitiveClassForName(String str) {
        return (String) NAME_TO_FD.get(str);
    }

    public static boolean isPrimitive(String str) {
        return NAME_TO_FD.get(str) != null;
    }

    public static final String getFieldDescriptor(String str) {
        return (String) NAME_TO_FD.get(str);
    }

    public static final Class getPrimitiveClass(String str) {
        return (Class) NAME_TO_CLASS.get(str);
    }

    private PrimitiveClassImpl(ElementContext elementContext, String str) {
        super(elementContext);
        if (str == null) {
            throw new IllegalArgumentException("null name");
        }
        if (!NAME_TO_FD.containsKey(str)) {
            throw new IllegalArgumentException(new StringBuffer().append("Unknown primitive class '").append(str).append("'").toString());
        }
        reallySetSimpleName(str);
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JElement
    public String getQualifiedName() {
        return getSimpleName();
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JClass
    public String getFieldDescriptor() {
        return (String) NAME_TO_FD.get(getSimpleName());
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isAssignableFrom(JClass jClass) {
        return jClass.isPrimitiveType() && jClass.getSimpleName().equals(getSimpleName());
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JClass
    public Class getPrimitiveClass() {
        return (Class) NAME_TO_CLASS.get(getSimpleName());
    }
}
