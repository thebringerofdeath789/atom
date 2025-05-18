package com.ipotensic.kernel.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.enums.GalleryUIType;

/* loaded from: classes2.dex */
public class VisionGalleryButton extends ImageButton {
    private GalleryUIType type;

    public VisionGalleryButton(Context context) {
        super(context);
        this.type = GalleryUIType.UI_TYPE_GALLERY;
    }

    public VisionGalleryButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = GalleryUIType.UI_TYPE_GALLERY;
    }

    public VisionGalleryButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = GalleryUIType.UI_TYPE_GALLERY;
    }

    public VisionGalleryButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.type = GalleryUIType.UI_TYPE_GALLERY;
    }

    public void setType(GalleryUIType galleryUIType) {
        this.type = galleryUIType;
        if (galleryUIType == GalleryUIType.UI_TYPE_GALLERY) {
            setImageResource(C1965R.mipmap.img_btn_gallery);
        } else if (this.type == GalleryUIType.UI_TYPE_FOLLOW_DISABLE) {
            setImageResource(C1965R.mipmap.img_btn_short_video_follow_disable);
        } else if (this.type == GalleryUIType.UI_TYPE_FOLLOW_ENABLE) {
            setImageResource(C1965R.mipmap.img_btn_short_video_follow_enable);
        }
    }

    public GalleryUIType getType() {
        return this.type;
    }
}