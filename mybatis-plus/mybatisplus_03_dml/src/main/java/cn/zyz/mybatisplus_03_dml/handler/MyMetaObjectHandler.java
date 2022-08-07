package cn.zyz.mybatisplus_03_dml.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @program: mybatis-plus
 * @author: zyz
 * @create: 2022-07-19 21:01
 * MP自动填充策略类
 **/

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {


    /**
     * 插入数据自动填充设置
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,"age",Integer.class,18);
    }

    /**
     * 修改数据自动填充设置
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,"age",Integer.class,18);
    }
}



