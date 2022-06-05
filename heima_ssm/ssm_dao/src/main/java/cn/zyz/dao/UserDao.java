package cn.zyz.dao;

import cn.zyz.entity.Role;
import cn.zyz.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    UserInfo findByUsername (String username);

    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String userId);

    List<Role> findOtherRole(String userId);

    void addRoleToUser(@Param("userId") String userId,@Param("roleId") String roleId);
}
