package com.qxb.student.common.basics;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.qxb.student.common.R;
import com.qxb.student.common.module.bean.attr.WebAttr;
import com.qxb.student.common.view.Toolbar;
import com.qxb.student.common.view.web.WebView;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用web页面
 * @author winky
 */
public class WebActivity extends BaseAppActivity {

    private final static String AUTHORIZATION = "Authorization";
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        WebAttr attr = getIntent().getParcelableExtra(WebAttr.TAG);
        if (attr == null) {
            finish();
            return;
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        webView = findViewById(R.id.webView);
        toolbar.setTitle(attr.getTitle());
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.arrow_left_black);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        webView.setExternal(attr.isExternal());
        if (TextUtils.isEmpty(attr.getAuth())) {
            webView.loadUrl(attr.getHttpUrl());
        } else {
            Map<String, String> httpHeaders = new HashMap<>();
            httpHeaders.put(AUTHORIZATION, attr.getAuth());
            webView.loadUrl(attr.getHttpUrl(), httpHeaders);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (webView != null) {
            webView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (webView != null) {
            webView.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webView != null) {
            webView.destroy();
        }
    }
}
