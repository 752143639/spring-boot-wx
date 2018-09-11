package wx.realware.grp.pt.pb.common.job;

 import org.quartz.*;
 import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 import java.util.Date;

public class QuartManager {
    public Logger logger = LoggerFactory.getLogger(QuartManager.class);


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
     * @param time  时间设置，参考quartz说明文档
     * @throws SchedulerException
     *
     */
    public static void addJob(String jobName, String jobGroupName,
                              String triggerName, String triggerGroupName, String jobClass,
                              String time) {
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            Class className = Class.forName(jobClass);
            JobDetail jobDetail =JobBuilder.newJob(className).withIdentity(jobName,jobGroupName).build();
             //2.0以下版本
            // new JobDetail(jobName, jobGroupName, Class.forName(jobClass));// 任务名，任务组，任务执行类
            //new CronTrigger(triggerName, triggerGroupName);// 触发器名,触发器组
            // 触发器
            CronTrigger trigger =TriggerBuilder.newTrigger().withIdentity(triggerName,triggerGroupName)
                    .withSchedule(CronScheduleBuilder.cronSchedule(time)).startNow().build();
            sched.scheduleJob(jobDetail,trigger);
         } catch (Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
            throw new RuntimeException("创建间隔任务：+"+jobName+"失败："+e.getMessage());
        }
    }


    /**
     * 修改定时任务的触发时间
     * @param triggerName
     * @param triggerGroupName
     * @param time
     */
    public static void modifyJobTime(String triggerName,
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
            throw new RuntimeException("关闭自动任务失败："+e.getMessage());
        }
    }


}
