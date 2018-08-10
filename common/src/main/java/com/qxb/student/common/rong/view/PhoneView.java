package com.qxb.student.common.rong.view;

import android.content.Context;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qxb.student.common.R;
import com.qxb.student.common.rong.msg.PhoneMsg;

import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.provider.IContainerItemProvider;

/**
 * 交换电话
 * Created by winky on 2017/12/21.
 */
@ProviderTag(messageContent = PhoneMsg.class, centerInHorizontal = true, showSummaryWithName = false, showPortrait = false)
public class PhoneView extends IContainerItemProvider.MessageProvider<PhoneMsg> {

    @Override
    public void bindView(View view, int i, PhoneMsg phoneMsg, UIMessage uiMessage) {
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.text1.setText(view.getContext().getString(R.string.hint_phone_success));
    }

    @Override
    public Spannable getContentSummary(PhoneMsg phoneMsg) {
        return null;
    }

    @Override
    public void onItemClick(View view, int i, PhoneMsg phoneMsg, UIMessage uiMessage) {

    }

    @Override
    public void onItemLongClick(View view, int i, PhoneMsg phoneMsg, UIMessage uiMessage) {

    }

    @Override
    public View newView(Context context, ViewGroup viewGroup) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_rong_notice_message, null);
        ViewHolder holder = new ViewHolder();
        holder.text1 = view.findViewById(R.id.text1);
        view.setTag(holder);
        return view;
    }

    static class ViewHolder {
        TextView text1;
    }
}

