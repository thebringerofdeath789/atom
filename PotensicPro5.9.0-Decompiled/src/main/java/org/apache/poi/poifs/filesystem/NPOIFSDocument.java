package org.apache.poi.poifs.filesystem;

import androidx.fragment.app.FragmentTransaction;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import org.apache.poi.poifs.dev.POIFSViewable;
import org.apache.poi.poifs.property.DocumentProperty;
import org.apache.poi.util.HexDump;

/* loaded from: classes5.dex */
public final class NPOIFSDocument implements POIFSViewable {
    private int _block_size;
    private NPOIFSFileSystem _filesystem;
    private DocumentProperty _property;
    private NPOIFSStream _stream;

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public boolean preferArray() {
        return true;
    }

    public NPOIFSDocument(DocumentNode documentNode) throws IOException {
        this((DocumentProperty) documentNode.getProperty(), ((DirectoryNode) documentNode.getParent()).getNFileSystem());
    }

    public NPOIFSDocument(DocumentProperty documentProperty, NPOIFSFileSystem nPOIFSFileSystem) throws IOException {
        this._property = documentProperty;
        this._filesystem = nPOIFSFileSystem;
        if (documentProperty.getSize() < 4096) {
            this._stream = new NPOIFSStream(this._filesystem.getMiniStore(), documentProperty.getStartBlock());
            this._block_size = this._filesystem.getMiniStore().getBlockStoreBlockSize();
        } else {
            this._stream = new NPOIFSStream(this._filesystem, documentProperty.getStartBlock());
            this._block_size = this._filesystem.getBlockStoreBlockSize();
        }
    }

    public NPOIFSDocument(String str, NPOIFSFileSystem nPOIFSFileSystem, InputStream inputStream) throws IOException {
        this._filesystem = nPOIFSFileSystem;
        DocumentProperty documentProperty = new DocumentProperty(str, store(inputStream));
        this._property = documentProperty;
        documentProperty.setStartBlock(this._stream.getStartBlock());
    }

    public NPOIFSDocument(String str, int i, NPOIFSFileSystem nPOIFSFileSystem, POIFSWriterListener pOIFSWriterListener) throws IOException {
        this._filesystem = nPOIFSFileSystem;
        if (i < 4096) {
            this._stream = new NPOIFSStream(nPOIFSFileSystem.getMiniStore());
            this._block_size = this._filesystem.getMiniStore().getBlockStoreBlockSize();
        } else {
            this._stream = new NPOIFSStream(nPOIFSFileSystem);
            this._block_size = this._filesystem.getBlockStoreBlockSize();
        }
        OutputStream outputStream = this._stream.getOutputStream();
        DocumentOutputStream documentOutputStream = new DocumentOutputStream(outputStream, i);
        POIFSDocumentPath pOIFSDocumentPath = new POIFSDocumentPath(str.split("\\\\"));
        pOIFSWriterListener.processPOIFSWriterEvent(new POIFSWriterEvent(documentOutputStream, pOIFSDocumentPath, pOIFSDocumentPath.getComponent(pOIFSDocumentPath.length() - 1), i));
        outputStream.close();
        DocumentProperty documentProperty = new DocumentProperty(str, i);
        this._property = documentProperty;
        documentProperty.setStartBlock(this._stream.getStartBlock());
    }

    private int store(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        bufferedInputStream.mark(4096);
        if (bufferedInputStream.skip(4096L) < 4096) {
            this._stream = new NPOIFSStream(this._filesystem.getMiniStore());
            this._block_size = this._filesystem.getMiniStore().getBlockStoreBlockSize();
        } else {
            this._stream = new NPOIFSStream(this._filesystem);
            this._block_size = this._filesystem.getBlockStoreBlockSize();
        }
        bufferedInputStream.reset();
        OutputStream outputStream = this._stream.getOutputStream();
        byte[] bArr = new byte[1024];
        int i = 0;
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                i += read;
            } else {
                outputStream.close();
                return i;
            }
        }
    }

    void free() throws IOException {
        this._stream.free();
        this._property.setStartBlock(-2);
    }

    NPOIFSFileSystem getFileSystem() {
        return this._filesystem;
    }

    int getDocumentBlockSize() {
        return this._block_size;
    }

    Iterator<ByteBuffer> getBlockIterator() {
        if (getSize() > 0) {
            return this._stream.getBlockIterator();
        }
        return Collections.emptyList().iterator();
    }

    public int getSize() {
        return this._property.getSize();
    }

    public void replaceContents(InputStream inputStream) throws IOException {
        free();
        int store = store(inputStream);
        this._property.setStartBlock(this._stream.getStartBlock());
        this._property.updateSize(store);
    }

    DocumentProperty getDocumentProperty() {
        return this._property;
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Object[] getViewableArray() {
        String message;
        Object[] objArr = new Object[1];
        try {
            if (getSize() > 0) {
                int size = getSize();
                byte[] bArr = new byte[size];
                Iterator<ByteBuffer> it = this._stream.iterator();
                int i = 0;
                while (it.hasNext()) {
                    ByteBuffer next = it.next();
                    int min = Math.min(this._block_size, size - i);
                    next.get(bArr, i, min);
                    i += min;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                HexDump.dump(bArr, 0L, byteArrayOutputStream, 0);
                message = byteArrayOutputStream.toString();
            } else {
                message = "<NO DATA>";
            }
        } catch (IOException e) {
            message = e.getMessage();
        }
        objArr[0] = message;
        return objArr;
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Iterator<Object> getViewableIterator() {
        return Collections.emptyList().iterator();
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public String getShortDescription() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Document: \"").append(this._property.getName()).append("\"");
        stringBuffer.append(" size = ").append(getSize());
        return stringBuffer.toString();
    }
}
