package cn.zyz.entity;

import lombok.Data;
import org.springframework.security.core.userdetails.User;

import java.util.List;

/**
 * @program: heima_ssm
 * @author: zyz
 * @create: 2022-06-02 12:49
 **/


//角色
@Data
public class Role {
    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions;
    private List<UserInfo> users;
}



