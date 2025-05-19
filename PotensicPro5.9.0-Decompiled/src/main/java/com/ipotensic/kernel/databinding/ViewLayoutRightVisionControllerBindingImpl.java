package com.ipotensic.kernel.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.baselib.enums.VisionExecuteType;
import com.ipotensic.baselib.views.RoundRelativeLayout;
import com.ipotensic.baselib.views.StrokeTextView;
import com.ipotensic.baselib.views.wheelview.widget.WheelView;
import com.ipotensic.kernel.BR;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.model.RightControllerModel;
import com.ipotensic.kernel.view.CaptureProgressButton;
import com.ipotensic.kernel.view.DispatchTextView;
import com.ipotensic.kernel.view.OneKeyVideoButton;
import com.ipotensic.kernel.view.ShortVideoCountDownView;
import com.ipotensic.kernel.view.TimerControlView;
import com.ipotensic.kernel.view.VisionGalleryButton;
import com.ipotensic.kernel.view.ZoomControlView;
import xyz.doikki.videoplayer.player.VideoView;

/* loaded from: classes2.dex */
public class ViewLayoutRightVisionControllerBindingImpl extends ViewLayoutRightVisionControllerBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private long mDirtyFlags_1;
    private long mDirtyFlags_2;
    private OnClickListenerImpl mModelOnBlankClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mModelOnCountDownViewClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl2 mModelOnDemoVideoClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl3 mModelOnParams1ClickAndroidViewViewOnClickListener;
    private final ConstraintLayout mboundView0;
    private final ConstraintLayout mboundView25;
    private final View mboundView29;
    private final View mboundView31;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guide_right, 32);
        sparseIntArray.put(R.id.iv_timed_capture_photo, 33);
        sparseIntArray.put(R.id.ll_timed_info, 34);
        sparseIntArray.put(R.id.tv_camera_time, 35);
        sparseIntArray.put(R.id.tv_photo_count, 36);
        sparseIntArray.put(R.id.tv_zoom_scale, 37);
        sparseIntArray.put(R.id.tv_timer_scale, 38);
        sparseIntArray.put(R.id.zoom_control_view, 39);
        sparseIntArray.put(R.id.timer_control_view, 40);
        sparseIntArray.put(R.id.tv_count_down, 41);
    }

    public ViewLayoutRightVisionControllerBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 42, sIncludes, sViewsWithIds));
    }

    private ViewLayoutRightVisionControllerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 24, (View) objArr[4], (ImageButton) objArr[26], (CaptureProgressButton) objArr[20], (ImageButton) objArr[5], (VisionGalleryButton) objArr[30], (OneKeyVideoButton) objArr[28], (ImageButton) objArr[24], (ImageButton) objArr[27], (Guideline) objArr[32], (ImageView) objArr[19], (ImageView) objArr[22], (ImageView) objArr[33], (LinearLayout) objArr[13], (LinearLayout) objArr[17], (RoundRelativeLayout) objArr[1], (LinearLayout) objArr[9], (LinearLayout) objArr[15], (ConstraintLayout) objArr[7], (LinearLayout) objArr[11], (LinearLayout) objArr[8], (LinearLayout) objArr[34], (TimerControlView) objArr[40], (TextView) objArr[35], (TextView) objArr[14], (TextView) objArr[18], (TextView) objArr[41], (TextView) objArr[36], (TextView) objArr[10], (StrokeTextView) objArr[21], (TextView) objArr[16], (TextView) objArr[12], (TextView) objArr[3], (DispatchTextView) objArr[38], (DispatchTextView) objArr[37], (ShortVideoCountDownView) objArr[6], (VideoView) objArr[2], (WheelView) objArr[23], (ZoomControlView) objArr[39]);
        this.mDirtyFlags = -1L;
        this.mDirtyFlags_1 = -1L;
        this.mDirtyFlags_2 = -1L;
        this.blankView.setTag(null);
        this.btnCameraSetting.setTag(null);
        this.btnCapture.setTag(null);
        this.btnDemoVideoVisible.setTag(null);
        this.btnGallery.setTag(null);
        this.btnOneKeyVideo.setTag(null);
        this.btnParamsMode.setTag(null);
        this.btnSwitchCapture.setTag(null);
        this.imgBgParamsSetting.setTag(null);
        this.ivRecordRed.setTag(null);
        this.layoutCircle.setTag(null);
        this.layoutComet.setTag(null);
        this.layoutDemoVideo.setTag(null);
        this.layoutRecess.setTag(null);
        this.layoutScrew.setTag(null);
        this.layoutShortVideo.setTag(null);
        this.layoutSkyward.setTag(null);
        this.layoutVideoType.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[25];
        this.mboundView25 = constraintLayout2;
        constraintLayout2.setTag(null);
        View view2 = (View) objArr[29];
        this.mboundView29 = view2;
        view2.setTag(null);
        View view3 = (View) objArr[31];
        this.mboundView31 = view3;
        view3.setTag(null);
        this.tvCircle.setTag(null);
        this.tvComet.setTag(null);
        this.tvRecess.setTag(null);
        this.tvRecordTips.setTag(null);
        this.tvScrew.setTag(null);
        this.tvSkyward.setTag(null);
        this.tvTeachVideoTips.setTag(null);
        this.viewCountdown.setTag(null);
        this.viewDemoVideo.setTag(null);
        this.wheelView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 33554432L;
            this.mDirtyFlags_1 = 0L;
            this.mDirtyFlags_2 = 0L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags == 0 && this.mDirtyFlags_1 == 0 && this.mDirtyFlags_2 == 0) {
                return false;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.model != i) {
            return false;
        }
        setModel((RightControllerModel) obj);
        return true;
    }

    @Override // com.ipotensic.kernel.databinding.ViewLayoutRightVisionControllerBinding
    public void setModel(RightControllerModel rightControllerModel) {
        this.mModel = rightControllerModel;
        synchronized (this) {
            this.mDirtyFlags |= 16777216;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeModelIsCameraConnected((ObservableBoolean) obj, i2);
            case 1:
                return onChangeModelIsTimePhotography((ObservableBoolean) obj, i2);
            case 2:
                return onChangeModelIsExecuting((ObservableBoolean) obj, i2);
            case 3:
                return onChangeModelIsManualMode((ObservableBoolean) obj, i2);
            case 4:
                return onChangeModelIsDemoVideoVisible((ObservableBoolean) obj, i2);
            case 5:
                return onChangeModelIsCountStart((ObservableBoolean) obj, i2);
            case 6:
                return onChangeModelIsTrackFunctionOpen((ObservableBoolean) obj, i2);
            case 7:
                return onChangeModelBtnCaptureMode((ObservableInt) obj, i2);
            case 8:
                return onChangeModelIsRecordRedPointShow((ObservableBoolean) obj, i2);
            case 9:
                return onChangeModelIsTakingPhoto((ObservableBoolean) obj, i2);
            case 10:
                return onChangeModelIsCameraHighTemp((ObservableBoolean) obj, i2);
            case 11:
                return onChangeModelBtnGalleryMode((ObservableInt) obj, i2);
            case 12:
                return onChangeModelIsAtomSE((ObservableBoolean) obj, i2);
            case 13:
                return onChangeModelRecordTxt((ObservableString) obj, i2);
            case 14:
                return onChangeModelIsAtomLT((ObservableBoolean) obj, i2);
            case 15:
                return onChangeModelIsSwitchingMode((ObservableBoolean) obj, i2);
            case 16:
                return onChangeModelVideoType((ObservableField) obj, i2);
            case 17:
                return onChangeModelIsCameraSettingControllerShow((ObservableBoolean) obj, i2);
            case 18:
                return onChangeModelIsVideoTypeVisible((ObservableBoolean) obj, i2);
            case 19:
                return onChangeModelProgressPercent((ObservableInt) obj, i2);
            case 20:
                return onChangeModelIsPressRemoterKey((ObservableBoolean) obj, i2);
            case 21:
                return onChangeModelIsAtomPanTilt((ObservableBoolean) obj, i2);
            case 22:
                return onChangeModelIsRecording((ObservableBoolean) obj, i2);
            case 23:
                return onChangeModelIsParams1Select((ObservableBoolean) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeModelIsCameraConnected(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeModelIsTimePhotography(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeModelIsExecuting(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeModelIsManualMode(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeModelIsDemoVideoVisible(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeModelIsCountStart(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeModelIsTrackFunctionOpen(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeModelBtnCaptureMode(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeModelIsRecordRedPointShow(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeModelIsTakingPhoto(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeModelIsCameraHighTemp(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeModelBtnGalleryMode(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeModelIsAtomSE(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    private boolean onChangeModelRecordTxt(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        return true;
    }

    private boolean onChangeModelIsAtomLT(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        return true;
    }

    private boolean onChangeModelIsSwitchingMode(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32768;
        }
        return true;
    }

    private boolean onChangeModelVideoType(ObservableField<VisionExecuteType> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 65536;
        }
        return true;
    }

    private boolean onChangeModelIsCameraSettingControllerShow(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 131072;
        }
        return true;
    }

    private boolean onChangeModelIsVideoTypeVisible(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        }
        return true;
    }

    private boolean onChangeModelProgressPercent(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        return true;
    }

    private boolean onChangeModelIsPressRemoterKey(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        return true;
    }

    private boolean onChangeModelIsAtomPanTilt(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        }
        return true;
    }

    private boolean onChangeModelIsRecording(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4194304;
        }
        return true;
    }

    private boolean onChangeModelIsParams1Select(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8388608;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:1001:0x138f  */
    /* JADX WARN: Removed duplicated region for block: B:1004:0x13ae  */
    /* JADX WARN: Removed duplicated region for block: B:1006:0x13b7  */
    /* JADX WARN: Removed duplicated region for block: B:1008:0x13be  */
    /* JADX WARN: Removed duplicated region for block: B:1011:0x13cd  */
    /* JADX WARN: Removed duplicated region for block: B:1014:0x13e1  */
    /* JADX WARN: Removed duplicated region for block: B:1017:0x13f4  */
    /* JADX WARN: Removed duplicated region for block: B:1020:0x1401  */
    /* JADX WARN: Removed duplicated region for block: B:1023:0x140e  */
    /* JADX WARN: Removed duplicated region for block: B:1026:0x141d  */
    /* JADX WARN: Removed duplicated region for block: B:1029:0x142c  */
    /* JADX WARN: Removed duplicated region for block: B:1032:0x1442  */
    /* JADX WARN: Removed duplicated region for block: B:1035:0x1451  */
    /* JADX WARN: Removed duplicated region for block: B:1038:0x145e  */
    /* JADX WARN: Removed duplicated region for block: B:1041:0x148b  */
    /* JADX WARN: Removed duplicated region for block: B:1044:0x1498  */
    /* JADX WARN: Removed duplicated region for block: B:1047:0x14a7  */
    /* JADX WARN: Removed duplicated region for block: B:1050:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1051:0x1287  */
    /* JADX WARN: Removed duplicated region for block: B:1052:0x125e  */
    /* JADX WARN: Removed duplicated region for block: B:1055:0x121b  */
    /* JADX WARN: Removed duplicated region for block: B:1056:0x11f5  */
    /* JADX WARN: Removed duplicated region for block: B:1058:0x11d8  */
    /* JADX WARN: Removed duplicated region for block: B:1061:0x119d  */
    /* JADX WARN: Removed duplicated region for block: B:1064:0x11a9  */
    /* JADX WARN: Removed duplicated region for block: B:1066:0x11a0  */
    /* JADX WARN: Removed duplicated region for block: B:1068:0x1188  */
    /* JADX WARN: Removed duplicated region for block: B:1070:0x115e  */
    /* JADX WARN: Removed duplicated region for block: B:1071:0x1144  */
    /* JADX WARN: Removed duplicated region for block: B:1073:0x112f  */
    /* JADX WARN: Removed duplicated region for block: B:1076:0x110e  */
    /* JADX WARN: Removed duplicated region for block: B:1079:0x10dd  */
    /* JADX WARN: Removed duplicated region for block: B:1082:0x10ab  */
    /* JADX WARN: Removed duplicated region for block: B:1084:0x1085  */
    /* JADX WARN: Removed duplicated region for block: B:1086:0x1067  */
    /* JADX WARN: Removed duplicated region for block: B:1088:0x104f  */
    /* JADX WARN: Removed duplicated region for block: B:1090:0x1038  */
    /* JADX WARN: Removed duplicated region for block: B:1091:0x1018  */
    /* JADX WARN: Removed duplicated region for block: B:1093:0x1003  */
    /* JADX WARN: Removed duplicated region for block: B:1098:0x0fc4  */
    /* JADX WARN: Removed duplicated region for block: B:1101:0x0f92  */
    /* JADX WARN: Removed duplicated region for block: B:1104:0x0f62  */
    /* JADX WARN: Removed duplicated region for block: B:1106:0x0f1b  */
    /* JADX WARN: Removed duplicated region for block: B:1109:0x0f2b  */
    /* JADX WARN: Removed duplicated region for block: B:1111:0x0f30  */
    /* JADX WARN: Removed duplicated region for block: B:1112:0x0f20  */
    /* JADX WARN: Removed duplicated region for block: B:1115:0x0ef7  */
    /* JADX WARN: Removed duplicated region for block: B:1116:0x0ed3  */
    /* JADX WARN: Removed duplicated region for block: B:1118:0x0ebc  */
    /* JADX WARN: Removed duplicated region for block: B:1120:0x0e9c  */
    /* JADX WARN: Removed duplicated region for block: B:1123:0x0e7f  */
    /* JADX WARN: Removed duplicated region for block: B:1124:0x0e59  */
    /* JADX WARN: Removed duplicated region for block: B:1125:0x0e40  */
    /* JADX WARN: Removed duplicated region for block: B:1127:0x0e2d  */
    /* JADX WARN: Removed duplicated region for block: B:1131:0x0e0b  */
    /* JADX WARN: Removed duplicated region for block: B:1133:0x0daa  */
    /* JADX WARN: Removed duplicated region for block: B:1135:0x0d8d  */
    /* JADX WARN: Removed duplicated region for block: B:1136:0x0d72  */
    /* JADX WARN: Removed duplicated region for block: B:1139:0x0d44  */
    /* JADX WARN: Removed duplicated region for block: B:1142:0x0d54  */
    /* JADX WARN: Removed duplicated region for block: B:1145:0x0d64  */
    /* JADX WARN: Removed duplicated region for block: B:1146:0x0d49  */
    /* JADX WARN: Removed duplicated region for block: B:1147:0x0d26  */
    /* JADX WARN: Removed duplicated region for block: B:1150:0x0d0d  */
    /* JADX WARN: Removed duplicated region for block: B:1151:0x0ce6  */
    /* JADX WARN: Removed duplicated region for block: B:1154:0x0ccf  */
    /* JADX WARN: Removed duplicated region for block: B:1156:0x0c9d  */
    /* JADX WARN: Removed duplicated region for block: B:1157:0x0c74  */
    /* JADX WARN: Removed duplicated region for block: B:1158:0x0c64  */
    /* JADX WARN: Removed duplicated region for block: B:1159:0x0c55  */
    /* JADX WARN: Removed duplicated region for block: B:1161:0x0c41  */
    /* JADX WARN: Removed duplicated region for block: B:1162:0x0c27  */
    /* JADX WARN: Removed duplicated region for block: B:1164:0x0c16  */
    /* JADX WARN: Removed duplicated region for block: B:1166:0x0bf9  */
    /* JADX WARN: Removed duplicated region for block: B:1167:0x0bcf  */
    /* JADX WARN: Removed duplicated region for block: B:1169:0x0bc0  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:1170:0x0ba5  */
    /* JADX WARN: Removed duplicated region for block: B:1172:0x0b91  */
    /* JADX WARN: Removed duplicated region for block: B:1174:0x0b74  */
    /* JADX WARN: Removed duplicated region for block: B:1178:0x0b4e  */
    /* JADX WARN: Removed duplicated region for block: B:1179:0x0b0d  */
    /* JADX WARN: Removed duplicated region for block: B:1182:0x0afb  */
    /* JADX WARN: Removed duplicated region for block: B:1185:0x0a97  */
    /* JADX WARN: Removed duplicated region for block: B:1186:0x0a70  */
    /* JADX WARN: Removed duplicated region for block: B:1187:0x0a5e  */
    /* JADX WARN: Removed duplicated region for block: B:1188:0x0a4e  */
    /* JADX WARN: Removed duplicated region for block: B:1191:0x0a29  */
    /* JADX WARN: Removed duplicated region for block: B:1194:0x0a39  */
    /* JADX WARN: Removed duplicated region for block: B:1196:0x0a3e  */
    /* JADX WARN: Removed duplicated region for block: B:1197:0x0a2e  */
    /* JADX WARN: Removed duplicated region for block: B:1198:0x0a0b  */
    /* JADX WARN: Removed duplicated region for block: B:1292:0x05a3  */
    /* JADX WARN: Removed duplicated region for block: B:1295:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:1299:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:1309:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:1312:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:1314:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:1317:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:1323:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:1330:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:1333:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x0a08  */
    /* JADX WARN: Removed duplicated region for block: B:470:0x0a4b  */
    /* JADX WARN: Removed duplicated region for block: B:473:0x0a5b  */
    /* JADX WARN: Removed duplicated region for block: B:476:0x0a6b  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x0a7a  */
    /* JADX WARN: Removed duplicated region for block: B:488:0x0aad  */
    /* JADX WARN: Removed duplicated region for block: B:508:0x0b0a  */
    /* JADX WARN: Removed duplicated region for block: B:511:0x0b17  */
    /* JADX WARN: Removed duplicated region for block: B:525:0x0b5b  */
    /* JADX WARN: Removed duplicated region for block: B:534:0x0b7e  */
    /* JADX WARN: Removed duplicated region for block: B:543:0x0b9e  */
    /* JADX WARN: Removed duplicated region for block: B:548:0x0bad  */
    /* JADX WARN: Removed duplicated region for block: B:557:0x0bca  */
    /* JADX WARN: Removed duplicated region for block: B:561:0x0bda  */
    /* JADX WARN: Removed duplicated region for block: B:572:0x0c02  */
    /* JADX WARN: Removed duplicated region for block: B:581:0x0c1f  */
    /* JADX WARN: Removed duplicated region for block: B:586:0x0c2e  */
    /* JADX WARN: Removed duplicated region for block: B:595:0x0c4e  */
    /* JADX WARN: Removed duplicated region for block: B:600:0x0c61  */
    /* JADX WARN: Removed duplicated region for block: B:603:0x0c71  */
    /* JADX WARN: Removed duplicated region for block: B:606:0x0c81  */
    /* JADX WARN: Removed duplicated region for block: B:615:0x0cac  */
    /* JADX WARN: Removed duplicated region for block: B:626:0x0ce3  */
    /* JADX WARN: Removed duplicated region for block: B:629:0x0cf0  */
    /* JADX WARN: Removed duplicated region for block: B:638:0x0d23  */
    /* JADX WARN: Removed duplicated region for block: B:641:0x0d30  */
    /* JADX WARN: Removed duplicated region for block: B:646:0x0d6c  */
    /* JADX WARN: Removed duplicated region for block: B:650:0x0d7a  */
    /* JADX WARN: Removed duplicated region for block: B:659:0x0d97  */
    /* JADX WARN: Removed duplicated region for block: B:668:0x0db4  */
    /* JADX WARN: Removed duplicated region for block: B:690:0x0e19  */
    /* JADX WARN: Removed duplicated region for block: B:699:0x0e3b  */
    /* JADX WARN: Removed duplicated region for block: B:703:0x0e48  */
    /* JADX WARN: Removed duplicated region for block: B:712:0x0e63  */
    /* JADX WARN: Removed duplicated region for block: B:724:0x0e89  */
    /* JADX WARN: Removed duplicated region for block: B:733:0x0ea9  */
    /* JADX WARN: Removed duplicated region for block: B:742:0x0ec9  */
    /* JADX WARN: Removed duplicated region for block: B:747:0x0ede  */
    /* JADX WARN: Removed duplicated region for block: B:755:0x0f08  */
    /* JADX WARN: Removed duplicated region for block: B:760:0x0f3e  */
    /* JADX WARN: Removed duplicated region for block: B:771:0x0f74  */
    /* JADX WARN: Removed duplicated region for block: B:780:0x0fa5  */
    /* JADX WARN: Removed duplicated region for block: B:789:0x0fd0  */
    /* JADX WARN: Removed duplicated region for block: B:800:0x0ff0  */
    /* JADX WARN: Removed duplicated region for block: B:807:0x1007  */
    /* JADX WARN: Removed duplicated region for block: B:815:0x101c  */
    /* JADX WARN: Removed duplicated region for block: B:826:0x103b  */
    /* JADX WARN: Removed duplicated region for block: B:835:0x1059  */
    /* JADX WARN: Removed duplicated region for block: B:839:0x106c  */
    /* JADX WARN: Removed duplicated region for block: B:848:0x108f  */
    /* JADX WARN: Removed duplicated region for block: B:857:0x10bf  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:866:0x10f2  */
    /* JADX WARN: Removed duplicated region for block: B:874:0x1114 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:877:0x111c  */
    /* JADX WARN: Removed duplicated region for block: B:884:0x1132  */
    /* JADX WARN: Removed duplicated region for block: B:892:0x1148  */
    /* JADX WARN: Removed duplicated region for block: B:901:0x116c  */
    /* JADX WARN: Removed duplicated region for block: B:909:0x1195  */
    /* JADX WARN: Removed duplicated region for block: B:913:0x11ba A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:917:0x11c6  */
    /* JADX WARN: Removed duplicated region for block: B:926:0x11e1  */
    /* JADX WARN: Removed duplicated region for block: B:934:0x1201  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:942:0x1225  */
    /* JADX WARN: Removed duplicated region for block: B:952:0x1245 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:955:0x124d  */
    /* JADX WARN: Removed duplicated region for block: B:964:0x126a  */
    /* JADX WARN: Removed duplicated region for block: B:972:0x127f  */
    /* JADX WARN: Removed duplicated region for block: B:977:0x1293  */
    /* JADX WARN: Removed duplicated region for block: B:980:0x12b7  */
    /* JADX WARN: Removed duplicated region for block: B:983:0x1334  */
    /* JADX WARN: Removed duplicated region for block: B:986:0x133f  */
    /* JADX WARN: Removed duplicated region for block: B:989:0x134c  */
    /* JADX WARN: Removed duplicated region for block: B:992:0x1360  */
    /* JADX WARN: Removed duplicated region for block: B:995:0x136f  */
    /* JADX WARN: Removed duplicated region for block: B:998:0x137e  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 5300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.kernel.databinding.ViewLayoutRightVisionControllerBindingImpl.executeBindings():void");
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private RightControllerModel value;

        public OnClickListenerImpl setValue(RightControllerModel rightControllerModel) {
            this.value = rightControllerModel;
            if (rightControllerModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.onBlankClick(view);
        }
    }

    public static class OnClickListenerImpl1 implements View.OnClickListener {
        private RightControllerModel value;

        public OnClickListenerImpl1 setValue(RightControllerModel rightControllerModel) {
            this.value = rightControllerModel;
            if (rightControllerModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.onCountDownViewClick(view);
        }
    }

    public static class OnClickListenerImpl2 implements View.OnClickListener {
        private RightControllerModel value;

        public OnClickListenerImpl2 setValue(RightControllerModel rightControllerModel) {
            this.value = rightControllerModel;
            if (rightControllerModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.onDemoVideoClick(view);
        }
    }

    public static class OnClickListenerImpl3 implements View.OnClickListener {
        private RightControllerModel value;

        public OnClickListenerImpl3 setValue(RightControllerModel rightControllerModel) {
            this.value = rightControllerModel;
            if (rightControllerModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.onParams1Click(view);
        }
    }
}
