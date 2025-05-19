package com.ipotensic.potensicpro.activities;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.bean.AlbumItem;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.mediadataretriever.MediaRetriever;
import com.ipotensic.baselib.okhttp.PicassoLoader;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.adapter.MyLinearLayoutManager;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.activities.FeedbackPreviewController;
import com.ipotensic.potensicpro.adapter.FeedbackPicShowAdapter;
import com.ipotensic.potensicpro.anim.ExpandableViewHoldersUtil;
import com.ipotensic.potensicpro.view.DividerLineaItemDecoration;
import com.logan.flight.FlightConfig;
import com.logan.user.model.rev.RevUserGetFeedbackData;
import com.logan.user.presenter.UserRequestPresenter;
import com.logan.user.view.IFbCommitResultView;
import com.logan.user.view.IFeedbackDeleteView;
import com.logan.user.view.IFeedbackMarkView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class FeedbackDetailsActivity extends BaseActivity implements View.OnClickListener, IFbCommitResultView, IFeedbackDeleteView, IFeedbackMarkView {
    private List<RevUserGetFeedbackData.FeedbackInfo> data;
    private FeedbackDetailsAdapter detailsAdapter;
    private FeedbackPreviewController feedbackPreviewController;
    private ImageView ivDelete;
    private LinearLayout layoutViewDefault;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private TextView tvUploadNum;
    private boolean isDeleteMode = false;
    private List<Integer> deleteList = new ArrayList();
    private int position = 0;
    private final int MSG_UNREAD = 0;
    private final int MSG_READ = 1;
    private final int MSG_DELETE = 2;

    @Override // com.logan.user.view.IFeedbackDeleteView
    public void deleteFail() {
    }

    @Override // com.logan.user.view.IFeedbackMarkView
    public void markFail() {
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        setContentView(R.layout.activity_feedback_details);
        initView();
        setToolBar();
        initRequest();
    }

    private void setToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar;
        toolbar.findViewById(R.id.iv_back).setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.iv_delete);
        this.ivDelete = imageView;
        imageView.setOnClickListener(this);
        setSupportActionBar(this.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowTitleEnabled(false);
        supportActionBar.setHomeButtonEnabled(false);
        supportActionBar.setDisplayHomeAsUpEnabled(false);
    }

    private void initView() {
        this.layoutViewDefault = (LinearLayout) findViewById(R.id.layout_view_default);
        this.recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.detailsAdapter = new FeedbackDetailsAdapter();
        MyLinearLayoutManager myLinearLayoutManager = new MyLinearLayoutManager(this, 1, false);
        this.recyclerView.addItemDecoration(new DividerLineaItemDecoration(30));
        this.recyclerView.setLayoutManager(myLinearLayoutManager);
        this.recyclerView.setAdapter(this.detailsAdapter);
        this.feedbackPreviewController = new FeedbackPreviewController(this, (RelativeLayout) findViewById(R.id.layout_preview));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.feedbackPreviewController.getVisibility() == 0) {
            this.feedbackPreviewController.setVisibility(8);
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List<RevUserGetFeedbackData.FeedbackInfo> list;
        int id = view.getId();
        int i = R.mipmap.icon_feedback_select;
        if (id == R.id.iv_back) {
            if (this.feedbackPreviewController.getVisibility() == 0) {
                this.feedbackPreviewController.setVisibility(8);
                this.ivDelete.setVisibility(0);
                this.ivDelete.setImageResource(R.mipmap.icon_feedback_select);
                return;
            }
            finish();
            return;
        }
        if (id != R.id.iv_delete || (list = this.data) == null || list.size() <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (RevUserGetFeedbackData.FeedbackInfo feedbackInfo : this.data) {
            if (feedbackInfo.isSelected()) {
                sb.append(feedbackInfo.getId() + ",");
            }
        }
        if (this.isDeleteMode && sb.length() > 0) {
            final String sb2 = sb.toString();
            if (PhoneConfig.usrToken == null || TextUtils.isEmpty(sb2)) {
                return;
            }
            new GeneralDialog((Context) this, getString(R.string.fb_confirm_delete), getString(R.string.fb_confirm_delete_content), getString(R.string.dialog_cancel), getString(R.string.dialog_confirm), true, false, new GeneralDialog.DialogListener() { // from class: com.ipotensic.potensicpro.activities.FeedbackDetailsActivity.1
                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.DialogListener
                public void cancel() {
                }

                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.DialogListener
                public void confirm() {
                    UserRequestPresenter.getInstance().deleteFeedbackInfo(PhoneConfig.usrToken, sb2, FeedbackDetailsActivity.this);
                }
            }).show();
            return;
        }
        boolean z = !this.isDeleteMode;
        this.isDeleteMode = z;
        ImageView imageView = this.ivDelete;
        if (z) {
            i = R.mipmap.icon_feedback_delete;
        }
        imageView.setImageResource(i);
        this.detailsAdapter.notifyDataSetChanged();
    }

    private void initRequest() {
        if (PhoneConfig.usrToken != null) {
            showLoadingDialog();
            UserRequestPresenter.getInstance().getUserFeedbackInfo(PhoneConfig.usrToken, 60, this);
        }
    }

    @Override // com.logan.user.view.IFbCommitResultView
    public void getFeedbackSuccess(List<RevUserGetFeedbackData.FeedbackInfo> list) {
        dismissLoadingDialog();
        if (list.size() > 0) {
            this.layoutViewDefault.setVisibility(8);
            this.ivDelete.setVisibility(0);
            this.recyclerView.setVisibility(0);
            this.data = list;
            this.detailsAdapter.notifyDataSetChanged();
            return;
        }
        this.layoutViewDefault.setVisibility(0);
        this.ivDelete.setVisibility(4);
        this.recyclerView.setVisibility(8);
    }

    @Override // com.logan.user.view.IFbCommitResultView
    public void getFailed() {
        dismissLoadingDialog();
        ToastUtil.toast(PhoneConfig.runningActivity, PhoneConfig.applicationContext.getString(R.string.toast_no_network));
        this.ivDelete.setVisibility(4);
        this.recyclerView.setVisibility(8);
    }

    @Override // com.logan.user.view.IFeedbackDeleteView
    public void deleteSuccess() {
        Iterator<RevUserGetFeedbackData.FeedbackInfo> it = this.data.iterator();
        while (it.hasNext()) {
            if (it.next().isSelected()) {
                it.remove();
            }
        }
        if (this.data.size() == 0) {
            this.layoutViewDefault.setVisibility(0);
            this.ivDelete.setVisibility(4);
        }
        this.detailsAdapter.notifyDataSetChanged();
        ToastUtil.toast(this, getString(R.string.toast_delete_success));
    }

    @Override // com.logan.user.view.IFeedbackMarkView
    public void markSuccess() {
        if (this.position >= this.data.size()) {
            return;
        }
        this.data.get(this.position).setState_user(1);
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        UserRequestPresenter.getInstance().removeUserFeedbackImp();
    }

    private class FeedbackDetailsAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private ExpandableViewHoldersUtil.KeepOneH<MyViewHolder> keepOneH;

        private FeedbackDetailsAdapter() {
            this.keepOneH = new ExpandableViewHoldersUtil.KeepOneH<>();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new MyViewHolder(LayoutInflater.from(FeedbackDetailsActivity.this).inflate(R.layout.view_adapter_feedback_details, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
            if (i >= FeedbackDetailsActivity.this.data.size()) {
                return;
            }
            myViewHolder.bind(i, (RevUserGetFeedbackData.FeedbackInfo) FeedbackDetailsActivity.this.data.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (FeedbackDetailsActivity.this.data != null) {
                return FeedbackDetailsActivity.this.data.size();
            }
            return 0;
        }

        private class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, ExpandableViewHoldersUtil.Expandable {
            ConstraintLayout clBottomLayout;
            ConstraintLayout clCustomerLayout;
            ConstraintLayout clTopLayout;
            ImageView imageView;
            ImageView ivDown;
            ImageView ivRedPoint;
            ImageView ivRight;
            ImageView ivVideoView;
            View line;
            RecyclerView rvCustomerView;
            RecyclerView rvUserView;
            TextView tvCustomerReply;
            TextView tvCustomerTime;
            TextView tvUserReplyContent1;
            TextView tvUserReplyContent2;
            TextView tvUserReplyTime1;
            TextView tvUserReplyTime2;
            MyViewHolder viewHolder;

            public MyViewHolder(View view) {
                super(view);
                this.viewHolder = this;
                this.clTopLayout = (ConstraintLayout) view.findViewById(R.id.cl_top_layout);
                this.imageView = (ImageView) view.findViewById(R.id.image_view);
                this.tvUserReplyTime1 = (TextView) view.findViewById(R.id.tv_user_time_1);
                this.tvUserReplyContent1 = (TextView) view.findViewById(R.id.tv_user_reply_1);
                this.ivRedPoint = (ImageView) view.findViewById(R.id.iv_red_point);
                this.ivRight = (ImageView) view.findViewById(R.id.iv_right);
                this.ivDown = (ImageView) view.findViewById(R.id.iv_down);
                this.ivVideoView = (ImageView) view.findViewById(R.id.video_view);
                this.rvUserView = (RecyclerView) view.findViewById(R.id.rv_user_feedback);
                this.rvCustomerView = (RecyclerView) view.findViewById(R.id.rv_customer_feedback);
                this.clCustomerLayout = (ConstraintLayout) view.findViewById(R.id.cl_customer_layout);
                this.line = view.findViewById(R.id.line1);
                this.clBottomLayout = (ConstraintLayout) view.findViewById(R.id.cl_bottom_layout);
                this.tvUserReplyTime2 = (TextView) view.findViewById(R.id.tv_user_time_2);
                this.tvUserReplyContent2 = (TextView) view.findViewById(R.id.tv_user_reply_2);
                this.tvCustomerTime = (TextView) view.findViewById(R.id.tv_customer_reply_time);
                this.tvCustomerReply = (TextView) view.findViewById(R.id.tv_customer_reply);
                this.clTopLayout.setOnClickListener(this);
                this.clBottomLayout.setOnClickListener(this);
            }

            public void bind(int i, RevUserGetFeedbackData.FeedbackInfo feedbackInfo) {
                String product_class;
                FeedbackDetailsAdapter.this.keepOneH.bind(this, i);
                int state_user = feedbackInfo.getState_user();
                List<RevUserGetFeedbackData.PictureBean> pictureList = feedbackInfo.getPictureList();
                String video_url = feedbackInfo.getVideo_url();
                String video_thumbnail = feedbackInfo.getVideo_thumbnail();
                if (pictureList.size() > 0) {
                    String thumb = pictureList.get(0).getThumb();
                    this.imageView.setTag(null);
                    this.imageView.setVisibility(0);
                    this.ivVideoView.setVisibility(8);
                    PicassoLoader.with(FeedbackDetailsActivity.this).load(thumb).into(this.imageView);
                } else if (!TextUtils.isEmpty(video_thumbnail)) {
                    this.imageView.setVisibility(0);
                    this.ivVideoView.setVisibility(0);
                    PicassoLoader.with(FeedbackDetailsActivity.this).load(video_thumbnail).into(this.imageView);
                } else if (!TextUtils.isEmpty(video_url)) {
                    this.imageView.setVisibility(0);
                    this.ivVideoView.setVisibility(0);
                    MediaRetriever.withVideo(video_url).thumbnailType(2).metaKeys(null).into(this.imageView);
                } else {
                    this.imageView.setVisibility(8);
                    this.ivVideoView.setVisibility(8);
                }
                if (feedbackInfo.getIsbase64() == 0) {
                    String str = new String(Base64.decode(feedbackInfo.getContent().getBytes(), 0));
                    this.tvUserReplyContent1.setText(str);
                    this.tvUserReplyContent2.setText(str);
                } else {
                    this.tvUserReplyContent1.setText(feedbackInfo.getContent());
                    this.tvUserReplyContent2.setText(feedbackInfo.getContent());
                }
                if (FlightConfig.isAtomSeriesProductClass(feedbackInfo.getProduct_class())) {
                    product_class = "Atom";
                } else {
                    product_class = FlightConfig.isAtomSeSeriesProductClass(feedbackInfo.getProduct_class()) ? FlightConfig.TYPE_ATOM_SE : feedbackInfo.getProduct_class();
                }
                String replace = feedbackInfo.getIntime().replace("-", InternalZipConstants.ZIP_FILE_SEPARATOR);
                if (!TextUtils.isEmpty(product_class)) {
                    String replace2 = product_class.replace("-", StringUtils.SPACE);
                    this.tvUserReplyTime1.setText(String.format("%s%s%s", replace2, StringUtils.SPACE, replace));
                    this.tvUserReplyTime2.setText(String.format("%s%s%s", "(" + replace2, "-", replace + ")"));
                } else {
                    this.tvUserReplyTime1.setText(replace);
                    this.tvUserReplyTime2.setText(replace);
                }
                int size = feedbackInfo.getReplyInfoList().size();
                this.clCustomerLayout.setVisibility(size > 0 ? 0 : 8);
                this.line.setVisibility(size > 0 ? 0 : 8);
                if (size > 0) {
                    RevUserGetFeedbackData.CustomerReplyInfo customerReplyInfo = feedbackInfo.getReplyInfoList().get(0);
                    String replace3 = customerReplyInfo.getHtime().replace("-", InternalZipConstants.ZIP_FILE_SEPARATOR);
                    if (!TextUtils.isEmpty(product_class)) {
                        this.tvCustomerTime.setText(String.format("%s%s%s", "(" + product_class.replace("-", StringUtils.SPACE), "-", replace3 + ")"));
                    } else {
                        this.tvCustomerTime.setText(replace3);
                    }
                    String huifucontent = customerReplyInfo.getHuifucontent();
                    if (!TextUtils.isEmpty(huifucontent)) {
                        if (customerReplyInfo.getIsbase64() == 0) {
                            this.tvCustomerReply.setText(new String(Base64.decode(huifucontent.getBytes(), 0)));
                        } else {
                            this.tvCustomerReply.setText(huifucontent);
                        }
                    }
                }
                this.ivRight.setImageResource(FeedbackDetailsActivity.this.isDeleteMode ? feedbackInfo.isSelected() ? R.mipmap.icon_fb_checkbox_selected : R.mipmap.icon_fb_checkbox_default : R.mipmap.icon_arrow_right);
                this.ivRedPoint.setVisibility((FeedbackDetailsActivity.this.isDeleteMode || state_user == 1) ? 8 : 0);
                if (FeedbackDetailsActivity.this.isDeleteMode && FeedbackDetailsAdapter.this.keepOneH.openPos() == i) {
                    FeedbackDetailsAdapter.this.keepOneH.close(this.viewHolder, FeedbackDetailsActivity.this.data);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FeedbackDetailsActivity.this.position = getAdapterPosition();
                if (FeedbackDetailsActivity.this.position >= FeedbackDetailsActivity.this.data.size()) {
                    return;
                }
                int id = view.getId();
                if (id != R.id.cl_top_layout) {
                    if (id == R.id.cl_bottom_layout) {
                        FeedbackDetailsAdapter.this.keepOneH.close(this.viewHolder, FeedbackDetailsActivity.this.data);
                        return;
                    }
                    return;
                }
                RevUserGetFeedbackData.FeedbackInfo feedbackInfo = (RevUserGetFeedbackData.FeedbackInfo) FeedbackDetailsActivity.this.data.get(FeedbackDetailsActivity.this.position);
                if (!FeedbackDetailsActivity.this.isDeleteMode) {
                    FeedbackDetailsAdapter.this.keepOneH.open(this.viewHolder, FeedbackDetailsActivity.this.data);
                    final List<RevUserGetFeedbackData.PictureBean> pictureList = ((RevUserGetFeedbackData.FeedbackInfo) FeedbackDetailsActivity.this.data.get(FeedbackDetailsActivity.this.position)).getPictureList();
                    final String video_url = ((RevUserGetFeedbackData.FeedbackInfo) FeedbackDetailsActivity.this.data.get(FeedbackDetailsActivity.this.position)).getVideo_url();
                    final String video_thumbnail = ((RevUserGetFeedbackData.FeedbackInfo) FeedbackDetailsActivity.this.data.get(FeedbackDetailsActivity.this.position)).getVideo_thumbnail();
                    int video_pos = ((RevUserGetFeedbackData.FeedbackInfo) FeedbackDetailsActivity.this.data.get(FeedbackDetailsActivity.this.position)).getVideo_pos();
                    if (pictureList.size() > 0 || !TextUtils.isEmpty(video_url) || !TextUtils.isEmpty(video_thumbnail)) {
                        this.rvUserView.setLayoutManager(new GridLayoutManager(FeedbackDetailsActivity.this, 6));
                        FeedbackPicShowAdapter feedbackPicShowAdapter = new FeedbackPicShowAdapter(FeedbackDetailsActivity.this, pictureList, video_url, video_thumbnail, video_pos);
                        this.rvUserView.setAdapter(feedbackPicShowAdapter);
                        feedbackPicShowAdapter.setOnItemClickListener(new FeedbackPicShowAdapter.OnItemClickListener() { // from class: com.ipotensic.potensicpro.activities.FeedbackDetailsActivity.FeedbackDetailsAdapter.MyViewHolder.1
                            @Override // com.ipotensic.potensicpro.adapter.FeedbackPicShowAdapter.OnItemClickListener
                            public void onItemClick(int i, String str) {
                                FeedbackDetailsActivity.this.ivDelete.setVisibility(4);
                                ArrayList<AlbumItem> arrayList = new ArrayList<>();
                                for (int i2 = 0; i2 < pictureList.size(); i2++) {
                                    String pic = ((RevUserGetFeedbackData.PictureBean) pictureList.get(i2)).getPic();
                                    if (!TextUtils.isEmpty(pic)) {
                                        arrayList.add(new AlbumItem(false, pic));
                                    }
                                }
                                if (!TextUtils.isEmpty(video_url)) {
                                    AlbumItem albumItem = new AlbumItem(true, video_url);
                                    albumItem.setVideoThumbnailUrl(video_thumbnail);
                                    arrayList.add(albumItem);
                                }
                                FeedbackDetailsActivity.this.feedbackPreviewController.showSources(i, arrayList);
                                FeedbackDetailsActivity.this.feedbackPreviewController.setExitModeListener(new FeedbackPreviewController.ExitModeListener() { // from class: com.ipotensic.potensicpro.activities.FeedbackDetailsActivity.FeedbackDetailsAdapter.MyViewHolder.1.1
                                    @Override // com.ipotensic.potensicpro.activities.FeedbackPreviewController.ExitModeListener
                                    public void exitMode() {
                                        FeedbackDetailsActivity.this.ivDelete.setVisibility(0);
                                        FeedbackDetailsActivity.this.ivDelete.setImageResource(R.mipmap.icon_feedback_select);
                                    }
                                });
                            }
                        });
                    }
                    List<RevUserGetFeedbackData.CustomerReplyInfo> replyInfoList = ((RevUserGetFeedbackData.FeedbackInfo) FeedbackDetailsActivity.this.data.get(FeedbackDetailsActivity.this.position)).getReplyInfoList();
                    if (replyInfoList.size() > 0) {
                        final String video_url2 = replyInfoList.get(0).getVideo_url();
                        final String video_thumbnail2 = replyInfoList.get(0).getVideo_thumbnail();
                        int video_pos2 = replyInfoList.get(0).getVideo_pos();
                        final List<RevUserGetFeedbackData.PictureBean> pictureList2 = replyInfoList.get(0).getPictureList();
                        if (pictureList2.size() > 0 || !TextUtils.isEmpty(video_url2) || !TextUtils.isEmpty(video_thumbnail2)) {
                            this.rvCustomerView.setLayoutManager(new GridLayoutManager(FeedbackDetailsActivity.this, 6));
                            FeedbackPicShowAdapter feedbackPicShowAdapter2 = new FeedbackPicShowAdapter(FeedbackDetailsActivity.this, pictureList2, video_url2, video_thumbnail2, video_pos2);
                            this.rvCustomerView.setAdapter(feedbackPicShowAdapter2);
                            feedbackPicShowAdapter2.setOnItemClickListener(new FeedbackPicShowAdapter.OnItemClickListener() { // from class: com.ipotensic.potensicpro.activities.FeedbackDetailsActivity.FeedbackDetailsAdapter.MyViewHolder.2
                                @Override // com.ipotensic.potensicpro.adapter.FeedbackPicShowAdapter.OnItemClickListener
                                public void onItemClick(int i, String str) {
                                    FeedbackDetailsActivity.this.ivDelete.setVisibility(4);
                                    ArrayList<AlbumItem> arrayList = new ArrayList<>();
                                    for (int i2 = 0; i2 < pictureList2.size(); i2++) {
                                        String pic = ((RevUserGetFeedbackData.PictureBean) pictureList2.get(i2)).getPic();
                                        if (!TextUtils.isEmpty(pic)) {
                                            arrayList.add(new AlbumItem(false, pic));
                                        }
                                    }
                                    if (!TextUtils.isEmpty(video_url2)) {
                                        AlbumItem albumItem = new AlbumItem(true, video_url2);
                                        albumItem.setVideoThumbnailUrl(video_thumbnail2);
                                        arrayList.add(albumItem);
                                    }
                                    FeedbackDetailsActivity.this.feedbackPreviewController.showSources(i, arrayList);
                                    FeedbackDetailsActivity.this.feedbackPreviewController.setExitModeListener(new FeedbackPreviewController.ExitModeListener() { // from class: com.ipotensic.potensicpro.activities.FeedbackDetailsActivity.FeedbackDetailsAdapter.MyViewHolder.2.1
                                        @Override // com.ipotensic.potensicpro.activities.FeedbackPreviewController.ExitModeListener
                                        public void exitMode() {
                                            FeedbackDetailsActivity.this.ivDelete.setVisibility(0);
                                            FeedbackDetailsActivity.this.ivDelete.setImageResource(R.mipmap.icon_feedback_select);
                                        }
                                    });
                                }
                            });
                        }
                    }
                    if (feedbackInfo.getState_user() != 0 || PhoneConfig.usrToken == null) {
                        return;
                    }
                    UserRequestPresenter.getInstance().markFeedbackInfo(PhoneConfig.usrToken, feedbackInfo.getId(), FeedbackDetailsActivity.this);
                    return;
                }
                boolean isSelected = feedbackInfo.isSelected();
                feedbackInfo.setSelected(!isSelected);
                this.ivRight.setImageResource(!isSelected ? R.mipmap.icon_fb_checkbox_selected : R.mipmap.icon_fb_checkbox_default);
            }

            @Override // com.ipotensic.potensicpro.anim.ExpandableViewHoldersUtil.Expandable
            public View getExpandView() {
                return this.clBottomLayout;
            }

            @Override // com.ipotensic.potensicpro.anim.ExpandableViewHoldersUtil.Expandable
            public View getTopView() {
                return this.clTopLayout;
            }

            @Override // com.ipotensic.potensicpro.anim.ExpandableViewHoldersUtil.Expandable
            public View getMarkView() {
                return this.ivRedPoint;
            }
        }
    }
}
