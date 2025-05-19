package com.ipotensic.potensicpro.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.cropbitmap.LikeQQCropView;
import com.ipotensic.baselib.okhttp.PicassoLoader;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.utils.FileUtil;
import com.ipotensic.potensicpro.utils.PhotoChooserUtil;
import com.ipotensic.potensicpro.view.CircleImageView;
import com.ipotensic.potensicpro.view.dialog.PhotoChooseDialog;
import com.logan.user.presenter.UserRequestPresenter;
import com.logan.user.view.IUploadHeadImgView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class NickNameActivity extends BaseActivity implements View.OnClickListener {
    private LikeQQCropView bitmapCropView;
    private TextView btnConfirm;
    private EditText etNick;
    private CircleImageView headView;
    private ConstraintLayout layoutCrop;
    private String nickName;
    private PhotoChooseDialog photoChooseDialog;
    private boolean isFinish = false;
    private Bitmap chooseImageBmp = null;
    private Bitmap bitmap = null;
    private boolean isHeaderImgChange = false;
    private PhotoChooserUtil.OnChooseListener onChooseListener = new PhotoChooserUtil.OnChooseListener() { // from class: com.ipotensic.potensicpro.activities.NickNameActivity.4
        @Override // com.ipotensic.potensicpro.utils.PhotoChooserUtil.OnChooseListener
        public void onChooseNoCrop(String str, String str2) {
        }

        @Override // com.ipotensic.potensicpro.utils.PhotoChooserUtil.OnChooseListener
        public void onFileTooBig() {
        }

        @Override // com.ipotensic.potensicpro.utils.PhotoChooserUtil.OnChooseListener
        public void onVideoResult(String str) {
        }

        @Override // com.ipotensic.potensicpro.utils.PhotoChooserUtil.OnChooseListener
        public void onChooseCropResult(Bitmap bitmap) {
            if (bitmap != null) {
                NickNameActivity.this.bitmap = bitmap;
                NickNameActivity.this.headView.setImageBitmap(bitmap);
                NickNameActivity.this.btnConfirm.setBackgroundResource(R.mipmap.img_btn_tell_us_selected);
            }
        }

        @Override // com.ipotensic.potensicpro.utils.PhotoChooserUtil.OnChooseListener
        public void onChooseImage(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (!file.exists() || file.length() <= 0) {
                return;
            }
            NickNameActivity.this.layoutCrop.setVisibility(0);
            NickNameActivity.this.bitmapCropView.setBitmapForWidth(str, (NickNameActivity.this.getWindow().getDecorView().getWidth() * 7) / 10);
            NickNameActivity.this.findViewById(R.id.btn_sure).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.activities.NickNameActivity.4.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    NickNameActivity.this.bitmap = NickNameActivity.this.bitmapCropView.clip();
                    NickNameActivity.this.layoutCrop.setVisibility(8);
                    NickNameActivity.this.chooseImageBmp = NickNameActivity.this.bitmap;
                    NickNameActivity.this.headView.setImageBitmap(NickNameActivity.this.bitmap);
                    NickNameActivity.this.btnConfirm.setBackgroundResource(R.mipmap.img_btn_tell_us_selected);
                    NickNameActivity.this.isHeaderImgChange = true;
                }
            });
            NickNameActivity.this.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.activities.NickNameActivity.4.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    NickNameActivity.this.layoutCrop.setVisibility(8);
                    NickNameActivity.this.isHeaderImgChange = false;
                }
            });
        }
    };

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        setContentView(R.layout.activity_nick_name);
        initView();
    }

    private void initView() {
        this.layoutCrop = (ConstraintLayout) findViewById(R.id.layout_crop);
        this.bitmapCropView = (LikeQQCropView) findViewById(R.id.view_crop_bitmap);
        findViewById(R.id.btn_return).setOnClickListener(this);
        CircleImageView circleImageView = (CircleImageView) findViewById(R.id.img_head);
        this.headView = circleImageView;
        circleImageView.setOnClickListener(this);
        this.headView.setBorderColor(getResources().getColor(R.color.color_full_white));
        this.headView.setBorderWidth(UnitUtil.dp2px(3));
        loadHeadImg();
        TextView textView = (TextView) findViewById(R.id.btn_confirm);
        this.btnConfirm = textView;
        textView.setOnClickListener(this);
        EditText editText = (EditText) findViewById(R.id.et_nick);
        this.etNick = editText;
        editText.addTextChangedListener(new MyTextWatcher(this.etNick.getId()));
        showNickName();
    }

    private void showNickName() {
        if (PhoneConfig.usrToken != null) {
            String nickName = SPHelper.getInstance().getNickName(PhoneConfig.usrToken.getToken());
            if (nickName.equals("")) {
                if (PhoneConfig.usrToken.getNicname().equals("")) {
                    this.etNick.setHint(PhoneConfig.usrToken.getEmail());
                    return;
                } else {
                    this.etNick.setHint(PhoneConfig.usrToken.getNicname());
                    return;
                }
            }
            this.etNick.setHint(nickName);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_return) {
            finish();
            return;
        }
        if (id != R.id.btn_confirm) {
            if (id == R.id.img_head) {
                if (this.photoChooseDialog == null) {
                    this.photoChooseDialog = new PhotoChooseDialog(this, this.onChooseListener);
                }
                this.photoChooseDialog.show();
                return;
            }
            return;
        }
        String obj = this.etNick.getText().toString();
        this.nickName = obj;
        if (!TextUtils.isEmpty(obj) || this.isHeaderImgChange) {
            if (TextUtils.isEmpty(this.nickName)) {
                this.nickName = null;
            }
            uploadHeadImg(this.chooseImageBmp, this.nickName);
        }
    }

    public static void setEditTextInhibitInputSpaChat(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.ipotensic.potensicpro.activities.NickNameActivity.1
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (charSequence.equals(StringUtils.SPACE)) {
                    return "";
                }
                return null;
            }
        }});
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.ipotensic.potensicpro.activities.NickNameActivity.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (Pattern.compile("[`~!@#_$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）— +|{}【】‘；：”“’。，、？]").matcher(charSequence.toString()).find()) {
                    return "";
                }
                return null;
            }
        }});
    }

    class MyTextWatcher implements TextWatcher {
        int mViewId;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        MyTextWatcher(int i) {
            this.mViewId = i;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String trim = editable.toString().trim();
            if (trim.length() > 0) {
                NickNameActivity.this.etNick.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, NickNameActivity.this.getResources().getDrawable(R.mipmap.img_icon_nick_name_unlock), (Drawable) null);
                NickNameActivity.this.btnConfirm.setBackgroundResource(R.mipmap.img_btn_tell_us_selected);
            } else {
                NickNameActivity.this.etNick.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, NickNameActivity.this.getResources().getDrawable(R.mipmap.img_icon_nick_name_lock), (Drawable) null);
                if (NickNameActivity.this.bitmap == null) {
                    NickNameActivity.this.btnConfirm.setBackgroundResource(R.mipmap.img_btn_tell_us_normal);
                }
            }
            if (trim.length() > 22) {
                NickNameActivity.this.etNick.setText(trim.substring(0, 22));
                NickNameActivity.this.etNick.requestFocus();
                NickNameActivity.this.etNick.setSelection(NickNameActivity.this.etNick.getText().length());
            }
        }
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        PhotoChooseDialog photoChooseDialog = this.photoChooseDialog;
        if (photoChooseDialog != null) {
            photoChooseDialog.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        PhotoChooseDialog photoChooseDialog = this.photoChooseDialog;
        if (photoChooseDialog != null) {
            photoChooseDialog.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    private void loadHeadImg() {
        try {
            String headImageDescription = LocalFileManager.getInstance().getHeadImageDescription();
            if (PhoneConfig.usrToken != null && PhoneConfig.usrToken.getToken().equals(headImageDescription)) {
                Bitmap decodeFile = BitmapFactory.decodeFile(LocalFileManager.getInstance().getHeadImageLocalPath());
                this.chooseImageBmp = decodeFile;
                this.headView.setImageBitmap(decodeFile);
            } else if (PhoneConfig.usrToken != null) {
                new Thread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.NickNameActivity.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DDLog.i("download head img:" + PhoneConfig.usrToken.getAvatar());
                            final Bitmap bitmap = PicassoLoader.with(NickNameActivity.this).load(PhoneConfig.usrToken.getAvatar()).resize(250, 250).get();
                            if (bitmap != null) {
                                LocalFileManager.getInstance().saveHeaderBitmap(bitmap, PhoneConfig.usrToken.getToken());
                                if (NickNameActivity.this.isFinish) {
                                    return;
                                }
                                NickNameActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.NickNameActivity.3.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        NickNameActivity.this.chooseImageBmp = bitmap;
                                        NickNameActivity.this.headView.setImageBitmap(bitmap);
                                    }
                                });
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void test(String str) {
        byte[] bArr = new byte[1024];
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.close();
                    fileInputStream.close();
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void uploadHeadImg(final Bitmap bitmap, final String str) {
        String str2;
        boolean z;
        showLoadingDialog();
        if (bitmap != null) {
            str2 = getExternalCacheDir() + File.separator + "temp.jpg";
            z = FileUtil.saveBitmap(str2, bitmap);
        } else {
            str2 = null;
            z = false;
        }
        if (!z) {
            DDLog.e("保存头像失败");
        }
        if (PhoneConfig.usrToken != null) {
            UserRequestPresenter.getInstance().uploadHeadImage(PhoneConfig.usrToken, str, str2, new IUploadHeadImgView() { // from class: com.ipotensic.potensicpro.activities.NickNameActivity.5
                @Override // com.logan.user.view.IUploadHeadImgView
                public void onUploadSuccess() {
                    if (NickNameActivity.this.isFinish) {
                        return;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        SPHelper.getInstance().setNickName(PhoneConfig.usrToken.getToken(), str);
                    }
                    LocalFileManager.getInstance().saveHeaderBitmap(bitmap, PhoneConfig.usrToken.getToken());
                    NickNameActivity.this.headView.setImageBitmap(bitmap);
                    NickNameActivity.this.dismissLoadingDialog();
                    NickNameActivity nickNameActivity = NickNameActivity.this;
                    new GeneralDialog((Context) nickNameActivity, nickNameActivity.getString(R.string.dialog_success), NickNameActivity.this.getString(R.string.dialog_information_modify_success), R.mipmap.img_dialog_upgrade_success, true, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.potensicpro.activities.NickNameActivity.5.1
                        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                        public void confirm() {
                            if (bitmap != null) {
                                Intent intent = new Intent();
                                intent.putExtra("img_path", LocalFileManager.getInstance().getHeadImageLocalPath());
                                NickNameActivity.this.setResult(-1, intent);
                            }
                            NickNameActivity.this.finish();
                        }
                    }).show();
                }

                @Override // com.logan.user.view.IUploadHeadImgView
                public void onUploadFailed(String str3) {
                    if (NickNameActivity.this.isFinish) {
                        return;
                    }
                    NickNameActivity.this.dismissLoadingDialog();
                    DDLog.e("NickNameActivity error: " + str3);
                    if (str3.equals("")) {
                        NickNameActivity nickNameActivity = NickNameActivity.this;
                        new GeneralDialog((Context) nickNameActivity, nickNameActivity.getString(R.string.dialog_failure), NickNameActivity.this.getString(R.string.dialog_information_modify_failure), R.mipmap.img_dialog_failure, true, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.potensicpro.activities.NickNameActivity.5.2
                            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                            public void confirm() {
                            }
                        }).show();
                    } else {
                        NickNameActivity nickNameActivity2 = NickNameActivity.this;
                        new GeneralDialog((Context) nickNameActivity2, nickNameActivity2.getString(R.string.dialog_failure), NickNameActivity.this.getString(R.string.toast_no_network), R.mipmap.img_dialog_failure, true, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.potensicpro.activities.NickNameActivity.5.3
                            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                            public void confirm() {
                            }
                        }).show();
                    }
                }

                @Override // com.logan.user.view.IUploadHeadImgView
                public void onTokenError() {
                    if (NickNameActivity.this.isFinish) {
                        return;
                    }
                    NickNameActivity.this.dismissLoadingDialog();
                }
            });
        } else {
            dismissLoadingDialog();
            new GeneralDialog((Context) this, getString(R.string.dialog_failure), getString(R.string.dialog_information_modify_failure), R.mipmap.img_dialog_failure, true, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.potensicpro.activities.NickNameActivity.6
                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                public void confirm() {
                }
            }).show();
        }
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.isFinish = true;
    }
}
