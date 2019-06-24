package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Syslog;

import java.util.List;

public interface SyslogService {

    void save(Syslog syslog) throws Exception;

    List<Syslog> findAll(int page, int size) throws Exception;
}
