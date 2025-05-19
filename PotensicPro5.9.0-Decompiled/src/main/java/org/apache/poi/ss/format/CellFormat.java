package org.apache.poi.ss.format;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

/* loaded from: classes5.dex */
public class CellFormat {
    private static final String INVALID_VALUE_FOR_FORMAT = "###############################################################################################################################################################################################################################################################";
    private final String format;
    private final int formatPartCount;
    private final CellFormatPart negNumFmt;
    private final CellFormatPart posNumFmt;
    private final CellFormatPart textFmt;
    private final CellFormatPart zeroNumFmt;
    private static final Pattern ONE_PART = Pattern.compile(CellFormatPart.FORMAT_PAT.pattern() + "(;|$)", 6);
    private static final CellFormatPart DEFAULT_TEXT_FORMAT = new CellFormatPart("@");
    private static String QUOTE = "\"";
    public static final CellFormat GENERAL_FORMAT = new CellFormat("General") { // from class: org.apache.poi.ss.format.CellFormat.1
        @Override // org.apache.poi.ss.format.CellFormat
        public CellFormatResult apply(Object obj) {
            return new CellFormatResult(true, new CellGeneralFormatter().format(obj), null);
        }
    };
    private static final Map<String, CellFormat> formatCache = new WeakHashMap();

    public static CellFormat getInstance(String str) {
        Map<String, CellFormat> map = formatCache;
        CellFormat cellFormat = map.get(str);
        if (cellFormat == null) {
            if (str.equals("General") || str.equals("@")) {
                cellFormat = GENERAL_FORMAT;
            } else {
                cellFormat = new CellFormat(str);
            }
            map.put(str, cellFormat);
        }
        return cellFormat;
    }

