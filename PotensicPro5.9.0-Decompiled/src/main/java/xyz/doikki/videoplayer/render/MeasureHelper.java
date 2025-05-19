package xyz.doikki.videoplayer.render;

import android.view.View;

/* loaded from: classes6.dex */
public class MeasureHelper {
    private int mCurrentScreenScale;
    private int mVideoHeight;
    private int mVideoRotationDegree;
    private int mVideoWidth;

    public void setVideoRotation(int i) {
        this.mVideoRotationDegree = i;
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    public void setScreenScale(int i) {
        this.mCurrentScreenScale = i;
    }

    public int[] doMeasure(int i, int i2) {
        int i3;
        int i4 = this.mVideoRotationDegree;
        if (i4 == 90 || i4 == 270) {
            int i5 = i + i2;
            i2 = i5 - i2;
            i = i5 - i2;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i6 = this.mVideoHeight;
        if (i6 == 0 || (i3 = this.mVideoWidth) == 0) {
            return new int[]{size, size2};
        }
        int i7 = this.mCurrentScreenScale;
        if (i7 == 1) {
            i2 = (size / 16) * 9;
            if (size2 <= i2) {
                i = (size2 / 9) * 16;
                i2 = size2;
            }
            i = size;
        } else if (i7 == 2) {
            i2 = (size / 4) * 3;
            if (size2 <= i2) {
                i = (size2 / 3) * 4;
                i2 = size2;
            }
            i = size;
        } else if (i7 != 3) {
            if (i7 == 4) {
                i2 = i6;
                i = i3;
            } else if (i7 != 5) {
                if (i3 * size2 < size * i6) {
                    i = (i3 * size2) / i6;
                } else if (i3 * size2 > size * i6) {
                    i2 = (i6 * size) / i3;
                    i = size;
                } else {
                    i = size;
                }
                i2 = size2;
            } else if (i3 * size2 > size * i6) {
                i = (i3 * size2) / i6;
                i2 = size2;
            } else {
                i2 = (i6 * size) / i3;
                i = size;
            }
        }
        return new int[]{i, i2};
    }
}
