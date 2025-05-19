package org.apache.commons.collections4.sequence;

/* loaded from: classes4.dex */
public interface CommandVisitor<T> {
    void visitDeleteCommand(T t);

    void visitInsertCommand(T t);

    void visitKeepCommand(T t);
}
