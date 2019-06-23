package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;
import cn.itcast.ssm.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IuserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public List<UserInfo> findAll(int page,int size) throws Exception {
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page,size);
        List<UserInfo> users = userDao.findAll();
        return users;
    }

    @Override
    public void save(UserInfo userInfo) {
        //加密对象的密码
       userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
       userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        UserInfo userInfo = userDao.findById(id);

        return userInfo;
    }

    //查询不存在的角色的角色id
    @Override
    public List<Role> findOthersRole(String userid) {
        List<Role> role = userDao.findOthersRole(userid);
        return role;
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) {
        for (String roleId : roleIds) {
            userDao.addRoleToUser(userId,roleId);
        }
    }

    @Override
    public List<Role> findRole(String userid) {
        List<Role> role = userDao.findRole(userid);
        return role;
    }

}
