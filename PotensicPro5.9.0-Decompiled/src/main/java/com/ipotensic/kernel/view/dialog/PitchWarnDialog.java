package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PitchWarnDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0014J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/ipotensic/kernel/view/dialog/PitchWarnDialog;", "Lcom/ipotensic/baselib/base/BaseSyncDialog;", "context", "Landroid/content/Context;", "isFollowMode", "", "(Landroid/content/Context;Z)V", "()Z", "setFollowMode", "(Z)V", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class PitchWarnDialog extends BaseSyncDialog {
    private boolean isFollowMode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PitchWarnDialog(Context context, boolean z) {
        super(context, R.layout.view_dialog_pitch_warn);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.isFollowMode = z;
    }

    /* renamed from: isFollowMode, reason: from getter */
    public final boolean getIsFollowMode() {
        return this.isFollowMode;
    }

    public final void setFollowMode(boolean z) {
        this.isFollowMode = z;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tvTitle = (TextView) findViewById(R.id.tv_title);
        TextView tvContent = (TextView) findViewById(R.id.tv_content);
        ImageView imageView = (ImageView) findViewById(R.id.img_tip);
        Button button = (Button) findViewById(R.id.btn_confirm);
        if (this.isFollowMode) {
            Intrinsics.checkExpressionValueIsNotNull(tvTitle, "tvTitle");
            tvTitle.setText(getContext().getString(R.string.visual_tracking_activation_failed_gimbal_pitch_angle_title));
            Intrinsics.checkExpressionValueIsNotNull(tvContent, "tvContent");
            tvContent.setText(getContext().getString(R.string.visual_tracking_activation_failed_gimbal_pitch_angle_tips));
            imageView.setImageResource(R.mipmap.img_pitch_warn_follow);
        } else {
            Intrinsics.checkExpressionValueIsNotNull(tvTitle, "tvTitle");
            tvTitle.setText(getContext().getString(R.string.quickshots_activation_failed_gimbal_pitch_angle_title));
            Intrinsics.checkExpressionValueIsNotNull(tvContent, "tvContent");
            tvContent.setText(getContext().getString(R.string.quickshots_activation_failed_gimbal_pitch_angle_tips));
            imageView.setImageResource(R.mipmap.img_pitch_warn_quick_shot);
        }
        button.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.view.dialog.PitchWarnDialog$onCreate$1
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                PitchWarnDialog.this.dismiss();
            }
        });
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        int screenHeight = (ScreenUtils.getScreenHeight(context) * 292) / 375;
        setSize((screenHeight * 554) / 292, screenHeight);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }
}
