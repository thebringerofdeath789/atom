package org.apache.commons.net.ftp.parser;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.TimeZones;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileEntryParserImpl;
import org.apache.commons.text.lookup.StringLookupFactory;

/* loaded from: classes4.dex */
public class MLSxEntryParser extends FTPFileEntryParserImpl {
    private static final MLSxEntryParser PARSER = new MLSxEntryParser();
    private static final HashMap<String, Integer> TYPE_TO_INT;
    private static int[] UNIX_GROUPS;
    private static int[][] UNIX_PERMS;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        TYPE_TO_INT = hashMap;
        hashMap.put(StringLookupFactory.KEY_FILE, 0);
        hashMap.put("cdir", 1);
        hashMap.put("pdir", 1);
        hashMap.put("dir", 1);
        UNIX_GROUPS = new int[]{0, 1, 2};
        UNIX_PERMS = new int[][]{new int[0], new int[]{2}, new int[]{1}, new int[]{2, 1}, new int[]{0}, new int[]{0, 2}, new int[]{0, 1}, new int[]{0, 1, 2}};
    }

    @Override // org.apache.commons.net.ftp.FTPFileEntryParser
    public FTPFile parseFTPEntry(String str) {
        if (str.startsWith(StringUtils.SPACE)) {
            if (str.length() <= 1) {
                return null;
            }
            FTPFile fTPFile = new FTPFile();
            fTPFile.setRawListing(str);
            fTPFile.setName(str.substring(1));
            return fTPFile;
        }
        int i = 2;
        String[] split = str.split(StringUtils.SPACE, 2);
        if (split.length != 2 || split[1].length() == 0) {
            return null;
        }
        int i2 = 0;
        String str2 = split[0];
        if (!str2.endsWith(";")) {
            return null;
        }
        FTPFile fTPFile2 = new FTPFile();
        fTPFile2.setRawListing(str);
        fTPFile2.setName(split[1]);
        String[] split2 = str2.split(";");
        boolean contains = split[0].toLowerCase(Locale.ENGLISH).contains("unix.mode=");
        int length = split2.length;
        int i3 = 0;
        while (i3 < length) {
            String[] split3 = split2[i3].split("=", -1);
            if (split3.length != i) {
                return null;
            }
            String lowerCase = split3[i2].toLowerCase(Locale.ENGLISH);
            String str3 = split3[1];
            if (str3.length() != 0) {
                String lowerCase2 = str3.toLowerCase(Locale.ENGLISH);
                if ("size".equals(lowerCase)) {
                    fTPFile2.setSize(Long.parseLong(str3));
                } else if ("sizd".equals(lowerCase)) {
                    fTPFile2.setSize(Long.parseLong(str3));
                } else if ("modify".equals(lowerCase)) {
                    Calendar parseGMTdateTime = parseGMTdateTime(str3);
                    if (parseGMTdateTime == null) {
                        return null;
                    }
                    fTPFile2.setTimestamp(parseGMTdateTime);
                } else if ("type".equals(lowerCase)) {
                    Integer num = TYPE_TO_INT.get(lowerCase2);
                    if (num == null) {
                        fTPFile2.setType(3);
                    } else {
                        fTPFile2.setType(num.intValue());
                    }
                } else if (lowerCase.startsWith("unix.")) {
                    String lowerCase3 = lowerCase.substring(5).toLowerCase(Locale.ENGLISH);
                    if ("group".equals(lowerCase3)) {
                        fTPFile2.setGroup(str3);
                    } else if ("owner".equals(lowerCase3)) {
                        fTPFile2.setUser(str3);
                    } else if (RtspHeaders.Values.MODE.equals(lowerCase3)) {
                        int length2 = str3.length() - 3;
                        int i4 = i2;
                        while (i4 < 3) {
                            int charAt = str3.charAt(length2 + i4) - '0';
                            if (charAt >= 0 && charAt <= 7) {
                                int[] iArr = UNIX_PERMS[charAt];
                                int length3 = iArr.length;
                                for (int i5 = i2; i5 < length3; i5++) {
                                    fTPFile2.setPermission(UNIX_GROUPS[i4], iArr[i5], true);
                                }
                            }
                            i4++;
                            i2 = 0;
                        }
                    }
                } else if (!contains && "perm".equals(lowerCase)) {
                    doUnixPerms(fTPFile2, lowerCase2);
                    i3++;
                    i = 2;
                    i2 = 0;
                }
            }
            i3++;
            i = 2;
            i2 = 0;
        }
        return fTPFile2;
    }

    public static Calendar parseGMTdateTime(String str) {
        SimpleDateFormat simpleDateFormat;
        boolean z;
        if (str.contains(".")) {
            simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
            z = true;
        } else {
            simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            z = false;
        }
        TimeZone timeZone = TimeZone.getTimeZone(TimeZones.GMT_ID);
        simpleDateFormat.setTimeZone(timeZone);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
        ParsePosition parsePosition = new ParsePosition(0);
        simpleDateFormat.setLenient(false);
        Date parse = simpleDateFormat.parse(str, parsePosition);
        if (parsePosition.getIndex() != str.length()) {
            return null;
        }
        gregorianCalendar.setTime(parse);
        if (!z) {
            gregorianCalendar.clear(14);
        }
        return gregorianCalendar;
    }

    private void doUnixPerms(FTPFile fTPFile, String str) {
        for (char c : str.toCharArray()) {
            if (c == 'a') {
                fTPFile.setPermission(0, 1, true);
            } else if (c == 'p') {
                fTPFile.setPermission(0, 1, true);
            } else if (c == 'r') {
                fTPFile.setPermission(0, 0, true);
            } else if (c == 'w') {
                fTPFile.setPermission(0, 1, true);
            } else if (c == 'l') {
                fTPFile.setPermission(0, 2, true);
            } else if (c != 'm') {
                switch (c) {
                    case 'c':
                        fTPFile.setPermission(0, 1, true);
                        break;
                    case 'd':
                        fTPFile.setPermission(0, 1, true);
                        break;
                    case 'e':
                        fTPFile.setPermission(0, 0, true);
                        break;
                }
            } else {
                fTPFile.setPermission(0, 1, true);
            }
        }
    }

    public static FTPFile parseEntry(String str) {
        return PARSER.parseFTPEntry(str);
    }

    public static MLSxEntryParser getInstance() {
        return PARSER;
    }
}
