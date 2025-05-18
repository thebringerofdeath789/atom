package com.ipotensic.kernel.controllers.settings;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.fastjson.JSONObject;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.guide.util.ViewUtils;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.utils.CommonUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.controllers.BaseController;
import com.ipotensic.kernel.manager.FlightFirmwareChecker;
import com.ipotensic.kernel.utils.AnimationUtil;
import com.ipotensic.kernel.view.CursorEditText;
import com.ipotensic.kernel.view.CustomSeekbar;
import com.ipotensic.kernel.view.SwitchButton;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.kernel.view.dialog.GeneralOneButtonDialog;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevSettingData;
import com.logan.flight.data.recv.FlightRevStateData;
import com.logan.flight.data.recv.FlightRevVersionData;
import com.mapbox.api.directions.p022v5.models.SpeedLimit;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class Setting1Controller extends BaseController implements View.OnClickListener, SwitchButton.SwitchStateListener {
    private static final long DIALOG_DISMISS_TIME = 15000;
    private final String CHAR_FORMAT;
    private final String CHAR_NO_LIMIT;
    private GeneralOneButtonDialog closeNewHandModeDialog;
    private CursorEditText etLimitDistance;
    private CursorEditText etLimitHeight;
    private CursorEditText etRadius;
    private CursorEditText etReturnHeight;
    private CursorEditText etSpeed;
    private final Handler handler;
    private final CursorEditText.OnInputFinishListener inputFinishListener;
    private boolean isFlight;
    private boolean isFromUser;
    private boolean isSoftInputShow;
    private ImageView ivBack;
    private ImageButton ivLeft;
    private ImageButton ivRight;
    private int lastTrackValue;
    private ConstraintLayout layoutCircle;
    private ConstraintLayout layoutFlyFence;
    private ConstraintLayout layoutReturnHeight;
    private LinearLayout layoutRthSetting;
    private LinearLayout layoutSpeedMode;
    private RelativeLayout layoutSpeedSetting;
    private CustomSeekbar limitDistanceSeekbar;
    private CustomSeekbar limitHeightSeekbar;
    private CustomSeekbar radiusSeekBar;
    private CustomSeekbar returnHeightSeekbar;
    private GeneralDialog returnHeightVideoDialog;
    private SwitchButton sbNewMode;
    private SwitchButton sbNoLimit;
    private final SeekBar.OnSeekBarChangeListener seekBarChangeListener;
    private final ViewTreeObserver.OnGlobalLayoutListener softInputListener;
    private CustomSeekbar speedSeekBar;
    private final Runnable sportSeedTooFastRunnable;
    private FlightRevStateData stateData;
    private TextView tvCircleRadiusUnit;
    private TextView tvCircleSpeedUnit;
    private TextView tvCodeTitle;
    private TextView tvDistanceLimitTitle;
    private TextView tvDistanceUnit;
    private TextView tvFlightTips;
    private TextView tvFlyFenceSettingTitle;
    private TextView tvGentlyLowMode;
    private TextView tvHeightLimitTitle;
    private TextView tvHeightUnit;
    private TextView tvNormalMiddleMode;
    private TextView tvRadiusTitle;
    private TextView tvReturnHeightSettingTitle;
    private TextView tvReturnHeightTitle;
    private TextView tvReturnHeightUnit;
    private TextView tvSpeedTitle;
    private TextView tvSportHighMode;
    private TextView tvSportSpeedTooFast;

    @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
    public void onDisableClick() {
    }

    private void initLimitUI() {
        if (PhoneConfig.isFt) {
            this.etReturnHeight.setLimit(FlightConfig.get_value(FlightConfig.getMaxReturnHeight()), FlightConfig.get_value(30), FlightConfig.get_value(10));
            this.etLimitHeight.setLimit(FlightConfig.get_value(FlightConfig.getMaxHeight()), FlightConfig.get_value(30), FlightConfig.get_value(10));
            this.etLimitDistance.setLimit(FlightConfig.get_value(FlightConfig.getMaxDistance()), FlightConfig.get_value(30), FlightConfig.get_value(20));
            this.etRadius.setLimit(FlightConfig.get_value(50), FlightConfig.get_value(10), FlightConfig.get_value(10));
            this.etSpeed.setLimit(FlightConfig.get_speed_value(5), FlightConfig.get_speed_value(3), FlightConfig.get_speed_value(1));
        } else {
            this.etReturnHeight.setLimit(FlightConfig.getMaxReturnHeight(), 30, 10);
            this.etLimitHeight.setLimit(FlightConfig.getMaxHeight(), 30, 10);
            this.etLimitDistance.setLimit(FlightConfig.getMaxDistance(), 30, 20);
            this.etRadius.setLimit(50, 10, 10);
            this.etSpeed.setLimit(5, 3, 1);
        }
        this.etReturnHeight.setInputEnable(!PhoneConfig.isFt);
        this.etLimitHeight.setInputEnable(!PhoneConfig.isFt);
        this.etLimitDistance.setInputEnable(!PhoneConfig.isFt);
        this.etRadius.setInputEnable(!PhoneConfig.isFt);
        this.etSpeed.setInputEnable(!PhoneConfig.isFt);
        this.returnHeightSeekbar.setLimit(FlightConfig.getMaxReturnHeight(), 30, 10);
        this.limitHeightSeekbar.setLimit(FlightConfig.getMaxHeight(), 30, 10);
        this.limitDistanceSeekbar.setLimit(FlightConfig.getMaxDistance(), 30, 20);
        this.radiusSeekBar.setLimit(50, 10, 10);
        this.speedSeekBar.setLimit(5, 3, 1);
        this.tvReturnHeightUnit.setText(PhoneConfig.isFt ? "ft" : "m");
        this.tvHeightUnit.setText(PhoneConfig.isFt ? "ft" : "m");
        this.tvDistanceUnit.setText(PhoneConfig.isFt ? "ft" : "m");
        this.tvCircleRadiusUnit.setText(PhoneConfig.isFt ? "ft" : "m");
        TextView textView = this.tvCircleSpeedUnit;
        boolean z = PhoneConfig.isFt;
        String str = SpeedLimit.MPH;
        textView.setText(z ? SpeedLimit.MPH : "m/s");
        this.tvCodeTitle.setText(PhoneConfig.isFt ? String.format(getContext().getString(C1965R.string.sys_basic_beginner_mode_describe1), Integer.valueOf(FlightConfig.get_value(30))) : getContext().getString(C1965R.string.sys_basic_beginner_mode_describe));
        TextView textView2 = this.tvReturnHeightTitle;
        StringBuilder append = new StringBuilder().append(getContext().getString(C1965R.string.txt_set_range));
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.etReturnHeight.getMin());
        objArr[1] = Integer.valueOf(this.etReturnHeight.getMax());
        objArr[2] = PhoneConfig.isFt ? "ft" : "m";
        textView2.setText(append.append(String.format(": (%d~%d%s)", objArr)).toString());
        TextView textView3 = this.tvHeightLimitTitle;
        StringBuilder append2 = new StringBuilder().append(getContext().getString(C1965R.string.sys_basic_altitude_limitation));
        Object[] objArr2 = new Object[3];
        objArr2[0] = Integer.valueOf(this.etLimitHeight.getMin());
        objArr2[1] = Integer.valueOf(this.etLimitHeight.getMax());
        objArr2[2] = PhoneConfig.isFt ? "ft" : "m";
        textView3.setText(append2.append(String.format(": (%d~%d%s)", objArr2)).toString());
        TextView textView4 = this.tvDistanceLimitTitle;
        StringBuilder append3 = new StringBuilder().append(getContext().getString(C1965R.string.sys_basic_distance_limitation));
        Object[] objArr3 = new Object[3];
        objArr3[0] = Integer.valueOf(this.etLimitDistance.getMin());
        objArr3[1] = Integer.valueOf(this.etLimitDistance.getMax());
        objArr3[2] = PhoneConfig.isFt ? "ft" : "m";
        textView4.setText(append3.append(String.format(": (%d~%d%s)", objArr3)).toString());
        TextView textView5 = this.tvRadiusTitle;
        StringBuilder append4 = new StringBuilder().append(getContext().getString(C1965R.string.sys_basic_radius));
        Object[] objArr4 = new Object[3];
        objArr4[0] = Integer.valueOf(this.etRadius.getMin());
        objArr4[1] = Integer.valueOf(this.etRadius.getMax());
        objArr4[2] = PhoneConfig.isFt ? "ft" : "m";
        textView5.setText(append4.append(String.format(": (%d~%d%s)", objArr4)).toString());
        TextView textView6 = this.tvSpeedTitle;
        StringBuilder append5 = new StringBuilder().append(getContext().getString(C1965R.string.sys_basic_speed));
        Object[] objArr5 = new Object[3];
        objArr5[0] = Integer.valueOf(this.etSpeed.getMin());
        objArr5[1] = Integer.valueOf(this.etSpeed.getMax());
        if (!PhoneConfig.isFt) {
            str = "m/s";
        }
        objArr5[2] = str;
        textView6.setText(append5.append(String.format(": (%d~%d%s)", objArr5)).toString());
    }

    public Setting1Controller(AppCompatActivity appCompatActivity, ViewStub viewStub) {
        super(appCompatActivity, viewStub);
        this.CHAR_NO_LIMIT = "∞";
        this.CHAR_FORMAT = ": (%d~%d%s)";
        this.isSoftInputShow = false;
        this.stateData = new FlightRevStateData();
        this.isFromUser = true;
        this.softInputListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.ipotensic.kernel.controllers.settings.Setting1Controller.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    Rect rect = new Rect();
                    Setting1Controller.this.etLimitHeight.getWindowVisibleDisplayFrame(rect);
                    int height = Setting1Controller.this.etLimitHeight.getRootView().getHeight();
                    int i = height - rect.bottom;
                    if (i > height / 6) {
                        Setting1Controller.this.isSoftInputShow = true;
                    } else if (Setting1Controller.this.isSoftInputShow && i <= height / 6) {
                        Setting1Controller.this.isSoftInputShow = false;
                        int limitHeight = FlightRevData.get().getFlightRevSettingData().getLimitHeight();
                        int value = Setting1Controller.this.limitHeightSeekbar.getValue();
                        if (limitHeight <= 120 && value > 120) {
                            Setting1Controller.this.showOver120Dialog();
                        }
                    }
                } catch (Exception unused) {
                }
            }
        };
        this.inputFinishListener = new CursorEditText.OnInputFinishListener() { // from class: com.ipotensic.kernel.controllers.settings.Setting1Controller.2
            @Override // com.ipotensic.kernel.view.CursorEditText.OnInputFinishListener
            public void onResult(View view, int i) {
                int id = view.getId();
                if (id != Setting1Controller.this.etRadius.getId()) {
                    if (id != Setting1Controller.this.etSpeed.getId()) {
                        if (id != Setting1Controller.this.etReturnHeight.getId()) {
                            if (id != Setting1Controller.this.etLimitDistance.getId()) {
                                if (id == Setting1Controller.this.etLimitHeight.getId()) {
                                    DDLog.m1685e("inputFinishListener", "高度限制：" + i);
                                    if (PhoneConfig.isFt || Setting1Controller.this.limitHeightSeekbar.getValue() == i) {
                                        return;
                                    }
                                    Setting1Controller.this.limitHeightSeekbar.setValue(i);
                                    return;
                                }
                                return;
                            }
                            DDLog.m1685e("inputFinishListener", "距离限制：" + i);
                            if (PhoneConfig.isFt || Setting1Controller.this.limitDistanceSeekbar.getValue() == i) {
                                return;
                            }
                            Setting1Controller.this.limitDistanceSeekbar.setValue(i);
                            return;
                        }
                        DDLog.m1685e("inputFinishListener", "返航高度：" + i);
                        if (PhoneConfig.isFt || Setting1Controller.this.returnHeightSeekbar.getValue() == i) {
                            return;
                        }
                        Setting1Controller.this.returnHeightSeekbar.setValue(i);
                        return;
                    }
                    if (PhoneConfig.isFt || Setting1Controller.this.speedSeekBar.getValue() == i) {
                        return;
                    }
                    Setting1Controller.this.speedSeekBar.setValue(i);
                    return;
                }
                if (PhoneConfig.isFt || Setting1Controller.this.radiusSeekBar.getValue() == i) {
                    return;
                }
                Setting1Controller.this.radiusSeekBar.setValue(i);
            }
        };
        this.seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.ipotensic.kernel.controllers.settings.Setting1Controller.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                int id = seekBar.getId();
                if (id == Setting1Controller.this.returnHeightSeekbar.getId()) {
                    int value = Setting1Controller.this.returnHeightSeekbar.getValue();
                    DDLog.m1685e("onProgressChanged", "设置返航高度:" + value);
                    if (PhoneConfig.isFt) {
                        Setting1Controller.this.etReturnHeight.setText(FlightConfig.get_value(value) + "");
                    } else {
                        Setting1Controller.this.etReturnHeight.setText(value + "");
                    }
                    FlightSendData.get().getSendFlightSetData().setReturnHeight(value);
                    int value2 = Setting1Controller.this.limitHeightSeekbar.getValue();
                    if (value > value2) {
                        Setting1Controller.this.limitHeightSeekbar.setValue(value);
                        DDLog.m1685e("onProgressChanged", "返航高度大于限高，之前的限高=" + value2);
                        return;
                    }
                    return;
                }
                if (id == Setting1Controller.this.limitDistanceSeekbar.getId()) {
                    int value3 = Setting1Controller.this.limitDistanceSeekbar.getValue();
                    DDLog.m1685e("onProgressChanged", "设置距离限制：" + value3);
                    if (PhoneConfig.isFt) {
                        Setting1Controller.this.etLimitDistance.setText(FlightConfig.get_value(value3) + "");
                    } else {
                        Setting1Controller.this.etLimitDistance.setText(value3 + "");
                    }
                    FlightSendData.get().getSendFlightSetData().setDistanceLimit(value3);
                    return;
                }
                if (id == Setting1Controller.this.limitHeightSeekbar.getId()) {
                    int value4 = Setting1Controller.this.limitHeightSeekbar.getValue();
                    DDLog.m1685e("onProgressChanged", "设置高度限制：" + value4);
                    if (PhoneConfig.isFt) {
                        Setting1Controller.this.etLimitHeight.setText(FlightConfig.get_value(value4) + "");
                    } else {
                        Setting1Controller.this.etLimitHeight.setText(value4 + "");
                    }
                    FlightSendData.get().getSendFlightSetData().setHeightLimit(value4);
                    int value5 = Setting1Controller.this.returnHeightSeekbar.getValue();
                    if (value4 < value5) {
                        Setting1Controller.this.returnHeightSeekbar.setValue(value4);
                        DDLog.m1685e("onProgressChanged", "限高小于返航高度，之前的返航高度=" + value5);
                        if (SPHelper.getInstance().isRthGuideVideoShown()) {
                            return;
                        }
                        Setting1Controller.this.showReturnHeightVideo();
                        return;
                    }
                    return;
                }
                if (id == Setting1Controller.this.radiusSeekBar.getId()) {
                    int value6 = Setting1Controller.this.radiusSeekBar.getValue();
                    if (PhoneConfig.isFt) {
                        Setting1Controller.this.etRadius.setText(FlightConfig.get_value(value6) + "");
                    } else {
                        Setting1Controller.this.etRadius.setText(value6 + "");
                    }
                    FlightSendData.get().getSendFlightSetData().setSurroundRadius((short) value6);
                    return;
                }
                if (id == Setting1Controller.this.speedSeekBar.getId()) {
                    int value7 = Setting1Controller.this.speedSeekBar.getValue();
                    if (PhoneConfig.isFt) {
                        Setting1Controller.this.etSpeed.setText(FlightConfig.get_speed_value(value7) + "");
                    } else {
                        Setting1Controller.this.etSpeed.setText(value7 + "");
                    }
                    FlightSendData.get().getSendFlightSetData().setSurroundSpeed((short) value7);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (seekBar.getId() != Setting1Controller.this.limitHeightSeekbar.getId()) {
                    if (seekBar.getId() != Setting1Controller.this.returnHeightSeekbar.getId() || SPHelper.getInstance().isRthGuideVideoShown()) {
                        return;
                    }
                    Setting1Controller.this.showReturnHeightVideo();
                    return;
                }
                Setting1Controller setting1Controller = Setting1Controller.this;
                setting1Controller.lastTrackValue = setting1Controller.limitHeightSeekbar.getValue();
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (seekBar.getId() == Setting1Controller.this.limitHeightSeekbar.getId()) {
                    int value = Setting1Controller.this.limitHeightSeekbar.getValue();
                    if (Setting1Controller.this.lastTrackValue > 120 || value <= 120) {
                        return;
                    }
                    Setting1Controller.this.showOver120Dialog();
                }
            }
        };
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.ipotensic.kernel.controllers.settings.Setting1Controller.4
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 0) {
                    Setting1Controller.this.hideCloseNewHandModeDialog();
                }
            }
        };
        this.sportSeedTooFastRunnable = new Runnable() { // from class: com.ipotensic.kernel.controllers.settings.Setting1Controller.5
            @Override // java.lang.Runnable
            public void run() {
                Setting1Controller.this.tvSportSpeedTooFast.setVisibility(8);
            }
        };
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.tvCodeTitle = (TextView) view.findViewById(C1965R.id.tv_code_title);
        this.tvReturnHeightUnit = (TextView) view.findViewById(C1965R.id.tv_unit_return_height);
        this.tvHeightUnit = (TextView) view.findViewById(C1965R.id.tv_unit_height);
        this.tvDistanceUnit = (TextView) view.findViewById(C1965R.id.tv_unit_distance);
        this.tvCircleRadiusUnit = (TextView) view.findViewById(C1965R.id.tv_unit_circle_radius);
        this.tvCircleSpeedUnit = (TextView) view.findViewById(C1965R.id.tv_unit_circle_speed);
        this.radiusSeekBar = (CustomSeekbar) view.findViewById(C1965R.id.seekBar_radius);
        this.speedSeekBar = (CustomSeekbar) view.findViewById(C1965R.id.seekBar_speed);
        this.etRadius = (CursorEditText) view.findViewById(C1965R.id.tv_radius);
        this.etSpeed = (CursorEditText) view.findViewById(C1965R.id.edt_speed);
        this.layoutCircle = (ConstraintLayout) view.findViewById(C1965R.id.layout_circle);
        this.etReturnHeight = (CursorEditText) view.findViewById(C1965R.id.et_return_height_value);
        this.sbNewMode = (SwitchButton) view.findViewById(C1965R.id.slideBtn_new_mode);
        this.ivBack = (ImageView) view.findViewById(C1965R.id.iv_back);
        this.ivLeft = (ImageButton) view.findViewById(C1965R.id.iv_left);
        this.ivRight = (ImageButton) view.findViewById(C1965R.id.iv_right);
        this.tvFlightTips = (TextView) view.findViewById(C1965R.id.tv_flight_tips);
        this.layoutSpeedSetting = (RelativeLayout) view.findViewById(C1965R.id.layout_speed_setting);
        this.tvSportSpeedTooFast = (TextView) view.findViewById(C1965R.id.tv_speed_change);
        this.tvRadiusTitle = (TextView) view.findViewById(C1965R.id.tv_radius_tips);
        this.tvSpeedTitle = (TextView) view.findViewById(C1965R.id.tv_speed_tips);
        this.tvGentlyLowMode = (TextView) view.findViewById(C1965R.id.tv_gently_mode);
        this.tvNormalMiddleMode = (TextView) view.findViewById(C1965R.id.tv_normal_mode);
        this.tvSportHighMode = (TextView) view.findViewById(C1965R.id.tv_sport_mode);
        this.layoutSpeedMode = (LinearLayout) view.findViewById(C1965R.id.layout_speed_mode);
        this.limitHeightSeekbar = (CustomSeekbar) view.findViewById(C1965R.id.seekBar_altitude);
        this.limitDistanceSeekbar = (CustomSeekbar) view.findViewById(C1965R.id.seekBar_distance);
        this.returnHeightSeekbar = (CustomSeekbar) view.findViewById(C1965R.id.seekBar_return_height);
        this.sbNoLimit = (SwitchButton) view.findViewById(C1965R.id.switch_btn_no_limit);
        this.tvHeightLimitTitle = (TextView) view.findViewById(C1965R.id.tv_fly_fence_altitide);
        this.tvDistanceLimitTitle = (TextView) view.findViewById(C1965R.id.tv_fly_fence_distance);
        this.tvReturnHeightTitle = (TextView) view.findViewById(C1965R.id.tv_return_height);
        this.etLimitHeight = (CursorEditText) view.findViewById(C1965R.id.tv_show_altitude_value);
        this.etLimitDistance = (CursorEditText) view.findViewById(C1965R.id.tv_show_distance_value);
        this.layoutFlyFence = (ConstraintLayout) view.findViewById(C1965R.id.layout_fly_fence_setting);
        this.layoutReturnHeight = (ConstraintLayout) view.findViewById(C1965R.id.layout_return_height_setting);
        this.layoutRthSetting = (LinearLayout) view.findViewById(C1965R.id.layout_return_height);
        this.tvReturnHeightSettingTitle = (TextView) view.findViewById(C1965R.id.tv_return_height_title);
        this.tvFlyFenceSettingTitle = (TextView) view.findViewById(C1965R.id.tv_fly_fence_title);
        this.etLimitDistance.setKeyboardListener(getContext(), view);
        this.etLimitHeight.setKeyboardListener(getContext(), view);
        this.etReturnHeight.setKeyboardListener(getContext(), view);
        this.etRadius.setKeyboardListener(getContext(), view);
        this.etReturnHeight.setKeyboardListener(getContext(), view);
        this.etSpeed.setKeyboardListener(getContext(), view);
        this.etLimitDistance.setInputFinishListener(this.inputFinishListener);
        this.etLimitHeight.setInputFinishListener(this.inputFinishListener);
        this.etReturnHeight.setInputFinishListener(this.inputFinishListener);
        this.etRadius.setInputFinishListener(this.inputFinishListener);
        this.etReturnHeight.setInputFinishListener(this.inputFinishListener);
        this.etSpeed.setInputFinishListener(this.inputFinishListener);
        initLimitUI();
        this.etLimitDistance.setSpecial(65535);
        this.ivBack.setOnClickListener(this);
        this.ivLeft.setOnClickListener(this);
        this.ivRight.setOnClickListener(this);
        this.sbNewMode.switchStateListener(this);
        this.sbNoLimit.switchStateListener(this);
        this.tvGentlyLowMode.setOnClickListener(this);
        this.tvNormalMiddleMode.setOnClickListener(this);
        this.tvSportHighMode.setOnClickListener(this);
        this.tvReturnHeightSettingTitle.setOnClickListener(this);
        this.returnHeightSeekbar.setOnSeekBarChangeListener(this.seekBarChangeListener);
        this.limitDistanceSeekbar.setOnSeekBarChangeListener(this.seekBarChangeListener);
        this.limitHeightSeekbar.setOnSeekBarChangeListener(this.seekBarChangeListener);
        this.radiusSeekBar.setOnSeekBarChangeListener(this.seekBarChangeListener);
        this.speedSeekBar.setOnSeekBarChangeListener(this.seekBarChangeListener);
        this.etLimitHeight.getViewTreeObserver().addOnGlobalLayoutListener(this.softInputListener);
        this.etReturnHeight.setOnTouchListener(new View.OnTouchListener() { // from class: com.ipotensic.kernel.controllers.settings.-$$Lambda$Setting1Controller$T8ajdbRoZJPqFUKxlEMCydkknI4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return Setting1Controller.this.lambda$initView$0$Setting1Controller(view2, motionEvent);
            }
        });
        if (FlightConfig.isConnectFlight()) {
            return;
        }
        setDistanceUI(FlightRevData.get().getFlightRevSettingData().isDistanceNoLimit(), false);
        setDefaultUI();
    }

    public /* synthetic */ boolean lambda$initView$0$Setting1Controller(View view, MotionEvent motionEvent) {
        if (SPHelper.getInstance().isRthGuideVideoShown() || motionEvent.getAction() != 0) {
            return false;
        }
        showReturnHeightVideo();
        return true;
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void setVisibility(int i) {
        super.setVisibility(i);
        if ((i == 0 || getBaseView() != null) && i == 0) {
            resetLayout();
        }
    }

    private void setSpeedModeEnable(boolean z) {
        if (z) {
            setSpeedUIEnable(false);
            return;
        }
        FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
        if (CommonUtil.hasNewVersion("1.0.9", FlightRevData.get().getFlightRevVersionData().getFlightControlVersion())) {
            DDLog.m1684e("speed mode: 1 :" + flightRevStateData.isOutdoor() + " , " + (flightRevStateData.getMode() != 1));
            setSpeedUIEnable(flightRevStateData.isOutdoor() || flightRevStateData.getMode() != 1);
        } else {
            DDLog.m1684e("speed mode: 2");
            setSpeedUIEnable(flightRevStateData.getMode() != 1);
        }
    }

    private void setSpeedUIEnable(boolean z) {
        DDLog.m1684e("speed mode: 3:" + z);
        this.layoutSpeedSetting.setAlpha(z ? 1.0f : 0.5f);
        this.tvGentlyLowMode.setEnabled(z);
        this.tvNormalMiddleMode.setEnabled(z);
        this.tvSportHighMode.setEnabled(z);
        this.tvGentlyLowMode.setClickable(z);
        this.tvNormalMiddleMode.setClickable(z);
        this.tvSportHighMode.setClickable(z);
    }

    public void updateData() {
        if (getBaseView() == null) {
            return;
        }
        setSpeedModeEnable(FlightRevData.get().getFlightRevSettingData().isNewerModeOpen());
        FlightRevSettingData flightRevSettingData = FlightRevData.get().getFlightRevSettingData();
        boolean isNewerModeOpen = flightRevSettingData.isNewerModeOpen();
        this.sbNewMode.setChecked(isNewerModeOpen);
        this.isFlight = FlightRevData.get().getFlightRevStateData().isFlight();
        setButtonEnable(isNewerModeOpen);
        int returnHeight = flightRevSettingData.getReturnHeight();
        if (returnHeight < this.returnHeightSeekbar.getLimitMin()) {
            returnHeight = this.returnHeightSeekbar.getLimitMin();
        }
        this.returnHeightSeekbar.setValue(returnHeight);
        int limitHeight = flightRevSettingData.getLimitHeight();
        if (limitHeight < this.limitHeightSeekbar.getLimitMin()) {
            limitHeight = this.limitHeightSeekbar.getLimitMin();
        }
        this.limitHeightSeekbar.setValue(limitHeight);
        int limitDistance = flightRevSettingData.getLimitDistance();
        if (limitDistance < this.limitDistanceSeekbar.getLimitMin()) {
            limitDistance = this.limitDistanceSeekbar.getLimitMin();
        }
        setDistanceUI(flightRevSettingData.isDistanceNoLimit(), false);
        DDLog.m1685e("updateData", "距离限制：" + this.limitDistanceSeekbar.getValue() + ",返航高度：" + this.returnHeightSeekbar.getValue() + ",高度限制：" + this.limitHeightSeekbar.getValue());
        DDLog.m1684e("设置 isNoLimit：" + (limitDistance == 65535));
        this.tvFlightTips.setVisibility(this.isFlight ? 0 : 4);
        int surroundRadius = flightRevSettingData.getSurroundRadius();
        if (surroundRadius < this.radiusSeekBar.getLimitMin()) {
            surroundRadius = this.radiusSeekBar.getLimitMin();
        }
        this.radiusSeekBar.setValue(surroundRadius);
        int surroundSpeed = flightRevSettingData.getSurroundSpeed();
        if (surroundSpeed < this.speedSeekBar.getLimitMin()) {
            surroundSpeed = this.speedSeekBar.getLimitMin();
        }
        this.speedSeekBar.setValue(surroundSpeed);
    }

    private void setEnableClick(boolean z) {
        boolean isHotCircle = FlightRevData.get().getFlightRevStateData().isHotCircle();
        this.etReturnHeight.setEnabled(z);
        this.etReturnHeight.setTextColor(z ? getContext().getResources().getColor(C1965R.color.colorGradientBlueStart) : getContext().getResources().getColor(C1965R.color.colorWhite));
        this.etReturnHeight.setAlpha(z ? 1.0f : 0.5f);
        this.etLimitHeight.setEnabled(z);
        this.etLimitHeight.setTextColor(z ? getContext().getResources().getColor(C1965R.color.colorGradientBlueStart) : getContext().getResources().getColor(C1965R.color.colorWhite));
        this.etLimitHeight.setAlpha(z ? 1.0f : 0.5f);
        this.etLimitDistance.setEnabled(z);
        this.etLimitDistance.setTextColor(z ? getContext().getResources().getColor(C1965R.color.colorGradientBlueStart) : getContext().getResources().getColor(C1965R.color.colorWhite));
        this.etLimitDistance.setAlpha(z ? 1.0f : 0.5f);
        this.etRadius.setEnabled(z);
        this.etRadius.setTextColor(z ? getContext().getResources().getColor(C1965R.color.colorGradientBlueStart) : getContext().getResources().getColor(C1965R.color.colorWhite));
        this.etRadius.setAlpha(z ? 1.0f : 0.5f);
        this.etSpeed.setEnabled(z);
        this.etSpeed.setTextColor(z ? getContext().getResources().getColor(C1965R.color.colorGradientBlueStart) : getContext().getResources().getColor(C1965R.color.colorWhite));
        this.etSpeed.setAlpha(z ? 1.0f : 0.5f);
        this.sbNoLimit.setViewEnable(z);
        ViewUtils.setViewEnableWithAlpha(this.returnHeightSeekbar, z);
        ViewUtils.setViewEnableWithAlpha(this.limitHeightSeekbar, z);
        ViewUtils.setViewEnableWithAlpha(this.limitDistanceSeekbar, z);
        ViewUtils.setViewEnableWithAlpha(this.radiusSeekBar, z && !isHotCircle);
        ViewUtils.setViewEnableWithAlpha(this.speedSeekBar, z && !isHotCircle);
        ViewUtils.setViewEnable(this.etRadius, z && !isHotCircle);
        ViewUtils.setViewEnable(this.etSpeed, z && !isHotCircle);
        ViewUtils.setViewEnableWithAlpha(this.layoutCircle, z && !isHotCircle);
        ViewUtils.setViewEnableWithAlpha(this.layoutReturnHeight, z);
        ViewUtils.setViewEnableWithAlpha(this.layoutFlyFence, z);
        this.tvGentlyLowMode.setEnabled(z);
        this.tvNormalMiddleMode.setEnabled(z);
        this.tvSportHighMode.setEnabled(z);
        this.ivRight.setEnabled(z && !isHotCircle);
        this.ivLeft.setEnabled(z && !isHotCircle);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C1965R.id.iv_back) {
            if (this.isSoftInputShow) {
                ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                return;
            } else {
                EventDispatcher.get().sendEvent(EventID.EVENT_UI_HIDE_FLIGHT_SETTING);
                return;
            }
        }
        if (id == C1965R.id.iv_left) {
            FlightSendData.get().getSendFlightSetData().setClockwise(false);
            this.ivLeft.setImageResource(C1965R.mipmap.icon_direction_left_selected);
            this.ivRight.setImageResource(C1965R.mipmap.icon_direction_right_disable);
            return;
        }
        if (id == C1965R.id.iv_right) {
            FlightSendData.get().getSendFlightSetData().setClockwise(true);
            this.ivLeft.setImageResource(C1965R.mipmap.icon_direction_left_disable);
            this.ivRight.setImageResource(C1965R.mipmap.icon_direction_right_selected);
            return;
        }
        if (id == C1965R.id.tv_gently_mode) {
            sendSpeedMode(0);
            return;
        }
        if (id == C1965R.id.tv_normal_mode) {
            sendSpeedMode(1);
            return;
        }
        if (id == C1965R.id.tv_sport_mode) {
            if (FlightConfig.isConnectFlight() && FlightRevData.get().getFlightRevFlightInfoData().getVerticalDistance() <= 8.0d) {
                if (PhoneConfig.isFt) {
                    ToastUtil.toast(getContext(), getContext().getResources().getString(C1965R.string.switch_sport_mode_tip, "26ft"));
                    return;
                } else {
                    ToastUtil.toast(getContext(), getContext().getResources().getString(C1965R.string.switch_sport_mode_tip, "8m"));
                    return;
                }
            }
            if (FlightConfig.isConnectFlight() && FlightRevData.get().getFlightRevFlightInfoData().getRemainedBattery() <= 30) {
                ToastUtil.toast(getContext(), getContext().getResources().getString(C1965R.string.low_power_quit_sport_mode));
                return;
            }
            sendSpeedMode(2);
            if (FlightConfig.isConnectFlight()) {
                AnimationUtil.transInTop(this.tvSportSpeedTooFast);
                this.tvSportSpeedTooFast.removeCallbacks(this.sportSeedTooFastRunnable);
                this.tvSportSpeedTooFast.postDelayed(this.sportSeedTooFastRunnable, 3000L);
                return;
            }
            return;
        }
        if (id == C1965R.id.tv_return_height_title) {
            showReturnHeightVideo();
        }
    }

    private void sendSpeedMode(int i) {
        if (FlightRevData.get().getFlightRevStateData().isReturning()) {
            ToastUtil.toast(getContext(), getContext().getString(C1965R.string.returning_switch_mode_unavailable));
            EventDispatcher.get().sendEvent(EventID.AUDIO_RETURNING_NOT_AVAILABLE);
        } else {
            setSpeedUI(i);
            FlightSendData.get().getSendFlightSetData().setSpeedMode(i);
        }
    }

    @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
    public void onStateChanged(View view, boolean z) {
        if (view.getId() == this.sbNoLimit.getId()) {
            setDistanceUI(z, true);
            if (z) {
                FlightSendData.get().getSendFlightSetData().setDistanceLimit(65535);
                return;
            }
            return;
        }
        if (view.getId() == this.sbNewMode.getId()) {
            setSpeedModeEnable(z);
            FlightSendData.get().getSendFlightSetData().setNewerMode(z);
            if (z) {
                CustomSeekbar customSeekbar = this.limitDistanceSeekbar;
                customSeekbar.setValue(customSeekbar.getDefaultValue());
                CustomSeekbar customSeekbar2 = this.returnHeightSeekbar;
                customSeekbar2.setValue(customSeekbar2.getDefaultValue());
                CustomSeekbar customSeekbar3 = this.limitHeightSeekbar;
                customSeekbar3.setValue(customSeekbar3.getDefaultValue());
                DDLog.m1685e("onStateChanged", "距离限制：" + this.limitDistanceSeekbar.getDefaultValue() + ",返航高度：" + this.returnHeightSeekbar.getDefaultValue() + ",高度限制：" + this.limitHeightSeekbar.getDefaultValue());
                this.sbNoLimit.setChecked(false);
                setDistanceUI(false, true);
                CustomSeekbar customSeekbar4 = this.radiusSeekBar;
                customSeekbar4.setValue(customSeekbar4.getDefaultValue());
                CustomSeekbar customSeekbar5 = this.speedSeekBar;
                customSeekbar5.setValue(customSeekbar5.getDefaultValue());
                setSpeedUI(0);
                FlightSendData.get().getSendFlightSetData().setSpeedMode(0);
            } else if (FlightConfig.isConnectFlight()) {
                this.limitHeightSeekbar.setValue(FlightRevData.get().getFlightRevSettingData().getLimitHeight());
                this.returnHeightSeekbar.setValue(FlightRevData.get().getFlightRevSettingData().getReturnHeight());
                if (FlightRevData.get().getFlightRevSettingData().isDistanceNoLimit()) {
                    this.sbNoLimit.setChecked(true);
                    setDistanceUI(true, false);
                } else {
                    this.limitDistanceSeekbar.setValue(FlightRevData.get().getFlightRevSettingData().getLimitDistance());
                }
                DDLog.m1685e("onStateChanged", "距离限制：" + this.limitDistanceSeekbar.getValue() + ",返航高度：" + this.returnHeightSeekbar.getValue() + ",高度限制：" + this.limitHeightSeekbar.getValue());
                this.radiusSeekBar.setValue(FlightRevData.get().getFlightRevSettingData().getSurroundRadius());
                this.speedSeekBar.setValue(FlightRevData.get().getFlightRevSettingData().getSurroundSpeed());
                if (this.layoutRthSetting.getVisibility() == 0 && this.isFromUser) {
                    showCloseNewHandModeDialog();
                    setLimitData();
                }
            }
            this.ivLeft.setImageResource(C1965R.mipmap.icon_direction_left_disable);
            this.ivRight.setImageResource(C1965R.mipmap.icon_direction_right_selected_disable);
            FlightSendData.get().getSendFlightSetData().setClockwise(true);
            setButtonEnable(z);
        }
    }

    public void setLimitData() {
        this.returnHeightSeekbar.setValue(60);
        this.limitHeightSeekbar.setValue(60);
        this.limitDistanceSeekbar.setValue(500);
    }

    private void showCloseNewHandModeDialog() {
        GeneralOneButtonDialog confirmStr = new GeneralOneButtonDialog(getContext()).setTitleId(C1965R.string.settings_safety_exit_beginner_mode_title).setContent(getContext().getString(C1965R.string.settings_safety_exit_beginner_mode_tips)).setConfirmStr(C1965R.string.txt_guide_map_know);
        this.closeNewHandModeDialog = confirmStr;
        confirmStr.show();
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, 15000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCloseNewHandModeDialog() {
        GeneralOneButtonDialog generalOneButtonDialog = this.closeNewHandModeDialog;
        if (generalOneButtonDialog == null || !generalOneButtonDialog.isShowing()) {
            return;
        }
        this.closeNewHandModeDialog.dismiss();
        this.closeNewHandModeDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showReturnHeightVideo() {
        if (FlightConfig.isConnectFlight()) {
            GeneralDialog generalDialog = this.returnHeightVideoDialog;
            if (generalDialog == null || !generalDialog.isShowing()) {
                GeneralDialog generalDialog2 = new GeneralDialog(getContext(), C1965R.raw.video_rth_guide);
                this.returnHeightVideoDialog = generalDialog2;
                generalDialog2.show();
            }
        }
    }

    public void hideReturnHeightVideoDialog() {
        GeneralDialog generalDialog = this.returnHeightVideoDialog;
        if (generalDialog == null || !generalDialog.isShowing()) {
            return;
        }
        this.returnHeightVideoDialog.dismiss();
    }

    public void dismiss() {
        TextView textView = this.tvSportSpeedTooFast;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.tvFlightTips;
        if (textView2 != null) {
            textView2.setVisibility(4);
        }
        if (FlightConfig.isConnectFlight()) {
            return;
        }
        setDefaultUI();
        hideReturnHeightVideoDialog();
    }

    private void setDefaultUI() {
        this.isFromUser = false;
        this.sbNewMode.setChecked(false);
        onStateChanged((View) this.sbNewMode, false);
        this.isFromUser = true;
        CustomSeekbar customSeekbar = this.limitHeightSeekbar;
        customSeekbar.setValue(customSeekbar.getDefaultValue());
        CustomSeekbar customSeekbar2 = this.returnHeightSeekbar;
        customSeekbar2.setValue(customSeekbar2.getDefaultValue());
        CustomSeekbar customSeekbar3 = this.limitDistanceSeekbar;
        customSeekbar3.setValue(customSeekbar3.getDefaultValue());
        DDLog.m1685e("setDefaultUI", "距离限制：" + this.limitDistanceSeekbar.getValue() + ",返航高度：" + this.returnHeightSeekbar.getValue() + ",高度限制：" + this.limitHeightSeekbar.getValue());
        CustomSeekbar customSeekbar4 = this.radiusSeekBar;
        customSeekbar4.setValue(customSeekbar4.getDefaultValue());
        CustomSeekbar customSeekbar5 = this.speedSeekBar;
        customSeekbar5.setValue(customSeekbar5.getDefaultValue());
        setSpeedUI(0);
        this.ivLeft.setImageResource(C1965R.mipmap.icon_direction_left_disable);
        this.ivRight.setImageResource(C1965R.mipmap.icon_direction_right_selected);
    }

    private void setButtonEnable(boolean z) {
        String flight_control;
        String flightControlVersion = FlightRevData.get().getFlightRevVersionData().getFlightControlVersion();
        if (this.isFlight) {
            Set<String> registerFirmwareInfo = SPHelper.getInstance().getRegisterFirmwareInfo();
            if (registerFirmwareInfo != null) {
                Iterator<String> it = registerFirmwareInfo.iterator();
                while (it.hasNext()) {
                    FlightFirmwareChecker.RegisterVersion registerVersion = (FlightFirmwareChecker.RegisterVersion) JSONObject.parseObject(it.next(), FlightFirmwareChecker.RegisterVersion.class);
                    if (registerVersion != null && registerVersion.getClassname().equalsIgnoreCase(FlightConfig.getLastProductClass()) && ((flight_control = registerVersion.getFlight_control()) == null || CommonUtil.hasNewVersion(flightControlVersion, flight_control))) {
                        setEnableClick(false);
                        this.sbNewMode.setViewEnable(false);
                        return;
                    }
                }
            }
            setEnableClick(!z);
            this.sbNewMode.setViewEnable(true);
            return;
        }
        setEnableClick(!z);
        this.sbNewMode.setViewEnable(true);
    }

    public void setSpeedUI(int i) {
        if (this.layoutSpeedSetting != null) {
            this.tvGentlyLowMode.setTextColor(getContext().getResources().getColor(i == 0 ? C1965R.color.white : C1965R.color.color_white_seventy_percent));
            this.tvGentlyLowMode.setBackgroundColor(getContext().getResources().getColor(i == 0 ? C1965R.color.colorFormatSdCard : C1965R.color.colorTransparent));
            this.tvNormalMiddleMode.setTextColor(getContext().getResources().getColor(i == 1 ? C1965R.color.white : C1965R.color.color_white_seventy_percent));
            this.tvNormalMiddleMode.setBackgroundColor(getContext().getResources().getColor(i == 1 ? C1965R.color.colorFormatSdCard : C1965R.color.colorTransparent));
            this.tvSportHighMode.setTextColor(getContext().getResources().getColor(i == 2 ? C1965R.color.white : C1965R.color.color_white_seventy_percent));
            this.tvSportHighMode.setBackgroundColor(getContext().getResources().getColor(i == 2 ? C1965R.color.colorFormatSdCard : C1965R.color.colorTransparent));
        }
    }

    /* renamed from: com.ipotensic.kernel.controllers.settings.Setting1Controller$7 */
    static /* synthetic */ class C22847 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_RECEIVE_STATE_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_SETTING_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_UNIT_CHANGED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_TYPE_DEFINED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        int i = C22847.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (((FlightRevSettingData) event.obj) != null) {
                    updateData();
                    return;
                }
                return;
            } else {
                if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                    initLimitUI();
                    resetLayout();
                    return;
                }
                initLimitUI();
                if (FlightConfig.isConnectFlight()) {
                    updateData();
                    return;
                } else {
                    setDefaultUI();
                    return;
                }
            }
        }
        FlightRevStateData flightRevStateData = (FlightRevStateData) event.obj;
        if (flightRevStateData != null) {
            if (this.stateData.getSpeedMode() != flightRevStateData.getSpeedMode()) {
                if (flightRevStateData.getSpeedMode() != -1) {
                    setSpeedUI(flightRevStateData.getSpeedMode());
                }
                try {
                    this.stateData = flightRevStateData.m2625clone();
                } catch (Exception e) {
                    DDLog.m1684e("复制出错:" + e.getMessage());
                }
            }
            if (flightRevStateData.isReturning()) {
                this.tvReturnHeightSettingTitle.setText(getContext().getString(C1965R.string.txt_flight_lowest_return_height) + StringUtils.SPACE + getContext().getString(C1965R.string.txt_return_not_available));
                this.tvFlyFenceSettingTitle.setText(getContext().getString(C1965R.string.txt_fly_fence) + StringUtils.SPACE + getContext().getString(C1965R.string.txt_return_not_available));
                this.sbNewMode.setViewEnable(false);
                ViewUtils.setViewEnableWithAlpha(this.layoutReturnHeight, false);
                ViewUtils.setViewEnableWithAlpha(this.layoutFlyFence, false);
                ViewUtils.setViewEnableWithAlpha(this.returnHeightSeekbar, false);
                ViewUtils.setViewEnableWithAlpha(this.limitHeightSeekbar, false);
                ViewUtils.setViewEnableWithAlpha(this.limitDistanceSeekbar, false);
                return;
            }
            this.tvReturnHeightSettingTitle.setText(getContext().getString(C1965R.string.txt_flight_lowest_return_height));
            this.tvFlyFenceSettingTitle.setText(getContext().getString(C1965R.string.txt_fly_fence));
            setButtonEnable(this.sbNewMode.isChecked());
            ViewUtils.setViewEnableWithAlpha(this.layoutReturnHeight, !this.sbNewMode.isChecked());
            ViewUtils.setViewEnableWithAlpha(this.layoutFlyFence, !this.sbNewMode.isChecked());
            ViewUtils.setViewEnableWithAlpha(this.returnHeightSeekbar, !this.sbNewMode.isChecked());
            ViewUtils.setViewEnableWithAlpha(this.limitHeightSeekbar, !this.sbNewMode.isChecked());
            ViewUtils.setViewEnableWithAlpha(this.limitDistanceSeekbar, !this.sbNewMode.isChecked());
        }
    }

    private void resetLayout() {
        boolean is_Atom_Series = FlightConfig.is_Atom_Series();
        this.layoutSpeedMode.setVisibility(is_Atom_Series ? 0 : 8);
        FlightRevVersionData flightRevVersionData = FlightRevData.get().getFlightRevVersionData();
        if (is_Atom_Series && flightRevVersionData.getFlightControlVersion() != null && CommonUtil.hasNewVersion("1.7.0", flightRevVersionData.getFlightControlVersion())) {
            this.layoutRthSetting.setVisibility(0);
        } else {
            this.layoutRthSetting.setVisibility(8);
        }
    }

    private void setDistanceUI(boolean z, boolean z2) {
        this.etLimitDistance.getPaint().setFakeBoldText(z);
        this.etLimitDistance.setEnabled(!z);
        if (z) {
            return;
        }
        this.etLimitDistance.setTextSize(2, 12.0f);
        DDLog.m1684e("设置距离06");
        this.limitDistanceSeekbar.setValue(FlightRevData.get().getFlightRevSettingData().getLimitDistance());
        if (z2) {
            CustomSeekbar customSeekbar = this.limitDistanceSeekbar;
            customSeekbar.setValue(customSeekbar.getDefaultValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showOver120Dialog() {
        new GeneralDialog(getContext(), getContext().getString(C1965R.string.txt_disclaimer), getContext().getString(C1965R.string.txt_disclaimer_content), getContext().getString(C1965R.string.dialog_cancel), getContext().getString(C1965R.string.user_agree), new OnResultListener<Boolean>() { // from class: com.ipotensic.kernel.controllers.settings.Setting1Controller.6
            @Override // com.ipotensic.baselib.okhttp.OnResultListener
            public void onFailed(Exception exc) {
            }

            @Override // com.ipotensic.baselib.okhttp.OnResultListener
            public void onSuccess(Boolean bool) {
                FlightRevSettingData flightRevSettingData;
                if (bool.booleanValue() || (flightRevSettingData = FlightRevData.get().getFlightRevSettingData()) == null) {
                    return;
                }
                Setting1Controller.this.limitHeightSeekbar.setValue(flightRevSettingData.getLimitHeight());
            }
        }).show();
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onPause() {
        super.onPause();
        GeneralDialog generalDialog = this.returnHeightVideoDialog;
        if (generalDialog != null) {
            generalDialog.onPauseVideo();
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        super.onDestroy();
        hideReturnHeightVideoDialog();
    }
}