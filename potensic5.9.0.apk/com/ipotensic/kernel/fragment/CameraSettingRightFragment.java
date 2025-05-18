package com.ipotensic.kernel.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.google.common.collect.Lists;
import com.ipotensic.baselib.base.BaseFragment;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.databinding.FragmentCameraSettingRightBinding;
import com.ipotensic.kernel.model.KernelViewModel;
import com.ipotensic.kernel.view.HorizontalWheelView;
import com.ipotensic.kernel.view.ResolutionAndFpsSelectView;
import com.logan.camera.CameraConfig;
import com.logan.camera.data.ManualModeInfo;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes2.dex */
public class CameraSettingRightFragment extends BaseFragment {
    private static final List<String> isoLists = Lists.newArrayList("100", "200", "400", "800", "1600", "3200", "6400");
    private static final List<String> ssList = Lists.newArrayList("1/8000", "1/6400", "1/5000", "1/4000", "1/3200", "1/2500", "1/2000", "1/1600", "1/1250", "1/1000", "1/800", "1/640", "1/500", "1/400", "1/320", "1/240", "1/160", "1/120", "1/100", "1/80", "1/60", "1/50", "1/40", "1/30", "1/25", "1/24");
    private ManualSettingAdvanceCallback callback;
    private boolean isHide;
    private KernelViewModel kernelViewModel;
    private FragmentCameraSettingRightBinding mBind;

    public interface ManualSettingAdvanceCallback {
        void onIsoValueSetting(int i);

        void onSsOrIsoOrSeekbarTouched();

        void onSsValueSetting(int i);

        void onWhiteBalanceModeChange(boolean z);

        void onWhiteBalanceValueSetting(int i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ManualSettingAdvanceCallback) {
            this.callback = (ManualSettingAdvanceCallback) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement SampleCallback");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mBind = FragmentCameraSettingRightBinding.inflate(getLayoutInflater(), viewGroup, false);
        initData();
        initListener();
        initObserver();
        return this.mBind.getRoot();
    }

    private void initData() {
        this.kernelViewModel = (KernelViewModel) new ViewModelProvider(requireActivity()).get(KernelViewModel.class);
        this.mBind.wvSsItem.setItems(UnitUtil.dp2px(268), ssList, CameraConfig.get().getManualModeInfo() != null ? ssList.indexOf(CameraConfig.get().getManualModeInfo().ssUp + InternalZipConstants.ZIP_FILE_SEPARATOR + CameraConfig.get().getManualModeInfo().ssDown) : 0);
        this.mBind.wvIsoItem.setItems(UnitUtil.dp2px(268), isoLists, CameraConfig.get().getManualModeInfo() != null ? isoLists.indexOf(String.valueOf(CameraConfig.get().getManualModeInfo().isoValue)) : 0);
    }

