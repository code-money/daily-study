package com.zyz.dao;

import com.zyz.entity.Role;

import java.util.List;

public interface RoleDao {

    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();
}
