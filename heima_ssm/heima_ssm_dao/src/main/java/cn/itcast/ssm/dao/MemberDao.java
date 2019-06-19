package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {
    @Select("select * from member where id=#{id}")
    Member findById(String id) throws Exception;
}
