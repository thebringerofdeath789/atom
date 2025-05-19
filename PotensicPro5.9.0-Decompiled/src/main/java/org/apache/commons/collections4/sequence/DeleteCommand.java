package org.apache.commons.collections4.sequence;

/* loaded from: classes4.dex */
public class DeleteCommand<T> extends EditCommand<T> {
    public DeleteCommand(T t) {
        super(t);
    }

    @Override // org.apache.commons.collections4.sequence.EditCommand
    public void accept(CommandVisitor<T> commandVisitor) {
        commandVisitor.visitDeleteCommand(getObject());
    }
}
