package com.zyz.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyz.dao.ProvinceDao;
import com.zyz.dao.impl.ProvinceDaoImpl;
import com.zyz.entity.Province;
import com.zyz.service.ProvinceService;
import com.zyz.util.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @program: study04
 * @author: zyz
 * @create: 2022-05-12 00:21
 **/

public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao provinceDao=new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return provinceDao.findAll();
    }

    @Override
    public String findAllJson() {
        //1.先从redis中查询数据
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");

        //2.判断province_json数据是否为null
        if (province_json == null || province_json.length()==0){
            //缓存中没有数据
            System.out.println("查询数据库");
            //2.1从数据库中查询
            List<Province> ps = provinceDao.findAll();
            //2.2将list序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //2.3 将json存入redis中
            jedis.set("province",province_json);
            //归还连接
            jedis.close();
        }else {
            System.out.println("查询缓存");
        }
        return province_json;
    }
}



