package cn.zyz.mybatisplus_02_dql.dao;


import cn.zyz.mybatisplus_02_dql.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDao extends BaseMapper<User> {
}
