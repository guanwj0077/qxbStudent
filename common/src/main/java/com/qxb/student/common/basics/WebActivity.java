package com.qxb.student.common.basics;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.qxb.student.common.R;
import com.qxb.student.common.module.bean.WebAttr;
import com.qxb.student.common.utils.SysUtils;
import com.qxb.student.common.view.web.WebView;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WebActivity extends BaseAppActivity {

    private final static String AUTHORIZATION = "Authorization";
    private Toolbar toolbar;
    private WebView webView;
    private WebAttr attr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        attr = getIntent().getParcelableExtra(WebAttr.TAG);
        if (attr == null) {
            finish();
            return;
        }
        toolbar = findViewById(R.id.toolbar);
        webView = findViewById(R.id.webView);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.arrow_left_black);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbar.setTitle(attr.getTitle());

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
