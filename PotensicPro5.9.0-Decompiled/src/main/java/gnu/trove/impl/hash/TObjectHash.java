package gnu.trove.impl.hash;

import gnu.trove.procedure.TObjectProcedure;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class TObjectHash<T> extends THash {
    static final long serialVersionUID = -3461112548087185871L;
    public transient Object[] _set;
    protected boolean consumeFreeSlot;
    public static final Object REMOVED = new Object();
    public static final Object FREE = new Object();

    public TObjectHash() {
    }

    public TObjectHash(int i) {
        super(i);
    }

    public TObjectHash(int i, float f) {
        super(i, f);
    }

    @Override // gnu.trove.impl.hash.THash
    public int capacity() {
        return this._set.length;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._set[i] = REMOVED;
        super.removeAt(i);
    }

    @Override // gnu.trove.impl.hash.THash
    public int setUp(int i) {
        int up = super.setUp(i);
        Object[] objArr = new Object[up];
        this._set = objArr;
        Arrays.fill(objArr, FREE);
        return up;
    }

    public boolean forEach(TObjectProcedure<? super T> tObjectProcedure) {
        Object[] objArr = this._set;
        int length = objArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && !tObjectProcedure.execute(objArr[i])) {
                return false;
            }
            length = i;
        }
    }

    public boolean contains(Object obj) {
        return index(obj) >= 0;
    }

    protected int index(Object obj) {
        if (obj == null) {
            return indexForNull();
        }
        int hash = hash(obj) & Integer.MAX_VALUE;
        Object[] objArr = this._set;
        int length = hash % objArr.length;
        Object obj2 = objArr[length];
        if (obj2 == FREE) {
            return -1;
        }
        return (obj2 == obj || equals(obj, obj2)) ? length : indexRehashed(obj, length, hash, obj2);
    }

    private int indexRehashed(Object obj, int i, int i2, Object obj2) {
        Object[] objArr = this._set;
        int length = objArr.length;
        int i3 = (i2 % (length - 2)) + 1;
        int i4 = i;
        do {
            i4 -= i3;
            if (i4 < 0) {
                i4 += length;
            }
            Object obj3 = objArr[i4];
            if (obj3 == FREE) {
                return -1;
            }
            if (obj3 == obj || equals(obj, obj3)) {
                return i4;
            }
        } while (i4 != i);
        return -1;
    }

    private int indexForNull() {
        int i = 0;
        for (Object obj : this._set) {
            if (obj == null) {
                return i;
            }
            if (obj == FREE) {
                return -1;
            }
            i++;
        }
        return -1;
    }

    @Deprecated
    protected int insertionIndex(T t) {
        return insertKey(t);
    }

    protected int insertKey(T t) {
        this.consumeFreeSlot = false;
        if (t == null) {
            return insertKeyForNull();
        }
        int hash = hash(t) & Integer.MAX_VALUE;
        Object[] objArr = this._set;
        int length = hash % objArr.length;
        Object obj = objArr[length];
        if (obj != FREE) {
            return (obj == t || equals(t, obj)) ? (-length) - 1 : insertKeyRehash(t, length, hash, obj);
        }
        this.consumeFreeSlot = true;
        objArr[length] = t;
        return length;
    }

    private int insertKeyRehash(T t, int i, int i2, Object obj) {
        Object[] objArr = this._set;
        int length = objArr.length;
        int i3 = (i2 % (length - 2)) + 1;
        int i4 = i;
        int i5 = -1;
        do {
            if (obj == REMOVED && i5 == -1) {
                i5 = i4;
            }
            i4 -= i3;
            if (i4 < 0) {
                i4 += length;
            }
            obj = objArr[i4];
            if (obj == FREE) {
                if (i5 != -1) {
                    this._set[i5] = t;
                    return i5;
                }
                this.consumeFreeSlot = true;
                this._set[i4] = t;
                return i4;
            }
            if (obj == t || equals(t, obj)) {
                return (-i4) - 1;
            }
        } while (i4 != i);
        if (i5 != -1) {
            this._set[i5] = t;
            return i5;
        }
        throw new IllegalStateException("No free or removed slots available. Key set full?!!");
    }

    private int insertKeyForNull() {
        int i = 0;
        int i2 = -1;
        for (Object obj : this._set) {
            if (obj == REMOVED && i2 == -1) {
                i2 = i;
            }
            if (obj == FREE) {
                if (i2 != -1) {
                    this._set[i2] = null;
                    return i2;
                }
                this.consumeFreeSlot = true;
                this._set[i] = null;
                return i;
            }
            if (obj == null) {
                return (-i) - 1;
            }
            i++;
        }
        if (i2 != -1) {
            this._set[i2] = null;
            return i2;
        }
        throw new IllegalStateException("Could not find insertion index for null key. Key set full!?!!");
    }

    protected final void throwObjectContractViolation(Object obj, Object obj2) throws IllegalArgumentException {
        throw buildObjectContractViolation(obj, obj2, "");
    }

    protected final void throwObjectContractViolation(Object obj, Object obj2, int i, int i2, Object[] objArr) throws IllegalArgumentException {
        throw buildObjectContractViolation(obj, obj2, dumpExtraInfo(obj, obj2, size(), i2, objArr));
    }

    protected final IllegalArgumentException buildObjectContractViolation(Object obj, Object obj2, String str) {
        return new IllegalArgumentException("Equal objects must have equal hashcodes. During rehashing, Trove discovered that the following two objects claim to be equal (as in java.lang.Object.equals()) but their hashCodes (or those calculated by your TObjectHashingStrategy) are not equal.This violates the general contract of java.lang.Object.hashCode().  See bullet point two in that method's documentation. object #1 =" + objectInfo(obj) + "; object #2 =" + objectInfo(obj2) + "\n" + str);
    }

    protected boolean equals(Object obj, Object obj2) {
        if (obj2 == null || obj2 == REMOVED) {
            return false;
        }
        return obj.equals(obj2);
    }

    protected int hash(Object obj) {
        return obj.hashCode();
    }

    protected static String reportPotentialConcurrentMod(int i, int i2) {
        return i != i2 ? "[Warning] apparent concurrent modification of the key set. Size before and after rehash() do not match " + i2 + " vs " + i : "";
    }

    protected String dumpExtraInfo(Object obj, Object obj2, int i, int i2, Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(dumpKeyTypes(obj, obj2));
        sb.append(reportPotentialConcurrentMod(i, i2));
        sb.append(detectKeyLoss(objArr, i2));
        if (obj == obj2) {
            sb.append("Inserting same object twice, rehashing bug. Object= ").append(obj2);
        }
        return sb.toString();
    }

    private static String detectKeyLoss(Object[] objArr, int i) {
        StringBuilder sb = new StringBuilder();
        Set<Object> makeKeySet = makeKeySet(objArr);
        if (makeKeySet.size() != i) {
            sb.append("\nhashCode() and/or equals() have inconsistent implementation");
            sb.append("\nKey set lost entries, now got ").append(makeKeySet.size()).append(" instead of ").append(i);
            sb.append(". This can manifest itself as an apparent duplicate key.");
        }
        return sb.toString();
    }

    private static Set<Object> makeKeySet(Object[] objArr) {
        HashSet hashSet = new HashSet();
        for (Object obj : objArr) {
            if (obj != FREE && obj != REMOVED) {
                hashSet.add(obj);
            }
        }
        return hashSet;
    }

    private static String equalsSymmetryInfo(Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        if (obj == obj2) {
            return "a == b";
        }
        if (obj.getClass() != obj2.getClass()) {
            sb.append("Class of objects differ a=").append(obj.getClass()).append(" vs b=").append(obj2.getClass());
            boolean equals = obj.equals(obj2);
            boolean equals2 = obj2.equals(obj);
            if (equals != equals2) {
                sb.append("\nequals() of a or b object are asymmetric");
                sb.append("\na.equals(b) =").append(equals);
                sb.append("\nb.equals(a) =").append(equals2);
            }
        }
        return sb.toString();
    }

    protected static String objectInfo(Object obj) {
        return (obj == null ? "class null" : obj.getClass()) + " id= " + System.identityHashCode(obj) + " hashCode= " + (obj == null ? 0 : obj.hashCode()) + " toString= " + String.valueOf(obj);
    }

    private String dumpKeyTypes(Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        HashSet hashSet = new HashSet();
        for (Object obj3 : this._set) {
            if (obj3 != FREE && obj3 != REMOVED) {
                if (obj3 != null) {
                    hashSet.add(obj3.getClass());
                } else {
                    hashSet.add(null);
                }
            }
        }
        if (hashSet.size() > 1) {
            sb.append("\nMore than one type used for keys. Watch out for asymmetric equals(). Read about the 'Liskov substitution principle' and the implications for equals() in java.");
            sb.append("\nKey types: ").append(hashSet);
            sb.append(equalsSymmetryInfo(obj, obj2));
        }
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.THash, java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        super.writeExternal(objectOutput);
    }

    @Override // gnu.trove.impl.hash.THash, java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        super.readExternal(objectInput);
    }
}
