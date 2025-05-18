package com.ipotensic.potensicpro;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.potensicpro.databinding.ActivityFindMyDroneBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYFINDMYDRONE = 1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(1);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_find_my_drone, 1);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        if (i2 != 1) {
            return null;
        }
        if ("layout/activity_find_my_drone_0".equals(tag)) {
            return new ActivityFindMyDroneBindingImpl(dataBindingComponent, view);
        }
        throw new IllegalArgumentException("The tag for activity_find_my_drone is invalid. Received: " + tag);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.gs.keyboard.DataBinderMapperImpl());
        arrayList.add(new com.ipotensic.baselib.DataBinderMapperImpl());
        arrayList.add(new com.ipotensic.kernel.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(15);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "bigPackageViewModel");
            sparseArray.put(2, "compassCalibrationModel");
            sparseArray.put(3, "findDroneViewModel");
            sparseArray.put(4, "gimbalCalibrationModel");
            sparseArray.put(5, "gimbalFineTuningModel");
            sparseArray.put(6, "model");
            sparseArray.put(7, "pairDroneModel");
            sparseArray.put(8, "remoterControllerModel");
            sparseArray.put(9, "settingAboutModel");
            sparseArray.put(10, "settingCameraModel");
            sparseArray.put(11, "settingControlModel");
            sparseArray.put(12, "settingMainModel");
            sparseArray.put(13, "settingSecurityModel");
            sparseArray.put(14, "settingStickMode");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(1);
            sKeys = hashMap;
            hashMap.put("layout/activity_find_my_drone_0", Integer.valueOf(R.layout.activity_find_my_drone));
        }
    }
}