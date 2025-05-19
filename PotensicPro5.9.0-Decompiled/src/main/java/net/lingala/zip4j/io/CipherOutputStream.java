package net.lingala.zip4j.io;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.zip.CRC32;
import net.lingala.zip4j.core.HeaderWriter;
import net.lingala.zip4j.crypto.AESEncrpyter;
import net.lingala.zip4j.crypto.IEncrypter;
import net.lingala.zip4j.crypto.StandardEncrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.EndCentralDirRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Raw;
import net.lingala.zip4j.util.Zip4jUtil;

/* loaded from: classes4.dex */
public class CipherOutputStream extends BaseOutputStream {
    private long bytesWrittenForThisFile;
    protected CRC32 crc;
    private IEncrypter encrypter;
    protected FileHeader fileHeader;
    protected LocalFileHeader localFileHeader;
    protected OutputStream outputStream;
    private byte[] pendingBuffer;
    private int pendingBufferLength;
    private File sourceFile;
    private long totalBytesRead;
    private long totalBytesWritten;
    protected ZipModel zipModel;
    protected ZipParameters zipParameters;

    private int[] generateGeneralPurposeBitArray(boolean z, int i) {
        int[] iArr = new int[8];
        if (z) {
            iArr[0] = 1;
        } else {
            iArr[0] = 0;
        }
        if (i != 8) {
            iArr[1] = 0;
            iArr[2] = 0;
        }
        iArr[3] = 1;
        return iArr;
    }

    public CipherOutputStream(OutputStream outputStream, ZipModel zipModel) {
        this.outputStream = outputStream;
        initZipModel(zipModel);
        this.crc = new CRC32();
        this.totalBytesWritten = 0L;
        this.bytesWrittenForThisFile = 0L;
        this.pendingBuffer = new byte[16];
        this.pendingBufferLength = 0;
        this.totalBytesRead = 0L;
    }

