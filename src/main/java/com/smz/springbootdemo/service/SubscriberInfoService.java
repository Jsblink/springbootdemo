package com.smz.springbootdemo.service;

import com.smz.springbootdemo.dao.SubscriberInfoRepository;
import com.smz.springbootdemo.domain.SubscriberInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberInfoService {

    @Autowired
    private SubscriberInfoRepository subscriberInfoRepository;

    public SubscriberInfo getSubscriberInfoByUserID(String userId) {
        return subscriberInfoRepository.getSubscriberInfoByUserID(userId);
    }

    public List<SubscriberInfo> queryAllSubscriberInfo() {
        return subscriberInfoRepository.findAll();
    }

    public SubscriberInfo saveAndFlush(SubscriberInfo subscriberInfo){
        return subscriberInfoRepository.saveAndFlush(subscriberInfo);
    }


    public void deleteByUserId(String userId){
        subscriberInfoRepository.deleteByUserId(userId);
    }

    public Page<SubscriberInfo> queryAllByPage(Pageable pageable){
        return subscriberInfoRepository.queryAllByPage(pageable);
    }

}
