package org.apache.poi.ss.formula.function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.nntp.NNTPReply;

/* loaded from: classes5.dex */
final class FunctionMetadataReader {
    private static final String[] DIGIT_ENDING_FUNCTION_NAMES;
    private static final Set<String> DIGIT_ENDING_FUNCTION_NAMES_SET;
    private static final String ELLIPSIS = "...";
    private static final String METADATA_FILE_NAME = "functionMetadata.txt";
    private static final Pattern TAB_DELIM_PATTERN = Pattern.compile("\t");
    private static final Pattern SPACE_DELIM_PATTERN = Pattern.compile(StringUtils.SPACE);
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    FunctionMetadataReader() {
    }

    static {
        String[] strArr = {"LOG10", "ATAN2", "DAYS360", "SUMXMY2", "SUMX2MY2", "SUMX2PY2"};
        DIGIT_ENDING_FUNCTION_NAMES = strArr;
        DIGIT_ENDING_FUNCTION_NAMES_SET = new HashSet(Arrays.asList(strArr));
    }

    public static FunctionMetadataRegistry createRegistry() {
        InputStream resourceAsStream = FunctionMetadataReader.class.getResourceAsStream(METADATA_FILE_NAME);
        if (resourceAsStream == null) {
            throw new RuntimeException("resource 'functionMetadata.txt' not found");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, "UTF-8"));
            FunctionDataBuilder functionDataBuilder = new FunctionDataBuilder(NNTPReply.SERVICE_DISCONTINUED);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (readLine.length() >= 1 && readLine.charAt(0) != '#' && readLine.trim().length() >= 1) {
                            processLine(functionDataBuilder, readLine);
                        }
                    } else {
                        bufferedReader.close();
                        return functionDataBuilder.build();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void processLine(FunctionDataBuilder functionDataBuilder, String str) {
        String[] split = TAB_DELIM_PATTERN.split(str, -2);
        if (split.length != 8) {
            throw new RuntimeException("Bad line format '" + str + "' - expected 8 data fields");
        }
        int parseInt = parseInt(split[0]);
        String str2 = split[1];
        int parseInt2 = parseInt(split[2]);
        int parseInt3 = parseInt(split[3]);
        byte parseReturnTypeCode = parseReturnTypeCode(split[4]);
        byte[] parseOperandTypeCodes = parseOperandTypeCodes(split[5]);
        boolean z = split[7].length() > 0;
        validateFunctionName(str2);
        functionDataBuilder.add(parseInt, str2, parseInt2, parseInt3, parseReturnTypeCode, parseOperandTypeCodes, z);
    }

    private static byte parseReturnTypeCode(String str) {
        if (str.length() == 0) {
            return (byte) 0;
        }
        return parseOperandTypeCode(str);
    }

    private static byte[] parseOperandTypeCodes(String str) {
        if (str.length() < 1) {
            return EMPTY_BYTE_ARRAY;
        }
        if (isDash(str)) {
            return EMPTY_BYTE_ARRAY;
        }
        String[] split = SPACE_DELIM_PATTERN.split(str);
        int length = split.length;
        if (ELLIPSIS.equals(split[length - 1])) {
            length--;
        }
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = parseOperandTypeCode(split[i]);
        }
        return bArr;
    }

    private static boolean isDash(String str) {
        return str.length() == 1 && str.charAt(0) == '-';
    }

    private static byte parseOperandTypeCode(String str) {
        if (str.length() != 1) {
            throw new RuntimeException("Bad operand type code format '" + str + "' expected single char");
        }
        char charAt = str.charAt(0);
        if (charAt == 'A') {
            return (byte) 64;
        }
        if (charAt == 'R') {
            return (byte) 0;
        }
        if (charAt == 'V') {
            return (byte) 32;
        }
        throw new IllegalArgumentException("Unexpected operand type code '" + str + "' (" + ((int) str.charAt(0)) + ")");
    }

    private static void validateFunctionName(String str) {
        int length = str.length() - 1;
        if (Character.isDigit(str.charAt(length))) {
            while (length >= 0 && Character.isDigit(str.charAt(length))) {
                length--;
            }
            if (!DIGIT_ENDING_FUNCTION_NAMES_SET.contains(str)) {
                throw new RuntimeException("Invalid function name '" + str + "' (is footnote number incorrectly appended)");
            }
        }
    }

    private static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new RuntimeException("Value '" + str + "' could not be parsed as an integer");
        }
    }
}
