package cn.zyz.service;

import cn.zyz.entity.Role;
import cn.zyz.entity.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String userId);

    List<Role> findOtherRole(String userId);

    void addRoleToUser(String userId, String[] roleIds);
}
