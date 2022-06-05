package cn.zyz.service;

import cn.zyz.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);
}
