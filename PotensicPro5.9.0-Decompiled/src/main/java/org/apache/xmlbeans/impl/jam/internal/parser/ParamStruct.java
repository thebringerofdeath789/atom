package org.apache.xmlbeans.impl.jam.internal.parser;

import org.apache.xmlbeans.impl.jam.mutable.MInvokable;
import org.apache.xmlbeans.impl.jam.mutable.MParameter;

/* loaded from: classes5.dex */
class ParamStruct {
    private String mName;
    private String mType;

    public ParamStruct(String str, String str2) {
        init(str, str2);
    }

    public void init(String str, String str2) {
        this.mType = str;
        this.mName = str2;
    }

    public MParameter createParameter(MInvokable mInvokable) {
        if (mInvokable == null) {
            throw new IllegalArgumentException("null invokable");
        }
        MParameter addNewParameter = mInvokable.addNewParameter();
        addNewParameter.setSimpleName(this.mName);
        addNewParameter.setUnqualifiedType(this.mType);
        return addNewParameter;
    }
}
