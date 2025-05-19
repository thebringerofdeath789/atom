package org.apache.poi.hssf.record;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class FilePassRecord extends StandardRecord {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ENCRYPTION_OTHER = 1;
    private static final int ENCRYPTION_XOR = 0;
    public static final short sid = 47;
    private int _encryptionType;
    private KeyData _keyData;

    private interface KeyData {
        void appendToString(StringBuffer stringBuffer);

        int getDataSize();

        void read(RecordInputStream recordInputStream);

        void serialize(LittleEndianOutput littleEndianOutput);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return this;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 47;
    }

    public static class Rc4KeyData implements KeyData {
        private static final int ENCRYPTION_OTHER_CAPI_2 = 2;
        private static final int ENCRYPTION_OTHER_CAPI_3 = 3;
        private static final int ENCRYPTION_OTHER_CAPI_4 = 4;
        private static final int ENCRYPTION_OTHER_RC4 = 1;
        private byte[] _encryptedVerifier;
        private byte[] _encryptedVerifierHash;
        private int _encryptionInfo;
        private int _minorVersionNo;
        private byte[] _salt;

        @Override // org.apache.poi.hssf.record.FilePassRecord.KeyData
        public int getDataSize() {
            return 54;
        }

        @Override // org.apache.poi.hssf.record.FilePassRecord.KeyData
        public void read(RecordInputStream recordInputStream) {
            int readUShort = recordInputStream.readUShort();
            this._encryptionInfo = readUShort;
            if (readUShort != 1) {
                if (readUShort == 2 || readUShort == 3 || readUShort == 4) {
                    throw new EncryptedDocumentException("HSSF does not currently support CryptoAPI encryption");
                }
                throw new RecordFormatException("Unknown encryption info " + this._encryptionInfo);
            }
            int readUShort2 = recordInputStream.readUShort();
            this._minorVersionNo = readUShort2;
            if (readUShort2 == 1) {
                this._salt = FilePassRecord.read(recordInputStream, 16);
                this._encryptedVerifier = FilePassRecord.read(recordInputStream, 16);
                this._encryptedVerifierHash = FilePassRecord.read(recordInputStream, 16);
                return;
            }
            throw new RecordFormatException("Unexpected VersionInfo number for RC4Header " + this._minorVersionNo);
        }

        @Override // org.apache.poi.hssf.record.FilePassRecord.KeyData
        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this._encryptionInfo);
            littleEndianOutput.writeShort(this._minorVersionNo);
            littleEndianOutput.write(this._salt);
            littleEndianOutput.write(this._encryptedVerifier);
            littleEndianOutput.write(this._encryptedVerifierHash);
        }

        public byte[] getSalt() {
            return (byte[]) this._salt.clone();
        }

        public void setSalt(byte[] bArr) {
            this._salt = (byte[]) bArr.clone();
        }

        public byte[] getEncryptedVerifier() {
            return (byte[]) this._encryptedVerifier.clone();
        }

        public void setEncryptedVerifier(byte[] bArr) {
            this._encryptedVerifier = (byte[]) bArr.clone();
        }

        public byte[] getEncryptedVerifierHash() {
            return (byte[]) this._encryptedVerifierHash.clone();
        }

        public void setEncryptedVerifierHash(byte[] bArr) {
            this._encryptedVerifierHash = (byte[]) bArr.clone();
        }

        @Override // org.apache.poi.hssf.record.FilePassRecord.KeyData
        public void appendToString(StringBuffer stringBuffer) {
            stringBuffer.append("    .rc4.info = ").append(HexDump.shortToHex(this._encryptionInfo)).append("\n");
            stringBuffer.append("    .rc4.ver  = ").append(HexDump.shortToHex(this._minorVersionNo)).append("\n");
            stringBuffer.append("    .rc4.salt = ").append(HexDump.toHex(this._salt)).append("\n");
            stringBuffer.append("    .rc4.verifier = ").append(HexDump.toHex(this._encryptedVerifier)).append("\n");
            stringBuffer.append("    .rc4.verifierHash = ").append(HexDump.toHex(this._encryptedVerifierHash)).append("\n");
        }
    }

    public static class XorKeyData implements KeyData {
        private int _key;
        private int _verifier;

        @Override // org.apache.poi.hssf.record.FilePassRecord.KeyData
        public int getDataSize() {
            return 6;
        }

        @Override // org.apache.poi.hssf.record.FilePassRecord.KeyData
        public void read(RecordInputStream recordInputStream) {
            this._key = recordInputStream.readUShort();
            this._verifier = recordInputStream.readUShort();
        }

        @Override // org.apache.poi.hssf.record.FilePassRecord.KeyData
        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this._key);
            littleEndianOutput.writeShort(this._verifier);
        }

        public int getKey() {
            return this._key;
        }

        public int getVerifier() {
            return this._verifier;
        }

        public void setKey(int i) {
            this._key = i;
        }

        public void setVerifier(int i) {
            this._verifier = i;
        }

        @Override // org.apache.poi.hssf.record.FilePassRecord.KeyData
        public void appendToString(StringBuffer stringBuffer) {
            stringBuffer.append("    .xor.key = ").append(HexDump.intToHex(this._key)).append("\n");
            stringBuffer.append("    .xor.verifier  = ").append(HexDump.intToHex(this._verifier)).append("\n");
        }
    }

    public FilePassRecord(RecordInputStream recordInputStream) {
        int readUShort = recordInputStream.readUShort();
        this._encryptionType = readUShort;
        if (readUShort == 0) {
            this._keyData = new XorKeyData();
        } else if (readUShort == 1) {
            this._keyData = new Rc4KeyData();
        } else {
            throw new RecordFormatException("Unknown encryption type " + this._encryptionType);
        }
        this._keyData.read(recordInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] read(RecordInputStream recordInputStream, int i) {
        byte[] bArr = new byte[i];
        recordInputStream.readFully(bArr);
        return bArr;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._encryptionType);
        this._keyData.serialize(littleEndianOutput);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return this._keyData.getDataSize();
    }

    public Rc4KeyData getRc4KeyData() {
        KeyData keyData = this._keyData;
        if (keyData instanceof Rc4KeyData) {
            return (Rc4KeyData) keyData;
        }
        return null;
    }

    public XorKeyData getXorKeyData() {
        KeyData keyData = this._keyData;
        if (keyData instanceof XorKeyData) {
            return (XorKeyData) keyData;
        }
        return null;
    }

    private Rc4KeyData checkRc4() {
        Rc4KeyData rc4KeyData = getRc4KeyData();
        if (rc4KeyData != null) {
            return rc4KeyData;
        }
        throw new RecordFormatException("file pass record doesn't contain a rc4 key.");
    }

    public byte[] getDocId() {
        return checkRc4().getSalt();
    }

    public void setDocId(byte[] bArr) {
        checkRc4().setSalt(bArr);
    }

    public byte[] getSaltData() {
        return checkRc4().getEncryptedVerifier();
    }

    public void setSaltData(byte[] bArr) {
        getRc4KeyData().setEncryptedVerifier(bArr);
    }

    public byte[] getSaltHash() {
        return getRc4KeyData().getEncryptedVerifierHash();
    }

    public void setSaltHash(byte[] bArr) {
        getRc4KeyData().setEncryptedVerifierHash(bArr);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[FILEPASS]\n");
        stringBuffer.append("    .type = ").append(HexDump.shortToHex(this._encryptionType)).append("\n");
        this._keyData.appendToString(stringBuffer);
        stringBuffer.append("[/FILEPASS]\n");
        return stringBuffer.toString();
    }
}
