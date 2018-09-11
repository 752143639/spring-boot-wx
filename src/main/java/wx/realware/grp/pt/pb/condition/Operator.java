package wx.realware.grp.pt.pb.condition;

/**
 * edit by liufengqiang
 * time 20180826
 */
public interface Operator {
    public   final  String like="like";
    public  final  String or="or";
    public  final  String in="in";
    public  final  String not_in="not in";
    public  final  String not_like="not in";
    public  final  String between ="between";
    public  final  String and ="and";
    public final String leftBracket="(";
    public final String rightBracket="(";
    public  final String eq="=";
    public  final String biger=">";
    public  final String samll="<";
    public  final String eqbiger=">=";
    public  final String eqsamll="=<";
    public  final  String sperator=",";
      /**
       * 空格
       */
      String blank=" ";

    public final String select="select";
    public final String update="update";
    public final String insert="insert";
    public final String into="into";
    public final String table="table";

    public final String delete="delete";
    public final String from="from";

}
