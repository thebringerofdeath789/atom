package net.lingala.zip4j.zip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.SplitOutputStream;
import net.lingala.zip4j.io.ZipOutputStream;
import net.lingala.zip4j.model.EndCentralDirRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.util.ArchiveMaintainer;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Zip4jUtil;

/* loaded from: classes4.dex */
public class ZipEngine {
    private ZipModel zipModel;

    public ZipEngine(ZipModel zipModel) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("zip model is null in ZipEngine constructor");
        }
        this.zipModel = zipModel;
    }

    public void addFiles(final ArrayList arrayList, final ZipParameters zipParameters, final ProgressMonitor progressMonitor, boolean z) throws ZipException {
        if (arrayList == null || zipParameters == null) {
            throw new ZipException("one of the input parameters is null when adding files");
        }
        if (arrayList.size() <= 0) {
            throw new ZipException("no files to add");
        }
        progressMonitor.setCurrentOperation(0);
        progressMonitor.setState(1);
        progressMonitor.setResult(1);
        if (z) {
            progressMonitor.setTotalWork(calculateTotalWork(arrayList, zipParameters));
            progressMonitor.setFileName(((File) arrayList.get(0)).getAbsolutePath());
            new Thread(InternalZipConstants.THREAD_NAME) { // from class: net.lingala.zip4j.zip.ZipEngine.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        ZipEngine.this.initAddFiles(arrayList, zipParameters, progressMonitor);
                    } catch (ZipException unused) {
                    }
                }
            }.start();
            return;
        }
        initAddFiles(arrayList, zipParameters, progressMonitor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0127, code lost:
    
        r14.setResult(3);
        r14.setState(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x012d, code lost:
    
        r5.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0184 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x017f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void initAddFiles(java.util.ArrayList r12, net.lingala.zip4j.model.ZipParameters r13, net.lingala.zip4j.progress.ProgressMonitor r14) throws net.lingala.zip4j.exception.ZipException {
        /*
            Method dump skipped, instructions count: 408
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: net.lingala.zip4j.zip.ZipEngine.initAddFiles(java.util.ArrayList, net.lingala.zip4j.model.ZipParameters, net.lingala.zip4j.progress.ProgressMonitor):void");
    }

    public void addStreamToZip(InputStream inputStream, ZipParameters zipParameters) throws ZipException {
        if (inputStream == null || zipParameters == null) {
            throw new ZipException("one of the input parameters is null, cannot add stream to zip");
        }
        ZipOutputStream zipOutputStream = null;
        try {
            try {
                checkParameters(zipParameters);
                boolean checkFileExists = Zip4jUtil.checkFileExists(this.zipModel.getZipFile());
                SplitOutputStream splitOutputStream = new SplitOutputStream(new File(this.zipModel.getZipFile()), this.zipModel.getSplitLength());
                ZipOutputStream zipOutputStream2 = new ZipOutputStream(splitOutputStream, this.zipModel);
                if (checkFileExists) {
                    try {
                        if (this.zipModel.getEndCentralDirRecord() == null) {
                            throw new ZipException("invalid end of central directory record");
                        }
                        splitOutputStream.seek(this.zipModel.getEndCentralDirRecord().getOffsetOfStartOfCentralDir());
                    } catch (ZipException e) {
                        throw e;
                    } catch (Exception e2) {
                        e = e2;
                        throw new ZipException(e);
                    } catch (Throwable th) {
                        th = th;
                        zipOutputStream = zipOutputStream2;
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                }
                byte[] bArr = new byte[4096];
                zipOutputStream2.putNextEntry(null, zipParameters);
                if (!zipParameters.getFileNameInZip().endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR) && !zipParameters.getFileNameInZip().endsWith("\\")) {
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            zipOutputStream2.write(bArr, 0, read);
                        }
                    }
                }
                zipOutputStream2.closeEntry();
                zipOutputStream2.finish();
                try {
                    zipOutputStream2.close();
                } catch (IOException unused2) {
                }
            } catch (ZipException e3) {
                throw e3;
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void addFolderToZip(File file, ZipParameters zipParameters, ProgressMonitor progressMonitor, boolean z) throws ZipException {
        String absolutePath;
        if (file == null || zipParameters == null) {
            throw new ZipException("one of the input parameters is null, cannot add folder to zip");
        }
        if (!Zip4jUtil.checkFileExists(file.getAbsolutePath())) {
            throw new ZipException("input folder does not exist");
        }
        if (!file.isDirectory()) {
            throw new ZipException("input file is not a folder, user addFileToZip method to add files");
        }
        if (!Zip4jUtil.checkFileReadAccess(file.getAbsolutePath())) {
            throw new ZipException("cannot read folder: " + file.getAbsolutePath());
        }
        if (zipParameters.isIncludeRootFolder()) {
            absolutePath = "";
            if (file.getAbsolutePath() != null) {
                if (file.getAbsoluteFile().getParentFile() != null) {
                    absolutePath = file.getAbsoluteFile().getParentFile().getAbsolutePath();
                }
            } else if (file.getParentFile() != null) {
                absolutePath = file.getParentFile().getAbsolutePath();
            }
        } else {
            absolutePath = file.getAbsolutePath();
        }
        zipParameters.setDefaultFolderPath(absolutePath);
        ArrayList filesInDirectoryRec = Zip4jUtil.getFilesInDirectoryRec(file, zipParameters.isReadHiddenFiles());
        if (zipParameters.isIncludeRootFolder()) {
            if (filesInDirectoryRec == null) {
                filesInDirectoryRec = new ArrayList();
            }
            filesInDirectoryRec.add(file);
        }
        addFiles(filesInDirectoryRec, zipParameters, progressMonitor, z);
    }

    private void checkParameters(ZipParameters zipParameters) throws ZipException {
        if (zipParameters == null) {
            throw new ZipException("cannot validate zip parameters");
        }
        if (zipParameters.getCompressionMethod() != 0 && zipParameters.getCompressionMethod() != 8) {
            throw new ZipException("unsupported compression type");
        }
        if (zipParameters.getCompressionMethod() == 8 && zipParameters.getCompressionLevel() < 0 && zipParameters.getCompressionLevel() > 9) {
            throw new ZipException("invalid compression level. compression level dor deflate should be in the range of 0-9");
        }
        if (zipParameters.isEncryptFiles()) {
            if (zipParameters.getEncryptionMethod() != 0 && zipParameters.getEncryptionMethod() != 99) {
                throw new ZipException("unsupported encryption method");
            }
            if (zipParameters.getPassword() == null || zipParameters.getPassword().length <= 0) {
                throw new ZipException("input password is empty or null");
            }
            return;
        }
        zipParameters.setAesKeyStrength(-1);
        zipParameters.setEncryptionMethod(-1);
    }

    private void removeFilesIfExists(ArrayList arrayList, ZipParameters zipParameters, ProgressMonitor progressMonitor) throws ZipException {
        ZipModel zipModel = this.zipModel;
        if (zipModel == null || zipModel.getCentralDirectory() == null || this.zipModel.getCentralDirectory().getFileHeaders() == null || this.zipModel.getCentralDirectory().getFileHeaders().size() <= 0) {
            return;
        }
        RandomAccessFile randomAccessFile = null;
        for (int i = 0; i < arrayList.size(); i++) {
            try {
                try {
                    FileHeader fileHeader = Zip4jUtil.getFileHeader(this.zipModel, Zip4jUtil.getRelativeFileName(((File) arrayList.get(i)).getAbsolutePath(), zipParameters.getRootFolderInZip(), zipParameters.getDefaultFolderPath()));
                    if (fileHeader != null) {
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                            randomAccessFile = null;
                        }
                        ArchiveMaintainer archiveMaintainer = new ArchiveMaintainer();
                        progressMonitor.setCurrentOperation(2);
                        HashMap initRemoveZipFile = archiveMaintainer.initRemoveZipFile(this.zipModel, fileHeader, progressMonitor);
                        if (progressMonitor.isCancelAllTasks()) {
                            progressMonitor.setResult(3);
                            progressMonitor.setState(0);
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                    return;
                                } catch (IOException unused) {
                                    return;
                                }
                            }
                            return;
                        }
                        progressMonitor.setCurrentOperation(0);
                        if (randomAccessFile == null) {
                            randomAccessFile = prepareFileOutputStream();
                            if (initRemoveZipFile != null && initRemoveZipFile.get(InternalZipConstants.OFFSET_CENTRAL_DIR) != null) {
                                try {
                                    long parseLong = Long.parseLong((String) initRemoveZipFile.get(InternalZipConstants.OFFSET_CENTRAL_DIR));
                                    if (parseLong >= 0) {
                                        randomAccessFile.seek(parseLong);
                                    }
                                } catch (NumberFormatException unused2) {
                                    throw new ZipException("NumberFormatException while parsing offset central directory. Cannot update already existing file header");
                                } catch (Exception unused3) {
                                    throw new ZipException("Error while parsing offset central directory. Cannot update already existing file header");
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                } catch (IOException e) {
                    throw new ZipException(e);
                }
            } catch (Throwable th) {
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException unused5) {
            }
        }
    }

    private RandomAccessFile prepareFileOutputStream() throws ZipException {
        String zipFile = this.zipModel.getZipFile();
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(zipFile)) {
            throw new ZipException("invalid output path");
        }
        try {
            File file = new File(zipFile);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            return new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
        } catch (FileNotFoundException e) {
            throw new ZipException(e);
        }
    }

    private EndCentralDirRecord createEndOfCentralDirectoryRecord() {
        EndCentralDirRecord endCentralDirRecord = new EndCentralDirRecord();
        endCentralDirRecord.setSignature(InternalZipConstants.ENDSIG);
        endCentralDirRecord.setNoOfThisDisk(0);
        endCentralDirRecord.setTotNoOfEntriesInCentralDir(0);
        endCentralDirRecord.setTotNoOfEntriesInCentralDirOnThisDisk(0);
        endCentralDirRecord.setOffsetOfStartOfCentralDir(0L);
        return endCentralDirRecord;
    }

    private long calculateTotalWork(ArrayList arrayList, ZipParameters zipParameters) throws ZipException {
        long fileLengh;
        if (arrayList == null) {
            throw new ZipException("file list is null, cannot calculate total work");
        }
        long j = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if ((arrayList.get(i) instanceof File) && ((File) arrayList.get(i)).exists()) {
                if (zipParameters.isEncryptFiles() && zipParameters.getEncryptionMethod() == 0) {
                    fileLengh = Zip4jUtil.getFileLengh((File) arrayList.get(i)) * 2;
                } else {
                    fileLengh = Zip4jUtil.getFileLengh((File) arrayList.get(i));
                }
                j += fileLengh;
                if (this.zipModel.getCentralDirectory() != null && this.zipModel.getCentralDirectory().getFileHeaders() != null && this.zipModel.getCentralDirectory().getFileHeaders().size() > 0) {
                    FileHeader fileHeader = Zip4jUtil.getFileHeader(this.zipModel, Zip4jUtil.getRelativeFileName(((File) arrayList.get(i)).getAbsolutePath(), zipParameters.getRootFolderInZip(), zipParameters.getDefaultFolderPath()));
                    if (fileHeader != null) {
                        j += Zip4jUtil.getFileLengh(new File(this.zipModel.getZipFile())) - fileHeader.getCompressedSize();
                    }
                }
            }
        }
        return j;
    }
}
