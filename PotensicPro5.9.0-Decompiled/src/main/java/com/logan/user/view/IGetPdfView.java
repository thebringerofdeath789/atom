package com.logan.user.view;

import com.logan.user.model.rev.RevUserGetPdfResult;
import java.util.List;

/* loaded from: classes3.dex */
public interface IGetPdfView {
    void onGetPdfFailed(String str);

    void onGetPdfSuccess(List<RevUserGetPdfResult.Document> list);

    void onProductNotFind();

    void onTokenError();
}
