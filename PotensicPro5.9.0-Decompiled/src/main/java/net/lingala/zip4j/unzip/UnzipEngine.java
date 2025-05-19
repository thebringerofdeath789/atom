package net.lingala.zip4j.unzip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.zip.CRC32;
import net.lingala.zip4j.core.HeaderReader;
import net.lingala.zip4j.crypto.AESDecrypter;
import net.lingala.zip4j.crypto.IDecrypter;
import net.lingala.zip4j.crypto.StandardDecrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.InflaterInputStream;
import net.lingala.zip4j.io.PartInputStream;
import net.lingala.zip4j.io.ZipInputStream;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Raw;
import net.lingala.zip4j.util.Zip4jUtil;

/* loaded from: classes4.dex */
public class UnzipEngine {
    private CRC32 crc;
    private int currSplitFileCounter = 0;
    private IDecrypter decrypter;
    private FileHeader fileHeader;
    private LocalFileHeader localFileHeader;
    private ZipModel zipModel;

    public UnzipEngine(ZipModel zipModel, FileHeader fileHeader) throws ZipException {
        if (zipModel == null || fileHeader == null) {
            throw new ZipException("Invalid parameters passed to StoreUnzip. One or more of the parameters were null");
        }
        this.zipModel = zipModel;
        this.fileHeader = fileHeader;
        this.crc = new CRC32();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [net.lingala.zip4j.unzip.UnzipEngine] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v6 */
    public void unzipFile(ProgressMonitor progressMonitor, String str, String str2, UnzipParameters unzipParameters) throws ZipException {
        byte[] bArr;
        ZipInputStream inputStream;
        if (this.zipModel == null || this.fileHeader == null || !Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("Invalid parameters passed during unzipping file. One or more of the parameters were null");
        }
        ZipInputStream zipInputStream = null;
        try {
            try {
                bArr = new byte[4096];
                inputStream = getInputStream();
            } catch (IOException e) {
                e = e;
            } catch (Exception e2) {
                e = e2;
            } catch (Throwable th) {
                th = th;
                str = 0;
            }
            try {
                FileOutputStream outputStream = getOutputStream(str, str2);
                do {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                        progressMonitor.updateWorkCompleted(read);
                    } else {
                        closeStreams(inputStream, outputStream);
                        UnzipUtil.applyFileAttributes(this.fileHeader, new File(getOutputFileNameWithPath(str, str2)), unzipParameters);
                        closeStreams(inputStream, outputStream);
                        return;
                    }
                } while (!progressMonitor.isCancelAllTasks());
                progressMonitor.setResult(3);
                progressMonitor.setState(0);
                closeStreams(inputStream, outputStream);
            } catch (IOException e3) {
                e = e3;
                throw new ZipException(e);
            } catch (Exception e4) {
                e = e4;
                throw new ZipException(e);
            } catch (Throwable th2) {
                th = th2;
                str = 0;
                zipInputStream = inputStream;
                closeStreams(zipInputStream, str);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public ZipInputStream getInputStream() throws ZipException {
        long j;
        if (this.fileHeader == null) {
            throw new ZipException("file header is null, cannot get inputstream");
        }
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile createFileHandler = createFileHandler(InternalZipConstants.READ_MODE);
            if (!checkLocalHeader()) {
                throw new ZipException("local header and file header do not match");
            }
            init(createFileHandler);
            long compressedSize = this.localFileHeader.getCompressedSize();
            long offsetStartOfData = this.localFileHeader.getOffsetStartOfData();
            if (this.localFileHeader.isEncrypted()) {
                if (this.localFileHeader.getEncryptionMethod() == 99) {
                    if (this.decrypter instanceof AESDecrypter) {
                        compressedSize -= (((AESDecrypter) r5).getSaltLength() + ((AESDecrypter) this.decrypter).getPasswordVerifierLength()) + 10;
                        j = ((AESDecrypter) this.decrypter).getSaltLength() + ((AESDecrypter) this.decrypter).getPasswordVerifierLength();
                    } else {
                        throw new ZipException("invalid decryptor when trying to calculate compressed size for AES encrypted file: " + this.fileHeader.getFileName());
                    }
                } else if (this.localFileHeader.getEncryptionMethod() == 0) {
                    j = 12;
                    compressedSize -= 12;
                }
                offsetStartOfData += j;
            }
            long j2 = compressedSize;
            long j3 = offsetStartOfData;
            int compressionMethod = this.fileHeader.getCompressionMethod();
            if (this.fileHeader.getEncryptionMethod() == 99) {
                if (this.fileHeader.getAesExtraDataRecord() != null) {
                    compressionMethod = this.fileHeader.getAesExtraDataRecord().getCompressionMethod();
                } else {
                    throw new ZipException("AESExtraDataRecord does not exist for AES encrypted file: " + this.fileHeader.getFileName());
                }
            }
            createFileHandler.seek(j3);
            if (compressionMethod == 0) {
                return new ZipInputStream(new PartInputStream(createFileHandler, j3, j2, this));
            }
            if (compressionMethod == 8) {
                return new ZipInputStream(new InflaterInputStream(createFileHandler, j3, j2, this));
            }
            throw new ZipException("compression type not supported");
        } catch (ZipException e) {
            if (0 != 0) {
                try {
                    randomAccessFile.close();
                } catch (IOException unused) {
                }
            }
            throw e;
        } catch (Exception e2) {
            if (0 != 0) {
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
            }
            throw new ZipException(e2);
        }
    }

    private void init(RandomAccessFile randomAccessFile) throws ZipException {
        if (this.localFileHeader == null) {
            throw new ZipException("local file header is null, cannot initialize input stream");
        }
        try {
            initDecrypter(randomAccessFile);
        } catch (ZipException e) {
            throw e;
        } catch (Exception e2) {
            throw new ZipException(e2);
        }
    }

    private void initDecrypter(RandomAccessFile randomAccessFile) throws ZipException {
        LocalFileHeader localFileHeader = this.localFileHeader;
        if (localFileHeader == null) {
            throw new ZipException("local file header is null, cannot init decrypter");
        }
        if (localFileHeader.isEncrypted()) {
            if (this.localFileHeader.getEncryptionMethod() == 0) {
                this.decrypter = new StandardDecrypter(this.fileHeader, getStandardDecrypterHeaderBytes(randomAccessFile));
            } else {
                if (this.localFileHeader.getEncryptionMethod() == 99) {
                    this.decrypter = new AESDecrypter(this.localFileHeader, getAESSalt(randomAccessFile), getAESPasswordVerifier(randomAccessFile));
                    return;
                }
                throw new ZipException("unsupported encryption method");
            }
        }
    }

    private byte[] getStandardDecrypterHeaderBytes(RandomAccessFile randomAccessFile) throws ZipException {
        try {
            byte[] bArr = new byte[12];
            randomAccessFile.seek(this.localFileHeader.getOffsetStartOfData());
            randomAccessFile.read(bArr, 0, 12);
            return bArr;
        } catch (IOException e) {
            throw new ZipException(e);
        } catch (Exception e2) {
            throw new ZipException(e2);
        }
    }

    private byte[] getAESSalt(RandomAccessFile randomAccessFile) throws ZipException {
        if (this.localFileHeader.getAesExtraDataRecord() == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[calculateAESSaltLength(this.localFileHeader.getAesExtraDataRecord())];
            randomAccessFile.seek(this.localFileHeader.getOffsetStartOfData());
            randomAccessFile.read(bArr);
            return bArr;
        } catch (IOException e) {
            throw new ZipException(e);
        }
    }

    private byte[] getAESPasswordVerifier(RandomAccessFile randomAccessFile) throws ZipException {
        try {
            byte[] bArr = new byte[2];
            randomAccessFile.read(bArr);
            return bArr;
        } catch (IOException e) {
            throw new ZipException(e);
        }
    }

    private int calculateAESSaltLength(AESExtraDataRecord aESExtraDataRecord) throws ZipException {
        if (aESExtraDataRecord == null) {
            throw new ZipException("unable to determine salt length: AESExtraDataRecord is null");
        }
        int aesStrength = aESExtraDataRecord.getAesStrength();
        if (aesStrength == 1) {
            return 8;
        }
        if (aesStrength == 2) {
            return 12;
        }
        if (aesStrength == 3) {
            return 16;
        }
        throw new ZipException("unable to determine salt length: invalid aes key strength");
    }

    public void checkCRC() throws ZipException {
        FileHeader fileHeader = this.fileHeader;
        if (fileHeader != null) {
            if (fileHeader.getEncryptionMethod() != 99) {
                if ((this.crc.getValue() & 4294967295L) != this.fileHeader.getCrc32()) {
                    String str = "invalid CRC for file: " + this.fileHeader.getFileName();
                    if (this.localFileHeader.isEncrypted() && this.localFileHeader.getEncryptionMethod() == 0) {
                        str = str + " - Wrong Password?";
                    }
                    throw new ZipException(str);
                }
                return;
            }
            IDecrypter iDecrypter = this.decrypter;
            if (iDecrypter == null || !(iDecrypter instanceof AESDecrypter)) {
                return;
            }
            byte[] calculatedAuthenticationBytes = ((AESDecrypter) iDecrypter).getCalculatedAuthenticationBytes();
            byte[] storedMac = ((AESDecrypter) this.decrypter).getStoredMac();
            byte[] bArr = new byte[10];
            if (storedMac == null) {
                throw new ZipException("CRC (MAC) check failed for " + this.fileHeader.getFileName());
            }
            System.arraycopy(calculatedAuthenticationBytes, 0, bArr, 0, 10);
            if (!Arrays.equals(bArr, storedMac)) {
                throw new ZipException("invalid CRC (MAC) for file: " + this.fileHeader.getFileName());
            }
        }
    }

    private boolean checkLocalHeader() throws ZipException {
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile checkSplitFile = checkSplitFile();
                if (checkSplitFile == null) {
                    checkSplitFile = new RandomAccessFile(new File(this.zipModel.getZipFile()), InternalZipConstants.READ_MODE);
                }
                LocalFileHeader readLocalFileHeader = new HeaderReader(checkSplitFile).readLocalFileHeader(this.fileHeader);
                this.localFileHeader = readLocalFileHeader;
                if (readLocalFileHeader == null) {
                    throw new ZipException("error reading local file header. Is this a valid zip file?");
                }
                if (readLocalFileHeader.getCompressionMethod() != this.fileHeader.getCompressionMethod()) {
                    if (checkSplitFile != null) {
                        try {
                            checkSplitFile.close();
                        } catch (IOException | Exception unused) {
                        }
                    }
                    return false;
                }
                if (checkSplitFile != null) {
                    try {
                        checkSplitFile.close();
                    } catch (IOException | Exception unused2) {
                    }
                }
                return true;
            } catch (FileNotFoundException e) {
                throw new ZipException(e);
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    randomAccessFile.close();
                } catch (IOException | Exception unused3) {
                }
            }
            throw th;
        }
    }

    private RandomAccessFile checkSplitFile() throws ZipException {
        String str;
        if (!this.zipModel.isSplitArchive()) {
            return null;
        }
        int diskNumberStart = this.fileHeader.getDiskNumberStart();
        int i = diskNumberStart + 1;
        this.currSplitFileCounter = i;
        String zipFile = this.zipModel.getZipFile();
        if (diskNumberStart == this.zipModel.getEndCentralDirRecord().getNoOfThisDisk()) {
            str = this.zipModel.getZipFile();
        } else if (diskNumberStart >= 9) {
            str = zipFile.substring(0, zipFile.lastIndexOf(".")) + ".z" + i;
        } else {
            str = zipFile.substring(0, zipFile.lastIndexOf(".")) + ".z0" + i;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, InternalZipConstants.READ_MODE);
            if (this.currSplitFileCounter == 1) {
                randomAccessFile.read(new byte[4]);
                if (Raw.readIntLittleEndian(r0, 0) != 134695760) {
                    throw new ZipException("invalid first part split file signature");
                }
            }
            return randomAccessFile;
        } catch (FileNotFoundException e) {
            throw new ZipException(e);
        } catch (IOException e2) {
            throw new ZipException(e2);
        }
    }

    private RandomAccessFile createFileHandler(String str) throws ZipException {
        ZipModel zipModel = this.zipModel;
        if (zipModel == null || !Zip4jUtil.isStringNotNullAndNotEmpty(zipModel.getZipFile())) {
            throw new ZipException("input parameter is null in getFilePointer");
        }
        try {
            if (this.zipModel.isSplitArchive()) {
                return checkSplitFile();
            }
            return new RandomAccessFile(new File(this.zipModel.getZipFile()), str);
        } catch (FileNotFoundException e) {
            throw new ZipException(e);
        } catch (Exception e2) {
            throw new ZipException(e2);
        }
    }

    private FileOutputStream getOutputStream(String str, String str2) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("invalid output path");
        }
        try {
            File file = new File(getOutputFileNameWithPath(str, str2));
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            return new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new ZipException(e);
        }
    }

    private String getOutputFileNameWithPath(String str, String str2) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            str2 = this.fileHeader.getFileName();
        }
        return str + System.getProperty("file.separator") + str2;
    }

    public RandomAccessFile startNextSplitFile() throws IOException, FileNotFoundException {
        String str;
        String zipFile = this.zipModel.getZipFile();
        if (this.currSplitFileCounter == this.zipModel.getEndCentralDirRecord().getNoOfThisDisk()) {
            str = this.zipModel.getZipFile();
        } else if (this.currSplitFileCounter >= 9) {
            str = zipFile.substring(0, zipFile.lastIndexOf(".")) + ".z" + (this.currSplitFileCounter + 1);
        } else {
            str = zipFile.substring(0, zipFile.lastIndexOf(".")) + ".z0" + (this.currSplitFileCounter + 1);
        }
        this.currSplitFileCounter++;
        try {
            if (!Zip4jUtil.checkFileExists(str)) {
                throw new IOException("zip split file does not exist: " + str);
            }
            return new RandomAccessFile(str, InternalZipConstants.READ_MODE);
        } catch (ZipException e) {
            throw new IOException(e.getMessage());
        }
    }

    private void closeStreams(InputStream inputStream, OutputStream outputStream) throws ZipException {
        if (inputStream != null) {
            try {
                try {
                    inputStream.close();
                } catch (Throwable th) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e) {
                if (Zip4jUtil.isStringNotNullAndNotEmpty(e.getMessage()) && e.getMessage().indexOf(" - Wrong Password?") >= 0) {
                    throw new ZipException(e.getMessage());
                }
                return;
            }
        }
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.close();
        } catch (IOException unused2) {
        }
    }

    public void updateCRC(int i) {
        this.crc.update(i);
    }

    public void updateCRC(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            this.crc.update(bArr, i, i2);
        }
    }

    public FileHeader getFileHeader() {
        return this.fileHeader;
    }

    public IDecrypter getDecrypter() {
        return this.decrypter;
    }

    public ZipModel getZipModel() {
        return this.zipModel;
    }

    public LocalFileHeader getLocalFileHeader() {
        return this.localFileHeader;
    }
}
