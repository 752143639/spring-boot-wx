package wx.realware.grp.pt.pb.datasource.feature;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wx.realware.grp.pt.pb.common.exception.DataException;
import wx.realware.grp.pt.pb.common.util.BeanFactoryUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbFeatureFacotry {
    public static  DbFeatury dbFeatury;
    public static  String  databaseProductName;
    public static Logger logger= LoggerFactory.getLogger(DbFeatureFacotry.class);
    public static DbFeatury getDbFeatury() {
        Connection connection =null;
        DataSource dataSource=null;
        if(dbFeatury==null){
             try{
                 dataSource= (DataSource) BeanFactoryUtil.getBean("druidDataSource");
                 connection = dataSource.getConnection();
                 databaseProductName= connection.getMetaData().getDatabaseProductName();
                 if(databaseProductName.toLowerCase().indexOf("oracle")!=-1){
                     dbFeatury=new OracleFeatrue();
                 }else if (databaseProductName.toLowerCase().indexOf("mysql")!=-1){
                     dbFeatury=new MysqlFeature();
                 }
             }catch(Exception e){
                 logger.info("获取数据库类型失败，原因",e);
                 throw  new DataException(e);
             }finally {

                 if(connection !=null){
                     try {
                         connection.close();
                     } catch (SQLException e1) {
                         logger.info("数据库连接关闭失败，原因..",e1);
                     }
                 }
             }


        }
        return dbFeatury;
    }
}
