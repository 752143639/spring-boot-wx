package wx.realware.grp.pt.pb.common.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class PlatformUtil implements Serializable {
    public static Logger logger  =  LoggerFactory.getLogger(PlatformUtil.class);

    public static void setProperty(Object obj,String name,String value){
     if(obj instanceof Map){
         ((Map) obj).put(name,value);
     }else{
         try{

             BeanUtils.setProperty(obj,name,value);
         }catch (Exception e){
             logger.error("字段" +name + " :" + value +"赋值失败！",e);

         }

     }

    }


    public static Object getProperty(Object obj ,String name){
        //字段值
        Object result = null;

        if (obj instanceof Map) {
            result = (Object) ((Map) obj).get(name);
            if(result == null) {
                result = (Object) ((Map) obj).get(name.toLowerCase());
            }
            if(result == null) {
                result = (Object) ((Map) obj).get(name.toUpperCase());
            }
        } else

            try{
                if(PropertyUtils.isReadable(obj, name)){

                    result =  PropertyUtils.getProperty( obj, name );

                }else if(PropertyUtils.isReadable(obj, name.toLowerCase())){

                    result =  PropertyUtils.getProperty( obj, name.toLowerCase() );

                }else if(PropertyUtils.isReadable(obj, name.toUpperCase())){

                    result =  PropertyUtils.getProperty( obj, name.toUpperCase() );
                }
            }catch(Exception ex){
                logger.error("错误："+obj.getClass().getName()+"取不到"+name+"#",ex);
            }
           return result;

    }
}
