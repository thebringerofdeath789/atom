package org.apache.commons.beanutils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class LazyDynaList extends ArrayList<Object> {
    private Class<?> elementDynaBeanType;
    private DynaClass elementDynaClass;
    private Class<?> elementType;
    private transient WrapDynaClass wrapDynaClass;

    public LazyDynaList() {
    }

    public LazyDynaList(int i) {
        super(i);
    }

    public LazyDynaList(DynaClass dynaClass) {
        setElementDynaClass(dynaClass);
    }

    public LazyDynaList(Class<?> cls) {
        setElementType(cls);
    }

    public LazyDynaList(Collection<?> collection) {
        super(collection.size());
        addAll(collection);
    }

    public LazyDynaList(Object[] objArr) {
        super(objArr.length);
        for (Object obj : objArr) {
            add(obj);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        DynaBean transform = transform(obj);
        growList(i);
        super.add(i, transform);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        return super.add(transform(obj));
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<?> collection) {
        if (collection == null || collection.size() == 0) {
            return false;
        }
        ensureCapacity(size() + collection.size());
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
        return true;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<?> collection) {
        if (collection == null || collection.size() == 0) {
            return false;
        }
        ensureCapacity((i > size() ? i : size()) + collection.size());
        if (size() == 0) {
            transform(collection.iterator().next());
        }
        growList(i);
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            add(i, it.next());
            i++;
        }
        return true;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public Object get(int i) {
        growList(i + 1);
        return super.get(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        DynaBean transform = transform(obj);
        growList(i + 1);
        return super.set(i, transform);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        if (size() == 0 && this.elementType == null) {
            return new LazyDynaBean[0];
        }
        Object[] objArr = (Object[]) Array.newInstance(this.elementType, size());
        for (int i = 0; i < size(); i++) {
            if (Map.class.isAssignableFrom(this.elementType)) {
                objArr[i] = ((LazyDynaMap) get(i)).getMap();
            } else if (DynaBean.class.isAssignableFrom(this.elementType)) {
                objArr[i] = get(i);
            } else {
                objArr[i] = ((WrapDynaBean) get(i)).getInstance();
            }
        }
        return objArr;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        Object wrapDynaBean;
        Class<?> componentType = tArr.getClass().getComponentType();
        if (DynaBean.class.isAssignableFrom(componentType) || (size() == 0 && this.elementType == null)) {
            return (T[]) super.toArray(tArr);
        }
        if (componentType.isAssignableFrom(this.elementType)) {
            if (tArr.length < size()) {
                tArr = (T[]) ((Object[]) Array.newInstance(componentType, size()));
            }
            for (int i = 0; i < size(); i++) {
                if (Map.class.isAssignableFrom(this.elementType)) {
                    wrapDynaBean = ((LazyDynaMap) get(i)).getMap();
                } else if (DynaBean.class.isAssignableFrom(this.elementType)) {
                    wrapDynaBean = get(i);
                } else {
                    wrapDynaBean = ((WrapDynaBean) get(i)).getInstance();
                }
                Array.set(tArr, i, wrapDynaBean);
            }
            return tArr;
        }
        throw new IllegalArgumentException("Invalid array type: " + componentType.getName() + " - not compatible with '" + this.elementType.getName());
    }

    public DynaBean[] toDynaBeanArray() {
        if (size() == 0 && this.elementDynaBeanType == null) {
            return new LazyDynaBean[0];
        }
        DynaBean[] dynaBeanArr = (DynaBean[]) Array.newInstance(this.elementDynaBeanType, size());
        for (int i = 0; i < size(); i++) {
            dynaBeanArr[i] = (DynaBean) get(i);
        }
        return dynaBeanArr;
    }

    public void setElementType(Class<?> cls) {
        DynaBean wrapDynaBean;
        if (cls == null) {
            throw new IllegalArgumentException("Element Type is missing");
        }
        Class<?> cls2 = this.elementType;
        if (((cls2 == null || cls2.equals(cls)) ? false : true) && size() > 0) {
            throw new IllegalStateException("Element Type cannot be reset");
        }
        this.elementType = cls;
        try {
            Object newInstance = cls.newInstance();
            if (Map.class.isAssignableFrom(cls)) {
                wrapDynaBean = createDynaBeanForMapProperty(newInstance);
                this.elementDynaClass = wrapDynaBean.getDynaClass();
            } else if (DynaBean.class.isAssignableFrom(cls)) {
                wrapDynaBean = (DynaBean) newInstance;
                this.elementDynaClass = wrapDynaBean.getDynaClass();
            } else {
                wrapDynaBean = new WrapDynaBean(newInstance);
                this.wrapDynaClass = (WrapDynaClass) wrapDynaBean.getDynaClass();
            }
            Class<?> cls3 = wrapDynaBean.getClass();
            this.elementDynaBeanType = cls3;
            if (WrapDynaBean.class.isAssignableFrom(cls3)) {
                this.elementType = ((WrapDynaBean) wrapDynaBean).getInstance().getClass();
            } else if (LazyDynaMap.class.isAssignableFrom(this.elementDynaBeanType)) {
                this.elementType = ((LazyDynaMap) wrapDynaBean).getMap().getClass();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Error creating type: " + cls.getName() + " - " + e);
        }
    }

    public void setElementDynaClass(DynaClass dynaClass) {
        if (dynaClass == null) {
            throw new IllegalArgumentException("Element DynaClass is missing");
        }
        if (size() > 0) {
            throw new IllegalStateException("Element DynaClass cannot be reset");
        }
        try {
            DynaBean newInstance = dynaClass.newInstance();
            Class<?> cls = newInstance.getClass();
            this.elementDynaBeanType = cls;
            if (WrapDynaBean.class.isAssignableFrom(cls)) {
                this.elementType = ((WrapDynaBean) newInstance).getInstance().getClass();
                this.wrapDynaClass = (WrapDynaClass) dynaClass;
            } else if (LazyDynaMap.class.isAssignableFrom(this.elementDynaBeanType)) {
                this.elementType = ((LazyDynaMap) newInstance).getMap().getClass();
                this.elementDynaClass = dynaClass;
            } else {
                this.elementType = newInstance.getClass();
                this.elementDynaClass = dynaClass;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Error creating DynaBean from " + dynaClass.getClass().getName() + " - " + e);
        }
    }

    private void growList(int i) {
        if (i < size()) {
            return;
        }
        ensureCapacity(i + 1);
        for (int size = size(); size < i; size++) {
            super.add(transform(null));
        }
    }

    private DynaBean transform(Object obj) {
        DynaBean wrapDynaBean;
        Class<?> cls;
        if (obj == null) {
            if (this.elementType == null) {
                setElementDynaClass(new LazyDynaClass());
            }
            if (getDynaClass() == null) {
                setElementType(this.elementType);
            }
            try {
                wrapDynaBean = getDynaClass().newInstance();
                cls = wrapDynaBean.getClass();
            } catch (Exception e) {
                throw new IllegalArgumentException("Error creating DynaBean: " + getDynaClass().getClass().getName() + " - " + e);
            }
        } else {
            obj.getClass();
            if (Map.class.isAssignableFrom(obj.getClass())) {
                wrapDynaBean = createDynaBeanForMapProperty(obj);
            } else if (DynaBean.class.isAssignableFrom(obj.getClass())) {
                wrapDynaBean = (DynaBean) obj;
            } else {
                wrapDynaBean = new WrapDynaBean(obj);
            }
            cls = wrapDynaBean.getClass();
        }
        Class<?> cls2 = wrapDynaBean.getClass();
        if (WrapDynaBean.class.isAssignableFrom(cls)) {
            cls2 = ((WrapDynaBean) wrapDynaBean).getInstance().getClass();
        } else if (LazyDynaMap.class.isAssignableFrom(cls)) {
            cls2 = ((LazyDynaMap) wrapDynaBean).getMap().getClass();
        }
        Class<?> cls3 = this.elementType;
        if (cls3 == null || cls2.equals(cls3)) {
            return wrapDynaBean;
        }
        throw new IllegalArgumentException("Element Type " + cls2 + " doesn't match other elements " + this.elementType);
    }

    private LazyDynaMap createDynaBeanForMapProperty(Object obj) {
        return new LazyDynaMap((Map<String, Object>) obj);
    }

    private DynaClass getDynaClass() {
        DynaClass dynaClass = this.elementDynaClass;
        return dynaClass == null ? this.wrapDynaClass : dynaClass;
    }
}
