package org.apache.poi.xssf.usermodel.helpers;

/* loaded from: classes5.dex */
public class HeaderFooterHelper {
    private static final String HeaderFooterEntity_C = "&C";
    public static final String HeaderFooterEntity_Date = "&D";
    public static final String HeaderFooterEntity_File = "&F";
    private static final String HeaderFooterEntity_L = "&L";
    private static final String HeaderFooterEntity_R = "&R";
    public static final String HeaderFooterEntity_Time = "&T";

    public String getLeftSection(String str) {
        return getParts(str)[0];
    }

    public String getCenterSection(String str) {
        return getParts(str)[1];
    }

    public String getRightSection(String str) {
        return getParts(str)[2];
    }

    public String setLeftSection(String str, String str2) {
        String[] parts = getParts(str);
        parts[0] = str2;
        return joinParts(parts);
    }

    public String setCenterSection(String str, String str2) {
        String[] parts = getParts(str);
        parts[1] = str2;
        return joinParts(parts);
    }

    public String setRightSection(String str, String str2) {
        String[] parts = getParts(str);
        parts[2] = str2;
        return joinParts(parts);
    }

    private String[] getParts(String str) {
        int indexOf;
        int indexOf2;
        String[] strArr = {"", "", ""};
        if (str == null) {
            return strArr;
        }
        while (true) {
            int indexOf3 = str.indexOf(HeaderFooterEntity_L);
            if (indexOf3 <= -2 || (indexOf = str.indexOf(HeaderFooterEntity_C)) <= -2 || (indexOf2 = str.indexOf(HeaderFooterEntity_R)) <= -2 || (indexOf3 <= -1 && indexOf <= -1 && indexOf2 <= -1)) {
                break;
            }
            if (indexOf2 > indexOf && indexOf2 > indexOf3) {
                strArr[2] = str.substring(indexOf2 + 2);
                str = str.substring(0, indexOf2);
            } else if (indexOf > indexOf2 && indexOf > indexOf3) {
                strArr[1] = str.substring(indexOf + 2);
                str = str.substring(0, indexOf);
            } else {
                strArr[0] = str.substring(indexOf3 + 2);
                str = str.substring(0, indexOf3);
            }
        }
        return strArr;
    }

    private String joinParts(String[] strArr) {
        return joinParts(strArr[0], strArr[1], strArr[2]);
    }

    private String joinParts(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str2.length() > 0) {
            stringBuffer.append(HeaderFooterEntity_C);
            stringBuffer.append(str2);
        }
        if (str.length() > 0) {
            stringBuffer.append(HeaderFooterEntity_L);
            stringBuffer.append(str);
        }
        if (str3.length() > 0) {
            stringBuffer.append(HeaderFooterEntity_R);
            stringBuffer.append(str3);
        }
        return stringBuffer.toString();
    }
}
