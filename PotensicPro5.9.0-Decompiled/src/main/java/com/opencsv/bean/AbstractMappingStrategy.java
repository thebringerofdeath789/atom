package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.bean.AbstractMappingStrategy;
import com.opencsv.bean.ComplexFieldMapEntry;
import com.opencsv.exceptions.CsvBadConverterException;
import com.opencsv.exceptions.CsvBeanIntrospectionException;
import com.opencsv.exceptions.CsvChainedException;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvFieldAssignmentException;
import com.opencsv.exceptions.CsvRecursionException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;
import java.lang.Comparable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.SetUtils;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

/* loaded from: classes3.dex */
public abstract class AbstractMappingStrategy<I, K extends Comparable<K>, C extends ComplexFieldMapEntry<I, K, T>, T> implements MappingStrategy<T> {
    private static final Set<Class> FORBIDDEN_CLASSES_FOR_RECURSION = new HashSet(Arrays.asList(Byte.TYPE, Short.TYPE, Integer.TYPE, Float.TYPE, Double.TYPE, Boolean.TYPE, Long.TYPE, Character.TYPE));
    private RecursiveType recursiveTypeTree;
    protected Class<? extends T> type;
    protected final HeaderIndex headerIndex = new HeaderIndex();
    private MultiValuedMap<Class<?>, Field> ignoredFields = new ArrayListValuedHashMap();
    protected Locale errorLocale = Locale.getDefault();
    protected String profile = "";

    protected abstract K chooseMultivaluedFieldIndexFromHeaderIndex(int i);

    protected abstract BeanField<T, K> findField(int i);

    public abstract String findHeader(int i);

    protected abstract FieldMap<I, K, ? extends C, T> getFieldMap();

    protected abstract void initializeFieldMap();

    protected void loadAnnotatedFieldMap(ListValuedMap<Class<?>, Field> listValuedMap) {
    }

    protected abstract void loadUnadornedFieldMap(ListValuedMap<Class<?>, Field> listValuedMap);

    protected abstract void verifyLineLength(int i) throws CsvRequiredFieldEmptyException;

    protected Set<Class<? extends Annotation>> getBindingAnnotations() {
        return Collections.emptySet();
    }

