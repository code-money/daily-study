package cn.zyz.dao;

import cn.zyz.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface AccountDao {

     @Select("select * from account")
     List<Account> findAll();

     @Insert("insert into account (name,money) values (#{name},#{money})")
     public void saveAccount(Account account);

}
