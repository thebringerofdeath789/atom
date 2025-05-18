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
import com.ipotensic.baselib.dispatcher.Event;
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
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    BlurTransController.this.setVisibility(8);
                    DDLog.e("\u663e\u793a\u6d88\u5931");
                } catch (Exception unused) {
                }
            }
        };
        this.ivBlurTransBg = (ImageView) view.findViewById(R.id.img_blur_trans_bg);
    }

    public void onMapVideoChanged() {
        setVisibility(8);
    }

    /* renamed from: com.ipotensic.kernel.controllers.BlurTransController$3 */
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
    */
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        int i = AnonymousClass3.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1) {
            DDLog.e("blur EVENT_CAMERA_SWITCH_MODE_NOTIFY");
        } else if (i != 2) {
            if (i != 3) {
                if (i == 4 || i == 5) {
                    this.isShow = false;
                    return;
                }
                return;
            }
            DDLog.e("blur EVENT_SHOW_BLUR_TRANS");
            if (getVisibility() == 0) {
                this.isShow = true;
                show();
                return;
            } else {
                DDLog.e("\u5ef6\u8fdf\u663e\u793a");
                PhoneConfig.mainHandler.removeCallbacks(this.dismissRunnable);
                PhoneConfig.mainHandler.postDelayed(this.dismissRunnable, 1800L);
                return;
            }
        }
        DDLog.e("blur EVENT_SET_CAPTURE_MODE_SUCCESS");
        DDLog.e("blur EVENT_SHOW_BLUR_TRANS");
        if (getVisibility() == 0) {
        }
    }

    private void show() {
        try {
            if (this.isShow) {
                DDLog.e("\u5f00\u59cb\u663e\u793a");
                this.isShow = false;
                H264Player.YuvData yuvData = H264Player.currentYuvData;
                if (yuvData != null) {
                    Bitmap nv21ToBitmap = YuvTransformer.nv21ToBitmap(YuvTransformer.getNv21(yuvData.Y, yuvData.U, yuvData.V, yuvData.width, yuvData.height), yuvData.width, yuvData.height);
                    Bitmap blurBitmap = BlurUtils.blurBitmap(getContext(), nv21ToBitmap, 20.0f);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    blurBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    BitmapUtil.recycle(blurBitmap);
                    BitmapUtil.recycle(nv21ToBitmap);
                    PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.controllers.BlurTransController.1
                        final /* synthetic */ ByteArrayOutputStream val$bgStream;

                        AnonymousClass1(ByteArrayOutputStream byteArrayOutputStream2) {
                            r2 = byteArrayOutputStream2;
                        }

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
                                Glide.with((FragmentActivity) BlurTransController.this.getContext()).load(r2.toByteArray()).into(BlurTransController.this.ivBlurTransBg);
                                BlurTransController.this.setVisibility(0);
                                DDLog.e("\u663e\u793a\u4e2d");
                            } catch (Exception e) {
                                DDLog.e("\u663e\u793a\u5931\u8d25:" + e);
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

    /* renamed from: com.ipotensic.kernel.controllers.BlurTransController$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ByteArrayOutputStream val$bgStream;

        AnonymousClass1(ByteArrayOutputStream byteArrayOutputStream2) {
            r2 = byteArrayOutputStream2;
        }

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
                Glide.with((FragmentActivity) BlurTransController.this.getContext()).load(r2.toByteArray()).into(BlurTransController.this.ivBlurTransBg);
                BlurTransController.this.setVisibility(0);
                DDLog.e("\u663e\u793a\u4e2d");
            } catch (Exception e) {
                DDLog.e("\u663e\u793a\u5931\u8d25:" + e);
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.controllers.BlurTransController$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BlurTransController.this.setVisibility(8);
                DDLog.e("\u663e\u793a\u6d88\u5931");
            } catch (Exception unused) {
            }
        }
    }
}