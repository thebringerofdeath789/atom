package org.apache.xmlbeans.impl.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.xmlbeans.Filer;
import repackage.Repackager;

/* loaded from: classes5.dex */
public class FilerImpl implements Filer {
    private static final Charset CHARSET;
    private File classdir;
    private boolean incrSrcGen;
    private Repackager repackager;
    private Set seenTypes;
    private List sourceFiles;
    private File srcdir;
    private boolean verbose;

    static {
        Charset charset;
        try {
            charset = Charset.forName(System.getProperty("file.encoding"));
        } catch (Exception unused) {
            charset = null;
        }
        CHARSET = charset;
    }

    public FilerImpl(File file, File file2, Repackager repackager, boolean z, boolean z2) {
        this.classdir = file;
        this.srcdir = file2;
        this.repackager = repackager;
        this.verbose = z;
        List list = this.sourceFiles;
        this.sourceFiles = list == null ? new ArrayList() : list;
        this.incrSrcGen = z2;
        if (z2) {
            this.seenTypes = new HashSet();
        }
    }

    @Override // org.apache.xmlbeans.Filer
    public OutputStream createBinaryFile(String str) throws IOException {
        if (this.verbose) {
            System.err.println(new StringBuffer().append("created binary: ").append(str).toString());
        }
        File file = new File(this.classdir, str);
        file.getParentFile().mkdirs();
        return new FileOutputStream(file);
    }

    @Override // org.apache.xmlbeans.Filer
    public Writer createSourceFile(String str) throws IOException {
        if (this.incrSrcGen) {
            this.seenTypes.add(str);
        }
        if (str.indexOf(36) > 0) {
            str = new StringBuffer().append(str.substring(0, str.lastIndexOf(46))).append(".").append(str.substring(str.indexOf(36) + 1)).toString();
        }
        File file = new File(this.srcdir, new StringBuffer().append(str.replace('.', File.separatorChar)).append(".java").toString());
        file.getParentFile().mkdirs();
        if (this.verbose) {
            System.err.println(new StringBuffer().append("created source: ").append(file.getAbsolutePath()).toString());
        }
        this.sourceFiles.add(file);
        if (this.incrSrcGen && file.exists()) {
            return new IncrFileWriter(file, this.repackager);
        }
        return this.repackager == null ? writerForFile(file) : new RepackagingWriter(file, this.repackager);
    }

    public List getSourceFiles() {
        return new ArrayList(this.sourceFiles);
    }

    public Repackager getRepackager() {
        return this.repackager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Writer writerForFile(File file) throws IOException {
        Charset charset = CHARSET;
        if (charset == null) {
            return new FileWriter(file);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        CharsetEncoder newEncoder = charset.newEncoder();
        newEncoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        return new OutputStreamWriter(fileOutputStream, newEncoder);
    }

    static class IncrFileWriter extends StringWriter {
        private File _file;
        private Repackager _repackager;

        public IncrFileWriter(File file, Repackager repackager) {
            this._file = file;
            this._repackager = repackager;
        }

        @Override // java.io.StringWriter, java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            Repackager repackager = this._repackager;
            String stringBuffer = (repackager != null ? repackager.repackage(getBuffer()) : getBuffer()).toString();
            ArrayList arrayList = new ArrayList();
            StringReader stringReader = new StringReader(stringBuffer);
            FileReader fileReader = new FileReader(this._file);
            try {
                Diff.readersAsText(stringReader, "<generated>", fileReader, this._file.getName(), arrayList);
                stringReader.close();
                fileReader.close();
                if (arrayList.size() > 0) {
                    Writer writerForFile = FilerImpl.writerForFile(this._file);
                    try {
                        writerForFile.write(stringBuffer);
                    } finally {
                        writerForFile.close();
                    }
                }
            } catch (Throwable th) {
                stringReader.close();
                fileReader.close();
                throw th;
            }
        }
    }

    static class RepackagingWriter extends StringWriter {
        private File _file;
        private Repackager _repackager;

        public RepackagingWriter(File file, Repackager repackager) {
            this._file = file;
            this._repackager = repackager;
        }

        @Override // java.io.StringWriter, java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            Writer writerForFile = FilerImpl.writerForFile(this._file);
            try {
                writerForFile.write(this._repackager.repackage(getBuffer()).toString());
            } finally {
                writerForFile.close();
            }
        }
    }
}
