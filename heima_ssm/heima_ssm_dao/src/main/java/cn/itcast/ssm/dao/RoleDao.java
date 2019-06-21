package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//查看角色
public interface RoleDao {

    @Select("select * from role r inner join users_role ur on r.id=ur.roleid where ur.userid=#{id}")
    List<Role> findRoleById(String id)throws Exception;
}
