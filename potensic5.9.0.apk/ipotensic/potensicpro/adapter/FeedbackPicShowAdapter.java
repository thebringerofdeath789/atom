package com.ipotensic.potensicpro.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.ipotensic.baselib.mediadataretriever.MediaRetriever;
import com.ipotensic.baselib.okhttp.PicassoLoader;
import com.ipotensic.potensicpro.R;
import com.logan.user.model.rev.RevUserGetFeedbackData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class FeedbackPicShowAdapter extends RecyclerView.Adapter<PicViewHolder> {
    private Activity context;
    private List<RevUserGetFeedbackData.PictureBean> data;
    private OnItemClickListener listener;
    private List<String> thumbList = new ArrayList();
    private List<String> picList = new ArrayList();
    private boolean isVideoThumbExist = false;

    public interface OnItemClickListener {
        void onItemClick(int i, String str);
    }

    public FeedbackPicShowAdapter(Activity activity, List<RevUserGetFeedbackData.PictureBean> list, String str, String str2, int i) {
        this.context = activity;
        this.data = list;
        initData(str, str2);
    }

    private void initData(String str, String str2) {
        this.thumbList.clear();
        this.picList.clear();
        for (RevUserGetFeedbackData.PictureBean pictureBean : this.data) {
            String thumb = pictureBean.getThumb();
            String pic = pictureBean.getPic();
            this.thumbList.add(thumb);
            this.picList.add(pic);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.thumbList.add(str2);
            this.picList.add(str);
            this.isVideoThumbExist = true;
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.thumbList.add(str);
            this.picList.add(str);
            this.isVideoThumbExist = false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PicViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new PicViewHolder(LayoutInflater.from(this.context).inflate(R.layout.adapter_fb_reply_picture, (ViewGroup) null, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PicViewHolder picViewHolder, final int i) {
        if (i >= this.thumbList.size()) {
            return;
        }
        String str = this.thumbList.get(i);
        String lowerCase = str.toLowerCase();
        if (lowerCase.endsWith(".jpg") || lowerCase.endsWith(".png") || lowerCase.endsWith(".jpeg") || lowerCase.endsWith(".webp")) {
            if (!this.isVideoThumbExist || i != this.thumbList.size() - 1) {
                picViewHolder.videoView.setVisibility(8);
            } else {
                picViewHolder.videoView.setVisibility(0);
            }
            picViewHolder.imageView.setTag(null);
            PicassoLoader.with(this.context).load(str).placeholder(R.mipmap.icon_placeholder).into(picViewHolder.imageView);
        } else {
            picViewHolder.videoView.setVisibility(0);
            MediaRetriever.withVideo(str).thumbnailType(2).metaKeys(null).into(picViewHolder.imageView);
        }
        picViewHolder.imageView.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.adapter.FeedbackPicShowAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FeedbackPicShowAdapter.this.listener != null) {
                    FeedbackPicShowAdapter.this.listener.onItemClick(i, (String) FeedbackPicShowAdapter.this.picList.get(i));
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.thumbList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public class PicViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final ImageView videoView;

        public PicViewHolder(View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.image_view);
            this.videoView = (ImageView) view.findViewById(R.id.video_view);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }
}