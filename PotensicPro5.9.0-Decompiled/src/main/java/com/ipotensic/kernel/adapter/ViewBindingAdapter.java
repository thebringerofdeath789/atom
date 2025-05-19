package com.ipotensic.kernel.adapter;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.enums.VisionExecuteType;
import com.ipotensic.baselib.guide.util.ViewUtils;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.enums.CaptureUIType;
import com.ipotensic.kernel.enums.GalleryUIType;
import com.ipotensic.kernel.view.BatteryProgressView;
import com.ipotensic.kernel.view.CaptureProgressButton;
import com.ipotensic.kernel.view.CursorEditText;
import com.ipotensic.kernel.view.CursorStringEditText;
import com.ipotensic.kernel.view.CustomSeekbar;
import com.ipotensic.kernel.view.OneKeyVideoButton;
import com.ipotensic.kernel.view.ShortVideoCountDownView;
import com.ipotensic.kernel.view.SwitchButton;
import com.ipotensic.kernel.view.VisionGalleryButton;
import kotlin.jvm.JvmStatic;

/* loaded from: classes2.dex */
public class ViewBindingAdapter {
    public static final int NONE = -1;

    public static void setImageViewResource(ImageView imageView, int i) {
        imageView.setImageResource(i);
    }

    public static void setImageViewResource(ImageButton imageButton, int i) {
        imageButton.setImageResource(i);
    }

    public static void setVerticalBias(View view, float f) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        layoutParams.verticalBias = f;
        view.setLayoutParams(layoutParams);
    }

    public static void setCaptureUiType(CaptureProgressButton captureProgressButton, int i, int i2) {
        for (CaptureUIType captureUIType : CaptureUIType.values()) {
            if (i == captureUIType.ordinal()) {
                captureProgressButton.setCaptureType(captureUIType);
            }
        }
        captureProgressButton.setProgressPercent(i2);
    }

    public static void setBackgroundResource(View view, int i) {
        if (i == -1) {
            view.setBackground(null);
        } else {
            view.setBackgroundResource(i);
        }
    }

    public static void setBackgroundColor(View view, int i) {
        if (i == -1) {
            view.setBackground(null);
        } else {
            view.setBackgroundColor(view.getContext().getColor(i));
        }
    }

    public static void setSwitchButtonListener(SwitchButton switchButton, SwitchButton.SwitchStateListener switchStateListener) {
        switchButton.switchStateListener(switchStateListener);
    }

    public static void setSwitchButtonEnable(SwitchButton switchButton, boolean z) {
        switchButton.setViewEnable(z);
    }

    public static void setSwitchButtonChecked(SwitchButton switchButton, boolean z) {
        switchButton.setChecked(z);
    }

    public static void setText(TextView textView, ObservableString observableString) {
        textView.setText(observableString.get());
    }

    public static void setText(CursorEditText cursorEditText, int i) {
        cursorEditText.setText(i + "");
    }

    public static void setProgressColor(CustomSeekbar customSeekbar, int i) {
        try {
            ((LayerDrawable) customSeekbar.getProgressDrawable()).getDrawable(2).setColorFilter(customSeekbar.getContext().getColor(i), PorterDuff.Mode.SRC);
        } catch (Exception e) {
            DDLog.e("设置背景颜色失败:" + e);
        }
    }

    public static void setSeekbarLimit(CustomSeekbar customSeekbar, int i, int i2, int i3, int i4, SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        customSeekbar.setLimit(i, i2, i3);
        customSeekbar.setOnSeekBarChangeListener(onSeekBarChangeListener);
        customSeekbar.setValue(i4);
    }

    public static void setEdittextLimit(CursorEditText cursorEditText, int i, int i2, int i3, CursorEditText.OnInputFinishListener onInputFinishListener) {
        cursorEditText.setLimit(i, i2, i3);
        cursorEditText.setInputFinishListener(onInputFinishListener);
    }

    public static void setEdittextLimit(CursorEditText cursorEditText, int i, int i2, int i3, int i4, CursorEditText.OnInputFinishListener onInputFinishListener) {
        cursorEditText.setLimit(i, i2, i3);
        cursorEditText.setInputFinishListener(onInputFinishListener);
        cursorEditText.setText(i4 + "");
    }

    public static void setStringEdittextLimit(CursorStringEditText cursorStringEditText, float f, float f2, float f3, CursorStringEditText.OnInputFinishListener onInputFinishListener) {
        cursorStringEditText.setLimit(f, f2, f3);
        cursorStringEditText.setInputFinishListener(onInputFinishListener);
    }

    public static void set_input_enable(CursorEditText cursorEditText, boolean z) {
        cursorEditText.setInputEnable(z);
    }

    @JvmStatic
    public static void setTextViewColor(TextView textView, int i) {
        textView.setTextColor(i);
    }

    public static void setBatteryProgress(BatteryProgressView batteryProgressView, int i) {
        if (i == -1) {
            batteryProgressView.disconnect();
        } else {
            batteryProgressView.setProgress(i);
        }
    }

    public static void setViewEnableWithAlpha(View view, boolean z) {
        ViewUtils.setViewEnableWithAlpha(view, z);
    }

    public static void setCheckChangeListener(CheckBox checkBox, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        checkBox.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public static void setSeekbarThumb(CustomSeekbar customSeekbar, int i) {
        customSeekbar.setThumb(AppCompatResources.getDrawable(customSeekbar.getContext(), i));
    }

    public static void setVideoType(OneKeyVideoButton oneKeyVideoButton, VisionExecuteType visionExecuteType, boolean z, boolean z2) {
        if (z) {
            oneKeyVideoButton.reset();
        } else {
            oneKeyVideoButton.setType(visionExecuteType);
            oneKeyVideoButton.setEnableMode(z2);
        }
    }

    public static void setDrawableTop(TextView textView, int i) {
        Drawable drawable = textView.getContext().getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
    }

    public static void setGalleryType(VisionGalleryButton visionGalleryButton, int i) {
        for (GalleryUIType galleryUIType : GalleryUIType.values()) {
            if (galleryUIType.ordinal() == i) {
                visionGalleryButton.setType(galleryUIType);
            }
        }
    }

    public static void setCountDownStart(ShortVideoCountDownView shortVideoCountDownView, boolean z, ShortVideoCountDownView.OnCountDownListener onCountDownListener) {
        if (z) {
            if (shortVideoCountDownView.isCountingDown()) {
                return;
            }
            shortVideoCountDownView.startCount(3, onCountDownListener);
            return;
        }
        shortVideoCountDownView.interrupt();
    }

    public static void setVisible(View view, boolean z) {
        view.setVisibility(z ? 0 : 8);
    }
}
