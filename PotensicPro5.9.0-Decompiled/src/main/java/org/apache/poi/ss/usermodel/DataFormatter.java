package org.apache.poi.ss.usermodel;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.opencsv.ICSVParser;
import java.math.RoundingMode;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes5.dex */
public class DataFormatter {
    private static final String defaultFractionFractionPartFormat = "#/##";
    private static final String defaultFractionWholePartFormat = "#";
    private static final String invalidDateTimeString;
    private final DateFormatSymbols dateSymbols;
    private final DecimalFormatSymbols decimalSymbols;
    private Format defaultNumFormat;
    private boolean emulateCsv;
    private final Map<String, Format> formats;
    private final Format generalDecimalNumFormat;
    private final Format generalWholeNumFormat;
    private static final Pattern numPattern = Pattern.compile("[0#]+");
    private static final Pattern daysAsText = Pattern.compile("([d]{3,})", 2);
    private static final Pattern amPmPattern = Pattern.compile("((A|P)[M/P]*)", 2);
    private static final Pattern localePatternGroup = Pattern.compile("(\\[\\$[^-\\]]*-[0-9A-Z]+\\])");
    private static final Pattern colorPattern = Pattern.compile("(\\[BLACK\\])|(\\[BLUE\\])|(\\[CYAN\\])|(\\[GREEN\\])|(\\[MAGENTA\\])|(\\[RED\\])|(\\[WHITE\\])|(\\[YELLOW\\])|(\\[COLOR\\s*\\d\\])|(\\[COLOR\\s*[0-5]\\d\\])", 2);
    private static final Pattern fractionPattern = Pattern.compile("(?:([#\\d]+)\\s+)?(#+)\\s*\\/\\s*([#\\d]+)");
    private static final Pattern fractionStripper = Pattern.compile("(\"[^\"]*\")|([^ \\?#\\d\\/]+)");

