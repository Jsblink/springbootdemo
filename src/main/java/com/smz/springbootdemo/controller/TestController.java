package com.smz.springbootdemo.controller;

import com.smz.springbootdemo.service.CacheService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    CacheService cacheService;

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(path = "cache")
    public String qureyCache(String id){
        cacheService.queryCache(id);
        if (id == null){
            return "null";
        }
        if (id == ""){
            return "kong";
        }
        return "OK";
    }
}
