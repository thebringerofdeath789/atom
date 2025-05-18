package com.ipotensic.baselib.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonBean.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0006J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\fJ*\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, m2338d2 = {"Lcom/ipotensic/baselib/bean/CommonBean;", "T", "", "function", "", "params", "(Ljava/lang/String;Ljava/lang/Object;)V", "getFunction", "()Ljava/lang/String;", "setFunction", "(Ljava/lang/String;)V", "getParams", "()Ljava/lang/Object;", "setParams", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/ipotensic/baselib/bean/CommonBean;", "equals", "", "other", "hashCode", "", "toString", "BaseLib_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final /* data */ class CommonBean<T> {
    private String function;
    private T params;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommonBean copy$default(CommonBean commonBean, String str, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = commonBean.function;
        }
        if ((i & 2) != 0) {
            obj = commonBean.params;
        }
        return commonBean.copy(str, obj);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFunction() {
        return this.function;
    }

    public final T component2() {
        return this.params;
    }

    public final CommonBean<T> copy(String function, T params) {
        Intrinsics.checkParameterIsNotNull(function, "function");
        return new CommonBean<>(function, params);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonBean)) {
            return false;
        }
        CommonBean commonBean = (CommonBean) other;
        return Intrinsics.areEqual(this.function, commonBean.function) && Intrinsics.areEqual(this.params, commonBean.params);
    }

    public int hashCode() {
        String str = this.function;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        T t = this.params;
        return hashCode + (t != null ? t.hashCode() : 0);
    }

    public String toString() {
        return "CommonBean(function=" + this.function + ", params=" + this.params + ")";
    }

    public CommonBean(String function, T t) {
        Intrinsics.checkParameterIsNotNull(function, "function");
        this.function = function;
        this.params = t;
    }

    public final String getFunction() {
        return this.function;
    }

    public final void setFunction(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.function = str;
    }

    public /* synthetic */ CommonBean(String str, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : obj);
    }

    public final T getParams() {
        return this.params;
    }

    public final void setParams(T t) {
        this.params = t;
    }
}