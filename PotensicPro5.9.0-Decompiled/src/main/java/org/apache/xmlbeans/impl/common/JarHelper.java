package org.apache.xmlbeans.impl.common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;

/* loaded from: classes5.dex */
public class JarHelper {
    private static final int BUFFER_SIZE = 2156;
    private static final char SEP = '/';
    private byte[] mBuffer = new byte[BUFFER_SIZE];
    private int mByteCount = 0;
    private boolean mVerbose = false;
    private String mDestJarName = "";

    public void jarDir(File file, File file2) throws IOException {
        if (file == null || file2 == null) {
            throw new IllegalArgumentException();
        }
        this.mDestJarName = file2.getCanonicalPath();
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        JarOutputStream jarOutputStream = new JarOutputStream(fileOutputStream);
        try {
            try {
                jarDir(file, jarOutputStream, null);
            } catch (IOException e) {
                throw e;
            }
        } finally {
            jarOutputStream.close();
            fileOutputStream.close();
        }
    }

    public void unjarDir(File file, File file2) throws IOException {
        unjar(new FileInputStream(file), file2);
    }

    public void unjar(InputStream inputStream, File file) throws IOException {
        JarInputStream jarInputStream = new JarInputStream(inputStream);
        while (true) {
            JarEntry nextJarEntry = jarInputStream.getNextJarEntry();
            if (nextJarEntry != null) {
                if (nextJarEntry.isDirectory()) {
                    File file2 = new File(file, nextJarEntry.getName());
                    file2.mkdir();
                    if (nextJarEntry.getTime() != -1) {
                        file2.setLastModified(nextJarEntry.getTime());
                    }
                } else {
                    byte[] bArr = new byte[BUFFER_SIZE];
                    File file3 = new File(file, nextJarEntry.getName());
                    if (this.mVerbose) {
                        System.out.println(new StringBuffer().append("unjarring ").append(file3).append(" from ").append(nextJarEntry.getName()).toString());
                    }
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3), BUFFER_SIZE);
                    while (true) {
                        int read = jarInputStream.read(bArr, 0, BUFFER_SIZE);
                        if (read == -1) {
                            break;
                        } else {
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    if (nextJarEntry.getTime() != -1) {
                        file3.setLastModified(nextJarEntry.getTime());
                    }
                }
            } else {
                jarInputStream.close();
                return;
            }
        }
    }

    public void setVerbose(boolean z) {
        this.mVerbose = z;
    }

    private void jarDir(File file, JarOutputStream jarOutputStream, String str) throws IOException {
        if (this.mVerbose) {
            System.out.println(new StringBuffer().append("checking ").append(file).toString());
        }
        if (file.isDirectory()) {
            String[] list = file.list();
            String stringBuffer = str == null ? "" : new StringBuffer().append(str).append(file.getName()).append(SEP).toString();
            if (str != null) {
                JarEntry jarEntry = new JarEntry(stringBuffer);
                jarEntry.setTime(file.lastModified());
                jarOutputStream.putNextEntry(jarEntry);
                jarOutputStream.flush();
                jarOutputStream.closeEntry();
            }
            for (String str2 : list) {
                jarDir(new File(file, str2), jarOutputStream, stringBuffer);
            }
            return;
        }
        if (file.getCanonicalPath().equals(this.mDestJarName)) {
            if (this.mVerbose) {
                System.out.println(new StringBuffer().append("skipping ").append(file.getPath()).toString());
                return;
            }
            return;
        }
        if (this.mVerbose) {
            System.out.println(new StringBuffer().append("adding ").append(file.getPath()).toString());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            try {
                JarEntry jarEntry2 = new JarEntry(new StringBuffer().append(str).append(file.getName()).toString());
                jarEntry2.setTime(file.lastModified());
                jarOutputStream.putNextEntry(jarEntry2);
                while (true) {
                    int read = fileInputStream.read(this.mBuffer);
                    this.mByteCount = read;
                    if (read != -1) {
                        jarOutputStream.write(this.mBuffer, 0, read);
                        if (this.mVerbose) {
                            System.out.println(new StringBuffer().append("wrote ").append(this.mByteCount).append(" bytes").toString());
                        }
                    } else {
                        jarOutputStream.flush();
                        jarOutputStream.closeEntry();
                        return;
                    }
                }
            } catch (IOException e) {
                throw e;
            }
        } finally {
            fileInputStream.close();
        }
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length < 2) {
            System.err.println("Usage: JarHelper jarname.jar directory");
            return;
        }
        JarHelper jarHelper = new JarHelper();
        jarHelper.mVerbose = true;
        jarHelper.jarDir(new File(strArr[1]), new File(strArr[0]));
    }
}
