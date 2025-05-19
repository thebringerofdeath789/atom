package com.github.promeg.pinyinhelper;

import java.util.Collection;
import java.util.List;
import org.ahocorasick.trie.Emit;

/* loaded from: classes.dex */
interface SegmentationSelector {
    List<Emit> select(Collection<Emit> collection);
}
