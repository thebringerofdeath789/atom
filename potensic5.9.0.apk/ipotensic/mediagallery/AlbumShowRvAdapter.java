package com.ipotensic.mediagallery;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFile;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.enums.FileTypeEnum;
import com.ipotensic.baselib.listener.CustomClickListener;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.utils.DateUtils;
import com.ipotensic.baselib.utils.MediaFileUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public class AlbumShowRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private boolean isPicture;
    private BaseActivity resultActivity;
    private List<LocalFile> items = new ArrayList();
    private boolean isSelectMode = false;
    private final int HEAD_TYPE = 0;
    private final int BODY_TYPE = 1;
    private OnRecyclerViewItemClickListener itemClickListener = null;

    public interface OnRecyclerViewItemClickListener {
        void isHasItemSelected(List<LocalFile> list);

        void onItemClick(LocalFile localFile, int i);

        void onItemLongClick(int i);
    }

    public AlbumShowRvAdapter(BaseActivity baseActivity) {
        this.resultActivity = baseActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (i < this.items.size() && this.items.get(i).getFileTypeEnum() != FileTypeEnum.TYPE_HEAD) ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new HeadViewHolder(LayoutInflater.from(this.resultActivity).inflate(R.layout.layout_rv_calendar_timeaxis_item_head, (ViewGroup) null));
        }
        if (i == 1) {
            return new BodyViewHolder(LayoutInflater.from(this.resultActivity).inflate(R.layout.layout_rv_media_view_item, (ViewGroup) null));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        LocalFile localFile;
        try {
            if (i < this.items.size() && (localFile = this.items.get(i)) != null) {
                if (!(viewHolder instanceof BodyViewHolder)) {
                    if (viewHolder instanceof HeadViewHolder) {
                        DDLog.w("item notify:" + i + "," + DateUtils.getSdfTime(localFile.getCreateTime() + "", DateUtils.YMDHMS2));
                        ((HeadViewHolder) viewHolder).mTvTitle.setText(DateUtils.getSdfTime(localFile.getCreateTime() + "", DateUtils.YMDHMS2));
                        return;
                    }
                    return;
                }
                Glide.with((FragmentActivity) this.resultActivity).load(Uri.parse("file://" + localFile.getAbsPath())).into(((BodyViewHolder) viewHolder).imgThumbnail);
                BodyViewHolder bodyViewHolder = (BodyViewHolder) viewHolder;
                if (localFile.getFileTypeEnum() == FileTypeEnum.TYPE_VIDEO) {
                    bodyViewHolder.videoDuration.setVisibility(0);
                    bodyViewHolder.videoDuration.setText(localFile.getDurationFormatStr());
                    this.isPicture = false;
                } else {
                    bodyViewHolder.videoDuration.setVisibility(8);
                    this.isPicture = true;
                }
                boolean isSelect = localFile.isSelect();
                bodyViewHolder.imgSelect.setVisibility(isSelect ? 0 : 8);
                bodyViewHolder.imgThumbnail.setAlpha(isSelect ? 0.5f : 1.0f);
                bodyViewHolder.itemView.setOnTouchListener(new CustomClickListener() { // from class: com.ipotensic.mediagallery.AlbumShowRvAdapter.1
                    final /* synthetic */ LocalFile val$file;
                    final /* synthetic */ int val$position;

                    AnonymousClass1(int i2, LocalFile localFile2) {
                        r2 = i2;
                        r3 = localFile2;
                    }

                    @Override // com.ipotensic.baselib.listener.CustomClickListener
                    public void onLongClicked() {
                        if (AlbumShowRvAdapter.this.isSelectMode || AlbumShowRvAdapter.this.itemClickListener == null) {
                            return;
                        }
                        AlbumShowRvAdapter.this.itemClickListener.onItemLongClick(r2);
                        AlbumShowRvAdapter.this.itemClickListener.isHasItemSelected(AlbumShowRvAdapter.this.items);
                    }

                    @Override // com.ipotensic.baselib.listener.CustomClickListener
                    public void onShortClicked() {
                        if (AlbumShowRvAdapter.this.isSelectMode) {
                            ((LocalFile) AlbumShowRvAdapter.this.items.get(r2)).setSelect(!r3.isSelect());
                            AlbumShowRvAdapter.this.notifyItemChanged(r2);
                            AlbumShowRvAdapter.this.itemClickListener.isHasItemSelected(AlbumShowRvAdapter.this.items);
                        } else if (AlbumShowRvAdapter.this.itemClickListener != null) {
                            AlbumShowRvAdapter.this.itemClickListener.onItemClick(r3, r2);
                        }
                    }
                });
            }
        } catch (Exception e) {
            DDLog.e("\u672c\u5730\u56fe\u5e93\u52a0\u8f7d\u62a5\u9519\uff1a" + e);
        }
    }

    /* renamed from: com.ipotensic.mediagallery.AlbumShowRvAdapter$1 */
    class AnonymousClass1 extends CustomClickListener {
        final /* synthetic */ LocalFile val$file;
        final /* synthetic */ int val$position;

        AnonymousClass1(int i2, LocalFile localFile2) {
            r2 = i2;
            r3 = localFile2;
        }

        @Override // com.ipotensic.baselib.listener.CustomClickListener
        public void onLongClicked() {
            if (AlbumShowRvAdapter.this.isSelectMode || AlbumShowRvAdapter.this.itemClickListener == null) {
                return;
            }
            AlbumShowRvAdapter.this.itemClickListener.onItemLongClick(r2);
            AlbumShowRvAdapter.this.itemClickListener.isHasItemSelected(AlbumShowRvAdapter.this.items);
        }

        @Override // com.ipotensic.baselib.listener.CustomClickListener
        public void onShortClicked() {
            if (AlbumShowRvAdapter.this.isSelectMode) {
                ((LocalFile) AlbumShowRvAdapter.this.items.get(r2)).setSelect(!r3.isSelect());
                AlbumShowRvAdapter.this.notifyItemChanged(r2);
                AlbumShowRvAdapter.this.itemClickListener.isHasItemSelected(AlbumShowRvAdapter.this.items);
            } else if (AlbumShowRvAdapter.this.itemClickListener != null) {
                AlbumShowRvAdapter.this.itemClickListener.onItemClick(r3, r2);
            }
        }
    }

    public void updateAdapterList(List<LocalFile> list) {
        DDLog.e("update list");
        if (list != null) {
            this.items = list;
            notifyDataSetChanged();
        }
    }

    public boolean isSelectMode() {
        return this.isSelectMode;
    }

    public void setSelectMode(boolean z) {
        this.isSelectMode = z;
        if (z) {
            return;
        }
        for (int i = 0; i < this.items.size(); i++) {
            LocalFile localFile = this.items.get(i);
            if (localFile.isSelect()) {
                localFile.setSelect(false);
                notifyItemChanged(i);
            }
        }
    }

    public boolean hasPicSelected() {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).isSelect()) {
                return true;
            }
        }
        return false;
    }

    public void setItemSelected(int i) {
        this.items.get(i).setSelect(true);
        notifyItemChanged(i);
    }

    public List<LocalFile> getListFiles() {
        return this.items;
    }

    public boolean isPictureMode() {
        return this.isPicture;
    }

    public synchronized void deleteSelectedForAndroid11(MediaFileUtils.OnDeleteResultListener onDeleteResultListener) {
        ArrayList arrayList = new ArrayList();
        for (LocalFile localFile : this.items) {
            if (localFile.isSelect()) {
                arrayList.add(localFile);
            }
        }
        if (arrayList.size() != 0) {
            PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.mediagallery.AlbumShowRvAdapter.2
                final /* synthetic */ MediaFileUtils.OnDeleteResultListener val$deleteResultListener;
                final /* synthetic */ ArrayList val$needDeleteFiles;

                AnonymousClass2(ArrayList arrayList2, MediaFileUtils.OnDeleteResultListener onDeleteResultListener2) {
                    r2 = arrayList2;
                    r3 = onDeleteResultListener2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    DDLog.e("\u5f00\u59cb\u5220\u9664...");
                    LocalFileManager.getInstance().deleteFiles(AlbumShowRvAdapter.this.resultActivity, r2, r3);
                }
            });
        } else if (onDeleteResultListener2 != null) {
            onDeleteResultListener2.onResult(false);
        }
    }

    /* renamed from: com.ipotensic.mediagallery.AlbumShowRvAdapter$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ MediaFileUtils.OnDeleteResultListener val$deleteResultListener;
        final /* synthetic */ ArrayList val$needDeleteFiles;

        AnonymousClass2(ArrayList arrayList2, MediaFileUtils.OnDeleteResultListener onDeleteResultListener2) {
            r2 = arrayList2;
            r3 = onDeleteResultListener2;
        }

        @Override // java.lang.Runnable
        public void run() {
            DDLog.e("\u5f00\u59cb\u5220\u9664...");
            LocalFileManager.getInstance().deleteFiles(AlbumShowRvAdapter.this.resultActivity, r2, r3);
        }
    }

    /* renamed from: com.ipotensic.mediagallery.AlbumShowRvAdapter$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ SimpleResultListener val$resultListener;
        final /* synthetic */ boolean val$withDeleteFile;

        AnonymousClass3(boolean z, SimpleResultListener simpleResultListener) {
            r2 = z;
            r3 = simpleResultListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            SimpleResultListener simpleResultListener;
            try {
                try {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = AlbumShowRvAdapter.this.items.iterator();
                    AtomicLong atomicLong = new AtomicLong();
                    while (it.hasNext()) {
                        LocalFile localFile = (LocalFile) it.next();
                        if (localFile.getFileTypeEnum() == FileTypeEnum.TYPE_HEAD) {
                            atomicLong.set(localFile.getCreateTime());
                        }
                        if (localFile.isSelect()) {
                            arrayList.add(Long.valueOf(atomicLong.get()));
                            arrayList2.add(localFile);
                            if (r2) {
                                if (LocalFileManager.getInstance().deleteFile(localFile)) {
                                    int indexOf = AlbumShowRvAdapter.this.items.indexOf(localFile);
                                    it.remove();
                                    PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.mediagallery.AlbumShowRvAdapter.3.1
                                        final /* synthetic */ int val$position;

                                        AnonymousClass1(int indexOf2) {
                                            r2 = indexOf2;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            AlbumShowRvAdapter.this.notifyItemRemoved(r2);
                                        }
                                    });
                                }
                            } else {
                                DDLog.e("\u5220\u9664\u6587\u4ef6\uff1a" + localFile.getAbsPath());
                                int indexOf2 = AlbumShowRvAdapter.this.items.indexOf(localFile);
                                it.remove();
                                PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.mediagallery.AlbumShowRvAdapter.3.2
                                    final /* synthetic */ int val$position;

                                    AnonymousClass2(int indexOf22) {
                                        r2 = indexOf22;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AlbumShowRvAdapter.this.notifyItemRemoved(r2);
                                    }
                                });
                            }
                        }
                    }
                    Iterator it2 = AlbumShowRvAdapter.this.items.iterator();
                    while (it2.hasNext()) {
                        LocalFile localFile2 = (LocalFile) it2.next();
                        if (localFile2.getFileTypeEnum() == FileTypeEnum.TYPE_HEAD) {
                            int indexOf3 = AlbumShowRvAdapter.this.items.indexOf(localFile2);
                            if (indexOf3 != AlbumShowRvAdapter.this.items.size() - 1) {
                                int i = indexOf3 + 1;
                                if (i <= AlbumShowRvAdapter.this.items.size() - 1 && ((LocalFile) AlbumShowRvAdapter.this.items.get(i)).getFileTypeEnum() == FileTypeEnum.TYPE_HEAD) {
                                    it2.remove();
                                    DDLog.e("\u5220\u9664head\uff1a");
                                    PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.mediagallery.AlbumShowRvAdapter.3.4
                                        final /* synthetic */ int val$position;

                                        AnonymousClass4(int indexOf32) {
                                            r2 = indexOf32;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            AlbumShowRvAdapter.this.notifyItemRemoved(r2);
                                        }
                                    });
                                }
                            } else {
                                it2.remove();
                                PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.mediagallery.AlbumShowRvAdapter.3.3
                                    final /* synthetic */ int val$position;

                                    RunnableC00823(int indexOf32) {
                                        r2 = indexOf32;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AlbumShowRvAdapter.this.notifyItemRemoved(r2);
                                    }
                                });
                            }
                        }
                    }
                    try {
                        LocalFileManager.getInstance().sortChildNum(arrayList);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.mediagallery.AlbumShowRvAdapter.3.5
                        final /* synthetic */ List val$deleteFiles;

                        AnonymousClass5(List arrayList22) {
                            r2 = arrayList22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Iterator<LocalFile> it3 = LocalFileManager.getInstance().getVideoListNoHead().iterator();
                            while (it3.hasNext()) {
                                LocalFile next = it3.next();
                                for (int i2 = 0; i2 < r2.size(); i2++) {
                                    if (next.getAbsPath().equals(((LocalFile) r2.get(i2)).getAbsPath())) {
                                        it3.remove();
                                    }
                                }
                            }
                        }
                    });
                    simpleResultListener = r3;
                    if (simpleResultListener == null) {
                        return;
                    }
                } catch (Exception e2) {
                    DDLog.e("\u5220\u9664\u51fa\u9519 \uff1a" + e2);
                    simpleResultListener = r3;
                    if (simpleResultListener == null) {
                        return;
                    }
                }
                simpleResultListener.onResult(true);
            } catch (Throwable th) {
                SimpleResultListener simpleResultListener2 = r3;
                if (simpleResultListener2 != null) {
                    simpleResultListener2.onResult(true);
                }
                throw th;
            }
        }

        /* renamed from: com.ipotensic.mediagallery.AlbumShowRvAdapter$3$1 */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ int val$position;

            AnonymousClass1(int indexOf2) {
                r2 = indexOf2;
            }

            @Override // java.lang.Runnable
            public void run() {
                AlbumShowRvAdapter.this.notifyItemRemoved(r2);
            }
        }

        /* renamed from: com.ipotensic.mediagallery.AlbumShowRvAdapter$3$2 */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ int val$position;

            AnonymousClass2(int indexOf22) {
                r2 = indexOf22;
            }

            @Override // java.lang.Runnable
            public void run() {
                AlbumShowRvAdapter.this.notifyItemRemoved(r2);
            }
        }

        /* renamed from: com.ipotensic.mediagallery.AlbumShowRvAdapter$3$3 */
        class RunnableC00823 implements Runnable {
            final /* synthetic */ int val$position;

            RunnableC00823(int indexOf32) {
                r2 = indexOf32;
            }

            @Override // java.lang.Runnable
            public void run() {
                AlbumShowRvAdapter.this.notifyItemRemoved(r2);
            }
        }

        /* renamed from: com.ipotensic.mediagallery.AlbumShowRvAdapter$3$4 */
        class AnonymousClass4 implements Runnable {
            final /* synthetic */ int val$position;

            AnonymousClass4(int indexOf32) {
                r2 = indexOf32;
            }

            @Override // java.lang.Runnable
            public void run() {
                AlbumShowRvAdapter.this.notifyItemRemoved(r2);
            }
        }

        /* renamed from: com.ipotensic.mediagallery.AlbumShowRvAdapter$3$5 */
        class AnonymousClass5 implements Runnable {
            final /* synthetic */ List val$deleteFiles;

            AnonymousClass5(List arrayList22) {
                r2 = arrayList22;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<LocalFile> it3 = LocalFileManager.getInstance().getVideoListNoHead().iterator();
                while (it3.hasNext()) {
                    LocalFile next = it3.next();
                    for (int i2 = 0; i2 < r2.size(); i2++) {
                        if (next.getAbsPath().equals(((LocalFile) r2.get(i2)).getAbsPath())) {
                            it3.remove();
                        }
                    }
                }
            }
        }
    }

    public synchronized void deleteSelected(boolean z, SimpleResultListener<Boolean> simpleResultListener) {
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.mediagallery.AlbumShowRvAdapter.3
            final /* synthetic */ SimpleResultListener val$resultListener;
            final /* synthetic */ boolean val$withDeleteFile;

            AnonymousClass3(boolean z2, SimpleResultListener simpleResultListener2) {
                r2 = z2;
                r3 = simpleResultListener2;
            }

            @Override // java.lang.Runnable
            public void run() {
                SimpleResultListener simpleResultListener2;
                try {
                    try {
                        ArrayList arrayList = new ArrayList();
                        List arrayList22 = new ArrayList();
                        Iterator it = AlbumShowRvAdapter.this.items.iterator();
                        AtomicLong atomicLong = new AtomicLong();
                        while (it.hasNext()) {
                            LocalFile localFile = (LocalFile) it.next();
                            if (localFile.getFileTypeEnum() == FileTypeEnum.TYPE_HEAD) {
                                atomicLong.set(localFile.getCreateTime());
                            }
                            if (localFile.isSelect()) {
                                arrayList.add(Long.valueOf(atomicLong.get()));
                                arrayList22.add(localFile);
                                if (r2) {
                                    if (LocalFileManager.getInstance().deleteFile(localFile)) {
                                        int indexOf2 = AlbumShowRvAdapter.this.items.indexOf(localFile);
                                        it.remove();
                                        PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.mediagallery.AlbumShowRvAdapter.3.1
                                            final /* synthetic */ int val$position;

                                            AnonymousClass1(int indexOf22) {
                                                r2 = indexOf22;
                                            }

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                AlbumShowRvAdapter.this.notifyItemRemoved(r2);
                                            }
                                        });
                                    }
                                } else {
                                    DDLog.e("\u5220\u9664\u6587\u4ef6\uff1a" + localFile.getAbsPath());
                                    int indexOf22 = AlbumShowRvAdapter.this.items.indexOf(localFile);
                                    it.remove();
                                    PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.mediagallery.AlbumShowRvAdapter.3.2
                                        final /* synthetic */ int val$position;

                                        AnonymousClass2(int indexOf222) {
                                            r2 = indexOf222;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            AlbumShowRvAdapter.this.notifyItemRemoved(r2);
                                        }
                                    });
                                }
                            }
                        }
                        Iterator it2 = AlbumShowRvAdapter.this.items.iterator();
                        while (it2.hasNext()) {
                            LocalFile localFile2 = (LocalFile) it2.next();
                            if (localFile2.getFileTypeEnum() == FileTypeEnum.TYPE_HEAD) {
                                int indexOf32 = AlbumShowRvAdapter.this.items.indexOf(localFile2);
                                if (indexOf32 != AlbumShowRvAdapter.this.items.size() - 1) {
                                    int i = indexOf32 + 1;
                                    if (i <= AlbumShowRvAdapter.this.items.size() - 1 && ((LocalFile) AlbumShowRvAdapter.this.items.get(i)).getFileTypeEnum() == FileTypeEnum.TYPE_HEAD) {
                                        it2.remove();
                                        DDLog.e("\u5220\u9664head\uff1a");
                                        PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.mediagallery.AlbumShowRvAdapter.3.4
                                            final /* synthetic */ int val$position;

                                            AnonymousClass4(int indexOf322) {
                                                r2 = indexOf322;
                                            }

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                AlbumShowRvAdapter.this.notifyItemRemoved(r2);
                                            }
                                        });
                                    }
                                } else {
                                    it2.remove();
                                    PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.mediagallery.AlbumShowRvAdapter.3.3
                                        final /* synthetic */ int val$position;

                                        RunnableC00823(int indexOf322) {
                                            r2 = indexOf322;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            AlbumShowRvAdapter.this.notifyItemRemoved(r2);
                                        }
                                    });
                                }
                            }
                        }
                        try {
                            LocalFileManager.getInstance().sortChildNum(arrayList);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.mediagallery.AlbumShowRvAdapter.3.5
                            final /* synthetic */ List val$deleteFiles;

                            AnonymousClass5(List arrayList222) {
                                r2 = arrayList222;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Iterator<LocalFile> it3 = LocalFileManager.getInstance().getVideoListNoHead().iterator();
                                while (it3.hasNext()) {
                                    LocalFile next = it3.next();
                                    for (int i2 = 0; i2 < r2.size(); i2++) {
                                        if (next.getAbsPath().equals(((LocalFile) r2.get(i2)).getAbsPath())) {
                                            it3.remove();
                                        }
                                    }
                                }
                            }
                        });
                        simpleResultListener2 = r3;
                        if (simpleResultListener2 == null) {
                            return;
                        }
                    } catch (Exception e2) {
                        DDLog.e("\u5220\u9664\u51fa\u9519 \uff1a" + e2);
                        simpleResultListener2 = r3;
                        if (simpleResultListener2 == null) {
                            return;
                        }
                    }
                    simpleResultListener2.onResult(true);
                } catch (Throwable th) {
                    SimpleResultListener simpleResultListener22 = r3;
                    if (simpleResultListener22 != null) {
                        simpleResultListener22.onResult(true);
                    }
                    throw th;
                }
            }

            /* renamed from: com.ipotensic.mediagallery.AlbumShowRvAdapter$3$1 */
            class AnonymousClass1 implements Runnable {
                final /* synthetic */ int val$position;

                AnonymousClass1(int indexOf22) {
                    r2 = indexOf22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AlbumShowRvAdapter.this.notifyItemRemoved(r2);
                }
            }

            /* renamed from: com.ipotensic.mediagallery.AlbumShowRvAdapter$3$2 */
            class AnonymousClass2 implements Runnable {
                final /* synthetic */ int val$position;

                AnonymousClass2(int indexOf222) {
                    r2 = indexOf222;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AlbumShowRvAdapter.this.notifyItemRemoved(r2);
                }
            }

            /* renamed from: com.ipotensic.mediagallery.AlbumShowRvAdapter$3$3 */
            class RunnableC00823 implements Runnable {
                final /* synthetic */ int val$position;

                RunnableC00823(int indexOf322) {
                    r2 = indexOf322;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AlbumShowRvAdapter.this.notifyItemRemoved(r2);
                }
            }

            /* renamed from: com.ipotensic.mediagallery.AlbumShowRvAdapter$3$4 */
            class AnonymousClass4 implements Runnable {
                final /* synthetic */ int val$position;

                AnonymousClass4(int indexOf322) {
                    r2 = indexOf322;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AlbumShowRvAdapter.this.notifyItemRemoved(r2);
                }
            }

            /* renamed from: com.ipotensic.mediagallery.AlbumShowRvAdapter$3$5 */
            class AnonymousClass5 implements Runnable {
                final /* synthetic */ List val$deleteFiles;

                AnonymousClass5(List arrayList222) {
                    r2 = arrayList222;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Iterator<LocalFile> it3 = LocalFileManager.getInstance().getVideoListNoHead().iterator();
                    while (it3.hasNext()) {
                        LocalFile next = it3.next();
                        for (int i2 = 0; i2 < r2.size(); i2++) {
                            if (next.getAbsPath().equals(((LocalFile) r2.get(i2)).getAbsPath())) {
                                it3.remove();
                            }
                        }
                    }
                }
            }
        });
    }

    public int getCurrentTimeItemCount(int i) {
        return this.items.get(i).getChildNum();
    }

    public List<LocalFile> getAllData() {
        return this.items;
    }

    public class BodyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgSelect;
        private ImageView imgThumbnail;
        private TextView videoDuration;

        public BodyViewHolder(View view) {
            super(view);
            this.imgThumbnail = (ImageView) view.findViewById(R.id.iv_photo);
            this.videoDuration = (TextView) view.findViewById(R.id.tv_video_time);
            this.imgSelect = (ImageView) view.findViewById(R.id.img_select);
        }
    }

    public class HeadViewHolder extends RecyclerView.ViewHolder {
        public TextView mTvTitle;

        public HeadViewHolder(View view) {
            super(view);
            this.mTvTitle = (TextView) view.findViewById(R.id.tv_code_title);
        }
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        this.itemClickListener = onRecyclerViewItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }
}