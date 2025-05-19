package org.apache.poi.poifs.filesystem;

/* loaded from: classes5.dex */
public interface Entry {
    boolean delete();

    String getName();

    DirectoryEntry getParent();

    boolean isDirectoryEntry();

    boolean isDocumentEntry();

    boolean renameTo(String str);
}
