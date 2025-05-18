package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvBadConverterException;
import com.opencsv.exceptions.CsvBeanIntrospectionException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.SetValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;
import org.apache.commons.lang3.ArrayUtils;

/* loaded from: classes3.dex */
public abstract class BeanFieldJoin<T, I> extends BeanFieldSingleValue<T, I> {
    private final Class<? extends MultiValuedMap> mapType;

    protected abstract Object putNewValue(MultiValuedMap<I, Object> multiValuedMap, String str, Object obj);

    public BeanFieldJoin(Class<?> cls, Field field, boolean z, Locale locale, CsvConverter csvConverter, Class<? extends MultiValuedMap> cls2, String str, String str2) {
        super(cls, field, z, locale, csvConverter, str, str2);
        if (!MultiValuedMap.class.isAssignableFrom(field.getType())) {
            throw new CsvBadConverterException(BeanFieldJoin.class, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, locale).getString("invalid.multivaluedmap.type"), field.getType().toString()));
        }
        Class<?> type = field.getType();
        if (!type.isInterface()) {
            this.mapType = field.getType();
        } else if (!cls2.isInterface()) {
            this.mapType = cls2;
        } else if (MultiValuedMap.class.equals(type) || ListValuedMap.class.equals(type)) {
            this.mapType = ArrayListValuedHashMap.class;
        } else if (SetValuedMap.class.equals(type)) {
            this.mapType = HashSetValuedHashMap.class;
        } else {
            this.mapType = null;
            throw new CsvBadConverterException(BeanFieldJoin.class, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, locale).getString("invalid.multivaluedmap.type"), cls2.toString()));
        }
        if (!field.getType().isAssignableFrom(this.mapType)) {
            throw new CsvBadConverterException(BeanFieldJoin.class, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, locale).getString("unassignable.multivaluedmap.type"), cls2.getName(), field.getType().getName()));
        }
    }

    @Override // com.opencsv.bean.AbstractBeanField
    protected void assignValueToField(Object obj, Object obj2, String str) throws CsvDataTypeMismatchException {
        MultiValuedMap multiValuedMap = (MultiValuedMap) getFieldValue(obj);
        if (multiValuedMap == null) {
            try {
                multiValuedMap = this.mapType.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassCastException e) {
                e = e;
                CsvBeanIntrospectionException csvBeanIntrospectionException = new CsvBeanIntrospectionException(obj, this.field, e.getLocalizedMessage());
                csvBeanIntrospectionException.initCause(e);
                throw csvBeanIntrospectionException;
            } catch (IllegalAccessException e2) {
                e = e2;
                CsvBeanIntrospectionException csvBeanIntrospectionException2 = new CsvBeanIntrospectionException(obj, this.field, e.getLocalizedMessage());
                csvBeanIntrospectionException2.initCause(e);
                throw csvBeanIntrospectionException2;
            } catch (InstantiationException e3) {
                e = e3;
                CsvBadConverterException csvBadConverterException = new CsvBadConverterException(BeanFieldJoin.class, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("map.cannot.be.instantiated"), this.mapType.getName()));
                csvBadConverterException.initCause(e);
                throw csvBadConverterException;
            } catch (NoSuchMethodException e4) {
                e = e4;
                CsvBadConverterException csvBadConverterException2 = new CsvBadConverterException(BeanFieldJoin.class, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("map.cannot.be.instantiated"), this.mapType.getName()));
                csvBadConverterException2.initCause(e);
                throw csvBadConverterException2;
            } catch (InvocationTargetException e5) {
                e = e5;
                CsvBeanIntrospectionException csvBeanIntrospectionException22 = new CsvBeanIntrospectionException(obj, this.field, e.getLocalizedMessage());
                csvBeanIntrospectionException22.initCause(e);
                throw csvBeanIntrospectionException22;
            }
        }
        putNewValue(multiValuedMap, str, obj2);
        super.assignValueToField(obj, multiValuedMap, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.opencsv.bean.AbstractBeanField, com.opencsv.bean.BeanField
    public Object[] indexAndSplitMultivaluedField(Object obj, I i) throws CsvDataTypeMismatchException {
        Object[] objArr = ArrayUtils.EMPTY_OBJECT_ARRAY;
        if (obj == null) {
            return objArr;
        }
        if (MultiValuedMap.class.isAssignableFrom(obj.getClass())) {
            return ((MultiValuedMap) obj).get(i).toArray(ArrayUtils.EMPTY_OBJECT_ARRAY);
        }
        throw new CsvDataTypeMismatchException(obj, String.class, ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("field.not.multivaluedmap"));
    }

    @Override // com.opencsv.bean.AbstractBeanField
    protected boolean isFieldEmptyForWrite(Object obj) {
        return super.isFieldEmptyForWrite(obj) || ((MultiValuedMap) obj).isEmpty();
    }
}