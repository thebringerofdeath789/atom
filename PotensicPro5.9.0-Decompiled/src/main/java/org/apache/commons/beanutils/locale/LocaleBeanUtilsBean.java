package org.apache.commons.beanutils.locale;

import java.beans.IndexedPropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ContextClassLoaderLocal;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.MappedPropertyDescriptor;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.beanutils.expression.Resolver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes4.dex */
public class LocaleBeanUtilsBean extends BeanUtilsBean {
    private static final ContextClassLoaderLocal<LocaleBeanUtilsBean> LOCALE_BEANS_BY_CLASSLOADER = new ContextClassLoaderLocal<LocaleBeanUtilsBean>() { // from class: org.apache.commons.beanutils.locale.LocaleBeanUtilsBean.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.commons.beanutils.ContextClassLoaderLocal
        public LocaleBeanUtilsBean initialValue() {
            return new LocaleBeanUtilsBean();
        }
    };
    private final LocaleConvertUtilsBean localeConvertUtils;
    private final Log log;

    public static LocaleBeanUtilsBean getLocaleBeanUtilsInstance() {
        return LOCALE_BEANS_BY_CLASSLOADER.get();
    }

    public static void setInstance(LocaleBeanUtilsBean localeBeanUtilsBean) {
        LOCALE_BEANS_BY_CLASSLOADER.set(localeBeanUtilsBean);
    }

    public LocaleBeanUtilsBean() {
        this.log = LogFactory.getLog(LocaleBeanUtilsBean.class);
        this.localeConvertUtils = new LocaleConvertUtilsBean();
    }

    public LocaleBeanUtilsBean(LocaleConvertUtilsBean localeConvertUtilsBean, ConvertUtilsBean convertUtilsBean, PropertyUtilsBean propertyUtilsBean) {
        super(convertUtilsBean, propertyUtilsBean);
        this.log = LogFactory.getLog(LocaleBeanUtilsBean.class);
        this.localeConvertUtils = localeConvertUtilsBean;
    }

    public LocaleBeanUtilsBean(LocaleConvertUtilsBean localeConvertUtilsBean) {
        this.log = LogFactory.getLog(LocaleBeanUtilsBean.class);
        this.localeConvertUtils = localeConvertUtilsBean;
    }

    public LocaleConvertUtilsBean getLocaleConvertUtils() {
        return this.localeConvertUtils;
    }

    public Locale getDefaultLocale() {
        return getLocaleConvertUtils().getDefaultLocale();
    }

    public void setDefaultLocale(Locale locale) {
        getLocaleConvertUtils().setDefaultLocale(locale);
    }

    public boolean getApplyLocalized() {
        return getLocaleConvertUtils().getApplyLocalized();
    }

    public void setApplyLocalized(boolean z) {
        getLocaleConvertUtils().setApplyLocalized(z);
    }

    public String getIndexedProperty(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getLocaleConvertUtils().convert(getPropertyUtils().getIndexedProperty(obj, str), str2);
    }

