package com.example.marvel;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Assets {

    public static final int PAGE_LIMIT = 20;
    public static final int OFFSET = 0;
    public static final String PRIVATE_API_KEY = "1de4b3a02fefb3dba253b3d07ff2884bf28b48dd";
    public static final String PUBLIC_API_KEY = "97f02f6d342218d799bac2b1414451bb";
    public static final String BASE_URL = "https://gateway.marvel.com:443/";


    public static String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
