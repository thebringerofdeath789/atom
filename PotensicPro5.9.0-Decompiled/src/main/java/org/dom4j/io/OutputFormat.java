package org.dom4j.io;

import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class OutputFormat implements Cloneable {
    protected static final String STANDARD_INDENT = "  ";
    private char attributeQuoteChar;
    private boolean doXHTML;
    private String encoding;
    private boolean expandEmptyElements;
    private String indent;
    private String lineSeparator;
    private boolean newLineAfterDeclaration;
    private int newLineAfterNTags;
    private boolean newlines;
    private boolean omitEncoding;
    private boolean padText;
    private boolean suppressDeclaration;
    private boolean trimText;

    public OutputFormat() {
        this.suppressDeclaration = false;
        this.newLineAfterDeclaration = true;
        this.encoding = "UTF-8";
        this.omitEncoding = false;
        this.indent = null;
        this.expandEmptyElements = false;
        this.newlines = false;
        this.lineSeparator = "\n";
        this.trimText = false;
        this.padText = false;
        this.doXHTML = false;
        this.newLineAfterNTags = 0;
        this.attributeQuoteChar = '\"';
    }

    public OutputFormat(String str) {
        this.suppressDeclaration = false;
        this.newLineAfterDeclaration = true;
        this.encoding = "UTF-8";
        this.omitEncoding = false;
        this.indent = null;
        this.expandEmptyElements = false;
        this.newlines = false;
        this.lineSeparator = "\n";
        this.trimText = false;
        this.padText = false;
        this.doXHTML = false;
        this.newLineAfterNTags = 0;
        this.attributeQuoteChar = '\"';
        this.indent = str;
    }

    public OutputFormat(String str, boolean z) {
        this.suppressDeclaration = false;
        this.newLineAfterDeclaration = true;
        this.encoding = "UTF-8";
        this.omitEncoding = false;
        this.indent = null;
        this.expandEmptyElements = false;
        this.newlines = false;
        this.lineSeparator = "\n";
        this.trimText = false;
        this.padText = false;
        this.doXHTML = false;
        this.newLineAfterNTags = 0;
        this.attributeQuoteChar = '\"';
        this.indent = str;
        this.newlines = z;
    }

    public OutputFormat(String str, boolean z, String str2) {
        this.suppressDeclaration = false;
        this.newLineAfterDeclaration = true;
        this.encoding = "UTF-8";
        this.omitEncoding = false;
        this.indent = null;
        this.expandEmptyElements = false;
        this.newlines = false;
        this.lineSeparator = "\n";
        this.trimText = false;
        this.padText = false;
        this.doXHTML = false;
        this.newLineAfterNTags = 0;
        this.attributeQuoteChar = '\"';
        this.indent = str;
        this.newlines = z;
        this.encoding = str2;
    }

    public String getLineSeparator() {
        return this.lineSeparator;
    }

    public void setLineSeparator(String str) {
        this.lineSeparator = str;
    }

    public boolean isNewlines() {
        return this.newlines;
    }

    public void setNewlines(boolean z) {
        this.newlines = z;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public void setEncoding(String str) {
        if (str != null) {
            this.encoding = str;
        }
    }

    public boolean isOmitEncoding() {
        return this.omitEncoding;
    }

    public void setOmitEncoding(boolean z) {
        this.omitEncoding = z;
    }

    public void setSuppressDeclaration(boolean z) {
        this.suppressDeclaration = z;
    }

    public boolean isSuppressDeclaration() {
        return this.suppressDeclaration;
    }

    public void setNewLineAfterDeclaration(boolean z) {
        this.newLineAfterDeclaration = z;
    }

    public boolean isNewLineAfterDeclaration() {
        return this.newLineAfterDeclaration;
    }

    public boolean isExpandEmptyElements() {
        return this.expandEmptyElements;
    }

    public void setExpandEmptyElements(boolean z) {
        this.expandEmptyElements = z;
    }

    public boolean isTrimText() {
        return this.trimText;
    }

    public void setTrimText(boolean z) {
        this.trimText = z;
    }

    public boolean isPadText() {
        return this.padText;
    }

    public void setPadText(boolean z) {
        this.padText = z;
    }

    public String getIndent() {
        return this.indent;
    }

    public void setIndent(String str) {
        if (str != null && str.length() <= 0) {
            str = null;
        }
        this.indent = str;
    }

    public void setIndent(boolean z) {
        if (z) {
            this.indent = STANDARD_INDENT;
        } else {
            this.indent = null;
        }
    }

    public void setIndentSize(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(StringUtils.SPACE);
        }
        this.indent = stringBuffer.toString();
    }

    public boolean isXHTML() {
        return this.doXHTML;
    }

    public void setXHTML(boolean z) {
        this.doXHTML = z;
    }

    public int getNewLineAfterNTags() {
        return this.newLineAfterNTags;
    }

    public void setNewLineAfterNTags(int i) {
        this.newLineAfterNTags = i;
    }

    public char getAttributeQuoteCharacter() {
        return this.attributeQuoteChar;
    }

    public void setAttributeQuoteCharacter(char c) {
        if (c == '\'' || c == '\"') {
            this.attributeQuoteChar = c;
            return;
        }
        throw new IllegalArgumentException(new StringBuffer().append("Invalid attribute quote character (").append(c).append(")").toString());
    }

    public int parseOptions(String[] strArr, int i) {
        int length = strArr.length;
        while (i < length) {
            if (strArr[i].equals("-suppressDeclaration")) {
                setSuppressDeclaration(true);
            } else if (strArr[i].equals("-omitEncoding")) {
                setOmitEncoding(true);
            } else if (strArr[i].equals("-indent")) {
                i++;
                setIndent(strArr[i]);
            } else if (strArr[i].equals("-indentSize")) {
                i++;
                setIndentSize(Integer.parseInt(strArr[i]));
            } else if (strArr[i].startsWith("-expandEmpty")) {
                setExpandEmptyElements(true);
            } else if (strArr[i].equals("-encoding")) {
                i++;
                setEncoding(strArr[i]);
            } else if (strArr[i].equals("-newlines")) {
                setNewlines(true);
            } else if (strArr[i].equals("-lineSeparator")) {
                i++;
                setLineSeparator(strArr[i]);
            } else if (strArr[i].equals("-trimText")) {
                setTrimText(true);
            } else if (strArr[i].equals("-padText")) {
                setPadText(true);
            } else {
                if (!strArr[i].startsWith("-xhtml")) {
                    break;
                }
                setXHTML(true);
            }
            i++;
        }
        return i;
    }

    public static OutputFormat createPrettyPrint() {
        OutputFormat outputFormat = new OutputFormat();
        outputFormat.setIndentSize(2);
        outputFormat.setNewlines(true);
        outputFormat.setTrimText(true);
        outputFormat.setPadText(true);
        return outputFormat;
    }

    public static OutputFormat createCompactFormat() {
        OutputFormat outputFormat = new OutputFormat();
        outputFormat.setIndent(false);
        outputFormat.setNewlines(false);
        outputFormat.setTrimText(true);
        return outputFormat;
    }
}
