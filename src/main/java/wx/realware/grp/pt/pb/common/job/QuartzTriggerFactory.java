package wx.realware.grp.pt.pb.common.job;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 获取创建Job所需要的各种类型trigger
 * 如果不满足，安照需要自己添加
 * @author joe
 * @version 1.0.0
 * @time 2018/9/20 11:17
 * @filename QuartzTriggerFactory
 */
public class QuartzTriggerFactory {
    public static Logger logger = LoggerFactory.getLogger(QuartzTriggerFactory.class);
    /**
     * 指定时间开始触发，不重复
     * 在指定时间time执行一次任务
    * @author joe
    * date 2018/9/20 11:27
    * param [triggerName:名字, triggerGroupName：所属组, time：任务执行时间]
    * return Trigger  创建成功返回Trigger对象，异常或者失败返回null
    */
    public static SimpleTrigger getSimpleTrigger(String triggerName, String triggerGroupName, Date time)
    {
        SimpleTrigger trigger  = null;
        try {
            trigger = (SimpleTrigger) TriggerBuilder.newTrigger()
                    .withIdentity(triggerName, triggerGroupName)
                    .startAt(time)
                    .build();
        } catch (Exception e) {
            logger.warn("执行getSimpleTrigger1异常",e);
        }
        return trigger;
    }


    /**
     * 指定time时间触发，每隔seconds秒执行一次，重复reNums次：
    * @author joe
    * date 2018/9/20 12:16
    * param [triggerName:触发器名称, triggerGroupName:触发器所属组名, time：开发触发时间,
     * seconds：隔多少秒执行一次, reNums:循环执行的次数]
    * return org.quartz.Trigger 创建成功返回Trigger对象，异常或者失败返回null
    */
    public static SimpleTrigger getSimpleTrigger(String triggerName, String triggerGroupName, Date time,
                                             int seconds,int repeatNum)
    {
        SimpleTrigger trigger  = null;
        try {
            trigger = TriggerBuilder.newTrigger()
                    .withIdentity(triggerName, triggerGroupName)
                    .startAt(time)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(seconds)
                            .withRepeatCount(repeatNum))
                    .build();
        } catch (Exception e) {
            logger.warn("执行getSimpleTrigger2异常",e);
        }
        return trigger;
    }

    /**
     * 建立一个触发器，从startTime开始执行，没seconds执行一次，直到endTime结束
    * @author joe
    * date 2018/9/20 12:39
    * param [triggerName:触发器名称, triggerGroupName:触发器所属组名,StartTime：开发触发时间,
     *seconds：隔多少秒执行一次, endTime:结束时间]
    * return org.quartz.Trigger
    */
    public static SimpleTrigger getSimpleTrigger(String triggerName, String triggerGroupName, Date startTime,
                                           int seconds,Date endTime)
    {
        SimpleTrigger trigger  = null;
        try {
            trigger = TriggerBuilder.newTrigger()
                    .withIdentity(triggerName, triggerGroupName)
                    .startAt(startTime)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(seconds)
                            .repeatForever())
                    .endAt(endTime)
                    .build();
        } catch (Exception e) {
            logger.warn("执行getSimpleTrigger3异常",e);
        }
        return trigger;
    }


    /**
     * 创建指定触发器
     * @param triggerName               触发器定义名称
     * @param triggerGroupName          触发器所属组
     * @param cron_expressions          触发器执行策略表达式
     * @return CronTrigger
     */
    public static CronTrigger getCronTrigger(String triggerName, String triggerGroupName,
                                         String cron_expressions)
    {
        logger.debug("开始获取CronTrigger["+triggerName+"]["+triggerGroupName+"]["+cron_expressions+"]");
        CronTrigger trigger  = null;
        try {
            trigger = TriggerBuilder.newTrigger()
                    .withIdentity(triggerName, triggerGroupName)
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron_expressions))
                    .build();
        } catch (Exception e) {
            logger.warn("执行getSimpleTrigger3异常",e);
        }
        return trigger;
    }
}
