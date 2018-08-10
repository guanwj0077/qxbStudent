package com.qxb.student.common.rong.view;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qxb.student.common.R;
import com.qxb.student.common.module.OtherRepository;
import com.qxb.student.common.rong.SendMessageCallback;
import com.qxb.student.common.rong.msg.EvaluateInviteMsg;
import com.qxb.student.common.rong.msg.NoticeMsg;
import com.qxb.student.common.utils.UserCache;
import com.qxb.student.common.view.dialog.ToastUtils;

import io.rong.imkit.RongIM;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;

/**
 * 邀请评价
 * Created by winky on 2017/12/21.
 */
@ProviderTag(messageContent = EvaluateInviteMsg.class, showSummaryWithName = false)
public class EvaluateView extends IContainerItemProvider.MessageProvider<EvaluateInviteMsg> {

    private static final String IS_EDIT = "1";

    @Override
    public void bindView(View view, int i, EvaluateInviteMsg evaluateInviteMsg, final UIMessage uiMessage) {
        final ViewHolder holder = (ViewHolder) view.getTag();
        if (IS_EDIT.equals(uiMessage.getExtra())) {
            setDisable(holder);
        } else {
            holder.text1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    evaluate(holder, uiMessage);
                }
            });
            holder.text2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    noitce(holder, uiMessage);
                }
            });
        }
    }

    private void evaluate(final ViewHolder holder, final UIMessage uiMessage) {
        if (uiMessage.getEvaluated()) {
            ToastUtils.toast(R.string.hint_evaluation_ago);
        } else {
            MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
            mutableLiveData.observeForever(new Observer<Boolean>() {
                @Override
                public void onChanged(@Nullable Boolean aBoolean) {
                    noitce(holder, uiMessage);
                }
            });
            new OtherRepository().evaluateTeacher(mutableLiveData, uiMessage.getSenderUserId());
        }
    }

    private void noitce(ViewHolder holder, UIMessage uiMessage) {
        Context context = holder.text1.getContext();
        RongIM.getInstance().setMessageExtra(uiMessage.getMessageId(), IS_EDIT, null);
        NoticeMsg noticeMsg = new NoticeMsg();
        noticeMsg.setOwnContent(context.getString(R.string.hint_me_evaluation));
        noticeMsg.setTagetContent(context.getString(R.string.hint_other_evaluation));
        String push = String.format(context.getString(R.string.hint_evaluation_push), UserCache.getInstance().getUserName());
        RongIM.getInstance().sendMessage(
                Message.obtain(uiMessage.getTargetId(),
                        Conversation.ConversationType.PRIVATE,
                        noticeMsg), push, push, new SendMessageCallback()
        );
        setDisable(holder);
    }

    private void setDisable(ViewHolder holder) {
        holder.text1.setOnClickListener(null);
        holder.text2.setOnClickListener(null);
        holder.text1.setEnabled(false);
        holder.text2.setEnabled(false);
        holder.text1.setBackgroundResource(R.drawable.shape_gray);
    }

    @Override
    public Spannable getContentSummary(EvaluateInviteMsg evaluateInviteMsg) {
        return null;
    }

    @Override
    public void onItemClick(View view, int i, EvaluateInviteMsg evaluateInviteMsg, UIMessage uiMessage) {

    }

    @Override
    public void onItemLongClick(View view, int i, EvaluateInviteMsg evaluateInviteMsg, UIMessage uiMessage) {

    }

    @Override
    public View newView(Context context, ViewGroup viewGroup) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_rong_evaluate, null);
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

