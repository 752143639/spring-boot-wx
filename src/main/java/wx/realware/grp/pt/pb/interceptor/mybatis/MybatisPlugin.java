package wx.realware.grp.pt.pb.interceptor.mybatis;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Statement;
import java.util.Properties;

/**
 * 当前插件用来拦截目标（插件签名）
 */
@Intercepts(
        {@Signature(type = StatementHandler.class,method ="parameterize",args = Statement.class)}
)
public class MybatisPlugin   implements Interceptor{
    private Logger log= LoggerFactory.getLogger(MybatisPlugin.class);
    /**
     * 拦截方法
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object targer=invocation.getTarget();
        //target元数据
         MetaObject metaObject= SystemMetaObject.forObject(targer);
         //statment执行sql参数值
         Object value= metaObject.getValue("parameterHandler.parameterObject");
       log.info("参数执行值："+value);
        // metaObject.setValue("getParameterObject",2);
        //执行目标方法
       Object object = invocation.proceed();

        return object;
    }

    /**
     * 包装目标对象
     * 创建代理对象
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        //wrap包装
        Object  wrap= Plugin.wrap(target,this);
        return wrap;
    }

    /**
     * 插件配置信息
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {
        System.out.println(properties);
    }
}
