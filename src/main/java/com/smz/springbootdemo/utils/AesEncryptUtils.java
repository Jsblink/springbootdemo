package com.smz.springbootdemo.utils;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

@Configuration
public class AesEncryptUtils implements EnvironmentAware {
    //private  Environment environment;
    //可配置到Constant中，并读取配置文件注入,16位,自己定义
    public static String SALT ;

    //参数分别代表 算法名称/加密模式/数据填充方式
    public static String ALGORITHMSTR ;

    @Override
    public void setEnvironment(Environment environment) {
        //this.environment = environment;
        this.SALT = environment.getProperty("product.crypto.salt");
        this.ALGORITHMSTR = environment.getProperty("product.crypto.algorithm");
    }

    public static String encrypt(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));
        byte[] b = cipher.doFinal(content.getBytes("utf-8"));
        // 采用base64算法进行转码,避免出现中文乱码
        return Base64.encodeBase64String(b);

    }

    public static String decrypt(String encryptStr, String decryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
        // 采用base64算法进行转码,避免出现中文乱码
        byte[] encryptBytes = Base64.decodeBase64(encryptStr);
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        return new String(decryptBytes);
    }
    public static String encrypt(String content) throws Exception {
        return encrypt(content, SALT);
    }
    public static String decrypt(String encryptStr) throws Exception {
        return decrypt(encryptStr, SALT);
    }

}
