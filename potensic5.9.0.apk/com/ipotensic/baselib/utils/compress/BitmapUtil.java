package com.ipotensic.baselib.utils.compress;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.view.View;
import com.ipotensic.baselib.DDLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.opc.ContentTypes;

/* loaded from: classes2.dex */
public class BitmapUtil {
    private static final float BITMAP_SCALE = 0.4f;

    private BitmapUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    static Bitmap getScaledBitmap(Context context, Uri uri, float f, float f2, Bitmap.Config config) {
        String realPathFromURI = FileUtil.getRealPathFromURI(context, uri);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(realPathFromURI, options);
        Bitmap bitmap = null;
        if (decodeFile == null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(realPathFromURI);
                BitmapFactory.decodeStream(fileInputStream, null, options);
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        int i = options.outHeight;
        int i2 = options.outWidth;
        if (i == -1 || i2 == -1) {
            try {
                ExifInterface exifInterface = new ExifInterface(realPathFromURI);
                i = exifInterface.getAttributeInt("ImageLength", 1);
                i2 = exifInterface.getAttributeInt("ImageWidth", 1);
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        if (i2 <= 0 || i <= 0) {
            Bitmap decodeFile2 = BitmapFactory.decodeFile(realPathFromURI);
            if (decodeFile2 == null) {
                return null;
            }
            i2 = decodeFile2.getWidth();
            i = decodeFile2.getHeight();
        }
        float f3 = i2;
        float f4 = i;
        float f5 = f3 / f4;
        float f6 = f / f2;
        if (f4 > f2 || f3 > f) {
            if (f5 < f6) {
                i2 = (int) ((f2 / f4) * f3);
                i = (int) f2;
            } else {
                i = f5 > f6 ? (int) ((f / f3) * f4) : (int) f2;
                i2 = (int) f;
            }
        }
        options.inSampleSize = calculateInSampleSize(options, i2, i);
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16384];
        try {
            decodeFile = BitmapFactory.decodeFile(realPathFromURI, options);
            if (decodeFile == null) {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(realPathFromURI);
                    BitmapFactory.decodeStream(fileInputStream2, null, options);
                    fileInputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        } catch (OutOfMemoryError e5) {
            e5.printStackTrace();
        }
        if (i <= 0 || i2 <= 0) {
            return null;
        }
        try {
            bitmap = Bitmap.createBitmap(i2, i, config);
        } catch (OutOfMemoryError e6) {
            e6.printStackTrace();
        }
        float f7 = i2 / options.outWidth;
        float f8 = i / options.outHeight;
        Matrix matrix = new Matrix();
        matrix.setScale(f7, f8, 0.0f, 0.0f);
        Canvas canvas = new Canvas(bitmap);
        canvas.setMatrix(matrix);
        canvas.drawBitmap(decodeFile, 0.0f, 0.0f, new Paint(2));
        try {
            int attributeInt = new ExifInterface(realPathFromURI).getAttributeInt("Orientation", 0);
            Matrix matrix2 = new Matrix();
            if (attributeInt == 6) {
                matrix2.postRotate(90.0f);
            } else if (attributeInt == 3) {
                matrix2.postRotate(180.0f);
            } else if (attributeInt == 8) {
                matrix2.postRotate(270.0f);
            }
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix2, true);
        } catch (IOException e7) {
            e7.printStackTrace();
            return bitmap;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static File compressImage(Context context, Uri uri, float f, float f2, Bitmap.CompressFormat compressFormat, Bitmap.Config config, int i, String str, String str2, String str3) {
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        String str4 = compressFormat == Bitmap.CompressFormat.JPEG ? ContentTypes.EXTENSION_JPG_1 : null;
        if (str4 == null) {
            str4 = compressFormat.name().toLowerCase();
        }
        String generateFilePath = generateFilePath(context, str, uri, str4, str2, str3);
        try {
            try {
                FileOutputStream fileOutputStream3 = new FileOutputStream(generateFilePath);
                try {
                    Bitmap scaledBitmap = getScaledBitmap(context, uri, f, f2, config);
                    if (scaledBitmap != 0) {
                        scaledBitmap.compress(compressFormat, i, fileOutputStream3);
                    }
                    fileOutputStream3.close();
                    fileOutputStream = scaledBitmap;
                } catch (FileNotFoundException e) {
                    e = e;
                    fileOutputStream2 = fileOutputStream3;
                    e.printStackTrace();
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                        fileOutputStream = fileOutputStream2;
                    }
                    return new File(generateFilePath);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream3;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            }
            return new File(generateFilePath);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String generateFilePath(Context context, String str, Uri uri, String str2, String str3, String str4) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = str3 + FileUtil.splitFileName(FileUtil.getFileName(context, uri))[0];
        }
        return file.getAbsolutePath() + File.separator + str4 + "." + str2;
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int round;
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 > i2 || i4 > i) {
            round = Math.round(i3 / i2);
            int round2 = Math.round(i4 / i);
            if (round >= round2) {
                round = round2;
            }
        } else {
            round = 1;
        }
        while ((i4 * i3) / (round * round) > i * i2 * 2) {
            round++;
        }
        return round;
    }

    public static Bitmap getCacheBitmapFromView(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public static Bitmap centerCropBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        return Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height);
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.setRotate(i, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static void recycle(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
            } catch (Exception e) {
                DDLog.m1684e("bitmap 释放失败:" + e);
            }
        }
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        } else {
            createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static Bitmap blurBitmap(Context context, Bitmap bitmap, float f) {
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * BITMAP_SCALE), Math.round(bitmap.getHeight() * BITMAP_SCALE), false);
        Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
        RenderScript create = RenderScript.create(context);
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
        Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
        create2.setRadius(f);
        create2.setInput(createFromBitmap);
        create2.forEach(createFromBitmap2);
        createFromBitmap2.copyTo(createBitmap);
        return createBitmap;
    }
}