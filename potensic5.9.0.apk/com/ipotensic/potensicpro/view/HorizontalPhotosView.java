package com.ipotensic.potensicpro.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.potensicpro.C2640R;
import com.ipotensic.potensicpro.utils.PhotoChooserUtil;
import com.ipotensic.potensicpro.view.dialog.TakePhotoDialog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class HorizontalPhotosView extends RecyclerView implements PhotoChooserUtil.OnChooseListener {
    private Activity activity;
    private int currentIndex;
    private HashMap<Integer, PicAndVideoBean> deleteMap;
    private int imageWidth;
    private GridLayoutManager layoutManager;
    private HashMap<Integer, PicAndVideoBean> map;
    private MyAdapter myAdapter;
    private PhotoChooserUtil photoChooserUtil;
    private OnPhotoSelectedListener photoSelectedListener;
    private int picNum;
    private String videoPath;

    public interface OnPhotoSelectedListener {
        void onSelectedPicNum(int i);
    }

    @Override // com.ipotensic.potensicpro.utils.PhotoChooserUtil.OnChooseListener
    public void onChooseCropResult(Bitmap bitmap) {
    }

    @Override // com.ipotensic.potensicpro.utils.PhotoChooserUtil.OnChooseListener
    public void onChooseImage(String str) {
    }

    public static class PicAndVideoBean {
        private boolean isVideo;
        private String path;

        public PicAndVideoBean(String str, boolean z) {
            this.isVideo = z;
            this.path = str;
        }

        public boolean isVideo() {
            return this.isVideo;
        }

        public void setVideo(boolean z) {
            this.isVideo = z;
        }

        public String getPath() {
            return this.path;
        }

        public void setPath(String str) {
            this.path = str;
        }

        public String toString() {
            return "PicAndVideoBean{isVideo=" + this.isVideo + ", path='" + this.path + "'}";
        }
    }

    public HorizontalPhotosView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentIndex = 0;
        this.picNum = 0;
    }

    public void bindActivity(AppCompatActivity appCompatActivity) {
        this.activity = appCompatActivity;
        this.photoChooserUtil = new PhotoChooserUtil(appCompatActivity, this);
    }

    public String getVideoPath() {
        return this.videoPath;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.imageWidth == 0) {
            int measuredWidth = getMeasuredWidth() / 3;
            this.imageWidth = measuredWidth;
            if (measuredWidth > ScreenUtils.dp2px(getContext(), 116.0f)) {
                this.imageWidth = ScreenUtils.dp2px(getContext(), 116.0f);
            }
            post(new Runnable() { // from class: com.ipotensic.potensicpro.view.-$$Lambda$HorizontalPhotosView$rQ3mYbH3-EYKIs1o2X8eArIsjmI
                @Override // java.lang.Runnable
                public final void run() {
                    HorizontalPhotosView.this.setMyAdapter();
                }
            });
        }
    }

    private void init() {
        this.map = new HashMap<>();
        this.deleteMap = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMyAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        this.layoutManager = gridLayoutManager;
        gridLayoutManager.setOrientation(1);
        setLayoutManager(this.layoutManager);
        MyAdapter myAdapter = new MyAdapter();
        this.myAdapter = myAdapter;
        setAdapter(myAdapter);
    }

    public Map<Integer, PicAndVideoBean> getPicAndVideoMap() {
        return this.map;
    }

    @Override // com.ipotensic.potensicpro.utils.PhotoChooserUtil.OnChooseListener
    public void onChooseNoCrop(String str, String str2) {
        if (str2 == null) {
            return;
        }
        DDLog.m1684e("filePath: " + str2 + ", currentIndex = " + this.currentIndex);
        if (new File(str2).exists()) {
            PicAndVideoBean picAndVideoBean = this.map.get(Integer.valueOf(this.currentIndex));
            if (picAndVideoBean != null) {
                if (str2.equals(picAndVideoBean.path)) {
                    return;
                } else {
                    this.map.replace(Integer.valueOf(this.currentIndex), new PicAndVideoBean(str2, str.equals("video")));
                }
            } else {
                this.picNum++;
                this.map.put(Integer.valueOf(this.currentIndex), new PicAndVideoBean(str2, str.equals("video")));
            }
            this.myAdapter.notifyDataSetChanged();
            OnPhotoSelectedListener onPhotoSelectedListener = this.photoSelectedListener;
            if (onPhotoSelectedListener != null) {
                onPhotoSelectedListener.onSelectedPicNum(this.picNum);
            }
        }
    }

    @Override // com.ipotensic.potensicpro.utils.PhotoChooserUtil.OnChooseListener
    public void onVideoResult(String str) {
        DDLog.m1684e("videoPath: " + str);
        this.videoPath = str;
    }

    @Override // com.ipotensic.potensicpro.utils.PhotoChooserUtil.OnChooseListener
    public void onFileTooBig() {
        Activity activity = this.activity;
        ToastUtil.toast(activity, activity.getString(C2640R.string.fb_limit_video_size));
    }

    private class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
        private boolean isVideo;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i;
        }

        private MyAdapter() {
            this.isVideo = false;
        }

        class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            ImageButton btnDeletePhoto;
            ImageButton btnSelectPhoto;
            ImageView iconImage;
            ImageView ivVideoView;

            public ViewHolder(View view) {
                super(view);
                this.iconImage = (ImageView) view.findViewById(C2640R.id.icon_image);
                this.btnSelectPhoto = (ImageButton) view.findViewById(C2640R.id.btn_select_photo);
                this.btnDeletePhoto = (ImageButton) view.findViewById(C2640R.id.btn_delete_photo);
                this.ivVideoView = (ImageView) view.findViewById(C2640R.id.iv_video_view);
                this.iconImage.setOnClickListener(this);
                this.btnSelectPhoto.setOnClickListener(this);
                this.btnDeletePhoto.setOnClickListener(this);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HorizontalPhotosView.this.currentIndex = getAdapterPosition();
                MyAdapter.this.isVideo = false;
                int id = view.getId();
                if (id == C2640R.id.icon_image) {
                    Iterator it = HorizontalPhotosView.this.map.entrySet().iterator();
                    while (it.hasNext()) {
                        PicAndVideoBean picAndVideoBean = (PicAndVideoBean) ((Map.Entry) it.next()).getValue();
                        if (picAndVideoBean != null) {
                            MyAdapter.this.isVideo = picAndVideoBean.isVideo;
                            if (MyAdapter.this.isVideo) {
                                break;
                            }
                        }
                    }
                    if (HorizontalPhotosView.this.map.get(Integer.valueOf(HorizontalPhotosView.this.currentIndex)) != null) {
                        ImageButton imageButton = this.btnDeletePhoto;
                        imageButton.setVisibility(imageButton.getVisibility() != 0 ? 0 : 8);
                        ImageButton imageButton2 = this.btnSelectPhoto;
                        imageButton2.setVisibility(imageButton2.getVisibility() == 0 ? 8 : 0);
                        return;
                    }
                    TakePhotoDialog takePhotoDialog = new TakePhotoDialog(HorizontalPhotosView.this.getContext(), new TakePhotoDialog.TakePhotoSelectListener() { // from class: com.ipotensic.potensicpro.view.HorizontalPhotosView.MyAdapter.ViewHolder.1
                        @Override // com.ipotensic.potensicpro.view.dialog.TakePhotoDialog.TakePhotoSelectListener
                        public void takePhoto() {
                            HorizontalPhotosView.this.photoChooserUtil.recordVideoForCamera(MyAdapter.this.isVideo ? 1 : 0);
                        }

                        @Override // com.ipotensic.potensicpro.view.dialog.TakePhotoDialog.TakePhotoSelectListener
                        public void uploadPhoto() {
                            if (MyAdapter.this.isVideo) {
                                HorizontalPhotosView.this.photoChooserUtil.takePhotoForAlbum(false);
                            } else {
                                HorizontalPhotosView.this.photoChooserUtil.photoAndVideoForAlbum();
                            }
                        }
                    });
                    if (takePhotoDialog.isShowing()) {
                        return;
                    }
                    takePhotoDialog.show();
                    return;
                }
                if (id == C2640R.id.btn_select_photo) {
                    Iterator it2 = HorizontalPhotosView.this.map.entrySet().iterator();
                    while (it2.hasNext()) {
                        PicAndVideoBean picAndVideoBean2 = (PicAndVideoBean) ((Map.Entry) it2.next()).getValue();
                        if (picAndVideoBean2 != null) {
                            MyAdapter.this.isVideo = picAndVideoBean2.isVideo;
                            if (MyAdapter.this.isVideo) {
                                break;
                            }
                        }
                    }
                    final PicAndVideoBean picAndVideoBean3 = (PicAndVideoBean) HorizontalPhotosView.this.map.get(Integer.valueOf(HorizontalPhotosView.this.currentIndex));
                    TakePhotoDialog takePhotoDialog2 = new TakePhotoDialog(HorizontalPhotosView.this.getContext(), new TakePhotoDialog.TakePhotoSelectListener() { // from class: com.ipotensic.potensicpro.view.HorizontalPhotosView.MyAdapter.ViewHolder.2
                        @Override // com.ipotensic.potensicpro.view.dialog.TakePhotoDialog.TakePhotoSelectListener
                        public void takePhoto() {
                            if (picAndVideoBean3 != null) {
                                if (!MyAdapter.this.isVideo || picAndVideoBean3.isVideo) {
                                    HorizontalPhotosView.this.photoChooserUtil.recordVideoForCamera(0);
                                } else {
                                    HorizontalPhotosView.this.photoChooserUtil.recordVideoForCamera(1);
                                }
                            }
                        }

                        @Override // com.ipotensic.potensicpro.view.dialog.TakePhotoDialog.TakePhotoSelectListener
                        public void uploadPhoto() {
                            if (picAndVideoBean3 != null) {
                                if (!MyAdapter.this.isVideo || picAndVideoBean3.isVideo) {
                                    HorizontalPhotosView.this.photoChooserUtil.photoAndVideoForAlbum();
                                } else {
                                    HorizontalPhotosView.this.photoChooserUtil.takePhotoForAlbum(false);
                                }
                            }
                        }
                    });
                    if (takePhotoDialog2.isShowing()) {
                        return;
                    }
                    takePhotoDialog2.show();
                    return;
                }
                if (id == C2640R.id.btn_delete_photo) {
                    HorizontalPhotosView.this.deleteMap.clear();
                    while (r1 < HorizontalPhotosView.this.map.size()) {
                        PicAndVideoBean picAndVideoBean4 = (PicAndVideoBean) HorizontalPhotosView.this.map.get(Integer.valueOf(r1));
                        if (r1 < HorizontalPhotosView.this.currentIndex) {
                            if (picAndVideoBean4 != null) {
                                HorizontalPhotosView.this.deleteMap.put(Integer.valueOf(r1), picAndVideoBean4);
                            }
                        } else if (r1 < HorizontalPhotosView.this.map.size() - 1) {
                            HorizontalPhotosView.this.deleteMap.put(Integer.valueOf(r1), (PicAndVideoBean) HorizontalPhotosView.this.map.get(Integer.valueOf(r1 + 1)));
                        }
                        r1++;
                    }
                    HorizontalPhotosView.this.map.clear();
                    HorizontalPhotosView.this.map.putAll(HorizontalPhotosView.this.deleteMap);
                    HorizontalPhotosView.this.picNum = HorizontalPhotosView.this.map.size();
                    MyAdapter.this.notifyDataSetChanged();
                    if (HorizontalPhotosView.this.photoSelectedListener != null) {
                        HorizontalPhotosView.this.photoSelectedListener.onSelectedPicNum(HorizontalPhotosView.this.picNum);
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(ViewHolder viewHolder) {
            Glide.clear(viewHolder.iconImage);
            viewHolder.iconImage.setImageResource(C2640R.mipmap.icon_add_picture);
            viewHolder.iconImage.setVisibility(0);
            viewHolder.btnDeletePhoto.setVisibility(8);
            viewHolder.btnSelectPhoto.setVisibility(8);
            viewHolder.ivVideoView.setVisibility(8);
            super.onViewRecycled((MyAdapter) viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2640R.layout.view_item_photo, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            PicAndVideoBean picAndVideoBean = (PicAndVideoBean) HorizontalPhotosView.this.map.get(Integer.valueOf(i));
            if (picAndVideoBean != null) {
                String path = picAndVideoBean.getPath();
                if (path != null) {
                    Glide.with(HorizontalPhotosView.this.getContext()).load(Uri.parse("file://" + path)).into(viewHolder.iconImage);
                }
                viewHolder.ivVideoView.setVisibility(picAndVideoBean.isVideo ? 0 : 8);
            }
            if (HorizontalPhotosView.this.imageWidth > 0) {
                ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
                layoutParams.width = HorizontalPhotosView.this.imageWidth;
                layoutParams.height = HorizontalPhotosView.this.imageWidth;
                viewHolder.itemView.setLayoutParams(layoutParams);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (HorizontalPhotosView.this.picNum >= 6) {
                return 6;
            }
            return HorizontalPhotosView.this.picNum + 1;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        PhotoChooserUtil photoChooserUtil = this.photoChooserUtil;
        if (photoChooserUtil != null) {
            photoChooserUtil.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        PhotoChooserUtil photoChooserUtil = this.photoChooserUtil;
        if (photoChooserUtil != null) {
            photoChooserUtil.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public void setOnPhotoSelectedListener(OnPhotoSelectedListener onPhotoSelectedListener) {
        this.photoSelectedListener = onPhotoSelectedListener;
    }
}