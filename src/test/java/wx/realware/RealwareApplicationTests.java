package wx.realware;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import wx.realware.grp.pt.pb.respority.mybatis.mapper.fingers.EmployeeDao;
import wx.realware.grp.pt.pb.respority.service.impl.CommonServiceImpl;
import wx.realware.wx.token.job.AutoAccessTokenJob;

import javax.sql.DataSource;


@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
public class RealwareApplicationTests {
 @Autowired
 DataSource dataSource;
	@Autowired
	EmployeeDao employeeMapper;
	@Autowired
	CommonServiceImpl commonService;

	@Autowired
	AutoAccessTokenJob job;
	@Test
	public void contextLoads() {
		System.out.println(dataSource.getClass());
	}



    @Test
	public  void crdl(){

		commonService.crdl();

	}
	@Test
	public  void crdl2(){

		commonService.update();

	}

	@Test
	public  void setJobTest(){

		job.pringTest();

	}
}