    private CellFormat(String str) {
        this.format = str;
        Matcher matcher = ONE_PART.matcher(str);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            try {
                String group = matcher.group();
                arrayList.add(new CellFormatPart(group.endsWith(";") ? group.substring(0, group.length() - 1) : group));
            } catch (RuntimeException e) {
                CellFormatter.logger.log(Level.WARNING, "Invalid format: " + CellFormatter.quote(matcher.group()), (Throwable) e);
                arrayList.add(null);
            }
        }
        int size = arrayList.size();
        this.formatPartCount = size;
        if (size == 1) {
            this.posNumFmt = (CellFormatPart) arrayList.get(0);
            this.negNumFmt = null;
            this.zeroNumFmt = null;
            this.textFmt = DEFAULT_TEXT_FORMAT;
            return;
        }
        if (size == 2) {
            this.posNumFmt = (CellFormatPart) arrayList.get(0);
            this.negNumFmt = (CellFormatPart) arrayList.get(1);
            this.zeroNumFmt = null;
            this.textFmt = DEFAULT_TEXT_FORMAT;
            return;
        }
        if (size == 3) {
            this.posNumFmt = (CellFormatPart) arrayList.get(0);
            this.negNumFmt = (CellFormatPart) arrayList.get(1);
            this.zeroNumFmt = (CellFormatPart) arrayList.get(2);
            this.textFmt = DEFAULT_TEXT_FORMAT;
            return;
        }
        this.posNumFmt = (CellFormatPart) arrayList.get(0);
        this.negNumFmt = (CellFormatPart) arrayList.get(1);
        this.zeroNumFmt = (CellFormatPart) arrayList.get(2);
        this.textFmt = (CellFormatPart) arrayList.get(3);
    }

    public CellFormatResult apply(Object obj) {
        if (obj instanceof Number) {
            double doubleValue = ((Number) obj).doubleValue();
            if (doubleValue < 0.0d && ((this.formatPartCount == 2 && !this.posNumFmt.hasCondition() && !this.negNumFmt.hasCondition()) || ((this.formatPartCount == 3 && !this.negNumFmt.hasCondition()) || (this.formatPartCount == 4 && !this.negNumFmt.hasCondition())))) {
                return this.negNumFmt.apply(Double.valueOf(-doubleValue));
            }
            return getApplicableFormatPart(Double.valueOf(doubleValue)).apply(Double.valueOf(doubleValue));
        }
        if (obj instanceof Date) {
            Double valueOf = Double.valueOf(DateUtil.getExcelDate((Date) obj));
            if (DateUtil.isValidExcelDate(valueOf.doubleValue())) {
                return getApplicableFormatPart(valueOf).apply(obj);
            }
            throw new IllegalArgumentException("value not a valid Excel date");
        }
        return this.textFmt.apply(obj);
    }

    private CellFormatResult apply(Date date, double d) {
        return getApplicableFormatPart(Double.valueOf(d)).apply(date);
    }

    public CellFormatResult apply(Cell cell) {
        int ultimateType = ultimateType(cell);
        if (ultimateType == 0) {
            Double valueOf = Double.valueOf(cell.getNumericCellValue());
            if (getApplicableFormatPart(valueOf).getCellFormatType() == CellFormatType.DATE) {
                if (DateUtil.isValidExcelDate(valueOf.doubleValue())) {
                    return apply(cell.getDateCellValue(), valueOf.doubleValue());
                }
                return apply(INVALID_VALUE_FOR_FORMAT);
            }
            return apply(valueOf);
        }
        if (ultimateType == 1) {
            return apply(cell.getStringCellValue());
        }
        if (ultimateType == 3) {
            return apply("");
        }
        if (ultimateType == 4) {
            return apply(Boolean.valueOf(cell.getBooleanCellValue()));
        }
        return apply("?");
    }

    public CellFormatResult apply(JLabel jLabel, Object obj) {
        CellFormatResult apply = apply(obj);
        jLabel.setText(apply.text);
        if (apply.textColor != null) {
            jLabel.setForeground(apply.textColor);
        }
        return apply;
    }

    private CellFormatResult apply(JLabel jLabel, Date date, double d) {
        CellFormatResult apply = apply(date, d);
        jLabel.setText(apply.text);
        if (apply.textColor != null) {
            jLabel.setForeground(apply.textColor);
        }
        return apply;
    }

    public CellFormatResult apply(JLabel jLabel, Cell cell) {
        int ultimateType = ultimateType(cell);
        if (ultimateType == 0) {
            Double valueOf = Double.valueOf(cell.getNumericCellValue());
            if (getApplicableFormatPart(valueOf).getCellFormatType() == CellFormatType.DATE) {
                if (DateUtil.isValidExcelDate(valueOf.doubleValue())) {
                    return apply(jLabel, cell.getDateCellValue(), valueOf.doubleValue());
                }
                return apply(jLabel, INVALID_VALUE_FOR_FORMAT);
            }
            return apply(jLabel, valueOf);
        }
        if (ultimateType == 1) {
            return apply(jLabel, cell.getStringCellValue());
        }
        if (ultimateType == 3) {
            return apply(jLabel, "");
        }
        if (ultimateType == 4) {
            return apply(jLabel, Boolean.valueOf(cell.getBooleanCellValue()));
        }
        return apply(jLabel, "?");
    }

    private CellFormatPart getApplicableFormatPart(Object obj) {
        if (obj instanceof Number) {
            double doubleValue = ((Number) obj).doubleValue();
            int i = this.formatPartCount;
            if (i == 1) {
                if (!this.posNumFmt.hasCondition() || (this.posNumFmt.hasCondition() && this.posNumFmt.applies(Double.valueOf(doubleValue)))) {
                    return this.posNumFmt;
                }
                return new CellFormatPart("General");
            }
            if (i == 2) {
                if ((!this.posNumFmt.hasCondition() && doubleValue >= 0.0d) || (this.posNumFmt.hasCondition() && this.posNumFmt.applies(Double.valueOf(doubleValue)))) {
                    return this.posNumFmt;
                }
                if (!this.negNumFmt.hasCondition() || (this.negNumFmt.hasCondition() && this.negNumFmt.applies(Double.valueOf(doubleValue)))) {
                    return this.negNumFmt;
                }
                return new CellFormatPart(QUOTE + INVALID_VALUE_FOR_FORMAT + QUOTE);
            }
            if ((!this.posNumFmt.hasCondition() && doubleValue > 0.0d) || (this.posNumFmt.hasCondition() && this.posNumFmt.applies(Double.valueOf(doubleValue)))) {
                return this.posNumFmt;
            }
            if ((!this.negNumFmt.hasCondition() && doubleValue < 0.0d) || (this.negNumFmt.hasCondition() && this.negNumFmt.applies(Double.valueOf(doubleValue)))) {
                return this.negNumFmt;
            }
            return this.zeroNumFmt;
        }
        throw new IllegalArgumentException("value must be a Number");
    }

    public static int ultimateType(Cell cell) {
        int cellType = cell.getCellType();
        return cellType == 2 ? cell.getCachedFormulaResultType() : cellType;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CellFormat) {
            return this.format.equals(((CellFormat) obj).format);
        }
        return false;
    }

    public int hashCode() {
        return this.format.hashCode();
    }
}
