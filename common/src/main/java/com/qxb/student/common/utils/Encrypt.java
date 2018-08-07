package com.qxb.student.common.utils;


import java.security.MessageDigest;

/**
 * 加密
 *
 * @author winky
 * @date 2017/12/11
 */
public class Encrypt {

    public static String getReverseString(String str) {
        StringBuffer secret_key = new StringBuffer(200);
        return secret_key.append(str).reverse().toString();
    }

    public static String md5(String s) {
        char[] hexDigits = {'0', '1', '2', '3', '4',
                '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] btInput = s.getBytes("UTF-8");
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String base64(String s) {
        byte[] data = s.getBytes();
        final char[] legalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        int start = 0;
        int len = data.length;
        StringBuilder buf = new StringBuilder(data.length * 3 / 2);

        int end = len - 3;
        int i = start;
        int n = 0;

        while (i <= end) {
            int d = ((((int) data[i]) & 0x0ff) << 16) | ((((int) data[i + 1]) & 0x0ff) << 8)
                    | (((int) data[i + 2]) & 0x0ff);
            buf.append(legalChars[(d >> 18) & 63]);
            buf.append(legalChars[(d >> 12) & 63]);
            buf.append(legalChars[(d >> 6) & 63]);
            buf.append(legalChars[d & 63]);
            i += 3;
            if (n++ >= 14) {
                n = 0;
                buf.append(" ");
            }
        }
        if (i == start + len - 2) {
            int d = ((((int) data[i]) & 0x0ff) << 16) | ((((int) data[i + 1]) & 255) << 8);

            buf.append(legalChars[(d >> 18) & 63]);
            buf.append(legalChars[(d >> 12) & 63]);
            buf.append(legalChars[(d >> 6) & 63]);
            buf.append("=");
        } else if (i == start + len - 1) {
            int d = (((int) data[i]) & 0x0ff) << 16;

            buf.append(legalChars[(d >> 18) & 63]);
            buf.append(legalChars[(d >> 12) & 63]);
            buf.append("==");
        }
        return buf.toString();
    }

    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }

    public static void main(String[] args) {
//        Map<String, String> map = new TreeMap<>();
//        map.put("accountId", "2561");
//        map.put("chatRoomName", "aaaaaaaaaaaaaa");
//        map.put("expectTimeLength", "1.5");
//        map.put("intro", "bbbbbbbbbbb");
//        map.put("liveStartTime", "2018-3-5 7:03:00");
//        StringBuffer sb = new StringBuffer(200);
//        for (String k : map.keySet()) {
//            if (!isEmpty(k) && !isEmpty(map.get(k))) {
//                sb.append(k).append("=").append(map.get(k)).append("&");
//            }
//        }
//        if (!isEmpty(sb)) {
//            sb.deleteCharAt(sb.length() - 1);
//        }
//
//        String secretKey = getReverseString("1520240945068" + "13400000001");
//        String signParamStr = sb.toString() + "&secretKey=" + secretKey;
//        String signTemp = md5(signParamStr).toUpperCase();
//        System.out.println("signTemp：" + signTemp);
//        String sign = md5(getReverseString(signTemp)).toUpperCase();
//        System.out.println("生成的私钥secretKey：" + secretKey);
//        System.out.println("参与签名的字符串stringSignTemp：" + signParamStr);
//        System.out.println("生成signTemp：" + signTemp);
//        System.out.println("生成签名sign：" + sign);
//        I/qxb: sign:512B80E865FFAFE05BA0E05A449A7F1D
    }
}
