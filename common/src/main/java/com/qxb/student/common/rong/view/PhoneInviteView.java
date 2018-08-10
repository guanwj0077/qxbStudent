package com.qxb.student.common.rong.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qxb.student.common.R;
import com.qxb.student.common.module.OtherRepository;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.rong.SendMessageCallback;
import com.qxb.student.common.rong.msg.NoticeMsg;
import com.qxb.student.common.rong.msg.PhoneInviteMsg;
import com.qxb.student.common.rong.msg.PhoneMsg;
import com.qxb.student.common.utils.UserCache;

import io.rong.imkit.RongIM;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;

/**
 * 要电话
 * Created by winky on 2017/12/21.
 */
@ProviderTag(messageContent = PhoneInviteMsg.class, showSummaryWithName = false)
public class PhoneInviteView extends IContainerItemProvider.MessageProvider<PhoneInviteMsg> {

    private static final String IS_EDIT = "1";

    private void setDisable(ViewHolder holder) {
        holder.text1.setBackgroundResource(R.drawable.shape_gray);
        holder.text1.setOnClickListener(null);
        holder.text2.setOnClickListener(null);
        holder.text1.setEnabled(false);
        holder.text2.setEnabled(false);
    }

    @Override
    public void bindView(View view, int i, final PhoneInviteMsg phoneInviteMsg, final UIMessage uiMessage) {
        final ViewHolder holder = (ViewHolder) view.getTag();
        if (IS_EDIT.equals(uiMessage.getExtra())) {
            setDisable(holder);
        } else {
            holder.text1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RongIM.getInstance().setMessageExtra(uiMessage.getMessageId(), IS_EDIT, null);
                    User user = UserCache.getInstance().getUser();
                    RongIM.getInstance().sendMessage(
                            Message.obtain(uiMessage.getTargetId(), Conversation.ConversationType.PRIVATE,
                                    new PhoneMsg(user.getName(), user.getTelphone())),
                            String.format(v.getContext().getString(R.string.hint_phone_exchange_push_failed), user.getName()), null, new SendMessageCallback());
                    exchangePhone(uiMessage);
                    setDisable(holder);
                }
            });
            holder.text2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RongIM.getInstance().setMessageExtra(uiMessage.getMessageId(), IS_EDIT, null);
                    NoticeMsg noticeMsg = new NoticeMsg();
                    noticeMsg.setOwnContent(v.getContext().getString(R.string.hint_me_phone_reject));
                    noticeMsg.setTagetContent(v.getContext().getString(R.string.hint_other_phone_reject));
                    User user = UserCache.getInstance().getUser();
                    RongIM.getInstance().sendMessage(
                            Message.obtain(uiMessage.getTargetId(), Conversation.ConversationType.PRIVATE, noticeMsg),
                            String.format(v.getContext().getString(R.string.hint_phone_exchange_push_success), user.getName()),
                            null, new SendMessageCallback()
                    );
                    setDisable(holder);
                }
            });
        }
    }

    private void exchangePhone(UIMessage uiMessage) {
        new OtherRepository().exchangePhone(uiMessage.getSenderUserId());
    }

    @Override
    public Spannable getContentSummary(PhoneInviteMsg phoneInviteMsg) {
        return null;
    }

    @Override
    public void onItemClick(View view, int i, PhoneInviteMsg phoneInviteMsg, UIMessage uiMessage) {

    }

    @Override
    public void onItemLongClick(View view, int i, PhoneInviteMsg phoneInviteMsg, UIMessage uiMessage) {

    }

    @Override
    public View newView(Context context, ViewGroup viewGroup) {
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(context).inflate(R.layout.view_rong_phone_invite, null);
        ViewHolder holder = new ViewHolder();
        holder.text1 = view.findViewById(R.id.text1);
        holder.text2 = view.findViewById(R.id.text2);
        view.setTag(holder);
        return view;
    }

    class ViewHolder {
        TextView text1;
        TextView text2;
    }
}

