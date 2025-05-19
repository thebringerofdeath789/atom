package org.apache.xmlbeans.impl.jam.annotation;

import org.apache.xmlbeans.impl.jam.JAnnotationValue;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.provider.JamLogger;
import org.apache.xmlbeans.impl.jam.provider.JamServiceContext;

/* loaded from: classes5.dex */
public abstract class AnnotationProxy {
    private static final String DEFAULT_NVPAIR_DELIMS = "\n\r";
    public static final String SINGLE_MEMBER_NAME = "value";
    protected JamServiceContext mContext;

    public abstract JAnnotationValue[] getValues();

    public abstract void setValue(String str, Object obj, JClass jClass);

    public void init(JamServiceContext jamServiceContext) {
        if (jamServiceContext == null) {
            throw new IllegalArgumentException("null logger");
        }
        this.mContext = jamServiceContext;
    }

    public JAnnotationValue getValue(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null name");
        }
        String trim = str.trim();
        JAnnotationValue[] values = getValues();
        for (int i = 0; i < values.length; i++) {
            if (trim.equals(values[i].getName())) {
                return values[i];
            }
        }
        return null;
    }

    protected JamLogger getLogger() {
        return this.mContext.getLogger();
    }
}
