package org.ahocorasick.trie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import org.ahocorasick.interval.IntervalTree;
import org.ahocorasick.trie.handler.DefaultEmitHandler;
import org.ahocorasick.trie.handler.EmitHandler;

/* loaded from: classes4.dex */
public class Trie {
    private State rootState;
    private TrieConfig trieConfig;

    private Trie(TrieConfig trieConfig) {
        this.trieConfig = trieConfig;
        this.rootState = new State();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addKeyword(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        State state = this.rootState;
        for (char c : str.toCharArray()) {
            Character valueOf = Character.valueOf(c);
            if (this.trieConfig.isCaseInsensitive()) {
                valueOf = Character.valueOf(Character.toLowerCase(valueOf.charValue()));
            }
            state = state.addState(valueOf);
        }
        if (this.trieConfig.isCaseInsensitive()) {
            str = str.toLowerCase();
        }
        state.addEmit(str);
    }

    public Collection<Token> tokenize(String str) {
        ArrayList arrayList = new ArrayList();
        int i = -1;
        for (Emit emit : parseText(str)) {
            if (emit.getStart() - i > 1) {
                arrayList.add(createFragment(emit, str, i));
            }
            arrayList.add(createMatch(emit, str));
            i = emit.getEnd();
        }
        if (str.length() - i > 1) {
            arrayList.add(createFragment(null, str, i));
        }
        return arrayList;
    }

    private Token createFragment(Emit emit, String str, int i) {
        return new FragmentToken(str.substring(i + 1, emit == null ? str.length() : emit.getStart()));
    }

    private Token createMatch(Emit emit, String str) {
        return new MatchToken(str.substring(emit.getStart(), emit.getEnd() + 1), emit);
    }

    public Collection<Emit> parseText(CharSequence charSequence) {
        DefaultEmitHandler defaultEmitHandler = new DefaultEmitHandler();
        parseText(charSequence, defaultEmitHandler);
        List<Emit> emits = defaultEmitHandler.getEmits();
        if (this.trieConfig.isOnlyWholeWords()) {
            removePartialMatches(charSequence, emits);
        }
        if (this.trieConfig.isOnlyWholeWordsWhiteSpaceSeparated()) {
            removePartialMatchesWhiteSpaceSeparated(charSequence, emits);
        }
        if (!this.trieConfig.isAllowOverlaps()) {
            new IntervalTree(emits).removeOverlaps(emits);
        }
        return emits;
    }

    public boolean containsMatch(CharSequence charSequence) {
        return firstMatch(charSequence) != null;
    }

    public void parseText(CharSequence charSequence, EmitHandler emitHandler) {
        State state = this.rootState;
        for (int i = 0; i < charSequence.length(); i++) {
            Character valueOf = Character.valueOf(charSequence.charAt(i));
            if (this.trieConfig.isCaseInsensitive()) {
                valueOf = Character.valueOf(Character.toLowerCase(valueOf.charValue()));
            }
            state = getState(state, valueOf);
            if (storeEmits(i, state, emitHandler) && this.trieConfig.isStopOnHit()) {
                return;
            }
        }
    }

    public Emit firstMatch(CharSequence charSequence) {
        if (!this.trieConfig.isAllowOverlaps()) {
            Collection<Emit> parseText = parseText(charSequence);
            if (parseText == null || parseText.isEmpty()) {
                return null;
            }
            return parseText.iterator().next();
        }
        State state = this.rootState;
        for (int i = 0; i < charSequence.length(); i++) {
            Character valueOf = Character.valueOf(charSequence.charAt(i));
            if (this.trieConfig.isCaseInsensitive()) {
                valueOf = Character.valueOf(Character.toLowerCase(valueOf.charValue()));
            }
            state = getState(state, valueOf);
            Collection<String> emit = state.emit();
            if (emit != null && !emit.isEmpty()) {
                for (String str : emit) {
                    Emit emit2 = new Emit((i - str.length()) + 1, i, str);
                    if (!this.trieConfig.isOnlyWholeWords() || !isPartialMatch(charSequence, emit2)) {
                        return emit2;
                    }
                }
            }
        }
        return null;
    }

    private boolean isPartialMatch(CharSequence charSequence, Emit emit) {
        if (emit.getStart() == 0 || !Character.isAlphabetic(charSequence.charAt(emit.getStart() - 1))) {
            return emit.getEnd() + 1 != charSequence.length() && Character.isAlphabetic(charSequence.charAt(emit.getEnd() + 1));
        }
        return true;
    }

    private void removePartialMatches(CharSequence charSequence, List<Emit> list) {
        ArrayList arrayList = new ArrayList();
        for (Emit emit : list) {
            if (isPartialMatch(charSequence, emit)) {
                arrayList.add(emit);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            list.remove((Emit) it.next());
        }
    }

    private void removePartialMatchesWhiteSpaceSeparated(CharSequence charSequence, List<Emit> list) {
        long length = charSequence.length();
        ArrayList arrayList = new ArrayList();
        for (Emit emit : list) {
            if ((emit.getStart() != 0 && !Character.isWhitespace(charSequence.charAt(emit.getStart() - 1))) || (emit.getEnd() + 1 != length && !Character.isWhitespace(charSequence.charAt(emit.getEnd() + 1)))) {
                arrayList.add(emit);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            list.remove((Emit) it.next());
        }
    }

    private State getState(State state, Character ch) {
        State nextState = state.nextState(ch);
        while (nextState == null) {
            state = state.failure();
            nextState = state.nextState(ch);
        }
        return nextState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void constructFailureStates() {
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        for (State state : this.rootState.getStates()) {
            state.setFailure(this.rootState);
            linkedBlockingDeque.add(state);
        }
        while (!linkedBlockingDeque.isEmpty()) {
            State state2 = (State) linkedBlockingDeque.remove();
            for (Character ch : state2.getTransitions()) {
                State nextState = state2.nextState(ch);
                linkedBlockingDeque.add(nextState);
                State failure = state2.failure();
                while (failure.nextState(ch) == null) {
                    failure = failure.failure();
                }
                State nextState2 = failure.nextState(ch);
                nextState.setFailure(nextState2);
                nextState.addEmit(nextState2.emit());
            }
        }
    }

    private boolean storeEmits(int i, State state, EmitHandler emitHandler) {
        Collection<String> emit = state.emit();
        boolean z = false;
        if (emit != null && !emit.isEmpty()) {
            for (String str : emit) {
                emitHandler.emit(new Emit((i - str.length()) + 1, i, str));
                z = true;
            }
        }
        return z;
    }

    public static TrieBuilder builder() {
        return new TrieBuilder();
    }

    public static class TrieBuilder {
        private Trie trie;
        private TrieConfig trieConfig;

        private TrieBuilder() {
            this.trieConfig = new TrieConfig();
            this.trie = new Trie(this.trieConfig);
        }

        public TrieBuilder caseInsensitive() {
            this.trieConfig.setCaseInsensitive(true);
            return this;
        }

        public TrieBuilder removeOverlaps() {
            this.trieConfig.setAllowOverlaps(false);
            return this;
        }

        public TrieBuilder onlyWholeWords() {
            this.trieConfig.setOnlyWholeWords(true);
            return this;
        }

        public TrieBuilder onlyWholeWordsWhiteSpaceSeparated() {
            this.trieConfig.setOnlyWholeWordsWhiteSpaceSeparated(true);
            return this;
        }

        public TrieBuilder addKeyword(String str) {
            this.trie.addKeyword(str);
            return this;
        }

        public TrieBuilder stopOnHit() {
            this.trie.trieConfig.setStopOnHit(true);
            return this;
        }

        public Trie build() {
            this.trie.constructFailureStates();
            return this.trie;
        }
    }
}
