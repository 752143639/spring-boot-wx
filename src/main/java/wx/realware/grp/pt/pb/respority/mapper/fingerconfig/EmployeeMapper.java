package wx.realware.grp.pt.pb.respority.mapper.fingerconfig;


import wx.realware.grp.pt.pb.bean.common.Employee;

/**
 * 配置型Mybits实例
 */
public interface EmployeeMapper {
    public Employee getEmpByid(int id);
    public  void insertEmp(Employee employee);
}
