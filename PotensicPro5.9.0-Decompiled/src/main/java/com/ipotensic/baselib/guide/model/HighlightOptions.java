package com.ipotensic.baselib.guide.model;

import android.view.View;
import com.ipotensic.baselib.guide.listener.OnHighlightDrewListener;

/* loaded from: classes2.dex */
public class HighlightOptions {
    public boolean fetchLocationEveryTime;
    public View.OnClickListener onClickListener;
    public OnHighlightDrewListener onHighlightDrewListener;
    public RelativeGuide relativeGuide;

    public static class Builder {
        private HighlightOptions options = new HighlightOptions();

        public Builder setOnClickListener(View.OnClickListener onClickListener) {
            this.options.onClickListener = onClickListener;
            return this;
        }

        public Builder setRelativeGuide(RelativeGuide relativeGuide) {
            this.options.relativeGuide = relativeGuide;
            return this;
        }

        public Builder setOnHighlightDrewListener(OnHighlightDrewListener onHighlightDrewListener) {
            this.options.onHighlightDrewListener = onHighlightDrewListener;
            return this;
        }

        public Builder isFetchLocationEveryTime(boolean z) {
            this.options.fetchLocationEveryTime = z;
            return this;
        }

        public HighlightOptions build() {
            return this.options;
        }
    }
}
