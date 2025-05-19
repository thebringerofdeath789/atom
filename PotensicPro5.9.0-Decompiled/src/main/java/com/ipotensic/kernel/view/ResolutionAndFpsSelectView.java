package com.ipotensic.kernel.view;

import android.widget.ImageView;
import android.widget.LinearLayout;
import com.ipotensic.kernel.view.HorizontalWheelView;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;

/* loaded from: classes2.dex */
public class ResolutionAndFpsSelectView {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String DEFAULT_SELECT_FPS = "30";
    private String currentResolution;
    private int fpsIndex;
    private final ImageView ivSplitLine;
    private final ImageView ivTopArrowLine;
    private final LinearLayout llWvFpsItemWrapper;
    private final LinearLayout llWvResolutionItemWrapper;
    private HorizontalWheelView.OnWheelViewListener onWheelViewListener;
    private int resolutionIndex;
    private String[] supportFps;
    private Map<String, HashSet<String>> supportResolutionAndFps;
    private String[] supportResolutions;
    private int viewSize;
    private final HorizontalWheelView wvFpsItem;
    private final HorizontalWheelView wvResolutionItem;

    public ResolutionAndFpsSelectView(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, ImageView imageView2, HorizontalWheelView horizontalWheelView, HorizontalWheelView horizontalWheelView2) {
        this.llWvResolutionItemWrapper = linearLayout;
        this.llWvFpsItemWrapper = linearLayout2;
        this.ivSplitLine = imageView;
        this.ivTopArrowLine = imageView2;
        this.wvResolutionItem = horizontalWheelView;
        this.wvFpsItem = horizontalWheelView2;
        horizontalWheelView.setOnWheelViewListener(new HorizontalWheelView.OnWheelViewListener() { // from class: com.ipotensic.kernel.view.ResolutionAndFpsSelectView.1
            @Override // com.ipotensic.kernel.view.HorizontalWheelView.OnWheelViewListener
            public void onTouch() {
                ResolutionAndFpsSelectView.this.onWheelViewListener.onTouch();
            }

            @Override // com.ipotensic.kernel.view.HorizontalWheelView.OnWheelViewListener
            public void onSelected(int i, String str) {
                if (ResolutionAndFpsSelectView.this.resolutionIndex == i) {
                    return;
                }
                ResolutionAndFpsSelectView.this.resolutionIndex = i;
                ResolutionAndFpsSelectView.this.showFpsWheelView(i);
                ResolutionAndFpsSelectView.this.currentResolution = str + ResolutionAndFpsSelectView.this.supportFps[ResolutionAndFpsSelectView.this.fpsIndex];
                ResolutionAndFpsSelectView.this.onWheelViewListener.onSelected(i, ResolutionAndFpsSelectView.this.currentResolution);
            }
        });
        horizontalWheelView2.setOnWheelViewListener(new HorizontalWheelView.OnWheelViewListener() { // from class: com.ipotensic.kernel.view.ResolutionAndFpsSelectView.2
            @Override // com.ipotensic.kernel.view.HorizontalWheelView.OnWheelViewListener
            public void onTouch() {
                ResolutionAndFpsSelectView.this.onWheelViewListener.onTouch();
            }

            @Override // com.ipotensic.kernel.view.HorizontalWheelView.OnWheelViewListener
            public void onSelected(int i, String str) {
                ResolutionAndFpsSelectView.this.currentResolution = ResolutionAndFpsSelectView.this.supportResolutions[ResolutionAndFpsSelectView.this.resolutionIndex] + str;
                ResolutionAndFpsSelectView.this.onWheelViewListener.onSelected(i, ResolutionAndFpsSelectView.this.currentResolution);
            }
        });
    }

    public void setOnWheelViewListener(HorizontalWheelView.OnWheelViewListener onWheelViewListener) {
        this.onWheelViewListener = onWheelViewListener;
    }

    public void dismiss() {
        this.llWvResolutionItemWrapper.setVisibility(8);
        this.ivSplitLine.setVisibility(8);
        this.llWvFpsItemWrapper.setVisibility(8);
        this.ivTopArrowLine.setVisibility(8);
    }

    public void showResolutionAndFpsScrollView(Map<String, HashSet<String>> map, int i, String str) {
        this.supportResolutionAndFps = map;
        this.viewSize = i;
        this.currentResolution = str;
        this.supportResolutions = new String[map.size()];
        map.keySet().toArray(this.supportResolutions);
        Arrays.sort(this.supportResolutions, new Comparator<String>() { // from class: com.ipotensic.kernel.view.ResolutionAndFpsSelectView.3
            @Override // java.util.Comparator
            public int compare(String str2, String str3) {
                return getNumForResolution(str2) - getNumForResolution(str3);
            }

            public int getNumForResolution(String str2) {
                if (str2.endsWith("K")) {
                    return (int) (Double.parseDouble(str2.substring(0, str2.length() - 1)) * 1000.0d);
                }
                if (str2.endsWith("P")) {
                    return Integer.parseInt(str2.substring(0, str2.length() - 1));
                }
                return 0;
            }
        });
        int i2 = 0;
        while (true) {
            String[] strArr = this.supportResolutions;
            if (i2 >= strArr.length) {
                break;
            }
            if (str.startsWith(strArr[i2])) {
                this.resolutionIndex = i2;
                break;
            }
            i2++;
        }
        this.wvResolutionItem.setItems(i, Arrays.asList(this.supportResolutions), this.resolutionIndex);
        this.llWvResolutionItemWrapper.setVisibility(0);
        this.ivTopArrowLine.setVisibility(0);
        this.ivSplitLine.setVisibility(0);
        showFpsWheelView(this.resolutionIndex);
    }

    public void updateFpsWheelView(int i) {
        if (this.wvFpsItem.getVisibility() == 0) {
            this.viewSize = i;
            calFpsIndex(this.resolutionIndex);
            this.wvFpsItem.updateViews(i, this.fpsIndex);
            this.wvResolutionItem.updateViews(i, this.resolutionIndex);
        }
    }

    private void calFpsIndex(int i) {
        String[] strArr;
        Map<String, HashSet<String>> map = this.supportResolutionAndFps;
        if (map == null || (strArr = this.supportResolutions) == null) {
            return;
        }
        HashSet<String> hashSet = map.get(strArr[i]);
        String[] strArr2 = new String[hashSet.size()];
        this.supportFps = strArr2;
        hashSet.toArray(strArr2);
        Arrays.sort(this.supportFps);
        this.fpsIndex = -1;
        int i2 = 0;
        while (true) {
            String[] strArr3 = this.supportFps;
            if (i2 >= strArr3.length) {
                break;
            }
            if (this.currentResolution.endsWith(strArr3[i2])) {
                this.fpsIndex = i2;
                break;
            }
            i2++;
        }
        if (this.fpsIndex == -1) {
            int i3 = 0;
            while (true) {
                String[] strArr4 = this.supportFps;
                if (i3 >= strArr4.length) {
                    break;
                }
                if (strArr4[i3].equals(DEFAULT_SELECT_FPS)) {
                    this.fpsIndex = i3;
                    break;
                }
                i3++;
            }
        }
        if (this.fpsIndex == -1) {
            this.fpsIndex = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFpsWheelView(int i) {
        calFpsIndex(i);
        this.wvFpsItem.setNeedAppendFps(true);
        this.wvFpsItem.setItems(this.viewSize, Arrays.asList(this.supportFps), this.fpsIndex);
        if (this.llWvResolutionItemWrapper.getVisibility() == 0) {
            this.llWvFpsItemWrapper.setVisibility(0);
        }
    }
}
