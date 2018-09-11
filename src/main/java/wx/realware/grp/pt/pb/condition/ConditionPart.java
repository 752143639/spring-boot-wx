package wx.realware.grp.pt.pb.condition;

import java.io.Serializable;

/**
 * 条件类
 * edit by liufegnqiang
 * time 201808823
 */
public class ConditionPart  implements Serializable,Operator ,Comparable<ConditionPart>{
    /**
     * 数据库类型
     * 0 :mysql
     * 1 :oracle
     * 2 : Sybase
     * 3 :db
     */
    private int DataSourceType =0;
    /**


    /**
     * 运算符
     * 默认值 and
     * @param o
     * @return
     */

    private String LogicalOperator="and";

    private Boolean  isOperator  =false;

    /**
     * 字段名
     * @param o
     * @return
     */
    private String fieldName;

    /**
     * 字段值
     * @param o
     * @return
     */
    private String fieldValue;

    /**
     * 字段类型
     * 0：字符型
     * 1：整形
     * 2：日期
     * 3：金额
     *
     * @return
     */
    private int fieldType;

    /**
     * 是否格式化
     *
     * @param
     * @return
     */
    private Boolean isFormate=false;

    /**
     * 格式化表达式
     * @param o
     * @return
     */

    private String formatModel;

    /**
     * 排序(1,2,3,4)升序
     * @param o
     * @return
     */
    private Long discOrder;
    @Override
    public int compareTo(ConditionPart part) {
        if(this.discOrder>part.discOrder){
            return 1;
        }else if(this.discOrder==part.discOrder){
            return 0;
        }else{
            return -1;
        }
    }

    public int getDataSourceType() {
        return DataSourceType;
    }

    public void setDataSourceType(int dateSourceType) {
        DataSourceType = dateSourceType;
    }

    public String getLogicalOperator() {
        return LogicalOperator;
    }

    public void setLogicalOperator(String logicalOperator) {
        LogicalOperator = logicalOperator;
    }

    public Boolean getOperator() {
        return isOperator;
    }

    public void setOperator(Boolean operator) {
        isOperator = operator;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }


    public int getFieldType() {
        return fieldType;
    }

    public void setFieldType(int fieldType) {
        this.fieldType = fieldType;
    }

    public Boolean getFormate() {
        return isFormate;
    }

    public void setFormate(Boolean formate) {
        isFormate = formate;
    }

    public String getFormatModel() {
        return formatModel;
    }

    public void setFormatModel(String formatModel) {
        this.formatModel = formatModel;
    }

    public Long getDiscOrder() {
        return discOrder;
    }

    public void setDiscOrder(Long discOrder) {
        this.discOrder = discOrder;
    }
}
