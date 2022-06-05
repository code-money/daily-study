package cn.zyz.service.impl;

import cn.zyz.dao.SysLogDao;
import cn.zyz.entity.SysLog;
import cn.zyz.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: heima_ssm
 * @author: zyz
 * @create: 2022-06-04 21:17
 **/

@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    SysLogDao sysLogDao;
    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }
}



