//package wx.realware.grp.pt.pb.jdbc.config.multiDataSource;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
//@Configuration
//public class DynamicDataSourceConfig {
//// 数据源 读取spring.datasource.druid.first下的配置信息
//    @Bean
//    @ConfigurationProperties("spring.datasource.druid.first")
//    public DataSource firstDataSource(){
//        return DruidDataSourceBuilder.create().build();
//    }
//// 数据源 读取spring.datasource.druid.second下的配置信息
//    @Bean
//    @ConfigurationProperties("spring.datasource.druid.second")
//    public DataSource secondDataSource(){
//        return DruidDataSourceBuilder.create().build();
//    }
//    //加了@Primary注解，表示指定DynamicDataSource为Spring的数据源
//    //因为DynamicDataSource是继承与AbstractRoutingDataSource，
//    // 而AbstractRoutingDataSource又是继承于AbstractDataSource，
//    // AbstractDataSource实现了统一的DataSource接口，所以DynamicDataSource也可以当做DataSource使用
//    @Bean
//    @Primary
//    public DynamicDataSource dataSource(DataSource firstDataSource, DataSource secondDataSource) {
//        Map<String, DataSource> targetDataSources = new HashMap<>();
//        targetDataSources.put(DataSourceNames.FIRST, firstDataSource);
//        targetDataSources.put(DataSourceNames.SECOND, secondDataSource);
//        return new DynamicDataSource(firstDataSource, targetDataSources);
//    }
//
//}
