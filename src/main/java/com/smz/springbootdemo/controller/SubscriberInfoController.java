package com.smz.springbootdemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smz.springbootdemo.constfield.OperateResult;
import com.smz.springbootdemo.domain.SubscriberInfo;
import com.smz.springbootdemo.service.SubscriberInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** MVC架构，实现订户模型表subscriberinfo的增删改查功能
 *
 */
@RestController
@RequestMapping("/subscriberinfo")
@CrossOrigin( methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class SubscriberInfoController {
    private Logger logger = LoggerFactory.getLogger(SubscriberInfoController.class);

    @Autowired
    private SubscriberInfoService subscriberInfoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**userdid查询subscriberinfo信息，先查询内存，查不到再查redis,查不到直接返回无该用户，不会查询数据库
     *
     * @param userId 用户ID
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping("/get-subscriberinfo-by-userid")
    public String getSubscriberInfoByUserID(@RequestParam(value = "userId") String userId) throws JsonProcessingException {
        if (StringUtils.isEmpty(userId)){//return str == null || "".equals(str);
            return "userId is empty or equals null!!";
        }
        SubscriberInfo subscriberInfo = subscriberInfoService.getSubscriberInfoByUserID(userId);
        String jsonStr = objectMapper.writeValueAsString(subscriberInfo);
        return jsonStr;
    }

    /**一次性返回全部数据，后续需要进行分页修改
     *
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping("/query-all")
    public String queryAllSubscriberInfo() throws JsonProcessingException {
        List<SubscriberInfo> resultList = subscriberInfoService.queryAllSubscriberInfo();
        String jsonStr = objectMapper.writeValueAsString(resultList);
        return jsonStr;
    }

    /**需要存储到内存，redis和数据库里
     *
     * @param subscriberInfo
     * @return
     */
    @RequestMapping("/save-subscriberinfo")
    public String saveSubscriberInfo(@RequestBody SubscriberInfo subscriberInfo){
        logger.debug("begin save subscriberInfo,subscriberInfo={}",subscriberInfo);
        try {
            subscriberInfoService.saveAndFlush(subscriberInfo);
        }catch (Exception e){
            logger.error("add to db fail!!,{}",e);
            return "add to db fail!!";//返回字符串还是返回（errcode,errmsg）?
        }
        Long redisResult = stringRedisTemplate.opsForSet().add("subs", subscriberInfo.getUserId());
        if (redisResult == 0) {
            return "add to redis failed!!";
        }
        logger.debug("end save subscriberInfo");
        return OperateResult.OPERATE_SUCCESS;
    }

    /**分页查询
     *
     * @param page 查询的页数
     * @param size 每页数据条数
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping("/query-all-by-page")
    public String queryAllSubscriberInfoByPage(int page, int size) throws JsonProcessingException {
        logger.debug("query-all-by-page method begin");
        Pageable pageable = PageRequest.of(page, size);
        Page<SubscriberInfo> pageList = subscriberInfoService.queryAllByPage(pageable);
        String jsonStr = objectMapper.writeValueAsString(pageList);
        logger.debug("query-all-by-page[page={},siz={},jsonStr={}]",page,size,jsonStr);
        return jsonStr;
    }


}