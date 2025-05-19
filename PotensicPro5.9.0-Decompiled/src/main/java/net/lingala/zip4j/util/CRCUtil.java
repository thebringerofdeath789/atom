package net.lingala.zip4j.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.progress.ProgressMonitor;

/* loaded from: classes4.dex */
public class CRCUtil {
    private static final int BUF_SIZE = 16384;

    public static long computeFileCRC(String str) throws ZipException {
        return computeFileCRC(str, null);
    }

    public static long computeFileCRC(String str, ProgressMonitor progressMonitor) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("input file is null or empty, cannot calculate CRC for the file");
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                Zip4jUtil.checkFileReadAccess(str);
                FileInputStream fileInputStream2 = new FileInputStream(new File(str));
                try {
                    byte[] bArr = new byte[16384];
                    CRC32 crc32 = new CRC32();
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read != -1) {
                            crc32.update(bArr, 0, read);
                            if (progressMonitor != null) {
                                progressMonitor.updateWorkCompleted(read);
                                if (progressMonitor.isCancelAllTasks()) {
                                    progressMonitor.setResult(3);
                                    progressMonitor.setState(0);
                                    try {
                                        fileInputStream2.close();
                                        return 0L;
                                    } catch (IOException unused) {
                                        throw new ZipException("error while closing the file after calculating crc");
                                    }
                                }
                            }
                        } else {
                            long value = crc32.getValue();
                            try {
                                fileInputStream2.close();
                                return value;
                            } catch (IOException unused2) {
                                throw new ZipException("error while closing the file after calculating crc");
                            }
                        }
                    }
                } catch (IOException e) {
                    e = e;
                    throw new ZipException(e);
                } catch (Exception e2) {
                    e = e2;
                    throw new ZipException(e);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                            throw new ZipException("error while closing the file after calculating crc");
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
