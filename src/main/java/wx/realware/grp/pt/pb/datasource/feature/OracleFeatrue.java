package wx.realware.grp.pt.pb.datasource.feature;

import org.apache.commons.lang.StringUtils;

import java.util.Date;

public class OracleFeatrue extends  DbFeatury {

    @Override
    public String coverDateTostr(Date d,String format) {
        if(StringUtils.isNotBlank(format)){
            return  "to_date('" +FORMAT_SET.format(d) + "', '" + format +"')";
        }
     return    "to_date('" +FORMAT_SET.format(d) + "', '" + DateStr +"')";
    }

    @Override
    public String coverDateTostr(String date, String format) {
        if(StringUtils.isNotBlank(format)){
            return  "to_date('" +date + "', '" + format +"')";
        }
        return    "to_date('" +date + "', '" + DateStr +"')";
    }


}
