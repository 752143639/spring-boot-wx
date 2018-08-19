package wx.realware.grp.pt.pb.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import wx.realware.grp.pt.pb.bean.model.Employee;
import wx.realware.grp.pt.pb.properties.config.Persion;
import wx.realware.grp.pt.pb.respority.mybatis.mapper.fingers.EmployeeDao;
import wx.realware.grp.pt.pb.respority.service.impl.CommonServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 实例controller
 */
@Controller
public class ModelController {

    @Autowired
    private EmployeeDao employeeMapper;
    @Value("${persion.name}")
    private  String name;
    @Autowired
    CommonServiceImpl commonService;
    @Autowired
    private Persion persion;
   private Logger logger=LoggerFactory.getLogger(ModelController.class);
    /**
     *获取emp
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET ,value = "/hello/{id}")
    public String getEmp(@PathVariable("id")   int id) throws  Exception{
         try{
             Employee employee = employeeMapper.getEmpByid(id);
             logger.info(employee.toString());

         }catch (Exception e){
            logger.info("11",e);
         }

        return  "Hello";

    }

  @RequestMapping(value = "/abc")
    public ModelAndView getModel(Model model) {
      model.addAttribute("msg","您好");
      logger.info(persion.toString());
        return new ModelAndView("sucess");
    }
    @RequestMapping(value = "/bcd")
    public String getModel2(Model model){
        model.addAttribute("msg","您好");
        logger.info(persion.toString());
        return  "sucess";
    }
    @RequestMapping(value = "/cde")
    public void getModel3( HttpServletResponse response, HttpServletRequest request){
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
      //  model.addAttribute("msg","您好");
        logger.info(persion.toString());
        writer.write("wo们的中国abc");
    }

    /**
     * 查询
     * @param
     * @return
     */
    @RequestMapping(value = "/select/{id}")
    public String insert(@PathVariable("id")  int id){
        try{
            commonService.select(id);
        }catch(Exception e){
            logger.info("e",e);
        }

        return  "sucess";
    }

    /**
     * 删除
     * @param
     * @return
     */
    @RequestMapping(value = "/delete/")
    public String delete(@PathVariable("id") int id){

        employeeMapper.delete(id);
        return  "sucess";
    }
//    /**
//     * 查询
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "/select/{id}")
//    public String select(@PathVariable("id") int id,Model model){
//
//       Employee employee= employeeMapper.query(id);
//        model.addAttribute("name",employee.getLastName());
//        return  "sucess";
//    }
    /**
     * 更新
     * @param model
     * @return
     */
    @RequestMapping(value = "/delete")
    public String update(@PathVariable("id") int id,Model model){
        Employee employee =new Employee();
        employee.setLastName("update");

       int i = employeeMapper.update(employee);
        model.addAttribute("name",i );
        return  "sucess";
    }


}
