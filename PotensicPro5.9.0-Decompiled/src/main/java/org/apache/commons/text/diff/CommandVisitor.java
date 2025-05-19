package org.apache.commons.text.diff;

/* loaded from: classes4.dex */
public interface CommandVisitor<T> {
    void visitDeleteCommand(T t);

    void visitInsertCommand(T t);

    void visitKeepCommand(T t);
}
