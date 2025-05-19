package org.apache.commons.collections.map;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections.IterableMap;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.keyvalue.MultiKey;
import org.apache.commons.collections.map.AbstractHashedMap;

/* loaded from: classes4.dex */
public class MultiKeyMap implements IterableMap, Serializable {
    private static final long serialVersionUID = -1788199231038721040L;
    protected final AbstractHashedMap map;

    public static MultiKeyMap decorate(AbstractHashedMap abstractHashedMap) {
        if (abstractHashedMap == null) {
            throw new IllegalArgumentException("Map must not be null");
        }
        if (abstractHashedMap.size() > 0) {
            throw new IllegalArgumentException("Map must be empty");
        }
        return new MultiKeyMap(abstractHashedMap);
    }

    public MultiKeyMap() {
        this.map = new HashedMap();
    }

    protected MultiKeyMap(AbstractHashedMap abstractHashedMap) {
        this.map = abstractHashedMap;
    }

    public Object get(Object obj, Object obj2) {
        int hash = hash(obj, obj2);
        AbstractHashedMap.HashEntry[] hashEntryArr = this.map.data;
        AbstractHashedMap abstractHashedMap = this.map;
        for (AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(hashEntry, obj, obj2)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    public boolean containsKey(Object obj, Object obj2) {
        int hash = hash(obj, obj2);
        AbstractHashedMap.HashEntry[] hashEntryArr = this.map.data;
        AbstractHashedMap abstractHashedMap = this.map;
        for (AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(hashEntry, obj, obj2)) {
                return true;
            }
        }
        return false;
    }

    public Object put(Object obj, Object obj2, Object obj3) {
        int hash = hash(obj, obj2);
        AbstractHashedMap abstractHashedMap = this.map;
        int hashIndex = abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length);
        for (AbstractHashedMap.HashEntry hashEntry = this.map.data[hashIndex]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(hashEntry, obj, obj2)) {
                Object value = hashEntry.getValue();
                this.map.updateEntry(hashEntry, obj3);
                return value;
            }
        }
        this.map.addMapping(hashIndex, hash, new MultiKey(obj, obj2), obj3);
        return null;
    }

    @Override // java.util.Map
    public Object remove(Object obj, Object obj2) {
        int hash = hash(obj, obj2);
        AbstractHashedMap abstractHashedMap = this.map;
        int hashIndex = abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length);
        AbstractHashedMap.HashEntry hashEntry = null;
        for (AbstractHashedMap.HashEntry hashEntry2 = this.map.data[hashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (hashEntry2.hashCode == hash && isEqualKey(hashEntry2, obj, obj2)) {
                Object value = hashEntry2.getValue();
                this.map.removeMapping(hashEntry2, hashIndex, hashEntry);
                return value;
            }
            hashEntry = hashEntry2;
        }
        return null;
    }

    protected int hash(Object obj, Object obj2) {
        int hashCode = obj != null ? 0 ^ obj.hashCode() : 0;
        if (obj2 != null) {
            hashCode ^= obj2.hashCode();
        }
        int i = hashCode + (~(hashCode << 9));
        int i2 = (i >>> 14) ^ i;
        int i3 = i2 + (i2 << 4);
        return i3 ^ (i3 >>> 10);
    }

    protected boolean isEqualKey(AbstractHashedMap.HashEntry hashEntry, Object obj, Object obj2) {
        MultiKey multiKey = (MultiKey) hashEntry.getKey();
        if (multiKey.size() == 2 && (obj != null ? obj.equals(multiKey.getKey(0)) : multiKey.getKey(0) == null)) {
            Object key = multiKey.getKey(1);
            if (obj2 == null) {
                if (key == null) {
                    return true;
                }
            } else if (obj2.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Object get(Object obj, Object obj2, Object obj3) {
        int hash = hash(obj, obj2, obj3);
        AbstractHashedMap.HashEntry[] hashEntryArr = this.map.data;
        AbstractHashedMap abstractHashedMap = this.map;
        for (AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(hashEntry, obj, obj2, obj3)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    public boolean containsKey(Object obj, Object obj2, Object obj3) {
        int hash = hash(obj, obj2, obj3);
        AbstractHashedMap.HashEntry[] hashEntryArr = this.map.data;
        AbstractHashedMap abstractHashedMap = this.map;
        for (AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(hashEntry, obj, obj2, obj3)) {
                return true;
            }
        }
        return false;
    }

    public Object put(Object obj, Object obj2, Object obj3, Object obj4) {
        int hash = hash(obj, obj2, obj3);
        AbstractHashedMap abstractHashedMap = this.map;
        int hashIndex = abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length);
        for (AbstractHashedMap.HashEntry hashEntry = this.map.data[hashIndex]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(hashEntry, obj, obj2, obj3)) {
                Object value = hashEntry.getValue();
                this.map.updateEntry(hashEntry, obj4);
                return value;
            }
        }
        this.map.addMapping(hashIndex, hash, new MultiKey(obj, obj2, obj3), obj4);
        return null;
    }

    public Object remove(Object obj, Object obj2, Object obj3) {
        int hash = hash(obj, obj2, obj3);
        AbstractHashedMap abstractHashedMap = this.map;
        int hashIndex = abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length);
        AbstractHashedMap.HashEntry hashEntry = null;
        for (AbstractHashedMap.HashEntry hashEntry2 = this.map.data[hashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (hashEntry2.hashCode == hash && isEqualKey(hashEntry2, obj, obj2, obj3)) {
                Object value = hashEntry2.getValue();
                this.map.removeMapping(hashEntry2, hashIndex, hashEntry);
                return value;
            }
            hashEntry = hashEntry2;
        }
        return null;
    }

    protected int hash(Object obj, Object obj2, Object obj3) {
        int hashCode = obj != null ? 0 ^ obj.hashCode() : 0;
        if (obj2 != null) {
            hashCode ^= obj2.hashCode();
        }
        if (obj3 != null) {
            hashCode ^= obj3.hashCode();
        }
        int i = hashCode + (~(hashCode << 9));
        int i2 = (i >>> 14) ^ i;
        int i3 = i2 + (i2 << 4);
        return i3 ^ (i3 >>> 10);
    }

    protected boolean isEqualKey(AbstractHashedMap.HashEntry hashEntry, Object obj, Object obj2, Object obj3) {
        MultiKey multiKey = (MultiKey) hashEntry.getKey();
        if (multiKey.size() == 3 && (obj != null ? obj.equals(multiKey.getKey(0)) : multiKey.getKey(0) == null)) {
            Object key = multiKey.getKey(1);
            if (obj2 != null ? obj2.equals(key) : key == null) {
                Object key2 = multiKey.getKey(2);
                if (obj3 == null) {
                    if (key2 == null) {
                        return true;
                    }
                } else if (obj3.equals(key2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Object get(Object obj, Object obj2, Object obj3, Object obj4) {
        int hash = hash(obj, obj2, obj3, obj4);
        AbstractHashedMap.HashEntry[] hashEntryArr = this.map.data;
        AbstractHashedMap abstractHashedMap = this.map;
        for (AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(hashEntry, obj, obj2, obj3, obj4)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    public boolean containsKey(Object obj, Object obj2, Object obj3, Object obj4) {
        int hash = hash(obj, obj2, obj3, obj4);
        AbstractHashedMap.HashEntry[] hashEntryArr = this.map.data;
        AbstractHashedMap abstractHashedMap = this.map;
        for (AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(hashEntry, obj, obj2, obj3, obj4)) {
                return true;
            }
        }
        return false;
    }

    public Object put(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int hash = hash(obj, obj2, obj3, obj4);
        AbstractHashedMap abstractHashedMap = this.map;
        int hashIndex = abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length);
        for (AbstractHashedMap.HashEntry hashEntry = this.map.data[hashIndex]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(hashEntry, obj, obj2, obj3, obj4)) {
                Object value = hashEntry.getValue();
                this.map.updateEntry(hashEntry, obj5);
                return value;
            }
        }
        this.map.addMapping(hashIndex, hash, new MultiKey(obj, obj2, obj3, obj4), obj5);
        return null;
    }

    public Object remove(Object obj, Object obj2, Object obj3, Object obj4) {
        int hash = hash(obj, obj2, obj3, obj4);
        AbstractHashedMap abstractHashedMap = this.map;
        int hashIndex = abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length);
        AbstractHashedMap.HashEntry hashEntry = null;
        for (AbstractHashedMap.HashEntry hashEntry2 = this.map.data[hashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (hashEntry2.hashCode == hash && isEqualKey(hashEntry2, obj, obj2, obj3, obj4)) {
                Object value = hashEntry2.getValue();
                this.map.removeMapping(hashEntry2, hashIndex, hashEntry);
                return value;
            }
            hashEntry = hashEntry2;
        }
        return null;
    }

    protected int hash(Object obj, Object obj2, Object obj3, Object obj4) {
        int hashCode = obj != null ? 0 ^ obj.hashCode() : 0;
        if (obj2 != null) {
            hashCode ^= obj2.hashCode();
        }
        if (obj3 != null) {
            hashCode ^= obj3.hashCode();
        }
        if (obj4 != null) {
            hashCode ^= obj4.hashCode();
        }
        int i = hashCode + (~(hashCode << 9));
        int i2 = (i >>> 14) ^ i;
        int i3 = i2 + (i2 << 4);
        return i3 ^ (i3 >>> 10);
    }

    protected boolean isEqualKey(AbstractHashedMap.HashEntry hashEntry, Object obj, Object obj2, Object obj3, Object obj4) {
        MultiKey multiKey = (MultiKey) hashEntry.getKey();
        if (multiKey.size() == 4 && (obj != null ? obj.equals(multiKey.getKey(0)) : multiKey.getKey(0) == null)) {
            Object key = multiKey.getKey(1);
            if (obj2 != null ? obj2.equals(key) : key == null) {
                Object key2 = multiKey.getKey(2);
                if (obj3 != null ? obj3.equals(key2) : key2 == null) {
                    Object key3 = multiKey.getKey(3);
                    if (obj4 == null) {
                        if (key3 == null) {
                            return true;
                        }
                    } else if (obj4.equals(key3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Object get(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int hash = hash(obj, obj2, obj3, obj4, obj5);
        AbstractHashedMap.HashEntry[] hashEntryArr = this.map.data;
        AbstractHashedMap abstractHashedMap = this.map;
        for (AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(hashEntry, obj, obj2, obj3, obj4, obj5)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    public boolean containsKey(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int hash = hash(obj, obj2, obj3, obj4, obj5);
        AbstractHashedMap.HashEntry[] hashEntryArr = this.map.data;
        AbstractHashedMap abstractHashedMap = this.map;
        for (AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(hashEntry, obj, obj2, obj3, obj4, obj5)) {
                return true;
            }
        }
        return false;
    }

    public Object put(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        int hash = hash(obj, obj2, obj3, obj4, obj5);
        AbstractHashedMap abstractHashedMap = this.map;
        int hashIndex = abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length);
        for (AbstractHashedMap.HashEntry hashEntry = this.map.data[hashIndex]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(hashEntry, obj, obj2, obj3, obj4, obj5)) {
                Object value = hashEntry.getValue();
                this.map.updateEntry(hashEntry, obj6);
                return value;
            }
        }
        this.map.addMapping(hashIndex, hash, new MultiKey(obj, obj2, obj3, obj4, obj5), obj6);
        return null;
    }

    public Object remove(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int hash = hash(obj, obj2, obj3, obj4, obj5);
        AbstractHashedMap abstractHashedMap = this.map;
        int hashIndex = abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length);
        AbstractHashedMap.HashEntry hashEntry = null;
        for (AbstractHashedMap.HashEntry hashEntry2 = this.map.data[hashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (hashEntry2.hashCode == hash && isEqualKey(hashEntry2, obj, obj2, obj3, obj4, obj5)) {
                Object value = hashEntry2.getValue();
                this.map.removeMapping(hashEntry2, hashIndex, hashEntry);
                return value;
            }
            hashEntry = hashEntry2;
        }
        return null;
    }

    protected int hash(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int hashCode = obj != null ? 0 ^ obj.hashCode() : 0;
        if (obj2 != null) {
            hashCode ^= obj2.hashCode();
        }
        if (obj3 != null) {
            hashCode ^= obj3.hashCode();
        }
        if (obj4 != null) {
            hashCode ^= obj4.hashCode();
        }
        if (obj5 != null) {
            hashCode ^= obj5.hashCode();
        }
        int i = hashCode + (~(hashCode << 9));
        int i2 = (i >>> 14) ^ i;
        int i3 = i2 + (i2 << 4);
        return i3 ^ (i3 >>> 10);
    }

    protected boolean isEqualKey(AbstractHashedMap.HashEntry hashEntry, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        MultiKey multiKey = (MultiKey) hashEntry.getKey();
        if (multiKey.size() == 5 && (obj != null ? obj.equals(multiKey.getKey(0)) : multiKey.getKey(0) == null)) {
            Object key = multiKey.getKey(1);
            if (obj2 != null ? obj2.equals(key) : key == null) {
                Object key2 = multiKey.getKey(2);
                if (obj3 != null ? obj3.equals(key2) : key2 == null) {
                    Object key3 = multiKey.getKey(3);
                    if (obj4 != null ? obj4.equals(key3) : key3 == null) {
                        Object key4 = multiKey.getKey(4);
                        if (obj5 == null) {
                            if (key4 == null) {
                                return true;
                            }
                        } else if (obj5.equals(key4)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean removeAll(Object obj) {
        MapIterator mapIterator = mapIterator();
        boolean z = false;
        while (mapIterator.hasNext()) {
            MultiKey multiKey = (MultiKey) mapIterator.next();
            if (multiKey.size() >= 1) {
                Object key = multiKey.getKey(0);
                if (obj == null) {
                    if (key == null) {
                        mapIterator.remove();
                        z = true;
                    }
                } else if (obj.equals(key)) {
                    mapIterator.remove();
                    z = true;
                }
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x002f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean removeAll(java.lang.Object r8, java.lang.Object r9) {
        /*
            r7 = this;
            org.apache.commons.collections.MapIterator r0 = r7.mapIterator()
            r1 = 0
            r2 = r1
        L6:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L3d
            java.lang.Object r3 = r0.next()
            org.apache.commons.collections.keyvalue.MultiKey r3 = (org.apache.commons.collections.keyvalue.MultiKey) r3
            int r4 = r3.size()
            r5 = 2
            r6 = 1
            if (r4 < r5) goto L6
            java.lang.Object r4 = r3.getKey(r1)
            if (r8 != 0) goto L23
            if (r4 != 0) goto L6
            goto L29
        L23:
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L6
        L29:
            java.lang.Object r3 = r3.getKey(r6)
            if (r9 != 0) goto L32
            if (r3 != 0) goto L6
            goto L38
        L32:
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L6
        L38:
            r0.remove()
            r2 = r6
            goto L6
        L3d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections.map.MultiKeyMap.removeAll(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x003f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x002f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean removeAll(java.lang.Object r8, java.lang.Object r9, java.lang.Object r10) {
        /*
            r7 = this;
            org.apache.commons.collections.MapIterator r0 = r7.mapIterator()
            r1 = 0
            r2 = r1
        L6:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L4d
            java.lang.Object r3 = r0.next()
            org.apache.commons.collections.keyvalue.MultiKey r3 = (org.apache.commons.collections.keyvalue.MultiKey) r3
            int r4 = r3.size()
            r5 = 3
            r6 = 1
            if (r4 < r5) goto L6
            java.lang.Object r4 = r3.getKey(r1)
            if (r8 != 0) goto L23
            if (r4 != 0) goto L6
            goto L29
        L23:
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L6
        L29:
            java.lang.Object r4 = r3.getKey(r6)
            if (r9 != 0) goto L32
            if (r4 != 0) goto L6
            goto L38
        L32:
            boolean r4 = r9.equals(r4)
            if (r4 == 0) goto L6
        L38:
            r4 = 2
            java.lang.Object r3 = r3.getKey(r4)
            if (r10 != 0) goto L42
            if (r3 != 0) goto L6
            goto L48
        L42:
            boolean r3 = r10.equals(r3)
            if (r3 == 0) goto L6
        L48:
            r0.remove()
            r2 = r6
            goto L6
        L4d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections.map.MultiKeyMap.removeAll(java.lang.Object, java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x004f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x003f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x002f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean removeAll(java.lang.Object r8, java.lang.Object r9, java.lang.Object r10, java.lang.Object r11) {
        /*
            r7 = this;
            org.apache.commons.collections.MapIterator r0 = r7.mapIterator()
            r1 = 0
            r2 = r1
        L6:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L5d
            java.lang.Object r3 = r0.next()
            org.apache.commons.collections.keyvalue.MultiKey r3 = (org.apache.commons.collections.keyvalue.MultiKey) r3
            int r4 = r3.size()
            r5 = 4
            r6 = 1
            if (r4 < r5) goto L6
            java.lang.Object r4 = r3.getKey(r1)
            if (r8 != 0) goto L23
            if (r4 != 0) goto L6
            goto L29
        L23:
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L6
        L29:
            java.lang.Object r4 = r3.getKey(r6)
            if (r9 != 0) goto L32
            if (r4 != 0) goto L6
            goto L38
        L32:
            boolean r4 = r9.equals(r4)
            if (r4 == 0) goto L6
        L38:
            r4 = 2
            java.lang.Object r4 = r3.getKey(r4)
            if (r10 != 0) goto L42
            if (r4 != 0) goto L6
            goto L48
        L42:
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L6
        L48:
            r4 = 3
            java.lang.Object r3 = r3.getKey(r4)
            if (r11 != 0) goto L52
            if (r3 != 0) goto L6
            goto L58
        L52:
            boolean r3 = r11.equals(r3)
            if (r3 == 0) goto L6
        L58:
            r0.remove()
            r2 = r6
            goto L6
        L5d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections.map.MultiKeyMap.removeAll(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):boolean");
    }

    protected void checkKey(Object obj) {
        Objects.requireNonNull(obj, "Key must not be null");
        if (!(obj instanceof MultiKey)) {
            throw new ClassCastException("Key must be a MultiKey");
        }
    }

    public Object clone() {
        return new MultiKeyMap((AbstractHashedMap) this.map.clone());
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        checkKey(obj);
        return this.map.put(obj, obj2);
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            checkKey(it.next());
        }
        this.map.putAll(map);
    }

    @Override // org.apache.commons.collections.IterableMap
    public MapIterator mapIterator() {
        return this.map.mapIterator();
    }

    @Override // java.util.Map
    public int size() {
        return this.map.size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.map.get(obj);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.map.remove(obj);
    }

    @Override // java.util.Map
    public void clear() {
        this.map.clear();
    }

    @Override // java.util.Map
    public Set keySet() {
        return this.map.keySet();
    }

    @Override // java.util.Map
    public Collection values() {
        return this.map.values();
    }

    @Override // java.util.Map
    public Set entrySet() {
        return this.map.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return this.map.equals(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        return this.map.toString();
    }
}
