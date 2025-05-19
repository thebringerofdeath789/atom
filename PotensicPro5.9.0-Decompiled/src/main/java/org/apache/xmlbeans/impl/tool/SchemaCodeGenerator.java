package org.apache.xmlbeans.impl.tool;

import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.util.FilerImpl;
import repackage.Repackager;

/* loaded from: classes5.dex */
public class SchemaCodeGenerator {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$tool$SchemaCodeGenerator;
    private static Set deleteFileQueue;
    private static int triesRemaining;

    static {
        if (class$org$apache$xmlbeans$impl$tool$SchemaCodeGenerator == null) {
            class$org$apache$xmlbeans$impl$tool$SchemaCodeGenerator = class$("org.apache.xmlbeans.impl.tool.SchemaCodeGenerator");
        }
        $assertionsDisabled = true;
        deleteFileQueue = new HashSet();
        triesRemaining = 0;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static void saveTypeSystem(SchemaTypeSystem schemaTypeSystem, File file, File file2, Repackager repackager, XmlOptions xmlOptions) throws IOException {
        schemaTypeSystem.save(new FilerImpl(file, null, repackager, false, false));
    }

    static void deleteObsoleteFiles(File file, File file2, Set set) {
        if (!file.isDirectory() || !file2.isDirectory()) {
            throw new IllegalArgumentException();
        }
        String absolutePath = file2.getAbsolutePath();
        if (absolutePath.length() <= 5) {
            return;
        }
        if (!absolutePath.startsWith("/home/") || (absolutePath.indexOf(InternalZipConstants.ZIP_FILE_SEPARATOR, 6) < absolutePath.length() - 1 && absolutePath.indexOf(InternalZipConstants.ZIP_FILE_SEPARATOR, 6) >= 0)) {
            File[] listFiles = file2.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory()) {
                    deleteObsoleteFiles(file, listFiles[i], set);
                } else if (!set.contains(listFiles[i])) {
                    deleteXmlBeansFile(listFiles[i]);
                    deleteDirRecursively(file, listFiles[i].getParentFile());
                }
            }
        }
    }

    private static void deleteXmlBeansFile(File file) {
        if (file.getName().endsWith(".java")) {
            file.delete();
        }
    }

    private static void deleteDirRecursively(File file, File file2) {
        String[] list = file2.list();
        while (list != null && list.length == 0 && !file2.equals(file)) {
            file2.delete();
            file2 = file2.getParentFile();
            list = file2.list();
        }
    }

    protected static File createTempDir() throws IOException {
        String str;
        try {
            new File(SystemProperties.getProperty("java.io.tmpdir")).mkdirs();
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = null;
        File createTempFile = File.createTempFile("xbean", null);
        String absolutePath = createTempFile.getAbsolutePath();
        if (!absolutePath.endsWith(DiskFileUpload.postfix)) {
            throw new IOException("Error: createTempFile did not create a file ending with .tmp");
        }
        int i = 0;
        String substring = absolutePath.substring(0, absolutePath.length() - 4);
        while (true) {
            if (i >= 100) {
                break;
            }
            StringBuffer append = new StringBuffer().append(substring).append(".d");
            if (i == 0) {
                str = "";
            } else {
                int i2 = i + 1;
                String num = Integer.toString(i);
                i = i2;
                str = num;
            }
            File file2 = new File(append.append(str).toString());
            if (file2.exists()) {
                i++;
                file = file2;
            } else {
                boolean mkdirs = file2.mkdirs();
                if (!$assertionsDisabled && !mkdirs) {
                    throw new AssertionError(new StringBuffer().append("Could not create ").append(file2.getAbsolutePath()).toString());
                }
                file = file2;
            }
        }
        createTempFile.deleteOnExit();
        return file;
    }

    protected static void tryHardToDelete(File file) {
        tryToDelete(file);
        if (file.exists()) {
            tryToDeleteLater(file);
        }
    }

    private static void tryToDelete(File file) {
        String[] list;
        if (file.exists()) {
            if (file.isDirectory() && (list = file.list()) != null) {
                for (String str : list) {
                    tryToDelete(new File(file, str));
                }
            }
            if (!file.delete()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean tryNowThatItsLater() {
        /*
            java.util.Set r0 = org.apache.xmlbeans.impl.tool.SchemaCodeGenerator.deleteFileQueue
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L5c
            java.util.Set r2 = org.apache.xmlbeans.impl.tool.SchemaCodeGenerator.deleteFileQueue     // Catch: java.lang.Throwable -> L5c
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L5c
            java.util.Set r2 = org.apache.xmlbeans.impl.tool.SchemaCodeGenerator.deleteFileQueue     // Catch: java.lang.Throwable -> L5c
            r2.clear()     // Catch: java.lang.Throwable -> L5c
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5c
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r1 = r1.iterator()
        L19:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L32
            java.lang.Object r2 = r1.next()
            java.io.File r2 = (java.io.File) r2
            tryToDelete(r2)
            boolean r3 = r2.exists()
            if (r3 == 0) goto L19
            r0.add(r2)
            goto L19
        L32:
            java.util.Set r1 = org.apache.xmlbeans.impl.tool.SchemaCodeGenerator.deleteFileQueue
            monitor-enter(r1)
            int r2 = org.apache.xmlbeans.impl.tool.SchemaCodeGenerator.triesRemaining     // Catch: java.lang.Throwable -> L59
            r3 = 1
            if (r2 <= 0) goto L3d
            int r2 = r2 - r3
            org.apache.xmlbeans.impl.tool.SchemaCodeGenerator.triesRemaining = r2     // Catch: java.lang.Throwable -> L59
        L3d:
            int r2 = org.apache.xmlbeans.impl.tool.SchemaCodeGenerator.triesRemaining     // Catch: java.lang.Throwable -> L59
            r4 = 0
            if (r2 <= 0) goto L4f
            int r2 = r0.size()     // Catch: java.lang.Throwable -> L59
            if (r2 != 0) goto L49
            goto L4f
        L49:
            java.util.Set r2 = org.apache.xmlbeans.impl.tool.SchemaCodeGenerator.deleteFileQueue     // Catch: java.lang.Throwable -> L59
            r2.addAll(r0)     // Catch: java.lang.Throwable -> L59
            goto L51
        L4f:
            org.apache.xmlbeans.impl.tool.SchemaCodeGenerator.triesRemaining = r4     // Catch: java.lang.Throwable -> L59
        L51:
            int r0 = org.apache.xmlbeans.impl.tool.SchemaCodeGenerator.triesRemaining     // Catch: java.lang.Throwable -> L59
            if (r0 > 0) goto L56
            goto L57
        L56:
            r3 = r4
        L57:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L59
            return r3
        L59:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L59
            throw r0
        L5c:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5c
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.tool.SchemaCodeGenerator.tryNowThatItsLater():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void giveUp() {
        synchronized (deleteFileQueue) {
            deleteFileQueue.clear();
            triesRemaining = 0;
        }
    }

    private static void tryToDeleteLater(File file) {
        synchronized (deleteFileQueue) {
            deleteFileQueue.add(file);
            if (triesRemaining == 0) {
                new Thread() { // from class: org.apache.xmlbeans.impl.tool.SchemaCodeGenerator.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        while (!SchemaCodeGenerator.tryNowThatItsLater()) {
                            try {
                                Thread.sleep(3000L);
                            } catch (InterruptedException unused) {
                                SchemaCodeGenerator.giveUp();
                                return;
                            }
                        }
                    }
                };
            }
            if (triesRemaining < 10) {
                triesRemaining = 10;
            }
        }
    }
}
