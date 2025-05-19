package org.apache.commons.beanutils;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class LazyDynaMap extends LazyDynaBean implements MutableDynaClass {
    protected String name;
    protected boolean restricted;
    protected boolean returnNull;

    public LazyDynaMap() {
        this((String) null, (Map<String, Object>) null);
    }

    public LazyDynaMap(String str) {
        this(str, (Map<String, Object>) null);
    }

    public LazyDynaMap(Map<String, Object> map) {
        this((String) null, map);
    }

    public LazyDynaMap(String str, Map<String, Object> map) {
        this.returnNull = false;
        this.name = str == null ? "LazyDynaMap" : str;
        this.values = map == null ? newMap() : map;
        this.dynaClass = this;
    }

    public LazyDynaMap(DynaProperty[] dynaPropertyArr) {
        this((String) null, dynaPropertyArr);
    }

    public LazyDynaMap(String str, DynaProperty[] dynaPropertyArr) {
        this(str, (Map<String, Object>) null);
        if (dynaPropertyArr != null) {
            for (DynaProperty dynaProperty : dynaPropertyArr) {
                add(dynaProperty);
            }
        }
    }

    public LazyDynaMap(DynaClass dynaClass) {
        this(dynaClass.getName(), dynaClass.getDynaProperties());
    }

    public void setMap(Map<String, Object> map) {
        this.values = map;
    }

    @Override // org.apache.commons.beanutils.LazyDynaBean
    public Map<String, Object> getMap() {
        return this.values;
    }

    @Override // org.apache.commons.beanutils.LazyDynaBean, org.apache.commons.beanutils.DynaBean
    public void set(String str, Object obj) {
        if (isRestricted() && !this.values.containsKey(str)) {
            throw new IllegalArgumentException("Invalid property name '" + str + "' (DynaClass is restricted)");
        }
        this.values.put(str, obj);
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public String getName() {
        return this.name;
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public DynaProperty getDynaProperty(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Property name is missing.");
        }
        if (!this.values.containsKey(str) && isReturnNull()) {
            return null;
        }
        Object obj = this.values.get(str);
        if (obj == null) {
            return new DynaProperty(str);
        }
        return new DynaProperty(str, obj.getClass());
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public DynaProperty[] getDynaProperties() {
        DynaProperty[] dynaPropertyArr = new DynaProperty[this.values.size()];
        Iterator<Map.Entry<String, Object>> it = this.values.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            String key = it.next().getKey();
            Object obj = this.values.get(key);
            int i2 = i + 1;
            dynaPropertyArr[i] = new DynaProperty(key, obj == null ? null : obj.getClass());
            i = i2;
        }
        return dynaPropertyArr;
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public DynaBean newInstance() {
        Map<String, Object> newMap;
        try {
            newMap = (Map) getMap().getClass().newInstance();
        } catch (Exception unused) {
            newMap = newMap();
        }
        LazyDynaMap lazyDynaMap = new LazyDynaMap(newMap);
        DynaProperty[] dynaProperties = getDynaProperties();
        if (dynaProperties != null) {
            for (DynaProperty dynaProperty : dynaProperties) {
                lazyDynaMap.add(dynaProperty);
            }
        }
        return lazyDynaMap;
    }

    @Override // org.apache.commons.beanutils.MutableDynaClass
    public boolean isRestricted() {
        return this.restricted;
    }

    @Override // org.apache.commons.beanutils.MutableDynaClass
    public void setRestricted(boolean z) {
        this.restricted = z;
    }

    @Override // org.apache.commons.beanutils.MutableDynaClass
    public void add(String str) {
        add(str, null);
    }

    @Override // org.apache.commons.beanutils.MutableDynaClass
    public void add(String str, Class<?> cls) {
        if (str == null) {
            throw new IllegalArgumentException("Property name is missing.");
        }
        if (isRestricted()) {
            throw new IllegalStateException("DynaClass is currently restricted. No new properties can be added.");
        }
        if (this.values.get(str) == null) {
            this.values.put(str, cls == null ? null : createProperty(str, cls));
        }
    }

    @Override // org.apache.commons.beanutils.MutableDynaClass
    public void add(String str, Class<?> cls, boolean z, boolean z2) {
        throw new UnsupportedOperationException("readable/writable properties not supported");
    }

    protected void add(DynaProperty dynaProperty) {
        add(dynaProperty.getName(), dynaProperty.getType());
    }

    @Override // org.apache.commons.beanutils.MutableDynaClass
    public void remove(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Property name is missing.");
        }
        if (isRestricted()) {
            throw new IllegalStateException("DynaClass is currently restricted. No properties can be removed.");
        }
        if (this.values.containsKey(str)) {
            this.values.remove(str);
        }
    }

    public boolean isReturnNull() {
        return this.returnNull;
    }

    public void setReturnNull(boolean z) {
        this.returnNull = z;
    }

    @Override // org.apache.commons.beanutils.LazyDynaBean
    protected boolean isDynaProperty(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Property name is missing.");
        }
        return this.values.containsKey(str);
    }
}
