package org.apache.commons.collections;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* loaded from: classes4.dex */
public class LRUMap extends SequencedHashMap implements Externalizable {
    private static final long serialVersionUID = 2197433140769957051L;
    private int maximumSize;

    protected void processRemovedLRU(Object obj, Object obj2) {
    }

    public LRUMap() {
        this(100);
    }

    public LRUMap(int i) {
        super(i);
        this.maximumSize = 0;
        this.maximumSize = i;
    }

    @Override // org.apache.commons.collections.SequencedHashMap, java.util.Map
    public Object get(Object obj) {
        if (!containsKey(obj)) {
            return null;
        }
        Object remove = remove(obj);
        super.put(obj, remove);
        return remove;
    }

    @Override // org.apache.commons.collections.SequencedHashMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (size() >= this.maximumSize && !containsKey(obj)) {
            removeLRU();
        }
        return super.put(obj, obj2);
    }

    protected void removeLRU() {
        Object firstKey = getFirstKey();
        Object obj = super.get(firstKey);
        remove(firstKey);
        processRemovedLRU(firstKey, obj);
    }

    @Override // org.apache.commons.collections.SequencedHashMap, java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.maximumSize = objectInput.readInt();
        int readInt = objectInput.readInt();
        for (int i = 0; i < readInt; i++) {
            put(objectInput.readObject(), objectInput.readObject());
        }
    }

    @Override // org.apache.commons.collections.SequencedHashMap, java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(this.maximumSize);
        objectOutput.writeInt(size());
        for (Object obj : keySet()) {
            objectOutput.writeObject(obj);
            objectOutput.writeObject(super.get(obj));
        }
    }

    public int getMaximumSize() {
        return this.maximumSize;
    }

    public void setMaximumSize(int i) {
        this.maximumSize = i;
        while (size() > i) {
            removeLRU();
        }
    }
}