    static {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 255; i++) {
            sb.append('#');
        }
        invalidDateTimeString = sb.toString();
    }

    public DataFormatter() {
        this(false);
    }

    public DataFormatter(boolean z) {
        this(Locale.getDefault());
        this.emulateCsv = z;
    }

    public DataFormatter(Locale locale, boolean z) {
        this(locale);
        this.emulateCsv = z;
    }

    public DataFormatter(Locale locale) {
        this.emulateCsv = false;
        this.dateSymbols = new DateFormatSymbols(locale);
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(locale);
        this.decimalSymbols = decimalFormatSymbols;
        this.generalWholeNumFormat = new DecimalFormat(defaultFractionWholePartFormat, decimalFormatSymbols);
        this.generalDecimalNumFormat = new DecimalFormat("#.##########", decimalFormatSymbols);
        this.formats = new HashMap();
        Format format = ZipPlusFourFormat.instance;
        addFormat("00000\\-0000", format);
        addFormat("00000-0000", format);
        Format format2 = PhoneFormat.instance;
        addFormat("[<=9999999]###\\-####;\\(###\\)\\ ###\\-####", format2);
        addFormat("[<=9999999]###-####;(###) ###-####", format2);
        addFormat("###\\-####;\\(###\\)\\ ###\\-####", format2);
        addFormat("###-####;(###) ###-####", format2);
        Format format3 = SSNFormat.instance;
        addFormat("000\\-00\\-0000", format3);
        addFormat("000-00-0000", format3);
    }

    private Format getFormat(Cell cell) {
        if (cell.getCellStyle() == null) {
            return null;
        }
        short dataFormat = cell.getCellStyle().getDataFormat();
        String dataFormatString = cell.getCellStyle().getDataFormatString();
        if (dataFormatString == null || dataFormatString.trim().length() == 0) {
            return null;
        }
        return getFormat(cell.getNumericCellValue(), dataFormat, dataFormatString);
    }

    private Format getFormat(double d, int i, String str) {
        int indexOf = str.indexOf(59);
        int lastIndexOf = str.lastIndexOf(59);
        if (indexOf != -1 && indexOf != lastIndexOf) {
            int indexOf2 = str.indexOf(59, indexOf + 1);
            if (indexOf2 == lastIndexOf) {
                if (d == 0.0d) {
                    str = str.substring(lastIndexOf + 1);
                } else {
                    str = str.substring(0, lastIndexOf);
                }
            } else if (d == 0.0d) {
                str = str.substring(indexOf2 + 1, lastIndexOf);
            } else {
                str = str.substring(0, indexOf2);
            }
        }
        if (this.emulateCsv && d == 0.0d && str.contains(defaultFractionWholePartFormat) && !str.contains(SessionDescription.SUPPORTED_SDP_VERSION)) {
            str = str.replaceAll(defaultFractionWholePartFormat, "");
        }
        Format format = this.formats.get(str);
        if (format != null) {
            return format;
        }
        if ("General".equalsIgnoreCase(str) || "@".equals(str)) {
            if (isWholeNumber(d)) {
                return this.generalWholeNumFormat;
            }
            return this.generalDecimalNumFormat;
        }
        Format createFormat = createFormat(d, i, str);
        this.formats.put(str, createFormat);
        return createFormat;
    }

    public Format createFormat(Cell cell) {
        return createFormat(cell.getNumericCellValue(), cell.getCellStyle().getDataFormat(), cell.getCellStyle().getDataFormatString());
    }

    private Format createFormat(double d, int i, String str) {
        int i2;
        String group;
        int indexOf;
        Matcher matcher = colorPattern.matcher(str);
        while (true) {
            i2 = 0;
            if (!matcher.find() || (indexOf = str.indexOf((group = matcher.group()))) == -1) {
                break;
            }
            String str2 = str.substring(0, indexOf) + str.substring(indexOf + group.length());
            if (str2.equals(str)) {
                break;
            }
            matcher = colorPattern.matcher(str2);
            str = str2;
        }
        Matcher matcher2 = localePatternGroup.matcher(str);
        while (matcher2.find()) {
            String group2 = matcher2.group();
            String substring = group2.substring(group2.indexOf(36) + 1, group2.indexOf(45));
            if (substring.indexOf(36) > -1) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(substring.substring(0, substring.indexOf(36)));
                stringBuffer.append(ICSVParser.DEFAULT_ESCAPE_CHARACTER);
                stringBuffer.append(substring.substring(substring.indexOf(36), substring.length()));
                substring = stringBuffer.toString();
            }
            str = matcher2.replaceAll(substring);
            matcher2 = localePatternGroup.matcher(str);
        }
        if (str == null || str.trim().length() == 0) {
            return getDefaultFormat(d);
        }
        if ("General".equalsIgnoreCase(str) || "@".equals(str)) {
            if (isWholeNumber(d)) {
                return this.generalWholeNumFormat;
            }
            return this.generalDecimalNumFormat;
        }
        if (DateUtil.isADateFormat(i, str) && DateUtil.isValidExcelDate(d)) {
            return createDateFormat(str, d);
        }
        if (str.indexOf("#/") >= 0 || str.indexOf("?/") >= 0) {
            String[] split = str.split(";");
            while (true) {
                int length = split.length;
                String str3 = defaultFractionWholePartFormat;
                if (i2 < length) {
                    Matcher matcher3 = fractionPattern.matcher(fractionStripper.matcher(split[i2].replaceAll("\\?", defaultFractionWholePartFormat)).replaceAll(StringUtils.SPACE).replaceAll(" +", StringUtils.SPACE));
                    if (matcher3.find()) {
                        if (matcher3.group(1) == null) {
                            str3 = "";
                        }
                        return new FractionFormat(str3, matcher3.group(3));
                    }
                    i2++;
                } else {
                    return new FractionFormat(defaultFractionWholePartFormat, defaultFractionFractionPartFormat);
                }
            }
        } else {
            if (numPattern.matcher(str).find()) {
                return createNumberFormat(str, d);
            }
            if (this.emulateCsv) {
                return new ConstantStringFormat(cleanFormatForNumber(str));
            }
            return null;
        }
    }

    private Format createDateFormat(String str, double d) {
        char c;
        String replaceAll = str.replaceAll("\\\\-", "-").replaceAll("\\\\,", ",").replaceAll("\\\\\\.", ".").replaceAll("\\\\ ", StringUtils.SPACE).replaceAll("\\\\/", InternalZipConstants.ZIP_FILE_SEPARATOR).replaceAll(";@", "").replaceAll("\"/\"", InternalZipConstants.ZIP_FILE_SEPARATOR).replace("\"\"", "'").replaceAll("\\\\T", "'T'");
        Matcher matcher = amPmPattern.matcher(replaceAll);
        boolean z = false;
        boolean z2 = false;
        while (matcher.find()) {
            replaceAll = matcher.replaceAll("@");
            matcher = amPmPattern.matcher(replaceAll);
            z2 = true;
        }
        String replaceAll2 = replaceAll.replaceAll("@", "a");
        Matcher matcher2 = daysAsText.matcher(replaceAll2);
        if (matcher2.find()) {
            replaceAll2 = matcher2.replaceAll(matcher2.group(0).toUpperCase().replaceAll("D", "E"));
        }
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = replaceAll2.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z3 = false;
        boolean z4 = true;
        while (i < charArray.length) {
            char c2 = charArray[i];
            if (c2 == '\'') {
                stringBuffer.append(c2);
                do {
                    i++;
                    if (i < charArray.length) {
                        c = charArray[i];
                        stringBuffer.append(c);
                    }
                } while (c != '\'');
            } else if (c2 == '[' && !z3) {
                stringBuffer.append(c2);
                z4 = z;
                z3 = true;
            } else if (c2 == ']' && z3) {
                stringBuffer.append(c2);
                z3 = z;
            } else if (z3) {
                if (c2 == 'h' || c2 == 'H') {
                    stringBuffer.append('H');
                } else if (c2 == 'm' || c2 == 'M') {
                    stringBuffer.append('m');
                } else if (c2 == 's' || c2 == 'S') {
                    stringBuffer.append('s');
                } else {
                    stringBuffer.append(c2);
                }
            } else if (c2 == 'h' || c2 == 'H') {
                if (z2) {
                    stringBuffer.append('h');
                } else {
                    stringBuffer.append('H');
                }
                z4 = false;
            } else if (c2 != 'm' && c2 != 'M') {
                if (c2 == 's' || c2 == 'S') {
                    stringBuffer.append('s');
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        int intValue = ((Integer) arrayList.get(i2)).intValue();
                        if (stringBuffer.charAt(intValue) == 'M') {
                            stringBuffer.replace(intValue, intValue + 1, "m");
                        }
                    }
                    arrayList.clear();
                } else if (Character.isLetter(c2)) {
                    arrayList.clear();
                    if (c2 == 'y' || c2 == 'Y') {
                        stringBuffer.append('y');
                    } else if (c2 == 'd' || c2 == 'D') {
                        stringBuffer.append('d');
                    } else {
                        stringBuffer.append(c2);
                    }
                } else {
                    stringBuffer.append(c2);
                }
                z4 = true;
            } else if (z4) {
                stringBuffer.append('M');
                arrayList.add(Integer.valueOf(stringBuffer.length() - 1));
            } else {
                stringBuffer.append('m');
            }
            i++;
            z = false;
        }
        try {
            return new ExcelStyleDateFormatter(stringBuffer.toString(), this.dateSymbols);
        } catch (IllegalArgumentException unused) {
            return getDefaultFormat(d);
        }
    }

    private String cleanFormatForNumber(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        int i = 0;
        if (this.emulateCsv) {
            int i2 = 0;
            while (i2 < stringBuffer.length()) {
                char charAt = stringBuffer.charAt(i2);
                if ((charAt == '_' || charAt == '*' || charAt == '?') && (i2 <= 0 || stringBuffer.charAt(i2 - 1) != '\\')) {
                    if (charAt == '?') {
                        stringBuffer.setCharAt(i2, ' ');
                    } else if (i2 < stringBuffer.length() - 1) {
                        if (charAt == '_') {
                            stringBuffer.setCharAt(i2 + 1, ' ');
                        } else {
                            stringBuffer.deleteCharAt(i2 + 1);
                        }
                        stringBuffer.deleteCharAt(i2);
                        i2--;
                    }
                }
                i2++;
            }
        } else {
            int i3 = 0;
            while (i3 < stringBuffer.length()) {
                char charAt2 = stringBuffer.charAt(i3);
                if ((charAt2 == '_' || charAt2 == '*') && (i3 <= 0 || stringBuffer.charAt(i3 - 1) != '\\')) {
                    if (i3 < stringBuffer.length() - 1) {
                        stringBuffer.deleteCharAt(i3 + 1);
                    }
                    stringBuffer.deleteCharAt(i3);
                    i3--;
                }
                i3++;
            }
        }
        while (i < stringBuffer.length()) {
            char charAt3 = stringBuffer.charAt(i);
            if (charAt3 == '\\' || charAt3 == '\"') {
                stringBuffer.deleteCharAt(i);
            } else {
                if (charAt3 == '+' && i > 0 && stringBuffer.charAt(i - 1) == 'E') {
                    stringBuffer.deleteCharAt(i);
                }
                i++;
            }
            i--;
            i++;
        }
        return stringBuffer.toString();
    }

    private Format createNumberFormat(String str, double d) {
        try {
            DecimalFormat decimalFormat = new DecimalFormat(cleanFormatForNumber(str), this.decimalSymbols);
            setExcelStyleRoundingMode(decimalFormat);
            return decimalFormat;
        } catch (IllegalArgumentException unused) {
            return getDefaultFormat(d);
        }
    }

    private static boolean isWholeNumber(double d) {
        return d == Math.floor(d);
    }

    public Format getDefaultFormat(Cell cell) {
        return getDefaultFormat(cell.getNumericCellValue());
    }

    private Format getDefaultFormat(double d) {
        Format format = this.defaultNumFormat;
        if (format != null) {
            return format;
        }
        if (isWholeNumber(d)) {
            return this.generalWholeNumFormat;
        }
        return this.generalDecimalNumFormat;
    }

    private String performDateFormatting(Date date, Format format) {
        if (format != null) {
            return format.format(date);
        }
        return date.toString();
    }

    private String getFormattedDateString(Cell cell) {
        Format format = getFormat(cell);
        if (format instanceof ExcelStyleDateFormatter) {
            ((ExcelStyleDateFormatter) format).setDateToBeFormatted(cell.getNumericCellValue());
        }
        return performDateFormatting(cell.getDateCellValue(), format);
    }

    private String getFormattedNumberString(Cell cell) {
        Format format = getFormat(cell);
        double numericCellValue = cell.getNumericCellValue();
        if (format == null) {
            return String.valueOf(numericCellValue);
        }
        return format.format(new Double(numericCellValue));
    }

    public String formatRawCellContents(double d, int i, String str) {
        return formatRawCellContents(d, i, str, false);
    }

    public String formatRawCellContents(double d, int i, String str, boolean z) {
        if (DateUtil.isADateFormat(i, str)) {
            if (DateUtil.isValidExcelDate(d)) {
                Format format = getFormat(d, i, str);
                if (format instanceof ExcelStyleDateFormatter) {
                    ((ExcelStyleDateFormatter) format).setDateToBeFormatted(d);
                }
                return performDateFormatting(DateUtil.getJavaDate(d, z), format);
            }
            if (this.emulateCsv) {
                return invalidDateTimeString;
            }
        }
        Format format2 = getFormat(d, i, str);
        if (format2 == null) {
            return String.valueOf(d);
        }
        String format3 = format2.format(new Double(d));
        return (!format3.contains("E") || format3.contains("E-")) ? format3 : format3.replaceFirst("E", "E+");
    }

    public String formatCellValue(Cell cell) {
        return formatCellValue(cell, null);
    }

    public String formatCellValue(Cell cell, FormulaEvaluator formulaEvaluator) {
        if (cell == null) {
            return "";
        }
        int cellType = cell.getCellType();
        if (cellType == 2) {
            if (formulaEvaluator == null) {
                return cell.getCellFormula();
            }
            cellType = formulaEvaluator.evaluateFormulaCell(cell);
        }
        if (cellType == 0) {
            if (DateUtil.isCellDateFormatted(cell)) {
                return getFormattedDateString(cell);
            }
            return getFormattedNumberString(cell);
        }
        if (cellType == 1) {
            return cell.getRichStringCellValue().getString();
        }
        if (cellType == 3) {
            return "";
        }
        if (cellType == 4) {
            return String.valueOf(cell.getBooleanCellValue());
        }
        if (cellType == 5) {
            return FormulaError.forInt(cell.getErrorCellValue()).getString();
        }
        throw new RuntimeException("Unexpected celltype (" + cellType + ")");
    }

    public void setDefaultNumberFormat(Format format) {
        for (Map.Entry<String, Format> entry : this.formats.entrySet()) {
            if (entry.getValue() == this.generalDecimalNumFormat || entry.getValue() == this.generalWholeNumFormat) {
                entry.setValue(format);
            }
        }
        this.defaultNumFormat = format;
    }

    public void addFormat(String str, Format format) {
        this.formats.put(str, format);
    }

    static DecimalFormat createIntegerOnlyFormat(String str) {
        DecimalFormat decimalFormat = new DecimalFormat(str);
        decimalFormat.setParseIntegerOnly(true);
        return decimalFormat;
    }

    public static void setExcelStyleRoundingMode(DecimalFormat decimalFormat) {
        setExcelStyleRoundingMode(decimalFormat, RoundingMode.HALF_UP);
    }

    public static void setExcelStyleRoundingMode(DecimalFormat decimalFormat, RoundingMode roundingMode) {
        decimalFormat.setRoundingMode(roundingMode);
    }

    private static final class SSNFormat extends Format {
        public static final Format instance = new SSNFormat();
        private static final DecimalFormat df = DataFormatter.createIntegerOnlyFormat("000000000");

        private SSNFormat() {
        }

        public static String format(Number number) {
            String format = df.format(number);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(format.substring(0, 3)).append(NameUtil.HYPHEN);
            stringBuffer.append(format.substring(3, 5)).append(NameUtil.HYPHEN);
            stringBuffer.append(format.substring(5, 9));
            return stringBuffer.toString();
        }

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            return stringBuffer.append(format((Number) obj));
        }

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            return df.parseObject(str, parsePosition);
        }
    }

    private static final class ZipPlusFourFormat extends Format {
        public static final Format instance = new ZipPlusFourFormat();
        private static final DecimalFormat df = DataFormatter.createIntegerOnlyFormat("000000000");

        private ZipPlusFourFormat() {
        }

        public static String format(Number number) {
            String format = df.format(number);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(format.substring(0, 5)).append(NameUtil.HYPHEN);
            stringBuffer.append(format.substring(5, 9));
            return stringBuffer.toString();
        }

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            return stringBuffer.append(format((Number) obj));
        }

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            return df.parseObject(str, parsePosition);
        }
    }

    private static final class PhoneFormat extends Format {
        public static final Format instance = new PhoneFormat();
        private static final DecimalFormat df = DataFormatter.createIntegerOnlyFormat("##########");

        private PhoneFormat() {
        }

        public static String format(Number number) {
            String format = df.format(number);
            StringBuffer stringBuffer = new StringBuffer();
            int length = format.length();
            if (length <= 4) {
                return format;
            }
            int i = length - 4;
            String substring = format.substring(i, length);
            int i2 = length - 7;
            String substring2 = format.substring(Math.max(0, i2), i);
            String substring3 = format.substring(Math.max(0, length - 10), Math.max(0, i2));
            if (substring3 != null && substring3.trim().length() > 0) {
                stringBuffer.append(PropertyUtils.MAPPED_DELIM).append(substring3).append(") ");
            }
            if (substring2 != null && substring2.trim().length() > 0) {
                stringBuffer.append(substring2).append(NameUtil.HYPHEN);
            }
            stringBuffer.append(substring);
            return stringBuffer.toString();
        }

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            return stringBuffer.append(format((Number) obj));
        }

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            return df.parseObject(str, parsePosition);
        }
    }

    private static final class ConstantStringFormat extends Format {
        private static final DecimalFormat df = DataFormatter.createIntegerOnlyFormat("##########");
        private final String str;

        public ConstantStringFormat(String str) {
            this.str = str;
        }

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            return stringBuffer.append(this.str);
        }

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            return df.parseObject(str, parsePosition);
        }
    }
}
