package cn.zyz.mybatisplus_02_dql.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: mybatis-plus
 * @author: zyz
 * @create: 2022-07-17 17:26
 **/


@Data
@NoArgsConstructor
@AllArgsConstructor
//@Accessors(chain = true)
@TableName("tbl_user")   //设置实体类和数据库表名的映射
public class User {
    @TableId  //主键注解
    private Long id;
    private String name;
    @TableField(value = "pwd",select = false) //1.设置数据库字段名映射  2.设置是否参与查询
    private String password;
    private Integer age;
    private String tel;

    @TableField(exist = false)  //当实体类里的字段数据库中不存在时，添加该注解
    private Integer online;
}



