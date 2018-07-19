package com.qxb.student.common.utils;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**

 * @author zjk9527
 */
public class CommonUtils {
    /**
     * 判断是否符合电话号码的规则
     * @param phone
     * @return
     */
    public static boolean rightPhone(String phone) {
        Pattern mPhonePattern = Pattern.compile("^((13[0-9])|(14[0-9])|(15[[0-9]])|(16[[0-9]])|(17[[0-9]])|(18[[0-9]])|(19[[0-9]]))\\d{8}$");
        if ((phone == null) || (phone.length() < 1)) {
            return false;
        }
        return mPhonePattern.matcher(phone).matches();
    }

    /**
     * 判断短信验证码是否符合规则
     * @param patternContent
     * @return
     */
    public static String patternCode(String patternContent) {
        String patternCoder = "(?<!\\d)\\d{6}(?!\\d)";
        if (TextUtils.isEmpty(patternContent)) {
            return null;
        }
        Pattern p = Pattern.compile(patternCoder);
        Matcher matcher = p.matcher(patternContent);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }


}
