package wx.realware.grp.pt.pb.respority.mybatis.mapper.fingers;


import wx.realware.grp.pt.pb.bean.model.Employee;
import wx.realware.grp.pt.pb.respority.mybatis.basedao.BaseDao;

/**
 * 配置型Mybits实例
 * ahthod lfq
 * date 20180808
 */
public interface EmployeeDao extends BaseDao<Employee> {
    public Employee getEmpByid(int id);
    public Employee getEmpByDid(int id ,int d_id);
    public  void insertEmp(Employee employee);
}
