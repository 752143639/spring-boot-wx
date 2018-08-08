package wx.realware.grp.pt.pb.respority.mapper.fingerconfig;


import wx.realware.grp.pt.pb.bean.common.Employee;

/**
 * 配置型Mybits实例
 * ahthod lfq
 * date 20180808
 */
public interface EmployeeMapper {
    public Employee getEmpByid(int id);
    public  void insertEmp(Employee employee);
}
