package wx.realware.grp.pt.pb.datasource.feature;

import org.apache.commons.lang.StringUtils;

import java.util.Date;

public class MysqlFeature extends  DbFeatury {
    @Override
    public String coverDateTostr(Date d,String format) {
        if(StringUtils.isNotBlank(format)){
            return    "date_format('" +FORMAT_SET.format(d) + "', '" + format +"')";
        }
        return    "date_format('" +FORMAT_SET.format(d) + "', '" + DateStr +"')";

    }

    @Override
    public String coverDateTostr(String date, String format) {
        if(StringUtils.isNotBlank(format)){
            return    "date_format('" +date + "', '" + format +"')";
        }
        return    "date_format('" +date + "', '" + DateStr +"')";
    }
}
