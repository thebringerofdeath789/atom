package com.ipotensic.kernel.controllers;

import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.C1965R;
import com.logan.camera.CameraCtrlPresenter;

/* loaded from: classes2.dex */
public class TestCameraController extends BaseController {
    private Handler handler;
    private ScrollView scrollView;
    private TextView tvMsg;
    private TextView tvPreviewSize;

    public TestCameraController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        this.handler = new Handler();
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.scrollView = (ScrollView) view.findViewById(C1965R.id.scroll_view);
        this.tvMsg = (TextView) view.findViewById(C1965R.id.tv_msg);
        this.tvPreviewSize = (TextView) view.findViewById(C1965R.id.tv_preview_size);
        TextView textView = (TextView) view.findViewById(C1965R.id.btn_send1);
        final EditText editText = (EditText) view.findViewById(C1965R.id.et_fun1);
        final EditText editText2 = (EditText) view.findViewById(C1965R.id.et_params1);
        textView.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.controllers.TestCameraController.1
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                try {
                    CameraCtrlPresenter.getInstance().setDebugCmd(ParseUtil.hexStringToByte(editText.getText().toString())[0], editText2.getText().toString().getBytes());
                } catch (Exception e) {
                    ToastUtil.toast(TestCameraController.this.getContext(), "发送出错1:" + e.getMessage());
                }
            }
        });
        ((TextView) view.findViewById(C1965R.id.btn_clear1)).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.controllers.TestCameraController.2
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                editText.setText("");
                editText2.setText("");
            }
        });
        TextView textView2 = (TextView) view.findViewById(C1965R.id.btn_send2);
        final EditText editText3 = (EditText) view.findViewById(C1965R.id.et_fun2);
        final EditText editText4 = (EditText) view.findViewById(C1965R.id.et_params2);
        ((TextView) view.findViewById(C1965R.id.btn_clear2)).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.controllers.TestCameraController.3
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                editText3.setText("");
                editText4.setText("");
            }
        });
        textView2.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.controllers.TestCameraController.4
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                try {
                    CameraCtrlPresenter.getInstance().setDebugCmd(ParseUtil.hexStringToByte(editText3.getText().toString())[0], editText4.getText().toString().getBytes());
                } catch (Exception e) {
                    ToastUtil.toast(TestCameraController.this.getContext(), "发送出错2:" + e.getMessage());
                }
            }
        });
        setPreviewSizeUI();
    }

    private void setPreviewSizeUI() {
        TextView textView;
        if (PhoneConfig.previewSize == null || (textView = this.tvPreviewSize) == null) {
            return;
        }
        textView.setText("宽 ： " + PhoneConfig.previewSize.getWidth() + "\n高 ： " + PhoneConfig.previewSize.getHeight());
    }

    /* renamed from: com.ipotensic.kernel.controllers.TestCameraController$6 */
    static /* synthetic */ class C21896 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.EVENT_SHOW_CAMERA_DEBUG_INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_PREVIEW_SIZE_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        int i = C21896.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            setPreviewSizeUI();
        } else {
            this.tvMsg.append((String) event.obj);
            if (isScrollToBottom()) {
                this.handler.post(new Runnable() { // from class: com.ipotensic.kernel.controllers.TestCameraController.5
                    @Override // java.lang.Runnable
                    public void run() {
                        TestCameraController.this.scrollView.fullScroll(130);
                    }
                });
            }
        }
    }

    private boolean isScrollToBottom() {
        try {
            return this.scrollView.getChildAt(0).getMeasuredHeight() <= this.scrollView.getScrollY() + this.scrollView.getHeight();
        } catch (Exception unused) {
            return false;
        }
    }
}