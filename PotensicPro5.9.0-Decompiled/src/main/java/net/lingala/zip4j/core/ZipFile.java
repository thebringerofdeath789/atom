package net.lingala.zip4j.core;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.unzip.Unzip;
import net.lingala.zip4j.util.ArchiveMaintainer;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Zip4jUtil;
import net.lingala.zip4j.zip.ZipEngine;

/* loaded from: classes4.dex */
public class ZipFile {
    private String file;
    private String fileNameCharset;
    private boolean isEncrypted;
    private int mode;
    private ProgressMonitor progressMonitor;
    private boolean runInThread;
    private ZipModel zipModel;

    public ZipFile(String str) throws ZipException {
        this(new File(str));
    }

    public ZipFile(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("Input zip file parameter is not null", 1);
        }
        this.file = file.getPath();
        this.mode = 2;
        this.progressMonitor = new ProgressMonitor();
        this.runInThread = false;
    }

    public void createZipFile(File file, ZipParameters zipParameters) throws ZipException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(file);
        createZipFile(arrayList, zipParameters, false, -1L);
    }

    public void createZipFile(File file, ZipParameters zipParameters, boolean z, long j) throws ZipException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(file);
        createZipFile(arrayList, zipParameters, z, j);
    }

    public void createZipFile(ArrayList arrayList, ZipParameters zipParameters) throws ZipException {
        createZipFile(arrayList, zipParameters, false, -1L);
    }

    public void createZipFile(ArrayList arrayList, ZipParameters zipParameters, boolean z, long j) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(this.file)) {
            throw new ZipException("zip file path is empty");
        }
        if (Zip4jUtil.checkFileExists(this.file)) {
            throw new ZipException("zip file: " + this.file + " already exists. To add files to existing zip file use addFile method");
        }
        if (arrayList == null) {
            throw new ZipException("input file ArrayList is null, cannot create zip file");
        }
        if (!Zip4jUtil.checkArrayListTypes(arrayList, 1)) {
            throw new ZipException("One or more elements in the input ArrayList is not of type File");
        }
        createNewZipModel();
        this.zipModel.setSplitArchive(z);
        this.zipModel.setSplitLength(j);
        addFiles(arrayList, zipParameters);
    }

    public void createZipFileFromFolder(String str, ZipParameters zipParameters, boolean z, long j) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("folderToAdd is empty or null, cannot create Zip File from folder");
        }
        createZipFileFromFolder(new File(str), zipParameters, z, j);
    }

    public void createZipFileFromFolder(File file, ZipParameters zipParameters, boolean z, long j) throws ZipException {
        if (file == null) {
            throw new ZipException("folderToAdd is null, cannot create zip file from folder");
        }
        if (zipParameters == null) {
            throw new ZipException("input parameters are null, cannot create zip file from folder");
        }
        if (Zip4jUtil.checkFileExists(this.file)) {
            throw new ZipException("zip file: " + this.file + " already exists. To add files to existing zip file use addFolder method");
        }
        createNewZipModel();
        this.zipModel.setSplitArchive(z);
        if (z) {
            this.zipModel.setSplitLength(j);
        }
        addFolder(file, zipParameters, false);
    }

    public void addFile(File file, ZipParameters zipParameters) throws ZipException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(file);
        addFiles(arrayList, zipParameters);
    }

    public void addFiles(ArrayList arrayList, ZipParameters zipParameters) throws ZipException {
        checkZipModel();
        if (this.zipModel == null) {
            throw new ZipException("internal error: zip model is null");
        }
        if (arrayList == null) {
            throw new ZipException("input file ArrayList is null, cannot add files");
        }
        if (!Zip4jUtil.checkArrayListTypes(arrayList, 1)) {
            throw new ZipException("One or more elements in the input ArrayList is not of type File");
        }
        if (zipParameters == null) {
            throw new ZipException("input parameters are null, cannot add files to zip");
        }
        if (this.progressMonitor.getState() == 1) {
            throw new ZipException("invalid operation - Zip4j is in busy state");
        }
        if (Zip4jUtil.checkFileExists(this.file) && this.zipModel.isSplitArchive()) {
            throw new ZipException("Zip file already exists. Zip file format does not allow updating split/spanned files");
        }
        new ZipEngine(this.zipModel).addFiles(arrayList, zipParameters, this.progressMonitor, this.runInThread);
    }

    public void addFolder(String str, ZipParameters zipParameters) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("input path is null or empty, cannot add folder to zip file");
        }
        addFolder(new File(str), zipParameters);
    }

    public void addFolder(File file, ZipParameters zipParameters) throws ZipException {
        if (file == null) {
            throw new ZipException("input path is null, cannot add folder to zip file");
        }
        if (zipParameters == null) {
            throw new ZipException("input parameters are null, cannot add folder to zip file");
        }
        addFolder(file, zipParameters, true);
    }

    private void addFolder(File file, ZipParameters zipParameters, boolean z) throws ZipException {
        checkZipModel();
        ZipModel zipModel = this.zipModel;
        if (zipModel == null) {
            throw new ZipException("internal error: zip model is null");
        }
        if (z && zipModel.isSplitArchive()) {
            throw new ZipException("This is a split archive. Zip file format does not allow updating split/spanned files");
        }
        new ZipEngine(this.zipModel).addFolderToZip(file, zipParameters, this.progressMonitor, this.runInThread);
    }

    public void addStream(InputStream inputStream, ZipParameters zipParameters) throws ZipException {
        if (inputStream == null) {
            throw new ZipException("inputstream is null, cannot add file to zip");
        }
        if (zipParameters == null) {
            throw new ZipException("zip parameters are null");
        }
        setRunInThread(false);
        checkZipModel();
        if (this.zipModel == null) {
            throw new ZipException("internal error: zip model is null");
        }
        if (Zip4jUtil.checkFileExists(this.file) && this.zipModel.isSplitArchive()) {
            throw new ZipException("Zip file already exists. Zip file format does not allow updating split/spanned files");
        }
        new ZipEngine(this.zipModel).addStreamToZip(inputStream, zipParameters);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void readZipInfo() throws net.lingala.zip4j.exception.ZipException {
        /*
            r5 = this;
            java.lang.String r0 = r5.file
            boolean r0 = net.lingala.zip4j.util.Zip4jUtil.checkFileExists(r0)
            if (r0 == 0) goto L68
            java.lang.String r0 = r5.file
            boolean r0 = net.lingala.zip4j.util.Zip4jUtil.checkFileReadAccess(r0)
            if (r0 == 0) goto L60
            int r0 = r5.mode
            r1 = 2
            if (r0 != r1) goto L58
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L42 java.io.FileNotFoundException -> L47
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L42 java.io.FileNotFoundException -> L47
            java.lang.String r3 = r5.file     // Catch: java.lang.Throwable -> L42 java.io.FileNotFoundException -> L47
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L42 java.io.FileNotFoundException -> L47
            java.lang.String r3 = "r"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L42 java.io.FileNotFoundException -> L47
            net.lingala.zip4j.model.ZipModel r0 = r5.zipModel     // Catch: java.io.FileNotFoundException -> L40 java.lang.Throwable -> L51
            if (r0 != 0) goto L3c
            net.lingala.zip4j.core.HeaderReader r0 = new net.lingala.zip4j.core.HeaderReader     // Catch: java.io.FileNotFoundException -> L40 java.lang.Throwable -> L51
            r0.<init>(r1)     // Catch: java.io.FileNotFoundException -> L40 java.lang.Throwable -> L51
            java.lang.String r2 = r5.fileNameCharset     // Catch: java.io.FileNotFoundException -> L40 java.lang.Throwable -> L51
            net.lingala.zip4j.model.ZipModel r0 = r0.readAllHeaders(r2)     // Catch: java.io.FileNotFoundException -> L40 java.lang.Throwable -> L51
            r5.zipModel = r0     // Catch: java.io.FileNotFoundException -> L40 java.lang.Throwable -> L51
            if (r0 == 0) goto L3c
            java.lang.String r2 = r5.file     // Catch: java.io.FileNotFoundException -> L40 java.lang.Throwable -> L51
            r0.setZipFile(r2)     // Catch: java.io.FileNotFoundException -> L40 java.lang.Throwable -> L51
        L3c:
            r1.close()     // Catch: java.io.IOException -> L3f
        L3f:
            return
        L40:
            r0 = move-exception
            goto L4b
        L42:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L52
        L47:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L4b:
            net.lingala.zip4j.exception.ZipException r2 = new net.lingala.zip4j.exception.ZipException     // Catch: java.lang.Throwable -> L51
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L51
            throw r2     // Catch: java.lang.Throwable -> L51
        L51:
            r0 = move-exception
        L52:
            if (r1 == 0) goto L57
            r1.close()     // Catch: java.io.IOException -> L57
        L57:
            throw r0
        L58:
            net.lingala.zip4j.exception.ZipException r0 = new net.lingala.zip4j.exception.ZipException
            java.lang.String r1 = "Invalid mode"
            r0.<init>(r1)
            throw r0
        L60:
            net.lingala.zip4j.exception.ZipException r0 = new net.lingala.zip4j.exception.ZipException
            java.lang.String r1 = "no read access for the input zip file"
            r0.<init>(r1)
            throw r0
        L68:
            net.lingala.zip4j.exception.ZipException r0 = new net.lingala.zip4j.exception.ZipException
            java.lang.String r1 = "zip file does not exist"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.lingala.zip4j.core.ZipFile.readZipInfo():void");
    }

    public void extractAll(String str) throws ZipException {
        extractAll(str, null);
    }

    public void extractAll(String str, UnzipParameters unzipParameters) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("output path is null or invalid");
        }
        if (!Zip4jUtil.checkOutputFolder(str)) {
            throw new ZipException("invalid output path");
        }
        if (this.zipModel == null) {
            readZipInfo();
        }
        if (this.zipModel == null) {
            throw new ZipException("Internal error occurred when extracting zip file");
        }
        if (this.progressMonitor.getState() == 1) {
            throw new ZipException("invalid operation - Zip4j is in busy state");
        }
        new Unzip(this.zipModel).extractAll(unzipParameters, str, this.progressMonitor, this.runInThread);
    }

    public void extractFile(FileHeader fileHeader, String str) throws ZipException {
        extractFile(fileHeader, str, (UnzipParameters) null);
    }

    public void extractFile(FileHeader fileHeader, String str, UnzipParameters unzipParameters) throws ZipException {
        extractFile(fileHeader, str, unzipParameters, (String) null);
    }

    public void extractFile(FileHeader fileHeader, String str, UnzipParameters unzipParameters, String str2) throws ZipException {
        if (fileHeader == null) {
            throw new ZipException("input file header is null, cannot extract file");
        }
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("destination path is empty or null, cannot extract file");
        }
        readZipInfo();
        if (this.progressMonitor.getState() == 1) {
            throw new ZipException("invalid operation - Zip4j is in busy state");
        }
        fileHeader.extractFile(this.zipModel, str, unzipParameters, str2, this.progressMonitor, this.runInThread);
    }

    public void extractFile(String str, String str2) throws ZipException {
        extractFile(str, str2, (UnzipParameters) null);
    }

    public void extractFile(String str, String str2, UnzipParameters unzipParameters) throws ZipException {
        extractFile(str, str2, unzipParameters, (String) null);
    }

    public void extractFile(String str, String str2, UnzipParameters unzipParameters, String str3) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("file to extract is null or empty, cannot extract file");
        }
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            throw new ZipException("destination string path is empty or null, cannot extract file");
        }
        readZipInfo();
        FileHeader fileHeader = Zip4jUtil.getFileHeader(this.zipModel, str);
        if (fileHeader == null) {
            throw new ZipException("file header not found for given file name, cannot extract file");
        }
        if (this.progressMonitor.getState() == 1) {
            throw new ZipException("invalid operation - Zip4j is in busy state");
        }
        fileHeader.extractFile(this.zipModel, str2, unzipParameters, str3, this.progressMonitor, this.runInThread);
    }

    public void setPassword(String str) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw null;
        }
        setPassword(str.toCharArray());
    }

    public void setPassword(char[] cArr) throws ZipException {
        if (this.zipModel == null) {
            readZipInfo();
            if (this.zipModel == null) {
                throw new ZipException("Zip Model is null");
            }
        }
        if (this.zipModel.getCentralDirectory() == null || this.zipModel.getCentralDirectory().getFileHeaders() == null) {
            throw new ZipException("invalid zip file");
        }
        for (int i = 0; i < this.zipModel.getCentralDirectory().getFileHeaders().size(); i++) {
            if (this.zipModel.getCentralDirectory().getFileHeaders().get(i) != null && ((FileHeader) this.zipModel.getCentralDirectory().getFileHeaders().get(i)).isEncrypted()) {
                ((FileHeader) this.zipModel.getCentralDirectory().getFileHeaders().get(i)).setPassword(cArr);
            }
        }
    }

    public List getFileHeaders() throws ZipException {
        readZipInfo();
        ZipModel zipModel = this.zipModel;
        if (zipModel == null || zipModel.getCentralDirectory() == null) {
            return null;
        }
        return this.zipModel.getCentralDirectory().getFileHeaders();
    }

    public FileHeader getFileHeader(String str) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("input file name is emtpy or null, cannot get FileHeader");
        }
        readZipInfo();
        ZipModel zipModel = this.zipModel;
        if (zipModel == null || zipModel.getCentralDirectory() == null) {
            return null;
        }
        return Zip4jUtil.getFileHeader(this.zipModel, str);
    }

    public boolean isEncrypted() throws ZipException {
        if (this.zipModel == null) {
            readZipInfo();
            if (this.zipModel == null) {
                throw new ZipException("Zip Model is null");
            }
        }
        if (this.zipModel.getCentralDirectory() == null || this.zipModel.getCentralDirectory().getFileHeaders() == null) {
            throw new ZipException("invalid zip file");
        }
        ArrayList fileHeaders = this.zipModel.getCentralDirectory().getFileHeaders();
        int i = 0;
        while (true) {
            if (i < fileHeaders.size()) {
                FileHeader fileHeader = (FileHeader) fileHeaders.get(i);
                if (fileHeader != null && fileHeader.isEncrypted()) {
                    this.isEncrypted = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return this.isEncrypted;
    }

    public boolean isSplitArchive() throws ZipException {
        if (this.zipModel == null) {
            readZipInfo();
            if (this.zipModel == null) {
                throw new ZipException("Zip Model is null");
            }
        }
        return this.zipModel.isSplitArchive();
    }

    public void removeFile(String str) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("file name is empty or null, cannot remove file");
        }
        if (this.zipModel == null && Zip4jUtil.checkFileExists(this.file)) {
            readZipInfo();
        }
        if (this.zipModel.isSplitArchive()) {
            throw new ZipException("Zip file format does not allow updating split/spanned files");
        }
        FileHeader fileHeader = Zip4jUtil.getFileHeader(this.zipModel, str);
        if (fileHeader == null) {
            throw new ZipException("could not find file header for file: " + str);
        }
        removeFile(fileHeader);
    }

    public void removeFile(FileHeader fileHeader) throws ZipException {
        if (fileHeader == null) {
            throw new ZipException("file header is null, cannot remove file");
        }
        if (this.zipModel == null && Zip4jUtil.checkFileExists(this.file)) {
            readZipInfo();
        }
        if (this.zipModel.isSplitArchive()) {
            throw new ZipException("Zip file format does not allow updating split/spanned files");
        }
        ArchiveMaintainer archiveMaintainer = new ArchiveMaintainer();
        archiveMaintainer.initProgressMonitorForRemoveOp(this.zipModel, fileHeader, this.progressMonitor);
        archiveMaintainer.removeZipFile(this.zipModel, fileHeader, this.progressMonitor, this.runInThread);
    }

    public void mergeSplitFiles(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("outputZipFile is null, cannot merge split files");
        }
        if (file.exists()) {
            throw new ZipException("output Zip File already exists");
        }
        checkZipModel();
        if (this.zipModel == null) {
            throw new ZipException("zip model is null, corrupt zip file?");
        }
        ArchiveMaintainer archiveMaintainer = new ArchiveMaintainer();
        archiveMaintainer.initProgressMonitorForMergeOp(this.zipModel, this.progressMonitor);
        archiveMaintainer.mergeSplitZipFiles(this.zipModel, file, this.progressMonitor, this.runInThread);
    }

    public void setComment(String str) throws ZipException {
        if (str == null) {
            throw new ZipException("input comment is null, cannot update zip file");
        }
        if (!Zip4jUtil.checkFileExists(this.file)) {
            throw new ZipException("zip file does not exist, cannot set comment for zip file");
        }
        readZipInfo();
        ZipModel zipModel = this.zipModel;
        if (zipModel == null) {
            throw new ZipException("zipModel is null, cannot update zip file");
        }
        if (zipModel.getEndCentralDirRecord() == null) {
            throw new ZipException("end of central directory is null, cannot set comment");
        }
        new ArchiveMaintainer().setComment(this.zipModel, str);
    }

    public String getComment() throws ZipException {
        return getComment(null);
    }

    public String getComment(String str) throws ZipException {
        if (str == null) {
            str = Zip4jUtil.isSupportedCharset(InternalZipConstants.CHARSET_COMMENTS_DEFAULT) ? InternalZipConstants.CHARSET_COMMENTS_DEFAULT : InternalZipConstants.CHARSET_DEFAULT;
        }
        if (Zip4jUtil.checkFileExists(this.file)) {
            checkZipModel();
            ZipModel zipModel = this.zipModel;
            if (zipModel == null) {
                throw new ZipException("zip model is null, cannot read comment");
            }
            if (zipModel.getEndCentralDirRecord() == null) {
                throw new ZipException("end of central directory record is null, cannot read comment");
            }
            if (this.zipModel.getEndCentralDirRecord().getCommentBytes() == null || this.zipModel.getEndCentralDirRecord().getCommentBytes().length <= 0) {
                return null;
            }
            try {
                return new String(this.zipModel.getEndCentralDirRecord().getCommentBytes(), str);
            } catch (UnsupportedEncodingException e) {
                throw new ZipException(e);
            }
        }
        throw new ZipException("zip file does not exist, cannot read comment");
    }

    private void checkZipModel() throws ZipException {
        if (this.zipModel == null) {
            if (Zip4jUtil.checkFileExists(this.file)) {
                readZipInfo();
            } else {
                createNewZipModel();
            }
        }
    }

    private void createNewZipModel() {
        ZipModel zipModel = new ZipModel();
        this.zipModel = zipModel;
        zipModel.setZipFile(this.file);
        this.zipModel.setFileNameCharset(this.fileNameCharset);
    }

    public void setFileNameCharset(String str) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("null or empty charset name");
        }
        if (!Zip4jUtil.isSupportedCharset(str)) {
            throw new ZipException("unsupported charset: " + str);
        }
        this.fileNameCharset = str;
    }

    public ZipInputStream getInputStream(FileHeader fileHeader) throws ZipException {
        if (fileHeader == null) {
            throw new ZipException("FileHeader is null, cannot get InputStream");
        }
        checkZipModel();
        if (this.zipModel == null) {
            throw new ZipException("zip model is null, cannot get inputstream");
        }
        return new Unzip(this.zipModel).getInputStream(fileHeader);
    }

    public boolean isValidZipFile() {
        try {
            readZipInfo();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public ArrayList getSplitZipFiles() throws ZipException {
        checkZipModel();
        return Zip4jUtil.getSplitZipFiles(this.zipModel);
    }

    public ProgressMonitor getProgressMonitor() {
        return this.progressMonitor;
    }

    public boolean isRunInThread() {
        return this.runInThread;
    }

    public void setRunInThread(boolean z) {
        this.runInThread = z;
    }

    public File getFile() {
        return new File(this.file);
    }
}
