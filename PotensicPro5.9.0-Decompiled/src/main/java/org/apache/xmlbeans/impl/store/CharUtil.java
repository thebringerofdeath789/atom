package org.apache.xmlbeans.impl.store;

import java.io.PrintStream;
import java.lang.ref.SoftReference;

/* loaded from: classes5.dex */
public final class CharUtil {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static int CHARUTIL_INITIAL_BUFSIZE = 0;
    private static final int MAX_COPY = 64;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$CharUtil;
    private static ThreadLocal tl_charUtil;
    public int _cchSrc;
    private int _charBufSize;
    private CharIterator _charIter = new CharIterator();
    private char[] _currentBuffer;
    private int _currentOffset;
    public int _offSrc;

    public static final boolean isWhiteSpace(char c) {
        return c == '\t' || c == '\n' || c == '\r' || c == ' ';
    }

    static {
        if (class$org$apache$xmlbeans$impl$store$CharUtil == null) {
            class$org$apache$xmlbeans$impl$store$CharUtil = class$("org.apache.xmlbeans.impl.store.CharUtil");
        }
        $assertionsDisabled = true;
        CHARUTIL_INITIAL_BUFSIZE = 32768;
        tl_charUtil = new ThreadLocal() { // from class: org.apache.xmlbeans.impl.store.CharUtil.1
            @Override // java.lang.ThreadLocal
            protected Object initialValue() {
                return new SoftReference(new CharUtil(CharUtil.CHARUTIL_INITIAL_BUFSIZE));
            }
        };
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public CharUtil(int i) {
        this._charBufSize = i;
    }

    public CharIterator getCharIterator(Object obj, int i, int i2) {
        this._charIter.init(obj, i, i2);
        return this._charIter;
    }

    public CharIterator getCharIterator(Object obj, int i, int i2, int i3) {
        this._charIter.init(obj, i, i2, i3);
        return this._charIter;
    }

    public static CharUtil getThreadLocalCharUtil() {
        CharUtil charUtil = (CharUtil) ((SoftReference) tl_charUtil.get()).get();
        if (charUtil != null) {
            return charUtil;
        }
        CharUtil charUtil2 = new CharUtil(CHARUTIL_INITIAL_BUFSIZE);
        tl_charUtil.set(new SoftReference(charUtil2));
        return charUtil2;
    }

    public static void getString(StringBuffer stringBuffer, Object obj, int i, int i2) {
        if (!$assertionsDisabled && !isValid(obj, i, i2)) {
            throw new AssertionError();
        }
        if (i2 == 0) {
            return;
        }
        if (obj instanceof char[]) {
            stringBuffer.append((char[]) obj, i, i2);
            return;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (i == 0 && i2 == str.length()) {
                stringBuffer.append(str);
                return;
            } else {
                stringBuffer.append(str.substring(i, i2 + i));
                return;
            }
        }
        ((CharJoin) obj).getString(stringBuffer, i, i2);
    }

    public static void getChars(char[] cArr, int i, Object obj, int i2, int i3) {
        boolean z = $assertionsDisabled;
        if (!z && !isValid(obj, i2, i3)) {
            throw new AssertionError();
        }
        if (!z && (cArr == null || i < 0 || i > cArr.length)) {
            throw new AssertionError();
        }
        if (i3 == 0) {
            return;
        }
        if (obj instanceof char[]) {
            System.arraycopy((char[]) obj, i2, cArr, i, i3);
        } else if (obj instanceof String) {
            ((String) obj).getChars(i2, i3 + i2, cArr, i);
        } else {
            ((CharJoin) obj).getChars(cArr, i, i2, i3);
        }
    }

    public static String getString(Object obj, int i, int i2) {
        if (!$assertionsDisabled && !isValid(obj, i, i2)) {
            throw new AssertionError();
        }
        if (i2 == 0) {
            return "";
        }
        if (obj instanceof char[]) {
            return new String((char[]) obj, i, i2);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return (i == 0 && i2 == str.length()) ? str : str.substring(i, i2 + i);
        }
        StringBuffer stringBuffer = new StringBuffer();
        ((CharJoin) obj).getString(stringBuffer, i, i2);
        return stringBuffer.toString();
    }

    public final boolean isWhiteSpace(Object obj, int i, int i2) {
        if (!$assertionsDisabled && !isValid(obj, i, i2)) {
            throw new AssertionError();
        }
        boolean z = true;
        if (i2 <= 0) {
            return true;
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            while (i2 > 0) {
                int i3 = i + 1;
                if (!isWhiteSpace(cArr[i])) {
                    return false;
                }
                i2--;
                i = i3;
            }
            return true;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            while (i2 > 0) {
                int i4 = i + 1;
                if (!isWhiteSpace(str.charAt(i))) {
                    return false;
                }
                i2--;
                i = i4;
            }
            return true;
        }
        this._charIter.init(obj, i, i2);
        while (true) {
            if (!this._charIter.hasNext()) {
                break;
            }
            if (!isWhiteSpace(this._charIter.next())) {
                z = false;
                break;
            }
        }
        this._charIter.release();
        return z;
    }

    public Object stripLeft(Object obj, int i, int i2) {
        if (!$assertionsDisabled && !isValid(obj, i, i2)) {
            throw new AssertionError();
        }
        if (i2 > 0) {
            if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                while (i2 > 0 && isWhiteSpace(cArr[i])) {
                    i2--;
                    i++;
                }
            } else if (obj instanceof String) {
                String str = (String) obj;
                while (i2 > 0 && isWhiteSpace(str.charAt(i))) {
                    i2--;
                    i++;
                }
            } else {
                this._charIter.init(obj, i, i2);
                int i3 = 0;
                while (this._charIter.hasNext() && isWhiteSpace(this._charIter.next())) {
                    i3++;
                }
                this._charIter.release();
                i += i3;
            }
        }
        if (i2 == 0) {
            this._offSrc = 0;
            this._cchSrc = 0;
            return null;
        }
        this._offSrc = i;
        this._cchSrc = i2;
        return obj;
    }

