package org.apache.poi.poifs.dev;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.DocumentNode;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* loaded from: classes5.dex */
public class POIFSDump {
    public static void main(String[] strArr) throws Exception {
        for (int i = 0; i < strArr.length; i++) {
            System.out.println("Dumping " + strArr[i]);
            FileInputStream fileInputStream = new FileInputStream(strArr[i]);
            POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem(fileInputStream);
            fileInputStream.close();
            DirectoryNode root = pOIFSFileSystem.getRoot();
            File file = new File(root.getName());
            file.mkdir();
            dump(root, file);
        }
    }

    public static void dump(DirectoryEntry directoryEntry, File file) throws IOException {
        Iterator<Entry> entries = directoryEntry.getEntries();
        while (entries.hasNext()) {
            Entry next = entries.next();
            if (next instanceof DocumentNode) {
                DocumentNode documentNode = (DocumentNode) next;
                DocumentInputStream documentInputStream = new DocumentInputStream(documentNode);
                byte[] bArr = new byte[documentNode.getSize()];
                documentInputStream.read(bArr);
                documentInputStream.close();
                FileOutputStream fileOutputStream = new FileOutputStream(new File(file, documentNode.getName().trim()));
                try {
                    fileOutputStream.write(bArr);
                } finally {
                    fileOutputStream.close();
                }
            } else if (next instanceof DirectoryEntry) {
                File file2 = new File(file, next.getName());
                file2.mkdir();
                dump((DirectoryEntry) next, file2);
            } else {
                System.err.println("Skipping unsupported POIFS entry: " + next);
            }
        }
    }
}
