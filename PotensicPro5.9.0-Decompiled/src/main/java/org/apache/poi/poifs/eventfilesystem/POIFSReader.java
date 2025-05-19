package org.apache.poi.poifs.eventfilesystem;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Objects;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.POIFSDocument;
import org.apache.poi.poifs.filesystem.POIFSDocumentPath;
import org.apache.poi.poifs.property.DirectoryProperty;
import org.apache.poi.poifs.property.Property;
import org.apache.poi.poifs.property.PropertyTable;
import org.apache.poi.poifs.storage.BlockAllocationTableReader;
import org.apache.poi.poifs.storage.BlockList;
import org.apache.poi.poifs.storage.HeaderBlock;
import org.apache.poi.poifs.storage.RawDataBlockList;
import org.apache.poi.poifs.storage.SmallBlockTableReader;

/* loaded from: classes5.dex */
public class POIFSReader {
    private POIFSReaderRegistry registry = new POIFSReaderRegistry();
    private boolean registryClosed = false;

    public void read(InputStream inputStream) throws IOException {
        this.registryClosed = true;
        HeaderBlock headerBlock = new HeaderBlock(inputStream);
        RawDataBlockList rawDataBlockList = new RawDataBlockList(inputStream, headerBlock.getBigBlockSize());
        new BlockAllocationTableReader(headerBlock.getBigBlockSize(), headerBlock.getBATCount(), headerBlock.getBATArray(), headerBlock.getXBATCount(), headerBlock.getXBATIndex(), rawDataBlockList);
        PropertyTable propertyTable = new PropertyTable(headerBlock, rawDataBlockList);
        processProperties(SmallBlockTableReader.getSmallDocumentBlocks(headerBlock.getBigBlockSize(), rawDataBlockList, propertyTable.getRoot(), headerBlock.getSBATStart()), rawDataBlockList, propertyTable.getRoot().getChildren(), new POIFSDocumentPath());
    }

    public void registerListener(POIFSReaderListener pOIFSReaderListener) {
        Objects.requireNonNull(pOIFSReaderListener);
        if (this.registryClosed) {
            throw new IllegalStateException();
        }
        this.registry.registerListener(pOIFSReaderListener);
    }

    public void registerListener(POIFSReaderListener pOIFSReaderListener, String str) {
        registerListener(pOIFSReaderListener, null, str);
    }

    public void registerListener(POIFSReaderListener pOIFSReaderListener, POIFSDocumentPath pOIFSDocumentPath, String str) {
        if (pOIFSReaderListener == null || str == null || str.length() == 0) {
            throw null;
        }
        if (this.registryClosed) {
            throw new IllegalStateException();
        }
        POIFSReaderRegistry pOIFSReaderRegistry = this.registry;
        if (pOIFSDocumentPath == null) {
            pOIFSDocumentPath = new POIFSDocumentPath();
        }
        pOIFSReaderRegistry.registerListener(pOIFSReaderListener, pOIFSDocumentPath, str);
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length == 0) {
            System.err.println("at least one argument required: input filename(s)");
            System.exit(1);
        }
        for (int i = 0; i < strArr.length; i++) {
            POIFSReader pOIFSReader = new POIFSReader();
            pOIFSReader.registerListener(new SampleListener());
            System.out.println("reading " + strArr[i]);
            FileInputStream fileInputStream = new FileInputStream(strArr[i]);
            pOIFSReader.read(fileInputStream);
            fileInputStream.close();
        }
    }

    private void processProperties(BlockList blockList, BlockList blockList2, Iterator it, POIFSDocumentPath pOIFSDocumentPath) throws IOException {
        POIFSDocument pOIFSDocument;
        while (it.hasNext()) {
            Property property = (Property) it.next();
            String name = property.getName();
            if (property.isDirectory()) {
                processProperties(blockList, blockList2, ((DirectoryProperty) property).getChildren(), new POIFSDocumentPath(pOIFSDocumentPath, new String[]{name}));
            } else {
                int startBlock = property.getStartBlock();
                Iterator listeners = this.registry.getListeners(pOIFSDocumentPath, name);
                if (listeners.hasNext()) {
                    int size = property.getSize();
                    if (property.shouldUseSmallBlocks()) {
                        pOIFSDocument = new POIFSDocument(name, blockList.fetchBlocks(startBlock, -1), size);
                    } else {
                        pOIFSDocument = new POIFSDocument(name, blockList2.fetchBlocks(startBlock, -1), size);
                    }
                    while (listeners.hasNext()) {
                        ((POIFSReaderListener) listeners.next()).processPOIFSReaderEvent(new POIFSReaderEvent(new DocumentInputStream(pOIFSDocument), pOIFSDocumentPath, name));
                    }
                } else if (property.shouldUseSmallBlocks()) {
                    blockList.fetchBlocks(startBlock, -1);
                } else {
                    blockList2.fetchBlocks(startBlock, -1);
                }
            }
        }
    }

    private static class SampleListener implements POIFSReaderListener {
        SampleListener() {
        }

        @Override // org.apache.poi.poifs.eventfilesystem.POIFSReaderListener
        public void processPOIFSReaderEvent(POIFSReaderEvent pOIFSReaderEvent) {
            DocumentInputStream stream = pOIFSReaderEvent.getStream();
            POIFSDocumentPath path = pOIFSReaderEvent.getPath();
            String name = pOIFSReaderEvent.getName();
            try {
                int available = stream.available();
                stream.read(new byte[available]);
                int length = path.length();
                for (int i = 0; i < length; i++) {
                    System.out.print(InternalZipConstants.ZIP_FILE_SEPARATOR + path.getComponent(i));
                }
                System.out.println(InternalZipConstants.ZIP_FILE_SEPARATOR + name + ": " + available + " bytes read");
            } catch (IOException unused) {
            }
        }
    }
}
