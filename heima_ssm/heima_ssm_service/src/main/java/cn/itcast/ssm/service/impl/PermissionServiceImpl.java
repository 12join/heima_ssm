package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.PermissionsDao;
import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.service.PermissionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionsDao permissionsDao;
    @Override
    public List<Permission> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        List<Permission> permissions = permissionsDao.findAll();
        return permissions;
    }
}
