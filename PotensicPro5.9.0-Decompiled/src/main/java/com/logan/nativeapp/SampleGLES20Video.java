package com.logan.nativeapp;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes3.dex */
public class SampleGLES20Video {
    private static final int BYTES_PER_FLOAT = 4;
    private static final int COORDS_PER_TEXTURE = 2;
    private static final int COORDS_PER_VERTEX = 3;
    private final int mProgram;
    String screenshotName;
    int surfaceHeight;
    int surfaceWidth;
    private FloatBuffer textureBuffer;
    private FloatBuffer vertexBuffer;
    private float[] vertexCoords;
    private int[] textureHandle = new int[1];
    private float[] textureCoords = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private final String vertexShaderCode = "attribute vec4 vPosition;attribute vec2 vTexCoord;varying vec2 texCoordVar;void main() {    gl_Position = vPosition;    texCoordVar = vTexCoord;};";
    private final String fragmentShaderCode = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;uniform samplerExternalOES texture;varying vec2 texCoordVar;void main() {    gl_FragColor = texture2D(texture, texCoordVar);}";

    private static int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            int[] iArr2 = {0};
            GLES20.glGetShaderiv(glCreateShader, 35716, iArr2, 0);
            if (iArr2[0] > 0) {
                Log.d(SampleGLES20Video.class.getName(), GLES20.glGetShaderInfoLog(glCreateShader));
            }
        }
        return glCreateShader;
    }

    private void createBitmap(String str) {
        int i = this.surfaceWidth * this.surfaceHeight;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        GLES20.glReadPixels(0, 0, this.surfaceWidth, this.surfaceHeight, 6408, 5121, allocateDirect);
        int[] iArr = new int[i];
        allocateDirect.asIntBuffer().get(iArr);
        Bitmap createBitmap = Bitmap.createBitmap(this.surfaceWidth, this.surfaceHeight, Bitmap.Config.ARGB_8888);
        int i2 = this.surfaceWidth;
        createBitmap.setPixels(iArr, i - i2, -i2, 0, 0, i2, this.surfaceHeight);
        try {
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(str));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        createBitmap.recycle();
    }

    public void draw() {
        GLES20.glUseProgram(this.mProgram);
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgram, "vPosition");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.mProgram, "vTexCoord");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 3, 5126, false, 12, (Buffer) this.vertexBuffer);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, (Buffer) this.textureBuffer);
        GLES20.glDrawArrays(5, 0, this.vertexCoords.length / 3);
        GLES20.glDisableVertexAttribArray(glGetAttribLocation);
        GLES20.glDisableVertexAttribArray(glGetAttribLocation2);
        String str = this.screenshotName;
        if (str != null) {
            createBitmap(str);
            this.screenshotName = null;
        }
    }

    public SampleGLES20Video() {
        float[] fArr = {-1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f};
        this.vertexCoords = fArr;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.vertexBuffer = asFloatBuffer;
        asFloatBuffer.put(this.vertexCoords);
        this.vertexBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.textureCoords.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        this.textureBuffer = asFloatBuffer2;
        asFloatBuffer2.put(this.textureCoords);
        this.textureBuffer.position(0);
        int glCreateProgram = GLES20.glCreateProgram();
        this.mProgram = glCreateProgram;
        GLES20.glAttachShader(glCreateProgram, loadShader(35633, "attribute vec4 vPosition;attribute vec2 vTexCoord;varying vec2 texCoordVar;void main() {    gl_Position = vPosition;    texCoordVar = vTexCoord;};"));
        GLES20.glAttachShader(glCreateProgram, loadShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;uniform samplerExternalOES texture;varying vec2 texCoordVar;void main() {    gl_FragColor = texture2D(texture, texCoordVar);}"));
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glUseProgram(glCreateProgram);
        GLES20.glUniform1i(GLES20.glGetUniformLocation(glCreateProgram, "texture"), 0);
        GLES20.glGenTextures(1, this.textureHandle, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.textureHandle[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
    }

    public int getTextureHandle() {
        return this.textureHandle[0];
    }

    public void setResolution(int i, int i2) {
        this.surfaceWidth = i;
        this.surfaceHeight = i2;
    }

    public void screenshot(String str) {
        this.screenshotName = str;
    }
}
