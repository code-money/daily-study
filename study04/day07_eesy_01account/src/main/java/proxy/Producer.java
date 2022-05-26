package proxy;

/**
 * @program: day01_eesy_03spring
 * @author: zyz
 * @create: 2022-05-23 11:33
 **/

public interface Producer {

    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money);

    /**
     * 售后
     * @param money
     */
    public void afterService(float money);
}



