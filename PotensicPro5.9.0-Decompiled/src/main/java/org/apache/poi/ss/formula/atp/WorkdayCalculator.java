package org.apache.poi.ss.formula.atp;

import java.util.Calendar;
import java.util.Date;
import org.apache.poi.ss.usermodel.DateUtil;

/* loaded from: classes5.dex */
public class WorkdayCalculator {
    public static final WorkdayCalculator instance = new WorkdayCalculator();

    protected boolean isInARange(double d, double d2, double d3) {
        return d3 >= d && d3 <= d2;
    }

    private WorkdayCalculator() {
    }

    public int calculateWorkdays(double d, double d2, double[] dArr) {
        int pastDaysOfWeek = pastDaysOfWeek(d, d2, 7);
        int pastDaysOfWeek2 = pastDaysOfWeek(d, d2, 1);
        return ((((int) ((d2 - d) + 1.0d)) - pastDaysOfWeek) - pastDaysOfWeek2) - calculateNonWeekendHolidays(d, d2, dArr);
    }

    public Date calculateWorkdays(double d, int i, double[] dArr) {
        Date javaDate = DateUtil.getJavaDate(d);
        int i2 = i < 0 ? -1 : 1;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(javaDate);
        double excelDate = DateUtil.getExcelDate(calendar.getTime());
        while (i != 0) {
            calendar.add(6, i2);
            excelDate += i2;
            if (calendar.get(7) != 7 && calendar.get(7) != 1 && !isHoliday(excelDate, dArr)) {
                i -= i2;
            }
        }
        return calendar.getTime();
    }

    protected int pastDaysOfWeek(double d, double d2, int i) {
        if (d2 > d) {
            d = d2;
        }
        int floor = (int) Math.floor(d);
        int i2 = 0;
        for (int floor2 = (int) Math.floor(d < d2 ? d : d2); floor2 <= floor; floor2++) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(DateUtil.getJavaDate(floor2));
            if (calendar.get(7) == i) {
                i2++;
            }
        }
        return d < d2 ? i2 : -i2;
    }

    protected int calculateNonWeekendHolidays(double d, double d2, double[] dArr) {
        double d3 = d < d2 ? d : d2;
        if (d2 > d) {
            d = d2;
        }
        int i = 0;
        for (int i2 = 0; i2 < dArr.length; i2++) {
            if (isInARange(d3, d, dArr[i2]) && !isWeekend(dArr[i2])) {
                i++;
            }
        }
        return d < d2 ? i : -i;
    }

    protected boolean isWeekend(double d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtil.getJavaDate(d));
        return calendar.get(7) == 7 || calendar.get(7) == 1;
    }

    protected boolean isHoliday(double d, double[] dArr) {
        for (double d2 : dArr) {
            if (Math.round(d2) == Math.round(d)) {
                return true;
            }
        }
        return false;
    }

    protected int isNonWorkday(double d, double[] dArr) {
        return (isWeekend(d) || isHoliday(d, dArr)) ? 1 : 0;
    }
}
