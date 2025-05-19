package org.apache.commons.beanutils;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class BasicDynaClass implements DynaClass, Serializable {
    protected static Class<?>[] constructorTypes = {DynaClass.class};
    protected transient Constructor<?> constructor;
    protected Object[] constructorValues;
    protected Class<?> dynaBeanClass;
    protected String name;
    protected DynaProperty[] properties;
    protected HashMap<String, DynaProperty> propertiesMap;

    public BasicDynaClass() {
        this(null, null, null);
    }

    public BasicDynaClass(String str, Class<?> cls) {
        this(str, cls, null);
    }

    /* JADX WARN: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r4v0, types: [java.lang.Class<?>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BasicDynaClass(java.lang.String r3, java.lang.Class r4, org.apache.commons.beanutils.DynaProperty[] r5) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r2.constructor = r0
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            r0[r1] = r2
            r2.constructorValues = r0
            java.lang.Class<org.apache.commons.beanutils.BasicDynaBean> r0 = org.apache.commons.beanutils.BasicDynaBean.class
            r2.dynaBeanClass = r0
            java.lang.Class r0 = r2.getClass()
            java.lang.String r0 = r0.getName()
            r2.name = r0
            org.apache.commons.beanutils.DynaProperty[] r0 = new org.apache.commons.beanutils.DynaProperty[r1]
            r2.properties = r0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r2.propertiesMap = r0
            if (r3 == 0) goto L2b
            r2.name = r3
        L2b:
            if (r4 != 0) goto L2f
            java.lang.Class<org.apache.commons.beanutils.BasicDynaBean> r4 = org.apache.commons.beanutils.BasicDynaBean.class
        L2f:
            r2.setDynaBeanClass(r4)
            if (r5 == 0) goto L37
            r2.setProperties(r5)
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.beanutils.BasicDynaClass.<init>(java.lang.String, java.lang.Class, org.apache.commons.beanutils.DynaProperty[]):void");
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public String getName() {
        return this.name;
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public DynaProperty getDynaProperty(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No property name specified");
        }
        return this.propertiesMap.get(str);
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public DynaProperty[] getDynaProperties() {
        return this.properties;
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public DynaBean newInstance() throws IllegalAccessException, InstantiationException {
        try {
            if (this.constructor == null) {
                setDynaBeanClass(this.dynaBeanClass);
            }
            return (DynaBean) this.constructor.newInstance(this.constructorValues);
        } catch (InvocationTargetException e) {
            throw new InstantiationException(e.getTargetException().getMessage());
        }
    }

    public Class<?> getDynaBeanClass() {
        return this.dynaBeanClass;
    }

    protected void setDynaBeanClass(Class<?> cls) {
        if (cls.isInterface()) {
            throw new IllegalArgumentException("Class " + cls.getName() + " is an interface, not a class");
        }
        if (!DynaBean.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Class " + cls.getName() + " does not implement DynaBean");
        }
        try {
            this.constructor = cls.getConstructor(constructorTypes);
            this.dynaBeanClass = cls;
        } catch (NoSuchMethodException unused) {
            throw new IllegalArgumentException("Class " + cls.getName() + " does not have an appropriate constructor");
        }
    }

    protected void setProperties(DynaProperty[] dynaPropertyArr) {
        this.properties = dynaPropertyArr;
        this.propertiesMap.clear();
        for (DynaProperty dynaProperty : dynaPropertyArr) {
            this.propertiesMap.put(dynaProperty.getName(), dynaProperty);
        }
    }
}
