package com.ipotensic.baselib.utils;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class SDAdaptiveTextView extends AppCompatTextView {
    public SDAdaptiveTextView(Context context) {
        super(context);
    }

    public SDAdaptiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SDAdaptiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setAdaptiveText(String str) {
        setText(str);
        setText(adaptiveText(this));
    }

    private String adaptiveText(TextView textView) {
        String charSequence = textView.getText().toString();
        TextPaint paint = textView.getPaint();
        float width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
        String[] split = charSequence.replaceAll(StringUtils.CR, "").split("\n");
        StringBuilder sb = new StringBuilder();
        for (String str : split) {
            if (paint.measureText(str) <= width) {
                sb.append(str);
            } else {
                int i = 0;
                float f = 0.0f;
                while (i != str.length()) {
                    char charAt = str.charAt(i);
                    f += paint.measureText(String.valueOf(charAt));
                    if (f <= width) {
                        sb.append(charAt);
                    } else {
                        sb.append("\n");
                        i--;
                        f = 0.0f;
                    }
                    i++;
                }
            }
        }
        return sb.toString();
    }
}
