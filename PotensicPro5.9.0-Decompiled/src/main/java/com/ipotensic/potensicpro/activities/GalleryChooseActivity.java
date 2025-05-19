package com.ipotensic.potensicpro.activities;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.kernel.adapter.MyGridLayoutManager;
import com.ipotensic.potensicpro.R;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class GalleryChooseActivity extends BaseActivity {
    private BaseAdapter baseAdapter;
    private ArrayList<String> imageList;
    private HashMap<Integer, String> images;
    private ArrayList<String> videoList;
    private HashMap<Integer, String> videos;

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_gallery_choose);
        initView();
        initData();
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.baseAdapter = new BaseAdapter();
        recyclerView.setLayoutManager(new MyGridLayoutManager(this, 3));
        recyclerView.setAdapter(this.baseAdapter);
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.activities.GalleryChooseActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GalleryChooseActivity.this.finish();
            }
        });
    }

    private void initData() {
        if (this.images == null) {
            this.images = new HashMap<>();
        }
        if (this.videos == null) {
            this.videos = new HashMap<>();
        }
        if (this.imageList == null) {
            this.imageList = new ArrayList<>();
        }
        if (this.videoList == null) {
            this.videoList = new ArrayList<>();
        }
        this.images.clear();
        this.videos.clear();
        this.imageList.clear();
        this.videoList.clear();
        new Thread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.GalleryChooseActivity.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Uri uri = MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI;
                    Uri uri2 = MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI;
                    String[] strArr = {"video_id", "_data"};
                    Cursor query = GalleryChooseActivity.this.getContentResolver().query(uri, new String[]{"image_id", "_data"}, null, null, null);
                    if (query != null) {
                        if (query.moveToFirst()) {
                            while (query.moveToNext()) {
                                int columnIndex = query.getColumnIndex("image_id");
                                int columnIndex2 = query.getColumnIndex("_data");
                                int i = query.getInt(columnIndex);
                                String string = query.getString(columnIndex2);
                                Log.e("111", "imageId:" + i + ", imagePath:" + string);
                                GalleryChooseActivity.this.images.put(Integer.valueOf(i), string);
                                GalleryChooseActivity.this.imageList.add(string);
                            }
                        }
                        query.close();
                    }
                    Cursor query2 = GalleryChooseActivity.this.getContentResolver().query(uri2, strArr, null, null, null);
                    if (query2 != null) {
                        if (query2.moveToFirst()) {
                            while (query2.moveToNext()) {
                                int columnIndex3 = query2.getColumnIndex("video_id");
                                int columnIndex4 = query2.getColumnIndex("_data");
                                int i2 = query2.getInt(columnIndex3);
                                String string2 = query2.getString(columnIndex4);
                                GalleryChooseActivity.this.videos.put(Integer.valueOf(i2), string2);
                                GalleryChooseActivity.this.videoList.add(string2);
                            }
                        }
                        query2.close();
                        GalleryChooseActivity.this.refreshAdapter();
                    }
                } catch (Exception e) {
                    DDLog.e("获取所有本地图片出错:" + e.getMessage());
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshAdapter() {
        runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.GalleryChooseActivity.3
            @Override // java.lang.Runnable
            public void run() {
                if (GalleryChooseActivity.this.baseAdapter != null) {
                    GalleryChooseActivity.this.baseAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder> {
        private BaseAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return GalleryChooseActivity.this.new BaseViewHolder(LayoutInflater.from(GalleryChooseActivity.this).inflate(R.layout.view_adapter_gallery_choose, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
            if (i > GalleryChooseActivity.this.images.size() - 1) {
                return;
            }
            Log.e("111", "path:" + ((String) GalleryChooseActivity.this.imageList.get(i)));
            Glide.with((FragmentActivity) GalleryChooseActivity.this).load((String) GalleryChooseActivity.this.imageList.get(i)).into(baseViewHolder.imageView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return GalleryChooseActivity.this.imageList.size();
        }
    }

    private class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;

        public BaseViewHolder(View view) {
            super(view);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_photo);
            this.imageView = imageView;
            imageView.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (adapterPosition > GalleryChooseActivity.this.images.size() - 1) {
                return;
            }
            Log.e("111", "选中照片的完整路径：" + ((String) GalleryChooseActivity.this.images.get(Integer.valueOf(adapterPosition))) + ", position:" + adapterPosition);
        }
    }
}
