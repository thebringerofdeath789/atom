package net.lingala.zip4j.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;

/* loaded from: classes4.dex */
public class Zip4jUtil {
    public static void setFileArchive(File file) throws ZipException {
    }

    public static void setFileHidden(File file) throws ZipException {
    }

    public static void setFileSystemMode(File file) throws ZipException {
    }

    public static boolean isStringNotNullAndNotEmpty(String str) {
        return str != null && str.trim().length() > 0;
    }

    public static boolean checkOutputFolder(String str) throws ZipException {
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new ZipException(new NullPointerException("output path is null"));
        }
        File file = new File(str);
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new ZipException("output folder is not valid");
            }
            if (file.canWrite()) {
                return true;
            }
            throw new ZipException("no write access to output folder");
        }
        try {
            file.mkdirs();
            if (!file.isDirectory()) {
                throw new ZipException("output folder is not valid");
            }
            if (file.canWrite()) {
                return true;
            }
            throw new ZipException("no write access to destination folder");
        } catch (Exception unused) {
            throw new ZipException("Cannot create destination folder");
        }
    }

    public static boolean checkFileReadAccess(String str) throws ZipException {
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("path is null");
        }
        if (!checkFileExists(str)) {
            throw new ZipException("file does not exist: " + str);
        }
        try {
            return new File(str).canRead();
        } catch (Exception unused) {
            throw new ZipException("cannot read zip file");
        }
    }

    public static boolean checkFileWriteAccess(String str) throws ZipException {
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("path is null");
        }
        if (!checkFileExists(str)) {
            throw new ZipException("file does not exist: " + str);
        }
        try {
            return new File(str).canWrite();
        } catch (Exception unused) {
            throw new ZipException("cannot read zip file");
        }
    }

    public static boolean checkFileExists(String str) throws ZipException {
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("path is null");
        }
        return checkFileExists(new File(str));
    }

    public static boolean checkFileExists(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("cannot check if file exists: input file is null");
        }
        return file.exists();
    }

    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().indexOf("win") >= 0;
    }

    public static void setFileReadOnly(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("input file is null. cannot set read only file attribute");
        }
        if (file.exists()) {
            file.setReadOnly();
        }
    }

    public static long getLastModifiedFileTime(File file, TimeZone timeZone) throws ZipException {
        if (file == null) {
            throw new ZipException("input file is null, cannot read last modified file time");
        }
        if (!file.exists()) {
            throw new ZipException("input file does not exist, cannot read last modified file time");
        }
        return file.lastModified();
    }

    public static String getFileNameFromFilePath(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("input file is null, cannot get file name");
        }
        if (file.isDirectory()) {
            return null;
        }
        return file.getName();
    }

    public static long getFileLengh(String str) throws ZipException {
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("invalid file name");
        }
        return getFileLengh(new File(str));
    }

    public static long getFileLengh(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("input file is null, cannot calculate file length");
        }
        if (file.isDirectory()) {
            return -1L;
        }
        return file.length();
    }

    public static long javaToDosTime(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        if (calendar.get(1) < 1980) {
            return 2162688L;
        }
        return (calendar.get(13) >> 1) | ((r5 - 1980) << 25) | ((calendar.get(2) + 1) << 21) | (calendar.get(5) << 16) | (calendar.get(11) << 11) | (calendar.get(12) << 5);
    }

    public static long dosToJavaTme(int i) {
        int i2 = (i & 31) * 2;
        int i3 = (i >> 5) & 63;
        int i4 = (i >> 11) & 31;
        int i5 = (i >> 16) & 31;
        int i6 = ((i >> 21) & 15) - 1;
        int i7 = ((i >> 25) & 127) + 1980;
        Calendar calendar = Calendar.getInstance();
        calendar.set(i7, i6, i5, i4, i3, i2);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    public static FileHeader getFileHeader(ZipModel zipModel, String str) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("zip model is null, cannot determine file header for fileName: " + str);
        }
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("file name is null, cannot determine file header for fileName: " + str);
        }
        FileHeader fileHeaderWithExactMatch = getFileHeaderWithExactMatch(zipModel, str);
        if (fileHeaderWithExactMatch != null) {
            return fileHeaderWithExactMatch;
        }
        String replaceAll = str.replaceAll("\\\\", InternalZipConstants.ZIP_FILE_SEPARATOR);
        FileHeader fileHeaderWithExactMatch2 = getFileHeaderWithExactMatch(zipModel, replaceAll);
        return fileHeaderWithExactMatch2 == null ? getFileHeaderWithExactMatch(zipModel, replaceAll.replaceAll(InternalZipConstants.ZIP_FILE_SEPARATOR, "\\\\")) : fileHeaderWithExactMatch2;
    }

    public static FileHeader getFileHeaderWithExactMatch(ZipModel zipModel, String str) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("zip model is null, cannot determine file header with exact match for fileName: " + str);
        }
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("file name is null, cannot determine file header with exact match for fileName: " + str);
        }
        if (zipModel.getCentralDirectory() == null) {
            throw new ZipException("central directory is null, cannot determine file header with exact match for fileName: " + str);
        }
        if (zipModel.getCentralDirectory().getFileHeaders() == null) {
            throw new ZipException("file Headers are null, cannot determine file header with exact match for fileName: " + str);
        }
        if (zipModel.getCentralDirectory().getFileHeaders().size() <= 0) {
            return null;
        }
        ArrayList fileHeaders = zipModel.getCentralDirectory().getFileHeaders();
        for (int i = 0; i < fileHeaders.size(); i++) {
            FileHeader fileHeader = (FileHeader) fileHeaders.get(i);
            String fileName = fileHeader.getFileName();
            if (isStringNotNullAndNotEmpty(fileName) && str.equalsIgnoreCase(fileName)) {
                return fileHeader;
            }
        }
        return null;
    }

    public static int getIndexOfFileHeader(ZipModel zipModel, FileHeader fileHeader) throws ZipException {
        if (zipModel == null || fileHeader == null) {
            throw new ZipException("input parameters is null, cannot determine index of file header");
        }
        if (zipModel.getCentralDirectory() == null) {
            throw new ZipException("central directory is null, ccannot determine index of file header");
        }
        if (zipModel.getCentralDirectory().getFileHeaders() == null) {
            throw new ZipException("file Headers are null, cannot determine index of file header");
        }
        if (zipModel.getCentralDirectory().getFileHeaders().size() <= 0) {
            return -1;
        }
        String fileName = fileHeader.getFileName();
        if (!isStringNotNullAndNotEmpty(fileName)) {
            throw new ZipException("file name in file header is empty or null, cannot determine index of file header");
        }
        ArrayList fileHeaders = zipModel.getCentralDirectory().getFileHeaders();
        for (int i = 0; i < fileHeaders.size(); i++) {
            String fileName2 = ((FileHeader) fileHeaders.get(i)).getFileName();
            if (isStringNotNullAndNotEmpty(fileName2) && fileName.equalsIgnoreCase(fileName2)) {
                return i;
            }
        }
        return -1;
    }

    public static ArrayList getFilesInDirectoryRec(File file, boolean z) throws ZipException {
        if (file == null) {
            throw new ZipException("input path is null, cannot read files in the directory");
        }
        ArrayList arrayList = new ArrayList();
        List asList = Arrays.asList(file.listFiles());
        if (!file.canRead()) {
            return arrayList;
        }
        for (int i = 0; i < asList.size(); i++) {
            File file2 = (File) asList.get(i);
            if (file2.isHidden() && !z) {
                return arrayList;
            }
            arrayList.add(file2);
            if (file2.isDirectory()) {
                arrayList.addAll(getFilesInDirectoryRec(file2, z));
            }
        }
        return arrayList;
    }

    public static String getZipFileNameWithoutExt(String str) throws ZipException {
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("zip file name is empty or null, cannot determine zip file name");
        }
        if (str.indexOf(System.getProperty("file.separator")) >= 0) {
            str = str.substring(str.lastIndexOf(System.getProperty("file.separator")));
        }
        return str.indexOf(".") > 0 ? str.substring(0, str.lastIndexOf(".")) : str;
    }

    public static byte[] convertCharset(String str) throws ZipException {
        try {
            String detectCharSet = detectCharSet(str);
            if (detectCharSet.equals(InternalZipConstants.CHARSET_CP850)) {
                return str.getBytes(InternalZipConstants.CHARSET_CP850);
            }
            if (detectCharSet.equals(InternalZipConstants.CHARSET_UTF8)) {
                return str.getBytes(InternalZipConstants.CHARSET_UTF8);
            }
            return str.getBytes();
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        } catch (Exception e) {
            throw new ZipException(e);
        }
    }

    public static String decodeFileName(byte[] bArr, boolean z) {
        if (z) {
            try {
                return new String(bArr, InternalZipConstants.CHARSET_UTF8);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        }
        return getCp850EncodedString(bArr);
    }

    public static String getCp850EncodedString(byte[] bArr) {
        try {
            return new String(bArr, InternalZipConstants.CHARSET_CP850);
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static String getAbsoluteFilePath(String str) throws ZipException {
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("filePath is null or empty, cannot get absolute file path");
        }
        return new File(str).getAbsolutePath();
    }

    public static boolean checkArrayListTypes(ArrayList arrayList, int i) throws ZipException {
        if (arrayList == null) {
            throw new ZipException("input arraylist is null, cannot check types");
        }
        if (arrayList.size() <= 0) {
            return true;
        }
        boolean z = false;
        if (i == 1) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (!(arrayList.get(i2) instanceof File)) {
                    z = true;
                    break;
                }
            }
            return !z;
        }
        if (i == 2) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (!(arrayList.get(i3) instanceof String)) {
                    z = true;
                    break;
                }
            }
        }
        return !z;
    }

    public static String detectCharSet(String str) throws ZipException {
        if (str == null) {
            throw new ZipException("input string is null, cannot detect charset");
        }
        try {
            return str.equals(new String(str.getBytes(InternalZipConstants.CHARSET_CP850), InternalZipConstants.CHARSET_CP850)) ? InternalZipConstants.CHARSET_CP850 : str.equals(new String(str.getBytes(InternalZipConstants.CHARSET_UTF8), InternalZipConstants.CHARSET_UTF8)) ? InternalZipConstants.CHARSET_UTF8 : InternalZipConstants.CHARSET_DEFAULT;
        } catch (UnsupportedEncodingException unused) {
            return InternalZipConstants.CHARSET_DEFAULT;
        } catch (Exception unused2) {
            return InternalZipConstants.CHARSET_DEFAULT;
        }
    }

    public static int getEncodedStringLength(String str) throws ZipException {
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("input string is null, cannot calculate encoded String length");
        }
        return getEncodedStringLength(str, detectCharSet(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.nio.ByteBuffer] */
    public static int getEncodedStringLength(String str, String str2) throws ZipException {
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("input string is null, cannot calculate encoded String length");
        }
        if (!isStringNotNullAndNotEmpty(str2)) {
            throw new ZipException("encoding is not defined, cannot calculate string length");
        }
        try {
            if (str2.equals(InternalZipConstants.CHARSET_CP850)) {
                str = ByteBuffer.wrap(str.getBytes(InternalZipConstants.CHARSET_CP850));
            } else if (str2.equals(InternalZipConstants.CHARSET_UTF8)) {
                str = ByteBuffer.wrap(str.getBytes(InternalZipConstants.CHARSET_UTF8));
            } else {
                str = ByteBuffer.wrap(str.getBytes(str2));
            }
        } catch (UnsupportedEncodingException unused) {
            str = ByteBuffer.wrap(str.getBytes());
        } catch (Exception e) {
            throw new ZipException(e);
        }
        return str.limit();
    }

    public static boolean isSupportedCharset(String str) throws ZipException {
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("charset is null or empty, cannot check if it is supported");
        }
        try {
            new String("a".getBytes(), str);
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        } catch (Exception e) {
            throw new ZipException(e);
        }
    }

    public static ArrayList getSplitZipFiles(ZipModel zipModel) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("cannot get split zip files: zipmodel is null");
        }
        if (zipModel.getEndCentralDirRecord() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String zipFile = zipModel.getZipFile();
        String name = new File(zipFile).getName();
        if (!isStringNotNullAndNotEmpty(zipFile)) {
            throw new ZipException("cannot get split zip files: zipfile is null");
        }
        if (!zipModel.isSplitArchive()) {
            arrayList.add(zipFile);
            return arrayList;
        }
        int noOfThisDisk = zipModel.getEndCentralDirRecord().getNoOfThisDisk();
        if (noOfThisDisk == 0) {
            arrayList.add(zipFile);
            return arrayList;
        }
        int i = 0;
        while (i <= noOfThisDisk) {
            if (i == noOfThisDisk) {
                arrayList.add(zipModel.getZipFile());
            } else {
                arrayList.add((name.indexOf(".") >= 0 ? zipFile.substring(0, zipFile.lastIndexOf(".")) : zipFile) + (i > 9 ? ".z" : ".z0") + (i + 1));
            }
            i++;
        }
        return arrayList;
    }

    public static String getRelativeFileName(String str, String str2, String str3) throws ZipException {
        String fileNameFromFilePath;
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("input file path/name is empty, cannot calculate relative file name");
        }
        if (isStringNotNullAndNotEmpty(str3)) {
            String path = new File(str3).getPath();
            if (!path.endsWith(InternalZipConstants.FILE_SEPARATOR)) {
                path = path + InternalZipConstants.FILE_SEPARATOR;
            }
            String substring = str.substring(path.length());
            if (substring.startsWith(System.getProperty("file.separator"))) {
                substring = substring.substring(1);
            }
            File file = new File(str);
            if (file.isDirectory()) {
                fileNameFromFilePath = substring.replaceAll("\\\\", InternalZipConstants.ZIP_FILE_SEPARATOR) + InternalZipConstants.ZIP_FILE_SEPARATOR;
            } else {
                fileNameFromFilePath = substring.substring(0, substring.lastIndexOf(file.getName())).replaceAll("\\\\", InternalZipConstants.ZIP_FILE_SEPARATOR) + file.getName();
            }
        } else {
            File file2 = new File(str);
            if (file2.isDirectory()) {
                fileNameFromFilePath = file2.getName() + InternalZipConstants.ZIP_FILE_SEPARATOR;
            } else {
                fileNameFromFilePath = getFileNameFromFilePath(new File(str));
            }
        }
        if (isStringNotNullAndNotEmpty(str2)) {
            fileNameFromFilePath = str2 + fileNameFromFilePath;
        }
        if (isStringNotNullAndNotEmpty(fileNameFromFilePath)) {
            return fileNameFromFilePath;
        }
        throw new ZipException("Error determining file name");
    }

    public static long[] getAllHeaderSignatures() {
        return new long[]{InternalZipConstants.LOCSIG, 134695760, InternalZipConstants.CENSIG, InternalZipConstants.ENDSIG, InternalZipConstants.DIGSIG, InternalZipConstants.ARCEXTDATREC, 134695760, InternalZipConstants.ZIP64ENDCENDIRLOC, InternalZipConstants.ZIP64ENDCENDIRREC, 1, 39169};
    }
}
