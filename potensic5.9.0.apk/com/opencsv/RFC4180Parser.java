package com.opencsv;

import com.opencsv.enums.CSVReaderNullFieldIndicator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class RFC4180Parser extends AbstractCSVParser {
    private static final Pattern SPECIAL_REGEX_CHARS = Pattern.compile("[{}()\\[\\].+*?^$\\\\|]");
    private final String quoteCharString;
    private final String separatorAsString;

    @Override // com.opencsv.ICSVParser
    public void setErrorLocale(Locale locale) {
    }

    public RFC4180Parser() {
        this('\"', ',', CSVReaderNullFieldIndicator.NEITHER);
    }

    RFC4180Parser(char c, char c2, CSVReaderNullFieldIndicator cSVReaderNullFieldIndicator) {
        super(c2, c, cSVReaderNullFieldIndicator);
        this.separatorAsString = SPECIAL_REGEX_CHARS.matcher(Character.toString(c2)).replaceAll("\\\\$0");
        this.quoteCharString = Character.toString(c);
    }

    @Override // com.opencsv.AbstractCSVParser
    /* renamed from: convertToCsvValue */
    protected String lambda$parseToLine$0$AbstractCSVParser(String str, boolean z) {
        String str2 = (str != null || this.nullFieldIndicator.equals(CSVReaderNullFieldIndicator.NEITHER)) ? str : "";
        StringBuilder sb = new StringBuilder(str2 == null ? 16 : str2.length() * 2);
        boolean z2 = true;
        boolean z3 = str2 != null && str2.contains(Character.toString(getQuotechar()));
        if (!z && !isSurroundWithQuotes(str, z3)) {
            z2 = false;
        }
        if (z3) {
            str2 = str2.replaceAll(Character.toString(getQuotechar()), Character.toString(getQuotechar()) + Character.toString(getQuotechar()));
        }
        if (z2) {
            sb.append(getQuotechar());
        }
        sb.append(str2);
        if (z2) {
            sb.append(getQuotechar());
        }
        return sb.toString();
    }

    @Override // com.opencsv.AbstractCSVParser
    protected String[] parseLine(String str, boolean z) {
        if (!z && this.pending != null) {
            this.pending = null;
        }
        if (str == null) {
            if (this.pending == null) {
                return null;
            }
            String str2 = this.pending;
            this.pending = null;
            return new String[]{str2};
        }
        if (z && this.pending != null) {
            str = this.pending + str;
        }
        this.pending = null;
        if (!StringUtils.contains(str, this.quotechar)) {
            return handleEmptySeparators(tokenizeStringIntoArray(str));
        }
        String[] handleEmptySeparators = handleEmptySeparators(splitWhileNotInQuotes(str, z));
        for (int i = 0; i < handleEmptySeparators.length; i++) {
            if (StringUtils.contains(handleEmptySeparators[i], this.quotechar)) {
                handleEmptySeparators[i] = handleQuotes(handleEmptySeparators[i]);
            }
        }
        return handleEmptySeparators;
    }

    private String[] tokenizeStringIntoArray(String str) {
        return str.split(this.separatorAsString, -1);
    }

    private String[] handleEmptySeparators(String[] strArr) {
        if (this.nullFieldIndicator == CSVReaderNullFieldIndicator.EMPTY_SEPARATORS || this.nullFieldIndicator == CSVReaderNullFieldIndicator.BOTH) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].isEmpty()) {
                    strArr[i] = null;
                }
            }
        }
        return strArr;
    }

    private String[] splitWhileNotInQuotes(String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < str.length()) {
            int indexOf = str.indexOf(this.separator, i);
            int indexOf2 = str.indexOf(this.quotechar, i);
            if (indexOf == -1) {
                arrayList.add(str.substring(i));
                i = str.length();
            } else {
                if (indexOf2 == -1 || indexOf2 > indexOf || indexOf2 != i) {
                    arrayList.add(str.substring(i, indexOf));
                } else {
                    indexOf = findEndOfFieldFromPosition(str, i);
                    arrayList.add(indexOf >= str.length() ? str.substring(i) : str.substring(i, indexOf));
                }
                i = indexOf + 1;
            }
        }
        if (z && lastElementStartedWithQuoteButDidNotEndInOne(arrayList)) {
            this.pending = arrayList.get(arrayList.size() - 1) + "\n";
            arrayList.remove(arrayList.size() - 1);
        } else if (str.lastIndexOf(this.separator) == str.length() - 1) {
            arrayList.add("");
        }
        return (String[]) arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    private boolean lastElementStartedWithQuoteButDidNotEndInOne(List<String> list) {
        String str = list.get(list.size() - 1);
        return startsButDoesNotEndWithQuote(str) || hasOnlyOneQuote(str) || hasOddQuotes(str);
    }

    private boolean hasOddQuotes(String str) {
        return StringUtils.countMatches(str, this.quotechar) % 2 != 0;
    }

    private boolean hasOnlyOneQuote(String str) {
        return StringUtils.countMatches(str, this.quotechar) == 1;
    }

    private boolean startsButDoesNotEndWithQuote(String str) {
        return str.startsWith(Character.toString(this.quotechar)) && !str.endsWith(Character.toString(this.quotechar));
    }

    private int findEndOfFieldFromPosition(String str, int i) {
        int indexOf = str.indexOf(this.quotechar, i + 1);
        boolean z = false;
        while (haveNotFoundLastQuote(str, indexOf)) {
            if (!z) {
                int i2 = indexOf + 1;
                if (str.charAt(i2) == this.separator) {
                    return i2;
                }
            }
            do {
                indexOf = str.indexOf(this.quotechar, indexOf + 1);
                z = !z;
                if (haveNotFoundLastQuote(str, indexOf)) {
                }
            } while (str.charAt(indexOf + 1) == this.quotechar);
        }
        return str.length();
    }

    private boolean haveNotFoundLastQuote(String str, int i) {
        return i != -1 && i < str.length() - 1;
    }

    private String handleQuotes(String str) {
        if (!hasOnlyOneQuote(str) && str.startsWith(this.quoteCharString)) {
            str = StringUtils.removeEnd(StringUtils.removeStart(str, this.quoteCharString), this.quoteCharString);
        }
        String replace = StringUtils.replace(str, this.quoteCharString + this.quoteCharString, this.quoteCharString);
        if (!replace.isEmpty()) {
            return replace;
        }
        if (this.nullFieldIndicator == CSVReaderNullFieldIndicator.BOTH || this.nullFieldIndicator == CSVReaderNullFieldIndicator.EMPTY_QUOTES) {
            return null;
        }
        return replace;
    }

    @Override // com.opencsv.AbstractCSVParser, com.opencsv.ICSVParser
    public CSVReaderNullFieldIndicator nullFieldIndicator() {
        return this.nullFieldIndicator;
    }

    @Override // com.opencsv.AbstractCSVParser, com.opencsv.ICSVParser
    public String getPendingText() {
        return StringUtils.defaultString(this.pending);
    }
}