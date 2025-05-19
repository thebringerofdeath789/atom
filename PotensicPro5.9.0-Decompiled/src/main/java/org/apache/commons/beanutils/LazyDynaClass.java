package org.apache.commons.beanutils;

/* loaded from: classes4.dex */
public class LazyDynaClass extends BasicDynaClass implements MutableDynaClass {
    protected boolean restricted;
    protected boolean returnNull;

    public LazyDynaClass() {
        this((String) null, (DynaProperty[]) null);
    }

    public LazyDynaClass(String str) {
        this(str, (DynaProperty[]) null);
    }

    public LazyDynaClass(String str, Class<?> cls) {
        this(str, cls, null);
    }

    public LazyDynaClass(String str, DynaProperty[] dynaPropertyArr) {
        this(str, LazyDynaBean.class, dynaPropertyArr);
    }

    public LazyDynaClass(String str, Class<?> cls, DynaProperty[] dynaPropertyArr) {
        super(str, cls, dynaPropertyArr);
        this.returnNull = false;
    }

    @Override // org.apache.commons.beanutils.MutableDynaClass
    public boolean isRestricted() {
        return this.restricted;
    }

    @Override // org.apache.commons.beanutils.MutableDynaClass
    public void setRestricted(boolean z) {
        this.restricted = z;
    }

    public boolean isReturnNull() {
        return this.returnNull;
    }

    public void setReturnNull(boolean z) {
        this.returnNull = z;
    }

    @Override // org.apache.commons.beanutils.MutableDynaClass
    public void add(String str) {
        add(new DynaProperty(str));
    }

    @Override // org.apache.commons.beanutils.MutableDynaClass
    public void add(String str, Class<?> cls) {
        if (cls == null) {
            add(str);
        } else {
            add(new DynaProperty(str, cls));
        }
    }

    @Override // org.apache.commons.beanutils.MutableDynaClass
    public void add(String str, Class<?> cls, boolean z, boolean z2) {
        throw new UnsupportedOperationException("readable/writable properties not supported");
    }

    protected void add(DynaProperty dynaProperty) {
        if (dynaProperty.getName() == null) {
            throw new IllegalArgumentException("Property name is missing.");
        }
        if (isRestricted()) {
            throw new IllegalStateException("DynaClass is currently restricted. No new properties can be added.");
        }
        if (this.propertiesMap.get(dynaProperty.getName()) != null) {
            return;
        }
        DynaProperty[] dynaProperties = getDynaProperties();
        DynaProperty[] dynaPropertyArr = new DynaProperty[dynaProperties.length + 1];
        System.arraycopy(dynaProperties, 0, dynaPropertyArr, 0, dynaProperties.length);
        dynaPropertyArr[dynaProperties.length] = dynaProperty;
        setProperties(dynaPropertyArr);
    }

    @Override // org.apache.commons.beanutils.MutableDynaClass
    public void remove(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Property name is missing.");
        }
        if (isRestricted()) {
            throw new IllegalStateException("DynaClass is currently restricted. No properties can be removed.");
        }
        if (this.propertiesMap.get(str) == null) {
            return;
        }
        DynaProperty[] dynaProperties = getDynaProperties();
        DynaProperty[] dynaPropertyArr = new DynaProperty[dynaProperties.length - 1];
        int i = 0;
        for (int i2 = 0; i2 < dynaProperties.length; i2++) {
            if (!str.equals(dynaProperties[i2].getName())) {
                dynaPropertyArr[i] = dynaProperties[i2];
                i++;
            }
        }
        setProperties(dynaPropertyArr);
    }

    @Override // org.apache.commons.beanutils.BasicDynaClass, org.apache.commons.beanutils.DynaClass
    public DynaProperty getDynaProperty(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Property name is missing.");
        }
        DynaProperty dynaProperty = this.propertiesMap.get(str);
        return (dynaProperty != null || isReturnNull() || isRestricted()) ? dynaProperty : new DynaProperty(str);
    }

    public boolean isDynaProperty(String str) {
        if (str != null) {
            return this.propertiesMap.get(str) != null;
        }
        throw new IllegalArgumentException("Property name is missing.");
    }
}
