package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Member;
import cn.itcast.ssm.domain.Orders;
import cn.itcast.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;
//查询订单
public interface OrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = " orderStatus", column = " orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "cn.itcast.ssm.dao.ProductDao.findById"))
    })
    List<Orders> findAll();


    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = " orderStatus", column = " orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "cn.itcast.ssm.dao.ProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "cn.itcast.ssm.dao.MemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.itcast.ssm.dao.TravellerDao.findById"))
    })
    Orders findById(String id);


    @Delete("delete from orders where id=#{id}")
    void remover(String id);
    //通过id查询状态
    @Select("select orderStatus from orders where id=#{id}")
    Integer open(String id);
    //修改状态,设为开启
    @Update("update  orders set  orderStatus=1 where id=#{id}")
    void openStatus(String id);
    //修改状态,设为关闭
    @Update("update  orders set  orderStatus=0 where id=#{id}")
    void close(String id);
}