    private void initListener() {
        this.mBind.wvSsItem.setOnWheelViewListener(new HorizontalWheelView.OnWheelViewListener() { // from class: com.ipotensic.kernel.fragment.CameraSettingRightFragment.1
            @Override // com.ipotensic.kernel.view.HorizontalWheelView.OnWheelViewListener
            public void onSelected(int i, String str) {
                if (TextUtils.isEmpty(str) || CameraSettingRightFragment.this.isHide) {
                    return;
                }
                CameraSettingRightFragment.this.callback.onSsValueSetting(Integer.parseInt(str.split(InternalZipConstants.ZIP_FILE_SEPARATOR)[1]));
            }

            @Override // com.ipotensic.kernel.view.HorizontalWheelView.OnWheelViewListener
            public void onTouch() {
                CameraSettingRightFragment.this.callback.onSsOrIsoOrSeekbarTouched();
            }
        });
        this.mBind.wvIsoItem.setOnWheelViewListener(new HorizontalWheelView.OnWheelViewListener() { // from class: com.ipotensic.kernel.fragment.CameraSettingRightFragment.2
            @Override // com.ipotensic.kernel.view.HorizontalWheelView.OnWheelViewListener
            public void onSelected(int i, String str) {
                if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str) || CameraSettingRightFragment.this.isHide) {
                    return;
                }
                CameraSettingRightFragment.this.callback.onIsoValueSetting(Integer.parseInt(str));
            }

            @Override // com.ipotensic.kernel.view.HorizontalWheelView.OnWheelViewListener
            public void onTouch() {
                CameraSettingRightFragment.this.callback.onSsOrIsoOrSeekbarTouched();
            }
        });
        this.mBind.sbWhiteBalance.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.ipotensic.kernel.fragment.CameraSettingRightFragment.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                CameraSettingRightFragment.this.mBind.tvColorTemperature.setText(String.valueOf((i + 20) * 100));
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                CameraSettingRightFragment.this.callback.onSsOrIsoOrSeekbarTouched();
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                CameraSettingRightFragment.this.callback.onWhiteBalanceValueSetting((seekBar.getProgress() + 20) * 100);
            }
        });
        this.mBind.tvAutoWhiteBalance.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$CameraSettingRightFragment$EnXgU2nL5HrT5HQh_G5pAWb87Ak
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraSettingRightFragment.this.lambda$initListener$0$CameraSettingRightFragment(view);
            }
        });
    }

    public /* synthetic */ void lambda$initListener$0$CameraSettingRightFragment(View view) {
        if (this.mBind.tvAutoWhiteBalance.getText().toString().equals("AWB")) {
            this.mBind.tvAutoWhiteBalance.setText("MWB");
            this.callback.onWhiteBalanceModeChange(false);
            enableSeekbar();
        } else {
            this.mBind.tvAutoWhiteBalance.setText("AWB");
            this.callback.onWhiteBalanceModeChange(true);
            disableSeekbar();
        }
    }

    private void initObserver() {
        this.kernelViewModel.getSetRecordSizeSuccess().observe(this, new Observer() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$CameraSettingRightFragment$6mMjyo7zwRJPZgt7qxqzERLGwUw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraSettingRightFragment.this.lambda$initObserver$1$CameraSettingRightFragment((Void) obj);
            }
        });
    }

    public /* synthetic */ void lambda$initObserver$1$CameraSettingRightFragment(Void r1) {
        refreshSsByFps();
    }

    public void setScaleViewValue(int i) {
        FragmentCameraSettingRightBinding fragmentCameraSettingRightBinding = this.mBind;
        if (fragmentCameraSettingRightBinding == null) {
            return;
        }
        if (i < 0) {
            fragmentCameraSettingRightBinding.svEvValue.setPosition(((i - 5) / 10) + 10);
        } else {
            fragmentCameraSettingRightBinding.svEvValue.setPosition(((i + 5) / 10) + 10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        refreshData();
    }

    public void setHide(boolean z) {
        this.isHide = z;
    }

    public void refreshData() {
        if (this.mBind == null) {
            return;
        }
        refreshSsByFps();
        ManualModeInfo manualModeInfo = CameraConfig.get().getManualModeInfo();
        if (manualModeInfo != null) {
            setWhiteBalanceValue(manualModeInfo.wbValue);
            setWhiteBalanceMode(manualModeInfo.isMwbMode);
            setIso(manualModeInfo.isoValue);
        }
    }

    public void refreshSsByFps() {
        if (this.mBind == null) {
            return;
        }
        if (CameraConfig.get().isRecodeMode()) {
            String currentValue = CameraConfig.get().supportVideoSizes.getCurrentValue();
            List<String> list = ssList;
            int size = list.size();
            if (currentValue.endsWith("25")) {
                size = list.size() - 1;
            } else if (currentValue.endsWith(ResolutionAndFpsSelectView.DEFAULT_SELECT_FPS)) {
                size = list.size() - 2;
            } else if (currentValue.endsWith("50")) {
                size = list.size() - 4;
            } else if (currentValue.endsWith("60")) {
                size = list.size() - 5;
            } else if (currentValue.endsWith("120")) {
                size = list.size() - 8;
            }
            int indexOf = CameraConfig.get().getManualModeInfo() != null ? list.subList(0, size).indexOf(CameraConfig.get().getManualModeInfo().ssUp + InternalZipConstants.ZIP_FILE_SEPARATOR + CameraConfig.get().getManualModeInfo().ssDown) : 0;
            if (indexOf == -1) {
                indexOf = size - 1;
            }
            this.mBind.wvSsItem.setItems(UnitUtil.dp2px(268), list.subList(0, size), indexOf);
            return;
        }
        this.mBind.wvSsItem.setItems(UnitUtil.dp2px(268), ssList, CameraConfig.get().getManualModeInfo() != null ? ssList.indexOf(CameraConfig.get().getManualModeInfo().ssUp + InternalZipConstants.ZIP_FILE_SEPARATOR + CameraConfig.get().getManualModeInfo().ssDown) : 0);
    }

    public void setWhiteBalanceValueFrequency(int i) {
        FragmentCameraSettingRightBinding fragmentCameraSettingRightBinding = this.mBind;
        if (fragmentCameraSettingRightBinding != null && fragmentCameraSettingRightBinding.tvAutoWhiteBalance.getText().toString().equals("AWB")) {
            setWhiteBalanceValue(i);
        }
    }

    public void setWhiteBalanceValue(int i) {
        this.mBind.tvColorTemperature.setText(String.valueOf(i));
        this.mBind.sbWhiteBalance.setProgress((i / 100) - 20);
    }

    public void setWhiteBalanceMode(boolean z) {
        if (z) {
            this.mBind.tvAutoWhiteBalance.setText("MWB");
            enableSeekbar();
        } else {
            this.mBind.tvAutoWhiteBalance.setText("AWB");
            disableSeekbar();
        }
    }

    public void setIso(int i) {
        this.mBind.wvIsoItem.setSelection(isoLists.indexOf(String.valueOf(i)));
    }

    private void enableSeekbar() {
        this.mBind.sbWhiteBalance.setEnabled(true);
        this.mBind.tvColorTemperature.setTextColor(-1);
        this.mBind.sbWhiteBalance.setThumb(AppCompatResources.getDrawable(getContext(), C1965R.mipmap.seekbar_thumb));
    }

    private void disableSeekbar() {
        this.mBind.sbWhiteBalance.setEnabled(false);
        this.mBind.tvColorTemperature.setTextColor(Color.parseColor("#999999"));
        this.mBind.sbWhiteBalance.setThumb(AppCompatResources.getDrawable(getContext(), C1965R.mipmap.seekbar_thumb_disable));
    }
}