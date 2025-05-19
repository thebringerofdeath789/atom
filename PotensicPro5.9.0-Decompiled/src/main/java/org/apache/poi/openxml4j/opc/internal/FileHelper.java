package org.apache.poi.openxml4j.opc.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: classes5.dex */
public final class FileHelper {
    public static File getDirectory(File file) {
        if (file == null) {
            return null;
        }
        String path = file.getPath();
        int length = path.length();
        do {
            length--;
            if (length < 0) {
                return null;
            }
        } while (path.charAt(length) != File.separatorChar);
        return new File(path.substring(0, length));
    }

    public static void copyFile(File file, File file2) throws IOException {
        FileChannel channel = new FileInputStream(file).getChannel();
        FileChannel channel2 = new FileOutputStream(file2).getChannel();
        channel.transferTo(0L, channel.size(), channel2);
        channel.close();
        channel2.close();
    }

    public static String getFilename(File file) {
        if (file == null) {
            return "";
        }
        String path = file.getPath();
        int length = path.length();
        int i = length;
        do {
            i--;
            if (i < 0) {
                return "";
            }
        } while (path.charAt(i) != File.separatorChar);
        return path.substring(i + 1, length);
    }
}
