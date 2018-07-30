package com.qxb.student.ui.bankao;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.qxb.student.R;
import com.qxb.student.common.basics.AbsToolbarFragment;
import com.qxb.student.common.module.bean.Bankao;
import com.qxb.student.control.BanKaoControl;

/**
 * 伴考详情
 *
 * @author winky
 * @date 2018/7/30
 */
public class BankaoDetailFragment extends AbsToolbarFragment {

    private static final String ID = "_id";

    public static Bundle build(int id) {
        Bundle bundle = new Bundle();
        bundle.putString(ID, String.valueOf(id));
        return bundle;
    }

    public static Bundle build(Bankao bankao) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Bankao.TAG, bankao);
        return bundle;
    }

    @Override
    public int bindContentView() {
        return R.layout.fragment_bankao_detail;
    }

    private WebView webView;
    private ListView listView;
    private TextView send;
    private ImageView imageView;
    private EditText editText;

    private Bankao bankao;
    private String bankaoId;

    private BanKaoControl banKaoControl;

    @Override
    public void initContent(@Nullable Bundle savedInstanceState) {
        banKaoControl = ViewModelProviders.of(this).get(BanKaoControl.class);
        webView = findViewById(R.id.webView);
        listView = findViewById(R.id.listView);
        send = findViewById(R.id.send);
        imageView = findViewById(R.id.image1);
        editText = findViewById(R.id.edit1);
        bankao = getParcelableExtra(Bankao.TAG);
        if (bankao == null) {
            bankaoId = getStringExtra(ID);
            banKaoControl.getBankaoDetail(bankaoId);
        }

//        app:srcCompat="@{banKao.is_collectioned ? @drawable/collect : @drawable/un_collect}"
    }

    private void loadWeb(Bankao bankao) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        webView = null;
        listView = null;
        send = null;
        imageView = null;
        editText = null;
    }
}
