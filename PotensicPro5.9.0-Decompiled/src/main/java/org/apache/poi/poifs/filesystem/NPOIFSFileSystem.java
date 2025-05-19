package org.apache.poi.poifs.filesystem;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.EmptyFileException;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.common.POIFSConstants;
import org.apache.poi.poifs.dev.POIFSViewable;
import org.apache.poi.poifs.filesystem.BlockStore;
import org.apache.poi.poifs.nio.ByteArrayBackedDataSource;
import org.apache.poi.poifs.nio.DataSource;
import org.apache.poi.poifs.nio.FileBackedDataSource;
import org.apache.poi.poifs.property.DirectoryProperty;
import org.apache.poi.poifs.property.DocumentProperty;
import org.apache.poi.poifs.property.NPropertyTable;
import org.apache.poi.poifs.storage.BATBlock;
import org.apache.poi.poifs.storage.BlockAllocationTableReader;
import org.apache.poi.poifs.storage.BlockAllocationTableWriter;
import org.apache.poi.poifs.storage.HeaderBlock;
import org.apache.poi.poifs.storage.HeaderBlockConstants;
import org.apache.poi.poifs.storage.HeaderBlockWriter;
import org.apache.poi.util.CloseIgnoringInputStream;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LongField;

/* loaded from: classes5.dex */
public class NPOIFSFileSystem extends BlockStore implements POIFSViewable, Closeable {
    private List<BATBlock> _bat_blocks;
    private DataSource _data;
    private HeaderBlock _header;
    private NPOIFSMiniStore _mini_store;
    private NPropertyTable _property_table;
    private DirectoryNode _root;
    private List<BATBlock> _xbat_blocks;
    private POIFSBigBlockSize bigBlockSize;

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public String getShortDescription() {
        return "POIFS FileSystem";
    }

    public static InputStream createNonClosingInputStream(InputStream inputStream) {
        return new CloseIgnoringInputStream(inputStream);
    }

    private NPOIFSFileSystem(boolean z) {
        this.bigBlockSize = POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS;
        this._header = new HeaderBlock(this.bigBlockSize);
        this._property_table = new NPropertyTable(this._header);
        this._mini_store = new NPOIFSMiniStore(this, this._property_table.getRoot(), new ArrayList(), this._header);
        this._xbat_blocks = new ArrayList();
        this._bat_blocks = new ArrayList();
        this._root = null;
        if (z) {
            this._data = new ByteArrayBackedDataSource(new byte[this.bigBlockSize.getBigBlockSize() * 3]);
        }
    }

    public NPOIFSFileSystem() {
        this(true);
        this._header.setBATCount(1);
        this._header.setBATArray(new int[]{0});
        BATBlock createEmptyBATBlock = BATBlock.createEmptyBATBlock(this.bigBlockSize, false);
        createEmptyBATBlock.setOurBlockIndex(0);
        this._bat_blocks.add(createEmptyBATBlock);
        setNextBlock(0, -3);
        setNextBlock(1, -2);
        this._property_table.setStartBlock(-2);
    }

    public NPOIFSFileSystem(File file) throws IOException {
        this(file, true);
    }

    public NPOIFSFileSystem(File file, boolean z) throws IOException {
        this(null, file, z, true);
    }

    public NPOIFSFileSystem(FileChannel fileChannel) throws IOException {
        this(fileChannel, true);
    }

    public NPOIFSFileSystem(FileChannel fileChannel, boolean z) throws IOException {
        this(fileChannel, null, z, false);
    }

    private NPOIFSFileSystem(FileChannel fileChannel, File file, boolean z, boolean z2) throws IOException {
        this(false);
        try {
            if (file == null) {
                this._data = new FileBackedDataSource(fileChannel, z);
            } else {
                if (file.length() == 0) {
                    throw new EmptyFileException();
                }
                FileBackedDataSource fileBackedDataSource = new FileBackedDataSource(file, z);
                fileChannel = fileBackedDataSource.getChannel();
                this._data = fileBackedDataSource;
            }
            ByteBuffer allocate = ByteBuffer.allocate(512);
            IOUtils.readFully(fileChannel, allocate);
            this._header = new HeaderBlock(allocate);
            readCoreContents();
        } catch (IOException e) {
            if (z2) {
                fileChannel.close();
            }
            throw e;
        } catch (RuntimeException e2) {
            if (z2 && fileChannel != null) {
                fileChannel.close();
            }
            throw e2;
        }
    }

