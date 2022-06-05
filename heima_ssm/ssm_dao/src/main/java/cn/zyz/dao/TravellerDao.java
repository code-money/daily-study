package cn.zyz.dao;

import cn.zyz.entity.Traveller;
import lombok.Data;

import java.util.List;

/**
 * @program: heima_ssm
 * @author: zyz
 * @create: 2022-05-31 23:26
 **/


public interface TravellerDao {

    List<Traveller> findByOrdersId(String ordersId);

}



