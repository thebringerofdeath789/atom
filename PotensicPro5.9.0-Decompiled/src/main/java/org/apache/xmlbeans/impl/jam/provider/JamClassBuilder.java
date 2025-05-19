package org.apache.xmlbeans.impl.jam.provider;

import org.apache.xmlbeans.impl.jam.internal.elements.ClassImpl;
import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
import org.apache.xmlbeans.impl.jam.mutable.MClass;

/* loaded from: classes5.dex */
public abstract class JamClassBuilder {
    private ElementContext mContext = null;

    public abstract MClass build(String str, String str2);

    public void init(ElementContext elementContext) {
        if (this.mContext != null) {
            throw new IllegalStateException("init called more than once");
        }
        if (elementContext == null) {
            throw new IllegalArgumentException("null ctx");
        }
        this.mContext = elementContext;
    }

    protected MClass createClassToBuild(String str, String str2, String[] strArr, JamClassPopulator jamClassPopulator) {
        if (this.mContext == null) {
            throw new IllegalStateException("init not called");
        }
        if (str == null) {
            throw new IllegalArgumentException("null pkg");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("null class");
        }
        if (jamClassPopulator == null) {
            throw new IllegalArgumentException("null pop");
        }
        assertInitialized();
        return new ClassImpl(str, str2.replace('.', '$'), this.mContext, strArr, jamClassPopulator);
    }

    protected MClass createClassToBuild(String str, String str2, String[] strArr) {
        if (this.mContext == null) {
            throw new IllegalStateException("init not called");
        }
        if (str == null) {
            throw new IllegalArgumentException("null pkg");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("null class");
        }
        assertInitialized();
        return new ClassImpl(str, str2.replace('.', '$'), this.mContext, strArr);
    }

    protected JamLogger getLogger() {
        return this.mContext;
    }

    protected final void assertInitialized() {
        if (this.mContext == null) {
            throw new IllegalStateException(new StringBuffer().append(this).append(" not yet initialized.").toString());
        }
    }
}
