package cn.zyz.entity;

import lombok.Data;

import java.util.List;

/**
 * @program: heima_ssm
 * @author: zyz
 * @create: 2022-06-02 12:50
 **/

@Data
public class Permission {
    private String id;
    private String permissionName;
    private String url;
    private List<Role> roles;
}



