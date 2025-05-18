package com.ipotensic.baselib.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.ipotensic.baselib.DDLog;

/* loaded from: classes2.dex */
public class ScreenUtils {
    private static String TAG = "ScreenUtils";
    public static DisplayMetrics metric = new DisplayMetrics();

    private static void getMetrics(Activity activity) {
        if (activity == null) {
            LogUtils.m1715e("activity is null!");
        } else {
            activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        }
    }

    public static int getScreenHeight(Activity activity) {
        getMetrics(activity);
        return metric.heightPixels;
    }

    public static int getStatusBarHeight(Activity activity) {
        getMetrics(activity);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return metric.heightPixels - rect.height();
    }

    public static int getScreenHeight(Context context) {
        getMetrics(context);
        return metric.heightPixels;
    }

    private static void getMetrics(Context context) {
        if (context == null) {
            LogUtils.m1715e("context is null");
        } else {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(metric);
        }
    }

    public static int getScreenWidth(Activity activity) {
        getMetrics(activity);
        return metric.widthPixels;
    }

    public static int getScreenWidth(Context context) {
        getMetrics(context);
        return metric.widthPixels;
    }

    public static double getScreenDensity(Activity activity) {
        getMetrics(activity);
        return metric.density;
    }

    public static double getScreenDensity(Context context) {
        getMetrics(context);
        return metric.density;
    }

    public static void setWindowAlpha(Activity activity, float f) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = f;
        window.setAttributes(attributes);
    }

    public static void lightOff(Activity activity) {
        setWindowAlpha(activity, 0.3f);
    }

    public static void lightOn(Activity activity) {
        setWindowAlpha(activity, 1.0f);
    }

    public static int dp2px(Context context, float f) {
        getMetrics(context);
        return (int) ((f * metric.density) + 0.5f);
    }

    public static int sp2px(Context context, float f) {
        getMetrics(context);
        return (int) ((f * metric.scaledDensity) + 0.5f);
    }

    public static int px2dp(Context context, float f) {
        getMetrics(context);
        return (int) ((f / metric.density) + 0.5f);
    }

    public static int measureListViewHeight(ListView listView) {
        ListAdapter adapter;
        if (listView == null || (adapter = listView.getAdapter()) == null) {
            return 0;
        }
        Context context = listView.getContext();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getScreenWidth(context) - dp2px(context, 10.0f), Integer.MIN_VALUE);
        int i = 0;
        for (int i2 = 0; i2 < adapter.getCount(); i2++) {
            View view = adapter.getView(i2, null, listView);
            view.measure(makeMeasureSpec, 0);
            i += view.getMeasuredHeight();
        }
        int dividerHeight = i + ((listView.getDividerHeight() * adapter.getCount()) - 1);
        Log.i(TAG, "listview Height : " + dividerHeight);
        return dividerHeight;
    }

    public static int measureImageView(ImageView imageView) {
        int width = imageView.getWidth();
        LogUtils.m1716i("getWidth():" + width);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        DisplayMetrics displayMetrics = imageView.getResources().getDisplayMetrics();
        if (width == 0) {
            width = layoutParams.width;
            LogUtils.m1716i("LayoutParams:" + width);
        }
        if (width == 0) {
            width = getAttrValue("maxWidth", imageView);
            LogUtils.m1716i("getAttrValue():" + width);
        }
        if (width != 0) {
            return width;
        }
        int i = displayMetrics.widthPixels;
        LogUtils.m1716i("DisplayMetrics:" + i);
        return i;
    }

    public static int getAttrValue(String str, ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        try {
            return imageView.getClass().getDeclaredField(str).getInt(imageView);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int getNavigationBarHeight(Context context) {
        try {
            int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static double getWidthAndHeightRatio(Context context) {
        double screenWidth = getScreenWidth(context);
        double screenHeight = getScreenHeight(context);
        double navigationBarHeight = getNavigationBarHeight(context);
        DDLog.m1684e("导航栏高度1 ：" + screenWidth);
        DDLog.m1684e("导航栏高度2 ：" + screenHeight);
        DDLog.m1684e("导航栏高度3 ：" + navigationBarHeight);
        return (screenWidth - navigationBarHeight) / screenHeight;
    }
}