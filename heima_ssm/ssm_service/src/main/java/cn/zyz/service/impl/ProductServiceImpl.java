package cn.zyz.service.impl;

import cn.zyz.dao.ProductDao;
import cn.zyz.entity.Product;
import cn.zyz.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: heima_ssm
 * @author: zyz
 * @create: 2022-05-30 22:36
 **/

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }
}



