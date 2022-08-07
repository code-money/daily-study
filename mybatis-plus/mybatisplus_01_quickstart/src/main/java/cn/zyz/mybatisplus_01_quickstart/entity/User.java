package cn.zyz.mybatisplus_01_quickstart.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @program: mybatis-plus
 * @author: zyz
 * @create: 2022-07-17 17:26
 **/


@Data
@NoArgsConstructor
@AllArgsConstructor
//@Accessors(chain = true)
public class User {
    @TableId
    private Long id;
    private String name;
    private String password;
    private Integer age;
    private String tel;
}



