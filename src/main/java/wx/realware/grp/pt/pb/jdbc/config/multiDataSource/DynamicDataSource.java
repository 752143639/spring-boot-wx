//package wx.realware.grp.pt.pb.jdbc.config.multiDataSource;
//
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 多数据源取值，针对不同实例名
// */
//public class DynamicDataSource extends AbstractRoutingDataSource {
//
//
//    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
//
//    public DynamicDataSource(DataSource defaultTargetDataSource, Map<String, DataSource> targetDataSources) {
//        super.setDefaultTargetDataSource(defaultTargetDataSource);
//        super.setTargetDataSources(new HashMap<>(targetDataSources));
//        super.afterPropertiesSet();
//    }
////获取数据源，没有指定，则为默认数据源
//    @Override
//    protected Object determineCurrentLookupKey() {
//        return getDataSource();
//    }
//
//    public static void setDataSource(String dataSource) {
//        contextHolder.set(dataSource);
//    }
//
//    public static String getDataSource() {
//        return contextHolder.get();
//    }
//
//    public static void clearDataSource() {
//        contextHolder.remove();
//    }
//}
