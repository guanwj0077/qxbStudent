package com.qxb.student.common.rong.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qxb.student.common.R;
import com.qxb.student.common.rong.msg.NoticeMsg;

import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.Message;

/**
 * 展示通知类消息
 * Created by winky on 2017/12/7.
 */
@ProviderTag(messageContent = NoticeMsg.class, centerInHorizontal = true, showSummaryWithName = false, showPortrait = false)
public class NoticeView extends IContainerItemProvider.MessageProvider<NoticeMsg> {

    public NoticeView() {
    }

    @Override
    public View newView(Context context, ViewGroup viewGroup) {
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(context).inflate(R.layout.view_rong_notice_message, null);
        ViewHolder holder = new ViewHolder();
        holder.message = view.findViewById(R.id.text1);
        view.setTag(holder);
        return view;
    }

    @Override
    public void bindView(View view, int i, NoticeMsg noticeMsg, UIMessage uiMessage) {
        ViewHolder holder = (ViewHolder) view.getTag();
        String hint = uiMessage.getMessageDirection() == Message.MessageDirection.SEND ? noticeMsg.getOwnContent() : noticeMsg.getTagetContent();
        boolean isShow = TextUtils.isEmpty(hint);
        holder.message.setVisibility(isShow ? View.GONE : View.VISIBLE);
        if (!isShow) {
            holder.message.setText(hint);
        }
    }

    @Override
    public Spannable getContentSummary(NoticeMsg noticeMsg) {
        return new SpannableString("");
    }


    @Override
    public void onItemClick(View view, int i, NoticeMsg noticeMsg, UIMessage uiMessage) {

    }

    @Override
    public void onItemLongClick(View view, int i, NoticeMsg noticeMsg, UIMessage uiMessage) {

    }

    class ViewHolder {
        TextView message;
    }
}

