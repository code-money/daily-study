package cn.zyz.dao;

import cn.zyz.entity.Member;

public interface MemberDao {

    Member findById(String id);
}
