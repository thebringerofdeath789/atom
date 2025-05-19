package org.apache.commons.beanutils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public class WrapDynaBean implements DynaBean, Serializable {
    protected transient WrapDynaClass dynaClass;
    protected Object instance;

    public WrapDynaBean(Object obj) {
        this(obj, null);
    }

    public WrapDynaBean(Object obj, WrapDynaClass wrapDynaClass) {
        this.dynaClass = null;
        this.instance = null;
        this.instance = obj;
        this.dynaClass = wrapDynaClass == null ? (WrapDynaClass) getDynaClass() : wrapDynaClass;
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public boolean contains(String str, String str2) {
        throw new UnsupportedOperationException("WrapDynaBean does not support contains()");
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public Object get(String str) {
        try {
            return getPropertyUtils().getSimpleProperty(this.instance, str);
        } catch (InvocationTargetException e) {
            throw new IllegalArgumentException("Error reading property '" + str + "' nested exception - " + e.getTargetException());
        } catch (Throwable th) {
            throw new IllegalArgumentException("Error reading property '" + str + "', exception - " + th);
        }
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public Object get(String str, int i) {
        try {
            return getPropertyUtils().getIndexedProperty(this.instance, str, i);
        } catch (IndexOutOfBoundsException e) {
            throw e;
        } catch (InvocationTargetException e2) {
            throw new IllegalArgumentException("Error reading indexed property '" + str + "' nested exception - " + e2.getTargetException());
        } catch (Throwable th) {
            throw new IllegalArgumentException("Error reading indexed property '" + str + "', exception - " + th);
        }
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public Object get(String str, String str2) {
        try {
            return getPropertyUtils().getMappedProperty(this.instance, str, str2);
        } catch (InvocationTargetException e) {
            throw new IllegalArgumentException("Error reading mapped property '" + str + "' nested exception - " + e.getTargetException());
        } catch (Throwable th) {
            throw new IllegalArgumentException("Error reading mapped property '" + str + "', exception - " + th);
        }
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public DynaClass getDynaClass() {
        if (this.dynaClass == null) {
            this.dynaClass = WrapDynaClass.createDynaClass(this.instance.getClass());
        }
        return this.dynaClass;
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void remove(String str, String str2) {
        throw new UnsupportedOperationException("WrapDynaBean does not support remove()");
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void set(String str, Object obj) {
        try {
            getPropertyUtils().setSimpleProperty(this.instance, str, obj);
        } catch (InvocationTargetException e) {
            throw new IllegalArgumentException("Error setting property '" + str + "' nested exception -" + e.getTargetException());
        } catch (Throwable th) {
            throw new IllegalArgumentException("Error setting property '" + str + "', exception - " + th);
        }
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void set(String str, int i, Object obj) {
        try {
            getPropertyUtils().setIndexedProperty(this.instance, str, i, obj);
        } catch (IndexOutOfBoundsException e) {
            throw e;
        } catch (InvocationTargetException e2) {
            throw new IllegalArgumentException("Error setting indexed property '" + str + "' nested exception - " + e2.getTargetException());
        } catch (Throwable th) {
            throw new IllegalArgumentException("Error setting indexed property '" + str + "', exception - " + th);
        }
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void set(String str, String str2, Object obj) {
        try {
            getPropertyUtils().setMappedProperty(this.instance, str, str2, obj);
        } catch (InvocationTargetException e) {
            throw new IllegalArgumentException("Error setting mapped property '" + str + "' nested exception - " + e.getTargetException());
        } catch (Throwable th) {
            throw new IllegalArgumentException("Error setting mapped property '" + str + "', exception - " + th);
        }
    }

    public Object getInstance() {
        return this.instance;
    }

    protected DynaProperty getDynaProperty(String str) {
        DynaProperty dynaProperty = getDynaClass().getDynaProperty(str);
        if (dynaProperty != null) {
            return dynaProperty;
        }
        throw new IllegalArgumentException("Invalid property name '" + str + "'");
    }

    private PropertyUtilsBean getPropertyUtils() {
        WrapDynaClass wrapDynaClass = this.dynaClass;
        PropertyUtilsBean propertyUtilsBean = wrapDynaClass != null ? wrapDynaClass.getPropertyUtilsBean() : null;
        return propertyUtilsBean != null ? propertyUtilsBean : PropertyUtilsBean.getInstance();
    }
}