    public Object stripRight(Object obj, int i, int i2) {
        if (!$assertionsDisabled && !isValid(obj, i, i2)) {
            throw new AssertionError();
        }
        if (i2 > 0) {
            this._charIter.init(obj, i, i2, i2);
            while (this._charIter.hasPrev() && isWhiteSpace(this._charIter.prev())) {
                i2--;
            }
            this._charIter.release();
        }
        if (i2 == 0) {
            this._offSrc = 0;
            this._cchSrc = 0;
            return null;
        }
        this._offSrc = i;
        this._cchSrc = i2;
        return obj;
    }

    public Object insertChars(int i, Object obj, int i2, int i3, Object obj2, int i4, int i5) {
        CharJoin charJoin;
        Object obj3;
        boolean z = $assertionsDisabled;
        if (!z && !isValid(obj, i2, i3)) {
            throw new AssertionError();
        }
        if (!z && !isValid(obj2, i4, i5)) {
            throw new AssertionError();
        }
        if (!z && (i < 0 || i > i3)) {
            throw new AssertionError();
        }
        if (i5 == 0) {
            this._cchSrc = i3;
            this._offSrc = i2;
            return obj;
        }
        if (i3 == 0) {
            this._cchSrc = i5;
            this._offSrc = i4;
            return obj2;
        }
        int i6 = i3 + i5;
        this._cchSrc = i6;
        if (i6 <= 64 && canAllocate(i6)) {
            char[] allocate = allocate(this._cchSrc);
            getChars(allocate, this._offSrc, obj, i2, i);
            getChars(allocate, this._offSrc + i, obj2, i4, i5);
            getChars(allocate, this._offSrc + i + i5, obj, i2 + i, i3 - i);
            obj3 = allocate;
        } else {
            this._offSrc = 0;
            if (i == 0) {
                charJoin = new CharJoin(obj2, i4, i5, obj, i2);
            } else if (i == i3) {
                charJoin = new CharJoin(obj, i2, i3, obj2, i4);
            } else {
                charJoin = new CharJoin(new CharJoin(obj, i2, i, obj2, i4), 0, i + i5, obj, i2 + i);
            }
            int i7 = charJoin._depth;
            obj3 = charJoin;
            if (i7 > 64) {
                obj3 = saveChars(charJoin, this._offSrc, this._cchSrc);
            }
        }
        if (z || isValid(obj3, this._offSrc, this._cchSrc)) {
            return obj3;
        }
        throw new AssertionError();
    }

