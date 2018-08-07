package com.qxb.student.helper;

import android.content.Context;
import android.widget.Toast;

import com.qxb.student.R;
import com.qxb.student.common.module.bean.User;
import com.qxb.student.common.module.bean.attr.NavAttr;
import com.qxb.student.common.utils.ContextUtils;
import com.qxb.student.common.utils.NavigationUtils;
import com.qxb.student.common.utils.SysUtils;
import com.qxb.student.common.utils.UserCache;
import com.qxb.student.common.utils.dialog.ToastUtils;

/**
 * @author winky
 * @date 2018/8/6
 */
public class HintHelper {

    /**
     * 是否有网，没有网则给出提示
     * @return
     */
    public static boolean hasNetwork() {
        if (SysUtils.getInstance().isConnected()) {
            return true;
        } else {
            Context context = ContextUtils.getInstance().getContext();
            ToastUtils.toast(context, context.getString(R.string.hint_no_network));
            return false;
        }
    }

    /**
     * 是否登录，没有登录则跳转登录
     * @return
     */
    public static boolean hasLogin(Context context) {
        if (UserCache.getInstance().getUser() != null) {
            return true;
        } else {
            NavigationUtils.getInstance().toNavigation(context,
                    new NavAttr.Builder()
                            .graphRes(R.navigation.nav_login)
                            .navId(R.id.nav_login)
                            .build());
            return false;
        }
    }
}
