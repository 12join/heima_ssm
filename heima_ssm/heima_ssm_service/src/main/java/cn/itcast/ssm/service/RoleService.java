package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Role;

import java.util.List;

public interface RoleService {
    //查询角色的方法
    List<Role>  findAll(int page,int size);
    //保存角色的方法
    void save(Role role);
}
