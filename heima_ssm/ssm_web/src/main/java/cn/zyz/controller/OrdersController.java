package cn.zyz.controller;

import cn.zyz.entity.Orders;
import cn.zyz.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: heima_ssm
 * @author: zyz
 * @create: 2022-05-31 23:28
 **/
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(value = "page",defaultValue = "1") Integer page,@RequestParam(value = "size",defaultValue = "4") Integer size){
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> list = ordersService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(list);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-page-list");
        return modelAndView;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam("id") String ordersId){
        ModelAndView modelAndView = new ModelAndView();
        Orders orders = ordersService.findById(ordersId);
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("orders-show");

        return modelAndView;
    }
}



