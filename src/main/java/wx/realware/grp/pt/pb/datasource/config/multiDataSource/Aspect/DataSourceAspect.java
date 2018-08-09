//package wx.realware.grp.pt.pb.jdbc.config.multiDataSource.Aspect;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.Ordered;
//import org.springframework.stereotype.Component;
//import wx.realware.grp.pt.pb.jdbc.config.multiDataSource.DataSourceNames;
//import wx.realware.grp.pt.pb.jdbc.config.multiDataSource.DynamicDataSource;
//import wx.realware.grp.pt.pb.jdbc.config.multiDataSource.annotation.DataSource;
//
//import java.lang.reflect.Method;
//
///**
// * 多数据原切面处理
// */
//@Aspect
//@Component
//public class DataSourceAspect  implements Ordered{
//    private   Logger logger= LoggerFactory.getLogger(getClass());
//
//   @Pointcut("@annotation(wx.realware.grp.pt.pb.jdbc.config.multiDataSource.annotation.DataSource)")
//   public void dataSourcePointCut(){
//
//   }
//   @Around("dataSourcePointCut()")
//   public Object around(ProceedingJoinPoint point) throws Throwable {
//       MethodSignature methodSignature= (MethodSignature) point.getSignature();
//       Method method=methodSignature.getMethod();
//       DataSource dataSource = method.getAnnotation(DataSource.class);
//       if(dataSource==null){
//           DynamicDataSource.setDataSource(DataSourceNames.FIRST);
//           logger.debug("set datasource " +DataSourceNames.FIRST);
//       }else {
//           DynamicDataSource.setDataSource(dataSource.name());
//           logger.debug("set datasource " +dataSource.name());
//       }
//
//
//
//          try {
//              return  point.proceed();
//           } finally {
//             DynamicDataSource.clearDataSource();
//             logger.debug("clear dataSource");
//          }
//   }
//    @Override
//    public int getOrder() {
//        return 1;
//    }
//}
