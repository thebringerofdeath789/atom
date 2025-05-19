package org.apache.poi.hssf.usermodel;

import org.apache.poi.xssf.usermodel.helpers.HeaderFooterHelper;

/* loaded from: classes5.dex */
public abstract class HeaderFooter implements org.apache.poi.ss.usermodel.HeaderFooter {
    protected abstract String getRawText();

    protected abstract void setHeaderFooterText(String str);

    protected HeaderFooter() {
    }

    private String[] splitParts() {
        String rawText = getRawText();
        String str = "";
        String str2 = "";
        String str3 = str2;
        while (true) {
            if (rawText.length() <= 1) {
                rawText = str2;
                break;
            }
            if (rawText.charAt(0) != '&') {
                break;
            }
            int length = rawText.length();
            char charAt = rawText.charAt(1);
            if (charAt == 'C') {
                if (rawText.indexOf("&L") >= 0) {
                    length = Math.min(length, rawText.indexOf("&L"));
                }
                if (rawText.indexOf("&R") >= 0) {
                    length = Math.min(length, rawText.indexOf("&R"));
                }
                str2 = rawText.substring(2, length);
                rawText = rawText.substring(length);
            } else if (charAt == 'L') {
                if (rawText.indexOf("&C") >= 0) {
                    length = Math.min(length, rawText.indexOf("&C"));
                }
                if (rawText.indexOf("&R") >= 0) {
                    length = Math.min(length, rawText.indexOf("&R"));
                }
                str = rawText.substring(2, length);
                rawText = rawText.substring(length);
            } else {
                if (charAt != 'R') {
                    break;
                }
                if (rawText.indexOf("&C") >= 0) {
                    length = Math.min(length, rawText.indexOf("&C"));
                }
                if (rawText.indexOf("&L") >= 0) {
                    length = Math.min(length, rawText.indexOf("&L"));
                }
                str3 = rawText.substring(2, length);
                rawText = rawText.substring(length);
            }
        }
        return new String[]{str, rawText, str3};
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public final String getLeft() {
        return splitParts()[0];
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public final void setLeft(String str) {
        updatePart(0, str);
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public final String getCenter() {
        return splitParts()[1];
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public final void setCenter(String str) {
        updatePart(1, str);
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public final String getRight() {
        return splitParts()[2];
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public final void setRight(String str) {
        updatePart(2, str);
    }

    private void updatePart(int i, String str) {
        String[] splitParts = splitParts();
        if (str == null) {
            str = "";
        }
        splitParts[i] = str;
        updateHeaderFooterText(splitParts);
    }

    private void updateHeaderFooterText(String[] strArr) {
        String str = strArr[0];
        String str2 = strArr[1];
        String str3 = strArr[2];
        if (str2.length() < 1 && str.length() < 1 && str3.length() < 1) {
            setHeaderFooterText("");
            return;
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append("&C");
        sb.append(str2);
        sb.append("&L");
        sb.append(str);
        sb.append("&R");
        sb.append(str3);
        setHeaderFooterText(sb.toString());
    }

    public static String fontSize(short s) {
        return "&" + ((int) s);
    }

    public static String font(String str, String str2) {
        return "&\"" + str + "," + str2 + "\"";
    }

    public static String page() {
        return MarkupTag.PAGE_FIELD.getRepresentation();
    }

    public static String numPages() {
        return MarkupTag.NUM_PAGES_FIELD.getRepresentation();
    }

    public static String date() {
        return MarkupTag.DATE_FIELD.getRepresentation();
    }

    public static String time() {
        return MarkupTag.TIME_FIELD.getRepresentation();
    }

    public static String file() {
        return MarkupTag.FILE_FIELD.getRepresentation();
    }

    public static String tab() {
        return MarkupTag.SHEET_NAME_FIELD.getRepresentation();
    }

    public static String startBold() {
        return MarkupTag.BOLD_FIELD.getRepresentation();
    }

    public static String endBold() {
        return MarkupTag.BOLD_FIELD.getRepresentation();
    }

    public static String startUnderline() {
        return MarkupTag.UNDERLINE_FIELD.getRepresentation();
    }

    public static String endUnderline() {
        return MarkupTag.UNDERLINE_FIELD.getRepresentation();
    }

    public static String startDoubleUnderline() {
        return MarkupTag.DOUBLE_UNDERLINE_FIELD.getRepresentation();
    }

    public static String endDoubleUnderline() {
        return MarkupTag.DOUBLE_UNDERLINE_FIELD.getRepresentation();
    }

    public static String stripFields(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        for (MarkupTag markupTag : MarkupTag.values()) {
            String representation = markupTag.getRepresentation();
            while (true) {
                int indexOf = str.indexOf(representation);
                if (indexOf > -1) {
                    str = str.substring(0, indexOf) + str.substring(indexOf + representation.length());
                }
            }
        }
        return str.replaceAll("\\&\\d+", "").replaceAll("\\&\".*?,.*?\"", "");
    }

    private enum MarkupTag {
        SHEET_NAME_FIELD("&A", false),
        DATE_FIELD(HeaderFooterHelper.HeaderFooterEntity_Date, false),
        FILE_FIELD(HeaderFooterHelper.HeaderFooterEntity_File, false),
        FULL_FILE_FIELD("&Z", false),
        PAGE_FIELD("&P", false),
        TIME_FIELD(HeaderFooterHelper.HeaderFooterEntity_Time, false),
        NUM_PAGES_FIELD("&N", false),
        PICTURE_FIELD("&G", false),
        BOLD_FIELD("&B", true),
        ITALIC_FIELD("&I", true),
        STRIKETHROUGH_FIELD("&S", true),
        SUBSCRIPT_FIELD("&Y", true),
        SUPERSCRIPT_FIELD("&X", true),
        UNDERLINE_FIELD("&U", true),
        DOUBLE_UNDERLINE_FIELD("&E", true);

        private final boolean _occursInPairs;
        private final String _representation;

        MarkupTag(String str, boolean z) {
            this._representation = str;
            this._occursInPairs = z;
        }

        public String getRepresentation() {
            return this._representation;
        }

        public boolean occursPairs() {
            return this._occursInPairs;
        }
    }
}
