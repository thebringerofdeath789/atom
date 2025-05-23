package org.apache.poi.poifs.crypt;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import javax.crypto.SecretKey;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* loaded from: classes5.dex */
public abstract class Decryptor {
    public static final String DEFAULT_PASSWORD = "VelvetSweatshop";
    public static final String DEFAULT_POIFS_ENTRY = "EncryptedPackage";
    protected final EncryptionInfoBuilder builder;
    private byte[] integrityHmacKey;
    private byte[] integrityHmacValue;
    private SecretKey secretKey;
    private byte[] verifier;

    public abstract InputStream getDataStream(DirectoryNode directoryNode) throws IOException, GeneralSecurityException;

    public abstract long getLength();

    public abstract boolean verifyPassword(String str) throws GeneralSecurityException;

    protected Decryptor(EncryptionInfoBuilder encryptionInfoBuilder) {
        this.builder = encryptionInfoBuilder;
    }

    public static Decryptor getInstance(EncryptionInfo encryptionInfo) {
        Decryptor decryptor = encryptionInfo.getDecryptor();
        if (decryptor != null) {
            return decryptor;
        }
        throw new EncryptedDocumentException("Unsupported version");
    }

    public InputStream getDataStream(NPOIFSFileSystem nPOIFSFileSystem) throws IOException, GeneralSecurityException {
        return getDataStream(nPOIFSFileSystem.getRoot());
    }

    public InputStream getDataStream(POIFSFileSystem pOIFSFileSystem) throws IOException, GeneralSecurityException {
        return getDataStream(pOIFSFileSystem.getRoot());
    }

    public byte[] getVerifier() {
        return this.verifier;
    }

    public SecretKey getSecretKey() {
        return this.secretKey;
    }

    public byte[] getIntegrityHmacKey() {
        return this.integrityHmacKey;
    }

    public byte[] getIntegrityHmacValue() {
        return this.integrityHmacValue;
    }

    protected void setSecretKey(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    protected void setVerifier(byte[] bArr) {
        this.verifier = bArr;
    }

    protected void setIntegrityHmacKey(byte[] bArr) {
        this.integrityHmacKey = bArr;
    }

    protected void setIntegrityHmacValue(byte[] bArr) {
        this.integrityHmacValue = bArr;
    }

    protected int getBlockSizeInBytes() {
        return this.builder.getHeader().getBlockSize();
    }

    protected int getKeySizeInBytes() {
        return this.builder.getHeader().getKeySize() / 8;
    }
}