    public NPOIFSFileSystem(InputStream inputStream) throws IOException {
        this(false);
        ReadableByteChannel readableByteChannel;
        try {
            readableByteChannel = Channels.newChannel(inputStream);
        } catch (Throwable th) {
            th = th;
            readableByteChannel = null;
        }
        try {
            ByteBuffer allocate = ByteBuffer.allocate(512);
            IOUtils.readFully(readableByteChannel, allocate);
            HeaderBlock headerBlock = new HeaderBlock(allocate);
            this._header = headerBlock;
            BlockAllocationTableReader.sanityCheckBlockCount(headerBlock.getBATCount());
            long calculateMaximumSize = BATBlock.calculateMaximumSize(this._header);
            if (calculateMaximumSize > 2147483647L) {
                throw new IllegalArgumentException("Unable read a >2gb file via an InputStream");
            }
            ByteBuffer allocate2 = ByteBuffer.allocate((int) calculateMaximumSize);
            allocate.position(0);
            allocate2.put(allocate);
            allocate2.position(allocate.capacity());
            IOUtils.readFully(readableByteChannel, allocate2);
            this._data = new ByteArrayBackedDataSource(allocate2.array(), allocate2.position());
            if (readableByteChannel != null) {
                readableByteChannel.close();
            }
            closeInputStream(inputStream, true);
            readCoreContents();
        } catch (Throwable th2) {
            th = th2;
            if (readableByteChannel != null) {
                readableByteChannel.close();
            }
            closeInputStream(inputStream, false);
            throw th;
        }
    }

    private void closeInputStream(InputStream inputStream, boolean z) {
        try {
            inputStream.close();
        } catch (IOException e) {
            if (z) {
                throw new RuntimeException(e);
            }
            e.printStackTrace();
        }
    }

    public static boolean hasPOIFSHeader(InputStream inputStream) throws IOException {
        inputStream.mark(8);
        byte[] bArr = new byte[8];
        IOUtils.readFully(inputStream, bArr);
        LongField longField = new LongField(0, bArr);
        if (inputStream instanceof PushbackInputStream) {
            ((PushbackInputStream) inputStream).unread(bArr);
        } else {
            inputStream.reset();
        }
        return longField.get() == HeaderBlockConstants._signature;
    }

    private void readCoreContents() throws IOException {
        this.bigBlockSize = this._header.getBigBlockSize();
        BlockStore.ChainLoopDetector chainLoopDetector = getChainLoopDetector();
        for (int i : this._header.getBATArray()) {
            readBAT(i, chainLoopDetector);
        }
        int bATCount = this._header.getBATCount() - this._header.getBATArray().length;
        int xBATIndex = this._header.getXBATIndex();
        for (int i2 = 0; i2 < this._header.getXBATCount(); i2++) {
            chainLoopDetector.claim(xBATIndex);
            BATBlock createBATBlock = BATBlock.createBATBlock(this.bigBlockSize, getBlockAt(xBATIndex));
            createBATBlock.setOurBlockIndex(xBATIndex);
            xBATIndex = createBATBlock.getValueAt(this.bigBlockSize.getXBATEntriesPerBlock());
            this._xbat_blocks.add(createBATBlock);
            int min = Math.min(bATCount, this.bigBlockSize.getXBATEntriesPerBlock());
            for (int i3 = 0; i3 < min; i3++) {
                int valueAt = createBATBlock.getValueAt(i3);
                if (valueAt != -1 && valueAt != -2) {
                    readBAT(valueAt, chainLoopDetector);
                }
                bATCount -= min;
            }
            bATCount -= min;
        }
        this._property_table = new NPropertyTable(this._header, this);
        ArrayList arrayList = new ArrayList();
        this._mini_store = new NPOIFSMiniStore(this, this._property_table.getRoot(), arrayList, this._header);
        int sBATStart = this._header.getSBATStart();
        for (int i4 = 0; i4 < this._header.getSBATCount(); i4++) {
            chainLoopDetector.claim(sBATStart);
            BATBlock createBATBlock2 = BATBlock.createBATBlock(this.bigBlockSize, getBlockAt(sBATStart));
            createBATBlock2.setOurBlockIndex(sBATStart);
            arrayList.add(createBATBlock2);
            sBATStart = getNextBlock(sBATStart);
        }
    }

