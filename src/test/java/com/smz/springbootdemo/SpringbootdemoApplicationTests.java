package com.smz.springbootdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smz.springbootdemo.controller.SubscriberInfoController;
import com.smz.springbootdemo.dao.SubscriberInfoRepository;
import com.smz.springbootdemo.domain.SimpleBean;
import com.smz.springbootdemo.generate.PortalConfigModelMapper;
import com.smz.springbootdemo.service.CacheService;
import com.smz.springbootdemo.service.SubscriberInfoService;
import com.smz.springbootdemo.utils.AesEncryptUtils;
import com.smz.springbootdemo.generate.Subscriberinfo;
import com.smz.springbootdemo.generate.SubscriberinfoDao;
import com.smz.springbootdemo.zk.ZkUtil;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.data.Stat;
import org.ehcache.core.EhcacheManager;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = {SpringbootdemoApplication.class})
class SpringbootdemoApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(SpringbootdemoApplicationTests.class);

    @Autowired
    private SubscriberInfoService subscriberInfoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SubscriberInfoRepository subscriberInfoRepository;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private Environment environment;

    /*@Autowired
    private CrossOriginFilter crossOriginFilter;*/

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired(required = false)
    AesEncryptUtils aes;

    @Autowired
    StringEncryptor stringEncryptor;

    @Autowired
    SubscriberinfoDao subscriberinfoDao;

    @Resource
    CacheService cacheService;

    @Autowired
    CacheManager cacheManager;

    @Autowired
    PortalConfigModelMapper portalConfigModelMapper;

    @Autowired
    ZkUtil zkUtil;

    @Test
    void beanAnnotation() throws KeeperException, InterruptedException {
      /*  SimpleBean bean = applicationContext.getBean("SimpleBean2", SimpleBean.class);
        System.out.println(bean);*/
        List<String> children = zkUtil.getChildren("/admin");
        for (int i = 0; i < children.size(); i++) {
            System.out.println(children.get(i));
        }
    }
    @Test
    void contextLoads() throws JsonProcessingException {
        /*SubscriberInfo bean = subscriberInfoService.getSubscriberInfoByUserID("20201226001@itv");
        objectMapper.writeValueAsString(bean);
        System.out.println(bean.toString());*/
        /*SubscriberInfo subscriberInfo = new SubscriberInfo();
        subscriberInfo.setUserId("cde");
        subscriberInfo.setUserName("12345678910");
        subscriberInfoService.deleteByUserId("abc");*/

      /*  Pageable pageable = PageRequest.of(2,2);
        Page<SubscriberInfo> subscriberInfos = subscriberInfoRepository.queryAllByPage(pageable);
        System.out.println(subscriberInfos.toList());*/

      /*  String value = stringRedisTemplate.opsForValue().get("name");
        System.out.println("redis value is " + value);//jj
        */

  /*      Long value = stringRedisTemplate.opsForSet().add("subs", "1231s@iptv");
        System.out.println("redis value is " + value);*/

        String property = environment.getProperty("server.port");
        //System.out.println(crossOriginFilter);

        kafkaTemplate.send("test","{\"name\":\"skfxo123\"}");

    }

    @Test
    public  void logTest() throws Exception {
        /*logger.info("level is {}","info");
        logger.warn("level is {}","warn");
        logger.error("level is {}","error");
        logger.debug("level is {}","debug");*/
       /* System.out.println("PWD: " + stringEncryptor.encrypt("123456"));
        System.out.println("PWD: " + stringEncryptor.decrypt("PWD: 3eOLfF7UPZk5WneYjs3TMQ=="));*/
       /* System.out.println(applicationContext.getBean(BCryptPasswordEncoder.class));
        System.out.println(AesEncryptUtils.ALGORITHMSTR);
        System.out.println(AesEncryptUtils.SALT);
        System.out.println(AesEncryptUtils.decrypt("eYIQuRPS54iO2+qLft7GVQ=="));*/

/*        Subscriberinfo subscriberinfo = subscriberinfoDao.selectByPrimaryKey(27);
        System.out.println(subscriberinfo);*/
    }

    @Test
    public  void contextTest(){
        SubscriberInfoController bean = applicationContext.getBean(SubscriberInfoController.class);
        System.out.println(bean);
    }

    @Test
    public void cacheTest() throws JsonProcessingException {
/*        cacheService.queryCache("12");
        Cache cache = this.cacheManager.getCache("myCache1");
        Cache.ValueWrapper value = cache.get("12");
        Object o = value.get();
        System.out.println(o);*/

        SimpleBean simpleBean = new SimpleBean();
        simpleBean.setId(18);
        String jsonStr = objectMapper.writeValueAsString(simpleBean);
        Cache cache = this.cacheManager.getCache("myCache1");
        cacheService.save("save", jsonStr);
        Cache.ValueWrapper value = cache.get("save");
        Object o = value.get();
        cacheService.remove("save");
        Cache.ValueWrapper value1 = cache.get("save");
        System.out.println(value);
/*        Cache.ValueWrapper value1 = cache.get("12");
        Object o1 = value.get();
        System.out.println(o1);*/

    }

}
