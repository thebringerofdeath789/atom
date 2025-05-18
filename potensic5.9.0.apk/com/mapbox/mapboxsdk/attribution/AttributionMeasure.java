package com.mapbox.mapboxsdk.attribution;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class AttributionMeasure {
    private Bitmap logo;
    private Bitmap logoSmall;
    private float margin;
    private boolean shorterText;
    private Bitmap snapshot;
    private TextView textView;
    private TextView textViewShort;

    public interface Command {
        AttributionLayout execute(AttributionMeasure attributionMeasure);
    }

    AttributionMeasure(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, TextView textView, TextView textView2, float f) {
        this.snapshot = bitmap;
        this.logo = bitmap2;
        this.logoSmall = bitmap3;
        this.textView = textView;
        this.textViewShort = textView2;
        this.margin = f;
    }

    public AttributionLayout measure() {
        AttributionLayout start = new Chain(new FullLogoLongTextCommand(), new FullLogoShortTextCommand(), new SmallLogoLongTextCommand(), new SmallLogoShortTextCommand(), new LongTextCommand(), new ShortTextCommand(), new NoTextCommand()).start(this);
        this.shorterText = start.isShortText();
        return start;
    }

    private static class FullLogoLongTextCommand implements Command {
        private FullLogoLongTextCommand() {
        }

        @Override // com.mapbox.mapboxsdk.attribution.AttributionMeasure.Command
        public AttributionLayout execute(AttributionMeasure attributionMeasure) {
            if (attributionMeasure.getLogoContainerWidth() + attributionMeasure.getTextViewContainerWidth() <= attributionMeasure.getMaxSize()) {
                return new AttributionLayout(attributionMeasure.logo, AttributionMeasure.calculateAnchor(attributionMeasure.snapshot, attributionMeasure.textView, attributionMeasure.margin), false);
            }
            return null;
        }
    }

    private static class FullLogoShortTextCommand implements Command {
        private FullLogoShortTextCommand() {
        }

        @Override // com.mapbox.mapboxsdk.attribution.AttributionMeasure.Command
        public AttributionLayout execute(AttributionMeasure attributionMeasure) {
            if (attributionMeasure.getLogoContainerWidth() + attributionMeasure.getTextViewShortContainerWidth() <= attributionMeasure.getMaxSizeShort()) {
                return new AttributionLayout(attributionMeasure.logo, AttributionMeasure.calculateAnchor(attributionMeasure.snapshot, attributionMeasure.textViewShort, attributionMeasure.margin), true);
            }
            return null;
        }
    }

    private static class SmallLogoLongTextCommand implements Command {
        private SmallLogoLongTextCommand() {
        }

        @Override // com.mapbox.mapboxsdk.attribution.AttributionMeasure.Command
        public AttributionLayout execute(AttributionMeasure attributionMeasure) {
            if (attributionMeasure.getLogoSmallContainerWidth() + attributionMeasure.getTextViewContainerWidth() <= attributionMeasure.getMaxSize()) {
                return new AttributionLayout(attributionMeasure.logoSmall, AttributionMeasure.calculateAnchor(attributionMeasure.snapshot, attributionMeasure.textView, attributionMeasure.margin), false);
            }
            return null;
        }
    }

    private static class SmallLogoShortTextCommand implements Command {
        private SmallLogoShortTextCommand() {
        }

        @Override // com.mapbox.mapboxsdk.attribution.AttributionMeasure.Command
        public AttributionLayout execute(AttributionMeasure attributionMeasure) {
            if (attributionMeasure.getLogoContainerWidth() + attributionMeasure.getTextViewShortContainerWidth() <= attributionMeasure.getMaxSizeShort()) {
                return new AttributionLayout(attributionMeasure.logoSmall, AttributionMeasure.calculateAnchor(attributionMeasure.snapshot, attributionMeasure.textViewShort, attributionMeasure.margin), true);
            }
            return null;
        }
    }

    private static class LongTextCommand implements Command {
        private LongTextCommand() {
        }

        @Override // com.mapbox.mapboxsdk.attribution.AttributionMeasure.Command
        public AttributionLayout execute(AttributionMeasure attributionMeasure) {
            if (attributionMeasure.getTextViewContainerWidth() + attributionMeasure.margin <= attributionMeasure.getMaxSize()) {
                return new AttributionLayout(null, AttributionMeasure.calculateAnchor(attributionMeasure.snapshot, attributionMeasure.textView, attributionMeasure.margin), false);
            }
            return null;
        }
    }

    private static class ShortTextCommand implements Command {
        private ShortTextCommand() {
        }

        @Override // com.mapbox.mapboxsdk.attribution.AttributionMeasure.Command
        public AttributionLayout execute(AttributionMeasure attributionMeasure) {
            if (attributionMeasure.getTextViewShortContainerWidth() + attributionMeasure.margin <= attributionMeasure.getMaxSizeShort()) {
                return new AttributionLayout(null, AttributionMeasure.calculateAnchor(attributionMeasure.snapshot, attributionMeasure.textViewShort, attributionMeasure.margin), true);
            }
            return null;
        }
    }

    private static class NoTextCommand implements Command {
        private NoTextCommand() {
        }

        @Override // com.mapbox.mapboxsdk.attribution.AttributionMeasure.Command
        public AttributionLayout execute(AttributionMeasure attributionMeasure) {
            return new AttributionLayout(null, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PointF calculateAnchor(Bitmap bitmap, TextView textView, float f) {
        return new PointF((bitmap.getWidth() - textView.getMeasuredWidth()) - f, (bitmap.getHeight() - f) - textView.getMeasuredHeight());
    }

    public TextView getTextView() {
        return this.shorterText ? this.textViewShort : this.textView;
    }

    private class Chain {
        public List<Command> commands;

        Chain(Command... commandArr) {
            this.commands = Arrays.asList(commandArr);
        }

        public AttributionLayout start(AttributionMeasure attributionMeasure) {
            Iterator<Command> it = this.commands.iterator();
            AttributionLayout attributionLayout = null;
            while (it.hasNext() && (attributionLayout = it.next().execute(attributionMeasure)) == null) {
            }
            return attributionLayout;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getTextViewContainerWidth() {
        return this.textView.getMeasuredWidth() + this.margin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getLogoContainerWidth() {
        return this.logo.getWidth() + (this.margin * 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getTextViewShortContainerWidth() {
        return this.textViewShort.getMeasuredWidth() + this.margin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getLogoSmallContainerWidth() {
        return this.logoSmall.getWidth() + (this.margin * 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getMaxSize() {
        return (this.snapshot.getWidth() * 8) / 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getMaxSizeShort() {
        return this.snapshot.getWidth();
    }

    public static class Builder {
        private Bitmap logo;
        private Bitmap logoSmall;
        private float marginPadding;
        private Bitmap snapshot;
        private TextView textView;
        private TextView textViewShort;

        public Builder setSnapshot(Bitmap bitmap) {
            this.snapshot = bitmap;
            return this;
        }

        public Builder setLogo(Bitmap bitmap) {
            this.logo = bitmap;
            return this;
        }

        public Builder setLogoSmall(Bitmap bitmap) {
            this.logoSmall = bitmap;
            return this;
        }

        public Builder setTextView(TextView textView) {
            this.textView = textView;
            return this;
        }

        public Builder setTextViewShort(TextView textView) {
            this.textViewShort = textView;
            return this;
        }

        public Builder setMarginPadding(float f) {
            this.marginPadding = f;
            return this;
        }

        public AttributionMeasure build() {
            return new AttributionMeasure(this.snapshot, this.logo, this.logoSmall, this.textView, this.textViewShort, this.marginPadding);
        }
    }
}