package com.ipotensic.kernel.model;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.Button;
import androidx.lifecycle.MutableLiveData;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.logan.flight.FlightConfig;
import kotlin.Metadata;

/* compiled from: KernelViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"com/ipotensic/kernel/model/KernelViewModel$startSwoopReturnCountTimer$1$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class KernelViewModel$startSwoopReturnCountTimer$$inlined$run$lambda$1 extends CountDownTimer {
    final /* synthetic */ Context $context$inlined;
    final /* synthetic */ long $time$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KernelViewModel$startSwoopReturnCountTimer$$inlined$run$lambda$1(long j, long j2, long j3, Context context) {
        super(j, j2);
        time = j3;
        context = context;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        MutableLiveData mutableLiveData;
        GeneralDialog generalDialog;
        Button button;
        MutableLiveData mutableLiveData2;
        mutableLiveData = KernelViewModel.this.swoopReturnCountTime;
        mutableLiveData.setValue(Integer.valueOf((int) (j / 1000)));
        generalDialog = KernelViewModel.this.swoopReturnDialog;
        if (generalDialog == null || (button = generalDialog.confirmBtn) == null) {
            return;
        }
        StringBuilder append = new StringBuilder().append(context.getString(R.string.dialog_confirm)).append("(");
        mutableLiveData2 = KernelViewModel.this.swoopReturnCountTime;
        button.setText(append.append((Integer) mutableLiveData2.getValue()).append("s)").toString());
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        MutableLiveData mutableLiveData;
        GeneralDialog generalDialog;
        GeneralDialog generalDialog2;
        Button button;
        MutableLiveData mutableLiveData2;
        DDLog.e("\u4fef\u51b2\u8fd4\u822astartSwoopReturnCountTimer onFinish");
        mutableLiveData = KernelViewModel.this.swoopReturnCountTime;
        mutableLiveData.setValue(0);
        generalDialog = KernelViewModel.this.swoopReturnDialog;
        if (generalDialog != null && (button = generalDialog.confirmBtn) != null) {
            StringBuilder append = new StringBuilder().append(context.getString(R.string.dialog_confirm)).append("(");
            mutableLiveData2 = KernelViewModel.this.swoopReturnCountTime;
            button.setText(append.append((Integer) mutableLiveData2.getValue()).append("s)").toString());
        }
        if (!FlightConfig.isConnectFlight()) {
            generalDialog2 = KernelViewModel.this.swoopReturnDialog;
            if (generalDialog2 != null) {
                generalDialog2.dismiss();
            }
            KernelViewModel.this.swoopReturnDialog = (GeneralDialog) null;
        }
        KernelViewModel.this.swoopReturnCountTimer = (CountDownTimer) null;
    }
}