package com.qxb.student.ui.home.toLecture;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.qxb.student.R;
import com.qxb.student.common.basics.BaseAppActivity;
import com.qxb.student.common.view.LandLayoutVideo;
import com.qxb.student.common.view.Toolbar;
import com.qxb.student.control.LectureControl;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.shuyu.gsyvideoplayer.listener.GSYVideoProgressListener;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

import org.xmlpull.v1.XmlPullParser;

public class ListenToLectureActivity extends BaseAppActivity {
    private boolean isPlay;
    private boolean isPause;
    private OrientationUtils mOrientationUtils;
    private Toolbar toolbar;
    private LandLayoutVideo detail_player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflate = LayoutInflater.from(this);
        View view = inflate.inflate(R.layout.activity_listen_to_lecture,null,true);
        setContentView(view);
        LectureControl lectureControl = ViewModelProviders.of(getActivity()).get(LectureControl.class);
        lectureControl.init(ListenToLectureActivity.this,view);
        toolbar = findViewById(R.id.toolbar);
        detail_player = findViewById(R.id.detail_player);
        toolbar.setTitle(getString(R.string.attending_a_lecture));
        toolbar.setNavigationIcon(com.qxb.student.common.R.drawable.arrow_left_black);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mOrientationUtils = new OrientationUtils(this, detail_player);
        resolveNormalVideoUI();
        mOrientationUtils.setEnable(false);


        showPlay();
    }



    private void showPlay() {
        //增加封面
        ImageView imageView = new ImageView(this);

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.mipmap.arrow_right);
        GSYVideoOptionBuilder gsyVideoOption = new GSYVideoOptionBuilder();
        gsyVideoOption.setThumbImageView(imageView)
                .setIsTouchWiget(true)
                .setRotateViewAuto(false)
                .setLockLand(false)
                .setAutoFullWithSize(true)
                .setShowFullAnimation(false)
                .setNeedLockFull(true)
                .setUrl("http://7xjmzj.com1.z0.glb.clouddn.com/20171026175005_JObCxCE2.mp4")
                .setCacheWithPlay(false)
                .setVideoTitle("测试视频")
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
                .build(detail_player);

        detail_player.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接横屏
                mOrientationUtils.resolveByClick();

                //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
                detail_player.startWindowFullscreen(ListenToLectureActivity.this, true, true);
            }
        });
    }


    private void resolveNormalVideoUI() {
        detail_player.getTitleTextView().setVisibility(View.GONE);
        detail_player.getBackButton().setVisibility(View.GONE);
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

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //如果旋转了就全屏
        if (isPlay && !isPause) {
            detail_player.onConfigurationChanged(this, newConfig, mOrientationUtils, true, true);
        }
    }

    private GSYVideoPlayer getCurPlay() {
        if (detail_player.getFullWindowPlayer() != null) {
            return detail_player.getFullWindowPlayer();
        }
        return detail_player;
    }


}
