package cn.zyz.juc.completable;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 *
 * 案例说明：电商比价需求
 * 1 同一款产品，同时搜索出同款产品在各大电商的售价;
 * 2 同一款产品，同时搜索出本产品在某一个电商平台下，各个入驻门店的售价是多少
 *
 * 出来结果希望是同款产品的在不同地方的价格清单列表，返回一个List
 * 《mysql》 in jd price is 88.05
 * 《mysql》 in pdd price is 86.11
 * 《mysql》 in taobao price is 90.43
 *
 * 技术要求
 *    函数式编程
 *    链式编程
 *    Stream流式计算
 */
public class CompletableFutureNetMallDemo {

    //模拟初始化三家平台
    static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("dangdang"),
            new NetMall("taobao")
    );

    /**
     * 一家一家查询，最后转换为一个List集合
     * @param list
     * @param productName
     * @return
     */
    public static List<String> getPrice(List<NetMall> list,String productName){
        List<String> netMallPriceList = list.stream().map(netMall -> {
            //----流式计算做了映射（利用map），希望出来的是有格式的字符串（利用String.format）,%是占位符
            return String.format(productName + " in %s price is %.2f",
                    netMall.getNetMallName(),
                    netMall.calcPrice(productName));
        }).collect(Collectors.toList());
        return netMallPriceList;
    }

    /**
     * 使用CompletableFuture做异步操作，大大节省时间
     * @param list
     * @param productName
     * @return
     */
    public static List<String> getPriceByCompletableFuture(List<NetMall> list,String productName){
        return list.stream().map(netMall ->
                CompletableFuture.supplyAsync(() -> String.format(productName + " in %s price is %.2f",
                        netMall.getNetMallName(),
                        netMall.calcPrice(productName))))//Stream<CompletableFuture<String>>
                        .collect(Collectors.toList())//List<CompletablFuture<String>>
                        .stream()//Stream<CompletableFuture<String>
                        .map(s->s.join())//Stream<String>
                        .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<String> mysql = getPrice(list,"mysql");
        mysql.forEach(System.out::println);
        long end = System.currentTimeMillis();
        double times=end-start;
        System.out.println("总耗时为："+times);


        long start2 = System.currentTimeMillis();
        List<String> mysql2 = getPriceByCompletableFuture(list, "mysql");
        mysql.forEach(System.out::println);
        long end2 = System.currentTimeMillis();
        double times2=end2-start2;
        System.out.println("总耗时为："+times2);
    }
}



class NetMall{
    @Getter
    private String netMallName;

    public NetMall(String netMallName) {
        this.netMallName = netMallName;
    }

    public double calcPrice(String productName){
        try { TimeUnit.SECONDS.sleep(1);}catch (Exception e){e.printStackTrace();}

        //模拟平台的商品价格
        return ThreadLocalRandom.current().nextDouble(1,3)*2+productName.charAt(0);
    }
}


