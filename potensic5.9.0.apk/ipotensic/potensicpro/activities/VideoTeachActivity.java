package com.ipotensic.potensicpro.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.okhttp.PicassoLoader;
import com.ipotensic.baselib.utils.LanguageHelper;
import com.ipotensic.kernel.activitys.VideoDisplayActivity;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.view.DividerLineaItemDecoration;
import com.logan.camera.RemoteFile;
import com.logan.user.model.rev.RevUserGetTeachVideoResult;
import com.logan.user.presenter.UserRequestPresenter;
import com.logan.user.view.IGetTeachVideoView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class VideoTeachActivity extends BaseActivity implements View.OnClickListener, IGetTeachVideoView {
    private VideoTeachAdapter adapter;
    private List<RevUserGetTeachVideoResult.Document> documents = new ArrayList();
    private ImageView ivBlank;
    private TextView tvNoNetWorkTips;

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        setContentView(R.layout.activity_video_teach);
        initView();
        setToolBar();
        getVideoListFromServer();
    }

    private void setToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.findViewById(R.id.iv_back).setOnClickListener(this);
        ((TextView) toolbar.findViewById(R.id.tv_code_title)).setText(getResources().getString(R.string.main_video_teaching));
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowTitleEnabled(false);
        supportActionBar.setHomeButtonEnabled(false);
        supportActionBar.setDisplayHomeAsUpEnabled(false);
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        VideoTeachAdapter videoTeachAdapter = new VideoTeachAdapter();
        this.adapter = videoTeachAdapter;
        recyclerView.setAdapter(videoTeachAdapter);
        recyclerView.addItemDecoration(new DividerLineaItemDecoration(40));
        this.ivBlank = (ImageView) findViewById(R.id.iv_blank);
        this.tvNoNetWorkTips = (TextView) findViewById(R.id.tv_no_network);
    }

    private void getVideoListFromServer() {
        if (PhoneConfig.usrToken != null) {
            showLoadingDialog();
            UserRequestPresenter.getInstance().getTeachVideo(PhoneConfig.usrToken, LanguageHelper.getLanguageType(this), this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_back) {
            setResult(-1, new Intent());
            finish();
        }
    }

    @Override // com.logan.user.view.IGetTeachVideoView
    public void onGetTeachVideoSuccess(List<RevUserGetTeachVideoResult.Document> list) {
        if (list != null) {
            dismissLoadingDialog();
            this.documents = list;
        }
        VideoTeachAdapter videoTeachAdapter = this.adapter;
        if (videoTeachAdapter != null) {
            videoTeachAdapter.notifyDataSetChanged();
        }
        if (list != null && list.size() > 0) {
            this.ivBlank.setVisibility(8);
            this.tvNoNetWorkTips.setVisibility(8);
        } else {
            setNoContentUI();
        }
    }

    @Override // com.logan.user.view.IGetTeachVideoView
    public void onGetTeachVideoFailed(String str) {
        dismissLoadingDialog();
        VideoTeachAdapter videoTeachAdapter = this.adapter;
        if (videoTeachAdapter != null) {
            videoTeachAdapter.notifyDataSetChanged();
        }
        setNoNetworkUI();
    }

    @Override // com.logan.user.view.IGetTeachVideoView
    public void onTokenError() {
        dismissLoadingDialog();
        setNoContentUI();
    }

    @Override // com.logan.user.view.IGetTeachVideoView
    public void onProductNotFind() {
        dismissLoadingDialog();
        VideoTeachAdapter videoTeachAdapter = this.adapter;
        if (videoTeachAdapter != null) {
            videoTeachAdapter.notifyDataSetChanged();
        }
        setNoContentUI();
    }

    private void setNoContentUI() {
        this.ivBlank.setVisibility(0);
        this.tvNoNetWorkTips.setVisibility(0);
        this.ivBlank.setImageResource(R.mipmap.icon_no_content);
        this.tvNoNetWorkTips.setText(getText(R.string.txt_no_content));
    }

    private void setNoNetworkUI() {
        this.ivBlank.setVisibility(0);
        this.tvNoNetWorkTips.setVisibility(0);
        this.ivBlank.setImageResource(R.mipmap.icon_no_network);
        this.tvNoNetWorkTips.setText(getText(R.string.no_net_work));
    }

    private class VideoTeachAdapter extends RecyclerView.Adapter<ViewHolder> {
        private VideoTeachAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(VideoTeachActivity.this).inflate(R.layout.view_adapter_video_teach, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            final RevUserGetTeachVideoResult.Document document = (RevUserGetTeachVideoResult.Document) VideoTeachActivity.this.documents.get(i);
            PicassoLoader.with(VideoTeachActivity.this).load(document.getThumbnail()).into(viewHolder.ivVideoThumbnail);
            viewHolder.tvTitle.setText(document.getName());
            viewHolder.tvMessage.setText(document.getDetail());
            viewHolder.ivVideoThumbnail.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.VideoTeachActivity.VideoTeachAdapter.1
                @Override // com.ipotensic.baselib.listener.ScaleClickListener
                public void click(View view) {
                    RemoteFile remoteFile = new RemoteFile();
                    remoteFile.setDownloadUrl(document.getDownloadurl());
                    remoteFile.setFileName(document.getName());
                    Intent intent = new Intent(VideoTeachActivity.this, (Class<?>) VideoDisplayActivity.class);
                    intent.putExtra("data", remoteFile);
                    intent.putExtra("type", 0);
                    intent.putExtra("position", 0);
                    intent.putExtra("isServerVideo", true);
                    VideoTeachActivity.this.startActivity(intent);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return VideoTeachActivity.this.documents.size();
        }

        private class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView ivVideoThumbnail;
            private TextView tvMessage;
            private TextView tvTitle;

            private ViewHolder(View view) {
                super(view);
                this.tvTitle = (TextView) view.findViewById(R.id.tv_code_title);
                this.tvMessage = (TextView) view.findViewById(R.id.tv_message);
                this.ivVideoThumbnail = (ImageView) view.findViewById(R.id.iv_video);
            }
        }
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}