package org.apache.poi.ss.usermodel;

import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;

/* loaded from: classes5.dex */
public interface CellRange<C extends Cell> extends Iterable<C> {
    C getCell(int i, int i2);

    C[][] getCells();

    C[] getFlattenedCells();

    int getHeight();

    String getReferenceText();

    C getTopLeftCell();

    int getWidth();

    @Override // java.lang.Iterable
    Iterator<C> iterator();

    int size();
}
