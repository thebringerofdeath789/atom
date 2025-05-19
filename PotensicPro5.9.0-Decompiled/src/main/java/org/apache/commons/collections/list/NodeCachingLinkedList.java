package org.apache.commons.collections.list;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import org.apache.commons.collections.list.AbstractLinkedList;

/* loaded from: classes4.dex */
public class NodeCachingLinkedList extends AbstractLinkedList implements Serializable {
    protected static final int DEFAULT_MAXIMUM_CACHE_SIZE = 20;
    private static final long serialVersionUID = 6897789178562232073L;
    protected transient int cacheSize;
    protected transient AbstractLinkedList.Node firstCachedNode;
    protected int maximumCacheSize;

    public NodeCachingLinkedList() {
        this(20);
    }

    public NodeCachingLinkedList(Collection collection) {
        super(collection);
        this.maximumCacheSize = 20;
    }

    public NodeCachingLinkedList(int i) {
        this.maximumCacheSize = i;
        init();
    }

    protected int getMaximumCacheSize() {
        return this.maximumCacheSize;
    }

    protected void setMaximumCacheSize(int i) {
        this.maximumCacheSize = i;
        shrinkCacheToMaximumSize();
    }

    protected void shrinkCacheToMaximumSize() {
        while (this.cacheSize > this.maximumCacheSize) {
            getNodeFromCache();
        }
    }

    protected AbstractLinkedList.Node getNodeFromCache() {
        if (this.cacheSize == 0) {
            return null;
        }
        AbstractLinkedList.Node node = this.firstCachedNode;
        this.firstCachedNode = node.next;
        node.next = null;
        this.cacheSize--;
        return node;
    }

    protected boolean isCacheFull() {
        return this.cacheSize >= this.maximumCacheSize;
    }

    protected void addNodeToCache(AbstractLinkedList.Node node) {
        if (isCacheFull()) {
            return;
        }
        AbstractLinkedList.Node node2 = this.firstCachedNode;
        node.previous = null;
        node.next = node2;
        node.setValue(null);
        this.firstCachedNode = node;
        this.cacheSize++;
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList
    protected AbstractLinkedList.Node createNode(Object obj) {
        AbstractLinkedList.Node nodeFromCache = getNodeFromCache();
        if (nodeFromCache == null) {
            return super.createNode(obj);
        }
        nodeFromCache.setValue(obj);
        return nodeFromCache;
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList
    protected void removeNode(AbstractLinkedList.Node node) {
        super.removeNode(node);
        addNodeToCache(node);
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList
    protected void removeAllNodes() {
        int min = Math.min(this.size, this.maximumCacheSize - this.cacheSize);
        AbstractLinkedList.Node node = this.header.next;
        int i = 0;
        while (i < min) {
            AbstractLinkedList.Node node2 = node.next;
            addNodeToCache(node);
            i++;
            node = node2;
        }
        super.removeAllNodes();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }
}