    private void readBAT(int i, BlockStore.ChainLoopDetector chainLoopDetector) throws IOException {
        chainLoopDetector.claim(i);
        BATBlock createBATBlock = BATBlock.createBATBlock(this.bigBlockSize, getBlockAt(i));
        createBATBlock.setOurBlockIndex(i);
        this._bat_blocks.add(createBATBlock);
    }

    private BATBlock createBAT(int i, boolean z) throws IOException {
        BATBlock createEmptyBATBlock = BATBlock.createEmptyBATBlock(this.bigBlockSize, !z);
        createEmptyBATBlock.setOurBlockIndex(i);
        this._data.write(ByteBuffer.allocate(this.bigBlockSize.getBigBlockSize()), (i + 1) * this.bigBlockSize.getBigBlockSize());
        return createEmptyBATBlock;
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    protected ByteBuffer getBlockAt(int i) throws IOException {
        try {
            return this._data.read(this.bigBlockSize.getBigBlockSize(), (i + 1) * this.bigBlockSize.getBigBlockSize());
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Block " + i + " not found - " + e);
        }
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    protected ByteBuffer createBlockIfNeeded(int i) throws IOException {
        try {
            return getBlockAt(i);
        } catch (IndexOutOfBoundsException unused) {
            this._data.write(ByteBuffer.allocate(getBigBlockSize()), (i + 1) * this.bigBlockSize.getBigBlockSize());
            return getBlockAt(i);
        }
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    protected BATBlock.BATBlockAndIndex getBATBlockAndIndex(int i) {
        return BATBlock.getBATBlockAndIndex(i, this._header, this._bat_blocks);
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    protected int getNextBlock(int i) {
        BATBlock.BATBlockAndIndex bATBlockAndIndex = getBATBlockAndIndex(i);
        return bATBlockAndIndex.getBlock().getValueAt(bATBlockAndIndex.getIndex());
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    protected void setNextBlock(int i, int i2) {
        BATBlock.BATBlockAndIndex bATBlockAndIndex = getBATBlockAndIndex(i);
        bATBlockAndIndex.getBlock().setValueAt(bATBlockAndIndex.getIndex(), i2);
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    protected int getFreeBlock() throws IOException {
        int bATEntriesPerBlock = this.bigBlockSize.getBATEntriesPerBlock();
        int i = 0;
        int i2 = 0;
        for (BATBlock bATBlock : this._bat_blocks) {
            if (bATBlock.hasFreeSectors()) {
                for (int i3 = 0; i3 < bATEntriesPerBlock; i3++) {
                    if (bATBlock.getValueAt(i3) == -1) {
                        return i2 + i3;
                    }
                }
            }
            i2 += bATEntriesPerBlock;
        }
        BATBlock createBAT = createBAT(i2, true);
        createBAT.setValueAt(0, -3);
        this._bat_blocks.add(createBAT);
        if (this._header.getBATCount() >= 109) {
            BATBlock bATBlock2 = null;
            Iterator<BATBlock> it = this._xbat_blocks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BATBlock next = it.next();
                if (next.hasFreeSectors()) {
                    bATBlock2 = next;
                    break;
                }
            }
            if (bATBlock2 == null) {
                int i4 = i2 + 1;
                BATBlock createBAT2 = createBAT(i4, false);
                createBAT2.setValueAt(0, i2);
                createBAT.setValueAt(1, -4);
                if (this._xbat_blocks.size() == 0) {
                    this._header.setXBATStart(i4);
                } else {
                    List<BATBlock> list = this._xbat_blocks;
                    list.get(list.size() - 1).setValueAt(this.bigBlockSize.getXBATEntriesPerBlock(), i4);
                }
                this._xbat_blocks.add(createBAT2);
                this._header.setXBATCount(this._xbat_blocks.size());
                i2 = i4;
            } else {
                while (true) {
                    if (i >= this.bigBlockSize.getXBATEntriesPerBlock()) {
                        break;
                    }
                    if (bATBlock2.getValueAt(i) == -1) {
                        bATBlock2.setValueAt(i, i2);
                        break;
                    }
                    i++;
                }
            }
        } else {
            int bATCount = this._header.getBATCount() + 1;
            int[] iArr = new int[bATCount];
            int i5 = bATCount - 1;
            System.arraycopy(this._header.getBATArray(), 0, iArr, 0, i5);
            iArr[i5] = i2;
            this._header.setBATArray(iArr);
        }
        this._header.setBATCount(this._bat_blocks.size());
        return i2 + 1;
    }

    protected long size() throws IOException {
        return this._data.size();
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    protected BlockStore.ChainLoopDetector getChainLoopDetector() throws IOException {
        return new BlockStore.ChainLoopDetector(this._data.size());
    }

    NPropertyTable _get_property_table() {
        return this._property_table;
    }

    public NPOIFSMiniStore getMiniStore() {
        return this._mini_store;
    }

    void addDocument(NPOIFSDocument nPOIFSDocument) {
        this._property_table.addProperty(nPOIFSDocument.getDocumentProperty());
    }

    void addDirectory(DirectoryProperty directoryProperty) {
        this._property_table.addProperty(directoryProperty);
    }

    public DocumentEntry createDocument(InputStream inputStream, String str) throws IOException {
        return getRoot().createDocument(str, inputStream);
    }

    public DocumentEntry createDocument(String str, int i, POIFSWriterListener pOIFSWriterListener) throws IOException {
        return getRoot().createDocument(str, i, pOIFSWriterListener);
    }

    public DirectoryEntry createDirectory(String str) throws IOException {
        return getRoot().createDirectory(str);
    }

    public void writeFilesystem() throws IOException {
        DataSource dataSource = this._data;
        if (!(dataSource instanceof FileBackedDataSource)) {
            throw new IllegalArgumentException("POIFS opened from an inputstream, so writeFilesystem() may not be called. Use writeFilesystem(OutputStream) instead");
        }
        if (!((FileBackedDataSource) dataSource).isWriteable()) {
            throw new IllegalArgumentException("POIFS opened in read only mode, so writeFilesystem() may not be called. Open the FileSystem in read-write mode first");
        }
        syncWithDataSource();
    }

    public void writeFilesystem(OutputStream outputStream) throws IOException {
        syncWithDataSource();
        this._data.copyTo(outputStream);
    }

    private void syncWithDataSource() throws IOException {
        NPOIFSStream nPOIFSStream = new NPOIFSStream(this, this._header.getPropertyStart());
        this._property_table.preWrite();
        this._property_table.write(nPOIFSStream);
        new HeaderBlockWriter(this._header).writeBlock(getBlockAt(-1));
        for (BATBlock bATBlock : this._bat_blocks) {
            BlockAllocationTableWriter.writeBlock(bATBlock, getBlockAt(bATBlock.getOurBlockIndex()));
        }
        for (BATBlock bATBlock2 : this._xbat_blocks) {
            BlockAllocationTableWriter.writeBlock(bATBlock2, getBlockAt(bATBlock2.getOurBlockIndex()));
        }
        this._mini_store.syncWithDataSource();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this._data.close();
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length != 2) {
            System.err.println("two arguments required: input filename and output filename");
            System.exit(1);
        }
        FileInputStream fileInputStream = new FileInputStream(strArr[0]);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(strArr[1]);
            try {
                NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(fileInputStream);
                try {
                    nPOIFSFileSystem.writeFilesystem(fileOutputStream);
                } finally {
                    nPOIFSFileSystem.close();
                }
            } finally {
                fileOutputStream.close();
            }
        } finally {
            fileInputStream.close();
        }
    }

    public DirectoryNode getRoot() {
        if (this._root == null) {
            this._root = new DirectoryNode(this._property_table.getRoot(), this, (DirectoryNode) null);
        }
        return this._root;
    }

    public DocumentInputStream createDocumentInputStream(String str) throws IOException {
        return getRoot().createDocumentInputStream(str);
    }

    void remove(EntryNode entryNode) throws IOException {
        if (entryNode instanceof DocumentEntry) {
            new NPOIFSDocument((DocumentProperty) entryNode.getProperty(), this).free();
        }
        this._property_table.removeProperty(entryNode.getProperty());
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Object[] getViewableArray() {
        return preferArray() ? getRoot().getViewableArray() : new Object[0];
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Iterator<Object> getViewableIterator() {
        if (!preferArray()) {
            return getRoot().getViewableIterator();
        }
        return Collections.emptyList().iterator();
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public boolean preferArray() {
        return getRoot().preferArray();
    }

    public int getBigBlockSize() {
        return this.bigBlockSize.getBigBlockSize();
    }

    public POIFSBigBlockSize getBigBlockSizeDetails() {
        return this.bigBlockSize;
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    protected int getBlockStoreBlockSize() {
        return getBigBlockSize();
    }
}
