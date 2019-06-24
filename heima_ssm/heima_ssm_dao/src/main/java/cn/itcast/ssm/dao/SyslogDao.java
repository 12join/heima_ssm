package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Syslog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SyslogDao {

    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(Syslog syslog) throws Exception;

    @Select("select * from syslog")
    List<Syslog> findAll();
}
