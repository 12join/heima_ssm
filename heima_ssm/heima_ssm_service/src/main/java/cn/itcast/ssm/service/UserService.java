package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.UserInfo;

import java.util.List;

public interface UserService {

    //查询用户的方法
    List<UserInfo> findAll(int page,int size) throws Exception;
    //保存用户的方法
    void save(UserInfo userInfo);
}
