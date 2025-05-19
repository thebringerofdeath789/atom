package org.apache.xmlbeans.impl.jam.internal;

import com.opencsv.ICSVParser;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import org.apache.xmlbeans.impl.jam.provider.JamLogger;

/* loaded from: classes5.dex */
public class DirectoryScanner {
    private Vector mDirsIncluded;
    private String[] mExcludes;
    private Vector mFilesIncluded;
    private String[] mIncludes;
    private JamLogger mLogger;
    private File mRoot;
    private boolean mCaseSensitive = true;
    private List mIncludeList = null;
    private List mExcludeList = null;
    private boolean mIsDirty = false;
    private String[] mIncludedFilesCache = null;

    public DirectoryScanner(File file, JamLogger jamLogger) {
        if (jamLogger == null) {
            throw new IllegalArgumentException("null logger");
        }
        this.mLogger = jamLogger;
        this.mRoot = file;
    }

    public void include(String str) {
        if (this.mIncludeList == null) {
            this.mIncludeList = new ArrayList();
        }
        this.mIncludeList.add(str);
        this.mIsDirty = true;
    }

    public void exclude(String str) {
        if (this.mExcludeList == null) {
            this.mExcludeList = new ArrayList();
        }
        this.mExcludeList.add(str);
        this.mIsDirty = true;
    }

    public String[] getIncludedFiles() throws IOException {
        String[] strArr;
        if (!this.mIsDirty && (strArr = this.mIncludedFilesCache) != null) {
            return strArr;
        }
        List list = this.mIncludeList;
        if (list != null) {
            String[] strArr2 = new String[list.size()];
            this.mIncludeList.toArray(strArr2);
            setIncludes(strArr2);
        } else {
            setIncludes(null);
        }
        List list2 = this.mExcludeList;
        if (list2 != null) {
            String[] strArr3 = new String[list2.size()];
            this.mExcludeList.toArray(strArr3);
            setExcludes(strArr3);
        } else {
            setExcludes(null);
        }
        scan();
        String[] strArr4 = new String[this.mFilesIncluded.size()];
        this.mIncludedFilesCache = strArr4;
        this.mFilesIncluded.copyInto(strArr4);
        return this.mIncludedFilesCache;
    }

    public void setDirty() {
        this.mIsDirty = true;
    }

    public File getRoot() {
        return this.mRoot;
    }

