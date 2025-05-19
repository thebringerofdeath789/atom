package org.apache.poi.poifs.crypt;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndianInput;

/* loaded from: classes5.dex */
public class EncryptionInfo {
    private final Decryptor decryptor;
    private final int encryptionFlags;
    private final Encryptor encryptor;
    private final EncryptionHeader header;
    private final EncryptionVerifier verifier;
    private final int versionMajor;
    private final int versionMinor;
    public static BitField flagCryptoAPI = BitFieldFactory.getInstance(4);
    public static BitField flagDocProps = BitFieldFactory.getInstance(8);
    public static BitField flagExternal = BitFieldFactory.getInstance(16);
    public static BitField flagAES = BitFieldFactory.getInstance(32);

    public EncryptionInfo(POIFSFileSystem pOIFSFileSystem) throws IOException {
        this(pOIFSFileSystem.getRoot());
    }

    public EncryptionInfo(NPOIFSFileSystem nPOIFSFileSystem) throws IOException {
        this(nPOIFSFileSystem.getRoot());
    }

    public EncryptionInfo(DirectoryNode directoryNode) throws IOException {
        this((LittleEndianInput) directoryNode.createDocumentInputStream("EncryptionInfo"), false);
    }

    public EncryptionInfo(LittleEndianInput littleEndianInput, boolean z) throws IOException {
        EncryptionMode encryptionMode;
        short readShort = littleEndianInput.readShort();
        this.versionMajor = readShort;
        short readShort2 = littleEndianInput.readShort();
        this.versionMinor = readShort2;
        if (!z && readShort == EncryptionMode.binaryRC4.versionMajor && readShort2 == EncryptionMode.binaryRC4.versionMinor) {
            encryptionMode = EncryptionMode.binaryRC4;
            this.encryptionFlags = -1;
        } else if (!z && readShort == EncryptionMode.agile.versionMajor && readShort2 == EncryptionMode.agile.versionMinor) {
            encryptionMode = EncryptionMode.agile;
            this.encryptionFlags = littleEndianInput.readInt();
        } else if (!z && 2 <= readShort && readShort <= 4 && readShort2 == EncryptionMode.standard.versionMinor) {
            encryptionMode = EncryptionMode.standard;
            this.encryptionFlags = littleEndianInput.readInt();
        } else if (z && 2 <= readShort && readShort <= 4 && readShort2 == EncryptionMode.cryptoAPI.versionMinor) {
            encryptionMode = EncryptionMode.cryptoAPI;
            this.encryptionFlags = littleEndianInput.readInt();
        } else {
            int readInt = littleEndianInput.readInt();
            this.encryptionFlags = readInt;
            throw new EncryptedDocumentException("Unknown encryption: version major: " + ((int) readShort) + " / version minor: " + ((int) readShort2) + " / fCrypto: " + flagCryptoAPI.isSet(readInt) + " / fExternal: " + flagExternal.isSet(readInt) + " / fDocProps: " + flagDocProps.isSet(readInt) + " / fAES: " + flagAES.isSet(readInt));
        }
        try {
            EncryptionInfoBuilder builder = getBuilder(encryptionMode);
            builder.initialize(this, littleEndianInput);
            this.header = builder.getHeader();
            this.verifier = builder.getVerifier();
            this.decryptor = builder.getDecryptor();
            this.encryptor = builder.getEncryptor();
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    @Deprecated
    public EncryptionInfo(POIFSFileSystem pOIFSFileSystem, EncryptionMode encryptionMode) {
        this(encryptionMode);
    }

    @Deprecated
    public EncryptionInfo(NPOIFSFileSystem nPOIFSFileSystem, EncryptionMode encryptionMode) {
        this(encryptionMode);
    }

    @Deprecated
    public EncryptionInfo(DirectoryNode directoryNode, EncryptionMode encryptionMode) {
        this(encryptionMode);
    }

    @Deprecated
    public EncryptionInfo(POIFSFileSystem pOIFSFileSystem, EncryptionMode encryptionMode, CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i, int i2, ChainingMode chainingMode) {
        this(encryptionMode, cipherAlgorithm, hashAlgorithm, i, i2, chainingMode);
    }

    @Deprecated
    public EncryptionInfo(NPOIFSFileSystem nPOIFSFileSystem, EncryptionMode encryptionMode, CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i, int i2, ChainingMode chainingMode) {
        this(encryptionMode, cipherAlgorithm, hashAlgorithm, i, i2, chainingMode);
    }

    @Deprecated
    public EncryptionInfo(DirectoryNode directoryNode, EncryptionMode encryptionMode, CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i, int i2, ChainingMode chainingMode) {
        this(encryptionMode, cipherAlgorithm, hashAlgorithm, i, i2, chainingMode);
    }

    public EncryptionInfo(EncryptionMode encryptionMode) {
        this(encryptionMode, null, null, -1, -1, null);
    }

    public EncryptionInfo(EncryptionMode encryptionMode, CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i, int i2, ChainingMode chainingMode) {
        this.versionMajor = encryptionMode.versionMajor;
        this.versionMinor = encryptionMode.versionMinor;
        this.encryptionFlags = encryptionMode.encryptionFlags;
        try {
            EncryptionInfoBuilder builder = getBuilder(encryptionMode);
            builder.initialize(this, cipherAlgorithm, hashAlgorithm, i, i2, chainingMode);
            this.header = builder.getHeader();
            this.verifier = builder.getVerifier();
            this.decryptor = builder.getDecryptor();
            this.encryptor = builder.getEncryptor();
        } catch (Exception e) {
            throw new EncryptedDocumentException(e);
        }
    }

    protected static EncryptionInfoBuilder getBuilder(EncryptionMode encryptionMode) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (EncryptionInfoBuilder) Thread.currentThread().getContextClassLoader().loadClass(encryptionMode.builder).newInstance();
    }

    public int getVersionMajor() {
        return this.versionMajor;
    }

    public int getVersionMinor() {
        return this.versionMinor;
    }

    public int getEncryptionFlags() {
        return this.encryptionFlags;
    }

    public EncryptionHeader getHeader() {
        return this.header;
    }

    public EncryptionVerifier getVerifier() {
        return this.verifier;
    }

    public Decryptor getDecryptor() {
        return this.decryptor;
    }

    public Encryptor getEncryptor() {
        return this.encryptor;
    }
}
