package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.UUID;

/* loaded from: classes.dex */
public final class PsshAtomUtil {
    private static final String TAG = "PsshAtomUtil";

    private PsshAtomUtil() {
    }

    public static byte[] buildPsshAtom(UUID uuid, byte[] bArr) {
        return buildPsshAtom(uuid, null, bArr);
    }

    public static byte[] buildPsshAtom(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(Atom.TYPE_pssh);
        allocate.putInt(uuidArr != null ? 16777216 : 0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            allocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr != null && bArr.length != 0) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static boolean isPsshAtom(byte[] bArr) {
        return parsePsshAtom(bArr) != null;
    }

    public static UUID parseUuid(byte[] bArr) {
        PsshAtom parsePsshAtom = parsePsshAtom(bArr);
        if (parsePsshAtom == null) {
            return null;
        }
        return parsePsshAtom.uuid;
    }

    public static int parseVersion(byte[] bArr) {
        PsshAtom parsePsshAtom = parsePsshAtom(bArr);
        if (parsePsshAtom == null) {
            return -1;
        }
        return parsePsshAtom.version;
    }

    public static byte[] parseSchemeSpecificData(byte[] bArr, UUID uuid) {
        PsshAtom parsePsshAtom = parsePsshAtom(bArr);
        if (parsePsshAtom == null) {
            return null;
        }
        if (!uuid.equals(parsePsshAtom.uuid)) {
            String valueOf = String.valueOf(uuid);
            String valueOf2 = String.valueOf(parsePsshAtom.uuid);
            Log.w(TAG, new StringBuilder(String.valueOf(valueOf).length() + 33 + String.valueOf(valueOf2).length()).append("UUID mismatch. Expected: ").append(valueOf).append(", got: ").append(valueOf2).append(".").toString());
            return null;
        }
        return parsePsshAtom.schemeData;
    }

    private static PsshAtom parsePsshAtom(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        if (parsableByteArray.limit() < 32) {
            return null;
        }
        parsableByteArray.setPosition(0);
        if (parsableByteArray.readInt() != parsableByteArray.bytesLeft() + 4 || parsableByteArray.readInt() != 1886614376) {
            return null;
        }
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        if (parseFullAtomVersion > 1) {
            Log.w(TAG, new StringBuilder(37).append("Unsupported pssh version: ").append(parseFullAtomVersion).toString());
            return null;
        }
        UUID uuid = new UUID(parsableByteArray.readLong(), parsableByteArray.readLong());
        if (parseFullAtomVersion == 1) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedIntToInt() * 16);
        }
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt != parsableByteArray.bytesLeft()) {
            return null;
        }
        byte[] bArr2 = new byte[readUnsignedIntToInt];
        parsableByteArray.readBytes(bArr2, 0, readUnsignedIntToInt);
        return new PsshAtom(uuid, parseFullAtomVersion, bArr2);
    }

    private static class PsshAtom {
        private final byte[] schemeData;
        private final UUID uuid;
        private final int version;

        public PsshAtom(UUID uuid, int i, byte[] bArr) {
            this.uuid = uuid;
            this.version = i;
            this.schemeData = bArr;
        }
    }
}
