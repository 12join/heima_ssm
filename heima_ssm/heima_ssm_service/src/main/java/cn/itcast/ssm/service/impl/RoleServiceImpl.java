package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.RoleDao;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.service.RoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        List<Role> roles = roleDao.findAll();
        return roles;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findById(String roleId) throws Exception {
        Role role = roleDao.findById(roleId);
        return role;
    }
}
