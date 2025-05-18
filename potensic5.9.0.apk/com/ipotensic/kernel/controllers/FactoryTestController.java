package com.ipotensic.kernel.controllers;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.enums.PackageType;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.controllers.TestGpsProductionController;
import com.ipotensic.kernel.view.CommonSwitchView;
import com.ipotensic.kernel.view.CommonTitleView;

/* loaded from: classes2.dex */
public class FactoryTestController extends BaseController implements CommonSwitchView.OnSwitchChangeListener {
    private CommonSwitchView viewCameraTest;
    private CommonSwitchView viewFactoryTest;
    private CommonSwitchView viewFpvTest;
    private CommonSwitchView viewGpsLocation;
    private CommonSwitchView viewGpsSignalTest;
    private CommonSwitchView viewImuCal;
    private CommonSwitchView viewMaintainTest;
    private CommonSwitchView viewOfficeTest;
    private CommonSwitchView viewOpenGpsTest;
    private CommonSwitchView viewOpenModelTest;

    @Override // com.ipotensic.kernel.view.CommonSwitchView.OnSwitchChangeListener
    public void onDisableClick(View view) {
    }

    public FactoryTestController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.viewFactoryTest = (CommonSwitchView) view.findViewById(C1965R.id.view_factory_test);
        this.viewOfficeTest = (CommonSwitchView) view.findViewById(C1965R.id.view_office_test);
        this.viewCameraTest = (CommonSwitchView) view.findViewById(C1965R.id.view_camera_test);
        this.viewMaintainTest = (CommonSwitchView) view.findViewById(C1965R.id.view_maintain_test);
        this.viewOpenModelTest = (CommonSwitchView) view.findViewById(C1965R.id.view_open_model_test);
        this.viewOpenGpsTest = (CommonSwitchView) view.findViewById(C1965R.id.view_open_gps_test);
        this.viewImuCal = (CommonSwitchView) view.findViewById(C1965R.id.view_imu_cal);
        this.viewGpsLocation = (CommonSwitchView) view.findViewById(C1965R.id.view_location_test);
        this.viewFpvTest = (CommonSwitchView) view.findViewById(C1965R.id.view_fpv_test);
        this.viewGpsSignalTest = (CommonSwitchView) view.findViewById(C1965R.id.view_gps_signal_test);
        ((CommonTitleView) view.findViewById(C1965R.id.view_title)).setListener(new CommonTitleView.OnClickListener() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$FactoryTestController$KD6tq7WNsYp6vNiNj7hGLyjT2gE
            @Override // com.ipotensic.kernel.view.CommonTitleView.OnClickListener
            public final void onRightClick(View view2) {
                FactoryTestController.this.lambda$initView$0$FactoryTestController(view2);
            }
        });
        this.viewFactoryTest.setListener(this);
        this.viewOfficeTest.setListener(this);
        this.viewCameraTest.setListener(this);
        this.viewMaintainTest.setListener(this);
        this.viewOpenModelTest.setListener(this);
        this.viewOpenGpsTest.setListener(this);
        this.viewImuCal.setListener(this);
        this.viewGpsLocation.setListener(this);
        this.viewFpvTest.setListener(this);
        this.viewGpsSignalTest.setListener(this);
        switch (C21281.$SwitchMap$com$ipotensic$baselib$enums$PackageType[PhoneConfig.PACK_TYPE.ordinal()]) {
            case 1:
                this.viewCameraTest.check(true);
                break;
            case 2:
                this.viewFactoryTest.check(true);
                break;
            case 3:
                this.viewOfficeTest.check(true);
                break;
            case 4:
                this.viewMaintainTest.check(true);
                break;
            case 5:
                this.viewOpenModelTest.check(true);
                break;
            case 6:
                this.viewOpenGpsTest.check(true);
                break;
            case 7:
                this.viewImuCal.check(true);
                break;
            case 8:
                this.viewGpsLocation.check(true);
                break;
            case 9:
                this.viewFpvTest.check(true);
                break;
            case 10:
                this.viewGpsSignalTest.check(true);
                break;
        }
    }

    public /* synthetic */ void lambda$initView$0$FactoryTestController(View view) {
        setVisibility(8);
    }

    @Override // com.ipotensic.kernel.view.CommonSwitchView.OnSwitchChangeListener
    public void onCheckedChanged(View view, boolean z) {
        if (view.getId() == C1965R.id.view_factory_test) {
            if (z) {
                checkedChange(this.viewFactoryTest);
            }
            factoryModeTest(z);
            return;
        }
        if (view.getId() == C1965R.id.view_office_test) {
            if (z) {
                checkedChange(this.viewOfficeTest);
            }
            officeModeTest(z);
            return;
        }
        if (view.getId() == C1965R.id.view_camera_test) {
            if (z) {
                checkedChange(this.viewCameraTest);
            }
            cameraModeTest(z);
            return;
        }
        if (view.getId() == C1965R.id.view_maintain_test) {
            if (z) {
                checkedChange(this.viewMaintainTest);
            }
            maintainModeTest(z);
            return;
        }
        if (view.getId() == C1965R.id.view_open_model_test) {
            if (z) {
                checkedChange(this.viewOpenModelTest);
            }
            openModelTest(z);
            return;
        }
        if (view.getId() == C1965R.id.view_imu_cal) {
            if (z) {
                checkedChange(this.viewImuCal);
            }
            openImuCalTest(z);
            return;
        }
        if (view.getId() == C1965R.id.view_location_test) {
            if (z) {
                checkedChange(this.viewGpsLocation);
            }
            openGpsLocationTest(z);
        } else if (view.getId() == C1965R.id.view_fpv_test) {
            if (z) {
                checkedChange(this.viewFpvTest);
            }
            openFpvTest(z);
        } else if (view.getId() == C1965R.id.view_gps_signal_test) {
            if (z) {
                checkedChange(this.viewGpsSignalTest);
            }
            openGpsSignalTest(z);
        }
    }

    private void checkedChange(CommonSwitchView commonSwitchView) {
        this.viewOfficeTest.check(false);
        this.viewFactoryTest.check(false);
        this.viewCameraTest.check(false);
        this.viewMaintainTest.check(false);
        this.viewOpenModelTest.check(false);
        this.viewOpenGpsTest.check(false);
        this.viewImuCal.check(false);
        this.viewGpsLocation.check(false);
        this.viewFpvTest.check(false);
        this.viewGpsSignalTest.check(false);
        commonSwitchView.check(true);
    }

    public void factoryModeTest(boolean z) {
        PhoneConfig.PACK_TYPE = z ? PackageType.TYPE_FACTORY : PackageType.TYPE_RELEASE;
        setTestView();
    }

    public void officeModeTest(boolean z) {
        PhoneConfig.PACK_TYPE = z ? PackageType.TYPE_TESTER : PackageType.TYPE_RELEASE;
        setTestView();
    }

    public void cameraModeTest(boolean z) {
        PhoneConfig.PACK_TYPE = z ? PackageType.TYPE_CAMERA : PackageType.TYPE_RELEASE;
        setTestView();
    }

    public void maintainModeTest(boolean z) {
        PhoneConfig.PACK_TYPE = z ? PackageType.TYPE_MAINTAIN : PackageType.TYPE_RELEASE;
        setTestView();
    }

    public void openModelTest(boolean z) {
        PhoneConfig.PACK_TYPE = z ? PackageType.TYPE_MODEL : PackageType.TYPE_RELEASE;
        setTestView();
    }

    public void openGpsTest(boolean z) {
        PhoneConfig.PACK_TYPE = z ? PackageType.TYPE_GPS : PackageType.TYPE_RELEASE;
        setTestView();
    }

    public void openImuCalTest(boolean z) {
        PhoneConfig.PACK_TYPE = z ? PackageType.TYPE_IMU_CAL : PackageType.TYPE_RELEASE;
        setTestView();
    }

    public void openGpsLocationTest(boolean z) {
        PhoneConfig.PACK_TYPE = z ? PackageType.TYPE_LOCATION : PackageType.TYPE_RELEASE;
        setTestView();
    }

    public void openFpvTest(boolean z) {
        PhoneConfig.PACK_TYPE = z ? PackageType.TYPE_FPV : PackageType.TYPE_RELEASE;
        setTestView();
    }

    public void openGpsSignalTest(boolean z) {
        PhoneConfig.PACK_TYPE = z ? PackageType.TYPE_GPS_SIGNAL : PackageType.TYPE_RELEASE;
        setTestView();
    }

    private void setTestView() {
        TestGpsProductionController.TestType testType;
        TesterController testerController = (TesterController) EventDispatcher.get().getController(TesterController.class);
        if (testerController != null) {
            testerController.setVisibility(PhoneConfig.PACK_TYPE == PackageType.TYPE_TESTER ? 0 : 8);
        }
        TestFactoryController testFactoryController = (TestFactoryController) EventDispatcher.get().getController(TestFactoryController.class);
        if (testFactoryController != null) {
            testFactoryController.setVisibility(PhoneConfig.PACK_TYPE == PackageType.TYPE_FACTORY ? 0 : 8);
        }
        TestCameraController testCameraController = (TestCameraController) EventDispatcher.get().getController(TestCameraController.class);
        if (testCameraController != null) {
            testCameraController.setVisibility(PhoneConfig.PACK_TYPE == PackageType.TYPE_CAMERA ? 0 : 8);
        }
        TestMaintainController testMaintainController = (TestMaintainController) EventDispatcher.get().getController(TestMaintainController.class);
        if (testMaintainController != null) {
            testMaintainController.setVisibility(PhoneConfig.PACK_TYPE == PackageType.TYPE_MAINTAIN ? 0 : 8);
        }
        TestGpsProductionController testGpsProductionController = (TestGpsProductionController) EventDispatcher.get().getController(TestGpsProductionController.class);
        if (testGpsProductionController != null) {
            if (PhoneConfig.PACK_TYPE == PackageType.TYPE_MODEL) {
                testType = TestGpsProductionController.TestType.TYPE_MODEL;
            } else if (PhoneConfig.PACK_TYPE == PackageType.TYPE_GPS) {
                testType = TestGpsProductionController.TestType.TYPE_TEST;
            } else {
                testType = TestGpsProductionController.TestType.TYPE_NONE;
            }
            testGpsProductionController.setGpsTestType(testType);
        }
        TestSixImuCalibrationController testSixImuCalibrationController = (TestSixImuCalibrationController) EventDispatcher.get().getController(TestSixImuCalibrationController.class);
        if (testSixImuCalibrationController != null) {
            testSixImuCalibrationController.setVisibility(PhoneConfig.PACK_TYPE == PackageType.TYPE_IMU_CAL ? 0 : 8);
        }
        TestLocationController testLocationController = (TestLocationController) EventDispatcher.get().getController(TestLocationController.class);
        if (testLocationController != null) {
            testLocationController.show(PhoneConfig.PACK_TYPE == PackageType.TYPE_LOCATION);
        }
        TestFpvController testFpvController = (TestFpvController) EventDispatcher.get().getController(TestFpvController.class);
        if (testFpvController != null) {
            testFpvController.setVisibility(PhoneConfig.PACK_TYPE == PackageType.TYPE_FPV ? 0 : 8);
        }
        TestGpsSignalController testGpsSignalController = (TestGpsSignalController) EventDispatcher.get().getController(TestGpsSignalController.class);
        if (testGpsSignalController != null) {
            testGpsSignalController.setVisibility(PhoneConfig.PACK_TYPE == PackageType.TYPE_GPS_SIGNAL ? 0 : 8);
        }
    }

    /* renamed from: com.ipotensic.kernel.controllers.FactoryTestController$1 */
    static /* synthetic */ class C21281 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$enums$PackageType;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.EVENT_HIDE_IMU_CAL_TEST_CONTROLLER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[PackageType.values().length];
            $SwitchMap$com$ipotensic$baselib$enums$PackageType = iArr2;
            try {
                iArr2[PackageType.TYPE_CAMERA.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$PackageType[PackageType.TYPE_FACTORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$PackageType[PackageType.TYPE_TESTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$PackageType[PackageType.TYPE_MAINTAIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$PackageType[PackageType.TYPE_MODEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$PackageType[PackageType.TYPE_GPS.ordinal()] = 6;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$PackageType[PackageType.TYPE_IMU_CAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$PackageType[PackageType.TYPE_LOCATION.ordinal()] = 8;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$PackageType[PackageType.TYPE_FPV.ordinal()] = 9;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$PackageType[PackageType.TYPE_GPS_SIGNAL.ordinal()] = 10;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        if (C21281.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()] != 1) {
            return;
        }
        this.viewImuCal.check(false);
        openImuCalTest(false);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        super.onDestroy();
        PhoneConfig.PACK_TYPE = PackageType.TYPE_RELEASE;
    }
}