package wx.realware.grp.pt.pb.respority.mapper.annotation;


 import org.apache.ibatis.annotations.*;
 import wx.realware.grp.pt.pb.bean.common.Department;

/**
 * 注解型mybtis实例
 */
public interface DepartmentMapper {
    @Select("select * from department where id=#{id} ")
    public Department getById(int id);
    @Delete("delete from department where id=#{id}  ")
    public int deleteById(int id);
    @Options(useGeneratedKeys = true ,keyProperty = "id")
    @Insert("insert into department (departmentName) values (#{departmentName}) ")
    public int insertIn(Department department);
   @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDep(Department department) ;
}
