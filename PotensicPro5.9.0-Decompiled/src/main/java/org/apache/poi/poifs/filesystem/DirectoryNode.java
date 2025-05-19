package org.apache.poi.poifs.filesystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.poi.hpsf.ClassID;
import org.apache.poi.poifs.dev.POIFSViewable;
import org.apache.poi.poifs.property.DirectoryProperty;
import org.apache.poi.poifs.property.DocumentProperty;
import org.apache.poi.poifs.property.Property;

/* loaded from: classes5.dex */
public class DirectoryNode extends EntryNode implements DirectoryEntry, POIFSViewable, Iterable<Entry> {
    private Map<String, Entry> _byname;
    private ArrayList<Entry> _entries;
    private NPOIFSFileSystem _nfilesystem;
    private POIFSFileSystem _ofilesystem;
    private POIFSDocumentPath _path;

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Object[] getViewableArray() {
        return new Object[0];
    }

    @Override // org.apache.poi.poifs.filesystem.EntryNode, org.apache.poi.poifs.filesystem.Entry
    public boolean isDirectoryEntry() {
        return true;
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public boolean preferArray() {
        return false;
    }

    DirectoryNode(DirectoryProperty directoryProperty, POIFSFileSystem pOIFSFileSystem, DirectoryNode directoryNode) {
        this(directoryProperty, directoryNode, pOIFSFileSystem, (NPOIFSFileSystem) null);
    }

    DirectoryNode(DirectoryProperty directoryProperty, NPOIFSFileSystem nPOIFSFileSystem, DirectoryNode directoryNode) {
        this(directoryProperty, directoryNode, (POIFSFileSystem) null, nPOIFSFileSystem);
    }

    private DirectoryNode(DirectoryProperty directoryProperty, DirectoryNode directoryNode, POIFSFileSystem pOIFSFileSystem, NPOIFSFileSystem nPOIFSFileSystem) {
        super(directoryProperty, directoryNode);
        Entry documentNode;
        this._ofilesystem = pOIFSFileSystem;
        this._nfilesystem = nPOIFSFileSystem;
        if (directoryNode == null) {
            this._path = new POIFSDocumentPath();
        } else {
            this._path = new POIFSDocumentPath(directoryNode._path, new String[]{directoryProperty.getName()});
        }
        this._byname = new HashMap();
        this._entries = new ArrayList<>();
        Iterator<Property> children = directoryProperty.getChildren();
        while (children.hasNext()) {
            Property next = children.next();
            if (next.isDirectory()) {
                DirectoryProperty directoryProperty2 = (DirectoryProperty) next;
                if (this._ofilesystem != null) {
                    documentNode = new DirectoryNode(directoryProperty2, this._ofilesystem, this);
                } else {
                    documentNode = new DirectoryNode(directoryProperty2, this._nfilesystem, this);
                }
            } else {
                documentNode = new DocumentNode((DocumentProperty) next, this);
            }
            this._entries.add(documentNode);
            this._byname.put(documentNode.getName(), documentNode);
        }
    }

    public POIFSDocumentPath getPath() {
        return this._path;
    }

    public POIFSFileSystem getFileSystem() {
        return this._ofilesystem;
    }

    public NPOIFSFileSystem getNFileSystem() {
        return this._nfilesystem;
    }

    public DocumentInputStream createDocumentInputStream(String str) throws IOException {
        return createDocumentInputStream(getEntry(str));
    }

    public DocumentInputStream createDocumentInputStream(Entry entry) throws IOException {
        if (!entry.isDocumentEntry()) {
            throw new IOException("Entry '" + entry.getName() + "' is not a DocumentEntry");
        }
        return new DocumentInputStream((DocumentEntry) entry);
    }

    DocumentEntry createDocument(POIFSDocument pOIFSDocument) throws IOException {
        DocumentProperty documentProperty = pOIFSDocument.getDocumentProperty();
        DocumentNode documentNode = new DocumentNode(documentProperty, this);
        ((DirectoryProperty) getProperty()).addChild(documentProperty);
        this._ofilesystem.addDocument(pOIFSDocument);
        this._entries.add(documentNode);
        this._byname.put(documentProperty.getName(), documentNode);
        return documentNode;
    }

    DocumentEntry createDocument(NPOIFSDocument nPOIFSDocument) throws IOException {
        DocumentProperty documentProperty = nPOIFSDocument.getDocumentProperty();
        DocumentNode documentNode = new DocumentNode(documentProperty, this);
        ((DirectoryProperty) getProperty()).addChild(documentProperty);
        this._nfilesystem.addDocument(nPOIFSDocument);
        this._entries.add(documentNode);
        this._byname.put(documentProperty.getName(), documentNode);
        return documentNode;
    }

    boolean changeName(String str, String str2) {
        EntryNode entryNode = (EntryNode) this._byname.get(str);
        if (entryNode == null) {
            return false;
        }
        boolean changeName = ((DirectoryProperty) getProperty()).changeName(entryNode.getProperty(), str2);
        if (!changeName) {
            return changeName;
        }
        this._byname.remove(str);
        this._byname.put(entryNode.getProperty().getName(), entryNode);
        return changeName;
    }

    boolean deleteEntry(EntryNode entryNode) {
        boolean deleteChild = ((DirectoryProperty) getProperty()).deleteChild(entryNode.getProperty());
        if (deleteChild) {
            this._entries.remove(entryNode);
            this._byname.remove(entryNode.getName());
            POIFSFileSystem pOIFSFileSystem = this._ofilesystem;
            if (pOIFSFileSystem != null) {
                pOIFSFileSystem.remove(entryNode);
            } else {
                try {
                    this._nfilesystem.remove(entryNode);
                } catch (IOException unused) {
                }
            }
        }
        return deleteChild;
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public Iterator<Entry> getEntries() {
        return this._entries.iterator();
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public Set<String> getEntryNames() {
        return this._byname.keySet();
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public boolean isEmpty() {
        return this._entries.isEmpty();
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public int getEntryCount() {
        return this._entries.size();
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public boolean hasEntry(String str) {
        return str != null && this._byname.containsKey(str);
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public Entry getEntry(String str) throws FileNotFoundException {
        Entry entry = str != null ? this._byname.get(str) : null;
        if (entry != null) {
            return entry;
        }
        throw new FileNotFoundException("no such entry: \"" + str + "\", had: " + this._byname.keySet());
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public DocumentEntry createDocument(String str, InputStream inputStream) throws IOException {
        if (this._nfilesystem != null) {
            return createDocument(new NPOIFSDocument(str, this._nfilesystem, inputStream));
        }
        return createDocument(new POIFSDocument(str, inputStream));
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public DocumentEntry createDocument(String str, int i, POIFSWriterListener pOIFSWriterListener) throws IOException {
        if (this._nfilesystem != null) {
            return createDocument(new NPOIFSDocument(str, i, this._nfilesystem, pOIFSWriterListener));
        }
        return createDocument(new POIFSDocument(str, i, this._path, pOIFSWriterListener));
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public DirectoryEntry createDirectory(String str) throws IOException {
        DirectoryNode directoryNode;
        DirectoryProperty directoryProperty = new DirectoryProperty(str);
        if (this._ofilesystem != null) {
            directoryNode = new DirectoryNode(directoryProperty, this._ofilesystem, this);
            this._ofilesystem.addDirectory(directoryProperty);
        } else {
            directoryNode = new DirectoryNode(directoryProperty, this._nfilesystem, this);
            this._nfilesystem.addDirectory(directoryProperty);
        }
        ((DirectoryProperty) getProperty()).addChild(directoryProperty);
        this._entries.add(directoryNode);
        this._byname.put(str, directoryNode);
        return directoryNode;
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public ClassID getStorageClsid() {
        return getProperty().getStorageClsid();
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public void setStorageClsid(ClassID classID) {
        getProperty().setStorageClsid(classID);
    }

    @Override // org.apache.poi.poifs.filesystem.EntryNode
    protected boolean isDeleteOK() {
        return isEmpty();
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Iterator<Object> getViewableIterator() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getProperty());
        Iterator<Entry> it = this._entries.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList.iterator();
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public String getShortDescription() {
        return getName();
    }

    @Override // java.lang.Iterable
    public Iterator<Entry> iterator() {
        return getEntries();
    }
}
