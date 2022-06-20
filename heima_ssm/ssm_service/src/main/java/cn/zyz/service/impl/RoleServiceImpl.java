package cn.zyz.service.impl;

import cn.zyz.dao.RoleDao;
import cn.zyz.entity.Role;
import cn.zyz.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: heima_ssm
 * @author: zyz
 * @create: 2022-06-03 13:23
 **/

@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}



