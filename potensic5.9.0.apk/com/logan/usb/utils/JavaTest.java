package com.logan.usb.utils;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.netty.ParseUtil;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class JavaTest {
    private ConcurrentLinkedQueue<byte[]> frameNal = new ConcurrentLinkedQueue<>();
    private static byte[] head = "usb head head".getBytes();
    private static byte[] end = "usb end end".getBytes();
    public static boolean isRunning = true;

    /* renamed from: as */
    private static BlockingQueue<String> f2674as = new LinkedBlockingDeque();
    public static ScheduledThreadPoolExecutor schedule = new ScheduledThreadPoolExecutor((Runtime.getRuntime().availableProcessors() * 2) + 1, new ThreadFactory() { // from class: com.logan.usb.utils.JavaTest.3
        final AtomicInteger count = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "MyScheduleThread_" + this.count.getAndIncrement());
        }
    }, new ThreadPoolExecutor.AbortPolicy());
    static int num = 100;
    public static ExecutorService threadPool = Executors.newCachedThreadPool();
    private static int dataSize = 10;

    public static class Item {
    }

    public interface OnRecordTimerListener {
        void onTimeUpdate(long j);
    }

    public interface OnUpdateListener {
        void onPercent(long j);
    }

    class MethodTest {
        MethodTest() {
        }

        public void getCaller() {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            for (int i = 0; i < stackTrace.length; i++) {
                StackTraceElement stackTraceElement = stackTrace[i];
                System.out.format(" ClassName:%d\t%s\n", Integer.valueOf(i), stackTraceElement.getClassName());
                System.out.format("MethodName:%d\t%s\n", Integer.valueOf(i), stackTraceElement.getMethodName());
                System.out.format("  FileName:%d\t%s\n", Integer.valueOf(i), stackTraceElement.getFileName());
                System.out.format("LineNumber:%d\t%s\n\n", Integer.valueOf(i), Integer.valueOf(stackTraceElement.getLineNumber()));
            }
        }
    }

    public static int getHeadIndex(byte[] bArr, int i) {
        int i2 = 0;
        while (true) {
            byte[] bArr2 = head;
            if (i2 >= bArr2.length) {
                return i;
            }
            if (bArr[i + i2] != bArr2[i2]) {
                return -1;
            }
            i2++;
        }
    }

    public static int getEndIndex(byte[] bArr, int i) {
        int i2 = 0;
        while (true) {
            byte[] bArr2 = end;
            if (i2 >= bArr2.length) {
                return i;
            }
            if (bArr[i + i2] != bArr2[i2]) {
                return -1;
            }
            i2++;
        }
    }

    public static boolean isUsbFrameHead(byte[] bArr, int i) {
        int i2 = i + 6;
        return bArr.length >= i2 && bArr[i] == -2 && bArr[i + 1] == 0 && bArr[i + 2] == 0 && bArr[i + 3] == 0 && bArr[i + 4] == 0 && bArr[i + 5] == 0 && bArr[i2] == 0;
    }

    private static void producter() {
        new Thread(new Runnable() { // from class: com.logan.usb.utils.JavaTest.1
            /* JADX WARN: Code restructure failed: missing block: B:14:0x005d, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:15:0x005e, code lost:
            
                r0.printStackTrace();
             */
            /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
            
                return;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r5 = this;
                    r0 = 0
                    r1 = r0
                L2:
                    int r1 = r1 + 1
                    r2 = 1000(0x3e8, double:4.94E-321)
                    java.lang.Thread.sleep(r2)     // Catch: java.lang.InterruptedException -> La
                    goto Le
                La:
                    r2 = move-exception
                    r2.printStackTrace()
                Le:
                    java.util.concurrent.BlockingQueue r2 = com.logan.usb.utils.JavaTest.access$000()
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "哈哈-->"
                    java.lang.StringBuilder r3 = r3.append(r4)
                    java.lang.StringBuilder r3 = r3.append(r1)
                    java.lang.String r3 = r3.toString()
                    r2.add(r3)
                    java.io.PrintStream r2 = java.lang.System.out
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "队列大小为:"
                    java.lang.StringBuilder r3 = r3.append(r4)
                    java.util.concurrent.BlockingQueue r4 = com.logan.usb.utils.JavaTest.access$000()
                    int r4 = r4.size()
                    java.lang.StringBuilder r3 = r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    r2.println(r3)
                    r2 = 10
                    if (r1 < r2) goto L2
                    r1 = 5000(0x1388, double:2.4703E-320)
                    java.lang.Thread.sleep(r1)     // Catch: java.lang.InterruptedException -> L5d
                    java.util.concurrent.BlockingQueue r1 = com.logan.usb.utils.JavaTest.access$000()     // Catch: java.lang.InterruptedException -> L5d
                    java.lang.String r2 = ""
                    r1.offer(r2)     // Catch: java.lang.InterruptedException -> L5d
                    com.logan.usb.utils.JavaTest.isRunning = r0     // Catch: java.lang.InterruptedException -> L5d
                    goto L61
                L5d:
                    r0 = move-exception
                    r0.printStackTrace()
                L61:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.logan.usb.utils.JavaTest.RunnableC30541.run():void");
            }
        }).start();
    }

    private static void customer() {
        new Thread(new Runnable() { // from class: com.logan.usb.utils.JavaTest.2
            @Override // java.lang.Runnable
            public void run() {
                while (JavaTest.isRunning) {
                    try {
                        System.out.println((String) JavaTest.f2674as.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                System.out.println("结束了");
            }
        }).start();
    }

    public void test() {
        new MethodTest().getCaller();
    }

    public static class Follow1Thread extends Thread {
        private boolean isStart = false;
        private long startTime;
        private long time;
        private OnUpdateListener updateListener;

        public Follow1Thread(long j, OnUpdateListener onUpdateListener) {
            this.time = j;
            this.updateListener = onUpdateListener;
        }

        @Override // java.lang.Thread
        public void start() {
            super.start();
            this.isStart = true;
        }

        public void end() {
            this.isStart = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long currentTimeMillis;
            this.startTime = System.currentTimeMillis();
            while (this.isStart) {
                try {
                    System.out.println(TtmlNode.START);
                    Thread.sleep(300L);
                    currentTimeMillis = ((System.currentTimeMillis() - this.startTime) * 100) / this.time;
                    OnUpdateListener onUpdateListener = this.updateListener;
                    if (onUpdateListener != null) {
                        onUpdateListener.onPercent(currentTimeMillis);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (currentTimeMillis >= 100) {
                    return;
                }
            }
        }
    }

    private static boolean isFrameUseful(byte[] bArr) {
        return ParseUtil.getCheckCode(bArr, 2, bArr.length - 2) == bArr[bArr.length - 1];
    }

    private static void test1() {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        for (int i = 0; i < 1000; i++) {
            copyOnWriteArraySet.add(new byte[1024]);
        }
        for (int i2 = 0; i2 < 5; i2++) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                try {
                    int length = ((byte[]) it.next()).length;
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("set耗时:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private static void test2() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(new byte[1024]);
        }
        for (int i2 = 0; i2 < 5; i2++) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    int length = ((byte[]) it.next()).length;
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("list耗时:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private static void test3() {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 1000; i++) {
            linkedList.add(new byte[1024]);
        }
        for (int i2 = 0; i2 < 5; i2++) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                try {
                    int length = ((byte[]) it.next()).length;
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("linked耗时:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private static void test4() {
        Stack stack = new Stack();
        for (int i = 0; i < 1000; i++) {
            stack.add(new byte[1024]);
        }
        for (int i2 = 0; i2 < 5; i2++) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = stack.iterator();
            while (it.hasNext()) {
                try {
                    int length = ((byte[]) it.next()).length;
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("linked耗时:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public static List<Integer> runTestRunnable() throws Exception {
        ArrayList<Future> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < 10; i++) {
        }
        for (Future future : arrayList) {
            while (!future.isDone()) {
                System.out.println("执行结果=" + future.isDone());
                Thread.sleep(1L);
                System.out.println("执行结果=" + future.isDone());
            }
            arrayList2.add((Integer) future.get());
        }
        return arrayList2;
    }

    public static class testRunnable implements Callable<Integer> {

        /* renamed from: i */
        private int f2676i;

        public testRunnable(int i) {
            this.f2676i = i;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            System.out.println("执行" + this.f2676i);
            System.out.println("执行完成" + this.f2676i);
            return Integer.valueOf(this.f2676i);
        }
    }

    public static class cancelRunnable implements Runnable {
        ScheduledFuture future;

        public void setFuture(ScheduledFuture scheduledFuture) {
            this.future = scheduledFuture;
        }

        public ScheduledFuture getFuture() {
            return this.future;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (JavaTest.num == 105) {
                this.future.cancel(true);
            }
            PrintStream printStream = System.out;
            int i = JavaTest.num;
            JavaTest.num = i + 1;
            printStream.println(i);
        }
    }

    public static class TestRunnable implements Runnable {
        public int tag;

        public TestRunnable(int i) {
            this.tag = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.tag);
        }
    }

    private static List<byte[]> getFrames(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        int i = -1;
        for (int i2 = 0; i2 < bArr.length - 5; i2++) {
            if (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 0 && bArr[i2 + 3] == 1) {
                if (i != -1) {
                    int i3 = i2 - i;
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(bArr, i, bArr2, 0, i3);
                    arrayList.add(bArr2);
                }
                i = i2;
            }
        }
        if (i == -1) {
            arrayList.add(bArr);
        } else {
            int length = bArr.length - i;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, i, bArr3, 0, length);
            arrayList.add(bArr3);
        }
        return arrayList;
    }

    public static byte[] float2byte(float f) {
        int floatToIntBits = Float.floatToIntBits(f);
        byte[] bArr = new byte[4];
        for (int i = 0; i < 4; i++) {
            bArr[i] = (byte) (floatToIntBits >> (24 - (i * 8)));
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        for (int i2 = 0; i2 < 2; i2++) {
            byte b = bArr2[i2];
            int i3 = (4 - i2) - 1;
            bArr2[i2] = bArr2[i3];
            bArr2[i3] = b;
        }
        return bArr2;
    }

    public static class Test implements Cloneable {

        /* renamed from: is */
        public boolean f2675is;

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Test m2626clone() throws CloneNotSupportedException {
            return (Test) super.clone();
        }
    }

    public static byte[] getRandomBytes() {
        int i = dataSize;
        dataSize = i + 1;
        byte[] bArr = new byte[i];
        new Random().nextBytes(bArr);
        return bArr;
    }

    public static void main(String[] strArr) {
        byte[] hexStringToByte = ParseUtil.hexStringToByte("fffe fe01 0c00 ce3ada21000000007800000068007e5ebf3ec3e93f3ff6611dc128ed9c3b363c513beb00aabc 7210 0000170b0203090912864110e3698e2d0a1044000000803f0000a040000020415424c4474b109c9025c6d26fe7c65cf72047000060404260653c295c8f3d6f12833b4260653c846300000000000000000000000000000000000000000000000000000000000000000000000000082003ffffa33a770d152cf14326969cbdcaa9093d1a0f1c409c4a09bbf437a23a0ef28cbb0000000000000000000000000000000000000000000000000000000000000000a723883f00000000000080bfcddf43bfe58d523ea72388bf28417c39e23f74b9114072bb61e8fb3c1ae88e3c004d82bd7db8aa387b05323b000080bfe1312a3da8a52f3b000000000001010000010000037155b4b403f4e3b603b603b603b603000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003e9a9cbd91b4093de00e1c406c5e0b2ed8ed4b2e08d4e1ad76bc1a3b0000000000d09d450000000000000000004d823d000000000000000000000000000102000008000000000100010101000101010101000100000000d20fd40f52fd2200708002562a00000000020d715a41bc0300000000504600020000000000000000000094");
        System.out.println(ParseUtil.byteToHexString(new byte[]{hexStringToByte[44]}));
        System.out.println(ParseUtil.byteToHexString(new byte[]{hexStringToByte[45]}));
    }
}