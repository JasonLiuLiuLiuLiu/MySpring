package site.iblogs.mall.dao;

import org.apache.ibatis.annotations.Param;
import site.iblogs.mall.mbg.model.UmsPermission;

import java.util.List;

/**
 * 后台用户与角色管理自定义Dao
 */
public interface UmsAdminRoleRelationDao {

    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
