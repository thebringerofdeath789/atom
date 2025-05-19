package com.ipotensic.baselib.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes2.dex */
public class ZipUtils {
    public static void ZipFolder(String str, String str2) {
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(new File(str2 + "" + System.currentTimeMillis() + ".zip")));
            File file = new File(str);
            ZipFiles(file.getParent() + File.separator, file.getName(), zipOutputStream);
            zipOutputStream.finish();
            zipOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void ZipFiles(String str, String str2, ZipOutputStream zipOutputStream) {
        if (zipOutputStream == null) {
            return;
        }
        try {
            File file = new File(str + str2);
            if (file.isFile()) {
                ZipEntry zipEntry = new ZipEntry(str2);
                FileInputStream fileInputStream = new FileInputStream(file);
                zipOutputStream.putNextEntry(zipEntry);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        zipOutputStream.write(bArr, 0, read);
                    } else {
                        zipOutputStream.closeEntry();
                        return;
                    }
                }
            } else {
                String[] list = file.list();
                if (list.length <= 0) {
                    zipOutputStream.putNextEntry(new ZipEntry(str2 + File.separator));
                    zipOutputStream.closeEntry();
                }
                for (String str3 : list) {
                    ZipFiles(str + str2 + InternalZipConstants.ZIP_FILE_SEPARATOR, str3, zipOutputStream);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean zipFiles(ArrayList<String> arrayList, String str) {
        if (arrayList != null && arrayList.size() != 0 && str != null) {
            try {
                ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str));
                for (int i = 0; i < arrayList.size(); i++) {
                    File file = new File(arrayList.get(i));
                    if (file.isFile() && file.exists()) {
                        try {
                            ZipEntry zipEntry = new ZipEntry(file.getName());
                            FileInputStream fileInputStream = new FileInputStream(file);
                            zipOutputStream.putNextEntry(zipEntry);
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read);
                            }
                            zipOutputStream.closeEntry();
                        } catch (Exception unused) {
                        }
                    }
                }
                try {
                    zipOutputStream.finish();
                    zipOutputStream.close();
                    return true;
                } catch (Exception unused2) {
                    return true;
                }
            } catch (Exception unused3) {
            }
        }
        return false;
    }
}
