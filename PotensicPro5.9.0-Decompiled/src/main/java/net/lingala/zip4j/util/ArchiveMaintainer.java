package net.lingala.zip4j.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import net.lingala.zip4j.core.HeaderWriter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.SplitOutputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;

/* loaded from: classes4.dex */
public class ArchiveMaintainer {
    public HashMap removeZipFile(final ZipModel zipModel, final FileHeader fileHeader, final ProgressMonitor progressMonitor, boolean z) throws ZipException {
        if (z) {
            new Thread(InternalZipConstants.THREAD_NAME) { // from class: net.lingala.zip4j.util.ArchiveMaintainer.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        ArchiveMaintainer.this.initRemoveZipFile(zipModel, fileHeader, progressMonitor);
                        progressMonitor.endProgressMonitorSuccess();
                    } catch (ZipException unused) {
                    }
                }
            }.start();
            return null;
        }
        HashMap initRemoveZipFile = initRemoveZipFile(zipModel, fileHeader, progressMonitor);
        progressMonitor.endProgressMonitorSuccess();
        return initRemoveZipFile;
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:96)
        */
    public java.util.HashMap initRemoveZipFile(net.lingala.zip4j.model.ZipModel r33, net.lingala.zip4j.model.FileHeader r34, net.lingala.zip4j.progress.ProgressMonitor r35) throws net.lingala.zip4j.exception.ZipException {
        /*
            Method dump skipped, instructions count: 1133
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: net.lingala.zip4j.util.ArchiveMaintainer.initRemoveZipFile(net.lingala.zip4j.model.ZipModel, net.lingala.zip4j.model.FileHeader, net.lingala.zip4j.progress.ProgressMonitor):java.util.HashMap");
    }

    private void restoreFileName(File file, String str) throws ZipException {
        if (file.delete()) {
            if (!new File(str).renameTo(file)) {
                throw new ZipException("cannot rename modified zip file");
            }
            return;
        }
        throw new ZipException("cannot delete old zip file");
    }

    private void copyFile(RandomAccessFile randomAccessFile, OutputStream outputStream, long j, long j2, ProgressMonitor progressMonitor) throws ZipException {
        if (randomAccessFile == null || outputStream == null) {
            throw new ZipException("input or output stream is null, cannot copy file");
        }
        long j3 = 0;
        if (j < 0) {
            throw new ZipException("starting offset is negative, cannot copy file");
        }
        if (j2 < 0) {
            throw new ZipException("end offset is negative, cannot copy file");
        }
        if (j > j2) {
            throw new ZipException("start offset is greater than end offset, cannot copy file");
        }
        if (j == j2) {
            return;
        }
        if (progressMonitor.isCancelAllTasks()) {
            progressMonitor.setResult(3);
            progressMonitor.setState(0);
            return;
        }
        try {
            randomAccessFile.seek(j);
            long j4 = j2 - j;
            byte[] bArr = j4 < 4096 ? new byte[(int) j4] : new byte[4096];
            while (true) {
                int read = randomAccessFile.read(bArr);
                if (read == -1) {
                    return;
                }
                outputStream.write(bArr, 0, read);
                long j5 = read;
                progressMonitor.updateWorkCompleted(j5);
                if (progressMonitor.isCancelAllTasks()) {
                    progressMonitor.setResult(3);
                    return;
                }
                j3 += j5;
                if (j3 == j4) {
                    return;
                }
                if (bArr.length + j3 > j4) {
                    bArr = new byte[(int) (j4 - j3)];
                }
            }
        } catch (IOException e) {
            throw new ZipException(e);
        } catch (Exception e2) {
            throw new ZipException(e2);
        }
    }

    private RandomAccessFile createFileHandler(ZipModel zipModel, String str) throws ZipException {
        if (zipModel == null || !Zip4jUtil.isStringNotNullAndNotEmpty(zipModel.getZipFile())) {
            throw new ZipException("input parameter is null in getFilePointer, cannot create file handler to remove file");
        }
        try {
            return new RandomAccessFile(new File(zipModel.getZipFile()), str);
        } catch (FileNotFoundException e) {
            throw new ZipException(e);
        }
    }

    public void mergeSplitZipFiles(final ZipModel zipModel, final File file, final ProgressMonitor progressMonitor, boolean z) throws ZipException {
        if (z) {
            new Thread(InternalZipConstants.THREAD_NAME) { // from class: net.lingala.zip4j.util.ArchiveMaintainer.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        ArchiveMaintainer.this.initMergeSplitZipFile(zipModel, file, progressMonitor);
                    } catch (ZipException unused) {
                    }
                }
            }.start();
        } else {
            initMergeSplitZipFile(zipModel, file, progressMonitor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0086 A[Catch: all -> 0x0075, Exception -> 0x0078, IOException -> 0x007b, TRY_LEAVE, TryCatch #22 {IOException -> 0x007b, Exception -> 0x0078, all -> 0x0075, blocks: (B:76:0x003b, B:78:0x0041, B:80:0x004b, B:82:0x0059, B:21:0x0086), top: B:75:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ce A[Catch: all -> 0x00e2, Exception -> 0x00ea, IOException -> 0x00f2, TRY_ENTER, TRY_LEAVE, TryCatch #6 {IOException -> 0x00f2, blocks: (B:26:0x00ab, B:36:0x00bc, B:28:0x00ce), top: B:25:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0180 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void initMergeSplitZipFile(net.lingala.zip4j.model.ZipModel r24, java.io.File r25, net.lingala.zip4j.progress.ProgressMonitor r26) throws net.lingala.zip4j.exception.ZipException {
        /*
            Method dump skipped, instructions count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: net.lingala.zip4j.util.ArchiveMaintainer.initMergeSplitZipFile(net.lingala.zip4j.model.ZipModel, java.io.File, net.lingala.zip4j.progress.ProgressMonitor):void");
    }

    private RandomAccessFile createSplitZipFileHandler(ZipModel zipModel, int i) throws ZipException {
        String str;
        if (zipModel == null) {
            throw new ZipException("zip model is null, cannot create split file handler");
        }
        if (i < 0) {
            throw new ZipException("invlaid part number, cannot create split file handler");
        }
        try {
            String zipFile = zipModel.getZipFile();
            if (i == zipModel.getEndCentralDirRecord().getNoOfThisDisk()) {
                str = zipModel.getZipFile();
            } else if (i >= 9) {
                str = zipFile.substring(0, zipFile.lastIndexOf(".")) + ".z" + (i + 1);
            } else {
                str = zipFile.substring(0, zipFile.lastIndexOf(".")) + ".z0" + (i + 1);
            }
            File file = new File(str);
            if (!Zip4jUtil.checkFileExists(file)) {
                throw new ZipException("split file does not exist: " + str);
            }
            return new RandomAccessFile(file, InternalZipConstants.READ_MODE);
        } catch (FileNotFoundException e) {
            throw new ZipException(e);
        } catch (Exception e2) {
            throw new ZipException(e2);
        }
    }

    private OutputStream prepareOutputStreamForMerge(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("outFile is null, cannot create outputstream");
        }
        try {
            return new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new ZipException(e);
        } catch (Exception e2) {
            throw new ZipException(e2);
        }
    }

    private void updateSplitZipModel(ZipModel zipModel, ArrayList arrayList, boolean z) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("zip model is null, cannot update split zip model");
        }
        zipModel.setSplitArchive(false);
        updateSplitFileHeader(zipModel, arrayList, z);
        updateSplitEndCentralDirectory(zipModel);
        if (zipModel.isZip64Format()) {
            updateSplitZip64EndCentralDirLocator(zipModel, arrayList);
            updateSplitZip64EndCentralDirRec(zipModel, arrayList);
        }
    }

    private void updateSplitFileHeader(ZipModel zipModel, ArrayList arrayList, boolean z) throws ZipException {
        try {
            if (zipModel.getCentralDirectory() == null) {
                throw new ZipException("corrupt zip model - getCentralDirectory, cannot update split zip model");
            }
            int size = zipModel.getCentralDirectory().getFileHeaders().size();
            int i = z ? 4 : 0;
            for (int i2 = 0; i2 < size; i2++) {
                long j = 0;
                for (int i3 = 0; i3 < ((FileHeader) zipModel.getCentralDirectory().getFileHeaders().get(i2)).getDiskNumberStart(); i3++) {
                    j += ((Long) arrayList.get(i3)).longValue();
                }
                ((FileHeader) zipModel.getCentralDirectory().getFileHeaders().get(i2)).setOffsetLocalHeader((((FileHeader) zipModel.getCentralDirectory().getFileHeaders().get(i2)).getOffsetLocalHeader() + j) - i);
                ((FileHeader) zipModel.getCentralDirectory().getFileHeaders().get(i2)).setDiskNumberStart(0);
            }
        } catch (ZipException e) {
            throw e;
        } catch (Exception e2) {
            throw new ZipException(e2);
        }
    }

    private void updateSplitEndCentralDirectory(ZipModel zipModel) throws ZipException {
        try {
            if (zipModel == null) {
                throw new ZipException("zip model is null - cannot update end of central directory for split zip model");
            }
            if (zipModel.getCentralDirectory() == null) {
                throw new ZipException("corrupt zip model - getCentralDirectory, cannot update split zip model");
            }
            zipModel.getEndCentralDirRecord().setNoOfThisDisk(0);
            zipModel.getEndCentralDirRecord().setNoOfThisDiskStartOfCentralDir(0);
            zipModel.getEndCentralDirRecord().setTotNoOfEntriesInCentralDir(zipModel.getCentralDirectory().getFileHeaders().size());
            zipModel.getEndCentralDirRecord().setTotNoOfEntriesInCentralDirOnThisDisk(zipModel.getCentralDirectory().getFileHeaders().size());
        } catch (ZipException e) {
            throw e;
        } catch (Exception e2) {
            throw new ZipException(e2);
        }
    }

    private void updateSplitZip64EndCentralDirLocator(ZipModel zipModel, ArrayList arrayList) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("zip model is null, cannot update split Zip64 end of central directory locator");
        }
        if (zipModel.getZip64EndCentralDirLocator() == null) {
            return;
        }
        zipModel.getZip64EndCentralDirLocator().setNoOfDiskStartOfZip64EndOfCentralDirRec(0);
        long j = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            j += ((Long) arrayList.get(i)).longValue();
        }
        zipModel.getZip64EndCentralDirLocator().setOffsetZip64EndOfCentralDirRec(zipModel.getZip64EndCentralDirLocator().getOffsetZip64EndOfCentralDirRec() + j);
        zipModel.getZip64EndCentralDirLocator().setTotNumberOfDiscs(1);
    }

    private void updateSplitZip64EndCentralDirRec(ZipModel zipModel, ArrayList arrayList) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("zip model is null, cannot update split Zip64 end of central directory record");
        }
        if (zipModel.getZip64EndCentralDirRecord() == null) {
            return;
        }
        zipModel.getZip64EndCentralDirRecord().setNoOfThisDisk(0);
        zipModel.getZip64EndCentralDirRecord().setNoOfThisDiskStartOfCentralDir(0);
        zipModel.getZip64EndCentralDirRecord().setTotNoOfEntriesInCentralDirOnThisDisk(zipModel.getEndCentralDirRecord().getTotNoOfEntriesInCentralDir());
        long j = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            j += ((Long) arrayList.get(i)).longValue();
        }
        zipModel.getZip64EndCentralDirRecord().setOffsetStartCenDirWRTStartDiskNo(zipModel.getZip64EndCentralDirRecord().getOffsetStartCenDirWRTStartDiskNo() + j);
    }

    public void setComment(ZipModel zipModel, String str) throws ZipException {
        if (str == null) {
            throw new ZipException("comment is null, cannot update Zip file with comment");
        }
        if (zipModel == null) {
            throw new ZipException("zipModel is null, cannot update Zip file with comment");
        }
        byte[] bytes = str.getBytes();
        int length = str.length();
        if (Zip4jUtil.isSupportedCharset(InternalZipConstants.CHARSET_COMMENTS_DEFAULT)) {
            try {
                String str2 = new String(str.getBytes(InternalZipConstants.CHARSET_COMMENTS_DEFAULT), InternalZipConstants.CHARSET_COMMENTS_DEFAULT);
                byte[] bytes2 = str2.getBytes(InternalZipConstants.CHARSET_COMMENTS_DEFAULT);
                length = str2.length();
                str = str2;
                bytes = bytes2;
            } catch (UnsupportedEncodingException unused) {
                bytes = str.getBytes();
                length = str.length();
            }
        }
        if (length > 65535) {
            throw new ZipException("comment length exceeds maximum length");
        }
        zipModel.getEndCentralDirRecord().setComment(str);
        zipModel.getEndCentralDirRecord().setCommentBytes(bytes);
        zipModel.getEndCentralDirRecord().setCommentLength(length);
        SplitOutputStream splitOutputStream = null;
        try {
            try {
                HeaderWriter headerWriter = new HeaderWriter();
                SplitOutputStream splitOutputStream2 = new SplitOutputStream(zipModel.getZipFile());
                try {
                    if (zipModel.isZip64Format()) {
                        splitOutputStream2.seek(zipModel.getZip64EndCentralDirRecord().getOffsetStartCenDirWRTStartDiskNo());
                    } else {
                        splitOutputStream2.seek(zipModel.getEndCentralDirRecord().getOffsetOfStartOfCentralDir());
                    }
                    headerWriter.finalizeZipFileWithoutValidations(zipModel, splitOutputStream2);
                    try {
                        splitOutputStream2.close();
                    } catch (IOException unused2) {
                    }
                } catch (FileNotFoundException e) {
                    e = e;
                    throw new ZipException(e);
                } catch (IOException e2) {
                    e = e2;
                    throw new ZipException(e);
                } catch (Throwable th) {
                    th = th;
                    splitOutputStream = splitOutputStream2;
                    if (splitOutputStream != null) {
                        try {
                            splitOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void initProgressMonitorForRemoveOp(ZipModel zipModel, FileHeader fileHeader, ProgressMonitor progressMonitor) throws ZipException {
        if (zipModel == null || fileHeader == null || progressMonitor == null) {
            throw new ZipException("one of the input parameters is null, cannot calculate total work");
        }
        progressMonitor.setCurrentOperation(2);
        progressMonitor.setFileName(fileHeader.getFileName());
        progressMonitor.setTotalWork(calculateTotalWorkForRemoveOp(zipModel, fileHeader));
        progressMonitor.setState(1);
    }

    private long calculateTotalWorkForRemoveOp(ZipModel zipModel, FileHeader fileHeader) throws ZipException {
        return Zip4jUtil.getFileLengh(new File(zipModel.getZipFile())) - fileHeader.getCompressedSize();
    }

    public void initProgressMonitorForMergeOp(ZipModel zipModel, ProgressMonitor progressMonitor) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("zip model is null, cannot calculate total work for merge op");
        }
        progressMonitor.setCurrentOperation(4);
        progressMonitor.setFileName(zipModel.getZipFile());
        progressMonitor.setTotalWork(calculateTotalWorkForMergeOp(zipModel));
        progressMonitor.setState(1);
    }

    private long calculateTotalWorkForMergeOp(ZipModel zipModel) throws ZipException {
        String str;
        long j = 0;
        if (zipModel.isSplitArchive()) {
            int noOfThisDisk = zipModel.getEndCentralDirRecord().getNoOfThisDisk();
            String zipFile = zipModel.getZipFile();
            for (int i = 0; i <= noOfThisDisk; i++) {
                if (zipModel.getEndCentralDirRecord().getNoOfThisDisk() == 0) {
                    str = zipModel.getZipFile();
                } else {
                    str = zipFile.substring(0, zipFile.lastIndexOf(".")) + ".z01";
                }
                j += Zip4jUtil.getFileLengh(new File(str));
            }
        }
        return j;
    }
}
