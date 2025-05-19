package org.apache.poi.poifs.filesystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.util.Internal;

@Internal
/* loaded from: classes5.dex */
public class EntryUtils {
    @Internal
    public static void copyNodeRecursively(Entry entry, DirectoryEntry directoryEntry) throws IOException {
        if (entry.isDirectoryEntry()) {
            DirectoryEntry directoryEntry2 = (DirectoryEntry) entry;
            DirectoryEntry createDirectory = directoryEntry.createDirectory(entry.getName());
            createDirectory.setStorageClsid(directoryEntry2.getStorageClsid());
            Iterator<Entry> entries = directoryEntry2.getEntries();
            while (entries.hasNext()) {
                copyNodeRecursively(entries.next(), createDirectory);
            }
            return;
        }
        DocumentEntry documentEntry = (DocumentEntry) entry;
        DocumentInputStream documentInputStream = new DocumentInputStream(documentEntry);
        directoryEntry.createDocument(documentEntry.getName(), documentInputStream);
        documentInputStream.close();
    }

    public static void copyNodes(DirectoryEntry directoryEntry, DirectoryEntry directoryEntry2) throws IOException {
        Iterator<Entry> it = directoryEntry.iterator();
        while (it.hasNext()) {
            copyNodeRecursively(it.next(), directoryEntry2);
        }
    }

    public static void copyNodes(FilteringDirectoryNode filteringDirectoryNode, FilteringDirectoryNode filteringDirectoryNode2) throws IOException {
        copyNodes((DirectoryEntry) filteringDirectoryNode, (DirectoryEntry) filteringDirectoryNode2);
    }

    public static void copyNodes(DirectoryEntry directoryEntry, DirectoryEntry directoryEntry2, List<String> list) throws IOException {
        Iterator<Entry> entries = directoryEntry.getEntries();
        while (entries.hasNext()) {
            Entry next = entries.next();
            if (!list.contains(next.getName())) {
                copyNodeRecursively(next, directoryEntry2);
            }
        }
    }

    public static void copyNodes(POIFSFileSystem pOIFSFileSystem, POIFSFileSystem pOIFSFileSystem2) throws IOException {
        copyNodes(pOIFSFileSystem.getRoot(), pOIFSFileSystem2.getRoot());
    }

    public static void copyNodes(POIFSFileSystem pOIFSFileSystem, POIFSFileSystem pOIFSFileSystem2, List<String> list) throws IOException {
        copyNodes(new FilteringDirectoryNode(pOIFSFileSystem.getRoot(), list), new FilteringDirectoryNode(pOIFSFileSystem2.getRoot(), list));
    }

    public static boolean areDirectoriesIdentical(DirectoryEntry directoryEntry, DirectoryEntry directoryEntry2) {
        boolean areDocumentsIdentical;
        if (!directoryEntry.getName().equals(directoryEntry2.getName()) || directoryEntry.getEntryCount() != directoryEntry2.getEntryCount()) {
            return false;
        }
        HashMap hashMap = new HashMap();
        for (Entry entry : directoryEntry) {
            String name = entry.getName();
            if (entry.isDirectoryEntry()) {
                hashMap.put(name, -12345);
            } else {
                hashMap.put(name, Integer.valueOf(((DocumentNode) entry).getSize()));
            }
        }
        for (Entry entry2 : directoryEntry2) {
            String name2 = entry2.getName();
            if (!hashMap.containsKey(name2)) {
                return false;
            }
            if ((entry2.isDirectoryEntry() ? -12345 : ((DocumentNode) entry2).getSize()) != ((Integer) hashMap.get(name2)).intValue()) {
                return false;
            }
            hashMap.remove(name2);
        }
        if (!hashMap.isEmpty()) {
            return false;
        }
        for (Entry entry3 : directoryEntry) {
            try {
                Entry entry4 = directoryEntry2.getEntry(entry3.getName());
                if (entry3.isDirectoryEntry()) {
                    areDocumentsIdentical = areDirectoriesIdentical((DirectoryEntry) entry3, (DirectoryEntry) entry4);
                } else {
                    areDocumentsIdentical = areDocumentsIdentical((DocumentEntry) entry3, (DocumentEntry) entry4);
                }
            } catch (FileNotFoundException | IOException unused) {
            }
            if (!areDocumentsIdentical) {
                return false;
            }
        }
        return true;
    }

    public static boolean areDocumentsIdentical(DocumentEntry documentEntry, DocumentEntry documentEntry2) throws IOException {
        DocumentInputStream documentInputStream;
        int read;
        boolean z = false;
        if (!documentEntry.getName().equals(documentEntry2.getName()) || documentEntry.getSize() != documentEntry2.getSize()) {
            return false;
        }
        DocumentInputStream documentInputStream2 = null;
        try {
            DocumentInputStream documentInputStream3 = new DocumentInputStream(documentEntry);
            try {
                documentInputStream = new DocumentInputStream(documentEntry2);
                do {
                    try {
                        int read2 = documentInputStream3.read();
                        read = documentInputStream.read();
                        if (read2 != read) {
                            break;
                        }
                        if (read2 == -1) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        documentInputStream2 = documentInputStream3;
                        if (documentInputStream2 != null) {
                            documentInputStream2.close();
                        }
                        if (documentInputStream != null) {
                            documentInputStream.close();
                        }
                        throw th;
                    }
                } while (read != -1);
                z = true;
                documentInputStream3.close();
                documentInputStream.close();
                return z;
            } catch (Throwable th2) {
                th = th2;
                documentInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            documentInputStream = null;
        }
    }
}
