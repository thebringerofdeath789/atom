package com.ipotensic.kernel.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;

/* loaded from: classes2.dex */
public class NV21ToBitmapHelper {

    /* renamed from: in */
    private Allocation f2242in;
    private int lastHeight;
    private int lastWidth;
    private Allocation out;
    private Type.Builder rgbaType;

    /* renamed from: rs */
    private RenderScript f2243rs;
    private ScriptIntrinsicYuvToRGB yuvToRgbIntrinsic;
    private Type.Builder yuvType;

    public NV21ToBitmapHelper(Context context) {
        RenderScript create = RenderScript.create(context);
        this.f2243rs = create;
        this.yuvToRgbIntrinsic = ScriptIntrinsicYuvToRGB.create(create, Element.U8_4(create));
    }

    public Bitmap nv21ToBitmap(byte[] bArr, int i, int i2) {
        if (this.lastWidth != i || this.lastHeight != i2) {
            this.yuvType = null;
        }
        if (this.yuvType == null) {
            RenderScript renderScript = this.f2243rs;
            Type.Builder x = new Type.Builder(renderScript, Element.U8(renderScript)).setX(bArr.length);
            this.yuvType = x;
            this.f2242in = Allocation.createTyped(this.f2243rs, x.create(), 1);
            RenderScript renderScript2 = this.f2243rs;
            Type.Builder y = new Type.Builder(renderScript2, Element.RGBA_8888(renderScript2)).setX(i).setY(i2);
            this.rgbaType = y;
            this.out = Allocation.createTyped(this.f2243rs, y.create(), 1);
        }
        this.f2242in.copyFrom(bArr);
        this.yuvToRgbIntrinsic.setInput(this.f2242in);
        this.yuvToRgbIntrinsic.forEach(this.out);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.out.copyTo(createBitmap);
        this.lastWidth = i;
        this.lastHeight = i2;
        return createBitmap;
    }

    public void release() {
        RenderScript renderScript = this.f2243rs;
        if (renderScript != null) {
            try {
                renderScript.finish();
                this.f2243rs.destroy();
            } catch (Exception unused) {
            }
            this.f2243rs = null;
        }
        ScriptIntrinsicYuvToRGB scriptIntrinsicYuvToRGB = this.yuvToRgbIntrinsic;
        if (scriptIntrinsicYuvToRGB != null) {
            try {
                scriptIntrinsicYuvToRGB.destroy();
            } catch (Exception unused2) {
            }
            this.yuvToRgbIntrinsic = null;
        }
    }
}