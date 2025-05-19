package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class JavaBeanSerializer extends SerializeFilterable implements ObjectSerializer {
    protected SerializeBeanInfo beanInfo;
    protected final FieldSerializer[] getters;
    private volatile transient long[] hashArray;
    private volatile transient short[] hashArrayMapping;
    protected final FieldSerializer[] sortedGetters;

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (Map<String, String>) null);
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, createAliasMap(strArr));
    }

    static Map<String, String> createAliasMap(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public Class<?> getType() {
        return this.beanInfo.beanType;
    }

    public JavaBeanSerializer(Class<?> cls, Map<String, String> map) {
        this(TypeUtils.buildBeanInfo(cls, map, null));
    }

    public JavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) {
        boolean z;
        this.beanInfo = serializeBeanInfo;
        this.sortedGetters = new FieldSerializer[serializeBeanInfo.sortedFields.length];
        int i = 0;
        while (true) {
            FieldSerializer[] fieldSerializerArr = this.sortedGetters;
            if (i >= fieldSerializerArr.length) {
                break;
            }
            fieldSerializerArr[i] = new FieldSerializer(serializeBeanInfo.beanType, serializeBeanInfo.sortedFields[i]);
            i++;
        }
        if (serializeBeanInfo.fields == serializeBeanInfo.sortedFields) {
            this.getters = this.sortedGetters;
        } else {
            this.getters = new FieldSerializer[serializeBeanInfo.fields.length];
            int i2 = 0;
            while (true) {
                if (i2 >= this.getters.length) {
                    z = false;
                    break;
                }
                FieldSerializer fieldSerializer = getFieldSerializer(serializeBeanInfo.fields[i2].name);
                if (fieldSerializer == null) {
                    z = true;
                    break;
                } else {
                    this.getters[i2] = fieldSerializer;
                    i2++;
                }
            }
            if (z) {
                FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                System.arraycopy(fieldSerializerArr2, 0, this.getters, 0, fieldSerializerArr2.length);
            }
        }
        if (serializeBeanInfo.jsonType != null) {
            for (Class<? extends SerializeFilter> cls : serializeBeanInfo.jsonType.serialzeFilters()) {
                try {
                    addFilter(cls.getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                }
            }
        }
        if (serializeBeanInfo.jsonType != null) {
            for (Class<? extends SerializeFilter> cls2 : serializeBeanInfo.jsonType.serialzeFilters()) {
                try {
                    addFilter(cls2.getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused2) {
                }
            }
        }
    }

    public void writeDirectNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeAsArray(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeAsArrayNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    public void writeNoneASM(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:278:0x0401, code lost:
    
        if (r5 == 0) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f1, code lost:
    
        if (r14.fieldTransient != false) goto L76;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x03e2 A[Catch: Exception -> 0x040c, all -> 0x0465, TryCatch #3 {Exception -> 0x040c, blocks: (B:113:0x014c, B:120:0x0178, B:123:0x019c, B:125:0x01a4, B:128:0x01b5, B:130:0x01c0, B:132:0x01c4, B:136:0x01cb, B:138:0x01ce, B:140:0x01d3, B:143:0x01dd, B:145:0x01e8, B:147:0x01ec, B:150:0x01f3, B:152:0x01f6, B:155:0x01fe, B:157:0x0206, B:159:0x0211, B:161:0x0215, B:164:0x021c, B:166:0x021f, B:168:0x0224, B:169:0x0229, B:171:0x0231, B:173:0x023c, B:175:0x0240, B:178:0x0247, B:180:0x024a, B:182:0x024f, B:184:0x0256, B:186:0x025a, B:190:0x0268, B:192:0x026c, B:194:0x0275, B:196:0x0280, B:198:0x0286, B:200:0x028a, B:203:0x0295, B:205:0x0299, B:207:0x029d, B:210:0x02a8, B:212:0x02ac, B:214:0x02b0, B:217:0x02bb, B:219:0x02bf, B:221:0x02c3, B:224:0x02d1, B:226:0x02d5, B:228:0x02d9, B:231:0x02e6, B:233:0x02ea, B:235:0x02ee, B:238:0x02fc, B:240:0x0300, B:242:0x0304, B:246:0x0310, B:248:0x0314, B:250:0x0318, B:252:0x0328, B:254:0x0335, B:257:0x033f, B:258:0x0345, B:260:0x03d0, B:262:0x03d4, B:264:0x03d8, B:269:0x03e2, B:271:0x03ea, B:272:0x03f2, B:274:0x03f8, B:287:0x0351, B:288:0x0354, B:291:0x035c, B:294:0x0362, B:296:0x0377, B:299:0x0381, B:302:0x038b, B:304:0x0394, B:307:0x039e, B:308:0x03a2, B:309:0x03a6, B:311:0x03ad, B:312:0x03b1, B:313:0x03b5, B:315:0x03b9, B:317:0x03bd, B:320:0x03c9, B:321:0x03cd, B:322:0x036d), top: B:112:0x014c }] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x045b A[Catch: all -> 0x0465, Exception -> 0x046a, TRY_LEAVE, TryCatch #4 {all -> 0x0465, blocks: (B:54:0x00e1, B:58:0x00ef, B:98:0x0106, B:100:0x010c, B:103:0x011a, B:105:0x0120, B:107:0x012a, B:113:0x014c, B:326:0x0160, B:329:0x016d, B:120:0x0178, B:123:0x019c, B:125:0x01a4, B:128:0x01b5, B:130:0x01c0, B:132:0x01c4, B:136:0x01cb, B:138:0x01ce, B:140:0x01d3, B:143:0x01dd, B:145:0x01e8, B:147:0x01ec, B:150:0x01f3, B:152:0x01f6, B:155:0x01fe, B:157:0x0206, B:159:0x0211, B:161:0x0215, B:164:0x021c, B:166:0x021f, B:168:0x0224, B:169:0x0229, B:171:0x0231, B:173:0x023c, B:175:0x0240, B:178:0x0247, B:180:0x024a, B:182:0x024f, B:184:0x0256, B:186:0x025a, B:190:0x0268, B:192:0x026c, B:194:0x0275, B:196:0x0280, B:198:0x0286, B:200:0x028a, B:203:0x0295, B:205:0x0299, B:207:0x029d, B:210:0x02a8, B:212:0x02ac, B:214:0x02b0, B:217:0x02bb, B:219:0x02bf, B:221:0x02c3, B:224:0x02d1, B:226:0x02d5, B:228:0x02d9, B:231:0x02e6, B:233:0x02ea, B:235:0x02ee, B:238:0x02fc, B:240:0x0300, B:242:0x0304, B:246:0x0310, B:248:0x0314, B:250:0x0318, B:252:0x0328, B:254:0x0335, B:257:0x033f, B:258:0x0345, B:260:0x03d0, B:262:0x03d4, B:264:0x03d8, B:269:0x03e2, B:271:0x03ea, B:272:0x03f2, B:274:0x03f8, B:287:0x0351, B:288:0x0354, B:291:0x035c, B:294:0x0362, B:296:0x0377, B:299:0x0381, B:302:0x038b, B:304:0x0394, B:307:0x039e, B:308:0x03a2, B:309:0x03a6, B:311:0x03ad, B:312:0x03b1, B:313:0x03b5, B:315:0x03b9, B:317:0x03bd, B:320:0x03c9, B:321:0x03cd, B:322:0x036d, B:338:0x0138, B:344:0x0141, B:348:0x0415, B:368:0x0443, B:370:0x044b, B:372:0x0453, B:374:0x045b), top: B:53:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x04a5 A[Catch: all -> 0x0532, TRY_ENTER, TryCatch #11 {all -> 0x0532, blocks: (B:95:0x0480, B:71:0x04a5, B:72:0x04fe, B:74:0x0504, B:75:0x051f, B:77:0x0523, B:80:0x052c, B:81:0x0531, B:88:0x04bd, B:90:0x04c1, B:92:0x04c7, B:93:0x04e5), top: B:94:0x0480 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0504 A[Catch: all -> 0x0532, TryCatch #11 {all -> 0x0532, blocks: (B:95:0x0480, B:71:0x04a5, B:72:0x04fe, B:74:0x0504, B:75:0x051f, B:77:0x0523, B:80:0x052c, B:81:0x0531, B:88:0x04bd, B:90:0x04c1, B:92:0x04c7, B:93:0x04e5), top: B:94:0x0480 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0523 A[Catch: all -> 0x0532, TryCatch #11 {all -> 0x0532, blocks: (B:95:0x0480, B:71:0x04a5, B:72:0x04fe, B:74:0x0504, B:75:0x051f, B:77:0x0523, B:80:0x052c, B:81:0x0531, B:88:0x04bd, B:90:0x04c1, B:92:0x04c7, B:93:0x04e5), top: B:94:0x0480 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0529  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0480 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void write(com.alibaba.fastjson.serializer.JSONSerializer r32, java.lang.Object r33, java.lang.Object r34, java.lang.reflect.Type r35, int r36, boolean r37) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }

    protected void writeClassName(JSONSerializer jSONSerializer, String str, Object obj) {
        if (str == null) {
            str = jSONSerializer.config.typeKey;
        }
        jSONSerializer.out.writeFieldName(str, false);
        String str2 = this.beanInfo.typeName;
        if (str2 == null) {
            Class<?> cls = obj.getClass();
            if (TypeUtils.isProxy(cls)) {
                cls = cls.getSuperclass();
            }
            str2 = cls.getName();
        }
        jSONSerializer.write(str2);
    }

    public boolean writeReference(JSONSerializer jSONSerializer, Object obj, int i) {
        SerialContext serialContext = jSONSerializer.context;
        int i2 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if (serialContext == null || (serialContext.features & i2) != 0 || (i & i2) != 0 || jSONSerializer.references == null || !jSONSerializer.references.containsKey(obj)) {
            return false;
        }
        jSONSerializer.writeReference(obj);
        return true;
    }

    protected boolean isWriteAsArray(JSONSerializer jSONSerializer) {
        return isWriteAsArray(jSONSerializer, 0);
    }

    protected boolean isWriteAsArray(JSONSerializer jSONSerializer, int i) {
        int i2 = SerializerFeature.BeanToArray.mask;
        return ((this.beanInfo.features & i2) == 0 && !jSONSerializer.out.beanToArray && (i & i2) == 0) ? false : true;
    }

    public Object getFieldValue(Object obj, String str) {
        FieldSerializer fieldSerializer = getFieldSerializer(str);
        if (fieldSerializer == null) {
            throw new JSONException("field not found. " + str);
        }
        try {
            return fieldSerializer.getPropertyValue(obj);
        } catch (IllegalAccessException e) {
            throw new JSONException("getFieldValue error." + str, e);
        } catch (InvocationTargetException e2) {
            throw new JSONException("getFieldValue error." + str, e2);
        }
    }

    public Object getFieldValue(Object obj, String str, long j, boolean z) {
        FieldSerializer fieldSerializer = getFieldSerializer(j);
        if (fieldSerializer == null) {
            if (z) {
                throw new JSONException("field not found. " + str);
            }
            return null;
        }
        try {
            return fieldSerializer.getPropertyValue(obj);
        } catch (IllegalAccessException e) {
            throw new JSONException("getFieldValue error." + str, e);
        } catch (InvocationTargetException e2) {
            throw new JSONException("getFieldValue error." + str, e2);
        }
    }

    public FieldSerializer getFieldSerializer(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        int length = this.sortedGetters.length - 1;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int compareTo = this.sortedGetters[i2].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else {
                if (compareTo <= 0) {
                    return this.sortedGetters[i2];
                }
                length = i2 - 1;
            }
        }
        return null;
    }

    public FieldSerializer getFieldSerializer(long j) {
        PropertyNamingStrategy[] propertyNamingStrategyArr;
        int binarySearch;
        if (this.hashArray == null) {
            propertyNamingStrategyArr = PropertyNamingStrategy.values();
            long[] jArr = new long[this.sortedGetters.length * propertyNamingStrategyArr.length];
            int i = 0;
            int i2 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr = this.sortedGetters;
                if (i >= fieldSerializerArr.length) {
                    break;
                }
                String str = fieldSerializerArr[i].fieldInfo.name;
                jArr[i2] = TypeUtils.fnv1a_64(str);
                i2++;
                for (PropertyNamingStrategy propertyNamingStrategy : propertyNamingStrategyArr) {
                    String translate = propertyNamingStrategy.translate(str);
                    if (!str.equals(translate)) {
                        jArr[i2] = TypeUtils.fnv1a_64(translate);
                        i2++;
                    }
                }
                i++;
            }
            Arrays.sort(jArr, 0, i2);
            this.hashArray = new long[i2];
            System.arraycopy(jArr, 0, this.hashArray, 0, i2);
        } else {
            propertyNamingStrategyArr = null;
        }
        int binarySearch2 = Arrays.binarySearch(this.hashArray, j);
        if (binarySearch2 < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            if (propertyNamingStrategyArr == null) {
                propertyNamingStrategyArr = PropertyNamingStrategy.values();
            }
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, (short) -1);
            int i3 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                if (i3 >= fieldSerializerArr2.length) {
                    break;
                }
                String str2 = fieldSerializerArr2[i3].fieldInfo.name;
                int binarySearch3 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(str2));
                if (binarySearch3 >= 0) {
                    sArr[binarySearch3] = (short) i3;
                }
                for (PropertyNamingStrategy propertyNamingStrategy2 : propertyNamingStrategyArr) {
                    String translate2 = propertyNamingStrategy2.translate(str2);
                    if (!str2.equals(translate2) && (binarySearch = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(translate2))) >= 0) {
                        sArr[binarySearch] = (short) i3;
                    }
                }
                i3++;
            }
            this.hashArrayMapping = sArr;
        }
        short s = this.hashArrayMapping[binarySearch2];
        if (s != -1) {
            return this.sortedGetters[s];
        }
        return null;
    }

    public List<Object> getFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            arrayList.add(fieldSerializer.getPropertyValue(obj));
        }
        return arrayList;
    }

    public List<Object> getObjectFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            Class<?> cls = fieldSerializer.fieldInfo.fieldClass;
            if (!cls.isPrimitive() && !cls.getName().startsWith("java.lang.")) {
                arrayList.add(fieldSerializer.getPropertyValue(obj));
            }
        }
        return arrayList;
    }

    public int getSize(Object obj) throws Exception {
        int i = 0;
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                i++;
            }
        }
        return i;
    }

    public Set<String> getFieldNames(Object obj) throws Exception {
        HashSet hashSet = new HashSet();
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                hashSet.add(fieldSerializer.fieldInfo.name);
            }
        }
        return hashSet;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
        }
        return linkedHashMap;
    }

    protected BeanContext getBeanContext(int i) {
        return this.sortedGetters[i].fieldContext;
    }

    protected Type getFieldType(int i) {
        return this.sortedGetters[i].fieldInfo.fieldType;
    }

    protected char writeBefore(JSONSerializer jSONSerializer, Object obj, char c) {
        if (jSONSerializer.beforeFilters != null) {
            Iterator<BeforeFilter> it = jSONSerializer.beforeFilters.iterator();
            while (it.hasNext()) {
                c = it.next().writeBefore(jSONSerializer, obj, c);
            }
        }
        if (this.beforeFilters != null) {
            Iterator<BeforeFilter> it2 = this.beforeFilters.iterator();
            while (it2.hasNext()) {
                c = it2.next().writeBefore(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    protected char writeAfter(JSONSerializer jSONSerializer, Object obj, char c) {
        if (jSONSerializer.afterFilters != null) {
            Iterator<AfterFilter> it = jSONSerializer.afterFilters.iterator();
            while (it.hasNext()) {
                c = it.next().writeAfter(jSONSerializer, obj, c);
            }
        }
        if (this.afterFilters != null) {
            Iterator<AfterFilter> it2 = this.afterFilters.iterator();
            while (it2.hasNext()) {
                c = it2.next().writeAfter(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    protected boolean applyLabel(JSONSerializer jSONSerializer, String str) {
        if (jSONSerializer.labelFilters != null) {
            Iterator<LabelFilter> it = jSONSerializer.labelFilters.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(str)) {
                    return false;
                }
            }
        }
        if (this.labelFilters == null) {
            return true;
        }
        Iterator<LabelFilter> it2 = this.labelFilters.iterator();
        while (it2.hasNext()) {
            if (!it2.next().apply(str)) {
                return false;
            }
        }
        return true;
    }
}
