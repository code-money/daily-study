package proxy;

/**
 * @program: day01_eesy_03spring
 * @author: zyz
 * @create: 2022-05-23 11:37
 **/

public class ProducerDao implements Producer{
    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money){
        System.out.println("销售产品并拿到钱"+money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterService(float money){
        System.out.println("提供售后服务并拿到钱:"+money);
    }
}



