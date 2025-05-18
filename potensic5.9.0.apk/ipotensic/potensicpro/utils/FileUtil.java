package com.ipotensic.potensicpro.utils;

import android.graphics.Bitmap;
import com.ipotensic.baselib.LocalFileManager;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;

/* loaded from: classes2.dex */
public class FileUtil {
    public static boolean writeToFile(String str, byte[] bArr) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean saveBitmap(String str, Bitmap bitmap) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static byte[] fileToByteArray(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1000);
            byte[] bArr = new byte[1000];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0065 A[Catch: IOException -> 0x0061, TRY_LEAVE, TryCatch #3 {IOException -> 0x0061, blocks: (B:44:0x005d, B:37:0x0065), top: B:43:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getStringFromInputStream(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        } catch (IOException e) {
            e = e;
            bufferedReader = null;
            inputStreamReader = null;
        } catch (Throwable th2) {
            inputStreamReader = null;
            th = th2;
            bufferedReader = null;
        }
        try {
            bufferedReader = new BufferedReader(inputStreamReader);
        } catch (IOException e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (inputStreamReader != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
        try {
            try {
                StringBuffer stringBuffer = new StringBuffer("");
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                    stringBuffer.append("\n");
                }
                String stringBuffer2 = stringBuffer.toString();
                try {
                    inputStreamReader.close();
                    bufferedReader.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return stringBuffer2;
            } catch (Throwable th4) {
                th = th4;
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        throw th;
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            e.printStackTrace();
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                    return null;
                }
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return null;
        }
    }

    public static void copyFile(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        r0 = null;
        FileChannel fileChannel3 = null;
        fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = null;
                    fileChannel = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                    fileChannel = null;
                }
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = null;
                fileChannel = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                fileChannel = null;
            }
            try {
                fileChannel = fileInputStream.getChannel();
                try {
                    fileChannel3 = fileOutputStream.getChannel();
                    fileChannel.transferTo(0L, fileChannel.size(), fileChannel3);
                    try {
                        fileInputStream.close();
                    } catch (Exception unused) {
                    }
                    try {
                        fileChannel.close();
                    } catch (Exception unused2) {
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused3) {
                    }
                    fileChannel3.close();
                } catch (IOException e3) {
                    e = e3;
                    fileChannel2 = fileChannel3;
                    fileInputStream2 = fileInputStream;
                    try {
                        e.printStackTrace();
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused4) {
                        }
                        try {
                            fileChannel.close();
                        } catch (Exception unused5) {
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused6) {
                        }
                        fileChannel2.close();
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused7) {
                        }
                        try {
                            fileChannel.close();
                        } catch (Exception unused8) {
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused9) {
                        }
                        try {
                            fileChannel2.close();
                            throw th;
                        } catch (Exception unused10) {
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileChannel2 = fileChannel3;
                    fileInputStream2 = fileInputStream;
                    fileInputStream2.close();
                    fileChannel.close();
                    fileOutputStream.close();
                    fileChannel2.close();
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
                fileChannel = null;
                fileInputStream2 = fileInputStream;
                fileChannel2 = fileChannel;
                e.printStackTrace();
                fileInputStream2.close();
                fileChannel.close();
                fileOutputStream.close();
                fileChannel2.close();
            } catch (Throwable th5) {
                th = th5;
                fileChannel = null;
                fileInputStream2 = fileInputStream;
                fileChannel2 = fileChannel;
                fileInputStream2.close();
                fileChannel.close();
                fileOutputStream.close();
                fileChannel2.close();
                throw th;
            }
        } catch (Exception unused11) {
        }
    }

    public static String fromBitmapGetFilePath(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (LocalFileManager.getInstance().getCacheDir() == null) {
            LocalFileManager.getInstance().initExternalDir();
            LocalFileManager.getInstance().initMediaDir();
        }
        String str = LocalFileManager.getInstance().getCacheDir() + File.separator + "picture_" + currentTimeMillis + ".jpg";
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}