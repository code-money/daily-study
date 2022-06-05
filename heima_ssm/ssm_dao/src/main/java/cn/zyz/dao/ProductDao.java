package cn.zyz.dao;

import cn.zyz.entity.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {
    /**
     * 查询所有的产品信息
     * @return
     */
    public List<Product> findAll();

    /**
     * 新增信息
     * @param product
     */
    void save(Product product);


    /**
     * 根据id查询产品信息
     * @return
     */
    Product findById(String id);
}
