package jxl.biff;

import common.Logger;
import jxl.WorkbookSettings;

/* loaded from: classes4.dex */
public class EncodedURLHelper {
    static /* synthetic */ Class class$jxl$biff$EncodedURLHelper;
    private static byte endOfSubdirectory;
    private static Logger logger;
    private static byte msDosDriveLetter;
    private static byte parentDirectory;
    private static byte sameDrive;
    private static byte unencodedUrl;

    static {
        Class cls = class$jxl$biff$EncodedURLHelper;
        if (cls == null) {
            cls = class$("jxl.biff.EncodedURLHelper");
            class$jxl$biff$EncodedURLHelper = cls;
        }
        logger = Logger.getLogger(cls);
        msDosDriveLetter = (byte) 1;
        sameDrive = (byte) 2;
        endOfSubdirectory = (byte) 3;
        parentDirectory = (byte) 4;
        unencodedUrl = (byte) 5;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static byte[] getEncodedURL(String str, WorkbookSettings workbookSettings) {
        if (str.startsWith("http:")) {
            return getURL(str, workbookSettings);
        }
        return getFile(str, workbookSettings);
    }

    private static byte[] getFile(String str, WorkbookSettings workbookSettings) {
        int i;
        int max;
        String substring;
        int i2;
        ByteArray byteArray = new ByteArray();
        if (str.charAt(1) == ':') {
            byteArray.add(msDosDriveLetter);
            byteArray.add((byte) str.charAt(0));
            i = 2;
        } else {
            if (str.charAt(0) == '\\' || str.charAt(0) == '/') {
                byteArray.add(sameDrive);
            }
            i = 0;
        }
        while (true) {
            if (str.charAt(i) != '\\' && str.charAt(i) != '/') {
                break;
            }
            i++;
        }
        while (i < str.length()) {
            int indexOf = str.indexOf(47, i);
            int indexOf2 = str.indexOf(92, i);
            if (indexOf != -1 && indexOf2 != -1) {
                max = Math.min(indexOf, indexOf2);
            } else {
                max = (indexOf == -1 || indexOf2 == -1) ? Math.max(indexOf, indexOf2) : 0;
            }
            if (max == -1) {
                substring = str.substring(i);
                i2 = str.length();
            } else {
                substring = str.substring(i, max);
                i2 = max + 1;
            }
            if (!substring.equals(".")) {
                if (substring.equals("..")) {
                    byteArray.add(parentDirectory);
                } else {
                    byteArray.add(StringHelper.getBytes(substring, workbookSettings));
                }
            }
            if (i2 < str.length()) {
                byteArray.add(endOfSubdirectory);
            }
            i = i2;
        }
        return byteArray.getBytes();
    }

    private static byte[] getURL(String str, WorkbookSettings workbookSettings) {
        ByteArray byteArray = new ByteArray();
        byteArray.add(unencodedUrl);
        byteArray.add((byte) str.length());
        byteArray.add(StringHelper.getBytes(str, workbookSettings));
        return byteArray.getBytes();
    }
}
