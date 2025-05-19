package org.apache.commons.beanutils;

/* loaded from: classes4.dex */
public class BeanUtilsBean2 extends BeanUtilsBean {
    public BeanUtilsBean2() {
        super(new ConvertUtilsBean2());
    }

    @Override // org.apache.commons.beanutils.BeanUtilsBean
    protected Object convert(Object obj, Class<?> cls) {
        return getConvertUtils().convert(obj, cls);
    }
}
