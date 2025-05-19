package com.ipotensic.kernel.view;

import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.ExpandableView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public class ExposureLevelView {
    private static final int TYPE_PLUS = 1;
    private static final int TYPE_SUB = 0;
    private ImageView adjustView;
    private TranslateAnimation animation;
    private IChangeProgressListener mListener;
    private ImageButton plusBtn;
    private ImageButton subBtn;
    private TextView valueText;
    private View view;
    private int progress = 4;
    private int max = 8;
    private int min = 0;
    private int enabaleMax = 8;
    private float offset = 0.0f;
    private int curType = 0;

    public interface IChangeProgressListener {
        void ChangeProgress(float f);
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface type {
    }

    static /* synthetic */ int access$008(ExposureLevelView exposureLevelView) {
        int i = exposureLevelView.progress;
        exposureLevelView.progress = i + 1;
        return i;
    }

    static /* synthetic */ int access$010(ExposureLevelView exposureLevelView) {
        int i = exposureLevelView.progress;
        exposureLevelView.progress = i - 1;
        return i;
    }

    public ExposureLevelView(View view) {
        this.view = view;
        initView();
        initListener();
        final ExpandableView expandableView = (ExpandableView) this.view.findViewById(R.id.ev_expandable);
        expandableView.setOnExpandListener(new ExpandableView.OnExpandListener() { // from class: com.ipotensic.kernel.view.ExposureLevelView.1
            @Override // com.ipotensic.kernel.view.ExpandableView.OnExpandListener
            public void onExpand(boolean z) {
                if (z) {
                    ExposureLevelView.this.valueText.post(new Runnable() { // from class: com.ipotensic.kernel.view.ExposureLevelView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ExposureLevelView.this.progress > 4) {
                                ExposureLevelView.this.curType = 1;
                            } else {
                                ExposureLevelView.this.curType = 0;
                            }
                            ExposureLevelView.this.setValueNoAnimator();
                            expandableView.removeListener();
                        }
                    });
                }
            }
        });
    }

    private void initView() {
        this.subBtn = (ImageButton) this.view.findViewById(R.id.iv_ev_sub);
        this.plusBtn = (ImageButton) this.view.findViewById(R.id.iv_ev_plus);
        this.adjustView = (ImageView) this.view.findViewById(R.id.iv_ev_adjust);
        this.valueText = (TextView) this.view.findViewById(R.id.tv_ev_value);
    }

    private void initListener() {
        this.subBtn.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.ExposureLevelView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ExposureLevelView.this.progress > ExposureLevelView.this.min) {
                    ExposureLevelView.access$010(ExposureLevelView.this);
                    ExposureLevelView.this.curType = 0;
                    ExposureLevelView exposureLevelView = ExposureLevelView.this;
                    exposureLevelView.updateProgressImg(exposureLevelView.progress, ExposureLevelView.this.curType);
                }
            }
        });
        this.plusBtn.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.ExposureLevelView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ExposureLevelView.this.progress < ExposureLevelView.this.max) {
                    ExposureLevelView.access$008(ExposureLevelView.this);
                    ExposureLevelView.this.curType = 1;
                    ExposureLevelView exposureLevelView = ExposureLevelView.this;
                    exposureLevelView.updateProgressImg(exposureLevelView.progress, ExposureLevelView.this.curType);
                }
            }
        });
    }

    private void setAnimator(int i, long j) {
        float f = (float) ((this.progress - 4) * 0.5d);
        this.valueText.setText(String.valueOf(f > 0.0f ? "+" + f : f < 0.0f ? Float.valueOf(f) : "0.0"));
        float width = (this.adjustView.getWidth() * 3) / 26;
        this.offset = width * f * 2.0f;
        if (j == 0) {
            float f2 = this.offset;
            this.animation = new TranslateAnimation(f2, f2, 0.0f, 0.0f);
        } else if (i == 0) {
            float f3 = this.offset;
            this.animation = new TranslateAnimation(width + f3, f3, 0.0f, 0.0f);
        } else if (i == 1) {
            float f4 = this.offset;
            this.animation = new TranslateAnimation(f4 - width, f4, 0.0f, 0.0f);
        } else {
            this.animation = new TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f);
        }
        this.animation.setFillAfter(true);
        this.animation.setDuration(j);
        this.valueText.clearAnimation();
        this.valueText.setAnimation(this.animation);
        this.animation.start();
        this.mListener.ChangeProgress(f);
    }

    public void uploadProgress(double d) {
        int i = this.progress;
        if (i > i) {
            this.curType = 0;
        } else if (i < i) {
            this.curType = 1;
        }
        this.progress = (int) ((d + 2.0d) / 0.5d);
        setValueNoAnimator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgressImg(int i, int i2) {
        this.adjustView.getDrawable().setLevel(i);
        setAnimator(i2, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValueNoAnimator() {
        this.adjustView.getDrawable().setLevel(this.progress);
        setAnimator(this.curType, 0L);
    }

    public void setProgressMaxMin(int i, int i2) {
        this.max = i;
        this.min = i2;
        this.enabaleMax = i - i2;
    }

    public void setChangeProgressListener(IChangeProgressListener iChangeProgressListener) {
        this.mListener = iChangeProgressListener;
    }
}
