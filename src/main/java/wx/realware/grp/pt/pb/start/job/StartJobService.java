package wx.realware.grp.pt.pb.start.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import wx.realware.grp.pt.pb.respority.service.JobService;

import java.io.Serializable;


/**
 * 服务启动时，自动执行order执行顺序
 * editby liufengqiang
 * time 20180901
 */
@Component
@Order(value = 1)
public class StartJobService implements ApplicationRunner,Serializable {
    Logger logger = LoggerFactory.getLogger(StartJobService.class);
    @Autowired
    JobService jobService;
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        /**
         * 启动自动任务
         *
         */
        logger.info("开始加载自动任务........");
        jobService.start();
        logger.info("完成加载自动任务........");
    }
}
