package wx.realware.grp.pt.pb.interconfig;

import java.lang.annotation.*;

/**
 * edit liufengqiang
 * dto.filed-table.column
 * time：20180823
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface Column {
    String  value() default "";
}
