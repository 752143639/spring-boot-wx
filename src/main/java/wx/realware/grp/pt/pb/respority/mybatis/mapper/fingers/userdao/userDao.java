package wx.realware.grp.pt.pb.respority.mybatis.mapper.fingers.userdao;

import wx.realware.grp.pt.pb.entry.base.user.UserEntry;

import java.util.List;
import java.util.Map;

public interface userDao {
    /**
     * 查询用户的所有权限
     * @param userId  用户ID
     */
    List<String> queryAllPerms(Long userId);

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     * 根据用户名，查询系统用户
     */
    UserEntry queryByUserName(String username);

    /**
     * 修改密码
     */
    int updatePassword(Map<String, Object> map);
}