    private void setIncludes(String[] strArr) {
        if (strArr == null) {
            this.mIncludes = null;
            return;
        }
        this.mIncludes = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String replace = strArr[i].replace('/', File.separatorChar).replace(ICSVParser.DEFAULT_ESCAPE_CHARACTER, File.separatorChar);
            if (replace.endsWith(File.separator)) {
                replace = new StringBuffer().append(replace).append("**").toString();
            }
            this.mIncludes[i] = replace;
        }
    }

    private void setExcludes(String[] strArr) {
        if (strArr == null) {
            this.mExcludes = null;
            return;
        }
        this.mExcludes = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String replace = strArr[i].replace('/', File.separatorChar).replace(ICSVParser.DEFAULT_ESCAPE_CHARACTER, File.separatorChar);
            if (replace.endsWith(File.separator)) {
                replace = new StringBuffer().append(replace).append("**").toString();
            }
            this.mExcludes[i] = replace;
        }
    }

    private void scan() throws IllegalStateException, IOException {
        if (this.mIncludes == null) {
            this.mIncludes = new String[]{"**"};
        }
        if (this.mExcludes == null) {
            this.mExcludes = new String[0];
        }
        this.mFilesIncluded = new Vector();
        this.mDirsIncluded = new Vector();
        if (isIncluded("") && !isExcluded("")) {
            this.mDirsIncluded.addElement("");
        }
        scandir(this.mRoot, "", true);
    }

    private void scandir(File file, String str, boolean z) throws IOException {
        if (this.mLogger.isVerbose(this)) {
            this.mLogger.verbose(new StringBuffer().append("[DirectoryScanner] scanning dir ").append(file).append(" for '").append(str).append("'").toString());
        }
        String[] list = file.list();
        if (list == null) {
            throw new IOException(new StringBuffer().append("IO error scanning directory ").append(file.getAbsolutePath()).toString());
        }
        for (int i = 0; i < list.length; i++) {
            String stringBuffer = new StringBuffer().append(str).append(list[i]).toString();
            File file2 = new File(file, list[i]);
            if (file2.isDirectory()) {
                if (isIncluded(stringBuffer) && !isExcluded(stringBuffer)) {
                    this.mDirsIncluded.addElement(stringBuffer);
                    if (this.mLogger.isVerbose(this)) {
                        this.mLogger.verbose(new StringBuffer().append("...including dir ").append(stringBuffer).toString());
                    }
                    scandir(file2, new StringBuffer().append(stringBuffer).append(File.separator).toString(), z);
                } else if (couldHoldIncluded(stringBuffer)) {
                    scandir(file2, new StringBuffer().append(stringBuffer).append(File.separator).toString(), z);
                }
            } else if (file2.isFile() && isIncluded(stringBuffer)) {
                if (!isExcluded(stringBuffer)) {
                    this.mFilesIncluded.addElement(stringBuffer);
                    if (this.mLogger.isVerbose(this)) {
                        this.mLogger.verbose(new StringBuffer().append("...including ").append(stringBuffer).append(" under '").append(file).toString());
                    }
                } else if (this.mLogger.isVerbose(this)) {
                    this.mLogger.verbose(new StringBuffer().append("...EXCLUDING ").append(stringBuffer).append(" under '").append(file).toString());
                }
            }
        }
    }

    private boolean isIncluded(String str) {
        int i = 0;
        while (true) {
            String[] strArr = this.mIncludes;
            if (i >= strArr.length) {
                return false;
            }
            if (matchPath(strArr[i], str, this.mCaseSensitive)) {
                return true;
            }
            i++;
        }
    }

    private boolean couldHoldIncluded(String str) {
        int i = 0;
        while (true) {
            String[] strArr = this.mIncludes;
            if (i >= strArr.length) {
                return false;
            }
            if (matchPatternStart(strArr[i], str, this.mCaseSensitive)) {
                return true;
            }
            i++;
        }
    }

    private boolean isExcluded(String str) {
        int i = 0;
        while (true) {
            String[] strArr = this.mExcludes;
            if (i >= strArr.length) {
                return false;
            }
            if (matchPath(strArr[i], str, this.mCaseSensitive)) {
                return true;
            }
            i++;
        }
    }

    private static boolean matchPatternStart(String str, String str2, boolean z) {
        if (str2.startsWith(File.separator) != str.startsWith(File.separator)) {
            return false;
        }
        Vector vector = tokenizePath(str);
        Vector vector2 = tokenizePath(str2);
        int size = vector.size() - 1;
        int size2 = vector2.size() - 1;
        int i = 0;
        int i2 = 0;
        while (i <= size && i2 <= size2) {
            String str3 = (String) vector.elementAt(i);
            if (str3.equals("**")) {
                break;
            }
            if (!match(str3, (String) vector2.elementAt(i2), z)) {
                return false;
            }
            i++;
            i2++;
        }
        return i2 > size2 || i <= size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean matchPath(String str, String str2, boolean z) {
        int i;
        int i2 = 0;
        if (str2.startsWith(File.separator) != str.startsWith(File.separator)) {
            return false;
        }
        Vector vector = tokenizePath(str);
        Vector vector2 = tokenizePath(str2);
        int i3 = 1;
        int size = vector.size() - 1;
        int size2 = vector2.size() - 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 <= size && i5 <= size2) {
            String str3 = (String) vector.elementAt(i4);
            if (str3.equals("**")) {
                break;
            }
            if (!match(str3, (String) vector2.elementAt(i5), z)) {
                return false;
            }
            i4++;
            i5++;
        }
        if (i5 > size2) {
            while (i4 <= size) {
                if (!vector.elementAt(i4).equals("**")) {
                    return false;
                }
                i4++;
            }
            return true;
        }
        if (i4 > size) {
            return false;
        }
        while (i4 <= size && i5 <= size2) {
            String str4 = (String) vector.elementAt(size);
            if (str4.equals("**")) {
                break;
            }
            if (!match(str4, (String) vector2.elementAt(size2), z)) {
                return false;
            }
            size--;
            size2--;
        }
        if (i5 > size2) {
            while (i4 <= size) {
                if (!vector.elementAt(i4).equals("**")) {
                    return false;
                }
                i4++;
            }
            return true;
        }
        while (i4 != size && i5 <= size2) {
            int i6 = i4 + 1;
            int i7 = i6;
            while (true) {
                if (i7 > size) {
                    i7 = -1;
                    break;
                }
                if (vector.elementAt(i7).equals("**")) {
                    break;
                }
                i7++;
            }
            if (i7 == i6) {
                i4 = i6;
            } else {
                int i8 = (i7 - i4) - i3;
                int i9 = (size2 - i5) + i3;
                int i10 = i2;
                while (true) {
                    if (i10 > i9 - i8) {
                        i = -1;
                        break;
                    }
                    for (int i11 = i2; i11 < i8; i11++) {
                        if (!match((String) vector.elementAt(i4 + i11 + 1), (String) vector2.elementAt(i5 + i10 + i11), z)) {
                            break;
                        }
                    }
                    i = i5 + i10;
                    break;
                    i10++;
                    i2 = 0;
                }
                if (i == -1) {
                    return false;
                }
                i5 = i + i8;
                i2 = 0;
                i4 = i7;
                i3 = 1;
            }
        }
        boolean z2 = i2;
        while (i4 <= size) {
            if (!vector.elementAt(i4).equals("**")) {
                return z2;
            }
            i4++;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x00ba, code lost:
    
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x00be, code lost:
    
        if (r11 != r10) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x00c2, code lost:
    
        r10 = (r11 - r6) - r3;
        r13 = (r4 - r9) + r3;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x00cb, code lost:
    
        if (r14 > (r13 - r10)) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x00cd, code lost:
    
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x00ce, code lost:
    
        if (r15 >= r10) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x00d0, code lost:
    
        r3 = r0[(r6 + r15) + 1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x00d6, code lost:
    
        if (r3 == r7) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x00d8, code lost:
    
        if (r19 == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x00e0, code lost:
    
        if (r3 == r1[(r9 + r14) + r15]) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x00f4, code lost:
    
        r14 = r14 + 1;
        r7 = '?';
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x00e3, code lost:
    
        if (r19 != false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x00f2, code lost:
    
        if (java.lang.Character.toUpperCase(r3) == java.lang.Character.toUpperCase(r1[(r9 + r14) + r15])) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x00fa, code lost:
    
        r15 = r15 + 1;
        r7 = '?';
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0100, code lost:
    
        r9 = r9 + r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0103, code lost:
    
        if (r9 != (-1)) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0106, code lost:
    
        r9 = r9 + r10;
        r6 = r11;
        r3 = 1;
        r7 = '?';
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0105, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0102, code lost:
    
        r9 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x00c0, code lost:
    
        r6 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x00bd, code lost:
    
        r11 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x010c, code lost:
    
        if (r6 > r2) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0110, code lost:
    
        if (r0[r6] == '*') goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0113, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0112, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0116, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x006e, code lost:
    
        if (r9 <= r4) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0070, code lost:
    
        if (r6 > r2) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0074, code lost:
    
        if (r0[r6] == '*') goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0077, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0076, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x007a, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x007b, code lost:
    
        r10 = r0[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x007d, code lost:
    
        if (r10 == '*') goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x007f, code lost:
    
        if (r9 > r4) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0081, code lost:
    
        if (r10 == '?') goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0083, code lost:
    
        if (r19 == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0087, code lost:
    
        if (r10 == r1[r4]) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0089, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x008a, code lost:
    
        if (r19 != false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0096, code lost:
    
        if (java.lang.Character.toUpperCase(r10) == java.lang.Character.toUpperCase(r1[r4])) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0098, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0099, code lost:
    
        r2 = r2 - 1;
        r4 = r4 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x009e, code lost:
    
        if (r9 <= r4) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00a0, code lost:
    
        if (r6 > r2) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00a4, code lost:
    
        if (r0[r6] == '*') goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00a7, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00a6, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00aa, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00ab, code lost:
    
        if (r6 == r2) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00ad, code lost:
    
        if (r9 > r4) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00af, code lost:
    
        r10 = r6 + 1;
        r11 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x00b3, code lost:
    
        if (r11 > r2) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00b7, code lost:
    
        if (r0[r11] != '*') goto L79;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean match(java.lang.String r17, java.lang.String r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.jam.internal.DirectoryScanner.match(java.lang.String, java.lang.String, boolean):boolean");
    }

    private static Vector tokenizePath(String str) {
        Vector vector = new Vector();
        StringTokenizer stringTokenizer = new StringTokenizer(str, File.separator);
        while (stringTokenizer.hasMoreTokens()) {
            vector.addElement(stringTokenizer.nextToken());
        }
        return vector;
    }
}