    public Object removeChars(int i, int i2, Object obj, int i3, int i4) {
        boolean z = $assertionsDisabled;
        if (!z && !isValid(obj, i3, i4)) {
            throw new AssertionError();
        }
        if (!z && (i < 0 || i > i4)) {
            throw new AssertionError();
        }
        if (!z && (i2 < 0 || i + i2 > i4)) {
            throw new AssertionError();
        }
        int i5 = i4 - i2;
        this._cchSrc = i5;
        if (i5 == 0) {
            obj = null;
            this._offSrc = 0;
        } else if (i == 0) {
            this._offSrc = i3 + i2;
        } else if (i + i2 == i4) {
            this._offSrc = i3;
        } else if (i5 <= 64 && canAllocate(i5)) {
            char[] allocate = allocate(i5);
            getChars(allocate, this._offSrc, obj, i3, i);
            getChars(allocate, this._offSrc + i, obj, i3 + i + i2, (i4 - i) - i2);
            this._offSrc = this._offSrc;
            obj = allocate;
        } else {
            CharJoin charJoin = new CharJoin(obj, i3, i, obj, i3 + i + i2);
            if (charJoin._depth > 64) {
                obj = saveChars(charJoin, 0, this._cchSrc);
            } else {
                this._offSrc = 0;
                obj = charJoin;
            }
        }
        if (z || isValid(obj, this._offSrc, this._cchSrc)) {
            return obj;
        }
        throw new AssertionError();
    }

    private static int sizeof(Object obj) {
        if (!$assertionsDisabled && obj != null && !(obj instanceof String) && !(obj instanceof char[])) {
            throw new AssertionError();
        }
        if (obj instanceof char[]) {
            return ((char[]) obj).length;
        }
        if (obj == null) {
            return 0;
        }
        return ((String) obj).length();
    }

    private boolean canAllocate(int i) {
        char[] cArr = this._currentBuffer;
        return cArr == null || cArr.length - this._currentOffset >= i;
    }

    private char[] allocate(int i) {
        char[] cArr;
        boolean z = $assertionsDisabled;
        if (!z && (cArr = this._currentBuffer) != null && cArr.length - this._currentOffset <= 0) {
            throw new AssertionError();
        }
        if (this._currentBuffer == null) {
            this._currentBuffer = new char[Math.max(i, this._charBufSize)];
            this._currentOffset = 0;
        }
        int i2 = this._currentOffset;
        this._offSrc = i2;
        int min = Math.min(this._currentBuffer.length - i2, i);
        this._cchSrc = min;
        char[] cArr2 = this._currentBuffer;
        if (!z && this._currentOffset + min > cArr2.length) {
            throw new AssertionError();
        }
        int i3 = this._currentOffset + min;
        this._currentOffset = i3;
        if (i3 == cArr2.length) {
            this._currentBuffer = null;
            this._currentOffset = 0;
        }
        return cArr2;
    }

