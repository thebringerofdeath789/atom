package com.ipotensic.kernel.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.ipotensic.baselib.enums.VisionExecuteType;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class OneKeyVideoButton extends ImageButton {
    private VisionExecuteType visionExecuteType;

    public OneKeyVideoButton(Context context) {
        super(context);
        this.visionExecuteType = null;
    }

    public OneKeyVideoButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.visionExecuteType = null;
    }

    public OneKeyVideoButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.visionExecuteType = null;
    }

    public OneKeyVideoButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.visionExecuteType = null;
    }

    public void setType(VisionExecuteType visionExecuteType) {
        this.visionExecuteType = visionExecuteType;
        if (visionExecuteType == VisionExecuteType.TYPE_RECESS) {
            setImageResource(R.mipmap.icon_recess_display);
            return;
        }
        if (this.visionExecuteType == VisionExecuteType.TYPE_SKYWARD) {
            setImageResource(R.mipmap.icon_skyward_display);
            return;
        }
        if (this.visionExecuteType == VisionExecuteType.TYPE_CIRCLE) {
            setImageResource(R.mipmap.icon_circle_display);
        } else if (this.visionExecuteType == VisionExecuteType.TYPE_SCREW) {
            setImageResource(R.mipmap.icon_screw_display);
        } else if (this.visionExecuteType == VisionExecuteType.TYPE_COMET) {
            setImageResource(R.mipmap.icon_comet_display);
        }
    }

    public void setEnableMode(boolean z) {
        if (z) {
            setType(this.visionExecuteType);
            return;
        }
        if (this.visionExecuteType == VisionExecuteType.TYPE_RECESS) {
            setImageResource(R.mipmap.img_btn_short_video_recess_disable);
            return;
        }
        if (this.visionExecuteType == VisionExecuteType.TYPE_SKYWARD) {
            setImageResource(R.mipmap.img_btn_short_video_towering_disable);
            return;
        }
        if (this.visionExecuteType == VisionExecuteType.TYPE_CIRCLE) {
            setImageResource(R.mipmap.img_btn_short_video_circle_disable);
        } else if (this.visionExecuteType == VisionExecuteType.TYPE_SCREW) {
            setImageResource(R.mipmap.img_btn_short_video_screw_disable);
        } else if (this.visionExecuteType == VisionExecuteType.TYPE_COMET) {
            setImageResource(R.mipmap.img_btn_short_video_comet_disable);
        }
    }

    public void reset() {
        setImageResource(R.mipmap.img_btn_short_video);
    }

    public VisionExecuteType getType() {
        return this.visionExecuteType;
    }
}
