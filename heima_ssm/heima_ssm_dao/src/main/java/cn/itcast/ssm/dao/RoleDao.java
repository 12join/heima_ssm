package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

//查看角色
public interface RoleDao {

    @Select("select * from role r inner join users_role ur on r.id=ur.roleid where ur.userid=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,
                    many =@Many(select = "cn.itcast.ssm.dao.PermissionsDao.findPerById"))
    })
    List<Role> findRoleById(String id)throws Exception;

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);
    @Select("select * from role where id=#{roleId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,
                    many =@Many(select = "cn.itcast.ssm.dao.PermissionsDao.findPerById")),
            @Result(property = "users",column = "id",javaType = java.util.List.class,
            many = @Many(select = "cn.itcast.ssm.dao.UserDao.findRoleById"))
    })
    Role findById(String roleId);
}
