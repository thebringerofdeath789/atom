package org.ahocorasick.trie.handler;

import java.util.ArrayList;
import java.util.List;
import org.ahocorasick.trie.Emit;

/* loaded from: classes4.dex */
public class DefaultEmitHandler implements EmitHandler {
    private List<Emit> emits = new ArrayList();

    @Override // org.ahocorasick.trie.handler.EmitHandler
    public void emit(Emit emit) {
        this.emits.add(emit);
    }

    public List<Emit> getEmits() {
        return this.emits;
    }
}
