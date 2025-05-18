package com.ipotensic.potensicpro.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.ipotensic.kernel.view.mapscaleview.MapScaleView;
import com.ipotensic.potensicpro.C2640R;
import com.ipotensic.potensicpro.viewmodel.FindDroneViewModel;
import com.mapbox.mapboxsdk.maps.MapView;

/* loaded from: classes2.dex */
public class ActivityFindMyDroneBindingImpl extends ActivityFindMyDroneBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ViewMapboxToolBinding mboundView0;
    private final ConstraintLayout mboundView01;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C2640R.id.toolbar, 4);
        sparseIntArray.put(C2640R.id.iv_back, 5);
        sparseIntArray.put(C2640R.id.tv_code_title, 6);
        sparseIntArray.put(C2640R.id.iv_search, 7);
        sparseIntArray.put(C2640R.id.map_view, 8);
        sparseIntArray.put(C2640R.id.scaleView, 9);
        sparseIntArray.put(C2640R.id.tv_start_beep, 10);
        sparseIntArray.put(C2640R.id.img_speaker_beep, 11);
    }

    public ActivityFindMyDroneBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private ActivityFindMyDroneBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ConstraintLayout) objArr[1], (ImageView) objArr[11], (ImageView) objArr[5], (ImageView) objArr[7], (MapView) objArr[8], (MapScaleView) objArr[9], (Toolbar) objArr[4], (TextView) objArr[6], (ConstraintLayout) objArr[2], (TextView) objArr[10]);
        this.mDirtyFlags = -1L;
        this.btnStartBeep.setTag(null);
        this.mboundView0 = objArr[3] != null ? ViewMapboxToolBinding.bind((View) objArr[3]) : null;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView01 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvIconStartBeep.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (3 != i) {
            return false;
        }
        setFindDroneViewModel((FindDroneViewModel) obj);
        return true;
    }

    @Override // com.ipotensic.potensicpro.databinding.ActivityFindMyDroneBinding
    public void setFindDroneViewModel(FindDroneViewModel findDroneViewModel) {
        this.mFindDroneViewModel = findDroneViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeFindDroneViewModelShowBeepBtn((MutableLiveData) obj, i2);
    }

    private boolean onChangeFindDroneViewModelShowBeepBtn(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        FindDroneViewModel findDroneViewModel = this.mFindDroneViewModel;
        long j2 = j & 7;
        int i = 0;
        if (j2 != 0) {
            MutableLiveData<Boolean> mutableLiveData = findDroneViewModel != null ? findDroneViewModel.showBeepBtn : null;
            updateLiveDataRegistration(0, mutableLiveData);
            boolean safeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null);
            if (j2 != 0) {
                j |= safeUnbox ? 16L : 8L;
            }
            if (!safeUnbox) {
                i = 8;
            }
        }
        if ((j & 7) != 0) {
            this.btnStartBeep.setVisibility(i);
            this.tvIconStartBeep.setVisibility(i);
        }
    }
}