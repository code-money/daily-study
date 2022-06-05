package cn.zyz.entity;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @program: heima_ssm
 * @author: zyz
 * @create: 2022-06-02 12:49
 **/

@Data
public class UserInfo  {
    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;
    private String statusStr;
    private List<Role> roles;

    public String getStatusStr() {
        if (status==0){
            statusStr="关闭";
        }else if (status==1){
            statusStr="开启";
        }
        return statusStr;
    }
}



