package org.apache.poi.hssf.extractor;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hssf.OldExcelFormatException;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.CodepageRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.OldFormulaRecord;
import org.apache.poi.hssf.record.OldLabelRecord;
import org.apache.poi.hssf.record.OldSheetRecord;
import org.apache.poi.hssf.record.OldStringRecord;
import org.apache.poi.hssf.record.RKRecord;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentNode;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.NotOLE2FileException;

/* loaded from: classes4.dex */
public class OldExcelExtractor {
    private int biffVersion;
    private int fileType;
    private Closeable input;
    private RecordInputStream ris;

    public OldExcelExtractor(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 8);
        if (NPOIFSFileSystem.hasPOIFSHeader(bufferedInputStream)) {
            open(new NPOIFSFileSystem(bufferedInputStream));
        } else {
            open(bufferedInputStream);
        }
    }

    public OldExcelExtractor(File file) throws IOException {
        try {
            open(new NPOIFSFileSystem(file));
        } catch (OldExcelFormatException unused) {
            open(new FileInputStream(file));
        } catch (NotOLE2FileException unused2) {
            open(new FileInputStream(file));
        }
    }

    public OldExcelExtractor(NPOIFSFileSystem nPOIFSFileSystem) throws IOException {
        open(nPOIFSFileSystem);
    }

    public OldExcelExtractor(DirectoryNode directoryNode) throws IOException {
        open(directoryNode);
    }

    private void open(InputStream inputStream) {
        this.input = inputStream;
        this.ris = new RecordInputStream(inputStream);
        prepare();
    }

    private void open(NPOIFSFileSystem nPOIFSFileSystem) throws IOException {
        this.input = nPOIFSFileSystem;
        open(nPOIFSFileSystem.getRoot());
    }

    private void open(DirectoryNode directoryNode) throws IOException {
        DocumentNode documentNode = (DocumentNode) directoryNode.getEntry("Book");
        if (documentNode == null) {
            throw new IOException("No Excel 5/95 Book stream found");
        }
        this.ris = new RecordInputStream(directoryNode.createDocumentInputStream(documentNode));
        prepare();
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length < 1) {
            System.err.println("Use:");
            System.err.println("   OldExcelExtractor <filename>");
            System.exit(1);
        }
        System.out.println(new OldExcelExtractor(new File(strArr[0])).getText());
    }

    private void prepare() {
        if (!this.ris.hasNextRecord()) {
            throw new IllegalArgumentException("File contains no records!");
        }
        this.ris.nextRecord();
        short sid = this.ris.getSid();
        if (sid == 9) {
            this.biffVersion = 2;
        } else if (sid == 521) {
            this.biffVersion = 3;
        } else if (sid == 1033) {
            this.biffVersion = 4;
        } else if (sid == 2057) {
            this.biffVersion = 5;
        } else {
            throw new IllegalArgumentException("File does not begin with a BOF, found sid of " + ((int) sid));
        }
        this.fileType = new BOFRecord(this.ris).getType();
    }

    public int getBiffVersion() {
        return this.biffVersion;
    }

    public int getFileType() {
        return this.fileType;
    }

    public String getText() {
        StringBuffer stringBuffer = new StringBuffer();
        CodepageRecord codepageRecord = null;
        while (this.ris.hasNextRecord()) {
            int nextSid = this.ris.getNextSid();
            this.ris.nextRecord();
            if (nextSid != 4) {
                if (nextSid == 66) {
                    codepageRecord = new CodepageRecord(this.ris);
                } else if (nextSid == 133) {
                    OldSheetRecord oldSheetRecord = new OldSheetRecord(this.ris);
                    oldSheetRecord.setCodePage(codepageRecord);
                    stringBuffer.append("Sheet: ");
                    stringBuffer.append(oldSheetRecord.getSheetname());
                    stringBuffer.append('\n');
                } else if (nextSid != 638) {
                    if (nextSid != 1030 && nextSid != 6) {
                        if (nextSid != 7) {
                            if (nextSid == 515) {
                                handleNumericCell(stringBuffer, new NumberRecord(this.ris).getValue());
                            } else if (nextSid != 516) {
                                if (nextSid != 518) {
                                    if (nextSid != 519) {
                                        RecordInputStream recordInputStream = this.ris;
                                        recordInputStream.readFully(new byte[recordInputStream.remaining()]);
                                    }
                                }
                            }
                        }
                        OldStringRecord oldStringRecord = new OldStringRecord(this.ris);
                        oldStringRecord.setCodePage(codepageRecord);
                        stringBuffer.append(oldStringRecord.getString());
                        stringBuffer.append('\n');
                    }
                    if (this.biffVersion == 5) {
                        FormulaRecord formulaRecord = new FormulaRecord(this.ris);
                        if (formulaRecord.getCachedResultType() == 0) {
                            handleNumericCell(stringBuffer, formulaRecord.getValue());
                        }
                    } else {
                        OldFormulaRecord oldFormulaRecord = new OldFormulaRecord(this.ris);
                        if (oldFormulaRecord.getCachedResultType() == 0) {
                            handleNumericCell(stringBuffer, oldFormulaRecord.getValue());
                        }
                    }
                } else {
                    handleNumericCell(stringBuffer, new RKRecord(this.ris).getRKNumber());
                }
            }
            OldLabelRecord oldLabelRecord = new OldLabelRecord(this.ris);
            oldLabelRecord.setCodePage(codepageRecord);
            stringBuffer.append(oldLabelRecord.getValue());
            stringBuffer.append('\n');
        }
        Closeable closeable = this.input;
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
            this.input = null;
        }
        this.ris = null;
        return stringBuffer.toString();
    }

    protected void handleNumericCell(StringBuffer stringBuffer, double d) {
        stringBuffer.append(d);
        stringBuffer.append('\n');
    }
}
