package com.zpaas.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA1加密工具
 * @author ZhangJunyong
 *
 */
public class SHA1Util {

    private SHA1Util() {
    }

    public static String encode(String rawPass) {

        MessageDigest messageDigest = getMessageDigest();

        byte[] digest = messageDigest.digest(rawPass.getBytes());

        return new String(CommonUtil.hex2Ascii(digest)).toLowerCase();
    }

    protected final static MessageDigest getMessageDigest() throws IllegalArgumentException {
        try {
            return MessageDigest.getInstance("SHA-1");
        }
        catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("No such algorithm [" + "SHA-1" + "]");
        }
    }

    public static boolean isPasswordValid(String encPass, String rawPass) {
        String pass1 = "" + encPass;
        String pass2 = encode(rawPass);

        return pass1.equals(pass2);
    }


    public static void main(String[] args) {
        String result = SHA1Util.encode("111111");
        System.out.println("password=" + result);

        boolean isGood = SHA1Util.isPasswordValid("3d4f2bf07dc1be38b20cd6e46949a1071f9d0e3d", "111111");
        System.out.println("isGood=" + isGood);
    }

}
