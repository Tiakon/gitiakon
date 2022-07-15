package cn.tiakon.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

/**
 * Created by Hoictas on 2017/8/9.
 */
public class MD5Util {


    public static String getEncoderStrByMD5(String str) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        byte[] strBytes = str.getBytes("utf-8");
        String encode = base64Encoder.encode(md5.digest(strBytes));
        return encode;
    }


}


