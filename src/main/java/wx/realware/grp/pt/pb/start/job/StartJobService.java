package wx.realware.grp.pt.pb.start.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        /**
         * 启动
         */

    }
}
