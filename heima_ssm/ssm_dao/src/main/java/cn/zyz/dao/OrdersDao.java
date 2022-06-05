package cn.zyz.dao;

import cn.zyz.entity.Orders;

import java.util.List;

public interface OrdersDao {
    List<Orders> findAll();

    Orders findById(String ordersId);
}
