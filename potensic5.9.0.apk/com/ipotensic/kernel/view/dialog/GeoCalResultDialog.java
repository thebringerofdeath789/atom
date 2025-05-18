package com.ipotensic.kernel.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.databinding.ViewDialogShowGeoCalResultBinding;
import com.logan.flight.utils.MagCalibrationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeoCalResultDialog.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, m2338d2 = {"Lcom/ipotensic/kernel/view/dialog/GeoCalResultDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "calibrationResult", "Lcom/logan/flight/utils/MagCalibrationResult;", "(Landroid/content/Context;Lcom/logan/flight/utils/MagCalibrationResult;)V", "viewBinding", "Lcom/ipotensic/kernel/databinding/ViewDialogShowGeoCalResultBinding;", "getViewBinding", "()Lcom/ipotensic/kernel/databinding/ViewDialogShowGeoCalResultBinding;", "setViewBinding", "(Lcom/ipotensic/kernel/databinding/ViewDialogShowGeoCalResultBinding;)V", "calMgDb", "", "value", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class GeoCalResultDialog extends Dialog {
    private final MagCalibrationResult calibrationResult;
    public ViewDialogShowGeoCalResultBinding viewBinding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeoCalResultDialog(Context context, MagCalibrationResult magCalibrationResult) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.calibrationResult = magCalibrationResult;
    }

    public final ViewDialogShowGeoCalResultBinding getViewBinding() {
        ViewDialogShowGeoCalResultBinding viewDialogShowGeoCalResultBinding = this.viewBinding;
        if (viewDialogShowGeoCalResultBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        return viewDialogShowGeoCalResultBinding;
    }

    public final void setViewBinding(ViewDialogShowGeoCalResultBinding viewDialogShowGeoCalResultBinding) {
        Intrinsics.checkParameterIsNotNull(viewDialogShowGeoCalResultBinding, "<set-?>");
        this.viewBinding = viewDialogShowGeoCalResultBinding;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDialogShowGeoCalResultBinding inflate = ViewDialogShowGeoCalResultBinding.inflate(getLayoutInflater());
        Intrinsics.checkExpressionValueIsNotNull(inflate, "ViewDialogShowGeoCalResu…g.inflate(layoutInflater)");
        this.viewBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        setContentView(inflate.getRoot());
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        int screenWidth = (ScreenUtils.getScreenWidth(getContext()) * 9) / 10;
        int screenHeight = (ScreenUtils.getScreenHeight(getContext()) * 9) / 10;
        Window window = getWindow();
        if (window != null) {
            window.setLayout(screenWidth, screenHeight);
        }
        ViewDialogShowGeoCalResultBinding viewDialogShowGeoCalResultBinding = this.viewBinding;
        if (viewDialogShowGeoCalResultBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        }
        viewDialogShowGeoCalResultBinding.btnBack.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.view.dialog.GeoCalResultDialog$onCreate$1
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                GeoCalResultDialog.this.dismiss();
            }
        });
        MagCalibrationResult magCalibrationResult = this.calibrationResult;
        if (magCalibrationResult != null) {
            if (magCalibrationResult.isCalibrationFinish()) {
                ViewDialogShowGeoCalResultBinding viewDialogShowGeoCalResultBinding2 = this.viewBinding;
                if (viewDialogShowGeoCalResultBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                }
                viewDialogShowGeoCalResultBinding2.tvResult.setText("校准成功");
                ViewDialogShowGeoCalResultBinding viewDialogShowGeoCalResultBinding3 = this.viewBinding;
                if (viewDialogShowGeoCalResultBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                }
                viewDialogShowGeoCalResultBinding3.tvResult.setTextColor(getContext().getColor(C1965R.color.color_connect_green));
            } else if (magCalibrationResult.isCalibrationFailed()) {
                ViewDialogShowGeoCalResultBinding viewDialogShowGeoCalResultBinding4 = this.viewBinding;
                if (viewDialogShowGeoCalResultBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                }
                viewDialogShowGeoCalResultBinding4.tvResult.setText("校准失败");
                ViewDialogShowGeoCalResultBinding viewDialogShowGeoCalResultBinding5 = this.viewBinding;
                if (viewDialogShowGeoCalResultBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                }
                viewDialogShowGeoCalResultBinding5.tvResult.setTextColor(getContext().getColor(C1965R.color.color_disconnect_red));
            } else if (magCalibrationResult.isCalibrationTimeout()) {
                ViewDialogShowGeoCalResultBinding viewDialogShowGeoCalResultBinding6 = this.viewBinding;
                if (viewDialogShowGeoCalResultBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                }
                viewDialogShowGeoCalResultBinding6.tvResult.setText("校准超时");
                ViewDialogShowGeoCalResultBinding viewDialogShowGeoCalResultBinding7 = this.viewBinding;
                if (viewDialogShowGeoCalResultBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                }
                viewDialogShowGeoCalResultBinding7.tvResult.setTextColor(getContext().getColor(C1965R.color.color_disconnect_red));
            }
            ViewDialogShowGeoCalResultBinding viewDialogShowGeoCalResultBinding8 = this.viewBinding;
            if (viewDialogShowGeoCalResultBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            }
            viewDialogShowGeoCalResultBinding8.tvTime.setText(FormatUtil.getCurTime4());
            float[] bias_result = magCalibrationResult.getBias_result();
            if (bias_result != null && bias_result.length >= 3) {
                ViewDialogShowGeoCalResultBinding viewDialogShowGeoCalResultBinding9 = this.viewBinding;
                if (viewDialogShowGeoCalResultBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                }
                TextView textView = viewDialogShowGeoCalResultBinding9.tvBiasResult0;
                Intrinsics.checkExpressionValueIsNotNull(textView, "viewBinding.tvBiasResult0");
                textView.setText(String.valueOf(bias_result[0]));
                ViewDialogShowGeoCalResultBinding viewDialogShowGeoCalResultBinding10 = this.viewBinding;
                if (viewDialogShowGeoCalResultBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                }
                TextView textView2 = viewDialogShowGeoCalResultBinding10.tvBiasResult1;
                Intrinsics.checkExpressionValueIsNotNull(textView2, "viewBinding.tvBiasResult1");
                textView2.setText(String.valueOf(bias_result[1]));
                ViewDialogShowGeoCalResultBinding viewDialogShowGeoCalResultBinding11 = this.viewBinding;
                if (viewDialogShowGeoCalResultBinding11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                }
                TextView textView3 = viewDialogShowGeoCalResultBinding11.tvBiasResult2;
                Intrinsics.checkExpressionValueIsNotNull(textView3, "viewBinding.tvBiasResult2");
                textView3.setText(String.valueOf(bias_result[2]));
            }
            float[] scale_result = magCalibrationResult.getScale_result();
            if (scale_result != null && scale_result.length >= 3) {
                ViewDialogShowGeoCalResultBinding viewDialogShowGeoCalResultBinding12 = this.viewBinding;
                if (viewDialogShowGeoCalResultBinding12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                }
                TextView textView4 = viewDialogShowGeoCalResultBinding12.tvScaleResult0;
                Intrinsics.checkExpressionValueIsNotNull(textView4, "viewBinding.tvScaleResult0");
                textView4.setText(String.valueOf(scale_result[0]));
                ViewDialogShowGeoCalResultBinding viewDialogShowGeoCalResultBinding13 = this.viewBinding;
                if (viewDialogShowGeoCalResultBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                }
                TextView textView5 = viewDialogShowGeoCalResultBinding13.tvScaleResult1;
                Intrinsics.checkExpressionValueIsNotNull(textView5, "viewBinding.tvScaleResult1");
                textView5.setText(String.valueOf(scale_result[1]));
                ViewDialogShowGeoCalResultBinding viewDialogShowGeoCalResultBinding14 = this.viewBinding;
                if (viewDialogShowGeoCalResultBinding14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                }
                TextView textView6 = viewDialogShowGeoCalResultBinding14.tvScaleResult2;
                Intrinsics.checkExpressionValueIsNotNull(textView6, "viewBinding.tvScaleResult2");
                textView6.setText(String.valueOf(scale_result[2]));
            }
            float[] offdiag_result = magCalibrationResult.getOffdiag_result();
            if (offdiag_result != null && offdiag_result.length >= 3) {
                ViewDialogShowGeoCalResultBinding viewDialogShowGeoCalResultBinding15 = this.viewBinding;
                if (viewDialogShowGeoCalResultBinding15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                }
                TextView textView7 = viewDialogShowGeoCalResultBinding15.tvOffdiagResult0;
                Intrinsics.checkExpressionValueIsNotNull(textView7, "viewBinding.tvOffdiagResult0");
                textView7.setText(String.valueOf(offdiag_result[0]));
                ViewDialogShowGeoCalResultBinding viewDialogShowGeoCalResultBinding16 = this.viewBinding;
                if (viewDialogShowGeoCalResultBinding16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                }
                TextView textView8 = viewDialogShowGeoCalResultBinding16.tvOffdiagResult1;
                Intrinsics.checkExpressionValueIsNotNull(textView8, "viewBinding.tvOffdiagResult1");
                textView8.setText(String.valueOf(offdiag_result[1]));
                ViewDialogShowGeoCalResultBinding viewDialogShowGeoCalResultBinding17 = this.viewBinding;
                if (viewDialogShowGeoCalResultBinding17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                }
                TextView textView9 = viewDialogShowGeoCalResultBinding17.tvOffdiagResult2;
                Intrinsics.checkExpressionValueIsNotNull(textView9, "viewBinding.tvOffdiagResult2");
                textView9.setText(String.valueOf(offdiag_result[2]));
            }
            float[] mg_db_result = magCalibrationResult.getMg_db_result();
            if (mg_db_result != null) {
                if (!(mg_db_result.length == 0)) {
                    ViewDialogShowGeoCalResultBinding viewDialogShowGeoCalResultBinding18 = this.viewBinding;
                    if (viewDialogShowGeoCalResultBinding18 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    }
                    TextView textView10 = viewDialogShowGeoCalResultBinding18.tvMgDbResult;
                    Intrinsics.checkExpressionValueIsNotNull(textView10, "viewBinding.tvMgDbResult");
                    textView10.setText(calMgDb(mg_db_result[0]));
                }
            }
        }
    }

    private final String calMgDb(float value) {
        return (((value - 45559.0f) * 100) / 45559.0f) + "% ( " + value + " / 45559.0 )";
    }
}