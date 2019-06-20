package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProductDao {

    @Select("select * from product where id=#{id}")
    public Product findById(String id);

   @Select("select * from product")
   List<Product> findAll();
   //保存产品的方法
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    @Delete("delete from product where id=#{id}")
    void remover(String id);
    //查询开启的状态
    @Select("select productStatus from product where id=#{id}")
    Integer open(String id);
    //修改状态,设为开启
    @Update("update product set productStatus=1 where id=#{id}")
    void openStatus(String id);
    //修改状态,设为关闭
    @Update("update product set productStatus=0 where id=#{id}")
    void closeStatus(String id);
}
