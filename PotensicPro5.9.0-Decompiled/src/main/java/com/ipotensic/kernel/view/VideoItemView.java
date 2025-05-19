package com.ipotensic.kernel.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class VideoItemView extends RelativeLayout {
    public ImageView imgPlay;
    public ImageView imgThumbnail;

    public VideoItemView(Context context) {
        super(context);
        initView(context);
    }

    public VideoItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public VideoItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    public VideoItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initView(context);
    }

    private void initView(Context context) {
        RelativeLayout.LayoutParams layoutParams;
        this.imgThumbnail = new ImageView(context);
        if (context.getResources().getConfiguration().orientation == 2) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.addRule(13);
        addView(this.imgThumbnail, layoutParams);
        this.imgPlay = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.imgPlay.setImageResource(R.drawable.icon_video_item);
        this.imgPlay.setPadding(30, 30, 30, 30);
        addView(this.imgPlay, layoutParams2);
    }
}
