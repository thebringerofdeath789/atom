package com.ipotensic.baselib.bean;

import com.ipotensic.baselib.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TitleBean.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ>\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003J\u0006\u0010 \u001a\u00020\u0007J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0006\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006$"}, d2 = {"Lcom/ipotensic/baselib/bean/TitleBean;", "", "iconBack", "", "titleName", "rightView", "isHome", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getIconBack", "()Ljava/lang/String;", "setIconBack", "(Ljava/lang/String;)V", "()Ljava/lang/Integer;", "setHome", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getRightView", "setRightView", "getTitleName", "setTitleName", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/ipotensic/baselib/bean/TitleBean;", "equals", "", "other", "getIdByTag", "tag", "getLeftId", "hashCode", "toString", "Companion", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final /* data */ class TitleBean {
    public static final String TAG_BACK = "back";
    public static final String TAG_HOME = "home";
    public static final String TAG_LANGUAGE = "lan";
    private String iconBack;
    private Integer isHome;
    private String rightView;
    private String titleName;

    public TitleBean() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ TitleBean copy$default(TitleBean titleBean, String str, String str2, String str3, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = titleBean.iconBack;
        }
        if ((i & 2) != 0) {
            str2 = titleBean.titleName;
        }
        if ((i & 4) != 0) {
            str3 = titleBean.rightView;
        }
        if ((i & 8) != 0) {
            num = titleBean.isHome;
        }
        return titleBean.copy(str, str2, str3, num);
    }

    /* renamed from: component1, reason: from getter */
    public final String getIconBack() {
        return this.iconBack;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitleName() {
        return this.titleName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRightView() {
        return this.rightView;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getIsHome() {
        return this.isHome;
    }

    public final TitleBean copy(String iconBack, String titleName, String rightView, Integer isHome) {
        return new TitleBean(iconBack, titleName, rightView, isHome);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TitleBean)) {
            return false;
        }
        TitleBean titleBean = (TitleBean) other;
        return Intrinsics.areEqual(this.iconBack, titleBean.iconBack) && Intrinsics.areEqual(this.titleName, titleBean.titleName) && Intrinsics.areEqual(this.rightView, titleBean.rightView) && Intrinsics.areEqual(this.isHome, titleBean.isHome);
    }

    public int hashCode() {
        String str = this.iconBack;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.titleName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.rightView;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.isHome;
        return hashCode3 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "TitleBean(iconBack=" + this.iconBack + ", titleName=" + this.titleName + ", rightView=" + this.rightView + ", isHome=" + this.isHome + ")";
    }

    public TitleBean(String str, String str2, String str3, Integer num) {
        this.iconBack = str;
        this.titleName = str2;
        this.rightView = str3;
        this.isHome = num;
    }

    public /* synthetic */ TitleBean(String str, String str2, String str3, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? (String) null : str, (i & 2) != 0 ? (String) null : str2, (i & 4) != 0 ? (String) null : str3, (i & 8) != 0 ? (Integer) null : num);
    }

    public final String getIconBack() {
        return this.iconBack;
    }

    public final void setIconBack(String str) {
        this.iconBack = str;
    }

    public final String getTitleName() {
        return this.titleName;
    }

    public final void setTitleName(String str) {
        this.titleName = str;
    }

    public final String getRightView() {
        return this.rightView;
    }

    public final void setRightView(String str) {
        this.rightView = str;
    }

    public final Integer isHome() {
        return this.isHome;
    }

    public final void setHome(Integer num) {
        this.isHome = num;
    }

    public final int getLeftId() {
        return getIdByTag(this.iconBack);
    }

    public final int getIdByTag(String tag) {
        if (tag != null) {
            int hashCode = tag.hashCode();
            if (hashCode != 106905) {
                if (hashCode != 3015911) {
                    if (hashCode == 3208415 && tag.equals(TAG_HOME)) {
                        return R.mipmap.icon_home;
                    }
                } else if (tag.equals(TAG_BACK)) {
                    return R.mipmap.img_arrow_left_black;
                }
            } else if (tag.equals(TAG_LANGUAGE)) {
                return R.mipmap.icon_language;
            }
        }
        return 0;
    }
}
