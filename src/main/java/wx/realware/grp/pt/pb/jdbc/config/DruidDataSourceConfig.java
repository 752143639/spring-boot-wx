package wx.realware.grp.pt.pb.jdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRegistration;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidDataSourceConfig {
    /**
     * 获取自定义druidDataSource
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
     public DataSource druid(){
       return new DruidDataSource()  ;
     };

    /**
     * 添加自定义servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistration =new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String>initPara=new HashMap<>();
        initPara.put("loginUsername","lfq");
        initPara.put("loginPassword","1");
        initPara.put("loginPassword","1");
        servletRegistration.setInitParameters(initPara);
        return servletRegistration;
    }

    /**
     * 添加自定义过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean filterRegistrationBean =new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String,String>initPara=new HashMap<>();
        initPara.put("exclusions","*.jsp,*.js,*.css,/druid/*./hello");
         filterRegistrationBean.setInitParameters(initPara);
         filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
           return  filterRegistrationBean;
    }
}
