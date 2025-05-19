package net.lingala.zip4j.unzip;

import java.io.File;
import java.util.ArrayList;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.ZipInputStream;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Zip4jUtil;

/* loaded from: classes4.dex */
public class Unzip {
    private ZipModel zipModel;

    public Unzip(ZipModel zipModel) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("ZipModel is null");
        }
        this.zipModel = zipModel;
    }

    public void extractAll(final UnzipParameters unzipParameters, final String str, final ProgressMonitor progressMonitor, boolean z) throws ZipException {
        CentralDirectory centralDirectory = this.zipModel.getCentralDirectory();
        if (centralDirectory == null || centralDirectory.getFileHeaders() == null) {
            throw new ZipException("invalid central directory in zipModel");
        }
        final ArrayList fileHeaders = centralDirectory.getFileHeaders();
        progressMonitor.setCurrentOperation(1);
        progressMonitor.setTotalWork(calculateTotalWork(fileHeaders));
        progressMonitor.setState(1);
        if (z) {
            new Thread(InternalZipConstants.THREAD_NAME) { // from class: net.lingala.zip4j.unzip.Unzip.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        Unzip.this.initExtractAll(fileHeaders, unzipParameters, progressMonitor, str);
                        progressMonitor.endProgressMonitorSuccess();
                    } catch (ZipException unused) {
                    }
                }
            }.start();
        } else {
            initExtractAll(fileHeaders, unzipParameters, progressMonitor, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initExtractAll(ArrayList arrayList, UnzipParameters unzipParameters, ProgressMonitor progressMonitor, String str) throws ZipException {
        for (int i = 0; i < arrayList.size(); i++) {
            initExtractFile((FileHeader) arrayList.get(i), str, unzipParameters, null, progressMonitor);
            if (progressMonitor.isCancelAllTasks()) {
                progressMonitor.setResult(3);
                progressMonitor.setState(0);
                return;
            }
        }
    }

    public void extractFile(final FileHeader fileHeader, final String str, final UnzipParameters unzipParameters, final String str2, final ProgressMonitor progressMonitor, boolean z) throws ZipException {
        if (fileHeader == null) {
            throw new ZipException("fileHeader is null");
        }
        progressMonitor.setCurrentOperation(1);
        progressMonitor.setTotalWork(fileHeader.getCompressedSize());
        progressMonitor.setState(1);
        progressMonitor.setPercentDone(0);
        progressMonitor.setFileName(fileHeader.getFileName());
        if (z) {
            new Thread(InternalZipConstants.THREAD_NAME) { // from class: net.lingala.zip4j.unzip.Unzip.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        Unzip.this.initExtractFile(fileHeader, str, unzipParameters, str2, progressMonitor);
                        progressMonitor.endProgressMonitorSuccess();
                    } catch (ZipException unused) {
                    }
                }
            }.start();
        } else {
            initExtractFile(fileHeader, str, unzipParameters, str2, progressMonitor);
            progressMonitor.endProgressMonitorSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initExtractFile(FileHeader fileHeader, String str, UnzipParameters unzipParameters, String str2, ProgressMonitor progressMonitor) throws ZipException {
        if (fileHeader == null) {
            throw new ZipException("fileHeader is null");
        }
        try {
            try {
                progressMonitor.setFileName(fileHeader.getFileName());
                if (!str.endsWith(InternalZipConstants.FILE_SEPARATOR)) {
                    str = str + InternalZipConstants.FILE_SEPARATOR;
                }
                if (fileHeader.isDirectory()) {
                    try {
                        String fileName = fileHeader.getFileName();
                        if (Zip4jUtil.isStringNotNullAndNotEmpty(fileName)) {
                            File file = new File(str + fileName);
                            if (file.exists()) {
                                return;
                            }
                            file.mkdirs();
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        progressMonitor.endProgressMonitorError(e);
                        throw new ZipException(e);
                    }
                }
                checkOutputDirectoryStructure(fileHeader, str, str2);
                try {
                    new UnzipEngine(this.zipModel, fileHeader).unzipFile(progressMonitor, str, str2, unzipParameters);
                } catch (Exception e2) {
                    progressMonitor.endProgressMonitorError(e2);
                    throw new ZipException(e2);
                }
            } catch (Exception e3) {
                progressMonitor.endProgressMonitorError(e3);
                throw new ZipException(e3);
            }
        } catch (ZipException e4) {
            progressMonitor.endProgressMonitorError(e4);
            throw e4;
        }
    }

    public ZipInputStream getInputStream(FileHeader fileHeader) throws ZipException {
        return new UnzipEngine(this.zipModel, fileHeader).getInputStream();
    }

    private void checkOutputDirectoryStructure(FileHeader fileHeader, String str, String str2) throws ZipException {
        if (fileHeader == null || !Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("Cannot check output directory structure...one of the parameters was null");
        }
        String fileName = fileHeader.getFileName();
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            str2 = fileName;
        }
        if (Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            try {
                File file = new File(new File(str + str2).getParent());
                if (file.exists()) {
                    return;
                }
                file.mkdirs();
            } catch (Exception e) {
                throw new ZipException(e);
            }
        }
    }

    private long calculateTotalWork(ArrayList arrayList) throws ZipException {
        long compressedSize;
        if (arrayList == null) {
            throw new ZipException("fileHeaders is null, cannot calculate total work");
        }
        long j = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            FileHeader fileHeader = (FileHeader) arrayList.get(i);
            if (fileHeader.getZip64ExtendedInfo() != null && fileHeader.getZip64ExtendedInfo().getUnCompressedSize() > 0) {
                compressedSize = fileHeader.getZip64ExtendedInfo().getCompressedSize();
            } else {
                compressedSize = fileHeader.getCompressedSize();
            }
            j += compressedSize;
        }
        return j;
    }
}
