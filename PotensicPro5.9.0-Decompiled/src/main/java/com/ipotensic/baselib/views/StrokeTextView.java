package com.ipotensic.baselib.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.ipotensic.baselib.R;

/* loaded from: classes2.dex */
public class StrokeTextView extends AppCompatTextView {
    public TextView borderText;
    private int colors;
    private Context context;
    private TextPaint tp1;

    public StrokeTextView(Context context) {
        this(context, null);
    }

    public StrokeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StrokeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.borderText = null;
        this.borderText = new TextView(context, attributeSet);
        this.context = context;
        init(attributeSet);
    }

    public void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.StrokeTextView);
        this.colors = obtainStyledAttributes.getColor(R.styleable.StrokeTextView_stroke_color, getContext().getColor(R.color.black));
        obtainStyledAttributes.recycle();
        TextPaint paint = this.borderText.getPaint();
        this.tp1 = paint;
        paint.setStrokeWidth(2.0f);
        this.tp1.setStyle(Paint.Style.STROKE);
        this.borderText.setTextColor(this.colors);
        this.borderText.setGravity(getGravity());
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
        TextPaint textPaint = this.tp1;
        if (textPaint != null) {
            textPaint.setTypeface(typeface);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.borderText.setLayoutParams(layoutParams);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        CharSequence text = this.borderText.getText();
        if (text == null || !text.equals(getText())) {
            this.borderText.setText(getText());
            postInvalidate();
        }
        super.onMeasure(i, i2);
        this.borderText.measure(i, i2);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        CharSequence text;
        TextView textView = this.borderText;
        if (textView != null && ((text = textView.getText()) == null || !text.equals(charSequence))) {
            this.borderText.setText(charSequence);
        }
        super.setText(charSequence, bufferType);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.borderText.layout(i, i2, i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.borderText.draw(canvas);
        super.onDraw(canvas);
    }
}
