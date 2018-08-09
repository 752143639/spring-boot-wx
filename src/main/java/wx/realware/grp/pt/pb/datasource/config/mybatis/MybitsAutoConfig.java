package wx.realware.grp.pt.pb.datasource.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注解版，sql忽略大小写
 */
@Configuration
@MapperScan(value = "wx.realware.grp.pt.pb.respority.mapper")
public class MybitsAutoConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){

        return  new ConfigurationCustomizer(){
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
