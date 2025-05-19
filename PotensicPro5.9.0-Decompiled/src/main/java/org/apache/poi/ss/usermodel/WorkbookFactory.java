package org.apache.poi.ss.usermodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.security.GeneralSecurityException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* loaded from: classes5.dex */
public class WorkbookFactory {
    public static Workbook create(POIFSFileSystem pOIFSFileSystem) throws IOException {
        return new HSSFWorkbook(pOIFSFileSystem);
    }

    public static Workbook create(NPOIFSFileSystem nPOIFSFileSystem) throws IOException {
        try {
            return create(nPOIFSFileSystem, (String) null);
        } catch (InvalidFormatException e) {
            throw new IOException(e);
        }
    }

    private static Workbook create(NPOIFSFileSystem nPOIFSFileSystem, String str) throws IOException, InvalidFormatException {
        DirectoryNode root = nPOIFSFileSystem.getRoot();
        boolean z = true;
        if (root.hasEntry(Decryptor.DEFAULT_POIFS_ENTRY)) {
            Decryptor decryptor = Decryptor.getInstance(new EncryptionInfo(nPOIFSFileSystem));
            boolean z2 = false;
            if (str != null) {
                try {
                    if (decryptor.verifyPassword(str)) {
                        z2 = true;
                    }
                } catch (GeneralSecurityException e) {
                    throw new IOException(e);
                }
            }
            if (z2 || !decryptor.verifyPassword(Decryptor.DEFAULT_PASSWORD)) {
                z = z2;
            }
            InputStream dataStream = z ? decryptor.getDataStream(root) : null;
            if (z) {
                return create(OPCPackage.open(dataStream));
            }
            if (str != null) {
                throw new EncryptedDocumentException("Password incorrect");
            }
            throw new EncryptedDocumentException("The supplied spreadsheet is protected, but no password was supplied");
        }
        if (str != null) {
            Biff8EncryptionKey.setCurrentUserPassword(str);
        }
        HSSFWorkbook hSSFWorkbook = new HSSFWorkbook(root, true);
        Biff8EncryptionKey.setCurrentUserPassword(null);
        return hSSFWorkbook;
    }

    public static Workbook create(OPCPackage oPCPackage) throws IOException {
        return new XSSFWorkbook(oPCPackage);
    }

    public static Workbook create(InputStream inputStream) throws IOException, InvalidFormatException, EncryptedDocumentException {
        return create(inputStream, (String) null);
    }

    public static Workbook create(InputStream inputStream, String str) throws IOException, InvalidFormatException, EncryptedDocumentException {
        if (!inputStream.markSupported()) {
            inputStream = new PushbackInputStream(inputStream, 8);
        }
        if (POIFSFileSystem.hasPOIFSHeader(IOUtils.peekFirst8Bytes(inputStream))) {
            return create(new NPOIFSFileSystem(inputStream), str);
        }
        if (POIXMLDocument.hasOOXMLHeader(inputStream)) {
            return new XSSFWorkbook(OPCPackage.open(inputStream));
        }
        throw new IllegalArgumentException("Your InputStream was neither an OLE2 stream, nor an OOXML stream");
    }

    public static Workbook create(File file) throws IOException, InvalidFormatException, EncryptedDocumentException {
        return create(file, (String) null);
    }

    public static Workbook create(File file, String str) throws IOException, InvalidFormatException, EncryptedDocumentException {
        if (!file.exists()) {
            throw new FileNotFoundException(file.toString());
        }
        try {
            return create(new NPOIFSFileSystem(file), str);
        } catch (OfficeXmlFileException unused) {
            OPCPackage open = OPCPackage.open(file);
            try {
                return new XSSFWorkbook(open);
            } catch (IOException e) {
                open.revert();
                throw e;
            } catch (IllegalArgumentException e2) {
                open.revert();
                throw e2;
            }
        }
    }
}
