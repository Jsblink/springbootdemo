package com.smz.springbootdemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.smz.springbootdemo.domain.SubscriberInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "config")
public class ConfigController {

    private static final Logger logger = LoggerFactory.getLogger(ConfigController.class);

    @RequestMapping("/query-all-by-page")
    public String queryAllSubscriberInfoByPage(int page, int size) throws JsonProcessingException {

        return "jsonStr";
    }
}
