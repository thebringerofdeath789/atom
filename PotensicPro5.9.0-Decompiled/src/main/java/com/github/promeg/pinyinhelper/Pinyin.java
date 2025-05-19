package com.github.promeg.pinyinhelper;

import com.google.android.exoplayer2.audio.AacUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ahocorasick.trie.Trie;

/* loaded from: classes.dex */
public final class Pinyin {
    static List<PinyinDict> mPinyinDicts;
    static SegmentationSelector mSelector;
    static Trie mTrieDict;

    private Pinyin() {
    }

    public static void init(Config config) {
        if (config == null) {
            mPinyinDicts = null;
            mTrieDict = null;
            mSelector = null;
        } else if (config.valid()) {
            mPinyinDicts = Collections.unmodifiableList(config.getPinyinDicts());
            mTrieDict = Utils.dictsToTrie(config.getPinyinDicts());
            mSelector = config.getSelector();
        }
    }

    public static void add(PinyinDict pinyinDict) {
        if (pinyinDict == null || pinyinDict.words() == null || pinyinDict.words().size() == 0) {
            return;
        }
        init(new Config(mPinyinDicts).with(pinyinDict));
    }

    public static Config newConfig() {
        return new Config(null);
    }

    public static String toPinyin(String str, String str2) {
        return Engine.toPinyin(str, mTrieDict, mPinyinDicts, str2, mSelector);
    }

    public static String toPinyin(char c) {
        if (isChinese(c)) {
            return c == 12295 ? "LING" : PinyinData.PINYIN_TABLE[getPinyinCode(c)];
        }
        return String.valueOf(c);
    }

    public static boolean isChinese(char c) {
        return (19968 <= c && c <= 40869 && getPinyinCode(c) > 0) || 12295 == c;
    }

    private static int getPinyinCode(char c) {
        int i = c - 19968;
        if (i >= 0 && i < 7000) {
            return decodeIndex(PinyinCode1.PINYIN_CODE_PADDING, PinyinCode1.PINYIN_CODE, i);
        }
        if (7000 <= i && i < 14000) {
            return decodeIndex(PinyinCode2.PINYIN_CODE_PADDING, PinyinCode2.PINYIN_CODE, i - AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND);
        }
        return decodeIndex(PinyinCode3.PINYIN_CODE_PADDING, PinyinCode3.PINYIN_CODE, i - 14000);
    }

    private static short decodeIndex(byte[] bArr, byte[] bArr2, int i) {
        int i2 = i % 8;
        short s = (short) (bArr2[i] & 255);
        return (bArr[i / 8] & PinyinData.BIT_MASKS[i2]) != 0 ? (short) (s | 256) : s;
    }

    public static final class Config {
        List<PinyinDict> mPinyinDicts;
        SegmentationSelector mSelector;

        private Config(List<PinyinDict> list) {
            if (list != null) {
                this.mPinyinDicts = new ArrayList(list);
            }
            this.mSelector = new ForwardLongestSelector();
        }

        public Config with(PinyinDict pinyinDict) {
            if (pinyinDict != null) {
                List<PinyinDict> list = this.mPinyinDicts;
                if (list == null) {
                    ArrayList arrayList = new ArrayList();
                    this.mPinyinDicts = arrayList;
                    arrayList.add(pinyinDict);
                } else if (!list.contains(pinyinDict)) {
                    this.mPinyinDicts.add(pinyinDict);
                }
            }
            return this;
        }

        boolean valid() {
            return (getPinyinDicts() == null || getSelector() == null) ? false : true;
        }

        SegmentationSelector getSelector() {
            return this.mSelector;
        }

        List<PinyinDict> getPinyinDicts() {
            return this.mPinyinDicts;
        }
    }
}
