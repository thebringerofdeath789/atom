package me.yokeyword.indexablerv;

import java.util.Comparator;
import me.yokeyword.indexablerv.IndexableEntity;

/* loaded from: classes4.dex */
class PinyinComparator<T extends IndexableEntity> implements Comparator<EntityWrapper<T>> {
    PinyinComparator() {
    }

    @Override // java.util.Comparator
    public int compare(EntityWrapper<T> entityWrapper, EntityWrapper<T> entityWrapper2) {
        String indexByField = entityWrapper.getIndexByField();
        String indexByField2 = entityWrapper2.getIndexByField();
        if (indexByField == null) {
            indexByField = "";
        }
        if (indexByField2 == null) {
            indexByField2 = "";
        }
        return compareIndexName(indexByField.trim(), indexByField2.trim());
    }

    private int compareIndexName(String str, String str2) {
        int i = 0;
        String word = getWord(str, 0);
        String word2 = getWord(str2, 0);
        while (word.equals(word2) && !word.equals("")) {
            i++;
            word = getWord(str, i);
            word2 = getWord(str2, i);
        }
        return word.compareTo(word2);
    }

    private String getWord(String str, int i) {
        int i2 = i + 1;
        if (str.length() < i2) {
            return "";
        }
        if (PinyinUtil.matchingPolyphone(str)) {
            return PinyinUtil.getPingYin(PinyinUtil.getPolyphoneRealHanzi(str).substring(i, i2));
        }
        return PinyinUtil.getPingYin(str.substring(i, i2));
    }
}
