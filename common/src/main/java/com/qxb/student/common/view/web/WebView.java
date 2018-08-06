package com.qxb.student.common.view.web;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.GeolocationPermissions;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import java.util.ArrayList;

/**
 * Created by winky on 2018/7/17.
 */
public class WebView extends android.webkit.WebView {

    private ProgressBar progressbar;
    /**
     * 是否在外部浏览器打开网页
     */
    private boolean external;

    private FragmentActivity activity;
    private View view;
    private FrameLayout frameLayout;
    private WebChromeClient.CustomViewCallback viewCallback;
    private OnWebClientListener listener;

    public WebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (context instanceof FragmentActivity) {
            activity = (FragmentActivity) context;
        } else {
            throw new IllegalArgumentException("activity is empty");
        }
        progressbar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        progressbar.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 3, 0, 0));
        addView(progressbar);

        setWebViewClient(webViewClient);
        setWebChromeClient(webChromeClient);

        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setAllowFileAccess(true); // 允许访问文件
        settings.setDisplayZoomControls(false);//不显示webview缩放按钮
        settings.setLoadWithOverviewMode(true);

        addJavascriptInterface(new JavaScriptInterface(), "imagelistner");
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        LayoutParams lp = (LayoutParams) progressbar.getLayoutParams();
        lp.x = l;
        lp.y = t;
        progressbar.setLayoutParams(lp);
        super.onScrollChanged(l, t, oldl, oldt);
    }

    public void setWebClientListener(OnWebClientListener listener) {
        this.listener = listener;
    }

    public interface OnWebClientListener {
        void onPageFinished(android.webkit.WebView view, String url);
    }

    private WebViewClient webViewClient = new WebViewClient() {

        private boolean toWebUrl(android.webkit.WebView webView, @NonNull Uri uri) {
            String url = uri.toString();
            if (external) {
                try {
                    if (url.startsWith("http") || url.startsWith("https")) {
                        webView.loadUrl(uri.toString());
                    } else {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        activity.startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                webView.loadUrl(uri.toString());
            }
            return true;
        }

        @Override
        public boolean shouldOverrideUrlLoading(android.webkit.WebView view, String url) {
            return toWebUrl(view, Uri.parse(url));
        }

        @Override
        public boolean shouldOverrideUrlLoading(android.webkit.WebView view, WebResourceRequest request) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                return toWebUrl(view, request.getUrl());
            } else {
                return super.shouldOverrideUrlLoading(view, request);
            }
        }

        @Override
        public void onReceivedSslError(android.webkit.WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();// 接受所有网站的证书
        }

        @Override
        public void onPageStarted(android.webkit.WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(android.webkit.WebView view, String url) {
            super.onPageFinished(view, url);
            if (listener != null) {
                listener.onPageFinished(view, url);
            }
            //当页面加载完成，修改图片点击事件
            view.loadUrl("javascript:(function(){" +
                    "var objs = document.getElementById(\"content\").getElementsByTagName(\"img\");" +
                    "for(var i=0;i<objs.length;i++)  " +
                    "{" +
                    "var imageUrl=objs[i].src;" +
                    "var index=imageUrl.lastIndexOf(\".\");" +
                    "var format=imageUrl.substring(index+1,imageUrl.length);" +
                    "if(format==\"gif\"){continue;}" +
                    "window.imagelistner.readImageUrl(imageUrl);  " +
                    " objs[i].onclick=function()  " +
                    " {  " +
                    " window.imagelistner.openImage(this.src);" +
                    "  }  " +
                    "}" +
                    "})()");
        }
    };

    /**
     * 视频播放全屏
     **/
    private void showCustomView(View view, WebChromeClient.CustomViewCallback callback) {
        if (this.view != null) {
            callback.onCustomViewHidden();
            return;
        }
        FrameLayout decor = (FrameLayout) activity.getWindow().getDecorView();
        frameLayout = new FullscreenHolder(activity);
        frameLayout.addView(view, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        decor.addView(frameLayout, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        this.view = view;
        setStatusBarVisibility(false);
        this.viewCallback = callback;
        //设置横屏
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    /**
     * 隐藏视频全屏
     */
    private void hideCustomView() {
        if (this.view == null) {
            return;
        }

        setStatusBarVisibility(true);
        FrameLayout decor = (FrameLayout) activity.getWindow().getDecorView();
        decor.removeView(frameLayout);
        this.frameLayout = null;
        this.view = null;
        this.viewCallback.onCustomViewHidden();
        setVisibility(View.VISIBLE);
        // 设置竖屏
        this.activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /**
     * 全屏容器界面
     */
    class FullscreenHolder extends FrameLayout {

        public FullscreenHolder(Context ctx) {
            super(ctx);
            setBackgroundColor(ctx.getResources().getColor(android.R.color.black));
        }

        @Override
        public boolean onTouchEvent(MotionEvent evt) {
            return true;
        }
    }

    private void setStatusBarVisibility(boolean visible) {
        int flag = visible ? 0 : WindowManager.LayoutParams.FLAG_FULLSCREEN;
        activity.getWindow().setFlags(flag, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private WebChromeClient webChromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(android.webkit.WebView view, int newProgress) {
            if (newProgress == 100) {
                progressbar.setVisibility(GONE);
            } else {
                if (progressbar.getVisibility() == GONE)
                    progressbar.setVisibility(VISIBLE);
                progressbar.setProgress(newProgress);
            }
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
            super.onGeolocationPermissionsShowPrompt(origin, callback);
            callback.invoke(origin, true, false);
        }

        /*** 视频播放相关的方法 **/
        @Override
        public View getVideoLoadingProgressView() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
            return frameLayout;
        }

        @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {
            showCustomView(view, callback);
        }

        @Override
        public void onHideCustomView() {
            hideCustomView();
        }
    };

    class JavaScriptInterface {
        private ArrayList<String> imgList = null;

        JavaScriptInterface() {
            imgList = new ArrayList<>();
        }

        @android.webkit.JavascriptInterface
        public void readImageUrl(String img) {     //把所有图片的url保存在ArrayList<String>中
            imgList.add(img);
        }

        @android.webkit.JavascriptInterface  //对于targetSdkVersion>=17的，要加这个声明
        public void openImage(String clickimg) {
//            Intent intent = new Intent(getContext(), PhotoShowActivity.class);
//            intent.putStringArrayListExtra(Constant.PHOTO_LIST, listimg);
//            intent.putExtra(Constant.PHOTO_CURENT, listimg.indexOf(clickimg));
//            getContext().startActivity(intent);
        }
    }

    public void setExternal(boolean external) {
        this.external = external;
    }
}