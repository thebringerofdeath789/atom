package com.ipotensic.kernel.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.controllers.RightController;
import com.ipotensic.kernel.databinding.FragmentCameraSettingLeftBinding;
import com.ipotensic.kernel.model.KernelViewModel;
import com.ipotensic.kernel.view.HorizontalWheelView;
import com.ipotensic.kernel.view.ResolutionAndFpsSelectView;
import com.logan.camera.CameraConfig;
import com.logan.camera.data.CameraSupport;
import com.logan.camera.data.PhotoChildMode;
import com.logan.camera.enums.CaptureMode;

/* loaded from: classes2.dex */
public class CameraSettingLeftFragment extends Fragment {
    private ManualSettingGeneralCallback callback;
    private boolean isHide;
    private KernelViewModel kernelViewModel;
    private FragmentCameraSettingLeftBinding mBind;
    private ResolutionAndFpsSelectView resolutionAndFpsSelectView;

    public interface ManualSettingGeneralCallback {
        void onManualSettingFormatSdClicked();

        void onManualSettingResolutionFpsTouched();

        void onManualSettingSetRaw(boolean z);

        void onManualSettingSetResolutionFps(int i);

        void onManualSettingSetSdcardShowCapacity(boolean z);

        void onPreviewAddCrossChecked(boolean z);

        void onPreviewAddDotChecked(boolean z);

        void onPreviewAddSharpChecked(boolean z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ManualSettingGeneralCallback) {
            this.callback = (ManualSettingGeneralCallback) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement SampleCallback");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mBind = FragmentCameraSettingLeftBinding.inflate(getLayoutInflater(), viewGroup, false);
        initData();
        initListener();
        initObserver();
        return this.mBind.getRoot();
    }

    private void initData() {
        this.kernelViewModel = (KernelViewModel) new ViewModelProvider(requireActivity()).get(KernelViewModel.class);
        this.mBind.wvResolutionItem.setControlFrequency(true);
        this.mBind.wvFpsItem.setControlFrequency(true);
        this.resolutionAndFpsSelectView = new ResolutionAndFpsSelectView(this.mBind.llWvResolutionItemWrapper, this.mBind.llWvFpsItemWrapper, this.mBind.viewResolutionFpsSplit, this.mBind.ivSplitLineEv, this.mBind.wvResolutionItem, this.mBind.wvFpsItem);
        switchCameraMode();
        setPhotoFormat();
        updateSdCheckState();
        updateSdcardInfo();
    }

