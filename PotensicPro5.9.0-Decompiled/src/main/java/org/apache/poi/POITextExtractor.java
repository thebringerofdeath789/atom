package org.apache.poi;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class POITextExtractor implements Closeable {
    protected POIDocument document;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public abstract POITextExtractor getMetadataTextExtractor();

    public abstract String getText();

    public POITextExtractor(POIDocument pOIDocument) {
        this.document = pOIDocument;
    }

    protected POITextExtractor(POITextExtractor pOITextExtractor) {
        this.document = pOITextExtractor.document;
    }
}
