package wx.realware.grp.pt.pb.respority.mybatis.mapper.fingers;


import wx.realware.grp.pt.pb.bean.model.Employee;

/**
 * 配置型Mybits实例
 * ahthod lfq
 * date 20180808
 */
public interface EmployeeMapper {
    public Employee getEmpByid(int id);
    public  void insertEmp(Employee employee);
}
