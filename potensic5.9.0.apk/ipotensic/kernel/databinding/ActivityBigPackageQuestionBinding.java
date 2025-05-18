package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ActivityBigPackageQuestionBinding implements ViewBinding {
    public final ImageButton btnBack;
    private final ScrollView rootView;

    private ActivityBigPackageQuestionBinding(ScrollView scrollView, ImageButton imageButton) {
        this.rootView = scrollView;
        this.btnBack = imageButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static ActivityBigPackageQuestionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityBigPackageQuestionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_big_package_question, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityBigPackageQuestionBinding bind(View view) {
        int i = R.id.btnBack;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            return new ActivityBigPackageQuestionBinding((ScrollView) view, imageButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}