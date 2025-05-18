package com.ipotensic.baselib.utils;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class BreakTextView extends AppCompatTextView {
    private boolean mEnabled;

    public BreakTextView(Context context) {
        super(context);
        this.mEnabled = true;
    }

    public BreakTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEnabled = true;
    }

    public BreakTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEnabled = true;
    }

    public void setAutoSplit(boolean z) {
        this.mEnabled = z;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (getWidth() <= 0 || getHeight() <= 0 || !this.mEnabled) {
            return;
        }
        CharSequence autoSplitText = autoSplitText(this);
        if (TextUtils.isEmpty(autoSplitText)) {
            return;
        }
        setText(autoSplitText);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (getWidth() > 0 && getHeight() > 0 && this.mEnabled) {
            CharSequence autoSplitText = autoSplitText(this);
            if (!TextUtils.isEmpty(autoSplitText)) {
                setText(autoSplitText);
            }
        }
        super.onMeasure(i, i2);
    }

    private CharSequence autoSplitText(TextView textView) {
        CharSequence text = textView.getText();
        String charSequence = text.toString();
        TextPaint paint = textView.getPaint();
        float width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
        String[] split = charSequence.replaceAll(StringUtils.f4244CR, "").split("\n");
        StringBuilder sb = new StringBuilder();
        for (String str : split) {
            if (paint.measureText(str) <= width) {
                sb.append(str);
            } else {
                float f = 0.0f;
                int i = 0;
                while (i != str.length()) {
                    char charAt = str.charAt(i);
                    f += paint.measureText(String.valueOf(charAt));
                    if (f <= width) {
                        sb.append(charAt);
                    } else {
                        int i2 = i - 2;
                        if (i2 >= 0) {
                            int i3 = i - 1;
                            if (str.charAt(i3) >= 'A' && str.charAt(i3) <= 'z' && str.charAt(i2) >= 'A' && str.charAt(i2) <= 'z') {
                                sb.deleteCharAt(sb.length() - 1);
                                sb.append("\n");
                                i -= 2;
                                f = 0.0f;
                            }
                        }
                        sb.append("\n");
                        i--;
                        f = 0.0f;
                    }
                    i++;
                }
            }
            sb.append("\n");
        }
        if (!charSequence.endsWith("\n")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        if (text instanceof Spanned) {
            TextUtils.copySpansFrom((Spanned) text, 0, text.length(), null, spannableString, 0);
        }
        return spannableString;
    }
}