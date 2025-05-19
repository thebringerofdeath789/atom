package org.ahocorasick.trie;

/* loaded from: classes4.dex */
public class TrieConfig {
    private boolean allowOverlaps = true;
    private boolean onlyWholeWords = false;
    private boolean onlyWholeWordsWhiteSpaceSeparated = false;
    private boolean caseInsensitive = false;
    private boolean stopOnHit = false;

    public boolean isStopOnHit() {
        return this.stopOnHit;
    }

    public void setStopOnHit(boolean z) {
        this.stopOnHit = z;
    }

    public boolean isAllowOverlaps() {
        return this.allowOverlaps;
    }

    public void setAllowOverlaps(boolean z) {
        this.allowOverlaps = z;
    }

    public boolean isOnlyWholeWords() {
        return this.onlyWholeWords;
    }

    public void setOnlyWholeWords(boolean z) {
        this.onlyWholeWords = z;
    }

    public boolean isOnlyWholeWordsWhiteSpaceSeparated() {
        return this.onlyWholeWordsWhiteSpaceSeparated;
    }

    public void setOnlyWholeWordsWhiteSpaceSeparated(boolean z) {
        this.onlyWholeWordsWhiteSpaceSeparated = z;
    }

    public boolean isCaseInsensitive() {
        return this.caseInsensitive;
    }

    public void setCaseInsensitive(boolean z) {
        this.caseInsensitive = z;
    }
}