    public Object saveChars(Object obj, int i, int i2) {
        return saveChars(obj, i, i2, null, 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object saveChars(Object obj, int i, int i2, Object obj2, int i3, int i4) {
        Object obj3;
        Object obj4;
        boolean z = $assertionsDisabled;
        if (!z && !isValid(obj, i, i2)) {
            throw new AssertionError();
        }
        if (!z && !isValid(obj2, i3, i4)) {
            throw new AssertionError();
        }
        char[] allocate = allocate(i2);
        int i5 = this._offSrc;
        int i6 = this._cchSrc;
        if (!z && i6 > i2) {
            throw new AssertionError();
        }
        getChars(allocate, i5, obj, i, i6);
        int i7 = i6 + i4;
        int i8 = 0;
        if (i4 == 0) {
            obj3 = allocate;
        } else {
            if (obj2 == allocate && i3 + i4 == i5) {
                if (!z && !(obj2 instanceof char[])) {
                    throw new AssertionError();
                }
            } else {
                if (obj2 instanceof CharJoin) {
                    CharJoin charJoin = (CharJoin) obj2;
                    if (charJoin._srcRight == allocate && ((i3 + i4) - charJoin._cchLeft) + charJoin._offRight == i5) {
                        if (!z && !(charJoin._srcRight instanceof char[])) {
                            throw new AssertionError();
                        }
                    }
                }
                CharJoin charJoin2 = new CharJoin(obj2, i3, i4, allocate, i5);
                int i9 = charJoin2._depth;
                Object obj5 = charJoin2;
                if (i9 > 64) {
                    obj5 = saveChars(charJoin2, 0, i7);
                }
                i5 = 0;
                obj3 = obj5;
            }
            i5 = i3;
            obj3 = obj2;
        }
        int i10 = i2 - i6;
        if (i10 > 0) {
            char[] allocate2 = allocate(i10);
            int i11 = this._offSrc;
            int i12 = this._cchSrc;
            if (!z && i12 != i10) {
                throw new AssertionError();
            }
            if (!z && i11 != 0) {
                throw new AssertionError();
            }
            getChars(allocate2, i11, obj, i + (i2 - i10), i10);
            CharJoin charJoin3 = new CharJoin(obj3, i5, i7, allocate2, i11);
            i7 += i10;
            int i13 = charJoin3._depth;
            Object obj6 = charJoin3;
            if (i13 > 64) {
                obj6 = saveChars(charJoin3, 0, i7);
            }
            obj4 = obj6;
        } else {
            i8 = i5;
            obj4 = obj3;
        }
        this._offSrc = i8;
        this._cchSrc = i7;
        if (z || isValid(obj4, i8, i7)) {
            return obj4;
        }
        throw new AssertionError();
    }

    private static void dumpText(PrintStream printStream, String str) {
        printStream.print("\"");
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                break;
            }
            char charAt = str.charAt(i);
            if (i == 36) {
                printStream.print("...");
                break;
            }
            if (charAt == '\n') {
                printStream.print("\\n");
            } else if (charAt == '\r') {
                printStream.print("\\r");
            } else if (charAt == '\t') {
                printStream.print("\\t");
            } else if (charAt == '\f') {
                printStream.print("\\f");
            } else if (charAt == '\f') {
                printStream.print("\\f");
            } else if (charAt == '\"') {
                printStream.print("\\\"");
            } else {
                printStream.print(charAt);
            }
            i++;
        }
        printStream.print("\"");
    }

    public static void dump(Object obj, int i, int i2) {
        dumpChars(System.out, obj, i, i2);
        System.out.println();
    }

    public static void dumpChars(PrintStream printStream, Object obj, int i, int i2) {
        int i3;
        int i4;
        printStream.print(new StringBuffer().append("off=").append(i).append(", cch=").append(i2).append(", ").toString());
        if (obj == null) {
            printStream.print("<null-src>");
            return;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            printStream.print("String");
            if ((i != 0 || i2 != str.length()) && (i < 0 || i > str.length() || (i4 = i + i2) < 0 || i4 > str.length())) {
                printStream.print(" (Error)");
                return;
            } else {
                dumpText(printStream, str.substring(i, i2 + i));
                return;
            }
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            printStream.print("char[]");
            if ((i != 0 || i2 != cArr.length) && (i < 0 || i > cArr.length || (i3 = i + i2) < 0 || i3 > cArr.length)) {
                printStream.print(" (Error)");
                return;
            } else {
                dumpText(printStream, new String(cArr, i, i2));
                return;
            }
        }
        if (obj instanceof CharJoin) {
            printStream.print("CharJoin");
            ((CharJoin) obj).dumpChars(printStream, i, i2);
        } else {
            printStream.print("Unknown text source");
        }
    }

