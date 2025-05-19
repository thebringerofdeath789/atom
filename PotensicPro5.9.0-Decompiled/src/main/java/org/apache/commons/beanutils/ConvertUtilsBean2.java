package org.apache.commons.beanutils;

/* loaded from: classes4.dex */
public class ConvertUtilsBean2 extends ConvertUtilsBean {
    @Override // org.apache.commons.beanutils.ConvertUtilsBean
    public String convert(Object obj) {
        return (String) convert(obj, String.class);
    }

    @Override // org.apache.commons.beanutils.ConvertUtilsBean
    public Object convert(String str, Class<?> cls) {
        return convert((Object) str, cls);
    }

    @Override // org.apache.commons.beanutils.ConvertUtilsBean
    public Object convert(String[] strArr, Class<?> cls) {
        return convert((Object) strArr, cls);
    }
}
