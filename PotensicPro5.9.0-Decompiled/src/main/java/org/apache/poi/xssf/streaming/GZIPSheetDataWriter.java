package org.apache.poi.xssf.streaming;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.poi.util.TempFile;
import org.apache.poi.xssf.model.SharedStringsTable;

/* loaded from: classes5.dex */
public class GZIPSheetDataWriter extends SheetDataWriter {
    public GZIPSheetDataWriter() throws IOException {
    }

    public GZIPSheetDataWriter(SharedStringsTable sharedStringsTable) throws IOException {
        super(sharedStringsTable);
    }

    @Override // org.apache.poi.xssf.streaming.SheetDataWriter
    public File createTempFile() throws IOException {
        return TempFile.createTempFile("poi-sxssf-sheet-xml", ".gz");
    }

    @Override // org.apache.poi.xssf.streaming.SheetDataWriter
    public Writer createWriter(File file) throws IOException {
        return new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(file)), "UTF-8");
    }

    @Override // org.apache.poi.xssf.streaming.SheetDataWriter
    public InputStream getWorksheetXMLInputStream() throws IOException {
        return new GZIPInputStream(new FileInputStream(getTempFile()));
    }
}
