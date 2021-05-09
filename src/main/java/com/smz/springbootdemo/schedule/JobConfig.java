package com.smz.springbootdemo.schedule;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfig {

    private static String JOB_GROUP_NAME = "TEST_JOBGROUP_NAME";
    private static String TRIGGER_GROUP_NAME = "TEST_TRIGGERGROUP_NAME";

    /**
     *
     * @return
     */
    @Bean("printJobDetail")
    public JobDetail printJobDetail(){
        JobDetail build = JobBuilder.newJob(PrintJob.class)
                .withIdentity("PRINT_JOBDETAIL", JOB_GROUP_NAME)
                .usingJobData("map_job", "map_job_value")
                .usingJobData("map_job1", "map_job_value1")
                .storeDurably(true)//不加开机启动失败，SchedulerException: Jobs added with no trigger must be durable.
                .build();
        return build;
    }

    @Bean("printJobDetail2")
    public Trigger printJobTrigger(){
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(printJobDetail())
                .withIdentity("PRINT_TRRGIER", TRIGGER_GROUP_NAME)
                .usingJobData("map_trigger1","map_trigger1_value")
                .withSchedule(cronScheduleBuilder)
                .withPriority(0)
                .build();
        return trigger;
    }

    @Bean
    public Trigger printJobTrigger2(){
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/2 * * * * ?");
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(printJobDetail())
                .withIdentity("PRINT_TRRGIER2", TRIGGER_GROUP_NAME)
                .usingJobData("map_trigger2","map_trigger2_value")
                .withSchedule(cronScheduleBuilder)
                .build();
        return trigger;
    }
}
