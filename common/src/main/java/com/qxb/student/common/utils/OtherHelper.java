package com.qxb.student.common.utils;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.qxb.student.common.R;
import com.qxb.student.common.module.OtherRepository;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.module.bean.UserSchoolTeacher;
import com.qxb.student.common.rong.ExtensionModule;
import com.qxb.student.common.rong.msg.EvaluateInviteMsg;
import com.qxb.student.common.rong.msg.NoticeMsg;
import com.qxb.student.common.rong.msg.PhoneInviteMsg;
import com.qxb.student.common.rong.msg.PhoneMsg;
import com.qxb.student.common.rong.view.EvaluateView;
import com.qxb.student.common.rong.view.NoticeView;
import com.qxb.student.common.rong.view.PhoneInviteView;
import com.qxb.student.common.rong.view.PhoneView;
import com.qxb.student.common.view.dialog.ToastUtils;

import java.util.List;

import io.rong.imkit.DefaultExtensionModule;
import io.rong.imkit.IExtensionModule;
import io.rong.imkit.RongExtensionManager;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.UserInfo;

/**
 * @author winky
 * @date 2018/8/10
 */
public class OtherHelper {

    private static final Singleton<OtherHelper> SINGLETON = new Singleton<OtherHelper>() {
        @Override
        protected OtherHelper create() {
            return new OtherHelper();
        }
    };

    public static OtherHelper getInstance() {
        return SINGLETON.get();
    }

    private MutableLiveData<String> roomTokenLiveData = new MutableLiveData<>();

    private OtherRepository otherRepository = new OtherRepository();

    public void OnCleared() {
        roomTokenLiveData.removeObserver(tokenObs);
        roomTokenLiveData = null;
        otherRepository = null;
    }

    private OtherHelper() {
        roomTokenLiveData.observeForever(tokenObs);
    }


    public void initToken(String userId) {
        otherRepository.rongConnect(roomTokenLiveData, userId, false);
    }

    private void tokenSuccess() {
//        RongIM.getInstance().setSendMessageListener(sendMessageListener);
        User user = UserCache.getInstance().getUser();
        if (user == null) {
            return;
        }
        UserInfo userInfoInfo = new UserInfo(String.valueOf(user.getAccount_id()), user.getName(), Uri.parse(user.getPicRealPath()));
        RongIM.getInstance().setCurrentUserInfo(userInfoInfo);
        //设置用户信息随消息发送过来
        RongIM.getInstance().setMessageAttachedUserInfo(true);
        //设置融云连接状态监听
        RongIM.setConnectionStatusListener(connectionStatusListener);
        //设置数据提供
        RongIM.setUserInfoProvider(userInfoProvider, true);

        List<IExtensionModule> moduleList = RongExtensionManager.getInstance().getExtensionModules();
        if (moduleList != null) {
            for (IExtensionModule module : moduleList) {
                if (module instanceof DefaultExtensionModule) {
                    RongExtensionManager.getInstance().unregisterExtensionModule(module);
                    break;
                }
            }
        }
        RongExtensionManager.getInstance().registerExtensionModule(new ExtensionModule());
        //注册消息模板及对应视图
        RongIM.registerMessageType(EvaluateInviteMsg.class);
        RongIM.registerMessageType(NoticeMsg.class);
        RongIM.registerMessageType(PhoneMsg.class);
        RongIM.registerMessageType(PhoneInviteMsg.class);
        RongIM.registerMessageTemplate(new EvaluateView());
        RongIM.registerMessageTemplate(new NoticeView());
        RongIM.registerMessageTemplate(new PhoneView());
        RongIM.registerMessageTemplate(new PhoneInviteView());
        //扩展功能自定义
      /* InputProvider.ExtendProvider[] provider = {
               new ImageInputProvider(RongContext.getInstance()),//图片
                new CameraInputProvider(RongContext.getInstance()),//相机
        };
        RongIM.getInstance().resetInputExtensionProvider(Conversation.ConversationType.PRIVATE, provider);*/

    }

    private int connectCount = 0;
    private Observer<String> tokenObs = new Observer<String>() {
        @Override
        public void onChanged(@Nullable String token) {
            if (connectCount >= 3) {
                ToastUtils.toast(R.string.hint_room_failed);
                roomTokenLiveData.removeObserver(tokenObs);
                return;
            }
            RongIM.connect(token, new RongIMClient.ConnectCallback() {
                /**
                 * Token 错误，在线上环境下主要是因为 Token 已经过期，您需要向 App Server 重新请求一个新的 Token
                 */
                @Override
                public void onTokenIncorrect() {
                    connectCount++;
                    otherRepository.rongConnect(roomTokenLiveData, UserCache.getInstance().getAccountId(), true);
                }

                /**
                 * 连接融云成功
                 * @param userid 当前 token
                 */
                @Override
                public void onSuccess(String userid) {
                    tokenSuccess();
                }

                /**
                 * 连接融云失败
                 * @param errorCode 错误码，可到官网 查看错误码对应的注释
                 *                  http://www.rongcloud.cn/docs/android.html#常见错误码
                 */
                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {
                }
            });
        }
    };

    private RongIMClient.ConnectionStatusListener connectionStatusListener = new RongIMClient.ConnectionStatusListener() {
        @Override
        public void onChanged(ConnectionStatus connectionStatus) {
            switch (connectionStatus) {
                //连接成功。
                case CONNECTED:
                    break;
                //断开连接。
                case DISCONNECTED:
                    break;
                //连接中。
                case CONNECTING:
                    break;
                //网络不可用。
                case NETWORK_UNAVAILABLE:
                    break;
                //用户账户在其他设备登录，本机会被踢掉线
                case KICKED_OFFLINE_BY_OTHER_CLIENT:
                    RongIM.getInstance().logout();
                    LibControl.getInstance().logout();
                    break;
            }
        }
    };

    private RongIM.UserInfoProvider userInfoProvider = new RongIM.UserInfoProvider() {
        @Override
        public UserInfo getUserInfo(String userId) {
            final MutableLiveData<UserSchoolTeacher> liveData = new MutableLiveData<>();
            liveData.observeForever(new Observer<UserSchoolTeacher>() {
                @Override
                public void onChanged(@Nullable UserSchoolTeacher teacher) {
                    liveData.removeObserver(this);
                    if (teacher != null) {
                        UserInfo userInfo = new UserInfo(String.valueOf(teacher.getAccount_id()), teacher.getName(), Uri.parse(teacher.getPicRealPath()));
                        RongIM.getInstance().refreshUserInfoCache(userInfo);
                    }
                }
            });
            return null;
        }
    };
}
