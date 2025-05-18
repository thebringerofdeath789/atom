package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Encoder;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class ImageVideoWrapperEncoder implements Encoder<ImageVideoWrapper> {
    private final Encoder<ParcelFileDescriptor> fileDescriptorEncoder;

    /* renamed from: id */
    private String f1811id;
    private final Encoder<InputStream> streamEncoder;

    public ImageVideoWrapperEncoder(Encoder<InputStream> encoder, Encoder<ParcelFileDescriptor> encoder2) {
        this.streamEncoder = encoder;
        this.fileDescriptorEncoder = encoder2;
    }

    @Override // com.bumptech.glide.load.Encoder
    public boolean encode(ImageVideoWrapper imageVideoWrapper, OutputStream outputStream) {
        if (imageVideoWrapper.getStream() != null) {
            return this.streamEncoder.encode(imageVideoWrapper.getStream(), outputStream);
        }
        return this.fileDescriptorEncoder.encode(imageVideoWrapper.getFileDescriptor(), outputStream);
    }

    @Override // com.bumptech.glide.load.Encoder
    public String getId() {
        if (this.f1811id == null) {
            this.f1811id = this.streamEncoder.getId() + this.fileDescriptorEncoder.getId();
        }
        return this.f1811id;
    }
}