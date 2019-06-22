package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

//用户登入
public interface UserDao {

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType =java.util.List.class,many = @Many(select = "cn.itcast.ssm.dao.RoleDao.findRoleById"))
    })
    UserInfo findUsername(String username);

    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);


    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType =java.util.List.class,many = @Many(select = "cn.itcast.ssm.dao.RoleDao.findRoleById"))
    })
    UserInfo findById(String id);

    @Select("select * from users where id in (select userid from users_role ur where ur.roleid=#{id})")
    List<UserInfo> findRoleById(String id) throws Exception;

    @Select("select * from role where id not in(select roleid from  users_role ur where ur.userid=#{userid})")
    List<Role> findOthersRole(String userid);

    //添加中间表,产生关联
    @Insert("insert into  users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param(value = "userId") String userId,@Param(value = "roleId") String roleId);

    //查询存在的角色中的角色
    @Select("select * from role where id  in(select roleid from  users_role ur where ur.userid=#{userid})")
   List<Role> findRole(String userid);
}
