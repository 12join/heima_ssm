package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {
    @Select("select * from traveller t inner join order_traveller ot on t.id=ot.travellerid where ot.orderid=#{orderId}")
    List<Traveller> findById(String orderId);
}
