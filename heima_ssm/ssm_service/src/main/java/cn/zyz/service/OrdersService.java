package cn.zyz.service;

import cn.zyz.entity.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> findAll(int page,int size);

    Orders findById(String ordersId);
}
