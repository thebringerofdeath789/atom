package org.apache.poi.hssf.dev;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
import org.apache.poi.hssf.eventusermodel.HSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFRequest;
import org.apache.poi.hssf.record.Record;

/* loaded from: classes4.dex */
public class EFBiffViewer {
    String file;

    public void run() throws IOException {
        InputStream pOIFSInputStream = BiffViewer.getPOIFSInputStream(new File(this.file));
        HSSFRequest hSSFRequest = new HSSFRequest();
        hSSFRequest.addListenerForAllRecords(new HSSFListener() { // from class: org.apache.poi.hssf.dev.EFBiffViewer.1
            @Override // org.apache.poi.hssf.eventusermodel.HSSFListener
            public void processRecord(Record record) {
                System.out.println(record.toString());
            }
        });
        new HSSFEventFactory().processEvents(hSSFRequest, pOIFSInputStream);
    }

    public void setFile(String str) {
        this.file = str;
    }

    public static void main(String[] strArr) {
        if (strArr.length == 1 && !strArr[0].equals("--help")) {
            try {
                EFBiffViewer eFBiffViewer = new EFBiffViewer();
                eFBiffViewer.setFile(strArr[0]);
                eFBiffViewer.run();
                return;
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        System.out.println("EFBiffViewer");
        System.out.println("Outputs biffview of records based on HSSFEventFactory");
        System.out.println("usage: java org.apache.poi.hssf.dev.EBBiffViewer filename");
    }
}
