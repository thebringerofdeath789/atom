package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.github.mmin18.widget.RealtimeBlurView;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.view.dialog.BatteryInstallSafetyDialog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BatteryInstallSafetyDialog.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0002./B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010+\u001a\u00020,H\u0016J\u0012\u0010-\u001a\u00020,2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00060"}, m2338d2 = {"Lcom/ipotensic/kernel/view/dialog/BatteryInstallSafetyDialog;", "Lcom/ipotensic/baselib/base/BaseSyncDialog;", "context", "Landroid/content/Context;", "resultListener", "Lcom/ipotensic/kernel/view/dialog/BatteryInstallSafetyDialog$OnResultListener;", "(Landroid/content/Context;Lcom/ipotensic/kernel/view/dialog/BatteryInstallSafetyDialog$OnResultListener;)V", "bgView", "Landroid/view/View;", "getBgView", "()Landroid/view/View;", "setBgView", "(Landroid/view/View;)V", "gifView", "Landroid/widget/ImageView;", "getGifView", "()Landroid/widget/ImageView;", "setGifView", "(Landroid/widget/ImageView;)V", "imgTemp", "getImgTemp", "setImgTemp", "isBgSet", "", "()Z", "setBgSet", "(Z)V", "layoutMain", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getLayoutMain", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setLayoutMain", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "realTimeBlurView", "Lcom/github/mmin18/widget/RealtimeBlurView;", "getRealTimeBlurView", "()Lcom/github/mmin18/widget/RealtimeBlurView;", "setRealTimeBlurView", "(Lcom/github/mmin18/widget/RealtimeBlurView;)V", "getResultListener", "()Lcom/ipotensic/kernel/view/dialog/BatteryInstallSafetyDialog$OnResultListener;", "setResultListener", "(Lcom/ipotensic/kernel/view/dialog/BatteryInstallSafetyDialog$OnResultListener;)V", "dismiss", "", "initView", "Companion", "OnResultListener", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class BatteryInstallSafetyDialog extends BaseSyncDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean isUserConfirm;
    public View bgView;
    public ImageView gifView;
    public ImageView imgTemp;
    private boolean isBgSet;
    public ConstraintLayout layoutMain;
    public RealtimeBlurView realTimeBlurView;
    private OnResultListener resultListener;

    /* compiled from: BatteryInstallSafetyDialog.kt */
    @Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m2338d2 = {"Lcom/ipotensic/kernel/view/dialog/BatteryInstallSafetyDialog$OnResultListener;", "", "onConfirm", "", "isNoLonger", "", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
    public interface OnResultListener {
        void onConfirm(boolean isNoLonger);
    }

    public static final boolean isUserConfirm() {
        return isUserConfirm;
    }

    public static final void setUserConfirm(boolean z) {
        isUserConfirm = z;
    }

    /* compiled from: BatteryInstallSafetyDialog.kt */
    @Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, m2338d2 = {"Lcom/ipotensic/kernel/view/dialog/BatteryInstallSafetyDialog$Companion;", "", "()V", "isUserConfirm", "", "isUserConfirm$annotations", "()Z", "setUserConfirm", "(Z)V", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
    public static final class Companion {
        @JvmStatic
        public static /* synthetic */ void isUserConfirm$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isUserConfirm() {
            return BatteryInstallSafetyDialog.isUserConfirm;
        }

        public final void setUserConfirm(boolean z) {
            BatteryInstallSafetyDialog.isUserConfirm = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatteryInstallSafetyDialog(Context context, OnResultListener onResultListener) {
        super(context, C1965R.layout.view_dialog_battery_install_safety);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.resultListener = onResultListener;
    }

    public final OnResultListener getResultListener() {
        return this.resultListener;
    }

    public final void setResultListener(OnResultListener onResultListener) {
        this.resultListener = onResultListener;
    }

    public final RealtimeBlurView getRealTimeBlurView() {
        RealtimeBlurView realtimeBlurView = this.realTimeBlurView;
        if (realtimeBlurView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("realTimeBlurView");
        }
        return realtimeBlurView;
    }

    public final void setRealTimeBlurView(RealtimeBlurView realtimeBlurView) {
        Intrinsics.checkParameterIsNotNull(realtimeBlurView, "<set-?>");
        this.realTimeBlurView = realtimeBlurView;
    }

    public final ConstraintLayout getLayoutMain() {
        ConstraintLayout constraintLayout = this.layoutMain;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutMain");
        }
        return constraintLayout;
    }

    public final void setLayoutMain(ConstraintLayout constraintLayout) {
        Intrinsics.checkParameterIsNotNull(constraintLayout, "<set-?>");
        this.layoutMain = constraintLayout;
    }

    public final ImageView getImgTemp() {
        ImageView imageView = this.imgTemp;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgTemp");
        }
        return imageView;
    }

    public final void setImgTemp(ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.imgTemp = imageView;
    }

    public final View getBgView() {
        View view = this.bgView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bgView");
        }
        return view;
    }

    public final void setBgView(View view) {
        Intrinsics.checkParameterIsNotNull(view, "<set-?>");
        this.bgView = view;
    }

    public final ImageView getGifView() {
        ImageView imageView = this.gifView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifView");
        }
        return imageView;
    }

    public final void setGifView(ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.gifView = imageView;
    }

    /* renamed from: isBgSet, reason: from getter */
    public final boolean getIsBgSet() {
        return this.isBgSet;
    }

    public final void setBgSet(boolean z) {
        this.isBgSet = z;
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        View findViewById = findViewById(C1965R.id.view_real_time_blur);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.view_real_time_blur)");
        this.realTimeBlurView = (RealtimeBlurView) findViewById;
        View findViewById2 = findViewById(C1965R.id.layout_main);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.layout_main)");
        this.layoutMain = (ConstraintLayout) findViewById2;
        View findViewById3 = findViewById(C1965R.id.img_temp);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "findViewById(R.id.img_temp)");
        this.imgTemp = (ImageView) findViewById3;
        View findViewById4 = findViewById(C1965R.id.bg_view);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "findViewById(R.id.bg_view)");
        this.bgView = findViewById4;
        View findViewById5 = findViewById(C1965R.id.iv_anim_gif);
        Intrinsics.checkExpressionValueIsNotNull(findViewById5, "findViewById(R.id.iv_anim_gif)");
        this.gifView = (ImageView) findViewById5;
        DrawableRequestBuilder diskCacheStrategy = Glide.with(getContext()).load((RequestManager) Integer.valueOf(C1965R.drawable.gif_battery_install_safety)).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE);
        ImageView imageView = this.gifView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifView");
        }
        diskCacheStrategy.into((DrawableRequestBuilder) new GlideDrawableImageViewTarget(imageView));
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setSize(this.MATCH_PARENT, this.MATCH_PARENT);
        final CheckBox checkBox = (CheckBox) findViewById(C1965R.id.cb_no_longer);
        ((Button) findViewById(C1965R.id.btn_confirm)).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.BatteryInstallSafetyDialog$initView$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BatteryInstallSafetyDialog.OnResultListener resultListener = BatteryInstallSafetyDialog.this.getResultListener();
                if (resultListener != null) {
                    CheckBox cbNoLonger = checkBox;
                    Intrinsics.checkExpressionValueIsNotNull(cbNoLonger, "cbNoLonger");
                    resultListener.onConfirm(cbNoLonger.isChecked());
                }
                BatteryInstallSafetyDialog.this.dismiss();
            }
        });
    }

    @Override // com.ipotensic.baselib.base.BaseSyncDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.view.dialog.BatteryInstallSafetyDialog$dismiss$1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Glide.get(BatteryInstallSafetyDialog.this.getContext()).clearMemory();
                    Glide.get(BatteryInstallSafetyDialog.this.getContext()).clearDiskCache();
                } catch (Exception unused) {
                }
            }
        });
    }
}