package com.ipotensic.potensicpro.models;

import com.logan.user.model.rev.RevUserAppVersionData;
import com.logan.user.view.IVersionView;
import javax.xml.transform.OutputKeys;
import kotlin.Metadata;

/* compiled from: MainViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"com/ipotensic/potensicpro/models/MainViewModel$checkAppVersionUpdate$1", "Lcom/logan/user/view/IVersionView;", "getInfoError", "", "needToUpdate", OutputKeys.VERSION, "Lcom/logan/user/model/rev/RevUserAppVersionData$Version;", "app__GooglePalyRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class MainViewModel$checkAppVersionUpdate$1 implements IVersionView {
    MainViewModel$checkAppVersionUpdate$1() {
    }

    @Override // com.logan.user.view.IVersionView
    public void needToUpdate(RevUserAppVersionData.Version r2) {
        if (r2 != null) {
            if (r2.getEnable() == 0) {
                MainViewModel.this.getVersionData().setValue(r2);
            } else {
                MainViewModel.this.getUpdateFinishData().setValue(true);
            }
        }
    }

    @Override // com.logan.user.view.IVersionView
    public void getInfoError() {
        MainViewModel.this.getUpdateFinishData().setValue(true);
    }
}