package org.apache.poi.ss.format;

import java.awt.Color;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes5.dex */
public class CellFormatPart {
    public static final int COLOR_GROUP;
    public static final Pattern COLOR_PAT;
    public static final int CONDITION_OPERATOR_GROUP;
    public static final Pattern CONDITION_PAT;
    public static final int CONDITION_VALUE_GROUP;
    public static final Pattern FORMAT_PAT;
    private static final Map<String, Color> NAMED_COLORS = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    public static final int SPECIFICATION_GROUP;
    public static final Pattern SPECIFICATION_PAT;
    private final Color color;
    private CellFormatCondition condition;
    private final CellFormatter format;
    private final CellFormatType type;

    interface PartHandler {
        String handlePart(Matcher matcher, String str, CellFormatType cellFormatType, StringBuffer stringBuffer);
    }

    static {
        for (HSSFColor hSSFColor : HSSFColor.getIndexHash().values()) {
            String simpleName = hSSFColor.getClass().getSimpleName();
            if (simpleName.equals(simpleName.toUpperCase())) {
                short[] triplet = hSSFColor.getTriplet();
                Color color = new Color(triplet[0], triplet[1], triplet[2]);
                Map<String, Color> map = NAMED_COLORS;
                map.put(simpleName, color);
                if (simpleName.indexOf(95) > 0) {
                    map.put(simpleName.replace(NameUtil.USCORE, ' '), color);
                }
                if (simpleName.indexOf("_PERCENT") > 0) {
                    map.put(simpleName.replace("_PERCENT", "%").replace(NameUtil.USCORE, ' '), color);
                }
            }
        }
        COLOR_PAT = Pattern.compile("\\[(black|blue|cyan|green|magenta|red|white|yellow|color [0-9]+)\\]", 6);
        CONDITION_PAT = Pattern.compile("([<>=]=?|!=|<>)    # The operator\n  \\s*([0-9]+(?:\\.[0-9]*)?)\\s*  # The constant to test against\n", 6);
        SPECIFICATION_PAT = Pattern.compile("\\\\.                 # Quoted single character\n|\"([^\\\\\"]|\\\\.)*\"         # Quoted string of characters (handles escaped quotes like \\\") \n|_.                             # Space as wide as a given character\n|\\*.                           # Repeating fill character\n|@                              # Text: cell text\n|([0?\\#](?:[0?\\#,]*))         # Number: digit + other digits and commas\n|e[-+]                          # Number: Scientific: Exponent\n|m{1,5}                         # Date: month or minute spec\n|d{1,4}                         # Date: day/date spec\n|y{2,4}                         # Date: year spec\n|h{1,2}                         # Date: hour spec\n|s{1,2}                         # Date: second spec\n|am?/pm?                        # Date: am/pm spec\n|\\[h{1,2}\\]                   # Elapsed time: hour spec\n|\\[m{1,2}\\]                   # Elapsed time: minute spec\n|\\[s{1,2}\\]                   # Elapsed time: second spec\n|[^;]                           # A character\n", 6);
        Pattern compile = Pattern.compile("(?:\\[(black|blue|cyan|green|magenta|red|white|yellow|color [0-9]+)\\])?                  # Text color\n(?:\\[([<>=]=?|!=|<>)    # The operator\n  \\s*([0-9]+(?:\\.[0-9]*)?)\\s*  # The constant to test against\n\\])?                # Condition\n((?:\\\\.                 # Quoted single character\n|\"([^\\\\\"]|\\\\.)*\"         # Quoted string of characters (handles escaped quotes like \\\") \n|_.                             # Space as wide as a given character\n|\\*.                           # Repeating fill character\n|@                              # Text: cell text\n|([0?\\#](?:[0?\\#,]*))         # Number: digit + other digits and commas\n|e[-+]                          # Number: Scientific: Exponent\n|m{1,5}                         # Date: month or minute spec\n|d{1,4}                         # Date: day/date spec\n|y{2,4}                         # Date: year spec\n|h{1,2}                         # Date: hour spec\n|s{1,2}                         # Date: second spec\n|am?/pm?                        # Date: am/pm spec\n|\\[h{1,2}\\]                   # Elapsed time: hour spec\n|\\[m{1,2}\\]                   # Elapsed time: minute spec\n|\\[s{1,2}\\]                   # Elapsed time: second spec\n|[^;]                           # A character\n)+)                        # Format spec\n", 6);
        FORMAT_PAT = compile;
        COLOR_GROUP = findGroup(compile, "[Blue]@", "Blue");
        CONDITION_OPERATOR_GROUP = findGroup(compile, "[>=1]@", ">=");
        CONDITION_VALUE_GROUP = findGroup(compile, "[>=1]@", "1");
        SPECIFICATION_GROUP = findGroup(compile, "[Blue][>1]\\a ?", "\\a ?");
    }

