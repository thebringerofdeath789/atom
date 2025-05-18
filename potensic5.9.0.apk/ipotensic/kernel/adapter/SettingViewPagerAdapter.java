package com.ipotensic.kernel.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.List;

/* loaded from: classes2.dex */
public class SettingViewPagerAdapter extends FragmentStateAdapter {
    private List<Fragment> fragments;

    public SettingViewPagerAdapter(Fragment fragment, List<Fragment> list) {
        super(fragment);
        this.fragments = list;
    }

    public SettingViewPagerAdapter(FragmentActivity fragmentActivity, List<Fragment> list) {
        super(fragmentActivity);
        this.fragments = list;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i) {
        return this.fragments.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.fragments.size();
    }
}