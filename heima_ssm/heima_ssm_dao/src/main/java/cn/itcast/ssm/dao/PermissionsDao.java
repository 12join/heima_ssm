package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionsDao {

    @Select("select * from permission p inner join role_permission rp on p.id=rp.permissionid where rp.roleid=#{id}")
    List<Permission> findPerById(String id) throws Exception;
    //查询权限表
    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    //保存权限用户
    @Insert("insert into permission(permissionName, url) values(#{permissionName},#{url})")
    void save(Permission permission);
}
