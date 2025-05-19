package me.yokeyword.indexablerv;

/* loaded from: classes4.dex */
public class EntityWrapper<T> {
    static final int TYPE_CONTENT = Integer.MAX_VALUE;
    static final int TYPE_FOOTER = 2;
    static final int TYPE_HEADER = 1;
    static final int TYPE_TITLE = 2147483646;
    private T data;
    private int headerFooterType;
    private String index;
    private String indexByField;
    private String indexTitle;
    private int itemType;
    private int originalPosition;
    private String pinyin;

    EntityWrapper() {
        this.originalPosition = -1;
        this.itemType = Integer.MAX_VALUE;
    }

    EntityWrapper(String str, int i) {
        this.originalPosition = -1;
        this.itemType = Integer.MAX_VALUE;
        this.index = str;
        this.indexTitle = str;
        this.pinyin = str;
        this.itemType = i;
    }

    public String getIndex() {
        return this.index;
    }

    void setIndex(String str) {
        this.index = str;
    }

    public String getIndexTitle() {
        return this.indexTitle;
    }

    void setIndexTitle(String str) {
        this.indexTitle = str;
    }

    public String getPinyin() {
        return this.pinyin;
    }

    void setPinyin(String str) {
        this.pinyin = str;
    }

    public String getIndexByField() {
        return this.indexByField;
    }

    void setIndexByField(String str) {
        this.indexByField = str;
    }

    public T getData() {
        return this.data;
    }

    void setData(T t) {
        this.data = t;
    }

    public int getOriginalPosition() {
        return this.originalPosition;
    }

    void setOriginalPosition(int i) {
        this.originalPosition = i;
    }

    int getItemType() {
        return this.itemType;
    }

    void setItemType(int i) {
        this.itemType = i;
    }

    int getHeaderFooterType() {
        return this.headerFooterType;
    }

    void setHeaderFooterType(int i) {
        this.headerFooterType = i;
    }

    public boolean isTitle() {
        return this.itemType == TYPE_TITLE;
    }

    public boolean isContent() {
        return this.itemType == Integer.MAX_VALUE;
    }

    public boolean isHeader() {
        return this.headerFooterType == 1;
    }

    public boolean isFooter() {
        return this.headerFooterType == 2;
    }
}
