package cn.zyz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: study05
 * @author: zyz
 * @create: 2022-05-29 15:55
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Integer id;
    private String name;
    private Double money;
}



