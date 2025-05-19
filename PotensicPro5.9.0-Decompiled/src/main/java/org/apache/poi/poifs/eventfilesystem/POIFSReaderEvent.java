package org.apache.poi.poifs.eventfilesystem;

import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.POIFSDocumentPath;

/* loaded from: classes5.dex */
public class POIFSReaderEvent {
    private String documentName;
    private POIFSDocumentPath path;
    private DocumentInputStream stream;

    POIFSReaderEvent(DocumentInputStream documentInputStream, POIFSDocumentPath pOIFSDocumentPath, String str) {
        this.stream = documentInputStream;
        this.path = pOIFSDocumentPath;
        this.documentName = str;
    }

    public DocumentInputStream getStream() {
        return this.stream;
    }

    public POIFSDocumentPath getPath() {
        return this.path;
    }

    public String getName() {
        return this.documentName;
    }
}
