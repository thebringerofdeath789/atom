package org.ahocorasick.trie;

/* loaded from: classes4.dex */
public abstract class Token {
    private String fragment;

    public abstract Emit getEmit();

    public abstract boolean isMatch();

    public Token(String str) {
        this.fragment = str;
    }

    public String getFragment() {
        return this.fragment;
    }
}
