package org.apache.poi.xslf.usermodel;

import java.awt.Graphics2D;
import java.awt.font.TextLayout;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

/* loaded from: classes5.dex */
class TextFragment {
    final TextLayout _layout;
    final AttributedString _str;

    TextFragment(TextLayout textLayout, AttributedString attributedString) {
        this._layout = textLayout;
        this._str = attributedString;
    }

    void draw(Graphics2D graphics2D, double d, double d2) {
        if (this._str == null) {
            return;
        }
        double ascent = d2 + this._layout.getAscent();
        Integer num = (Integer) graphics2D.getRenderingHint(XSLFRenderingHint.TEXT_RENDERING_MODE);
        if (num != null && num.intValue() == 2) {
            this._layout.draw(graphics2D, (float) d, (float) ascent);
        } else {
            graphics2D.drawString(this._str.getIterator(), (float) d, (float) ascent);
        }
    }

    public float getHeight() {
        return (float) (Math.ceil(this._layout.getAscent()) + Math.ceil(this._layout.getDescent()) + this._layout.getLeading());
    }

    public float getWidth() {
        return this._layout.getAdvance();
    }

    public String getString() {
        AttributedString attributedString = this._str;
        if (attributedString == null) {
            return "";
        }
        AttributedCharacterIterator iterator = attributedString.getIterator();
        StringBuffer stringBuffer = new StringBuffer();
        for (char first = iterator.first(); first != 65535; first = iterator.next()) {
            stringBuffer.append(first);
        }
        return stringBuffer.toString();
    }

    public String toString() {
        return "[" + getClass().getSimpleName() + "] " + getString();
    }
}
