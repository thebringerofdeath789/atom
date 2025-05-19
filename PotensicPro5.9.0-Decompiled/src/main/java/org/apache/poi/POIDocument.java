package org.apache.poi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.HPSFException;
import org.apache.poi.hpsf.MutablePropertySet;
import org.apache.poi.hpsf.PropertySet;
import org.apache.poi.hpsf.PropertySetFactory;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hpsf.WritingNotSupportedException;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.poifs.filesystem.EntryUtils;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* loaded from: classes.dex */
public abstract class POIDocument {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) POIDocument.class);
    protected DirectoryNode directory;
    private DocumentSummaryInformation dsInf;
    private boolean initialized;
    private SummaryInformation sInf;

    public abstract void write(OutputStream outputStream) throws IOException;

    protected POIDocument(DirectoryNode directoryNode) {
        this.initialized = false;
        this.directory = directoryNode;
    }

    @Deprecated
    protected POIDocument(DirectoryNode directoryNode, POIFSFileSystem pOIFSFileSystem) {
        this.initialized = false;
        this.directory = directoryNode;
    }

    protected POIDocument(POIFSFileSystem pOIFSFileSystem) {
        this(pOIFSFileSystem.getRoot());
    }

    protected POIDocument(NPOIFSFileSystem nPOIFSFileSystem) {
        this(nPOIFSFileSystem.getRoot());
    }

    public DocumentSummaryInformation getDocumentSummaryInformation() {
        if (!this.initialized) {
            readProperties();
        }
        return this.dsInf;
    }

    public SummaryInformation getSummaryInformation() {
        if (!this.initialized) {
            readProperties();
        }
        return this.sInf;
    }

    public void createInformationProperties() {
        if (!this.initialized) {
            readProperties();
        }
        if (this.sInf == null) {
            this.sInf = PropertySetFactory.newSummaryInformation();
        }
        if (this.dsInf == null) {
            this.dsInf = PropertySetFactory.newDocumentSummaryInformation();
        }
    }

    protected void readProperties() {
        PropertySet propertySet = getPropertySet("\u0005DocumentSummaryInformation");
        if (propertySet != null && (propertySet instanceof DocumentSummaryInformation)) {
            this.dsInf = (DocumentSummaryInformation) propertySet;
        } else if (propertySet != null) {
            logger.log(5, "DocumentSummaryInformation property set came back with wrong class - ", propertySet.getClass());
        }
        PropertySet propertySet2 = getPropertySet("\u0005SummaryInformation");
        if (propertySet2 instanceof SummaryInformation) {
            this.sInf = (SummaryInformation) propertySet2;
        } else if (propertySet2 != null) {
            logger.log(5, "SummaryInformation property set came back with wrong class - ", propertySet2.getClass());
        }
        this.initialized = true;
    }

    protected PropertySet getPropertySet(String str) {
        return getPropertySet(str, null);
    }

    protected PropertySet getPropertySet(String str, EncryptionInfo encryptionInfo) {
        DirectoryNode directoryNode = this.directory;
        if (encryptionInfo != null) {
            try {
                InputStream dataStream = encryptionInfo.getDecryptor().getDataStream(this.directory);
                POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem(dataStream);
                dataStream.close();
                directoryNode = pOIFSFileSystem.getRoot();
            } catch (Exception e) {
                logger.log(7, (Object) ("Error getting encrypted property set with name " + str), (Throwable) e);
                return null;
            }
        }
        if (directoryNode != null && directoryNode.hasEntry(str)) {
            try {
                try {
                    return PropertySetFactory.create(directoryNode.createDocumentInputStream(directoryNode.getEntry(str)));
                } catch (IOException e2) {
                    logger.log(5, "Error creating property set with name " + str + "\n" + e2);
                    return null;
                } catch (HPSFException e3) {
                    logger.log(5, "Error creating property set with name " + str + "\n" + e3);
                    return null;
                }
            } catch (IOException e4) {
                logger.log(5, "Error getting property set with name " + str + "\n" + e4);
            }
        }
        return null;
    }

    protected void writeProperties(POIFSFileSystem pOIFSFileSystem) throws IOException {
        writeProperties(pOIFSFileSystem, null);
    }

    protected void writeProperties(POIFSFileSystem pOIFSFileSystem, List<String> list) throws IOException {
        SummaryInformation summaryInformation = getSummaryInformation();
        if (summaryInformation != null) {
            writePropertySet("\u0005SummaryInformation", summaryInformation, pOIFSFileSystem);
            if (list != null) {
                list.add("\u0005SummaryInformation");
            }
        }
        DocumentSummaryInformation documentSummaryInformation = getDocumentSummaryInformation();
        if (documentSummaryInformation != null) {
            writePropertySet("\u0005DocumentSummaryInformation", documentSummaryInformation, pOIFSFileSystem);
            if (list != null) {
                list.add("\u0005DocumentSummaryInformation");
            }
        }
    }

    protected void writePropertySet(String str, PropertySet propertySet, POIFSFileSystem pOIFSFileSystem) throws IOException {
        try {
            MutablePropertySet mutablePropertySet = new MutablePropertySet(propertySet);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            mutablePropertySet.write(byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            pOIFSFileSystem.createDocument(new ByteArrayInputStream(byteArray), str);
            logger.log(3, "Wrote property set " + str + " of size " + byteArray.length);
        } catch (WritingNotSupportedException unused) {
            logger.log(7, "Couldn't write property set with name " + str + " as not supported by HPSF yet");
        }
    }

    @Deprecated
    protected void copyNodes(POIFSFileSystem pOIFSFileSystem, POIFSFileSystem pOIFSFileSystem2, List<String> list) throws IOException {
        EntryUtils.copyNodes(pOIFSFileSystem, pOIFSFileSystem2, list);
    }

    @Deprecated
    protected void copyNodes(DirectoryNode directoryNode, DirectoryNode directoryNode2, List<String> list) throws IOException {
        EntryUtils.copyNodes(directoryNode, directoryNode2, list);
    }

    @Internal
    @Deprecated
    protected void copyNodeRecursively(Entry entry, DirectoryEntry directoryEntry) throws IOException {
        EntryUtils.copyNodeRecursively(entry, directoryEntry);
    }
}
