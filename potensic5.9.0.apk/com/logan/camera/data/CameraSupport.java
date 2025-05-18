package com.logan.camera.data;

import android.text.TextUtils;
import com.baidu.geofence.GeoFence;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.kernel.view.ResolutionAndFpsSelectView;
import com.logan.camera.CameraConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class CameraSupport extends BaseData {
    private static final String TAG = "CameraSupport";
    private SupportType supportType;
    private List<CameraSetBean> supportList = new ArrayList();
    private String currentValue = null;
    private int currentValueForUsb = -1;

    public enum SupportType {
        TYPE_VIDEO_SIZE,
        TYPE_PHOTO_SIZE,
        TYPE_SPLIT_VIDEO
    }

    private String listToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.supportList.size(); i++) {
            sb.append(this.supportList.get(i).toString() + "\n");
        }
        return sb.toString();
    }

    public String toString() {
        return "CameraSupport{supportList=" + listToString() + ", currentValue='" + this.currentValue + "', currentValueForUsb=" + this.currentValueForUsb + ", supportType=" + this.supportType + '}';
    }

    public int getCurrentIndexForUsb() {
        for (int i = 0; i < this.supportList.size(); i++) {
            if (this.supportList.get(i).getShowString().equals(this.currentValue)) {
                return i;
            }
        }
        return 0;
    }

    public CameraSupport(SupportType supportType) {
        this.supportType = supportType;
    }

    public List<CameraSetBean> getSupportList() {
        return this.supportList;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public Map<String, HashSet<String>> getSupportResolutionAndFps() {
        String str;
        HashMap hashMap = new HashMap();
        Iterator<CameraSetBean> it = this.supportList.iterator();
        while (it.hasNext()) {
            int realValueForUsb = it.next().getRealValueForUsb();
            String str2 = null;
            String str3 = ResolutionAndFpsSelectView.DEFAULT_SELECT_FPS;
            switch (realValueForUsb) {
                case 0:
                    str2 = "4K";
                    break;
                case 1:
                    str2 = "2.7K";
                    break;
                case 2:
                    str2 = "2K";
                    break;
                case 3:
                    str = "60";
                    str3 = str;
                    str2 = "1080P";
                    break;
                case 4:
                    str2 = "720P";
                    str3 = "120";
                    break;
                case 5:
                    str2 = "1080P";
                    break;
                case 6:
                    str3 = "25";
                    str2 = "4K";
                    break;
                case 7:
                    str3 = "24";
                    str2 = "4K";
                    break;
                case 8:
                    str3 = "25";
                    str2 = "2.7K";
                    break;
                case 9:
                    str3 = "24";
                    str2 = "2.7K";
                    break;
                case 10:
                    str = "50";
                    str3 = str;
                    str2 = "1080P";
                    break;
                case 11:
                    str3 = "25";
                    str2 = "1080P";
                    break;
                case 12:
                    str3 = "24";
                    str2 = "1080P";
                    break;
                case 13:
                    str2 = "2.5K";
                    break;
                default:
                    str3 = null;
                    break;
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                HashSet hashSet = (HashSet) hashMap.get(str2);
                if (hashSet == null) {
                    hashSet = new HashSet();
                }
                hashSet.add(str3);
                hashMap.put(str2, hashSet);
            }
        }
        return hashMap;
    }

    public static int getSendValueFromResolutionFps(String str) {
        str.hashCode();
        switch (str) {
            case "720P120":
                return 4;
            case "2K30":
                return 2;
            case "4K24":
                return 7;
            case "4K25":
                return 6;
            case "2.5K30":
                return 13;
            case "2.7K24":
                return 9;
            case "2.7K25":
                return 8;
            case "2.7K30":
                return 1;
            case "1080P24":
                return 12;
            case "1080P25":
                return 11;
            case "1080P30":
                return 5;
            case "1080P50":
                return 10;
            case "1080P60":
                return 3;
            default:
                return 0;
        }
    }

    public void setSupportListForWIFI(SizeData sizeData) {
        List<String> sizeData2;
        if (sizeData == null || (sizeData2 = sizeData.getSizeData()) == null) {
            return;
        }
        this.supportList.clear();
        for (int i = 0; i < sizeData2.size(); i++) {
            String str = sizeData2.get(i);
            this.supportList.add(new CameraSetBean(str, str, false));
        }
        setCurrent();
    }

    public void setSupportListForUSB(int[] iArr) {
        if (iArr != null) {
            this.supportList.clear();
            for (int i : iArr) {
                CameraSetBean cameraSetBean = null;
                if (this.supportType == SupportType.TYPE_PHOTO_SIZE) {
                    if (i == 0) {
                        cameraSetBean = new CameraSetBean("16M", i, true);
                    } else if (i == 1) {
                        cameraSetBean = new CameraSetBean("12M", i, true);
                    } else if (i == 2) {
                        cameraSetBean = new CameraSetBean("8M", i, true);
                    } else if (i == 3) {
                        cameraSetBean = new CameraSetBean("20M", i, true);
                    } else if (i == 4) {
                        cameraSetBean = new CameraSetBean("4M", i, true);
                    } else if (i == 5) {
                        cameraSetBean = new CameraSetBean("3M", i, true);
                    } else if (i == 6) {
                        cameraSetBean = new CameraSetBean("2.5K", i, true);
                    }
                } else if (this.supportType == SupportType.TYPE_VIDEO_SIZE) {
                    switch (i) {
                        case 0:
                            cameraSetBean = new CameraSetBean("4K30", i, true);
                            break;
                        case 1:
                            cameraSetBean = new CameraSetBean("2.7K30", i, true);
                            break;
                        case 2:
                            if (!CameraConfig.get().isATOMSECamera()) {
                                cameraSetBean = new CameraSetBean("2K30", i, true);
                                break;
                            }
                            break;
                        case 3:
                            cameraSetBean = new CameraSetBean("1080P60", i, true);
                            break;
                        case 4:
                            cameraSetBean = new CameraSetBean("720P120", i, true);
                            break;
                        case 5:
                            cameraSetBean = new CameraSetBean("1080P30", i, true);
                            break;
                        case 6:
                            cameraSetBean = new CameraSetBean("4K25", i, true);
                            break;
                        case 7:
                            cameraSetBean = new CameraSetBean("4K24", i, true);
                            break;
                        case 8:
                            cameraSetBean = new CameraSetBean("2.7K25", i, true);
                            break;
                        case 9:
                            cameraSetBean = new CameraSetBean("2.7K24", i, true);
                            break;
                        case 10:
                            cameraSetBean = new CameraSetBean("1080P50", i, true);
                            break;
                        case 11:
                            cameraSetBean = new CameraSetBean("1080P25", i, true);
                            break;
                        case 12:
                            cameraSetBean = new CameraSetBean("1080P24", i, true);
                            break;
                        case 13:
                            cameraSetBean = new CameraSetBean("2.5K30", i, true);
                            break;
                    }
                } else if (this.supportType == SupportType.TYPE_SPLIT_VIDEO) {
                    if (i == 0) {
                        cameraSetBean = new CameraSetBean("OFF", i, true);
                    } else if (i == 1) {
                        cameraSetBean = new CameraSetBean("1'", i, true);
                    } else if (i == 3) {
                        cameraSetBean = new CameraSetBean("3'", i, true);
                    } else if (i == 5) {
                        cameraSetBean = new CameraSetBean("5'", i, true);
                    }
                }
                if (cameraSetBean != null) {
                    this.supportList.add(cameraSetBean);
                    DDLog.m1684e("相机支持列表：" + this.supportType + "==" + cameraSetBean.toString());
                }
            }
        }
        setCurrent();
    }

    public String getCurrentValue() {
        return this.currentValue;
    }

    public int getCurrentFps() {
        String[] split = this.currentValue.split("P");
        if (split.length < 2) {
            split = this.currentValue.split("K");
        }
        if (TextUtils.isDigitsOnly(split[1])) {
            return Integer.parseInt(split[1]);
        }
        return 30;
    }

    public void setCurrentValue(String str) {
        this.currentValue = str;
        setCurrent();
    }

    public void setCurrentValueForUsb(int i) {
        this.currentValueForUsb = i;
        setCurrent();
    }

    public void setCurrent() {
        if (this.supportList.size() > 0) {
            if (this.currentValue == null && this.currentValueForUsb == -1) {
                return;
            }
            DDLog.m1684e("相机支持列表currentValueForUsb:" + this.supportType + "==" + this.currentValueForUsb);
            if (this.currentValueForUsb != -1) {
                int i = 0;
                while (true) {
                    if (i >= this.supportList.size()) {
                        break;
                    }
                    if (this.currentValueForUsb == this.supportList.get(i).getRealValueForUsb()) {
                        this.currentValue = this.supportList.get(i).getShowString();
                        break;
                    }
                    i++;
                }
            }
            if (this.currentValue != null) {
                for (int i2 = 0; i2 < this.supportList.size(); i2++) {
                    this.supportList.get(i2).setSelect(equals(this.currentValue, this.supportList.get(i2).getShowString()));
                }
            }
        }
    }

    public void parseMaxZoomData(byte[] bArr, int i, int i2) {
        if (bArr.length >= i + i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            int i3 = i2 / 2;
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            for (int i4 = 0; i4 < i2; i4++) {
                if (i4 % 2 == 0) {
                    iArr[i4 / 2] = bArr2[i4];
                } else {
                    iArr2[i4 / 2] = bArr2[i4];
                }
            }
            for (CameraSetBean cameraSetBean : this.supportList) {
                int i5 = 0;
                while (true) {
                    if (i5 >= i3) {
                        break;
                    }
                    if (cameraSetBean.getShowString().equals(getShowString(iArr[i5]))) {
                        cameraSetBean.setMaxZoom(iArr2[i5]);
                        break;
                    }
                    i5++;
                }
            }
        }
    }

    public String getShowString(int i) {
        if (this.supportType == SupportType.TYPE_PHOTO_SIZE) {
            switch (i) {
                case 0:
                    return "16M";
                case 1:
                    return "12M";
                case 2:
                    return "8M";
                case 3:
                    return "20M";
                case 4:
                    return "4M";
                case 5:
                    return "3M";
                case 6:
                    return "2.5K";
                default:
                    return "";
            }
        }
        if (this.supportType != SupportType.TYPE_VIDEO_SIZE) {
            return this.supportType == SupportType.TYPE_SPLIT_VIDEO ? i != 0 ? i != 1 ? i != 3 ? i != 5 ? "" : GeoFence.BUNDLE_KEY_FENCE : GeoFence.BUNDLE_KEY_FENCESTATUS : "1" : "OFF" : "";
        }
        switch (i) {
            case 0:
                return "4K30";
            case 1:
                return "2.7K30";
            case 2:
                return "2K30";
            case 3:
                return "1080P60";
            case 4:
                return "720P120";
            case 5:
                return "1080P30";
            case 6:
                return "4K25";
            case 7:
                return "4K24";
            case 8:
                return "2.7K25";
            case 9:
                return "2.7K24";
            case 10:
                return "1080P50";
            case 11:
                return "1080P25";
            case 12:
                return "1080P24";
            case 13:
                return "2.5K30";
            default:
                return "";
        }
    }

    public int getMaxZoom() {
        for (CameraSetBean cameraSetBean : this.supportList) {
            String str = this.currentValue;
            if (str != null && str.equals(cameraSetBean.getShowString())) {
                return cameraSetBean.getMaxZoom();
            }
        }
        return -1;
    }
}