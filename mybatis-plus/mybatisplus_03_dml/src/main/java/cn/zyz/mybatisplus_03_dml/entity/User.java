package cn.zyz.mybatisplus_03_dml.entity;

import com.baomidou.mybatisplus.annotation.*;
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
@TableName("tbl_user")
public class User {
    /**
     *  AUTO(0):使用数据库id自增策略控制id生成
     *  NONE(1):不设置id生成策略
     *  INPUT(2):用户手工输入id
     *  ASSIGN_ID(3):雪花算法生成id
     *  ASSIGN_UUID(4):以UUID生成算法作为id生成策略
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    @TableField(value = "pwd")
    private String password;
    //设置自动填充
    @TableField(fill = FieldFill.INSERT)
    private Integer age;
    private String tel;
    //当实体类里的字段数据库中不存在时，添加该注解
    @TableField(exist = false)
    private Integer online;
    //逻辑删除字段，表示当前记录是否被删除  被逻辑删除的数据不会参与到DML和DQL语句中
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
    //乐观锁
    @Version
    private Integer version;


}



