package repackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class Repackage {
    private List _fromPackages;
    private List _moveAlongFiles;
    private Map _movedDirs;
    private Pattern _packagePattern;
    private Repackager _repackager;
    private int _skippedFiles;
    private File _sourceBase;
    private File _targetBase;
    private List _toPackages;

    public static void main(String[] strArr) throws Exception {
        new Repackage(strArr).repackage();
    }

    private Repackage(String[] strArr) {
        int i;
        String str = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        boolean z = false;
        while (i2 < strArr.length) {
            if (strArr[i2].equals("-repackage") && (i = i2 + 1) < strArr.length) {
                str = strArr[i];
            } else if (strArr[i2].equals("-f") && (i = i2 + 1) < strArr.length) {
                str2 = strArr[i];
            } else if (!strArr[i2].equals("-t") || (i = i2 + 1) >= strArr.length) {
                z = true;
                i2++;
            } else {
                str3 = strArr[i];
            }
            i2 = i;
            i2++;
        }
        if (!z && str != null) {
            if (!((str2 == null) ^ (str3 == null))) {
                this._repackager = new Repackager(str);
                if (str2 == null || str3 == null) {
                    return;
                }
                this._sourceBase = new File(str2);
                this._targetBase = new File(str3);
                return;
            }
        }
        throw new RuntimeException("Usage: repackage -repackage [spec] [ -f [sourcedir] -t [targetdir] ]");
    }

    public void repackage() throws Exception {
        if (this._sourceBase == null || this._targetBase == null) {
            System.out.println(this._repackager.repackage(readInputStream(System.in)).toString());
            return;
        }
        this._fromPackages = this._repackager.getFromPackages();
        this._toPackages = this._repackager.getToPackages();
        this._packagePattern = Pattern.compile("^\\s*package\\s+((?:\\w|\\.)*)\\s*;", 8);
        this._moveAlongFiles = new ArrayList();
        this._movedDirs = new HashMap();
        this._targetBase.mkdirs();
        ArrayList arrayList = new ArrayList();
        fillFiles(arrayList, this._sourceBase);
        System.out.println(new StringBuffer().append("Repackaging ").append(arrayList.size()).append(" files ...").toString());
        int length = this._sourceBase.getCanonicalPath().length();
        for (int i = 0; i < arrayList.size(); i++) {
            repackageFile(((File) arrayList.get(i)).getCanonicalPath().substring(length + 1));
        }
        finishMovingFiles();
        if (this._skippedFiles > 0) {
            System.out.println(new StringBuffer().append("Skipped ").append(this._skippedFiles).append(" unmodified files.").toString());
        }
    }

    private boolean fileIsUnchanged(String str) {
        return new File(this._sourceBase, str).lastModified() < new File(this._targetBase, str).lastModified();
    }

    public void repackageFile(String str) throws IOException {
        if (str.endsWith(".java")) {
            repackageJavaFile(str);
            return;
        }
        if (str.endsWith(".xsdconfig") || str.endsWith(".xml") || str.endsWith(".g")) {
            repackageNonJavaFile(str);
        } else if (str.startsWith(new StringBuffer().append("bin").append(File.separatorChar).toString())) {
            repackageNonJavaFile(str);
        } else {
            moveAlongWithJavaFiles(str);
        }
    }

    public void moveAlongWithJavaFiles(String str) {
        this._moveAlongFiles.add(str);
    }

    public void finishMovingFiles() throws IOException {
        for (String str : this._moveAlongFiles) {
            String str2 = (String) this._movedDirs.get(Repackager.dirForPath(str));
            String file = str2 != null ? new File(str2, new File(str).getName()).toString() : str;
            if (str.endsWith(".html")) {
                repackageNonJavaFile(str, file);
            } else {
                justMoveNonJavaFile(str, file);
            }
        }
    }

    public void repackageNonJavaFile(String str) throws IOException {
        File file = new File(this._sourceBase, str);
        File file2 = new File(this._targetBase, str);
        if (file.lastModified() < file2.lastModified()) {
            this._skippedFiles++;
        } else {
            writeFile(file2, this._repackager.repackage(readFile(file)));
        }
    }

    public void repackageNonJavaFile(String str, String str2) throws IOException {
        File file = new File(this._sourceBase, str);
        File file2 = new File(this._targetBase, str2);
        if (file.lastModified() < file2.lastModified()) {
            this._skippedFiles++;
        } else {
            writeFile(file2, this._repackager.repackage(readFile(file)));
        }
    }

    public void justMoveNonJavaFile(String str, String str2) throws IOException {
        File file = new File(this._sourceBase, str);
        File file2 = new File(this._targetBase, str2);
        if (file.lastModified() < file2.lastModified()) {
            this._skippedFiles++;
        } else {
            copyFile(file, file2);
        }
    }

    public void repackageJavaFile(String str) throws IOException {
        List list;
        List list2;
        String str2 = str;
        File file = new File(this._sourceBase, str2);
        StringBuffer readFile = readFile(file);
        Matcher matcher = this._packagePattern.matcher(readFile);
        int i = 1;
        if (matcher.find()) {
            String group = matcher.group(1);
            int start = matcher.start(1);
            int end = matcher.end(1);
            if (matcher.find()) {
                throw new RuntimeException(new StringBuffer().append("Two package specifications found: ").append(str2).toString());
            }
            ArrayList splitPath = Repackager.splitPath(str2, File.separatorChar);
            String dirForPath = Repackager.dirForPath(str);
            while (true) {
                boolean z = false;
                for (int i2 = i; i2 < splitPath.size(); i2++) {
                    int i3 = i2 - 1;
                    String str3 = (String) splitPath.get(i3);
                    String str4 = (String) splitPath.get(i2);
                    if (str3.indexOf(58) < str4.indexOf(58)) {
                        splitPath.set(i3, str4);
                        splitPath.set(i2, str3);
                        z = true;
                    }
                }
                if (!z) {
                    break;
                } else {
                    i = 1;
                }
            }
            ArrayList splitPath2 = Repackager.splitPath(group, '.');
            int size = splitPath.size() - 2;
            if (size < 0 || splitPath.size() - 1 < splitPath2.size()) {
                throw new RuntimeException(new StringBuffer().append("Package spec differs from file path: ").append(str2).toString());
            }
            for (int size2 = splitPath2.size() - 1; size2 >= 0; size2--) {
                if (!splitPath2.get(size2).equals(splitPath.get(size))) {
                    throw new RuntimeException(new StringBuffer().append("Package spec differs from file path: ").append(str2).toString());
                }
                size--;
            }
            int i4 = 0;
            loop3: while (true) {
                list = null;
                if (i4 >= this._fromPackages.size()) {
                    list2 = null;
                    break;
                }
                List list3 = (List) this._fromPackages.get(i4);
                if (list3.size() <= splitPath2.size()) {
                    for (int i5 = 0; i5 < list3.size(); i5++) {
                        if (!list3.get(i5).equals(splitPath2.get(i5))) {
                            break;
                        }
                    }
                    list = (List) this._toPackages.get(i4);
                    list2 = list3;
                    break loop3;
                }
                i4++;
            }
            if (list != null) {
                String str5 = "";
                String str6 = "";
                for (int i6 = 0; i6 < list.size(); i6++) {
                    if (i6 > 0) {
                        str5 = new StringBuffer().append(str5).append(".").toString();
                        str6 = new StringBuffer().append(str6).append(File.separatorChar).toString();
                    }
                    str5 = new StringBuffer().append(str5).append(list.get(i6)).toString();
                    str6 = new StringBuffer().append(str6).append(list.get(i6)).toString();
                }
                for (int size3 = (splitPath.size() - splitPath2.size()) - 2; size3 >= 0; size3--) {
                    str6 = new StringBuffer().append((String) splitPath.get(size3)).append(File.separatorChar).append(str6).toString();
                }
                for (int size4 = list2.size(); size4 < splitPath2.size(); size4++) {
                    str6 = new StringBuffer().append(str6).append(File.separatorChar).append((String) splitPath2.get(size4)).toString();
                    str5 = new StringBuffer().append(str5).append('.').append((String) splitPath2.get(size4)).toString();
                }
                String stringBuffer = new StringBuffer().append(str6).append(File.separatorChar).append((String) splitPath.get(splitPath.size() - 1)).toString();
                readFile.replace(start, end, str5);
                String dirForPath2 = Repackager.dirForPath(stringBuffer);
                if (!dirForPath.equals(dirForPath2)) {
                    this._movedDirs.put(dirForPath, dirForPath2);
                }
                str2 = stringBuffer;
            }
        }
        if (file.lastModified() < new File(this._targetBase, str2).lastModified()) {
            this._skippedFiles++;
        } else {
            writeFile(new File(this._targetBase, str2), this._repackager.repackage(readFile));
        }
    }

    void writeFile(File file, StringBuffer stringBuffer) throws IOException {
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        StringReader stringReader = new StringReader(stringBuffer.toString());
        copy(stringReader, outputStreamWriter);
        stringReader.close();
        outputStreamWriter.close();
        fileOutputStream.close();
    }

    StringBuffer readFile(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        StringWriter stringWriter = new StringWriter();
        copy(inputStreamReader, stringWriter);
        stringWriter.close();
        inputStreamReader.close();
        fileInputStream.close();
        return stringWriter.getBuffer();
    }

    StringBuffer readInputStream(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        StringWriter stringWriter = new StringWriter();
        copy(inputStreamReader, stringWriter);
        stringWriter.close();
        inputStreamReader.close();
        return stringWriter.getBuffer();
    }

    public static void copyFile(File file, File file2) throws IOException {
        file2.getParentFile().mkdirs();
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        copy(fileInputStream, fileOutputStream);
        fileOutputStream.close();
        fileInputStream.close();
    }

    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[16384];
        while (true) {
            int read = inputStream.read(bArr, 0, 16384);
            if (read < 0) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    public static void copy(Reader reader, Writer writer) throws IOException {
        char[] cArr = new char[16384];
        while (true) {
            int read = reader.read(cArr, 0, 16384);
            if (read < 0) {
                return;
            } else {
                writer.write(cArr, 0, read);
            }
        }
    }

    public void fillFiles(ArrayList arrayList, File file) throws IOException {
        if (!file.isDirectory()) {
            arrayList.add(file);
            return;
        }
        if (file.getName().equals("build") || file.getName().equals("CVS")) {
            return;
        }
        for (String str : file.list()) {
            fillFiles(arrayList, new File(file, str));
        }
    }

    public void recursiveDelete(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                for (String str : file.list()) {
                    recursiveDelete(new File(file, str));
                }
            }
            file.delete();
        }
    }
}
