package wx.realware.grp.pt.pb.condition;

 import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import wx.realware.grp.pt.pb.common.exception.DataException;
 import wx.realware.grp.pt.pb.common.util.PlatformUtil;
 import wx.realware.grp.pt.pb.datasource.feature.DbFeatureFacotry;
 import wx.realware.grp.pt.pb.interconfig.Column;
import wx.realware.grp.pt.pb.interconfig.Table;

import java.io.Serializable;
 import java.lang.reflect.Field;
 import java.util.*;

/**
 * edit by liufengqiang
 * time 20180826
 * @param <T>
 */

public class Ctrter <T> implements Serializable,Operator {
    /**
     * 默认字段名称
     */
    private String fields [];
    private T obj;
    private String updateSql;
    private String selectSql;
    private String insertSql;
    private String deleteSql;
    /**
     *
     */
    private Map condition;
    /**
     * 默认表名称
     * @param t
     * @return
     */
    private String tableName ;
    public Ctrter() {

    }

    public void addCondition(Map cons){
         this.condition=cons;
    }
    /**
     * 构造方法
     * @param obj
     * @param fields
     * @param tableName
     */
    public Ctrter( T obj,String[] fields,String tableName) {
        this.fields = fields;
        this.obj=obj;
        this.tableName=tableName;
    }

    /**
     * 获取表明
     * @param
     * @return
     */
    public String getTableName( ){
        Class<?> cl= this.obj.getClass();
        String tableName="";
         //表名
        if(cl.isAnnotationPresent(Table.class) && StringUtils.isBlank(this.tableName)  ){
            Table table=    cl.getAnnotation(Table.class);
            tableName=table.value();
        }else if(StringUtils.isNotBlank(this.tableName)){
            tableName=this.tableName;
        }else{
            throw  new DataException("获取upateSql中tableName异常!");
        }
        return tableName;
    }
    /**
     * 获取字段名称
     */
    public String [] getFields(){
         String[] fields={};
        Class<?> cl= this.obj.getClass();
        List fieldList=new ArrayList<String> ();
        Field[] declaredFields = cl.getDeclaredFields();
         if(declaredFields[0].isAnnotationPresent(Column.class) && ArrayUtils.isEmpty(this.fields)){
             for( Field field:declaredFields){
                 String columnName= field.getAnnotation(Column.class).value();
                 fieldList.add(columnName);
             }
             fields=(String[]) fieldList.toArray();
         }else if( ArrayUtils.isNotEmpty(this.fields)){
             fields=this.fields;
         }else{
             throw  new DataException("获取对象属性字段异常!");
         }
         return  fields;
    }



    /**
     * 通用updateSql拼装
     * @return
     */
  public String updateSql(){
       StringBuffer upbf=new StringBuffer();
       upbf.append(Operator.update).append(Operator.blank);
       Class<?> cl= this.obj.getClass();

      Field[] declaredFields = cl.getDeclaredFields();
      //表名
      upbf.append(getTableName()) ;
      //
      if(declaredFields[0].isAnnotationPresent(Column.class) && ArrayUtils.isEmpty(this.fields)){
      for(Field filed:declaredFields){

              Column  column=  filed.getAnnotation(Column.class);
              String colName=column.value();
              Object colValue=  PlatformUtil.getProperty(this.obj,filed.getName());
              //日期格式处理
              if(colValue !=null && colValue instanceof Date){
                 Date dateValue=(Date)colValue;
                  colValue=  DbFeatureFacotry.getDbFeatury().coverDateTostr(dateValue,"");
              }

          upbf.append(" set ").append(colName).append(" = ").append(colValue).append(" , ");
            }
       }else{
            for( String filed:  this.fields){
                Object colValue=  PlatformUtil.getProperty(this.obj,filed);
                 //日期格式处理
                if(colValue !=null && colValue instanceof Date){
                    Date dateValue=(Date)colValue;
                    colValue= DbFeatureFacotry.getDbFeatury().coverDateTostr(dateValue,"");
                }

                upbf.append(" set ").append(filed).append(" = ").append(colValue).append(" , ");
            }
      }
        String updateSql=upbf.toString();


         return updateSql.substring(0,updateSql.lastIndexOf(","));
  }

    /**
     * 通用selectSql拼装
     * @return
     */

   public String selectSql(){
       StringBuffer tempSql=new StringBuffer();
       tempSql.append(Operator.select).append(Operator.blank);
        String []fields=this.getFields();
        for(String field:fields){
            tempSql.append(Operator.blank+field+Operator.sperator+Operator.blank);
        }
       String selectSql=tempSql.toString().substring(0,tempSql.toString().lastIndexOf(Operator.sperator));
       String tableName=this.getTableName();
       selectSql=selectSql+Operator.blank+Operator.from+Operator.blank+tableName;
        return  selectSql;
   };

    /**
     * 通用selectSql拼装
     * @return
     */

    public String insertSql(){
         StringBuffer tempSql=new StringBuffer();
        String tableName=this.getTableName();
        tempSql.append(Operator.insert).append(Operator.blank).append(Operator.into).append(Operator.blank).append(tableName).append(Operator.blank)
        .append(Operator.leftBracket).append(Operator.blank);
        String []fields=this.getFields();
        for(String field:fields){
            tempSql.append(Operator.blank+field+Operator.sperator+Operator.blank);
        }
        String insertSql=tempSql.toString().substring(0,tempSql.toString().lastIndexOf(Operator.sperator));
        insertSql=insertSql +Operator.blank+Operator.rightBracket;
        return  insertSql;
    };

    /**
     * 通用deletSql拼装
     * @return
     */

    public String deleteSql(){
        StringBuffer tempSql=new StringBuffer();
        String tableName=this.getTableName();
        tempSql.append(Operator.delete).append(Operator.blank).append(Operator.from).append(Operator.blank).append(tableName);
        return  tempSql.toString();
    };

    public String getUpdateSql() {
        return updateSql;
    }

    public void setUpdateSql(String updateSql) {
        this.updateSql = this.updateSql();
    }

    public void setSelectSql(String selectSql) {
        this.selectSql = this.selectSql();
    }

    public void setInsertSql(String insertSql) {
        this.insertSql = this.insertSql();
    }

    public String getDeleteSql() {
        return deleteSql;
    }

    public void setDeleteSql(String deleteSql) {
        this.deleteSql = this.deleteSql();
    }
}
