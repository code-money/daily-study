package cn.zyz.dao;

import cn.zyz.entity.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findRoleByUserid(String userId);

    List<Role> findAll();

    void save(Role role);
}
