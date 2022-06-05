package cn.zyz.service.impl;

import cn.zyz.dao.OrdersDao;
import cn.zyz.entity.Orders;
import cn.zyz.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.aspectj.apache.bcel.classfile.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: heima_ssm
 * @author: zyz
 * @create: 2022-05-31 23:29
 **/


@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        List<Orders> list = ordersDao.findAll();
        return list;
    }

    @Override
    public Orders findById(String ordersId) {
        Orders orders = ordersDao.findById(ordersId);
        return orders;
    }
}



