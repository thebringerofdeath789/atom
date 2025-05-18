package com.ipotensic.potensicpro.activities;

import com.ipotensic.potensicpro.activities.InstructionActivity;
import com.ipotensic.potensicpro.view.PDFDownloadProgressView;
import com.logan.user.model.rev.RevUserGetPdfResult;

/* compiled from: lambda */
/* renamed from: com.ipotensic.potensicpro.activities.-$$Lambda$InstructionActivity$2$1$CT-DSy2QNdsQ5gqiBjAqROV9uTU */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$InstructionActivity$2$1$CTDSy2QNdsQ5gqiBjAqROV9uTU implements Runnable {
    public final /* synthetic */ PDFDownloadProgressView f$1;
    public final /* synthetic */ RevUserGetPdfResult.Document f$2;

    public /* synthetic */ $$Lambda$InstructionActivity$2$1$CTDSy2QNdsQ5gqiBjAqROV9uTU(PDFDownloadProgressView pDFDownloadProgressView, RevUserGetPdfResult.Document document) {
        pDFDownloadProgressView = pDFDownloadProgressView;
        document = document;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InstructionActivity.AnonymousClass2.AnonymousClass1.this.lambda$onDownloadError$2$InstructionActivity$2$1(pDFDownloadProgressView, document);
    }
}