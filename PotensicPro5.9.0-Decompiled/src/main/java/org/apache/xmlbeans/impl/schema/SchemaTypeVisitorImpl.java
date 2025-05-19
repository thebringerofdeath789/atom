package org.apache.xmlbeans.impl.schema;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.impl.values.TypeStoreVisitor;

/* loaded from: classes5.dex */
public class SchemaTypeVisitorImpl implements TypeStoreVisitor {
    static final /* synthetic */ boolean $assertionsDisabled;
    static final boolean CHECK_VALIDITY = false;
    static final boolean PROBE_VALIDITY = true;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$SchemaTypeVisitorImpl;
    private boolean _isValid;
    private SchemaParticle _matchedParticle;
    private VisitorState[] _rollback;
    private int _rollbackIndex;
    int _rollbackSize;
    private VisitorState[] _stack;
    int _stackSize;
    private VisitorState _top;

    static {
        if (class$org$apache$xmlbeans$impl$schema$SchemaTypeVisitorImpl == null) {
            class$org$apache$xmlbeans$impl$schema$SchemaTypeVisitorImpl = class$("org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl");
        }
        $assertionsDisabled = true;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public SchemaTypeVisitorImpl(SchemaParticle schemaParticle) {
        init(schemaParticle);
    }

    public SchemaTypeVisitorImpl() {
    }

    public void init(SchemaParticle schemaParticle) {
        if (this._stack == null) {
            this._stack = expand(null);
        }
        if (this._rollback == null) {
            this._rollback = expand(null);
        }
        this._stackSize = 0;
        this._rollbackSize = 0;
        if (schemaParticle != null) {
            push(schemaParticle);
            this._rollbackIndex = 1;
        }
    }

    public VisitorState[] expand(VisitorState[] visitorStateArr) {
        int length = visitorStateArr == null ? 4 : visitorStateArr.length * 2;
        VisitorState[] visitorStateArr2 = new VisitorState[length];
        if (visitorStateArr != null) {
            System.arraycopy(visitorStateArr, 0, visitorStateArr2, 0, visitorStateArr.length);
        }
        for (int length2 = visitorStateArr != null ? visitorStateArr.length : 0; length2 < length; length2++) {
            visitorStateArr2[length2] = new VisitorState();
        }
        return visitorStateArr2;
    }

    private static class VisitorState {
        int _childCount;
        int _curCount;
        int _curMax;
        int _curMin;
        SchemaParticle _curPart;
        int _processedChildCount;
        boolean[] _seen;

        private VisitorState() {
        }

        public void copy(VisitorState visitorState) {
            this._curPart = visitorState._curPart;
            this._curCount = visitorState._curCount;
            this._curMin = visitorState._curMin;
            this._curMax = visitorState._curMax;
            this._processedChildCount = visitorState._processedChildCount;
            this._childCount = visitorState._childCount;
            boolean[] zArr = visitorState._seen;
            if (zArr != null) {
                boolean[] zArr2 = new boolean[zArr.length];
                this._seen = zArr2;
                boolean[] zArr3 = visitorState._seen;
                System.arraycopy(zArr3, 0, zArr2, 0, zArr3.length);
            }
        }

        public void init(SchemaParticle schemaParticle) {
            this._curPart = schemaParticle;
            this._curMin = schemaParticle.getIntMinOccurs();
            this._curMax = schemaParticle.getIntMaxOccurs();
            this._curCount = 0;
            this._processedChildCount = 0;
            this._childCount = schemaParticle.countOfParticleChild();
            this._seen = schemaParticle.getParticleType() == 1 ? new boolean[this._childCount] : null;
        }
    }

    VisitorState topRef() {
        return this._stack[this._stackSize - 1];
    }

    void saveCopy(VisitorState visitorState) {
        VisitorState[] visitorStateArr = this._rollback;
        if (visitorStateArr.length == this._rollbackSize) {
            this._rollback = expand(visitorStateArr);
        }
        this._rollback[this._rollbackSize].copy(visitorState);
        this._rollbackSize++;
    }

    void addParticle(SchemaParticle schemaParticle) {
        VisitorState[] visitorStateArr = this._stack;
        if (visitorStateArr.length == this._stackSize) {
            this._stack = expand(visitorStateArr);
        }
        this._stack[this._stackSize].init(schemaParticle);
        this._stackSize++;
    }

    boolean prepare() {
        if (this._rollbackIndex == 0) {
            this._top = null;
            return false;
        }
        VisitorState visitorState = topRef();
        this._top = visitorState;
        saveCopy(visitorState);
        this._rollbackIndex = this._stackSize - 1;
        return true;
    }

    void push(SchemaParticle schemaParticle) {
        addParticle(schemaParticle);
        this._top = topRef();
    }

    boolean pop() {
        int i = this._stackSize - 1;
        this._stackSize = i;
        if (i <= this._rollbackIndex) {
            return prepare();
        }
        this._top = topRef();
        return true;
    }

    void commit() {
        this._top = null;
        this._rollbackIndex = this._stackSize;
        this._rollbackSize = 0;
    }

    void rollback() {
        while (true) {
            int i = this._rollbackSize;
            if (i > 0) {
                int i2 = i - 1;
                this._rollbackSize = i2;
                VisitorState[] visitorStateArr = this._stack;
                int i3 = this._rollbackIndex;
                VisitorState visitorState = visitorStateArr[i3];
                VisitorState[] visitorStateArr2 = this._rollback;
                visitorStateArr[i3] = visitorStateArr2[i2];
                visitorStateArr2[i2] = visitorState;
                this._rollbackIndex = i3 + 1;
            } else {
                this._stackSize = this._rollbackIndex;
                this._top = null;
                return;
            }
        }
    }

    boolean notValid() {
        this._isValid = false;
        this._matchedParticle = null;
        rollback();
        return false;
    }

    boolean ok(SchemaParticle schemaParticle, boolean z) {
        if (!z) {
            this._matchedParticle = schemaParticle;
            commit();
            return true;
        }
        rollback();
        return true;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreVisitor
    public boolean visit(QName qName) {
        return visit(qName, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x00cc, code lost:
    
        r8._top._processedChildCount = r2 + 1;
        push(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x00f5, code lost:
    
        r8._top._curCount++;
        r8._top._processedChildCount = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0052, code lost:
    
        if (r2 == 4) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0055, code lost:
    
        if (r2 == 5) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0059, code lost:
    
        if (org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl.$assertionsDisabled == false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0061, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x006a, code lost:
    
        if (r8._top._curPart.canStartWithElement(r9) != false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0074, code lost:
    
        if (r8._top._curCount >= r8._top._curMin) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x007a, code lost:
    
        return notValid();
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x007b, code lost:
    
        r8._top._curCount++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x008a, code lost:
    
        return ok(r8._top._curPart, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0093, code lost:
    
        if (r8._top._curPart.canStartWithElement(r9) != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x009d, code lost:
    
        if (r8._top._curCount >= r8._top._curMin) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x00a3, code lost:
    
        return notValid();
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x00a4, code lost:
    
        r8._top._curCount++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x00b3, code lost:
    
        return ok(r8._top._curPart, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0198, code lost:
    
        if (r9 != null) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x019f, code lost:
    
        return ok(null, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x01a4, code lost:
    
        return notValid();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        r2 = r8._top._curPart.getParticleType();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0049, code lost:
    
        if (r2 == 1) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x013e, code lost:
    
        r2 = r8._top._processedChildCount;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0147, code lost:
    
        if (r5 >= r8._top._childCount) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x014f, code lost:
    
        if (r8._top._seen[r5] == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0152, code lost:
    
        r6 = r8._top._curPart.getParticleChild(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x015e, code lost:
    
        if (r6.canStartWithElement(r9) == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0176, code lost:
    
        if (r6.isSkippable() == false) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0178, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x017a, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0160, code lost:
    
        r8._top._processedChildCount++;
        r8._top._seen[r5] = true;
        push(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0181, code lost:
    
        if (r2 >= r8._top._childCount) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01a5, code lost:
    
        r8._top._curCount++;
        r8._top._processedChildCount = 0;
        java.util.Arrays.fill(r8._top._seen, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x018b, code lost:
    
        if (r8._top._curCount >= r8._top._curMin) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0196, code lost:
    
        if (pop() != false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0191, code lost:
    
        return notValid();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x004c, code lost:
    
        if (r2 == 2) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0106, code lost:
    
        if (r3 >= r8._top._childCount) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0108, code lost:
    
        r2 = r8._top._curPart.getParticleChild(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0114, code lost:
    
        if (r2.canStartWithElement(r9) == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0122, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0116, code lost:
    
        r8._top._curCount++;
        push(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x012d, code lost:
    
        if (r8._top._curCount >= r8._top._curMin) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0137, code lost:
    
        if (r8._top._curPart.isSkippable() != false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x013d, code lost:
    
        return notValid();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x004f, code lost:
    
        if (r2 == 3) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00b4, code lost:
    
        r2 = r8._top._processedChildCount;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x00bc, code lost:
    
        if (r2 >= r8._top._childCount) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00be, code lost:
    
        r5 = r8._top._curPart.getParticleChild(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00ca, code lost:
    
        if (r5.canStartWithElement(r9) == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00db, code lost:
    
        if (r5.isSkippable() != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00f2, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x00e1, code lost:
    
        if (r8._top._processedChildCount != 0) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00eb, code lost:
    
        if (r8._top._curCount >= r8._top._curMin) goto L98;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean visit(aavax.xml.namespace.QName r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 441
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl.visit(aavax.xml.namespace.QName, boolean):boolean");
    }

    public boolean testValid(QName qName) {
        return visit(qName, true);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreVisitor
    public int get_elementflags() {
        if (currentParticle() == null || currentParticle().getParticleType() != 4) {
            return 0;
        }
        SchemaLocalElement schemaLocalElement = (SchemaLocalElement) currentParticle();
        return (schemaLocalElement.isNillable() ? 1 : 0) | (schemaLocalElement.isDefault() ? 2 : 0) | (schemaLocalElement.isFixed() ? 4 : 0);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreVisitor
    public String get_default_text() {
        if (currentParticle() == null || currentParticle().getParticleType() != 4) {
            return null;
        }
        return ((SchemaLocalElement) currentParticle()).getDefaultText();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreVisitor
    public SchemaField get_schema_field() {
        if (currentParticle() instanceof SchemaField) {
            return (SchemaField) currentParticle();
        }
        return null;
    }

    public SchemaParticle currentParticle() {
        return this._matchedParticle;
    }

    public boolean isAllValid() {
        return this._isValid;
    }
}
