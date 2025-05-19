package com.logan.user.view;

import com.logan.user.model.rev.RevUserGetTeachVideoResult;
import java.util.List;

/* loaded from: classes3.dex */
public interface IGetTeachVideoView {
    void onGetTeachVideoFailed(String str);

    void onGetTeachVideoSuccess(List<RevUserGetTeachVideoResult.Document> list);

    void onProductNotFind();

    void onTokenError();
}
