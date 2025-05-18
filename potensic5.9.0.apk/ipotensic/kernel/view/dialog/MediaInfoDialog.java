package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.R;
import com.logan.camera.data.MediaInfoData;

/* loaded from: classes2.dex */
public class MediaInfoDialog extends com.ipotensic.baselib.base.BaseDialog {
    private void windowDeploy(int i) {
        Window window = getWindow();
        window.setGravity(i);
        window.setWindowAnimations(R.style.dialogWindowAnim);
        window.setBackgroundDrawableResource(R.color.colorTransparent);
        window.setAttributes(window.getAttributes());
    }

    public MediaInfoDialog(Context context) {
        super(context, R.layout.view_dialog_media_info, R.style.ImageDetailDialog);
        initWindow();
    }

    public MediaInfoDialog(Context context, int i) {
        super(context, R.layout.view_main_dialog_media_info, R.style.ImageDetailDialog);
        initWindow();
        windowDeploy(80);
    }

    private void initWindow() {
        if (getContext().getResources().getConfiguration().orientation == 2) {
            setSize((int) (ScreenUtils.getScreenWidth(getContext()) * 0.5d), -2);
        } else {
            setSize((int) (ScreenUtils.getScreenWidth(getContext()) * 0.8d), -2);
        }
    }

    public void hideResolution() {
        findViewById(R.id.layout_resolution).setVisibility(8);
    }

    public void hideSize() {
        findViewById(R.id.layout_size).setVisibility(8);
    }

    public void setMediaInfo(MediaInfoData mediaInfoData) {
        if (mediaInfoData != null) {
            TextView textView = (TextView) findViewById(R.id.tv_date);
            TextView textView2 = (TextView) findViewById(R.id.tv_resolution);
            TextView textView3 = (TextView) findViewById(R.id.tv_size);
            TextView textView4 = (TextView) findViewById(R.id.tv_format);
            TextView textView5 = (TextView) findViewById(R.id.tv_duration);
            TextView textView6 = (TextView) findViewById(R.id.tv_frame_rate);
            textView.setText("" + mediaInfoData.getCreatetime());
            textView2.setText(mediaInfoData.getWidth() + "x" + mediaInfoData.getHeight());
            textView3.setText(FormatUtil.getPicOrVideoSize(mediaInfoData.getFilesize()));
            String filename = mediaInfoData.getFilename();
            if (filename != null && filename.length() > 3) {
                textView4.setText(mediaInfoData.isVideo() ? "" + filename.substring(filename.length() - 3) : "JPEG");
            } else {
                textView4.setText(mediaInfoData.getFormat() + "");
            }
            if (mediaInfoData.isVideo()) {
                textView5.setText(FormatUtil.formatVideoDuration(mediaInfoData.getFiletime()));
                textView6.setText(Double.valueOf(mediaInfoData.getFps()).intValue() + "fps");
                if (mediaInfoData.getFps() == 0.0d) {
                    findViewById(R.id.layout_frame_rate).setVisibility(8);
                    return;
                }
                return;
            }
            findViewById(R.id.layout_duration).setVisibility(8);
            findViewById(R.id.layout_frame_rate).setVisibility(8);
        }
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.MediaInfoDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MediaInfoDialog.this.dismiss();
            }
        });
    }

    @Override // com.ipotensic.baselib.base.BaseDialog, android.app.Dialog, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        initWindow();
    }
}