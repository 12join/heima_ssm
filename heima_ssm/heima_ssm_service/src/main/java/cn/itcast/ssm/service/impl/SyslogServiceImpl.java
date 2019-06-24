package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.SyslogDao;
import cn.itcast.ssm.domain.Syslog;
import cn.itcast.ssm.service.SyslogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SyslogServiceImpl implements SyslogService {

    @Autowired
    private SyslogDao syslogDao;

    @Override
    public void save(Syslog syslog) throws Exception {
        syslogDao.save(syslog);
    }

    @Override
    public List<Syslog> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        List<Syslog> syslogs = syslogDao.findAll();
        return syslogs;
    }
}
