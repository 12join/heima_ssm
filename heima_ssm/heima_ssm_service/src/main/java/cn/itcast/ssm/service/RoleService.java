package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;

import java.util.List;

public interface RoleService {
    //查询角色的方法
    List<Role>  findAll(int page,int size) throws Exception;
    //保存角色的方法
    void save(Role role) throws Exception ;
    //根据id查询详情
    Role findById(String roleId) throws Exception;

    //根据roleid查询权限的表
    List<Permission> findOtherRole(String roleid) throws Exception;

    //对角色和权限设置保存权限角色
    void addPermissionToRole(String roleId, String[] permisssionIds);
}
