package com.ipotensic.potensicpro.activities;

import com.google.gson.Gson;
import com.ipotensic.baselib.base.JsViewModel;
import com.ipotensic.baselib.bean.CommonBean;
import com.ipotensic.baselib.bean.TitleBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: MainAcademyController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "tag", "", "invoke"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class MainAcademyController$initWebSettings$2 extends Lambda implements Function1<String, Unit> {
    MainAcademyController$initWebSettings$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke */
    public final void invoke2(String tag) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Gson gson = new Gson();
        int hashCode = tag.hashCode();
        if (hashCode == 106905) {
            if (tag.equals(TitleBean.TAG_LANGUAGE)) {
                CommonBean commonBean = new CommonBean(JsViewModel.SHOW_LANGUAGE, null);
                MainAcademyController mainAcademyController = MainAcademyController.this;
                String json = gson.toJson(commonBean);
                Intrinsics.checkExpressionValueIsNotNull(json, "gson.toJson(bean)");
                mainAcademyController.jsMethod(json);
                return;
            }
            return;
        }
        if (hashCode == 3208415 && tag.equals(TitleBean.TAG_HOME)) {
            CommonBean commonBean2 = new CommonBean(JsViewModel.GO_HOME, null);
            MainAcademyController mainAcademyController2 = MainAcademyController.this;
            String json2 = gson.toJson(commonBean2);
            Intrinsics.checkExpressionValueIsNotNull(json2, "gson.toJson(bean)");
            mainAcademyController2.jsMethod(json2);
        }
    }
}