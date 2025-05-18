package com.ipotensic.kernel.model;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.ipotensic.baselib.DDLog;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.upgrade.big.BigPackageHelper;
import java.io.File;

/* loaded from: classes2.dex */
public class BigPackageViewModel extends AndroidViewModel {
    private static final String TAG = "BigPackageViewModel";
    public MutableLiveData<String> filePath;
    public MutableLiveData<Boolean> isCameraHighTemp;
    public MutableLiveData<Boolean> isFwDownloading;
    public MutableLiveData<Boolean> isNeedDownloadFw;
    public MutableLiveData<Boolean> isPlanePowerLow;
    public MutableLiveData<Boolean> isRemotePowerLow;
    public MutableLiveData<Boolean> isStartCheck;
    public MutableLiveData<Boolean> isUpgrading;
    public MutableLiveData<Boolean> notConnectFlight;
    public MutableLiveData<Long> offset;
    public MutableLiveData<Integer> readLen;
    public MutableLiveData<String> sdState;
    public MutableLiveData<Long> totalSize;
    public MutableLiveData<Boolean> unLock;
    public MutableLiveData<Integer> upgradingProgress;
    public MutableLiveData<Integer> upgradingState;
    public MutableLiveData<Integer> upgradingTotalProgress;

    public BigPackageViewModel(Application application) {
        super(application);
        this.notConnectFlight = new MutableLiveData<>();
        this.isRemotePowerLow = new MutableLiveData<>();
        this.isPlanePowerLow = new MutableLiveData<>();
        this.unLock = new MutableLiveData<>();
        this.isCameraHighTemp = new MutableLiveData<>(false);
        this.sdState = new MutableLiveData<>();
        this.filePath = new MutableLiveData<>();
        this.totalSize = new MutableLiveData<>(0L);
        this.isFwDownloading = new MutableLiveData<>(false);
        this.isNeedDownloadFw = new MutableLiveData<>(false);
        this.upgradingProgress = new MutableLiveData<>(0);
        this.upgradingTotalProgress = new MutableLiveData<>(0);
        this.upgradingState = new MutableLiveData<>(0);
        this.isUpgrading = new MutableLiveData<>(false);
        this.isStartCheck = new MutableLiveData<>(false);
        this.readLen = new MutableLiveData<>(0);
        this.offset = new MutableLiveData<>(0L);
    }

    public boolean checkUpgradeCondition() {
        this.notConnectFlight.setValue(Boolean.valueOf(!FlightConfig.isConnectFlight()));
        this.isRemotePowerLow.setValue(Boolean.valueOf(FlightRevData.get().getFlightRemoterBatteryData() != null && FlightRevData.get().getFlightRemoterBatteryData().isRemoterLowPower()));
        this.isPlanePowerLow.setValue(Boolean.valueOf(FlightRevData.get().getFlightRevFlightInfoData().getRemainedBattery() != -1 && FlightRevData.get().getFlightRevFlightInfoData().getRemainedBattery() < 30));
        this.unLock.setValue(Boolean.valueOf(FlightRevData.get().getFlightRevStateData().isUnLock()));
        return (this.notConnectFlight.getValue().booleanValue() || this.isRemotePowerLow.getValue().booleanValue() || this.isPlanePowerLow.getValue().booleanValue() || this.unLock.getValue().booleanValue() || this.isCameraHighTemp.getValue().booleanValue() || this.sdState.getValue() != null) ? false : true;
    }

    public void sendFile() {
        try {
            DDLog.m1684e("大包 filePath： " + this.filePath.getValue());
            if (this.filePath.getValue() != null) {
                File file = new File(this.filePath.getValue());
                if (file.exists()) {
                    DDLog.m1684e("大包文件file:" + file.getName());
                    BigPackageHelper.get().setUploadFile(file);
                }
            }
        } catch (Exception unused) {
            DDLog.m1684e("大包 文件不存在");
        }
    }

    public void onDownloadStart(long j) {
        DDLog.m1684e("开始下载大包固件totalSize: " + j);
        this.totalSize.postValue(Long.valueOf(j));
        this.isFwDownloading.postValue(true);
    }
}