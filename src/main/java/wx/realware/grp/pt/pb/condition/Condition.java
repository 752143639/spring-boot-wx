package wx.realware.grp.pt.pb.condition;


import wx.realware.grp.pt.pb.common.util.CollectionUtils;
import wx.realware.grp.pt.pb.datasource.feature.DbFeatureFacotry;

import java.io.Serializable;
import java.util.Collections;
import java.util.*;
 /**
 * 条件拼写类
 */
public class Condition implements Serializable ,Operator{
    /**
     * 条件列表
     */
    private List<ConditionPart> parts=new ArrayList<>() ;

    /**
     * 特殊过滤条件
     */
    private String special_condition;

     /**
      * 添加part
      */
     public void addPars(ConditionPart part){
         parts.add(part);
     }
    /**
     * 获取一般过滤条件
     *
     * @return
     */
    public Map getCondition() {
        if(CollectionUtils.isListEmpty(parts)){
            return null;
        }
        // 对parts进行排序
        Collections.sort(parts);
        Map conditons=new HashMap();
        for (ConditionPart part : parts) {
            String filedValue=part.getFieldValue();
             //日期格式转换
            if(part.getFieldType()==2){
                 filedValue=DbFeatureFacotry.dbFeatury.coverDateTostr(filedValue,part.getFormatModel());
              }
           //逻辑拼写 or ,like等
            if(part.getLogicalOperator().equalsIgnoreCase(not_in)){
                filedValue= blank+not_in +blank +leftBracket + filedValue +blank +rightBracket;
            }else if(part.getLogicalOperator().equalsIgnoreCase(in) ){
                filedValue=blank+in +blank +leftBracket + filedValue +blank +rightBracket;

            }else  {
                filedValue= blank+part.getLogicalOperator() +blank  + filedValue  ;
            }


            conditons.put(part.getFieldName(),filedValue);
        }
        return conditons;
    }


}
