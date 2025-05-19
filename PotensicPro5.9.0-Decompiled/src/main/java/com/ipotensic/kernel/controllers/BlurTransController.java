package com.ipotensic.kernel.controllers;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.utils.YuvTransformer;
import com.ipotensic.baselib.utils.compress.BitmapUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.utils.BlurUtils;
import com.logan.h264.H264Player;
import java.io.ByteArrayOutputStream;

/* loaded from: classes2.dex */
public class BlurTransController extends BaseController {
    private final long BLUR_FIRST_TIME;
    private final long BLUR_SHOW_TIME;
    private final Runnable dismissRunnable;
    private boolean isShow;
    private ImageView ivBlurTransBg;

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
    }

    public BlurTransController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        this.BLUR_FIRST_TIME = 3000L;
        this.BLUR_SHOW_TIME = 1800L;
        this.isShow = false;
        this.dismissRunnable = new Runnable() { // from class: com.ipotensic.kernel.controllers.BlurTransController.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BlurTransController.this.setVisibility(8);
                    DDLog.e("显示消失");
                } catch (Exception unused) {
                }
            }
        };
        this.ivBlurTransBg = (ImageView) view.findViewById(R.id.img_blur_trans_bg);
    }

    public void onMapVideoChanged() {
        setVisibility(8);
    }

    /* renamed from: com.ipotensic.kernel.controllers.BlurTransController$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.EVENT_CAMERA_SWITCH_MODE_NOTIFY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_SET_CAPTURE_MODE_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_SHOW_BLUR_TRANS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_AOA_DISCONNECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_HIDE_BLUR_TRANS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onEvent(com.ipotensic.baselib.dispatcher.EventID r3, com.ipotensic.baselib.dispatcher.Event r4) {
        /*
            r2 = this;
            super.onEvent(r3, r4)
            int[] r4 = com.ipotensic.kernel.controllers.BlurTransController.AnonymousClass3.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID
            int r3 = r3.ordinal()
            r3 = r4[r3]
            r4 = 1
            if (r3 == r4) goto L1f
            r0 = 2
            if (r3 == r0) goto L24
            r0 = 3
            if (r3 == r0) goto L29
            r4 = 4
            if (r3 == r4) goto L1b
            r4 = 5
            if (r3 == r4) goto L1b
            goto L4f
        L1b:
            r3 = 0
            r2.isShow = r3
            goto L4f
        L1f:
            java.lang.String r3 = "blur EVENT_CAMERA_SWITCH_MODE_NOTIFY"
            com.ipotensic.baselib.DDLog.e(r3)
        L24:
            java.lang.String r3 = "blur EVENT_SET_CAPTURE_MODE_SUCCESS"
            com.ipotensic.baselib.DDLog.e(r3)
        L29:
            java.lang.String r3 = "blur EVENT_SHOW_BLUR_TRANS"
            com.ipotensic.baselib.DDLog.e(r3)
            int r3 = r2.getVisibility()
            if (r3 == 0) goto L3a
            r2.isShow = r4
            r2.show()
            goto L4f
        L3a:
            java.lang.String r3 = "延迟显示"
            com.ipotensic.baselib.DDLog.e(r3)
            android.os.Handler r3 = com.ipotensic.baselib.configs.PhoneConfig.mainHandler
            java.lang.Runnable r4 = r2.dismissRunnable
            r3.removeCallbacks(r4)
            android.os.Handler r3 = com.ipotensic.baselib.configs.PhoneConfig.mainHandler
            java.lang.Runnable r4 = r2.dismissRunnable
            r0 = 1800(0x708, double:8.893E-321)
            r3.postDelayed(r4, r0)
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.kernel.controllers.BlurTransController.onEvent(com.ipotensic.baselib.dispatcher.EventID, com.ipotensic.baselib.dispatcher.Event):void");
    }

    private void show() {
        try {
            if (this.isShow) {
                DDLog.e("开始显示");
                this.isShow = false;
                H264Player.YuvData yuvData = H264Player.currentYuvData;
                if (yuvData != null) {
                    Bitmap nv21ToBitmap = YuvTransformer.nv21ToBitmap(YuvTransformer.getNv21(yuvData.Y, yuvData.U, yuvData.V, yuvData.width, yuvData.height), yuvData.width, yuvData.height);
                    Bitmap blurBitmap = BlurUtils.blurBitmap(getContext(), nv21ToBitmap, 20.0f);
                    final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    blurBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    BitmapUtil.recycle(blurBitmap);
                    BitmapUtil.recycle(nv21ToBitmap);
                    PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.controllers.BlurTransController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                MapVideoController mapVideoController = (MapVideoController) EventDispatcher.get().getController(MapVideoController.class);
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) BlurTransController.this.ivBlurTransBg.getLayoutParams();
                                if (mapVideoController.isMapMode()) {
                                    layoutParams.height = -1;
                                    layoutParams.width = -1;
                                } else {
                                    layoutParams.height = -1;
                                    layoutParams.width = PhoneConfig.showSize.getWidth();
                                }
                                BlurTransController.this.ivBlurTransBg.setLayoutParams(layoutParams);
                                Glide.with((FragmentActivity) BlurTransController.this.getContext()).load(byteArrayOutputStream.toByteArray()).into(BlurTransController.this.ivBlurTransBg);
                                BlurTransController.this.setVisibility(0);
                                DDLog.e("显示中");
                            } catch (Exception e) {
                                DDLog.e("显示失败:" + e);
                            }
                        }
                    });
                    PhoneConfig.mainHandler.removeCallbacks(this.dismissRunnable);
                    PhoneConfig.mainHandler.postDelayed(this.dismissRunnable, 3000L);
                }
            }
        } catch (Exception unused) {
        }
    }
}
