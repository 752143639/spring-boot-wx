package wx.realware.grp.pt.pb.respority.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import wx.realware.grp.pt.pb.TransactionManagement.IsmartService;
import wx.realware.grp.pt.pb.TransactionManagement.IsmartServiceExecute;
import wx.realware.grp.pt.pb.bean.model.Employee;
import wx.realware.grp.pt.pb.respority.mybatis.mapper.fingers.EmployeeDao;
import wx.realware.grp.pt.pb.respority.service.CommonService;

/**
 * 通用接口实现类
 */
@Service
public class CommonServiceImpl  implements CommonService{
    @Autowired
    EmployeeDao employeeMapper;
    @Autowired
    IsmartService ismartService;
    @Transactional(propagation = Propagation.REQUIRED)
    public  void crdl(){
        Employee employee=new Employee();

        employee.setId(6);
        employee.setEmail("update7");

        employee.setLastName("nameu7");
        System.out.println("update ...."+employeeMapper.update(employee));
        System.out.println("delete ...."+employeeMapper.delete(9));
       Employee employee1 = employeeMapper.query(10);
//
//        System.out.println(employee1.getLastName());
        Employee s=new Employee();

        s.setEmail("update77");

        s.setLastName("nameup77");
        ismartService.newExecute(new IsmartServiceExecute() {
            @Override
            public void doExcute() {
                employeeMapper.save(s);
            }
        });

        int i= 1/0;


    }

}
