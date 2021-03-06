package sample;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.Security;


public class DesCrypt {

    private static final String VECTOR  = "WhatIsYo";

    //1 - mod(CBC) and menu(file)
    //2 - mod(ECB) and menu(text)

    public String encrypt(String secretKey,String orgtext,int mode) throws Exception{


        IvParameterSpec ivParameterSpec = new IvParameterSpec(VECTOR.getBytes(StandardCharsets.UTF_8));
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8),"DES");

        String s = null;
        if(mode == 1) {
            //CBC mode
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec,ivParameterSpec);
            s = new String(Hex.encodeHex(cipher.doFinal(orgtext.getBytes(StandardCharsets.UTF_8))));
        } else if(mode == 2) {
            //ECB mod
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec);
            s = new String(Hex.encodeHex(cipher.doFinal(orgtext.getBytes(StandardCharsets.UTF_8))));
        }else{
            throw new Exception("Unselected Mode (CBC/ECB)");
        }

        return s;

    }

    public String decrypt(String key,String cipherText,int mode) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(VECTOR.getBytes(StandardCharsets.UTF_8));
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8),"DES");


        String s;

        if(mode == 1) {
            //CBC mode
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,secretKeySpec,ivParameterSpec);
            s = new String(cipher.doFinal(Hex.decodeHex(cipherText.toCharArray())));
        }else if(mode == 2) {
            //ECB mod
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
            s = new String(cipher.doFinal(Hex.decodeHex(cipherText.toCharArray())));
        }else{
            throw new Exception("Unselected Mode (CBC/ECB)");
        }

        return s;
    }
}
