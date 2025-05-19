package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.BoundedMap;
import org.apache.commons.collections.map.AbstractHashedMap;
import org.apache.commons.collections.map.AbstractLinkedMap;

/* loaded from: classes4.dex */
public class LRUMap extends AbstractLinkedMap implements BoundedMap, Serializable, Cloneable {
    protected static final int DEFAULT_MAX_SIZE = 100;
    private static final long serialVersionUID = -612114643488955218L;
    private transient int maxSize;
    private boolean scanUntilRemovable;

    protected boolean removeLRU(AbstractLinkedMap.LinkEntry linkEntry) {
        return true;
    }

    public LRUMap() {
        this(100, 0.75f, false);
    }

    public LRUMap(int i) {
        this(i, 0.75f);
    }

    public LRUMap(int i, boolean z) {
        this(i, 0.75f, z);
    }

    public LRUMap(int i, float f) {
        this(i, f, false);
    }

    public LRUMap(int i, float f, boolean z) {
        super(i < 1 ? 16 : i, f);
        if (i < 1) {
            throw new IllegalArgumentException("LRUMap max size must be greater than 0");
        }
        this.maxSize = i;
        this.scanUntilRemovable = z;
    }

    public LRUMap(Map map) {
        this(map, false);
    }

    public LRUMap(Map map, boolean z) {
        this(map.size(), 0.75f, z);
        putAll(map);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        AbstractLinkedMap.LinkEntry linkEntry = (AbstractLinkedMap.LinkEntry) getEntry(obj);
        if (linkEntry == null) {
            return null;
        }
        moveToMRU(linkEntry);
        return linkEntry.getValue();
    }

    protected void moveToMRU(AbstractLinkedMap.LinkEntry linkEntry) {
        if (linkEntry.after != this.header) {
            this.modCount++;
            linkEntry.before.after = linkEntry.after;
            linkEntry.after.before = linkEntry.before;
            linkEntry.after = this.header;
            linkEntry.before = this.header.before;
            this.header.before.after = linkEntry;
            this.header.before = linkEntry;
            return;
        }
        if (linkEntry == this.header) {
            throw new IllegalStateException("Can't move header to MRU (please report this to commons-dev@jakarta.apache.org)");
        }
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    protected void updateEntry(AbstractHashedMap.HashEntry hashEntry, Object obj) {
        moveToMRU((AbstractLinkedMap.LinkEntry) hashEntry);
        hashEntry.setValue(obj);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    protected void addMapping(int i, int i2, Object obj, Object obj2) {
        if (isFull()) {
            AbstractLinkedMap.LinkEntry linkEntry = this.header.after;
            boolean z = false;
            if (this.scanUntilRemovable) {
                while (true) {
                    if (linkEntry == this.header || linkEntry == null) {
                        break;
                    }
                    if (removeLRU(linkEntry)) {
                        z = true;
                        break;
                    }
                    linkEntry = linkEntry.after;
                }
                if (linkEntry == null) {
                    throw new IllegalStateException(new StringBuffer().append("Entry.after=null, header.after").append(this.header.after).append(" header.before").append(this.header.before).append(" key=").append(obj).append(" value=").append(obj2).append(" size=").append(this.size).append(" maxSize=").append(this.maxSize).append(" Please check that your keys are immutable, and that you have used synchronization properly.").append(" If so, then please report this to commons-dev@jakarta.apache.org as a bug.").toString());
                }
            } else {
                z = removeLRU(linkEntry);
            }
            AbstractLinkedMap.LinkEntry linkEntry2 = linkEntry;
            if (!z) {
                super.addMapping(i, i2, obj, obj2);
                return;
            } else {
                if (linkEntry2 == null) {
                    throw new IllegalStateException(new StringBuffer().append("reuse=null, header.after=").append(this.header.after).append(" header.before").append(this.header.before).append(" key=").append(obj).append(" value=").append(obj2).append(" size=").append(this.size).append(" maxSize=").append(this.maxSize).append(" Please check that your keys are immutable, and that you have used synchronization properly.").append(" If so, then please report this to commons-dev@jakarta.apache.org as a bug.").toString());
                }
                reuseMapping(linkEntry2, i, i2, obj, obj2);
                return;
            }
        }
        super.addMapping(i, i2, obj, obj2);
    }

    protected void reuseMapping(AbstractLinkedMap.LinkEntry linkEntry, int i, int i2, Object obj, Object obj2) {
        try {
            int hashIndex = hashIndex(linkEntry.hashCode, this.data.length);
            AbstractHashedMap.HashEntry hashEntry = this.data[hashIndex];
            AbstractHashedMap.HashEntry hashEntry2 = null;
            while (hashEntry != linkEntry && hashEntry != null) {
                hashEntry2 = hashEntry;
                hashEntry = hashEntry.next;
            }
            if (hashEntry == null) {
                throw new IllegalStateException(new StringBuffer().append("Entry.next=null, data[removeIndex]=").append(this.data[hashIndex]).append(" previous=").append(hashEntry2).append(" key=").append(obj).append(" value=").append(obj2).append(" size=").append(this.size).append(" maxSize=").append(this.maxSize).append(" Please check that your keys are immutable, and that you have used synchronization properly.").append(" If so, then please report this to commons-dev@jakarta.apache.org as a bug.").toString());
            }
            this.modCount++;
            removeEntry(linkEntry, hashIndex, hashEntry2);
            reuseEntry(linkEntry, i, i2, obj, obj2);
            addEntry(linkEntry, i);
        } catch (NullPointerException unused) {
            throw new IllegalStateException(new StringBuffer().append("NPE, entry=").append(linkEntry).append(" entryIsHeader=").append(linkEntry == this.header).append(" key=").append(obj).append(" value=").append(obj2).append(" size=").append(this.size).append(" maxSize=").append(this.maxSize).append(" Please check that your keys are immutable, and that you have used synchronization properly.").append(" If so, then please report this to commons-dev@jakarta.apache.org as a bug.").toString());
        }
    }

    @Override // org.apache.commons.collections.BoundedMap
    public boolean isFull() {
        return this.size >= this.maxSize;
    }

    @Override // org.apache.commons.collections.BoundedMap
    public int maxSize() {
        return this.maxSize;
    }

    public boolean isScanUntilRemovable() {
        return this.scanUntilRemovable;
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap
    public Object clone() {
        return super.clone();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    protected void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.maxSize);
        super.doWriteObject(objectOutputStream);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    protected void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.maxSize = objectInputStream.readInt();
        super.doReadObject(objectInputStream);
    }
}
