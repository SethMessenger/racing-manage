package com.wxmp.racingcms.mapper;

import com.wxmp.racingapi.vo.dto.SysUserRelDTO;
import com.wxmp.racingcms.domain.RUser;
import com.wxmp.racingcms.vo.view.RUserMatchView;
import com.wxmp.racingcms.vo.view.RUserView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RUserMapper {

    /**
     * 插入记录
     * @param record
     * @return
     */
    int insert(RUser record);

    /**
     * 查询全部记录
     * @return
     */
    List<RUser> selectAll();

    /**
     * 分页查询
     * @param filter
     * @return
     */
    List<RUser> listForPage(@Param("filter") RUser filter);

    /**
     * 分页查询
     * @param filter
     * @return
     */
    List<RUserView> viewListForPage(@Param("filter") RUser filter);

    /**
     * 更新记录
     * @param user
     * @return
     */
    int update(RUser user);

    /**
     * 冻结用户，不进行物理删除
     * @param uuid
     * @return
     */
    int deleteUser(@Param("uuid")String uuid);

    /**
     * 主键查询
     * @param uuid
     * @return
     */
    RUser getById(@Param("uuid") String uuid);

    /**
     * 分页查询
     * @param filter
     * @return
     */
    List<RUserMatchView> listUserMatchLogs(@Param("filter") RUser filter);

    /**
     * 查询用户的关联关系
     * @param sysUserUuids
     * @return
     */
    List<SysUserRelDTO> selectRelUsers(@Param("sysUserUuids")List<String> sysUserUuids);
}