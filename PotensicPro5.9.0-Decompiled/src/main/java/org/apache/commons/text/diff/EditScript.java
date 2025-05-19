package org.apache.commons.text.diff;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class EditScript<T> {
    private final List<EditCommand<T>> commands = new ArrayList();
    private int lcsLength = 0;
    private int modifications = 0;

    public void append(KeepCommand<T> keepCommand) {
        this.commands.add(keepCommand);
        this.lcsLength++;
    }

    public void append(InsertCommand<T> insertCommand) {
        this.commands.add(insertCommand);
        this.modifications++;
    }

    public void append(DeleteCommand<T> deleteCommand) {
        this.commands.add(deleteCommand);
        this.modifications++;
    }

    public void visit(CommandVisitor<T> commandVisitor) {
        Iterator<EditCommand<T>> it = this.commands.iterator();
        while (it.hasNext()) {
            it.next().accept(commandVisitor);
        }
    }

    public int getLCSLength() {
        return this.lcsLength;
    }

    public int getModifications() {
        return this.modifications;
    }
}
