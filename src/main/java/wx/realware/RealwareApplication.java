package wx.realware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;


@SpringBootApplication
public class RealwareApplication {
	public static void main(String[] args) {
		SpringApplication.run(RealwareApplication.class, args);
	}
}