    public static boolean isValid(Object obj, int i, int i2) {
        if (i2 >= 0 && i >= 0) {
            if (obj == null) {
                return i == 0 && i2 == 0;
            }
            if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                return i <= cArr.length && i + i2 <= cArr.length;
            }
            if (obj instanceof String) {
                String str = (String) obj;
                return i <= str.length() && i + i2 <= str.length();
            }
            if (obj instanceof CharJoin) {
                return ((CharJoin) obj).isValid(i, i2);
            }
        }
        return false;
    }

    public static final class CharJoin {
        static final /* synthetic */ boolean $assertionsDisabled;
        static final int MAX_DEPTH = 64;
        public final int _cchLeft;
        public final int _depth;
        public final int _offLeft;
        public final int _offRight;
        public final Object _srcLeft;
        public final Object _srcRight;

        static {
            if (CharUtil.class$org$apache$xmlbeans$impl$store$CharUtil == null) {
                CharUtil.class$org$apache$xmlbeans$impl$store$CharUtil = CharUtil.class$("org.apache.xmlbeans.impl.store.CharUtil");
            } else {
                Class cls = CharUtil.class$org$apache$xmlbeans$impl$store$CharUtil;
            }
            $assertionsDisabled = true;
        }

        public CharJoin(Object obj, int i, int i2, Object obj2, int i3) {
            int i4;
            this._srcLeft = obj;
            this._offLeft = i;
            this._cchLeft = i2;
            this._srcRight = obj2;
            this._offRight = i3;
            int i5 = obj instanceof CharJoin ? ((CharJoin) obj)._depth : 0;
            if ((obj2 instanceof CharJoin) && (i4 = ((CharJoin) obj2)._depth) > i5) {
                i5 = i4;
            }
            int i6 = i5 + 1;
            this._depth = i6;
            if (!$assertionsDisabled && i6 > 66) {
                throw new AssertionError();
            }
        }

        private int cchRight(int i, int i2) {
            return Math.max(0, (i2 - this._cchLeft) - i);
        }

        public int depth() {
            Object obj = this._srcLeft;
            int depth = obj instanceof CharJoin ? ((CharJoin) obj).depth() : 0;
            Object obj2 = this._srcRight;
            if (obj2 instanceof CharJoin) {
                depth = Math.max(((CharJoin) obj2).depth(), depth);
            }
            return depth + 1;
        }

        public boolean isValid(int i, int i2) {
            int i3 = this._depth;
            if (i3 > 2) {
                return true;
            }
            if ($assertionsDisabled || i3 == depth()) {
                return i >= 0 && i2 >= 0 && CharUtil.isValid(this._srcLeft, this._offLeft, this._cchLeft) && CharUtil.isValid(this._srcRight, this._offRight, cchRight(i, i2));
            }
            throw new AssertionError();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getString(StringBuffer stringBuffer, int i, int i2) {
            if (!$assertionsDisabled && i2 <= 0) {
                throw new AssertionError();
            }
            int i3 = this._cchLeft;
            if (i < i3) {
                int min = Math.min(i3 - i, i2);
                CharUtil.getString(stringBuffer, this._srcLeft, this._offLeft + i, min);
                if (i2 > min) {
                    CharUtil.getString(stringBuffer, this._srcRight, this._offRight, i2 - min);
                    return;
                }
                return;
            }
            CharUtil.getString(stringBuffer, this._srcRight, (this._offRight + i) - i3, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getChars(char[] cArr, int i, int i2, int i3) {
            if (!$assertionsDisabled && i3 <= 0) {
                throw new AssertionError();
            }
            int i4 = this._cchLeft;
            if (i2 < i4) {
                int min = Math.min(i4 - i2, i3);
                CharUtil.getChars(cArr, i, this._srcLeft, this._offLeft + i2, min);
                if (i3 > min) {
                    CharUtil.getChars(cArr, i + min, this._srcRight, this._offRight, i3 - min);
                    return;
                }
                return;
            }
            CharUtil.getChars(cArr, i, this._srcRight, (this._offRight + i2) - i4, i3);
        }

        private void dumpChars(int i, int i2) {
            dumpChars(System.out, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dumpChars(PrintStream printStream, int i, int i2) {
            printStream.print("( ");
            CharUtil.dumpChars(printStream, this._srcLeft, this._offLeft, this._cchLeft);
            printStream.print(", ");
            CharUtil.dumpChars(printStream, this._srcRight, this._offRight, cchRight(i, i2));
            printStream.print(" )");
        }
    }

    public static final class CharIterator {
        static final /* synthetic */ boolean $assertionsDisabled;
        private int _cchRoot;
        private int _maxPos;
        private int _minPos;
        private int _offLeaf;
        private int _offRoot;
        private int _pos;
        private char[] _srcLeafChars;
        private String _srcLeafString;
        private Object _srcRoot;

        static {
            if (CharUtil.class$org$apache$xmlbeans$impl$store$CharUtil == null) {
                CharUtil.class$org$apache$xmlbeans$impl$store$CharUtil = CharUtil.class$("org.apache.xmlbeans.impl.store.CharUtil");
            } else {
                Class cls = CharUtil.class$org$apache$xmlbeans$impl$store$CharUtil;
            }
            $assertionsDisabled = true;
        }

        public void init(Object obj, int i, int i2) {
            init(obj, i, i2, 0);
        }

        public void init(Object obj, int i, int i2, int i3) {
            if (!$assertionsDisabled && !CharUtil.isValid(obj, i, i2)) {
                throw new AssertionError();
            }
            release();
            this._srcRoot = obj;
            this._offRoot = i;
            this._cchRoot = i2;
            this._maxPos = -1;
            this._minPos = -1;
            movePos(i3);
        }

        public void release() {
            this._srcRoot = null;
            this._srcLeafString = null;
            this._srcLeafChars = null;
        }

        public boolean hasNext() {
            return this._pos < this._cchRoot;
        }

        public boolean hasPrev() {
            return this._pos > 0;
        }

        public char next() {
            if (!$assertionsDisabled && !hasNext()) {
                throw new AssertionError();
            }
            char currentChar = currentChar();
            movePos(this._pos + 1);
            return currentChar;
        }

        public char prev() {
            if (!$assertionsDisabled && !hasPrev()) {
                throw new AssertionError();
            }
            movePos(this._pos - 1);
            return currentChar();
        }

        public void movePos(int i) {
            Object obj;
            if (!$assertionsDisabled && (i < 0 || i > this._cchRoot)) {
                throw new AssertionError();
            }
            if (i < this._minPos || i > this._maxPos) {
                Object obj2 = this._srcRoot;
                int i2 = this._offRoot;
                int i3 = i2 + i;
                int i4 = this._cchRoot;
                this._offLeaf = i2;
                while (obj2 instanceof CharJoin) {
                    CharJoin charJoin = (CharJoin) obj2;
                    if (i3 < charJoin._cchLeft) {
                        obj = charJoin._srcLeft;
                        this._offLeaf = charJoin._offLeft;
                        i3 += charJoin._offLeft;
                        i4 = charJoin._cchLeft;
                    } else {
                        obj = charJoin._srcRight;
                        this._offLeaf = charJoin._offRight;
                        i3 -= charJoin._cchLeft - charJoin._offRight;
                        i4 -= charJoin._cchLeft;
                    }
                    obj2 = obj;
                }
                int i5 = i - (i3 - this._offLeaf);
                this._minPos = i5;
                int i6 = i4 + i5;
                this._maxPos = i6;
                if (i < this._cchRoot) {
                    this._maxPos = i6 - 1;
                }
                this._srcLeafChars = null;
                this._srcLeafString = null;
                if (obj2 instanceof char[]) {
                    this._srcLeafChars = (char[]) obj2;
                } else {
                    this._srcLeafString = (String) obj2;
                }
                if (!$assertionsDisabled && (i < i5 || i > this._maxPos)) {
                    throw new AssertionError();
                }
            }
            this._pos = i;
        }

        private char currentChar() {
            int i = (this._offLeaf + this._pos) - this._minPos;
            char[] cArr = this._srcLeafChars;
            return cArr == null ? this._srcLeafString.charAt(i) : cArr[i];
        }
    }
}
