package wx.realware.grp.pt.pb.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.Serializable;
import java.util.Map;

public class BeanFactoryUtil implements ApplicationContextAware,Serializable {
    private static ApplicationContext applicationContext;

    public   void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }

    public Map getBeansOfType(Class type) throws BeansException {
        return applicationContext.getBeansOfType(type);
    }

}
