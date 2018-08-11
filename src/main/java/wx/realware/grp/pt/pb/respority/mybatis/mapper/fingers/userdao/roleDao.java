package wx.realware.grp.pt.pb.respority.mybatis.mapper.fingers.userdao;

import java.util.List;

/**
 * 权限
 * athord lfq
 * date 20180810
 */
public interface roleDao {

    /**
     * 根据用户ID，获取角色ID列表
     */
    List<Long> queryRoleIdList(Long userId);
}
