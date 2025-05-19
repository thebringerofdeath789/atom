package org.jdom.output;

import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class Format implements Cloneable {
    private static final String CVS_ID = "@(#) $RCSfile: Format.java,v $ $Revision: 1.10 $ $Date: 2004/09/07 06:37:20 $ $Name: jdom_1_0 $";
    private static final String STANDARD_ENCODING = "UTF-8";
    private static final String STANDARD_INDENT = "  ";
    private static final String STANDARD_LINE_SEPARATOR = "\r\n";
    static /* synthetic */ Class class$java$lang$String;
    String indent = null;
    String lineSeparator = "\r\n";
    String encoding = "UTF-8";
    boolean omitDeclaration = false;
    boolean omitEncoding = false;
    boolean expandEmptyElements = false;
    boolean ignoreTrAXEscapingPIs = false;
    TextMode mode = TextMode.PRESERVE;
    EscapeStrategy escapeStrategy = new DefaultEscapeStrategy(this.encoding);

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static Format getRawFormat() {
        return new Format();
    }

    public static Format getPrettyFormat() {
        Format format = new Format();
        format.setIndent(STANDARD_INDENT);
        format.setTextMode(TextMode.TRIM);
        return format;
    }

    public static Format getCompactFormat() {
        Format format = new Format();
        format.setTextMode(TextMode.NORMALIZE);
        return format;
    }

    private Format() {
    }

    public Format setEscapeStrategy(EscapeStrategy escapeStrategy) {
        this.escapeStrategy = escapeStrategy;
        return this;
    }

    public EscapeStrategy getEscapeStrategy() {
        return this.escapeStrategy;
    }

    public Format setLineSeparator(String str) {
        this.lineSeparator = str;
        return this;
    }

    public String getLineSeparator() {
        return this.lineSeparator;
    }

    public Format setOmitEncoding(boolean z) {
        this.omitEncoding = z;
        return this;
    }

    public boolean getOmitEncoding() {
        return this.omitEncoding;
    }

    public Format setOmitDeclaration(boolean z) {
        this.omitDeclaration = z;
        return this;
    }

    public boolean getOmitDeclaration() {
        return this.omitDeclaration;
    }

    public Format setExpandEmptyElements(boolean z) {
        this.expandEmptyElements = z;
        return this;
    }

    public boolean getExpandEmptyElements() {
        return this.expandEmptyElements;
    }

    public void setIgnoreTrAXEscapingPIs(boolean z) {
        this.ignoreTrAXEscapingPIs = z;
    }

    public boolean getIgnoreTrAXEscapingPIs() {
        return this.ignoreTrAXEscapingPIs;
    }

    public Format setTextMode(TextMode textMode) {
        this.mode = textMode;
        return this;
    }

    public TextMode getTextMode() {
        return this.mode;
    }

    public Format setIndent(String str) {
        if ("".equals(str)) {
            str = null;
        }
        this.indent = str;
        return this;
    }

    public String getIndent() {
        return this.indent;
    }

    public Format setEncoding(String str) {
        this.encoding = str;
        this.escapeStrategy = new DefaultEscapeStrategy(str);
        return this;
    }

    public String getEncoding() {
        return this.encoding;
    }

    protected Object clone() {
        try {
            return (Format) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    class DefaultEscapeStrategy implements EscapeStrategy {
        private int bits;
        Method canEncode;
        Object encoder;

        public DefaultEscapeStrategy(String str) {
            Class<?> class$;
            if ("UTF-8".equalsIgnoreCase(str) || "UTF-16".equalsIgnoreCase(str)) {
                this.bits = 16;
                return;
            }
            if ("ISO-8859-1".equalsIgnoreCase(str) || "Latin1".equalsIgnoreCase(str)) {
                this.bits = 8;
                return;
            }
            if ("US-ASCII".equalsIgnoreCase(str) || "ASCII".equalsIgnoreCase(str)) {
                this.bits = 7;
                return;
            }
            this.bits = 0;
            try {
                Class<?> cls = Class.forName("java.nio.charset.Charset");
                Class<?> cls2 = Class.forName("java.nio.charset.CharsetEncoder");
                Class<?>[] clsArr = new Class[1];
                if (Format.class$java$lang$String != null) {
                    class$ = Format.class$java$lang$String;
                } else {
                    class$ = Format.class$("java.lang.String");
                    Format.class$java$lang$String = class$;
                }
                clsArr[0] = class$;
                this.encoder = cls.getMethod("newEncoder", null).invoke(cls.getMethod("forName", clsArr).invoke(null, str), null);
                this.canEncode = cls2.getMethod("canEncode", Character.TYPE);
            } catch (Exception unused) {
            }
        }

        @Override // org.jdom.output.EscapeStrategy
        public boolean shouldEscape(char c) {
            Object obj;
            int i = this.bits;
            if (i == 16) {
                return false;
            }
            if (i == 8) {
                return c > 255;
            }
            if (i == 7) {
                return c > 127;
            }
            if (this.canEncode != null && (obj = this.encoder) != null) {
                try {
                    return !((Boolean) r0.invoke(obj, new Character(c))).booleanValue();
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public static class TextMode {
        private final String name;
        public static final TextMode PRESERVE = new TextMode("PRESERVE");
        public static final TextMode TRIM = new TextMode("TRIM");
        public static final TextMode NORMALIZE = new TextMode("NORMALIZE");
        public static final TextMode TRIM_FULL_WHITE = new TextMode("TRIM_FULL_WHITE");

        private TextMode(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }
}
