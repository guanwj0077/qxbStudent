package com.qxb.student.common.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.qxb.student.common.R;
import com.qxb.student.common.module.bean.User;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;

public class MobUtils {

    private static final Singleton<MobUtils> SINGLETON = new Singleton<MobUtils>() {
        @Override
        protected MobUtils create() {
            return new MobUtils();
        }
    };

    public static MobUtils getInstance() {
        return SINGLETON.get();
    }

//    public static void share(Activity context, AppShareParam shareParam) {
//        OnekeyShare oks = new OnekeyShare();
//        //关闭sso授权
//        oks.disableSSOWhenAuthorize();
//        oks.setSilent(true);
//        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
//        oks.setTitle(shareParam.getTitle());
//        // titleUrl是标题的网络链接，QQ和QQ空间等使用
//        oks.setTitleUrl(shareParam.getTitleUrl());
//        // text是分享文本，所有平台都需要这个字段
//        oks.setText(shareParam.getText());
//        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
//        oks.setImageUrl(shareParam.getImageUrl());
//        // url仅在微信（包括好友和朋友圈）中使用
//        oks.setUrl(shareParam.getTitleUrl());
//        // 设置自定义的外部回调
//        oks.setCallback(new OnPlatformActionListener(context, shareParam, new OnShareCallbackListener() {
//            @Override
//            public void onComplete(Activity activity, AppShareParam param) {
//                if (TextUtils.isEmpty(param.getSource())) {
//                    return;
//                }
//                shareCount(activity, param.getSource());
//            }
//
//            @Override
//            public void onError(Activity activity, AppShareParam param) {
//
//            }
//
//            @Override
//            public void onCancel(Activity activity, AppShareParam param) {
//
//            }
//        }));
//        // 启动分享GUI
//        oks.show(context);
//    }

    public static void shareCount(final Activity context, String source) {
//        User user = LiteOrmUtil.getCurUser();
//        if (user == null) {
//            LoginActivity.start(context, null);
//            return;
//        }
//        Map<String, String> params = new HashMap<>();
//        params.put("account_id", String.valueOf(user.getAccount_id()));
//        params.put("type", source);
//        HttpManager.postAsyn(Api.ORDER_SHARE_COUNT, new HttpManager.StringCallback() {
//            @Override
//            public void onFailure(Request request, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(String response) {
//                ApiModel apiModel = FastOk.get(response, ApiModel.class);
//                if (apiModel.getCODE() == 1) {
//                    ShareResult result = FastOk.get(apiModel.getData().toString(), ShareResult.class);
//                    if (result != null && result.isResult()) {
//                        showDialog(context, result);
//                    }
//                } else {
//                    ToastUtils.show(apiModel.getMsg());
//                }
//            }
//        }, params);
    }

//    private static void showDialog(final Activity activity, ShareResult result) {
//        final Dialog dialog = new Dialog(activity, R.style.MyDialogStyleTop2);
//        dialog.setContentView(R.layout.view_integral_hint);
//        TextView textView = (TextView) dialog.findViewById(R.id.hint_text);
//        TextView iknow = (TextView) dialog.findViewById(R.id.iknow);
//        iknow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//        User user = LiteOrmUtil.getCurUser();
//        if (user != null) {
//            user.setIntegral(user.getIntegral() + result.getAddIntegral());
//            LiteOrmUtil.update(user);
//        }
//        textView.setText(makeKeyword(activity, String.valueOf(result.getAddIntegral())));
//        dialog.setCanceledOnTouchOutside(true);//设置点击旁边，关闭dialog
//        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
//        dialog.show();
//    }

    public static SpannableString makeKeyword(Context context, String content) {
        SpannableString styledText = new SpannableString("分享成功！您已获得" + content + "积分");
        int end = styledText.length() - 2;
//        styledText.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.f9ae38)), end - content.length(), end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        styledText.setSpan(new AbsoluteSizeSpan(38), end - content.length(), end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return styledText;
    }

    public void grantAuth() {
        Platform qq = ShareSDK.getPlatform(QQ.NAME);
//        if (weibo.isAuthValid()) {
//            weibo.removeAccount(true);//执行此操作就可以移除掉本地授权状态和授权信息
//        }
        qq.SSOSetting(false);//设置false表示使用SSO授权方式
//回调信息，可以在这里获取基本的授权返回的信息，但是注意如果做提示和UI操作要传到主线程handler里去执行
        qq.setPlatformActionListener(new PlatformActionListener() {

            @Override
            public void onError(Platform arg0, int arg1, Throwable arg2) {
                // TODO Auto-generated method stub
                arg2.printStackTrace();
            }

            @Override
            public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
                // TODO Auto-generated method stub
                //输出所有授权信息
                arg0.getDb().exportData();
            }

            @Override
            public void onCancel(Platform arg0, int arg1) {
                // TODO Auto-generated method stub

            }
        });
//authorize与showUser单独调用一个即可
        qq.authorize();//要功能不要数据，在监听oncomplete中不会返回用户数据
    }

}
