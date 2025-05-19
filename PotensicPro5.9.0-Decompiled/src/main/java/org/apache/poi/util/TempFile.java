package org.apache.poi.util;

import java.io.File;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class TempFile {
    private static TempFileCreationStrategy strategy = new DefaultTempFileCreationStrategy();

    public static void setTempFileCreationStrategy(TempFileCreationStrategy tempFileCreationStrategy) {
        if (tempFileCreationStrategy == null) {
            throw new IllegalArgumentException("strategy == null");
        }
        strategy = tempFileCreationStrategy;
    }

    public static File createTempFile(String str, String str2) throws IOException {
        return strategy.createTempFile(str, str2);
    }

    public static class DefaultTempFileCreationStrategy implements TempFileCreationStrategy {
        private File dir;

        public DefaultTempFileCreationStrategy() {
            this(null);
        }

        public DefaultTempFileCreationStrategy(File file) {
            this.dir = file;
        }

        @Override // org.apache.poi.util.TempFileCreationStrategy
        public File createTempFile(String str, String str2) throws IOException {
            if (this.dir == null) {
                File file = new File(System.getProperty("java.io.tmpdir"), "poifiles");
                this.dir = file;
                file.mkdir();
                if (System.getProperty("poi.keep.tmp.files") == null) {
                    this.dir.deleteOnExit();
                }
            }
            File createTempFile = File.createTempFile(str, str2, this.dir);
            if (System.getProperty("poi.keep.tmp.files") == null) {
                createTempFile.deleteOnExit();
            }
            return createTempFile;
        }
    }
}
