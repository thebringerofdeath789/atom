package org.ahocorasick.trie;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes4.dex */
public class State {
    private final int depth;
    private Set<String> emits;
    private State failure;
    private final State rootState;
    private Map<Character, State> success;

    public State() {
        this(0);
    }

    public State(int i) {
        this.success = new HashMap();
        this.failure = null;
        this.emits = null;
        this.depth = i;
        this.rootState = i == 0 ? this : null;
    }

    private State nextState(Character ch, boolean z) {
        State state;
        State state2 = this.success.get(ch);
        return (z || state2 != null || (state = this.rootState) == null) ? state2 : state;
    }

    public State nextState(Character ch) {
        return nextState(ch, false);
    }

    public State nextStateIgnoreRootState(Character ch) {
        return nextState(ch, true);
    }

    public State addState(Character ch) {
        State nextStateIgnoreRootState = nextStateIgnoreRootState(ch);
        if (nextStateIgnoreRootState != null) {
            return nextStateIgnoreRootState;
        }
        State state = new State(this.depth + 1);
        this.success.put(ch, state);
        return state;
    }

    public int getDepth() {
        return this.depth;
    }

    public void addEmit(String str) {
        if (this.emits == null) {
            this.emits = new TreeSet();
        }
        this.emits.add(str);
    }

    public void addEmit(Collection<String> collection) {
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            addEmit(it.next());
        }
    }

    public Collection<String> emit() {
        Set<String> set = this.emits;
        return set == null ? Collections.emptyList() : set;
    }

    public State failure() {
        return this.failure;
    }

    public void setFailure(State state) {
        this.failure = state;
    }

    public Collection<State> getStates() {
        return this.success.values();
    }

    public Collection<Character> getTransitions() {
        return this.success.keySet();
    }
}
