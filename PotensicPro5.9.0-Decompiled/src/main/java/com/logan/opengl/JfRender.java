package com.logan.opengl;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Size;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.baselib.utils.YuvTransformer;
import com.logan.libffmpeg.R;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes3.dex */
public class JfRender implements GLSurfaceView.Renderer {
    private int afPosition_yuv;
    private int avPosition_yuv;
    private Context context;
    private GLSurfaceView glSurfaceView;
    private int height_yuv;
    private int mvpMatrixLoc;
    private int program_yuv;
    private int sampler_u;
    private int sampler_v;
    private int sampler_y;
    private int screenHeight;
    private int screenWidth;
    private FloatBuffer textureBuffer;
    private final float[] textureData;
    private int[] textureId_yuv;
    private ByteBuffer u;
    private ByteBuffer v;
    private FloatBuffer vertexBuffer;
    private final float[] vertexData;
    private int width_yuv;
    private ByteBuffer y;
    private final String TAG = "JfRender";
    private final float[] scaleMatrix = new float[16];
    private float scaleValue = 1.0f;
    private float rotateDegree = 0.0f;
    private boolean isAnimating = false;

    static void mat4f_LoadOrtho(float f, float f2, float f3, float f4, float f5, float f6, float[] fArr) {
        float f7 = f2 - f;
        float f8 = f4 - f3;
        float f9 = f6 - f5;
        float f10 = (-(f2 + f)) / f7;
        float f11 = (-(f4 + f3)) / f8;
        fArr[0] = 2.0f / f7;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 2.0f / f8;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = (-2.0f) / f9;
        fArr[11] = 0.0f;
        fArr[12] = f10;
        fArr[13] = f11;
        fArr[14] = (-(f6 + f5)) / f9;
        fArr[15] = 1.0f;
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }

    public int getWidth_yuv() {
        return this.width_yuv;
    }

    public int getHeight_yuv() {
        return this.height_yuv;
    }

