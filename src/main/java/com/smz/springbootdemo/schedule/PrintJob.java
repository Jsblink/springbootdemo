package com.smz.springbootdemo.schedule;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;


public class PrintJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("instance is " + this);
        JobDataMap name = jobExecutionContext.getTrigger().getJobDataMap();
        for (String key :  name.keySet()) {
            System.out.println(name.get(key) + new Date().toString());
        }
        System.out.println("over");
    }
}
