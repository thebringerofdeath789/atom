package org.apache.poi.hpsf;

import org.apache.poi.util.Internal;

@Internal
/* loaded from: classes4.dex */
class VersionedStream {
    private IndirectPropertyName _streamName;
    private GUID _versionGuid;

    VersionedStream(byte[] bArr, int i) {
        this._versionGuid = new GUID(bArr, i);
        this._streamName = new IndirectPropertyName(bArr, i + 16);
    }

    int getSize() {
        return this._streamName.getSize() + 16;
    }
}
