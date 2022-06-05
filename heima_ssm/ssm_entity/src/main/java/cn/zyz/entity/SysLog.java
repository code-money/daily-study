package cn.zyz.entity;

import lombok.Data;

import java.util.Date;

/**
 * @program: heima_ssm
 * @author: zyz
 * @create: 2022-06-03 19:31
 **/


@Data
public class SysLog {
    private String id;
    private Date visitTime;
    private String visitTimeStr;
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;
}



