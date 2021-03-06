package org.souzarodrigo.core.utils.security.util;


import java.security.MessageDigest;

public class EncryptPassword {

    public static String getEncryptPassword(String password) {
        try {
            String algorithm = "SHA";
            byte[] plainText = password.getBytes();
            MessageDigest md = MessageDigest.getInstance(algorithm);

            md.reset();
            md.update(plainText);
            byte[] encodedPassword = md.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : encodedPassword) {
                if ((b & 0xff) < 0x10) {
                    sb.append("0");
                }

                sb.append(Long.toString(b & 0xff, 16));
            }

            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
