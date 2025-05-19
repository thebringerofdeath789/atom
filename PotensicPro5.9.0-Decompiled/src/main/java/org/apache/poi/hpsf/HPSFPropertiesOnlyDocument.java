package org.apache.poi.hpsf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import org.apache.poi.POIDocument;
import org.apache.poi.poifs.filesystem.EntryUtils;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* loaded from: classes4.dex */
public class HPSFPropertiesOnlyDocument extends POIDocument {
    public HPSFPropertiesOnlyDocument(NPOIFSFileSystem nPOIFSFileSystem) {
        super(nPOIFSFileSystem.getRoot());
    }

    public HPSFPropertiesOnlyDocument(POIFSFileSystem pOIFSFileSystem) {
        super(pOIFSFileSystem);
    }

    @Override // org.apache.poi.POIDocument
    public void write(OutputStream outputStream) throws IOException {
        POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem();
        ArrayList arrayList = new ArrayList(1);
        writeProperties(pOIFSFileSystem, arrayList);
        EntryUtils.copyNodes(this.directory, pOIFSFileSystem.getRoot(), arrayList);
        pOIFSFileSystem.writeFilesystem(outputStream);
    }
}
