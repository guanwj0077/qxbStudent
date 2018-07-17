package com.qxb.student.common.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class SysUtils {

    private static final Singleton<SysUtils> SINGLETON = new Singleton<SysUtils>() {
        @Override
        protected SysUtils create() {
            return new SysUtils();
        }
    };

    public static SysUtils getInstance() {
        return SINGLETON.get();
    }

    /**
     * 状态栏高度
     */
    private static int STATUS_BAR_HEIGHT;
    /**
     * 屏幕高度
     */
    private static DisplayMetrics displayMetrics;
    /**
     * 当前包信息
     */
    private PackageInfo packageInfo;

    private Context context = ContextUtils.getInstance().getContext();

    /**
     * 获得进程的名字
     *
     * @return 进程名
     */
    public String getMainProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager != null) {
            for (ActivityManager.RunningAppProcessInfo appProcess : activityManager.getRunningAppProcesses()) {
                if (appProcess.pid == pid) {
                    return appProcess.processName;
                }
            }
        }
        return "";
    }

    /**
     * 判断网络是否连接
     *
     * @return
     */
    public boolean isConnected() {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (null != connectivity) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (null != info && info.isConnected()) {
                return info.getState() == NetworkInfo.State.CONNECTED;
            }
        }
        return false;
    }

    /**
     * 判断是否是wifi连接
     */
    public boolean isWifi() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm != null && cm.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;
    }

    /**
     * 获得状态栏的高度
     *
     * @return
     */
    public int getStatusHeight() {
        if (STATUS_BAR_HEIGHT > 0) {
            return STATUS_BAR_HEIGHT;
        }
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            STATUS_BAR_HEIGHT = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return STATUS_BAR_HEIGHT;
    }

    public DisplayMetrics getDisplayMetrics() {
        if (displayMetrics == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = windowManager.getDefaultDisplay();
            DisplayMetrics metrics = new DisplayMetrics();
            display.getMetrics(metrics);
            displayMetrics = metrics;
        }
        return displayMetrics;
    }

    /**
     * 获取当前屏幕截图，包含状态栏
     *
     * @param activity         截取当前活动视图
     * @param containSystemBar 是否包含状态栏
     * @return
     */
    public Bitmap snapShot(Activity activity, boolean containSystemBar) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        DisplayMetrics displayMetrics = getDisplayMetrics();
        //如果不需要状态栏, 创建图片高度减去状态栏高度
        int height = containSystemBar ? displayMetrics.heightPixels : displayMetrics.heightPixels - getStatusHeight();
        Bitmap bp = Bitmap.createBitmap(bmp, 0, 0, displayMetrics.widthPixels, height);
        view.destroyDrawingCache();
        return bp;
    }

    /**
     * 获取当前包信息
     *
     * @return
     */
    public PackageInfo getPackageInfo() {
        if (packageInfo == null) {
            packageInfo = getPackageInfo(context.getPackageName());
        }
        return packageInfo;
    }

    /**
     * 获取包信息
     *
     * @return
     */
    public PackageInfo getPackageInfo(String packageName) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, Context.MODE_PRIVATE);
            return packageInfo;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ApplicationInfo getApplicationInfo() {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取手机IMEI
     *
     * @return
     */
//    @SuppressLint("MissingPermission")
//    public final String getIMEI() {
//        try {
//            //实例化TelephonyManager对象
//            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
//            //获取IMEI号
//            String imei;
//            if (Build.VERSION.SDK_INT >= 26) {
//                imei = telephonyManager.getImei();
//            } else {
//                imei = telephonyManager.getDeviceId();
//            }
//            //在次做个验证，也不是什么时候都能获取到的啊
//            if (imei == null) {
//                imei = "";
//            }
//            return imei;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "";
//        }
//
//    }
}
