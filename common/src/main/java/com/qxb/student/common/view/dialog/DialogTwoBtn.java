package com.qxb.student.common.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qxb.student.common.R;

/**
 * @author: zjk9527
 * created on: 2018/7/20 14:29
 * description:
 */
public class DialogTwoBtn extends Dialog{

    private TextView tv_msg_title;

    public TextView message;

    private TextView left_btn;

    private TextView right_btn;

    private LinearLayout ll_tips;


    private Context context;
    public View.OnClickListener left_Ocl;
    public View.OnClickListener right_Ocl;

    public DialogTwoBtn(Context paramContext) {
        super(paramContext);
    }

    public DialogTwoBtn(Context paramContext, int paramInt) {
        super(paramContext, paramInt);
        this.context = paramContext;
    }

    @Override
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.dialog_twobtn_view);
        tv_msg_title=findViewById(R.id.tv_msg_title);
    }

    public void setLeft_Ocl(View.OnClickListener paramOnClickListener) {
        if (left_btn == null) {
            left_btn = (TextView) findViewById(R.id.left_btn);
        }
        this.left_btn.setOnClickListener(paramOnClickListener);
    }

    public void setLeft_btn(String paramString) {
        if (left_btn == null) {
            left_btn = (TextView) findViewById(R.id.left_btn);
        }
        this.left_btn.setText(paramString);
    }

    public void setMessage(String paramString) {
        if (message == null) {
            message = (TextView) findViewById(R.id.message);
        }
        this.message.setText(paramString);
    }

    public void setMsgTitle(String paramString) {
        if (tv_msg_title == null) {
            tv_msg_title = (TextView) findViewById(R.id.tv_msg_title);
        }
        this.tv_msg_title.setText(paramString);
    }

    public void setTipsVisible(boolean tipsVisible) {
        if (ll_tips == null) {
            ll_tips = (LinearLayout) findViewById(R.id.ll_tips);
        }
        ll_tips.setVisibility(tipsVisible ? View.VISIBLE : View.GONE);
    }

    public void setLeftBtnVisible(boolean isVisibility) {
        if (left_btn == null) {
            left_btn = (TextView) findViewById(R.id.right_btn);
        }
        this.left_btn.setVisibility(isVisibility ? View.VISIBLE : View.GONE);
    }

    public void setRight_Ocl(View.OnClickListener paramOnClickListener) {
        if (right_btn == null) {
            right_btn = (TextView) findViewById(R.id.right_btn);
        }
        this.right_btn.setOnClickListener(paramOnClickListener);
    }

    public void setRight_btn(String paramString) {
        if (right_btn == null) {
            right_btn = (TextView) findViewById(R.id.right_btn);
        }
        this.right_btn.setText(paramString);
    }

    @Override
    public void show() {
        super.show();
        /* WindowManager.LayoutParams localLayoutParams = getWindow()
                .getAttributes();
        localLayoutParams.width = width;*/
        //getWindow().setAttributes(localLayoutParams);
    }
}
