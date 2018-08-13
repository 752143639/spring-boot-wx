package wx.realware.grp.pt.pb.respority.mybatis.basedao;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 基础操作，需要xml中sql对应
 * athord lfq
 * date 20180809
 * @param <T>
 */
public interface BaseDao <T> {
   void save(T t);
   void save(Map<String,Object> map);
   void batchSave(List<T> list);
   //返回值类型可以为 Boolean Long Integer,以及对应的基本类型
   int  update(T t);
   int  update(Map<String,Object> map);
   int  batchUpdate(List<T> list);
   int  delete (Object id);
   int  batchDelete(Object [] ids);
   int   delete(Map<String, Object> map);
   T query(Object id);
   T queryObject(T t);
    List<T> queryList(Map<String, Object> map);
    T queryOne(@Param("map") Map<String, Object> map,@Param("fileds") Object fields);
    T queryObject(T t,Object fields);
    List<T> queryList(Map<String, Object> map,Object fields);
    T queryOne(@Param("map") Map<String, Object> map);

    List<T> queryList(Object id);
    int queryTotal(Map<String, Object> map);
    int queryTotal();
    //key列名，value列值
    Map<String,Object>queryMap(Object id);
    //key指定，value,对象
    @MapKey("lastName")
    Map<String,T>queryMapObject(Object id);
}
