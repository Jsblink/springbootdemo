package com.smz.springbootdemo;

import com.smz.springbootdemo.domain.SubscriberInfo;
import com.smz.springbootdemo.service.SubscriberInfoService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class TT  {
    private static Logger logger = LoggerFactory.getLogger(TT.class);

    public static void main(String[] args) {

      /*  SubscriberInfoService subscriberInfoService = new SubscriberInfoService();
        SubscriberInfo bean = subscriberInfoService.getSubscriberInfoByUserID("20201226001@itv");
        System.out.println(bean.toString());*/

       /* String originalFilename = "car.jpg";
        String prefixName = originalFilename.substring(0, originalFilename.lastIndexOf("."));
        System.out.println(prefixName);*/

 /*       SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy" + File.separator + "MM" + File.separator + "dd");
        Calendar calendar = Calendar.getInstance();
        System.out.println( calendar.get(Calendar.YEAR));
        System.out.println( calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println( calendar.get(Calendar.MONTH) + 1);
        System.out.println( calendar.getTime());
        String format = simpleDateFormat.format(calendar.getTime());
        System.out.println(format);*/

        System.getProperty("user.dir");
    }

    @Test
    public void test(){
        logger.info("level is {}","info");
        logger.warn("level is {}","warn");
    }

}
