package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;

import java.util.List;

public interface UserService {

    //查询用户的方法
    List<UserInfo> findAll(int page,int size) throws Exception;
    //保存用户的方法
    void save(UserInfo userInfo);
    //根据id查询详情
   UserInfo findById(String id);

    //查询不在用户角色中的角色
    List<Role> findOthersRole(String userid);
    //添加用户和角色的中间表,产生关联
    void addRoleToUser(String userId, String[] roleIds) ;

    //查询存在的角色中的角色
    List<Role> findRole(String userid);
}
