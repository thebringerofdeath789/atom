package org.apache.poi.hssf.eventusermodel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import jxl.biff.BaseCompoundFile;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordFactoryInputStream;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* loaded from: classes4.dex */
public class HSSFEventFactory {
    public void processWorkbookEvents(HSSFRequest hSSFRequest, POIFSFileSystem pOIFSFileSystem) throws IOException {
        processWorkbookEvents(hSSFRequest, pOIFSFileSystem.getRoot());
    }

    public void processWorkbookEvents(HSSFRequest hSSFRequest, DirectoryNode directoryNode) throws IOException {
        Set<String> entryNames = directoryNode.getEntryNames();
        String str = BaseCompoundFile.WORKBOOK_NAME;
        if (!entryNames.contains(BaseCompoundFile.WORKBOOK_NAME)) {
            if (entryNames.contains("WORKBOOK")) {
                str = "WORKBOOK";
            } else if (entryNames.contains("BOOK")) {
                str = "BOOK";
            }
        }
        processEvents(hSSFRequest, directoryNode.createDocumentInputStream(str));
    }

    public short abortableProcessWorkbookEvents(HSSFRequest hSSFRequest, POIFSFileSystem pOIFSFileSystem) throws IOException, HSSFUserException {
        return abortableProcessWorkbookEvents(hSSFRequest, pOIFSFileSystem.getRoot());
    }

    public short abortableProcessWorkbookEvents(HSSFRequest hSSFRequest, DirectoryNode directoryNode) throws IOException, HSSFUserException {
        return abortableProcessEvents(hSSFRequest, directoryNode.createDocumentInputStream(BaseCompoundFile.WORKBOOK_NAME));
    }

    public void processEvents(HSSFRequest hSSFRequest, InputStream inputStream) {
        try {
            genericProcessEvents(hSSFRequest, inputStream);
        } catch (HSSFUserException unused) {
        }
    }

    public short abortableProcessEvents(HSSFRequest hSSFRequest, InputStream inputStream) throws HSSFUserException {
        return genericProcessEvents(hSSFRequest, inputStream);
    }

    private short genericProcessEvents(HSSFRequest hSSFRequest, InputStream inputStream) throws HSSFUserException {
        short s = 0;
        RecordFactoryInputStream recordFactoryInputStream = new RecordFactoryInputStream(inputStream, false);
        do {
            Record nextRecord = recordFactoryInputStream.nextRecord();
            if (nextRecord == null) {
                break;
            }
            s = hSSFRequest.processRecord(nextRecord);
        } while (s == 0);
        return s;
    }
}
