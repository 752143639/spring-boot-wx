package wx.realware.wx.token.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service( "AutoAccessTokenJob")
public class AutoAccessTokenJob {
    @Scheduled(cron="1,5,9,13 * * * * ?")
    public void pringTest(){
        String time=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        System.out.println("我的时间" +time);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
