package org.apache.xmlbeans.impl.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.nio.channels.FileChannel;

/* loaded from: classes5.dex */
public class IOUtil {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$common$IOUtil;

    static {
        if (class$org$apache$xmlbeans$impl$common$IOUtil == null) {
            class$org$apache$xmlbeans$impl$common$IOUtil = class$("org.apache.xmlbeans.impl.common.IOUtil");
        }
        $assertionsDisabled = true;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static void copyCompletely(InputStream inputStream, OutputStream outputStream) throws IOException {
        if ((outputStream instanceof FileOutputStream) && (inputStream instanceof FileInputStream)) {
            try {
                FileChannel channel = ((FileOutputStream) outputStream).getChannel();
                FileChannel channel2 = ((FileInputStream) inputStream).getChannel();
                channel2.transferTo(0L, 2147483647L, channel);
                channel2.close();
                channel.close();
                return;
            } catch (Exception unused) {
            }
        }
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 0) {
                try {
                    break;
                } catch (IOException unused2) {
                }
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
        inputStream.close();
        try {
            outputStream.close();
        } catch (IOException unused3) {
        }
    }

    public static void copyCompletely(Reader reader, Writer writer) throws IOException {
        char[] cArr = new char[8192];
        while (true) {
            int read = reader.read(cArr);
            if (read < 0) {
                try {
                    break;
                } catch (IOException unused) {
                }
            } else {
                writer.write(cArr, 0, read);
            }
        }
        reader.close();
        try {
            writer.close();
        } catch (IOException unused2) {
        }
    }

    public static void copyCompletely(URI uri, URI uri2) throws IOException {
        InputStream inputStream = null;
        try {
            try {
                File file = new File(uri);
                if (file.exists()) {
                    inputStream = new FileInputStream(file);
                }
            } catch (Exception unused) {
            }
            File file2 = new File(uri2);
            file2.getParentFile().mkdirs();
            if (inputStream == null) {
                inputStream = uri.toURL().openStream();
            }
            copyCompletely(inputStream, new FileOutputStream(file2));
        } catch (IllegalArgumentException unused2) {
            throw new IOException(new StringBuffer().append("Cannot copy to ").append(uri2).toString());
        }
    }

    public static File createDir(File file, String str) {
        if (str != null) {
            file = new File(file, str);
        }
        boolean z = (file.exists() && file.isDirectory()) || file.mkdirs();
        if ($assertionsDisabled || z) {
            return file;
        }
        throw new AssertionError(new StringBuffer().append("Could not create ").append(file.getAbsolutePath()).toString());
    }
}
