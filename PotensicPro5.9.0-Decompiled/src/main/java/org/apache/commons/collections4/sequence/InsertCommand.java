package org.apache.commons.collections4.sequence;

/* loaded from: classes4.dex */
public class InsertCommand<T> extends EditCommand<T> {
    public InsertCommand(T t) {
        super(t);
    }

    @Override // org.apache.commons.collections4.sequence.EditCommand
    public void accept(CommandVisitor<T> commandVisitor) {
        commandVisitor.visitInsertCommand(getObject());
    }
}
