package net.lingala.zip4j.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Raw;
import net.lingala.zip4j.util.Zip4jUtil;

/* loaded from: classes4.dex */
public class SplitOutputStream extends OutputStream {
    private long bytesWrittenForThisPart;
    private int currSplitFileCounter;
    private File outFile;
    private RandomAccessFile raf;
    private long splitLength;
    private File zipFile;

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
    }

    public SplitOutputStream(String str) throws FileNotFoundException, ZipException {
        this(Zip4jUtil.isStringNotNullAndNotEmpty(str) ? new File(str) : null);
    }

    public SplitOutputStream(File file) throws FileNotFoundException, ZipException {
        this(file, -1L);
    }

    public SplitOutputStream(String str, long j) throws FileNotFoundException, ZipException {
        this(!Zip4jUtil.isStringNotNullAndNotEmpty(str) ? new File(str) : null, j);
    }

    public SplitOutputStream(File file, long j) throws FileNotFoundException, ZipException {
        if (j >= 0 && j < 65536) {
            throw new ZipException("split length less than minimum allowed split length of 65536 Bytes");
        }
        this.raf = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
        this.splitLength = j;
        this.outFile = file;
        this.zipFile = file;
        this.currSplitFileCounter = 0;
        this.bytesWrittenForThisPart = 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i2 <= 0) {
            return;
        }
        long j = this.splitLength;
        if (j == -1) {
            this.raf.write(bArr, i, i2);
            this.bytesWrittenForThisPart += i2;
            return;
        }
        if (j < 65536) {
            throw new IOException("split length less than minimum allowed split length of 65536 Bytes");
        }
        long j2 = this.bytesWrittenForThisPart;
        if (j2 >= j) {
            startNextSplitFile();
            this.raf.write(bArr, i, i2);
            this.bytesWrittenForThisPart = i2;
            return;
        }
        long j3 = i2;
        if (j2 + j3 > j) {
            if (isHeaderData(bArr)) {
                startNextSplitFile();
                this.raf.write(bArr, i, i2);
                this.bytesWrittenForThisPart = j3;
                return;
            }
            this.raf.write(bArr, i, (int) (this.splitLength - this.bytesWrittenForThisPart));
            startNextSplitFile();
            RandomAccessFile randomAccessFile = this.raf;
            long j4 = this.splitLength;
            long j5 = this.bytesWrittenForThisPart;
            randomAccessFile.write(bArr, i + ((int) (j4 - j5)), (int) (j3 - (j4 - j5)));
            this.bytesWrittenForThisPart = j3 - (this.splitLength - this.bytesWrittenForThisPart);
            return;
        }
        this.raf.write(bArr, i, i2);
        this.bytesWrittenForThisPart += j3;
    }

    private void startNextSplitFile() throws IOException {
        File file;
        try {
            String zipFileNameWithoutExt = Zip4jUtil.getZipFileNameWithoutExt(this.outFile.getName());
            String absolutePath = this.zipFile.getAbsolutePath();
            String str = this.outFile.getParent() == null ? "" : this.outFile.getParent() + System.getProperty("file.separator");
            if (this.currSplitFileCounter < 9) {
                file = new File(str + zipFileNameWithoutExt + ".z0" + (this.currSplitFileCounter + 1));
            } else {
                file = new File(str + zipFileNameWithoutExt + ".z" + (this.currSplitFileCounter + 1));
            }
            this.raf.close();
            if (file.exists()) {
                throw new IOException("split file: " + file.getName() + " already exists in the current directory, cannot rename this file");
            }
            if (!this.zipFile.renameTo(file)) {
                throw new IOException("cannot rename newly created split file");
            }
            this.zipFile = new File(absolutePath);
            this.raf = new RandomAccessFile(this.zipFile, InternalZipConstants.WRITE_MODE);
            this.currSplitFileCounter++;
        } catch (ZipException e) {
            throw new IOException(e.getMessage());
        }
    }

    private boolean isHeaderData(byte[] bArr) {
        if (bArr != null && bArr.length >= 4) {
            int readIntLittleEndian = Raw.readIntLittleEndian(bArr, 0);
            long[] allHeaderSignatures = Zip4jUtil.getAllHeaderSignatures();
            if (allHeaderSignatures != null && allHeaderSignatures.length > 0) {
                for (int i = 0; i < allHeaderSignatures.length; i++) {
                    if (allHeaderSignatures[i] != 134695760 && allHeaderSignatures[i] == readIntLittleEndian) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkBuffSizeAndStartNextSplitFile(int i) throws ZipException {
        if (i < 0) {
            throw new ZipException("negative buffersize for checkBuffSizeAndStartNextSplitFile");
        }
        if (isBuffSizeFitForCurrSplitFile(i)) {
            return false;
        }
        try {
            startNextSplitFile();
            this.bytesWrittenForThisPart = 0L;
            return true;
        } catch (IOException e) {
            throw new ZipException(e);
        }
    }

    public boolean isBuffSizeFitForCurrSplitFile(int i) throws ZipException {
        if (i < 0) {
            throw new ZipException("negative buffersize for isBuffSizeFitForCurrSplitFile");
        }
        long j = this.splitLength;
        return j < 65536 || this.bytesWrittenForThisPart + ((long) i) <= j;
    }

    public void seek(long j) throws IOException {
        this.raf.seek(j);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        RandomAccessFile randomAccessFile = this.raf;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }

    public long getFilePointer() throws IOException {
        return this.raf.getFilePointer();
    }

    public boolean isSplitZipFile() {
        return this.splitLength != -1;
    }

    public long getSplitLength() {
        return this.splitLength;
    }

    public int getCurrSplitFileCounter() {
        return this.currSplitFileCounter;
    }
}
