package wx.realware.grp.pt.pb.respority.service.impl;


import org.apache.commons.collections.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import wx.realware.grp.pt.pb.common.job.QuartManager;
import wx.realware.grp.pt.pb.common.util.CollectionUtils;
import wx.realware.grp.pt.pb.condition.Condition;
import wx.realware.grp.pt.pb.condition.ConditionPart;
import wx.realware.grp.pt.pb.condition.Ctrter;
import wx.realware.grp.pt.pb.entry.job.QuartJobEntity;
import wx.realware.grp.pt.pb.respority.mybatis.mapper.fingers.jobdao.QuartDao;
import wx.realware.grp.pt.pb.respority.service.JobService;

import java.util.List;

@Service("wx.realware.grp.pt.pb.respority.service.impl.JobServiceImpl")
public class JobServiceImpl implements JobService {

    @Autowired
   public QuartDao quartDao;

    /**
     * 启动自动任务
     */
    @Override
  public void start(){
      List<QuartJobEntity>quartJobEntities=  this.getQuartList();
     if(CollectionUtils.isListEmpty(quartJobEntities)){
         return;
     }
  for(QuartJobEntity  quartJobEntitie :quartJobEntities ){
   //crontrigger 定时任务
    if(quartJobEntitie.getJob_type()==2){
        QuartManager.addJob(quartJobEntitie.getJob_name(),quartJobEntitie.getJob_name(),quartJobEntitie.getJob_name(),quartJobEntitie.getJob_name(),quartJobEntitie.getClass_name(),quartJobEntitie.getJob_time());
   //线程或间隔任务
    }else if(quartJobEntitie.getJob_type()==2){
        QuartManager.addSimJob(quartJobEntitie.getJob_name(),quartJobEntitie.getJob_name(), quartJobEntitie.getJob_name(),quartJobEntitie.getJob_name(),
                quartJobEntitie.getClass_name(),quartJobEntitie.getRepearcount(),quartJobEntitie.getJob_interval(),quartJobEntitie.getDelaytime());

    }

  }

  }
 @Transactional(propagation = Propagation.REQUIRED)
  public  List<QuartJobEntity> getQuartList(){
        ConditionPart conditionPart=new ConditionPart();
        conditionPart.setFieldName("is_enbaled");
        conditionPart.setFieldValue("1");
        Condition condition=new Condition();
        condition.addPars(conditionPart);
        Ctrter<QuartJobEntity> ctrter=new Ctrter<QuartJobEntity>(QuartJobEntity.class);
        ctrter.addCondition(condition.getCondition());
        //获取查询sql语句
        ctrter.setSelectSql();
        List<QuartJobEntity> quartJobEntities = quartDao.queryList(ctrter);
        return  quartJobEntities;
    }



}