    @Override // org.apache.commons.beanutils.BeanUtilsBean
    public String getIndexedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getIndexedProperty(obj, str, (String) null);
    }

    public String getIndexedProperty(Object obj, String str, int i, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getLocaleConvertUtils().convert(getPropertyUtils().getIndexedProperty(obj, str, i), str2);
    }

    @Override // org.apache.commons.beanutils.BeanUtilsBean
    public String getIndexedProperty(Object obj, String str, int i) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getIndexedProperty(obj, str, i, null);
    }

    public String getSimpleProperty(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getLocaleConvertUtils().convert(getPropertyUtils().getSimpleProperty(obj, str), str2);
    }

    @Override // org.apache.commons.beanutils.BeanUtilsBean
    public String getSimpleProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getSimpleProperty(obj, str, null);
    }

    public String getMappedProperty(Object obj, String str, String str2, String str3) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getLocaleConvertUtils().convert(getPropertyUtils().getMappedProperty(obj, str, str2), str3);
    }

    @Override // org.apache.commons.beanutils.BeanUtilsBean
    public String getMappedProperty(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getMappedProperty(obj, str, str2, null);
    }

    public String getMappedPropertyLocale(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getLocaleConvertUtils().convert(getPropertyUtils().getMappedProperty(obj, str), str2);
    }

    @Override // org.apache.commons.beanutils.BeanUtilsBean
    public String getMappedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getMappedPropertyLocale(obj, str, null);
    }

    public String getNestedProperty(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getLocaleConvertUtils().convert(getPropertyUtils().getNestedProperty(obj, str), str2);
    }

    @Override // org.apache.commons.beanutils.BeanUtilsBean
    public String getNestedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getNestedProperty(obj, str, null);
    }

    public String getProperty(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getNestedProperty(obj, str, str2);
    }

    @Override // org.apache.commons.beanutils.BeanUtilsBean
    public String getProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getNestedProperty(obj, str);
    }

    @Override // org.apache.commons.beanutils.BeanUtilsBean
    public void setProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException {
        setProperty(obj, str, obj2, null);
    }

    public void setProperty(Object obj, String str, Object obj2, String str2) throws IllegalAccessException, InvocationTargetException {
        if (this.log.isTraceEnabled()) {
            StringBuilder sb = new StringBuilder("  setProperty(");
            sb.append(obj);
            sb.append(", ");
            sb.append(str);
            sb.append(", ");
            if (obj2 == null) {
                sb.append("<NULL>");
            } else if (obj2 instanceof String) {
                sb.append((String) obj2);
            } else if (obj2 instanceof String[]) {
                String[] strArr = (String[]) obj2;
                sb.append(PropertyUtils.INDEXED_DELIM);
                for (int i = 0; i < strArr.length; i++) {
                    if (i > 0) {
                        sb.append(',');
                    }
                    sb.append(strArr[i]);
                }
                sb.append(PropertyUtils.INDEXED_DELIM2);
            } else {
                sb.append(obj2.toString());
            }
            sb.append(PropertyUtils.MAPPED_DELIM2);
            this.log.trace(sb.toString());
        }
        Resolver resolver = getPropertyUtils().getResolver();
        Object obj3 = obj;
        while (resolver.hasNested(str)) {
            try {
                obj3 = getPropertyUtils().getProperty(obj3, resolver.next(str));
                str = resolver.remove(str);
            } catch (NoSuchMethodException unused) {
                return;
            }
        }
        if (this.log.isTraceEnabled()) {
            this.log.trace("    Target bean = " + obj3);
            this.log.trace("    Target name = " + str);
        }
        String property = resolver.getProperty(str);
        int index = resolver.getIndex(str);
        String key = resolver.getKey(str);
        Class<?> definePropertyType = definePropertyType(obj3, str, property);
        if (definePropertyType != null) {
            invokeSetter(obj3, property, key, index, convert(definePropertyType, index, obj2, str2));
        }
    }

    protected Class<?> definePropertyType(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException {
        if (obj instanceof DynaBean) {
            DynaProperty dynaProperty = ((DynaBean) obj).getDynaClass().getDynaProperty(str2);
            if (dynaProperty == null) {
                return null;
            }
            return dynaProperty.getType();
        }
        try {
            IndexedPropertyDescriptor propertyDescriptor = getPropertyUtils().getPropertyDescriptor(obj, str);
            if (propertyDescriptor == null) {
                return null;
            }
            if (propertyDescriptor instanceof MappedPropertyDescriptor) {
                return ((MappedPropertyDescriptor) propertyDescriptor).getMappedPropertyType();
            }
            if (propertyDescriptor instanceof IndexedPropertyDescriptor) {
                return propertyDescriptor.getIndexedPropertyType();
            }
            return propertyDescriptor.getPropertyType();
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    protected Object convert(Class<?> cls, int i, Object obj, String str) {
        if (this.log.isTraceEnabled()) {
            this.log.trace("Converting value '" + obj + "' to type:" + cls);
        }
        if (cls.isArray() && i < 0) {
            if (obj instanceof String) {
                return getLocaleConvertUtils().convert(new String[]{(String) obj}, cls, str);
            }
            return obj instanceof String[] ? getLocaleConvertUtils().convert((String[]) obj, cls, str) : obj;
        }
        if (cls.isArray()) {
            if (obj instanceof String) {
                return getLocaleConvertUtils().convert((String) obj, cls.getComponentType(), str);
            }
            return obj instanceof String[] ? getLocaleConvertUtils().convert(((String[]) obj)[0], cls.getComponentType(), str) : obj;
        }
        if (obj instanceof String) {
            return getLocaleConvertUtils().convert((String) obj, cls, str);
        }
        return obj instanceof String[] ? getLocaleConvertUtils().convert(((String[]) obj)[0], cls, str) : obj;
    }

    protected Object convert(Class<?> cls, int i, Object obj) {
        if (cls.isArray() && i < 0) {
            if (obj instanceof String) {
                return ConvertUtils.convert(new String[]{(String) obj}, cls);
            }
            return obj instanceof String[] ? ConvertUtils.convert((String[]) obj, cls) : obj;
        }
        if (cls.isArray()) {
            if (obj instanceof String) {
                return ConvertUtils.convert((String) obj, cls.getComponentType());
            }
            return obj instanceof String[] ? ConvertUtils.convert(((String[]) obj)[0], cls.getComponentType()) : obj;
        }
        if (obj instanceof String) {
            return ConvertUtils.convert((String) obj, cls);
        }
        return obj instanceof String[] ? ConvertUtils.convert(((String[]) obj)[0], cls) : obj;
    }

    protected void invokeSetter(Object obj, String str, String str2, int i, Object obj2) throws IllegalAccessException, InvocationTargetException {
        try {
            if (i >= 0) {
                getPropertyUtils().setIndexedProperty(obj, str, i, obj2);
            } else if (str2 != null) {
                getPropertyUtils().setMappedProperty(obj, str, str2, obj2);
            } else {
                getPropertyUtils().setProperty(obj, str, obj2);
            }
        } catch (NoSuchMethodException e) {
            throw new InvocationTargetException(e, "Cannot set " + str);
        }
    }

    @Deprecated
    protected Descriptor calculate(Object obj, String str) throws IllegalAccessException, InvocationTargetException {
        Resolver resolver = getPropertyUtils().getResolver();
        Object obj2 = obj;
        String str2 = str;
        while (resolver.hasNested(str2)) {
            try {
                obj2 = getPropertyUtils().getProperty(obj2, resolver.next(str2));
                str2 = resolver.remove(str2);
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
        if (this.log.isTraceEnabled()) {
            this.log.trace("    Target bean = " + obj2);
            this.log.trace("    Target name = " + str2);
        }
        return new Descriptor(obj2, str2, resolver.getProperty(str2), resolver.getKey(str2), resolver.getIndex(str2));
    }

    @Deprecated
    protected class Descriptor {
        private int index = -1;
        private String key;
        private String name;
        private String propName;
        private Object target;

        public Descriptor(Object obj, String str, String str2, String str3, int i) {
            setTarget(obj);
            setName(str);
            setPropName(str2);
            setKey(str3);
            setIndex(i);
        }

        public Object getTarget() {
            return this.target;
        }

        public void setTarget(Object obj) {
            this.target = obj;
        }

        public String getKey() {
            return this.key;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public int getIndex() {
            return this.index;
        }

        public void setIndex(int i) {
            this.index = i;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getPropName() {
            return this.propName;
        }

        public void setPropName(String str) {
            this.propName = str;
        }
    }
}
