package com.ipotensic.kernel.controllers;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.guide.NewbieGuide;
import com.ipotensic.baselib.guide.model.GuidePage;
import com.ipotensic.baselib.guide.model.RelativeGuide;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.model.KernelViewModel;
import com.ipotensic.kernel.utils.AnimationUtil;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import org.apache.commons.net.nntp.NNTPReply;

/* loaded from: classes2.dex */
public class ActionCancelController extends BaseController {
    private GeneralDialog actionDialog;
    private ImageButton cancelSwoopReturnButton;
    private TextView cancelSwoopReturnText;
    private Context context;
    private ImageView ivActionCancel;
    private KernelViewModel kernelViewModel;
    private onItemClickListener listener;

    public interface onItemClickListener {
        void cancelAction();
    }

    public ActionCancelController(AppCompatActivity appCompatActivity, ViewStub viewStub) {
        super(appCompatActivity, viewStub);
        this.kernelViewModel = (KernelViewModel) new ViewModelProvider(appCompatActivity).get(KernelViewModel.class);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.context = view.getContext();
        this.ivActionCancel = (ImageView) view.findViewById(R.id.iv_cancel_action);
        this.cancelSwoopReturnButton = (ImageButton) view.findViewById(R.id.btn_cancel_swoop_return);
        this.cancelSwoopReturnText = (TextView) view.findViewById(R.id.text_cancel_swoop_return);
        this.ivActionCancel.setOnClickListener(new ScaleClickListener(1000) { // from class: com.ipotensic.kernel.controllers.ActionCancelController.1
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                DDLog.e("触发取消按钮");
                if (FlightRevData.get().getFlightRevStateData().isReturning()) {
                    DDLog.e("取消按钮 退出一键返航");
                    FlightSendData.get().setReturnMode();
                } else {
                    if (!FlightRevData.get().getFlightRevStateData().isLanding()) {
                        if (ActionCancelController.this.actionDialog == null) {
                            ActionCancelController.this.actionDialog = new GeneralDialog(ActionCancelController.this.context, ActionCancelController.this.context.getString(R.string.dialog_quit_cur_mode), ActionCancelController.this.context.getString(R.string.dialog_quit_cur_mode_describe), (String) null, (String) null, false, 2, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.controllers.ActionCancelController.1.1
                                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                                public void confirm() {
                                    ActionCancelController.this.listener.cancelAction();
                                    if (FlightRevData.get().getFlightRevStateData().isHotCircle()) {
                                        DDLog.e("退出环绕模式");
                                        FlightSendData.get().setCircleFly();
                                    } else if (FlightRevData.get().getFlightRevStateData().isFollowing()) {
                                        DDLog.e("退出跟随模式");
                                        FlightSendData.get().setFollow();
                                    } else if (FlightRevData.get().getFlightRevStateData().isPointFly()) {
                                        DDLog.e("退出航点模式");
                                        FlightSendData.get().setPointFly();
                                        FlightConfig.isInterruptFly = true;
                                    }
                                }
                            });
                        }
                        if (ActionCancelController.this.actionDialog.isShowing()) {
                            return;
                        }
                        ActionCancelController.this.actionDialog.show();
                        return;
                    }
                    DDLog.e("取消按钮 退出一键着落");
                    FlightSendData.get().setLaunch();
                }
            }
        });
        this.cancelSwoopReturnButton.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$ActionCancelController$h0QGp7eCYM3HZpveCqx3yEt_wXM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActionCancelController.this.lambda$initView$0$ActionCancelController(view2);
            }
        });
    }

    public /* synthetic */ void lambda$initView$0$ActionCancelController(View view) {
        DDLog.e("俯冲返航cancelSwoopReturnButton");
        KernelViewModel kernelViewModel = this.kernelViewModel;
        if (kernelViewModel != null) {
            kernelViewModel.exitSwoopReturn();
        }
    }

    private void actionDialogDismiss() {
        GeneralDialog generalDialog = this.actionDialog;
        if (generalDialog == null || !generalDialog.isShowing()) {
            return;
        }
        this.actionDialog.dismiss();
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            DDLog.e("actionCancelController 1111");
            if (getBaseView().getVisibility() != 0) {
                transInLeft(getBaseView(), NNTPReply.SERVICE_DISCONTINUED);
            }
        }
        if (i == 8) {
            actionDialogDismiss();
        }
        controlSwoopReturnText(FlightRevData.get().getFlightRevStateData().isSwoopReturn());
    }

    public void transInLeft(final View view, int i) {
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.trans_in_left);
        loadAnimation.setDuration(i);
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.ipotensic.kernel.controllers.ActionCancelController.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                DDLog.e("actionCancelController 22222");
                view.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ActionCancelController.this.guideViewShow();
            }
        });
    }

    public void setOnItemClickListener(onItemClickListener onitemclicklistener) {
        this.listener = onitemclicklistener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void guideViewShow() {
        if (FlightRevData.get().getFlightRevStateData().isFollowing() && SPHelper.getInstance().getFirstFollowMe()) {
            SPHelper.getInstance().setFirstFollowMe(false);
            NewbieGuide.with((Activity) this.context).addGuidePage(GuidePage.newInstance().addHighLight(this.ivActionCancel, new RelativeGuide(R.layout.guide_follow_me, 5)).setEnterAnimation(AnimationUtil.enterAnimation()).setExitAnimation(AnimationUtil.exitAnimation()).setBackgroundColor(getContext().getResources().getColor(R.color.colorTransparent))).show();
        }
    }

    public void controlSwoopReturnText(boolean z) {
        ImageButton imageButton = this.cancelSwoopReturnButton;
        if (imageButton != null) {
            imageButton.setVisibility(z ? 0 : 8);
        }
        TextView textView = this.cancelSwoopReturnText;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }
}
