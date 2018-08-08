package wx.realware.grp.pt.pb.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * ConfigurationProperties获取属性名称
 */
@Component
@PropertySource(value = {"classpath:properties/persion.properties"})
@ConfigurationProperties(prefix = "persion")
 public class Persion {
    private String name;
    private Integer age;
    private Map<String,Object> map;
    private List<String> lists;

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", map=" + map +
                ", lists=" + lists +
                '}';
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
