package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Permission;

import java.util.List;

public interface PermissionService {
    //查询权限的方法
    List<Permission>  findAll(int page,int size) throws Exception;
    //保存权限用户
    void save(Permission permission) throws Exception;
}
