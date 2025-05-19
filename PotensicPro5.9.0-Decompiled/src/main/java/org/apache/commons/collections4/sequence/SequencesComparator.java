package org.apache.commons.collections4.sequence;

import java.util.List;
import org.apache.commons.collections4.Equator;
import org.apache.commons.collections4.functors.DefaultEquator;

/* loaded from: classes4.dex */
public class SequencesComparator<T> {
    private final Equator<? super T> equator;
    private final List<T> sequence1;
    private final List<T> sequence2;
    private final int[] vDown;
    private final int[] vUp;

    public SequencesComparator(List<T> list, List<T> list2) {
        this(list, list2, DefaultEquator.defaultEquator());
    }

    public SequencesComparator(List<T> list, List<T> list2, Equator<? super T> equator) {
        this.sequence1 = list;
        this.sequence2 = list2;
        this.equator = equator;
        int size = list.size() + list2.size() + 2;
        this.vDown = new int[size];
        this.vUp = new int[size];
    }

    public EditScript<T> getScript() {
        EditScript<T> editScript = new EditScript<>();
        buildScript(0, this.sequence1.size(), 0, this.sequence2.size(), editScript);
        return editScript;
    }

    private Snake buildSnake(int i, int i2, int i3, int i4) {
        int i5 = i;
        while (true) {
            int i6 = i5 - i2;
            if (i6 >= i4 || i5 >= i3 || !this.equator.equate(this.sequence1.get(i5), this.sequence2.get(i6))) {
                break;
            }
            i5++;
        }
        return new Snake(i, i5, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
    
        if (r11[r10 - 1] < r11[r10 + 1]) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00be, code lost:
    
        if (r11[r12 + 1] <= r11[r12 - 1]) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0128, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f8 A[LOOP:4: B:55:0x00de->B:59:0x00f8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0106 A[EDGE_INSN: B:60:0x0106->B:61:0x0106 BREAK  A[LOOP:4: B:55:0x00de->B:59:0x00f8], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0123 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.apache.commons.collections4.sequence.SequencesComparator.Snake getMiddleSnake(int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections4.sequence.SequencesComparator.getMiddleSnake(int, int, int, int):org.apache.commons.collections4.sequence.SequencesComparator$Snake");
    }

    private void buildScript(int i, int i2, int i3, int i4, EditScript<T> editScript) {
        Snake middleSnake = getMiddleSnake(i, i2, i3, i4);
        if (middleSnake != null && ((middleSnake.getStart() != i2 || middleSnake.getDiag() != i2 - i4) && (middleSnake.getEnd() != i || middleSnake.getDiag() != i - i3))) {
            buildScript(i, middleSnake.getStart(), i3, middleSnake.getStart() - middleSnake.getDiag(), editScript);
            for (int start = middleSnake.getStart(); start < middleSnake.getEnd(); start++) {
                editScript.append(new KeepCommand<>(this.sequence1.get(start)));
            }
            buildScript(middleSnake.getEnd(), i2, middleSnake.getEnd() - middleSnake.getDiag(), i4, editScript);
            return;
        }
        int i5 = i;
        int i6 = i3;
        while (true) {
            if (i5 >= i2 && i6 >= i4) {
                return;
            }
            if (i5 < i2 && i6 < i4 && this.equator.equate(this.sequence1.get(i5), this.sequence2.get(i6))) {
                editScript.append(new KeepCommand<>(this.sequence1.get(i5)));
                i5++;
            } else if (i2 - i > i4 - i3) {
                editScript.append(new DeleteCommand<>(this.sequence1.get(i5)));
                i5++;
            } else {
                editScript.append(new InsertCommand<>(this.sequence2.get(i6)));
            }
            i6++;
        }
    }

    private static class Snake {
        private final int diag;
        private final int end;
        private final int start;

        public Snake(int i, int i2, int i3) {
            this.start = i;
            this.end = i2;
            this.diag = i3;
        }

        public int getStart() {
            return this.start;
        }

        public int getEnd() {
            return this.end;
        }

        public int getDiag() {
            return this.diag;
        }
    }
}
