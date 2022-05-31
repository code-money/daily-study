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
}
