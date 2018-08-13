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

import java.util.HashMap;
import java.util.Map;

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
        employee.setD_id(1);
        employee.setId(1);
        employee.setLastName("lfq");
       // System.out.println("update ...."+employeeMapper.update(employee));
       // System.out.println("delete ...."+employeeMapper.delete(9));
     //   Employee employee1 = employeeMapper.query(employee);

     //  System.out.println(employee1.toString());
        Map<String,Object> conditionMap=new HashMap<String,Object>();
         conditionMap.put("id","1");
        conditionMap.put("d_id","1");
        String fileds="last_name,id,d_id";
        Employee employee2 = employeeMapper.queryOne(conditionMap,fileds);

        System.out.println(employee2.toString());
//        Employee s=new Employee();
//
//        s.setEmail("update77");
//
//        s.setLastName("nameup77");
//        ismartService.newExecute(new IsmartServiceExecute() {
//            @Override
//            public void doExcute() {
//                employeeMapper.save(s);
//            }
//        });



    }

}
