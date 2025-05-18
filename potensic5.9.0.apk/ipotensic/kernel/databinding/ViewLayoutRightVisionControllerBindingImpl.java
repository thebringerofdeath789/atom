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
import com.google.common.primitives.Longs;
import com.ipotensic.baselib.enums.VisionExecuteType;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.views.RoundRelativeLayout;
import com.ipotensic.baselib.views.StrokeTextView;
import com.ipotensic.baselib.views.wheelview.widget.WheelView;
import com.ipotensic.kernel.BR;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.adapter.ViewBindingAdapter;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.enums.CaptureUIType;
import com.ipotensic.kernel.enums.GalleryUIType;
import com.ipotensic.kernel.model.RightControllerModel;
import com.ipotensic.kernel.view.CaptureProgressButton;
import com.ipotensic.kernel.view.DispatchTextView;
import com.ipotensic.kernel.view.OneKeyVideoButton;
import com.ipotensic.kernel.view.ShortVideoCountDownView;
import com.ipotensic.kernel.view.TimerControlView;
import com.ipotensic.kernel.view.VisionGalleryButton;
import com.ipotensic.kernel.view.ZoomControlView;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.apache.poi.ss.util.IEEEDouble;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
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
    */
    protected void executeBindings() {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        OnClickListenerImpl2 onClickListenerImpl2;
        ScaleClickListener scaleClickListener;
        OnClickListenerImpl onClickListenerImpl;
        OnClickListenerImpl3 onClickListenerImpl3;
        ScaleClickListener scaleClickListener2;
        ScaleClickListener scaleClickListener3;
        ScaleClickListener scaleClickListener4;
        ScaleClickListener scaleClickListener5;
        ObservableInt observableInt;
        ObservableString observableString;
        ObservableBoolean observableBoolean;
        ObservableBoolean observableBoolean2;
        ObservableBoolean observableBoolean3;
        OnClickListenerImpl1 onClickListenerImpl1;
        ObservableInt observableInt2;
        ScaleClickListener scaleClickListener6;
        ScaleClickListener scaleClickListener7;
        ObservableBoolean observableBoolean4;
        ScaleClickListener scaleClickListener8;
        ScaleClickListener scaleClickListener9;
        ScaleClickListener scaleClickListener10;
        ShortVideoCountDownView.OnCountDownListener onCountDownListener;
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        boolean z4;
        int i2;
        boolean z5;
        int i3;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        int i4;
        int i5;
        boolean z10;
        int i6;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        int i7;
        boolean z16;
        boolean z17;
        long j6;
        VisionExecuteType visionExecuteType;
        boolean z18;
        ScaleClickListener scaleClickListener11;
        OnClickListenerImpl3 onClickListenerImpl32;
        ObservableBoolean observableBoolean5;
        int i8;
        long j7;
        int i9;
        boolean z19;
        ScaleClickListener scaleClickListener12;
        int i10;
        boolean z20;
        int i11;
        boolean z21;
        VisionExecuteType visionExecuteType2;
        boolean z22;
        boolean z23;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z24;
        boolean z25;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z26;
        boolean z27;
        int i20;
        int i21;
        long j8;
        int i22;
        ScaleClickListener scaleClickListener13;
        long j9;
        int i23;
        ObservableBoolean observableBoolean6;
        boolean z28;
        boolean z29;
        int i24;
        ObservableBoolean observableBoolean7;
        boolean z30;
        boolean z31;
        long j10;
        int i25;
        ObservableBoolean observableBoolean8;
        boolean z32;
        ObservableBoolean observableBoolean9;
        boolean z33;
        boolean z34;
        ObservableBoolean observableBoolean10;
        boolean z35;
        boolean z36;
        long j11;
        int i26;
        int i27;
        int i28;
        long j12;
        boolean z37;
        long j13;
        boolean z38;
        int i29;
        long j14;
        boolean z39;
        long j15;
        float f;
        long j16;
        boolean z40;
        int i30;
        long j17;
        boolean z41;
        int i31;
        float f2;
        int i32;
        boolean z42;
        boolean z43;
        boolean z44;
        boolean z45;
        int i33;
        boolean z46;
        int i34;
        boolean z47;
        ObservableBoolean observableBoolean11;
        boolean z48;
        boolean z49;
        boolean z50;
        ObservableBoolean observableBoolean12;
        ObservableBoolean observableBoolean13;
        long j18;
        long j19;
        boolean z51;
        long j20;
        boolean z52;
        long j21;
        ObservableBoolean observableBoolean14;
        int i35;
        int i36;
        long j22;
        boolean z53;
        long j23;
        long j24;
        int i37;
        long j25;
        boolean z54;
        long j26;
        boolean z55;
        int i38;
        int i39;
        int i40;
        int i41;
        boolean z56;
        boolean z57;
        ObservableBoolean observableBoolean15;
        boolean z58;
        boolean z59;
        boolean z60;
        ObservableBoolean observableBoolean16;
        boolean z61;
        int i42;
        int i43;
        boolean z62;
        boolean z63;
        ObservableBoolean observableBoolean17;
        boolean z64;
        ObservableBoolean observableBoolean18;
        long j27;
        int i44;
        long j28;
        boolean z65;
        int i45;
        boolean z66;
        int i46;
        boolean z67;
        boolean z68;
        boolean z69;
        int i47;
        ObservableBoolean observableBoolean19;
        boolean z70;
        boolean z71;
        boolean z72;
        ObservableBoolean observableBoolean20;
        ObservableBoolean observableBoolean21;
        boolean z73;
        ObservableBoolean observableBoolean22;
        boolean z74;
        boolean z75;
        boolean z76;
        int i48;
        ObservableBoolean observableBoolean23;
        long j29;
        boolean z77;
        long j30;
        boolean z78;
        long j31;
        boolean z79;
        ObservableBoolean observableBoolean24;
        ObservableBoolean observableBoolean25;
        ObservableBoolean observableBoolean26;
        ObservableBoolean observableBoolean27;
        ObservableBoolean observableBoolean28;
        long j32;
        ObservableInt observableInt3;
        ObservableBoolean observableBoolean29;
        long j33;
        ObservableBoolean observableBoolean30;
        ObservableInt observableInt4;
        ObservableBoolean observableBoolean31;
        boolean z80;
        ObservableBoolean observableBoolean32;
        boolean z81;
        boolean z82;
        ObservableBoolean observableBoolean33;
        ScaleClickListener scaleClickListener14;
        ScaleClickListener scaleClickListener15;
        ScaleClickListener scaleClickListener16;
        OnClickListenerImpl onClickListenerImpl4;
        ScaleClickListener scaleClickListener17;
        ScaleClickListener scaleClickListener18;
        OnClickListenerImpl1 onClickListenerImpl12;
        OnClickListenerImpl2 onClickListenerImpl22;
        ScaleClickListener scaleClickListener19;
        ScaleClickListener scaleClickListener20;
        ScaleClickListener scaleClickListener21;
        OnClickListenerImpl3 onClickListenerImpl33;
        ScaleClickListener scaleClickListener22;
        ScaleClickListener scaleClickListener23;
        boolean z83;
        int i49;
        int i50;
        ObservableBoolean observableBoolean34;
        ShortVideoCountDownView.OnCountDownListener onCountDownListener2;
        boolean z84;
        ScaleClickListener scaleClickListener24;
        ObservableInt observableInt5;
        boolean z85;
        boolean z86;
        int i51;
        int i52;
        boolean z87;
        ObservableInt observableInt6;
        boolean z88;
        int i53;
        int i54;
        long j34;
        boolean z89;
        ObservableString observableString2;
        long j35;
        ObservableString observableString3;
        ObservableBoolean observableBoolean35;
        boolean z90;
        int i55;
        int i56;
        VisionExecuteType visionExecuteType3;
        boolean z91;
        boolean z92;
        boolean z93;
        boolean z94;
        boolean z95;
        long j36;
        boolean z96;
        int i57;
        long j37;
        int i58;
        boolean z97;
        ObservableBoolean observableBoolean36;
        ObservableBoolean observableBoolean37;
        long j38;
        ObservableField<VisionExecuteType> observableField;
        boolean z98;
        ObservableBoolean observableBoolean38;
        ObservableInt observableInt7;
        ObservableBoolean observableBoolean39;
        ObservableInt observableInt8;
        ObservableBoolean observableBoolean40;
        long j39;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
            j2 = this.mDirtyFlags_1;
            this.mDirtyFlags_1 = 0L;
            j3 = this.mDirtyFlags_2;
            this.mDirtyFlags_2 = 0L;
        }
        RightControllerModel rightControllerModel = this.mModel;
        if ((67108863 & j) != 0) {
            if ((j & 54690343) != 0) {
                observableBoolean32 = rightControllerModel != null ? rightControllerModel.isCameraConnected : null;
                updateRegistration(0, observableBoolean32);
                z80 = observableBoolean32 != null ? observableBoolean32.get() : false;
                if ((j & 54559271) != 0) {
                    j = z80 ? j | IjkMediaMeta.AV_CH_LOW_FREQUENCY_2 : j | IjkMediaMeta.AV_CH_SURROUND_DIRECT_RIGHT;
                }
                if ((j & 54559235) != 0) {
                    j2 = z80 ? j2 | 128 : j2 | 64;
                }
                if ((j & 54690307) != 0) {
                    j2 = z80 ? j2 | Long.MIN_VALUE : j2 | Longs.MAX_POWER_OF_TWO;
                }
            } else {
                z80 = false;
                observableBoolean32 = null;
            }
            if ((j & 54528388) != 0) {
                observableBoolean33 = rightControllerModel != null ? rightControllerModel.isExecuting : null;
                updateRegistration(2, observableBoolean33);
                z81 = observableBoolean33 != null ? observableBoolean33.get() : false;
                if ((j & 54525956) != 0) {
                    j2 |= z81 ? 562949953421312L : 281474976710656L;
                }
                z82 = !z81;
                if ((j & 50333828) != 0) {
                    j2 = z82 ? j2 | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : j2 | PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                }
                if ((j & 54526212) != 0) {
                    j3 = z82 ? j3 | 32 : j3 | 16;
                }
            } else {
                z81 = false;
                z82 = false;
                observableBoolean33 = null;
            }
            if ((j & 50331648) == 0 || rightControllerModel == null) {
                scaleClickListener14 = null;
                scaleClickListener15 = null;
                scaleClickListener16 = null;
                scaleClickListener4 = null;
                onClickListenerImpl4 = null;
                scaleClickListener17 = null;
                scaleClickListener18 = null;
                onClickListenerImpl12 = null;
                onClickListenerImpl22 = null;
                scaleClickListener19 = null;
                scaleClickListener20 = null;
                scaleClickListener21 = null;
                onClickListenerImpl33 = null;
                scaleClickListener22 = null;
            } else {
                scaleClickListener4 = rightControllerModel.onCaptureClickListener;
                OnClickListenerImpl onClickListenerImpl5 = this.mModelOnBlankClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl5 == null) {
                    onClickListenerImpl5 = new OnClickListenerImpl();
                    this.mModelOnBlankClickAndroidViewViewOnClickListener = onClickListenerImpl5;
                }
                onClickListenerImpl4 = onClickListenerImpl5.setValue(rightControllerModel);
                ScaleClickListener scaleClickListener25 = rightControllerModel.onGalleryClickListener;
                scaleClickListener15 = rightControllerModel.typeCircleClickListener;
                scaleClickListener16 = rightControllerModel.onSwitchModeClickListener;
                scaleClickListener17 = scaleClickListener25;
                scaleClickListener18 = rightControllerModel.onShortVideoClickListener;
                OnClickListenerImpl1 onClickListenerImpl13 = this.mModelOnCountDownViewClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl13 == null) {
                    onClickListenerImpl13 = new OnClickListenerImpl1();
                    this.mModelOnCountDownViewClickAndroidViewViewOnClickListener = onClickListenerImpl13;
                }
                onClickListenerImpl12 = onClickListenerImpl13.setValue(rightControllerModel);
                OnClickListenerImpl2 onClickListenerImpl23 = this.mModelOnDemoVideoClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl23 == null) {
                    onClickListenerImpl23 = new OnClickListenerImpl2();
                    this.mModelOnDemoVideoClickAndroidViewViewOnClickListener = onClickListenerImpl23;
                }
                onClickListenerImpl22 = onClickListenerImpl23.setValue(rightControllerModel);
                scaleClickListener19 = rightControllerModel.typeCometClickListener;
                scaleClickListener20 = rightControllerModel.typeSkywardClickListener;
                scaleClickListener21 = rightControllerModel.onCameraSettingClickListener;
                OnClickListenerImpl3 onClickListenerImpl34 = this.mModelOnParams1ClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl34 == null) {
                    onClickListenerImpl34 = new OnClickListenerImpl3();
                    this.mModelOnParams1ClickAndroidViewViewOnClickListener = onClickListenerImpl34;
                }
                onClickListenerImpl33 = onClickListenerImpl34.setValue(rightControllerModel);
                scaleClickListener22 = rightControllerModel.typeScrewClickListener;
                scaleClickListener14 = rightControllerModel.typeRecessClickListener;
            }
            long j40 = j & 50331664;
            ScaleClickListener scaleClickListener26 = scaleClickListener14;
            if (j40 != 0) {
                if (rightControllerModel != null) {
                    observableBoolean40 = rightControllerModel.isDemoVideoVisible;
                    scaleClickListener23 = scaleClickListener15;
                } else {
                    scaleClickListener23 = scaleClickListener15;
                    observableBoolean40 = null;
                }
                updateRegistration(4, observableBoolean40);
                z83 = observableBoolean40 != null ? observableBoolean40.get() : false;
                if (j40 != 0) {
                    if (z83) {
                        j2 |= 140737488355328L;
                        j39 = 131072;
                    } else {
                        j2 |= 70368744177664L;
                        j39 = 65536;
                    }
                    j3 |= j39;
                }
                if (!z83) {
                    i49 = 8;
                    if ((j & 50331680) == 0) {
                        z7 = z83;
                        if (rightControllerModel != null) {
                            ObservableBoolean observableBoolean41 = rightControllerModel.isCountStart;
                            i50 = i49;
                            onCountDownListener2 = rightControllerModel.countDownListener;
                            observableBoolean34 = observableBoolean41;
                        } else {
                            i50 = i49;
                            observableBoolean34 = null;
                            onCountDownListener2 = null;
                        }
                        updateRegistration(5, observableBoolean34);
                        if (observableBoolean34 != null) {
                            z84 = observableBoolean34.get();
                            if ((j & 50399296) != 0) {
                                observableBoolean3 = observableBoolean34;
                                if (rightControllerModel != null) {
                                    ObservableBoolean observableBoolean42 = rightControllerModel.isTrackFunctionOpen;
                                    scaleClickListener24 = scaleClickListener16;
                                    boolean z99 = z84;
                                    observableInt8 = rightControllerModel.btnGalleryMode;
                                    observableBoolean39 = observableBoolean42;
                                    z10 = z99;
                                } else {
                                    z10 = z84;
                                    scaleClickListener24 = scaleClickListener16;
                                    observableBoolean39 = null;
                                    observableInt8 = null;
                                }
                                updateRegistration(6, observableBoolean39);
                                updateRegistration(11, observableInt8);
                                boolean z100 = observableBoolean39 != null ? observableBoolean39.get() : false;
                                int i59 = observableInt8 != null ? observableInt8.get() : 0;
                                z85 = !z100;
                                ObservableInt observableInt9 = observableInt8;
                                boolean z101 = i59 == GalleryUIType.UI_TYPE_FOLLOW_DISABLE.ordinal();
                                long j41 = j & 50331712;
                                if (j41 != 0) {
                                    j2 |= z85 ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE : PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                                }
                                if (j41 != 0) {
                                    int i60 = i59;
                                    z86 = z101;
                                    observableInt5 = observableInt9;
                                    long j42 = j2;
                                    i51 = i60;
                                    i52 = z85 ? 0 : 8;
                                    j4 = j42;
                                } else {
                                    int i61 = i59;
                                    z86 = z101;
                                    observableInt5 = observableInt9;
                                    j4 = j2;
                                    i52 = 0;
                                    i51 = i61;
                                }
                            } else {
                                observableBoolean3 = observableBoolean34;
                                z10 = z84;
                                scaleClickListener24 = scaleClickListener16;
                                j4 = j2;
                                observableInt5 = null;
                                z85 = false;
                                z86 = false;
                                i51 = 0;
                                i52 = 0;
                            }
                            if ((j & 50856064) != 0) {
                                z87 = z85;
                                if (rightControllerModel != null) {
                                    ObservableInt observableInt10 = rightControllerModel.btnCaptureMode;
                                    z11 = z86;
                                    ObservableInt observableInt11 = observableInt5;
                                    observableInt7 = rightControllerModel.progressPercent;
                                    observableInt6 = observableInt10;
                                    observableInt2 = observableInt11;
                                } else {
                                    observableInt2 = observableInt5;
                                    z11 = z86;
                                    observableInt6 = null;
                                    observableInt7 = null;
                                }
                                updateRegistration(7, observableInt6);
                                updateRegistration(19, observableInt7);
                                int i62 = observableInt6 != null ? observableInt6.get() : 0;
                                int i63 = observableInt7 != null ? observableInt7.get() : 0;
                                long j43 = j & 50331776;
                                if (j43 != 0) {
                                    ObservableInt observableInt12 = observableInt6;
                                    boolean z102 = i62 == CaptureUIType.CAPTURE_UI_PHOTO.ordinal();
                                    if (j43 != 0) {
                                        j3 |= z102 ? 8388608L : 4194304L;
                                    }
                                    j5 = j3;
                                    i54 = i62;
                                    i53 = i63;
                                    z88 = z102;
                                    observableInt6 = observableInt12;
                                } else {
                                    j5 = j3;
                                    i54 = i62;
                                    i53 = i63;
                                    z88 = false;
                                }
                            } else {
                                z87 = z85;
                                observableInt2 = observableInt5;
                                z11 = z86;
                                j5 = j3;
                                observableInt6 = null;
                                z88 = false;
                                i53 = 0;
                                i54 = 0;
                            }
                            j34 = j & 50497025;
                            ObservableInt observableInt13 = observableInt6;
                            if (j34 != 0) {
                                if (rightControllerModel != null) {
                                    observableBoolean38 = rightControllerModel.isCameraHighTemp;
                                    z12 = z88;
                                } else {
                                    z12 = z88;
                                    observableBoolean38 = null;
                                }
                                updateRegistration(10, observableBoolean38);
                                z89 = !(observableBoolean38 != null ? observableBoolean38.get() : false);
                                if (j34 != 0) {
                                    j4 = z89 ? j4 | 33554432 : j4 | 16777216;
                                }
                            } else {
                                z12 = z88;
                                z89 = false;
                            }
                            if ((j & 50339840) != 0) {
                                observableString2 = rightControllerModel != null ? rightControllerModel.recordTxt : null;
                                updateRegistration(13, observableString2);
                            } else {
                                observableString2 = null;
                            }
                            j35 = j & 50352128;
                            z13 = z89;
                            if (j35 != 0) {
                                if (rightControllerModel != null) {
                                    observableBoolean35 = rightControllerModel.isAtomLT;
                                    observableString3 = observableString2;
                                } else {
                                    observableString3 = observableString2;
                                    observableBoolean35 = null;
                                }
                                updateRegistration(14, observableBoolean35);
                                z90 = observableBoolean35 != null ? observableBoolean35.get() : false;
                                if (j35 != 0) {
                                    j |= z90 ? 134217728L : 67108864L;
                                }
                            } else {
                                observableString3 = observableString2;
                                observableBoolean35 = null;
                                z90 = false;
                            }
                            if ((j & 58787904) != 0) {
                                if (rightControllerModel != null) {
                                    observableField = rightControllerModel.videoType;
                                    observableBoolean4 = observableBoolean35;
                                } else {
                                    observableBoolean4 = observableBoolean35;
                                    observableField = null;
                                }
                                updateRegistration(16, observableField);
                                visionExecuteType3 = observableField != null ? observableField.get() : null;
                                long j44 = j & 58785792;
                                z14 = z90;
                                if (j44 != 0) {
                                    z98 = visionExecuteType3 == VisionExecuteType.TYPE_RECESS;
                                    if (j44 != 0) {
                                        j |= z98 ? 2199023255552L : 1099511627776L;
                                    }
                                    if ((j & 50397184) != 0) {
                                        j5 |= z98 ? 512L : 256L;
                                    }
                                } else {
                                    z98 = false;
                                }
                                long j45 = j & 50397184;
                                z95 = z98;
                                if (j45 != 0) {
                                    i55 = i53;
                                    z91 = visionExecuteType3 == VisionExecuteType.TYPE_SCREW;
                                    i7 = i51;
                                    z92 = visionExecuteType3 == VisionExecuteType.TYPE_SKYWARD;
                                    i56 = i52;
                                    z93 = visionExecuteType3 == VisionExecuteType.TYPE_COMET;
                                    z94 = visionExecuteType3 == VisionExecuteType.TYPE_CIRCLE;
                                    if (j45 != 0) {
                                        j |= z91 ? IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT : IjkMediaMeta.AV_CH_WIDE_RIGHT;
                                    }
                                    long j46 = j & 50397184;
                                    if (j46 != 0) {
                                        j4 = z92 ? j4 | 36028797018963968L : j4 | 18014398509481984L;
                                    }
                                    if (j46 != 0) {
                                        j = z93 ? j | 36028797018963968L : j | 18014398509481984L;
                                    }
                                    if ((j & 50397184) != 0) {
                                        j |= z94 ? 140737488355328L : 70368744177664L;
                                    }
                                } else {
                                    i55 = i53;
                                    i7 = i51;
                                    i56 = i52;
                                    z91 = false;
                                    z92 = false;
                                    z93 = false;
                                    z94 = false;
                                }
                            } else {
                                observableBoolean4 = observableBoolean35;
                                z14 = z90;
                                i55 = i53;
                                i7 = i51;
                                i56 = i52;
                                visionExecuteType3 = null;
                                z91 = false;
                                z92 = false;
                                z93 = false;
                                z94 = false;
                                z95 = false;
                            }
                            j36 = j & 50593792;
                            VisionExecuteType visionExecuteType4 = visionExecuteType3;
                            if (j36 != 0) {
                                if (rightControllerModel != null) {
                                    observableBoolean37 = rightControllerModel.isVideoTypeVisible;
                                    z16 = z91;
                                } else {
                                    z16 = z91;
                                    observableBoolean37 = null;
                                }
                                updateRegistration(18, observableBoolean37);
                                z96 = observableBoolean37 != null ? observableBoolean37.get() : false;
                                if (j36 != 0) {
                                    if (z96) {
                                        j4 = j4 | 8 | IjkMediaMeta.AV_CH_WIDE_LEFT;
                                        j38 = 8192;
                                    } else {
                                        j4 = j4 | 4 | IjkMediaMeta.AV_CH_STEREO_RIGHT;
                                        j38 = 4096;
                                    }
                                    j5 |= j38;
                                }
                                if (!z96) {
                                    i57 = 8;
                                    j37 = j & 55738919;
                                    z17 = z96;
                                    if (j37 == 0) {
                                        if (rightControllerModel != null) {
                                            observableBoolean36 = rightControllerModel.isPressRemoterKey;
                                            i58 = i57;
                                        } else {
                                            i58 = i57;
                                            observableBoolean36 = null;
                                        }
                                        updateRegistration(20, observableBoolean36);
                                        z97 = !(observableBoolean36 != null ? observableBoolean36.get() : false);
                                        if (j37 != 0) {
                                            j = z97 ? j | Long.MIN_VALUE : j | Longs.MAX_POWER_OF_TWO;
                                        }
                                    } else {
                                        i58 = i57;
                                        z97 = false;
                                    }
                                    if ((j & 52449288) == 0) {
                                        ObservableBoolean observableBoolean43 = rightControllerModel != null ? rightControllerModel.isAtomPanTilt : null;
                                        updateRegistration(21, observableBoolean43);
                                        boolean z103 = observableBoolean43 != null ? observableBoolean43.get() : false;
                                        if ((j & 52449280) != 0) {
                                            j4 |= z103 ? 131072L : 65536L;
                                        }
                                        long j47 = j & 52428800;
                                        if (j47 != 0) {
                                            j5 |= z103 ? 8L : 4L;
                                        }
                                        if ((j & 52428808) != 0) {
                                            j5 = z103 ? j5 | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : j5 | PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                                        }
                                        if (j47 != 0) {
                                            scaleClickListener9 = scaleClickListener20;
                                            scaleClickListener10 = scaleClickListener22;
                                            onCountDownListener = onCountDownListener2;
                                            z6 = z87;
                                            i4 = z103 ? 0 : 8;
                                            observableBoolean2 = observableBoolean33;
                                            scaleClickListener2 = scaleClickListener18;
                                            onClickListenerImpl1 = onClickListenerImpl12;
                                            i = i50;
                                            i5 = i58;
                                        } else {
                                            scaleClickListener9 = scaleClickListener20;
                                            scaleClickListener10 = scaleClickListener22;
                                            onCountDownListener = onCountDownListener2;
                                            i = i50;
                                            z6 = z87;
                                            i5 = i58;
                                            i4 = 0;
                                            observableBoolean2 = observableBoolean33;
                                            scaleClickListener2 = scaleClickListener18;
                                            onClickListenerImpl1 = onClickListenerImpl12;
                                        }
                                        z4 = z92;
                                        i2 = i54;
                                        onClickListenerImpl = onClickListenerImpl4;
                                        scaleClickListener5 = scaleClickListener24;
                                        i6 = i55;
                                        z = z103;
                                        scaleClickListener = scaleClickListener21;
                                        z15 = z95;
                                        z5 = z81;
                                        scaleClickListener3 = scaleClickListener17;
                                        scaleClickListener8 = scaleClickListener23;
                                        z3 = z94;
                                    } else {
                                        scaleClickListener9 = scaleClickListener20;
                                        scaleClickListener = scaleClickListener21;
                                        scaleClickListener10 = scaleClickListener22;
                                        onCountDownListener = onCountDownListener2;
                                        i = i50;
                                        z6 = z87;
                                        i5 = i58;
                                        i4 = 0;
                                        observableBoolean2 = observableBoolean33;
                                        z5 = z81;
                                        scaleClickListener3 = scaleClickListener17;
                                        scaleClickListener2 = scaleClickListener18;
                                        onClickListenerImpl1 = onClickListenerImpl12;
                                        z4 = z92;
                                        z3 = z94;
                                        i2 = i54;
                                        onClickListenerImpl = onClickListenerImpl4;
                                        scaleClickListener5 = scaleClickListener24;
                                        i6 = i55;
                                        z = false;
                                        z15 = z95;
                                        scaleClickListener8 = scaleClickListener23;
                                    }
                                    z9 = z82;
                                    z2 = z93;
                                    j6 = j;
                                    visionExecuteType = visionExecuteType4;
                                    z18 = z97;
                                    onClickListenerImpl2 = onClickListenerImpl22;
                                    observableString = observableString3;
                                    scaleClickListener7 = scaleClickListener19;
                                    observableBoolean = observableBoolean32;
                                    onClickListenerImpl3 = onClickListenerImpl33;
                                    i3 = i56;
                                    z8 = z80;
                                    observableInt = observableInt13;
                                    scaleClickListener6 = scaleClickListener26;
                                }
                            } else {
                                z16 = z91;
                                z96 = false;
                            }
                            i57 = 0;
                            j37 = j & 55738919;
                            z17 = z96;
                            if (j37 == 0) {
                            }
                            if ((j & 52449288) == 0) {
                            }
                            z9 = z82;
                            z2 = z93;
                            j6 = j;
                            visionExecuteType = visionExecuteType4;
                            z18 = z97;
                            onClickListenerImpl2 = onClickListenerImpl22;
                            observableString = observableString3;
                            scaleClickListener7 = scaleClickListener19;
                            observableBoolean = observableBoolean32;
                            onClickListenerImpl3 = onClickListenerImpl33;
                            i3 = i56;
                            z8 = z80;
                            observableInt = observableInt13;
                            scaleClickListener6 = scaleClickListener26;
                        }
                    } else {
                        z7 = z83;
                        i50 = i49;
                        observableBoolean34 = null;
                        onCountDownListener2 = null;
                    }
                    z84 = false;
                    if ((j & 50399296) != 0) {
                    }
                    if ((j & 50856064) != 0) {
                    }
                    j34 = j & 50497025;
                    ObservableInt observableInt132 = observableInt6;
                    if (j34 != 0) {
                    }
                    if ((j & 50339840) != 0) {
                    }
                    j35 = j & 50352128;
                    z13 = z89;
                    if (j35 != 0) {
                    }
                    if ((j & 58787904) != 0) {
                    }
                    j36 = j & 50593792;
                    VisionExecuteType visionExecuteType42 = visionExecuteType3;
                    if (j36 != 0) {
                    }
                    i57 = 0;
                    j37 = j & 55738919;
                    z17 = z96;
                    if (j37 == 0) {
                    }
                    if ((j & 52449288) == 0) {
                    }
                    z9 = z82;
                    z2 = z93;
                    j6 = j;
                    visionExecuteType = visionExecuteType42;
                    z18 = z97;
                    onClickListenerImpl2 = onClickListenerImpl22;
                    observableString = observableString3;
                    scaleClickListener7 = scaleClickListener19;
                    observableBoolean = observableBoolean32;
                    onClickListenerImpl3 = onClickListenerImpl33;
                    i3 = i56;
                    z8 = z80;
                    observableInt = observableInt132;
                    scaleClickListener6 = scaleClickListener26;
                }
            } else {
                scaleClickListener23 = scaleClickListener15;
                z83 = false;
            }
            i49 = 0;
            if ((j & 50331680) == 0) {
            }
            z84 = false;
            if ((j & 50399296) != 0) {
            }
            if ((j & 50856064) != 0) {
            }
            j34 = j & 50497025;
            ObservableInt observableInt1322 = observableInt6;
            if (j34 != 0) {
            }
            if ((j & 50339840) != 0) {
            }
            j35 = j & 50352128;
            z13 = z89;
            if (j35 != 0) {
            }
            if ((j & 58787904) != 0) {
            }
            j36 = j & 50593792;
            VisionExecuteType visionExecuteType422 = visionExecuteType3;
            if (j36 != 0) {
            }
            i57 = 0;
            j37 = j & 55738919;
            z17 = z96;
            if (j37 == 0) {
            }
            if ((j & 52449288) == 0) {
            }
            z9 = z82;
            z2 = z93;
            j6 = j;
            visionExecuteType = visionExecuteType422;
            z18 = z97;
            onClickListenerImpl2 = onClickListenerImpl22;
            observableString = observableString3;
            scaleClickListener7 = scaleClickListener19;
            observableBoolean = observableBoolean32;
            onClickListenerImpl3 = onClickListenerImpl33;
            i3 = i56;
            z8 = z80;
            observableInt = observableInt1322;
            scaleClickListener6 = scaleClickListener26;
        } else {
            j4 = j2;
            j5 = j3;
            onClickListenerImpl2 = null;
            scaleClickListener = null;
            onClickListenerImpl = null;
            onClickListenerImpl3 = null;
            scaleClickListener2 = null;
            scaleClickListener3 = null;
            scaleClickListener4 = null;
            scaleClickListener5 = null;
            observableInt = null;
            observableString = null;
            observableBoolean = null;
            observableBoolean2 = null;
            observableBoolean3 = null;
            onClickListenerImpl1 = null;
            observableInt2 = null;
            scaleClickListener6 = null;
            scaleClickListener7 = null;
            observableBoolean4 = null;
            scaleClickListener8 = null;
            scaleClickListener9 = null;
            scaleClickListener10 = null;
            onCountDownListener = null;
            z = false;
            i = 0;
            z2 = false;
            z3 = false;
            z4 = false;
            i2 = 0;
            z5 = false;
            i3 = 0;
            z6 = false;
            z7 = false;
            z8 = false;
            z9 = false;
            i4 = 0;
            i5 = 0;
            z10 = false;
            i6 = 0;
            z11 = false;
            z12 = false;
            z13 = false;
            z14 = false;
            z15 = false;
            i7 = 0;
            z16 = false;
            z17 = false;
            j6 = j;
            visionExecuteType = null;
            z18 = false;
        }
        if ((j6 & Long.MIN_VALUE) == 0 && (j4 & 33554432) == 0) {
            onClickListenerImpl32 = onClickListenerImpl3;
            scaleClickListener11 = scaleClickListener5;
            i8 = 0;
            j7 = 0;
        } else {
            scaleClickListener11 = scaleClickListener5;
            if (rightControllerModel != null) {
                observableBoolean5 = rightControllerModel.isCameraConnected;
                onClickListenerImpl32 = onClickListenerImpl3;
            } else {
                onClickListenerImpl32 = onClickListenerImpl3;
                observableBoolean5 = observableBoolean;
            }
            i8 = 0;
            updateRegistration(0, observableBoolean5);
            if (observableBoolean5 != null) {
                z8 = observableBoolean5.get();
            }
            j7 = 0;
            if ((j6 & 54559271) != 0) {
                j6 = z8 ? j6 | IjkMediaMeta.AV_CH_LOW_FREQUENCY_2 : j6 | IjkMediaMeta.AV_CH_SURROUND_DIRECT_RIGHT;
            }
            if ((j6 & 54559235) != 0) {
                j4 = z8 ? j4 | 128 : j4 | 64;
            }
            if ((j6 & 54690307) != 0) {
                j4 = z8 ? j4 | Long.MIN_VALUE : j4 | Longs.MAX_POWER_OF_TWO;
            }
        }
        int i64 = (j6 & 18014398509481984L) != j7 ? R.mipmap.img_btn_comet_unselect : i8;
        int i65 = (j6 & 36028797018963968L) != j7 ? R.mipmap.img_btn_comet_select : i8;
        long j48 = j5 & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        if (j48 != j7) {
            if (rightControllerModel != null) {
                observableBoolean31 = rightControllerModel.isManualMode;
                i9 = i64;
            } else {
                i9 = i64;
                observableBoolean31 = null;
            }
            updateRegistration(3, observableBoolean31);
            z19 = observableBoolean31 != null ? observableBoolean31.get() : false;
            if (j48 != j7) {
                j4 |= z19 ? IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT : IjkMediaMeta.AV_CH_WIDE_RIGHT;
            }
        } else {
            i9 = i64;
            z19 = false;
        }
        int i66 = (j4 & 8) != 0 ? R.color.colorShortVideoBg : 0;
        int i67 = (j5 & 65536) != 0 ? R.mipmap.img_btn_demo_video_show : 0;
        int i68 = (j6 & 140737488355328L) != 0 ? R.mipmap.img_btn_circle_select : 0;
        if ((j5 & 4194304) != 0) {
            i10 = i66;
            if (rightControllerModel != null) {
                observableInt4 = rightControllerModel.btnCaptureMode;
                scaleClickListener12 = scaleClickListener2;
            } else {
                scaleClickListener12 = scaleClickListener2;
                observableInt4 = observableInt;
            }
            updateRegistration(7, observableInt4);
            if (observableInt4 != null) {
                i2 = observableInt4.get();
            }
            int i69 = i2;
            ObservableInt observableInt14 = observableInt4;
            z20 = i69 == CaptureUIType.CAPTURE_UI_TAKING_PHOTO.ordinal();
            i2 = i69;
            observableInt = observableInt14;
        } else {
            scaleClickListener12 = scaleClickListener2;
            i10 = i66;
            z20 = false;
        }
        int i70 = (j6 & IjkMediaMeta.AV_CH_WIDE_RIGHT) != 0 ? R.mipmap.img_btn_screw_unselect : 0;
        int i71 = (j6 & IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) != 0 ? R.mipmap.img_btn_screw_select : 0;
        if ((j6 & 1099511627776L) != 0) {
            i11 = i70;
            z21 = visionExecuteType == VisionExecuteType.TYPE_SKYWARD;
            if ((j6 & 50397184) != 0) {
                j4 = z21 ? j4 | 36028797018963968L : j4 | 18014398509481984L;
            }
        } else {
            i11 = i70;
            z21 = z4;
        }
        int i72 = (j5 & 131072) != 0 ? R.mipmap.img_btn_demo_video_hide : 0;
        int i73 = (j5 & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) != 0 ? R.mipmap.icon_camera_set : 0;
        if ((j4 & 65536) != 0) {
            z22 = z20;
            ObservableBoolean observableBoolean44 = rightControllerModel != null ? rightControllerModel.isAtomLT : observableBoolean4;
            visionExecuteType2 = visionExecuteType;
            updateRegistration(14, observableBoolean44);
            if (observableBoolean44 != null) {
                z14 = observableBoolean44.get();
            }
            if ((j6 & 50352128) != 0) {
                j6 |= z14 ? 134217728L : 67108864L;
            }
        } else {
            visionExecuteType2 = visionExecuteType;
            z22 = z20;
        }
        int i74 = (j5 & 512) != 0 ? R.mipmap.img_btn_recess_select : 0;
        int i75 = (j5 & 256) != 0 ? R.mipmap.img_btn_recess_unselect : 0;
        int i76 = (j6 & 70368744177664L) != 0 ? R.mipmap.img_btn_circle_unselect : 0;
        if ((j4 & IjkMediaMeta.AV_CH_WIDE_LEFT) != 0) {
            z23 = !(rightControllerModel != null ? rightControllerModel.isFollowMode() : false);
        } else {
            z23 = false;
        }
        if ((j6 & 50397184) != 0) {
            if (!z16) {
                i71 = i11;
            }
            if (!z3) {
                i68 = i76;
            }
            if (z2) {
                i9 = i65;
            }
            if (!z15) {
                i74 = i75;
            }
            i14 = i74;
            i13 = i9;
            i12 = i68;
            i15 = i71;
        } else {
            i12 = 0;
            i13 = 0;
            i14 = 0;
            i15 = 0;
        }
        long j49 = j6 & 58785792;
        if (j49 != 0) {
            z24 = z15 ? true : z21;
            if (j49 != 0) {
                j6 = z24 ? j6 | 137438953472L : j6 | 68719476736L;
            }
        } else {
            z24 = false;
        }
        long j50 = j6 & 55738919;
        if (j50 != 0) {
            z25 = z18 ? z8 : false;
            if (j50 != 0) {
                j4 |= z25 ? 9007199254740992L : IEEEDouble.FRAC_ASSUMED_HIGH_BIT;
            }
        } else {
            z25 = false;
        }
        long j51 = j6 & 50593792;
        if (j51 != 0) {
            if (!z17) {
                i10 = -1;
            }
            if (!z17) {
                z23 = false;
            }
            if (j51 != 0) {
                j5 |= z23 ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE : PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            i16 = i12;
            i18 = i10;
            i17 = i13;
            i19 = z23 ? 0 : 8;
        } else {
            i16 = i12;
            i17 = i13;
            i18 = 0;
            i19 = 0;
        }
        long j52 = j6 & 52449280;
        if (j52 != 0) {
            z26 = z ? true : z14;
            if (j52 != 0) {
                j4 |= z26 ? 8796093022208L : 4398046511104L;
            }
        } else {
            z26 = false;
        }
        long j53 = j6 & 50497025;
        if (j53 != 0) {
            z27 = z13 ? z8 : false;
            if (j53 != 0) {
                j6 |= z27 ? 2251799813685248L : 1125899906842624L;
            }
        } else {
            z27 = false;
        }
        if ((j6 & 50331664) != 0) {
            if (z7) {
                i67 = i72;
            }
            i20 = i19;
            i21 = i67;
        } else {
            i20 = i19;
            i21 = 0;
        }
        long j54 = j6 & 50331776;
        if (j54 != 0) {
            if (z12) {
                z22 = true;
            }
            if (j54 != 0) {
                j6 |= z22 ? LockFreeTaskQueueCore.CLOSED_MASK : LockFreeTaskQueueCore.FROZEN_MASK;
            }
            j8 = IjkMediaMeta.AV_CH_LOW_FREQUENCY_2;
        } else {
            j8 = IjkMediaMeta.AV_CH_LOW_FREQUENCY_2;
            z22 = false;
        }
        if ((j6 & j8) == 0 && (j4 & 9007199254740992L) == 0) {
            i22 = i18;
            scaleClickListener13 = scaleClickListener3;
            j9 = 0;
        } else {
            i22 = i18;
            ObservableBoolean observableBoolean45 = rightControllerModel != null ? rightControllerModel.isExecuting : observableBoolean2;
            scaleClickListener13 = scaleClickListener3;
            updateRegistration(2, observableBoolean45);
            if (observableBoolean45 != null) {
                z5 = observableBoolean45.get();
            }
            if ((j6 & 54525956) != 0) {
                j4 |= z5 ? 562949953421312L : 281474976710656L;
            }
            z9 = !z5;
            j9 = 0;
            if ((j6 & 50333828) != 0) {
                j4 = z9 ? j4 | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : j4 | PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            if ((j6 & 54526212) != 0) {
                j5 = z9 ? j5 | 32 : j5 | 16;
            }
        }
        int i77 = (j4 & 36028797018963968L) != j9 ? R.mipmap.img_btn_skyward_select : 0;
        if ((j6 & 67108864) == j9 && (j4 & 4398046511104L) == j9) {
            i23 = i77;
        } else {
            if (rightControllerModel != null) {
                observableBoolean6 = rightControllerModel.isAtomSE;
                i23 = i77;
            } else {
                i23 = i77;
                observableBoolean6 = null;
            }
            updateRegistration(12, observableBoolean6);
            if (observableBoolean6 != null) {
                z28 = observableBoolean6.get();
                int i78 = (j4 & 18014398509481984L) == 0 ? R.mipmap.img_btn_skyward_unselect : 0;
                if ((j6 & 2251799813685248L) == 0 || (j4 & Long.MIN_VALUE) != 0) {
                    z29 = z28;
                    if (rightControllerModel == null) {
                        observableBoolean7 = rightControllerModel.isCameraSettingControllerShow;
                        i24 = i78;
                    } else {
                        i24 = i78;
                        observableBoolean7 = null;
                    }
                    updateRegistration(17, observableBoolean7);
                    z30 = observableBoolean7 == null ? observableBoolean7.get() : false;
                    z31 = !z30;
                } else {
                    z29 = z28;
                    i24 = i78;
                    observableBoolean7 = null;
                    z30 = false;
                    z31 = false;
                }
                int i79 = (j6 & LockFreeTaskQueueCore.FROZEN_MASK) == 0 ? R.mipmap.img_btn_switch_capture_video : 0;
                int i80 = (j4 & IjkMediaMeta.AV_CH_WIDE_RIGHT) == 0 ? R.mipmap.icon_auto_mode : 0;
                if ((j4 & IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) == 0) {
                    i25 = R.mipmap.icon_manual_mode;
                    j10 = 128;
                } else {
                    j10 = 128;
                    i25 = 0;
                }
                if ((j4 & j10) == 0) {
                    observableBoolean8 = observableBoolean7;
                    if (rightControllerModel != null) {
                        observableBoolean9 = rightControllerModel.isRecording;
                        z32 = z30;
                    } else {
                        z32 = z30;
                        observableBoolean9 = null;
                    }
                    updateRegistration(22, observableBoolean9);
                    z33 = observableBoolean9 != null ? observableBoolean9.get() : false;
                    z34 = !z33;
                } else {
                    observableBoolean8 = observableBoolean7;
                    z32 = z30;
                    observableBoolean9 = null;
                    z33 = false;
                    z34 = false;
                }
                if ((j6 & 206158430208L) == 0) {
                    observableBoolean10 = observableBoolean9;
                    if (rightControllerModel != null) {
                        observableBoolean30 = rightControllerModel.isParams1Select;
                        z35 = z33;
                    } else {
                        z35 = z33;
                        observableBoolean30 = null;
                    }
                    updateRegistration(23, observableBoolean30);
                    z36 = observableBoolean30 != null ? observableBoolean30.get() : false;
                    if ((j6 & 137438953472L) != 0) {
                        j6 |= z36 ? 35184372088832L : 17592186044416L;
                    }
                    if ((j6 & 68719476736L) != 0) {
                        j4 |= z36 ? 549755813888L : 274877906944L;
                    }
                } else {
                    observableBoolean10 = observableBoolean9;
                    z35 = z33;
                    z36 = false;
                }
                int i81 = (j6 & LockFreeTaskQueueCore.CLOSED_MASK) == 0 ? R.mipmap.img_btn_switch_capture_photo : 0;
                j11 = j6 & 50352128;
                if (j11 == 0) {
                    boolean z104 = z14 ? true : z29;
                    if (j11 != 0) {
                        if (z104) {
                            j6 |= 549755813888L;
                            j33 = 8192;
                        } else {
                            j6 |= 274877906944L;
                            j33 = 4096;
                        }
                        j4 |= j33;
                    }
                    i28 = z104 ? 0 : 8;
                    int i82 = z104 ? 8 : 0;
                    i26 = i81;
                    i27 = i82;
                } else {
                    i26 = i81;
                    i27 = 0;
                    i28 = 0;
                }
                j12 = j6 & 54559271;
                if (j12 == 0) {
                    z37 = z8 ? z9 : false;
                    if (j12 != 0) {
                        j4 |= z37 ? 35184372088832L : 17592186044416L;
                    }
                } else {
                    z37 = false;
                }
                j13 = j6 & 50497025;
                if (j13 == 0) {
                    z38 = z27 ? z31 : false;
                    if (j13 != 0) {
                        j6 |= z38 ? 9007199254740992L : IEEEDouble.FRAC_ASSUMED_HIGH_BIT;
                    }
                } else {
                    z38 = false;
                }
                if ((j6 & 50331776) == 0) {
                    if (z22) {
                        i79 = i26;
                    }
                    i29 = i79;
                } else {
                    i29 = 0;
                }
                j14 = j6 & 54559235;
                if (j14 == 0) {
                    z39 = z8 ? z34 : false;
                    if (j14 != 0) {
                        j6 |= z39 ? 562949953421312L : 281474976710656L;
                    }
                } else {
                    z39 = false;
                }
                if ((j5 & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != 0) {
                    i80 = 0;
                } else if (z19) {
                    i80 = i25;
                }
                j15 = j6 & 52449280;
                if (j15 == 0) {
                    if (z26) {
                        z29 = true;
                    }
                    if (j15 != 0) {
                        j4 |= z29 ? 2199023255552L : 1099511627776L;
                    }
                    f = z29 ? 0.535f : 0.62f;
                } else {
                    f = 0.0f;
                }
                j16 = j6 & 55738919;
                if (j16 == 0) {
                    z40 = z25 ? z9 : false;
                    if (j16 != 0) {
                        j4 |= z40 ? 8388608L : 4194304L;
                    }
                } else {
                    z40 = false;
                }
                if ((j6 & 50397184) == 0) {
                    if (!z21) {
                        i23 = i24;
                    }
                    i30 = i23;
                } else {
                    i30 = 0;
                }
                j17 = j6 & 54690307;
                if (j17 == 0) {
                    z41 = z8 ? z31 : false;
                    if (j17 != 0) {
                        j4 |= z41 ? 2251799813685248L : 1125899906842624L;
                    }
                } else {
                    z41 = false;
                }
                if ((j6 & 52428808) == 0) {
                    if (z) {
                        i73 = i80;
                    }
                    i31 = i73;
                } else {
                    i31 = 0;
                }
                int i83 = (j4 & 274877906944L) == 0 ? R.mipmap.icon_anticlockwise : 0;
                int i84 = (j4 & 549755813888L) == 0 ? R.mipmap.icon_clockwise : 0;
                if ((j4 & 35184380477440L) == 0) {
                    i32 = i30;
                    if (rightControllerModel != null) {
                        observableBoolean29 = rightControllerModel.isCountStart;
                        f2 = f;
                    } else {
                        f2 = f;
                        observableBoolean29 = observableBoolean3;
                    }
                    updateRegistration(5, observableBoolean29);
                    if (observableBoolean29 != null) {
                        z10 = observableBoolean29.get();
                    }
                    z43 = !z10;
                    z42 = z10;
                } else {
                    f2 = f;
                    i32 = i30;
                    z42 = z10;
                    z43 = false;
                }
                if ((j4 & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) == 0) {
                    z44 = z43;
                    if (rightControllerModel != null) {
                        observableInt3 = rightControllerModel.btnCaptureMode;
                        z45 = z42;
                    } else {
                        z45 = z42;
                        observableInt3 = observableInt;
                    }
                    updateRegistration(7, observableInt3);
                    if (observableInt3 != null) {
                        i2 = observableInt3.get();
                    }
                    i33 = i2;
                    if (i33 == CaptureUIType.CAPTURE_UI_GO.ordinal()) {
                        z46 = true;
                        int i85 = (j6 & 35184372088832L) != 0 ? R.mipmap.icon_params_auto : 0;
                        if ((j6 & 9570149208162304L) != 0) {
                            z47 = z46;
                            if (rightControllerModel != null) {
                                observableBoolean11 = rightControllerModel.isSwitchingMode;
                                i34 = i33;
                            } else {
                                i34 = i33;
                                observableBoolean11 = null;
                            }
                            updateRegistration(15, observableBoolean11);
                            z48 = observableBoolean11 != null ? observableBoolean11.get() : false;
                            z49 = !z48;
                        } else {
                            i34 = i33;
                            z47 = z46;
                            observableBoolean11 = null;
                            z48 = false;
                            z49 = false;
                        }
                        int i86 = (j6 & 17592186044416L) != 0 ? R.mipmap.icon_params_not_auto : 0;
                        if ((j4 & 2533274790395904L) == 0 || (j5 & 32) != 0) {
                            z50 = z48;
                            if (rightControllerModel != null) {
                                observableBoolean13 = rightControllerModel.isRecording;
                                observableBoolean12 = observableBoolean11;
                            } else {
                                observableBoolean12 = observableBoolean11;
                                observableBoolean13 = observableBoolean10;
                            }
                            updateRegistration(22, observableBoolean13);
                            if (observableBoolean13 != null) {
                                z35 = observableBoolean13.get();
                            }
                            j18 = 0;
                            if ((j4 & 2251799813685248L) != 0) {
                                z34 = !z35;
                            }
                        } else {
                            z50 = z48;
                            observableBoolean12 = observableBoolean11;
                            observableBoolean13 = observableBoolean10;
                            j18 = 0;
                        }
                        if ((j6 & 137438953472L) == j18) {
                            i85 = 0;
                        } else if (!z36) {
                            i85 = i86;
                        }
                        j19 = j6 & 54559235;
                        if (j19 != j18) {
                            z51 = z39 ? z49 : false;
                            if (j19 != j18) {
                                j6 |= z51 ? 144115188075855872L : 72057594037927936L;
                            }
                        } else {
                            z51 = false;
                        }
                        j20 = j6 & 50497025;
                        if (j20 != 0) {
                            z52 = z38 ? z49 : false;
                            if (j20 != 0) {
                                j5 |= z52 ? 2L : 1L;
                            }
                        } else {
                            z52 = false;
                        }
                        j21 = j6 & 50333828;
                        if (j21 != 0) {
                            if (!z9) {
                                z47 = false;
                            }
                            if (j21 != 0) {
                                j6 |= z47 ? IjkMediaMeta.AV_CH_STEREO_LEFT : 268435456L;
                            }
                            if ((j6 & 50331780) != 0) {
                                if (z47) {
                                    j6 |= 8796093022208L;
                                    j32 = 2048;
                                } else {
                                    j6 |= 4398046511104L;
                                    j32 = 1024;
                                }
                                j4 |= j32;
                            }
                            if ((j6 & 50331780) != 0) {
                                i36 = z47 ? 0 : 4;
                                observableBoolean14 = observableBoolean13;
                                i35 = z47 ? 0 : 8;
                            } else {
                                observableBoolean14 = observableBoolean13;
                                i35 = 0;
                                i36 = 0;
                            }
                        } else {
                            observableBoolean14 = observableBoolean13;
                            i35 = 0;
                            i36 = 0;
                            z47 = false;
                        }
                        j22 = j6 & 55738919;
                        if (j22 != 0) {
                            z53 = z40 ? z44 : false;
                            if (j22 != 0) {
                                j4 |= z53 ? IjkMediaMeta.AV_CH_STEREO_LEFT : 268435456L;
                            }
                        } else {
                            z53 = false;
                        }
                        if ((j6 & 68719476736L) == 0) {
                            i83 = 0;
                        } else if (z36) {
                            i83 = i84;
                        }
                        j23 = j6 & 54559271;
                        if (j23 != 0) {
                            if (!z37) {
                                z44 = false;
                            }
                            if (j23 != 0) {
                                j5 |= z44 ? 2048L : 1024L;
                            }
                        } else {
                            z44 = false;
                        }
                        j24 = j6 & 54525956;
                        if (j24 != 0) {
                            boolean z105 = z5 ? true : z35;
                            if (j24 != 0) {
                                j4 |= z105 ? 2L : 1L;
                            }
                            i37 = z105 ? 0 : 8;
                        } else {
                            i37 = 0;
                        }
                        j25 = j6 & 54690307;
                        if (j25 != 0) {
                            z54 = z41 ? z34 : false;
                            if (j25 != 0) {
                                j4 |= z54 ? 576460752303423488L : 288230376151711744L;
                            }
                        } else {
                            z54 = false;
                        }
                        j26 = j6 & 54526212;
                        if (j26 != 0) {
                            z55 = z9 ? z35 : false;
                            if (j26 != 0) {
                                j4 |= z55 ? 144115188075855872L : 72057594037927936L;
                            }
                        } else {
                            z55 = false;
                        }
                        if ((j6 & 58785792) != 0) {
                            if (!z24) {
                                i85 = i83;
                            }
                            i38 = i36;
                            i39 = i85;
                        } else {
                            i38 = i36;
                            i39 = 0;
                        }
                        if ((j4 & 144115188075855872L) != 0) {
                            i40 = i35;
                            if (rightControllerModel != null) {
                                observableBoolean28 = rightControllerModel.isRecordRedPointShow;
                                i41 = i39;
                            } else {
                                i41 = i39;
                                observableBoolean28 = null;
                            }
                            updateRegistration(8, observableBoolean28);
                            if (observableBoolean28 != null) {
                                z56 = observableBoolean28.get();
                                if ((j6 & 144115188075855872L) == 0 || (j5 & 2050) != 0) {
                                    if (rightControllerModel == null) {
                                        observableBoolean15 = rightControllerModel.isTakingPhoto;
                                        z57 = z56;
                                    } else {
                                        z57 = z56;
                                        observableBoolean15 = null;
                                    }
                                    updateRegistration(9, observableBoolean15);
                                    z58 = observableBoolean15 == null ? observableBoolean15.get() : false;
                                    z59 = !z58;
                                } else {
                                    z57 = z56;
                                    observableBoolean15 = null;
                                    z58 = false;
                                    z59 = false;
                                }
                                if ((j6 & IjkMediaMeta.AV_CH_STEREO_LEFT) == 0) {
                                    z60 = z58;
                                    ObservableInt observableInt15 = rightControllerModel != null ? rightControllerModel.btnGalleryMode : observableInt2;
                                    observableBoolean16 = observableBoolean15;
                                    updateRegistration(11, observableInt15);
                                    if (observableInt15 != null) {
                                        i7 = observableInt15.get();
                                    }
                                    i42 = i7;
                                    z61 = i42 == GalleryUIType.UI_TYPE_FOLLOW_DISABLE.ordinal();
                                } else {
                                    z60 = z58;
                                    observableBoolean16 = observableBoolean15;
                                    z61 = z11;
                                    i42 = i7;
                                }
                                if ((j4 & 576460752303423488L) == 0) {
                                    z62 = z61;
                                    if (rightControllerModel != null) {
                                        observableBoolean17 = rightControllerModel.isSwitchingMode;
                                        i43 = i42;
                                    } else {
                                        i43 = i42;
                                        observableBoolean17 = observableBoolean12;
                                    }
                                    updateRegistration(15, observableBoolean17);
                                    z63 = observableBoolean17 != null ? observableBoolean17.get() : z50;
                                    z49 = !z63;
                                } else {
                                    i43 = i42;
                                    z62 = z61;
                                    z63 = z50;
                                    observableBoolean17 = observableBoolean12;
                                }
                                if ((j4 & IjkMediaMeta.AV_CH_STEREO_LEFT) == 0) {
                                    z64 = z63;
                                    if (rightControllerModel != null) {
                                        observableBoolean27 = rightControllerModel.isCameraSettingControllerShow;
                                        observableBoolean18 = observableBoolean17;
                                    } else {
                                        observableBoolean18 = observableBoolean17;
                                        observableBoolean27 = observableBoolean8;
                                    }
                                    updateRegistration(17, observableBoolean27);
                                    z31 = !(observableBoolean27 != null ? observableBoolean27.get() : z32);
                                } else {
                                    z64 = z63;
                                    observableBoolean18 = observableBoolean17;
                                }
                                j27 = j6 & 50333828;
                                if (j27 != 0) {
                                    boolean z106 = z47 ? z62 : false;
                                    if (j27 != 0) {
                                        j5 |= z106 ? 128L : 64L;
                                    }
                                    if (!z106) {
                                        i44 = 8;
                                        j28 = j6 & 54559235;
                                        if (j28 != 0) {
                                            z65 = z51 ? z59 : false;
                                            if (j28 != 0) {
                                                j4 = z65 ? j4 | 32 : j4 | 16;
                                            }
                                        } else {
                                            z65 = false;
                                        }
                                        if (j22 != 0) {
                                            if (!z53) {
                                                z31 = false;
                                            }
                                            if (j22 != 0) {
                                                j4 |= z31 ? 512L : 256L;
                                            }
                                        } else {
                                            z31 = false;
                                        }
                                        if (j26 != 0) {
                                            if (!z55) {
                                                z57 = false;
                                            }
                                            if (j26 != 0) {
                                                j4 |= z57 ? 134217728L : 67108864L;
                                            }
                                            i45 = z57 ? 0 : 8;
                                        } else {
                                            i45 = 0;
                                        }
                                        if (j25 != 0) {
                                            z66 = z54 ? z49 : false;
                                            if (j25 != 0) {
                                                j5 |= z66 ? 32768L : 16384L;
                                            }
                                        } else {
                                            z66 = false;
                                        }
                                        if ((j6 & 50497025) != 0) {
                                            i46 = i45;
                                            z67 = z52 ? z59 : false;
                                        } else {
                                            i46 = i45;
                                            z67 = false;
                                        }
                                        if (j23 != 0) {
                                            z68 = z44 ? z59 : false;
                                            if (j23 != 0) {
                                                j4 |= z68 ? IjkMediaMeta.AV_CH_LOW_FREQUENCY_2 : IjkMediaMeta.AV_CH_SURROUND_DIRECT_RIGHT;
                                            }
                                        } else {
                                            z68 = false;
                                        }
                                        if ((j4 & 32) != 0) {
                                            i47 = i44;
                                            if (rightControllerModel != null) {
                                                observableBoolean19 = rightControllerModel.isTimePhotography;
                                                z69 = z67;
                                            } else {
                                                z69 = z67;
                                                observableBoolean19 = null;
                                            }
                                            updateRegistration(1, observableBoolean19);
                                            z70 = observableBoolean19 != null ? observableBoolean19.get() : false;
                                            z71 = !z70;
                                        } else {
                                            z69 = z67;
                                            i47 = i44;
                                            observableBoolean19 = null;
                                            z70 = false;
                                            z71 = false;
                                        }
                                        if ((j5 & 32768) != 0) {
                                            z72 = z70;
                                            if (rightControllerModel != null) {
                                                observableBoolean21 = rightControllerModel.isTakingPhoto;
                                                observableBoolean20 = observableBoolean19;
                                            } else {
                                                observableBoolean20 = observableBoolean19;
                                                observableBoolean21 = observableBoolean16;
                                            }
                                            updateRegistration(9, observableBoolean21);
                                            z73 = observableBoolean21 != null ? observableBoolean21.get() : z60;
                                            z59 = !z73;
                                        } else {
                                            z72 = z70;
                                            observableBoolean20 = observableBoolean19;
                                            observableBoolean21 = observableBoolean16;
                                            z73 = z60;
                                        }
                                        if ((j4 & 34359738880L) != 0) {
                                            observableBoolean22 = observableBoolean21;
                                            if (rightControllerModel != null) {
                                                observableBoolean26 = rightControllerModel.isRecording;
                                                z74 = z73;
                                            } else {
                                                z74 = z73;
                                                observableBoolean26 = observableBoolean14;
                                            }
                                            updateRegistration(22, observableBoolean26);
                                            if (observableBoolean26 != null) {
                                                z35 = observableBoolean26.get();
                                            }
                                            z34 = !z35;
                                        } else {
                                            observableBoolean22 = observableBoolean21;
                                            z74 = z73;
                                        }
                                        boolean z107 = (j28 == 0 && z65) ? z71 : false;
                                        if (j22 != 0) {
                                            z75 = z31 ? z34 : false;
                                            if (j22 != 0) {
                                                j5 = z75 ? j5 | 33554432 : j5 | 16777216;
                                            }
                                        } else {
                                            z75 = false;
                                        }
                                        if (j23 != 0) {
                                            if (!z68) {
                                                z34 = false;
                                            }
                                            if (j23 != 0) {
                                                j4 |= z34 ? 32768L : 16384L;
                                            }
                                        } else {
                                            z34 = false;
                                        }
                                        if (j25 != 0) {
                                            z76 = z66 ? z59 : false;
                                            if (j25 != 0) {
                                                j6 |= z76 ? IjkMediaMeta.AV_CH_WIDE_LEFT : IjkMediaMeta.AV_CH_STEREO_RIGHT;
                                            }
                                        } else {
                                            z76 = false;
                                        }
                                        if ((j6 & IjkMediaMeta.AV_CH_WIDE_LEFT) != 0) {
                                            if (rightControllerModel != null) {
                                                observableBoolean25 = rightControllerModel.isTimePhotography;
                                                i48 = i27;
                                            } else {
                                                i48 = i27;
                                                observableBoolean25 = observableBoolean20;
                                            }
                                            updateRegistration(1, observableBoolean25);
                                            if (observableBoolean25 != null) {
                                                z72 = observableBoolean25.get();
                                            }
                                            z71 = !z72;
                                            observableBoolean20 = observableBoolean25;
                                        } else {
                                            i48 = i27;
                                        }
                                        if ((j4 & 32768) == 0 || (j5 & 33554432) != 0) {
                                            observableBoolean23 = rightControllerModel != null ? rightControllerModel.isSwitchingMode : observableBoolean18;
                                            updateRegistration(15, observableBoolean23);
                                            if (observableBoolean23 != null) {
                                                z64 = observableBoolean23.get();
                                            }
                                            z49 = !z64;
                                        }
                                        boolean z108 = ((j6 & 54690307) == 0 && z76) ? z71 : false;
                                        j29 = j6 & 54559271;
                                        if (j29 != 0) {
                                            z77 = z34 ? z49 : false;
                                            if (j29 != 0) {
                                                j6 |= z77 ? 576460752303423488L : 288230376151711744L;
                                            }
                                        } else {
                                            z77 = false;
                                        }
                                        j30 = j6 & 55738919;
                                        if (j30 != 0) {
                                            if (!z75) {
                                                z49 = false;
                                            }
                                            if (j30 != 0) {
                                                j4 = z49 ? j4 | 137438953472L : j4 | 68719476736L;
                                            }
                                        } else {
                                            z49 = false;
                                        }
                                        if ((j6 & 576460752303423488L) != 0) {
                                            if (rightControllerModel != null) {
                                                observableBoolean24 = rightControllerModel.isTimePhotography;
                                                z78 = z108;
                                            } else {
                                                z78 = z108;
                                                observableBoolean24 = observableBoolean20;
                                            }
                                            updateRegistration(1, observableBoolean24);
                                            if (observableBoolean24 != null) {
                                                z72 = observableBoolean24.get();
                                            }
                                            z71 = !z72;
                                            observableBoolean20 = observableBoolean24;
                                        } else {
                                            z78 = z108;
                                        }
                                        if ((j4 & 137438953472L) != 0) {
                                            ObservableBoolean observableBoolean46 = rightControllerModel != null ? rightControllerModel.isTakingPhoto : observableBoolean22;
                                            updateRegistration(9, observableBoolean46);
                                            z59 = !(observableBoolean46 != null ? observableBoolean46.get() : z74);
                                        }
                                        j31 = j6 & 54559271;
                                        boolean z109 = (j31 == 0 && z77) ? z71 : false;
                                        if (j30 != 0) {
                                            if (!z49) {
                                                z59 = false;
                                            }
                                            if (j30 != 0) {
                                                j4 |= z59 ? LockFreeTaskQueueCore.CLOSED_MASK : LockFreeTaskQueueCore.FROZEN_MASK;
                                            }
                                        } else {
                                            z59 = false;
                                        }
                                        if ((j4 & LockFreeTaskQueueCore.CLOSED_MASK) != 0) {
                                            ObservableBoolean observableBoolean47 = rightControllerModel != null ? rightControllerModel.isTimePhotography : observableBoolean20;
                                            updateRegistration(1, observableBoolean47);
                                            if (observableBoolean47 != null) {
                                                z72 = observableBoolean47.get();
                                            }
                                            z71 = !z72;
                                        }
                                        if (j30 != 0) {
                                            if (!z59) {
                                                z71 = false;
                                            }
                                            z79 = z71;
                                        } else {
                                            z79 = false;
                                        }
                                        if ((j6 & 50331664) != 0) {
                                            this.blankView.setVisibility(i);
                                            ViewBindingAdapter.setImageViewResource(this.btnDemoVideoVisible, i21);
                                            this.layoutDemoVideo.setVisibility(i);
                                            this.tvTeachVideoTips.setVisibility(i);
                                            this.viewDemoVideo.setVisibility(i);
                                        }
                                        if ((j6 & 50331648) != 0) {
                                            this.blankView.setOnClickListener(onClickListenerImpl);
                                            this.btnCameraSetting.setOnClickListener(scaleClickListener);
                                            this.btnCapture.setOnClickListener(scaleClickListener4);
                                            this.btnDemoVideoVisible.setOnClickListener(onClickListenerImpl2);
                                            this.btnGallery.setOnClickListener(scaleClickListener13);
                                            this.btnOneKeyVideo.setOnClickListener(scaleClickListener12);
                                            this.btnParamsMode.setOnClickListener(onClickListenerImpl32);
                                            this.btnSwitchCapture.setOnClickListener(scaleClickListener11);
                                            ScaleClickListener scaleClickListener27 = scaleClickListener8;
                                            this.layoutCircle.setOnClickListener(scaleClickListener27);
                                            ScaleClickListener scaleClickListener28 = scaleClickListener7;
                                            this.layoutComet.setOnClickListener(scaleClickListener28);
                                            ScaleClickListener scaleClickListener29 = scaleClickListener6;
                                            this.layoutRecess.setOnClickListener(scaleClickListener29);
                                            ScaleClickListener scaleClickListener30 = scaleClickListener10;
                                            this.layoutScrew.setOnClickListener(scaleClickListener30);
                                            ScaleClickListener scaleClickListener31 = scaleClickListener9;
                                            this.layoutSkyward.setOnClickListener(scaleClickListener31);
                                            this.tvCircle.setOnClickListener(scaleClickListener27);
                                            this.tvComet.setOnClickListener(scaleClickListener28);
                                            this.tvRecess.setOnClickListener(scaleClickListener29);
                                            this.tvScrew.setOnClickListener(scaleClickListener30);
                                            this.tvSkyward.setOnClickListener(scaleClickListener31);
                                            this.viewCountdown.setOnClickListener(onClickListenerImpl1);
                                        }
                                        if ((52428808 & j6) != 0) {
                                            ViewBindingAdapter.setImageViewResource(this.btnCameraSetting, i31);
                                        }
                                        if ((j6 & 54559235) != 0) {
                                            ViewBindingAdapter.setViewEnableWithAlpha(this.btnCameraSetting, z107);
                                        }
                                        if ((50352128 & j6) != 0) {
                                            this.btnCameraSetting.setVisibility(i48);
                                            this.mboundView31.setVisibility(i28);
                                        }
                                        if ((j6 & 50497025) != 0) {
                                            ViewBindingAdapter.setViewEnableWithAlpha(this.btnCapture, z69);
                                        }
                                        if ((52449280 & j6) != 0) {
                                            ViewBindingAdapter.setVerticalBias(this.btnCapture, f2);
                                        }
                                        if ((50856064 & j6) != 0) {
                                            ViewBindingAdapter.setCaptureUiType(this.btnCapture, i34, i6);
                                        }
                                        if ((50593792 & j6) != 0) {
                                            this.btnDemoVideoVisible.setVisibility(i5);
                                            ViewBindingAdapter.setBackgroundColor(this.layoutShortVideo, i22);
                                            this.layoutVideoType.setVisibility(i20);
                                        }
                                        if ((50333696 & j6) != 0) {
                                            ViewBindingAdapter.setGalleryType(this.btnGallery, i43);
                                        }
                                        if (j30 != 0) {
                                            ViewBindingAdapter.setViewEnableWithAlpha(this.btnGallery, z79);
                                        }
                                        if (j31 != 0) {
                                            ViewBindingAdapter.setViewEnableWithAlpha(this.btnOneKeyVideo, z109);
                                        }
                                        if ((52428800 & j6) != 0) {
                                            int i87 = i4;
                                            this.btnOneKeyVideo.setVisibility(i87);
                                            this.mboundView29.setVisibility(i87);
                                        }
                                        if ((50399296 & j6) != 0) {
                                            ViewBindingAdapter.setVideoType(this.btnOneKeyVideo, visionExecuteType2, z6, z62);
                                        }
                                        if ((58785792 & j6) != 0) {
                                            ViewBindingAdapter.setImageViewResource(this.btnParamsMode, i41);
                                        }
                                        if ((j6 & 50333828) != 0) {
                                            this.btnParamsMode.setVisibility(i47);
                                        }
                                        if ((j6 & 54690307) != 0) {
                                            ViewBindingAdapter.setViewEnableWithAlpha(this.btnSwitchCapture, z78);
                                        }
                                        if ((50331776 & j6) != 0) {
                                            ViewBindingAdapter.setImageViewResource(this.btnSwitchCapture, i29);
                                        }
                                        if ((50331780 & j6) != 0) {
                                            this.imgBgParamsSetting.setVisibility(i40);
                                            this.wheelView.setVisibility(i38);
                                        }
                                        if ((54526212 & j6) != 0) {
                                            this.ivRecordRed.setVisibility(i46);
                                        }
                                        if ((50331712 & j6) != 0) {
                                            this.mboundView25.setVisibility(i3);
                                        }
                                        if ((j6 & 50397184) != 0) {
                                            ViewBindingAdapter.setDrawableTop(this.tvCircle, i16);
                                            ViewBindingAdapter.setDrawableTop(this.tvComet, i17);
                                            ViewBindingAdapter.setDrawableTop(this.tvRecess, i14);
                                            ViewBindingAdapter.setDrawableTop(this.tvScrew, i15);
                                            ViewBindingAdapter.setDrawableTop(this.tvSkyward, i32);
                                        }
                                        if ((50339840 & j6) != 0) {
                                            ViewBindingAdapter.setText(this.tvRecordTips, observableString);
                                        }
                                        if ((j6 & 54525956) != 0) {
                                            this.tvRecordTips.setVisibility(i37);
                                        }
                                        if ((50331680 & j6) != 0) {
                                            ViewBindingAdapter.setCountDownStart(this.viewCountdown, z45, onCountDownListener);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                i44 = 0;
                                j28 = j6 & 54559235;
                                if (j28 != 0) {
                                }
                                if (j22 != 0) {
                                }
                                if (j26 != 0) {
                                }
                                if (j25 != 0) {
                                }
                                if ((j6 & 50497025) != 0) {
                                }
                                if (j23 != 0) {
                                }
                                if ((j4 & 32) != 0) {
                                }
                                if ((j5 & 32768) != 0) {
                                }
                                if ((j4 & 34359738880L) != 0) {
                                }
                                if (j28 == 0) {
                                }
                                if (j22 != 0) {
                                }
                                if (j23 != 0) {
                                }
                                if (j25 != 0) {
                                }
                                if ((j6 & IjkMediaMeta.AV_CH_WIDE_LEFT) != 0) {
                                }
                                if ((j4 & 32768) == 0) {
                                }
                                if (rightControllerModel != null) {
                                }
                                updateRegistration(15, observableBoolean23);
                                if (observableBoolean23 != null) {
                                }
                                z49 = !z64;
                                if ((j6 & 54690307) == 0) {
                                }
                                j29 = j6 & 54559271;
                                if (j29 != 0) {
                                }
                                j30 = j6 & 55738919;
                                if (j30 != 0) {
                                }
                                if ((j6 & 576460752303423488L) != 0) {
                                }
                                if ((j4 & 137438953472L) != 0) {
                                }
                                j31 = j6 & 54559271;
                                if (j31 == 0) {
                                }
                                if (j30 != 0) {
                                }
                                if ((j4 & LockFreeTaskQueueCore.CLOSED_MASK) != 0) {
                                }
                                if (j30 != 0) {
                                }
                                if ((j6 & 50331664) != 0) {
                                }
                                if ((j6 & 50331648) != 0) {
                                }
                                if ((52428808 & j6) != 0) {
                                }
                                if ((j6 & 54559235) != 0) {
                                }
                                if ((50352128 & j6) != 0) {
                                }
                                if ((j6 & 50497025) != 0) {
                                }
                                if ((52449280 & j6) != 0) {
                                }
                                if ((50856064 & j6) != 0) {
                                }
                                if ((50593792 & j6) != 0) {
                                }
                                if ((50333696 & j6) != 0) {
                                }
                                if (j30 != 0) {
                                }
                                if (j31 != 0) {
                                }
                                if ((52428800 & j6) != 0) {
                                }
                                if ((50399296 & j6) != 0) {
                                }
                                if ((58785792 & j6) != 0) {
                                }
                                if ((j6 & 50333828) != 0) {
                                }
                                if ((j6 & 54690307) != 0) {
                                }
                                if ((50331776 & j6) != 0) {
                                }
                                if ((50331780 & j6) != 0) {
                                }
                                if ((54526212 & j6) != 0) {
                                }
                                if ((50331712 & j6) != 0) {
                                }
                                if ((j6 & 50397184) != 0) {
                                }
                                if ((50339840 & j6) != 0) {
                                }
                                if ((j6 & 54525956) != 0) {
                                }
                                if ((50331680 & j6) != 0) {
                                }
                            }
                        } else {
                            i40 = i35;
                            i41 = i39;
                        }
                        z56 = false;
                        if ((j6 & 144115188075855872L) == 0) {
                        }
                        if (rightControllerModel == null) {
                        }
                        updateRegistration(9, observableBoolean15);
                        if (observableBoolean15 == null) {
                        }
                        z59 = !z58;
                        if ((j6 & IjkMediaMeta.AV_CH_STEREO_LEFT) == 0) {
                        }
                        if ((j4 & 576460752303423488L) == 0) {
                        }
                        if ((j4 & IjkMediaMeta.AV_CH_STEREO_LEFT) == 0) {
                        }
                        j27 = j6 & 50333828;
                        if (j27 != 0) {
                        }
                        i44 = 0;
                        j28 = j6 & 54559235;
                        if (j28 != 0) {
                        }
                        if (j22 != 0) {
                        }
                        if (j26 != 0) {
                        }
                        if (j25 != 0) {
                        }
                        if ((j6 & 50497025) != 0) {
                        }
                        if (j23 != 0) {
                        }
                        if ((j4 & 32) != 0) {
                        }
                        if ((j5 & 32768) != 0) {
                        }
                        if ((j4 & 34359738880L) != 0) {
                        }
                        if (j28 == 0) {
                        }
                        if (j22 != 0) {
                        }
                        if (j23 != 0) {
                        }
                        if (j25 != 0) {
                        }
                        if ((j6 & IjkMediaMeta.AV_CH_WIDE_LEFT) != 0) {
                        }
                        if ((j4 & 32768) == 0) {
                        }
                        if (rightControllerModel != null) {
                        }
                        updateRegistration(15, observableBoolean23);
                        if (observableBoolean23 != null) {
                        }
                        z49 = !z64;
                        if ((j6 & 54690307) == 0) {
                        }
                        j29 = j6 & 54559271;
                        if (j29 != 0) {
                        }
                        j30 = j6 & 55738919;
                        if (j30 != 0) {
                        }
                        if ((j6 & 576460752303423488L) != 0) {
                        }
                        if ((j4 & 137438953472L) != 0) {
                        }
                        j31 = j6 & 54559271;
                        if (j31 == 0) {
                        }
                        if (j30 != 0) {
                        }
                        if ((j4 & LockFreeTaskQueueCore.CLOSED_MASK) != 0) {
                        }
                        if (j30 != 0) {
                        }
                        if ((j6 & 50331664) != 0) {
                        }
                        if ((j6 & 50331648) != 0) {
                        }
                        if ((52428808 & j6) != 0) {
                        }
                        if ((j6 & 54559235) != 0) {
                        }
                        if ((50352128 & j6) != 0) {
                        }
                        if ((j6 & 50497025) != 0) {
                        }
                        if ((52449280 & j6) != 0) {
                        }
                        if ((50856064 & j6) != 0) {
                        }
                        if ((50593792 & j6) != 0) {
                        }
                        if ((50333696 & j6) != 0) {
                        }
                        if (j30 != 0) {
                        }
                        if (j31 != 0) {
                        }
                        if ((52428800 & j6) != 0) {
                        }
                        if ((50399296 & j6) != 0) {
                        }
                        if ((58785792 & j6) != 0) {
                        }
                        if ((j6 & 50333828) != 0) {
                        }
                        if ((j6 & 54690307) != 0) {
                        }
                        if ((50331776 & j6) != 0) {
                        }
                        if ((50331780 & j6) != 0) {
                        }
                        if ((54526212 & j6) != 0) {
                        }
                        if ((50331712 & j6) != 0) {
                        }
                        if ((j6 & 50397184) != 0) {
                        }
                        if ((50339840 & j6) != 0) {
                        }
                        if ((j6 & 54525956) != 0) {
                        }
                        if ((50331680 & j6) != 0) {
                        }
                    }
                } else {
                    z44 = z43;
                    z45 = z42;
                    i33 = i2;
                }
                z46 = false;
                if ((j6 & 35184372088832L) != 0) {
                }
                if ((j6 & 9570149208162304L) != 0) {
                }
                if ((j6 & 17592186044416L) != 0) {
                }
                if ((j4 & 2533274790395904L) == 0) {
                }
                z50 = z48;
                if (rightControllerModel != null) {
                }
                updateRegistration(22, observableBoolean13);
                if (observableBoolean13 != null) {
                }
                j18 = 0;
                if ((j4 & 2251799813685248L) != 0) {
                }
                if ((j6 & 137438953472L) == j18) {
                }
                j19 = j6 & 54559235;
                if (j19 != j18) {
                }
                j20 = j6 & 50497025;
                if (j20 != 0) {
                }
                j21 = j6 & 50333828;
                if (j21 != 0) {
                }
                j22 = j6 & 55738919;
                if (j22 != 0) {
                }
                if ((j6 & 68719476736L) == 0) {
                }
                j23 = j6 & 54559271;
                if (j23 != 0) {
                }
                j24 = j6 & 54525956;
                if (j24 != 0) {
                }
                j25 = j6 & 54690307;
                if (j25 != 0) {
                }
                j26 = j6 & 54526212;
                if (j26 != 0) {
                }
                if ((j6 & 58785792) != 0) {
                }
                if ((j4 & 144115188075855872L) != 0) {
                }
                z56 = false;
                if ((j6 & 144115188075855872L) == 0) {
                }
                if (rightControllerModel == null) {
                }
                updateRegistration(9, observableBoolean15);
                if (observableBoolean15 == null) {
                }
                z59 = !z58;
                if ((j6 & IjkMediaMeta.AV_CH_STEREO_LEFT) == 0) {
                }
                if ((j4 & 576460752303423488L) == 0) {
                }
                if ((j4 & IjkMediaMeta.AV_CH_STEREO_LEFT) == 0) {
                }
                j27 = j6 & 50333828;
                if (j27 != 0) {
                }
                i44 = 0;
                j28 = j6 & 54559235;
                if (j28 != 0) {
                }
                if (j22 != 0) {
                }
                if (j26 != 0) {
                }
                if (j25 != 0) {
                }
                if ((j6 & 50497025) != 0) {
                }
                if (j23 != 0) {
                }
                if ((j4 & 32) != 0) {
                }
                if ((j5 & 32768) != 0) {
                }
                if ((j4 & 34359738880L) != 0) {
                }
                if (j28 == 0) {
                }
                if (j22 != 0) {
                }
                if (j23 != 0) {
                }
                if (j25 != 0) {
                }
                if ((j6 & IjkMediaMeta.AV_CH_WIDE_LEFT) != 0) {
                }
                if ((j4 & 32768) == 0) {
                }
                if (rightControllerModel != null) {
                }
                updateRegistration(15, observableBoolean23);
                if (observableBoolean23 != null) {
                }
                z49 = !z64;
                if ((j6 & 54690307) == 0) {
                }
                j29 = j6 & 54559271;
                if (j29 != 0) {
                }
                j30 = j6 & 55738919;
                if (j30 != 0) {
                }
                if ((j6 & 576460752303423488L) != 0) {
                }
                if ((j4 & 137438953472L) != 0) {
                }
                j31 = j6 & 54559271;
                if (j31 == 0) {
                }
                if (j30 != 0) {
                }
                if ((j4 & LockFreeTaskQueueCore.CLOSED_MASK) != 0) {
                }
                if (j30 != 0) {
                }
                if ((j6 & 50331664) != 0) {
                }
                if ((j6 & 50331648) != 0) {
                }
                if ((52428808 & j6) != 0) {
                }
                if ((j6 & 54559235) != 0) {
                }
                if ((50352128 & j6) != 0) {
                }
                if ((j6 & 50497025) != 0) {
                }
                if ((52449280 & j6) != 0) {
                }
                if ((50856064 & j6) != 0) {
                }
                if ((50593792 & j6) != 0) {
                }
                if ((50333696 & j6) != 0) {
                }
                if (j30 != 0) {
                }
                if (j31 != 0) {
                }
                if ((52428800 & j6) != 0) {
                }
                if ((50399296 & j6) != 0) {
                }
                if ((58785792 & j6) != 0) {
                }
                if ((j6 & 50333828) != 0) {
                }
                if ((j6 & 54690307) != 0) {
                }
                if ((50331776 & j6) != 0) {
                }
                if ((50331780 & j6) != 0) {
                }
                if ((54526212 & j6) != 0) {
                }
                if ((50331712 & j6) != 0) {
                }
                if ((j6 & 50397184) != 0) {
                }
                if ((50339840 & j6) != 0) {
                }
                if ((j6 & 54525956) != 0) {
                }
                if ((50331680 & j6) != 0) {
                }
            }
        }
        z28 = false;
        if ((j4 & 18014398509481984L) == 0) {
        }
        if ((j6 & 2251799813685248L) == 0) {
        }
        z29 = z28;
        if (rightControllerModel == null) {
        }
        updateRegistration(17, observableBoolean7);
        if (observableBoolean7 == null) {
        }
        z31 = !z30;
        if ((j6 & LockFreeTaskQueueCore.FROZEN_MASK) == 0) {
        }
        if ((j4 & IjkMediaMeta.AV_CH_WIDE_RIGHT) == 0) {
        }
        if ((j4 & IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) == 0) {
        }
        if ((j4 & j10) == 0) {
        }
        if ((j6 & 206158430208L) == 0) {
        }
        if ((j6 & LockFreeTaskQueueCore.CLOSED_MASK) == 0) {
        }
        j11 = j6 & 50352128;
        if (j11 == 0) {
        }
        j12 = j6 & 54559271;
        if (j12 == 0) {
        }
        j13 = j6 & 50497025;
        if (j13 == 0) {
        }
        if ((j6 & 50331776) == 0) {
        }
        j14 = j6 & 54559235;
        if (j14 == 0) {
        }
        if ((j5 & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != 0) {
        }
        j15 = j6 & 52449280;
        if (j15 == 0) {
        }
        j16 = j6 & 55738919;
        if (j16 == 0) {
        }
        if ((j6 & 50397184) == 0) {
        }
        j17 = j6 & 54690307;
        if (j17 == 0) {
        }
        if ((j6 & 52428808) == 0) {
        }
        if ((j4 & 274877906944L) == 0) {
        }
        if ((j4 & 549755813888L) == 0) {
        }
        if ((j4 & 35184380477440L) == 0) {
        }
        if ((j4 & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) == 0) {
        }
        z46 = false;
        if ((j6 & 35184372088832L) != 0) {
        }
        if ((j6 & 9570149208162304L) != 0) {
        }
        if ((j6 & 17592186044416L) != 0) {
        }
        if ((j4 & 2533274790395904L) == 0) {
        }
        z50 = z48;
        if (rightControllerModel != null) {
        }
        updateRegistration(22, observableBoolean13);
        if (observableBoolean13 != null) {
        }
        j18 = 0;
        if ((j4 & 2251799813685248L) != 0) {
        }
        if ((j6 & 137438953472L) == j18) {
        }
        j19 = j6 & 54559235;
        if (j19 != j18) {
        }
        j20 = j6 & 50497025;
        if (j20 != 0) {
        }
        j21 = j6 & 50333828;
        if (j21 != 0) {
        }
        j22 = j6 & 55738919;
        if (j22 != 0) {
        }
        if ((j6 & 68719476736L) == 0) {
        }
        j23 = j6 & 54559271;
        if (j23 != 0) {
        }
        j24 = j6 & 54525956;
        if (j24 != 0) {
        }
        j25 = j6 & 54690307;
        if (j25 != 0) {
        }
        j26 = j6 & 54526212;
        if (j26 != 0) {
        }
        if ((j6 & 58785792) != 0) {
        }
        if ((j4 & 144115188075855872L) != 0) {
        }
        z56 = false;
        if ((j6 & 144115188075855872L) == 0) {
        }
        if (rightControllerModel == null) {
        }
        updateRegistration(9, observableBoolean15);
        if (observableBoolean15 == null) {
        }
        z59 = !z58;
        if ((j6 & IjkMediaMeta.AV_CH_STEREO_LEFT) == 0) {
        }
        if ((j4 & 576460752303423488L) == 0) {
        }
        if ((j4 & IjkMediaMeta.AV_CH_STEREO_LEFT) == 0) {
        }
        j27 = j6 & 50333828;
        if (j27 != 0) {
        }
        i44 = 0;
        j28 = j6 & 54559235;
        if (j28 != 0) {
        }
        if (j22 != 0) {
        }
        if (j26 != 0) {
        }
        if (j25 != 0) {
        }
        if ((j6 & 50497025) != 0) {
        }
        if (j23 != 0) {
        }
        if ((j4 & 32) != 0) {
        }
        if ((j5 & 32768) != 0) {
        }
        if ((j4 & 34359738880L) != 0) {
        }
        if (j28 == 0) {
        }
        if (j22 != 0) {
        }
        if (j23 != 0) {
        }
        if (j25 != 0) {
        }
        if ((j6 & IjkMediaMeta.AV_CH_WIDE_LEFT) != 0) {
        }
        if ((j4 & 32768) == 0) {
        }
        if (rightControllerModel != null) {
        }
        updateRegistration(15, observableBoolean23);
        if (observableBoolean23 != null) {
        }
        z49 = !z64;
        if ((j6 & 54690307) == 0) {
        }
        j29 = j6 & 54559271;
        if (j29 != 0) {
        }
        j30 = j6 & 55738919;
        if (j30 != 0) {
        }
        if ((j6 & 576460752303423488L) != 0) {
        }
        if ((j4 & 137438953472L) != 0) {
        }
        j31 = j6 & 54559271;
        if (j31 == 0) {
        }
        if (j30 != 0) {
        }
        if ((j4 & LockFreeTaskQueueCore.CLOSED_MASK) != 0) {
        }
        if (j30 != 0) {
        }
        if ((j6 & 50331664) != 0) {
        }
        if ((j6 & 50331648) != 0) {
        }
        if ((52428808 & j6) != 0) {
        }
        if ((j6 & 54559235) != 0) {
        }
        if ((50352128 & j6) != 0) {
        }
        if ((j6 & 50497025) != 0) {
        }
        if ((52449280 & j6) != 0) {
        }
        if ((50856064 & j6) != 0) {
        }
        if ((50593792 & j6) != 0) {
        }
        if ((50333696 & j6) != 0) {
        }
        if (j30 != 0) {
        }
        if (j31 != 0) {
        }
        if ((52428800 & j6) != 0) {
        }
        if ((50399296 & j6) != 0) {
        }
        if ((58785792 & j6) != 0) {
        }
        if ((j6 & 50333828) != 0) {
        }
        if ((j6 & 54690307) != 0) {
        }
        if ((50331776 & j6) != 0) {
        }
        if ((50331780 & j6) != 0) {
        }
        if ((54526212 & j6) != 0) {
        }
        if ((50331712 & j6) != 0) {
        }
        if ((j6 & 50397184) != 0) {
        }
        if ((50339840 & j6) != 0) {
        }
        if ((j6 & 54525956) != 0) {
        }
        if ((50331680 & j6) != 0) {
        }
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