    private void initListener() {
        this.mBind.rgPhotoFormat.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$CameraSettingLeftFragment$omYe4TYDWLbUCXXomgcRPg1BcdM
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                CameraSettingLeftFragment.this.lambda$initListener$0$CameraSettingLeftFragment(radioGroup, i);
            }
        });
        this.mBind.tvSdFormat.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$CameraSettingLeftFragment$cIAkJB2v69VDES31QaJ_8ygR_44
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraSettingLeftFragment.this.lambda$initListener$1$CameraSettingLeftFragment(view);
            }
        });
        this.mBind.rgSdcardDisplayItems.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$CameraSettingLeftFragment$klqwy4NZCDd0YGCkXX-w4qBkRYg
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                CameraSettingLeftFragment.this.lambda$initListener$2$CameraSettingLeftFragment(radioGroup, i);
            }
        });
        this.resolutionAndFpsSelectView.setOnWheelViewListener(new HorizontalWheelView.OnWheelViewListener() { // from class: com.ipotensic.kernel.fragment.CameraSettingLeftFragment.1
            @Override // com.ipotensic.kernel.view.HorizontalWheelView.OnWheelViewListener
            public void onSelected(int i, String str) {
                if (CameraSettingLeftFragment.this.isHide) {
                    return;
                }
                CameraSettingLeftFragment.this.callback.onManualSettingSetResolutionFps(CameraSupport.getSendValueFromResolutionFps(str));
            }

            @Override // com.ipotensic.kernel.view.HorizontalWheelView.OnWheelViewListener
            public void onTouch() {
                CameraSettingLeftFragment.this.callback.onManualSettingResolutionFpsTouched();
            }
        });
    }

    public /* synthetic */ void lambda$initListener$0$CameraSettingLeftFragment(RadioGroup radioGroup, int i) {
        if (this.mBind.getRoot().findViewById(i).isPressed()) {
            boolean z = i == R.id.rb_photo_format_raw;
            if (CameraConfig.get().isRaw() == z) {
                return;
            }
            this.callback.onManualSettingSetRaw(z);
        }
    }

    public /* synthetic */ void lambda$initListener$1$CameraSettingLeftFragment(View view) {
        RightController rightController = (RightController) EventDispatcher.get().getController(RightController.class);
        if (rightController == null || !rightController.isRecording()) {
            this.callback.onManualSettingFormatSdClicked();
        }
    }

    public /* synthetic */ void lambda$initListener$2$CameraSettingLeftFragment(RadioGroup radioGroup, int i) {
        if (this.mBind.getRoot().findViewById(i).isPressed()) {
            this.callback.onManualSettingSetSdcardShowCapacity(i == R.id.rb_sdcard_volume);
        }
    }

    private void initObserver() {
        this.kernelViewModel.getPhotoChildModeData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$CameraSettingLeftFragment$_QVdkGCJ0_qSW42G-H_AsGLRcJI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraSettingLeftFragment.this.lambda$initObserver$3$CameraSettingLeftFragment((PhotoChildMode) obj);
            }
        });
    }

    public /* synthetic */ void lambda$initObserver$3$CameraSettingLeftFragment(PhotoChildMode photoChildMode) {
        if (photoChildMode.isTimerMode()) {
            this.mBind.rgPhotoFormat.setAlpha(0.5f);
            setJpgOrRawEnable(false);
        } else {
            this.mBind.rgPhotoFormat.setAlpha(1.0f);
            setJpgOrRawEnable(true);
        }
    }

    public void setHide(boolean z) {
        this.isHide = z;
    }

    public void switchCameraMode() {
        if (this.mBind == null) {
            return;
        }
        if (CameraConfig.get().isRecodeMode()) {
            this.mBind.rgPhotoFormat.setVisibility(8);
            this.resolutionAndFpsSelectView.showResolutionAndFpsScrollView(CameraConfig.get().supportVideoSizes.getSupportResolutionAndFps(), UnitUtil.dp2px(268), CameraConfig.get().supportVideoSizes.getCurrentValue());
            this.mBind.tvPhotoFormat.setText(R.string.resolution_fps);
        } else {
            this.mBind.rgPhotoFormat.setVisibility(0);
            this.resolutionAndFpsSelectView.dismiss();
            this.mBind.tvPhotoFormat.setText(R.string.photo_format);
        }
    }

    public void setPhotoFormat() {
        if (this.mBind == null) {
            return;
        }
        if (CameraConfig.get().isRaw()) {
            this.mBind.rgPhotoFormat.check(R.id.rb_photo_format_raw);
        } else {
            this.mBind.rgPhotoFormat.check(R.id.rb_photo_format_jpg);
        }
    }

    public void updateSdcardInfo() {
        FragmentCameraSettingLeftBinding fragmentCameraSettingLeftBinding = this.mBind;
        if (fragmentCameraSettingLeftBinding == null) {
            return;
        }
        fragmentCameraSettingLeftBinding.rbSdcardVolume.setText(getSdCapacity());
        this.mBind.rbSdcardEstimate.setText(getPhotoOrVideoCapacity());
    }

    public void updateSdCheckState() {
        if (this.mBind == null) {
            return;
        }
        if (SPHelper.getInstance().showSdCapacity()) {
            this.mBind.rgSdcardDisplayItems.check(R.id.rb_sdcard_volume);
        } else {
            this.mBind.rgSdcardDisplayItems.check(R.id.rb_sdcard_estimate);
        }
    }

    private String getPhotoOrVideoCapacity() {
        if (CameraConfig.get().getCaptureMode() == CaptureMode.MODE_PHOTO) {
            return !CameraConfig.get().isSdCardAvailable() ? getContext().getString(R.string.n_a) : CameraConfig.get().getPhotoRemain() + " P";
        }
        return !CameraConfig.get().isSdCardAvailable() ? getContext().getString(R.string.n_a) : FormatUtil.secondToHHmmss(CameraConfig.get().getRecordRemain());
    }

    private String getSdCapacity() {
        if (!CameraConfig.get().isSdCardAvailable()) {
            return getContext().getString(R.string.n_a);
        }
        return FormatUtil.getSdCardSpaceRatio(CameraConfig.get().getSdFreeSpace(), CameraConfig.get().getSdTotalSpace());
    }

    private void setJpgOrRawEnable(boolean z) {
        int childCount = this.mBind.rgPhotoFormat.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.mBind.rgPhotoFormat.getChildAt(i).setEnabled(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.callback = null;
    }
}
