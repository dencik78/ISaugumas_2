package sample;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;


public class DesCrypt {

    private static final String VECTOR  = "WhatIsYo";

    //1 - mod(CBC) and menu(file)
    //2 - mod(ECB) and menu(text)

    public String encrypt(String secretKey,String orgtext,int mode) throws Exception{
        IvParameterSpec ivParameterSpec = new IvParameterSpec(VECTOR.getBytes(StandardCharsets.UTF_8));
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8),"DES");

        String mod = null;

        if(mode == 1) {
            //CBC mode
            mod = "DES/CBC/PKCS5Padding";
        }else if(mode == 2) {
            //ECB mod
            mod = "DES/ECB/PKCS5Padding";
        }

        assert mod != null;
        Cipher cipher = Cipher.getInstance(mod);
        cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec,ivParameterSpec);
        return new String(Hex.encodeHex(cipher.doFinal(orgtext.getBytes(StandardCharsets.UTF_8))));

    }

    public String decrypt(String key,String cipherText,int mode) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(VECTOR.getBytes(StandardCharsets.UTF_8));
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8),"DES");


        String mod = null;

        if(mode == 1) {
            //CBC mode
            mod = "DES/CBC/PKCS5Padding";
        }else if(mode == 2) {
            //ECB mod
            mod = "DES/ECB/PKCS5Padding";
        }

        assert mod != null;
        Cipher cipher = Cipher.getInstance(mod);

        cipher.init(Cipher.DECRYPT_MODE,secretKeySpec,ivParameterSpec);

        return new String(cipher.doFinal(Hex.decodeHex(cipherText.toCharArray())));
    }
}
