package org.apache.commons.text.diff;

/* loaded from: classes4.dex */
public abstract class EditCommand<T> {
    private final T object;

    public abstract void accept(CommandVisitor<T> commandVisitor);

    protected EditCommand(T t) {
        this.object = t;
    }

    protected T getObject() {
        return this.object;
    }
}
