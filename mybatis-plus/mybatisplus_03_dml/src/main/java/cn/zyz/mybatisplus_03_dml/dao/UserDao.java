package cn.zyz.mybatisplus_03_dml.dao;



import cn.zyz.mybatisplus_03_dml.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDao extends BaseMapper<User> {
}
