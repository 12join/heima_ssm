package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionsDao {

    @Select("select * from permission p inner join role_permission rp on p.id=rp.permissionid where rp.roleid=#{id}")
    List<Permission> findPerById(String id) throws Exception;
}
