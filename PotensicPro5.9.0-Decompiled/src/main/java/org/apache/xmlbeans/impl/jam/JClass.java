package org.apache.xmlbeans.impl.jam;

/* loaded from: classes5.dex */
public interface JClass extends JMember {
    boolean equals(Object obj);

    JClass forName(String str);

    JClass getArrayComponentType();

    int getArrayDimensions();

    JamClassLoader getClassLoader();

    JClass[] getClasses();

    JConstructor[] getConstructors();

    @Override // org.apache.xmlbeans.impl.jam.JMember
    JClass getContainingClass();

    JPackage getContainingPackage();

    JField[] getDeclaredFields();

    JMethod[] getDeclaredMethods();

    JProperty[] getDeclaredProperties();

    String getFieldDescriptor();

    JField[] getFields();

    JClass[] getImportedClasses();

    JPackage[] getImportedPackages();

    JClass[] getInterfaces();

    JMethod[] getMethods();

    Class getPrimitiveClass();

    JProperty[] getProperties();

    JClass getSuperclass();

    boolean isAbstract();

    boolean isAnnotationType();

    boolean isArrayType();

    boolean isAssignableFrom(JClass jClass);

    boolean isBuiltinType();

    boolean isEnumType();

    boolean isFinal();

    boolean isInterface();

    boolean isObjectType();

    boolean isPrimitiveType();

    boolean isStatic();

    boolean isUnresolvedType();

    boolean isVoidType();
}
