package cn.zyz.dao;

import cn.zyz.entity.Permission;

import java.util.List;

public interface PermissionDao {
    List<Permission> findPermissionByRoleId(String roleId);
}
