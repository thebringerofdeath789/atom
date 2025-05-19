package net.lingala.zip4j.io;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;

/* loaded from: classes4.dex */
public class DeflaterOutputStream extends CipherOutputStream {
    private byte[] buff;
    protected Deflater deflater;
    private boolean firstBytesRead;

    public DeflaterOutputStream(OutputStream outputStream, ZipModel zipModel) {
        super(outputStream, zipModel);
        this.deflater = new Deflater();
        this.buff = new byte[4096];
        this.firstBytesRead = false;
    }

    @Override // net.lingala.zip4j.io.CipherOutputStream
    public void putNextEntry(File file, ZipParameters zipParameters) throws ZipException {
        super.putNextEntry(file, zipParameters);
        if (zipParameters.getCompressionMethod() == 8) {
            this.deflater.reset();
            if ((zipParameters.getCompressionLevel() < 0 || zipParameters.getCompressionLevel() > 9) && zipParameters.getCompressionLevel() != -1) {
                throw new ZipException("invalid compression level for deflater. compression level should be in the range of 0-9");
            }
            this.deflater.setLevel(zipParameters.getCompressionLevel());
        }
    }

    @Override // net.lingala.zip4j.io.CipherOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    private void deflate() throws IOException {
        Deflater deflater = this.deflater;
        byte[] bArr = this.buff;
        int deflate = deflater.deflate(bArr, 0, bArr.length);
        if (deflate > 0) {
            if (this.deflater.finished()) {
                if (deflate == 4) {
                    return;
                }
                if (deflate < 4) {
                    decrementCompressedFileSize(4 - deflate);
                    return;
                }
                deflate -= 4;
            }
            if (!this.firstBytesRead) {
                super.write(this.buff, 2, deflate - 2);
                this.firstBytesRead = true;
            } else {
                super.write(this.buff, 0, deflate);
            }
        }
    }

    @Override // net.lingala.zip4j.io.CipherOutputStream, net.lingala.zip4j.io.BaseOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // net.lingala.zip4j.io.CipherOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.zipParameters.getCompressionMethod() != 8) {
            super.write(bArr, i, i2);
            return;
        }
        this.deflater.setInput(bArr, i, i2);
        while (!this.deflater.needsInput()) {
            deflate();
        }
    }

    @Override // net.lingala.zip4j.io.CipherOutputStream
    public void closeEntry() throws IOException, ZipException {
        if (this.zipParameters.getCompressionMethod() == 8) {
            if (!this.deflater.finished()) {
                this.deflater.finish();
                while (!this.deflater.finished()) {
                    deflate();
                }
            }
            this.firstBytesRead = false;
        }
        super.closeEntry();
    }

    @Override // net.lingala.zip4j.io.CipherOutputStream
    public void finish() throws IOException, ZipException {
        super.finish();
    }
}
