package com.ipotensic.kernel.view.dialog;

import android.app.Dialog;
import android.text.SpannableString;
import androidx.appcompat.app.AppCompatActivity;
import com.ipotensic.kernel.view.dialog.BaseDialog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;

/* compiled from: AppDialogManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJO\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0007\u00a2\u0006\u0002\u0010\u0016JO\u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0007\u00a2\u0006\u0002\u0010\u001bJi\u0010\u001c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00152\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0007\u00a2\u0006\u0002\u0010\u001fJ'\u0010 \u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010!\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\u0010\"R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/ipotensic/kernel/view/dialog/AppDialogManager;", "", "()V", "dialogMap", "Ljava/util/HashMap;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/ipotensic/kernel/view/dialog/BaseDialog;", "Lkotlin/collections/HashMap;", "dismissDialog", "", "activity", "hasDialogShowing", "", "level", "", "showCommonOneButtonDialog", MessageBundle.TITLE_ENTRY, "", "content", "confirmStr", "confirm", "Lkotlin/Function0;", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "showCommonOneButtonWithSpanContentDialog", "Lcom/ipotensic/kernel/view/dialog/CommonOneButtonDialog;", "contentSp", "Landroid/text/SpannableString;", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Landroid/text/SpannableString;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)Lcom/ipotensic/kernel/view/dialog/CommonOneButtonDialog;", "showCommonTwoButtonDialog", "cancelStr", "cancelListener", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "showDialog", "newDialog", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/Integer;Lcom/ipotensic/kernel/view/dialog/BaseDialog;)V", "Companion", "Holder", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AppDialogManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "AppDialogManager";
    private HashMap<AppCompatActivity, BaseDialog> dialogMap;

    @JvmStatic
    public static final AppDialogManager getInstance() {
        return INSTANCE.getInstance();
    }

    public final void showCommonOneButtonDialog(AppCompatActivity appCompatActivity, String str, String str2) {
        showCommonOneButtonDialog$default(this, appCompatActivity, str, str2, null, null, null, 56, null);
    }

    public final void showCommonOneButtonDialog(AppCompatActivity appCompatActivity, String str, String str2, String str3) {
        showCommonOneButtonDialog$default(this, appCompatActivity, str, str2, str3, null, null, 48, null);
    }

    public final void showCommonOneButtonDialog(AppCompatActivity appCompatActivity, String str, String str2, String str3, Integer num) {
        showCommonOneButtonDialog$default(this, appCompatActivity, str, str2, str3, num, null, 32, null);
    }

    public final CommonOneButtonDialog showCommonOneButtonWithSpanContentDialog(AppCompatActivity appCompatActivity, String str, SpannableString spannableString) {
        return showCommonOneButtonWithSpanContentDialog$default(this, appCompatActivity, str, spannableString, null, null, null, 56, null);
    }

    public final CommonOneButtonDialog showCommonOneButtonWithSpanContentDialog(AppCompatActivity appCompatActivity, String str, SpannableString spannableString, String str2) {
        return showCommonOneButtonWithSpanContentDialog$default(this, appCompatActivity, str, spannableString, str2, null, null, 48, null);
    }

    public final CommonOneButtonDialog showCommonOneButtonWithSpanContentDialog(AppCompatActivity appCompatActivity, String str, SpannableString spannableString, String str2, Integer num) {
        return showCommonOneButtonWithSpanContentDialog$default(this, appCompatActivity, str, spannableString, str2, num, null, 32, null);
    }

    public final void showCommonTwoButtonDialog(AppCompatActivity appCompatActivity, String str, String str2, Function0<Unit> function0) {
        showCommonTwoButtonDialog$default(this, appCompatActivity, str, str2, function0, null, null, null, null, 240, null);
    }

    public final void showCommonTwoButtonDialog(AppCompatActivity appCompatActivity, String str, String str2, Function0<Unit> function0, String str3) {
        showCommonTwoButtonDialog$default(this, appCompatActivity, str, str2, function0, str3, null, null, null, 224, null);
    }

    public final void showCommonTwoButtonDialog(AppCompatActivity appCompatActivity, String str, String str2, Function0<Unit> function0, String str3, String str4) {
        showCommonTwoButtonDialog$default(this, appCompatActivity, str, str2, function0, str3, str4, null, null, 192, null);
    }

    public final void showCommonTwoButtonDialog(AppCompatActivity appCompatActivity, String str, String str2, Function0<Unit> function0, String str3, String str4, Integer num) {
        showCommonTwoButtonDialog$default(this, appCompatActivity, str, str2, function0, str3, str4, num, null, 128, null);
    }

    private AppDialogManager() {
        this.dialogMap = new HashMap<>();
    }

    public /* synthetic */ AppDialogManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: AppDialogManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/ipotensic/kernel/view/dialog/AppDialogManager$Companion;", "", "()V", "TAG", "", "getInstance", "Lcom/ipotensic/kernel/view/dialog/AppDialogManager;", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final AppDialogManager getInstance() {
            return Holder.INSTANCE.getManager();
        }
    }

    /* compiled from: AppDialogManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/ipotensic/kernel/view/dialog/AppDialogManager$Holder;", "", "()V", "manager", "Lcom/ipotensic/kernel/view/dialog/AppDialogManager;", "getManager", "()Lcom/ipotensic/kernel/view/dialog/AppDialogManager;", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
    public static final class Holder {
        public static final Holder INSTANCE = new Holder();
        private static final AppDialogManager manager = new AppDialogManager(null);

        private Holder() {
        }

        public final AppDialogManager getManager() {
            return manager;
        }
    }

    public final boolean hasDialogShowing(AppCompatActivity activity, int level) {
        Dialog dialog;
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        BaseDialog baseDialog = this.dialogMap.get(activity);
        return baseDialog != null && (dialog = baseDialog.getDialog()) != null && dialog.isShowing() && baseDialog.getLevel() > level;
    }

    public final void dismissDialog(AppCompatActivity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        BaseDialog baseDialog = this.dialogMap.get(activity);
        if (baseDialog != null) {
            baseDialog.dismiss();
        }
    }

    public static /* synthetic */ void showCommonOneButtonDialog$default(AppDialogManager appDialogManager, AppCompatActivity appCompatActivity, String str, String str2, String str3, Integer num, Function0 function0, int i, Object obj) {
        appDialogManager.showCommonOneButtonDialog(appCompatActivity, str, str2, (i & 8) != 0 ? (String) null : str3, (i & 16) != 0 ? 0 : num, (i & 32) != 0 ? (Function0) null : function0);
    }

    public final void showCommonOneButtonDialog(AppCompatActivity activity, String r3, String content, String confirmStr, Integer level, Function0<Unit> confirm) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(r3, "title");
        Intrinsics.checkParameterIsNotNull(content, "content");
        showDialog(activity, level, new CommonOneButtonDialog().setTitle(r3).setContent(content).setButtonStr(confirmStr).setAutoDismiss(true).setConfirmListener(confirm));
    }

    public static /* synthetic */ CommonOneButtonDialog showCommonOneButtonWithSpanContentDialog$default(AppDialogManager appDialogManager, AppCompatActivity appCompatActivity, String str, SpannableString spannableString, String str2, Integer num, Function0 function0, int i, Object obj) {
        return appDialogManager.showCommonOneButtonWithSpanContentDialog(appCompatActivity, str, spannableString, (i & 8) != 0 ? (String) null : str2, (i & 16) != 0 ? 0 : num, (i & 32) != 0 ? (Function0) null : function0);
    }

    public final CommonOneButtonDialog showCommonOneButtonWithSpanContentDialog(AppCompatActivity activity, String r3, SpannableString contentSp, String confirmStr, Integer level, Function0<Unit> confirm) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(r3, "title");
        Intrinsics.checkParameterIsNotNull(contentSp, "contentSp");
        CommonOneButtonDialog confirmListener = new CommonOneButtonDialog().setTitle(r3).setContent(contentSp).setButtonStr(confirmStr).setAutoDismiss(true).setConfirmListener(confirm);
        showDialog(activity, level, confirmListener);
        return confirmListener;
    }

    public static /* synthetic */ void showCommonTwoButtonDialog$default(AppDialogManager appDialogManager, AppCompatActivity appCompatActivity, String str, String str2, Function0 function0, String str3, String str4, Integer num, Function0 function02, int i, Object obj) {
        appDialogManager.showCommonTwoButtonDialog(appCompatActivity, str, str2, function0, (i & 16) != 0 ? (String) null : str3, (i & 32) != 0 ? (String) null : str4, (i & 64) != 0 ? 0 : num, (i & 128) != 0 ? (Function0) null : function02);
    }

    public final void showCommonTwoButtonDialog(AppCompatActivity activity, String r3, String content, Function0<Unit> confirm, String confirmStr, String cancelStr, Integer level, Function0<Unit> cancelListener) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(r3, "title");
        Intrinsics.checkParameterIsNotNull(content, "content");
        Intrinsics.checkParameterIsNotNull(confirm, "confirm");
        showDialog(activity, level, new CommonTwoButtonDialog().setTitle(r3).setContent(content).setConfirmStr(confirmStr).setCancelStr(cancelStr).setConfirmListener(confirm).setCancelListener(cancelListener));
    }

    private final void showDialog(AppCompatActivity activity, Integer level, BaseDialog newDialog) {
        if (hasDialogShowing(activity, level != null ? level.intValue() : 0)) {
            return;
        }
        BaseDialog baseDialog = this.dialogMap.get(activity);
        if (baseDialog != null) {
            baseDialog.dismiss();
        }
        newDialog.setDestroyListener(new BaseDialog.OnDialogDestroyListener() { // from class: com.ipotensic.kernel.view.dialog.AppDialogManager$showDialog$1
            final /* synthetic */ AppCompatActivity $activity;
            final /* synthetic */ BaseDialog $newDialog;

            AppDialogManager$showDialog$1(AppCompatActivity activity2, BaseDialog newDialog2) {
                r2 = activity2;
                r3 = newDialog2;
            }

            @Override // com.ipotensic.kernel.view.dialog.BaseDialog.OnDialogDestroyListener
            public void onDialogDestroy() {
                HashMap hashMap;
                HashMap hashMap2;
                hashMap = AppDialogManager.this.dialogMap;
                BaseDialog baseDialog2 = (BaseDialog) hashMap.get(r2);
                if (baseDialog2 == null || !baseDialog2.equals(r3)) {
                    return;
                }
                hashMap2 = AppDialogManager.this.dialogMap;
                hashMap2.remove(r2);
            }
        });
        newDialog2.show(activity2);
        this.dialogMap.put(activity2, newDialog2);
    }
}