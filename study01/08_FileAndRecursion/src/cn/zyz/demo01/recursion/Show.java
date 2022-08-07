package cn.zyz.demo01.recursion;

/**
 * @program: study01
 * @author: zyz
 * @create: 2022-07-22 10:41
 **/

public class Show {
    public void show(int i){
        if (i>0){
            throw new MyException("不能大于0");
        }
        System.out.println("展示一下:"+i);
    }
}



