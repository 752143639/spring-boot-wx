package wx.realware.grp.pt.pb.respority.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

        Map<String,Object> conditionMap=new HashMap<String,Object>();
        conditionMap.put("id","1");
        conditionMap.put("d_id","1");
        String fileds="lastName,id,d_id";
        Employee employee2=null;
        try {
            PageHelper.startPage(1,4);

            employee2 = employeeMapper.queryOne(conditionMap,fileds);
            System.out.println(employee2.toString());


            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Employee employee3 = employeeMapper.queryOne(conditionMap,fileds);
        System.out.println( employee2==employee3);
        System.out.println(employee3.toString());
    }
    @Transactional(propagation = Propagation.REQUIRED)
    @Cacheable(cacheNames = "emp" ,key = "#id"  ,unless = "#result==null")
    public  Employee select(Object id){

        Map<String,Object> conditionMap=new HashMap<String,Object>();
        conditionMap.put("id",id);

        Employee employee2=null;

       PageHelper.startPage(1,4);

       employee2 = employeeMapper.queryOne(conditionMap,null);
        System.out.println(employee2.toString());
             return employee2;

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public  void update(){

        Employee employee2=new Employee();
        employee2.setId(1);
        employee2.setLastName("updatelfq..");
        employeeMapper.update(employee2);
        System.out.println("...........................");

    }




    }


