package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.impl.common.IOUtil;

/* loaded from: classes5.dex */
public class CommandLine {
    private static final File[] EMPTY_FILEARRAY = new File[0];
    private static final URL[] EMPTY_URLARRAY = new URL[0];
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$tool$CommandLine;
    private String[] _args;
    private String[] _badopts;
    private File _baseDir;
    private List _files;
    private Map _options;
    private List _urls;

    public CommandLine(String[] strArr, Collection collection, Collection collection2) {
        if (collection == null || collection2 == null) {
            throw new IllegalArgumentException("collection required (use Collections.EMPTY_SET if no options)");
        }
        this._options = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (i < strArr.length) {
            if (strArr[i].indexOf(45) == 0) {
                String substring = strArr[i].substring(1);
                String str = null;
                if (!collection.contains(substring)) {
                    if (collection2.contains(substring)) {
                        int i2 = i + 1;
                        if (i2 < strArr.length) {
                            str = strArr[i2];
                            i = i2;
                        }
                    } else {
                        arrayList.add(strArr[i]);
                    }
                    this._options.put(substring, str);
                }
                str = "";
                this._options.put(substring, str);
            } else {
                arrayList2.add(strArr[i]);
            }
            i++;
        }
        this._badopts = (String[]) arrayList.toArray(new String[arrayList.size()]);
        this._args = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static void printLicense() {
        try {
            Class cls = class$org$apache$xmlbeans$impl$tool$CommandLine;
            if (cls == null) {
                cls = class$("org.apache.xmlbeans.impl.tool.CommandLine");
                class$org$apache$xmlbeans$impl$tool$CommandLine = cls;
            }
            IOUtil.copyCompletely(cls.getClassLoader().getResourceAsStream("LICENSE.txt"), System.out);
        } catch (Exception unused) {
            System.out.println("License available in this JAR in LICENSE.txt");
        }
    }

    public static void printVersion() {
        System.out.println(new StringBuffer().append(XmlBeans.getVendor()).append(", ").append(XmlBeans.getTitle()).append(".XmlBeans version ").append(XmlBeans.getVersion()).toString());
    }

    public String[] args() {
        String[] strArr = this._args;
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return strArr2;
    }

    public String[] getBadOpts() {
        return this._badopts;
    }

    public String getOpt(String str) {
        return (String) this._options.get(str);
    }

    private static List collectFiles(File[] fileArr) {
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            if (!file.isDirectory()) {
                arrayList.add(file);
            } else {
                arrayList.addAll(collectFiles(file.listFiles()));
            }
        }
        return arrayList;
    }

    private List getFileList() {
        if (this._files == null) {
            String[] args = args();
            File[] fileArr = new File[args.length];
            boolean z = false;
            for (int i = 0; i < args.length; i++) {
                fileArr[i] = new File(args[i]);
                if (!z && this._baseDir == null) {
                    if (fileArr[i].isDirectory()) {
                        this._baseDir = fileArr[i];
                    } else {
                        this._baseDir = fileArr[i].getParentFile();
                    }
                } else {
                    URI uri = fileArr[i].toURI();
                    File file = this._baseDir;
                    if (file != null && file.toURI().relativize(uri).equals(uri)) {
                        this._baseDir = null;
                        z = true;
                    }
                }
            }
            this._files = Collections.unmodifiableList(collectFiles(fileArr));
        }
        return this._files;
    }

    private List getUrlList() {
        if (this._urls == null) {
            String[] args = args();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < args.length; i++) {
                if (looksLikeURL(args[i])) {
                    try {
                        arrayList.add(new URL(args[i]));
                    } catch (MalformedURLException e) {
                        System.err.println(new StringBuffer().append("ignoring invalid url: ").append(args[i]).append(": ").append(e.getMessage()).toString());
                    }
                }
            }
            this._urls = Collections.unmodifiableList(arrayList);
        }
        return this._urls;
    }

    private static boolean looksLikeURL(String str) {
        return str.startsWith("http:") || str.startsWith("https:") || str.startsWith("ftp:") || str.startsWith("file:");
    }

    public URL[] getURLs() {
        return (URL[]) getUrlList().toArray(EMPTY_URLARRAY);
    }

    public File[] getFiles() {
        return (File[]) getFileList().toArray(EMPTY_FILEARRAY);
    }

    public File getBaseDir() {
        return this._baseDir;
    }

    public File[] filesEndingWith(String str) {
        ArrayList arrayList = new ArrayList();
        for (File file : getFileList()) {
            if (file.getName().endsWith(str) && !looksLikeURL(file.getPath())) {
                arrayList.add(file);
            }
        }
        return (File[]) arrayList.toArray(EMPTY_FILEARRAY);
    }
}
