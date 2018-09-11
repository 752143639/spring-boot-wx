package wx.realware.grp.pt.pb.datasource.feature;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public  abstract class DbFeatury implements Serializable {

    public static final  String DateStr = "yyyy-MM-dd HH24:mi:ss";

    public static final String TYPE_TABLE = "TABLE";
    public static final String TYPE_VIEW = "VIEW";

    public static final SimpleDateFormat FORMAT_SET = new SimpleDateFormat(DateStr);

     public abstract String coverDateTostr(Date date,String format);
     public abstract String coverDateTostr(String date,String format);
}
