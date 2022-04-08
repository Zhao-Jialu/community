package com.nowcoder.community.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.util.Properties;

@Configuration
public class KaptchaConfig {

    @Bean
    public Producer kaptchaProducer() {
        Properties properties = new Properties();
        properties.setProperty("kaptcha.image.width","100");  //验证码的宽度
        properties.setProperty("kaptcha.image.height","40");  //验证码的高度
        properties.setProperty("kaptcha.textproducer.font.size","32"); //字体大小
        properties.setProperty("kaptcha.textproducer.font.color","0,0,0"); //字体颜色
        properties.setProperty("kaptcha.textproducer.char.string","0123456789ABCDEFGHIGKLMNOPQRSTUVWXYZ"); //验证码选取的范围
        properties.setProperty("kaptcha.textproducer.char.length","4"); //验证码的长度
        properties.setProperty("kaptcha.noise.impl","com.google.code.kaptcha.impl.NoNoise"); //采用的噪声类型，此处采用的无干扰类型


        DefaultKaptcha kaptcha = new DefaultKaptcha();
        Config config = new Config(properties);
        kaptcha.setConfig(config);
        return kaptcha;
    }
}
