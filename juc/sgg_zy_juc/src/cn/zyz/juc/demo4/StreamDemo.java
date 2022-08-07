package cn.zyz.juc.demo4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-07-16 11:21
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    private int id;
    private String userName;
    private int age;
}


/**
 * 题目：请按照给出数据，找出同时满足以下条件的用户，也即以下条件全部满足
 * 偶数ID且年龄大于24且用户名转为大写且用户名字母到排序
 * 只输出一个用户名字
 */
public class StreamDemo {
    public static void main(String[] args) {
        User u1 = new User(25, "a", 26);
        User u2 = new User(18, "b", 13);
        User u3 = new User(32, "c", 30);
        User u4 = new User(15, "d", 20);
        User u5 = new User(46, "e", 25);
        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);
        //原始API完成
        /*List<User> list1 = new ArrayList<>();
        for (User user : list) {
            if (user.getId()%2!=0 || user.getAge()<=24){
                continue;
            }
            user.setUserName(user.getUserName().toUpperCase(Locale.ROOT));
            list1.add(user);
        }
        list1.sort((a,b)->{
//            return a.getUserName() - b.getUserName();
            return b.getId()-a.getId();
        });
        System.out.println(list1);*/

        //Stream流写法
        list.stream()
                .filter(user -> user.getId() % 2 == 0 && user.getAge() > 24)
                .map(user -> {
                    user.setUserName(user.getUserName().toUpperCase(Locale.ROOT));
                    return user;
                })
                .sorted((uu1, uu2) -> uu2.getId() - uu1.getId())
                .limit(1)
                .forEach(System.out::println);

    }
}



