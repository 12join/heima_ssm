package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.domain.UserInfo;
import cn.itcast.ssm.service.UserService;
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
    public List<UserInfo> findAll() throws Exception {
        List<UserInfo> users = userDao.findAll();
        return users;
    }

    @Override
    public void save(UserInfo userInfo) {
        //加密对象的密码
       userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
       userDao.save(userInfo);
    }
}
