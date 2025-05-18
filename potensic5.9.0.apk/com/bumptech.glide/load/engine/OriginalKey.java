package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* loaded from: classes.dex */
class OriginalKey implements Key {

    /* renamed from: id */
    private final String f1810id;
    private final Key signature;

    public OriginalKey(String str, Key key) {
        this.f1810id = str;
        this.signature = key;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OriginalKey originalKey = (OriginalKey) obj;
        return this.f1810id.equals(originalKey.f1810id) && this.signature.equals(originalKey.signature);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (this.f1810id.hashCode() * 31) + this.signature.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.f1810id.getBytes("UTF-8"));
        this.signature.updateDiskCacheKey(messageDigest);
    }
}