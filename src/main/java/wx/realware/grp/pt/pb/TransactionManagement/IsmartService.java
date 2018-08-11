package wx.realware.grp.pt.pb.TransactionManagement;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface IsmartService {
    /**
     * 开启小事务
     * @param execute
     */
     @Transactional(propagation= Propagation.REQUIRES_NEW)
    public void  newExecute(IsmartServiceExecute execute);

    /**
     * 删除事务
     * @param execute
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public void  NotSupportExecute(IsmartServiceExecute execute);


}
