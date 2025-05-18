package com.ipotensic.kernel.utils;

import com.ipotensic.kernel.bean.DroneNoticeBean;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SortUtils.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m2338d2 = {"Lcom/ipotensic/kernel/utils/SortUtils;", "", "()V", "TipLevelComparator", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class SortUtils {
    public static final SortUtils INSTANCE = new SortUtils();

    private SortUtils() {
    }

    /* compiled from: SortUtils.kt */
    @Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, m2338d2 = {"Lcom/ipotensic/kernel/utils/SortUtils$TipLevelComparator;", "Ljava/util/Comparator;", "Lcom/ipotensic/kernel/bean/DroneNoticeBean;", "Lkotlin/Comparator;", "()V", "compare", "", "reminder1", "reminder2", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
    public static final class TipLevelComparator implements Comparator<DroneNoticeBean> {
        @Override // java.util.Comparator
        public int compare(DroneNoticeBean reminder1, DroneNoticeBean reminder2) {
            Intrinsics.checkParameterIsNotNull(reminder1, "reminder1");
            Intrinsics.checkParameterIsNotNull(reminder2, "reminder2");
            return String.valueOf(reminder2.getReminderTime()).compareTo(String.valueOf(reminder1.getReminderTime()));
        }
    }
}