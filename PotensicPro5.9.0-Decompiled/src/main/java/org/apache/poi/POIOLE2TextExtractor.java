package org.apache.poi;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hpsf.extractor.HPSFPropertiesExtractor;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* loaded from: classes.dex */
public abstract class POIOLE2TextExtractor extends POITextExtractor {
    public POIOLE2TextExtractor(POIDocument pOIDocument) {
        super(pOIDocument);
    }

    public DocumentSummaryInformation getDocSummaryInformation() {
        return this.document.getDocumentSummaryInformation();
    }

    public SummaryInformation getSummaryInformation() {
        return this.document.getSummaryInformation();
    }

    @Override // org.apache.poi.POITextExtractor
    public POITextExtractor getMetadataTextExtractor() {
        return new HPSFPropertiesExtractor(this);
    }

    public DirectoryEntry getRoot() {
        return this.document.directory;
    }

    @Deprecated
    public POIFSFileSystem getFileSystem() {
        return this.document.directory.getFileSystem();
    }
}
