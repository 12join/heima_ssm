package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Permission;
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

    //根据角色id 查询没有设置的权限
    @Select("select * from permission where id not in(select permissionid from role_permission rp where rp.roleid=#{roleid})")
    List<Permission> findOtherRole(String roleid);

    //保存角色和权限表的中间表,建立关联
    @Insert("insert into role_permission(permissionid,roleid) values(#{permissionId},#{roleId})")
    void addPermissionToRole(@Param(value = "roleId") String roleId, @Param(value = "permissionId") String permisssionId);
}