    protected Map<Class<?>, Object> createBean() throws CsvBeanIntrospectionException, IllegalStateException {
        if (this.type == null) {
            throw new IllegalStateException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("type.unset"));
        }
        HashMap hashMap = new HashMap();
        try {
            T newInstance = this.type.newInstance();
            hashMap.put(this.type, newInstance);
            createSubordinateBeans(this.recursiveTypeTree, hashMap, newInstance);
            return hashMap;
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            CsvBeanIntrospectionException csvBeanIntrospectionException = new CsvBeanIntrospectionException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("bean.instantiation.impossible"));
            csvBeanIntrospectionException.initCause(e);
            throw csvBeanIntrospectionException;
        }
    }

    private static void createSubordinateBeans(RecursiveType recursiveType, Map<Class<?>, Object> map, Object obj) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        for (Map.Entry<FieldAccess<Object>, RecursiveType> entry : recursiveType.getRecursiveMembers().entrySet()) {
            Object field = entry.getKey().getField(obj);
            if (field == null) {
                field = entry.getValue().type.newInstance();
                entry.getKey().setField(obj, field);
            }
            map.put(entry.getValue().getType(), field);
            createSubordinateBeans(entry.getValue(), map, field);
        }
    }

    protected Map<Class<?>, Object> indexBean(T t) throws IllegalAccessException, InvocationTargetException {
        HashMap hashMap = new HashMap();
        hashMap.put(this.type, t);
        indexSubordinateBeans(this.recursiveTypeTree, hashMap, t);
        return hashMap;
    }

    private static void indexSubordinateBeans(RecursiveType recursiveType, Map<Class<?>, Object> map, Object obj) throws IllegalAccessException, InvocationTargetException {
        for (Map.Entry<FieldAccess<Object>, RecursiveType> entry : recursiveType.getRecursiveMembers().entrySet()) {
            Object field = obj == null ? null : entry.getKey().getField(obj);
            map.put(entry.getValue().getType(), field);
            indexSubordinateBeans(entry.getValue(), map, field);
        }
    }

    @Override // com.opencsv.bean.MappingStrategy
    public String[] generateHeader(T t) throws CsvRequiredFieldEmptyException {
        if (this.type == null) {
            throw new IllegalStateException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("type.before.header"));
        }
        if (this.headerIndex.isEmpty()) {
            String[] generateHeader = getFieldMap().generateHeader(t);
            this.headerIndex.initializeHeaderIndex(generateHeader);
            return generateHeader;
        }
        return this.headerIndex.getHeaderIndex();
    }

    String getColumnName(int i) {
        return this.headerIndex.getByPosition(i);
    }

    public Class<? extends T> getType() {
        return this.type;
    }

    @Override // com.opencsv.bean.MappingStrategy
    public T populateNewBean(String[] strArr) throws CsvBeanIntrospectionException, CsvFieldAssignmentException, CsvChainedException {
        verifyLineLength(strArr.length);
        Map<Class<?>, Object> createBean = createBean();
        CsvChainedException csvChainedException = null;
        for (int i = 0; i < strArr.length; i++) {
            try {
                setFieldValue(createBean, strArr[i], i);
            } catch (CsvFieldAssignmentException e) {
                if (csvChainedException != null) {
                    csvChainedException.add(e);
                } else {
                    csvChainedException = new CsvChainedException(e);
                }
            }
        }
        if (csvChainedException != null) {
            if (csvChainedException.hasOnlyOneException()) {
                throw csvChainedException.getFirstException();
            }
            throw csvChainedException;
        }
        return (T) createBean.get(this.type);
    }

    @Override // com.opencsv.bean.MappingStrategy
    public void setType(Class<? extends T> cls) throws CsvBadConverterException {
        this.type = cls;
        loadFieldMap();
    }

    @Override // com.opencsv.bean.MappingStrategy
    public void setProfile(String str) {
        this.profile = StringUtils.defaultString(str);
    }

    @Override // com.opencsv.bean.MappingStrategy
    public void ignoreFields(MultiValuedMap<Class<?>, Field> multiValuedMap) throws IllegalArgumentException {
        if (multiValuedMap == null) {
            this.ignoredFields = new ArrayListValuedHashMap();
        } else {
            this.ignoredFields = multiValuedMap;
            final MapIterator<Class<?>, Field> mapIterator = multiValuedMap.mapIterator();
            mapIterator.forEachRemaining(new Consumer() { // from class: com.opencsv.bean.-$$Lambda$AbstractMappingStrategy$IxsW_7ELg2bL70qN8BXcXXrmPyQ
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    AbstractMappingStrategy.this.lambda$ignoreFields$0$AbstractMappingStrategy(mapIterator, (Class) obj);
                }
            });
        }
        if (this.type != null) {
            loadFieldMap();
        }
    }

    public /* synthetic */ void lambda$ignoreFields$0$AbstractMappingStrategy(MapIterator mapIterator, Class cls) {
        Field field = (Field) mapIterator.getValue();
        if (cls == null || field == null || !field.getDeclaringClass().isAssignableFrom(cls)) {
            throw new IllegalArgumentException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("ignore.field.inconsistent"));
        }
    }

    protected List<Field> filterIgnoredFields(Class<?> cls, Field[] fieldArr) {
        Set hashSet;
        LinkedList linkedList = new LinkedList();
        for (Field field : fieldArr) {
            CsvIgnore csvIgnore = (CsvIgnore) field.getAnnotation(CsvIgnore.class);
            if (csvIgnore == null) {
                hashSet = SetUtils.emptySet();
            } else {
                hashSet = new HashSet(Arrays.asList(csvIgnore.profiles()));
            }
            if (!this.ignoredFields.containsMapping(cls, field) && !hashSet.contains(this.profile) && !hashSet.contains("")) {
                linkedList.add(field);
            }
        }
        return linkedList;
    }

    protected void loadFieldMap() throws CsvBadConverterException {
        initializeFieldMap();
        this.recursiveTypeTree = loadRecursiveClasses(this.type, new HashSet());
        Map<Boolean, ListValuedMap<Class<?>, Field>> partitionFields = partitionFields();
        if (!partitionFields.get(Boolean.TRUE).isEmpty()) {
            loadAnnotatedFieldMap(partitionFields.get(Boolean.TRUE));
        } else {
            loadUnadornedFieldMap(partitionFields.get(Boolean.FALSE));
        }
    }

    protected boolean isForbiddenClassForRecursion(Class<?> cls) {
        return FORBIDDEN_CLASSES_FOR_RECURSION.contains(cls);
    }

    protected RecursiveType loadRecursiveClasses(Class<?> cls, Set<Class<?>> set) {
        if (isForbiddenClassForRecursion(cls)) {
            throw new CsvRecursionException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("recursion.on.primitive"), cls);
        }
        if (set.contains(cls)) {
            throw new CsvRecursionException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("recursive.type.encountered.twice"), cls.toString()), cls);
        }
        set.add(cls);
        RecursiveType recursiveType = new RecursiveType(cls);
        for (final Field field : filterIgnoredFields(cls, FieldUtils.getFieldsWithAnnotation(cls, CsvRecurse.class))) {
            Stream<Class<? extends Annotation>> stream = getBindingAnnotations().stream();
            field.getClass();
            if (stream.anyMatch(new Predicate() { // from class: com.opencsv.bean.-$$Lambda$AbstractMappingStrategy$DkOTCYBYCF30YKlNOUh77nF4zEY
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean isAnnotationPresent;
                    isAnnotationPresent = field.isAnnotationPresent((Class) obj);
                    return isAnnotationPresent;
                }
            })) {
                throw new CsvRecursionException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("recursion.binding.mutually.exclusive"), field.getType());
            }
            recursiveType.addRecursiveMember(new FieldAccess<>(field), loadRecursiveClasses(field.getType(), set));
        }
        return recursiveType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: assembleCompleteFieldList, reason: merged with bridge method [inline-methods] */
    public void lambda$assembleCompleteFieldList$1$AbstractMappingStrategy(RecursiveType recursiveType, final ListValuedMap<Class<?>, Field> listValuedMap) {
        listValuedMap.putAll(recursiveType.type, filterIgnoredFields(recursiveType.type, FieldUtils.getAllFields(recursiveType.type)));
        recursiveType.getRecursiveMembers().values().forEach(new Consumer() { // from class: com.opencsv.bean.-$$Lambda$AbstractMappingStrategy$PXHbEc7wc7pz6-sWemWTqXxSecc
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                AbstractMappingStrategy.this.lambda$assembleCompleteFieldList$1$AbstractMappingStrategy(listValuedMap, (AbstractMappingStrategy.RecursiveType) obj);
            }
        });
    }

    protected Map<Boolean, ListValuedMap<Class<?>, Field>> partitionFields() {
        ArrayListValuedHashMap arrayListValuedHashMap = new ArrayListValuedHashMap();
        lambda$assembleCompleteFieldList$1$AbstractMappingStrategy(this.recursiveTypeTree, arrayListValuedHashMap);
        final Set<Class<? extends Annotation>> bindingAnnotations = getBindingAnnotations();
        final TreeMap treeMap = new TreeMap();
        treeMap.put(Boolean.TRUE, new ArrayListValuedHashMap());
        treeMap.put(Boolean.FALSE, new ArrayListValuedHashMap());
        arrayListValuedHashMap.entries().stream().filter(new Predicate() { // from class: com.opencsv.bean.-$$Lambda$AbstractMappingStrategy$_-jZ73PwKPSnVfnhxmOhaxjD0zg
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return AbstractMappingStrategy.lambda$partitionFields$2((Map.Entry) obj);
            }
        }).forEach(new Consumer() { // from class: com.opencsv.bean.-$$Lambda$AbstractMappingStrategy$hbg0kYrw7ImoEMBWkkE3oRDXvsE
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                AbstractMappingStrategy.lambda$partitionFields$4(bindingAnnotations, treeMap, (Map.Entry) obj);
            }
        });
        return treeMap;
    }

    static /* synthetic */ boolean lambda$partitionFields$2(Map.Entry entry) {
        return !((Field) entry.getValue()).isSynthetic();
    }

    static /* synthetic */ void lambda$partitionFields$4(Set set, Map map, final Map.Entry entry) {
        if (set.stream().anyMatch(new Predicate() { // from class: com.opencsv.bean.-$$Lambda$AbstractMappingStrategy$1FF-Ow-9wFcrI28gNF4lU1TNLJ4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean isAnnotationPresent;
                isAnnotationPresent = ((Field) entry.getValue()).isAnnotationPresent((Class) obj);
                return isAnnotationPresent;
            }
        })) {
            ((ListValuedMap) map.get(Boolean.TRUE)).put(entry.getKey(), entry.getValue());
        } else {
            ((ListValuedMap) map.get(Boolean.FALSE)).put(entry.getKey(), entry.getValue());
        }
    }

    protected BeanField<T, K> instantiateCustomConverter(Class<? extends AbstractBeanField<T, K>> cls) throws CsvBadConverterException {
        try {
            AbstractBeanField<T, K> newInstance = cls.newInstance();
            newInstance.setErrorLocale(this.errorLocale);
            return newInstance;
        } catch (IllegalAccessException | InstantiationException e) {
            CsvBadConverterException csvBadConverterException = new CsvBadConverterException(cls, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("custom.converter.invalid"), cls.getCanonicalName()));
            csvBadConverterException.initCause(e);
            throw csvBadConverterException;
        }
    }

    @Override // com.opencsv.bean.MappingStrategy
    public void setErrorLocale(Locale locale) {
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
        if (getFieldMap() != null) {
            getFieldMap().setErrorLocale(this.errorLocale);
            getFieldMap().values().forEach(new Consumer() { // from class: com.opencsv.bean.-$$Lambda$AbstractMappingStrategy$23gFLUYPyyskh2EKaUE1H1aTAKg
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    AbstractMappingStrategy.this.lambda$setErrorLocale$5$AbstractMappingStrategy((BeanField) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$setErrorLocale$5$AbstractMappingStrategy(BeanField beanField) {
        beanField.setErrorLocale(this.errorLocale);
    }

    protected void setFieldValue(Map<Class<?>, Object> map, String str, int i) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, CsvConstraintViolationException, CsvValidationException {
        BeanField<T, K> findField = findField(i);
        if (findField != null) {
            findField.setFieldValue(map.get(findField.getType()), str, findHeader(i));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x008d, code lost:
    
        r2 = findField(r0);
        r8 = chooseMultivaluedFieldIndexFromHeaderIndex(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0099, code lost:
    
        if (java.util.Objects.equals(r9, r2) == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009f, code lost:
    
        if (java.util.Objects.equals(r10, r8) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a1, code lost:
    
        if (r0 >= r3) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a3, code lost:
    
        r4.add("");
        r0 = r0 + 1;
        r2 = findField(r0);
        r8 = chooseMultivaluedFieldIndexFromHeaderIndex(r0);
     */
    @Override // com.opencsv.bean.MappingStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String[] transmuteBean(T r17) throws com.opencsv.exceptions.CsvFieldAssignmentException, com.opencsv.exceptions.CsvChainedException {
        /*
            r16 = this;
            r1 = r16
            com.opencsv.bean.HeaderIndex r0 = r1.headerIndex
            int r0 = r0.findMaxIndex()
            r2 = 1
            int r3 = r0 + 1
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 0
            int r0 = java.lang.Math.max(r3, r5)
            r4.<init>(r0)
            java.util.Map r6 = r16.indexBean(r17)     // Catch: java.lang.reflect.InvocationTargetException -> Lcc java.lang.IllegalAccessException -> Lce
            r0 = 0
            r7 = r0
            r8 = r5
        L1c:
            if (r8 >= r3) goto Lb5
            com.opencsv.bean.BeanField r9 = r1.findField(r8)
            java.lang.Comparable r10 = r1.chooseMultivaluedFieldIndexFromHeaderIndex(r8)
            java.lang.String[] r11 = org.apache.commons.lang3.ArrayUtils.EMPTY_STRING_ARRAY
            if (r9 == 0) goto L45
            java.lang.Class r0 = r9.getType()     // Catch: com.opencsv.exceptions.CsvRequiredFieldEmptyException -> L37 com.opencsv.exceptions.CsvDataTypeMismatchException -> L39
            java.lang.Object r0 = r6.get(r0)     // Catch: com.opencsv.exceptions.CsvRequiredFieldEmptyException -> L37 com.opencsv.exceptions.CsvDataTypeMismatchException -> L39
            java.lang.String[] r11 = r9.write(r0, r10)     // Catch: com.opencsv.exceptions.CsvRequiredFieldEmptyException -> L37 com.opencsv.exceptions.CsvDataTypeMismatchException -> L39
            goto L45
        L37:
            r0 = move-exception
            goto L3a
        L39:
            r0 = move-exception
        L3a:
            if (r7 == 0) goto L40
            r7.add(r0)
            goto L45
        L40:
            com.opencsv.exceptions.CsvChainedException r7 = new com.opencsv.exceptions.CsvChainedException
            r7.<init>(r0)
        L45:
            int r0 = r11.length
            java.lang.String r12 = ""
            if (r0 != 0) goto L50
            r4.add(r12)
            int r8 = r8 + 1
            goto Lb2
        L50:
            r0 = r11[r5]
            java.lang.String r0 = org.apache.commons.lang3.StringUtils.defaultString(r0)
            r4.add(r0)
            int r0 = r8 + 1
            com.opencsv.bean.BeanField r13 = r1.findField(r0)
            java.lang.Comparable r14 = r1.chooseMultivaluedFieldIndexFromHeaderIndex(r0)
            r15 = r2
        L64:
            int r2 = r11.length
            if (r15 >= r2) goto L8b
            if (r0 >= r3) goto L8b
            boolean r2 = java.util.Objects.equals(r9, r13)
            if (r2 == 0) goto L8b
            boolean r2 = java.util.Objects.equals(r10, r14)
            if (r2 == 0) goto L8b
            r0 = r11[r15]
            java.lang.String r0 = org.apache.commons.lang3.StringUtils.defaultString(r0)
            r4.add(r0)
            int r15 = r15 + 1
            int r0 = r8 + r15
            com.opencsv.bean.BeanField r13 = r1.findField(r0)
            java.lang.Comparable r14 = r1.chooseMultivaluedFieldIndexFromHeaderIndex(r0)
            goto L64
        L8b:
            if (r0 >= r3) goto Lb1
            com.opencsv.bean.BeanField r2 = r1.findField(r0)
            java.lang.Comparable r8 = r1.chooseMultivaluedFieldIndexFromHeaderIndex(r0)
        L95:
            boolean r2 = java.util.Objects.equals(r9, r2)
            if (r2 == 0) goto Lb1
            boolean r2 = java.util.Objects.equals(r10, r8)
            if (r2 == 0) goto Lb1
            if (r0 >= r3) goto Lb1
            r4.add(r12)
            int r0 = r0 + 1
            com.opencsv.bean.BeanField r2 = r1.findField(r0)
            java.lang.Comparable r8 = r1.chooseMultivaluedFieldIndexFromHeaderIndex(r0)
            goto L95
        Lb1:
            r8 = r0
        Lb2:
            r2 = 1
            goto L1c
        Lb5:
            if (r7 == 0) goto Lc3
            boolean r0 = r7.hasOnlyOneException()
            if (r0 == 0) goto Lc2
            com.opencsv.exceptions.CsvFieldAssignmentException r0 = r7.getFirstException()
            throw r0
        Lc2:
            throw r7
        Lc3:
            java.lang.String[] r0 = org.apache.commons.lang3.ArrayUtils.EMPTY_STRING_ARRAY
            java.lang.Object[] r0 = r4.toArray(r0)
            java.lang.String[] r0 = (java.lang.String[]) r0
            return r0
        Lcc:
            r0 = move-exception
            goto Lcf
        Lce:
            r0 = move-exception
        Lcf:
            com.opencsv.exceptions.CsvBeanIntrospectionException r2 = new com.opencsv.exceptions.CsvBeanIntrospectionException
            java.util.Locale r3 = r1.errorLocale
            java.lang.String r4 = "opencsv"
            java.util.ResourceBundle r3 = java.util.ResourceBundle.getBundle(r4, r3)
            java.lang.String r4 = "error.introspecting.beans"
            java.lang.String r3 = r3.getString(r4)
            r2.<init>(r3)
            r2.initCause(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opencsv.bean.AbstractMappingStrategy.transmuteBean(java.lang.Object):java.lang.String[]");
    }

    protected CsvConverter determineConverter(Field field, Class<?> cls, String str, String str2, Class<? extends AbstractCsvConverter> cls2) throws CsvBadConverterException {
        if (cls2 != null && !cls2.equals(AbstractCsvConverter.class)) {
            try {
                AbstractCsvConverter newInstance = cls2.newInstance();
                newInstance.setType(cls);
                newInstance.setLocale(str);
                newInstance.setWriteLocale(str2);
                newInstance.setErrorLocale(this.errorLocale);
                return newInstance;
            } catch (IllegalAccessException | InstantiationException e) {
                CsvBadConverterException csvBadConverterException = new CsvBadConverterException(cls2, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("custom.converter.invalid"), cls2.getCanonicalName()));
                csvBadConverterException.initCause(e);
                throw csvBadConverterException;
            }
        }
        if (field.isAnnotationPresent(CsvDate.class) || field.isAnnotationPresent(CsvDates.class)) {
            CsvDate csvDate = (CsvDate) selectAnnotationForProfile(field.getAnnotationsByType(CsvDate.class), new Function() { // from class: com.opencsv.bean.-$$Lambda$YSbZfM7ClO29wLYrg8ro0oR_NwE
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((CsvDate) obj).profiles();
                }
            });
            if (csvDate == null) {
                throw new CsvBadConverterException(CsvDate.class, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME).getString("profile.not.found.date"), this.profile));
            }
            String value = csvDate.value();
            String writeFormat = csvDate.writeFormatEqualsReadFormat() ? value : csvDate.writeFormat();
            String chronology = csvDate.chronology();
            return new ConverterDate(cls, str, str2, this.errorLocale, value, writeFormat, chronology, csvDate.writeChronologyEqualsReadChronology() ? chronology : csvDate.writeChronology());
        }
        if (field.isAnnotationPresent(CsvNumber.class) || field.isAnnotationPresent(CsvNumbers.class)) {
            CsvNumber csvNumber = (CsvNumber) selectAnnotationForProfile(field.getAnnotationsByType(CsvNumber.class), new Function() { // from class: com.opencsv.bean.-$$Lambda$1JH6sA1erJ9ACEHjYJ0XhpC9W78
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((CsvNumber) obj).profiles();
                }
            });
            if (csvNumber == null) {
                throw new CsvBadConverterException(CsvNumber.class, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME).getString("profile.not.found.number"), this.profile));
            }
            String value2 = csvNumber.value();
            return new ConverterNumber(cls, str, str2, this.errorLocale, value2, csvNumber.writeFormatEqualsReadFormat() ? value2 : csvNumber.writeFormat());
        }
        if (cls.equals(Currency.class)) {
            return new ConverterCurrency(this.errorLocale);
        }
        if (cls.isEnum()) {
            return new ConverterEnum(cls, str, str2, this.errorLocale);
        }
        if (cls.equals(UUID.class)) {
            return new ConverterUUID(this.errorLocale);
        }
        return new ConverterPrimitiveTypes(cls, str, str2, this.errorLocale);
    }

    protected <A extends Annotation> A selectAnnotationForProfile(A[] aArr, Function<A, String[]> function) {
        A a = null;
        for (A a2 : aArr) {
            for (String str : function.apply(a2)) {
                if (this.profile.equals(str)) {
                    return a2;
                }
                if ("".equals(str)) {
                    a = a2;
                }
            }
        }
        return a;
    }

    protected static class RecursiveType {
        private final Map<FieldAccess<Object>, RecursiveType> recursiveMembers = new HashMap();
        private final Class<?> type;

        RecursiveType(Class<?> cls) {
            this.type = cls;
        }

        public Class<?> getType() {
            return this.type;
        }

        public void addRecursiveMember(FieldAccess<Object> fieldAccess, RecursiveType recursiveType) {
            this.recursiveMembers.put(fieldAccess, recursiveType);
        }

        public Map<FieldAccess<Object>, RecursiveType> getRecursiveMembers() {
            return this.recursiveMembers;
        }
    }
}
