package wx.realware.grp.pt.pb.common.job;

 import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用于定时任务的创建、删除、修改等操作
 */
public class JobManagerAdapter {
    public  static Logger logger = LoggerFactory.getLogger(JobManagerAdapter.class);


    /**
     * Quartz的独立运行容器工厂
     */
    private static SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();

    /**
     * 添加一个定时任务
     * @param jobName  任务名
     * @param jobGroupName  任务组名
     * @param triggerName  触发器名
     * @param triggerGroupName  触发器组名
     * @param jobClass  任务
     * @param cron_expressions  时间设置，参考quartz说明文档
     * @throws SchedulerException
     *
     */
    public static void addPopularJob(String jobName, String jobGroupName,
                              String triggerName, String triggerGroupName, String jobClass,
                              String cron_expressions) {
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            Class className = Class.forName(jobClass);
            JobDetail jobDetail =JobBuilder.newJob(className).withIdentity(jobName,jobGroupName).build();
            CronTrigger trigger = QuartzTriggerFactory.getCronTrigger(triggerName,triggerGroupName,cron_expressions);
            sched.scheduleJob(jobDetail,trigger);
         } catch (Exception e) {
            logger.warn("执行addPopularJob异常",e);
            throw new RuntimeException("创建定时任务：+"+jobName+"失败："+e.getMessage());
        }
    }


    /**
     * 添加一个间隔任务
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     * @param jobClass
     * @param repeatCount
     * @param repeatInterval
     * @param delayTime
     */
    public static void addSimJob(String jobName,String jobGroupName,String triggerName, String triggerGroupName,String jobClass,int repeatCount,int repeatInterval,long delayTime){
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            long startTime = System.currentTimeMillis() +delayTime ;
            Class  className = Class.forName(jobClass) ;
            JobDetail jobDetail = JobBuilder.newJob(className).withIdentity(jobName,jobGroupName).build();
            SimpleTrigger trigger=TriggerBuilder.newTrigger().withIdentity(triggerName,triggerGroupName)
                    .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(repeatInterval).withRepeatCount(repeatCount)).startNow().build();

            //加入到调度器中
            sched.scheduleJob(jobDetail, trigger);
        }  catch (Exception e) {
            logger.warn("执行addSimJob异常",e);
            throw new RuntimeException("创建间隔任务：+"+jobName+"失败："+e.getMessage());
        }
    }


    /**
     * 修改定时任务的触发时间
     * @param triggerName
     * @param triggerGroupName
     * @param time
     */
    public static void modifyPopularJobTime(String triggerName,
                                     String triggerGroupName, String time) {
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
            CronTrigger trigger=(CronTrigger)sched.getTrigger(triggerKey);
             if (trigger == null) {
                return;
            }
            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(time)) {
                CronTrigger ct = (CronTrigger) trigger;
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(time);
                //按新的trigger重新设置job执行
                trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            }
        } catch (Exception e) {
            logger.warn("执行modifyPopularJobTime异常",e);
            throw new RuntimeException("修改定时任务触发器："+triggerName+"触发时间失败："+e.getMessage());
        }
    }

    /**
     * 移除一个任务
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     */
    public static void removeJob(String jobName, String jobGroupName,
                                 String triggerName, String triggerGroupName) {
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
            JobKey jobKey = JobKey.jobKey(jobName, triggerGroupName);
            sched.pauseTrigger(triggerKey);// 停止触发器
            sched.unscheduleJob(triggerKey);// 移除触发器
            sched.deleteJob(jobKey);// 删除任务
         } catch (Exception e) {
            logger.warn("执行removeJob异常",e);
            throw new RuntimeException("任务："+jobName+"删除失败：+"+e.getMessage());
        }
    }

    /**
     * 启动所有自动任务
     */
    public static void startJobs() {
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            sched.start();
        } catch (Exception e) {
            logger.warn("执行startJobs异常",e);
            throw new RuntimeException("启动自动任务失败："+e.getMessage());
        }
    }

    /**
     * 关闭所有自动任务
     */
    public static void shutdownJobs() {
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            if (!sched.isShutdown()) {
                sched.shutdown();
            }
        } catch (Exception e) {
            logger.warn("执行shutdownJobs异常",e);
            throw new RuntimeException("关闭自动任务失败："+e.getMessage());
        }
    }
}