    public CellFormatPart(String str) {
        Matcher matcher = FORMAT_PAT.matcher(str);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Unrecognized format: " + CellFormatter.quote(str));
        }
        this.color = getColor(matcher);
        this.condition = getCondition(matcher);
        this.type = getCellFormatType(matcher);
        this.format = getFormatter(matcher);
    }

    public boolean applies(Object obj) {
        CellFormatCondition cellFormatCondition = this.condition;
        if (cellFormatCondition == null || !(obj instanceof Number)) {
            Objects.requireNonNull(obj, "valueObject");
            return true;
        }
        return cellFormatCondition.pass(((Number) obj).doubleValue());
    }

    private static int findGroup(Pattern pattern, String str, String str2) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Pattern \"" + pattern.pattern() + "\" doesn't match \"" + str + "\"");
        }
        for (int i = 1; i <= matcher.groupCount(); i++) {
            String group = matcher.group(i);
            if (group != null && group.equals(str2)) {
                return i;
            }
        }
        throw new IllegalArgumentException("\"" + str2 + "\" not found in \"" + pattern.pattern() + "\"");
    }

    private static Color getColor(Matcher matcher) {
        String group = matcher.group(COLOR_GROUP);
        if (group == null || group.length() == 0) {
            return null;
        }
        Color color = NAMED_COLORS.get(group);
        if (color == null) {
            CellFormatter.logger.warning("Unknown color: " + CellFormatter.quote(group));
        }
        return color;
    }

    private CellFormatCondition getCondition(Matcher matcher) {
        int i = CONDITION_OPERATOR_GROUP;
        String group = matcher.group(i);
        if (group == null || group.length() == 0) {
            return null;
        }
        return CellFormatCondition.getInstance(matcher.group(i), matcher.group(CONDITION_VALUE_GROUP));
    }

    private CellFormatType getCellFormatType(Matcher matcher) {
        return formatType(matcher.group(SPECIFICATION_GROUP));
    }

    private CellFormatter getFormatter(Matcher matcher) {
        return this.type.formatter(matcher.group(SPECIFICATION_GROUP));
    }

    private CellFormatType formatType(String str) {
        String trim = str.trim();
        if (trim.equals("") || trim.equalsIgnoreCase("General")) {
            return CellFormatType.GENERAL;
        }
        Matcher matcher = SPECIFICATION_PAT.matcher(trim);
        boolean z = false;
        boolean z2 = false;
        while (matcher.find()) {
            String group = matcher.group(0);
            if (group.length() > 0) {
                switch (group.charAt(0)) {
                    case '#':
                    case '?':
                        return CellFormatType.NUMBER;
                    case '0':
                        z2 = true;
                        break;
                    case '@':
                        return CellFormatType.TEXT;
                    case 'D':
                    case 'Y':
                    case 'd':
                    case 'y':
                        return CellFormatType.DATE;
                    case 'H':
                    case 'M':
                    case 'S':
                    case 'h':
                    case 'm':
                    case 's':
                        z = true;
                        break;
                    case '[':
                        return CellFormatType.ELAPSED;
                }
            }
        }
        if (z) {
            return CellFormatType.DATE;
        }
        if (z2) {
            return CellFormatType.NUMBER;
        }
        return CellFormatType.TEXT;
    }

    static String quoteSpecial(String str, CellFormatType cellFormatType) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\'' && cellFormatType.isSpecial('\'')) {
                sb.append((char) 0);
            } else {
                boolean isSpecial = cellFormatType.isSpecial(charAt);
                if (isSpecial) {
                    sb.append("'");
                }
                sb.append(charAt);
                if (isSpecial) {
                    sb.append("'");
                }
            }
        }
        return sb.toString();
    }

    public CellFormatResult apply(Object obj) {
        String simpleFormat;
        Color color;
        boolean applies = applies(obj);
        if (applies) {
            simpleFormat = this.format.format(obj);
            color = this.color;
        } else {
            simpleFormat = this.format.simpleFormat(obj);
            color = null;
        }
        return new CellFormatResult(applies, simpleFormat, color);
    }

    public CellFormatResult apply(JLabel jLabel, Object obj) {
        CellFormatResult apply = apply(obj);
        jLabel.setText(apply.text);
        if (apply.textColor != null) {
            jLabel.setForeground(apply.textColor);
        }
        return apply;
    }

    CellFormatType getCellFormatType() {
        return this.type;
    }

    boolean hasCondition() {
        return this.condition != null;
    }

    public static StringBuffer parseFormat(String str, CellFormatType cellFormatType, PartHandler partHandler) {
        int i;
        Matcher matcher = SPECIFICATION_PAT.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            i = 0;
            if (!matcher.find()) {
                break;
            }
            String group = group(matcher, 0);
            if (group.length() > 0) {
                String handlePart = partHandler.handlePart(matcher, group, cellFormatType, stringBuffer);
                if (handlePart == null) {
                    char charAt = group.charAt(0);
                    if (charAt == '\"') {
                        group = quoteSpecial(group.substring(1, group.length() - 1), cellFormatType);
                    } else if (charAt == '*') {
                        group = expandChar(group);
                    } else if (charAt == '\\') {
                        group = quoteSpecial(group.substring(1), cellFormatType);
                    } else if (charAt == '_') {
                        group = StringUtils.SPACE;
                    }
                } else {
                    group = handlePart;
                }
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(group));
            }
        }
        matcher.appendTail(stringBuffer);
        if (cellFormatType.isSpecial('\'')) {
            int i2 = 0;
            while (true) {
                i2 = stringBuffer.indexOf("''", i2);
                if (i2 < 0) {
                    break;
                }
                stringBuffer.delete(i2, i2 + 2);
            }
            while (true) {
                i = stringBuffer.indexOf("\u0000", i);
                if (i < 0) {
                    break;
                }
                stringBuffer.replace(i, i + 1, "''");
            }
        }
        return stringBuffer;
    }

    static String expandChar(String str) {
        char charAt = str.charAt(1);
        return "" + charAt + charAt + charAt;
    }

    public static String group(Matcher matcher, int i) {
        String group = matcher.group(i);
        return group == null ? "" : group;
    }
}
