package com.qxb.student.common.rong;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.qxb.student.common.R;
import com.qxb.student.common.basics.BaseAppActivity;
import com.qxb.student.common.module.bean.attr.ChatAttr;
import com.qxb.student.common.utils.UserCache;
import com.qxb.student.common.view.Toolbar;

import java.util.List;

import io.rong.imkit.RongIM;
import io.rong.imkit.fragment.ConversationFragment;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.message.TextMessage;

/**
 * 融云聊天页面
 *
 * @author winky
 * @date 2018/8/10
 */
public class ChatActivity extends BaseAppActivity {

    /**
     * 聊天入参
     */
    private ChatAttr chatAttr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        chatAttr = getIntent().getParcelableExtra(ChatAttr.TAG);
        if (chatAttr == null) {
            finish();
            return;
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(chatAttr.getTitle() + "\n" + chatAttr.getSchoolName());


        enterFragment(chatAttr.getTargetId());

        try {
            RongIMClient.getInstance().getHistoryMessages(Conversation.ConversationType.PRIVATE, chatAttr.getTargetId(), -1, 10, new RongIMClient.ResultCallback<List<Message>>() {
                @Override
                public void onSuccess(List<Message> messages) {
                    //如果聊天内容为空则发送问候
                    if (messages.size() == 0) {
                        TextMessage textMessage = TextMessage.obtain(getString(R.string.hint_chat_hello));
                        Message message = Message.obtain(UserCache.getInstance().getAccountId(), Conversation.ConversationType.PRIVATE, textMessage);
                        RongIM.getInstance().sendMessage(message, null, null, new SendMessageCallback());
//                        RongIM.getInstance().insertIncomingMessage(Conversation.ConversationType.PRIVATE, chatAttr.getTargetId(), chatAttr.getTargetId(), new Message.ReceivedStatus(1), textMessage, null);
                    }
                }

                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {

                }
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * 加载会话页面 ConversationFragment
     *
     * @param targetId 目标 Id
     */
    private void enterFragment(String targetId) {
        ConversationFragment fragment = (ConversationFragment) getSupportFragmentManager().findFragmentById(R.id.conversation);
        Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName)
                .buildUpon().appendPath("conversation")
                .appendPath(Conversation.ConversationType.PRIVATE.getName().toLowerCase())
                .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false") //设置私聊会话非聚合显示
                .appendQueryParameter("targetId", targetId)
                .build();
        fragment.setUri(uri);
    }
}
