package jp.wasabeef.blurry;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.renderscript.RSRuntimeException;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Array;

/* loaded from: classes4.dex */
class Blur {
    Blur() {
    }

    public static Bitmap of(View view, BlurFactor blurFactor) {
        view.setDrawingCacheEnabled(true);
        view.destroyDrawingCache();
        view.setDrawingCacheQuality(524288);
        Bitmap drawingCache = view.getDrawingCache();
        Bitmap of = of(view.getContext(), drawingCache, blurFactor);
        drawingCache.recycle();
        return of;
    }

    public static Bitmap of(Context context, Bitmap bitmap, BlurFactor blurFactor) {
        Bitmap stack;
        int i = blurFactor.width / blurFactor.sampling;
        int i2 = blurFactor.height / blurFactor.sampling;
        if (Helper.hasZero(i, i2)) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.scale(1.0f / blurFactor.sampling, 1.0f / blurFactor.sampling);
        Paint paint = new Paint();
        paint.setFlags(3);
        paint.setColorFilter(new PorterDuffColorFilter(blurFactor.color, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        try {
            stack = rs(context, createBitmap, blurFactor.radius);
        } catch (RSRuntimeException unused) {
            stack = stack(createBitmap, blurFactor.radius, true);
        }
        if (blurFactor.sampling == 1) {
            return stack;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(stack, blurFactor.width, blurFactor.height, true);
        stack.recycle();
        return createScaledBitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap rs(android.content.Context r5, android.graphics.Bitmap r6, int r7) throws android.renderscript.RSRuntimeException {
        /*
            r0 = 0
            android.renderscript.RenderScript r5 = android.renderscript.RenderScript.create(r5)     // Catch: java.lang.Throwable -> L54
            android.renderscript.RenderScript$RSMessageHandler r1 = new android.renderscript.RenderScript$RSMessageHandler     // Catch: java.lang.Throwable -> L4e
            r1.<init>()     // Catch: java.lang.Throwable -> L4e
            r5.setMessageHandler(r1)     // Catch: java.lang.Throwable -> L4e
            android.renderscript.Allocation$MipmapControl r1 = android.renderscript.Allocation.MipmapControl.MIPMAP_NONE     // Catch: java.lang.Throwable -> L4e
            r2 = 1
            android.renderscript.Allocation r1 = android.renderscript.Allocation.createFromBitmap(r5, r6, r1, r2)     // Catch: java.lang.Throwable -> L4e
            android.renderscript.Type r2 = r1.getType()     // Catch: java.lang.Throwable -> L4b
            android.renderscript.Allocation r2 = android.renderscript.Allocation.createTyped(r5, r2)     // Catch: java.lang.Throwable -> L4b
            android.renderscript.Element r3 = android.renderscript.Element.U8_4(r5)     // Catch: java.lang.Throwable -> L46
            android.renderscript.ScriptIntrinsicBlur r0 = android.renderscript.ScriptIntrinsicBlur.create(r5, r3)     // Catch: java.lang.Throwable -> L46
            r0.setInput(r1)     // Catch: java.lang.Throwable -> L46
            float r7 = (float) r7     // Catch: java.lang.Throwable -> L46
            r0.setRadius(r7)     // Catch: java.lang.Throwable -> L46
            r0.forEach(r2)     // Catch: java.lang.Throwable -> L46
            r2.copyTo(r6)     // Catch: java.lang.Throwable -> L46
            if (r5 == 0) goto L36
            r5.destroy()
        L36:
            if (r1 == 0) goto L3b
            r1.destroy()
        L3b:
            if (r2 == 0) goto L40
            r2.destroy()
        L40:
            if (r0 == 0) goto L45
            r0.destroy()
        L45:
            return r6
        L46:
            r6 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L58
        L4b:
            r6 = move-exception
            r2 = r0
            goto L51
        L4e:
            r6 = move-exception
            r1 = r0
            r2 = r1
        L51:
            r0 = r5
            r5 = r2
            goto L58
        L54:
            r6 = move-exception
            r5 = r0
            r1 = r5
            r2 = r1
        L58:
            if (r0 == 0) goto L5d
            r0.destroy()
        L5d:
            if (r1 == 0) goto L62
            r1.destroy()
        L62:
            if (r2 == 0) goto L67
            r2.destroy()
        L67:
            if (r5 == 0) goto L6c
            r5.destroy()
        L6c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.wasabeef.blurry.Blur.rs(android.content.Context, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    private static Bitmap stack(Bitmap bitmap, int i, boolean z) {
        int[] iArr;
        int i2 = i;
        Bitmap copy = z ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i2 < 1) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i3 = width * height;
        int[] iArr2 = new int[i3];
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i4 = width - 1;
        int i5 = height - 1;
        int i6 = i2 + i2 + 1;
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[i3];
        int[] iArr5 = new int[i3];
        int[] iArr6 = new int[Math.max(width, height)];
        int i7 = (i6 + 1) >> 1;
        int i8 = i7 * i7;
        int i9 = i8 * 256;
        int[] iArr7 = new int[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            iArr7[i10] = i10 / i8;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) int.class, i6, 3);
        int i11 = i2 + 1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < height) {
            Bitmap bitmap2 = copy;
            int i15 = height;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = -i2;
            int i25 = 0;
            while (i24 <= i2) {
                int i26 = i5;
                int[] iArr9 = iArr6;
                int i27 = iArr2[i13 + Math.min(i4, Math.max(i24, 0))];
                int[] iArr10 = iArr8[i24 + i2];
                iArr10[0] = (i27 & 16711680) >> 16;
                iArr10[1] = (i27 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i27 & 255;
                int abs = i11 - Math.abs(i24);
                i25 += iArr10[0] * abs;
                i16 += iArr10[1] * abs;
                i17 += iArr10[2] * abs;
                if (i24 > 0) {
                    i21 += iArr10[0];
                    i22 += iArr10[1];
                    i23 += iArr10[2];
                } else {
                    i18 += iArr10[0];
                    i19 += iArr10[1];
                    i20 += iArr10[2];
                }
                i24++;
                i5 = i26;
                iArr6 = iArr9;
            }
            int i28 = i5;
            int[] iArr11 = iArr6;
            int i29 = i2;
            int i30 = i25;
            int i31 = 0;
            while (i31 < width) {
                iArr3[i13] = iArr7[i30];
                iArr4[i13] = iArr7[i16];
                iArr5[i13] = iArr7[i17];
                int i32 = i30 - i18;
                int i33 = i16 - i19;
                int i34 = i17 - i20;
                int[] iArr12 = iArr8[((i29 - i2) + i6) % i6];
                int i35 = i18 - iArr12[0];
                int i36 = i19 - iArr12[1];
                int i37 = i20 - iArr12[2];
                if (i12 == 0) {
                    iArr = iArr7;
                    iArr11[i31] = Math.min(i31 + i2 + 1, i4);
                } else {
                    iArr = iArr7;
                }
                int i38 = iArr2[i14 + iArr11[i31]];
                iArr12[0] = (i38 & 16711680) >> 16;
                iArr12[1] = (i38 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr12[2] = i38 & 255;
                int i39 = i21 + iArr12[0];
                int i40 = i22 + iArr12[1];
                int i41 = i23 + iArr12[2];
                i30 = i32 + i39;
                i16 = i33 + i40;
                i17 = i34 + i41;
                i29 = (i29 + 1) % i6;
                int[] iArr13 = iArr8[i29 % i6];
                i18 = i35 + iArr13[0];
                i19 = i36 + iArr13[1];
                i20 = i37 + iArr13[2];
                i21 = i39 - iArr13[0];
                i22 = i40 - iArr13[1];
                i23 = i41 - iArr13[2];
                i13++;
                i31++;
                iArr7 = iArr;
            }
            i14 += width;
            i12++;
            copy = bitmap2;
            height = i15;
            i5 = i28;
            iArr6 = iArr11;
        }
        Bitmap bitmap3 = copy;
        int i42 = i5;
        int[] iArr14 = iArr6;
        int i43 = height;
        int[] iArr15 = iArr7;
        int i44 = 0;
        while (i44 < width) {
            int i45 = -i2;
            int i46 = i6;
            int[] iArr16 = iArr2;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = i45;
            int i55 = i45 * width;
            int i56 = 0;
            int i57 = 0;
            while (i54 <= i2) {
                int i58 = width;
                int max = Math.max(0, i55) + i44;
                int[] iArr17 = iArr8[i54 + i2];
                iArr17[0] = iArr3[max];
                iArr17[1] = iArr4[max];
                iArr17[2] = iArr5[max];
                int abs2 = i11 - Math.abs(i54);
                i56 += iArr3[max] * abs2;
                i57 += iArr4[max] * abs2;
                i47 += iArr5[max] * abs2;
                if (i54 > 0) {
                    i51 += iArr17[0];
                    i52 += iArr17[1];
                    i53 += iArr17[2];
                } else {
                    i48 += iArr17[0];
                    i49 += iArr17[1];
                    i50 += iArr17[2];
                }
                int i59 = i42;
                if (i54 < i59) {
                    i55 += i58;
                }
                i54++;
                i42 = i59;
                width = i58;
            }
            int i60 = width;
            int i61 = i42;
            int i62 = i2;
            int i63 = i44;
            int i64 = i57;
            int i65 = i43;
            int i66 = i56;
            int i67 = 0;
            while (i67 < i65) {
                iArr16[i63] = (iArr16[i63] & ViewCompat.MEASURED_STATE_MASK) | (iArr15[i66] << 16) | (iArr15[i64] << 8) | iArr15[i47];
                int i68 = i66 - i48;
                int i69 = i64 - i49;
                int i70 = i47 - i50;
                int[] iArr18 = iArr8[((i62 - i2) + i46) % i46];
                int i71 = i48 - iArr18[0];
                int i72 = i49 - iArr18[1];
                int i73 = i50 - iArr18[2];
                if (i44 == 0) {
                    iArr14[i67] = Math.min(i67 + i11, i61) * i60;
                }
                int i74 = iArr14[i67] + i44;
                iArr18[0] = iArr3[i74];
                iArr18[1] = iArr4[i74];
                iArr18[2] = iArr5[i74];
                int i75 = i51 + iArr18[0];
                int i76 = i52 + iArr18[1];
                int i77 = i53 + iArr18[2];
                i66 = i68 + i75;
                i64 = i69 + i76;
                i47 = i70 + i77;
                i62 = (i62 + 1) % i46;
                int[] iArr19 = iArr8[i62];
                i48 = i71 + iArr19[0];
                i49 = i72 + iArr19[1];
                i50 = i73 + iArr19[2];
                i51 = i75 - iArr19[0];
                i52 = i76 - iArr19[1];
                i53 = i77 - iArr19[2];
                i63 += i60;
                i67++;
                i2 = i;
            }
            i44++;
            i2 = i;
            i42 = i61;
            i43 = i65;
            i6 = i46;
            iArr2 = iArr16;
            width = i60;
        }
        int i78 = width;
        bitmap3.setPixels(iArr2, 0, i78, 0, 0, i78, i43);
        return bitmap3;
    }
}
