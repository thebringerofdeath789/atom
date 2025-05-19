package org.apache.commons.beanutils;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public class ConvertingWrapDynaBean extends WrapDynaBean {
    public ConvertingWrapDynaBean(Object obj) {
        super(obj);
    }

    @Override // org.apache.commons.beanutils.WrapDynaBean, org.apache.commons.beanutils.DynaBean
    public void set(String str, Object obj) {
        try {
            BeanUtils.copyProperty(this.instance, str, obj);
        } catch (InvocationTargetException e) {
            throw new IllegalArgumentException("Error setting property '" + str + "' nested exception - " + e.getTargetException());
        } catch (Throwable th) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Error setting property '" + str + "', exception - " + th);
            BeanUtils.initCause(illegalArgumentException, th);
            throw illegalArgumentException;
        }
    }
}