    public void putNextEntry(File file, ZipParameters zipParameters) throws ZipException {
        if (!zipParameters.isSourceExternalStream() && file == null) {
            throw new ZipException("input file is null");
        }
        if (!zipParameters.isSourceExternalStream() && !Zip4jUtil.checkFileExists(file)) {
            throw new ZipException("input file does not exist");
        }
        try {
            this.sourceFile = file;
            this.zipParameters = (ZipParameters) zipParameters.clone();
            if (!zipParameters.isSourceExternalStream()) {
                if (this.sourceFile.isDirectory()) {
                    this.zipParameters.setEncryptFiles(false);
                    this.zipParameters.setEncryptionMethod(-1);
                    this.zipParameters.setCompressionMethod(0);
                }
            } else {
                if (!Zip4jUtil.isStringNotNullAndNotEmpty(this.zipParameters.getFileNameInZip())) {
                    throw new ZipException("file name is empty for external stream");
                }
                if (this.zipParameters.getFileNameInZip().endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR) || this.zipParameters.getFileNameInZip().endsWith("\\")) {
                    this.zipParameters.setEncryptFiles(false);
                    this.zipParameters.setEncryptionMethod(-1);
                    this.zipParameters.setCompressionMethod(0);
                }
            }
            createFileHeader();
            createLocalFileHeader();
            if (this.zipModel.isSplitArchive() && (this.zipModel.getCentralDirectory() == null || this.zipModel.getCentralDirectory().getFileHeaders() == null || this.zipModel.getCentralDirectory().getFileHeaders().size() == 0)) {
                byte[] bArr = new byte[4];
                Raw.writeIntLittleEndian(bArr, 0, 134695760);
                this.outputStream.write(bArr);
                this.totalBytesWritten += 4;
            }
            OutputStream outputStream = this.outputStream;
            if (!(outputStream instanceof SplitOutputStream)) {
                long j = this.totalBytesWritten;
                if (j == 4) {
                    this.fileHeader.setOffsetLocalHeader(4L);
                } else {
                    this.fileHeader.setOffsetLocalHeader(j);
                }
            } else if (this.totalBytesWritten == 4) {
                this.fileHeader.setOffsetLocalHeader(4L);
            } else {
                this.fileHeader.setOffsetLocalHeader(((SplitOutputStream) outputStream).getFilePointer());
            }
            this.totalBytesWritten += new HeaderWriter().writeLocalFileHeader(this.zipModel, this.localFileHeader, this.outputStream);
            if (this.zipParameters.isEncryptFiles()) {
                initEncrypter();
                if (this.encrypter != null) {
                    if (zipParameters.getEncryptionMethod() == 0) {
                        this.outputStream.write(((StandardEncrypter) this.encrypter).getHeaderBytes());
                        this.totalBytesWritten += r6.length;
                        this.bytesWrittenForThisFile += r6.length;
                    } else if (zipParameters.getEncryptionMethod() == 99) {
                        byte[] saltBytes = ((AESEncrpyter) this.encrypter).getSaltBytes();
                        byte[] derivedPasswordVerifier = ((AESEncrpyter) this.encrypter).getDerivedPasswordVerifier();
                        this.outputStream.write(saltBytes);
                        this.outputStream.write(derivedPasswordVerifier);
                        this.totalBytesWritten += saltBytes.length + derivedPasswordVerifier.length;
                        this.bytesWrittenForThisFile += saltBytes.length + derivedPasswordVerifier.length;
                    }
                }
            }
            this.crc.reset();
        } catch (CloneNotSupportedException e) {
            throw new ZipException(e);
        } catch (ZipException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new ZipException(e3);
        }
    }

    private void initEncrypter() throws ZipException {
        if (!this.zipParameters.isEncryptFiles()) {
            this.encrypter = null;
            return;
        }
        int encryptionMethod = this.zipParameters.getEncryptionMethod();
        if (encryptionMethod == 0) {
            this.encrypter = new StandardEncrypter(this.zipParameters.getPassword(), (this.localFileHeader.getLastModFileTime() & 65535) << 16);
        } else {
            if (encryptionMethod == 99) {
                this.encrypter = new AESEncrpyter(this.zipParameters.getPassword(), this.zipParameters.getAesKeyStrength());
                return;
            }
            throw new ZipException("invalid encprytion method");
        }
    }

    private void initZipModel(ZipModel zipModel) {
        if (zipModel == null) {
            this.zipModel = new ZipModel();
        } else {
            this.zipModel = zipModel;
        }
        if (this.zipModel.getEndCentralDirRecord() == null) {
            this.zipModel.setEndCentralDirRecord(new EndCentralDirRecord());
        }
        if (this.zipModel.getCentralDirectory() == null) {
            this.zipModel.setCentralDirectory(new CentralDirectory());
        }
        if (this.zipModel.getCentralDirectory().getFileHeaders() == null) {
            this.zipModel.getCentralDirectory().setFileHeaders(new ArrayList());
        }
        if (this.zipModel.getLocalFileHeaderList() == null) {
            this.zipModel.setLocalFileHeaderList(new ArrayList());
        }
        OutputStream outputStream = this.outputStream;
        if ((outputStream instanceof SplitOutputStream) && ((SplitOutputStream) outputStream).isSplitZipFile()) {
            this.zipModel.setSplitArchive(true);
            this.zipModel.setSplitLength(((SplitOutputStream) this.outputStream).getSplitLength());
        }
        this.zipModel.getEndCentralDirRecord().setSignature(InternalZipConstants.ENDSIG);
    }

    @Override // net.lingala.zip4j.io.BaseOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        Objects.requireNonNull(bArr);
        if (bArr.length == 0) {
            return;
        }
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (i2 == 0) {
            return;
        }
        if (this.zipParameters.isEncryptFiles() && this.zipParameters.getEncryptionMethod() == 99) {
            int i4 = this.pendingBufferLength;
            if (i4 != 0) {
                if (i2 >= 16 - i4) {
                    System.arraycopy(bArr, i, this.pendingBuffer, i4, 16 - i4);
                    byte[] bArr2 = this.pendingBuffer;
                    encryptAndWrite(bArr2, 0, bArr2.length);
                    i = 16 - this.pendingBufferLength;
                    i2 -= i;
                    this.pendingBufferLength = 0;
                } else {
                    System.arraycopy(bArr, i, this.pendingBuffer, i4, i2);
                    this.pendingBufferLength += i2;
                    return;
                }
            }
            if (i2 != 0 && (i3 = i2 % 16) != 0) {
                System.arraycopy(bArr, (i2 + i) - i3, this.pendingBuffer, 0, i3);
                this.pendingBufferLength = i3;
                i2 -= i3;
            }
        }
        if (i2 != 0) {
            encryptAndWrite(bArr, i, i2);
        }
    }

    private void encryptAndWrite(byte[] bArr, int i, int i2) throws IOException {
        IEncrypter iEncrypter = this.encrypter;
        if (iEncrypter != null) {
            try {
                iEncrypter.encryptData(bArr, i, i2);
            } catch (ZipException e) {
                throw new IOException(e.getMessage());
            }
        }
        this.outputStream.write(bArr, i, i2);
        long j = i2;
        this.totalBytesWritten += j;
        this.bytesWrittenForThisFile += j;
    }

    public void closeEntry() throws IOException, ZipException {
        int i = this.pendingBufferLength;
        if (i != 0) {
            encryptAndWrite(this.pendingBuffer, 0, i);
            this.pendingBufferLength = 0;
        }
        if (this.zipParameters.isEncryptFiles() && this.zipParameters.getEncryptionMethod() == 99) {
            IEncrypter iEncrypter = this.encrypter;
            if (iEncrypter instanceof AESEncrpyter) {
                this.outputStream.write(((AESEncrpyter) iEncrypter).getFinalMac());
                this.bytesWrittenForThisFile += 10;
                this.totalBytesWritten += 10;
            } else {
                throw new ZipException("invalid encrypter for AES encrypted file");
            }
        }
        this.fileHeader.setCompressedSize(this.bytesWrittenForThisFile);
        this.localFileHeader.setCompressedSize(this.bytesWrittenForThisFile);
        if (this.zipParameters.isSourceExternalStream()) {
            this.fileHeader.setUncompressedSize(this.totalBytesRead);
            long uncompressedSize = this.localFileHeader.getUncompressedSize();
            long j = this.totalBytesRead;
            if (uncompressedSize != j) {
                this.localFileHeader.setUncompressedSize(j);
            }
        }
        long value = this.crc.getValue();
        if (this.fileHeader.isEncrypted() && this.fileHeader.getEncryptionMethod() == 99) {
            value = 0;
        }
        if (this.zipParameters.isEncryptFiles() && this.zipParameters.getEncryptionMethod() == 99) {
            this.fileHeader.setCrc32(0L);
            this.localFileHeader.setCrc32(0L);
        } else {
            this.fileHeader.setCrc32(value);
            this.localFileHeader.setCrc32(value);
        }
        this.zipModel.getLocalFileHeaderList().add(this.localFileHeader);
        this.zipModel.getCentralDirectory().getFileHeaders().add(this.fileHeader);
        this.totalBytesWritten += new HeaderWriter().writeExtendedLocalHeader(this.localFileHeader, this.outputStream);
        this.crc.reset();
        this.bytesWrittenForThisFile = 0L;
        this.encrypter = null;
        this.totalBytesRead = 0L;
    }

    public void finish() throws IOException, ZipException {
        this.zipModel.getEndCentralDirRecord().setOffsetOfStartOfCentralDir(this.totalBytesWritten);
        new HeaderWriter().finalizeZipFile(this.zipModel, this.outputStream);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        OutputStream outputStream = this.outputStream;
        if (outputStream != null) {
            outputStream.close();
        }
    }

    private void createFileHeader() throws ZipException {
        String relativeFileName;
        int i;
        FileHeader fileHeader = new FileHeader();
        this.fileHeader = fileHeader;
        fileHeader.setSignature(33639248);
        this.fileHeader.setVersionMadeBy(20);
        this.fileHeader.setVersionNeededToExtract(20);
        if (this.zipParameters.isEncryptFiles() && this.zipParameters.getEncryptionMethod() == 99) {
            this.fileHeader.setCompressionMethod(99);
            this.fileHeader.setAesExtraDataRecord(generateAESExtraDataRecord(this.zipParameters));
        } else {
            this.fileHeader.setCompressionMethod(this.zipParameters.getCompressionMethod());
        }
        if (this.zipParameters.isEncryptFiles()) {
            this.fileHeader.setEncrypted(true);
            this.fileHeader.setEncryptionMethod(this.zipParameters.getEncryptionMethod());
        }
        if (this.zipParameters.isSourceExternalStream()) {
            this.fileHeader.setLastModFileTime((int) Zip4jUtil.javaToDosTime(System.currentTimeMillis()));
            if (!Zip4jUtil.isStringNotNullAndNotEmpty(this.zipParameters.getFileNameInZip())) {
                throw new ZipException("fileNameInZip is null or empty");
            }
            relativeFileName = this.zipParameters.getFileNameInZip();
        } else {
            this.fileHeader.setLastModFileTime((int) Zip4jUtil.javaToDosTime(Zip4jUtil.getLastModifiedFileTime(this.sourceFile, this.zipParameters.getTimeZone())));
            this.fileHeader.setUncompressedSize(this.sourceFile.length());
            relativeFileName = Zip4jUtil.getRelativeFileName(this.sourceFile.getAbsolutePath(), this.zipParameters.getRootFolderInZip(), this.zipParameters.getDefaultFolderPath());
        }
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(relativeFileName)) {
            throw new ZipException("fileName is null or empty. unable to create file header");
        }
        this.fileHeader.setFileName(relativeFileName);
        if (Zip4jUtil.isStringNotNullAndNotEmpty(this.zipModel.getFileNameCharset())) {
            this.fileHeader.setFileNameLength(Zip4jUtil.getEncodedStringLength(relativeFileName, this.zipModel.getFileNameCharset()));
        } else {
            this.fileHeader.setFileNameLength(Zip4jUtil.getEncodedStringLength(relativeFileName));
        }
        OutputStream outputStream = this.outputStream;
        if (outputStream instanceof SplitOutputStream) {
            this.fileHeader.setDiskNumberStart(((SplitOutputStream) outputStream).getCurrSplitFileCounter());
        } else {
            this.fileHeader.setDiskNumberStart(0);
        }
        this.fileHeader.setExternalFileAttr(new byte[]{(byte) (!this.zipParameters.isSourceExternalStream() ? getFileAttributes(this.sourceFile) : 0), 0, 0, 0});
        if (this.zipParameters.isSourceExternalStream()) {
            this.fileHeader.setDirectory(relativeFileName.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR) || relativeFileName.endsWith("\\"));
        } else {
            this.fileHeader.setDirectory(this.sourceFile.isDirectory());
        }
        if (this.fileHeader.isDirectory()) {
            this.fileHeader.setCompressedSize(0L);
            this.fileHeader.setUncompressedSize(0L);
        } else if (!this.zipParameters.isSourceExternalStream()) {
            long fileLengh = Zip4jUtil.getFileLengh(this.sourceFile);
            if (this.zipParameters.getCompressionMethod() == 0) {
                if (this.zipParameters.getEncryptionMethod() == 0) {
                    this.fileHeader.setCompressedSize(12 + fileLengh);
                } else if (this.zipParameters.getEncryptionMethod() == 99) {
                    int aesKeyStrength = this.zipParameters.getAesKeyStrength();
                    if (aesKeyStrength == 1) {
                        i = 8;
                    } else {
                        if (aesKeyStrength != 3) {
                            throw new ZipException("invalid aes key strength, cannot determine key sizes");
                        }
                        i = 16;
                    }
                    this.fileHeader.setCompressedSize(i + fileLengh + 10 + 2);
                } else {
                    this.fileHeader.setCompressedSize(0L);
                }
            } else {
                this.fileHeader.setCompressedSize(0L);
            }
            this.fileHeader.setUncompressedSize(fileLengh);
        }
        if (this.zipParameters.isEncryptFiles() && this.zipParameters.getEncryptionMethod() == 0) {
            this.fileHeader.setCrc32(this.zipParameters.getSourceFileCRC());
        }
        byte[] bArr = new byte[2];
        bArr[0] = Raw.bitArrayToByte(generateGeneralPurposeBitArray(this.fileHeader.isEncrypted(), this.zipParameters.getCompressionMethod()));
        boolean isStringNotNullAndNotEmpty = Zip4jUtil.isStringNotNullAndNotEmpty(this.zipModel.getFileNameCharset());
        if (!(isStringNotNullAndNotEmpty && this.zipModel.getFileNameCharset().equalsIgnoreCase(InternalZipConstants.CHARSET_UTF8)) && (isStringNotNullAndNotEmpty || !Zip4jUtil.detectCharSet(this.fileHeader.getFileName()).equals(InternalZipConstants.CHARSET_UTF8))) {
            bArr[1] = 0;
        } else {
            bArr[1] = 8;
        }
        this.fileHeader.setGeneralPurposeFlag(bArr);
    }

    private void createLocalFileHeader() throws ZipException {
        if (this.fileHeader == null) {
            throw new ZipException("file header is null, cannot create local file header");
        }
        LocalFileHeader localFileHeader = new LocalFileHeader();
        this.localFileHeader = localFileHeader;
        localFileHeader.setSignature(67324752);
        this.localFileHeader.setVersionNeededToExtract(this.fileHeader.getVersionNeededToExtract());
        this.localFileHeader.setCompressionMethod(this.fileHeader.getCompressionMethod());
        this.localFileHeader.setLastModFileTime(this.fileHeader.getLastModFileTime());
        this.localFileHeader.setUncompressedSize(this.fileHeader.getUncompressedSize());
        this.localFileHeader.setFileNameLength(this.fileHeader.getFileNameLength());
        this.localFileHeader.setFileName(this.fileHeader.getFileName());
        this.localFileHeader.setEncrypted(this.fileHeader.isEncrypted());
        this.localFileHeader.setEncryptionMethod(this.fileHeader.getEncryptionMethod());
        this.localFileHeader.setAesExtraDataRecord(this.fileHeader.getAesExtraDataRecord());
        this.localFileHeader.setCrc32(this.fileHeader.getCrc32());
        this.localFileHeader.setCompressedSize(this.fileHeader.getCompressedSize());
        this.localFileHeader.setGeneralPurposeFlag((byte[]) this.fileHeader.getGeneralPurposeFlag().clone());
    }

    private int getFileAttributes(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("input file is null, cannot get file attributes");
        }
        if (!file.exists()) {
            return 0;
        }
        if (file.isDirectory()) {
            return file.isHidden() ? 18 : 16;
        }
        if (!file.canWrite() && file.isHidden()) {
            return 3;
        }
        if (file.canWrite()) {
            return file.isHidden() ? 2 : 0;
        }
        return 1;
    }

    private AESExtraDataRecord generateAESExtraDataRecord(ZipParameters zipParameters) throws ZipException {
        if (zipParameters == null) {
            throw new ZipException("zip parameters are null, cannot generate AES Extra Data record");
        }
        AESExtraDataRecord aESExtraDataRecord = new AESExtraDataRecord();
        aESExtraDataRecord.setSignature(39169L);
        aESExtraDataRecord.setDataSize(7);
        aESExtraDataRecord.setVendorID("AE");
        aESExtraDataRecord.setVersionNumber(2);
        if (zipParameters.getAesKeyStrength() == 1) {
            aESExtraDataRecord.setAesStrength(1);
        } else if (zipParameters.getAesKeyStrength() == 3) {
            aESExtraDataRecord.setAesStrength(3);
        } else {
            throw new ZipException("invalid AES key strength, cannot generate AES Extra data record");
        }
        aESExtraDataRecord.setCompressionMethod(zipParameters.getCompressionMethod());
        return aESExtraDataRecord;
    }

    public void decrementCompressedFileSize(int i) {
        if (i <= 0) {
            return;
        }
        long j = i;
        long j2 = this.bytesWrittenForThisFile;
        if (j <= j2) {
            this.bytesWrittenForThisFile = j2 - j;
        }
    }

    protected void updateTotalBytesRead(int i) {
        if (i > 0) {
            this.totalBytesRead += i;
        }
    }

    public void setSourceFile(File file) {
        this.sourceFile = file;
    }

    public File getSourceFile() {
        return this.sourceFile;
    }
}
