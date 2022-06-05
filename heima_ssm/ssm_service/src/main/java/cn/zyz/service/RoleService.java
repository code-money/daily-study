package cn.zyz.service;

import cn.zyz.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    void save(Role role);
}
