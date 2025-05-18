package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewLayoutSettingBinding implements ViewBinding {
    public final ImageButton btnIndicator1;
    public final ImageButton btnIndicator2;
    public final ImageButton btnIndicator3;
    public final ImageButton btnIndicator4;
    public final ImageButton btnIndicator5;
    public final LinearLayout layoutIndicator;
    private final ConstraintLayout rootView;
    public final ViewStub stubSetting1;
    public final ViewStub stubSetting2;
    public final ViewStub stubSetting3;
    public final ViewStub stubSetting4;
    public final ViewStub stubSetting5;
    public final View viewLeftBlank;

    private ViewLayoutSettingBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, LinearLayout linearLayout, ViewStub viewStub, ViewStub viewStub2, ViewStub viewStub3, ViewStub viewStub4, ViewStub viewStub5, View view) {
        this.rootView = constraintLayout;
        this.btnIndicator1 = imageButton;
        this.btnIndicator2 = imageButton2;
        this.btnIndicator3 = imageButton3;
        this.btnIndicator4 = imageButton4;
        this.btnIndicator5 = imageButton5;
        this.layoutIndicator = linearLayout;
        this.stubSetting1 = viewStub;
        this.stubSetting2 = viewStub2;
        this.stubSetting3 = viewStub3;
        this.stubSetting4 = viewStub4;
        this.stubSetting5 = viewStub5;
        this.viewLeftBlank = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_layout_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutSettingBinding bind(View view) {
        View findViewById;
        int i = C1965R.id.btn_indicator_1;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            i = C1965R.id.btn_indicator_2;
            ImageButton imageButton2 = (ImageButton) view.findViewById(i);
            if (imageButton2 != null) {
                i = C1965R.id.btn_indicator_3;
                ImageButton imageButton3 = (ImageButton) view.findViewById(i);
                if (imageButton3 != null) {
                    i = C1965R.id.btn_indicator_4;
                    ImageButton imageButton4 = (ImageButton) view.findViewById(i);
                    if (imageButton4 != null) {
                        i = C1965R.id.btn_indicator_5;
                        ImageButton imageButton5 = (ImageButton) view.findViewById(i);
                        if (imageButton5 != null) {
                            i = C1965R.id.layout_indicator;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                            if (linearLayout != null) {
                                i = C1965R.id.stub_setting_1;
                                ViewStub viewStub = (ViewStub) view.findViewById(i);
                                if (viewStub != null) {
                                    i = C1965R.id.stub_setting_2;
                                    ViewStub viewStub2 = (ViewStub) view.findViewById(i);
                                    if (viewStub2 != null) {
                                        i = C1965R.id.stub_setting_3;
                                        ViewStub viewStub3 = (ViewStub) view.findViewById(i);
                                        if (viewStub3 != null) {
                                            i = C1965R.id.stub_setting_4;
                                            ViewStub viewStub4 = (ViewStub) view.findViewById(i);
                                            if (viewStub4 != null) {
                                                i = C1965R.id.stub_setting_5;
                                                ViewStub viewStub5 = (ViewStub) view.findViewById(i);
                                                if (viewStub5 != null && (findViewById = view.findViewById((i = C1965R.id.view_left_blank))) != null) {
                                                    return new ViewLayoutSettingBinding((ConstraintLayout) view, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, linearLayout, viewStub, viewStub2, viewStub3, viewStub4, viewStub5, findViewById);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}