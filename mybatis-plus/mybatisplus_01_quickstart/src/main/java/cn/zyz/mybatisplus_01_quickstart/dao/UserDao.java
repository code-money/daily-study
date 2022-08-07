package cn.zyz.mybatisplus_01_quickstart.dao;

import cn.zyz.mybatisplus_01_quickstart.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDao extends BaseMapper<User> {
}
