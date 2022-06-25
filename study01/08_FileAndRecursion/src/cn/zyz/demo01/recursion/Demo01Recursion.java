package cn.zyz.demo01.recursion;

public class Demo01Recursion {
    public static void main(String[] args) {
        System.out.println(getSum(100));
        System.out.println(multiplication(4));
    }

    //递归求1-n的和
    public static int getSum(int num) {
        return num!=0 ? num+getSum(--num):0;
    }

    //递归求n的阶乘
    public static int multiplication(int num){
        if (num!=1){
            return num*multiplication(--num);
        }else {
            return 1;
        }
    }
}
