package com.zyz.dao.impl;

import com.zyz.dao.ProvinceDao;
import com.zyz.entity.Province;
import com.zyz.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @program: study04
 * @author: zyz
 * @create: 2022-05-12 00:20
 **/

public class ProvinceDaoImpl implements ProvinceDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Province> findAll() {
        String sql = "select * from province";
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<>(Province.class));
        return list;
    }
}



