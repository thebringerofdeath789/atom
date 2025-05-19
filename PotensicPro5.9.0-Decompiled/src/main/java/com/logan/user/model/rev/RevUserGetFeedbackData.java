package com.logan.user.model.rev;

import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes3.dex */
public class RevUserGetFeedbackData extends BaseUserRevData {
    private int code;
    private List<FeedbackInfo> list;

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public List<FeedbackInfo> getList() {
        return this.list;
    }

    public void setList(List<FeedbackInfo> list) {
        this.list = list;
    }

    public RevUserGetFeedbackData parse(String str) {
        JSONArray jSONArray;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        JSONObject parseObject = JSONObject.parseObject(str);
        this.code = parseObject.getIntValue("code");
        if (this.list == null) {
            this.list = new ArrayList();
        }
        this.list.clear();
        if (this.code == 0 && (jSONArray = parseObject.getJSONArray("data")) != null && jSONArray.size() > 0) {
            int i = 0;
            while (i < jSONArray.size()) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                FeedbackInfo feedbackInfo = new FeedbackInfo();
                String str9 = TtmlNode.ATTR_ID;
                feedbackInfo.setId(jSONObject.getIntValue(TtmlNode.ATTR_ID));
                String str10 = "content";
                feedbackInfo.setContent(jSONObject.getString("content"));
                String str11 = "pic1";
                feedbackInfo.setPic1(jSONObject.getString("pic1"));
                feedbackInfo.setPic2(jSONObject.getString("pic2"));
                feedbackInfo.setPic3(jSONObject.getString("pic3"));
                feedbackInfo.setPic4(jSONObject.getString("pic4"));
                feedbackInfo.setPic5(jSONObject.getString("pic5"));
                feedbackInfo.setPic6(jSONObject.getString("pic6"));
                String str12 = "uid";
                feedbackInfo.setUid(jSONObject.getIntValue("uid"));
                feedbackInfo.setState_user(jSONObject.getIntValue("state_user"));
                JSONArray jSONArray2 = jSONArray;
                feedbackInfo.setIntime(jSONObject.getString("intime"));
                int i2 = i;
                feedbackInfo.setStatus(jSONObject.getIntValue(NotificationCompat.CATEGORY_STATUS));
                String str13 = "state_user";
                feedbackInfo.setBrand(jSONObject.getString("brand"));
                String str14 = "brand";
                feedbackInfo.setDevicever(jSONObject.getString("devicever"));
                String str15 = "devicever";
                feedbackInfo.setAppver(jSONObject.getString("appver"));
                String str16 = "appver";
                feedbackInfo.setIp(jSONObject.getString(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP));
                String str17 = IjkMediaPlayer.OnNativeInvokeListener.ARG_IP;
                feedbackInfo.setIsbase64(jSONObject.getIntValue("isbase64"));
                String str18 = "isbase64";
                feedbackInfo.setState(jSONObject.getIntValue("state"));
                String str19 = "state";
                feedbackInfo.setFid(jSONObject.getIntValue("fid"));
                String str20 = "fid";
                feedbackInfo.setHuifucontent(jSONObject.getString("huifucontent"));
                feedbackInfo.setHtime(jSONObject.getString("htime"));
                feedbackInfo.setHusername(jSONObject.getString("husername"));
                feedbackInfo.setPic_url1(jSONObject.getString("pic_url1"));
                feedbackInfo.setPic_url2(jSONObject.getString("pic_url2"));
                feedbackInfo.setPic_url3(jSONObject.getString("pic_url3"));
                feedbackInfo.setVideo_url(jSONObject.getString("video_url"));
                feedbackInfo.setFile_url(jSONObject.getString("file_url"));
                feedbackInfo.setType(jSONObject.getIntValue("type"));
                feedbackInfo.setProduct_class(jSONObject.getString("product_class"));
                feedbackInfo.setLeve(jSONObject.getIntValue("leve"));
                feedbackInfo.setVideo_pos(jSONObject.getIntValue("video_pos"));
                feedbackInfo.setVideo_thumbnail(jSONObject.getString("video_thumbnail"));
                JSONArray jSONArray3 = jSONObject.getJSONArray("pic_array");
                if (jSONArray3 == null || jSONArray3.size() <= 0) {
                    str2 = NotificationCompat.CATEGORY_STATUS;
                    str3 = "intime";
                    str4 = "uid";
                    str5 = "huifucontent";
                } else {
                    str5 = "huifucontent";
                    List<PictureBean> pictureList = feedbackInfo.getPictureList();
                    str2 = NotificationCompat.CATEGORY_STATUS;
                    str3 = "intime";
                    int i3 = 0;
                    while (i3 < jSONArray3.size()) {
                        JSONObject jSONObject2 = jSONArray3.getJSONObject(i3);
                        JSONArray jSONArray4 = jSONArray3;
                        PictureBean pictureBean = new PictureBean();
                        pictureBean.setPic(jSONObject2.getString("pic"));
                        pictureBean.setThumb(jSONObject2.getString("thumb"));
                        pictureList.add(pictureBean);
                        i3++;
                        jSONArray3 = jSONArray4;
                        str12 = str12;
                    }
                    str4 = str12;
                    feedbackInfo.setPictureList(pictureList);
                }
                JSONArray jSONArray5 = jSONObject.getJSONArray("reply_info");
                if (jSONArray5 != null && jSONArray5.size() > 0) {
                    List<CustomerReplyInfo> replyInfoList = feedbackInfo.getReplyInfoList();
                    int i4 = 0;
                    while (i4 < jSONArray5.size()) {
                        JSONObject jSONObject3 = jSONArray5.getJSONObject(i4);
                        CustomerReplyInfo customerReplyInfo = new CustomerReplyInfo();
                        customerReplyInfo.setId(jSONObject3.getIntValue(str9));
                        customerReplyInfo.setContent(jSONObject3.getString(str10));
                        customerReplyInfo.setPic1(jSONObject3.getString(str11));
                        customerReplyInfo.setPic2(jSONObject3.getString("pic2"));
                        customerReplyInfo.setPic3(jSONObject3.getString("pic3"));
                        customerReplyInfo.setPic4(jSONObject3.getString("pic4"));
                        customerReplyInfo.setPic5(jSONObject3.getString("pic5"));
                        customerReplyInfo.setPic6(jSONObject3.getString("pic6"));
                        JSONArray jSONArray6 = jSONArray5;
                        String str21 = str4;
                        customerReplyInfo.setUid(jSONObject3.getIntValue(str21));
                        String str22 = str3;
                        String str23 = str9;
                        customerReplyInfo.setIntime(jSONObject3.getString(str22));
                        String str24 = str2;
                        customerReplyInfo.setStatus(jSONObject3.getIntValue(str24));
                        String str25 = str14;
                        customerReplyInfo.setBrand(jSONObject3.getString(str25));
                        String str26 = str15;
                        customerReplyInfo.setDevicever(jSONObject3.getString(str26));
                        String str27 = str16;
                        customerReplyInfo.setAppver(jSONObject3.getString(str27));
                        String str28 = str17;
                        customerReplyInfo.setIp(jSONObject3.getString(str28));
                        String str29 = str18;
                        customerReplyInfo.setIsbase64(jSONObject3.getIntValue(str29));
                        String str30 = str19;
                        customerReplyInfo.setState(jSONObject3.getIntValue(str30));
                        String str31 = str20;
                        customerReplyInfo.setFid(jSONObject3.getIntValue(str31));
                        String str32 = str5;
                        customerReplyInfo.setHuifucontent(jSONObject3.getString(str32));
                        customerReplyInfo.setHtime(jSONObject3.getString("htime"));
                        customerReplyInfo.setHusername(jSONObject3.getString("husername"));
                        customerReplyInfo.setCtime_str(jSONObject3.getIntValue("ctime_str"));
                        customerReplyInfo.setType(jSONObject3.getIntValue("type"));
                        customerReplyInfo.setVideo_url(jSONObject3.getString("video_url"));
                        customerReplyInfo.setFile_url(jSONObject3.getString("file_url"));
                        customerReplyInfo.setPic_url1(jSONObject3.getString("pic_url1"));
                        customerReplyInfo.setPic_url2(jSONObject3.getString("pic_url2"));
                        customerReplyInfo.setPic_url3(jSONObject3.getString("pic_url3"));
                        String str33 = str13;
                        customerReplyInfo.setState_user(jSONObject3.getIntValue(str33));
                        customerReplyInfo.setProduct_class(jSONObject3.getString("product_class"));
                        customerReplyInfo.setLeve(jSONObject3.getIntValue("leve"));
                        customerReplyInfo.setVideo_pos(jSONObject3.getIntValue("video_pos"));
                        customerReplyInfo.setVideo_thumbnail(jSONObject3.getString("video_thumbnail"));
                        replyInfoList.add(customerReplyInfo);
                        JSONArray jSONArray7 = jSONObject3.getJSONArray("pic_array");
                        if (jSONArray7 == null || jSONArray7.size() <= 0) {
                            str6 = str33;
                            str7 = str10;
                            str8 = str11;
                        } else {
                            List<PictureBean> pictureList2 = customerReplyInfo.getPictureList();
                            str6 = str33;
                            str7 = str10;
                            int i5 = 0;
                            while (i5 < jSONArray7.size()) {
                                JSONObject jSONObject4 = jSONArray7.getJSONObject(i5);
                                JSONArray jSONArray8 = jSONArray7;
                                PictureBean pictureBean2 = new PictureBean();
                                pictureBean2.setPic(jSONObject4.getString("pic"));
                                pictureBean2.setThumb(jSONObject4.getString("thumb"));
                                pictureList2.add(pictureBean2);
                                i5++;
                                jSONArray7 = jSONArray8;
                                str11 = str11;
                            }
                            str8 = str11;
                            customerReplyInfo.setPictureList(pictureList2);
                        }
                        replyInfoList.add(customerReplyInfo);
                        i4++;
                        str9 = str23;
                        jSONArray5 = jSONArray6;
                        str10 = str7;
                        str11 = str8;
                        str3 = str22;
                        str2 = str24;
                        str14 = str25;
                        str15 = str26;
                        str16 = str27;
                        str17 = str28;
                        str18 = str29;
                        str19 = str30;
                        str20 = str31;
                        str5 = str32;
                        str13 = str6;
                        str4 = str21;
                    }
                }
                this.list.add(feedbackInfo);
                i = i2 + 1;
                jSONArray = jSONArray2;
            }
        }
        return this;
    }

    public static class PictureBean implements Serializable {
        String pic;
        String thumb;

        public String getPic() {
            return this.pic;
        }

        public void setPic(String str) {
            this.pic = str;
        }

        public String getThumb() {
            return this.thumb;
        }

        public void setThumb(String str) {
            this.thumb = str;
        }
    }

    public static class FeedbackInfo implements Serializable {
        private String appver;
        private String brand;
        private String content;
        private String devicever;
        private int fid;
        private String file_url;
        private String htime;
        private String huifucontent;
        private String husername;
        private int id;
        private String intime;
        private String ip;
        private boolean isSelected;
        private int isbase64;
        private int leve;
        private String pic1;
        private String pic2;
        private String pic3;
        private String pic4;
        private String pic5;
        private String pic6;
        private String pic_url1;
        private String pic_url2;
        private String pic_url3;
        private List<PictureBean> pictureList;
        private String product_class;
        private List<CustomerReplyInfo> replyInfoList;
        private int state;
        private int state_user;
        private int status;
        private int type;
        private int uid;
        private int video_pos;
        private String video_thumbnail;
        private String video_url;

        public int getVideo_pos() {
            return this.video_pos;
        }

        public void setVideo_pos(int i) {
            this.video_pos = i;
        }

        public String getVideo_thumbnail() {
            return this.video_thumbnail;
        }

        public void setVideo_thumbnail(String str) {
            this.video_thumbnail = str;
        }

        public boolean isSelected() {
            return this.isSelected;
        }

        public void setSelected(boolean z) {
            this.isSelected = z;
        }

        public int getId() {
            return this.id;
        }

        public void setId(int i) {
            this.id = i;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public String getPic1() {
            return this.pic1;
        }

        public void setPic1(String str) {
            this.pic1 = str;
        }

        public String getPic2() {
            return this.pic2;
        }

        public void setPic2(String str) {
            this.pic2 = str;
        }

        public String getPic3() {
            return this.pic3;
        }

        public void setPic3(String str) {
            this.pic3 = str;
        }

        public String getPic4() {
            return this.pic4;
        }

        public void setPic4(String str) {
            this.pic4 = str;
        }

        public String getPic5() {
            return this.pic5;
        }

        public void setPic5(String str) {
            this.pic5 = str;
        }

        public String getPic6() {
            return this.pic6;
        }

        public void setPic6(String str) {
            this.pic6 = str;
        }

        public int getUid() {
            return this.uid;
        }

        public void setUid(int i) {
            this.uid = i;
        }

        public String getIntime() {
            return this.intime;
        }

        public void setIntime(String str) {
            this.intime = str;
        }

        public int getState_user() {
            return this.state_user;
        }

        public void setState_user(int i) {
            this.state_user = i;
        }

        public int getState() {
            return this.state;
        }

        public void setState(int i) {
            this.state = i;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int i) {
            this.status = i;
        }

        public String getBrand() {
            return this.brand;
        }

        public void setBrand(String str) {
            this.brand = str;
        }

        public String getDevicever() {
            return this.devicever;
        }

        public void setDevicever(String str) {
            this.devicever = str;
        }

        public String getAppver() {
            return this.appver;
        }

        public void setAppver(String str) {
            this.appver = str;
        }

        public String getIp() {
            return this.ip;
        }

        public void setIp(String str) {
            this.ip = str;
        }

        public int getIsbase64() {
            return this.isbase64;
        }

        public void setIsbase64(int i) {
            this.isbase64 = i;
        }

        public int getFid() {
            return this.fid;
        }

        public void setFid(int i) {
            this.fid = i;
        }

        public String getHuifucontent() {
            return this.huifucontent;
        }

        public void setHuifucontent(String str) {
            this.huifucontent = str;
        }

        public String getHtime() {
            return this.htime;
        }

        public void setHtime(String str) {
            this.htime = str;
        }

        public String getHusername() {
            return this.husername;
        }

        public void setHusername(String str) {
            this.husername = str;
        }

        public String getPic_url1() {
            return this.pic_url1;
        }

        public void setPic_url1(String str) {
            this.pic_url1 = str;
        }

        public String getPic_url2() {
            return this.pic_url2;
        }

        public void setPic_url2(String str) {
            this.pic_url2 = str;
        }

        public String getPic_url3() {
            return this.pic_url3;
        }

        public void setPic_url3(String str) {
            this.pic_url3 = str;
        }

        public String getVideo_url() {
            return this.video_url;
        }

        public void setVideo_url(String str) {
            this.video_url = str;
        }

        public String getFile_url() {
            return this.file_url;
        }

        public void setFile_url(String str) {
            this.file_url = str;
        }

        public int getType() {
            return this.type;
        }

        public void setType(int i) {
            this.type = i;
        }

        public String getProduct_class() {
            return this.product_class;
        }

        public void setProduct_class(String str) {
            this.product_class = str;
        }

        public int getLeve() {
            return this.leve;
        }

        public void setLeve(int i) {
            this.leve = i;
        }

        public List<PictureBean> getPictureList() {
            if (this.pictureList == null) {
                this.pictureList = new ArrayList();
            }
            return this.pictureList;
        }

        public void setPictureList(List<PictureBean> list) {
            this.pictureList = list;
        }

        public List<CustomerReplyInfo> getReplyInfoList() {
            if (this.replyInfoList == null) {
                this.replyInfoList = new ArrayList();
            }
            return this.replyInfoList;
        }

        public void setReplyInfoList(List<CustomerReplyInfo> list) {
            this.replyInfoList = list;
        }
    }

    public class CustomerReplyInfo implements Serializable {
        private String appver;
        private String brand;
        private String content;
        private int ctime_str;
        private String devicever;
        private int fid;
        private String file_url;
        private String htime;
        private String huifucontent;
        private String husername;
        private int id;
        private String intime;
        private String ip;
        private int isbase64;
        private int leve;
        private String pic1;
        private String pic2;
        private String pic3;
        private String pic4;
        private String pic5;
        private String pic6;
        private String pic_url1;
        private String pic_url2;
        private String pic_url3;
        private List<PictureBean> pictureList;
        private String product_class;
        private int state;
        private int state_user;
        private int status;
        private int type;
        private int uid;
        private int video_pos;
        private String video_thumbnail;
        private String video_url;

        public CustomerReplyInfo() {
        }

        public int getVideo_pos() {
            return this.video_pos;
        }

        public void setVideo_pos(int i) {
            this.video_pos = i;
        }

        public String getVideo_thumbnail() {
            return this.video_thumbnail;
        }

        public void setVideo_thumbnail(String str) {
            this.video_thumbnail = str;
        }

        public String getProduct_class() {
            return this.product_class;
        }

        public void setProduct_class(String str) {
            this.product_class = str;
        }

        public int getLeve() {
            return this.leve;
        }

        public void setLeve(int i) {
            this.leve = i;
        }

        public int getState_user() {
            return this.state_user;
        }

        public void setState_user(int i) {
            this.state_user = i;
        }

        public int getId() {
            return this.id;
        }

        public void setId(int i) {
            this.id = i;
        }

        public int getFid() {
            return this.fid;
        }

        public void setFid(int i) {
            this.fid = i;
        }

        public String getHuifucontent() {
            return this.huifucontent;
        }

        public void setHuifucontent(String str) {
            this.huifucontent = str;
        }

        public String getHtime() {
            return this.htime;
        }

        public void setHtime(String str) {
            this.htime = str;
        }

        public String getHusername() {
            return this.husername;
        }

        public void setHusername(String str) {
            this.husername = str;
        }

        public int getState() {
            return this.state;
        }

        public void setState(int i) {
            this.state = i;
        }

        public String getPic_url1() {
            return this.pic_url1;
        }

        public void setPic_url1(String str) {
            this.pic_url1 = str;
        }

        public String getPic_url2() {
            return this.pic_url2;
        }

        public void setPic_url2(String str) {
            this.pic_url2 = str;
        }

        public String getPic_url3() {
            return this.pic_url3;
        }

        public void setPic_url3(String str) {
            this.pic_url3 = str;
        }

        public String getVideo_url() {
            return this.video_url;
        }

        public void setVideo_url(String str) {
            this.video_url = str;
        }

        public String getFile_url() {
            return this.file_url;
        }

        public void setFile_url(String str) {
            this.file_url = str;
        }

        public int getUid() {
            return this.uid;
        }

        public void setUid(int i) {
            this.uid = i;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public String getPic1() {
            return this.pic1;
        }

        public void setPic1(String str) {
            this.pic1 = str;
        }

        public String getPic2() {
            return this.pic2;
        }

        public void setPic2(String str) {
            this.pic2 = str;
        }

        public String getPic3() {
            return this.pic3;
        }

        public void setPic3(String str) {
            this.pic3 = str;
        }

        public String getPic4() {
            return this.pic4;
        }

        public void setPic4(String str) {
            this.pic4 = str;
        }

        public String getPic5() {
            return this.pic5;
        }

        public void setPic5(String str) {
            this.pic5 = str;
        }

        public String getPic6() {
            return this.pic6;
        }

        public void setPic6(String str) {
            this.pic6 = str;
        }

        public String getIntime() {
            return this.intime;
        }

        public void setIntime(String str) {
            this.intime = str;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int i) {
            this.status = i;
        }

        public String getBrand() {
            return this.brand;
        }

        public void setBrand(String str) {
            this.brand = str;
        }

        public String getDevicever() {
            return this.devicever;
        }

        public void setDevicever(String str) {
            this.devicever = str;
        }

        public String getAppver() {
            return this.appver;
        }

        public void setAppver(String str) {
            this.appver = str;
        }

        public String getIp() {
            return this.ip;
        }

        public void setIp(String str) {
            this.ip = str;
        }

        public int getIsbase64() {
            return this.isbase64;
        }

        public void setIsbase64(int i) {
            this.isbase64 = i;
        }

        public int getType() {
            return this.type;
        }

        public void setType(int i) {
            this.type = i;
        }

        public int getCtime_str() {
            return this.ctime_str;
        }

        public void setCtime_str(int i) {
            this.ctime_str = i;
        }

        public List<PictureBean> getPictureList() {
            if (this.pictureList == null) {
                this.pictureList = new ArrayList();
            }
            return this.pictureList;
        }

        public void setPictureList(List<PictureBean> list) {
            this.pictureList = list;
        }
    }
}
