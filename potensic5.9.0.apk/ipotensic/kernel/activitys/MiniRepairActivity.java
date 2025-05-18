package com.ipotensic.kernel.activitys;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.dialog.MiniPairFailDialog;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevConnectData;
import com.logan.flight.data.recv.FlightRevMiniPairData;
import com.logan.flight.type.Flight;

/* loaded from: classes2.dex */
public class MiniRepairActivity extends BaseActivity implements EventDispatcher.OnEventListener {
    public static boolean isStartPair = false;
    private boolean isGrantResult = false;
    private ImageView ivClose;
    private ImageView ivRepairGif;
    private MiniPairFailDialog miniPairFailDialog;
    private TextView tvRepairStep;
    private TextView tvRepairStepTwo;
    private TextView tvRepairTitle;

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_repair);
        EventDispatcher.get().registerEvent(getLifecycle(), this);
        initView();
    }

    private void initView() {
        this.tvRepairTitle = (TextView) findViewById(R.id.tv_repair_title);
        this.ivRepairGif = (ImageView) findViewById(R.id.iv_repair_gif);
        this.tvRepairStep = (TextView) findViewById(R.id.tv_code_step);
        this.tvRepairStepTwo = (TextView) findViewById(R.id.tv_code_step_two);
        ImageView imageView = (ImageView) findViewById(R.id.iv_close);
        this.ivClose = imageView;
        imageView.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.activitys.MiniRepairActivity.1
            AnonymousClass1() {
            }

            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                MiniRepairActivity.this.finishActivity();
            }
        });
        int i = R.drawable.gif_mini_pair;
        Flight remoterType = FlightRevData.get().getFlightRevFpvData().getRemoterType();
        if (remoterType != null) {
            if (FlightConfig.isAtomPanTilt(remoterType)) {
                i = R.drawable.gif_atom_pair;
            } else if (FlightConfig.isAtomLT(remoterType)) {
                i = R.drawable.gif_atomlt_pair;
            }
        }
        this.tvRepairStep.setText(getString(FlightConfig.isAtomLT() ? R.string.atom_lt_frequency_pairing_mode_tips1 : R.string.mini_code_step_one));
        this.tvRepairStepTwo.setText(getString(FlightConfig.isAtomLT() ? R.string.atom_lt_frequency_pairing_mode_tips2 : R.string.mini_code_step_two));
        Glide.with((FragmentActivity) this).load(Integer.valueOf(i)).asGif().diskCacheStrategy(DiskCacheStrategy.NONE).into(this.ivRepairGif);
    }

    /* renamed from: com.ipotensic.kernel.activitys.MiniRepairActivity$1 */
    class AnonymousClass1 extends ScaleClickListener {
        AnonymousClass1() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            MiniRepairActivity.this.finishActivity();
        }
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    public void finishActivity() {
        finish();
    }

    @Override // com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        if (eventID == EventID.FLIGHT_RECEIVE_MINI_PAIR_RESULT) {
            FlightRevMiniPairData flightRevMiniPairData = (FlightRevMiniPairData) event.obj;
            DDLog.e("\u5bf9\u9891------\u7ed3\u679c: " + flightRevMiniPairData.isPairSuccess() + ", isGrantResult= " + this.isGrantResult);
            if (flightRevMiniPairData.isPairSuccess()) {
                DataManager.getInstance().requestFpvInfo();
                if (this.isGrantResult) {
                    return;
                }
                this.isGrantResult = true;
                this.tvRepairTitle.setText(getString(R.string.repair_mode));
                this.tvRepairStep.setText(getString(R.string.repair_will_complete));
                this.tvRepairStep.setCompoundDrawables(null, null, null, null);
                this.tvRepairStepTwo.setVisibility(8);
                new Handler().postDelayed(new Runnable() { // from class: com.ipotensic.kernel.activitys.MiniRepairActivity.2
                    AnonymousClass2() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        DDLog.e("\u5bf9\u9891\u7ed3\u675f\uff0c\u56de\u5230kernelActivity");
                        MiniRepairActivity.this.finishActivity();
                    }
                }, 4000L);
                return;
            }
            if (this.isGrantResult) {
                return;
            }
            DDLog.e("\u5bf9\u9891\u5931\u8d25");
            this.isGrantResult = true;
            MiniPairFailDialog miniPairFailDialog = new MiniPairFailDialog(this, R.layout.view_dialog_repair, new MiniPairFailDialog.OnClickListener() { // from class: com.ipotensic.kernel.activitys.-$$Lambda$MiniRepairActivity$WxG_lkC1lIFBwmTt7ocsLrrRnBo
                public /* synthetic */ $$Lambda$MiniRepairActivity$WxG_lkC1lIFBwmTt7ocsLrrRnBo() {
                }

                @Override // com.ipotensic.kernel.view.dialog.MiniPairFailDialog.OnClickListener
                public final void onConfirm() {
                    MiniRepairActivity.this.finish();
                }
            });
            this.miniPairFailDialog = miniPairFailDialog;
            miniPairFailDialog.show();
            return;
        }
        if (eventID == EventID.FLIGHT_RECEIVE_USB_CONNECT_STATE) {
            if (((FlightRevConnectData) event.obj).isRemoterConnected()) {
                return;
            }
            MiniPairFailDialog miniPairFailDialog2 = this.miniPairFailDialog;
            if (miniPairFailDialog2 != null && miniPairFailDialog2.isShowing()) {
                this.miniPairFailDialog.dismiss();
            }
            finishActivity();
            return;
        }
        if (eventID != EventID.FLIGHT_CONNECT_STATE_CHANGED || UsbConfig.isUsbConnected) {
            return;
        }
        MiniPairFailDialog miniPairFailDialog3 = this.miniPairFailDialog;
        if (miniPairFailDialog3 != null && miniPairFailDialog3.isShowing()) {
            this.miniPairFailDialog.dismiss();
        }
        finishActivity();
    }

    /* renamed from: com.ipotensic.kernel.activitys.MiniRepairActivity$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DDLog.e("\u5bf9\u9891\u7ed3\u675f\uff0c\u56de\u5230kernelActivity");
            MiniRepairActivity.this.finishActivity();
        }
    }
}