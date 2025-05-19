package com.github.promeg.pinyinhelper;

import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.ahocorasick.trie.Trie;

/* loaded from: classes.dex */
final class Utils {
    private Utils() {
    }

    static Trie dictsToTrie(List<PinyinDict> list) {
        TreeSet treeSet = new TreeSet();
        Trie.TrieBuilder builder = Trie.builder();
        if (list == null) {
            return null;
        }
        for (PinyinDict pinyinDict : list) {
            if (pinyinDict != null && pinyinDict.words() != null) {
                treeSet.addAll(pinyinDict.words());
            }
        }
        if (treeSet.size() <= 0) {
            return null;
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            builder.addKeyword((String) it.next());
        }
        return builder.build();
    }
}