    public JfRender(Context context, GLSurfaceView gLSurfaceView) {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        this.vertexData = fArr;
        float[] fArr2 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        this.textureData = fArr2;
        this.context = context;
        this.glSurfaceView = gLSurfaceView;
        this.screenWidth = ScreenUtils.getScreenWidth(context);
        this.screenHeight = ScreenUtils.getScreenHeight(context);
        FloatBuffer put = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr);
        this.vertexBuffer = put;
        put.position(0);
        FloatBuffer put2 = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr2);
        this.textureBuffer = put2;
        put2.position(0);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        initRenderYUV();
        this.mvpMatrixLoc = GLES20.glGetUniformLocation(this.program_yuv, "mvpMatrix");
        scale(this.scaleValue);
        rotate(this.rotateDegree);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        DDLog.e("JfRender", "onSurfaceChanged:");
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(16384);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        renderYUV();
        GLES20.glDrawArrays(5, 0, 4);
    }

    public void clearView() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
    }

    public void scale(float f) {
        this.scaleValue = f;
        setEffects();
    }

    public void rotate(float f) {
        this.rotateDegree = f;
        setEffects();
    }

    public void setAnimating(boolean z) {
        this.isAnimating = z;
    }

    private void setEffects() {
        Matrix.setIdentityM(this.scaleMatrix, 0);
        Matrix.rotateM(this.scaleMatrix, 0, this.rotateDegree, 0.0f, 0.0f, 1.0f);
    }

    private void initRenderYUV() {
        int createProgram = JfShaderUtil.createProgram(JfShaderUtil.readRawTxt(this.context, R.raw.vertex_shader), JfShaderUtil.readRawTxt(this.context, R.raw.fragment_shader));
        this.program_yuv = createProgram;
        this.avPosition_yuv = GLES20.glGetAttribLocation(createProgram, "av_Position");
        this.afPosition_yuv = GLES20.glGetAttribLocation(this.program_yuv, "af_Position");
        this.sampler_y = GLES20.glGetUniformLocation(this.program_yuv, "sampler_y");
        this.sampler_u = GLES20.glGetUniformLocation(this.program_yuv, "sampler_u");
        this.sampler_v = GLES20.glGetUniformLocation(this.program_yuv, "sampler_v");
        int[] iArr = new int[3];
        this.textureId_yuv = iArr;
        GLES20.glGenTextures(3, iArr, 0);
        for (int i = 0; i < 3; i++) {
            GLES20.glBindTexture(3553, this.textureId_yuv[i]);
            GLES20.glTexParameteri(3553, 10242, 10497);
            GLES20.glTexParameteri(3553, 10243, 10497);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
        }
        DDLog.d("initRenderYUV");
    }

    public synchronized void setYUVRenderData(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (this.isAnimating) {
            DDLog.e("动画中 不渲染");
            return;
        }
        this.width_yuv = i;
        this.height_yuv = i2;
        ByteBuffer byteBuffer = this.y;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.u;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        ByteBuffer byteBuffer3 = this.v;
        if (byteBuffer3 != null) {
            byteBuffer3.clear();
        }
        this.y = ByteBuffer.wrap(bArr);
        this.u = ByteBuffer.wrap(bArr2);
        this.v = ByteBuffer.wrap(bArr3);
    }

    public synchronized Bitmap getBitmap() {
        ByteBuffer byteBuffer = this.y;
        if (byteBuffer != null && this.u != null && this.v != null) {
            return YuvTransformer.nv21ToBitmap(YuvTransformer.getNv21(byteBuffer.array(), this.u.array(), this.v.array(), this.width_yuv, this.height_yuv), this.width_yuv, this.height_yuv);
        }
        return null;
    }

    private synchronized void renderYUV() {
        int i;
        GLSurfaceView gLSurfaceView = this.glSurfaceView;
        if (gLSurfaceView == null) {
            return;
        }
        this.screenWidth = gLSurfaceView.getWidth();
        int height = this.glSurfaceView.getHeight();
        this.screenHeight = height;
        int i2 = this.width_yuv;
        if (i2 > 0 && (i = this.height_yuv) > 0 && this.y != null && this.u != null && this.v != null) {
            float f = this.rotateDegree;
            if (f != 90.0f && f != 270.0f) {
                float f2 = (i2 * ((height * 100.0f) / i)) / 100.0f;
                float f3 = this.scaleValue;
                int i3 = (int) ((f2 * (f3 * 10.0f)) / 10.0f);
                int i4 = (((int) (f3 * 10.0f)) * height) / 10;
                GLES20.glViewport((this.screenWidth - i3) / 2, (0 - ((height * ((int) ((f3 - 1.0f) * 10.0f))) / 10)) / 2, i3, i4);
                if (PhoneConfig.showSize == null || PhoneConfig.showSize.getWidth() != i3 || PhoneConfig.showSize.getHeight() != i4) {
                    PhoneConfig.showSize = new Size(i3, i4);
                    EventDispatcher.get().sendEvent(EventID.EVENT_PREVIEW_VIDEO_SHOW_AREA_CHANGED);
                }
                GLES20.glUseProgram(this.program_yuv);
                GLES20.glEnableVertexAttribArray(this.avPosition_yuv);
                GLES20.glVertexAttribPointer(this.avPosition_yuv, 2, 5126, false, 8, (Buffer) this.vertexBuffer);
                GLES20.glEnableVertexAttribArray(this.afPosition_yuv);
                GLES20.glVertexAttribPointer(this.afPosition_yuv, 2, 5126, false, 8, (Buffer) this.textureBuffer);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, this.textureId_yuv[0]);
                GLES20.glTexImage2D(3553, 0, 6409, this.width_yuv, this.height_yuv, 0, 6409, 5121, this.y);
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(3553, this.textureId_yuv[1]);
                GLES20.glTexImage2D(3553, 0, 6409, this.width_yuv / 2, this.height_yuv / 2, 0, 6409, 5121, this.u);
                GLES20.glActiveTexture(33986);
                GLES20.glBindTexture(3553, this.textureId_yuv[2]);
                GLES20.glTexImage2D(3553, 0, 6409, this.width_yuv / 2, this.height_yuv / 2, 0, 6409, 5121, this.v);
                GLES20.glUniform1i(this.sampler_y, 0);
                GLES20.glUniform1i(this.sampler_u, 1);
                GLES20.glUniform1i(this.sampler_v, 2);
                GLES20.glUniformMatrix4fv(this.mvpMatrixLoc, 1, false, this.scaleMatrix, 0);
                GLES20.glDrawArrays(5, 0, 4);
            }
            int i5 = (int) ((i / i2) * height);
            int i6 = this.screenWidth;
            float f4 = this.scaleValue;
            GLES20.glViewport((i6 - ((((int) (f4 * 10.0f)) * i5) / 10)) / 2, (0 - ((((int) ((f4 - 1.0f) * 10.0f)) * height) / 10)) / 2, (i5 * ((int) (f4 * 10.0f))) / 10, (height * ((int) (f4 * 10.0f))) / 10);
            GLES20.glUseProgram(this.program_yuv);
            GLES20.glEnableVertexAttribArray(this.avPosition_yuv);
            GLES20.glVertexAttribPointer(this.avPosition_yuv, 2, 5126, false, 8, (Buffer) this.vertexBuffer);
            GLES20.glEnableVertexAttribArray(this.afPosition_yuv);
            GLES20.glVertexAttribPointer(this.afPosition_yuv, 2, 5126, false, 8, (Buffer) this.textureBuffer);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.textureId_yuv[0]);
            GLES20.glTexImage2D(3553, 0, 6409, this.width_yuv, this.height_yuv, 0, 6409, 5121, this.y);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.textureId_yuv[1]);
            GLES20.glTexImage2D(3553, 0, 6409, this.width_yuv / 2, this.height_yuv / 2, 0, 6409, 5121, this.u);
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, this.textureId_yuv[2]);
            GLES20.glTexImage2D(3553, 0, 6409, this.width_yuv / 2, this.height_yuv / 2, 0, 6409, 5121, this.v);
            GLES20.glUniform1i(this.sampler_y, 0);
            GLES20.glUniform1i(this.sampler_u, 1);
            GLES20.glUniform1i(this.sampler_v, 2);
            GLES20.glUniformMatrix4fv(this.mvpMatrixLoc, 1, false, this.scaleMatrix, 0);
            GLES20.glDrawArrays(5, 0, 4);
        }
    }
}
