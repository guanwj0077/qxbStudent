package com.qxb.student.common.basics;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.qxb.student.common.Constant;
import com.qxb.student.common.R;
import com.qxb.student.common.listener.MultiClickUtil;
import com.qxb.student.common.module.bean.attr.VoideAttr;
import com.qxb.student.common.utils.GlideUtils;
import com.qxb.student.common.view.LandLayoutVideo;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.shuyu.gsyvideoplayer.listener.GSYVideoProgressListener;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

public class VideoPlayActivity extends BaseAppActivity {
    private LandLayoutVideo video_play;

    private ImageView iv_share;
    private String type;

    private boolean isPlay;
    private boolean isPause;
    private OrientationUtils mOrientationUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_video_play);
        VoideAttr mVoideAttr=getIntent().getParcelableExtra(Constant.PURPOSE);
        video_play = findViewById(R.id.video_play);
        iv_share = findViewById(R.id.iv_share);
        iv_share.setVisibility(mVoideAttr.isShare() ? View.VISIBLE : View.GONE);
        video_play.getBackButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        iv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mOrientationUtils = new OrientationUtils(this, video_play);
        resolveNormalVideoUI();
        mOrientationUtils.setEnable(false);
        showPlay(mVoideAttr);
    }

    private void showPlay(VoideAttr mVoideAttr) {
        //增加封面

        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (TextUtils.isEmpty(mVoideAttr.getCoverRealPath())){
            imageView.setImageResource(R.mipmap.sybz_bg);
        }else{
            GlideUtils.getInstance().loadImage(imageView,mVoideAttr.getCoverRealPath());
        }
        GSYVideoOptionBuilder gsyVideoOption = new GSYVideoOptionBuilder();
        gsyVideoOption.setThumbImageView(imageView)
                .setIsTouchWiget(true)
                .setRotateViewAuto(false)
                .setLockLand(false)
                .setAutoFullWithSize(true)
                .setShowFullAnimation(false)
                .setNeedLockFull(true)
                .setUrl(mVoideAttr.getUrl())
                .setCacheWithPlay(false)
                .setVideoTitle(mVoideAttr.getTitle())
                .setVideoAllCallBack(new GSYSampleCallBack() {
                    @Override
                    public void onPrepared(String url, Object... objects) {
                        Debuger.printfError("***** onPrepared **** " + objects[0]);
                        Debuger.printfError("***** onPrepared **** " + objects[1]);
                        super.onPrepared(url, objects);
                        //开始播放了才能旋转和全屏
                        mOrientationUtils.setEnable(true);
                        isPlay = true;
                    }

                    @Override
                    public void onEnterFullscreen(String url, Object... objects) {
                        super.onEnterFullscreen(url, objects);
                        Debuger.printfError("***** onEnterFullscreen **** " + objects[0]);//title
                        Debuger.printfError("***** onEnterFullscreen **** " + objects[1]);//当前全屏player
                    }

                    @Override
                    public void onAutoComplete(String url, Object... objects) {
                        super.onAutoComplete(url, objects);
                    }

                    @Override
                    public void onClickStartError(String url, Object... objects) {
                        super.onClickStartError(url, objects);
                    }

                    @Override
                    public void onQuitFullscreen(String url, Object... objects) {
                        super.onQuitFullscreen(url, objects);
                        Debuger.printfError("***** onQuitFullscreen **** " + objects[0]);//title
                        Debuger.printfError("***** onQuitFullscreen **** " + objects[1]);//当前非全屏player
                        if (mOrientationUtils != null) {
                            mOrientationUtils.backToProtVideo();
                        }
                    }
                })
                .setLockClickListener(new LockClickListener() {
                    @Override
                    public void onClick(View view, boolean lock) {
                        if (mOrientationUtils != null) {
                            //配合下方的onConfigurationChanged
                            mOrientationUtils.setEnable(!lock);
                        }
                    }
                })
                .setGSYVideoProgressListener(new GSYVideoProgressListener() {
                    @Override
                    public void onProgress(int progress, int secProgress, int currentPosition, int duration) {
                        Debuger.printfLog(" progress " + progress + " secProgress " + secProgress + " currentPosition " + currentPosition + " duration " + duration);
                    }
                })
                .build(video_play);

        video_play.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接横屏
                mOrientationUtils.resolveByClick();

                //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
                video_play.startWindowFullscreen(VideoPlayActivity.this, true, true);
            }
        });
    }

    private void resolveNormalVideoUI() {
        video_play.getTitleTextView().setVisibility(View.VISIBLE);
        video_play.getBackButton().setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        if (mOrientationUtils != null) {
            mOrientationUtils.backToProtVideo();
        }
        if (GSYVideoManager.backFromWindowFull(this)) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        getCurPlay().onVideoPause();
        super.onPause();
        isPause = true;
    }

    @Override
    protected void onResume() {
        getCurPlay().onVideoResume(false);
        super.onResume();
        isPause = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isPlay) {
            getCurPlay().release();
        }
        if (mOrientationUtils != null) {
            mOrientationUtils.releaseListener();
        }
    }

   /* @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //如果旋转了就全屏
        if (isPlay && !isPause) {
            video_play.onConfigurationChanged(this, newConfig, mOrientationUtils, true, true);
        }
    }*/

    private GSYVideoPlayer getCurPlay() {
        if (video_play.getFullWindowPlayer() != null) {
            return video_play.getFullWindowPlayer();
        }
        return video_play;
    }

}
