package org.apache.commons.beanutils;

/* loaded from: classes4.dex */
public class DynaBeanPropertyMapDecorator extends BaseDynaBeanMapDecorator<String> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.beanutils.BaseDynaBeanMapDecorator
    public String convertKey(String str) {
        return str;
    }

    public DynaBeanPropertyMapDecorator(DynaBean dynaBean, boolean z) {
        super(dynaBean, z);
    }

    public DynaBeanPropertyMapDecorator(DynaBean dynaBean) {
        super(dynaBean);
    }
}
