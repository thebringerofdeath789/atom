package org.apache.xmlbeans.impl.jam.internal.parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.xmlbeans.impl.jam.JamClassLoader;
import org.apache.xmlbeans.impl.jam.mutable.MClass;
import org.apache.xmlbeans.impl.jam.provider.JamClassBuilder;
import org.apache.xmlbeans.impl.jam.provider.JamClassPopulator;
import org.apache.xmlbeans.impl.jam.provider.JamServiceContext;
import org.apache.xmlbeans.impl.jam.provider.ResourcePath;

/* loaded from: classes5.dex */
public class ParserClassBuilder extends JamClassBuilder implements JamClassPopulator {
    private static final boolean VERBOSE = false;
    private PrintWriter mOut;
    private ResourcePath mSourcePath;
    private boolean mVerbose;

    private ParserClassBuilder() {
        this.mVerbose = false;
        this.mOut = new PrintWriter(System.out);
    }

    public ParserClassBuilder(JamServiceContext jamServiceContext) {
        this.mVerbose = false;
        this.mOut = new PrintWriter(System.out);
        this.mSourcePath = jamServiceContext.getInputSourcepath();
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamClassBuilder
    public MClass build(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("null pkg");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("null name");
        }
        String stringBuffer = new StringBuffer().append(str.replace('.', File.separatorChar)).append(File.separatorChar).append(str2).append(".java").toString();
        if (str2.indexOf(".") != -1) {
            throw new IllegalArgumentException("inner classes are NYI at the moment");
        }
        InputStream findInPath = this.mSourcePath.findInPath(stringBuffer);
        if (findInPath == null) {
            if (this.mVerbose) {
                this.mOut.println(new StringBuffer().append("[ParserClassBuilder] could not find ").append(stringBuffer).toString());
            }
            return null;
        }
        if (this.mVerbose) {
            this.mOut.println(new StringBuffer().append("[ParserClassBuilder] loading class ").append(str).append("  ").append(str2).toString());
            this.mOut.println(new StringBuffer().append("[ParserClassBuilder] from file ").append(stringBuffer).toString());
        }
        try {
            new InputStreamReader(findInPath).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamClassPopulator
    public void populate(MClass mClass) {
        throw new IllegalStateException("NYI");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MClass[] parse(Reader reader, JamClassLoader jamClassLoader) throws Exception {
        if (reader == null) {
            throw new IllegalArgumentException("null in");
        }
        if (jamClassLoader == null) {
            throw new IllegalArgumentException("null loader");
        }
        throw new IllegalStateException("temporarily NI");
    }

    public static void main(String[] strArr) {
        new MainTool().process(strArr);
    }

    static class MainTool {
        private List mFailures = new ArrayList();
        private int mCount = 0;
        private PrintWriter mOut = new PrintWriter(System.out);
        private long mStartTime = System.currentTimeMillis();

        MainTool() {
        }

        public void process(String[] strArr) {
            for (String str : strArr) {
                try {
                    parse(new ParserClassBuilder(), new File(str));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.mOut.println("\n\n\n");
            int size = this.mFailures.size();
            if (size != 0) {
                this.mOut.println("The following files failed to parse:");
                for (int i = 0; i < size; i++) {
                    this.mOut.println(((File) this.mFailures.get(i)).getAbsolutePath());
                }
            }
            PrintWriter printWriter = this.mOut;
            StringBuffer stringBuffer = new StringBuffer();
            int i2 = this.mCount;
            printWriter.println(stringBuffer.append(((i2 - size) * 100) / i2).append("% (").append(this.mCount - size).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(this.mCount).append(") ").append("of input java files successfully parsed.").toString());
            this.mOut.println(new StringBuffer().append("Total time: ").append((System.currentTimeMillis() - this.mStartTime) / 1000).append(" seconds.").toString());
            this.mOut.flush();
            System.out.flush();
            System.err.flush();
        }

        private void parse(ParserClassBuilder parserClassBuilder, File file) throws Exception {
            System.gc();
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    parse(parserClassBuilder, file2);
                }
                return;
            }
            if (file.getName().endsWith(".java")) {
                this.mCount++;
                try {
                    if (ParserClassBuilder.parse(new FileReader(file), null) == null) {
                        this.mOut.println("[error, parser result is null]");
                        addFailure(file);
                    }
                } catch (Throwable th) {
                    th.printStackTrace(this.mOut);
                    addFailure(file);
                }
            }
        }

        private void addFailure(File file) {
            this.mFailures.add(file);
        }
    }
}
