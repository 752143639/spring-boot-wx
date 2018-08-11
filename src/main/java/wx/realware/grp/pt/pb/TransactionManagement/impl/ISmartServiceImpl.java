package wx.realware.grp.pt.pb.TransactionManagement.impl;

import org.springframework.stereotype.Service;
import wx.realware.grp.pt.pb.TransactionManagement.IsmartService;
import wx.realware.grp.pt.pb.TransactionManagement.IsmartServiceExecute;

/**
 * 小事务
 */
@Service
public class ISmartServiceImpl implements IsmartService {

    @Override
    public void newExecute(IsmartServiceExecute execute) {

        execute.doExcute();
    }

    @Override
    public void NotSupportExecute(IsmartServiceExecute execute) {
        execute.doExcute();
    }
}
