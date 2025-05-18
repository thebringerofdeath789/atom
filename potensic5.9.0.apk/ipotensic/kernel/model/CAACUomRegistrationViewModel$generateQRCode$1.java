package com.ipotensic.kernel.model;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.core.view.ViewCompat;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.ipotensic.baselib.listener.SimpleResultListener;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: CAACUomRegistrationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "com.ipotensic.kernel.model.CAACUomRegistrationViewModel$generateQRCode$1", f = "CAACUomRegistrationViewModel.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {66}, m = "invokeSuspend", n = {"$this$launch", "qrCodeWriter", "hints", "bitMatrix", "width", "height", "bmp", "output", "canvas", "paint", "rectF"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$4", "L$5", "L$6", "L$7", "L$8"})
/* loaded from: classes2.dex */
final class CAACUomRegistrationViewModel$generateQRCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ SimpleResultListener $resultListener;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    private CoroutineScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CAACUomRegistrationViewModel$generateQRCode$1(String str, SimpleResultListener simpleResultListener, Continuation continuation) {
        super(2, continuation);
        this.$content = str;
        this.$resultListener = simpleResultListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        CAACUomRegistrationViewModel$generateQRCode$1 cAACUomRegistrationViewModel$generateQRCode$1 = new CAACUomRegistrationViewModel$generateQRCode$1(this.$content, this.$resultListener, completion);
        cAACUomRegistrationViewModel$generateQRCode$1.p$ = (CoroutineScope) obj;
        return cAACUomRegistrationViewModel$generateQRCode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CAACUomRegistrationViewModel$generateQRCode$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            QRCodeWriter qRCodeWriter = new QRCodeWriter();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = hashMap;
            hashMap2.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            hashMap2.put(EncodeHintType.MARGIN, boxing.boxInt(1));
            BitMatrix bitMatrix = qRCodeWriter.encode(this.$content, BarcodeFormat.QR_CODE, 300, 300, hashMap2);
            Intrinsics.checkExpressionValueIsNotNull(bitMatrix, "bitMatrix");
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            for (int i2 = 0; i2 < width; i2++) {
                for (int i3 = 0; i3 < height; i3++) {
                    bmp.setPixel(i2, i3, bitMatrix.get(i2, i3) ? ViewCompat.MEASURED_STATE_MASK : -1);
                }
            }
            Intrinsics.checkExpressionValueIsNotNull(bmp, "bmp");
            Bitmap createBitmap = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setShader(new BitmapShader(bmp, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            RectF rectF = new RectF(0.0f, 0.0f, bmp.getWidth(), bmp.getHeight());
            canvas.drawRoundRect(rectF, 20.0f, 20.0f, paint);
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(createBitmap, null);
            this.L$0 = coroutineScope;
            this.L$1 = qRCodeWriter;
            this.L$2 = hashMap;
            this.L$3 = bitMatrix;
            this.I$0 = width;
            this.I$1 = height;
            this.L$4 = bmp;
            this.L$5 = createBitmap;
            this.L$6 = canvas;
            this.L$7 = paint;
            this.L$8 = rectF;
            this.label = 1;
            if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* compiled from: CAACUomRegistrationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
    @DebugMetadata(c = "com.ipotensic.kernel.model.CAACUomRegistrationViewModel$generateQRCode$1$1", f = "CAACUomRegistrationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.ipotensic.kernel.model.CAACUomRegistrationViewModel$generateQRCode$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $output;
        int label;
        private CoroutineScope p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Bitmap bitmap, Continuation continuation) {
            super(2, continuation);
            this.$output = bitmap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkParameterIsNotNull(completion, "completion");
            AnonymousClass1 anonymousClass1 = CAACUomRegistrationViewModel$generateQRCode$1.this.new AnonymousClass1(this.$output, completion);
            anonymousClass1.p$ = (CoroutineScope) obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CAACUomRegistrationViewModel$generateQRCode$1.this.$resultListener.onResult(this.$output);
            return Unit.INSTANCE;
        }
    }
}